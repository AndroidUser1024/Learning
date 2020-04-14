package com.qinshou.qinshoubox.friend.presenter;


import com.qinshou.commonmodule.base.AbsPresenter;
import com.qinshou.qinshoubox.friend.contract.IAddFriendContract;
import com.qinshou.qinshoubox.friend.model.AddFriendModel;
import com.qinshou.qinshoubox.friend.view.fragment.AddFriendFragment;
import com.qinshou.qinshoubox.im.bean.UserDetailBean;
import com.qinshou.qinshoubox.im.listener.QSCallback;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/08/21 14:25
 * Description:{@link AddFriendFragment} 的 P 层
 */
public class AddFriendPresenter extends AbsPresenter<IAddFriendContract.IView, IAddFriendContract.IModel> implements IAddFriendContract.IPresenter {
    @Override
    public IAddFriendContract.IModel initModel() {
        return new AddFriendModel();
    }

    @Override
    public void getUserDetail(String keyword) {
        getModel().getUserDetail(keyword, new QSCallback<UserDetailBean>() {
            @Override
            public void onSuccess(UserDetailBean userDetailBean) {
                if (!isViewAttached()) {
                    return;
                }
                getView().getUserDetailSuccess(userDetailBean);
            }

            @Override
            public void onFailure(Exception e) {
                if (!isViewAttached()) {
                    return;
                }
                getView().getUserDetailFailure(e);
            }
        });
    }
}