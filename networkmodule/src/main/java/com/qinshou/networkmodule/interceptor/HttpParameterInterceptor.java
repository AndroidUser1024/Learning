package com.qinshou.networkmodule.interceptor;


import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.FormBody;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Description:添加公共参数的 URL 拦截器
 * Created by 禽兽先生
 * Created on 2017/12/19
 */

public class HttpParameterInterceptor implements Interceptor {
    private Map<String, String> parametersMap = new HashMap<>();

    private HttpParameterInterceptor(Builder builder) {
        this.parametersMap = builder.parametersMap;
    }

    public Map<String, String> getParametersMap() {
        return parametersMap;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request oldRequest = chain.request();
        Request newRequest = oldRequest;
        if (oldRequest.method().toUpperCase().equals("GET")) {
            if (parametersMap.size() > 0) {
                HttpUrl.Builder httpUrlBuilder = oldRequest.url().newBuilder();
                httpUrlBuilder.scheme(oldRequest.url().scheme()).host(oldRequest.url().host());
                for (Map.Entry<String, String> parameter : parametersMap.entrySet()) {
                    if (parameter.getKey() != null && parameter.getValue() != null) {
                        httpUrlBuilder.addQueryParameter(parameter.getKey(), parameter.getValue());
                    }
                }
                newRequest = oldRequest.newBuilder()
                        .method(oldRequest.method(), oldRequest.body())
                        .url(httpUrlBuilder.build())
                        .build();
            }
        } else {
            if (oldRequest.method().toUpperCase().equals("POST")) {
                if (parametersMap.size() > 0) {
                    FormBody.Builder formBodyBuilder = new FormBody.Builder();
                    FormBody formBody = (FormBody) oldRequest.body();
                    if (formBody != null) {
                        for (int i = 0; i < formBody.size(); i++) {
                            if (formBody.encodedName(i) != null && formBody.encodedValue(i) != null) {
                                formBodyBuilder.addEncoded(formBody.encodedName(i), formBody.encodedValue(i));
                            }
                        }
                    }
                    for (Map.Entry<String, String> parameter : parametersMap.entrySet()) {
                        if (parameter.getKey() != null && parameter.getValue() != null) {
                            formBodyBuilder.addEncoded(parameter.getKey(), parameter.getValue());
                        }
                    }
                    newRequest = oldRequest.newBuilder()
                            .method(oldRequest.method(), oldRequest.body())
                            .post(formBodyBuilder.build()).build();
                }
            }
        }
        return chain.proceed(newRequest);
    }

    public static class Builder {
        private Map<String, String> parametersMap;

        public Builder() {
            parametersMap = new HashMap<>();
        }

        public Builder addHeaderParameter(String key, String value) {
            parametersMap.put(key, value);
            return this;
        }

        public Builder addHeaderParameter(String key, int value) {
            parametersMap.put(key, String.valueOf(value));
            return this;
        }

        public Builder addHeaderParameter(String key, float value) {
            parametersMap.put(key, String.valueOf(value));
            return this;
        }

        public Builder addHeaderParameter(String key, double value) {
            parametersMap.put(key, String.valueOf(value));
            return this;
        }

        public Builder addHeaderParameter(String key, long value) {
            parametersMap.put(key, String.valueOf(value));
            return this;
        }

        public Builder addHeaderParameter(String key, boolean value) {
            parametersMap.put(key, String.valueOf(value));
            return this;
        }

        public HttpParameterInterceptor build() {
            return new HttpParameterInterceptor(this);
        }
    }
}