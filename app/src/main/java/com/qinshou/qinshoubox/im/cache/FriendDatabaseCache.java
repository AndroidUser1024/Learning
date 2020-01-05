package com.qinshou.qinshoubox.im.cache;

import com.qinshou.qinshoubox.im.bean.FriendBean;
import com.qinshou.qinshoubox.im.db.DatabaseHelper;
import com.qinshou.qinshoubox.im.db.dao.IFriendDao;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 20-1-4 下午4:51
 * Description:
 */
public class FriendDatabaseCache extends AbsDatabaseCache<String, FriendBean> {

    private IFriendDao mFriendDao;

    public FriendDatabaseCache(DatabaseHelper databaseHelper) {
        super(databaseHelper);
        mFriendDao = databaseHelper.getDao(IFriendDao.class);
    }

    @Override
    public void put(String key, FriendBean value) {
        // 更新数据库
        if (mFriendDao.existsById(key)) {
            mFriendDao.update(value);
        } else {
            mFriendDao.insert(value);
        }
    }

    @Override
    public FriendBean get(String key) {
        return mFriendDao.selectById(key);
    }
}
