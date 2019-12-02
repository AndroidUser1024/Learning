package com.qinshou.qinshoubox.conversation.view.adapter;

import android.content.Context;

import com.qinshou.commonmodule.rcvbaseadapter.RcvMultipleBaseAdapter;

/**
 * Author：WangGuifa
 * Email：wangguifa@jeejio.com
 * Date：2019/8/12 16:31
 * Description：群聊成员适配器
 */
public class RcvGroupChatMemberAdapter extends RcvMultipleBaseAdapter {
    public RcvGroupChatMemberAdapter(Context context) {
        super(context);
        addItemView(new RcvGroupChatMemberItemView(context));
        addItemView(new RcvGroupChatMemberFunctionItemView(context));
    }
}
