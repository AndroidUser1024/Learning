package com.qinshou.qinshoubox.friend.view.fragment;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.qinshou.commonmodule.adapter.VpSingleViewAdapter;
import com.qinshou.commonmodule.rcvbaseadapter.RcvBaseAdapter;
import com.qinshou.commonmodule.util.SharedPreferencesHelper;
import com.qinshou.commonmodule.util.ShowLogUtil;
import com.qinshou.commonmodule.util.SystemUtil;
import com.qinshou.qinshoubox.im.listener.IOnFriendStatusListener;
import com.qinshou.qinshoubox.im.manager.ChatManager;
import com.qinshou.qinshoubox.MainActivity;
import com.qinshou.qinshoubox.R;
import com.qinshou.qinshoubox.base.QSFragment;
import com.qinshou.qinshoubox.constant.IConstant;
import com.qinshou.qinshoubox.friend.contract.IFriendContract;
import com.qinshou.qinshoubox.friend.presenter.FriendPresenter;
import com.qinshou.qinshoubox.friend.view.adapter.RcvFriendAdapter;
import com.qinshou.qinshoubox.friend.view.adapter.RcvGroupChatAdapter;
import com.qinshou.qinshoubox.im.bean.GroupChatBean;
import com.qinshou.qinshoubox.im.bean.UserBean;
import com.qinshou.qinshoubox.util.QSUtil;
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
    private final int TAB_INDEX_GROUP_CHAT = 0;
    private final int TAB_INDEX_FRIEND = 1;

    private TabLayout mTlFriend;
    private ViewPager mViewPager;
    /**
     * 好友申请历史未读数
     */
    private TextView mTvUnreadCount;
    /**
     * 主界面 TabLayout 的好友申请历史未读数
     */
    private TextView mTvUnreadCountInTlMain;
    private List<RecyclerView> mRecyclerViewList = new ArrayList<>();

    private IOnFriendStatusListener mOnFriendStatusListener = new IOnFriendStatusListener() {
        @Override
        public void add(int fromUserId, String additionalMsg, boolean newFriend) {
            if (!newFriend) {
                return;
            }
            try {
                if (SystemUtil.isBackground(getContext())) {
                    // 如果应用在后台显示通知
                } else {
                    // 震动
                    QSUtil.playVibration(getContext());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            // 红点提示
            int friendHistoryUnreadCount = SharedPreferencesHelper.SINGLETON.getInt(IConstant.SP_KEY_FRIEND_HISTORY_UNREAD_COUNT);
            if (friendHistoryUnreadCount == -1) {
                friendHistoryUnreadCount = 0;
            }
            friendHistoryUnreadCount++;
            SharedPreferencesHelper.SINGLETON.putInt(IConstant.SP_KEY_FRIEND_HISTORY_UNREAD_COUNT, friendHistoryUnreadCount);
            showFriendHistoryUnreadCount();
        }

        @Override
        public void agreeAdd(int fromUserId) {

        }

        @Override
        public void refuseAdd(int fromUserId) {

        }

        @Override
        public void delete(int fromUserId) {

        }

        @Override
        public void online(int fromUserId) {

        }

        @Override
        public void offline(int fromUserId) {

        }
    };

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mTvUnreadCount.setVisibility(View.GONE);
        mTvUnreadCountInTlMain.setVisibility(View.GONE);
        ChatManager.SINGLETON.removeOnFriendStatusListener(mOnFriendStatusListener);
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_friend;
    }

    @Override
    public void initView() {
        mTlFriend = findViewByID(R.id.tl_friend);
        mViewPager = findViewByID(R.id.view_pager);
        mTvUnreadCount = findViewByID(R.id.tv_unread_count);
        TabLayout tlMain = getActivity().findViewById(R.id.tl_main);
        if (tlMain == null) {
            return;
        }
        TabLayout.Tab tab = tlMain.getTabAt(MainActivity.TAB_INDEX_FRIEND);
        if (tab == null) {
            return;
        }
        View view = tab.getCustomView();
        if (view == null) {
            return;
        }
        mTvUnreadCountInTlMain = view.findViewById(R.id.tv_unread_count);
    }

    @Override
    public void setListener() {
        ChatManager.SINGLETON.addOnFriendStatusListener(mOnFriendStatusListener);
        findViewByID(R.id.ll_new_friend).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserStatusManager.SINGLETON.jump2FriendHistory(getContext());
            }
        });
        findViewByID(R.id.ll_create_group_chat).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserStatusManager.SINGLETON.jump2CreateGroupChat(getContext());
            }
        });
        mTlFriend.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                // 切换 ViewPager
                mViewPager.setCurrentItem(position);
                loadData(position);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                loadData(tab.getPosition());
            }
        });
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                TabLayout.Tab tab = mTlFriend.getTabAt(i);
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
        RecyclerView rcvGroupChat = new RecyclerView(getContext());
        rcvGroupChat.setLayoutManager(new LinearLayoutManager(getContext()));
        rcvGroupChat.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));
        RcvGroupChatAdapter rcvGroupChatAdapter = new RcvGroupChatAdapter(getContext());
        rcvGroupChat.setAdapter(rcvGroupChatAdapter);
        mRecyclerViewList.add(rcvGroupChat);
        titleList.add(getString(R.string.friend_ti_group_chat_text));

        RecyclerView rcvFriend = new RecyclerView(getContext());
        rcvFriend.setLayoutManager(new LinearLayoutManager(getContext()));
        rcvFriend.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));
        RcvFriendAdapter rcvFriendAdapter = new RcvFriendAdapter(getContext());
        rcvFriend.setAdapter(rcvFriendAdapter);
        mRecyclerViewList.add(rcvFriend);
        titleList.add(getString(R.string.friend_ti_friend_text));

        mViewPager.setAdapter(new VpSingleViewAdapter(mRecyclerViewList, titleList));
        mTlFriend.setupWithViewPager(mViewPager);

        loadData(mTlFriend.getSelectedTabPosition());
        showFriendHistoryUnreadCount();
    }

    @Override
    public void getMyGroupChatListSuccess(List<GroupChatBean> groupChatBeanList) {
        RecyclerView.Adapter adapter = mRecyclerViewList.get(mTlFriend.getSelectedTabPosition()).getAdapter();
        if (adapter instanceof RcvGroupChatAdapter) {
            ((RcvGroupChatAdapter) adapter).setDataList(groupChatBeanList);
        }
    }

    @Override
    public void getMyGroupChatListFailure(Exception e) {
    }

    @Override
    public void getFriendListSuccess(List<UserBean> userBeanList) {
        RecyclerView.Adapter adapter = mRecyclerViewList.get(mTlFriend.getSelectedTabPosition()).getAdapter();
        if (adapter instanceof RcvFriendAdapter) {
            ((RcvFriendAdapter) adapter).setDataList(userBeanList);
        }
    }

    @Override
    public void getFriendListFailure(Exception e) {
        ShowLogUtil.logi("e--->" + e.getMessage());
    }

    private void loadData(int position) {
        if (position == TAB_INDEX_GROUP_CHAT) {
            getPresenter().getMyGroupChatList();
        } else if (position == TAB_INDEX_FRIEND) {
            getPresenter().getFriendList();
        }
    }

    private void showFriendHistoryUnreadCount() {
        int friendHistoryUnreadCount = SharedPreferencesHelper.SINGLETON.getInt(IConstant.SP_KEY_FRIEND_HISTORY_UNREAD_COUNT);
        mTvUnreadCount.setVisibility(friendHistoryUnreadCount > 0 ? View.VISIBLE : View.GONE);
        mTvUnreadCount.setText(friendHistoryUnreadCount + "");
        mTvUnreadCountInTlMain.setVisibility(friendHistoryUnreadCount > 0 ? View.VISIBLE : View.GONE);
        mTvUnreadCountInTlMain.setText(friendHistoryUnreadCount + "");
    }
}