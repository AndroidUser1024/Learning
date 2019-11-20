package com.qinshou.qinshoubox.friend.presenter;


import com.qinshou.commonmodule.base.AbsPresenter;
import com.qinshou.okhttphelper.callback.Callback;
import com.qinshou.qinshoubox.friend.contract.ISetAdditionalMessageContract;
import com.qinshou.qinshoubox.friend.model.SetAdditionalMessageModel;
import com.qinshou.qinshoubox.friend.view.fragment.SetAdditionalMessageFragment;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/09/12 10:01
 * Description:{@link SetAdditionalMessageFragment} 的 P 层
 */
public class SetAdditionalMessagePresenter extends AbsPresenter<ISetAdditionalMessageContract.IView, ISetAdditionalMessageContract.IModel> implements ISetAdditionalMessageContract.IPresenter {
    @Override
    public ISetAdditionalMessageContract.IModel initModel() {
        return new SetAdditionalMessageModel();
    }

    @Override
    public void addFriend(int fromUserId, int toUserId, String remark, String additionalMessage, int source) {
        getModel().addFriend(fromUserId, toUserId, remark, additionalMessage, source, new Callback<Object>() {
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