package com.qinshou.qinshoubox.me.ui.adapter;

import android.content.Context;
import android.text.TextUtils;

import com.qinshou.commonmodule.rcvbaseadapter.baseholder.BaseViewHolder;
import com.qinshou.immodule.bean.MessageBean;
import com.qinshou.immodule.bean.MessageContentType;
import com.qinshou.immodule.chat.ChatManager;
import com.qinshou.qinshoubox.R;


/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/7/12 14:32
 * Description:收到的消息,消息类型为普通文本
 */
public class RcvMessageAdapterFromMessageTextItemView extends AbsRcvMessageAdapterFromMessageItemView {
    public RcvMessageAdapterFromMessageTextItemView(Context context) {
        super(context, R.layout.item_rcv_message_from_message_text);
    }

    @Override
    public boolean isForViewType(MessageBean item, int position) {
        // 消息来源与当前登录的用户名不同,则是收到的消息
        return item.getFromUserId() != ChatManager.SINGLETON.getUserId()
                && item.getContentType() == MessageContentType.TEXT.getValue();
    }

    @Override
    public void bindViewHolder(final BaseViewHolder baseViewHolder, final MessageBean messageBean, int i) {
        super.bindViewHolder(baseViewHolder, messageBean, i);
        // 消息内容
        baseViewHolder.setTvText(R.id.tv_content, messageBean.getContent());
    }
}