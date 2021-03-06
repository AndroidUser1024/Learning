package com.qinshou.qinshoubox.conversation.model;


import com.qinshou.qinshoubox.conversation.contract.IGroupChatContract;
import com.qinshou.qinshoubox.conversation.view.activity.GroupChatActivity;
import com.qinshou.qinshoubox.im.IMClient;
import com.qinshou.qinshoubox.im.bean.MessageBean;
import com.qinshou.qinshoubox.im.enums.MessageType;
import com.qinshou.qinshoubox.im.listener.QSCallback;

import java.util.Collections;
import java.util.List;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/06/20 10:26
 * Description:{@link GroupChatActivity} 的 M 层
 */

public class GroupChatModel implements IGroupChatContract.IModel {
    @Override
    public void getMessageList(String toUserId, int page, int pageSize, QSCallback<List<MessageBean>> qsCallback) {
        List<MessageBean> messageBeanList = IMClient.SINGLETON.getMessageManager().getList(MessageType.GROUP_CHAT.getValue(), toUserId, page, pageSize);
        // 翻转顺序
        Collections.reverse(messageBeanList);
        qsCallback.onSuccess(messageBeanList);
    }
}