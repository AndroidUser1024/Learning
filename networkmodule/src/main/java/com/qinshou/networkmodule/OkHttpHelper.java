package com.qinshou.networkmodule;

import android.util.Log;

import com.qinshou.networkmodule.annotation.Api;
import com.qinshou.networkmodule.annotation.Download;
import com.qinshou.networkmodule.annotation.DownloadCallback;
import com.qinshou.networkmodule.annotation.FileTarget;
import com.qinshou.networkmodule.annotation.Get;
import com.qinshou.networkmodule.annotation.Header;
import com.qinshou.networkmodule.annotation.Json;
import com.qinshou.networkmodule.annotation.Multipart;
import com.qinshou.networkmodule.annotation.Param;
import com.qinshou.networkmodule.annotation.Post;
import com.qinshou.networkmodule.annotation.Range;
import com.qinshou.networkmodule.annotation.Url;
import com.qinshou.networkmodule.call.AbsCall;
import com.qinshou.networkmodule.call.CallImpl;
import com.qinshou.networkmodule.call.DownloadCallImpl;
import com.qinshou.networkmodule.callback.IDownloadCallback;
import com.qinshou.networkmodule.interceptor.DownloadInterceptor;
import com.qinshou.networkmodule.interceptor.LogInterceptor;
import com.qinshou.networkmodule.util.RequestFactory;

import java.io.File;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2020/4/13 17:52
 * Description:网络请求帮助类
 */
public enum OkHttpHelper {
    SINGLETON;
    private OkHttpClient mOkHttpClient;

    OkHttpHelper() {
        // 创建默认的 OkHttpClient
        mOkHttpClient = new OkHttpClient.Builder()
                .connectTimeout(15, TimeUnit.SECONDS)
                .readTimeout(15, TimeUnit.SECONDS)
                .writeTimeout(15, TimeUnit.SECONDS)
                .addInterceptor(new LogInterceptor(LogInterceptor.Level.BODY, new LogInterceptor.Logger() {
                    @Override
                    public void log(String message) {
                        Log.i("daolema", "message--->" + message);
                    }
                })).build();
    }

    public void recreateOkHttpClient(OkHttpClient okHttpClient) {
        mOkHttpClient = okHttpClient;
    }

    public <T> T getCaller(final Class<T> clazz) {
        return (T) Proxy.newProxyInstance(clazz.getClassLoader(), new Class[]{clazz}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if (method.getAnnotation(Get.class) != null) {
                    return getGetCall(method, args, clazz);
                } else if (method.getAnnotation(Post.class) != null) {
                    return getPostCall(method, args, clazz);
                }
                return null;
            }
        });
    }

    /**
     * Author: QinHao
     * Email:cqflqinhao@126.com
     * Date:2020/4/16 11:25
     * Description:获取 Get 请求的 Call
     */
    private AbsCall getGetCall(Method method, Object[] args, Class clazz) {
        // 获取返回类型
        Type genericReturnType = method.getGenericReturnType();
        if (!(genericReturnType instanceof ParameterizedType)) {
            throw new IllegalStateException("get return model type failure");
        }
        if (((ParameterizedType) genericReturnType).getActualTypeArguments().length == 0) {
            throw new IllegalStateException("get return model type failure");
        }
        // 获取 header
        Map<String, String> headerMap = getHeaderMap(method, args);
        // 获取参数
        Map<String, Object> paramMap = getParamMap(method, args);
        String url = getUrl(method, args, clazz);
        if (method.getAnnotation(Download.class) == null) {
            // 普通 Get 请求
            return new CallImpl(mOkHttpClient, RequestFactory.newGetRequest(url, headerMap, paramMap), ((ParameterizedType) genericReturnType).getActualTypeArguments()[0]);
        } else {
            // 下载请求
            File fileTarget = getFileTarget(method, args);
            // 断点续传
            long range = getRange(method, args);
            headerMap.put("RANGE", "bytes=" + range + "-");
            // 是否有监听下载进度
            IDownloadCallback downloadCallback = getDownloadCallback(method, args);
            if (downloadCallback != null) {
                // 如果需要监听下载进度,则添加拦截器
                OkHttpClient okHttpClient = mOkHttpClient.newBuilder()
                        .addInterceptor(new DownloadInterceptor(downloadCallback, fileTarget, range))
                        .build();
                return new DownloadCallImpl(okHttpClient, RequestFactory.newGetDownloadRequest(url, headerMap), fileTarget);
            } else {
                return new DownloadCallImpl(mOkHttpClient, RequestFactory.newGetDownloadRequest(url, headerMap), fileTarget);
            }
        }
    }

    /**
     * Author: QinHao
     * Email:cqflqinhao@126.com
     * Date:2020/4/16 11:24
     * Description:获取 Post 请求的 Call
     */
    private AbsCall getPostCall(Method method, Object[] args, Class clazz) {
        // 获取返回类型
        Type genericReturnType = method.getGenericReturnType();
        if (!(genericReturnType instanceof ParameterizedType)) {
            throw new IllegalStateException("get return model type failure");
        }
        if (((ParameterizedType) genericReturnType).getActualTypeArguments().length == 0) {
            throw new IllegalStateException("get return model type failure");
        }
        // 获取 header
        Map<String, String> headerMap = getHeaderMap(method, args);
        // 获取参数
        Map<String, Object> paramMap = getParamMap(method, args);
        String url = getUrl(method, args, clazz);
        Request request;
        if (method.getAnnotation(Json.class) != null) {
            // 参数以 json 格式传递
            request = RequestFactory.newPostJsonRequest(url, headerMap, paramMap);
        } else if (method.getAnnotation(Multipart.class) != null) {
            // 上传文件
            request = RequestFactory.newPostFileRequest(url, headerMap, paramMap);
        } else {
            // 参数以普通表单传递
            request = RequestFactory.newPostRequest(url, headerMap, paramMap);
        }
        return new CallImpl(mOkHttpClient, request, ((ParameterizedType) genericReturnType).getActualTypeArguments()[0]);
    }

    /**
     * Author: QinHao
     * Email:cqflqinhao@126.com
     * Date:2020/4/16 11:27
     * Description:获取所有的 Header
     */
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

    /**
     * Author: QinHao
     * Email:cqflqinhao@126.com
     * Date:2020/4/16 11:27
     * Description:获取所有的参数
     */
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

    /**
     * Author: QinHao
     * Email:cqflqinhao@126.com
     * Date:2020/4/16 11:27
     * Description:获取请求 url
     */
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

    /**
     * Author: QinHao
     * Email:cqflqinhao@126.com
     * Date:2020/4/16 11:28
     * Description:获取下载请求时的目标文件
     *
     * @return 如果是下载请求, 则返回目标文件;如果不是下载请求,则返回 null
     */
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

    /**
     * Author: QinHao
     * Email:cqflqinhao@126.com
     * Date:2020/4/16 11:28
     * Description:获取下载请求时的进度监听器
     *
     * @return 如果是下载请求且需要监听的话则返回, 否则返回 null
     */
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

    /**
     * Author: QinHao
     * Email:cqflqinhao@126.com
     * Date:2020/4/16 11:28
     * Description:获取下载请求时的断点续传起始位置
     *
     * @return 如果是下载请求且断点续传则返回指定起始位置, 否则返回 0
     */
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
