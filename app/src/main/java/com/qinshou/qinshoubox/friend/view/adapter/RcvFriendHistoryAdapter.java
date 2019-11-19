package com.qinshou.qinshoubox.friend.view.adapter;

import android.content.Context;

import com.qinshou.commonmodule.rcvbaseadapter.RcvSingleBaseAdapter;
import com.qinshou.commonmodule.rcvbaseadapter.baseholder.BaseViewHolder;
import com.qinshou.qinshoubox.R;
import com.qinshou.qinshoubox.friend.bean.FriendHistoryBean;


/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/9/4 9:06
 * Description:好友申请历史列表适配器
 */
public class RcvFriendHistoryAdapter extends RcvSingleBaseAdapter<FriendHistoryBean> {

    public RcvFriendHistoryAdapter(Context context) {
        super(context, R.layout.item_rcv_friend_history);
    }

    @Override
    public void bindViewHolder(final BaseViewHolder baseViewHolder, final FriendHistoryBean friendHistoryBean, int i) {
    }
}
