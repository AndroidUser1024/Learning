package com.qinshou.qinshoubox.im.cache;

import com.qinshou.dbmodule.DatabaseManager;
import com.qinshou.dbmodule.dao.IBaseDao;
import com.qinshou.dbmodule.condition.Where;
import com.qinshou.qinshoubox.im.bean.FriendBean;
import com.qinshou.qinshoubox.im.bean.GroupChatMemberBean;
import com.qinshou.qinshoubox.im.bean.UserBean;
import com.qinshou.qinshoubox.im.bean.UserDetailBean;
import com.qinshou.qinshoubox.im.db.IFriendDao;
import com.qinshou.qinshoubox.im.db.IGroupChatMemberDao;
import com.qinshou.qinshoubox.im.db.IUserDao;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2020/1/16 18:15
 * Description:群成员数据库缓存
 */
public class GroupChatMemberDatabaseCache extends AbsDatabaseCache<String, UserDetailBean> {

    private IUserDao mUserDao;
    private IFriendDao mFriendDao;
    private IGroupChatMemberDao mGroupChatMemberDao;

    public GroupChatMemberDatabaseCache() {
        mUserDao = DatabaseManager.getInstance().getDao(IUserDao.class);
        mFriendDao = DatabaseManager.getInstance().getDao(IFriendDao.class);
        mGroupChatMemberDao = DatabaseManager.getInstance().getDao(IGroupChatMemberDao.class);
    }

    @Override
    public synchronized void put(String key, UserDetailBean value) {
        String[] split = key.split("_");
        if (split.length < 2) {
            return;
        }
        String groupChatId = split[0];
        String userId = split[1];
        // 用户数据不存在才存,但是这里不更新用户数据库
        if (mUserDao.existsById(value.getId()) == 0) {
            UserBean userBean = new UserBean(value.getId()
                    , value.getUsername()
                    , value.getNickname()
                    , value.getHeadImgSmall()
                    , value.getHeadImg());
            mUserDao.insert(userBean);
        }
        GroupChatMemberBean groupChatMemberBean = new GroupChatMemberBean();
        groupChatMemberBean.setGroupChatId(groupChatId);
        groupChatMemberBean.setUserId(userId);
        groupChatMemberBean.setNicknameInGroupChat(value.getNicknameInGroupChat());

        GroupChatMemberBean select = mGroupChatMemberDao.selectByGroupChatIdAndUserId(groupChatId, userId);
        if (select == null) {
            mGroupChatMemberDao.insert(groupChatMemberBean);
        } else {
            groupChatMemberBean.setId(select.getId());
            mGroupChatMemberDao.updateById(groupChatMemberBean);
        }
    }

    @Override
    public UserDetailBean get(String key) {
        String[] split = key.split("_");
        if (split.length < 2) {
            return null;
        }
        UserDetailBean userDetailBean = new UserDetailBean();
        String groupChatId = split[0];
        String userId = split[1];

        UserBean userBean = mUserDao.selectById(userId);
        if (userBean == null) {
            return null;
        }
        userDetailBean.setId(userBean.getId());
        userDetailBean.setUsername(userBean.getUsername());
        userDetailBean.setNickname(userBean.getNickname());
        userDetailBean.setHeadImg(userBean.getHeadImg());
        userDetailBean.setHeadImgSmall(userBean.getHeadImgSmall());

        FriendBean friendBean = mFriendDao.selectById(userId);
        if (friendBean != null) {
            userDetailBean.setRemark(friendBean.getRemark());
        }

        GroupChatMemberBean groupChatMemberBean = mGroupChatMemberDao.selectByGroupChatIdAndUserId(groupChatId, userId);
        if (groupChatMemberBean != null) {
            userDetailBean.setNicknameInGroupChat(groupChatMemberBean.getNicknameInGroupChat());
        }
        return userDetailBean;
    }

    @Override
    public UserDetailBean remove(String key) {
        String[] split = key.split("_");
        if (split.length < 2) {
            return null;
        }
        String groupChatId = split[0];
        String userId = split[1];
        mGroupChatMemberDao.deleteByGroupChatIdAndUserId(groupChatId, userId);
        return null;
    }

    @Override
    public Collection<UserDetailBean> getValues() {
        return null;
    }
}
