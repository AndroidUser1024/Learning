package com.qinshou.qinshoubox.im.manager;

import com.qinshou.qinshoubox.friend.bean.UserDetailBean;
import com.qinshou.qinshoubox.im.cache.ICache;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2020/1/16 17:54
 * Description:群成员管理者
 */
public class GroupChatMemberManager extends AbsManager<String, UserDetailBean> {
    public GroupChatMemberManager(String userId, ICache<String, UserDetailBean> cache) {
        super(userId, cache);
    }
}
