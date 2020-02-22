package com.qinshou.commonmodule.util;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PixelFormat;
import android.graphics.PointF;
import android.os.Build;
import android.provider.Settings;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.Toast;

/**
 * Description:状态栏工具类
 * Created by 禽兽先生
 * Created on 2018/3/22
 */

public class StatusBarUtil {

    /**
     * Description:沉浸式(App 界面延伸到 StatusBar 底下)
     * Date:2018/3/22
     */
    public static void setStatusBarTranslucent(Window window, boolean translucent) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            View decorView = window.getDecorView();
            if (translucent) {
                decorView.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() {
                    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
                    @Override
                    public WindowInsets onApplyWindowInsets(View v, WindowInsets insets) {
                        WindowInsets defaultInsets = v.onApplyWindowInsets(insets);
                        return defaultInsets.replaceSystemWindowInsets(
                                defaultInsets.getSystemWindowInsetLeft(),
                                0,
                                defaultInsets.getSystemWindowInsetRight(),
                                defaultInsets.getSystemWindowInsetBottom());
                    }
                });
            } else {
                decorView.setOnApplyWindowInsetsListener(null);
            }
            ViewCompat.requestApplyInsets(decorView);
//        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
//            if (translucent) {
//                window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
//            } else {
//                window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
//            }
//            ViewCompat.requestApplyInsets(window.getDecorView());
        }
    }

    /**
     * Description:设置状态栏颜色
     * Date:2018/3/22
     */
    public static void setStatusBarColor(final Window window, int color, boolean animated) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            if (animated) {
                int curColor = window.getStatusBarColor();
                ValueAnimator colorAnimation = ValueAnimator.ofObject(new ArgbEvaluator(), curColor, color);

                colorAnimation.addUpdateListener(
                        new ValueAnimator.AnimatorUpdateListener() {
                            @TargetApi(21)
                            @Override
                            public void onAnimationUpdate(ValueAnimator animator) {
                                window.setStatusBarColor((Integer) animator.getAnimatedValue());
                            }
                        });
                colorAnimation.setDuration(200).setStartDelay(0);
                colorAnimation.start();
            } else {
                window.setStatusBarColor(color);
            }
//        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
//            ViewGroup decorViewGroup = (ViewGroup) window.getDecorView();
//            View statusBarView = decorViewGroup.findViewWithTag("custom_status_bar_tag");
//            if (statusBarView == null) {
//                statusBarView = new View(window.getContext());
//                statusBarView.setTag("custom_status_bar_tag");
//                FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(
//                        FrameLayout.LayoutParams.MATCH_PARENT, SystemUtil.getStatusBarHeight(window.getContext()));
//                params.gravity = Gravity.TOP;
//                statusBarView.setLayoutParams(params);
//                decorViewGroup.addView(statusBarView);
//            }
//
//            if (animated) {
//                Drawable drawable = statusBarView.getBackground();
//                int curColor = Integer.MAX_VALUE;
//                if (drawable != null && drawable instanceof ColorDrawable) {
//                    ColorDrawable colorDrawable = (ColorDrawable) drawable;
//                    curColor = colorDrawable.getColor();
//                }
//                if (curColor != Integer.MAX_VALUE) {
//                    final View barView = statusBarView;
//                    ValueAnimator colorAnimation = ValueAnimator.ofObject(new ArgbEvaluator(), curColor, color);
//                    colorAnimation.addUpdateListener(
//                            new ValueAnimator.AnimatorUpdateListener() {
//                                @Override
//                                public void onAnimationUpdate(ValueAnimator animator) {
//                                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
//                                        barView.setBackground(new ColorDrawable((Integer) animator.getAnimatedValue()));
//                                    }
//                                }
//                            });
//                    colorAnimation.setDuration(200).setStartDelay(0);
//                    colorAnimation.start();
//                } else {
//                    statusBarView.setBackground(new ColorDrawable(color));
//                }
//            } else {
//                statusBarView.setBackground(new ColorDrawable(color));
//            }
        }
    }

    /**
     * Description:设置状态栏图标是否为黑色
     * Android 6.0 以上才有效
     * Date:2018/3/22
     */
    public static void setStatusBarStyle(Window window, boolean dark) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            View decorView = window.getDecorView();
            decorView.setSystemUiVisibility(dark ? View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR : View.SYSTEM_UI_FLAG_VISIBLE);
        }
    }

    /**
     * Description:隐藏状态栏
     * Date:2018/4/17
     */
    public static void setStatusBarHidden(Window window, boolean hidden) {
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            if (hidden) {
                window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
                window.clearFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN);
            } else {
                window.addFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN);
                window.clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
            }
        }

