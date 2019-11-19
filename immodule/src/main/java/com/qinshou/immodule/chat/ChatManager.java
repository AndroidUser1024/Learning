package com.qinshou.immodule.chat;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import com.google.gson.Gson;
import com.qinshou.immodule.bean.MessageBean;

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
    private final OkHttpClient mOkHttpClient;
    private final Request mRequest;

    ChatManager() {
        mOkHttpClient = new OkHttpClient.Builder()
                .connectTimeout(15 * 1000, TimeUnit.MILLISECONDS)
                .readTimeout(15 * 1000, TimeUnit.MILLISECONDS)
                .writeTimeout(15 * 1000, TimeUnit.MILLISECONDS)
                .build();
        mRequest = new Request.Builder().url("http://172.16.60.231").build();
    }

    private static final String USERNAME = "Username";

    public void connect(String username) {
        mWebSocket = mOkHttpClient.newWebSocket(mRequest, new WebSocketListener() {
            @Override
            public void onOpen(WebSocket webSocket, Response response) {
                super.onOpen(webSocket, response);
                Log.i(TAG, "onOpen: ");
                mWebSocket = webSocket;
            }

            @Override
            public void onMessage(WebSocket webSocket, String text) {
                super.onMessage(webSocket, text);
                Log.i(TAG, "onMessage: ");
            }

            @Override
            public void onMessage(WebSocket webSocket, ByteString bytes) {
                super.onMessage(webSocket, bytes);
                Log.i(TAG, "onMessage: ");
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
                Log.i(TAG, "onFailure: ");
            }
        });
    }

    public void disconnect() {
        if (mWebSocket == null) {
            return;
        }
        mWebSocket.close(1000, "normal close");
    }

    private void sendMessage(MessageBean messageBean) {
        if (mWebSocket == null) {
            return;
        }
        mWebSocket.send(new Gson().toJson(messageBean));
    }
}
