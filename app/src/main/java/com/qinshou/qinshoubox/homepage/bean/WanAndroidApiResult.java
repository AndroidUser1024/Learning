package com.qinshou.qinshoubox.homepage.bean;

import com.google.gson.annotations.SerializedName;

/**
 * Description:玩 Android Api 的数据统一格式
 * Date:2018/4/9
 */
public class WanAndroidApiResult<T> {
    @SerializedName("errorCode")
    private int errorCode;
    @SerializedName("errorMsg")
    private String errorMsg;
    @SerializedName("data")
    private T data;

    public WanAndroidApiResult() {
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "WanAndroidApiResult{" +
                "errorCode=" + errorCode +
                ", errorMsg='" + errorMsg + '\'' +
                ", data=" + data +
                '}';
    }
}