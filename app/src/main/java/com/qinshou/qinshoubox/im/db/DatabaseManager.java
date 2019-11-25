package com.qinshou.qinshoubox.im.db;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;

import com.qinshou.qinshoubox.im.bean.UserBean;

/**
 * Description:数据库管理者类
 * Created by 禽兽先生
 * Created on 2017/6/26
 */

public class DatabaseManager {

    private static final String TAG = "DatabaseManager";
    private SQLiteDatabase mSqLiteDatabase;

    DatabaseManager() {
    }

    /**
     * Description:-
     * Date:2018/11/15
     *
     * @param context   上下文
     * @param dbName    数据库名
     * @param dbVersion 数据库版本
     */
    public void init(Context context, String dbName, int dbVersion) {
        if (!dbName.endsWith(".db")) {
            dbName = dbName.concat(".db");
        }
        // 连接数据库
        SQLiteOpenHelper sqLiteOpenHelper = new DatabaseHelper(context, dbName, null, dbVersion);
        // 获取数据库可读可写的操作对象
        mSqLiteDatabase = sqLiteOpenHelper.getWritableDatabase();
    }

    public void insertUser(UserBean userBean) {
        String sql = "INSERT INTO user(id"
                + ",username"
                + ",nickname"
                + ",headImg"
                + ",headImgSmall"
                + ",remark"
                + ")"
                + " VALUES("
                + "\"" + userBean.getId() + "\""
                + "," + "\"" + userBean.getUsername() + "\""
                + "," + "\"" + userBean.getNickname() + "\""
                + "," + "\"" + userBean.getHeadImg() + "\""
                + "," + "\"" + userBean.getHeadImgSmall() + "\""
                + "," + "\"" + userBean.getRemark() + "\""
                + ");";
        mSqLiteDatabase.execSQL(sql);
    }

    public void updateUser(UserBean userBean) {
        String sql = "UPDATE user SET(id=" + "\"" + userBean.getId() + "\""
                + ",username=" + "\"" + userBean.getUsername() + "\""
                + ",nickname=" + "\"" + userBean.getNickname() + "\""
                + ",headImg=" + "\"" + userBean.getHeadImg() + "\""
                + ",headImgSmall=" + "\"" + userBean.getHeadImgSmall() + "\""
                + ",remark=" + "\"" + userBean.getRemark() + "\""
                + ");"
                + "WHERE id=" + "\"" + userBean.getId() + "\"";
        mSqLiteDatabase.execSQL(sql);
    }

    public UserBean getUser(int id) {
        String sql = "SELECT * FROM user WHERE id=" + "\"" + id + "\"" + ";";
        Cursor cursor = mSqLiteDatabase.rawQuery(sql, new String[]{});
        if (cursor.moveToNext()) {
            UserBean userBean = new UserBean();
            String[] columnNames = cursor.getColumnNames();
            for (String columnName : columnNames) {
                if (TextUtils.equals(columnName, "id")) {
                    userBean.setId(cursor.getInt(cursor.getColumnIndex(columnName)));
                } else if (TextUtils.equals(columnName, "username")) {
                    userBean.setUsername(cursor.getString(cursor.getColumnIndex(columnName)));
                } else if (TextUtils.equals(columnName, "nickname")) {
                    userBean.setNickname(cursor.getString(cursor.getColumnIndex(columnName)));
                } else if (TextUtils.equals(columnName, "headImg")) {
                    userBean.setHeadImg(cursor.getString(cursor.getColumnIndex(columnName)));
                } else if (TextUtils.equals(columnName, "headImgSmall")) {
                    userBean.setHeadImgSmall(cursor.getString(cursor.getColumnIndex(columnName)));
                } else if (TextUtils.equals(columnName, "remark")) {
                    userBean.setRemark(cursor.getString(cursor.getColumnIndex(columnName)));
                }
            }
            return userBean;
        }
        return null;
    }
}
