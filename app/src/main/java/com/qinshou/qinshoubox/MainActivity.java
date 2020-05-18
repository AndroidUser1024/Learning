package com.qinshou.qinshoubox;

import android.content.Context;
import android.content.Intent;

import com.google.android.material.tabs.TabLayout;

import android.content.IntentFilter;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.qinshou.commonmodule.ContainerActivity;
import com.qinshou.commonmodule.util.FragmentUtil;
import com.qinshou.commonmodule.util.SharedPreferencesHelper;
import com.qinshou.commonmodule.util.ShowLogUtil;
import com.qinshou.qinshoubox.base.QSActivity;
import com.qinshou.qinshoubox.base.QSFragment;
import com.qinshou.qinshoubox.broadcast.TimeTickBroadcastReceiver;
import com.qinshou.qinshoubox.constant.IConstant;
import com.qinshou.qinshoubox.conversation.view.fragment.ConversationFragment;
import com.qinshou.qinshoubox.friend.view.fragment.FriendFragment;
import com.qinshou.qinshoubox.homepage.bean.EventBean;
import com.qinshou.qinshoubox.homepage.ui.fragment.HomepageFragment;
import com.qinshou.qinshoubox.im.IMClient;
import com.qinshou.qinshoubox.login.bean.UserBean;
import com.qinshou.qinshoubox.login.view.fragment.LoginOrRegisterFragment;
import com.qinshou.qinshoubox.login.view.fragment.NotLoginFragment;
import com.qinshou.qinshoubox.me.ui.fragment.MeFragment;
import com.qinshou.qinshoubox.music.view.fragment.MusicListFragment;
import com.qinshou.qinshoubox.util.EncryptUtil;
import com.qinshou.qinshoubox.util.userstatusmanager.UserStatusManager;

/**
 * Description:主 Activity
 * Date:2018/4/9
 */
public class MainActivity extends QSActivity<MainPresenter> implements IMainContract.IView {
    public static final int TAB_INDEX_HOMEPAGE = 0;
    public static final int TAB_INDEX_MUSIC = 1;
    public static final int TAB_INDEX_CONVERSATION = 2;
    public static final int TAB_INDEX_FRIEND = 3;
    public static final int TAB_INDEX_ME = 4;
    /**
     * 底部导航栏
     */
    private TabLayout mTlMain;
    private QSFragment mHomepageFragment;
    private QSFragment mMusicListFragment;
    private QSFragment mConversationFragment;
    private QSFragment mFriendFragment;
    private QSFragment mMeFragment;
    private int[] mTabIvResourceArray = new int[]{R.drawable.main_iv_tab_home_src, R.drawable.main_iv_tab_home_src_selected
            , R.drawable.main_iv_tab_music_src, R.drawable.main_iv_tab_music_src_selected
            , R.drawable.main_iv_tab_conversation_src, R.drawable.main_iv_tab_conversation_src_selected
            , R.drawable.main_iv_tab_friend_src, R.drawable.main_iv_tab_friend_src_selected
            , R.drawable.main_iv_tab_me_src, R.drawable.main_iv_tab_me_src_selected};

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        FragmentUtil.removeFragment(getSupportFragmentManager(), mFriendFragment);
        FragmentUtil.removeFragment(getSupportFragmentManager(), mConversationFragment);
        FragmentUtil.removeFragment(getSupportFragmentManager(), mMeFragment);

        FragmentUtil.addFragment(getSupportFragmentManager(), R.id.fl_fragment_container, mFriendFragment = new FriendFragment());
        FragmentUtil.addFragment(getSupportFragmentManager(), R.id.fl_fragment_container, mConversationFragment = new ConversationFragment());
        FragmentUtil.addFragment(getSupportFragmentManager(), R.id.fl_fragment_container, mMeFragment = new MeFragment());

        TabLayout.Tab tab = mTlMain.getTabAt(0);
        if (tab != null) {
            tab.select();
        }
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
                    FragmentUtil.showFragment(getSupportFragmentManager(), R.id.fl_fragment_container, mHomepageFragment);
                } else if (position == TAB_INDEX_MUSIC) {
                    FragmentUtil.showFragment(getSupportFragmentManager(), R.id.fl_fragment_container, mMusicListFragment);
                } else if (position == TAB_INDEX_CONVERSATION) {
                    FragmentUtil.showFragment(getSupportFragmentManager(), R.id.fl_fragment_container, mConversationFragment);
                } else if (position == TAB_INDEX_FRIEND) {
                    FragmentUtil.showFragment(getSupportFragmentManager(), R.id.fl_fragment_container, mFriendFragment);
                } else if (position == TAB_INDEX_ME) {
                    FragmentUtil.showFragment(getSupportFragmentManager(), R.id.fl_fragment_container, mMeFragment);
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(Intent.ACTION_TIME_TICK);
        registerReceiver(new TimeTickBroadcastReceiver(), intentFilter);
    }

    @Override
    public void initData() {
//        PushHelper.setOnGetPushListener(new OnGetPushListener() {
//            @Override
//            public void getPush(String content) {
//                ShowLogUtil.logi(content);
//            }
//        });
        String[] mainTvTabTextArray = getResources().getStringArray(R.array.main_tv_tab_text);
        FragmentUtil.addFragment(getSupportFragmentManager(), R.id.fl_fragment_container, mMusicListFragment = new MusicListFragment());
        FragmentUtil.addFragment(getSupportFragmentManager(), R.id.fl_fragment_container, mFriendFragment = new FriendFragment());
        FragmentUtil.addFragment(getSupportFragmentManager(), R.id.fl_fragment_container, mConversationFragment = new ConversationFragment());
        FragmentUtil.addFragment(getSupportFragmentManager(), R.id.fl_fragment_container, mMeFragment = new MeFragment());
        FragmentUtil.addFragment(getSupportFragmentManager(), R.id.fl_fragment_container, mHomepageFragment = new HomepageFragment());
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

        String username = SharedPreferencesHelper.SINGLETON.getString(IConstant.SP_KEY_LAST_LOGIN_USERNAME);
        String password = SharedPreferencesHelper.SINGLETON.getString(IConstant.SP_KEY_LAST_LOGIN_PASSWORD);
        if (!TextUtils.isEmpty(username) && !TextUtils.isEmpty(password)) {
            // 对存储的密码进行解密,并自动登录
            getPresenter().login(username, EncryptUtil.decrypt(password));
        }
    }

    @Override
    public void handleEvent(EventBean<Object> eventBean) {
    }

    @Override
    public void loginSuccess(UserBean userBean) {
        ShowLogUtil.logi("loginSuccess" + " : " + "userBean--->" + userBean);
        UserStatusManager.SINGLETON.setUserBean(userBean);
        // 连接 IM 服务
        IMClient.SINGLETON.connect(userBean.getId());
    }

    @Override
    public void loginFailure(Exception e) {
        ShowLogUtil.logi("loginFailure" + " : " + "e--->" + e.getMessage());
        toastShort(e.getMessage());
        // 刪除保存的密码,这样下次打开应用就不会自动登录了
        SharedPreferencesHelper.SINGLETON.remove(IConstant.SP_KEY_LAST_LOGIN_PASSWORD);
        startActivity(ContainerActivity.getJumpIntent(getContext(), LoginOrRegisterFragment.class));
        finish();
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
            tvTab.setTextColor(i == position ? 0xFF3498DB : 0xFF666666);
        }
    }
}