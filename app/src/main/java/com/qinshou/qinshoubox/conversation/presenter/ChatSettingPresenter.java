package com.qinshou.qinshoubox.conversation.presenter;

import com.qinshou.commonmodule.base.AbsPresenter;
import com.qinshou.okhttphelper.callback.Callback;
import com.qinshou.qinshoubox.conversation.contract.IChatSettingContract;
import com.qinshou.qinshoubox.conversation.model.ChatSettingModel;
import com.qinshou.qinshoubox.conversation.view.fragment.ChatSettingFragment;
import com.qinshou.qinshoubox.im.bean.UserDetailBean;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/09/03 15:05
 * Description:{@link ChatSettingFragment} 的 P 层
 */
public class ChatSettingPresenter extends AbsPresenter<IChatSettingContract.IView, IChatSettingContract.IModel> implements IChatSettingContract.IPresenter {
    @Override
    public IChatSettingContract.IModel initModel() {
        return new ChatSettingModel();
    }

    @Override
    public void getFriend(String id) {
        getModel().getFriend(id, new Callback<UserDetailBean>() {
            @Override
            public void onSuccess(UserDetailBean data) {
                if (!isViewAttached()) {
                    return;
                }
                getView().getFriendSuccess(data);
            }

            @Override
            public void onFailure(Exception e) {
                if (!isViewAttached()) {
                    return;
                }
                getView().getFriendFailure(e);
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
    public void setBlackList(String toUserId, int blackList) {
        getModel().setBlackList(toUserId, blackList, new Callback<Object>() {
            @Override
            public void onSuccess(Object data) {
                if (!isViewAttached()) {
                    return;
                }
                getView().setBlackListSuccess();
            }

            @Override
            public void onFailure(Exception e) {
                if (!isViewAttached()) {
                    return;
                }
                getView().setBlackListFailure(e);
            }
        });
    }
}