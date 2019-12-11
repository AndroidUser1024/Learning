package com.qinshou.qinshoubox.friend.view.fragment;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.qinshou.commonmodule.ContainerActivity;
import com.qinshou.commonmodule.adapter.VpSingleViewAdapter;
import com.qinshou.commonmodule.util.SharedPreferencesHelper;
import com.qinshou.commonmodule.util.ShowLogUtil;
import com.qinshou.commonmodule.util.SystemUtil;
import com.qinshou.qinshoubox.R;
import com.qinshou.qinshoubox.base.QSFragment;
import com.qinshou.qinshoubox.constant.IConstant;
import com.qinshou.qinshoubox.friend.contract.IFriendContract;
import com.qinshou.qinshoubox.friend.presenter.FriendPresenter;
import com.qinshou.qinshoubox.friend.view.adapter.RcvFriendAdapter;
import com.qinshou.qinshoubox.friend.view.adapter.RcvGroupChatAdapter;
import com.qinshou.qinshoubox.homepage.bean.EventBean;
import com.qinshou.qinshoubox.im.listener.IOnFriendStatusListener;
import com.qinshou.qinshoubox.im.IMClient;
import com.qinshou.qinshoubox.im.bean.FriendBean;
import com.qinshou.qinshoubox.im.bean.GroupChatBean;
import com.qinshou.qinshoubox.im.listener.IOnGroupChatStatusListener;
import com.qinshou.qinshoubox.im.view.fragment.IMActivity;
import com.qinshou.qinshoubox.util.QSUtil;

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
    private RcvFriendAdapter mRcvFriendAdapter;
    private RcvGroupChatAdapter mRcvGroupChatAdapter;
    /**
     * 好友状态监听器
     */
    private IOnFriendStatusListener mOnFriendStatusListener = new IOnFriendStatusListener() {
        @Override
        public void add(String fromUserId, String additionalMsg, boolean newFriend) {
            ShowLogUtil.logi("add: fromUserId--->" + fromUserId + ",additionalMsg--->" + additionalMsg + ",newFriend--->" + newFriend);
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
        public void agreeAdd(String fromUserId) {
            ShowLogUtil.logi("agreeAdd: fromUserId--->" + fromUserId);
            getPresenter().getFriendList();
        }

        @Override
        public void refuseAdd(String fromUserId) {
            ShowLogUtil.logi("refuseAdd: fromUserId--->" + fromUserId);
        }

        @Override
        public void delete(String fromUserId) {
            ShowLogUtil.logi("delete: fromUserId--->" + fromUserId);
            getPresenter().getFriendList();
        }

        @Override
        public void online(String fromUserId) {
            ShowLogUtil.logi("online: fromUserId--->" + fromUserId);
        }

        @Override
        public void offline(String fromUserId) {
            ShowLogUtil.logi("offline: fromUserId--->" + fromUserId);
        }
    };

    /**
     * 群状态监听器
     */
    private IOnGroupChatStatusListener mOnGroupChatStatusListener = new IOnGroupChatStatusListener() {
        @Override
        public void add(String groupChatId, String fromUserId, String toUserId) {
            ShowLogUtil.logi("add: groupChatId--->" + groupChatId + ",fromUserId--->" + fromUserId + ",toUserId--->" + toUserId);
            getPresenter().getMyGroupChatList();
        }

        @Override
        public void delete(String groupChatId, String fromUserId, String toUserId) {
            ShowLogUtil.logi("delete: groupChatId--->" + groupChatId + ",fromUserId--->" + fromUserId + ",toUserId--->" + toUserId);
            getPresenter().getMyGroupChatList();
        }

        @Override
        public void otherAdd(String groupChatId, String fromUserId, String toUserId) {
            ShowLogUtil.logi("otherAdd: groupChatId--->" + groupChatId + ",fromUserId--->" + fromUserId + ",toUserId--->" + toUserId);
        }

        @Override
        public void otherDelete(String groupChatId, String fromUserId, String toUserId) {
            ShowLogUtil.logi("otherDelete: groupChatId--->" + groupChatId + ",fromUserId--->" + fromUserId + ",toUserId--->" + toUserId);
        }
    };

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        EventBus.getDefault().unregister(this);
        IMClient.SINGLETON.removeOnFriendStatusListener(mOnFriendStatusListener);
        IMClient.SINGLETON.removeOnGroupChatStatusListener(mOnGroupChatStatusListener);
        mTvUnreadCount.setVisibility(View.GONE);
        mTvUnreadCountInTlMain.setVisibility(View.GONE);
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
        TabLayout tlIM = getActivity().findViewById(R.id.tl_im);
        if (tlIM == null) {
            return;
        }
        TabLayout.Tab tab = tlIM.getTabAt(IMActivity.TAB_INDEX_FRIEND);
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
        EventBus.getDefault().register(this);
        IMClient.SINGLETON.addOnFriendStatusListener(mOnFriendStatusListener);
        IMClient.SINGLETON.addOnGroupChatStatusListener(mOnGroupChatStatusListener);
        findViewByID(R.id.ll_new_friend).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(ContainerActivity.getJumpIntent(getContext(), FriendHistoryFragment.class));
                SharedPreferencesHelper.SINGLETON.remove(IConstant.SP_KEY_FRIEND_HISTORY_UNREAD_COUNT);
                showFriendHistoryUnreadCount();
            }
        });
        findViewByID(R.id.ll_create_group_chat).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(ContainerActivity.getJumpIntent(getContext(), CreateGroupChatFragment.class));
            }
        });
        mTlFriend.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                // 修改 Tab 状态
                changeTabState(tab.getPosition());
                // 切换 ViewPager
                mViewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
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
        // 初始化 TabLayout
        String[] nameArray = getResources().getStringArray(R.array.friend_tv_tab_text);
        for (int i = 0; i < nameArray.length; i++) {
            TabLayout.Tab tab = mTlFriend.newTab();
            View view = LayoutInflater.from(getContext()).inflate(R.layout.layout_tab_friend, null);
            TextView tvName = view.findViewById(R.id.tv_name);
            tvName.setText(nameArray[i]);
            // 设置视图
            tab.setCustomView(view);
            mTlFriend.addTab(tab, i == TAB_INDEX_GROUP_CHAT);
        }
        // TabLayout 与 ViewPager 关联
        List<String> titleList = new ArrayList<>();
        for (int i = 0; i < nameArray.length; i++) {
            RecyclerView recyclerView = new RecyclerView(getContext());
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
            recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));
            if (i == TAB_INDEX_GROUP_CHAT) {
                recyclerView.setAdapter(mRcvGroupChatAdapter = new RcvGroupChatAdapter(getContext()));
            } else if (i == TAB_INDEX_FRIEND) {
                recyclerView.setAdapter(mRcvFriendAdapter = new RcvFriendAdapter(getContext()));
            }
            mRecyclerViewList.add(recyclerView);
            titleList.add(nameArray[i]);
        }
        mViewPager.setAdapter(new VpSingleViewAdapter(mRecyclerViewList, titleList));
