package com.qinshou.qinshoubox.im.cache;

import com.qinshou.qinshoubox.im.bean.UserDetailBean;

import java.util.Collection;

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
            if (userDetailBean != null) {
                getMemoryCache().put(key, userDetailBean);
            }
        }
        return userDetailBean;
    }

    @Override
    public UserDetailBean remove(String key) {
        getMemoryCache().remove(key);
        getDatabaseCache().remove(key);
        return null;
    }

    @Override
    public Collection<UserDetailBean> getValues() {
        Collection<UserDetailBean> values = getMemoryCache().getValues();
        if (values == null || values.size() == 0) {
            values = getDatabaseCache().getValues();
        }
        return values;
    }
}
