package com.qinshou.commonmodule.rcvbaseadapter.itemview;

import android.content.Context;
import android.util.SparseArray;

import com.jeejio.commonmodule.rcvbaseadapter.RcvMultipleBaseAdapter;
import com.jeejio.commonmodule.rcvbaseadapter.baseholder.BaseViewHolder;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2020/4/11 11:56
 * Description:该布局被添加到 RcvMultipleBaseAdapter 中会被认为是脚布局,脚布局会按添加顺序倒序展示
 */
public class FooterItemView<T> extends BaseItemView<T> {

    public FooterItemView(Context context, int layoutId) {
        super(context, layoutId);
    }

    @Override
    public boolean isForViewType(T item, int position) {
        SparseArray<BaseItemView> footerItemViewSparseArray = ((RcvMultipleBaseAdapter<T>) getRcvBaseAdapter()).getFooterItemViewSparseArray();
        int key = footerItemViewSparseArray.keyAt(footerItemViewSparseArray.indexOfValue(this));
        return position == getRcvBaseAdapter().getItemCount() - 1 - key;
    }

    @Override
    public void bindViewHolder(BaseViewHolder holder, T itemData, int position) {

    }
}
