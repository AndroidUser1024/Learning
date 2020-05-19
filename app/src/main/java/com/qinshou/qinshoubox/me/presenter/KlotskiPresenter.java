package com.qinshou.qinshoubox.me.presenter;

import com.qinshou.commonmodule.base.AbsPresenter;
import com.qinshou.qinshoubox.me.contract.IKlotskiContract;
import com.qinshou.qinshoubox.me.model.KlotskiModel;
import com.qinshou.qinshoubox.me.ui.fragment.KlotskiFragment;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2020/05/18 17:55
 * Description:{@link KlotskiFragment} 的 P 层
 */
public class KlotskiPresenter extends AbsPresenter<IKlotskiContract.IView, IKlotskiContract.IModel> implements IKlotskiContract.IPresenter {    @Override
    public IKlotskiContract.IModel initModel() {
        return new KlotskiModel();
    }
}