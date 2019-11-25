package com.qinshou.qinshoubox.conversation.model;


import com.qinshou.immodule.bean.ConversationBean;
import com.qinshou.immodule.bean.MessageBean;
import com.qinshou.immodule.listener.QSCallback;
import com.qinshou.immodule.manager.ConversationManager;
import com.qinshou.immodule.manager.MessageManager;
import com.qinshou.qinshoubox.conversation.contract.IChatContract;
import com.qinshou.qinshoubox.conversation.view.activity.ChatActivity;

import java.util.List;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/06/20 10:26
 * Description:{@link ChatActivity} 的 M 层
 */
public class ChatModel implements IChatContract.IModel {
    @Override
    public void getMessageList(int type, int toUserId, int page, int pageSize, QSCallback<List<MessageBean>> qsCallback) {
        ConversationBean conversationBean = ConversationManager.SINGLETON.getByTypeAndToUserId(type, toUserId);
        if (conversationBean == null) {
            return;
        }
        List<MessageBean> messageBeanList = MessageManager.SINGLETON.getList(conversationBean.getId(), page, pageSize);
        qsCallback.onSuccess(messageBeanList);
    }
}