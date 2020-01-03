package com.qinshou.okhttphelper.call;

import com.google.gson.Gson;
import com.qinshou.okhttphelper.callback.Callback;
import com.qinshou.okhttphelper.callback.FailureRunnable;
import com.qinshou.okhttphelper.callback.SuccessRunnable;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2020/1/3 9:35
 * Description:类描述
 */
public class DownloadCall {
    private OkHttpClient mOkHttpClient;
    private Request mRequest;
    private File mFile;

    public DownloadCall(OkHttpClient okHttpClient, Request request, File file) {
        mOkHttpClient = okHttpClient;
        mRequest = request;
        mFile = file;
    }

    public void enqueue(final Callback<File> callback) {
        if (mOkHttpClient == null || mRequest == null) {
            return;
        }
        mOkHttpClient.newCall(mRequest).enqueue(new okhttp3.Callback() {
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
                    failureCallback(post, handler, callback, new Exception(("Response's body is null")));
                    return;
                }
                if (mFile == null) {
                    failureCallback(post, handler, callback, new NullPointerException("The file to save is null"));
                }
                InputStream inputStream = response.body().byteStream();
                FileOutputStream fileOutputStream = null;
                try {
                    if (!mFile.getParentFile().exists()) {
                        mFile.getParentFile().mkdirs();
                    }
                    mFile.createNewFile();
                    fileOutputStream = new FileOutputStream(mFile);
                    byte[] bytes = new byte[1024 * 1024];
                    int len;
                    while ((len = inputStream.read(bytes)) != -1) {
                        fileOutputStream.write(bytes, 0, len);
                    }
                    fileOutputStream.flush();
                    successCallback(post, handler, callback, mFile);
                } catch (IOException e) {
                    failureCallback(post, handler, callback, e);
                } finally {
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });
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
    private void successCallback(Method post, Object handler, Callback<File> callback, File t) {
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
    private void failureCallback(Method post, Object handler, Callback<File> callback, Exception e) {
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
