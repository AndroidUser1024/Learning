package com.qinshou.immodule.chat;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import com.google.gson.Gson;
import com.qinshou.immodule.bean.MessageBean;
import com.qinshou.immodule.bean.MessageType;
import com.qinshou.immodule.listener.IOnMessageListener;

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
    private WebSocket mWebSocket;
    private final OkHttpClient mOkHttpClient = new OkHttpClient.Builder()
            .connectTimeout(15 * 1000, TimeUnit.MILLISECONDS)
            .readTimeout(15 * 1000, TimeUnit.MILLISECONDS)
            .writeTimeout(15 * 1000, TimeUnit.MILLISECONDS)
            .build();
    private final Request mRequest = new Request.Builder().url("http://172.16.60.231:10086/websocket").build();
    private Handler mHandler = new Handler(Looper.getMainLooper());
    private List<IOnMessageListener> mOnMessageListenerList = new ArrayList<>();
    private int mUserId;

    ChatManager() {
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
                if (messageBean.getType() == MessageType.CHAT.getValue()) {
                    mHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            for (IOnMessageListener onMessageListener : mOnMessageListenerList) {
                                onMessageListener.onMessage(messageBean);
                            }
                        }
                    });
                }

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
}
