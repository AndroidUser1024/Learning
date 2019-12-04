package com.qinshou.qinshoubox.friend.presenter;


import com.qinshou.commonmodule.base.AbsPresenter;
import com.qinshou.okhttphelper.callback.Callback;
import com.qinshou.qinshoubox.friend.contract.IAddFriendContract;
import com.qinshou.qinshoubox.friend.model.AddFriendModel;
import com.qinshou.qinshoubox.friend.view.fragment.AddFriendFragment;
import com.qinshou.qinshoubox.login.bean.UserBean;

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
    public void getUserDetail(String userId,String keyword) {
        getModel().getUserDetail(userId,keyword, new Callback<UserBean>() {
            @Override
            public void onSuccess(UserBean userBean) {
                if (!isViewAttached()) {
                    return;
                }
                getView().getUserDetailSuccess(userBean);
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