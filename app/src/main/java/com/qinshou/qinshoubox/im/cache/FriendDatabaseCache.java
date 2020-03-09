package com.qinshou.qinshoubox.im.cache;

import com.qinshou.qinshoubox.friend.bean.UserDetailBean;
import com.qinshou.qinshoubox.im.bean.FriendBean;
import com.qinshou.qinshoubox.im.db.DatabaseHelper;
import com.qinshou.qinshoubox.im.db.dao.IFriendDao;

/**
 * Author: QinHao
 * Email:cqflqinhao@126.com
 * Date: 2020/1/4 16:51
 * Description:好友数据库缓存
 */
public class FriendDatabaseCache extends AbsDatabaseCache<String, UserDetailBean> {

    private IFriendDao mFriendDao;

    public FriendDatabaseCache(DatabaseHelper databaseHelper) {
        super(databaseHelper);
        mFriendDao = databaseHelper.getDao(IFriendDao.class);
    }

    @Override
    public void put(String key, UserDetailBean value) {
//        FriendBean friendBean = new FriendBean(value.getId());
        // 更新数据库
//        if (mFriendDao.existsById(key)) {
//            mFriendDao.update(value);
//        } else {
//            mFriendDao.insert(value);
//        }
    }

    @Override
    public UserDetailBean get(String key) {
//        return mFriendDao.selectById(key);
        return null;
    }
}
