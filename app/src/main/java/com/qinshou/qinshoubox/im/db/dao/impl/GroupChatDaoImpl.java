package com.qinshou.qinshoubox.im.db.dao.impl;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.qinshou.qinshoubox.im.bean.GroupChatBean;
import com.qinshou.qinshoubox.im.db.dao.IGroupChatDao;


/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/12/5 9:01
 * Description:类描述
 */
public class GroupChatDaoImpl extends AbsDaoImpl<GroupChatBean> implements IGroupChatDao {
    public GroupChatDaoImpl(SQLiteDatabase SQLiteDatabase) {
        super(SQLiteDatabase);
    }

    @Override
    public int insert(GroupChatBean groupChatBean) {
        // 先查询该 id 是否存在
        String sql = "SELECT COUNT(*) AS count FROM group_chat WHERE id='%s'";
        sql = String.format(sql, groupChatBean.getId());
        Cursor cursor = getSQLiteDatabase().rawQuery(sql, new String[]{});
        int count = 0;
        try {
            if (cursor.moveToNext()) {
                count = cursor.getInt(cursor.getColumnIndex("count"));
            }
        } finally {
            cursor.close();
        }

        if (count == 0) {
            // 如果不存在,则新增
            sql = "INSERT INTO group_chat" +
                    " (id,ownerId,nickname,headImg,headImgSmall,nicknameDefault,nicknameInGroupChat,top" +
                    " ,doNotDisturb,showGroupChatMemberNickname)" +
                    " VALUES" +
                    " ('%s','%s','%s','%s','%s','%s','%s','%s','%s','%s')";
            sql = String.format(sql, groupChatBean.getId(), groupChatBean.getOwnerId(), groupChatBean.getNickname()
                    , groupChatBean.getHeadImg(), groupChatBean.getHeadImgSmall(), groupChatBean.getNicknameDefault()
                    , groupChatBean.getNicknameInGroupChat(), groupChatBean.getTop(), groupChatBean.getDoNotDisturb()
                    , groupChatBean.getShowGroupChatMemberNickname());
            getSQLiteDatabase().execSQL(sql);
        } else {
            // 已存在则更新
            sql = "UPDATE group_chat SET" +
                    " ownerId='%s',nickname='%s',headImg='%s',headImgSmall='%s'" +
                    " ,nicknameDefault='%s',nicknameInGroupChat='%s',top='%s'" +
                    " ,doNotDisturb='%s',showGroupChatMemberNickname='%s'" +
                    " WHERE id='%s'";
            sql = String.format(sql, groupChatBean.getOwnerId(), groupChatBean.getNickname()
                    , groupChatBean.getHeadImg(), groupChatBean.getHeadImgSmall()
                    , groupChatBean.getNicknameDefault(), groupChatBean.getNicknameInGroupChat()
                    , groupChatBean.getTop(), groupChatBean.getDoNotDisturb(), groupChatBean.getShowGroupChatMemberNickname()
                    , groupChatBean.getId());
            getSQLiteDatabase().execSQL(sql);
        }
        return 1;
    }

    @Override
    public GroupChatBean selectById(String id) {
        return null;
    }
}
