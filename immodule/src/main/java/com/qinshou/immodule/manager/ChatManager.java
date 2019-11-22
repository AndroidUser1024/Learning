package com.qinshou.immodule.manager;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.qinshou.immodule.bean.FriendStatusBean;
import com.qinshou.immodule.bean.MessageBean;
import com.qinshou.immodule.db.dao.IConversationDao;
import com.qinshou.immodule.db.dao.IConversationMessageRelDao;
import com.qinshou.immodule.db.dao.IMessageDao;
import com.qinshou.immodule.db.dao.impl.ConversationDaoImpl;
import com.qinshou.immodule.db.dao.impl.ConversationMessageRelDaoImpl;
import com.qinshou.immodule.db.dao.impl.MessageDaoImpl;
import com.qinshou.immodule.enums.FriendStatus;
import com.qinshou.immodule.enums.MessageType;
import com.qinshou.immodule.listener.IOnFriendStatusListener;
import com.qinshou.immodule.listener.IOnMessageListener;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
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
    private WebSocket mWebSocket;
    private final OkHttpClient mOkHttpClient = new OkHttpClient.Builder()
            .connectTimeout(15 * 1000, TimeUnit.MILLISECONDS)
            .readTimeout(15 * 1000, TimeUnit.MILLISECONDS)
            .writeTimeout(15 * 1000, TimeUnit.MILLISECONDS)
            .build();
    private final Request mRequest = new Request.Builder().url("http://172.16.60.231:10086/websocket").build();
    private Handler mHandler = new Handler(Looper.getMainLooper());
    private List<IOnMessageListener> mOnMessageListenerList = new ArrayList<>();
    private List<IOnFriendStatusListener> mOnFriendStatusListenerList = new ArrayList<>();
    private int mUserId;
    private IConversationDao mConversationDao;
    private IConversationMessageRelDao mConversationMessageRelDao;
    private IMessageDao mMessageDao;

    ChatManager() {
        mConversationDao = new ConversationDaoImpl();
        mConversationMessageRelDao = new ConversationMessageRelDaoImpl();
        mMessageDao = new MessageDaoImpl();
    }

    public int getUserId() {
        return mUserId;
    }

    public void connect(final Context context, int userId, final String username) {
        mUserId = userId;
        mWebSocket = mOkHttpClient.newWebSocket(mRequest, new WebSocketListener() {
            @Override
            public void onOpen(WebSocket webSocket, Response response) {
                super.onOpen(webSocket, response);
                Log.i(TAG, "onOpen: ");
                mWebSocket = webSocket;
                sendMessage(MessageBean.createHandshakeMessage());
            }

            @Override
            public void onMessage(WebSocket webSocket, String text) {
                super.onMessage(webSocket, text);
                Log.i(TAG, "onMessage: text--->" + text);
                final MessageBean messageBean = new Gson().fromJson(text, MessageBean.class);
                messageBean.setReceiveTimestamp(System.currentTimeMillis());

                MessageManager.SINGLETON.insertOrUpdate(false, messageBean);

                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        if (messageBean.getType() == MessageType.CHAT.getValue()
                                || messageBean.getType() == MessageType.GROUP_CHAT.getValue()) {
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

    public void disconnect() {
        if (mWebSocket == null) {
            return;
        }
        mWebSocket.close(1000, "normal close");
        mUserId = 0;
    }

    public void sendMessage(MessageBean messageBean) {
        if (mWebSocket == null) {
            return;
        }
        mWebSocket.send(new Gson().toJson(messageBean));
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
