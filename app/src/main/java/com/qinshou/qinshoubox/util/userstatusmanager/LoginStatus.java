package com.qinshou.qinshoubox.util.userstatusmanager;

import android.content.Context;
import android.content.Intent;

import com.qinshou.commonmodule.ContainerActivity;
import com.qinshou.commonmodule.util.ShowLogUtil;
import com.qinshou.qinshoubox.MainActivity;
import com.qinshou.qinshoubox.me.bean.UserBean;
import com.qinshou.qinshoubox.me.ui.fragment.DataSettingFragment;
import com.qinshou.qinshoubox.me.ui.fragment.LoginOrRegisterFragment;

import org.greenrobot.eventbus.EventBus;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/9/19 10:11
 * Description:登录状态
 */
public class LoginStatus implements IUserStatus {
    private UserBean mUserBean;

    public LoginStatus(UserBean userBean) {
        mUserBean = userBean;
    }

    @Override
    public UserBean getUserBean() {
        return mUserBean;
    }

    @Override
    public void login(Context context, UserBean userBean) {

    }

    @Override
    public void logout(Context context) {
        context.startActivity(new Intent(context, MainActivity.class));
        EventBus.getDefault().post(new UserBean());
        UserStatusManager.SINGLETON.setUserStatus(new LogoutStatus());
    }

    @Override
    public void jump2DataSetting(Context context) {
        context.startActivity(ContainerActivity.getJumpIntent(context, DataSettingFragment.class));
    }
}
