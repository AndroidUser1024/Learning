package com.qinshou.qinshoubox.me.adapter;

import android.content.Context;

import com.qinshou.commonmodule.rcvbaseadapter.RcvSingleBaseAdapter;
import com.qinshou.commonmodule.rcvbaseadapter.baseholder.BaseViewHolder;
import com.qinshou.commonmodule.util.ShowLogUtil;
import com.qinshou.qinshoubox.R;

import java.util.List;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/11/14 14:02
 * Description:类描
 */
public class RcvTestAdapter extends RcvSingleBaseAdapter<String> implements IOnItemMoveCallback {

    public RcvTestAdapter(Context context) {
        super(context, R.layout.item_rcv_test);
    }

    @Override
    public void bindViewHolder(BaseViewHolder holder, String itemData, int position) {
        holder.setTvText(R.id.tv_test, itemData);
    }

    @Override
    public void onItemMove(int fromPosition, int toPosition) {
        List<String> dataList = getDataList();
        String itemData = dataList.get(fromPosition);
        dataList.remove(fromPosition);
        dataList.add(toPosition, itemData);
        // 通知数据发生移动
        notifyItemMoved(fromPosition, toPosition);
        ShowLogUtil.logi(dataList);
    }
}
