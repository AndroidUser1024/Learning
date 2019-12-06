package com.qinshou.qinshoubox.friend.presenter;


import com.qinshou.commonmodule.base.AbsPresenter;
import com.qinshou.okhttphelper.callback.Callback;
import com.qinshou.qinshoubox.friend.contract.ISetAdditionalMsgContract;
import com.qinshou.qinshoubox.friend.model.SetAdditionalMsgModel;
import com.qinshou.qinshoubox.friend.view.fragment.SetAdditionalMsgFragment;

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
        getModel().addFriend(toUserId, remark, additionalMsg, source, new Callback<Object>() {
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