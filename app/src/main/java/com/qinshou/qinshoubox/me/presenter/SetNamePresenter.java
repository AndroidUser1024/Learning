package com.qinshou.qinshoubox.me.presenter;


import com.jeejio.networkmodule.callback.Callback;
import com.qinshou.commonmodule.base.AbsPresenter;
import com.qinshou.qinshoubox.login.bean.UserBean;
import com.qinshou.qinshoubox.me.contract.ISetNameContract;
import com.qinshou.qinshoubox.me.model.SetNameModel;
import com.qinshou.qinshoubox.me.ui.fragment.SetNameFragment;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/11/13 14:36
 * Description:{@link SetNameFragment} 的 P 层
 */
public class SetNamePresenter extends AbsPresenter<ISetNameContract.IView, ISetNameContract.IModel> implements ISetNameContract.IPresenter {
    @Override
    public ISetNameContract.IModel initModel() {
        return new SetNameModel();
    }

    @Override
    public void setUserInfo(String userId, final String nickname) {
        getModel().setUserInfo(userId, nickname, new Callback<UserBean>() {
            @Override
            public void onSuccess(UserBean userBean) {
                if (!isViewAttached()) {
                    return;
                }
                getView().setUserInfoSuccess(userBean);
            }

            @Override
            public void onFailure(Exception e) {

                if (!isViewAttached()) {
                    return;
                }
                getView().setUserInfoFailure(e);
            }
        });
    }
}