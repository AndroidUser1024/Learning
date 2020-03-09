package com.qinshou.qinshoubox.im.db.dao.impl;

import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.qinshou.qinshoubox.friend.bean.UserDetailBean;
import com.qinshou.qinshoubox.im.db.dao.IGroupChatMemberDao;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2020/1/16 18:23
 * Description:group_chat_member 表的 Dao 的实现类
 */
public class GroupChatMemberDaoImpl extends AbsDaoImpl<UserDetailBean> implements IGroupChatMemberDao {
    public GroupChatMemberDaoImpl(SQLiteDatabase SQLiteDatabase) {
        super(SQLiteDatabase);
    }

    @Override
    public int insert(String groupChatId, UserDetailBean userDetailBean) {
        String sql = "INSERT INTO group_chat_member" +
                " (" +
                "groupChatId" +
                ",userId" +
                ",nicknameInGroupChat" +
                ",status" +
                ")" +
                " VALUES" +
                " (" +
                "%s" +
                ",%s" +
                ",%s" +
                ",%s" +
                ")";
        sql = String.format(sql
                , getStringValue(groupChatId)
                , getStringValue(userDetailBean.getId())
                , getStringValue(userDetailBean.getNicknameInGroupChat())
                , userDetailBean.getStatus());
        try {
            getSQLiteDatabase().execSQL(sql);
        } catch (SQLException e) {
            Log.e(TAG, "insert: " + "e--->" + e.getMessage());
            return 0;
        }
        return 1;
    }

    @Override
    public int update(String groupChatId, UserDetailBean userDetailBean) {
        String sql = "UPDATE group_chat_member SET" +
                " nicknameInGroupChat=%s" +
                ",status=%s" +
                " WHERE" +
                " groupChatId=%s" +
                " AND" +
                " userId=%s";
        sql = String.format(sql
                , getStringValue(userDetailBean.getNicknameInGroupChat())
                , userDetailBean.getStatus()
                , getStringValue(groupChatId)
                , getStringValue(userDetailBean.getId()));
        try {
            getSQLiteDatabase().execSQL(sql);
        } catch (SQLException e) {
            Log.e(TAG, "update: " + "e--->" + e.getMessage());
            return 0;
        }
        return 1;
    }

    @Override
    public List<UserDetailBean> selectByGroupChatId(String groupChatId) {
        String sql = "SELECT" +
                " gcm.userId" +
                ",gcm.nicknameInGroupChat" +
                ",gcm.status" +
                ",u.nickname" +
                ",u.headImg" +
                ",u.headImgSmall" +
                ",f.remark" +
                " FROM group_chat_member AS gcm" +
                " LEFT OUTER JOIN user AS u ON gcm.userId=u.id" +
                " LEFT OUTER JOIN friend AS f ON gcm.userId=f.id" +
                " WHERE" +
                " groupChatId=%s";
        sql = String.format(sql, getStringValue(groupChatId));
        List<UserDetailBean> userDetailBeanList = new ArrayList<>();
        Cursor cursor = getSQLiteDatabase().rawQuery(sql, new String[]{});
        try {
            while (cursor.moveToNext()) {
                UserDetailBean userDetailBean = new UserDetailBean();
                userDetailBean.setId(cursor.getString(cursor.getColumnIndex("userId")));
                userDetailBean.setNicknameInGroupChat(cursor.getString(cursor.getColumnIndex("nicknameInGroupChat")));
                userDetailBean.setStatus(cursor.getInt(cursor.getColumnIndex("status")));
                userDetailBean.setNickname(cursor.getString(cursor.getColumnIndex("nickname")));
                userDetailBean.setHeadImg(cursor.getString(cursor.getColumnIndex("headImg")));
                userDetailBean.setHeadImgSmall(cursor.getString(cursor.getColumnIndex("headImgSmall")));
                userDetailBean.setRemark(cursor.getString(cursor.getColumnIndex("remark")));
                userDetailBeanList.add(userDetailBean);
            }
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
        return userDetailBeanList;
    }

    @Override
    public UserDetailBean selectByGroupChatIdAndUserId(String groupChatId, String userId) {
        String sql = "SELECT" +
                " gcm.userId" +
                ",gcm.nicknameInGroupChat" +
                ",gcm.status" +
                ",u.nickname" +
                ",u.headImg" +
                ",u.headImgSmall" +
                ",f.remark" +
                " FROM group_chat_member AS gcm" +
                " LEFT OUTER JOIN user AS u ON gcm.userId=u.id" +
                " LEFT OUTER JOIN friend AS f ON gcm.userId=f.id" +
                " WHERE" +
                " groupChatId=%s" +
                " AND" +
                " userId=%s";
        sql = String.format(sql, getStringValue(groupChatId), getStringValue(userId));
        Cursor cursor = getSQLiteDatabase().rawQuery(sql, new String[]{});
        try {
            if (cursor.moveToNext()) {
                UserDetailBean userDetailBean = new UserDetailBean();
                userDetailBean.setId(cursor.getString(cursor.getColumnIndex("userId")));
                userDetailBean.setNicknameInGroupChat(cursor.getString(cursor.getColumnIndex("nicknameInGroupChat")));
                userDetailBean.setStatus(cursor.getInt(cursor.getColumnIndex("status")));
                userDetailBean.setNickname(cursor.getString(cursor.getColumnIndex("nickname")));
                userDetailBean.setHeadImg(cursor.getString(cursor.getColumnIndex("headImg")));
                userDetailBean.setHeadImgSmall(cursor.getString(cursor.getColumnIndex("headImgSmall")));
                userDetailBean.setRemark(cursor.getString(cursor.getColumnIndex("remark")));
                return userDetailBean;
            }
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
        return null;
    }

    @Override
    public boolean existsByGroupChatIdAndUserId(String groupChatId, String userId) {
        String sql = "SELECT" +
                " COUNT(userId)" +
                " FROM group_chat_member" +
                " WHERE" +
                " groupChatId=%s" +
                " AND" +
                " userId=%s";
        sql = String.format(sql, getStringValue(groupChatId), getStringValue(userId));
        Cursor cursor = getSQLiteDatabase().rawQuery(sql, new String[]{});
        try {
            if (cursor.moveToNext()) {
                int count = cursor.getInt(cursor.getColumnIndex("COUNT(userId)"));
                return count > 0;
            }
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
        return false;
    }
}
