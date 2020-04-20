package com.qinshou.qinshoubox.me.model;

import com.qinshou.networkmodule.OkHttpHelper;
import com.qinshou.networkmodule.callback.Callback;
import com.qinshou.qinshoubox.login.bean.UserBean;
import com.qinshou.qinshoubox.me.contract.ISetNameContract;
import com.qinshou.qinshoubox.me.ui.fragment.SetNameFragment;
import com.qinshou.qinshoubox.network.QSBoxUserApi;
import com.qinshou.qinshoubox.transformer.QSApiTransformer;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/11/13 14:36
 * Description:{@link SetNameFragment} 的 M 层
 */
public class SetNameModel implements ISetNameContract.IModel {
    @Override
    public void setUserInfo(String userId, String nickname, Callback<UserBean> callback) {
        OkHttpHelper.SINGLETON.getCaller(QSBoxUserApi.class).setInfo(userId, nickname)
                .transform(new QSApiTransformer<UserBean>())
                .enqueue(callback);
    }
}