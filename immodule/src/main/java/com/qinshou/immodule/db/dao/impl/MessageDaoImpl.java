package com.qinshou.immodule.db.dao.impl;


import com.j256.ormlite.dao.Dao;
import com.qinshou.immodule.bean.MessageBean;
import com.qinshou.immodule.db.DBHelper;
import com.qinshou.immodule.db.dao.IMessageDao;

import java.sql.SQLException;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/8/5 17:34
 * Description:MessageDao 的实现类
 */
public class MessageDaoImpl implements IMessageDao {
    private Dao<MessageBean, Integer> mDao;

    public MessageDaoImpl() {
        try {
            mDao = DBHelper.getInstance().getDao(MessageBean.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int insertOrUpdate(MessageBean messageBean) {
        try {
            return mDao.createOrUpdate(messageBean).getNumLinesChanged();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}