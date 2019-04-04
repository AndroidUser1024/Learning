package com.qinshou.commonmodule.base;

/**
 * Description:P 层的基类
 * Author: QinHao
 * Date: 2019/4/3 19:12
 */
public abstract class AbsBasePresenter<V extends IBaseView, M extends IBaseModel> {
    private V mView;
    private M mModel;

    /**
     * description:初始化 Model
     * author:QinHao
     * date:2019/4/4 13:14
     */
    public abstract M initModel();

    public AbsBasePresenter() {
        mModel = initModel();
    }

    /**
     * description:依附 View
     * author:QinHao
     * date:2019/4/4 9:19
     */
    public void attachView(V view) {
        mView = view;
    }

    /**
     * description:分离 View
     * author:QinHao
     * date:2019/4/4 9:19
     */
    public void detachView() {
        mView = null;
    }

    /**
     * description:判断 View 是否已销毁
     * author:QinHao
     * date:2019/4/4 9:20
     */
    public boolean isViewAttached() {
        return mView == null;
    }

    public V getView() {
        return mView;
    }

    public M getModel() {
        return mModel;
    }
}
