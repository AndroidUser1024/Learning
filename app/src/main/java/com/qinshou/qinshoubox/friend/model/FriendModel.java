package com.qinshou.qinshoubox.friend.model;

import com.qinshou.qinshoubox.friend.contract.IFriendContract;
import com.qinshou.qinshoubox.friend.view.fragment.FriendFragment;
import com.qinshou.qinshoubox.im.bean.FriendBean;
import com.qinshou.qinshoubox.im.bean.GroupChatBean;
import com.qinshou.qinshoubox.im.listener.QSCallback;
import com.qinshou.qinshoubox.im.manager.IMClient;
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
    public void getMyGroupChatList(final QSCallback<List<GroupChatBean>> qsCallback) {
        if (!UserStatusManager.SINGLETON.isLogin()) {
            return;
        }
        IMClient.SINGLETON.getGroupChatManager().getGroupChatList(qsCallback);
    }

    @Override
    public void getFriendList(final QSCallback<List<FriendBean>> qsCallback) {
        if (!UserStatusManager.SINGLETON.isLogin()) {
            return;
        }
        IMClient.SINGLETON.getFriendManager().getFriendList(qsCallback);
    }
}