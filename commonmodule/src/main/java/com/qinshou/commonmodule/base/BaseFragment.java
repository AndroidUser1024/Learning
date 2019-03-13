package com.qinshou.commonmodule.base;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.qinshou.commonmodule.util.StatusBarUtil;

/**
 * Description:所有 Fragment 的基类
 * Created by 禽兽先生
 * Created on 2018/1/8
 */

public abstract class BaseFragment extends Fragment {
    private View rootView;

    /**
     * Description:初始化布局资源 ID
     * Date:2018/3/5
     */
    public abstract int getLayoutId();

    /**
     * Description:设置 Presenter,不使用 MVP 模式可以不用设置
     * Date:2018/3/7
     */
    public abstract void setPresenter();

    /**
     * Description:初始化各控件
     * Date:2018/3/5
     */
    public abstract void initView();

    /**
     * Description:设置监听器
     * Date:2018/3/5
     */
    public abstract void setListener();

    /**
     * Description:初始化数据
     * Date:2018/3/5
     */
    public abstract void initData();

    /**
     * Description:是否沉浸式,使内容延伸到状态栏下并使状态栏透明
     * Date:2018/4/10
     */
    public boolean getIsImmersive() {
        return false;
    }

    /**
     * Description:设置状态栏颜色,需在 getLayoutId() 方法前调用,通常在 getIsImmersive() 方法中设置
     * Date:2018/4/17
     */
    public int getStatusBarColor() {
        return Color.BLACK;
    }

    /**
     * Description:设置状态栏图标是否为深色,需在 getLayoutId() 方法前调用,通常在 getIsImmersive() 方法中设置
     * Date:2018/4/17
     */
    public boolean getStatusBarIsDark() {
        return false;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (getIsImmersive()) {
            //使内容延伸到状态栏下
            StatusBarUtil.setStatusBarTranslucent(getActivity().getWindow(), true);
            //使状态栏透明
            StatusBarUtil.setStatusBarColor(getActivity().getWindow(), Color.TRANSPARENT, true);
        } else {
            StatusBarUtil.setStatusBarTranslucent(getActivity().getWindow(), false);
            StatusBarUtil.setStatusBarColor(getActivity().getWindow(), getStatusBarColor(), false);
        }
        //状态栏深色图标
        StatusBarUtil.setStatusBarStyle(getActivity().getWindow(), getStatusBarIsDark());
        rootView = LayoutInflater.from(getContext()).inflate(getLayoutId(), null, false);
        setPresenter();
        initView();
        initData();
        setListener();
        return rootView;
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (!hidden) {
            if (getIsImmersive()) {
                StatusBarUtil.setStatusBarTranslucent(getActivity().getWindow(), true);
                StatusBarUtil.setStatusBarColor(getActivity().getWindow(), Color.TRANSPARENT, true);
            } else {
                StatusBarUtil.setStatusBarTranslucent(getActivity().getWindow(), false);
                StatusBarUtil.setStatusBarColor(getActivity().getWindow(), getStatusBarColor(), false);
            }
            //状态栏深色图标
            StatusBarUtil.setStatusBarStyle(getActivity().getWindow(), getStatusBarIsDark());
        }
    }

    public <T extends View> T findViewByID(int viewId) {
        if (rootView != null) {
            return (T) rootView.findViewById(viewId);
        }
        return null;
    }
}
