package com.qinshou.commonmodule.util;

import android.view.View;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/12/11 18:24
 * Description:防止按钮重复点击的工具类
 */
public abstract class PreventRepeatOnClickListener implements View.OnClickListener {
    /**
     * 两次点击按钮之间的点击间隔
     */
    private final int MIN_CLICK_INTERVAL = 500;
    private static long mLastClickTime;

    @Override
    public void onClick(View v) {
        long currentTime = System.currentTimeMillis();
        if (currentTime - mLastClickTime > MIN_CLICK_INTERVAL) {
            mLastClickTime = currentTime;
            onNotRepeatClick(v);
        }
    }

    public abstract void onNotRepeatClick(View v);
}
