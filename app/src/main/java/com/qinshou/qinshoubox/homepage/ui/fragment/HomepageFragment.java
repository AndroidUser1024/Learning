package com.qinshou.qinshoubox.homepage.ui.fragment;

import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.qinshou.commonmodule.adapter.InfiniteCycleViewPagerAdapter;
import com.qinshou.commonmodule.util.ShowLogUtil;
import com.qinshou.commonmodule.util.StatusBarUtil;
import com.qinshou.commonmodule.widget.RefreshLayout;
import com.qinshou.commonmodule.widget.ViewPagerPoints;
import com.qinshou.imagemodule.PhotoViewActivity;
import com.qinshou.imagemodule.util.ImageLoadUtil;
import com.qinshou.qinshoubox.R;
import com.qinshou.qinshoubox.base.QSFragment;
import com.qinshou.qinshoubox.homepage.contract.IHomepageContract;
import com.qinshou.qinshoubox.homepage.presenter.HomepagePresenter;
import com.qinshou.qinshoubox.homepage.ui.adapter.RvArticleAdapter;
import com.qinshou.qinshoubox.homepage.bean.WallpaperBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:首页界面
 * Created by 禽兽先生
 * Created on 2018/4/4
 */

public class HomepageFragment extends QSFragment<HomepagePresenter> implements IHomepageContract.IView {
    private ViewPager mVpWallpaper;
    private InfiniteCycleViewPagerAdapter mInfiniteViewPagerAdapter;
    private ViewPagerPoints mViewPagerPoints;

    private int page = 0;
    private RvArticleAdapter mRvArticleAdapter;
    private RefreshLayout refreshLayout;

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (!hidden) {
            StatusBarUtil.setStatusBarTranslucent(getActivity().getWindow(), true);
        }
    }

    @Override
    public int initStatusBarColor() {
        return 0x00000000;
    }

    @Override
    public boolean initStatusBarDark() {
        return false;
    }

    @Override
    public void onResume() {
        super.onResume();
        if (mInfiniteViewPagerAdapter != null && !mInfiniteViewPagerAdapter.isLooping()) {
            mInfiniteViewPagerAdapter.startLoop();
        }
    }

    /**
     * Description:界面失去焦点时停止轮播,节省内存
     * Date:2018/5/14
     */
    @Override
    public void onPause() {
        super.onPause();
        if (mInfiniteViewPagerAdapter != null && mInfiniteViewPagerAdapter.isLooping()) {
            mInfiniteViewPagerAdapter.stopLoop();
        }
    }

    @Override
    public int getLayoutId() {
        StatusBarUtil.setStatusBarTranslucent(getActivity().getWindow(), true);
        return R.layout.fragment_homepage;
    }

    @Override
    public void initView() {
        mVpWallpaper = findViewByID(R.id.vp_wallpaper);
        mInfiniteViewPagerAdapter = new InfiniteCycleViewPagerAdapter(getActivity(), mVpWallpaper);
        mVpWallpaper.setAdapter(mInfiniteViewPagerAdapter);
        mViewPagerPoints = findViewByID(R.id.view_pager_points);
        mViewPagerPoints.setupWithViewPager(mVpWallpaper);

        refreshLayout = findViewByID(R.id.refresh_layout);
//        RecyclerView rvArticle = findViewByID(R.id.rv_article);
//        //RecyclerView 去除焦点
//        rvArticle.setFocusableInTouchMode(false);
//        rvArticle.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
//        rvArticle.addItemDecoration(new DividerDecoration(getContext()));
//        mRvArticleAdapter = new RvArticleAdapter(getContext());
//        rvArticle.setAdapter(mRvArticleAdapter);
//        rvArticle.setNestedScrollingEnabled(false);
//
    }

    @Override
    public void setListener() {
        refreshLayout.setOnRefreshLoadMoreListener(new RefreshLayout.IOnRefreshLoadMoreListener() {
            @Override
            public void onRefresh(RefreshLayout refreshLayout) {
                page = 0;
//                initData();
            }

            @Override
            public void onLoadMore(RefreshLayout refreshLayout) {
                page++;
//                loadHomePageArticles();
            }
        });
    }

    @Override
    public void initData() {
        getPresenter().getWallpaperList();
    }

    @Override
    public void getWallpaperListSuccess(List<WallpaperBean> wallpaperBeanList) {
        ArrayList<View> viewList = new ArrayList<>();
        final ArrayList<String> imageList = new ArrayList<String>();
        for (int i = 0; i < wallpaperBeanList.size(); i++) {
            final ImageView imageView = new ImageView(getContext());
            imageView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            ImageLoadUtil.SINGLETON.loadImage(getContext(), wallpaperBeanList.get(i).getPath(), imageView);
            imageList.add(wallpaperBeanList.get(i).getPath());
            final int finalI = i;
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(PhotoViewActivity.getJumpIntent(getContext(), imageList, finalI));
                }
            });
            viewList.add(imageView);
        }
        mInfiniteViewPagerAdapter.setData(viewList);
        mInfiniteViewPagerAdapter.startLoop();
        mViewPagerPoints.setCount(wallpaperBeanList.size());
    }

    @Override
    public void getWallpaperListFailure(Exception e) {
    }
}
