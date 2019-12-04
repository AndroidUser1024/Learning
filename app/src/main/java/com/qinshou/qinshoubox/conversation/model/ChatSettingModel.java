package com.qinshou.qinshoubox.conversation.model;


import com.qinshou.qinshoubox.conversation.contract.IChatSettingContract;
import com.qinshou.qinshoubox.conversation.view.fragment.ChatSettingFragment;
import com.qinshou.immodule.bean.FriendBean;
import com.qinshou.immodule.listener.QSCallback;
import com.qinshou.immodule.manager.IMClient;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/09/03 15:05
 * Description:{@link ChatSettingFragment} 的 M 层
 */
public class ChatSettingModel implements IChatSettingContract.IModel {

    @Override
    public void getFriend(int id, QSCallback<FriendBean> qsCallback) {
        FriendBean friendBean = IMClient.SINGLETON.getFriendManager().getFriend(id);
        if (friendBean == null) {
            qsCallback.onFailure(new Exception("没有该用户"));
        } else {
            qsCallback.onSuccess(friendBean);
        }
    }

    @Override
    public void setTop(int toUserId, int top, QSCallback<FriendBean> qsCallback) {
        IMClient.SINGLETON.getFriendManager().setTop(toUserId, top, qsCallback);
    }

    @Override
    public void setDoNotDisturb(int toUserId, int doNotDisturb, QSCallback<FriendBean> qsCallback) {
        IMClient.SINGLETON.getFriendManager().setDoNotDisturb(toUserId, doNotDisturb, qsCallback);
    }

    @Override
    public void setBlackList(int toUserId, int blackList, QSCallback<FriendBean> qsCallback) {
        IMClient.SINGLETON.getFriendManager().setBlackList(toUserId, blackList, qsCallback);
    }
}