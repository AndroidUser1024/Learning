package com.qinshou.qinshoubox.conversation.model;

import com.qinshou.qinshoubox.im.bean.GroupChatDetailBean;
import com.qinshou.qinshoubox.conversation.contract.IGroupChatSettingContract;
import com.qinshou.qinshoubox.conversation.view.fragment.GroupChatSettingFragment;
import com.qinshou.qinshoubox.im.IMClient;
import com.qinshou.qinshoubox.im.listener.QSCallback;


/**
 * Author：WangGuifa
 * Email：wangguifa@jeejio.com
 * Date：2019/9/10 15:11
 * Description：{@link GroupChatSettingFragment} 的 M 层
 */
public class GroupChatSettingModel implements IGroupChatSettingContract.IModel {
    @Override
    public void getGroupChatDetail(String groupChatId, QSCallback<GroupChatDetailBean> qsCallback) {
        IMClient.SINGLETON.getGroupChatManager().getDetail(groupChatId, qsCallback);
    }

    @Override
    public void setTop(String groupChatId, int top, QSCallback<Object> qsCallback) {
        IMClient.SINGLETON.getGroupChatManager().setTop(groupChatId, top, qsCallback);
    }

    @Override
    public void setDoNotDisturb(String groupChatId, int doNotDisturb, QSCallback<Object> qsCallback) {
        IMClient.SINGLETON.getGroupChatManager().setDoNotDisturb(groupChatId, doNotDisturb, qsCallback);
    }

    @Override
    public void setShowGroupChatMemberNickname(String groupChatId, int showGroupChatMemberNickname, QSCallback<Object> qsCallback) {
        IMClient.SINGLETON.getGroupChatManager().setShowGroupChatMemberNickname(groupChatId, showGroupChatMemberNickname, qsCallback);
    }

    @Override
    public void exit(String groupChatId, QSCallback<Object> qsCallback) {
        IMClient.SINGLETON.getGroupChatManager().exit(groupChatId, qsCallback);
    }
}