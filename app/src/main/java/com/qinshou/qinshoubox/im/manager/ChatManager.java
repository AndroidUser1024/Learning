package com.qinshou.qinshoubox.im.manager;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.qinshou.okhttphelper.callback.Callback;
import com.qinshou.qinshoubox.im.bean.AckKeyBean;
import com.qinshou.qinshoubox.im.bean.FriendStatusBean;
import com.qinshou.qinshoubox.im.bean.MessageBean;
import com.qinshou.qinshoubox.im.db.DBHelper;
import com.qinshou.qinshoubox.im.enums.FriendStatus;
import com.qinshou.qinshoubox.im.enums.MessageStatus;
import com.qinshou.qinshoubox.im.enums.MessageType;
import com.qinshou.qinshoubox.im.listener.IOnFriendStatusListener;
import com.qinshou.qinshoubox.im.listener.IOnMessageListener;
import com.qinshou.qinshoubox.im.listener.QSCallback;
import com.qinshou.qinshoubox.im.util.EncryptUtil.CodeUtil;
import com.qinshou.qinshoubox.network.OkHttpHelperForQSBoxOfflineApi;
import com.qinshou.qinshoubox.transformer.QSApiTransformer;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okio.ByteString;

public enum ChatManager {
    SINGLETON;
    private static final String TAG = "ChatManager";
    private final int TIME_OUT = 30 * 1000;
    private static final String URL = "http://172.16.60.231:10086/websocket";
    //    private static final String URL = "http://192.168.1.109:10086/websocket";
    private WebSocket mWebSocket;
    private Handler mHandler = new Handler(Looper.getMainLooper());
    private List<IOnMessageListener> mOnMessageListenerList = new ArrayList<>();
    private List<IOnFriendStatusListener> mOnFriendStatusListenerList = new ArrayList<>();
    private int mUserId;
    private ConversationManager mConversationManager;
    private MessageManager mMessageManager;
    private UserManager mUserManager;
    private GroupChatManager mGroupChatManager;
    private FriendManager mFriendManager;
    private Map<String, MessageBean> mAckMessageMap = new HashMap<>();
    private Map<String, Timer> mRetrySendTimerMap = new HashMap<>();

    ChatManager() {
    }

    public void connect(final Context context, final int userId, final QSCallback<Void> qsCallback) {
        mWebSocket = new OkHttpClient.Builder()
                .connectTimeout(TIME_OUT, TimeUnit.MILLISECONDS)
                .readTimeout(TIME_OUT, TimeUnit.MILLISECONDS)
                .writeTimeout(TIME_OUT, TimeUnit.MILLISECONDS)
                .build().newWebSocket(new Request.Builder().url(URL).build(), new WebSocketListener() {
                    @Override
                    public void onOpen(WebSocket webSocket, Response response) {
                        super.onOpen(webSocket, response);
                        Log.i(TAG, "onOpen: ");
                        mWebSocket = webSocket;
                        sendMessage(MessageBean.createHandshakeMessage(userId));
                    }

                    @Override
                    public void onMessage(WebSocket webSocket, String text) {
                        super.onMessage(webSocket, text);
                        Log.i(TAG, "onMessage: text--->" + text);
                        final MessageBean messageBean = new Gson().fromJson(text, MessageBean.class);
                        if (messageBean.getType() == MessageType.HANDSHAKE_SUCCESS.getValue()) {
//                    UserBean userBean = new Gson().fromJson(messageBean.getExtend(), UserBean.class);
                            connectSuccess(context, userId, qsCallback);
                            return;
                        }
                        handleMessage(messageBean);

                    }

                    @Override
                    public void onMessage(WebSocket webSocket, ByteString bytes) {
                        super.onMessage(webSocket, bytes);
                        Log.i(TAG, "onMessage: bytes--->" + bytes);
                    }

                    @Override
                    public void onClosing(WebSocket webSocket, int code, String reason) {
                        super.onClosing(webSocket, code, reason);
                        Log.i(TAG, "onClosing: ");
                    }

                    @Override
                    public void onClosed(WebSocket webSocket, int code, String reason) {
                        super.onClosed(webSocket, code, reason);
                        Log.i(TAG, "onClosed: ");
                    }

                    @Override
                    public void onFailure(WebSocket webSocket, Throwable t, Response response) {
                        super.onFailure(webSocket, t, response);
                        Log.i(TAG, "onFailure: t--->" + t.getMessage());
                    }
                });
    }

