package com.qinshou.qinshoubox.im.db.dao.impl;

import android.database.sqlite.SQLiteDatabase;

import com.qinshou.qinshoubox.im.bean.FriendBean;
import com.qinshou.qinshoubox.im.db.dao.IFriendDao;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/12/5 8:57
 * Description:
 */
public class FriendDaoImpl extends AbsDaoImpl<FriendBean> implements IFriendDao {

    public FriendDaoImpl(SQLiteDatabase SQLiteDatabase) {
        super(SQLiteDatabase);
    }
}
