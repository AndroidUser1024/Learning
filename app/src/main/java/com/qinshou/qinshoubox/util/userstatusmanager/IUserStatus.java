package com.qinshou.qinshoubox.util.userstatusmanager;

import android.content.Context;

import com.qinshou.qinshoubox.login.bean.UserBean;


/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/9/19 10:09
 * Description:与用户状态相关的操作
 */
public interface IUserStatus {
    UserBean getUserBean();

    void login(Context context, UserBean userBean);

    void logout(Context context);

    void jump2DataSetting(Context context);

    void jump2IM(Context context);
}
