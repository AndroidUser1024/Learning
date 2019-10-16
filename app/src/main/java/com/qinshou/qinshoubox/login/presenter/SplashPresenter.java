package com.qinshou.qinshoubox.login.presenter;

import com.qinshou.commonmodule.base.AbsPresenter;
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
}
