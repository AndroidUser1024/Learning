package com.qinshou.qinshoubox.im.manager;

import com.qinshou.commonmodule.db.Id;
import com.qinshou.qinshoubox.im.bean.UserDetailBean;
import com.qinshou.qinshoubox.im.cache.GroupChatMemberDatabaseCache;
import com.qinshou.qinshoubox.im.cache.GroupChatMemberDoubleCache;
import com.qinshou.qinshoubox.im.cache.MemoryCache;
import com.qinshou.qinshoubox.im.db.DatabaseHelper;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2020/1/16 17:54
 * Description:群成员管理者
 */
public class GroupChatMemberManager extends AbsManager<String, UserDetailBean> {

    public GroupChatMemberManager(DatabaseHelper databaseHelper) {
        super(new GroupChatMemberDoubleCache(new MemoryCache<String, UserDetailBean>(), new GroupChatMemberDatabaseCache(databaseHelper)));
    }

    public void put(String groupChatId, UserDetailBean userDetailBean) {
        getCache().put(groupChatId + "_" + userDetailBean.getId(), userDetailBean);
    }

    public UserDetailBean getByGroupChatIdAndUserId(String groupChatId, String userId) {
        return getCache().get(groupChatId + "_" + userId);
    }
}
