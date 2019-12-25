package com.qinshou.qinshoubox.conversation.view.adapter;

import android.content.Context;
import android.text.TextUtils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.qinshou.commonmodule.rcvbaseadapter.baseholder.BaseViewHolder;
import com.qinshou.commonmodule.util.ShowLogUtil;
import com.qinshou.qinshoubox.R;
import com.qinshou.qinshoubox.im.IMClient;
import com.qinshou.qinshoubox.im.bean.FriendBean;
import com.qinshou.qinshoubox.im.bean.MessageBean;
import com.qinshou.qinshoubox.im.enums.FriendStatus;
import com.qinshou.qinshoubox.im.enums.MessageContentType;
import com.qinshou.qinshoubox.util.userstatusmanager.UserStatusManager;

import java.lang.reflect.Type;
import java.util.Map;

/**
 * Description:类描述
 * Author: MrQinshou
 * Date: 19-12-25 下午9:48
 */
public class RcvMessageAdapterFromMessageSystemItemView extends AbsRcvMessageAdapterFromMessageItemView {

    public RcvMessageAdapterFromMessageSystemItemView(Context context) {
        super(context, R.layout.item_rcv_message_from_message_system);
    }

    @Override
    public boolean isForViewType(MessageBean item, int position) {
        // 消息来源与当前登录的用户名不同,则是收到的消息
        return !TextUtils.equals(item.getFromUserId(), UserStatusManager.SINGLETON.getUserBean().getId())
                && item.getContentType() == MessageContentType.SYSTEM.getValue();
    }

    @Override
    public void bindViewHolder(final BaseViewHolder baseViewHolder, final MessageBean messageBean, int position) {
//        super.bindViewHolder(baseViewHolder, messageBean, position);
        setTime(baseViewHolder, messageBean, position);
        // 消息内容
        Type type = new TypeToken<Map<String, Object>>() {
        }.getType();
        Map<String, Object> map = new Gson().fromJson(messageBean.getExtend(), type);
        Number number = (Number) map.get("status");
        int status = number.intValue();
        FriendStatus friendStatus = FriendStatus.getByValue(status);
        if (friendStatus == null) {
            return;
        }
        FriendBean friendBean = IMClient.SINGLETON.getFriendManager().getById(messageBean.getFromUserId());
        String content = getContext().getResources().getString(R.string.chat_agree_add_text, TextUtils.isEmpty(friendBean.getRemark())
                ? friendBean.getNickname()
                : friendBean.getRemark());
        baseViewHolder.setTvText(R.id.tv_content, content);
    }
}