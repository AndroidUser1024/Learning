package com.qinshou.qinshoubox.conversation.model;


import com.qinshou.immodule.manager.ConversationManager;
import com.qinshou.qinshoubox.conversation.contract.IConversationContract;
import com.qinshou.qinshoubox.conversation.view.fragment.ConversationFragment;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/08/07 15:08
 * Description:{@link ConversationFragment} 的 M 层
 */
public class ConversationModel implements IConversationContract.IModel {
    @Override
    public void getConversationList() {
        ConversationManager.SINGLETON.getList();
    }
}