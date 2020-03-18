package com.qinshou.qinshoubox.im.cache;

import com.qinshou.qinshoubox.im.bean.UserDetailBean;
import com.qinshou.qinshoubox.im.db.DatabaseHelper;
import com.qinshou.qinshoubox.im.db.dao.IGroupChatMemberDao;
import com.qinshou.qinshoubox.im.db.dao.IUserDao;

import java.util.Collection;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2020/1/16 18:15
 * Description:群成员数据库缓存
 */
public class GroupChatMemberDatabaseCache extends AbsDatabaseCache<String, UserDetailBean> {

    private IGroupChatMemberDao mGroupChatMemberDao;
    private IUserDao mUserDao;

    public GroupChatMemberDatabaseCache(DatabaseHelper databaseHelper) {
        super(databaseHelper);
        mGroupChatMemberDao = databaseHelper.getDao(IGroupChatMemberDao.class);
        mUserDao = databaseHelper.getDao(IUserDao.class);
    }

    @Override
    public void put(String key, UserDetailBean value) {
        String[] split = key.split("_");
        if (split.length < 2) {
            return;
        }
        String groupChatId = split[0];
        String userId = split[1];
        // 用户数据不存在才存,但是这里不更新用户数据库
        if (!mUserDao.existsById(value.getId())) {
            mUserDao.insert(value);
        }
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

    @Override
    public UserDetailBean remove(String key) {
        return null;
    }

    @Override
    public Collection<UserDetailBean> getValues() {
        return null;
    }
}
