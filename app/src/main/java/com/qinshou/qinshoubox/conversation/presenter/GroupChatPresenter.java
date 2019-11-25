package com.qinshou.qinshoubox.conversation.presenter;


import com.qinshou.commonmodule.base.AbsPresenter;
import com.qinshou.immodule.bean.MessageBean;
import com.qinshou.immodule.listener.QSCallback;
import com.qinshou.qinshoubox.conversation.contract.IGroupChatContract;
import com.qinshou.qinshoubox.conversation.model.GroupChatModel;
import com.qinshou.qinshoubox.conversation.view.activity.GroupChatActivity;

import java.util.List;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/06/20 10:26
 * Description:{@link GroupChatActivity} 的 P 层
 */
public class GroupChatPresenter extends AbsPresenter<IGroupChatContract.IView, IGroupChatContract.IModel> implements IGroupChatContract.IPresenter {
    @Override
    public IGroupChatContract.IModel initModel() {
        return new GroupChatModel();
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