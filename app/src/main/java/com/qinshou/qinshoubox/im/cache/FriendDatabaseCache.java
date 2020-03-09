package com.qinshou.qinshoubox.im.cache;

import com.qinshou.commonmodule.util.ShowLogUtil;
import com.qinshou.qinshoubox.friend.bean.UserDetailBean;
import com.qinshou.qinshoubox.im.bean.FriendBean;
import com.qinshou.qinshoubox.im.db.DatabaseHelper;
import com.qinshou.qinshoubox.im.db.dao.IFriendDao;
import com.qinshou.qinshoubox.im.db.dao.IUserDao;

/**
 * Author: QinHao
 * Email:cqflqinhao@126.com
 * Date: 2020/1/4 16:51
 * Description:好友数据库缓存
 */
public class FriendDatabaseCache extends AbsDatabaseCache<String, UserDetailBean> {

    private IUserDao mUserDao;
    private IFriendDao mFriendDao;

    public FriendDatabaseCache(DatabaseHelper databaseHelper) {
        super(databaseHelper);
        mUserDao = databaseHelper.getDao(IUserDao.class);
        mFriendDao = databaseHelper.getDao(IFriendDao.class);
    }

    @Override
    public void put(String key, UserDetailBean value) {
        // 更新数据库
        if (mUserDao.existsById(value.getId())) {
            mUserDao.update(value);
        } else {
            mUserDao.insert(value);
        }
        FriendBean friendBean = new FriendBean(value.getId()
                , value.getStatus()
                , value.getRemark()
                , value.getTop()
                , value.getDoNotDisturb()
                , value.getBlackList());
        if (mFriendDao.existsById(friendBean.getId())) {
            mFriendDao.update(friendBean);
        } else {
            mFriendDao.insert(friendBean);
        }
    }

    @Override
    public UserDetailBean get(String key) {
        UserDetailBean userDetailBean = mUserDao.selectById(key);
        FriendBean friendBean = mFriendDao.selectById(key);
        if (userDetailBean != null && friendBean != null) {
            userDetailBean.setStatus(friendBean.getStatus());
            userDetailBean.setRemark(friendBean.getRemark());
            userDetailBean.setTop(friendBean.getTop());
            userDetailBean.setDoNotDisturb(friendBean.getDoNotDisturb());
            userDetailBean.setBlackList(friendBean.getBlackList());
        }
        return userDetailBean;
    }
}
