package com.qinshou.commonmodule.base;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/**
 * Description:P 层的基类
 * Author: QinHao
 * Date: 2019/4/3 19:12
 */
public abstract class AbsPresenter<V extends IBaseView, M extends IBaseModel> {
    /**
     * View 层的弱引用
     */
    private Reference<V> mViewReference;
    private M mModel;

    /**
     * description:初始化 Model
     * author:QinHao
     * date:2019/4/4 13:14
     */
    public abstract M initModel();

    public AbsPresenter() {
        mModel = initModel();
    }

    /**
     * description:依附 View
     * author:QinHao
     * date:2019/4/4 9:19
     */
    public void attachView(V view) {
        mViewReference = new WeakReference<V>(view);
    }

    /**
     * description:分离 View
     * author:QinHao
     * date:2019/4/4 9:19
     */
    public void detachView() {
        if (mViewReference != null) {
            mViewReference.clear();
            mViewReference = null;
        }
    }

    /**
     * description:判断 View 是否已销毁
     * author:QinHao
     * date:2019/4/4 9:20
     */
    public boolean isViewAttached() {
        return mViewReference != null && mViewReference.get() != null;
    }

    /**
     * description:获取 View
     * author:QinHao
     * date:2019/5/26 15:09
     */
    public V getView() {
        return mViewReference.get();
    }

    /**
     * description:获取 Model
     * author:QinHao
     * date:2019/5/26 15:09
     */
    public M getModel() {
        return mModel;
    }
}
