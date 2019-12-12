package com.qinshou.qinshoubox.base;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.qinshou.commonmodule.base.AbsMVPActivity;
import com.qinshou.commonmodule.base.AbsPresenter;
import com.qinshou.qinshoubox.R;
import com.qinshou.qinshoubox.homepage.bean.EventBean;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/**
 * Description:该应用的 Activity 的基类
 * Created by 禽兽先生
 * Created on 2018/11/13
 */
public abstract class QSActivity<P extends AbsPresenter> extends AbsMVPActivity<P> {
    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EventBus.getDefault().register(this);
    }

    @Override
    public int initStatusBarColor() {
        return getResources().getColor(R.color.activity_background_color);
    }

    @Override
    public boolean initStatusBarDark() {
        return true;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void receiveEvent(EventBean<Object> eventBean) {
        handleEvent(eventBean);
    }

    public abstract void handleEvent(EventBean<Object> eventBean);
}
