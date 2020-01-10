package com.qinshou.qinshoubox.login.model;

import com.qinshou.okhttphelper.callback.Callback;
import com.qinshou.qinshoubox.login.bean.PoemBean;
import com.qinshou.qinshoubox.login.bean.UserBean;
import com.qinshou.qinshoubox.login.contract.ISplashContract;
import com.qinshou.qinshoubox.login.view.activity.SplashActivity;
import com.qinshou.qinshoubox.network.OkHttpHelperForQSBoxPoemApi;
import com.qinshou.qinshoubox.network.OkHttpHelperForQSBoxUserApi;
import com.qinshou.qinshoubox.transformer.QSApiTransformer;

/**
 * Description:{@link SplashActivity} 的 CameraModel
 * Author: QinHao
 * Date: 2019/4/4 14:38
 */
public class SplashModel implements ISplashContract.ISplashModel {
    @Override
    public void getRandomPoem(Callback<PoemBean> callback) {
        OkHttpHelperForQSBoxPoemApi.SINGLETON.getRandomOne()
                .transform(new QSApiTransformer<PoemBean>())
                .enqueue(callback);
    }

    @Override
    public void login(String username, String password, Callback<UserBean> callback) {
        OkHttpHelperForQSBoxUserApi.SINGLETON.login(username, password)
                .transform(new QSApiTransformer<UserBean>())
                .enqueue(callback);
    }
}
