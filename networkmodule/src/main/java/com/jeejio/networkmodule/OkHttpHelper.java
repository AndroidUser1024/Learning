package com.jeejio.networkmodule;

import android.util.Log;

import com.jeejio.networkmodule.annotation.Api;
import com.jeejio.networkmodule.annotation.Download;
import com.jeejio.networkmodule.annotation.DownloadCallback;
import com.jeejio.networkmodule.annotation.FileTarget;
import com.jeejio.networkmodule.annotation.Get;
import com.jeejio.networkmodule.annotation.Header;
import com.jeejio.networkmodule.annotation.Json;
import com.jeejio.networkmodule.annotation.Multipart;
import com.jeejio.networkmodule.annotation.Param;
import com.jeejio.networkmodule.annotation.Post;
import com.jeejio.networkmodule.annotation.Range;
import com.jeejio.networkmodule.annotation.Url;
import com.jeejio.networkmodule.call.CallImpl;
import com.jeejio.networkmodule.call.DownloadCallImpl;
import com.jeejio.networkmodule.callback.IDownloadCallback;
import com.jeejio.networkmodule.interceptor.DownloadInterceptor;
import com.jeejio.networkmodule.interceptor.LogInterceptor;
import com.jeejio.networkmodule.util.RequestFactory;

import java.io.File;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2020/4/13 17:52
 * Description:类描述
 */
public enum OkHttpHelper {
    SINGLETON;
    private OkHttpClient mOkHttpClient;

    OkHttpHelper() {
        // 创建默认的 OkHttpClient
        mOkHttpClient = new OkHttpClient.Builder()
                .addInterceptor(new LogInterceptor(LogInterceptor.Level.BASIC, new LogInterceptor.Logger() {
                    @Override
                    public void log(String message) {
                        Log.i("daolema", "message--->" + message);
                    }
                })).build();
    }

    public <T> T getCaller(final Class<T> clazz) {
        return (T) Proxy.newProxyInstance(clazz.getClassLoader(), new Class[]{clazz}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Map<String, Object> paramMap = getParamMap(method, args);
                // 获取请求地址和请求方式
                Request request = null;
                String url = getUrl(method, args, clazz);
                Map<String, String> headerMap = getHeaderMap(method, args);
                Get get = method.getAnnotation(Get.class);
                Post post = method.getAnnotation(Post.class);
                if (get != null) {
                    if (method.getAnnotation(Download.class) != null) {
                        File fileTarget = getFileTarget(method, args);
                        IDownloadCallback downloadCallback = getDownloadCallback(method, args);
                        long range = getRange(method, args);
                        headerMap.put("RANGE", "bytes=" + range + "-");
                        if (downloadCallback != null) {
                            OkHttpClient okHttpClient = mOkHttpClient.newBuilder()
                                    .addInterceptor(new DownloadInterceptor(downloadCallback, fileTarget, range))
                                    .build();
                            return new DownloadCallImpl(okHttpClient, RequestFactory.newGetDownloadRequest(url, headerMap), fileTarget);
                        } else {
                            return new DownloadCallImpl(mOkHttpClient, RequestFactory.newGetDownloadRequest(url, headerMap), fileTarget);
                        }
                    } else {
                        request = RequestFactory.newGetRequest(url, headerMap, paramMap);
                    }
                } else if (post != null) {
                    if (method.getAnnotation(Json.class) != null) {
                        request = RequestFactory.newPostJsonRequest(url, headerMap, paramMap);
                    } else if (method.getAnnotation(Multipart.class) != null) {
                        request = RequestFactory.newPostFileRequest(url, headerMap, paramMap);
                    } else {
                        request = RequestFactory.newPostRequest(url, headerMap, paramMap);
                    }
                }
                if (request == null) {
                    throw new IllegalStateException("request is null");
                }
                // 获取返回类型
                Type genericReturnType = method.getGenericReturnType();
                if (!(genericReturnType instanceof ParameterizedType)) {
                    throw new IllegalStateException("get return model type failure");
                }
                if (((ParameterizedType) genericReturnType).getActualTypeArguments().length == 0) {
                    throw new IllegalStateException("get return model type failure");
                }
                return new CallImpl<T>(mOkHttpClient, request, ((ParameterizedType) genericReturnType).getActualTypeArguments()[0]);
            }
        });
    }

    private <T> String getUrl(Method method, Object[] args, Class<T> clazz) {
        Annotation[][] parameterAnnotations = method.getParameterAnnotations();
        // 解析参数
        for (int i = 0; i < parameterAnnotations.length; i++) {
            for (Annotation annotation : parameterAnnotations[i]) {
                if (!(annotation instanceof Url)) {
                    continue;
                }
                return (String) args[i];
            }
        }
        String url = "";
        Api api = clazz.getAnnotation(Api.class);
        if (api != null) {
            url += api.value();
        }
        Get get = method.getAnnotation(Get.class);
        Post post = method.getAnnotation(Post.class);
        if (get != null) {
            url += get.value();
        } else if (post != null) {
            url += post.value();
        }
        return url;
    }

    private Map<String, Object> getParamMap(Method method, Object[] args) {
        Annotation[][] parameterAnnotations = method.getParameterAnnotations();
        Map<String, Object> paramMap = new HashMap<>();
        // 解析参数
        for (int i = 0; i < parameterAnnotations.length; i++) {
            for (Annotation annotation : parameterAnnotations[i]) {
                if (!(annotation instanceof Param)) {
                    continue;
                }
                String name = ((Param) annotation).value();
                paramMap.put(name, args[i]);
            }
        }
        return paramMap;
    }

    private Map<String, String> getHeaderMap(Method method, Object[] args) {
        Annotation[][] parameterAnnotations = method.getParameterAnnotations();
        Map<String, String> headerMap = new HashMap<>();
        // 解析 Header
        for (int i = 0; i < parameterAnnotations.length; i++) {
            for (Annotation annotation : parameterAnnotations[i]) {
                if (!(annotation instanceof Header)) {
                    continue;
                }
                String name = ((Header) annotation).value();
                headerMap.put(name, args[i].toString());
            }
        }
        return headerMap;
    }

    private File getFileTarget(Method method, Object[] args) {
        Annotation[][] parameterAnnotations = method.getParameterAnnotations();
        // 解析 Header
        for (int i = 0; i < parameterAnnotations.length; i++) {
            for (Annotation annotation : parameterAnnotations[i]) {
                if (!(annotation instanceof FileTarget)) {
                    continue;
                }
                return (File) args[i];
            }
        }
        return null;
    }

    private IDownloadCallback getDownloadCallback(Method method, Object[] args) {
        Annotation[][] parameterAnnotations = method.getParameterAnnotations();
        for (int i = 0; i < parameterAnnotations.length; i++) {
            for (Annotation annotation : parameterAnnotations[i]) {
                if (!(annotation instanceof DownloadCallback)) {
                    continue;
                }
                return (IDownloadCallback) args[i];
            }
        }
        return null;
    }

    private long getRange(Method method, Object[] args) {
        Annotation[][] parameterAnnotations = method.getParameterAnnotations();
        for (int i = 0; i < parameterAnnotations.length; i++) {
            for (Annotation annotation : parameterAnnotations[i]) {
                if (!(annotation instanceof Range)) {
                    continue;
                }
                return (long) args[i];
            }
        }
        return 0;
    }
}
