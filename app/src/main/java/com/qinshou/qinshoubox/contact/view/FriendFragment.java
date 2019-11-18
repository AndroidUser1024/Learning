package com.qinshou.qinshoubox.contact.view;

import com.qinshou.qinshoubox.R;
import com.qinshou.qinshoubox.base.QSFragment;
import com.qinshou.qinshoubox.contact.contract.IFriendContract;
import com.qinshou.qinshoubox.contact.presenter.FriendPresenter;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/11/18 19:18
 * Description:联系人界面
 */
public class FriendFragment extends QSFragment<FriendPresenter> implements IFriendContract.IView {
    @Override
    public int getLayoutId() {
        return R.layout.fragment_friend;
    }

    @Override
    public void initView() {

    }

    @Override
    public void setListener() {

    }

    @Override
    public void initData() {

    }
}