package com.qinshou.qinshoubox.me.model;


import com.qinshou.okhttphelper.callback.Callback;
import com.qinshou.qinshoubox.im.bean.UserBean;
import com.qinshou.qinshoubox.me.contract.ILoginOrRegisterContract;
import com.qinshou.qinshoubox.me.ui.fragment.LoginOrRegisterFragment;
import com.qinshou.qinshoubox.network.OkHttpHelperForQSBoxApi;
import com.qinshou.qinshoubox.transformer.QSApiTransformer;

/**
 * Description:{@link LoginOrRegisterFragment} 界面的 Model 层
 * Author: QinHao
 * Date: 2019/5/5 17:21
 */
public class LoginOrRegisterModel implements ILoginOrRegisterContract.IModel {
    @Override
    public void register(String username, String password, Callback<UserBean> callback) {
        OkHttpHelperForQSBoxApi.SINGLETON.register(username, password)
                .transform(new QSApiTransformer<UserBean>())
                .enqueue(callback);
    }

    @Override
    public void login(String username, String password, Callback<UserBean> callback) {
        OkHttpHelperForQSBoxApi.SINGLETON.login(username, password)
                .transform(new QSApiTransformer<UserBean>())
                .enqueue(callback);
    }
}
