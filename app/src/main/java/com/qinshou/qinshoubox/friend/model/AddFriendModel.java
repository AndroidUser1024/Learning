package com.qinshou.qinshoubox.friend.model;


import com.qinshou.okhttphelper.callback.Callback;
import com.qinshou.qinshoubox.friend.contract.IAddFriendContract;
import com.qinshou.qinshoubox.friend.view.fragment.AddFriendFragment;
import com.qinshou.qinshoubox.login.bean.UserBean;
import com.qinshou.qinshoubox.network.OkHttpHelperForQSBoxUserApi;
import com.qinshou.qinshoubox.transformer.QSApiTransformer;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/08/21 14:25
 * Description:{@link AddFriendFragment} 的 M 层
 */
public class AddFriendModel implements IAddFriendContract.IModel {
    @Override
    public void getUserDetail(String userId,String keyword, Callback<UserBean> callback) {
        OkHttpHelperForQSBoxUserApi.SINGLETON.getUserDetail(userId, keyword)
                .transform(new QSApiTransformer<UserBean>())
                .enqueue(callback);
    }
}