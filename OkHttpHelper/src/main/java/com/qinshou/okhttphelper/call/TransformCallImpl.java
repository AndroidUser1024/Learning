package com.qinshou.okhttphelper.call;

import com.google.gson.Gson;
import com.qinshou.okhttphelper.callback.Callback;
import com.qinshou.okhttphelper.util.CallbackUtil;

import java.io.IOException;
import java.lang.reflect.Type;

import okhttp3.Call;
import okhttp3.Response;
import okhttp3.ResponseBody;

/**
 * Author: MrQinshou
 * Email:cqflqinhao@126.com
 * Date: 2019/7/4 17:07
 * Description:转换回调接口传值泛型后的请求调用者
 */
public class TransformCallImpl<I, O> extends AbsCall<O> {
    private Type mType;
    private ResponseTransformer<I, O> mResponseTransformer;

    public TransformCallImpl(Call call, Type type, ResponseTransformer<I, O> responseTransformer) {
        super(call);
        mType = type;
        mResponseTransformer = responseTransformer;
    }

    public void enqueue(final Callback<O> callback) {
        getCall().enqueue(new okhttp3.Callback() {
            @Override
            public void onFailure(okhttp3.Call call, IOException e) {
                CallbackUtil.failureCallback(callback, e);
            }

            @Override
            public void onResponse(okhttp3.Call call, Response response) throws IOException {
                if (response.body() == null) {
                    CallbackUtil.failureCallback(callback, new Exception(("response's body is null")));
                    return;
                }
                String json;
                try {
                    json = response.body().string();
                } catch (IOException e) {
                    CallbackUtil.failureCallback(callback, e);
                    return;
                }
                I i = new Gson().fromJson(json, mType);
                try {
                    O o = mResponseTransformer.transform(i);
                    CallbackUtil.successCallback(callback, o);
                } catch (Exception e) {
                    CallbackUtil.failureCallback(callback, e);
                }
            }
        });
    }

    @Override
    public O execute() throws Exception {
        Response response = getCall().execute();
        ResponseBody responseBody = response.body();
        if (responseBody == null) {
            return null;
        }
        I i = new Gson().fromJson(responseBody.string(), mType);
        return mResponseTransformer.transform(i);
    }

    @Override
    public <O1> TransformCallImpl<O, O1> transform(ResponseTransformer<O, O1> responseTransformer) {
        return new TransformCallImpl<>(getCall(), mType, responseTransformer);
    }
}
