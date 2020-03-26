package com.qinshou.qinshoubox.homepage.ui.fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.qinshou.commonmodule.rcvbaseadapter.baseholder.BaseViewHolder;
import com.qinshou.commonmodule.rcvbaseadapter.listener.IOnItemClickListener;
import com.qinshou.commonmodule.rcvdecoration.DividerDecoration;
import com.qinshou.commonmodule.util.StatusBarUtil;
import com.qinshou.commonmodule.widget.RefreshLayout;
import com.qinshou.imagemodule.PhotoViewActivity;
import com.qinshou.imagemodule.util.ImageLoadUtil;
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

import java.util.ArrayList;
import java.util.List;

/**
 * Description:首页界面
 * Created by 禽兽先生
 * Created on 2018/4/4
 */

public class HomepageFragment extends QSFragment<HomepagePresenter> implements IHomepageContract.IView {
    //    private ViewPager mVpWallpaper;
//    private InfiniteCycleViewPagerAdapter mInfiniteViewPagerAdapter;
//    private ViewPagerPoints mViewPagerPoints;

    private int mPage = IConstant.PAGE_START;
    private RcvNewsAdapter mRcvNewsAdapter;
    private RefreshLayout mRefreshLayout;
    private VpWallpaperAdapter mVpWallpaperAdapter;
    private ViewPager2 mVpWallpaper;

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
//        if (mInfiniteViewPagerAdapter != null && !mInfiniteViewPagerAdapter.isLooping()) {
//            mInfiniteViewPagerAdapter.startLoop();
//        }
    }

    /**
     * Description:界面失去焦点时停止轮播,节省内存
     * Date:2018/5/14
     */
    @Override
    public void onPause() {
        super.onPause();
//        if (mInfiniteViewPagerAdapter != null && mInfiniteViewPagerAdapter.isLooping()) {
//            mInfiniteViewPagerAdapter.stopLoop();
//        }
    }

    @Override
    public int getLayoutId() {
        StatusBarUtil.setStatusBarTranslucent(getActivity().getWindow(), true);
        return R.layout.fragment_homepage;
    }

    private class VpWallpaperAdapter extends RecyclerView.Adapter<VpWallpaperAdapter.MyViewHolder> {
        private List<WallpaperBean> mWallpaperBeanList = new ArrayList<>();
        @NonNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rcv_wallpaper, parent, false);
            return new MyViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
            if (mWallpaperBeanList.size() == 0) {
                return;
            }
            WallpaperBean wallpaperBean = mWallpaperBeanList.get(position % mWallpaperBeanList.size());
//            ImageLoadUtil.SINGLETON.loadImage(getContext(), wallpaperBean.getUrl(), holder.getImageView(R.id.iv_wallpaper));
            ImageLoadUtil.SINGLETON.loadImage(getContext(), wallpaperBean.getUrl(), holder.ivWallpaper);
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ArrayList<String> imageList = new ArrayList<>();
                    for (WallpaperBean wallpaperBean : mWallpaperBeanList) {
                        imageList.add(wallpaperBean.getUrl());
                    }
                    startActivity(PhotoViewActivity.getJumpIntent(getContext(), imageList, position % mWallpaperBeanList.size()));
                }
            });
//            ImageLoadUtil.SINGLETON.loadImage(getContext(), mWallpaperBeanList.get(position).getUrl(), holder.ivWallpaper);
//            holder.itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    ArrayList<String> imageList = new ArrayList<>();
//                    for (WallpaperBean wallpaperBean : mWallpaperBeanList) {
//                        imageList.add(wallpaperBean.getUrl());
//                    }
//                    startActivity(PhotoViewActivity.getJumpIntent(getContext(), imageList, position));
//                }
//            });
        }

        @Override
        public int getItemCount() {
//            return mWallpaperBeanList.size();
            return Integer.MAX_VALUE;
        }

        public void setDataList(List<WallpaperBean> dataList) {
            mWallpaperBeanList = dataList;
            notifyDataSetChanged();
            mVpWallpaper.setCurrentItem(getItemCount()/2,false);
        }

        private class MyViewHolder extends RecyclerView.ViewHolder {
            private ImageView ivWallpaper;
            public MyViewHolder(@NonNull View itemView) {
                super(itemView);
                ivWallpaper = itemView.findViewById(R.id.iv_wallpaper);
            }
        }
    }

    @Override
    public void initView() {
//        mVpWallpaper = findViewByID(R.id.vp_wallpaper);
//        mInfiniteViewPagerAdapter = new InfiniteCycleViewPagerAdapter(getActivity(), mVpWallpaper);
//        mVpWallpaper.setAdapter(mInfiniteViewPagerAdapter);
//        mViewPagerPoints = findViewByID(R.id.view_pager_points);
//        mViewPagerPoints.setupWithViewPager(mVpWallpaper);
        mVpWallpaper = findViewByID(R.id.vp_wallpaper);
//        vpWallpaper.setAdapter(mVpWallpaperAdapter = new VpWallpaperAdapter(getContext()));
        mVpWallpaper.setAdapter(mVpWallpaperAdapter = new VpWallpaperAdapter());

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
                getPresenter().getWallpaperList();
//                // 刷新时暂停轮播
//                if (mInfiniteViewPagerAdapter != null && mInfiniteViewPagerAdapter.isLooping()) {
//                    mInfiniteViewPagerAdapter.stopLoop();
//                }
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
//        mVpWallpaperAdapter.setOnItemClickListener(new IOnItemClickListener<WallpaperBean>() {
//            @Override
//            public void onItemClick(BaseViewHolder holder, WallpaperBean itemData, int position) {
//                ArrayList<String> imageList = new ArrayList<>();
//                for (WallpaperBean wallpaperBean : mVpWallpaperAdapter.getDataList()) {
//                    imageList.add(wallpaperBean.getUrl());
//                }
//                startActivity(PhotoViewActivity.getJumpIntent(getContext(), imageList, position));
//            }
//        });
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
//        ArrayList<View> viewList = new ArrayList<>();
//        final ArrayList<String> imageList = new ArrayList<String>();
//        for (int i = 0; i < wallpaperBeanList.size(); i++) {
//            final ImageView imageView = new ImageView(getContext());
//            imageView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
//            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
//            ImageLoadUtil.SINGLETON.loadImage(getContext(), wallpaperBeanList.get(i).getUrl(), imageView);
//            imageList.add(wallpaperBeanList.get(i).getUrl());
//            final int finalI = i;
//            imageView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    startActivity(PhotoViewActivity.getJumpIntent(getContext(), imageList, finalI));
//                }
//            });
//            viewList.add(imageView);
//        }
//        mInfiniteViewPagerAdapter.setData(viewList);
//        mInfiniteViewPagerAdapter.startLoop();
//        mViewPagerPoints.setCount(wallpaperBeanList.size());
    }

    @Override
    public void getWallpaperListFailure(Exception e) {
    }

    @Override
    public void getNewsListSuccess(List<NewsBean> newsBeanList) {
        mRcvNewsAdapter.addDataList(newsBeanList, mPage == IConstant.PAGE_START);
        mRefreshLayout.stopRefreshAndLoadMore();
//        // 重新开始轮播
//        if (mInfiniteViewPagerAdapter != null && !mInfiniteViewPagerAdapter.isLooping()) {
//            mInfiniteViewPagerAdapter.startLoop();
//        }
    }

    @Override
    public void getNewsListFailure(Exception e) {
        mRefreshLayout.stopRefreshAndLoadMore();
    }

}
