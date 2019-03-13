package com.qinshou.qinshoubox.network.wanandroid;

import com.qinshou.qinshoubox.homepage.bean.WanAndroidApiResult;

import io.reactivex.functions.Function;

/**
 * Description:WanAndroidApi 返回数据的统一处理类,只关注真实数据,不需要 error
 * Created by 禽兽先生
 * Created on 2018/1/6
 */

public class WanAndroidApiResultFunction<T> implements Function<WanAndroidApiResult<T>, T> {

    @Override
    public T apply(WanAndroidApiResult<T> tWanAndroidApiResult) throws Exception {
        if (tWanAndroidApiResult.getErrorCode() < 0) {
            throw new Exception(tWanAndroidApiResult.getErrorMsg());
        }
        return tWanAndroidApiResult.getData();
    }
}