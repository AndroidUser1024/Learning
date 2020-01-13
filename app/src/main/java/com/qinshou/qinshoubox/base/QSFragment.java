package com.qinshou.qinshoubox.base;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.qinshou.commonmodule.ContainerActivity;
import com.qinshou.commonmodule.base.AbsMVPFragment;
import com.qinshou.commonmodule.base.AbsPresenter;
import com.qinshou.commonmodule.util.ShowLogUtil;
import com.qinshou.qinshoubox.R;
import com.qinshou.qinshoubox.homepage.bean.EventBean;
import com.qinshou.qinshoubox.im.IMClient;
import com.qinshou.qinshoubox.im.listener.IOnConnectListener;
import com.qinshou.qinshoubox.login.view.fragment.LoginOrRegisterFragment;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/**
 * Description:该应用的 Fragment 的基类
 * Created by 禽兽先生
 * Created on 2018/11/13
 */
public abstract class QSFragment<P extends AbsPresenter> extends AbsMVPFragment<P> implements IOnConnectListener {
    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
        IMClient.SINGLETON.removeOnConnectListener(this);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EventBus.getDefault().register(this);
        IMClient.SINGLETON.addOnConnectListener(this);
    }

    @Override
    public int initStatusBarColor() {
        return getResources().getColor(R.color.activity_background_color);
    }

    @Override
    public boolean initStatusBarDark() {
        return true;
    }

    @Override
    public void onConnected() {
        ShowLogUtil.logi("onConnected");
    }

    @Override
    public void onAuthenticated() {
        ShowLogUtil.logi("onAuthenticated");
    }

    @Override
    public void onConnectFailure(Exception e) {
        ShowLogUtil.logi("onConnectFailure: e--->" + e.getMessage());
    }

    @Override
    public void onDisconnected() {
        ShowLogUtil.logi("onDisconnected");
        startActivity(ContainerActivity.getJumpIntent(getContext(), LoginOrRegisterFragment.class));
        finish();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void receiveEvent(EventBean<Object> eventBean) {
        handleEvent(eventBean);
    }

    public abstract void handleEvent(EventBean<Object> eventBean);
}
