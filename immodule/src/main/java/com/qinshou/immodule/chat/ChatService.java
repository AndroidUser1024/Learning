package com.qinshou.immodule.chat;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
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

public class ChatService extends Service {
    private static final String TAG = "ChatService";
    private WebSocket mWebSocket;

    public ChatService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(15 * 1000, TimeUnit.MILLISECONDS)
                .readTimeout(15 * 1000, TimeUnit.MILLISECONDS)
                .writeTimeout(15 * 1000, TimeUnit.MILLISECONDS)
                .build();
        Request request = new Request.Builder().url("http://172.16.60.231").build();
        okHttpClient.newWebSocket(request, new WebSocketListener() {
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

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    private void sendMessage(MessageBean messageBean) {
        if (mWebSocket == null) {
            return;
        }
        mWebSocket.send(new Gson().toJson(messageBean));
    }
}
