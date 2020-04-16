package com.qinshou.qinshoubox.me.presenter;


import com.qinshou.commonmodule.base.AbsPresenter;
import com.qinshou.qinshoubox.me.contract.IMagicTowerContract;
import com.qinshou.qinshoubox.me.model.MagicTowerModel;
import com.qinshou.qinshoubox.me.ui.fragment.MagicTowerFragment;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/10/8 17:53
 * Description:{@link MagicTowerFragment} 的 P 层
 */
public class MagicTowerPresenter extends AbsPresenter<IMagicTowerContract.IView, IMagicTowerContract.IModel> implements IMagicTowerContract.IPresenter {
    @Override
    public IMagicTowerContract.IModel initModel() {
        return new MagicTowerModel();
    }
}
