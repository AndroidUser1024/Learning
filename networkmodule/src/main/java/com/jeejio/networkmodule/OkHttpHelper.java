package com.jeejio.networkmodule;

import android.util.Log;

import com.jeejio.networkmodule.annotation.Api;
import com.jeejio.networkmodule.annotation.Get;
import com.jeejio.networkmodule.annotation.Header;
import com.jeejio.networkmodule.annotation.Json;
import com.jeejio.networkmodule.annotation.Param;
import com.jeejio.networkmodule.annotation.Post;
import com.jeejio.networkmodule.call.CallImpl;
import com.jeejio.networkmodule.interceptor.LogInterceptor;
import com.jeejio.networkmodule.util.RequestFactory;

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
                .addInterceptor(new LogInterceptor(LogInterceptor.Level.BODY, new LogInterceptor.Logger() {
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
                Map<String, Object> paramMap = getParamMap(method.getParameterAnnotations(), args);
                // 获取请求地址和请求方式
                Request request = null;
                String url = "";
                Map<String, String> headerMap = getHeaderMap(method.getParameterAnnotations(), args);
                Api api = clazz.getAnnotation(Api.class);
                if (api != null) {
                    url += api.value();
                }
                Get get = method.getAnnotation(Get.class);
                Post post = method.getAnnotation(Post.class);
                if (get != null) {
                    url += get.value();
                    request = RequestFactory.newGetRequest(url, headerMap, paramMap);
                } else if (post != null) {
                    url += post.value();
                    if (method.getAnnotation(Json.class) != null) {
                        request = RequestFactory.newPostJsonRequest(url, headerMap, paramMap);
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

    private Map<String, Object> getParamMap(Annotation[][] parameterAnnotations, Object[] args) {
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

    private Map<String, String> getHeaderMap(Annotation[][] parameterAnnotations, Object[] args) {
        Map<String, String> headerMap = new HashMap<>();
        // 解析参数
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
}
