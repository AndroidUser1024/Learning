package com.qinshou.qinshoubox.im.db.dao.impl;

import android.database.sqlite.SQLiteDatabase;

/**
 * Author: QinHao
 * Email:cqflqinhao@126.com
 * Date: 2019/12/5 8:58
 * Description:所有 Dao 实现类的基类
 */
public abstract class AbsDaoImpl<T> {
    public final String TAG = getClass().getSimpleName();
    private SQLiteDatabase mSQLiteDatabase;

    public AbsDaoImpl(SQLiteDatabase SQLiteDatabase) {
        mSQLiteDatabase = SQLiteDatabase;
    }

    public SQLiteDatabase getSQLiteDatabase() {
        return mSQLiteDatabase;
    }

    public String getStringValue(String value) {
        if (value == null) {
            return null;
        } else {
            return "\'" + value + "\'";
        }
    }
}
