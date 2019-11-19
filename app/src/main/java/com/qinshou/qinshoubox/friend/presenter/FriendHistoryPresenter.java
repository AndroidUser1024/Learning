package com.qinshou.qinshoubox.friend.presenter;


import com.qinshou.commonmodule.base.AbsPresenter;
import com.qinshou.okhttphelper.callback.Callback;
import com.qinshou.qinshoubox.friend.bean.FriendHistoryBean;
import com.qinshou.qinshoubox.friend.contract.IFriendHistoryContract;
import com.qinshou.qinshoubox.friend.model.FriendHistoryModel;

import java.util.List;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/08/21 14:03
 * Description:{@link FriendHistoryFragment} 的 P 层
 */
public class FriendHistoryPresenter extends AbsPresenter<IFriendHistoryContract.IView, IFriendHistoryContract.IModel> implements IFriendHistoryContract.IPresenter {
    @Override
    public IFriendHistoryContract.IModel initModel() {
        return new FriendHistoryModel();
    }

    @Override
    public void getFriendHistory() {
        getModel().getFriendHistory(new Callback<List<FriendHistoryBean>>() {
            @Override
            public void onSuccess(List<FriendHistoryBean> data) {
                if (!isViewAttached()) {
                    return;
                }
            }

            @Override
            public void onFailure(Exception e) {
                if (!isViewAttached()) {
                    return;
                }
            }
        });
    }
}