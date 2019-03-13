package com.qinshou.networkmodule;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Description:Disposable 的管理类
 * 在网络请求时,如果在 Activity 销毁后再请求到数据,再去处理 UI 则肯定会报异常,所以需要在 Activity 销毁后切断观察者和被观察者之间的联系
 * BaseObserver 会在观察者和被观察者建立联系后首先调用的 onSubscribe() 方法中将 Disposable 存到该类的 CompositeDisposable
 * 在应用退出时调用 clear() 则可以切断所有联系,观察者就不会再接收到发送的事件
 * Created by 禽兽先生
 * Created on 2018/4/18
 */

public class DisposableManager {
    private CompositeDisposable mCompositeDisposable;

    public static DisposableManager getInstance() {
        return SingleHolder.singleton;
    }

    private static class SingleHolder {
        private static final DisposableManager singleton = new DisposableManager();
    }

    private DisposableManager() {
        mCompositeDisposable = new CompositeDisposable();
    }

    public void addDisposable(Disposable disposable) {
        mCompositeDisposable.add(disposable);
    }

    public void removeDisposable(Disposable disposable) {
        mCompositeDisposable.remove(disposable);
    }

    public void clear() {
        mCompositeDisposable.clear();
    }
}
