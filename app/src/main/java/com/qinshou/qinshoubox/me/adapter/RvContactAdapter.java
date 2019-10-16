package com.qinshou.qinshoubox.me.adapter;

import android.content.Context;

import com.qinshou.commonmodule.rcvbaseadapter.RcvBaseAdapter;
import com.qinshou.commonmodule.rcvbaseadapter.baseholder.BaseViewHolder;
import com.qinshou.qinshoubox.R;
import com.qinshou.qinshoubox.me.bean.ContactBean;

/**
 * Description:通讯录列表的适配器
 * Created by 禽兽先生
 * Created on 2018/8/6
 */

public class RvContactAdapter extends RcvBaseAdapter<ContactBean> {
    public RvContactAdapter(Context context) {
        super(context, R.layout.item_rv_contact);
    }

    @Override
    public void bindViewHolder(BaseViewHolder holder, ContactBean itemData, int position) {
        holder.setTvText(R.id.tv_name, itemData.getName());
        holder.setTvText(R.id.tv_phone_number, itemData.getPhoneNumber());
    }
}
