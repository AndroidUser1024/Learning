package com.qinshou.immodule.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    private final String CREATE_USER_TABLE_SQL = "CREATE TABLE user(" +
            "pid INTEGER PRIMARY KEY AUTOINCREMENT" +
            ",id INTEGER" +
            ",username TEXT" +
            ",nickname TEXT" +
            ",headImg TEXT" +
            ",headImgSmall TEXT" +
            ",remark TEXT" +
            ")";

    /**
     * @param context 上下文
     * @param name    数据库名称
     * @param factory 游标工厂,一般为null
     * @param version 数据库版本
     */
    public DatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    /**
     * 初始化表,第一次创建表时调用
     *
     * @param db 数据库的操作类的对象
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        // 创建 user 表
        db.execSQL(CREATE_USER_TABLE_SQL);
    }

    /**
     * 更新数据库,如果数据库的版本号发生变化,执行此方法
     *
     * @param db         数据库的操作类的对象
     * @param oldVersion 旧版本
     * @param newVersion 新版本
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}