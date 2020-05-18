package com.qinshou.commonmodule.widget;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import androidx.annotation.IdRes;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.HashMap;
import java.util.Map;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2020/2/17 17:02
 * Description:BrainHealth 项目的 Activity 的基类
 * 使用示例:
 * StatusView statusView = new StatusView(Context);
 * statusView.init(Activity);
 * statusView.setLoadingView(loadingViewResId);
 * statusView.setEmptyView(emptyViewResId);
 * statusView.setFailureView(failureViewResId);
 * // 在合适的时机修改状态
 * statusView.changeStatus(Status);
 */
public class StatusView extends FrameLayout {
    private Map<Status, View> mStatusViewMap = new HashMap<>();

    public StatusView(@NonNull Context context) {
        this(context, null);
    }

    public StatusView(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public StatusView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /**
     * Author: QinHao
     * Email:qinhao@jeejio.com
     * Date:2020/2/17 13:42
     * Description:方法描述
     *
     * @param contentView 内容布局
     */
    private void initContentView(View contentView) {
        if (contentView == null) {
            return;
        }
        // 获取 contentView 的布局参数,用于设置 StatusView 的布局参数
        ViewGroup.LayoutParams layoutParams = contentView.getLayoutParams();
        // 获取 contentView 的父布局
        ViewGroup viewGroup = (ViewGroup) contentView.getParent();
        // 获取 contentView 在父布局中的下标
        int index = viewGroup.indexOfChild(contentView);
        // 将 contentView 从父布局中移除
        viewGroup.removeView(contentView);
        // 保存 contentView
        mStatusViewMap.put(Status.CONTENT, contentView);
        // 将 contentView 添加到 StatusView 中
        addView(contentView);
        // 将 StatusView 添加到原先 contentView 的位置,替换原本的 contentView
        viewGroup.addView(this, index, layoutParams);
    }

    /**
     * Author: QinHao
     * Email:qinhao@jeejio.com
     * Date:2020/2/17 13:30
     * Description:初始化 StatusView
     *
     * @param activity
     */
    public void init(Activity activity) {
        // 获取 Activity 根布局中的第一个子控件,这个子控件就是我们写在 xml 布局中的根布局
        View contentView = ((ViewGroup) activity.findViewById(android.R.id.content)).getChildAt(0);
        initContentView(contentView);
    }

    /**
     * Author: QinHao
     * Email:qinhao@jeejio.com
     * Date:2020/2/17 13:30
     * Description:初始化 StatusView
     *
     * @param activity
     */
    public void init(Activity activity, @IdRes int contentViewId) {
        // 获取 Activity 根布局中的第一个子控件,这个子控件就是我们写在 xml 布局中的根布局
        View view = ((ViewGroup) activity.findViewById(android.R.id.content)).getChildAt(0);
        // 获取需要显示多状态的目标控件 contentView
        View contentView = view.findViewById(contentViewId);
        initContentView(contentView);
    }

    /**
     * Author: QinHao
     * Email:qinhao@jeejio.com
     * Date:2020/2/17 13:30
     * Description:初始化 StatusView
     *
     * @param fragment 需要展示多状态的 Fragment,会将 fragment 的根布局作为 contentView
     */
    public void init(Fragment fragment) {
        // 获取 Activity 根布局中的第一个子控件,这个子控件就是我们写在 xml 布局中的根布局
        View view = fragment.getView();
        initContentView(view);
    }

    /**
     * Author: QinHao
     * Email:qinhao@jeejio.com
     * Date:2020/2/17 13:30
     * Description:初始化 StatusView
     *
     * @param fragment      需要展示多状态的 Fragment,会将 fragment 的根布局作为 contentView
     * @param contentViewId fragment 中需要展示多状态的控件
     */
    public void init(Fragment fragment, @IdRes int contentViewId) {
        // 获取 Activity 根布局中的第一个子控件,这个子控件就是我们写在 xml 布局中的根布局
        View view = fragment.getView();
        if (view == null) {
            return;
        }
        // 获取需要显示多状态的目标控件 contentView
        View contentView = view.findViewById(contentViewId);
        initContentView(contentView);
    }

    public enum Status {
        /**
         * 加载中布局
         */
        LOADING,
        /**
         * 真正需要展示的内容布局
         */
        CONTENT,
        /**
         * 空布局
         */
        EMPTY,
        /**
         * 失败布局
         */
        FAILURE,
    }

    public void setLoadingView(View loadingView) {
        mStatusViewMap.put(Status.LOADING, loadingView);
    }

    public void setLoadingView(@LayoutRes int loadingViewResId) {
        View view = View.inflate(getContext(), loadingViewResId, null);
        setLoadingView(view);
    }

    public void setEmptyView(View emptyView) {
        mStatusViewMap.put(Status.EMPTY, emptyView);
    }

    public void setEmptyView(@LayoutRes int emptyViewResId) {
        View view = View.inflate(getContext(), emptyViewResId, null);
        setEmptyView(view);
    }

    public void setFailureView(View failureView) {
        mStatusViewMap.put(Status.FAILURE, failureView);
    }

    public void setFailureView(@LayoutRes int failureViewResId) {
        View view = View.inflate(getContext(), failureViewResId, null);
        setFailureView(view);
    }

    /**
     * Author: QinHao
     * Email:qinhao@jeejio.com
     * Date:2020/2/17 13:38
     * Description:展示指定状态
     *
     * @param targetStatus 目标状态
     */
    public void changeStatus(Status targetStatus) {
        View view = mStatusViewMap.get(targetStatus);
        if (view == null) {
            return;
        }
        View currentView = getChildAt(0);
        if (currentView == view) {
            return;
        }
        removeAllViews();
        addView(view);
    }
}