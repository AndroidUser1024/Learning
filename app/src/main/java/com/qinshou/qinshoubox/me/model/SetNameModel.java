package com.qinshou.qinshoubox.me.model;

import com.qinshou.okhttphelper.callback.Callback;
import com.qinshou.immodule.bean.UserBean;
import com.qinshou.qinshoubox.me.contract.ISetNameContract;
import com.qinshou.qinshoubox.me.ui.fragment.SetNameFragment;
import com.qinshou.qinshoubox.network.OkHttpHelperForQSBoxApi;
import com.qinshou.qinshoubox.transformer.QSApiTransformer;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/11/13 14:36
 * Description:{@link SetNameFragment} 的 M 层
 */
public class SetNameModel implements ISetNameContract.IModel {
    @Override
    public void setUserInfo(int userId, String nickname, Callback<UserBean> callback) {
        OkHttpHelperForQSBoxApi.SINGLETON.setInfo(userId, nickname)
                .transform(new QSApiTransformer<UserBean>())
                .enqueue(callback);
    }
}