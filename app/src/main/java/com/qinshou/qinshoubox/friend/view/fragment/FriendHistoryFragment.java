
package com.qinshou.qinshoubox.friend.view.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.qinshou.commonmodule.ContainerActivity;
import com.qinshou.commonmodule.rcvdecoration.DividerDecoration;
import com.qinshou.commonmodule.rcvdecoration.StickyDecoration;
import com.qinshou.commonmodule.util.SharedPreferencesHelper;
import com.qinshou.commonmodule.widget.TitleBar;
import com.qinshou.qinshoubox.R;
import com.qinshou.qinshoubox.base.QSFragment;
import com.qinshou.qinshoubox.constant.IConstant;
import com.qinshou.qinshoubox.friend.bean.FriendHistoryBean;
import com.qinshou.qinshoubox.friend.contract.IFriendHistoryContract;
import com.qinshou.qinshoubox.friend.presenter.FriendHistoryPresenter;
import com.qinshou.qinshoubox.friend.view.adapter.RcvFriendHistoryAdapter;
import com.qinshou.qinshoubox.util.userstatusmanager.UserStatusManager;

import java.util.List;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/08/21 14:03
 * Description:好友申请历史界面
 */
public class FriendHistoryFragment extends QSFragment<FriendHistoryPresenter> implements IFriendHistoryContract.IView {
    /**
     * 标题栏
     */
    private TitleBar mTitleBar;
    /**
     * 好友申请历史列表适配器
     */
    private RcvFriendHistoryAdapter mRcvFriendHistoryAdapter;
    private int mPage = IConstant.PAGE_START;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_friend_history;
    }

    @Override
    public void initView() {
        mTitleBar = findViewByID(R.id.title_bar);
        RecyclerView rcvHistoryOfFriendRequest = findViewByID(R.id.rcv_request_history);
        rcvHistoryOfFriendRequest.setLayoutManager(new LinearLayoutManager(getContext()));
        mRcvFriendHistoryAdapter = new RcvFriendHistoryAdapter(getContext());
        rcvHistoryOfFriendRequest.setAdapter(mRcvFriendHistoryAdapter);
    }

    @Override
    public void setListener() {
        mTitleBar.setLeftTextOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        mTitleBar.setRightTextOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(ContainerActivity.getJumpIntent(getContext(), AddFriendFragment.class));
            }
        });
    }

    @Override
    public void initData() {
//        getPresenter().getFriendHistory(mPage, IConstant.PAGE_SIZE, UserStatusManager.SINGLETON.getUserBean().getId());
    }

    @Override
    public void getFriendHistorySuccess(List<FriendHistoryBean> friendHistoryBeanList) {
        mRcvFriendHistoryAdapter.addDataList(friendHistoryBeanList);
    }

    @Override
    public void getFriendHistoryFailure(Exception e) {

    }
}