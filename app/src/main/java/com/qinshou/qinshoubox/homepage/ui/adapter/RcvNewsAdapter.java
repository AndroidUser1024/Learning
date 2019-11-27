package com.qinshou.qinshoubox.homepage.ui.adapter;

import android.content.Context;

import com.qinshou.commonmodule.rcvbaseadapter.RcvBaseAdapter;
import com.qinshou.commonmodule.rcvbaseadapter.baseholder.BaseViewHolder;
import com.qinshou.commonmodule.rcvbaseadapter.listener.IOnItemClickListener;
import com.qinshou.qinshoubox.R;
import com.qinshou.qinshoubox.WebActivity;
import com.qinshou.qinshoubox.homepage.bean.ArticleBean;
import com.qinshou.qinshoubox.homepage.bean.NewsBean;
import com.qinshou.qinshoubox.homepage.util.HtmlTextUtil;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Description:首页新闻的适配器
 * Created by 禽兽先生
 * Created on 2018/4/6
 */

public class RcvNewsAdapter extends RcvBaseAdapter<NewsBean> {
    private SimpleDateFormat mSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.CHINA);

    public RcvNewsAdapter(Context context) {
        super(context, R.layout.item_rcv_news);
    }

    @Override
    public void bindViewHolder(final BaseViewHolder holder, final NewsBean itemData, int position) {
        holder.setTvText(R.id.tv_title, itemData.getTitleChinese());
        holder.setTvText(R.id.tv_source, itemData.getSourceChinese());
        holder.setTvText(R.id.tv_translator, itemData.getTranslatorAndEditor());
        holder.setTvText(R.id.tv_publish_time, mSimpleDateFormat.format(new Date(itemData.getPublishTime())));
    }
}
