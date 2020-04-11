package com.qinshou.commonmodule.rcvbaseadapter.itemview;

import android.content.Context;
import android.util.SparseArray;

import com.qinshou.commonmodule.rcvbaseadapter.RcvMultipleBaseAdapter;
import com.qinshou.commonmodule.rcvbaseadapter.baseholder.BaseViewHolder;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2020/4/11 11:56
 * Description:该布局被添加到 RcvMultipleBaseAdapter 中会被认为是头布局,脚布局会按添加顺序正序展示
 */
public class HeaderItemView<T> extends BaseItemView<T> {

    public HeaderItemView(Context context, int layoutId) {
        super(context, layoutId);
    }

    @Override
    public boolean isForViewType(T item, int position) {
        SparseArray<BaseItemView> headerItemViewSparseArray = ((RcvMultipleBaseAdapter<T>) getRcvBaseAdapter()).getHeaderItemViewSparseArray();
        int key = headerItemViewSparseArray.keyAt(headerItemViewSparseArray.indexOfValue(this));
        return position == key;
    }

    @Override
    public void bindViewHolder(BaseViewHolder holder, T itemData, int position) {

    }
}
