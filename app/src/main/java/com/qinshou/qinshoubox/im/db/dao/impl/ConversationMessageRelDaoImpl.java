package com.qinshou.qinshoubox.im.db.dao.impl;

import android.database.sqlite.SQLiteDatabase;

import com.qinshou.qinshoubox.im.bean.ConversationMessageRelBean;
import com.qinshou.qinshoubox.im.db.dao.IConversationMessageRelDao;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/12/5 9:03
 * Description:类描述
 */
public class ConversationMessageRelDaoImpl extends AbsDaoImpl<ConversationMessageRelBean> implements IConversationMessageRelDao {

    public ConversationMessageRelDaoImpl(SQLiteDatabase SQLiteDatabase) {
        super(SQLiteDatabase);
    }
}