    private void connectSuccess(Context context, final int userId, final QSCallback<Void> qsCallback) {
        mUserId = userId;
        // 初始化数据库
        DBHelper.init(context, "" + userId);
        // 创建会话管理者
        mConversationManager = new ConversationManager();
        // 创建消息管理者
        mMessageManager = new MessageManager();
        // 创建用户管理者
        mUserManager = new UserManager();
        // 创建群组管理者
        mGroupChatManager = new GroupChatManager();
        // 创建好友管理者
        mFriendManager = new FriendManager();
        mHandler.post(new Runnable() {
            @Override
            public void run() {
                qsCallback.onSuccess(null);
            }
        });
        OkHttpHelperForQSBoxOfflineApi.SINGLETON.getOfflineMessageList(userId)
                .transform(new QSApiTransformer<List<MessageBean>>())
                .enqueue(new Callback<List<MessageBean>>() {
                    @Override
                    public void onSuccess(List<MessageBean> data) {
                        for (MessageBean messageBean : data) {
                            handleMessage(messageBean);
                        }
                        // 通知后台删除离线消息
                        OkHttpHelperForQSBoxOfflineApi.SINGLETON.deleteOfflineMessageList(userId)
                                .enqueue(null);
                    }

                    @Override
                    public void onFailure(Exception e) {

                    }
                });
    }


    public void disconnect() {
        if (mWebSocket == null) {
            return;
        }
        mWebSocket.close(1000, "normal close");
        for (Timer timer : mRetrySendTimerMap.values()) {
            timer.cancel();
        }
        mAckMessageMap.clear();
        mRetrySendTimerMap.clear();
        mUserId = 0;
        mConversationManager = null;
        mMessageManager = null;
        mUserManager = null;
        mGroupChatManager = null;
        mFriendManager = null;
    }

    public void sendMessage(MessageBean messageBean) {
        if (mWebSocket == null) {
            return;
        }
        if (messageBean.getType() == MessageType.CHAT.getValue()
                || messageBean.getType() == MessageType.GROUP_CHAT.getValue()) {
            mMessageManager.insertOrUpdate(true, messageBean);

            // 创建一个唯一索引作为 ACK Key,将其 json 串做 Base64 加密,得到的加密字符串作为 key
            AckKeyBean ackKeyBean = new AckKeyBean(mUserId
                    , messageBean.getFromUserId()
                    , messageBean.getToUserId()
                    , messageBean.getType()
                    , messageBean.getSendTimestamp());
            String key = CodeUtil.encode(new Gson().toJson(ackKeyBean));
            mAckMessageMap.put(key, messageBean);
            // 设置一个定时任务,一定时间后如果还没有收到服务端回执,则重新发送
            Timer timer = new Timer();
            timer.schedule(new RetrySendTimerTask(key), TIME_OUT);
            mRetrySendTimerMap.put(key, timer);
        }
        mWebSocket.send(new Gson().toJson(messageBean));
    }

    private int i = 0;

