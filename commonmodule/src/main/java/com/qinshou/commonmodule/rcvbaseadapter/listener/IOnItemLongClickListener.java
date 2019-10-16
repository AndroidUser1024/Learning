package com.qinshou.commonmodule.rcvbaseadapter.listener;


import com.qinshou.commonmodule.rcvbaseadapter.baseholder.BaseViewHolder;

/**
 * Description:RcvBaseAdapter 适配器 Item 的长按点击监听器
 * Created by 禽兽先生
 * Created on 2018/3/8
 */

public interface IOnItemLongClickListener<T> {
    void onItemLongClick(BaseViewHolder holder, T itemData, int position);
}