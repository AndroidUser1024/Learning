package com.qinshou.qinshoubox.im.db.dao.impl;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

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
                ",nickname" +
                ",headImg" +
                ",headImgSmall" +
                ",remark" +
                ",nicknameInGroupChat" +
                ")" +
                " VALUES" +
                " (" +
                "%s" +
                ",%s" +
                ",%s" +
                ",%s" +
                ",%s" +
                ",%s" +
                ",%s" +
                ")";
        sql = String.format(sql, getStringValue(groupChatId), getStringValue(userDetailBean.getId())
                , getStringValue(userDetailBean.getNickname()), getStringValue(userDetailBean.getHeadImg())
                , getStringValue(userDetailBean.getHeadImgSmall()), getStringValue(userDetailBean.getRemark())
                , getStringValue(userDetailBean.getNicknameInGroupChat()));
        getSQLiteDatabase().execSQL(sql);
        return 1;
    }

    @Override
    public int update(String groupChatId, UserDetailBean userDetailBean) {
        String sql = "UPDATE group_chat_member SET" +
                ",nickname%s" +
                ",headImg%s" +
                ",headImgSmall%s" +
                ",remark%s" +
                ",nicknameInGroupChat%s" +
                " WHERE groupChatId=%s AND userId=%s";
        sql = String.format(sql, getStringValue(userDetailBean.getNickname()), getStringValue(userDetailBean.getHeadImg())
                , getStringValue(userDetailBean.getHeadImgSmall()), getStringValue(userDetailBean.getRemark())
                , getStringValue(userDetailBean.getNicknameInGroupChat()), getStringValue(groupChatId)
                , getStringValue(userDetailBean.getId()));
        getSQLiteDatabase().execSQL(sql);
        return 1;
    }

    @Override
    public List<UserDetailBean> selectByGroupChatId(String groupChatId) {
        String sql = "SELECT" +
                " gcm.userId" +
                ",gcm.nickname" +
                ",gcm.headImg" +
                ",gcm.headImgSmall" +
                ",gcm.remark" +
                ",gcm.nicknameInGroupChat" +
                " FROM group_chat_member AS gcm" +
                " WHERE" +
                " groupChatId=%s";
        sql = String.format(sql, getStringValue(groupChatId));
        List<UserDetailBean> userDetailBeanList = new ArrayList<>();
        Cursor cursor = getSQLiteDatabase().rawQuery(sql, new String[]{});
        try {
            while (cursor.moveToNext()) {
                UserDetailBean userDetailBean = new UserDetailBean();
                userDetailBean.setId(cursor.getString(cursor.getColumnIndex("userId")));
                userDetailBean.setNickname(cursor.getString(cursor.getColumnIndex("nickname")));
                userDetailBean.setHeadImg(cursor.getString(cursor.getColumnIndex("headImg")));
                userDetailBean.setHeadImgSmall(cursor.getString(cursor.getColumnIndex("headImgSmall")));
                userDetailBean.setRemark(cursor.getString(cursor.getColumnIndex("remark")));
                userDetailBean.setNicknameInGroupChat(cursor.getString(cursor.getColumnIndex("nicknameInGroupChat")));
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
                ",gcm.nickname" +
                ",gcm.headImg" +
                ",gcm.headImgSmall" +
                ",gcm.remark" +
                ",gcm.nicknameInGroupChat" +
                " FROM group_chat_member AS gcm" +
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
                userDetailBean.setNickname(cursor.getString(cursor.getColumnIndex("nickname")));
                userDetailBean.setHeadImg(cursor.getString(cursor.getColumnIndex("headImg")));
                userDetailBean.setHeadImgSmall(cursor.getString(cursor.getColumnIndex("headImgSmall")));
                userDetailBean.setRemark(cursor.getString(cursor.getColumnIndex("remark")));
                userDetailBean.setNicknameInGroupChat(cursor.getString(cursor.getColumnIndex("nicknameInGroupChat")));
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
