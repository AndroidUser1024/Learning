package com.qinshou.okhttphelper.interceptor;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.LongSerializationPolicy;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.FormBody;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okio.Buffer;

/**
 * Description:添加公共参数的 URL 拦截器
 * Created by 禽兽先生
 * Created on 2017/12/19
 */

public class HttpParameterInterceptor implements Interceptor {
    private static final String TAG = "HttpParameterInterceptor";
    private Map<String, Object> parametersMap = new HashMap<>();

    private HttpParameterInterceptor(Builder builder) {
        this.parametersMap = builder.parametersMap;
    }

    public Map<String, Object> getParametersMap() {
        return parametersMap;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        if (request.method().equalsIgnoreCase("GET")) {
            //根据原 request 的 url 重新创建 builder
            HttpUrl.Builder httpUrlBuilder = request.url().newBuilder();
            //由于是 GET 请求,原 url 已经拼接了原来的参数,所以不用重新拼接,只需要追加公共参数即可
            for (Map.Entry<String, Object> parameter : parametersMap.entrySet()) {
                if (parameter.getKey() != null && parameter.getValue() != null) {
                    System.out.println("key--->" + parameter.getKey() + ",value--->" + parameter.getValue());
                    httpUrlBuilder.addQueryParameter(parameter.getKey(), parameter.getValue().toString());
                }
            }
            //重新创建 request
            return chain.proceed(request.newBuilder()
                    .method(request.method(), request.body())
                    .url(httpUrlBuilder.build())
                    .build());
        } else if (request.method().equalsIgnoreCase("POST")) {
            RequestBody requestBody = request.body();
            if (requestBody == null) {
                return chain.proceed(request);
            }
            MediaType mediaType = requestBody.contentType();
            if (requestBody instanceof FormBody) {
                //参数以 Form 表单形式的 POST 请求
                FormBody.Builder formBodyBuilder = new FormBody.Builder();
                //先添加原请求的参数
                for (int i = 0; i < ((FormBody) requestBody).size(); i++) {
                    formBodyBuilder.add(((FormBody) requestBody).encodedName(i), ((FormBody) requestBody).encodedValue(i));
                }
                //添加公共参数
                for (Map.Entry<String, Object> parameter : parametersMap.entrySet()) {
                    if (parameter.getKey() != null && parameter.getValue() != null) {
                        formBodyBuilder.add(parameter.getKey(), parameter.getValue().toString());
                    }
                }
                //重新创建 request
                return chain.proceed(request.newBuilder()
                        .method(request.method(), request.body())
                        .post(formBodyBuilder.build())
                        .build());
            } else if (mediaType != null && mediaType.toString().contains("application/json;charset=utf-8")) {
                //参数以 Json 字符串的形式的 POST 请求
                //创建缓存
                Buffer buffer = new Buffer();
                //将请求体内容,写入缓存
                requestBody.writeTo(buffer);
                //读取参数字符串
                String json = buffer.readUtf8();
                Map<String, Object> map = new Gson().fromJson(json, Map.class);
                //添加公共参数
                for (Map.Entry<String, Object> parameter : parametersMap.entrySet()) {
                    if (parameter.getKey() != null && parameter.getValue() != null) {
                        map.put(parameter.getKey(), parameter.getValue());
                    }
                }
                //重新创建 request
                return chain.proceed(new Request.Builder()
                        .url(request.url())
                        .post(RequestBody.create(MediaType.parse("application/json;charset=utf-8"), new GsonBuilder()
                                .setLongSerializationPolicy(LongSerializationPolicy.STRING) //转换 Long 类型参数时先转为 String,否则数字太长会自动转为科学计数法
                                .create()
                                .toJson(map)))
                        .addHeader("Accept-Language", "zh_CN")
                        .build());
            }
        }
        return chain.proceed(request);
    }

    public static class Builder {
        private Map<String, Object> parametersMap;

        public Builder() {
            parametersMap = new HashMap<>();
        }

        public Builder addHeaderParameter(String key, Object value) {
            parametersMap.put(key, value.toString());
            return this;
        }

        public Builder addHeaderParameterMap(Map<String, Object> map) {
            parametersMap.putAll(map);
            return this;
        }

        public HttpParameterInterceptor build() {
            return new HttpParameterInterceptor(this);
        }
    }
}