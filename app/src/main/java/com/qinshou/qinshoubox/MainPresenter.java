package com.qinshou.qinshoubox;

import com.qinshou.commonmodule.base.AbsBasePresenter;

/**
 * Description:{@link MainActivity} 的 Presenter
 * Author: QinHao
 * Date: 2019/4/4 14:38
 */
public class MainPresenter extends AbsBasePresenter<IMainContract.IMainView, IMainContract.IMainModel> implements IMainContract.IMainPresenter {
    @Override
    public IMainContract.IMainModel initModel() {
        return new MainModel();
    }
}
