package com.qinshou.qinshoubox.homepage.ui.fragment;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.qinshou.commonmodule.rcvbaseadapter.baseholder.BaseViewHolder;
import com.qinshou.commonmodule.rcvbaseadapter.listener.IOnItemClickListener;
import com.qinshou.commonmodule.rcvdecoration.DividerDecoration;
import com.qinshou.commonmodule.util.StatusBarUtil;
import com.qinshou.commonmodule.widget.RefreshLayout;
import com.qinshou.commonmodule.widget.ViewPagerPoints;
import com.qinshou.qinshoubox.R;
import com.qinshou.qinshoubox.WebActivity;
import com.qinshou.qinshoubox.base.QSFragment;
import com.qinshou.qinshoubox.constant.IConstant;
import com.qinshou.qinshoubox.homepage.bean.EventBean;
import com.qinshou.qinshoubox.homepage.bean.NewsBean;
import com.qinshou.qinshoubox.homepage.bean.WallpaperBean;
import com.qinshou.qinshoubox.homepage.contract.IHomepageContract;
import com.qinshou.qinshoubox.homepage.presenter.HomepagePresenter;
import com.qinshou.qinshoubox.homepage.ui.adapter.RcvNewsAdapter;
import com.qinshou.qinshoubox.homepage.ui.adapter.VpWallpaperAdapter;

import java.util.List;

/**
 * Description:首页界面
 * Created by 禽兽先生
 * Created on 2018/4/4
 */

public class HomepageFragment extends QSFragment<HomepagePresenter> implements IHomepageContract.IView {
    private VpWallpaperAdapter mVpWallpaperAdapter;
    private ViewPagerPoints mViewPagerPoints;

    private RcvNewsAdapter mRcvNewsAdapter;
    private RefreshLayout mRefreshLayout;
    private int mPage = IConstant.PAGE_START;

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
    public int getLayoutId() {
        StatusBarUtil.setStatusBarTranslucent(getActivity().getWindow(), true);
        return R.layout.fragment_homepage;
    }

    @Override
    public void initView() {
        ViewPager2 vpWallpaper = findViewByID(R.id.vp_wallpaper);
        vpWallpaper.setAdapter(mVpWallpaperAdapter = new VpWallpaperAdapter(getContext(), vpWallpaper));
        mViewPagerPoints = findViewByID(R.id.view_pager_points);
        mViewPagerPoints.setupWithViewPager2(vpWallpaper);

        mRefreshLayout = findViewByID(R.id.refresh_layout);
        RecyclerView rvNews = findViewByID(R.id.rv_news);
        // RecyclerView 去除焦点
        rvNews.setFocusableInTouchMode(false);
        rvNews.setLayoutManager(new LinearLayoutManager(getContext()));
        rvNews.addItemDecoration(new DividerDecoration());
        mRcvNewsAdapter = new RcvNewsAdapter(getContext());
        rvNews.setAdapter(mRcvNewsAdapter);
        rvNews.setNestedScrollingEnabled(false);
    }

    @Override
    public void setListener() {
        mRefreshLayout.setOnRefreshLoadMoreListener(new RefreshLayout.IOnRefreshLoadMoreListener() {
            @Override
            public void onRefresh(RefreshLayout refreshLayout) {
                mPage = IConstant.PAGE_START;
                getPresenter().getNewsList(mPage, IConstant.PAGE_SIZE);
//                getPresenter().getWallpaperList();
            }

            @Override
            public void onLoadMore(RefreshLayout refreshLayout) {
                mPage++;
                getPresenter().getNewsList(mPage, IConstant.PAGE_SIZE);
            }
        });
        mRcvNewsAdapter.setOnItemClickListener(new IOnItemClickListener<NewsBean>() {
            @Override
            public void onItemClick(BaseViewHolder holder, NewsBean itemData, int position) {
                getContext().startActivity(WebActivity.getJumpIntent(getContext(), itemData.getHref()));
            }
        });
    }

    @Override
    public void initData() {
        getPresenter().getWallpaperList();
        getPresenter().getNewsList(mPage, IConstant.PAGE_SIZE);
    }

    @Override
    public void handleEvent(EventBean<Object> eventBean) {
    }

    @Override
    public void getWallpaperListSuccess(List<WallpaperBean> wallpaperBeanList) {
        mVpWallpaperAdapter.setDataList(wallpaperBeanList);
        mVpWallpaperAdapter.startLoop();
        mViewPagerPoints.setCount(wallpaperBeanList.size());
    }

    @Override
    public void getWallpaperListFailure(Exception e) {
    }

    @Override
    public void getNewsListSuccess(List<NewsBean> newsBeanList) {
        mRcvNewsAdapter.addDataList(newsBeanList, mPage == IConstant.PAGE_START);
        mRefreshLayout.stopRefreshAndLoadMore();
    }

    @Override
    public void getNewsListFailure(Exception e) {
        mRefreshLayout.stopRefreshAndLoadMore();
    }

}
