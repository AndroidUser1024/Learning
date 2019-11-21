package com.qinshou.immodule.listener;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/11/21 10:41
 * Description:好友状态监听器
 */
public interface IOnFriendStatusListener {
    void add(int fromUserId, String additionalMsg);

    void agreeAdd(int fromUserId);

    void refuseAdd(int fromUserId);

    void delete(int fromUserId);

    void online(int fromUserId);

    void offline(int fromUserId);
}
