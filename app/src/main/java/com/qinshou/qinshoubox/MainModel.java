package com.qinshou.qinshoubox;

import com.qinshou.networkmodule.OkHttpHelper;
import com.qinshou.networkmodule.callback.Callback;
import com.qinshou.qinshoubox.login.bean.UserBean;
import com.qinshou.qinshoubox.network.QSBoxUserApi;
import com.qinshou.qinshoubox.transformer.QSApiTransformer;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/6/11 10:03
 * Description:{@link MainActivity} 的 M 层
 */
public class MainModel implements IMainContract.IModel {
    @Override
    public void login(String username, String password, Callback<UserBean> callback) {
        OkHttpHelper.SINGLETON.getCaller(QSBoxUserApi.class).login(username, password)
                .transform(new QSApiTransformer<UserBean>())
                .enqueue(callback);
    }
}