//        mTlFriend.setupWithViewPager(mViewPager);

        getPresenter().getMyGroupChatList();
        getPresenter().getFriendList();
        showFriendHistoryUnreadCount();
    }

    @Override
    public void getMyGroupChatListSuccess(List<GroupChatBean> groupChatBeanList) {
        mRcvGroupChatAdapter.setDataList(groupChatBeanList);
    }

    @Override
    public void getMyGroupChatListFailure(Exception e) {
    }

    @Override
    public void getFriendListSuccess(List<FriendBean> friendBeanList) {
        mRcvFriendAdapter.setDataList(friendBeanList);
    }

    @Override
    public void getFriendListFailure(Exception e) {
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void receiveEvent(EventBean<Object> eventBean) {
        if (eventBean.getType() == EventBean.Type.REFRESH_GROUP_CHAT_LIST) {
            getPresenter().getMyGroupChatList();
        } else if (eventBean.getType() == EventBean.Type.REFRESH_FRIEND_LIST) {
            getPresenter().getFriendList();
        }
    }

    /**
     * Author: QinHao
     * Email:cqflqinhao@126.com
     * Date:2019/10/25 18:36
     * Description:修改当前选中的 tab 的状态
     *
     * @param position 当前选中的 tab 的下标
     */
    private void changeTabState(int position) {
        for (int i = 0; i < mTlFriend.getTabCount(); i++) {
            TabLayout.Tab tab = mTlFriend.getTabAt(i);
            if (tab == null) {
                continue;
            }
            View customView = tab.getCustomView();
            if (customView == null) {
                continue;
            }
            TextView tvName = customView.findViewById(R.id.tv_name);
            if (tvName == null) {
                continue;
            }
            // 切换文本框文字颜色
            tvName.setTextColor(i == position ? 0xFF333333 : 0xFF666666);
            // 切换文本框背景
            tvName.setBackgroundResource(i == position ? R.drawable.friend_tab_tv_name_bg : 0);
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