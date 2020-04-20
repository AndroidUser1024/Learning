package com.qinshou.qinshoubox.me.model;


import com.qinshou.networkmodule.OkHttpHelper;
import com.qinshou.networkmodule.callback.Callback;
import com.qinshou.qinshoubox.login.bean.UserBean;
import com.qinshou.qinshoubox.me.contract.IDataSettingContract;
import com.qinshou.qinshoubox.me.ui.fragment.DataSettingFragment;
import com.qinshou.qinshoubox.network.QSBoxUserApi;
import com.qinshou.qinshoubox.transformer.QSApiTransformer;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/09/19 15:56
 * Description:{@link DataSettingFragment} 的 M 层
 */
public class DataSettingModel implements IDataSettingContract.IModel {
    @Override
    public void logout(String username, Callback<UserBean> callback) {
        OkHttpHelper.SINGLETON.getCaller(QSBoxUserApi.class).logout(username)
                .transform(new QSApiTransformer<UserBean>())
                .enqueue(callback);
    }
}