package com.qinshou.qinshoubox.demo.view.fragment;

import com.qinshou.qinshoubox.R;
import com.qinshou.qinshoubox.base.QSFragment;
import com.qinshou.qinshoubox.demo.contract.IDemoContract;
import com.qinshou.qinshoubox.demo.presenter.DemoPresenter;
import com.qinshou.qinshoubox.homepage.bean.EventBean;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/11/25 18:55
 * Description:类描述
 */
public class DemoFragment extends QSFragment<DemoPresenter> implements IDemoContract.IView {
    @Override
    public int getLayoutId() {
        return R.layout.fragment_demo;
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
