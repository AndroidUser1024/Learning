package com.qinshou.qinshoubox.conversation.model;


import com.qinshou.qinshoubox.conversation.contract.IChatSettingContract;
import com.qinshou.qinshoubox.conversation.view.fragment.ChatSettingFragment;
import com.qinshou.qinshoubox.im.bean.UserDetailBean;
import com.qinshou.qinshoubox.im.IMClient;
import com.qinshou.qinshoubox.im.listener.QSCallback;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/09/03 15:05
 * Description:{@link ChatSettingFragment} 的 M 层
 */
public class ChatSettingModel implements IChatSettingContract.IModel {

    @Override
    public void getFriend(String id, QSCallback<UserDetailBean> qsCallback) {
        UserDetailBean userDetailBean = IMClient.SINGLETON.getFriendManager().getById(id);
        qsCallback.onSuccess(userDetailBean);
    }

    @Override
    public void setTop(String toUserId, int top, QSCallback<Object> qsCallback) {
        IMClient.SINGLETON.getFriendManager().setTop(toUserId, top, qsCallback);
    }

    @Override
    public void setDoNotDisturb(String toUserId, int doNotDisturb, QSCallback<Object> qsCallback) {
        IMClient.SINGLETON.getFriendManager().setDoNotDisturb(toUserId, doNotDisturb, qsCallback);
    }

    @Override
    public void setBlackList(String toUserId, int blackList, QSCallback<Object> qsCallback) {
        IMClient.SINGLETON.getFriendManager().setBlackList(toUserId, blackList, qsCallback);
    }
}