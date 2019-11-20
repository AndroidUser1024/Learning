package com.qinshou.qinshoubox.friend.view.fragment;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.qinshou.commonmodule.adapter.VpSingleViewAdapter;
import com.qinshou.commonmodule.util.ShowLogUtil;
import com.qinshou.qinshoubox.R;
import com.qinshou.qinshoubox.base.QSFragment;
import com.qinshou.qinshoubox.friend.contract.IFriendContract;
import com.qinshou.qinshoubox.friend.presenter.FriendPresenter;
import com.qinshou.qinshoubox.friend.view.adapter.RcvFriendAdapter;
import com.qinshou.qinshoubox.me.bean.UserBean;
import com.qinshou.qinshoubox.util.userstatusmanager.UserStatusManager;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/11/18 19:18
 * Description:联系人界面
 */
public class FriendFragment extends QSFragment<FriendPresenter> implements IFriendContract.IView {

    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private List<RecyclerView> mRecyclerViewList = new ArrayList<>();

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        EventBus.getDefault().unregister(this);
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_friend;
    }

    @Override
    public void initView() {
        EventBus.getDefault().register(this);
        mTabLayout = findViewByID(R.id.tab_layout);
        mViewPager = findViewByID(R.id.view_pager);
    }

    @Override
    public void setListener() {
        findViewByID(R.id.ll_new_friend).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserStatusManager.SINGLETON.jump2FriendHistory(getContext());
            }
        });
        findViewByID(R.id.ll_create_group_chat).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                startActivity(ContainerActivity.getJumpIntent(getContext(), CreateGroupChatFragment.class));
            }
        });
        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                // 切换 ViewPager
                mViewPager.setCurrentItem(position);
                if (position == 0) {
                    getFriendList();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                if (tab.getPosition() == 0) {
                    getFriendList();
                }
            }
        });
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                TabLayout.Tab tab = mTabLayout.getTabAt(i);
                if (tab == null) {
                    return;
                }
                tab.select();
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
    }

    @Override
    public void initData() {
        // TabLayout 与 ViewPager 关联
        List<String> titleList = new ArrayList<>();
        for (int i = 0; i < mTabLayout.getTabCount(); i++) {
            RecyclerView recyclerView = new RecyclerView(getContext());
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
            recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));
            RcvFriendAdapter rcvFriendAdapter = new RcvFriendAdapter(getContext());
            recyclerView.setAdapter(rcvFriendAdapter);
            mRecyclerViewList.add(recyclerView);
            TabLayout.Tab tab = mTabLayout.getTabAt(i);
            if (tab == null) {
                continue;
            }
            CharSequence text = tab.getText();
            if (text == null) {
                continue;
            }
            titleList.add(text.toString());
        }
        mViewPager.setAdapter(new VpSingleViewAdapter(mRecyclerViewList, titleList));
        mTabLayout.setupWithViewPager(mViewPager);
    }

    @Override
    public void getFriendListSuccess(List<UserBean> userBeanList) {
        RecyclerView.Adapter adapter = mRecyclerViewList.get(mTabLayout.getSelectedTabPosition()).getAdapter();
        if (adapter instanceof RcvFriendAdapter) {
            ((RcvFriendAdapter) adapter).setDataList(userBeanList);
        }
    }

    @Override
    public void getFriendListFailure(Exception e) {
        ShowLogUtil.logi("e--->" + e.getMessage());
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void updateUserBean(UserBean userBean) {
        mTabLayout.getTabAt(mTabLayout.getSelectedTabPosition()).select();
    }

    private void getFriendList() {
        if (!UserStatusManager.SINGLETON.isLogin()) {
            return;
        }
        getPresenter().getFriendList(UserStatusManager.SINGLETON.getUserBean().getId());
    }
}