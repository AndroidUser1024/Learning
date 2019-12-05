package com.qinshou.qinshoubox.im.db.dao.impl;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.qinshou.commonmodule.util.ShowLogUtil;
import com.qinshou.qinshoubox.im.bean.MessageBean;
import com.qinshou.qinshoubox.im.db.dao.IMessageDao;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
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
                " ('%s','%s','%s','%s','%s','%s','%s','%s','%s','%s')";
        sql = String.format(sql, messageBean.getId(), messageBean.getFromUserId(), messageBean.getToUserId()
                , messageBean.getType(), messageBean.getContentType(), messageBean.getContent()
                , messageBean.getSendTimestamp(), messageBean.getReceiveTimestamp(), messageBean.getStatus()
                , messageBean.getExtend());
        getSQLiteDatabase().execSQL(sql);
        Cursor cursor = null;
        try {
            cursor = getSQLiteDatabase().rawQuery("SELECT last_insert_rowid() FROM message", new String[]{});
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
}
