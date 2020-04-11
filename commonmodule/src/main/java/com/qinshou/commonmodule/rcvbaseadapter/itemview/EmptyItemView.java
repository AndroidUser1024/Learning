package com.qinshou.commonmodule.rcvbaseadapter.itemview;

import android.content.Context;

import com.qinshou.commonmodule.rcvbaseadapter.baseholder.BaseViewHolder;


/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2020/4/10 11:04
 * Description:该布局被添加到 RcvMultipleBaseAdapter 中会被认为是空布局
 */
public class EmptyItemView<T> extends BaseItemView<T> {

    public EmptyItemView(Context context, int layoutId) {
        super(context, layoutId);
    }

    @Override
    public boolean isForViewType(T item, int position) {
        return getRcvBaseAdapter().getDataList().size() == 0;
    }

    @Override
    public void bindViewHolder(BaseViewHolder holder, T itemData, int position) {

    }
}
