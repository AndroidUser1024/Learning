package com.qinshou.qinshoubox.friend.model;

import com.qinshou.okhttphelper.callback.Callback;
import com.qinshou.qinshoubox.im.bean.UserDetailBean;
import com.qinshou.qinshoubox.friend.contract.IFriendContract;
import com.qinshou.qinshoubox.friend.view.fragment.FriendFragment;
import com.qinshou.qinshoubox.im.IMClient;
import com.qinshou.qinshoubox.im.bean.GroupChatBean;

import java.util.List;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/11/18 19:18
 * Description:{@link FriendFragment} 的 M 层
 */
public class FriendModel implements IFriendContract.IModel {
    @Override
    public void getMyGroupChatList(final Callback<List<GroupChatBean>> callback) {
        IMClient.SINGLETON.getGroupChatManager().getList(callback);
    }

    @Override
    public void getFriendList(final Callback<List<UserDetailBean>> qsCallback) {
        IMClient.SINGLETON.getFriendManager().getList(qsCallback);
    }
}