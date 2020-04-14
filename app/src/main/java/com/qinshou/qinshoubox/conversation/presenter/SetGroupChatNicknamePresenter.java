package com.qinshou.qinshoubox.conversation.presenter;

import com.qinshou.commonmodule.base.AbsPresenter;
import com.qinshou.qinshoubox.conversation.contract.ISetGroupChatNicknameContract;
import com.qinshou.qinshoubox.conversation.model.SetGroupChatNicknameModel;
import com.qinshou.qinshoubox.conversation.view.fragment.SetGroupChatNicknameFragment;
import com.qinshou.qinshoubox.im.listener.QSCallback;

/**
 * Author: QinHao
 * Email:cqflqinhao@126.com
 * Date: 2019/12/09 14:01
 * Description:{@link SetGroupChatNicknameFragment} 的 P 层
 */
public class SetGroupChatNicknamePresenter extends AbsPresenter<ISetGroupChatNicknameContract.IView, ISetGroupChatNicknameContract.IModel> implements ISetGroupChatNicknameContract.IPresenter {
    @Override
    public ISetGroupChatNicknameContract.IModel initModel() {
        return new SetGroupChatNicknameModel();
    }

    @Override
    public void setGroupChatNickname(String groupChatId, String nickname) {
        getModel().setGroupChatNickname(groupChatId, nickname, new QSCallback<Object>() {
            @Override
            public void onSuccess(Object data) {
                if (!isViewAttached()) {
                    return;
                }
                getView().setGroupChatNicknameSuccess();
            }

            @Override
            public void onFailure(Exception e) {
                if (!isViewAttached()) {
                    return;
                }
                getView().setGroupChatNicknameFailure(e);
            }
        });
    }
}