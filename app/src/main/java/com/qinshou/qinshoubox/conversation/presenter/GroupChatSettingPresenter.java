package com.qinshou.qinshoubox.conversation.presenter;

import com.qinshou.commonmodule.base.AbsPresenter;
import com.qinshou.qinshoubox.im.bean.GroupChatDetailBean;
import com.qinshou.qinshoubox.conversation.contract.IGroupChatSettingContract;
import com.qinshou.qinshoubox.conversation.model.GroupChatSettingModel;
import com.qinshou.qinshoubox.conversation.view.fragment.GroupChatSettingFragment;
import com.qinshou.qinshoubox.im.listener.QSCallback;


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
        getModel().getGroupChatDetail(groupChatId, new QSCallback<GroupChatDetailBean>() {
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
    public void setTop(String groupChatId, int top) {
        getModel().setTop(groupChatId, top, new QSCallback<Object>() {
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
    public void setDoNotDisturb(String groupChatId, int doNotDisturb) {
        getModel().setDoNotDisturb(groupChatId, doNotDisturb, new QSCallback<Object>() {
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
    public void setShowGroupChatMemberNickname(String groupChatId, int showGroupChatMemberNickname) {
        getModel().setShowGroupChatMemberNickname(groupChatId, showGroupChatMemberNickname, new QSCallback<Object>() {
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
    public void exit(String groupChatId) {
        getModel().exit(groupChatId, new QSCallback<Object>() {
            @Override
            public void onSuccess(Object data) {
                if (!isViewAttached()) {
                    return;
                }
                getView().exitSuccess();
            }

            @Override
            public void onFailure(Exception e) {
                if (!isViewAttached()) {
                    return;
                }
                getView().exitFailure(e);
            }
        });
    }

}