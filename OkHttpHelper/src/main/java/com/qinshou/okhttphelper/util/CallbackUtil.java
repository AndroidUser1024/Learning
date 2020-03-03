package com.qinshou.okhttphelper.util;

import com.qinshou.okhttphelper.callback.Callback;
import com.qinshou.okhttphelper.callback.FailureRunnable;
import com.qinshou.okhttphelper.callback.SuccessRunnable;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * Author: MrQinshou
 * Email:cqflqinhao@126.com
 * Date: 2020-03-03 20:44
 * Description:回调工具类，会反射调用获取 Android 主线程的 Handler
 * 如果反射成功就在主线程中回调，失败则在发起请求的线程中调用，
 */
public class CallbackUtil {

    /**
     * Author: QinHao
     * Email:qinhao@jeejio.com
     * Date:2019/7/16 15:51
     * Description:成功请求并解析数据后的回调
     *
     * @param callback 回调接口
     * @param t        解析后的数据
     */
    public static <T> void successCallback(Callback<T> callback, T t) {
        // android.os.Handler 的 post 方法
        Method post = null;
        // android.os.Handler 的 实例对象
        Object handler = null;
        try {
            // 反射获取 Handler 的 class
            Class<?> handlerClass = Class.forName("android.os.Handler");
            // 反射获取 Looper 的 class
            Class<?> looperClass = Class.forName("android.os.Looper");
            // 获取 mainLooper
            Object mainLooper = looperClass.getMethod("getMainLooper").invoke(null);
            // 获取 Handler 参数为 Looper 的构造方法
            Constructor<?> constructor = handlerClass.getConstructor(looperClass);
            // 创建 Handler 对象
            handler = constructor.newInstance(mainLooper);
            // 获取参数为 Runnable 的 post 方法
            post = handlerClass.getMethod("post", Runnable.class);
        } catch (Exception ignoreException) {
            System.err.println(ignoreException.getMessage());
        }
        if (post == null || handler == null) {
            // 如果反射不成功,则就在子线程中回调
            callback.onSuccess(t);
        } else {
            // 如果反射成功,则在主线程中回调
            try {
                post.invoke(handler, new SuccessRunnable<>(callback, t));
            } catch (Exception ignoreException) {
                callback.onSuccess(t);
            }
        }
    }

    /**
     * Author: QinHao
     * Email:qinhao@jeejio.com
     * Date:2019/7/16 15:52
     * Description:成功请求并解析数据后的回调
     *
     * @param callback 回调接口
     * @param e        异常
     */
    public static <T> void failureCallback(Callback<T> callback, Exception e) {
        // android.os.Handler 的 post 方法
        Method post = null;
        // android.os.Handler 的 实例对象
        Object handler = null;
        try {
            // 反射获取 Handler 的 class
            Class<?> handlerClass = Class.forName("android.os.Handler");
            // 反射获取 Looper 的 class
            Class<?> looperClass = Class.forName("android.os.Looper");
            // 获取 mainLooper
            Object mainLooper = looperClass.getMethod("getMainLooper").invoke(null);
            // 获取 Handler 参数为 Looper 的构造方法
            Constructor<?> constructor = handlerClass.getConstructor(looperClass);
            // 创建 Handler 对象
            handler = constructor.newInstance(mainLooper);
            // 获取参数为 Runnable 的 post 方法
            post = handlerClass.getMethod("post", Runnable.class);
        } catch (Exception ignoreException) {
            System.err.println(ignoreException.getMessage());
        }
        if (post == null || handler == null) {
            // 如果反射不成功,则就在子线程中回调
            callback.onFailure(e);
        } else {
            // 如果反射成功,则在主线程中回调
            try {
                post.invoke(handler, new FailureRunnable<>(callback, e));
            } catch (Exception ignoreException) {
                callback.onFailure(e);
            }
        }
    }

}
