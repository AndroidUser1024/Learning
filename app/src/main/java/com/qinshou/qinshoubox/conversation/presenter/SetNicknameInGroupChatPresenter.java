package com.qinshou.qinshoubox.conversation.presenter;

import com.qinshou.commonmodule.base.AbsPresenter;
import com.qinshou.okhttphelper.callback.Callback;
import com.qinshou.qinshoubox.conversation.contract.ISetNicknameInGroupChatContract;
import com.qinshou.qinshoubox.conversation.model.SetNicknameInGroupChatModel;
import com.qinshou.qinshoubox.conversation.view.fragment.SetGroupChatNicknameFragment;
import com.qinshou.qinshoubox.conversation.view.fragment.SetNicknameInGroupChatFragment;
import com.qinshou.qinshoubox.im.listener.QSCallback;

/**
 * Author: QinHao
 * Email:cqflqinhao@126.com
 * Date: 2019/12/09 14:01
 * Description:{@link SetNicknameInGroupChatFragment} 的 P 层
 */
public class SetNicknameInGroupChatPresenter extends AbsPresenter<ISetNicknameInGroupChatContract.IView, ISetNicknameInGroupChatContract.IModel> implements ISetNicknameInGroupChatContract.IPresenter {
    @Override
    public ISetNicknameInGroupChatContract.IModel initModel() {
        return new SetNicknameInGroupChatModel();
    }

    @Override
    public void setNicknameInGroupChat(String groupChatId, String nicknameInGroupChat) {
        getModel().setNicknameInGroupChat(groupChatId, nicknameInGroupChat, new QSCallback<Object>() {
            @Override
            public void onSuccess(Object data) {
                if (!isViewAttached()) {
                    return;
                }
                getView().setNicknameInGroupChatSuccess();
            }

            @Override
            public void onFailure(Exception e) {
                if (!isViewAttached()) {
                    return;
                }
                getView().setNicknameInGroupChatFailure(e);
            }
        });
    }
}