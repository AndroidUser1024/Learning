package com.qinshou.qinshoubox.im.listener;

import com.qinshou.qinshoubox.im.bean.UserDetailBean;

import java.util.List;

/**
 * Author: QinHao
 * Email:cqflqinhao@126.com
 * Date: 2019/12/7 14:18
 * Description:群状态监听器
 */
public interface IOnGroupChatStatusListener {
    void add(String groupChatId, UserDetailBean fromUser, List<UserDetailBean> toUserList);

    void delete(String groupChatId, UserDetailBean fromUser, List<UserDetailBean> toUserList);

    void otherAdd(String groupChatId, UserDetailBean fromUser, List<UserDetailBean> toUserList);

    void otherDelete(String groupChatId, UserDetailBean fromUser, List<UserDetailBean> toUserList);

    void nicknameChanged(String groupChatId, UserDetailBean fromUser, List<UserDetailBean> toUserList);
}
