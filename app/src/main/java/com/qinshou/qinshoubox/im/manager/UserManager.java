package com.qinshou.qinshoubox.im.manager;


import com.jeejio.dbmodule.DatabaseManager;
import com.jeejio.dbmodule.dao.IBaseDao;
import com.qinshou.okhttphelper.callback.Callback;
import com.qinshou.qinshoubox.im.IMClient;
import com.qinshou.qinshoubox.im.bean.UserBean;
import com.qinshou.qinshoubox.im.bean.UserDetailBean;
import com.qinshou.qinshoubox.im.listener.QSCallback;
import com.qinshou.qinshoubox.network.OkHttpHelperForQSBoxUserApi;
import com.qinshou.qinshoubox.transformer.QSApiTransformer;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/11/26 14:07
 * Description:用户管理者
 */
public class UserManager {
    private IBaseDao<UserBean> mUserDao;

    public UserManager() {
        mUserDao = DatabaseManager.getInstance().getDaoByClass(UserBean.class);
    }

    public void getUser(String keyword, final QSCallback<UserDetailBean> qsCallback) {
        String userId = IMClient.SINGLETON.getUserDetailBean().getId();
        OkHttpHelperForQSBoxUserApi.SINGLETON.getUserDetail(userId, keyword)
                .transform(new QSApiTransformer<UserDetailBean>())
                .enqueue(new Callback<UserDetailBean>() {
                    @Override
                    public void onSuccess(UserDetailBean data) {
                        UserBean userBean = new UserBean(data.getId()
                                , data.getUsername()
                                , data.getNickname()
                                , data.getHeadImgSmall()
                                , data.getHeadImg());
                        mUserDao.save(userBean);

                        qsCallback.onSuccess(data);
                    }

                    @Override
                    public void onFailure(Exception e) {
                        qsCallback.onFailure(e);
                    }
                });
    }
}
