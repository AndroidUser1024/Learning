package com.qinshou.qinshoubox.im.manager;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import com.google.gson.Gson;
import com.qinshou.okhttphelper.callback.Callback;
import com.qinshou.qinshoubox.im.bean.FriendStatusBean;
import com.qinshou.qinshoubox.im.bean.MessageBean;
import com.qinshou.qinshoubox.im.bean.UserBean;
import com.qinshou.qinshoubox.im.db.DBHelper;
import com.qinshou.qinshoubox.im.enums.FriendStatus;
import com.qinshou.qinshoubox.im.enums.MessageType;
import com.qinshou.qinshoubox.im.listener.IOnFriendStatusListener;
import com.qinshou.qinshoubox.im.listener.IOnMessageListener;
import com.qinshou.qinshoubox.im.listener.QSCallback;
import com.qinshou.qinshoubox.network.OkHttpHelperForQSBoxOfflineApi;
import com.qinshou.qinshoubox.transformer.QSApiTransformer;

import java.util.ArrayList;
import java.util.List;
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
//    private static final String URL = "http://172.16.60.231:10086/websocket";
        private static final String URL = "http://192.168.1.109:10086/websocket";
    private WebSocket mWebSocket;
    private final OkHttpClient mOkHttpClient = new OkHttpClient.Builder()
            .connectTimeout(15 * 1000, TimeUnit.MILLISECONDS)
            .readTimeout(15 * 1000, TimeUnit.MILLISECONDS)
            .writeTimeout(15 * 1000, TimeUnit.MILLISECONDS)
            .build();
    private final Request mRequest = new Request.Builder().url(URL).build();
    private Handler mHandler = new Handler(Looper.getMainLooper());
    private List<IOnMessageListener> mOnMessageListenerList = new ArrayList<>();
    private List<IOnFriendStatusListener> mOnFriendStatusListenerList = new ArrayList<>();
    private int mUserId;
    private ConversationManager mConversationManager;
    private MessageManager mMessageManager;

    ChatManager() {
    }

    public void connect(final Context context, final int userId, final QSCallback<Void> qsCallback) {
        mWebSocket = mOkHttpClient.newWebSocket(mRequest, new WebSocketListener() {
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
                messageBean.setReceiveTimestamp(System.currentTimeMillis());
                if (messageBean.getType() == MessageType.HANDSHAKE_SUCCESS.getValue()) {
//                    UserBean userBean = new Gson().fromJson(messageBean.getExtend(), UserBean.class);
                    connectSuccess(context, userId, qsCallback);
                    return;
                }
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        if (messageBean.getType() == MessageType.CHAT.getValue()
                                || messageBean.getType() == MessageType.GROUP_CHAT.getValue()) {
                            mMessageManager.insertOrUpdate(false, messageBean);
                            for (IOnMessageListener onMessageListener : mOnMessageListenerList) {
                                onMessageListener.onMessage(messageBean);
                            }
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
                        }
                    }
                });

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
                            // 插入到数据库
                            mMessageManager.insertOrUpdate(false, messageBean);
                            for (IOnMessageListener onMessageListener : mOnMessageListenerList) {
                                onMessageListener.onMessage(messageBean);
                            }
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
        mUserId = 0;
        mConversationManager = null;
        mMessageManager = null;
    }

    public void sendMessage(MessageBean messageBean) {
        if (mWebSocket == null) {
            return;
        }
        if (messageBean.getType() == MessageType.CHAT.getValue()
                || messageBean.getType() == MessageType.GROUP_CHAT.getValue()) {
            mMessageManager.insertOrUpdate(true, messageBean);
        }
        mWebSocket.send(new Gson().toJson(messageBean));
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
