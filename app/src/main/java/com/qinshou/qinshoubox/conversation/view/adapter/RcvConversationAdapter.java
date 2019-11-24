package com.qinshou.qinshoubox.conversation.view.adapter;

import android.content.Context;

import com.qinshou.commonmodule.rcvbaseadapter.RcvSingleBaseAdapter;
import com.qinshou.commonmodule.rcvbaseadapter.baseholder.BaseViewHolder;
import com.qinshou.commonmodule.rcvbaseadapter.listener.IOnItemClickListener;
import com.qinshou.imagemodule.util.ImageLoadUtil;
import com.qinshou.immodule.bean.ConversationBean;
import com.qinshou.immodule.enums.MessageType;
import com.qinshou.qinshoubox.R;
import com.qinshou.qinshoubox.conversation.view.activity.ChatActivity;
import com.qinshou.qinshoubox.conversation.view.activity.GroupChatActivity;

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
        setOnItemClickListener(new IOnItemClickListener<ConversationBean>() {
            @Override
            public void onItemClick(BaseViewHolder holder, ConversationBean itemData, int position) {
                if (itemData.getType() == MessageType.CHAT.getValue()) {
                    ChatActivity.start(getContext(), itemData.getToUserId());
                } else if (itemData.getType() == MessageType.GROUP_CHAT.getValue()) {
                    GroupChatActivity.start(getContext(), itemData.getToUserId());
                }
            }
        });
    }

    @Override
    public void bindViewHolder(final BaseViewHolder baseViewHolder, final ConversationBean conversationBean, final int i) {
        ImageLoadUtil.SINGLETON.loadImage(getContext(), conversationBean.getHeadImgSmall(), baseViewHolder.getImageView(R.id.iv_head_img));
        baseViewHolder.setTvText(R.id.tv_title, conversationBean.getTitle());
        baseViewHolder.setTvText(R.id.tv_last_msg_content, conversationBean.getLastMsgContent());
    }
}