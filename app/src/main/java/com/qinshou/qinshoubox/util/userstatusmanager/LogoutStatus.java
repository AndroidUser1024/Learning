package com.qinshou.qinshoubox.util.userstatusmanager;

import android.content.Context;
import android.content.Intent;

import com.qinshou.commonmodule.ContainerActivity;
import com.qinshou.commonmodule.util.SharedPreferencesHelper;
import com.qinshou.immodule.manager.IMClient;
import com.qinshou.qinshoubox.MainActivity;
import com.qinshou.qinshoubox.constant.IConstant;
import com.qinshou.qinshoubox.homepage.bean.EventBean;
import com.qinshou.qinshoubox.login.bean.UserBean;
import com.qinshou.qinshoubox.login.view.fragment.LoginOrRegisterFragment;

import org.greenrobot.eventbus.EventBus;


/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/9/19 10:11
 * Description:登出状态
 */
public class LogoutStatus implements IUserStatus {
    @Override
    public UserBean getUserBean() {
        return null;
    }

    @Override
    public void login(Context context, UserBean userBean) {
        // 存储最后一次登录成功的用户名
        SharedPreferencesHelper.SINGLETON.putString(IConstant.SP_KEY_LAST_LOGIN_USERNAME, userBean.getUsername());
        context.startActivity(new Intent(context, MainActivity.class));
        // 设置为登录状态
        UserStatusManager.SINGLETON.setUserStatus(new LoginStatus(userBean));
        // 发送事件更新登录状态
        EventBus.getDefault().post(new EventBean<Object>(EventBean.Type.LOGIN, null));
        // 连接 IM 服务
        IMClient.SINGLETON.connect(userBean.getId());
    }

    @Override
    public void logout(Context context) {
    }

    @Override
    public void jump2DataSetting(Context context) {
        context.startActivity(ContainerActivity.getJumpIntent(context, LoginOrRegisterFragment.class));
    }

    @Override
    public void jump2IM(Context context) {
        context.startActivity(ContainerActivity.getJumpIntent(context, LoginOrRegisterFragment.class));
    }
}
