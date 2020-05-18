package com.qinshou.qinshoubox.login.presenter;

import com.qinshou.networkmodule.callback.Callback;
import com.qinshou.commonmodule.base.AbsPresenter;
import com.qinshou.qinshoubox.login.bean.PoemBean;
import com.qinshou.qinshoubox.login.bean.UserBean;
import com.qinshou.qinshoubox.login.contract.ISplashContract;
import com.qinshou.qinshoubox.login.model.SplashModel;
import com.qinshou.qinshoubox.login.view.activity.SplashActivity;

/**
 * Description:{@link SplashActivity} 的 Presenter
 * Author: QinHao
 * Date: 2019/4/4 14:38
 */
public class SplashPresenter extends AbsPresenter<ISplashContract.ISplashView, ISplashContract.ISplashModel> implements ISplashContract.ISplashPresenter {
    @Override
    public ISplashContract.ISplashModel initModel() {
        return new SplashModel();
    }

    @Override
    public void getRandomPoem() {
        getModel().getRandomPoem(new Callback<PoemBean>() {
            @Override
            public void onSuccess(PoemBean data) {
                if (!isViewAttached()) {
                    return;
                }
                getView().getRandomSuccess(data);
            }

            @Override
            public void onFailure(Exception e) {
                if (!isViewAttached()) {
                    return;
                }
                getView().getRandomFailure(e);
            }
        });
    }
}
