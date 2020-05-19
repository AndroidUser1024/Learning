package com.qinshou.qinshoubox.me.ui.adapter;

import android.content.Context;

import com.qinshou.commonmodule.rcvbaseadapter.RcvBaseAdapter;
import com.qinshou.commonmodule.rcvbaseadapter.baseholder.BaseViewHolder;
import com.qinshou.qinshoubox.R;
import com.qinshou.qinshoubox.me.bean.PuzzleItemBean;

/**
 * Description:放拼图块的适配器
 * Created by 禽兽先生
 * Created on 2018/8/30
 */
public class RcvPuzzleAdapter extends RcvBaseAdapter<PuzzleItemBean> {

    public RcvPuzzleAdapter(Context context) {
        super(context, R.layout.item_rcv_puzzle);
    }

    @Override
    public void bindViewHolder(BaseViewHolder holder, PuzzleItemBean itemData, int position) {
        holder.setIvImage(R.id.iv_puzzle_item, itemData.getBitmap());
    }
}
