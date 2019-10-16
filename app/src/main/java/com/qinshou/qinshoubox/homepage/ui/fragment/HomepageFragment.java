package com.qinshou.qinshoubox.homepage.ui.fragment;

import android.support.v4.view.ViewPager;

import com.qinshou.commonmodule.adapter.InfiniteCycleViewPagerAdapter;
import com.qinshou.commonmodule.widget.RefreshLayout;
import com.qinshou.commonmodule.widget.ViewPagerPoints;
import com.qinshou.qinshoubox.R;
import com.qinshou.qinshoubox.base.MyBaseFragment;
import com.qinshou.qinshoubox.homepage.adapter.RvArticleAdapter;

/**
 * Description:首页界面
 * Created by 禽兽先生
 * Created on 2018/4/4
 */

public class HomepageFragment extends MyBaseFragment {
    private ViewPager vpBeauty;
    private InfiniteCycleViewPagerAdapter mInfiniteViewPagerAdapter;
    private ViewPagerPoints viewPagerPoints;

    private int page = 0;
    private RvArticleAdapter mRvArticleAdapter;
    private RefreshLayout refreshLayout;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_homepage;
    }

    @Override
    public void initView() {
//        vpBeauty = findViewByID(R.id.vp_beauty);
//        mInfiniteViewPagerAdapter = new InfiniteCycleViewPagerAdapter(getActivity(), vpBeauty);
//        vpBeauty.setAdapter(mInfiniteViewPagerAdapter);
//        viewPagerPoints = findViewByID(R.id.view_pager_points);
//        viewPagerPoints.setupWithViewPager(vpBeauty);
//
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
        loadBeautyGirls();
        loadHomePageArticles();
    }

    @Override
    public void onResume() {
        super.onResume();
//        if (!mInfiniteViewPagerAdapter.isLooping()) {
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
//        if (mInfiniteViewPagerAdapter.isLooping()) {
//            mInfiniteViewPagerAdapter.stopLoop();
//        }
    }

    /**
     * Description:加载美女轮播图
     * Date:2018/5/14
     */
    private void loadBeautyGirls() {
//        GankIoApi.getInstance().getBeautyGirls(4, 1, new BaseObserver<List<WelfareBean>>() {
//
//            @Override
//            public void onNext(List<WelfareBean> value) {
//                ArrayList<View> viewList = new ArrayList<>();
//                final ArrayList<String> imageList = new ArrayList<String>();
//                for (int i = 0; i < value.size(); i++) {
//                    final ImageView imageView = new ImageView(getContext());
//                    imageView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
//                    imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
//                    ImageLoadUtil.getInstance().getImage(getContext(), value.get(i).getUrl(), new OnGetImageCallback() {
//                        @Override
//                        public void onSuccess(Bitmap bitmap) {
//                            imageView.setImageBitmap(BitmapUtil.roundCornerEffect(bitmap));
//                        }
//
//                        @Override
//                        public void onFailure(String error, Bitmap errorBitmap) {
//
//                        }
//                    });
////                    ImageLoadUtil.getInstance().loadImage(getContext(), value.get(i).getUrl(), imageView);
//
//                    imageList.add(value.get(i).getUrl());
//                    final int finalI = i;
//                    imageView.setOnClickListener(new View.OnClickListener() {
//                        @Override
//                        public void onClick(View v) {
//                            startActivity(PhotoViewActivity.getJumpIntent(getContext(), imageList, finalI));
//                        }
//                    });
//                    viewList.add(imageView);
//                }
//                mInfiniteViewPagerAdapter.setData(viewList);
//                mInfiniteViewPagerAdapter.startLoop();
//                viewPagerPoints.setCount(value.size());
//            }
//
//            @Override
//            public void onError(Throwable e) {
//            }
//
//        });
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
}
