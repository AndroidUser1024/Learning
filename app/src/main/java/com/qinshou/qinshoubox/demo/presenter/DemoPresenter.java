package com.qinshou.qinshoubox.demo.presenter;


import com.qinshou.networkmodule.callback.Callback;
import com.qinshou.commonmodule.base.AbsPresenter;
import com.qinshou.qinshoubox.demo.contract.IDemoContract;
import com.qinshou.qinshoubox.demo.model.DemoModel;
import com.qinshou.qinshoubox.demo.view.activity.DemoActivity;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/07/11 18:26
 * Description:{@link DemoActivity} 的 P 层
 * P 层示例
 */
public class DemoPresenter extends AbsPresenter<IDemoContract.IView, IDemoContract.IModel> implements IDemoContract.IPresenter {
    @Override
    public IDemoContract.IModel initModel() {
        return new DemoModel();
    }

    @Override
    public void demoRequest() {
        getModel().demoRequest(new Callback<Object>() {
            @Override
            public void onSuccess(Object o) {
                if (!isViewAttached()) {
                    return;
                }
                getView().demoRequestSuccess(o);
            }

            @Override
            public void onFailure(Exception e) {
                if (!isViewAttached()) {
                    return;
                }
                getView().demoRequestFailure(e);
            }
        });
    }
}