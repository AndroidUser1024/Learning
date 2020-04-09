package com.qinshou.qinshoubox.me.ui.adapter;

import android.content.Context;

import com.qinshou.commonmodule.rcvbaseadapter.RcvSingleBaseAdapter;
import com.qinshou.commonmodule.rcvbaseadapter.baseholder.BaseViewHolder;
import com.qinshou.qinshoubox.R;
import com.qinshou.qinshoubox.me.bean.MediaSourceBean;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2020/4/9 16:39
 * Description:播放列表适配器
 */
public class RcvPlayListAdapter extends RcvSingleBaseAdapter<MediaSourceBean> {
    public RcvPlayListAdapter(Context context) {
        super(context, R.layout.item_rcv_play_list);
    }

    @Override
    public void bindViewHolder(BaseViewHolder holder, MediaSourceBean itemData, int position) {
        holder.setTvText(R.id.tv_title, itemData.getTitle());
    }
}
