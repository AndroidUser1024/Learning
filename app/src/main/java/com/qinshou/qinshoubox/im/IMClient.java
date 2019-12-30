package com.qinshou.qinshoubox.im;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import com.google.gson.Gson;
import com.qinshou.commonmodule.util.ShowLogUtil;
import com.qinshou.okhttphelper.callback.AbsDownloadCallback;
import com.qinshou.okhttphelper.callback.Callback;
import com.qinshou.okhttphelper.interceptor.DownloadInterceptor;
import com.qinshou.qinshoubox.conversation.bean.UploadVoiceResultBean;
import com.qinshou.qinshoubox.im.bean.FriendStatusBean;
import com.qinshou.qinshoubox.im.bean.GroupChatStatusBean;
import com.qinshou.qinshoubox.im.bean.MessageBean;
import com.qinshou.qinshoubox.im.bean.ServerReceiptBean;
import com.qinshou.qinshoubox.im.db.DatabaseHelper;
import com.qinshou.qinshoubox.im.enums.FriendStatus;
import com.qinshou.qinshoubox.im.enums.GroupChatStatus;
import com.qinshou.qinshoubox.im.enums.MessageStatus;
import com.qinshou.qinshoubox.im.enums.MessageType;
import com.qinshou.qinshoubox.im.listener.IOnConnectListener;
import com.qinshou.qinshoubox.im.listener.IOnFriendStatusListener;
import com.qinshou.qinshoubox.im.listener.IOnGroupChatStatusListener;
import com.qinshou.qinshoubox.im.listener.IOnMessageListener;
import com.qinshou.qinshoubox.im.listener.IOnSendMessageListener;
import com.qinshou.qinshoubox.im.listener.QSCallback;
import com.qinshou.qinshoubox.im.manager.ConversationManager;
import com.qinshou.qinshoubox.im.manager.FriendManager;
import com.qinshou.qinshoubox.im.manager.GroupChatManager;
import com.qinshou.qinshoubox.im.manager.MessageManager;
import com.qinshou.qinshoubox.network.OkHttpHelperForQSBoxCommonApi;
import com.qinshou.qinshoubox.network.OkHttpHelperForQSBoxOfflineApi;
import com.qinshou.qinshoubox.network.QSBoxCommonApi;
import com.qinshou.qinshoubox.transformer.QSApiTransformer;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okio.ByteString;

/**
 * Author: QinHao
 * Email:cqflqinhao@126.com
 * Date: 2019/12/05 10:43
 * Description:IM 服务
 */
public enum IMClient {
    SINGLETON;
    private static final String TAG = "IMClient";
    private final int TIME_OUT = 15 * 1000;
    /**
     * 发送心跳间隔
     */
    private final long HEART_BEAT_INTERVAL = 60 * 1000;
    /**
     * 重连间隔
     */
    private final int RECONNECT_INTERVAL = 15 * 1000;
    /**
     * 重连次数
     */
    private final int MAX_RECONNECT_COUNT = 5;
    //    private static final String URL = "ws://www.mrqinshou.com:10086/websocket";
    private static final String URL = "ws://172.16.60.231:10086/websocket";
    //    private static final String URL = "ws://192.168.1.109:10086/websocket";
    private Context mContext;
    private WebSocket mWebSocket;
    private Handler mHandler = new Handler(Looper.getMainLooper());
    private List<IOnConnectListener> mOnConnectListenerList = new ArrayList<>();
    private List<IOnMessageListener> mOnMessageListenerList = new ArrayList<>();
    private List<IOnFriendStatusListener> mOnFriendStatusListenerList = new ArrayList<>();
    private List<IOnGroupChatStatusListener> mOnGroupChatStatusListenerList = new ArrayList<>();
    private List<IOnSendMessageListener> mOnSendMessageListenerList = new ArrayList<>();
    private String mUserId;
    private GroupChatManager mGroupChatManager;
    private FriendManager mFriendManager;
    private MessageManager mMessageManager;
    private ConversationManager mConversationManager;
    //    private Map<String, MessageBean> mAckMessageMap = new HashMap<>();
//    private Map<String, Timer> mRetrySendTimerMap = new HashMap<>();
    /**
     * 重连次数计数器
     */
    private int mReconnectCount;
    /**
     * 发送心跳任务
     */
    private Runnable mHeartBeatRunnable = new Runnable() {
        @Override
        public void run() {
            if (mWebSocket == null) {
                return;
            }
            Log.i(TAG, "发送心跳");
            mWebSocket.send(new Gson().toJson(MessageBean.createHeartBeatMessage(mUserId)));
            mHandler.postDelayed(mHeartBeatRunnable, HEART_BEAT_INTERVAL);
        }
    };
    /**
     * 重连任务
     */
    private Runnable mReconnectRunnable = new Runnable() {
        @Override
        public void run() {
            Log.i(TAG, "开始第 " + mReconnectCount + " 次重连");
            connect(mUserId);
        }
    };

