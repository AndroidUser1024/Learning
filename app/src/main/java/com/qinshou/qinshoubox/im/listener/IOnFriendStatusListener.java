package com.qinshou.qinshoubox.im.listener;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/11/21 10:41
 * Description:好友状态监听器
 */
public interface IOnFriendStatusListener {
    void add(String fromUserId, String additionalMsg, boolean newFriend);

    void agreeAdd(String fromUserId);

    void refuseAdd(String fromUserId);

    void delete(String fromUserId);

    void online(String fromUserId);

    void offline(String fromUserId);
}
