package com.qinshou.qinshoubox.im.db.dao.impl;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.qinshou.commonmodule.util.ShowLogUtil;
import com.qinshou.qinshoubox.im.bean.MessageBean;
import com.qinshou.qinshoubox.im.db.dao.IMessageDao;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: QinHao
 * Email:cqflqinhao@126.com
 * Date: 2019/12/5 9:02
 * Description:类描述
 */
public class MessageDaoImpl extends AbsDaoImpl<MessageBean> implements IMessageDao {
    public MessageDaoImpl(SQLiteDatabase SQLiteDatabase) {
        super(SQLiteDatabase);
    }

    @Override
    public MessageBean insert(MessageBean messageBean) {
        String sql = "INSERT INTO message" +
                " (id,fromUserId,toUserId,type,contentType,content,sendTimestamp,receiveTimestamp,status,extend)" +
                " VALUES" +
                " (%s,%s,%s,%s,%s,%s,%s,%s,%s,%s)";
        sql = String.format(sql, getStringValue(messageBean.getId()), getStringValue(messageBean.getFromUserId())
                , getStringValue(messageBean.getToUserId()), messageBean.getType(), messageBean.getContentType()
                , getStringValue(messageBean.getContent()), messageBean.getSendTimestamp()
                , messageBean.getReceiveTimestamp(), messageBean.getStatus(), getStringValue(messageBean.getExtend()));
        getSQLiteDatabase().execSQL(sql);
        Cursor cursor = getSQLiteDatabase().rawQuery("SELECT last_insert_rowid() FROM message", new String[]{});
        try {
            if (cursor.moveToFirst()) {
                int pid = cursor.getInt(0);
                messageBean.setPid(pid);
            }
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
        return messageBean;
    }

    @Override
    public int update(MessageBean messageBean) {
        String sql = "UPDATE message SET" +
                " id=%s,fromUserId=%s,toUserId=%s,type=%s,contentType=%s" +
                ",content=%s,sendTimestamp=%s,receiveTimestamp=%s,status=%s,extend=%s" +
                " WHERE pid=%s";
        sql = String.format(sql, getStringValue(messageBean.getId()), getStringValue(messageBean.getFromUserId())
                , getStringValue(messageBean.getToUserId()), messageBean.getType()
                , messageBean.getContentType(), getStringValue(messageBean.getContent()), messageBean.getSendTimestamp()
                , messageBean.getReceiveTimestamp(), messageBean.getStatus(), getStringValue(messageBean.getExtend())
                , messageBean.getPid());
        getSQLiteDatabase().execSQL(sql);
        return 1;
    }

    @Override
    public MessageBean selectByPid(int pid) {
        String sql = "SELECT" +
                " m.pid,m.id,m.fromUserId,m.toUserId,m.type" +
                ",m.contentType,m.content,m.sendTimestamp,m.receiveTimestamp,m.status" +
                ",m.extend" +
                " FROM message AS m" +
                " WHERE m.pid=%s";
        sql = String.format(sql, pid);
        Cursor cursor = getSQLiteDatabase().rawQuery(sql, new String[]{});
        try {
            if (cursor.moveToNext()) {
                MessageBean messageBean = new MessageBean();
                messageBean.setPid(cursor.getInt(cursor.getColumnIndex("pid")));
                messageBean.setId(cursor.getString(cursor.getColumnIndex("id")));
                messageBean.setFromUserId(cursor.getString(cursor.getColumnIndex("fromUserId")));
                messageBean.setToUserId(cursor.getString(cursor.getColumnIndex("toUserId")));
                messageBean.setType(cursor.getInt(cursor.getColumnIndex("type")));
                messageBean.setContentType(cursor.getInt(cursor.getColumnIndex("contentType")));
                messageBean.setContent(cursor.getString(cursor.getColumnIndex("content")));
                messageBean.setSendTimestamp(cursor.getLong(cursor.getColumnIndex("sendTimestamp")));
                messageBean.setReceiveTimestamp(cursor.getLong(cursor.getColumnIndex("receiveTimestamp")));
                messageBean.setStatus(cursor.getInt(cursor.getColumnIndex("status")));
                messageBean.setExtend(cursor.getString(cursor.getColumnIndex("extend")));
                return messageBean;
            }
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
        return null;
    }

    @Override
    public List<MessageBean> selectList(int conversationId, int page, int pageSize) {
        String sql = "SELECT" +
                " m.pid,m.id,m.fromUserId,m.toUserId,m.type" +
                ",m.contentType,m.content,m.sendTimestamp,m.receiveTimestamp,m.status" +
                ",m.extend" +
                " FROM conversation_message_rel AS cmr" +
                " LEFT OUTER JOIN message AS m ON m.pid = cmr.messagePid" +
                " WHERE cmr.conversationId = %s" +
                " LIMIT %s,%s";
        sql = String.format(sql, conversationId, (page - 1) * pageSize, (page) * pageSize);
        List<MessageBean> messageBeanList = new ArrayList<>();
        Cursor cursor = getSQLiteDatabase().rawQuery(sql, new String[]{});
        try {
            while (cursor.moveToNext()) {
                MessageBean messageBean = new MessageBean();
                messageBean.setPid(cursor.getInt(cursor.getColumnIndex("pid")));
                messageBean.setId(cursor.getString(cursor.getColumnIndex("id")));
                messageBean.setFromUserId(cursor.getString(cursor.getColumnIndex("fromUserId")));
                messageBean.setToUserId(cursor.getString(cursor.getColumnIndex("toUserId")));
                messageBean.setType(cursor.getInt(cursor.getColumnIndex("type")));
                messageBean.setContentType(cursor.getInt(cursor.getColumnIndex("contentType")));
                messageBean.setContent(cursor.getString(cursor.getColumnIndex("content")));
                messageBean.setSendTimestamp(cursor.getLong(cursor.getColumnIndex("sendTimestamp")));
                messageBean.setReceiveTimestamp(cursor.getLong(cursor.getColumnIndex("receiveTimestamp")));
                messageBean.setStatus(cursor.getInt(cursor.getColumnIndex("status")));
                messageBean.setExtend(cursor.getString(cursor.getColumnIndex("extend")));
                messageBeanList.add(messageBean);
            }
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
        return messageBeanList;
    }

    @Override
    public boolean existsByPid(int pid) {
        String sql = "SELECT COUNT(pid) FROM message WHERE pid=%s";
        sql = String.format(sql, pid);
        Cursor cursor = getSQLiteDatabase().rawQuery(sql, new String[]{});
        try {
            if (cursor.moveToNext()) {
                int count = cursor.getInt(cursor.getColumnIndex("COUNT(pid)"));
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
