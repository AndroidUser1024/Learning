package com.qinshou.okhttphelper.call;

import com.qinshou.okhttphelper.callback.Callback;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2020/3/3 17:37
 * Description:请求的抽象类
 */
public interface ICall<T> {
    void enqueue(Callback<T> callback);

    <O> TransformCallImpl<T, O> transform(ResponseTransformer<T, O> responseTransformer);

    void cancel();
}
