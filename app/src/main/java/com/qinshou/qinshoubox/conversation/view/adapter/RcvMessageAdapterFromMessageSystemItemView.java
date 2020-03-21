package com.qinshou.qinshoubox.conversation.view.adapter;

import android.content.Context;
import android.text.TextUtils;

import com.google.gson.Gson;
import com.qinshou.commonmodule.rcvbaseadapter.baseholder.BaseViewHolder;
import com.qinshou.qinshoubox.R;
import com.qinshou.qinshoubox.conversation.bean.GroupChatDetailBean;
import com.qinshou.qinshoubox.im.bean.UserDetailBean;
import com.qinshou.qinshoubox.im.IMClient;
import com.qinshou.qinshoubox.im.bean.GroupChatStatusBean;
import com.qinshou.qinshoubox.im.bean.MessageBean;
import com.qinshou.qinshoubox.im.enums.FriendStatus;
import com.qinshou.qinshoubox.im.enums.GroupChatStatus;
import com.qinshou.qinshoubox.im.enums.MessageContentType;
import com.qinshou.qinshoubox.im.enums.MessageType;
import com.qinshou.qinshoubox.im.listener.QSCallback;
import com.qinshou.qinshoubox.util.userstatusmanager.UserStatusManager;

import java.util.List;

/**
 * Description:类描述
 * Author: MrQinshou
 * Date: 19-12-25 下午9:48
 */
public class RcvMessageAdapterFromMessageSystemItemView extends AbsRcvMessageAdapterFromMessageItemView {

    public RcvMessageAdapterFromMessageSystemItemView(Context context, String groupChatId) {
        super(context, R.layout.item_rcv_message_from_message_system, groupChatId);
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
        GroupChatStatusBean groupChatStatusBean = new Gson().fromJson(messageBean.getExtend(), GroupChatStatusBean.class);
        if (FriendStatus.getByValue(groupChatStatusBean.getStatus()) != null) {
            showFriendStatusText(baseViewHolder, messageBean);
        } else if (GroupChatStatus.getByValue(groupChatStatusBean.getStatus()) != null) {
            showGroupChatStatusText(baseViewHolder, messageBean, groupChatStatusBean);
        }
    }

    private void showFriendStatusText(BaseViewHolder baseViewHolder, MessageBean messageBean) {
        UserDetailBean userDetailBean = IMClient.SINGLETON.getFriendManager().getById(messageBean.getFromUserId());
        String content = getContext().getResources().getString(R.string.chat_agree_add_text, TextUtils.isEmpty(userDetailBean.getRemark())
                ? userDetailBean.getNickname()
                : userDetailBean.getRemark());
        baseViewHolder.setTvText(R.id.tv_content, content);
    }

    private void showGroupChatStatusText(BaseViewHolder baseViewHolder, MessageBean messageBean, GroupChatStatusBean groupChatStatusBean) {
        if (groupChatStatusBean.getStatus() == GroupChatStatus.ADD.getValue()) {
            showGroupChatAddUI(baseViewHolder, groupChatStatusBean);
        } else if (groupChatStatusBean.getStatus() == GroupChatStatus.OTHER_ADD.getValue()) {
            showGroupChatOtherAddUI(baseViewHolder, groupChatStatusBean);
        } else if (groupChatStatusBean.getStatus() == GroupChatStatus.DELETE.getValue()) {
            showGroupChatDeleteUI(baseViewHolder, groupChatStatusBean);
        } else if (groupChatStatusBean.getStatus() == GroupChatStatus.OTHER_DELETE.getValue()) {
            showGroupChatOtherDeleteUI(baseViewHolder, groupChatStatusBean);
        } else if (groupChatStatusBean.getStatus() == GroupChatStatus.NICKNAME_CHANGED.getValue()) {
            showGroupChatNicknameChangedUI(baseViewHolder, groupChatStatusBean);
        }
    }

    private void showGroupChatAddUI(BaseViewHolder baseViewHolder, GroupChatStatusBean groupChatStatusBean) {
        StringBuilder stringBuilder = new StringBuilder();
        UserDetailBean fromUser = groupChatStatusBean.getFromUser();
        // 操作人优先显示备注,然后是群昵称,然后是昵称
        if (!TextUtils.isEmpty(fromUser.getRemark())) {
            stringBuilder.append(fromUser.getRemark());
        } else if (!TextUtils.isEmpty(fromUser.getNicknameInGroupChat())) {
            stringBuilder.append(fromUser.getNicknameInGroupChat());
        } else {
            stringBuilder.append(fromUser.getNickname());
        }
        stringBuilder.append("邀请");
        // 拼接被邀请人的昵称,优先显示备注,然后是群昵称,然后是昵称
        List<UserDetailBean> toUserList = groupChatStatusBean.getToUserList();
        for (int i = 0; toUserList != null && i < toUserList.size(); i++) {
            UserDetailBean toUser = toUserList.get(i);
            if (TextUtils.equals(toUser.getId(), UserStatusManager.SINGLETON.getUserBean().getId())) {
                stringBuilder.append("你、");
            } else {
                String nickname = TextUtils.isEmpty(toUser.getRemark())
                        ? toUser.getNickname()
                        : toUser.getRemark();
                stringBuilder.append(nickname)
                        .append("、");
            }
        }
        // 去掉最后一个 "、"
        int index = stringBuilder.lastIndexOf("、");
        if (index != -1) {
            stringBuilder.deleteCharAt(index);
        }
        stringBuilder.append("加入了群聊");
        baseViewHolder.setTvText(R.id.tv_content, stringBuilder);
    }

