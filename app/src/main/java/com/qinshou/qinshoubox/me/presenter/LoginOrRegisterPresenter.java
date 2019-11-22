package com.qinshou.qinshoubox.me.presenter;

import com.qinshou.commonmodule.base.AbsPresenter;
import com.qinshou.okhttphelper.callback.Callback;
import com.qinshou.immodule.bean.UserBean;
import com.qinshou.qinshoubox.me.contract.ILoginOrRegisterContract;
import com.qinshou.qinshoubox.me.model.LoginOrRegisterModel;
import com.qinshou.qinshoubox.me.ui.fragment.LoginOrRegisterFragment;

/**
 * Description:{@link LoginOrRegisterFragment} 的 Presenter 层
 * Author: QinHao
 * Date: 2019/5/5 17:16
 */
public class LoginOrRegisterPresenter extends AbsPresenter<ILoginOrRegisterContract.IView, ILoginOrRegisterContract.IModel> implements ILoginOrRegisterContract.IPresenter {
    @Override
    public ILoginOrRegisterContract.IModel initModel() {
        return new LoginOrRegisterModel();
    }

    @Override
    public void login(String username, String password) {
        getModel().login(username, password, new Callback<UserBean>() {
            @Override
            public void onSuccess(UserBean data) {
                if (!isViewAttached()) {
                    return;
                }
                getView().loginSuccess(data);
            }

            @Override
            public void onFailure(Exception e) {
                if (!isViewAttached()) {
                    return;
                }
                getView().loginFailure(e);
            }
        });
    }

    @Override
    public void register(String username, String password) {
        getModel().register(username, password, new Callback<UserBean>() {
            @Override
            public void onSuccess(UserBean data) {
                if (!isViewAttached()) {
                    return;
                }
                getView().registerSuccess(data);
            }

            @Override
            public void onFailure(Exception e) {
                if (!isViewAttached()) {
                    return;
                }
                getView().registerFailure(e);
            }
        });
    }
}
