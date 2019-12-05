package com.qinshou.qinshoubox.conversation.model;

import com.qinshou.qinshoubox.conversation.contract.IGroupChatSettingContract;
import com.qinshou.qinshoubox.conversation.view.fragment.GroupChatSettingFragment;
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
    public void getGroupChat(int groupChatId, QSCallback<GroupChatBean> qsCallback) {
//        IMClient.SINGLETON.getGroupChatManager().getGroupChat(groupChatId, qsCallback);
    }
}