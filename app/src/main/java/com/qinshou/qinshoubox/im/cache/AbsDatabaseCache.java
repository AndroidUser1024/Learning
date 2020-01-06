package com.qinshou.qinshoubox.im.cache;

import com.qinshou.qinshoubox.im.db.DatabaseHelper;

/**
 * Author: QinHao
 * Email:cqflqinhao@126.com
 * Date: 2020/1/4 16:50
 * Description:数据库缓存
 */
public abstract class AbsDatabaseCache<K, V> implements ICache<K, V> {
    private DatabaseHelper mDatabaseHelper;

    public AbsDatabaseCache(DatabaseHelper databaseHelper) {
        mDatabaseHelper = databaseHelper;
    }
}
