package com.qinshou.qinshoubox.conversation.model;

import com.qinshou.qinshoubox.conversation.contract.IGroupChatAddMemberContract;
import com.qinshou.qinshoubox.conversation.view.fragment.GroupChatAddMemberFragment;
import com.qinshou.immodule.bean.FriendBean;
import com.qinshou.qinshoubox.login.bean.UserBean;
import com.qinshou.immodule.listener.QSCallback;
import com.qinshou.qinshoubox.im.IMClient;

import java.util.List;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/12/02 17:40
 * Description:{@link GroupChatAddMemberFragment} 的 M 层
 */
public class GroupChatAddMemberModel implements IGroupChatAddMemberContract.IModel {
    @Override
    public void getMemberList(int groupChatId, QSCallback<List<UserBean>> qsCallback) {
//        IMClient.SINGLETON.getGroupChatManager().getMemberList(groupChatId, qsCallback);
    }

    @Override
    public void getFriendList(QSCallback<List<FriendBean>> qsCallback) {
//        IMClient.SINGLETON.getFriendManager().getFriendList(qsCallback);
    }

    @Override
    public void addMember(int groupChatId, List<Integer> addMemberIdList, QSCallback<Object> qsCallback) {
//        IMClient.SINGLETON.getGroupChatManager().addMember(groupChatId, addMemberIdList, qsCallback);
    }
}