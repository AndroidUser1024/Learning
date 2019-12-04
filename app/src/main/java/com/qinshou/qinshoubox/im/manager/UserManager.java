package com.qinshou.qinshoubox.im.manager;

import com.qinshou.okhttphelper.callback.Callback;
import com.qinshou.qinshoubox.im.bean.UserBean;
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

    public void getUser(String keyword, final QSCallback<UserBean> qsCallback) {
//        OkHttpHelperForQSBoxUserApi.SINGLETON.getUserDetail(IMClient.SINGLETON.getUserId(), keyword)
//                .transform(new QSApiTransformer<UserBean>())
//                .enqueue(new Callback<UserBean>() {
//                    @Override
//                    public void onSuccess(UserBean data) {
//                        qsCallback.onSuccess(data);
//                    }
//
//                    @Override
//                    public void onFailure(Exception e) {
//                        qsCallback.onFailure(e);
//                    }
//                });
    }
}
