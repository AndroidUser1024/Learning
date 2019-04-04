package com.qinshou.commonmodule.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;

/**
 * Description:适合 MVP 架构的 BaseActivity
 * Author: QinHao
 * Date: 2019/4/4 9:12
 */
public abstract class BaseMVPActivity<P extends AbsBasePresenter> extends AppCompatActivity implements IBaseView {
    private View mRootView;
    private P mPresenter;

    /**
     * Description:初始化布局资源 ID
     * Date:2018/3/5
     */
    public abstract int getLayoutId();

    /**
     * description:初始化 Presenter
     * author:QinHao
     * date:2019/4/4 13:14
     */
    public abstract P initPresenter();

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

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mRootView = LayoutInflater.from(this).inflate(getLayoutId(), null, false);
        setContentView(mRootView);
        mPresenter = initPresenter();
        if (mPresenter != null) {
            mPresenter.attachView(this);
        }
        initView();
        setListener();
        initData();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.detachView();
        }
    }

//    private Class<P> getPresenterClass() {
//        Type type = getClass().getGenericSuperclass();
//        if (type == null) {
//            return null;
//        }
//        if (!(type instanceof ParameterizedType)) {
//            return null;
//        }
//        Type[] typeArray = ((ParameterizedType) type).getActualTypeArguments();
//        if (typeArray.length < 1 || !(typeArray[0] instanceof Class)) {
//            return null;
//        }
//        return (Class<P>) typeArray[0];
//    }
//
//    public void initPresenter() {
//        Class<P> clazz = getPresenterClass();
//        if (clazz == null) {
//            return;
//        }
//        try {
//            mPresenter = clazz.newInstance();
//        } catch (InstantiationException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        }
//    }

    public P getPresenter() {
        return mPresenter;
    }
}
