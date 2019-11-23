package com.qinshou.qinshoubox.conversation.model;


import com.qinshou.immodule.bean.ConversationBean;
import com.qinshou.immodule.listener.QSCallback;
import com.qinshou.immodule.manager.ConversationManager;
import com.qinshou.qinshoubox.conversation.contract.IConversationContract;
import com.qinshou.qinshoubox.conversation.view.fragment.ConversationFragment;
import com.qinshou.qinshoubox.util.userstatusmanager.UserStatusManager;

import java.util.List;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/08/07 15:08
 * Description:{@link ConversationFragment} 的 M 层
 */
public class ConversationModel implements IConversationContract.IModel {
    @Override
    public void getConversationList(QSCallback<List<ConversationBean>> qsCallback) {
        if (!UserStatusManager.SINGLETON.isLogin()) {
            return;
        }
        qsCallback.onSuccess(ConversationManager.SINGLETON.getList());
    }
}