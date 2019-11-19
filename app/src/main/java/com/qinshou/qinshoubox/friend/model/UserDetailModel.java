package com.qinshou.qinshoubox.friend.model;


import com.qinshou.okhttphelper.callback.Callback;
import com.qinshou.qinshoubox.friend.contract.IUserDetailContract;
import com.qinshou.qinshoubox.friend.view.fragment.UserDetailFragment;
import com.qinshou.qinshoubox.me.bean.UserBean;
import com.qinshou.qinshoubox.network.OkHttpHelperForQSBoxApi;
import com.qinshou.qinshoubox.transformer.QSApiTransformer;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/11/11 20:08
 * Description:{@link UserDetailFragment} 的 M 层
 */
public class UserDetailModel implements IUserDetailContract.IModel {
    @Override
    public void getUserDetail(int userId, String keyword, Callback<UserBean> callback) {
        OkHttpHelperForQSBoxApi.SINGLETON.getUserDetail(userId, keyword)
                .transform(new QSApiTransformer<UserBean>())
                .enqueue(callback);
    }
}