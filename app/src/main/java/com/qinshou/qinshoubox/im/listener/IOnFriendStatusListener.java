package com.qinshou.qinshoubox.im.listener;

import com.qinshou.qinshoubox.im.bean.UserDetailBean;

/**
 * Author: QinHao
 * Email:cqflqinhao@126.com
 * Date: 2019/11/21 10:41
 * Description:好友状态监听器
 */
public interface IOnFriendStatusListener {
    void add(UserDetailBean fromUser, boolean newFriend);

    void agreeAdd(UserDetailBean fromUser);

    void refuseAdd(UserDetailBean fromUser);

    void delete(UserDetailBean fromUser);

    void online(UserDetailBean fromUser);

    void offline(UserDetailBean fromUser);
}
