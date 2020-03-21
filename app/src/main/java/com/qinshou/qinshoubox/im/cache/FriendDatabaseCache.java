package com.qinshou.qinshoubox.im.cache;

import com.jeejio.dbmodule.dao.IBaseDao;
import com.qinshou.qinshoubox.im.bean.FriendBean;
import com.qinshou.qinshoubox.im.bean.UserBean;
import com.qinshou.qinshoubox.im.bean.UserDetailBean;

import java.util.Collection;

/**
 * Author: QinHao
 * Email:cqflqinhao@126.com
 * Date: 2020/1/4 16:51
 * Description:好友数据库缓存
 */
public class FriendDatabaseCache extends AbsDatabaseCache<String, UserDetailBean> {

    private IBaseDao<UserBean> mUserDao;
    private IBaseDao<FriendBean> mFriendDao;

    public FriendDatabaseCache() {
        super();
    }

    @Override
    public void put(String key, UserDetailBean value) {
//        // 用户数据不存在才存,但是这里不更新用户数据库
//        if (!mUserDao.existsById(value.getId())) {
//            mUserDao.insert(value);
//        }
//        FriendBean friendBean = new FriendBean(value.getId()
//                , value.getStatus()
//                , value.getRemark()
//                , value.getTop()
//                , value.getDoNotDisturb()
//                , value.getBlackList());
//        if (mFriendDao.existsById(friendBean.getId())) {
//            mFriendDao.update(friendBean);
//        } else {
//            mFriendDao.insert(friendBean);
//        }
    }

    @Override
    public UserDetailBean get(String key) {
        UserDetailBean userDetailBean = new UserDetailBean();
//        UserDetailBean userDetailBean = mUserDao.selectById(key);
//        FriendBean friendBean = mFriendDao.selectById(key);
//        if (userDetailBean != null && friendBean != null) {
//            userDetailBean.setStatus(friendBean.getStatus());
//            userDetailBean.setRemark(friendBean.getRemark());
//            userDetailBean.setTop(friendBean.getTop());
//            userDetailBean.setDoNotDisturb(friendBean.getDoNotDisturb());
//            userDetailBean.setBlackList(friendBean.getBlackList());
//        }
        return userDetailBean;
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
