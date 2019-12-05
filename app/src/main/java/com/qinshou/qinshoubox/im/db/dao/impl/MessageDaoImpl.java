package com.qinshou.qinshoubox.im.db.dao.impl;

import android.database.sqlite.SQLiteDatabase;

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
}