    /**
     * Author: QinHao
     * Email:qinhao@jeejio.com
     * Date:2019/11/26 9:00
     * Description:处理消息
     *
     * @param messageBean 消息实体类
     */
    private void handleMessage(final MessageBean messageBean) {
        mHandler.post(new Runnable() {
            @Override
            public void run() {
                messageBean.setReceiveTimestamp(System.currentTimeMillis());
                if (messageBean.getType() == MessageType.CHAT.getValue()
                        || messageBean.getType() == MessageType.GROUP_CHAT.getValue()) {
                    boolean exist = mMessageManager.getByFromUserIdAndToUserIdAndTypeAndSendTimestamp(messageBean.getFromUserId()
                            , messageBean.getToUserId()
                            , messageBean.getType()
                            , messageBean.getSendTimestamp()) != null;
                    // 去重
                    if (exist) {
                        return;
                    }
                    messageBean.setStatus(MessageStatus.RECEIVED.getValue());
                    mMessageManager.insertOrUpdate(false, messageBean);
                    for (IOnMessageListener onMessageListener : mOnMessageListenerList) {
                        onMessageListener.onMessage(messageBean);
                    }
                    // 创建一个唯一索引作为 ACK Key,将其 json 串做 Base64 加密,得到的加密字符串作为 key
                    AckKeyBean ackKeyBean = new AckKeyBean(mUserId
                            , messageBean.getFromUserId()
                            , messageBean.getToUserId()
                            , messageBean.getType()
                            , messageBean.getSendTimestamp());
                    String key = CodeUtil.encode(new Gson().toJson(ackKeyBean));
                    Map<String, String> map = new HashMap<>();
                    map.put("key", key);
                    map.put("status", "" + MessageStatus.RECEIVED.getValue());
                    // 发送回执消息,通知客户端本条消息已成功发送
                    MessageBean clientReceiptMessage = MessageBean.createClientReceiptMessage(mUserId);
                    clientReceiptMessage.setExtend(new Gson().toJson(map));

                    mWebSocket.send(new Gson().toJson(clientReceiptMessage));
                } else if (messageBean.getType() == MessageType.FRIEND.getValue()) {
                    FriendStatusBean friendStatusBean = new Gson().fromJson(messageBean.getExtend(), FriendStatusBean.class);
                    if (friendStatusBean.getStatus() == FriendStatus.ADD.getValue()) {
                        for (IOnFriendStatusListener onFriendStatusListener : mOnFriendStatusListenerList) {
                            onFriendStatusListener.add(friendStatusBean.getFromUserId(), friendStatusBean.getAdditionalMsg(), friendStatusBean.isNewFriend());
                        }
                    } else if (friendStatusBean.getStatus() == FriendStatus.AGREE_ADD.getValue()) {
                        for (IOnFriendStatusListener onFriendStatusListener : mOnFriendStatusListenerList) {
                            onFriendStatusListener.agreeAdd(friendStatusBean.getFromUserId());
                        }
                    } else if (friendStatusBean.getStatus() == FriendStatus.REFUSE_ADD.getValue()) {
                        for (IOnFriendStatusListener onFriendStatusListener : mOnFriendStatusListenerList) {
                            onFriendStatusListener.refuseAdd(friendStatusBean.getFromUserId());
                        }
                    } else if (friendStatusBean.getStatus() == FriendStatus.DELETE.getValue()) {
                        for (IOnFriendStatusListener onFriendStatusListener : mOnFriendStatusListenerList) {
                            onFriendStatusListener.delete(friendStatusBean.getFromUserId());
                        }
                    } else if (friendStatusBean.getStatus() == FriendStatus.ONLINE.getValue()) {
                        for (IOnFriendStatusListener onFriendStatusListener : mOnFriendStatusListenerList) {
                            onFriendStatusListener.online(friendStatusBean.getFromUserId());
                        }
                    } else if (friendStatusBean.getStatus() == FriendStatus.OFFLINE.getValue()) {
                        for (IOnFriendStatusListener onFriendStatusListener : mOnFriendStatusListenerList) {
                            onFriendStatusListener.offline(friendStatusBean.getFromUserId());
                        }
                    }
                } else if (messageBean.getType() == MessageType.SERVER_RECEIPT.getValue()) {
                    Type type = new TypeToken<Map<String, String>>() {
                    }.getType();
                    Map<String, String> map = new Gson().fromJson(messageBean.getExtend(), type);
                    String key = map.get("key");
                    int status = Integer.valueOf(map.get("status"));
                    MessageBean ackMessageBean = mAckMessageMap.remove(key);
                    if (ackMessageBean != null) {
                        mMessageManager.setStatus(status, ackMessageBean.getFromUserId(), ackMessageBean.getToUserId(), ackMessageBean.getSendTimestamp());
                        // 取消定时任务
                        Timer timer = mRetrySendTimerMap.remove(key);
                        if (timer != null) {
                            timer.cancel();
                        }
                    }
                }
            }
        });
    }

    private class RetrySendTimerTask extends TimerTask {
        private String mKey;

        public RetrySendTimerTask(String key) {
            mKey = key;
        }

        @Override
        public void run() {
            MessageBean ackMessageBean = mAckMessageMap.get(mKey);
            if (ackMessageBean != null) {
                mWebSocket.send(new Gson().toJson(ackMessageBean));
                mRetrySendTimerMap.get(mKey).schedule(new RetrySendTimerTask(mKey), TIME_OUT);
            }
        }
    }

    public int getUserId() {
        return mUserId;
    }

    public ConversationManager getConversationManager() {
        return mConversationManager;
    }

    public MessageManager getMessageManager() {
        return mMessageManager;
    }

    public UserManager getUserManager() {
        return mUserManager;
    }

    public GroupChatManager getGroupChatManager() {
        return mGroupChatManager;
    }

    public FriendManager getFriendManager() {
        return mFriendManager;
    }

    public void addOnMessageListener(IOnMessageListener onMessageListener) {
        mOnMessageListenerList.add(onMessageListener);
    }

    public void removeOnMessageListener(IOnMessageListener onMessageListener) {
        mOnMessageListenerList.remove(onMessageListener);
    }

    public void addOnFriendStatusListener(IOnFriendStatusListener onFriendStatusListener) {
        mOnFriendStatusListenerList.add(onFriendStatusListener);
    }

    public void removeOnFriendStatusListener(IOnFriendStatusListener onFriendStatusListener) {
        mOnFriendStatusListenerList.remove(onFriendStatusListener);
    }
}
