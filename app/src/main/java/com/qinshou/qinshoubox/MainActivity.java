package com.qinshou.qinshoubox;

import android.support.design.widget.TabLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.qinshou.commonmodule.util.FragmentUtil;
import com.qinshou.commonmodule.util.SharedPreferencesHelper;
import com.qinshou.commonmodule.util.ShowLogUtil;
import com.qinshou.commonmodule.util.SystemUtil;
import com.qinshou.immodule.chat.ChatManager;
import com.qinshou.immodule.listener.IOnFriendStatusListener;
import com.qinshou.qinshoubox.base.QSActivity;
import com.qinshou.qinshoubox.constant.IConstant;
import com.qinshou.qinshoubox.friend.view.fragment.FriendFragment;
import com.qinshou.qinshoubox.homepage.ui.fragment.HomepageFragment;
import com.qinshou.qinshoubox.me.ui.fragment.MeFragment;
import com.qinshou.qinshoubox.util.QSUtil;

/**
 * Description:主 Activity
 * Date:2018/4/9
 */
public class MainActivity extends QSActivity<MainPresenter> implements IMainContract.IView {

    /**
     * 底部导航栏
     */
    private TabLayout mTlMain;
    private HomepageFragment mHomepageFragment;
    //    private KnowledgeSystemFragment mKnowledgeSystemFragment;
    private FriendFragment mFriendFragment;
    private MeFragment mMeFragment;
    private int[] mTabTvTextResourceArray = new int[]{R.string.main_tv_tab_text_chat
            , R.string.main_tv_tab_text_contact
            , R.string.main_tv_tab_text_mine};
    private int[] mTabIvResourceArray = new int[]{R.drawable.main_iv_tab_conversation_src, R.drawable.main_iv_tab_conversation_src_selected
            , R.drawable.main_iv_tab_friend_src, R.drawable.main_iv_tab_friend_src_selected
            , R.drawable.main_iv_tab_me_src, R.drawable.main_iv_tab_me_src_selected};
    private IOnFriendStatusListener mOnFriendStatusListener = new IOnFriendStatusListener() {
        @Override
        public void add(int fromUserId, String additionalMsg, boolean newFriend) {
            if (mFriendFragment == null || !newFriend) {
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
            mFriendFragment.showFriendHistoryUnreadCount();
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
    protected void onDestroy() {
        super.onDestroy();
        ChatManager.SINGLETON.removeOnFriendStatusListener(mOnFriendStatusListener);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
//        View flutterView = Flutter.createView(this, this.getLifecycle(), "HomePage");

//        unbindSlideBackActivity();
        mTlMain = findViewByID(R.id.tl_main);
    }

    @Override
    public void setListener() {
        ChatManager.SINGLETON.addOnFriendStatusListener(mOnFriendStatusListener);
        mTlMain.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                changeTabState(position);
                if (position == 0) {
                    FragmentUtil.showFragment(getActivity(), R.id.fl_fragment_container, mHomepageFragment);
                } else if (position == 1) {
                    FragmentUtil.showFragment(getActivity(), R.id.fl_fragment_container, mFriendFragment);
                } else if (position == 2) {
                    FragmentUtil.showFragment(getActivity(), R.id.fl_fragment_container, mMeFragment);
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    @Override
    public void initData() {
//        PushUtil.setOnGetPushListener(new OnGetPushListener() {
//            @Override
//            public void getPush(String content) {
//                ShowLogUtil.logi(content);
//            }
//        });
        mHomepageFragment = new HomepageFragment();
        mFriendFragment = new FriendFragment();
        mMeFragment = new MeFragment();
        for (int i = 0; i < 3; i++) {
            TabLayout.Tab tab = mTlMain.newTab();
            View view = LayoutInflater.from(getContext()).inflate(R.layout.layout_tab_main, null);
            ImageView ivTab = view.findViewById(R.id.iv_tab);
            TextView tvTab = view.findViewById(R.id.tv_tab);
//            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//                tvTab.setTextAppearance(R.style.TextViewUnread);
//            }
            ivTab.setImageResource(mTabIvResourceArray[i * 2]);
            tvTab.setText(mTabTvTextResourceArray[i]);
            // 设置视图
            tab.setCustomView(view);
            mTlMain.addTab(tab, i == 0);
        }
    }

    /**
     * Author: QinHao
     * Email:cqflqinhao@126.com
     * Date:2019/11/18 20:13
     * Description: 设置底部导航标签图片
     *
     * @param position 当前 tab 的 position
     */
    private void changeTabState(int position) {
        for (int i = 0; i < mTlMain.getTabCount(); i++) {
            TabLayout.Tab tab = mTlMain.getTabAt(i);
            if (tab == null) {
                continue;
            }
            View customView = tab.getCustomView();
            if (customView == null) {
                continue;
            }
            ImageView ivTab = customView.findViewById(R.id.iv_tab);
            TextView tvTab = customView.findViewById(R.id.tv_tab);
            if (ivTab == null || tvTab == null) {
                continue;
            }
            ivTab.setImageResource(i == position ? mTabIvResourceArray[i * 2 + 1] : mTabIvResourceArray[i * 2]);
            tvTab.setTextColor(i == position ? 0xFF03A9F4 : 0xFF666666);
        }
    }
}