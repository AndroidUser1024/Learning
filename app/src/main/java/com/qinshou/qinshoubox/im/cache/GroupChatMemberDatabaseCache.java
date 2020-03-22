package com.qinshou.qinshoubox.im.cache;

import com.jeejio.dbmodule.DatabaseManager;
import com.jeejio.dbmodule.dao.IBaseDao;
import com.jeejio.dbmodule.util.Where;
import com.qinshou.qinshoubox.im.bean.GroupChatMemberBean;
import com.qinshou.qinshoubox.im.bean.UserBean;
import com.qinshou.qinshoubox.im.bean.UserDetailBean;

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

    private IBaseDao<UserBean> mUserDao;
    private IBaseDao<GroupChatMemberBean> mGroupChatMemberDao;

    public GroupChatMemberDatabaseCache() {
        mUserDao = DatabaseManager.getInstance().getDaoByClass(UserBean.class);
        mGroupChatMemberDao = DatabaseManager.getInstance().getDaoByClass(GroupChatMemberBean.class);
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
        groupChatMemberBean.setStatus(1);
        groupChatMemberBean.setNicknameInGroupChat(value.getNicknameInGroupChat());

        List<Map<String, Object>> list = DatabaseManager.getInstance().rawQuery("SELECT" +
                " COUNT(id) AS count" +
                " FROM group_chat_member" +
                " WHERE" +
                " groupChatId=" + groupChatId + "" +
                " AND userId=" + userId);
        if (list.size() > 0) {
            Object count = list.get(0).get("count");
            if (count instanceof Integer && (int) count > 0) {
                mGroupChatMemberDao.update(groupChatMemberBean);
            } else {
                mGroupChatMemberDao.insert(groupChatMemberBean);
            }
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
        if (userBean != null) {
            userDetailBean.setId(userBean.getId());
            userDetailBean.setUsername(userBean.getUsername());
            userDetailBean.setNickname(userBean.getNickname());
            userDetailBean.setHeadImg(userBean.getHeadImg());
            userDetailBean.setHeadImgSmall(userBean.getHeadImgSmall());
        }

        GroupChatMemberBean groupChatMemberBean = mGroupChatMemberDao.select(new Where.Builder()
                .equal("groupChatId", groupChatId)
                .equal("userId", userId)
                .build());
        if (groupChatMemberBean != null) {
            userDetailBean.setStatus(groupChatMemberBean.getStatus());
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
        GroupChatMemberBean groupChatMemberBean = mGroupChatMemberDao.select(new Where.Builder()
                .equal("groupChatId", groupChatId)
                .equal("userId", userId)
                .build());
        groupChatMemberBean.setStatus(0);
        mGroupChatMemberDao.update(groupChatMemberBean);
        return null;
    }

    @Override
    public Collection<UserDetailBean> getValues() {
        return null;
    }
}
