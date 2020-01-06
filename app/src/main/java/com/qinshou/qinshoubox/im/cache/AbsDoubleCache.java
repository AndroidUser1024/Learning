package com.qinshou.qinshoubox.im.cache;

/**
 * Author: QinHao
 * Email:cqflqinhao@126.com
 * Date: 2020/1/4 19:01
 * Description:双重缓存
 */
public abstract class AbsDoubleCache<K, V> implements ICache<K, V> {
    private MemoryCache<K, V> mMemoryCache;
    private AbsDatabaseCache<K, V> mDatabaseCache;

    public AbsDoubleCache(MemoryCache<K, V> memoryCache, AbsDatabaseCache<K, V> databaseCache) {
        mMemoryCache = memoryCache;
        mDatabaseCache = databaseCache;
    }

    public AbsDatabaseCache<K, V> getDatabaseCache() {
        return mDatabaseCache;
    }

    public MemoryCache<K, V> getMemoryCache() {
        return mMemoryCache;
    }
}
