package com.qinshou.qinshoubox.homepage.ui.adapter;

import android.content.Context;

import com.qinshou.commonmodule.rcvbaseadapter.RcvBaseAdapter;
import com.qinshou.commonmodule.rcvbaseadapter.baseholder.BaseViewHolder;
import com.qinshou.commonmodule.rcvbaseadapter.listener.IOnItemClickListener;
import com.qinshou.qinshoubox.R;
import com.qinshou.qinshoubox.WebActivity;
import com.qinshou.qinshoubox.homepage.bean.ArticleBean;
import com.qinshou.qinshoubox.homepage.util.HtmlTextUtil;

/**
 * Description:首页文章的适配器
 * Created by 禽兽先生
 * Created on 2018/4/6
 */

public class RvArticleAdapter extends RcvBaseAdapter<ArticleBean> {
    public RvArticleAdapter(Context context) {
        super(context, R.layout.item_rv_homepage_article);
        setOnItemClickListener(new IOnItemClickListener<ArticleBean>() {
            @Override
            public void onItemClick(BaseViewHolder holder, ArticleBean itemData, int position) {
                getContext().startActivity(WebActivity.getJumpIntent(getContext(), itemData.getLink()));
            }
        });
    }

    @Override
    public void bindViewHolder(final BaseViewHolder holder, final ArticleBean itemData, int position) {
        holder.setTvText(R.id.tv_title, HtmlTextUtil.getHtmlText(itemData.getTitle()));
        holder.setTvText(R.id.tv_author, itemData.getAuthor());
        holder.setTvText(R.id.tv_type, itemData.getSuperChapterName() + "/" + itemData.getChapterName());
        holder.setTvText(R.id.tv_publish_time, itemData.getNiceDate());
    }
}
