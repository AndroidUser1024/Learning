
package com.qinshou.qinshoubox.friend.view.fragment;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.TextUtils;
import android.view.View;

import com.qinshou.commonmodule.ContainerActivity;
import com.qinshou.commonmodule.util.SharedPreferencesHelper;
import com.qinshou.commonmodule.widget.TitleBar;
import com.qinshou.qinshoubox.R;
import com.qinshou.qinshoubox.base.QSFragment;
import com.qinshou.qinshoubox.constant.IConstant;
import com.qinshou.qinshoubox.friend.bean.FriendHistoryBean;
import com.qinshou.qinshoubox.friend.contract.IFriendHistoryContract;
import com.qinshou.qinshoubox.friend.presenter.FriendHistoryPresenter;
import com.qinshou.qinshoubox.friend.view.adapter.RcvFriendHistoryAdapter;
import com.qinshou.qinshoubox.homepage.bean.EventBean;
import com.qinshou.qinshoubox.im.IMClient;
import com.qinshou.qinshoubox.im.bean.UserDetailBean;
import com.qinshou.qinshoubox.im.enums.FriendRelStatus;
import com.qinshou.qinshoubox.im.listener.IOnFriendStatusListener;
import com.qinshou.qinshoubox.util.userstatusmanager.UserStatusManager;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/08/21 14:03
 * Description:好友申请历史界面
 */
public class FriendHistoryFragment extends QSFragment<FriendHistoryPresenter> implements IFriendHistoryContract.IView {

//    private RefreshLayout mRefreshLayout;
    /**
     * 标题栏
     */
    private TitleBar mTitleBar;
    /**
     * 好友申请历史列表适配器
     */
    private RcvFriendHistoryAdapter mRcvFriendHistoryAdapter;
    private int mPage = IConstant.PAGE_START;
    private IOnFriendStatusListener mOnFriendStatusListener = new IOnFriendStatusListener() {
        @Override
        public void add(UserDetailBean fromUser, boolean newFriend) {
            getPresenter().getFriendHistory(mPage, IConstant.PAGE_SIZE);
            // 已经在当前页,查看到了好友申请,就不用保存申请历史未读数了
            String key = String.format(IConstant.SP_KEY_FRIEND_HISTORY_UNREAD_COUNT, UserStatusManager.SINGLETON.getUserBean().getId());
            SharedPreferencesHelper.SINGLETON.remove(key);
            EventBus.getDefault().post(new EventBean<>(EventBean.Type.REFRESH_FRIEND_HISTORY_UNREAD_COUNT, null));
        }

        @Override
        public void agreeAdd(UserDetailBean fromUser) {
        }

        @Override
        public void refuseAdd(UserDetailBean fromUser) {
        }

        @Override
        public void delete(UserDetailBean fromUser) {
        }

        @Override
        public void online(UserDetailBean fromUser) {
        }

        @Override
        public void offline(UserDetailBean fromUser) {
        }
    };

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        IMClient.SINGLETON.removeOnFriendStatusListener(mOnFriendStatusListener);
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_friend_history;
    }

    @Override
    public void initView() {
        mTitleBar = findViewByID(R.id.title_bar);
//        mRefreshLayout = findViewByID(R.id.refresh_layout);
        RecyclerView rcvHistoryOfFriendRequest = findViewByID(R.id.rcv_request_history);
        rcvHistoryOfFriendRequest.setLayoutManager(new LinearLayoutManager(getContext()));
        mRcvFriendHistoryAdapter = new RcvFriendHistoryAdapter(getContext());
        rcvHistoryOfFriendRequest.setAdapter(mRcvFriendHistoryAdapter);
    }

    @Override
    public void setListener() {
        IMClient.SINGLETON.addOnFriendStatusListener(mOnFriendStatusListener);
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
//        mRefreshLayout.setOnRefreshLoadMoreListener(new RefreshLayout.IOnRefreshLoadMoreListener() {
//            @Override
//            public void onRefresh(RefreshLayout refreshLayout) {
//                mPage = IConstant.PAGE_START;
//                getPresenter().getFriendHistory(mPage, IConstant.PAGE_SIZE);
//            }
//
//            @Override
//            public void onLoadMore(RefreshLayout refreshLayout) {
//                mPage++;
//                getPresenter().getFriendHistory(mPage, IConstant.PAGE_SIZE);
//            }
//        });
    }

    @Override
    public void initData() {
        getPresenter().getFriendHistory(mPage, IConstant.PAGE_SIZE);
    }

    @Override
    public void handleEvent(EventBean<Object> eventBean) {
    }

    @Override
    public void getFriendHistorySuccess(List<FriendHistoryBean> friendHistoryBeanList) {
        mRcvFriendHistoryAdapter.addDataList(friendHistoryBeanList, mPage == IConstant.PAGE_START);
//        mRefreshLayout.stopRefreshAndLoadMore();
    }

    @Override
    public void getFriendHistoryFailure(Exception e) {

    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void receiveEvent(EventBean<Object> eventBean) {
        if (eventBean.getType() == EventBean.Type.REFRESH_FRIEND_LIST && eventBean.getData() instanceof String) {
            for (int i = 0; i < mRcvFriendHistoryAdapter.getDataList().size(); i++) {
                FriendHistoryBean friendHistoryBean = mRcvFriendHistoryAdapter.getDataList().get(i);
                if (TextUtils.equals((String) eventBean.getData(), friendHistoryBean.getFromUserId())) {
                    friendHistoryBean.setStatus(FriendRelStatus.BOTH.getValue());
                    mRcvFriendHistoryAdapter.notifyItemChanged(i);
                    break;
                }
            }
        }
    }

}