    IMClient() {
    }

    private void connectSuccess(WebSocket webSocket, String userId) {
        mWebSocket = webSocket;
        mUserId = userId;
        mReconnectCount = 0;
        // 初始化数据库
        DatabaseHelper databaseHelper = new DatabaseHelper(mContext, userId);
        // 创建好友管理者
        mFriendManager = new FriendManager(databaseHelper, userId);
        // 创建群组管理者
        mGroupChatManager = new GroupChatManager(databaseHelper, userId);
        // 创建消息管理者
        mMessageManager = new MessageManager(databaseHelper, userId);
        // 创建会话管理者
        mConversationManager = new ConversationManager(databaseHelper, userId);
        // 拉取离线消息
        OkHttpHelperForQSBoxOfflineApi.SINGLETON.getOfflineMessageList(userId)
                .transform(new QSApiTransformer<List<MessageBean>>())
                .enqueue(new Callback<List<MessageBean>>() {
                    @Override
                    public void onSuccess(List<MessageBean> data) {
                        for (MessageBean messageBean : data) {
                            handleMessage(messageBean);
                        }
                        // 通知后台删除离线消息
                        OkHttpHelperForQSBoxOfflineApi.SINGLETON.deleteOfflineMessageList(mUserId)
                                .enqueue(null);
                    }

                    @Override
                    public void onFailure(Exception e) {

                    }
                });
        // 一定时间后发送心跳
        mHandler.removeCallbacks(mHeartBeatRunnable);
        mHandler.postDelayed(mHeartBeatRunnable, HEART_BEAT_INTERVAL);
    }

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
                messageBean.setStatus(MessageStatus.RECEIVED.getValue());

