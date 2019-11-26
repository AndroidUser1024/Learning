package com.qinshou.qinshoubox.im.manager;

import com.qinshou.okhttphelper.callback.Callback;
import com.qinshou.qinshoubox.im.bean.UserBean;
import com.qinshou.qinshoubox.im.db.dao.IUserDao;
import com.qinshou.qinshoubox.im.db.dao.impl.UserDaoImpl;
import com.qinshou.qinshoubox.im.listener.QSCallback;
import com.qinshou.qinshoubox.network.OkHttpHelperForQSBoxApi;
import com.qinshou.qinshoubox.network.OkHttpHelperForQSBoxFriendApi;
import com.qinshou.qinshoubox.transformer.QSApiTransformer;
import com.qinshou.qinshoubox.util.userstatusmanager.UserStatusManager;

import java.util.List;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/11/26 14:07
 * Description:用户管理者
 */
public class UserManager {
    /**
     * 用户 Dao
     */
    private IUserDao mUserDao;

    public UserManager() {
        mUserDao = new UserDaoImpl();
    }

    public int insertOrUpdate(UserBean userBean) {
        return mUserDao.insertOrUpdate(userBean);
    }

    public UserBean getUser(int id) {
        return mUserDao.getById(id);
    }

    public void getUser(String keyword, final QSCallback<UserBean> qsCallback) {
        OkHttpHelperForQSBoxApi.SINGLETON.getUserDetail(ChatManager.SINGLETON.getUserId(), keyword)
                .transform(new QSApiTransformer<UserBean>())
                .enqueue(new Callback<UserBean>() {
                    @Override
                    public void onSuccess(UserBean data) {
                        mUserDao.insertOrUpdate(data);
                        qsCallback.onSuccess(data);
                    }

                    @Override
                    public void onFailure(Exception e) {
                        qsCallback.onFailure(e);
                    }
                });
    }

    public void getFriendList(final QSCallback<List<UserBean>> qsCallback) {
        OkHttpHelperForQSBoxFriendApi.SINGLETON.getList(UserStatusManager.SINGLETON.getUserBean().getId())
                .transform(new QSApiTransformer<List<UserBean>>())
                .enqueue(new Callback<List<UserBean>>() {
                    @Override
                    public void onSuccess(List<UserBean> data) {
                        for (UserBean userBean : data) {
                            mUserDao.insertOrUpdate(userBean);
                        }
                        qsCallback.onSuccess(data);
                    }

                    @Override
                    public void onFailure(Exception e) {
                        qsCallback.onFailure(e);
                    }
                });
    }
}
