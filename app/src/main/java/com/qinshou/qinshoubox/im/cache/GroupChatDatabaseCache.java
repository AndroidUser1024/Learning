package com.qinshou.qinshoubox.im.cache;

import com.qinshou.qinshoubox.im.bean.GroupChatBean;
import com.qinshou.qinshoubox.im.db.DatabaseHelper;
import com.qinshou.qinshoubox.im.db.dao.IGroupChatDao;

/**
 * Author: QinHao
 * Email:cqflqinhao@126.com
 * Date: 2020/1/4 18:04
 * Description:GroupChatBean 数据库缓存
 */
public class GroupChatDatabaseCache extends AbsDatabaseCache<String, GroupChatBean> {

    private IGroupChatDao mGroupChatDao;

    public GroupChatDatabaseCache(DatabaseHelper databaseHelper) {
        super(databaseHelper);
        mGroupChatDao = databaseHelper.getDao(IGroupChatDao.class);
    }

    @Override
    public void put(String key, GroupChatBean value) {
        // 更新数据库
        if (mGroupChatDao.existsById(key)) {
            mGroupChatDao.update(value);
        } else {
            mGroupChatDao.insert(value);
        }
    }

    @Override
    public GroupChatBean get(String key) {
        return mGroupChatDao.selectById(key);
    }
}
