package com.qinshou.qinshoubox.im.cache;

import com.qinshou.qinshoubox.im.bean.UserDetailBean;

/**
 * Author: QinHao
 * Email:cqflqinhao@126.com
 * Date: 2020/1/4 19:55
 * Description:FriendBean 双重缓存
 */
public class FriendDoubleCache extends AbsDoubleCache<String, UserDetailBean> {

    public FriendDoubleCache(MemoryCache<String, UserDetailBean> memoryCache
            , AbsDatabaseCache<String, UserDetailBean> databaseCache) {
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
            getMemoryCache().put(key, userDetailBean);
        }
        return userDetailBean;
    }
}
