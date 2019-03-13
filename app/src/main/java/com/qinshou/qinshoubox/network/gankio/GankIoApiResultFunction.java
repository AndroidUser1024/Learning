package com.qinshou.qinshoubox.network.gankio;

import com.qinshou.qinshoubox.homepage.bean.GankIoApiResult;

import io.reactivex.functions.Function;

/**
 * Description:GankioApi 返回数据的统一处理类,只关注真实数据,不需要 error
 * Created by 禽兽先生
 * Created on 2018/1/6
 */

public class GankIoApiResultFunction<T> implements Function<GankIoApiResult<T>, T> {

    @Override
    public T apply(GankIoApiResult<T> tGankIoAiResult) throws Exception {
        if (tGankIoAiResult.isError()) {
            throw new Exception("请求错误");
        }
        return tGankIoAiResult.getData();
    }
}