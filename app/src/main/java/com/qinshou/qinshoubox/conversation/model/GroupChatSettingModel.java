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
    public void getGroupChatDetail(String groupChatId, Callback<GroupChatDetailBean> callback) {
        IMClient.SINGLETON.getGroupChatManager().getDetail(groupChatId, callback);
    }
}