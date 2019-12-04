package com.qinshou.qinshoubox.im.presenter;


import com.qinshou.commonmodule.base.AbsPresenter;
import com.qinshou.qinshoubox.im.contract.IIMContract;
import com.qinshou.qinshoubox.im.model.IMModel;
import com.qinshou.qinshoubox.im.view.fragment.IMFragment;

/**
 * Author: QinHao
 * Email:cqflqinhao@126.com
 * Date: 2019/12/04 21:49
 * Description:{@link IMFragment} 的 M 层
 */
public class IMPresenter extends AbsPresenter<IIMContract.IView, IIMContract.IModel> implements IIMContract.IPresenter {
    @Override
    public IIMContract.IModel initModel() {
        return new IMModel();
    }
}
