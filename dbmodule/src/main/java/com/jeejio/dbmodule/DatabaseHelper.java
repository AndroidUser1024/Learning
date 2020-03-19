
package com.jeejio.dbmodule;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.jeejio.dbmodule.util.SqlUtil;


/**
 * Description:
 * Created by 禽兽先生
 * Created on 2017/6/26
 */
public class DatabaseHelper extends SQLiteOpenHelper {
    private Class<?>[] mClassArray;

    /**
     * @param context 上下文
     * @param name    数据库名称
     * @param factory 游标工厂,一般为null
     * @param version 数据库版本
     */
    public DatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version, Class<?>[] classArray) {
        super(context, name, factory, version);
        this.mClassArray = classArray;
    }

    /**
     * 初始化表,第一次创建表时调用
     *
     * @param db 数据库的操作类的对象
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        for (Class<?> clazz : mClassArray) {
            db.execSQL(SqlUtil.getCreateTableSql(clazz));
        }
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
