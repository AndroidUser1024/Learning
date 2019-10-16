package com.qinshou.qinshoubox;

import android.support.design.widget.TabLayout;

import com.qinshou.commonmodule.util.FragmentUtil;
import com.qinshou.qinshoubox.base.MyBaseActivity;
import com.qinshou.qinshoubox.homepage.ui.fragment.HomepageFragment;
import com.qinshou.qinshoubox.knowledgesystem.ui.fragment.KnowledgeSystemFragment;
import com.qinshou.qinshoubox.me.ui.fragment.MeFragment;

/**
 * Description:主 Activity
 * Date:2018/4/9
 */
public class MainActivity extends MyBaseActivity {

    private TabLayout tabLayout;
    private HomepageFragment mHomepageFragment;
    private KnowledgeSystemFragment mKnowledgeSystemFragment;
    private MeFragment mMeFragment;

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
//        View flutterView = Flutter.createView(this, this.getLifecycle(), "HomePage");

//        unbindSlideBackActivity();
//        tabLayout = findViewByID(R.id.tab_layout);
//
//        mHomepageFragment = new HomepageFragment();
//        mKnowledgeSystemFragment = new KnowledgeSystemFragment();
//        mMeFragment = new MeFragment();
//        FragmentUtil.showFragment(getActivity(), R.id.fl_container, mHomepageFragment);
    }

    @Override
    public void setListener() {
//        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
//            @Override
//            public void onTabSelected(TabLayout.Tab tab) {
//                switch (tab.getPosition()) {
//                    case 0:
//                        FragmentUtil.showFragment(getActivity(), R.id.fl_container, mHomepageFragment);
//                        break;
//                    case 1:
//                        FragmentUtil.showFragment(getActivity(), R.id.fl_container, mKnowledgeSystemFragment);
//                        break;
//                    case 2:
//                        FragmentUtil.showFragment(getActivity(), R.id.fl_container, mMeFragment);
//                        break;
//                }
//            }
//
//            @Override
//            public void onTabUnselected(TabLayout.Tab tab) {
//
//            }
//
//            @Override
//            public void onTabReselected(TabLayout.Tab tab) {
//
//            }
//        });
    }

    @Override
    public void initData() {
//        PushUtil.setOnGetPushListener(new OnGetPushListener() {
//            @Override
//            public void getPush(String content) {
//                ShowLogUtil.logi(content);
//            }
//        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
//        DisposableManager.getInstance().clear();
    }
}