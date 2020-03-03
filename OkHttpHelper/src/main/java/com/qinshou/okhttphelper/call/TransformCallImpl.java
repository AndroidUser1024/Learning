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
 * Date: 2019/7/4 17:07
 * Description:转换回调接口传值泛型后的请求调用者
 */
public class TransformCallImpl<I, O> implements ICall<O> {
    private OkHttpClient mOkHttpClient;
    private Request mRequest;
    private Type mType;
    private ResponseTransformer<I, O> mResponseTransformer;
    private Call mCall;

    public TransformCallImpl(OkHttpClient okHttpClient, Request request, Type type, ResponseTransformer<I, O> responseTransformer) {
        mOkHttpClient = okHttpClient;
        mRequest = request;
        mType = type;
        mResponseTransformer = responseTransformer;
    }

    public void enqueue(final Callback<O> callback) {
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
            public void onResponse(okhttp3.Call call, Response response) throws IOException {
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
                I i = new Gson().fromJson(json, mType);
                try {
                    O o = mResponseTransformer.transform(i);
                    successCallback(post, handler, callback, o);
                } catch (Exception e) {
                    failureCallback(post, handler, callback, e);
                }
            }
        });
    }

    @Override
    public <O1> TransformCallImpl<O, O1> transform(ResponseTransformer<O, O1> responseTransformer) {
        return null;
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
     * @param o        解析后的数据
     */
    private void successCallback(Method post, Object handler, Callback<O> callback, O o) {
        if (post == null || handler == null) {
            // 如果反射不成功,则就在子线程中回调
            callback.onSuccess(o);
        } else {
            // 如果反射成功,则在主线程中回调
            try {
                post.invoke(handler, new SuccessRunnable<>(callback, o));
            } catch (Exception ignoreException) {
                System.err.println(ignoreException.getMessage());
                callback.onSuccess(o);
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
    private void failureCallback(Method post, Object handler, Callback<O> callback, Exception e) {
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
