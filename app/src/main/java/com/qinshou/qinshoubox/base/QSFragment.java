package com.qinshou.qinshoubox.base;

import com.qinshou.commonmodule.base.AbsMVPFragment;
import com.qinshou.commonmodule.base.AbsPresenter;
import com.qinshou.qinshoubox.R;

/**
 * Description:该应用的 Fragment 的基类
 * Created by 禽兽先生
 * Created on 2018/11/13
 */
public abstract class QSFragment<P extends AbsPresenter> extends AbsMVPFragment<P> {
    @Override
    public int initStatusBarColor() {
        return getResources().getColor(R.color.activity_background_color);
    }

    @Override
    public boolean initStatusBarDark() {
        return true;
    }
}
