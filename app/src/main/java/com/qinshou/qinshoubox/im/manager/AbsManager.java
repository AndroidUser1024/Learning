package com.qinshou.qinshoubox.im.manager;

import android.os.Handler;
import android.os.Looper;
import android.util.LruCache;


import com.qinshou.qinshoubox.im.db.DatabaseHelper;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2020/1/3 18:10
 * Description:管理者的基类
 */
public class AbsManager<T> {
    private DatabaseHelper mDatabaseHelper;
    private String mUserId;
    private final LruCache<String, T> mLruCache;
    /**
     * 线程池,线程数量不定,适合执行大量耗时较少的任务
     */
    private ExecutorService mExecutorService = Executors.newCachedThreadPool();
    /**
     * 将回调切换到主线程的 Handler
     */
    private Handler mHandler = new Handler(Looper.getMainLooper());


    public AbsManager(DatabaseHelper databaseHelper, String userId) {
        mDatabaseHelper = databaseHelper;
        mUserId = userId;
        int maxMemory = (int) (Runtime.getRuntime().maxMemory() / 1024);
        int cacheSize = maxMemory / 16;
        mLruCache = new LruCache<>(cacheSize);
    }

    public DatabaseHelper getDatabaseHelper() {
        return mDatabaseHelper;
    }

    public LruCache<String, T> getLruCache() {
        return mLruCache;
    }

    public ExecutorService getExecutorService() {
        return mExecutorService;
    }

    public Handler getHandler() {
        return mHandler;
    }
}
