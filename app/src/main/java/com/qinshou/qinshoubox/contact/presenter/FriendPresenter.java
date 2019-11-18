package com.qinshou.qinshoubox.contact.presenter;

import com.qinshou.commonmodule.base.AbsPresenter;
import com.qinshou.qinshoubox.contact.contract.IFriendContract;
import com.qinshou.qinshoubox.contact.model.FriendModel;
import com.qinshou.qinshoubox.contact.view.FriendFragment;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/11/18 19:18
 * Description:{@link FriendFragment} 的 P 层
 */
public class FriendPresenter extends AbsPresenter<IFriendContract.IView, IFriendContract.IModel> implements IFriendContract.IPresenter {    @Override
    public IFriendContract.IModel initModel() {
        return new FriendModel();
    }
}