package com.qinshou.qinshoubox.im.cache;

import com.qinshou.qinshoubox.im.bean.GroupChatBean;

/**
 * Author: QinHao
 * Email:cqflqinhao@126.com
 * Date: 2020/1/4 19:55
 * Description:GroupChatBean 双重缓存
 */
public class GroupChatDoubleCache extends AbsDoubleCache<String, GroupChatBean> {

    public GroupChatDoubleCache(MemoryCache<String, GroupChatBean> memoryCache, AbsDatabaseCache<String, GroupChatBean> databaseCache) {
        super(memoryCache, databaseCache);
    }

    @Override
    public void put(String key, GroupChatBean value) {
        getMemoryCache().put(key, value);
        getDatabaseCache().put(key, value);
    }

    @Override
    public GroupChatBean get(String key) {
        GroupChatBean groupChatBean = getMemoryCache().get(key);
        if (groupChatBean == null) {
            groupChatBean = getDatabaseCache().get(key);
            getMemoryCache().put(key, groupChatBean);
        }
        return groupChatBean;
    }
}
