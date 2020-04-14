package com.qinshou.qinshoubox.conversation.model;

import com.qinshou.okhttphelper.callback.Callback;
import com.qinshou.qinshoubox.conversation.contract.IGroupChatDeleteMemberContract;
import com.qinshou.qinshoubox.conversation.view.fragment.GroupChatDeleteMemberFragment;
import com.qinshou.qinshoubox.im.bean.UserDetailBean;
import com.qinshou.qinshoubox.im.IMClient;
import com.qinshou.qinshoubox.im.listener.QSCallback;

import java.util.List;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/12/02 17:41
 * Description:{@link GroupChatDeleteMemberFragment} 的 M 层
 */
public class GroupChatDeleteMemberModel implements IGroupChatDeleteMemberContract.IModel {
    @Override
    public void getMemberList(String groupChatId, QSCallback<List<UserDetailBean>> qsCallback) {
        IMClient.SINGLETON.getGroupChatManager().getMemberList(groupChatId, qsCallback);
    }

    @Override
    public void deleteMember(String groupChatId, List<String> deleteMemberIdList, QSCallback<Object> qsCallback) {
        IMClient.SINGLETON.getGroupChatManager().deleteMember(groupChatId, deleteMemberIdList, qsCallback);
    }
}