package com.qinshou.commonmodule.base;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.qinshou.commonmodule.util.StatusBarUtil;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Description:适合 MVP 架构的 BaseActivity
 * Author: QinHao
 * Date: 2019/4/4 9:12
 */
public abstract class AbsMVPFragment<P extends AbsPresenter> extends Fragment implements IBaseView {
    private View mRootView;
    private P mPresenter;

    /**
     * Author: QinHao
     * Email:qinhao@jeejio.com
     * Date:2019/6/10 16:23
     * Description:初始化布局资源 ID
     *
     * @return 返回布局资源 ID
     */
    public abstract int getLayoutId();

    /**
     * Author: QinHao
     * Email:qinhao@jeejio.com
     * Date:2019/6/10 16:23
     * Description:初始化各控件,做各种 findViewByID,setAdapter,setLayoutManager 等操作
     */
    public abstract void initView();

    /**
     * Author: QinHao
     * Email:qinhao@jeejio.com
     * Date:2019/6/10 16:24
     * Description:设置监听器
     */
    public abstract void setListener();

    /**
     * Author: QinHao
     * Email:qinhao@jeejio.com
     * Date:2019/6/10 16:25
     * Description:初始化数据,发起网络请求等
     */
    public abstract void initData();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (isImmersive()) {
            //使内容延伸到状态栏下
            StatusBarUtil.setStatusBarTranslucent(getActivity().getWindow(), true);
            //使状态栏透明
            StatusBarUtil.setStatusBarColor(getActivity().getWindow(), Color.TRANSPARENT, true);
        } else {
            StatusBarUtil.setStatusBarTranslucent(getActivity().getWindow(), false);
            StatusBarUtil.setStatusBarColor(getActivity().getWindow(), initStatusBarColor(), false);
        }
        //状态栏深色图标
        StatusBarUtil.setStatusBarStyle(getActivity().getWindow(), initStatusBarDark());
        mRootView = LayoutInflater.from(getContext()).inflate(getLayoutId(), null, false);
        mPresenter = createPresenter();
        if (mPresenter != null) {
            mPresenter.attachView(this);
        }
        initView();
        setListener();
        initData();
        return mRootView;

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (mPresenter != null) {
            mPresenter.detachView();
        }
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (!hidden) {
            if (isImmersive()) {
                StatusBarUtil.setStatusBarTranslucent(getActivity().getWindow(), true);
                StatusBarUtil.setStatusBarColor(getActivity().getWindow(), Color.TRANSPARENT, true);
            } else {
                StatusBarUtil.setStatusBarTranslucent(getActivity().getWindow(), false);
                StatusBarUtil.setStatusBarColor(getActivity().getWindow(), initStatusBarColor(), false);
            }
            //状态栏深色图标
            StatusBarUtil.setStatusBarStyle(getActivity().getWindow(), initStatusBarDark());
        }
    }

    /**
     * Author: QinHao
     * Email:qinhao@jeejio.com
     * Date:2019/6/10 16:16
     * Description:创建 Presenter 的实例
     *
     * @return Presenter 实例的类型
     */
    private P createPresenter() {
        Class<P> pClass = getPresenterClass();
        if (pClass == null) {
            return null;
        }
        try {
            return pClass.newInstance();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (java.lang.InstantiationException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Author: QinHao
     * Email:qinhao@jeejio.com
     * Date:2019/6/10 16:16
     * Description:获取泛型上的真实类型
     *
     * @return P Presenter 的实例
     */
    private Class<P> getPresenterClass() {
        Type type = getClass().getGenericSuperclass();
        if (type instanceof ParameterizedType) {
            Type[] typeArray = ((ParameterizedType) type).getActualTypeArguments();
            if (typeArray.length > 0 && typeArray[0] instanceof Class) {
                return (Class<P>) typeArray[0];
            }
        }
        return null;
    }

    public P getPresenter() {
        return mPresenter;
    }

    public <T extends View> T findViewByID(int viewId) {
        if (mRootView != null) {
            return (T) mRootView.findViewById(viewId);
        }
        return null;
    }

    public void toastShort(String content) {
        Toast.makeText(getContext(), content, Toast.LENGTH_SHORT).show();
    }

    public void toastLong(String content) {
        Toast.makeText(getContext(), content, Toast.LENGTH_LONG).show();
    }

    public void finish() {
        if (getActivity() != null) {
            getActivity().finish();
        }
    }

    /**
     * Author: QinHao
     * Email:qinhao@jeejio.com
     * Date:2019/10/26 17:26
     * Description:是否沉浸式,使内容延伸到状态栏下并使状态栏透明
     */
    public boolean isImmersive() {
        return false;
    }

    /**
     * Author: QinHao
     * Email:qinhao@jeejio.com
     * Date:2019/10/26 17:31
     * Description:设置状态栏颜色,需在 initLayoutId() 方法前调用,通常在 isImmersive() 方法中设置
     */
    public int initStatusBarColor() {
        return 0xFF000000;
    }

    /**
     * Author: QinHao
     * Email:qinhao@jeejio.com
     * Date:2019/10/26 17:31
     * Description:设置状态栏图标是否为深色,需在 initLayoutId() 方法前调用,通常在 isImmersive() 方法中设置
     */
    public boolean initStatusBarDark() {
        return false;
    }
}
