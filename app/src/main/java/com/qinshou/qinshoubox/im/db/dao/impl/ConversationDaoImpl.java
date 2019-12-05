package com.qinshou.qinshoubox.im.db.dao.impl;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.qinshou.commonmodule.util.ShowLogUtil;
import com.qinshou.qinshoubox.im.bean.ConversationBean;
import com.qinshou.qinshoubox.im.db.dao.IConversationDao;

import java.util.List;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/12/5 9:03
 * Description:类描述
 */
public class ConversationDaoImpl extends AbsDaoImpl<ConversationBean> implements IConversationDao {
    public ConversationDaoImpl(SQLiteDatabase SQLiteDatabase) {
        super(SQLiteDatabase);
    }

    @Override
    public int insert(ConversationBean conversationBean) {
        String sql = "INSERT INTO conversation" +
                " (toUserId,type,lastMsgContent,lastMsgContentType,lastMsgTimestamp,unreadCount)" +
                " VALUES" +
                " ('%s','%s','%s','%s','%s','%s')";
        sql = String.format(sql, conversationBean.getToUserId(), conversationBean.getType()
                , conversationBean.getLastMsgContent(), conversationBean.getLastMsgContentType()
                , conversationBean.getLastMsgTimestamp(), conversationBean.getUnreadCount());
        getSQLiteDatabase().execSQL(sql);
        return 0;
    }

    @Override
    public int update(ConversationBean conversationBean) {
        return 0;
    }

    @Override
    public List<ConversationBean> selectList() {
        return null;
    }

    @Override
    public ConversationBean selectByToUserIdAndType(String toUserId, int type) {
        // SELECT
        // c.id,c.toUserId,c.type,c.lastMsgContent,c.lastMsgContentType
        // ,c.lastMsgTimestamp,c.unreadCount
        // ,f.nickname,f.headImgSmall,f.remark,f.top,f.doNotDisturb
        // ,gc.nickname,gc.headImgSmall,gc.nicknameDefault,gc.top,gc.doNotDisturb
        // FROM conversation AS c
        // LEFT OUTER JOIN friend AS f ON f.id=c.toUserId AND c.type=2001
        // LEFT OUTER JOIN group_chat AS gc ON gc.id=c.toUserId AND c.type=3001
        // WHERE c.toUserId=#{toUserId} AND c.type=#{type};
        String sql = "SELECT" +
                " c.id,c.toUserId,c.type,c.lastMsgContent,c.lastMsgContentType" +
                " ,c.lastMsgTimestamp,c.unreadCount" +
                " ,f.nickname AS fNickname,f.headImgSmall AS fHeadImgSmall" +
                " ,f.remark AS fRemark,f.top AS fTop,f.doNotDisturb AS fDoNotDisturb" +
                " ,gc.nickname AS gcNickname,gc.headImgSmall AS gcHeadImgSmall" +
                " ,gc.nicknameDefault AS gcNicknameDefault,gc.top AS gcTop,gc.doNotDisturb AS gcDoNotDisturb" +
                " FROM conversation AS c" +
                " LEFT OUTER JOIN friend AS f ON f.id=c.toUserId AND c.type=2001" +
                " LEFT OUTER JOIN group_chat AS gc ON gc.id=c.toUserId AND c.type=3001" +
                " WHERE c.toUserId='%s' AND c.type='%s'";
        sql = String.format(sql, toUserId, type);
        Cursor cursor = getSQLiteDatabase().rawQuery(sql, new String[]{});
        if (cursor.moveToNext()) {
            ConversationBean conversationBean = new ConversationBean();
            conversationBean.setId(cursor.getInt(cursor.getColumnIndex("id")));
            conversationBean.setToUserId(cursor.getString(cursor.getColumnIndex("toUserId")));
            conversationBean.setType(cursor.getInt(cursor.getColumnIndex("type")));
            conversationBean.setLastMsgContent(cursor.getString(cursor.getColumnIndex("lastMsgContent")));
            conversationBean.setLastMsgContentType(cursor.getInt(cursor.getColumnIndex("lastMsgContentType")));
            conversationBean.setLastMsgTimestamp(cursor.getLong(cursor.getColumnIndex("lastMsgTimestamp")));
            conversationBean.setUnreadCount(cursor.getInt(cursor.getColumnIndex("unreadCount")));
            ShowLogUtil.logi("fNickname--->" + cursor.getColumnIndex("fNickname"));
            ShowLogUtil.logi("fHeadImgSmall--->" + cursor.getColumnIndex("fHeadImgSmall"));
            ShowLogUtil.logi("fRemark--->" + cursor.getColumnIndex("fRemark"));
            ShowLogUtil.logi("fTop--->" + cursor.getColumnIndex("fTop"));
            ShowLogUtil.logi("fDoNotDisturb--->" + cursor.getColumnIndex("fDoNotDisturb"));
            ShowLogUtil.logi("gcNickname--->" + cursor.getColumnIndex("gcNickname"));
            ShowLogUtil.logi("gcHeadImgSmall--->" + cursor.getColumnIndex("gcHeadImgSmall"));
            ShowLogUtil.logi("gcNicknameDefault--->" + cursor.getColumnIndex("gcNicknameDefault"));
            ShowLogUtil.logi("gcTop--->" + cursor.getColumnIndex("gcTop"));
            ShowLogUtil.logi("gcDoNotDisturb--->" + cursor.getColumnIndex("gcDoNotDisturb"));
            return conversationBean;
//            conversationBean.setId(cursor.getInt(cursor.getColumnIndex("id")));
//            conversationBean.setId(cursor.getInt(cursor.getColumnIndex("id")));
//            conversationBean.setId(cursor.getInt(cursor.getColumnIndex("id")));

        }
        cursor.close();
        return null;
    }
}