    private void showGroupChatOtherAddUI(BaseViewHolder baseViewHolder, GroupChatStatusBean groupChatStatusBean) {
        StringBuilder stringBuilder = new StringBuilder();
        UserDetailBean fromUser = groupChatStatusBean.getFromUser();
        // 操作人如果是自己,显示你
        if (TextUtils.equals(fromUser.getId(), UserStatusManager.SINGLETON.getUserBean().getId())) {
            stringBuilder.append("你");
        } else {
            // 操作人是别人,优先显示备注,然后是群昵称,然后是昵称
            if (!TextUtils.isEmpty(fromUser.getRemark())) {
                stringBuilder.append(fromUser.getRemark());
            } else if (!TextUtils.isEmpty(fromUser.getNicknameInGroupChat())) {
                stringBuilder.append(fromUser.getNicknameInGroupChat());
            } else {
                stringBuilder.append(fromUser.getNickname());
            }
        }
        stringBuilder.append("邀请");
        // 拼接被邀请人的昵称,优先显示备注,然后是群昵称,然后是昵称
        List<UserDetailBean> toUserList = groupChatStatusBean.getToUserList();
        for (int i = 0; toUserList != null && i < toUserList.size(); i++) {
            UserDetailBean toUser = toUserList.get(i);
            String nickname = TextUtils.isEmpty(toUser.getRemark())
                    ? toUser.getNickname()
                    : toUser.getRemark();
            stringBuilder.append(nickname)
                    .append("、");
        }
        // 去掉最后一个 "、"
        int index = stringBuilder.lastIndexOf("、");
        if (index != -1) {
            stringBuilder.deleteCharAt(index);
        }
        stringBuilder.append("加入了群聊");
        baseViewHolder.setTvText(R.id.tv_content, stringBuilder);
    }

    private void showGroupChatDeleteUI(BaseViewHolder baseViewHolder, GroupChatStatusBean groupChatStatusBean) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("你被");
        UserDetailBean fromUser = groupChatStatusBean.getFromUser();
        // 拼接踢出你的人的昵称,优先显示备注,然后是群昵称,然后是昵称
        String nickname = TextUtils.isEmpty(fromUser.getRemark())
                ? fromUser.getNickname()
                : fromUser.getRemark();
        stringBuilder.append(nickname)
                .append("移除群聊");
        baseViewHolder.setTvText(R.id.tv_content, stringBuilder);
    }

    private void showGroupChatOtherDeleteUI(BaseViewHolder baseViewHolder, GroupChatStatusBean groupChatStatusBean) {
        StringBuilder stringBuilder = new StringBuilder();
        UserDetailBean fromUser = groupChatStatusBean.getFromUser();
        // 操作人如果是自己,显示你
        if (TextUtils.equals(fromUser.getId(), UserStatusManager.SINGLETON.getUserBean().getId())) {
            stringBuilder.append("你");
        } else {
            // 操作人是别人,优先显示备注,然后是群昵称,然后是昵称
            if (!TextUtils.isEmpty(fromUser.getRemark())) {
                stringBuilder.append(fromUser.getRemark());
            } else if (!TextUtils.isEmpty(fromUser.getNicknameInGroupChat())) {
                stringBuilder.append(fromUser.getNicknameInGroupChat());
            } else {
                stringBuilder.append(fromUser.getNickname());
            }
        }
        stringBuilder.append("将");
        // 拼接被踢出人的昵称,优先显示备注,然后是群昵称,然后是昵称
        List<UserDetailBean> toUserList = groupChatStatusBean.getToUserList();
        for (int i = 0; toUserList != null && i < toUserList.size(); i++) {
            UserDetailBean toUser = toUserList.get(i);
            String nickname = TextUtils.isEmpty(toUser.getRemark())
                    ? toUser.getNickname()
                    : toUser.getRemark();
            stringBuilder.append(nickname)
                    .append("、");
        }
        // 去掉最后一个 "、"
        int index = stringBuilder.lastIndexOf("、");
        if (index != -1) {
            stringBuilder.deleteCharAt(index);
        }
        stringBuilder.append("移除群聊");
        baseViewHolder.setTvText(R.id.tv_content, stringBuilder);
    }

    private void showGroupChatNicknameChangedUI(BaseViewHolder baseViewHolder, GroupChatStatusBean groupChatStatusBean) {
        IMClient.SINGLETON.getGroupChatManager().getDetail(groupChatStatusBean.getGroupChatId(), new QSCallback<GroupChatDetailBean>() {
            @Override
            public void onSuccess(GroupChatDetailBean data) {
                StringBuilder stringBuilder = new StringBuilder();
                UserDetailBean fromUser = groupChatStatusBean.getFromUser();
                // 操作人如果是自己,显示你
                if (TextUtils.equals(fromUser.getId(), UserStatusManager.SINGLETON.getUserBean().getId())) {
                    stringBuilder.append("你");
                } else {
                    // 操作人是别人,优先显示备注,然后是群昵称,然后是昵称
                    if (!TextUtils.isEmpty(fromUser.getRemark())) {
                        stringBuilder.append(fromUser.getRemark());
                    } else if (!TextUtils.isEmpty(fromUser.getNicknameInGroupChat())) {
                        stringBuilder.append(fromUser.getNicknameInGroupChat());
                    } else {
                        stringBuilder.append(fromUser.getNickname());
                    }
                }
                stringBuilder.append("修改群名为\"")
                        .append(groupChatStatusBean.getGroupChatNickname())
                        .append("\"");
                baseViewHolder.setTvText(R.id.tv_content, stringBuilder);
            }

            @Override
            public void onFailure(Exception e) {

            }
        });

    }
}