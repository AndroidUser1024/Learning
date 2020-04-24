package com.qinshou.qinshoubox.me.ui.dialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

import com.qinshou.commonmodule.base.AbsDialogFragment;
import com.qinshou.qinshoubox.R;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2020/4/24 15:25
 * Description:加载对话框
 */
public class LoadingDialog extends AbsDialogFragment {

    private ImageView mIvLoading;

    @Override
    public int initLayoutId() {
        return R.layout.dialog_loading;
    }

    @Override
    public void initView() {
        mIvLoading = findViewByID(R.id.iv_loading);
        mIvLoading.post(new Runnable() {
            @Override
            public void run() {
                RotateAnimation rotateAnimation = new RotateAnimation(0
                        , 360
                        , mIvLoading.getWidth() / 2f
                        , mIvLoading.getHeight() / 2f);
                rotateAnimation.setRepeatMode(Animation.RESTART);
                rotateAnimation.setDuration(1000 * 2);
                rotateAnimation.setRepeatCount(Animation.INFINITE);
                rotateAnimation.setInterpolator(new LinearInterpolator());
                mIvLoading.startAnimation(rotateAnimation);
            }
        });
    }

    @Override
    public void setListener() {

    }

    @Override
    public void initData() {

    }

    @Override
    public Dialog customDialog(Dialog dialog) {
        dialog.setCancelable(false);
        dialog.setOnKeyListener(new DialogInterface.OnKeyListener() {
            @Override
            public boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event) {
                return keyCode == KeyEvent.KEYCODE_BACK;
            }
        });
        return dialog;
    }

    @Override
    public void onDismiss(DialogInterface dialog) {
        mIvLoading.clearAnimation();
        super.onDismiss(dialog);
    }
}
