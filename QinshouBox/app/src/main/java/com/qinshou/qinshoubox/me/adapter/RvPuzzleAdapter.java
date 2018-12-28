package com.qinshou.qinshoubox.me.adapter;

import android.content.Context;

import com.qinshou.commonmodule.adapter.RcvBaseAdapter;
import com.qinshou.commonmodule.adapter.holder.BaseViewHolder;
import com.qinshou.qinshoubox.R;
import com.qinshou.qinshoubox.me.bean.PuzzleItemBean;

/**
 * Description:放拼图块的适配器
 * Created by 禽兽先生
 * Created on 2018/8/30
 */
public class RvPuzzleAdapter extends RcvBaseAdapter<PuzzleItemBean> {

    public RvPuzzleAdapter(Context context) {
        super(context, R.layout.item_rv_puzzle);
    }

    @Override
    public void bindViewHolder(BaseViewHolder holder, PuzzleItemBean itemData, int position) {
        holder.setIvImage(R.id.iv_puzzle_item, itemData.getBitmap());
    }
}
