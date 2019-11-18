package com.qinshou.qinshoubox.me.presenter;


import com.qinshou.commonmodule.base.AbsPresenter;
import com.qinshou.qinshoubox.me.contract.IMyQRCodeContract;
import com.qinshou.qinshoubox.me.model.MyQRCodeModel;
import com.qinshou.qinshoubox.me.ui.fragment.MyQRCodeFragment;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/09/19 16:22
 * Description:{@link MyQRCodeFragment} 的 P 层
 */
public class MyQRCodePresenter extends AbsPresenter<IMyQRCodeContract.IView, IMyQRCodeContract.IModel> implements IMyQRCodeContract.IPresenter {
    @Override
    public IMyQRCodeContract.IModel initModel() {
        return new MyQRCodeModel();
    }
}