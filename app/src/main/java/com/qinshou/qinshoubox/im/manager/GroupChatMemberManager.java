package com.qinshou.qinshoubox.im.manager;

import com.qinshou.qinshoubox.im.IMClient;
import com.qinshou.qinshoubox.im.bean.UserDetailBean;
import com.qinshou.qinshoubox.im.cache.GroupChatMemberDatabaseCache;
import com.qinshou.qinshoubox.im.cache.GroupChatMemberDoubleCache;
import com.qinshou.qinshoubox.im.cache.MemoryCache;
import com.qinshou.qinshoubox.im.listener.QSCallback;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2020/1/16 17:54
 * Description:群成员管理者
 */
public class GroupChatMemberManager extends AbsManager<String, UserDetailBean> {

    public GroupChatMemberManager() {
        super(new GroupChatMemberDoubleCache(new MemoryCache<>(), new GroupChatMemberDatabaseCache()));
    }

    public void put(String groupChatId, UserDetailBean userDetailBean) {
        getCache().put(groupChatId + "_" + userDetailBean.getId(), userDetailBean);
    }

    public void remove(String groupChatId, UserDetailBean userDetailBean) {
        getCache().remove(groupChatId + "_" + userDetailBean.getId());
    }

    public void getByGroupChatIdAndUserId(String groupChatId, String userId, QSCallback<UserDetailBean> qsCallback) {
        UserDetailBean userDetailBean = getCache().get(groupChatId + "_" + userId);
        if (userDetailBean != null) {
            qsCallback.onSuccess(userDetailBean);
        }
        IMClient.SINGLETON.getUserManager().getUser(userId, groupChatId, new QSCallback<UserDetailBean>() {
            @Override
            public void onSuccess(UserDetailBean data) {
                getCache().put(groupChatId + "_" + data.getId(), data);
                qsCallback.onSuccess(data);
            }

            @Override
            public void onFailure(Exception e) {

            }
        });
    }
}
