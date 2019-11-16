package com.qinshou.qinshoubox.knowledgesystem.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;

import com.qinshou.commonmodule.widget.RefreshLayout;
import com.qinshou.qinshoubox.R;
import com.qinshou.qinshoubox.base.QSActivity;
import com.qinshou.qinshoubox.homepage.ui.adapter.RvArticleAdapter;

public class SearchActivity extends QSActivity {
    private static final String SEARCH_KEY_WORDS = "searchKeyWords";
    private int page = 0;
    private RvArticleAdapter mRvArticleAdapter;
    private RefreshLayout refreshLayout;

    @Override
    public int getLayoutId() {
        return R.layout.activity_search;
    }


    @Override
    public void initView() {
//        refreshLayout = findViewByID(R.id.refresh_layout);
//        RecyclerView rvArticle = findViewByID(R.id.rv_article);
//        rvArticle.setNestedScrollingEnabled(false);
//        rvArticle.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
//        mRvArticleAdapter = new RvArticleAdapter(this);
//        rvArticle.setAdapter(mRvArticleAdapter);
//        rvArticle.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
    }

    @Override
    public void setListener() {
        refreshLayout.setOnRefreshLoadMoreListener(new RefreshLayout.IOnRefreshLoadMoreListener() {
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
    }

    public static Intent getJumpIntent(Context context, String searchKeyWords) {
        Intent mIntent = new Intent(context, SearchActivity.class);
        mIntent.putExtra(SEARCH_KEY_WORDS, searchKeyWords);
        return mIntent;
    }
}
