package com.qinshou.qinshoubox.conversation.model;


import com.jeejio.networkmodule.callback.Callback;
import com.qinshou.qinshoubox.im.IMClient;
import com.qinshou.qinshoubox.conversation.contract.IConversationContract;
import com.qinshou.qinshoubox.conversation.view.fragment.ConversationFragment;
import com.qinshou.qinshoubox.im.bean.ConversationDetailBean;
import com.qinshou.qinshoubox.im.listener.QSCallback;

import java.util.List;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/08/07 15:08
 * Description:{@link ConversationFragment} 的 M 层
 */
public class ConversationModel implements IConversationContract.IModel {
    @Override
    public void getConversationList(QSCallback<List<ConversationDetailBean>> qsCallback) {
        qsCallback.onSuccess(IMClient.SINGLETON.getConversationManager().getListOrderByTopDescAndLastMsgTimeDesc());
    }
}