package com.qinshou.networkmodule.rxbus;


import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.Subject;

/**
 * Description:利用 RxJava2 实现的事件总线框架，可代替 EventBus
 * 使用步骤：
 * 1.在需要传递事件的地方调用 getInstance() 获取 RxBus 单例，调用 post(Object obj) 方法即可。
 * 2.在需要接收事件的地方调用 getInstance() 获取 RxBus 单例，调用register([Class<T> tClass]) 方法即可获取到可被观察的对象。
 * Date:2017/11/1
 */
public class RxBus {

    private final Subject<Object> mBus;

    private RxBus() {
        mBus = PublishSubject.create().toSerialized();
    }

    public static RxBus getInstance() {
        return Holder.BUS;
    }

    public void post(Object obj) {
        mBus.onNext(obj);
    }

    public <T> Observable<T> register(Class<T> tClass) {
        return mBus.ofType(tClass);
    }

    public Observable<Object> register() {
        return mBus;
    }

    public boolean hasObservers() {
        return mBus.hasObservers();
    }

    public void unregisterAll() {
        //会将所有由mBus生成的Observable都置completed状态,后续的所有消息都收不到了
        mBus.onComplete();
    }

    private static class Holder {
        private static final RxBus BUS = new RxBus();
    }

}