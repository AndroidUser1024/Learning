package com.qinshou.qinshoubox.friend.model;

import com.qinshou.okhttphelper.callback.Callback;
import com.qinshou.qinshoubox.friend.contract.IFriendContract;
import com.qinshou.qinshoubox.friend.view.fragment.FriendFragment;
import com.qinshou.immodule.bean.GroupChatBean;
import com.qinshou.immodule.listener.QSCallback;
import com.qinshou.qinshoubox.im.IMClient;
import com.qinshou.qinshoubox.im.bean.FriendBean;

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
        IMClient.SINGLETON.getGroupChatManager().getGroupChatList(qsCallback);
    }

    @Override
    public void getFriendList(final Callback<List<FriendBean>> qsCallback) {
        IMClient.SINGLETON.getFriendManager().getList(qsCallback);
    }
}