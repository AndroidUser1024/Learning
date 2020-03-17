package com.qinshou.qinshoubox.friend.model;


import com.qinshou.okhttphelper.callback.Callback;
import com.qinshou.qinshoubox.im.bean.UserDetailBean;
import com.qinshou.qinshoubox.friend.contract.IAddFriendContract;
import com.qinshou.qinshoubox.friend.view.fragment.AddFriendFragment;
import com.qinshou.qinshoubox.network.OkHttpHelperForQSBoxUserApi;
import com.qinshou.qinshoubox.transformer.QSApiTransformer;
import com.qinshou.qinshoubox.util.userstatusmanager.UserStatusManager;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/08/21 14:25
 * Description:{@link AddFriendFragment} 的 M 层
 */
public class AddFriendModel implements IAddFriendContract.IModel {
    @Override
    public void getUserDetail(String keyword, Callback<UserDetailBean> callback) {
        OkHttpHelperForQSBoxUserApi.SINGLETON.getUserDetail(UserStatusManager.SINGLETON.getUserBean().getId(), keyword)
                .transform(new QSApiTransformer<UserDetailBean>())
                .enqueue(callback);
    }
}