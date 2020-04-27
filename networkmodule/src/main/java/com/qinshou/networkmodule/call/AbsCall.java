package com.qinshou.networkmodule.call;


import android.os.Handler;
import android.os.Looper;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.internal.bind.TypeAdapters;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.qinshou.networkmodule.callback.Callback;

import java.io.IOException;

import okhttp3.Call;

/**
 * Author: MrQinshou
 * Email:cqflqinhao@126.com
 * Date: 2020/3/3 17:37
 * Description:请求的抽象类
 */
public abstract class AbsCall<T> {
    private Call mCall;
    Handler mHandler = new Handler(Looper.getMainLooper());

    public AbsCall(Call call) {
        mCall = call;
    }

    protected Gson getGson() {
        return new GsonBuilder()
                .registerTypeAdapterFactory(TypeAdapters.newFactory(int.class, Integer.class, new TypeAdapter<Number>() {
                    @Override
                    public void write(JsonWriter out, Number value) throws IOException {
                        out.value(value);
                    }

                    @Override
                    public Number read(JsonReader in) throws IOException {
                        if (in.peek() == JsonToken.NULL) {
                            in.nextNull();
                            return null;
                        }
                        try {
                            return in.nextInt();
                        } catch (NumberFormatException e) {
                            in.skipValue();
                            return 0;
                        }
                    }
                }))
                .registerTypeAdapterFactory(TypeAdapters.newFactory(long.class, Long.class, new TypeAdapter<Number>() {
                    @Override
                    public void write(JsonWriter out, Number value) throws IOException {
                        out.value(value);
                    }

                    @Override
                    public Number read(JsonReader in) throws IOException {
                        if (in.peek() == JsonToken.NULL) {
                            in.nextNull();
                            return null;
                        }
                        try {
                            return in.nextLong();
                        } catch (NumberFormatException e) {
                            in.skipValue();
                            return 0L;
                        }
                    }
                }))
                .registerTypeAdapterFactory(TypeAdapters.newFactory(float.class, Float.class, new TypeAdapter<Number>() {
                    @Override
                    public void write(JsonWriter out, Number value) throws IOException {
                      out.value(value);
                    }

                    @Override
                    public Number read(JsonReader in) throws IOException {
                        if (in.peek() == JsonToken.NULL) {
                            in.nextNull();
                            return null;
                        }
                        try {
                            return in.nextDouble();
                        } catch (NumberFormatException e) {
                            in.skipValue();
                            return 0F;
                        }
                    }
                }))
                .registerTypeAdapterFactory(TypeAdapters.newFactory(double.class, Double.class, new TypeAdapter<Number>() {
                    @Override
                    public void write(JsonWriter out, Number value) throws IOException {
                      out.value(value);
                    }

                    @Override
                    public Number read(JsonReader in) throws IOException {
                        if (in.peek() == JsonToken.NULL) {
                            in.nextNull();
                            return null;
                        }
                        try {
                            return in.nextDouble();
                        } catch (NumberFormatException e) {
                            in.skipValue();
                            return 0D;
                        }
                    }
                }))
                .create();
    }

    /**
     * Author: MrQinshou
     * Email:cqflqinhao@126.com
     * Date:2020-03-03 20:39
     * Description:发起异步请求
     */
    public abstract void enqueue(Callback<T> callback);

    /**
     * Author: MrQinshou
     * Email:cqflqinhao@126.com
     * Date:2020-03-03 20:39
     * Description:发起同步请求
     */
    public abstract T execute() throws Exception;

    /**
     * Author: MrQinshou
     * Email:cqflqinhao@126.com
     * Date:2020-03-03 20:39
     * Description:转换请求，可以对结果做一些中间的统一处理
     *
     * @param responseTransformer 转换者
     */
    public abstract <O> TransformCallImpl<T, O> transform(ResponseTransformer<T, O> responseTransformer);

    public Call getCall() {
        return mCall;
    }

    /**
     * Author: MrQinshou
     * Email:cqflqinhao@126.com
     * Date:2020-03-03 20:40
     * Description:取消请求
     */
    public void cancel() {
        if (mCall == null) {
            return;
        }
        mCall.cancel();
    }
}
