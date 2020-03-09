package com.qinshou.qinshoubox.conversation.presenter;

import com.qinshou.commonmodule.base.AbsPresenter;
import com.qinshou.okhttphelper.callback.Callback;
import com.qinshou.qinshoubox.conversation.contract.IGroupChatAddMemberContract;
import com.qinshou.qinshoubox.conversation.model.GroupChatAddMemberModel;
import com.qinshou.qinshoubox.conversation.view.fragment.GroupChatAddMemberFragment;
import com.qinshou.qinshoubox.friend.bean.UserDetailBean;
import com.qinshou.qinshoubox.im.bean.FriendBean;
import com.qinshou.qinshoubox.im.listener.QSCallback;

import java.util.List;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/12/02 17:40
 * Description:{@link GroupChatAddMemberFragment} 的 P 层
 */
public class GroupChatAddMemberPresenter extends AbsPresenter<IGroupChatAddMemberContract.IView, IGroupChatAddMemberContract.IModel> implements IGroupChatAddMemberContract.IPresenter {
    @Override
    public IGroupChatAddMemberContract.IModel initModel() {
        return new GroupChatAddMemberModel();
    }

    @Override
    public void getFriendList() {
        getModel().getFriendList(new Callback<List<UserDetailBean>>() {
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

    @Override
    public void getMemberList(String groupChatId) {
        getModel().getMemberList(groupChatId, new QSCallback<List<UserDetailBean>>() {
            @Override
            public void onSuccess(List<UserDetailBean> data) {
                if (!isViewAttached()) {
                    return;
                }
                getView().getMemberListSuccess(data);
            }

            @Override
            public void onFailure(Exception e) {
                if (!isViewAttached()) {
                    return;
                }
                getView().getMemberListFailure(e);
            }
        });
    }

    @Override
    public void addMember(String groupChatId, List<String> addMemberIdList) {
        getModel().addMember(groupChatId, addMemberIdList, new Callback<Object>() {
            @Override
            public void onSuccess(Object data) {
                if (!isViewAttached()) {
                    return;
                }
                getView().addMemberSuccess();
            }

            @Override
            public void onFailure(Exception e) {
                if (!isViewAttached()) {
                    return;
                }
                getView().addMemberFailure(e);
            }
        });
    }
}