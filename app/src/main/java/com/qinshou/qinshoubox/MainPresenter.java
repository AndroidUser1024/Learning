package com.qinshou.qinshoubox;


import com.qinshou.commonmodule.base.AbsPresenter;

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
}
