package com.qinshou.qinshoubox.im.manager;


import com.qinshou.dbmodule.DatabaseManager;
import com.qinshou.dbmodule.dao.IBaseDao;
import com.qinshou.networkmodule.OkHttpHelper;
import com.qinshou.networkmodule.callback.Callback;
import com.qinshou.qinshoubox.im.IMClient;
import com.qinshou.qinshoubox.im.bean.UserBean;
import com.qinshou.qinshoubox.im.bean.UserDetailBean;
import com.qinshou.qinshoubox.im.db.IUserDao;
import com.qinshou.qinshoubox.im.listener.QSCallback;
import com.qinshou.qinshoubox.network.QSBoxUserApi;
import com.qinshou.qinshoubox.transformer.QSApiTransformer;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/11/26 14:07
 * Description:用户管理者
 */
public class UserManager {
    private IUserDao mUserDao;

    public UserManager() {
        mUserDao = DatabaseManager.getInstance().getDao(IUserDao.class);
    }

    public void getUser(String keyword, final QSCallback<UserDetailBean> qsCallback) {
        String userId = IMClient.SINGLETON.getUserDetailBean().getId();
        OkHttpHelper.SINGLETON.getCaller(QSBoxUserApi.class).getUserDetail(keyword, userId)
                .transform(new QSApiTransformer<>())
                .enqueue(new Callback<UserDetailBean>() {
                    @Override
                    public void onSuccess(UserDetailBean data) {
                        UserBean userBean = new UserBean(data.getId()
                                , data.getUsername()
                                , data.getNickname()
                                , data.getHeadImgSmall()
                                , data.getHeadImg());
                        if (mUserDao.existsById(userBean.getId()) == 0) {
                            mUserDao.insert(userBean);
                        } else {
                            mUserDao.updateById(userBean);
                        }
                        qsCallback.onSuccess(data);
                    }

                    @Override
                    public void onFailure(Exception e) {
                        qsCallback.onFailure(e);
                    }
                });
    }

    public void getUser(String keyword, String groupChatId, final QSCallback<UserDetailBean> qsCallback) {
        String userId = IMClient.SINGLETON.getUserDetailBean().getId();
        OkHttpHelper.SINGLETON.getCaller(QSBoxUserApi.class).getUserDetail(keyword, userId, groupChatId)
                .transform(new QSApiTransformer<>())
                .enqueue(new Callback<UserDetailBean>() {
                    @Override
                    public void onSuccess(UserDetailBean data) {
                        UserBean userBean = new UserBean(data.getId()
                                , data.getUsername()
                                , data.getNickname()
                                , data.getHeadImgSmall()
                                , data.getHeadImg());
                        if (mUserDao.existsById(userBean.getId()) == 0) {
                            mUserDao.insert(userBean);
                        } else {
                            mUserDao.updateById(userBean);
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
