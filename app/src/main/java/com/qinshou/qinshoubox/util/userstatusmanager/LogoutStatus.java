package com.qinshou.qinshoubox.util.userstatusmanager;

import android.content.Context;
import android.content.Intent;

import com.qinshou.commonmodule.ContainerActivity;
import com.qinshou.commonmodule.util.SharedPreferencesHelper;
import com.qinshou.commonmodule.util.ShowLogUtil;
import com.qinshou.immodule.bean.MessageBean;
import com.qinshou.immodule.bean.UserBean;
import com.qinshou.immodule.db.DBHelper;
import com.qinshou.immodule.manager.ChatManager;
import com.qinshou.okhttphelper.callback.Callback;
import com.qinshou.qinshoubox.MainActivity;
import com.qinshou.qinshoubox.constant.IConstant;
import com.qinshou.qinshoubox.me.ui.fragment.LoginOrRegisterFragment;
import com.qinshou.qinshoubox.network.OkHttpHelperForQSBoxOfflineApi;
import com.qinshou.qinshoubox.transformer.QSApiTransformer;

import org.greenrobot.eventbus.EventBus;

import java.util.List;


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
        DBHelper.init(context, userBean.getUsername());
        // 存储最后一次登录成功的用户名
        SharedPreferencesHelper.SINGLETON.putString(IConstant.SP_KEY_LAST_LOGIN_USERNAME, userBean.getUsername());
        context.startActivity(new Intent(context, MainActivity.class));
        // 连接聊天服务
        ChatManager.SINGLETON.connect(context, userBean.getId(), userBean.getUsername());
        // 设置为登录状态
        UserStatusManager.SINGLETON.setUserStatus(new LoginStatus(userBean));
        // 发送事件更新登录状态
        EventBus.getDefault().post(true);
        // 更新好友申请历史数
        EventBus.getDefault().post(0);
        OkHttpHelperForQSBoxOfflineApi.SINGLETON.getOfflineMessageList(userBean.getId())
                .transform(new QSApiTransformer<List<MessageBean>>())
                .enqueue(new Callback<List<MessageBean>>() {
                    @Override
                    public void onSuccess(List<MessageBean> data) {
                        ShowLogUtil.logi(data);
                    }

                    @Override
                    public void onFailure(Exception e) {
                        ShowLogUtil.logi("onFailure: e--->" + e.getMessage());
                    }
                });
    }

    @Override
    public void logout(Context context) {
    }

    @Override
    public void jump2DataSetting(Context context) {
        context.startActivity(ContainerActivity.getJumpIntent(context, LoginOrRegisterFragment.class));
    }

    @Override
    public void jump2FriendHistory(Context context) {
        context.startActivity(ContainerActivity.getJumpIntent(context, LoginOrRegisterFragment.class));
    }

    @Override
    public void jump2CreateGroupChat(Context context) {
        context.startActivity(ContainerActivity.getJumpIntent(context, LoginOrRegisterFragment.class));
    }
}
