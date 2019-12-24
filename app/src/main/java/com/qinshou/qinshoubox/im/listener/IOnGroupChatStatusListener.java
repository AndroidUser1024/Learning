package com.qinshou.qinshoubox.im.listener;

/**
 * Author: QinHao
 * Email:cqflqinhao@126.com
 * Date: 2019/12/7 14:18
 * Description:群状态监听器
 */
public interface IOnGroupChatStatusListener {
    void add(String groupChatId, String fromUserId, String toUserId);

    void delete(String groupChatId, String fromUserId, String toUserId);

    void otherAdd(String groupChatId, String fromUserId, String toUserId);

    void otherDelete(String groupChatId, String fromUserId, String toUserId);

    void nicknameChanged(String groupChatId, String fromUserId, String toUserId);
}
