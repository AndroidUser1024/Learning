package com.qinshou.okhttphelper.call;

import com.google.gson.Gson;
import com.qinshou.okhttphelper.callback.Callback;
import com.qinshou.okhttphelper.callback.FailureRunnable;
import com.qinshou.okhttphelper.callback.SuccessRunnable;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/7/4 9:22
 * Description:请求调用者
 */
public class CallImpl<T> implements ICall<T> {
    private OkHttpClient mOkHttpClient;
    private Request mRequest;
    private Type mType;
    private Call mCall;

    public CallImpl(OkHttpClient okHttpClient, Request request, Type type) {
        mOkHttpClient = okHttpClient;
        mRequest = request;
        mType = type;
    }

    @Override
    public void enqueue(final Callback<T> callback) {
        if (mOkHttpClient == null || mRequest == null) {
            return;
        }
        mCall = mOkHttpClient.newCall(mRequest);
        mCall.enqueue(new okhttp3.Callback() {
            @Override
            public void onFailure(okhttp3.Call call, IOException e) {
                Method post = null;
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
                failureCallback(post, handler, callback, e);
            }

            @Override
            public void onResponse(okhttp3.Call call, Response response) {
                Method post = null;
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
                if (response.body() == null) {
                    failureCallback(post, handler, callback, new Exception(("response's body is null")));
                    return;
                }
                if (mType == null) {
                    failureCallback(post, handler, callback, new Exception(("return type is null")));
                    return;
                }
                String json;
                try {
                    json = response.body().string();
                } catch (IOException e) {
                    failureCallback(post, handler, callback, e);
                    return;
                }
                T t = new Gson().fromJson(json, mType);
                successCallback(post, handler, callback, t);
            }
        });
    }

    @Override
    public <O> TransformCallImpl<T, O> transform(ResponseTransformer<T, O> responseTransformer) {
        return new TransformCallImpl<>(mOkHttpClient, mRequest, mType, responseTransformer);
    }

    @Override
    public void cancel() {
        if (mCall != null) {
            mCall.cancel();
        }
    }

    /**
     * Author: QinHao
     * Email:qinhao@jeejio.com
     * Date:2019/7/16 15:51
     * Description:成功请求并解析数据后的回调
     *
     * @param post     android.os.Handler 的 post 方法
     * @param handler  android.os.Handler 的 实例对象
     * @param callback 回调接口
     * @param t        解析后的数据
     */
    private void successCallback(Method post, Object handler, Callback<T> callback, T t) {
        if (post == null || handler == null) {
            // 如果反射不成功,则就在子线程中回调
            callback.onSuccess(t);
        } else {
            // 如果反射成功,则在主线程中回调
            try {
                post.invoke(handler, new SuccessRunnable<>(callback, t));
            } catch (Exception ignoreException) {
                System.err.println(ignoreException.getMessage());
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
     * @param post     android.os.Handler 的 post 方法
     * @param handler  android.os.Handler 的 实例对象
     * @param callback 回调接口
     * @param e        异常
     */
    private void failureCallback(Method post, Object handler, Callback<T> callback, Exception e) {
        if (post == null || handler == null) {
            // 如果反射不成功,则就在子线程中回调
            callback.onFailure(e);
        } else {
            // 如果反射成功,则在主线程中回调
            try {
                post.invoke(handler, new FailureRunnable<>(callback, e));
            } catch (Exception ignoreException) {
                System.err.println(ignoreException.getMessage());
                callback.onFailure(e);
            }
        }
    }
}
