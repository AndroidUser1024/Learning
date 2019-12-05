package com.qinshou.qinshoubox.conversation.model;

import com.qinshou.qinshoubox.conversation.contract.IGroupChatDeleteMemberContract;
import com.qinshou.qinshoubox.conversation.view.fragment.GroupChatDeleteMemberFragment;
import com.qinshou.qinshoubox.login.bean.UserBean;
import com.qinshou.immodule.listener.QSCallback;
import com.qinshou.qinshoubox.im.IMClient;

import java.util.List;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/12/02 17:41
 * Description:{@link GroupChatDeleteMemberFragment} 的 M 层
 */
public class GroupChatDeleteMemberModel implements IGroupChatDeleteMemberContract.IModel {
    @Override
    public void getMemberList(int groupChatId, QSCallback<List<UserBean>> qsCallback) {
//        IMClient.SINGLETON.getGroupChatManager().getMemberList(groupChatId, qsCallback);
    }

    @Override
    public void deleteMember(int groupChatId, List<Integer> deleteMemberIdList, QSCallback<Object> qsCallback) {
//        IMClient.SINGLETON.getGroupChatManager().deleteMember(groupChatId, deleteMemberIdList, qsCallback);
    }
}