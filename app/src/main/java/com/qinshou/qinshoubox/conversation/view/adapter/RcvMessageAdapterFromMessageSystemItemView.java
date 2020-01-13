package com.qinshou.qinshoubox.conversation.view.adapter;

import android.content.Context;
import android.text.TextUtils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.qinshou.commonmodule.rcvbaseadapter.baseholder.BaseViewHolder;
import com.qinshou.commonmodule.util.ShowLogUtil;
import com.qinshou.okhttphelper.callback.Callback;
import com.qinshou.qinshoubox.R;
import com.qinshou.qinshoubox.conversation.bean.GroupChatDetailBean;
import com.qinshou.qinshoubox.friend.bean.UserDetailBean;
import com.qinshou.qinshoubox.im.IMClient;
import com.qinshou.qinshoubox.im.bean.FriendBean;
import com.qinshou.qinshoubox.im.bean.GroupChatBean;
import com.qinshou.qinshoubox.im.bean.MessageBean;
import com.qinshou.qinshoubox.im.enums.FriendStatus;
import com.qinshou.qinshoubox.im.enums.GroupChatStatus;
import com.qinshou.qinshoubox.im.enums.MessageContentType;
import com.qinshou.qinshoubox.im.enums.MessageType;
import com.qinshou.qinshoubox.util.userstatusmanager.UserStatusManager;

import org.w3c.dom.Text;

import java.lang.reflect.Type;
import java.util.List;
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
        if (item.getContentType() != MessageContentType.SYSTEM.getValue()) {
            return false;
        }
        if (item.getType() == MessageType.CHAT.getValue()) {
            return !TextUtils.equals(item.getFromUserId(), UserStatusManager.SINGLETON.getUserBean().getId());
        }
        if (item.getType() == MessageType.GROUP_CHAT.getValue()) {
            return true;
        }
        return false;
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
        if (FriendStatus.getByValue(status) != null) {
            showFriendStatusText(baseViewHolder, messageBean);
        } else if (GroupChatStatus.getByValue(status) != null) {
            List<String> toUserIdList = (List<String>) map.get("toUserIdList");
            showGroupChatStatusText(baseViewHolder, messageBean, GroupChatStatus.getByValue(status), toUserIdList);
        }
    }

    private void showFriendStatusText(BaseViewHolder baseViewHolder, MessageBean messageBean) {
        FriendBean friendBean = IMClient.SINGLETON.getFriendManager().getById(messageBean.getFromUserId());
        String content = getContext().getResources().getString(R.string.chat_agree_add_text, TextUtils.isEmpty(friendBean.getRemark())
                ? friendBean.getNickname()
                : friendBean.getRemark());
        baseViewHolder.setTvText(R.id.tv_content, content);
    }

    private void showGroupChatStatusText(final BaseViewHolder baseViewHolder, final MessageBean messageBean, final GroupChatStatus groupChatStatus, final List<String> toUserIdList) {
        final GroupChatBean groupChatBean = IMClient.SINGLETON.getGroupChatManager().getById(messageBean.getToUserId());
        IMClient.SINGLETON.getGroupChatManager().getMemberList(groupChatBean.getId(), new Callback<List<UserDetailBean>>() {
            @Override
            public void onSuccess(List<UserDetailBean> data) {
                StringBuilder stringBuilder = new StringBuilder();
                if (groupChatStatus == GroupChatStatus.ADD) {
                    if (TextUtils.equals(messageBean.getFromUserId(), UserStatusManager.SINGLETON.getUserBean().getId())) {
                        stringBuilder.append("你邀请");
                        for (int i = 0; toUserIdList != null && i < toUserIdList.size(); i++) {
                            String toUserId = toUserIdList.get(i);
                            if (TextUtils.equals(toUserId, UserStatusManager.SINGLETON.getUserBean().getId())) {
                                continue;
                            }
                            for (int j = 0; data != null && j < data.size(); j++) {
                                UserDetailBean userDetailBean = data.get(j);
                                if (!TextUtils.equals(toUserId, userDetailBean.getId())) {
                                    continue;
                                }
                                String nickname = TextUtils.isEmpty(userDetailBean.getRemark())
                                        ? userDetailBean.getNickname()
                                        : userDetailBean.getRemark();
                                stringBuilder.append(nickname)
                                        .append("、");
                                break;
                            }
                        }
                        int index = stringBuilder.lastIndexOf("、");
                        if (index != -1) {
                            stringBuilder.deleteCharAt(index);
                        }
                        stringBuilder.append("加入了群聊");
                    } else {
                        for (int i = 0; data != null && i < data.size(); i++) {
                            UserDetailBean userDetailBean = data.get(i);
                            if (!TextUtils.equals(messageBean.getFromUserId(), userDetailBean.getId())) {
                                continue;
                            }
                            String nickname = TextUtils.isEmpty(userDetailBean.getRemark())
                                    ? userDetailBean.getNickname()
                                    : userDetailBean.getRemark();
                            stringBuilder.append(nickname)
                                    .append("邀请");
                            break;
                        }
                        for (int i = 0; toUserIdList != null && i < toUserIdList.size(); i++) {
                            String toUserId = toUserIdList.get(i);
                            if (TextUtils.equals(toUserId, messageBean.getFromUserId())) {
                                continue;
                            }
                            for (int j = 0; data != null && j < data.size(); j++) {
                                UserDetailBean userDetailBean = data.get(i);
                                if (!TextUtils.equals(toUserId, userDetailBean.getId())) {
                                    continue;
                                }
                                String nickname;
                                if (TextUtils.equals(userDetailBean.getId(), UserStatusManager.SINGLETON.getUserBean().getId())) {
                                    nickname = "你";
                                } else {
                                    nickname = TextUtils.isEmpty(userDetailBean.getRemark())
                                            ? userDetailBean.getNickname()
                                            : userDetailBean.getRemark();
                                }
                                stringBuilder.append(nickname)
                                        .append("、");
                                break;
                            }
                        }
                        int index = stringBuilder.lastIndexOf("、");
                        if (index != -1) {
                            stringBuilder.deleteCharAt(index);
                        }
                        stringBuilder.append("加入了群聊");
                    }
                }
                baseViewHolder.setTvText(R.id.tv_content, stringBuilder);
            }

            @Override
            public void onFailure(Exception e) {

            }
        });

//        String content = getContext().getResources().getString(R.string.chat_agree_add_text, TextUtils.isEmpty(friendBean.getRemark())
//                ? friendBean.getNickname()
//                : friendBean.getRemark());
//        baseViewHolder.setTvText(R.id.tv_content, content);
    }
}