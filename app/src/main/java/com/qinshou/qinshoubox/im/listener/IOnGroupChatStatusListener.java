package com.qinshou.qinshoubox.im.listener;

import java.util.List;

/**
 * Author: QinHao
 * Email:cqflqinhao@126.com
 * Date: 2019/12/7 14:18
 * Description:群状态监听器
 */
public interface IOnGroupChatStatusListener {
    void add(String groupChatId, String fromUserId, List<String> toUserIdList);

    void delete(String groupChatId, String fromUserId, List<String> toUserIdList);

    void otherAdd(String groupChatId, String fromUserId, List<String> toUserIdList);

    void otherDelete(String groupChatId, String fromUserId, List<String> toUserIdList);

    void nicknameChanged(String groupChatId, String fromUserId, List<String> toUserIdList);
}
