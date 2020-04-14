package com.qinshou.qinshoubox.friend.model;

import com.qinshou.qinshoubox.friend.contract.ICreateGroupChatContract;
import com.qinshou.qinshoubox.friend.view.fragment.CreateGroupChatFragment;
import com.qinshou.qinshoubox.im.IMClient;
import com.qinshou.qinshoubox.im.bean.GroupChatBean;
import com.qinshou.qinshoubox.im.bean.UserDetailBean;
import com.qinshou.qinshoubox.im.listener.QSCallback;

import java.util.List;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/08/19 17:27
 * Description:{@link CreateGroupChatFragment} 的 M 层
 */
public class CreateGroupChatModel implements ICreateGroupChatContract.IModel {

    @Override
    public void getFriendList(QSCallback<List<UserDetailBean>> qsCallback) {
        IMClient.SINGLETON.getFriendManager().getList(qsCallback);
    }

    @Override
    public void createGroupChat( List<String> memberIdList, String nickname, String headImg, QSCallback<GroupChatBean> qsCallback) {
        IMClient.SINGLETON.getGroupChatManager().create( memberIdList, nickname, headImg, qsCallback);
    }
}