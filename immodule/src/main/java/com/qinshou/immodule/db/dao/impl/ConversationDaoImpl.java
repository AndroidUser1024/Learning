package com.qinshou.immodule.db.dao.impl;

import android.util.Log;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.GenericRawResults;
import com.j256.ormlite.stmt.QueryBuilder;
import com.qinshou.immodule.bean.ConversationBean;
import com.qinshou.immodule.db.DBHelper;
import com.qinshou.immodule.db.dao.IConversationDao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/8/5 17:34
 * Description:ConversationDao 的实现类
 */
public class ConversationDaoImpl implements IConversationDao {
    private Dao<ConversationBean, Integer> mDao;

    public ConversationDaoImpl() {
        try {
            mDao = DBHelper.getInstance().getDao(ConversationBean.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int insertOrUpdate(ConversationBean conversationBean) {
        try {
            return mDao.createOrUpdate(conversationBean).getNumLinesChanged();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public ConversationBean getByToUserId(int toUserId) {
        try {
            return mDao.queryBuilder()
                    .where()
                    .eq("toUserId", toUserId)
                    .queryForFirst();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<ConversationBean> getList() {
        try {
            QueryBuilder leftOuterJoinQueryBuilder = mDao.queryBuilder();
            leftOuterJoinQueryBuilder.where().eq("conversation.toUserId", "user.id");
            GenericRawResults<String[]> genericRawResults = mDao.queryBuilder().leftJoin(leftOuterJoinQueryBuilder).queryRaw();
            List<String[]> results = genericRawResults.getResults();
            for (String[] result : results) {
                Log.i("daolema", "result--->" + result);
            }
            return new ArrayList<>();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }
}
