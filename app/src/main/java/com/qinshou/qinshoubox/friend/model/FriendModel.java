package com.qinshou.qinshoubox.friend.model;

import com.qinshou.okhttphelper.callback.Callback;
import com.qinshou.qinshoubox.friend.contract.IFriendContract;
import com.qinshou.qinshoubox.friend.view.fragment.FriendFragment;
import com.qinshou.immodule.bean.GroupChatBean;
import com.qinshou.immodule.bean.UserBean;
import com.qinshou.qinshoubox.network.OkHttpHelperForQSBoxApi;
import com.qinshou.qinshoubox.network.OkHttpHelperForQSBoxGroupChatApi;
import com.qinshou.qinshoubox.transformer.QSApiTransformer;
import com.qinshou.qinshoubox.util.userstatusmanager.UserStatusManager;

import java.util.List;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/11/18 19:18
 * Description:{@link FriendFragment} 的 M 层
 */
public class FriendModel implements IFriendContract.IModel {
    @Override
    public void getMyGroupChatList(Callback<List<GroupChatBean>> callback) {
        if (!UserStatusManager.SINGLETON.isLogin()) {
            return;
        }
        OkHttpHelperForQSBoxGroupChatApi.SINGLETON.getMyGroupChatList(UserStatusManager.SINGLETON.getUserBean().getId())
                .transform(new QSApiTransformer<List<GroupChatBean>>())
                .enqueue(callback);
    }

    @Override
    public void getFriendList(Callback<List<UserBean>> callback) {
        if (!UserStatusManager.SINGLETON.isLogin()) {
            return;
        }
        OkHttpHelperForQSBoxApi.SINGLETON.getFriendList(UserStatusManager.SINGLETON.getUserBean().getId())
                .transform(new QSApiTransformer<List<UserBean>>())
                .enqueue(callback);
    }
}