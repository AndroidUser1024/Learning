package com.qinshou.qinshoubox.me.ui.adapter;

import android.content.Context;

import com.qinshou.commonmodule.rcvbaseadapter.RcvSingleBaseAdapter;
import com.qinshou.commonmodule.rcvbaseadapter.baseholder.BaseViewHolder;
import com.qinshou.qinshoubox.R;
import com.qinshou.qinshoubox.me.bean.KlotskiBean;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2020/5/19 16:23
 * Description:华容道适配器
 */
public class RcvKlotskiAdapter extends RcvSingleBaseAdapter<KlotskiBean> {
    public RcvKlotskiAdapter(Context context) {
        super(context, R.layout.item_rcv_klotski);
    }

    @Override
    public void bindViewHolder(BaseViewHolder holder, KlotskiBean itemData, int position) {
        holder.setTvText(R.id.tv_klotski_item, "");
        if (itemData != null) {
            holder.setTvText(R.id.tv_klotski_item, itemData.getText());
        }
    }
}
