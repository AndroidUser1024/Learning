package com.qinshou.qinshoubox.friend.presenter;


import com.qinshou.commonmodule.base.AbsPresenter;
import com.qinshou.qinshoubox.friend.contract.ISetAdditionalMsgContract;
import com.qinshou.qinshoubox.friend.model.SetAdditionalMsgModel;
import com.qinshou.qinshoubox.friend.view.fragment.SetAdditionalMsgFragment;
import com.qinshou.qinshoubox.im.listener.QSCallback;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/09/12 10:01
 * Description:{@link SetAdditionalMsgFragment} 的 P 层
 */
public class SetAdditionalMsgPresenter extends AbsPresenter<ISetAdditionalMsgContract.IView, ISetAdditionalMsgContract.IModel> implements ISetAdditionalMsgContract.IPresenter {
    @Override
    public ISetAdditionalMsgContract.IModel initModel() {
        return new SetAdditionalMsgModel();
    }

    @Override
    public void addFriend(String toUserId, String remark, String additionalMsg, int source) {
        getModel().addFriend(toUserId, remark, additionalMsg, source, new QSCallback<Object>() {
            @Override
            public void onSuccess(Object data) {
                if (!isViewAttached()) {
                    return;
                }
                getView().addFriendSuccess();
            }

            @Override
            public void onFailure(Exception e) {
                if (!isViewAttached()) {
                    return;
                }
                getView().addFriendFailure(e);
            }
        });
    }
}