package com.qinshou.qinshoubox.conversation.presenter;

import com.qinshou.commonmodule.base.AbsPresenter;
import com.qinshou.qinshoubox.conversation.contract.IGroupChatAddMemberContract;
import com.qinshou.qinshoubox.conversation.model.GroupChatAddMemberModel;
import com.qinshou.qinshoubox.conversation.view.fragment.GroupChatAddMemberFragment;
import com.qinshou.qinshoubox.im.bean.FriendBean;
import com.qinshou.qinshoubox.login.bean.UserBean;
import com.qinshou.immodule.listener.QSCallback;

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
    public void getMemberList(int groupChatId) {
        getModel().getMemberList(groupChatId, new QSCallback<List<UserBean>>() {
            @Override
            public void onSuccess(List<UserBean> data) {
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
    public void getFriendList() {
        getModel().getFriendList(new QSCallback<List<FriendBean>>() {
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
    public void addMember(int groupChatId, List<Integer> addMemberIdList) {
        getModel().addMember(groupChatId, addMemberIdList, new QSCallback<Object>() {
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