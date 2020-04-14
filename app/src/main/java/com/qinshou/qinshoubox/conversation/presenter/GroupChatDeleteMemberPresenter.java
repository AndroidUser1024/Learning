package com.qinshou.qinshoubox.conversation.presenter;

import com.qinshou.commonmodule.base.AbsPresenter;
import com.qinshou.qinshoubox.conversation.contract.IGroupChatDeleteMemberContract;
import com.qinshou.qinshoubox.conversation.model.GroupChatDeleteMemberModel;
import com.qinshou.qinshoubox.conversation.view.fragment.GroupChatDeleteMemberFragment;
import com.qinshou.qinshoubox.im.bean.UserDetailBean;
import com.qinshou.qinshoubox.im.listener.QSCallback;

import java.util.List;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/12/02 17:41
 * Description:{@link GroupChatDeleteMemberFragment} 的 P 层
 */
public class GroupChatDeleteMemberPresenter extends AbsPresenter<IGroupChatDeleteMemberContract.IView, IGroupChatDeleteMemberContract.IModel> implements IGroupChatDeleteMemberContract.IPresenter {
    @Override
    public IGroupChatDeleteMemberContract.IModel initModel() {
        return new GroupChatDeleteMemberModel();
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
    public void deleteMember(String groupChatId, List<String> deleteMemberIdList) {
        getModel().deleteMember(groupChatId, deleteMemberIdList, new QSCallback<Object>() {
            @Override
            public void onSuccess(Object data) {
                if (!isViewAttached()) {
                    return;
                }
                getView().deleteMemberSuccess();
            }

            @Override
            public void onFailure(Exception e) {
                if (!isViewAttached()) {
                    return;
                }
                getView().deleteMemberFailure(e);
            }
        });
    }
}