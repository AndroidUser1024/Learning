package com.qinshou.qinshoubox.conversation.view.adapter;

import android.content.Context;

import com.qinshou.commonmodule.rcvbaseadapter.RcvSingleBaseAdapter;
import com.qinshou.commonmodule.rcvbaseadapter.baseholder.BaseViewHolder;
import com.qinshou.immodule.bean.ConversationBean;
import com.qinshou.qinshoubox.R;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/8/7 15:32
 * Description:会话列表适配器
 */
public class RcvConversationAdapter extends RcvSingleBaseAdapter<ConversationBean> {
    private String[] mWeekArray;

    public RcvConversationAdapter(Context context) {
        super(context, R.layout.item_rcv_conversation);
        mWeekArray = context.getResources().getStringArray(R.array.conversation_tv_last_msg_time_text);
    }

    @Override
    public void bindViewHolder(final BaseViewHolder baseViewHolder, final ConversationBean conversationBean, final int i) {
    }
}