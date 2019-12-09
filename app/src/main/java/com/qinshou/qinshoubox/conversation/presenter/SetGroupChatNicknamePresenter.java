package com.qinshou.qinshoubox.conversation.presenter;

import com.qinshou.commonmodule.base.AbsPresenter;
import com.qinshou.okhttphelper.callback.Callback;
import com.qinshou.qinshoubox.conversation.contract.ISetGroupChatNameContract;
import com.qinshou.qinshoubox.conversation.model.SetGroupChatNicknameModel;
import com.qinshou.qinshoubox.conversation.view.fragment.SetGroupChatNicknameFragment;

/**
 * Author: QinHao
 * Email:cqflqinhao@126.com
 * Date: 2019/12/09 14:01
 * Description:{@link SetGroupChatNicknameFragment} 的 P 层
 */
public class SetGroupChatNicknamePresenter extends AbsPresenter<ISetGroupChatNameContract.IView, ISetGroupChatNameContract.IModel> implements ISetGroupChatNameContract.IPresenter {
    @Override
    public ISetGroupChatNameContract.IModel initModel() {
        return new SetGroupChatNicknameModel();
    }

    @Override
    public void setGroupChatNickname(String groupChatId, String nickname) {
        getModel().setGroupChatNickname(groupChatId, nickname, new Callback<Object>() {
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