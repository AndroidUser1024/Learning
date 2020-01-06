package com.qinshou.qinshoubox.im.cache;

import com.qinshou.qinshoubox.im.bean.FriendBean;

/**
 * Author: QinHao
 * Email:cqflqinhao@126.com
 * Date: 2020/1/4 19:55
 * Description:FriendBean 双重缓存
 */
public class FriendDoubleCache extends AbsDoubleCache<String, FriendBean> {

    public FriendDoubleCache(MemoryCache<String, FriendBean> memoryCache, AbsDatabaseCache<String, FriendBean> databaseCache) {
        super(memoryCache, databaseCache);
    }

    @Override
    public void put(String key, FriendBean value) {
        getMemoryCache().put(key, value);
        getDatabaseCache().put(key, value);
    }

    @Override
    public FriendBean get(String key) {
        FriendBean friendBean = getMemoryCache().get(key);
        if (friendBean == null) {
            friendBean = getDatabaseCache().get(key);
        }
        return friendBean;
    }
}
