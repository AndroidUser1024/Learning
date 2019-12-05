package com.qinshou.qinshoubox.conversation.model;


import com.qinshou.qinshoubox.im.bean.MessageBean;
import com.qinshou.qinshoubox.im.listener.QSCallback;
import com.qinshou.qinshoubox.conversation.contract.IGroupChatContract;
import com.qinshou.qinshoubox.conversation.view.activity.GroupChatActivity;

import java.util.List;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/06/20 10:26
 * Description:{@link GroupChatActivity} 的 M 层
 */

public class GroupChatModel implements IGroupChatContract.IModel {
    @Override
    public void getMessageList(int type, int toUserId, int page, int pageSize, QSCallback<List<MessageBean>> qsCallback) {
//        ConversationBean conversationBean = IMClient.SINGLETON.getConversationManager().getByTypeAndToUserId(type, toUserId);
//        if (conversationBean == null) {
//            return;
//        }
//        List<MessageBean> messageBeanList = IMClient.SINGLETON.getMessageManager().getList(conversationBean.getId(), page, pageSize);
//        qsCallback.onSuccess(messageBeanList);
    }
}