package com.qinshou.qinshoubox;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentTransaction;
import android.view.MenuItem;

import com.qinshou.commonmodule.base.BaseMVPActivity;
import com.qinshou.commonmodule.util.FragmentUtil;
import com.qinshou.qinshoubox.base.MyBaseActivity;
import com.qinshou.qinshoubox.homepage.ui.fragment.HomepageFragment;
import com.qinshou.qinshoubox.knowledgesystem.ui.fragment.KnowledgeSystemFragment;
import com.qinshou.qinshoubox.me.ui.fragment.MeFragment;
import com.qinshou.qinshoubox.music.view.fragment.MusicListFragment;
import com.qinshou.qinshoubox.playandroid.view.fragment.PlayAndroidFragment;

/**
 * Description:主 Activity
 * Date:2018/4/9
 */
public class MainActivity extends BaseMVPActivity<MainPresenter> implements IMainContract.IMainView {
    private PlayAndroidFragment mPlayAndroidFragment;
    private MusicListFragment mMusicListFragment;
    private BottomNavigationView mBottomNavigationView;

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public MainPresenter initPresenter() {
        return new MainPresenter();
    }

    @Override
    public void initView() {
        mBottomNavigationView = findViewById(R.id.bottom_navigation_view);
    }

    @Override
    public void setListener() {
        mBottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                switch (menuItem.getItemId()) {
                    case R.id.bottom_navigation_btn_play_android:
                        fragmentTransaction.replace(R.id.fl_fragment_container, mPlayAndroidFragment);
                        break;
                    case R.id.bottom_navigation_btn_music:
                        fragmentTransaction.replace(R.id.fl_fragment_container, mMusicListFragment);
                        break;
                    case R.id.bottom_navigation_btn_personal_center:
                        break;
                }
                fragmentTransaction.commitAllowingStateLoss();
                return true;
            }
        });
    }

    @Override
    public void initData() {
        mPlayAndroidFragment = new PlayAndroidFragment();
        mMusicListFragment = new MusicListFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.fl_fragment_container, mPlayAndroidFragment).commit();
    }
}