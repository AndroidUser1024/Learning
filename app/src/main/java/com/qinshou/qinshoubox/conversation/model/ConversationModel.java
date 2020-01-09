package com.qinshou.qinshoubox.conversation.model;


import com.qinshou.okhttphelper.callback.Callback;
import com.qinshou.qinshoubox.im.IMClient;
import com.qinshou.qinshoubox.im.bean.ConversationBean;
import com.qinshou.qinshoubox.conversation.contract.IConversationContract;
import com.qinshou.qinshoubox.conversation.view.fragment.ConversationFragment;

import java.util.List;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/08/07 15:08
 * Description:{@link ConversationFragment} 的 M 层
 */
public class ConversationModel implements IConversationContract.IModel {
    @Override
    public void getConversationList(Callback<List<ConversationBean>> callback) {
        callback.onSuccess(IMClient.SINGLETON.getConversationManager().getListOrderByTopDescAndLastMsgTimeDesc());
    }
}