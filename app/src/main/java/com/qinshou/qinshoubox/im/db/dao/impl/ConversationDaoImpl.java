package com.qinshou.qinshoubox.im.db.dao.impl;

import android.database.sqlite.SQLiteDatabase;

import com.qinshou.qinshoubox.im.bean.ConversationBean;
import com.qinshou.qinshoubox.im.db.dao.IConversationDao;

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
}
