package com.qinshou.qinshoubox.im.db.dao.impl;

import android.database.sqlite.SQLiteDatabase;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/12/5 8:58
 * Description:类描述
 */
public abstract class AbsDaoImpl<T> {
    private SQLiteDatabase mSQLiteDatabase;

    public AbsDaoImpl(SQLiteDatabase SQLiteDatabase) {
        mSQLiteDatabase = SQLiteDatabase;
    }
}
