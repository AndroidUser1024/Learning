package com.qinshou.qinshoubox.conversation.model;

import com.qinshou.okhttphelper.callback.Callback;
import com.qinshou.qinshoubox.conversation.bean.GroupChatDetailBean;
import com.qinshou.qinshoubox.conversation.contract.IGroupChatSettingContract;
import com.qinshou.qinshoubox.conversation.view.fragment.GroupChatSettingFragment;
import com.qinshou.qinshoubox.im.IMClient;
import com.qinshou.qinshoubox.im.listener.QSCallback;
import com.qinshou.qinshoubox.im.bean.GroupChatBean;


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
    public void setTop(String groupChatId, int top, Callback<Object> callback) {
        IMClient.SINGLETON.getGroupChatManager().setTop(groupChatId, top, callback);
    }

    @Override
    public void setDoNotDisturb(String groupChatId, int doNotDisturb, Callback<Object> callback) {
        IMClient.SINGLETON.getGroupChatManager().setDoNotDisturb(groupChatId, doNotDisturb, callback);
    }

    @Override
    public void setShowGroupChatMemberNickname(String groupChatId, int showGroupChatMemberNickname, Callback<Object> callback) {
        IMClient.SINGLETON.getGroupChatManager().setShowGroupChatMemberNickname(groupChatId, showGroupChatMemberNickname, callback);
    }

    @Override
    public void exit(String groupChatId, Callback<Object> callBack) {
        IMClient.SINGLETON.getGroupChatManager().exit(groupChatId, callBack);
    }
}