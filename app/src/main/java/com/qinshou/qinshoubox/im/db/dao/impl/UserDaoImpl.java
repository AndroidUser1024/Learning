package com.qinshou.qinshoubox.im.db.dao.impl;

import com.j256.ormlite.dao.Dao;
import com.qinshou.qinshoubox.im.db.DBHelper;
import com.qinshou.qinshoubox.im.db.dao.IUserDao;
import com.qinshou.qinshoubox.im.bean.UserBean;

import java.sql.SQLException;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/8/5 17:34
 * Description:UserDao 的实现类
 */
public class UserDaoImpl implements IUserDao {
    private Dao<UserBean, Integer> mDao;

    public UserDaoImpl() {
        try {
            mDao = DBHelper.getInstance().getDao(UserBean.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int insertOrUpdate(UserBean userBean) {
        try {
            return mDao.createOrUpdate(userBean).getNumLinesChanged();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public UserBean getById(int id) {
        try {
            return mDao.queryForId(id);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public UserBean getByUsername(String username) {
        try {
            return mDao.queryBuilder().where().eq("username", username)
                    .queryForFirst();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
