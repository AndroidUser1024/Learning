package com.qinshou.qinshoubox.demo.view.activity;


import com.qinshou.qinshoubox.base.QSActivity;
import com.qinshou.qinshoubox.demo.contract.IDemoContract;
import com.qinshou.qinshoubox.demo.presenter.DemoPresenter;
import com.qinshou.qinshoubox.homepage.bean.EventBean;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/07/11 18:26
 * Description:V 层示例
 */
public class DemoActivity extends QSActivity<DemoPresenter> implements IDemoContract.IView {
    @Override
    public int getLayoutId() {
        return 0;
//        return R.layout.layout_demo;
    }

    @Override
    public void initView() {

    }

    @Override
    public void setListener() {
        super.setListener();
    }

    @Override
    public void initData() {
        getPresenter().demoRequest();
    }

    @Override
    public void handleEvent(EventBean<Object> eventBean) {

    }

    @Override
    public void demoRequestSuccess(Object o) {

    }

    @Override
    public void demoRequestFailure(Exception e) {

    }
}