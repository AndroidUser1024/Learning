package com.qinshou.qinshoubox.im.listener;

import com.qinshou.qinshoubox.im.bean.GroupChatBean;
import com.qinshou.qinshoubox.im.bean.GroupChatDetailBean;
import com.qinshou.qinshoubox.im.bean.UserDetailBean;

import java.util.List;

/**
 * Author: QinHao
 * Email:cqflqinhao@126.com
 * Date: 2019/12/7 14:18
 * Description:群状态监听器
 */
public interface IOnGroupChatStatusListener {
    void add(GroupChatDetailBean groupChat, UserDetailBean fromUser, List<UserDetailBean> toUserList);

    void delete(GroupChatDetailBean groupChat, UserDetailBean fromUser, List<UserDetailBean> toUserList);

    void otherAdd(GroupChatDetailBean groupChat, UserDetailBean fromUser, List<UserDetailBean> toUserList);

    void otherDelete(GroupChatDetailBean groupChat, UserDetailBean fromUser, List<UserDetailBean> toUserList);

    void nicknameChanged(GroupChatDetailBean groupChat, UserDetailBean fromUser, List<UserDetailBean> toUserList);
}
