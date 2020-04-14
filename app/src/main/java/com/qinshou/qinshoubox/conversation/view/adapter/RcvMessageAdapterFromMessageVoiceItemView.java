package com.qinshou.qinshoubox.conversation.view.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;

import com.google.gson.Gson;
import com.qinshou.commonmodule.rcvbaseadapter.baseholder.BaseViewHolder;
import com.qinshou.qinshoubox.R;
import com.qinshou.qinshoubox.conversation.bean.VoiceBean;
import com.qinshou.qinshoubox.im.bean.MessageBean;
import com.qinshou.qinshoubox.im.enums.MessageContentType;
import com.qinshou.qinshoubox.util.userstatusmanager.UserStatusManager;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/7/12 14:32
 * Description:收到的消息,消息类型为语音
 */
public class RcvMessageAdapterFromMessageVoiceItemView extends AbsRcvMessageAdapterFromMessageItemView {

    public RcvMessageAdapterFromMessageVoiceItemView(Context context, String groupChatId) {
        super(context, R.layout.item_rcv_message_from_message_voice, groupChatId);
    }

    @Override
    public boolean isForViewType(MessageBean item, int position) {
        // 消息来源与当前登录的用户名不同,则是收到的消息
        return item.getContentType() == MessageContentType.VOICE.getValue()
                && !TextUtils.equals(item.getFromUserId(), UserStatusManager.SINGLETON.getUserBean().getId());
    }

    @Override
    public void bindViewHolder(final BaseViewHolder baseViewHolder, final MessageBean messageBean, final int i) {
        super.bindViewHolder(baseViewHolder, messageBean, i);
        // 消息内容
        VoiceBean voiceBean = new Gson().fromJson(messageBean.getExtend(), VoiceBean.class);
        StringBuilder stringBuilder = new StringBuilder();
        int time = (int) (voiceBean.getTime() / 1000);
        for (int a = 0; a < time; a++) {
            stringBuilder.append(" ");
        }
        baseViewHolder.setTvText(R.id.tv_placeholder, stringBuilder);
        baseViewHolder.setTvText(R.id.tv_voice_time, time + "\"");
//        // 该条语音消息是否已读 0为未读  1为已读
//        if (voiceBean.getUnread() == 0) {
//            baseViewHolder.setVisibility(R.id.iv_voice_unread, View.VISIBLE);
//        } else if (voiceBean.getUnread() == 1) {
//            baseViewHolder.setVisibility(R.id.iv_voice_unread, View.GONE);
//        }

        // 因为 item 的复用,虽然数据不会错乱,但是如果修改了一个 item 的控件
        // 那么复用该 ViewHolder 的 item 的状态和背景也会一起变化,所以需要设置当前条目的语音播放动画控件
        // 如果当前条目是正在播放的,则播放动画,否则设置静态图片
        if (i == ((RcvMessageAdapter) getRcvBaseAdapter()).getCurrentPlayPosition()) {
            ((RcvMessageAdapter) getRcvBaseAdapter()).updateVoiceUI(baseViewHolder, true, true);
        } else {
            baseViewHolder.setIvImage(R.id.iv_voice_from, R.drawable.chat_iv_voice_from_3);
        }
        // 点击播放
        baseViewHolder.setOnClickListener(R.id.ll_content, new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                ((RcvMessageAdapter) getRcvBaseAdapter()).playVoice(baseViewHolder, messageBean, i, true);
            }
        });
    }
}
