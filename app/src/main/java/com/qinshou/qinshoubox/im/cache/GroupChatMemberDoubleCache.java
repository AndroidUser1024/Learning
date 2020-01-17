package com.qinshou.qinshoubox.im.cache;

import com.qinshou.qinshoubox.friend.bean.UserDetailBean;
import com.qinshou.qinshoubox.im.bean.GroupChatBean;

/**
 * Author: QinHao
 * Email:cqflqinhao@126.com
 * Date: 2020/1/4 19:55
 * Description:群成员双重缓存
 */
public class GroupChatMemberDoubleCache extends AbsDoubleCache<String, UserDetailBean> {

    public GroupChatMemberDoubleCache(MemoryCache<String, UserDetailBean> memoryCache, AbsDatabaseCache<String, UserDetailBean> databaseCache) {
        super(memoryCache, databaseCache);
    }

    @Override
    public void put(String key, UserDetailBean value) {
        getMemoryCache().put(key, value);
        getDatabaseCache().put(key, value);
    }

    @Override
    public UserDetailBean get(String key) {
        UserDetailBean userDetailBean = getMemoryCache().get(key);
        if (userDetailBean == null) {
            userDetailBean = getDatabaseCache().get(key);
        }
        return userDetailBean;
    }
}
