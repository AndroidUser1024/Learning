package com.qinshou.qinshoubox.homepage.bean;

import com.google.gson.annotations.SerializedName;

/**
 * Description:GankIoApi 的数据统一格式实体类
 * Date:2018/4/9
 */
public class GankIoApiResult<T> {
    @SerializedName("error")
    private boolean error;
    @SerializedName("results")
    private T data;

    public GankIoApiResult() {
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "GankIoApiResult{" +
                "error=" + error +
                ", data=" + data +
                '}';
    }
}