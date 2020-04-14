package com.jeejio.networkmodule.call;

import com.google.gson.Gson;
import com.jeejio.networkmodule.callback.Callback;
import com.jeejio.networkmodule.callback.FailureRunnable;
import com.jeejio.networkmodule.callback.SuccessRunnable;

import java.io.IOException;
import java.lang.reflect.Type;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/**
 * Author: MrQinshou
 * Email:cqflqinhao@126.com
 * Date: 2019/7/4 9:22
 * Description:请求实现类
 */
public class CallImpl<T> extends AbsCall<T> {
    private Type mType;

    public CallImpl(OkHttpClient okHttpClient, Request request, Type type) {
        super(okHttpClient.newCall(request));
        mType = type;
    }


    @Override
    public void enqueue(final Callback<T> callback) {
        getCall().enqueue(new okhttp3.Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                mHandler.post(new FailureRunnable<>(callback, e));
            }

            @Override
            public void onResponse(Call call, Response response) {
                if (response.body() == null) {
                    mHandler.post(new FailureRunnable<>(callback, new Exception(("response's body is null"))));
                    return;
                }
                if (mType == null) {
                    mHandler.post(new FailureRunnable<>(callback, new Exception(("return type is null"))));
                    return;
                }
                String json;
                try {
                    json = response.body().string();
                } catch (IOException e) {
                    mHandler.post(new FailureRunnable<>(callback, e));
                    return;
                }
                T t = new Gson().fromJson(json, mType);
                mHandler.post(new SuccessRunnable<>(callback, t));
            }
        });
    }

    @Override
    public T execute() throws IOException {
        Response response = getCall().execute();
        ResponseBody responseBody = response.body();
        if (responseBody == null) {
            return null;
        }
        return new Gson().fromJson(responseBody.string(), mType);
    }

    @Override
    public <O> TransformCallImpl<T, O> transform(ResponseTransformer<T, O> responseTransformer) {
        return new TransformCallImpl<>(getCall(), mType, responseTransformer);
    }
}
