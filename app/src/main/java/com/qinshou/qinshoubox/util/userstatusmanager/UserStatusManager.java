package com.qinshou.qinshoubox.util.userstatusmanager;

import com.qinshou.qinshoubox.login.bean.UserBean;


/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/9/19 10:09
 * Description:用户状态管理者
 */
public enum UserStatusManager {
    SINGLETON;
    private UserBean mUserBean;

    public UserBean getUserBean() {
        return mUserBean;
    }

    public void setUserBean(UserBean userBean) {
        mUserBean = userBean;
    }

//    private IUserStatus mUserStatus = new LogoutStatus();
//    public boolean isLogin() {
//        return mUserStatus instanceof LoginStatus;
//    }
//
//    public void setUserStatus(IUserStatus userStatus) {
//        mUserStatus = userStatus;
//    }
//
//    public void login(Context context, UserBean userBean) {
//        mUserStatus.login(context, userBean);
//    }
//
//    public void logout(Context context) {
//        mUserStatus.logout(context);
//    }
//
//    public void jump2DataSetting(Context context) {
//        mUserStatus.jump2DataSetting(context);
//    }
//
//    public void jump2IM(Context context) {
//        mUserStatus.jump2IM(context);
//    }
}
