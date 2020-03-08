package com.qinshou.qinshoubox.im.db.dao.impl;

import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.qinshou.qinshoubox.friend.bean.UserDetailBean;
import com.qinshou.qinshoubox.im.db.dao.IUserDao;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2020/03/08 下午7:53
 * Description:
 */
public class UserDaoImpl extends AbsDaoImpl<UserDetailBean> implements IUserDao {
    public UserDaoImpl(SQLiteDatabase SQLiteDatabase) {
        super(SQLiteDatabase);
    }

    @Override
    public int insert(UserDetailBean userDetailBean) {
        String sql = "INSERT INTO user(" +
                " id" +
                " ,username" +
                " ,nickname" +
                " ,headImg" +
                " ,headImgSmall" +
                " ,phoneNumber" +
                " ,email" +
                " ,signature" +
                " ,gender" +
                ")" +
                " VALUES" +
                " (%s,%s,%s,%s,%s,%s,%s,%s,%s)";
        sql = String.format(sql
                , getStringValue(userDetailBean.getId())
                , getStringValue(userDetailBean.getUsername())
                , getStringValue(userDetailBean.getNickname())
                , getStringValue(userDetailBean.getHeadImg())
                , getStringValue(userDetailBean.getHeadImgSmall())
                , getStringValue(userDetailBean.getPhoneNumber())
                , getStringValue(userDetailBean.getEmail())
                , getStringValue(userDetailBean.getSignature())
                , userDetailBean.getGender());
        try {
            getSQLiteDatabase().execSQL(sql);
        } catch (SQLException e) {
            return 0;
        }
        return 1;
    }

    @Override
    public int delete(String id) {
        String sql = "DELETE FROM user" +
                " WHERE" +
                " id=%s";
        sql = String.format(sql, id);
        try {
            getSQLiteDatabase().execSQL(sql);
        } catch (SQLException e) {
            return 0;
        }
        return 1;
    }

    @Override
    public int update(UserDetailBean userDetailBean) {
        String sql = "UPDATE user SET" +
                " username=%s" +
                " ,nickname=%s" +
                " ,headImg=%s" +
                " ,headImgSmall=%s" +
                " ,phoneNumber=%s" +
                " ,email=%s" +
                " ,signature=%s" +
                " ,gender=%s" +
                " WHERE" +
                " id=%s";
        sql = String.format(sql
                , getStringValue(userDetailBean.getUsername())
                , getStringValue(userDetailBean.getNickname())
                , getStringValue(userDetailBean.getHeadImg())
                , getStringValue(userDetailBean.getHeadImgSmall())
                , getStringValue(userDetailBean.getPhoneNumber())
                , getStringValue(userDetailBean.getEmail())
                , getStringValue(userDetailBean.getSignature())
                , userDetailBean.getGender()
                , getStringValue(userDetailBean.getId()));
        try {
            getSQLiteDatabase().execSQL(sql);
        } catch (SQLException E) {
            return 0;
        }
        return 1;
    }
    @Override
    public UserDetailBean selectById(String id) {
        String sql = "SELECT" +
                " u.id" +
                " ,u.username" +
                " ,u.nickname" +
                " ,u.headImg" +
                " ,u.headImgSmall" +
                " ,u.phoneNumber" +
                " ,u.email" +
                " ,u.signature" +
                " ,u.gender" +
                " FROM user AS u" +
                " WHERE" +
                " u.id=%s";
        sql = String.format(sql, id);
        Cursor cursor = getSQLiteDatabase().rawQuery(sql, new String[]{});
        try {
            if (cursor.moveToNext()) {
                UserDetailBean userDetailBean = new UserDetailBean();
                userDetailBean.setId(cursor.getString(cursor.getColumnIndex("id")));
                userDetailBean.setUsername(cursor.getString(cursor.getColumnIndex("username")));
                userDetailBean.setNickname(cursor.getString(cursor.getColumnIndex("nickname")));
                userDetailBean.setHeadImg(cursor.getString(cursor.getColumnIndex("headImg")));
                userDetailBean.setHeadImgSmall(cursor.getString(cursor.getColumnIndex("headImgSmall")));
                userDetailBean.setPhoneNumber(cursor.getString(cursor.getColumnIndex("phoneNumber")));
                userDetailBean.setEmail(cursor.getString(cursor.getColumnIndex("email")));
                userDetailBean.setSignature(cursor.getString(cursor.getColumnIndex("signature")));
                userDetailBean.setGender(cursor.getInt(cursor.getColumnIndex("gender")));

            }
        }finally {
            if (cursor != null) {
                cursor.close();
            }
        }
        return null;
    }
}
