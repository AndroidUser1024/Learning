package com.qinshou.qinshoubox.friend.model;

import com.qinshou.okhttphelper.callback.Callback;
import com.qinshou.qinshoubox.friend.contract.IFriendContract;
import com.qinshou.qinshoubox.friend.view.fragment.FriendFragment;
import com.qinshou.qinshoubox.me.bean.GroupChatBean;
import com.qinshou.qinshoubox.me.bean.UserBean;
import com.qinshou.qinshoubox.network.OkHttpHelperForQSBoxApi;
import com.qinshou.qinshoubox.network.OkHttpHelperForQSBoxGroupChatApi;
import com.qinshou.qinshoubox.transformer.QSApiTransformer;

import java.util.List;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/11/18 19:18
 * Description:{@link FriendFragment} 的 M 层
 */
public class FriendModel implements IFriendContract.IModel {
    @Override
    public void getFriendList(int fromUserId, Callback<List<UserBean>> callback) {
        OkHttpHelperForQSBoxApi.SINGLETON.getFriendList(fromUserId)
                .transform(new QSApiTransformer<List<UserBean>>())
                .enqueue(callback);
    }

    @Override
    public void getMyGroupChatList(int userId, Callback<List<GroupChatBean>> callback) {
        OkHttpHelperForQSBoxGroupChatApi.SINGLETON.getMyGroupChatList(userId)
                .transform(new QSApiTransformer<List<GroupChatBean>>())
                .enqueue(callback);
    }
}