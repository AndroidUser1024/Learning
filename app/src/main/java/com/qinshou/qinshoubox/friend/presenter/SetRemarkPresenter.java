package com.qinshou.qinshoubox.friend.presenter;


import com.qinshou.commonmodule.base.AbsPresenter;
import com.qinshou.qinshoubox.friend.contract.ISetRemarkContract;
import com.qinshou.qinshoubox.friend.model.SetRemarkModel;
import com.qinshou.qinshoubox.friend.view.activity.SetRemarkActivity;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/09/05 19:53
 * Description:{@link SetRemarkActivity} 的 P 层
 */
public class SetRemarkPresenter extends AbsPresenter<ISetRemarkContract.IView, ISetRemarkContract.IModel> implements ISetRemarkContract.IPresenter {
    @Override
    public ISetRemarkContract.IModel initModel() {
        return new SetRemarkModel();
    }
}