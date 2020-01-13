package com.qinshou.qinshoubox.conversation.view.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.widget.TextView;

import com.qinshou.commonmodule.rcvbaseadapter.baseholder.BaseViewHolder;
import com.qinshou.qinshoubox.R;
import com.qinshou.qinshoubox.im.bean.MessageBean;
import com.qinshou.qinshoubox.im.enums.MessageContentType;
import com.qinshou.qinshoubox.util.userstatusmanager.UserStatusManager;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/7/12 14:32
 * Description:发送的消息
 */
public class RcvMessageAdapterToMessageTextItemView extends AbsRcvMessageAdapterToMessageItemView {

    public RcvMessageAdapterToMessageTextItemView(Context context) {
        super(context, R.layout.item_rcv_message_to_message_text);
    }

    @Override
    public boolean isForViewType(MessageBean item, int position) {
        // 消息来源与当前登录的用户 id 相同,则是发送的消息
        return item.getContentType() == MessageContentType.TEXT.getValue()
                && TextUtils.equals(item.getFromUserId(), UserStatusManager.SINGLETON.getUserBean().getId());
    }

    @Override
    public void bindViewHolder(final BaseViewHolder baseViewHolder, final MessageBean messageBean, final int i) {
        super.bindViewHolder(baseViewHolder, messageBean, i);
//        // 单聊不显示昵称,群聊才显示昵称
//        baseViewHolder.setVisibility(R.id.tv_nickname, messageBean.getType() == MessageType.CHAT.getValue()
//                ? View.GONE
//                : View.VISIBLE);
        // 昵称
//        baseViewHolder.setTvText(R.id.tv_nickname, JMClient.SINGLETON.getUserBean().getUserName());
        // 消息内容
        final TextView tvContent = baseViewHolder.findViewById(R.id.tv_content);
        // 普通文本
        tvContent.setText(messageBean.getContent());
    }
}
