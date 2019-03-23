package com.qinshou.networkmodule.okhttp;

import android.support.annotation.NonNull;


import com.qinshou.networkmodule.okhttp.callback.ARequestCallback;
import com.qinshou.networkmodule.okhttp.request.GetRequest;
import com.qinshou.networkmodule.okhttp.request.PostRequest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Description:类描述
 * Author: QinHao
 * Date: 2019/3/15 9:03
 */
public class OkHttpUtil {

    private OkHttpClient mOkHttpClient;

    private OkHttpUtil() {
        recreateOkHttpClient(new Builder());
    }

    public static OkHttpUtil getInstance() {
        return SingleHolder.instance;
    }

    private static final class SingleHolder {
        private static final OkHttpUtil instance = new OkHttpUtil();
    }

    public void recreateOkHttpClient(Builder builder) {
        OkHttpClient.Builder okHttpClientBuilder = new OkHttpClient.Builder();
        okHttpClientBuilder.connectTimeout(builder.mConnectTimeOut, TimeUnit.MILLISECONDS);
        okHttpClientBuilder.readTimeout(builder.mReadTimeOut, TimeUnit.MILLISECONDS);
        okHttpClientBuilder.writeTimeout(builder.mWriteTimeOut, TimeUnit.MILLISECONDS);
        for (int i = 0; builder.mInterceptorList != null && i < builder.mInterceptorList.size(); i++) {
            okHttpClientBuilder.addInterceptor(builder.mInterceptorList.get(i));
        }
        mOkHttpClient = okHttpClientBuilder.build();
    }

    public enum Method {
        GET,
        POST,
        POST_JSON,
    }

    public <T> void request(Method method, String url, final ARequestCallback<T> requestCallback, Parameter... parameters) {
        Request request = null;
        if (method == Method.GET) {
            request = new GetRequest().createRequest(url, parameters);
        } else if (method == Method.POST) {
            request = new PostRequest().createRequest(url, parameters);
        } else if (method == Method.POST_JSON) {
            request = new PostRequest().createJsonRequest(url, parameters);
        }
        if (request == null) {
            return;
        }
        mOkHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                requestCallback.onFailure(e);
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) {
                try {
                    if (response.body() != null) {
                        String json = response.body().string();
                        T t = requestCallback.handleData(json);
                        requestCallback.onSuccess(t);
                    } else {
                        requestCallback.onFailure(new NullPointerException("response's body is null"));
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public static class Builder {
        private long CONNECT_TIME_OUT = 15 * 1000;
        private long READ_TIME_OUT = 15 * 1000;
        private long WRITE_TIME_OUT = 15 * 1000;

        private long mConnectTimeOut = CONNECT_TIME_OUT;
        private long mReadTimeOut = READ_TIME_OUT;
        private long mWriteTimeOut = WRITE_TIME_OUT;
        private List<Interceptor> mInterceptorList;

        public Builder setConnectTimeOut(long connectTimeOut) {
            mConnectTimeOut = connectTimeOut;
            return this;
        }

        public Builder setReadTimeOut(long readTimeOut) {
            mReadTimeOut = readTimeOut;
            return this;
        }

        public Builder setWriteTimeOut(long writeTimeOut) {
            mWriteTimeOut = writeTimeOut;
            return this;
        }

        public Builder addInterceptor(Interceptor interceptor) {
            if (mInterceptorList == null) {
                mInterceptorList = new ArrayList<>();
            }
            mInterceptorList.add(interceptor);
            return this;
        }
    }
}
