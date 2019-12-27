package com.qinshou.qinshoubox.im.db.dao.impl;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.qinshou.qinshoubox.im.bean.ConversationMessageRelBean;
import com.qinshou.qinshoubox.im.db.dao.IConversationMessageRelDao;

/**
 * Author: QinHao
 * Email:cqflqinhao@126.com
 * Date: 2019/12/5 9:03
 * Description:类描述
 */
public class ConversationMessageRelDaoImpl extends AbsDaoImpl<ConversationMessageRelBean> implements IConversationMessageRelDao {

    public ConversationMessageRelDaoImpl(SQLiteDatabase SQLiteDatabase) {
        super(SQLiteDatabase);
    }

    @Override
    public void insert(ConversationMessageRelBean conversationMessageRelBean) {
        String sql = "INSERT INTO conversation_message_rel" +
                " (conversationId,messagePid)" +
                " VALUES" +
                " (%s,%s)";
        sql = String.format(sql, conversationMessageRelBean.getConversationId(), conversationMessageRelBean.getMessagePid());
        getSQLiteDatabase().execSQL(sql);
    }

    @Override
    public boolean existsByConversationIdAndMessagePid(ConversationMessageRelBean conversationMessageRelBean) {
        String sql = "SELECT" +
                " COUNT(id)" +
                " FROM conversation_message_rel" +
                " WHERE" +
                " conversationId=%s AND messagePid=%s";
        sql = String.format(sql, conversationMessageRelBean.getConversationId(), conversationMessageRelBean.getMessagePid());
        Cursor cursor = getSQLiteDatabase().rawQuery(sql, new String[]{});
        try {
            if (cursor.moveToNext()) {
                int count = cursor.getInt(cursor.getColumnIndex("COUNT(id)"));
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
