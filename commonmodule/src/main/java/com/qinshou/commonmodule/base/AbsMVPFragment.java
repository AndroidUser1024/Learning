package com.qinshou.commonmodule.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

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
}
