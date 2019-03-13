package com.qinshou.networkmodule;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Description:Observer 的基类,用户只需要关心 onNext() 和 onError() 方法
 * Created by 禽兽先生
 * Created on 2018/4/18
 */

public abstract class BaseObserver<T> implements Observer<T> {
    private Disposable mDisposable;

    @Override
    public void onSubscribe(Disposable d) {
        mDisposable = d;
        DisposableManager.getInstance().addDisposable(d);
    }

    @Override
    public abstract void onNext(T value);

    @Override
    public abstract void onError(Throwable e);

    @Override
    public void onComplete() {
        DisposableManager.getInstance().removeDisposable(mDisposable);
    }
}
