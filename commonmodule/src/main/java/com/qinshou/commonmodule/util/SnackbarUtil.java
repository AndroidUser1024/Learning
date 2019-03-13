package com.qinshou.commonmodule.util;

import android.app.Activity;
import android.graphics.Color;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.qinshou.commonmodule.R;

/**
 * Description:Snackbar 的工具类
 * Created by 禽兽先生
 * Created on 2018/4/13
 */

public class SnackbarUtil {
    private Activity mActivity;
    private String mContent;
    private int mDuration;
    private int mBackgroundColor;
    private int mTextColor;
    private int mTextSize;
    private String mButtonText;
    private int mButtonTextColor;
    private int mButtonTextSize;
    private View.OnClickListener mButtonOnClickListener;

    private SnackbarUtil(Builder builder) {
        this.mActivity = builder.mActivity;
        mContent = builder.mContent;
        mDuration = builder.mDuration;
        mBackgroundColor = builder.mBackgroundColor;
        mTextColor = builder.mTextColor;
        mTextSize = builder.mTextSize;
        mButtonText = builder.mButtonText;
        mButtonTextColor = builder.mButtonTextColor;
        mButtonTextSize = builder.mButtonTextSize;
        mButtonOnClickListener = builder.mButtonOnClickListener;
    }

    public static void showSnackbar(Activity activity, String content, int duration) {
        SoftKeyboardUtil.hideSoftKeyboard(activity);
        //第一个参数需要一个 View,Snackbar 默认会显示屏幕最底部(如果第一个 View 是 CoordinatorLayout 则会显示在 CoordinatorLayout 最底部)
        //如果第一个参数传入 activity.getWindow().getDecorView(),则有虚拟按键的手机 Snackbar 会被虚拟按键遮挡
        //使用 activity.findViewById(android.R.id.content) 则不会
        Snackbar mSnackbar = Snackbar.make(activity.findViewById(android.R.id.content), content, duration);
        mSnackbar.show();
    }

    public static void showSnackbar(Activity activity, String content) {
        showSnackbar(activity, content, Snackbar.LENGTH_SHORT);
    }

    public void showSnackbar() {
        SoftKeyboardUtil.hideSoftKeyboard(mActivity);
        //第一个参数需要一个 View,Snackbar 默认会显示屏幕最底部(如果第一个 View 是 CoordinatorLayout 则会显示在 CoordinatorLayout 最底部)
        //如果第一个参数传入 activity.getWindow().getDecorView(),则有虚拟按键的手机 Snackbar 会被虚拟按键遮挡
        //使用 activity.findViewById(android.R.id.content) 则不会
        final Snackbar snackbar = Snackbar.make(mActivity.findViewById(android.R.id.content), mContent, mDuration);
        Snackbar.SnackbarLayout snackbarLayout = (Snackbar.SnackbarLayout) snackbar.getView();
        //设置 Snackbar 背景颜色
        snackbarLayout.setBackgroundColor(mBackgroundColor);
        //设置 Snackbar 的内容字体大小和字体颜色
        TextView snackbarText = snackbarLayout.findViewById(R.id.snackbar_text);
        snackbarText.setTextSize(mTextSize);
        snackbarText.setTextColor(mTextColor);
        //设置 Snackbar 行为按钮的文字,字体大小,字体颜色和点击事件
        Button snackbarAction = snackbarLayout.findViewById(R.id.snackbar_action);
        snackbarAction.setText(mButtonText);
        snackbarAction.setTextSize(mButtonTextSize);
        snackbarAction.setTextColor(mButtonTextColor);
        snackbarAction.setVisibility(View.VISIBLE);
        if (mButtonOnClickListener != null) {
            snackbarAction.setOnClickListener(mButtonOnClickListener);
        } else {
            snackbarAction.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    snackbar.dismiss();
                }
            });
        }
        snackbar.show();
    }

    public static class Builder {
        private Activity mActivity;
        private String mContent;
        private int mDuration;
        private int mBackgroundColor;
        private int mTextColor;
        private int mTextSize;
        private String mButtonText;
        private int mButtonTextColor;
        private int mButtonTextSize;
        private View.OnClickListener mButtonOnClickListener;

        public Builder(Activity activity) {
            mActivity = activity;
            mContent = "";
            mDuration = Snackbar.LENGTH_SHORT;
            mBackgroundColor = Color.parseColor("#FF000000");
            mTextColor = Color.parseColor("#FFFFFFFF");
            mTextSize = 15;
            mButtonText = "关闭";
            mButtonTextColor = Color.parseColor("#FFFFC0CB");
            mButtonTextSize = 15;
        }

        public Builder setContent(String content) {
            mContent = content;
            return this;
        }

        public Builder setDuration(int duration) {
            mDuration = duration;
            return this;
        }

        public Builder setBackgroundColor(int backgroundColor) {
            mBackgroundColor = backgroundColor;
            return this;
        }

        public Builder setTextColor(int textColor) {
            mTextColor = textColor;
            return this;
        }

        public Builder setTextSize(int textSize) {
            mTextSize = textSize;
            return this;
        }

        public Builder setButtonText(String buttonText) {
            mButtonText = buttonText;
            return this;
        }

        public Builder setButtonTextColor(int buttonTextColor) {
            mButtonTextColor = buttonTextColor;
            return this;
        }

        public Builder setButtonTextSize(int buttonTextSize) {
            mButtonTextSize = buttonTextSize;
            return this;
        }

        public Builder setButtonOnClickListener(View.OnClickListener onClickListener) {
            this.mButtonOnClickListener = onClickListener;
            return this;
        }

        public SnackbarUtil build() {
            return new SnackbarUtil(this);
        }
    }
}
