package com.qinshou.qinshoubox.friend.model;


import com.qinshou.okhttphelper.callback.Callback;
import com.qinshou.qinshoubox.friend.bean.UserDetailBean;
import com.qinshou.qinshoubox.friend.contract.IUserDetailContract;
import com.qinshou.qinshoubox.friend.view.fragment.UserDetailFragment;
import com.qinshou.qinshoubox.im.IMClient;
import com.qinshou.qinshoubox.im.listener.QSCallback;
import com.qinshou.qinshoubox.network.OkHttpHelperForQSBoxUserApi;
import com.qinshou.qinshoubox.transformer.QSApiTransformer;
import com.qinshou.qinshoubox.util.userstatusmanager.UserStatusManager;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/11/11 20:08
 * Description:{@link UserDetailFragment} 的 M 层
 */
public class UserDetailModel implements IUserDetailContract.IModel {
    @Override
    public void getUserDetail(String keyword, Callback<UserDetailBean> callback) {
        OkHttpHelperForQSBoxUserApi.SINGLETON.getUserDetail(UserStatusManager.SINGLETON.getUserBean().getId(), keyword)
                .transform(new QSApiTransformer<UserDetailBean>())
                .enqueue(callback);
    }

    @Override
    public void agreeAddFriend(String toUserId, String remark, QSCallback<Object> qsCallback) {
        IMClient.SINGLETON.getFriendManager().agreeAddFriend(toUserId, remark, qsCallback);
    }

    @Override
    public void deleteFriend(String toUserId, Callback<Object> callback) {
        IMClient.SINGLETON.getFriendManager().deleteFriend(toUserId, callback);
    }

    @Override
    public void setRemark(String toUserId, String remark, Callback<Object> callback) {
        IMClient.SINGLETON.getFriendManager().setRemark(toUserId, remark, callback);
    }
}