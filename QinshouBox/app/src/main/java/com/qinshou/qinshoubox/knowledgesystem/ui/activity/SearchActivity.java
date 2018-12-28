package com.qinshou.qinshoubox.knowledgesystem.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;

import com.qinshou.commonmodule.widget.RefreshLayout;
import com.qinshou.networkmodule.BaseObserver;
import com.qinshou.qinshoubox.R;
import com.qinshou.qinshoubox.base.MyBaseActivity;
import com.qinshou.qinshoubox.homepage.adapter.RvArticleAdapter;
import com.qinshou.qinshoubox.homepage.bean.ArticleListBean;
import com.qinshou.qinshoubox.network.wanandroid.WanAndroidApi;

public class SearchActivity extends MyBaseActivity {
    private static final String SEARCH_KEY_WORDS = "searchKeyWords";
    private int page = 0;
    private RvArticleAdapter mRvArticleAdapter;
    private RefreshLayout refreshLayout;

    @Override
    public int getLayoutId() {
        return R.layout.activity_search;
    }

    @Override
    public void setPresenter() {

    }

    @Override
    public void initView() {
        refreshLayout = findViewByID(R.id.refresh_layout);
        RecyclerView rvArticle = findViewByID(R.id.rv_article);
        rvArticle.setNestedScrollingEnabled(false);
        rvArticle.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mRvArticleAdapter = new RvArticleAdapter(this);
        rvArticle.setAdapter(mRvArticleAdapter);
        rvArticle.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
    }

    @Override
    public void setListener() {
        refreshLayout.setOnRefreshLoadMoreListener(new RefreshLayout.OnRefreshLoadMoreListener() {
            @Override
            public void onRefresh(RefreshLayout refreshLayout) {
                page = 0;
                initData();
            }

            @Override
            public void onLoadMore(RefreshLayout refreshLayout) {
                page++;
                initData();
            }
        });
    }

    @Override
    public void initData() {
        String searchKeyWords = getIntent().getStringExtra(SEARCH_KEY_WORDS);
        if (TextUtils.isEmpty(searchKeyWords)) {
            return;
        }
        WanAndroidApi.getInstance().search(page, searchKeyWords, new BaseObserver<ArticleListBean>() {

            @Override
            public void onNext(ArticleListBean value) {
                mRvArticleAdapter.addDataList(value.getArticleList(), page == 0);

                refreshLayout.stopRefreshAndLoadMore();
            }

            @Override
            public void onError(Throwable e) {
                refreshLayout.stopRefreshAndLoadMore();
            }
        });
    }

    public static Intent getJumpIntent(Context context, String searchKeyWords) {
        Intent mIntent = new Intent(context, SearchActivity.class);
        mIntent.putExtra(SEARCH_KEY_WORDS, searchKeyWords);
        return mIntent;
    }
}