                if (messageBean.getType() == MessageType.CHAT.getValue()
                        || messageBean.getType() == MessageType.GROUP_CHAT.getValue()) {
//                    boolean exist = mMessageManager.getByFromUserIdAndToUserIdAndTypeAndSendTimestamp(messageBean.getFromUserId()
//                            , messageBean.getToUserId()
//                            , messageBean.getType()
//                            , messageBean.getSendTimestamp()) != null;
                    // 去重
//                    if (exist) {
//                        return;
//                    }
                    mMessageManager.insert(false, messageBean);
                    for (IOnMessageListener onMessageListener : mOnMessageListenerList) {
                        onMessageListener.onMessage(messageBean);
                    }
//                    // 创建一个唯一索引作为 ACK Key,将其 json 串做 Base64 加密,得到的加密字符串作为 key
//                    AckKeyBean ackKeyBean = new AckKeyBean(mUserId
//                            , messageBean.getFromUserId()
//                            , messageBean.getToUserId()
//                            , messageBean.getType()
//                            , messageBean.getSendTimestamp());
//                    String key = CodeUtil.encode(new Gson().toJson(ackKeyBean));
//                    Map<String, String> map = new HashMap<>();
//                    map.put("key", key);
//                    map.put("status", "" + MessageStatus.RECEIVED.getValue());
//                    // 发送回执消息,通知客户端本条消息已成功发送
//                    MessageBean clientReceiptMessage = MessageBean.createClientReceiptMessage(mUserId);
//                    clientReceiptMessage.setExtend(new Gson().toJson(map));
//                    mWebSocket.send(new Gson().toJson(clientReceiptMessage));

                } else if (messageBean.getType() == MessageType.FRIEND_STATUS.getValue()) {
                    handleFriendStatusMessage(messageBean);
                } else if (messageBean.getType() == MessageType.GROUP_CHAT_STATUS.getValue()) {
                    handleGroupChatStatusMessage(messageBean);
                } else if (messageBean.getType() == MessageType.SERVER_RECEIPT.getValue()) {
//                    Type type = new TypeToken<Map<String, String>>() {
//                    }.getType();
//                    Map<String, String> map = new Gson().fromJson(messageBean.getExtend(), type);
//                    String key = map.get("key");
//                    int status = Integer.valueOf(map.get("status"));
//                    MessageBean ackMessageBean = mAckMessageMap.remove(key);
//                    if (ackMessageBean != null) {
//                        mMessageManager.setStatus(status, ackMessageBean.getFromUserId(), ackMessageBean.getToUserId(), ackMessageBean.getSendTimestamp());
//                        // 取消定时任务
//                        Timer timer = mRetrySendTimerMap.remove(key);
//                        if (timer != null) {
//                            timer.cancel();
//                        }
//                    }
                    ServerReceiptBean serverReceiptBean = new Gson().fromJson(messageBean.getExtend(), ServerReceiptBean.class);
                    MessageBean select = mMessageManager.selectByPid(serverReceiptBean.getPid());
                    if (serverReceiptBean.getStatus() == MessageStatus.FAILURE.getValue()) {
                        if (select != null) {
                            select.setId(serverReceiptBean.getId());
                            select.setStatus(MessageStatus.FAILURE.getValue());
                            mMessageManager.update(select);
                        }
                        for (IOnSendMessageListener onSendMessageListener : mOnSendMessageListenerList) {
                            onSendMessageListener.onSendFailure(select, serverReceiptBean.getFailureCode());
                        }
                    } else {
                        if (select != null) {
                            select.setId(serverReceiptBean.getId());
                            select.setStatus(MessageStatus.SENDED.getValue());
                            mMessageManager.update(select);
                        }
                        for (IOnSendMessageListener onSendMessageListener : mOnSendMessageListenerList) {
                            onSendMessageListener.onSendSuccess(select);
                        }
                    }
                }
            }
        });
    }

    /**
     * Author: QinHao
     * Email:cqflqinhao@126.com
     * Date:2019/12/7 14:13
     * Description:处理好友状态的消息
     *
     * @param messageBean 消息实体类
     */
    private void handleFriendStatusMessage(MessageBean messageBean) {
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
    }

    /**
     * Author: QinHao
     * Email:cqflqinhao@126.com
     * Date:2019/12/7 14:14
     * Description:处理群相关状态的消息
     *
     * @param messageBean 消息实体类
     */
    private void handleGroupChatStatusMessage(MessageBean messageBean) {
        GroupChatStatusBean groupChatStatusBean = new Gson().fromJson(messageBean.getExtend(), GroupChatStatusBean.class);
        if (groupChatStatusBean.getStatus() == GroupChatStatus.ADD.getValue()) {
            for (IOnGroupChatStatusListener onGroupChatStatusListener : mOnGroupChatStatusListenerList) {
                onGroupChatStatusListener.add(groupChatStatusBean.getGroupChatId(), groupChatStatusBean.getFromUserId(), groupChatStatusBean.getToUserId());
            }
        } else if (groupChatStatusBean.getStatus() == GroupChatStatus.DELETE.getValue()) {
            for (IOnGroupChatStatusListener onGroupChatStatusListener : mOnGroupChatStatusListenerList) {
                onGroupChatStatusListener.delete(groupChatStatusBean.getGroupChatId(), groupChatStatusBean.getFromUserId(), groupChatStatusBean.getToUserId());
            }
        } else if (groupChatStatusBean.getStatus() == GroupChatStatus.OTHER_ADD.getValue()) {
            for (IOnGroupChatStatusListener onGroupChatStatusListener : mOnGroupChatStatusListenerList) {
                onGroupChatStatusListener.otherAdd(groupChatStatusBean.getGroupChatId(), groupChatStatusBean.getFromUserId(), groupChatStatusBean.getToUserId());
            }
        } else if (groupChatStatusBean.getStatus() == GroupChatStatus.OTHER_DELETE.getValue()) {
            for (IOnGroupChatStatusListener onGroupChatStatusListener : mOnGroupChatStatusListenerList) {
                onGroupChatStatusListener.otherDelete(groupChatStatusBean.getGroupChatId(), groupChatStatusBean.getFromUserId(), groupChatStatusBean.getToUserId());
            }
        } else if (groupChatStatusBean.getStatus() == GroupChatStatus.NICKNAME_CHANGED.getValue()) {
            for (IOnGroupChatStatusListener onGroupChatStatusListener : mOnGroupChatStatusListenerList) {
                onGroupChatStatusListener.nicknameChanged(groupChatStatusBean.getGroupChatId(), groupChatStatusBean.getFromUserId(), groupChatStatusBean.getToUserId());
            }
        }
    }

    /**
     * Author: QinHao
     * Email:cqflqinhao@126.com
     * Date:2019/12/5 10:43
     * Description:初始化 IM 服务,建议在 Application 中
     *
     * @param context 上下文
     */
    public void init(Context context) {
        mContext = context;
    }

    /**
     * Author: QinHao
     * Email:cqflqinhao@126.com
     * Date:2019/12/5 16:13
     * Description:连接 IM 服务
     *
     * @param userId 用户 id
     */
    public void connect(final String userId) {
        new OkHttpClient.Builder()
                .connectTimeout(TIME_OUT, TimeUnit.MILLISECONDS)
                .readTimeout(TIME_OUT, TimeUnit.MILLISECONDS)
                .writeTimeout(TIME_OUT, TimeUnit.MILLISECONDS)
                .build().newWebSocket(new Request.Builder().url(URL).build(), new WebSocketListener() {
            @Override
            public void onOpen(WebSocket webSocket, Response response) {
                super.onOpen(webSocket, response);
                Log.i(TAG, "onOpen:");
                for (IOnConnectListener onConnectListener : mOnConnectListenerList) {
                    onConnectListener.onConnected();
                }
                webSocket.send(new Gson().toJson(MessageBean.createHandshakeMessage(userId)));
            }

            @Override
            public void onMessage(WebSocket webSocket, String text) {
                super.onMessage(webSocket, text);
                Log.i(TAG, "onMessage: text--->" + text);
                final MessageBean messageBean = new Gson().fromJson(text, MessageBean.class);
                if (messageBean.getType() == MessageType.HANDSHAKE_SUCCESS.getValue()) {
//                    UserBean userBean = new Gson().fromJson(messageBean.getExtend(), UserBean.class);
                    connectSuccess(webSocket, userId);
                    for (IOnConnectListener onConnectListener : mOnConnectListenerList) {
                        onConnectListener.onAuthenticated();
                    }
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
            public void onFailure(WebSocket webSocket, final Throwable t, Response response) {
                super.onFailure(webSocket, t, response);
                Log.i(TAG, "onFailure: t--->" + t.getMessage());
                if (mWebSocket != null && mReconnectCount < MAX_RECONNECT_COUNT) {
                    // 异常断开,开始重连
                    mReconnectCount++;
                    mHandler.postDelayed(mReconnectRunnable, RECONNECT_INTERVAL);
                } else {
                    for (IOnConnectListener onConnectListener : mOnConnectListenerList) {
                        onConnectListener.onConnectFailure(new Exception(t));
                    }
                }
            }
        });
    }

    /**
     * Author: QinHao
     * Email:cqflqinhao@126.com
     * Date:2019/12/5 16:13
     * Description:断开 IM 连接
     */
    public void disconnect() {
//        for (Timer timer : mRetrySendTimerMap.values()) {
//            timer.cancel();
//        }
//        mAckMessageMap.clear();
//        mRetrySendTimerMap.clear();
        mUserId = null;
        mHandler.removeCallbacks(mHeartBeatRunnable);
        mHandler.removeCallbacks(mReconnectRunnable);
        if (mWebSocket == null) {
            return;
        }
        mWebSocket.close(1000, "normal close");
    }

    public void sendMessage(final MessageBean messageBean) {
        if (mWebSocket == null) {
            return;
        }
        messageBean.setFromUserId(mUserId);
        if (messageBean.getType() == MessageType.CHAT.getValue()
                || messageBean.getType() == MessageType.GROUP_CHAT.getValue()) {
            mMessageManager.insert(true, messageBean);
//            // 创建一个唯一索引作为 ACK Key,将其 json 串做 Base64 加密,得到的加密字符串作为 key
//            AckKeyBean ackKeyBean = new AckKeyBean(mUserId
//                    , messageBean.getFromUserId()
//                    , messageBean.getToUserId()
//                    , messageBean.getType()
//                    , messageBean.getSendTimestamp());
//            String key = CodeUtil.encode(new Gson().toJson(ackKeyBean));
//            mAckMessageMap.put(key, messageBean);
//            // 设置一个定时任务,一定时间后如果还没有收到服务端回执,则重新发送
//            Timer timer = new Timer();
//            timer.schedule(new RetrySendTimerTask(key), TIME_OUT);
//            mRetrySendTimerMap.put(key, timer);
        }
        mWebSocket.send(new Gson().toJson(messageBean));
        mHandler.post(new Runnable() {
            @Override
            public void run() {
                for (IOnSendMessageListener onSendMessageListener : mOnSendMessageListenerList) {
                    onSendMessageListener.onSending(messageBean);
                }
            }
        });
    }

//    private class RetrySendTimerTask extends TimerTask {
//        private String mKey;
//
//        public RetrySendTimerTask(String key) {
//            mKey = key;
//        }
//
//        @Override
//        public void run() {
//            MessageBean ackMessageBean = mAckMessageMap.get(mKey);
//            if (ackMessageBean != null) {
//                mWebSocket.send(new Gson().toJson(ackMessageBean));
//                mRetrySendTimerMap.get(mKey).schedule(new RetrySendTimerTask(mKey), TIME_OUT);
//            }
//        }
//    }

    public void uploadVoice(long time, File voice, final QSCallback<UploadVoiceResultBean> qsCallback) {
        OkHttpHelperForQSBoxCommonApi.SINGLETON.uploadVoice(mUserId, time, voice)
                .transform(new QSApiTransformer<UploadVoiceResultBean>())
                .enqueue(new Callback<UploadVoiceResultBean>() {
                    @Override
                    public void onSuccess(UploadVoiceResultBean data) {
                        qsCallback.onSuccess(data);
                    }

                    @Override
                    public void onFailure(Exception e) {
                        qsCallback.onFailure(e);
                    }
                });
    }

    public void download(String url, final File file, AbsDownloadCallback downloadCallback) {
        new OkHttpClient.Builder().addInterceptor(new DownloadInterceptor(downloadCallback)).build()
                .newCall(new Request.Builder().addHeader("Accept-Encoding", "dentity").url(url).get().build())
                .enqueue(new okhttp3.Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                        Log.i("daolema", "onFailure--->" + e.getMessage());
                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        ResponseBody responseBody = response.body();
                        if (responseBody == null) {
                            return;
                        }
                        InputStream inputStream = responseBody.byteStream();
                        Log.i("daolema", "onResponse: inputStream--->" + inputStream.available());
                        if (file.getParentFile().exists()) {
                            file.getParentFile().mkdirs();
                        }
                        file.createNewFile();
                        FileOutputStream fileOutputStream = null;
                        try {
                            fileOutputStream = new FileOutputStream(file);
                            byte[] bytes = new byte[1024];
                            int len;
                            while ((len = inputStream.read(bytes)) != -1) {
                                fileOutputStream.write(bytes, 0, len);
                            }
                            inputStream.close();
                            fileOutputStream.close();
                        } finally {
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            if (fileOutputStream != null) {
                                fileOutputStream.close();
                            }
                        }
                    }
                });
    }

    public GroupChatManager getGroupChatManager() {
        return mGroupChatManager;
    }

    public FriendManager getFriendManager() {
        return mFriendManager;
    }

    public MessageManager getMessageManager() {
        return mMessageManager;
    }

    public ConversationManager getConversationManager() {
        return mConversationManager;
    }

    public void addOnConnectListener(IOnConnectListener onConnectListener) {
        mOnConnectListenerList.add(onConnectListener);
    }

    public void removeOnConnectListener(IOnConnectListener onConnectListener) {
        mOnMessageListenerList.remove(onConnectListener);
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

    public void addOnGroupChatStatusListener(IOnGroupChatStatusListener onGroupChatStatusListener) {
        mOnGroupChatStatusListenerList.add(onGroupChatStatusListener);
    }

    public void removeOnGroupChatStatusListener(IOnGroupChatStatusListener onGroupChatStatusListener) {
        mOnGroupChatStatusListenerList.remove(onGroupChatStatusListener);
    }

    public void addOnSendMessageListener(IOnSendMessageListener onSendMessageListener) {
        mOnSendMessageListenerList.add(onSendMessageListener);
    }

    public void removeOnSendMessageListener(IOnSendMessageListener onSendMessageListener) {
        mOnSendMessageListenerList.remove(onSendMessageListener);
    }

}
