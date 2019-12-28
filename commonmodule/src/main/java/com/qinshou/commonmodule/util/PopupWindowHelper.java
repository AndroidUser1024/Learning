package com.qinshou.commonmodule.util;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;

public class PopupWindowHelper {
    public static class Builder {
        private Context mContext;
        private View contentView = null;
        private int width = 0;
        private int height = 0;
        //非必须设置的属性,我们设置默认值  
        private boolean focusable = false;
        private boolean outsideTouchable = true;
        private Drawable background = new ColorDrawable(Color.TRANSPARENT);
        private int animationStyle = 0;
        private PopupWindow.OnDismissListener onDismissListener = null;

        public Builder(Context context) {
            this.mContext = context;
        }

        public Builder setContentView(int resId) {
            return setContentView(LayoutInflater.from(mContext).inflate(resId, null));
        }

        public Builder setContentView(View contentView) {
            this.contentView = contentView;
            return this;
        }

        public Builder setWidth(int width) {
            this.width = width;
            return this;
        }

        public Builder setHeight(int height) {
            this.height = height;
            return this;
        }

        public Builder setFocusable(boolean focusable) {
            this.focusable = focusable;
            return this;
        }

        public Builder setOutsideTouchable(boolean outsideTouchable) {
            this.outsideTouchable = outsideTouchable;
            return this;
        }

        public Builder setBackgroundDrawable(Drawable background) {
            this.background = background;
            return this;
        }

        public Builder setAnimationStyle(int animationStyle) {
            this.animationStyle = animationStyle;
            return this;
        }

        public Builder setOnDismissListener(PopupWindow.OnDismissListener onDismissListener) {
            this.onDismissListener = onDismissListener;
            return this;
        }

        public PopupWindow create() {
            PopupWindow popupWindow = new PopupWindow();
            //因为contentView 、 width 和 height 这三个属性是必须的,所以我们在判断如果没有设置这三个参数的话主动抛出异常  
            //其实 Android 源码中不设置这三个参数并不会抛出异常  
            if (contentView == null) {
                throw new NullPointerException("contentView is null");
            } else {
                popupWindow.setContentView(contentView);
            }
            contentView.measure(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED);
            if (width == 0) {
                width = contentView.getMeasuredWidth();
            }
            popupWindow.setWidth(width);
            if (height == 0) {
                height = contentView.getMeasuredHeight();
            }
            popupWindow.setHeight(height);
            popupWindow.setFocusable(focusable);
            popupWindow.setOutsideTouchable(outsideTouchable);
            popupWindow.setBackgroundDrawable(background);
            popupWindow.setAnimationStyle(animationStyle);
            if (onDismissListener != null) {
                popupWindow.setOnDismissListener(onDismissListener);
            }
            return popupWindow;
        }
    }

    /**
     * Description:使 Activity 根布局变暗
     * Date:2018/6/21
     */
    public static void setActivityAlpha(Activity activity, float alpha) {
        WindowManager.LayoutParams lp = activity.getWindow().getAttributes();
        lp.alpha = alpha;
        if (alpha == 1) {
            activity.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
        } else {
            activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
        }
        activity.getWindow().setAttributes(lp);
    }
}  