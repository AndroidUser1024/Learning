package com.qinshou.qinshoubox.me.model;


import com.qinshou.okhttphelper.callback.Callback;
import com.qinshou.qinshoubox.im.bean.UserBean;
import com.qinshou.qinshoubox.me.contract.IDataSettingContract;
import com.qinshou.qinshoubox.me.ui.fragment.DataSettingFragment;
import com.qinshou.qinshoubox.network.OkHttpHelperForQSBoxUserApi;
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
        OkHttpHelperForQSBoxUserApi.SINGLETON.logout(username)
                .transform(new QSApiTransformer<UserBean>())
                .enqueue(callback);
    }
}