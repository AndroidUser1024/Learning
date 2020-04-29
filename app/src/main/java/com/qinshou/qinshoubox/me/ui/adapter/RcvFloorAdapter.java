package com.qinshou.qinshoubox.me.ui.adapter;

import android.content.Context;

import com.qinshou.commonmodule.rcvbaseadapter.RcvBaseAdapter;
import com.qinshou.commonmodule.rcvbaseadapter.baseholder.BaseViewHolder;
import com.qinshou.qinshoubox.R;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2020/04/28 22:17
 * Description:楼层列表适配器
 */
public class RcvFloorAdapter extends RcvBaseAdapter<String> {

    public RcvFloorAdapter(Context context) {
        super(context, R.layout.item_rcv_floor);
    }

    @Override
    public void bindViewHolder(BaseViewHolder holder, String itemData, int position) {
        holder.setTvText(R.id.tv_floor, itemData);
    }
}
