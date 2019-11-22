package com.qinshou.qinshoubox.friend.presenter;


import com.qinshou.commonmodule.base.AbsPresenter;
import com.qinshou.okhttphelper.callback.Callback;
import com.qinshou.qinshoubox.friend.contract.IUserDetailContract;
import com.qinshou.qinshoubox.friend.model.UserDetailModel;
import com.qinshou.qinshoubox.friend.view.fragment.UserDetailFragment;
import com.qinshou.immodule.bean.UserBean;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/11/11 20:08
 * Description:{@link UserDetailFragment} 的 P 层
 */
public class UserDetailPresenter extends AbsPresenter<IUserDetailContract.IView, IUserDetailContract.IModel> implements IUserDetailContract.IPresenter {
    @Override
    public IUserDetailContract.IModel initModel() {
        return new UserDetailModel();
    }

    @Override
    public void getUserDetail(final int userId, String keyword) {
        getModel().getUserDetail(userId, keyword, new Callback<UserBean>() {
            @Override
            public void onSuccess(UserBean data) {
                if (!isViewAttached()) {
                    return;
                }
                if (data.getFriendStatus() == 1) {
                    getView().showFriendUI(data);
                } else {
                    if (data.getReceive() == 1) {
                        getView().showWaitAcceptUI(data);
                    } else {
                        getView().showNotFriendUI(data);
                    }
                }
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

    @Override
    public void agreeAddFriend(int fromUserId, int toUserId, String remark) {
        getModel().agreeAddFriend(fromUserId, toUserId, remark, new Callback<UserBean>() {
            @Override
            public void onSuccess(UserBean data) {
                if (!isViewAttached()) {
                    return;
                }
                getView().agreeAddFriendSuccess(data);
            }

            @Override
            public void onFailure(Exception e) {
                if (!isViewAttached()) {
                    return;
                }
                getView().agreeAddFriendFailure(e);
            }
        });
    }
}