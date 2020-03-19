package com.qinshou.qinshoubox.im.cache;

import android.util.LruCache;

import java.util.Collection;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2020/1/4 16:40
 * Description:内存缓存
 */
public class MemoryCache<K, V> implements ICache<K, V> {
    private final LruCache<K, V> mLruCache;

    public MemoryCache() {
        int maxMemory = (int) (Runtime.getRuntime().maxMemory() / 1024);
        int cacheSize = maxMemory / 16;
        mLruCache = new LruCache<>(cacheSize);
    }

    @Override
    public void put(K key, V value) {
        mLruCache.put(key, value);
    }

    @Override
    public V get(K key) {
        return mLruCache.get(key);
    }

    @Override
    public V remove(K key) {
        return mLruCache.remove(key);
    }

    @Override
    public Collection<V> getValues() {
        return mLruCache.snapshot().values();
    }
}
