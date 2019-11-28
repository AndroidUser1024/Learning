package com.qinshou.qinshoubox.im.db.dao.impl;

import com.j256.ormlite.dao.Dao;
import com.qinshou.qinshoubox.im.bean.FriendBean;
import com.qinshou.qinshoubox.im.db.DBHelper;
import com.qinshou.qinshoubox.im.db.dao.IFriendDao;

import java.sql.SQLException;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/8/5 17:34
 * Description:UserDao 的实现类
 */
public class FriendDaoImpl implements IFriendDao {
    private Dao<FriendBean, Integer> mDao;

    public FriendDaoImpl() {
        try {
            mDao = DBHelper.getInstance().getDao(FriendBean.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int insertOrUpdate(FriendBean friendBean) {
        try {
            return mDao.createOrUpdate(friendBean).getNumLinesChanged();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public FriendBean getById(int id) {
        try {
            return mDao.queryForId(id);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public FriendBean getByUsername(String username) {
        try {
            return mDao.queryBuilder().where().eq("username", username)
                    .queryForFirst();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
