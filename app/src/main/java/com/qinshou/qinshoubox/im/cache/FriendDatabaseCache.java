package com.qinshou.qinshoubox.im.cache;

import com.qinshou.qinshoubox.im.bean.UserDetailBean;
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

    private IFriendDao mFriendDao;
    private IUserDao mUserDao;

    public FriendDatabaseCache(DatabaseHelper databaseHelper) {
        super(databaseHelper);
        mFriendDao = databaseHelper.getDao(IFriendDao.class);
        mUserDao = databaseHelper.getDao(IUserDao.class);
    }

    @Override
    public void put(String key, UserDetailBean value) {
        // 用户数据不存在才存,但是这里不更新用户数据库
        if (!mUserDao.existsById(value.getId())) {
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
