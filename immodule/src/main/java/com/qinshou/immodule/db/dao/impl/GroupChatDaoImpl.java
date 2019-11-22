package com.qinshou.immodule.db.dao.impl;


import com.j256.ormlite.dao.Dao;
import com.qinshou.immodule.bean.GroupChatBean;
import com.qinshou.immodule.db.DBHelper;
import com.qinshou.immodule.db.dao.IGroupChatDao;

import java.sql.SQLException;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/11/22 18:38
 * Description:IGroupChatDao 的实现类
 */
public class GroupChatDaoImpl implements IGroupChatDao {
    private Dao<GroupChatBean, Integer> mDao;

    public GroupChatDaoImpl() {
        try {
            mDao = DBHelper.getInstance().getDao(GroupChatBean.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int insertOrUpdate(GroupChatBean groupChatBean) {
        try {
            return mDao.createOrUpdate(groupChatBean).getNumLinesChanged();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public GroupChatBean getById(int id) {
        try {
            return mDao.queryForId(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
