package com.qinshou.immodule.db.dao.impl;

import com.j256.ormlite.dao.Dao;
import com.qinshou.immodule.db.DBHelper;
import com.qinshou.immodule.bean.ConversationMessageRelBean;
import com.qinshou.immodule.db.dao.IConversationMessageRelDao;

import java.sql.SQLException;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/8/5 17:34
 * Description:MessageDao 的实现类
 */
public class ConversationMessageRelDaoImpl implements IConversationMessageRelDao {
    private Dao<ConversationMessageRelBean, Integer> mDao;

    public ConversationMessageRelDaoImpl() {
        try {
            mDao = DBHelper.getInstance().getDao(ConversationMessageRelBean.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int insertOrUpdate(ConversationMessageRelBean conversationMessageRelBean) {
        try {
            return mDao.createOrUpdate(conversationMessageRelBean).getNumLinesChanged();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}