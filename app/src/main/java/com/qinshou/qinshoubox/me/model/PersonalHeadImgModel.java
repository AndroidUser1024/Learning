package com.qinshou.qinshoubox.me.model;

import com.jeejio.networkmodule.OkHttpHelper;
import com.jeejio.networkmodule.callback.Callback;
import com.qinshou.qinshoubox.login.bean.UserBean;
import com.qinshou.qinshoubox.me.contract.IPersonalHeadImgContract;
import com.qinshou.qinshoubox.me.ui.fragment.PersonalHeadImgFragment;
import com.qinshou.qinshoubox.network.QSBoxUserApi;
import com.qinshou.qinshoubox.transformer.QSApiTransformer;

import java.io.File;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/11/13 16:40
 * Description:{@link PersonalHeadImgFragment} 的 M 层
 */
public class PersonalHeadImgModel implements IPersonalHeadImgContract.IModel {
    @Override
    public void setHeadImg(String userId, File file, Callback<UserBean> callback) {
        OkHttpHelper.SINGLETON.getCaller(QSBoxUserApi.class).setHeadImg(userId, file)
                .transform(new QSApiTransformer<UserBean>())
                .enqueue(callback);
    }
}