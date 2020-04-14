package com.qinshou.qinshoubox.friend.presenter;

import com.qinshou.commonmodule.base.AbsPresenter;
import com.qinshou.qinshoubox.im.bean.UserDetailBean;
import com.qinshou.qinshoubox.friend.contract.IFriendContract;
import com.qinshou.qinshoubox.friend.model.FriendModel;
import com.qinshou.qinshoubox.friend.view.fragment.FriendFragment;
import com.qinshou.qinshoubox.im.bean.GroupChatBean;
import com.qinshou.qinshoubox.im.listener.QSCallback;

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
    public void getMyGroupChatList() {
        getModel().getMyGroupChatList(new QSCallback<List<GroupChatBean>>() {
            @Override
            public void onSuccess(List<GroupChatBean> data) {
                if (!isViewAttached()) {
                    return;
                }
                getView().getMyGroupChatListSuccess(data);
            }

            @Override
            public void onFailure(Exception e) {
                if (!isViewAttached()) {
                    return;
                }
                getView().getMyGroupChatListFailure(e);
            }
        });
    }

    @Override
    public void getFriendList() {
        getModel().getFriendList(new QSCallback<List<UserDetailBean>>() {
            @Override
            public void onSuccess(List<UserDetailBean> data) {
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