package com.qinshou.commonmodule.rcvbaseadapter.listener;


import com.qinshou.commonmodule.rcvbaseadapter.baseholder.BaseViewHolder;

/**
 * Description:RcvBaseAdapter 适配器 Item 的点击监听器
 * Created by 禽兽先生
 * Created on 2018/3/8
 */

public interface IOnItemClickListener<T> {
    void onItemClick(BaseViewHolder holder, T itemData, int position);
}