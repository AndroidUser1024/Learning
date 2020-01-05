package com.qinshou.qinshoubox.im.cache;

import com.qinshou.commonmodule.util.ShowLogUtil;
import com.qinshou.qinshoubox.im.bean.FriendBean;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 20-1-4 下午10:03
 * Description:
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
        ShowLogUtil.logi("从缓存拿到的 friendBean--->" + friendBean);
        if (friendBean == null) {
            friendBean = getDatabaseCache().get(key);
            ShowLogUtil.logi("从数据库拿到的 friendBean--->" + friendBean);
        }
        return friendBean;
    }
}
