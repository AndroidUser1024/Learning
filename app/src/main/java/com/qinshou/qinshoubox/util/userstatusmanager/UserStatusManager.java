package com.qinshou.qinshoubox.util.userstatusmanager;

import android.content.Context;

import com.qinshou.qinshoubox.friend.view.fragment.FriendFragment;
import com.qinshou.qinshoubox.me.bean.UserBean;


/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/9/19 10:09
 * Description:用户状态管理者
 */
public enum UserStatusManager {
    SINGLETON;
    private IUserStatus mUserStatus = new LogoutStatus();

    public boolean isLogin() {
        return mUserStatus instanceof LoginStatus;
    }

    public void setUserStatus(IUserStatus userStatus) {
        mUserStatus = userStatus;
    }

    public UserBean getUserBean() {
        return mUserStatus.getUserBean();
    }

    public void login(Context context, UserBean userBean) {
        mUserStatus.login(context, userBean);
    }

    public void logout(Context context) {
        mUserStatus.logout(context);
    }

    public void jump2DataSetting(Context context) {
        mUserStatus.jump2DataSetting(context);
    }

    public void jump2FriendHistory(FriendFragment friendFragment) {
        mUserStatus.jump2FriendHistory(friendFragment);
    }
}
