package com.qinshou.qinshoubox.im.manager;

import android.os.Handler;
import android.os.Looper;
import android.util.LruCache;


import com.qinshou.qinshoubox.im.cache.ICache;
import com.qinshou.qinshoubox.im.cache.MemoryCache;
import com.qinshou.qinshoubox.im.db.DatabaseHelper;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2020/1/3 18:10
 * Description:管理者的基类
 */
public abstract class AbsManager<K, V> {
    private final ICache<K, V> mCache;
    /**
     * 线程池,线程数量不定,适合执行大量耗时较少的任务
     */
    private ExecutorService mExecutorService = Executors.newCachedThreadPool();
    /**
     * 将回调切换到主线程的 Handler
     */
    private Handler mHandler = new Handler(Looper.getMainLooper());


    public AbsManager(ICache<K, V> cache) {
        mCache = cache;
    }

    public ICache<K, V> getCache() {
        return mCache;
    }

    public ExecutorService getExecutorService() {
        return mExecutorService;
    }

    public Handler getHandler() {
        return mHandler;
    }
}
