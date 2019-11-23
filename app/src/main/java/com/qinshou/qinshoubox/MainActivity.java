package com.qinshou.qinshoubox;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.qinshou.commonmodule.util.FragmentUtil;
import com.qinshou.commonmodule.util.SharedPreferencesHelper;
import com.qinshou.commonmodule.util.SystemUtil;
import com.qinshou.immodule.db.DBHelper;
import com.qinshou.immodule.manager.ChatManager;
import com.qinshou.immodule.listener.IOnFriendStatusListener;
import com.qinshou.qinshoubox.base.QSActivity;
import com.qinshou.qinshoubox.constant.IConstant;
import com.qinshou.qinshoubox.conversation.view.fragment.ConversationFragment;
import com.qinshou.qinshoubox.friend.view.fragment.FriendFragment;
import com.qinshou.qinshoubox.homepage.ui.fragment.HomepageFragment;
import com.qinshou.qinshoubox.me.ui.fragment.MeFragment;
import com.qinshou.qinshoubox.util.QSUtil;

/**
 * Description:主 Activity
 * Date:2018/4/9
 */
public class MainActivity extends QSActivity<MainPresenter> implements IMainContract.IView {
    public static final int TAB_INDEX_HOMEPAGE = 0;
    public static final int TAB_INDEX_CONVERSATION = 1;
    public static final int TAB_INDEX_FRIEND = 2;
    public static final int TAB_INDEX_ME = 3;
    /**
     * 底部导航栏
     */
    private TabLayout mTlMain;
    private HomepageFragment mHomepageFragment;
    private ConversationFragment mConversationFragment;
    private FriendFragment mFriendFragment;
    private MeFragment mMeFragment;
    private int[] mTabIvResourceArray = new int[]{R.drawable.main_iv_tab_conversation_src, R.drawable.main_iv_tab_conversation_src_selected
            , R.drawable.main_iv_tab_conversation_src, R.drawable.main_iv_tab_conversation_src_selected
            , R.drawable.main_iv_tab_friend_src, R.drawable.main_iv_tab_friend_src_selected
            , R.drawable.main_iv_tab_me_src, R.drawable.main_iv_tab_me_src_selected};


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.addCategory(Intent.CATEGORY_HOME);
            startActivity(intent);
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        DBHelper.init(getContext(), "test1");
//        View flutterView = Flutter.createView(this, this.getLifecycle(), "HomePage");

//        unbindSlideBackActivity();
        mTlMain = findViewByID(R.id.tl_main);
    }

    @Override
    public void setListener() {
        mTlMain.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                changeTabState(position);
                if (position == TAB_INDEX_HOMEPAGE) {
                    FragmentUtil.showFragment(getActivity(), R.id.fl_fragment_container, mHomepageFragment);
                } else if (position == TAB_INDEX_CONVERSATION) {
                    FragmentUtil.showFragment(getActivity(), R.id.fl_fragment_container, mConversationFragment);
                } else if (position == TAB_INDEX_FRIEND) {
                    FragmentUtil.showFragment(getActivity(), R.id.fl_fragment_container, mFriendFragment);
                } else if (position == TAB_INDEX_ME) {
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
        String[] mainTvTabTextArray = getResources().getStringArray(R.array.main_tv_tab_text);
        FragmentUtil.addFragment(getActivity(), R.id.fl_fragment_container, mConversationFragment = new ConversationFragment());
        FragmentUtil.addFragment(getActivity(), R.id.fl_fragment_container, mFriendFragment = new FriendFragment());
        FragmentUtil.addFragment(getActivity(), R.id.fl_fragment_container, mMeFragment = new MeFragment());
        FragmentUtil.addFragment(getActivity(), R.id.fl_fragment_container, mHomepageFragment = new HomepageFragment());
        for (int i = 0; i < mainTvTabTextArray.length; i++) {
            TabLayout.Tab tab = mTlMain.newTab();
            View view = LayoutInflater.from(getContext()).inflate(R.layout.layout_tab_main, null);
            ImageView ivTab = view.findViewById(R.id.iv_tab);
            TextView tvTab = view.findViewById(R.id.tv_tab);
//            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//                tvTab.setTextAppearance(R.style.TextViewUnread);
//            }
            ivTab.setImageResource(mTabIvResourceArray[i * 2]);
            tvTab.setText(mainTvTabTextArray[i]);
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