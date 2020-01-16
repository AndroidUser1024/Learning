package com.qinshou.qinshoubox.im.cache;

import com.qinshou.qinshoubox.friend.bean.UserDetailBean;
import com.qinshou.qinshoubox.im.db.DatabaseHelper;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2020/1/16 18:15
 * Description:群成员数据库缓存
 */
public class GroupChatMemberDatabaseCache extends AbsDatabaseCache<String, UserDetailBean> {

    public GroupChatMemberDatabaseCache(DatabaseHelper databaseHelper) {
        super(databaseHelper);
    }

    @Override
    public void put(String key, UserDetailBean value) {

    }

    @Override
    public UserDetailBean get(String key) {
        return null;
    }
}
