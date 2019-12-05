package com.qinshou.qinshoubox.im.db.dao.impl;

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
}
