package com.qinshou.qinshoubox.demo.contract;


import com.qinshou.commonmodule.base.IBaseModel;
import com.qinshou.commonmodule.base.IBaseView;
import com.qinshou.okhttphelper.callback.Callback;
import com.qinshou.qinshoubox.demo.view.activity.DemoActivity;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/07/11 18:26
 * Description:{@link DemoActivity} 的契约类
 * 契约层示例
 */
public interface IDemoContract {
    interface IModel extends IBaseModel {
        void demoRequest(Callback<Object> callback);
    }

    interface IView extends IBaseView {
        void demoRequestSuccess(Object o);

        void demoRequestFailure(Exception e);
    }

    interface IPresenter {
        void demoRequest();
    }
}