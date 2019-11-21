package com.qinshou.qinshoubox.friend.presenter;

import com.qinshou.commonmodule.base.AbsPresenter;
import com.qinshou.commonmodule.util.ShowLogUtil;
import com.qinshou.okhttphelper.callback.Callback;
import com.qinshou.qinshoubox.friend.contract.IFriendContract;
import com.qinshou.qinshoubox.friend.model.FriendModel;
import com.qinshou.qinshoubox.friend.view.fragment.FriendFragment;
import com.qinshou.qinshoubox.me.bean.UserBean;

import java.util.List;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/11/18 19:18
 * Description:{@link FriendFragment} 的 P 层
 */
public class FriendPresenter extends AbsPresenter<IFriendContract.IView, IFriendContract.IModel> implements IFriendContract.IPresenter {
    @Override
    public IFriendContract.IModel initModel() {
        return new FriendModel();
    }

    @Override
    public void getFriendList(int fromUserId) {
        getModel().getFriendList(fromUserId, new Callback<List<UserBean>>() {
            @Override
            public void onSuccess(List<UserBean> data) {
                if (!isViewAttached()) {
                    return;
                }
                getView().getFriendListSuccess(data);
            }

            @Override
            public void onFailure(Exception e) {
                if (!isViewAttached()) {
                    return;
                }
                getView().getFriendListFailure(e);
            }
        });
    }
}