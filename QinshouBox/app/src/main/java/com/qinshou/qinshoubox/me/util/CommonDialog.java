package com.qinshou.qinshoubox.me.util;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;


/**
 * Description:从底部弹出的对话框
 * Created by 禽兽先生
 * Created on 2018/4/28
 */
//                View view = View.inflate(MainActivity.this, R.layout.dialog_puzzle_show_origin_img, null);
//                        ImageView ivOriginImg = view.findViewById(R.id.iv_origin_img);
//                        new CommonDialog.SingleBackgroundBuilder(MainActivity.this).setContentView(view)
//                        .build()
//                        .show();
public class CommonDialog {
    private Context mContext;
    private int mLayoutId;
    private View mContentView;
    private boolean mCanceledOnTouchOutside;
    private boolean mAnimate;
    private int mAnimationResId;
    private int mGravity;

    private CommonDialog(Builder builder) {
        this.mContext = builder.mContext;
        this.mLayoutId = builder.mLayoutId;
        this.mContentView = builder.mContentView;
        this.mCanceledOnTouchOutside = builder.mCanceledOnTouchOutside;
        this.mAnimate = builder.mAnimate;
        this.mAnimationResId = builder.mAnimationResId;
    }

    public void show() {
        Dialog dialog = new Dialog(mContext);
        //设置对话框内容布局
        if (mContentView == null) {
            mContentView = LayoutInflater.from(mContext).inflate(mLayoutId, null);
        }
        dialog.setContentView(mContentView);
        Window window = dialog.getWindow();
        if (window != null) {
            WindowManager.LayoutParams layoutParams = window.getAttributes();
            //设置宽度
            layoutParams.width = ViewGroup.LayoutParams.MATCH_PARENT;
            //设置高度
            layoutParams.height = ViewGroup.LayoutParams.MATCH_PARENT;
            //出现在屏幕底部
            window.setGravity(mGravity);
            //设置对话框自带背景透明,才能显示布局的背景
            window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            //设置对话框出现和消失的动画
            if (mAnimate) {
                if (mAnimationResId != 0) {
                    window.setWindowAnimations(mAnimationResId);
                } else {
//                    window.setWindowAnimations(R.style.BottomDialogAnimation);
                }
            }
        }
        //设置点击外部对话框是否消失
        dialog.setCanceledOnTouchOutside(mCanceledOnTouchOutside);
        dialog.show();
    }

    public static class Builder {

        private Context mContext;
        private int mLayoutId;
        private View mContentView;
        private boolean mCanceledOnTouchOutside;
        private boolean mAnimate;
        private int mAnimationResId;
        private int mGravity;

        public Builder(Context context) {
            mContext = context;
        }

        public Builder setLayoutId(int layoutId) {
            mLayoutId = layoutId;
            return this;
        }

        public Builder setContentView(View contentView) {
            mContentView = contentView;
            return this;
        }

        public Builder canceledOnTouchOutside(boolean canceledOnTouchOutside) {
            mCanceledOnTouchOutside = canceledOnTouchOutside;
            return this;
        }

        public Builder animate(boolean animate) {
            mAnimate = animate;
            return this;
        }

        public Builder setAnimationResId(int animationResId) {
            this.mAnimationResId = animationResId;
            return this;
        }
        public Builder setGravity(int gravity) {
            this.mGravity = gravity;
            return this;
        }

        public CommonDialog build() {
            return new CommonDialog(this);
        }
    }

}