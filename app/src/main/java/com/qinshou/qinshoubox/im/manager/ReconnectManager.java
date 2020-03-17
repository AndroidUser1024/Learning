package com.qinshou.qinshoubox.im.manager;

import android.util.Log;

import androidx.annotation.NonNull;

import com.qinshou.qinshoubox.im.IMClient;
import com.qinshou.qinshoubox.im.listener.IOnConnectListener;

import java.io.EOFException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2020/3/17 18:05
 * Description:重连管理者
 */
public class ReconnectManager {
    private final String TAG = ReconnectManager.class.getSimpleName();
    /**
     * 最大重连次数
     */
    private final int MAX_RECONNECT_COUNT = 10000;
    /**
     * 重连尝试间隔
     */
    private final int INTERVAL = 10 * 1000;
    /**
     * 重连任务的线程池
     */
    private ScheduledExecutorService mReconnectScheduledExecutorService = Executors.newSingleThreadScheduledExecutor(
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
     * 重连任务的线程
     */
    private ScheduledFuture<?> mReconnectScheduledFuture;
    /**
     * 重连次数计数器
     */
    private int mReconnectCount;
    /**
     * 重连任务
     */
    private Runnable mReconnectRunnable = new Runnable() {
        @Override
        public void run() {
            if (mReconnectCount >= MAX_RECONNECT_COUNT) {
                Log.i(TAG, "重连了 " + MAX_RECONNECT_COUNT + " 次都没有连上,不再重连了");
                return;
            }
            mReconnectCount++;
            Log.i(TAG, "即将开始第 " + mReconnectCount + " 次重连");
            IMClient.SINGLETON.connect(IMClient.SINGLETON.getUserDetailBean().getId());
        }
    };
    /**
     * 是否开启重连的标识位
     */
    private boolean enable = true;

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public boolean start(Throwable throwable) {
        if (!enable) {
            return false;
        }
        // 自动重连
        mReconnectScheduledFuture = mReconnectScheduledExecutorService.schedule(mReconnectRunnable, INTERVAL, TimeUnit.MILLISECONDS);
        return true;
    }

    public void release() {
        // 移除重连任务
        if (mReconnectScheduledFuture != null) {
            mReconnectScheduledFuture.cancel(true);
            mReconnectScheduledFuture = null;
        }
    }
}
