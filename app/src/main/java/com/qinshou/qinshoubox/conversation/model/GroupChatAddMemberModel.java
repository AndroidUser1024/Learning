package com.qinshou.qinshoubox.conversation.model;

import com.qinshou.okhttphelper.callback.Callback;
import com.qinshou.qinshoubox.conversation.contract.IGroupChatAddMemberContract;
import com.qinshou.qinshoubox.conversation.view.fragment.GroupChatAddMemberFragment;
import com.qinshou.qinshoubox.im.bean.UserDetailBean;
import com.qinshou.qinshoubox.im.IMClient;
import com.qinshou.qinshoubox.im.listener.QSCallback;

import java.util.List;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/12/02 17:40
 * Description:{@link GroupChatAddMemberFragment} 的 M 层
 */
public class GroupChatAddMemberModel implements IGroupChatAddMemberContract.IModel {
    @Override
    public void getFriendList(QSCallback<List<UserDetailBean>> qsCallback) {
        IMClient.SINGLETON.getFriendManager().getList(qsCallback);
    }

    @Override
    public void getMemberList(String groupChatId, QSCallback<List<UserDetailBean>> qsCallback) {
        IMClient.SINGLETON.getGroupChatManager().getMemberList(groupChatId, qsCallback);
    }

    @Override
    public void addMember(String groupChatId, List<String> addMemberIdList, QSCallback<Object> qsCallback) {
        IMClient.SINGLETON.getGroupChatManager().addMember(groupChatId, addMemberIdList, qsCallback);
    }
}