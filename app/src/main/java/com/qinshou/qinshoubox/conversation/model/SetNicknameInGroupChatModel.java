package com.qinshou.qinshoubox.conversation.model;

import com.qinshou.qinshoubox.conversation.contract.ISetNicknameInGroupChatContract;
import com.qinshou.qinshoubox.conversation.view.fragment.SetNicknameInGroupChatFragment;
import com.qinshou.qinshoubox.im.IMClient;
import com.qinshou.qinshoubox.im.listener.QSCallback;

/**
 * Author: QinHao
 * Email:cqflqinhao@126.com
 * Date: 2019/12/09 14:01
 * Description:{@link SetNicknameInGroupChatFragment} 的 M 层
 */
public class SetNicknameInGroupChatModel implements ISetNicknameInGroupChatContract.IModel {
    @Override
    public void setNicknameInGroupChat(String groupChatId, String nicknameInGroupChat, QSCallback<Object> qsCallback) {
        IMClient.SINGLETON.getGroupChatManager().setNicknameInGroupChat(groupChatId, nicknameInGroupChat, qsCallback);
    }
}