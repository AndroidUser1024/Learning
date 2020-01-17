package com.qinshou.qinshoubox.im.cache;

import com.qinshou.qinshoubox.friend.bean.UserDetailBean;
import com.qinshou.qinshoubox.im.db.DatabaseHelper;
import com.qinshou.qinshoubox.im.db.dao.IGroupChatMemberDao;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2020/1/16 18:15
 * Description:群成员数据库缓存
 */
public class GroupChatMemberDatabaseCache extends AbsDatabaseCache<String, UserDetailBean> {

    private IGroupChatMemberDao mGroupChatMemberDao;

    public GroupChatMemberDatabaseCache(DatabaseHelper databaseHelper) {
        super(databaseHelper);
        mGroupChatMemberDao = databaseHelper.getDao(IGroupChatMemberDao.class);
    }

    @Override
    public void put(String key, UserDetailBean value) {
        String[] split = key.split("_");
        if (split.length < 2) {
            return;
        }
        String groupChatId = split[0];
        String userId = split[1];
        if (mGroupChatMemberDao.existsByGroupChatIdAndUserId(groupChatId, userId)) {
            mGroupChatMemberDao.update(groupChatId, value);
        } else {
            mGroupChatMemberDao.insert(groupChatId, value);
        }
    }

    @Override
    public UserDetailBean get(String key) {
        String[] split = key.split("_");
        if (split.length < 2) {
            return null;
        }
        String groupChatId = split[0];
        String userId = split[1];
        return mGroupChatMemberDao.selectByGroupChatIdAndUserId(groupChatId, userId);
    }
}
