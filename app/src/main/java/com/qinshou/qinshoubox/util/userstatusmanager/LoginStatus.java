package com.qinshou.qinshoubox.util.userstatusmanager;

import android.content.Context;
import android.content.Intent;

import com.qinshou.commonmodule.ContainerActivity;
import com.qinshou.qinshoubox.homepage.bean.EventBean;
import com.qinshou.immodule.db.DBHelper;
import com.qinshou.immodule.manager.IMClient;
import com.qinshou.qinshoubox.MainActivity;
import com.qinshou.qinshoubox.login.bean.UserBean;
import com.qinshou.qinshoubox.me.ui.fragment.DataSettingFragment;

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
//        DBHelper.getInstance().close();
        context.startActivity(new Intent(context, MainActivity.class));
        // 连接聊天服务
        IMClient.SINGLETON.disconnect();
        // 设置为注销状态
        UserStatusManager.SINGLETON.setUserStatus(new LogoutStatus());
        // 发送事件更新登录状态
        EventBus.getDefault().post(new EventBean<Object>(EventBean.Type.LOGOUT,null));
    }

    @Override
    public void jump2DataSetting(Context context) {
        context.startActivity(ContainerActivity.getJumpIntent(context, DataSettingFragment.class));
    }
}
