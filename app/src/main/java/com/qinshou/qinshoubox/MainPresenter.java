package com.qinshou.qinshoubox;


import com.qinshou.commonmodule.base.AbsPresenter;
import com.qinshou.networkmodule.callback.Callback;
import com.qinshou.qinshoubox.login.bean.UserBean;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/6/11 10:03
 * Description:{@link MainActivity} 的 P 层
 */
public class MainPresenter extends AbsPresenter<IMainContract.IView, IMainContract.IModel> implements IMainContract.IPresenter {
    @Override
    public IMainContract.IModel initModel() {
        return new MainModel();
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
}
