package com.qinshou.qinshoubox.me.model;

import com.qinshou.okhttphelper.callback.Callback;
import com.qinshou.qinshoubox.me.bean.UserBean;
import com.qinshou.qinshoubox.me.contract.IPersonalHeadImgContract;
import com.qinshou.qinshoubox.me.ui.fragment.PersonalHeadImgFragment;
import com.qinshou.qinshoubox.network.OkHttpHelperForQSBoxApi;
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
    public void setHeadImg(int userId, File file, Callback<UserBean> callback) {
        OkHttpHelperForQSBoxApi.SINGLETON.setHeadImg(userId, file)
                .transform(new QSApiTransformer<UserBean>())
                .enqueue(callback);
    }
}