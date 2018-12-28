package com.qinshou.networkmodule;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * Description:快速创建 Retrofit 对象的建造者类
 * Created by 禽兽先生
 * Created on 2018/4/4
 */


public class CustomRetrofitBuilder {
    private int connectTimeout;
    private int readTimeout;
    private int writeTimeout;
    private List<Interceptor> mInterceptorList;

    public CustomRetrofitBuilder() {
        connectTimeout = 3000;
        readTimeout = 3000;
        writeTimeout = 3000;
        mInterceptorList = new ArrayList<>();
    }

    public CustomRetrofitBuilder setConnectTimeout(int connectTimeout) {
        this.connectTimeout = connectTimeout;
        return this;
    }

    public CustomRetrofitBuilder setReadTimeout(int readTimeout) {
        this.readTimeout = readTimeout;
        return this;
    }

    public CustomRetrofitBuilder setWriteTimeout(int writeTimeout) {
        this.writeTimeout = writeTimeout;
        return this;
    }

    public CustomRetrofitBuilder addInterceptor(Interceptor interceptor) {
        mInterceptorList.add(interceptor);
        return this;
    }

    public Retrofit build(String baseUrl) {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(connectTimeout, TimeUnit.MILLISECONDS);
        builder.readTimeout(readTimeout, TimeUnit.MILLISECONDS);
        builder.writeTimeout(writeTimeout, TimeUnit.MILLISECONDS);
        for (Interceptor interceptor : mInterceptorList) {
            builder.addInterceptor(interceptor);
        }
        OkHttpClient okHttpClient = builder.build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                //增加返回值为 String 的支持
                .addConverterFactory(ScalarsConverterFactory.create())
                //增加返回值为 Gson 的支持(以实体类返回)
                .addConverterFactory(GsonConverterFactory.create())
                //增加对 RxJava2 的支持
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                //使用自己定制的 OkHttpClient,可以查看打印
                .client(okHttpClient)
                .build();
        return retrofit;
    }
}
