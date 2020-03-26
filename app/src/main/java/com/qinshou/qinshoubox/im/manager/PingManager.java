package com.qinshou.qinshoubox.im.manager;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.gson.Gson;
import com.qinshou.qinshoubox.im.bean.MessageBean;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

import okhttp3.WebSocket;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2020/3/17 18:53
 * Description:心跳管理者
 */
public class PingManager {
    private final String TAG = PingManager.class.getSimpleName();
    /**
     * 发送心跳间隔
     */
    private final long HEART_BEAT_INTERVAL = 60 * 1000;
    private WebSocket mWebSocket;
    /**
     * 发送心跳任务的线程池
     */
    private ScheduledExecutorService mHeartBeatScheduledExecutorService = Executors.newSingleThreadScheduledExecutor(
            new ThreadFactory() {
                @Override
                public Thread newThread(@NonNull Runnable r) {
                    Thread thread = new Thread(r);
                    thread.setName("Reconnect Thread");
                    thread.setDaemon(true);
                    return thread;
                }
            }
    );
    /**
     * 心跳任务的线程
     */
    private ScheduledFuture<?> mHeartBeatScheduledFuture;
    /**
     * 心跳任务
     */
    private Runnable mHeartBeatRunnable = new Runnable() {

        @Override
        public void run() {
            if (mWebSocket == null) {
                return;
            }
            Log.i(TAG, "发送心跳");
            mWebSocket.send(new Gson().toJson(MessageBean.createHeartBeatMessage()));
            mHeartBeatScheduledFuture = mHeartBeatScheduledExecutorService.schedule(mHeartBeatRunnable, HEART_BEAT_INTERVAL, TimeUnit.MILLISECONDS);
        }
    };

    public void start(WebSocket webSocket) {
        mWebSocket = webSocket;
        // 开启心跳任务
        release();
        mHeartBeatScheduledFuture = mHeartBeatScheduledExecutorService.schedule(mHeartBeatRunnable, HEART_BEAT_INTERVAL, TimeUnit.MILLISECONDS);
    }

    public void release() {
        if (mHeartBeatScheduledFuture != null) {
            mHeartBeatScheduledFuture.cancel(true);
            mHeartBeatScheduledFuture = null;
        }
    }
}
