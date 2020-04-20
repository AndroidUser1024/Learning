package com.qinshou.qinshoubox.im.cache;

import com.qinshou.dbmodule.DatabaseManager;
import com.qinshou.dbmodule.dao.IBaseDao;
import com.qinshou.qinshoubox.im.bean.GroupChatBean;

import java.util.Collection;

/**
 * Author: QinHao
 * Email:cqflqinhao@126.com
 * Date: 2020/1/4 18:04
 * Description:GroupChatBean 数据库缓存
 */
public class GroupChatDatabaseCache extends AbsDatabaseCache<String, GroupChatBean> {

    private IBaseDao<GroupChatBean> mGroupChatDao;

    public GroupChatDatabaseCache() {
        mGroupChatDao = DatabaseManager.getInstance().getDaoByClass(GroupChatBean.class);
    }

    @Override
    public void put(String key, GroupChatBean value) {
        // 更新数据库
        mGroupChatDao.save(value);
    }

    @Override
    public GroupChatBean get(String key) {
        return mGroupChatDao.selectById(key);
    }

    @Override
    public GroupChatBean remove(String key) {
        mGroupChatDao.deleteById(key);
        return null;
    }

    @Override
    public Collection<GroupChatBean> getValues() {
        return mGroupChatDao.selectList();
    }
}
