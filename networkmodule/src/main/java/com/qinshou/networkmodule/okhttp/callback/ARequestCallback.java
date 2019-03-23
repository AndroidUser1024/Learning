package com.qinshou.networkmodule.okhttp.callback;

import com.google.gson.Gson;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Description:网络请求回调类
 * Author: QinHao
 * Date: 2019/3/18 11:29
 */
public abstract class ARequestCallback<T> {
    private Type getTClass() {
        Type type = getClass().getGenericSuperclass();
        if (type instanceof ParameterizedType) {
            Type[] typeArray = ((ParameterizedType) type).getActualTypeArguments();
            if (typeArray.length > 0) {
                return typeArray[0];
            }
        }
        return Object.class;
    }

    public T handleData(String json) {
        return new Gson().fromJson(json, getTClass());
    }

    public abstract void onSuccess(T data);

    public abstract void onFailure(Exception e);
}
