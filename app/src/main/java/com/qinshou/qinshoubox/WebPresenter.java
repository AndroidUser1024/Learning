package com.qinshou.qinshoubox;

import com.qinshou.commonmodule.base.AbsPresenter;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/11/28 8:53
 * Description:{@link WebActivity} 的 P 层
 */
public class WebPresenter extends AbsPresenter<IWebContract.IView, IWebContract.IModel> implements IWebContract.IPresenter {
    @Override
    public IWebContract.IModel initModel() {
        return new WebModel();
    }
}
