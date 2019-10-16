package com.qinshou.qinshoubox.homepage.ui.fragment;

import android.graphics.Bitmap;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.qinshou.commonmodule.adapter.InfiniteCycleViewPagerAdapter;
import com.qinshou.commonmodule.util.ShowLogUtil;
import com.qinshou.commonmodule.widget.RefreshLayout;
import com.qinshou.commonmodule.widget.ViewPagerPoints;
import com.qinshou.imagemodule.PhotoViewActivity;
import com.qinshou.imagemodule.callback.OnGetImageCallback;
import com.qinshou.imagemodule.util.BitmapUtil;
import com.qinshou.imagemodule.util.ImageLoadUtil;
import com.qinshou.okhttphelper.callback.Callback;
import com.qinshou.qinshoubox.R;
import com.qinshou.qinshoubox.base.MyBaseFragment;
import com.qinshou.qinshoubox.homepage.contract.IHomepageContract;
import com.qinshou.qinshoubox.homepage.presenter.HomepagePresenter;
import com.qinshou.qinshoubox.homepage.ui.adapter.RvArticleAdapter;
import com.qinshou.qinshoubox.homepage.bean.WallpaperBean;
import com.qinshou.qinshoubox.homepage.transformer.QinshouBoxApiTransformer;
import com.qinshou.qinshoubox.network.OkHttpHelperForQinshouBoxApi;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:首页界面
 * Created by 禽兽先生
 * Created on 2018/4/4
 */

public class HomepageFragment extends MyBaseFragment<HomepagePresenter> implements IHomepageContract.IView {
    private ViewPager vpWallpaper;
    private InfiniteCycleViewPagerAdapter mInfiniteViewPagerAdapter;
    private ViewPagerPoints viewPagerPoints;

    private int page = 0;
    private RvArticleAdapter mRvArticleAdapter;
    private RefreshLayout refreshLayout;

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
        return R.layout.fragment_homepage;
    }

    @Override
    public void initView() {
        vpWallpaper = findViewByID(R.id.vp_wallpaper);
        mInfiniteViewPagerAdapter = new InfiniteCycleViewPagerAdapter(getActivity(), vpWallpaper);
        vpWallpaper.setAdapter(mInfiniteViewPagerAdapter);
        viewPagerPoints = findViewByID(R.id.view_pager_points);
        viewPagerPoints.setupWithViewPager(vpWallpaper);

//        RecyclerView rvArticle = findViewByID(R.id.rv_article);
//        //RecyclerView 去除焦点
//        rvArticle.setFocusableInTouchMode(false);
//        rvArticle.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
//        rvArticle.addItemDecoration(new DividerDecoration(getContext()));
//        mRvArticleAdapter = new RvArticleAdapter(getContext());
//        rvArticle.setAdapter(mRvArticleAdapter);
//        rvArticle.setNestedScrollingEnabled(false);
//
//        refreshLayout = findViewByID(R.id.refresh_layout);
    }

    @Override
    public void setListener() {
//        refreshLayout.setOnRefreshLoadMoreListener(new RefreshLayout.IOnRefreshLoadMoreListener() {
//            @Override
//            public void onRefresh(RefreshLayout refreshLayout) {
//                page = 0;
//                initData();
//            }
//
//            @Override
//            public void onLoadMore(RefreshLayout refreshLayout) {
//                page++;
//                loadHomePageArticles();
//            }
//        });
    }

    @Override
    public void initData() {
        loadWallpaperList();
        loadHomePageArticles();
    }


    /**
     * Description:加载美女轮播图
     * Date:2018/5/14
     */
    private void loadWallpaperList() {
        getPresenter().getWallpaperList();
    }

    /**
     * Description:加载首页文章
     * Date:2018/5/14
     */
    private void loadHomePageArticles() {
//        WanAndroidApi.getInstance().getHomepage(page, new BaseObserver<ArticleListBean>() {
//
//            @Override
//            public void onNext(ArticleListBean value) {
//                mRvArticleAdapter.addDataList(value.getArticleList(), page == 0);
//                refreshLayout.stopRefreshAndLoadMore();
//            }
//
//            @Override
//            public void onError(Throwable e) {
//                refreshLayout.stopRefreshAndLoadMore();
//            }
//        });
    }

    @Override
    public void getWallpaperListSuccess(List<WallpaperBean> wallpaperBeanList) {
        ShowLogUtil.logi(wallpaperBeanList);
        ArrayList<View> viewList = new ArrayList<>();
        final ArrayList<String> imageList = new ArrayList<String>();
        for (int i = 0; i < wallpaperBeanList.size(); i++) {
            final ImageView imageView = new ImageView(getContext());
            imageView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            ImageLoadUtil.getInstance().loadImage(getContext(), wallpaperBeanList.get(i).getPath(), imageView);
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
        viewPagerPoints.setCount(wallpaperBeanList.size());
    }

    @Override
    public void getWallpaperListFailure(Exception e) {
        ShowLogUtil.logi(e.getMessage());
    }
}
