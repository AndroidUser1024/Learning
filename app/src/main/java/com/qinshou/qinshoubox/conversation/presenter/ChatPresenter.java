package com.qinshou.qinshoubox.conversation.presenter;


import com.qinshou.commonmodule.base.AbsPresenter;
import com.qinshou.immodule.bean.MessageBean;
import com.qinshou.immodule.listener.QSCallback;
import com.qinshou.qinshoubox.conversation.contract.IChatContract;
import com.qinshou.qinshoubox.conversation.model.ChatModel;
import com.qinshou.qinshoubox.conversation.view.activity.ChatActivity;

import java.util.List;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/06/20 10:26
 * Description:{@link ChatActivity} 的 P 层
 */
public class ChatPresenter extends AbsPresenter<IChatContract.IView, IChatContract.IModel> implements IChatContract.IPresenter {
    @Override
    public IChatContract.IModel initModel() {
        return new ChatModel();
    }

    @Override
    public void getMessageList(int type, int toUserId, int page, int pageSize) {
        getModel().getMessageList(type, toUserId, page, pageSize, new QSCallback<List<MessageBean>>() {
            @Override
            public void onSuccess(List<MessageBean> data) {
                if (!isViewAttached()) {
                    return;
                }
                getView().getMessageListSuccess(data);
            }

            @Override
            public void onFailure(Exception e) {
                if (!isViewAttached()) {
                    return;
                }
                getView().getMessageListFailure(e);
            }
        });
    }
}