package com.qinshou.qinshoubox.friend.presenter;

import com.qinshou.commonmodule.base.AbsPresenter;
import com.qinshou.okhttphelper.callback.Callback;
import com.qinshou.qinshoubox.friend.contract.ICreateGroupChatContract;
import com.qinshou.qinshoubox.friend.model.CreateGroupChatModel;
import com.qinshou.qinshoubox.friend.view.fragment.CreateGroupChatFragment;
import com.qinshou.qinshoubox.im.bean.FriendBean;
import com.qinshou.qinshoubox.im.bean.GroupChatBean;
import com.qinshou.qinshoubox.im.bean.UserBean;
import com.qinshou.qinshoubox.im.listener.QSCallback;

import java.util.List;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/08/19 17:27
 * Description:{@link CreateGroupChatFragment} 的 P 层
 */
public class CreateGroupChatPresenter extends AbsPresenter<ICreateGroupChatContract.IView, ICreateGroupChatContract.IModel> implements ICreateGroupChatContract.IPresenter {
    @Override
    public ICreateGroupChatContract.IModel initModel() {
        return new CreateGroupChatModel();
    }

    @Override
    public void getFriendList(int fromUserId) {
        getModel().getFriendList(fromUserId, new QSCallback<List<FriendBean>>() {
            @Override
            public void onSuccess(List<FriendBean> data) {
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

    @Override
    public void createGroupChat(int ownerId, List<Integer> memberIdList, String nickname, String headImg) {
        getModel().createGroupChat(ownerId, memberIdList, nickname, headImg, new Callback<GroupChatBean>() {
            @Override
            public void onSuccess(GroupChatBean data) {
                if (!isViewAttached()) {
                    return;
                }
                getView().createGroupChatSuccess(data);
            }

            @Override
            public void onFailure(Exception e) {
                if (!isViewAttached()) {
                    return;
                }
                getView().createGroupChatFailure(e);
            }
        });
    }
}