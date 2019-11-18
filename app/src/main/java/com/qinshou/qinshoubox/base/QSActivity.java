package com.qinshou.qinshoubox.base;

import com.qinshou.commonmodule.base.AbsMVPActivity;
import com.qinshou.commonmodule.base.AbsPresenter;
import com.qinshou.qinshoubox.R;

/**
 * Description:该应用的 Activity 的基类
 * Created by 禽兽先生
 * Created on 2018/11/13
 */
public abstract class QSActivity<P extends AbsPresenter> extends AbsMVPActivity<P> {

    @Override
    public int initStatusBarColor() {
        return getResources().getColor(R.color.activity_background_color);
    }

    @Override
    public boolean initStatusBarDark() {
        return true;
    }
}
