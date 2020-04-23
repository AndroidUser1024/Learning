package com.qinshou.networkmodule.interceptor;


import android.util.Log;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Description:添加公共头的 URL 拦截器
 * Created by 禽兽先生
 * Created on 2017/12/19
 */

public class HttpHeaderInterceptor implements Interceptor {
    private static final String TAG = "HttpHeaderInterceptor";
    private Map<String, String> headersMap = new HashMap<>();

    private HttpHeaderInterceptor(Builder builder) {
        this.headersMap = builder.headersMap;
    }

    public Map<String, String> getHeadersMap() {
        return headersMap;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request.Builder builder = chain.request().newBuilder();
        for (Map.Entry<String, String> header : headersMap.entrySet()) {
            if (header.getKey() != null && header.getValue() != null) {
                builder.addHeader(header.getKey(), header.getValue());
            }
        }
        return chain.proceed(builder.build());
    }

    public static class Builder {
        private Map<String, String> headersMap;

        public Builder() {
            headersMap = new HashMap<>();
        }

        public Builder addHeader(String key, String value) {
            headersMap.put(key, value);
            return this;
        }

        public HttpHeaderInterceptor build() {
            return new HttpHeaderInterceptor(this);
        }
    }
}