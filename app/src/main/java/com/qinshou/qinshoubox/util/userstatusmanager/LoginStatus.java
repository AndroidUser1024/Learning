package com.qinshou.qinshoubox.util.userstatusmanager;

import android.content.Context;
import android.content.Intent;

import com.qinshou.commonmodule.ContainerActivity;
import com.qinshou.commonmodule.util.SharedPreferencesHelper;
import com.qinshou.qinshoubox.im.db.DBHelper;
import com.qinshou.qinshoubox.im.manager.ChatManager;
import com.qinshou.qinshoubox.MainActivity;
import com.qinshou.qinshoubox.constant.IConstant;
import com.qinshou.qinshoubox.friend.view.fragment.CreateGroupChatFragment;
import com.qinshou.qinshoubox.friend.view.fragment.FriendHistoryFragment;
import com.qinshou.qinshoubox.im.bean.UserBean;
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
        DBHelper.getInstance().close();
        context.startActivity(new Intent(context, MainActivity.class));
        // 连接聊天服务
        ChatManager.SINGLETON.disconnect();
        // 设置为注销状态
        UserStatusManager.SINGLETON.setUserStatus(new LogoutStatus());
        // 发送事件更新登录状态
        EventBus.getDefault().post(false);
    }

    @Override
    public void jump2DataSetting(Context context) {
        context.startActivity(ContainerActivity.getJumpIntent(context, DataSettingFragment.class));
    }

    @Override
    public void jump2FriendHistory(Context context) {
        SharedPreferencesHelper.SINGLETON.remove(IConstant.SP_KEY_FRIEND_HISTORY_UNREAD_COUNT);
        EventBus.getDefault().post(0);
        context.startActivity(ContainerActivity.getJumpIntent(context, FriendHistoryFragment.class));
    }

    @Override
    public void jump2CreateGroupChat(Context context) {
        context.startActivity(ContainerActivity.getJumpIntent(context, CreateGroupChatFragment.class));
    }
}
