package com.qinshou.qinshoubox.conversation.presenter;

import com.qinshou.commonmodule.base.AbsPresenter;
import com.qinshou.okhttphelper.callback.Callback;
import com.qinshou.qinshoubox.conversation.bean.GroupChatDetailBean;
import com.qinshou.qinshoubox.conversation.contract.IGroupChatSettingContract;
import com.qinshou.qinshoubox.conversation.model.GroupChatSettingModel;
import com.qinshou.qinshoubox.conversation.view.fragment.GroupChatSettingFragment;
import com.qinshou.qinshoubox.im.bean.GroupChatBean;


/**
 * Author：WangGuifa
 * Email：wangguifa@jeejio.com
 * Date：2019/9/10 15:14
 * Description：{@link GroupChatSettingFragment} 的 P 层
 */
public class GroupChatSettingPresenter extends AbsPresenter<IGroupChatSettingContract.IView, IGroupChatSettingContract.IModel> implements IGroupChatSettingContract.IPresenter {
    @Override
    public IGroupChatSettingContract.IModel initModel() {
        return new GroupChatSettingModel();
    }

    @Override
    public void getGroupChatDetail(String groupChatId) {
        getModel().getGroupChatDetail(groupChatId, new Callback<GroupChatDetailBean>() {
            @Override
            public void onSuccess(GroupChatDetailBean data) {
                if (!isViewAttached()) {
                    return;
                }
                getView().getGroupChatDetailSuccess(data);
            }

            @Override
            public void onFailure(Exception e) {
                if (!isViewAttached()) {
                    return;
                }
                getView().getGroupChatDetailFailure(e);
            }
        });
    }

    @Override
    public void setTop(String toUserId, int top) {
        getModel().setTop(toUserId, top, new Callback<Object>() {
            @Override
            public void onSuccess(Object data) {
                if (!isViewAttached()) {
                    return;
                }
                getView().setTopSuccess();
            }

            @Override
            public void onFailure(Exception e) {
                if (!isViewAttached()) {
                    return;
                }
                getView().setTopFailure(e);
            }
        });
    }

    @Override
    public void setDoNotDisturb(String toUserId, int doNotDisturb) {
        getModel().setDoNotDisturb(toUserId, doNotDisturb, new Callback<Object>() {
            @Override
            public void onSuccess(Object data) {
                if (!isViewAttached()) {
                    return;
                }
                getView().setDoNotDisturbSuccess();
            }

            @Override
            public void onFailure(Exception e) {
                if (!isViewAttached()) {
                    return;
                }
                getView().setDoNotDisturbFailure(e);
            }
        });
    }

    @Override
    public void setShowGroupChatMemberNickname(String toUserId, int showGroupChatMemberNickname) {
        getModel().setShowGroupChatMemberNickname(toUserId, showGroupChatMemberNickname, new Callback<Object>() {
            @Override
            public void onSuccess(Object data) {
                if (!isViewAttached()) {
                    return;
                }
                getView().setDoNotDisturbSuccess();
            }

            @Override
            public void onFailure(Exception e) {
                if (!isViewAttached()) {
                    return;
                }
                getView().setDoNotDisturbFailure(e);
            }
        });
    }

}