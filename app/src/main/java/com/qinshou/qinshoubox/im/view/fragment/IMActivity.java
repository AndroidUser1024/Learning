package com.qinshou.qinshoubox.im.view.fragment;

import android.support.design.widget.TabLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.qinshou.commonmodule.util.FragmentUtil;
import com.qinshou.qinshoubox.R;
import com.qinshou.qinshoubox.base.QSActivity;
import com.qinshou.qinshoubox.base.QSFragment;
import com.qinshou.qinshoubox.conversation.view.fragment.ConversationFragment;
import com.qinshou.qinshoubox.demo.view.fragment.DemoFragment;
import com.qinshou.qinshoubox.friend.view.fragment.FriendFragment;
import com.qinshou.qinshoubox.im.contract.IIMContract;
import com.qinshou.qinshoubox.im.presenter.IMPresenter;

/**
 * Author: QinHao
 * Email:cqflqinhao@126.com
 * Date: 2019/12/04 21:49
 * Description:IM 界面
 */
public class IMActivity extends QSActivity<IMPresenter> implements IIMContract.IView {
    public static final int TAB_INDEX_CONVERSATION = 0;
    public static final int TAB_INDEX_FRIEND = 1;
    private int[] mTabIvResourceArray = new int[]{R.drawable.main_iv_tab_conversation_src, R.drawable.main_iv_tab_conversation_src_selected
            , R.drawable.main_iv_tab_friend_src, R.drawable.main_iv_tab_friend_src_selected
    };
    private QSFragment mConversationFragment;
    private QSFragment mFriendFragment;
    /**
     * 底部导航栏
     */
    private TabLayout mTlIM;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_im;
    }

    @Override
    public void initView() {
//        unbindSlideBackActivity();
        mTlIM = findViewByID(R.id.tl_im);

    }

    @Override
    public void setListener() {
        mTlIM.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                changeTabState(position);
                if (position == TAB_INDEX_CONVERSATION) {
                    FragmentUtil.showFragment(getSupportFragmentManager(), R.id.fl_fragment_container, mConversationFragment);
                } else if (position == TAB_INDEX_FRIEND) {
                    FragmentUtil.showFragment(getSupportFragmentManager(), R.id.fl_fragment_container, mFriendFragment);
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
        String[] mainTvTabTextArray = getResources().getStringArray(R.array.im_tv_tab_text);
        FragmentUtil.addFragment(getSupportFragmentManager(), R.id.fl_fragment_container, mConversationFragment = new ConversationFragment());
        FragmentUtil.addFragment(getSupportFragmentManager(), R.id.fl_fragment_container, mFriendFragment = new FriendFragment());
        for (int i = 0; i < mainTvTabTextArray.length; i++) {
            TabLayout.Tab tab = mTlIM.newTab();
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
            mTlIM.addTab(tab, i == 0);
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
        for (int i = 0; i < mTlIM.getTabCount(); i++) {
            TabLayout.Tab tab = mTlIM.getTabAt(i);
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
