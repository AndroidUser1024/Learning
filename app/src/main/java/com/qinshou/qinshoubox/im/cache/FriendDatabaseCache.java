package com.qinshou.qinshoubox.im.cache;

import com.qinshou.dbmodule.DatabaseManager;
import com.qinshou.dbmodule.dao.IBaseDao;
import com.qinshou.qinshoubox.im.bean.FriendBean;
import com.qinshou.qinshoubox.im.bean.UserBean;
import com.qinshou.qinshoubox.im.bean.UserDetailBean;
import com.qinshou.qinshoubox.im.db.IFriendDao;
import com.qinshou.qinshoubox.im.db.IUserDao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Author: QinHao
 * Email:cqflqinhao@126.com
 * Date: 2020/1/4 16:51
 * Description:好友数据库缓存
 */
public class FriendDatabaseCache extends AbsDatabaseCache<String, UserDetailBean> {

    private IUserDao mUserDao;
    private IFriendDao mFriendDao;

    public FriendDatabaseCache() {
        mUserDao = DatabaseManager.getInstance().getDao(IUserDao.class);
        mFriendDao = DatabaseManager.getInstance().getDao(IFriendDao.class);
    }

    @Override
    public void put(String key, UserDetailBean value) {
        // 用户数据不存在才存,但是这里不更新用户数据库
        if (mUserDao.existsById(value.getId()) == 0) {
            UserBean userBean = new UserBean(value.getId()
                    , value.getUsername()
                    , value.getNickname()
                    , value.getHeadImgSmall()
                    , value.getHeadImg());
            mUserDao.insert(userBean);
        }
        FriendBean friendBean = new FriendBean(value.getId()
                , value.getStatus()
                , value.getRemark()
                , value.getTop()
                , value.getDoNotDisturb()
                , value.getBlackList());
        if (mFriendDao.existsById(friendBean.getId()) == 0) {
            mFriendDao.insert(friendBean);
        } else {
            mFriendDao.updateById(friendBean);
        }
    }

    @Override
    public UserDetailBean get(String key) {
        UserDetailBean userDetailBean = new UserDetailBean();
        UserBean userBean = mUserDao.selectById(key);
        if (userBean != null) {
            userDetailBean.setId(userBean.getId());
            userDetailBean.setUsername(userBean.getUsername());
            userDetailBean.setNickname(userBean.getNickname());
            userDetailBean.setHeadImg(userBean.getHeadImg());
            userDetailBean.setHeadImgSmall(userBean.getHeadImgSmall());
        }
        FriendBean friendBean = mFriendDao.selectById(key);
        if (friendBean != null) {
            userDetailBean.setStatus(friendBean.getStatus());
            userDetailBean.setRemark(friendBean.getRemark());
            userDetailBean.setTop(friendBean.getTop());
            userDetailBean.setDoNotDisturb(friendBean.getDoNotDisturb());
            userDetailBean.setBlackList(friendBean.getBlackList());
        }
        return userDetailBean;
    }

    @Override
    public UserDetailBean remove(String key) {
        mFriendDao.deleteById(key);
        return null;
    }

    @Override
    public Collection<UserDetailBean> getValues() {
        List<UserDetailBean> userDetailBeanList = new ArrayList<>();
        for (FriendBean friendBean : mFriendDao.selectList()) {
            UserDetailBean userDetailBean = new UserDetailBean();
            userDetailBean.setStatus(friendBean.getStatus());
            userDetailBean.setRemark(friendBean.getRemark());
            userDetailBean.setTop(friendBean.getTop());
            userDetailBean.setDoNotDisturb(friendBean.getDoNotDisturb());
            userDetailBean.setBlackList(friendBean.getBlackList());

            UserBean userBean = mUserDao.selectById(friendBean.getId());
            userDetailBean.setId(userBean.getId());
            userDetailBean.setUsername(userBean.getUsername());
            userDetailBean.setNickname(userBean.getNickname());
            userDetailBean.setHeadImg(userBean.getHeadImg());
            userDetailBean.setHeadImgSmall(userBean.getHeadImgSmall());
            userDetailBeanList.add(userDetailBean);
        }
        return userDetailBeanList;
    }
}
