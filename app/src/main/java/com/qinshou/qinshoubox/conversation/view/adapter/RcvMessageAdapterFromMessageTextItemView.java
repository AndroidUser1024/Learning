package com.qinshou.qinshoubox.conversation.view.adapter;

import android.content.Context;

import com.qinshou.commonmodule.rcvbaseadapter.baseholder.BaseViewHolder;
import com.qinshou.qinshoubox.R;
import com.qinshou.qinshoubox.im.bean.MessageBean;


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
//        return item.getFromUserId() != UserStatusManager.SINGLETON.getUserBean().getId()
//                && item.getContentType() == MessageContentType.TEXT.getValue();
        return true;
    }

    @Override
    public void bindViewHolder(final BaseViewHolder baseViewHolder, final MessageBean messageBean, int i) {
        super.bindViewHolder(baseViewHolder, messageBean, i);
        // 头像
//        FriendBean friendBean = IMClient.SINGLETON.getFriendManager().getFriend(messageBean.getFromUserId());
//        if (friendBean != null) {
//            ImageLoadUtil.SINGLETON.loadImage(getContext(), friendBean.getHeadImgSmall(), baseViewHolder.getImageView(R.id.iv_head_img));
//        }
        // 消息内容
        baseViewHolder.setTvText(R.id.tv_content, messageBean.getContent());
    }
}