//        if (Build.VERSION.SDK_INT == Build.VERSION_CODES.KITKAT) {
//            ViewGroup decorViewGroup = (ViewGroup) window.getDecorView();
//            final View statusBarView = decorViewGroup.findViewWithTag("custom_status_bar_tag");
//
//            if (statusBarView != null) {
//                boolean hiding = statusBarView.isClickable();
//                if (hiding == hidden) {
//                    return;
//                }
//
//                if (hidden) {
//                    statusBarView.setClickable(true);
//                    ObjectAnimator animator = ObjectAnimator.ofFloat(statusBarView, "y", -SystemUtil.getStatusBarHeight(window.getContext()));
//                    animator.setDuration(200);
//                    animator.setStartDelay(200);
//                    animator.start();
//                } else {
//                    statusBarView.setClickable(false);
//                    ObjectAnimator animator = ObjectAnimator.ofFloat(statusBarView, "y", 0);
//                    animator.setDuration(200);
//                    animator.start();
//                }
//            }
//        }
    }

    public static void appendStatusBarPadding(View view, int viewHeight) {
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            if (view != null) {
                int statusBarHeight = getStatusBarHeight(view.getContext());
                view.setPadding(view.getPaddingLeft(), statusBarHeight, view.getPaddingRight(), view.getPaddingBottom());
                if (viewHeight > 0) {
                    view.getLayoutParams().height = statusBarHeight + viewHeight;
                } else {
                    view.getLayoutParams().height = viewHeight;
                }
            }
        }
    }

    public static void removeStatusBarPadding(View view, int viewHeight) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            if (view != null) {
                view.setPadding(view.getPaddingLeft(), 0, view.getPaddingRight(),
                        view.getPaddingBottom());
                view.getLayoutParams().height = viewHeight;
            }
        }
    }
    /**
     * Description:获取状态栏高度,返回像素
     * Date:2017/9/1
     */
    public static int getStatusBarHeight(Context context) {
        int resourceId = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        return resourceId > 0 ? context.getResources().getDimensionPixelSize(resourceId) : 0;
    }

    public static void clickBackToTop(Context context, View view) {
        if (Build.VERSION.SDK_INT >= 23) {
            if (Settings.canDrawOverlays(context)) {
                showWindow(context, view);
            } else {
                //若没有权限，提示获取.
                Intent intent = new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION);
                Toast.makeText(context, "需要取得权限以使用悬浮窗", Toast.LENGTH_SHORT).show();
                context.startActivity(intent);
            }
        } else {
            //SDK在23以下，不用管.
            showWindow(context, view);
        }
    }

    private static void showWindow(final Context context, final View view) {
        //创建 WindowManager 的 LayoutParams.
        final WindowManager.LayoutParams mLayoutParams = new WindowManager.LayoutParams();
        WindowManager mWindowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        //设置type.系统提示型窗口，一般都在应用程序窗口之上.
        mLayoutParams.type = WindowManager.LayoutParams.TYPE_SYSTEM_ERROR;
        //设置效果为背景透明.
        mLayoutParams.format = PixelFormat.RGBA_8888;
        //设置flags.不可聚焦及不可使用按钮对悬浮窗进行操控
        //设置 FLAG_FULLSCREEN 和 FLAG_LAYOUT_IN_SCREEN 才会全屏出现在状态栏之上
        mLayoutParams.flags = WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE
                | WindowManager.LayoutParams.FLAG_FULLSCREEN
                | WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN;

        //设置悬浮窗初始停靠位置.
        mLayoutParams.gravity = Gravity.LEFT | Gravity.TOP;
        mLayoutParams.x = 0;
        //预留了一点距离用于下拉出现通知栏
        mLayoutParams.y = 20;

        //设置悬浮窗宽高
        mLayoutParams.width = ViewGroup.LayoutParams.MATCH_PARENT;
        mLayoutParams.height = SystemUtil.getStatusBarHeight(context) - mLayoutParams.y;

        //设置悬浮窗中视图为一个透明 View
        View mView = new View(context);
        mView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, SystemUtil.getStatusBarHeight(context) - mLayoutParams.y));
        mView.setBackgroundColor(Color.TRANSPARENT);
        mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (view instanceof ScrollView) {
                    final ScrollView mScrollView = (ScrollView) view;
                    mScrollView.smoothScrollTo(0, 0);
                } else if (view instanceof ListView) {
                    ListView mListView = (ListView) view;
                    mListView.smoothScrollToPositionFromTop(0, 0, 500);
                } else if (view instanceof RecyclerView) {
                    RecyclerView mRecyclerView = (RecyclerView) view;
                    LinearSmoothScroller mLinearSmoothScroller = new LinearSmoothScroller(context) {

                        @Override
                        protected int calculateTimeForScrolling(int dx) {
                            if (dx > 3000) {
                                dx = 3000;
                            }
                            return super.calculateTimeForScrolling(dx);
                        }

                        @Nullable
                        @Override
                        public PointF computeScrollVectorForPosition(int targetPosition) {
                            return super.computeScrollVectorForPosition(targetPosition);
                        }
                    };
                    mLinearSmoothScroller.setTargetPosition(0);
                    mRecyclerView.getLayoutManager().startSmoothScroll(mLinearSmoothScroller);
                }
            }
        });
        mWindowManager.addView(mView, mLayoutParams);
    }
}
