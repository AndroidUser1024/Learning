package com.qinshou.qinshoubox.me.presenter;

import com.qinshou.commonmodule.base.AbsPresenter;
import com.qinshou.qinshoubox.me.contract.ITestContract;
import com.qinshou.qinshoubox.me.model.TestModel;
import com.qinshou.qinshoubox.me.ui.fragment.TestFragment;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/11/14 13:59
 * Description:{@link TestFragment} 的 P 层
 */
public class TestPresenter extends AbsPresenter<ITestContract.IView,ITestContract.IModel> {
    @Override
    public ITestContract.IModel initModel() {
        return new TestModel();
    }
}
