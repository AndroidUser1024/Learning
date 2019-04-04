package com.qinshou.qinshoubox.playandroid.bean;

import com.google.gson.annotations.SerializedName;

/**
 * Description:GankIoApi 的数据统一格式实体类
 * Date:2018/4/9
 */
public class GankIoResultBean<T> {
    @SerializedName("error")
    private boolean error;
    @SerializedName("results")
    private T data;

    public GankIoResultBean() {
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
        return "GankIoResultBean{" +
                "error=" + error +
                ", data=" + data +
                '}';
    }
}