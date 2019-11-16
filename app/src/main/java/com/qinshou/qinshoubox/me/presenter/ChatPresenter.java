package com.qinshou.qinshoubox.me.presenter;


import com.qinshou.commonmodule.base.AbsPresenter;
import com.qinshou.okhttphelper.callback.Callback;
import com.qinshou.qinshoubox.me.bean.UserBean;
import com.qinshou.qinshoubox.me.contract.IChatContract;
import com.qinshou.qinshoubox.me.model.ChatModel;
import com.qinshou.qinshoubox.me.ui.activity.ChatActivity;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/06/20 10:26
 * Description:{@link ChatActivity} 的 P 层
 */
public class ChatPresenter extends AbsPresenter<IChatContract.IView, IChatContract.IModel> implements IChatContract.IPresenter {
    @Override
    public IChatContract.IModel initModel() {
        return new ChatModel();
    }

    @Override
    public void getUserInfo(String username) {
        getModel().getUserInfo(username, new Callback<UserBean>() {
            @Override
            public void onSuccess(UserBean userBean) {
                if (!isViewAttached()) {
                    return;
                }
                getView().getUserInfoSuccess(userBean);
            }

            @Override
            public void onFailure(Exception e) {
                if (!isViewAttached()) {
                    return;
                }
                getView().getUserInfoFailure(e);
            }
        });
    }
}