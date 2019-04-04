package com.qinshou.qinshoubox.playandroid.bean;

import com.google.gson.annotations.SerializedName;

/**
 * Description:玩 Android 接口的统一结果实体类
 * Author: QinHao
 * Date: 2019/3/27 9:27
 */
public class PlayAndroidResultBean<T> {
    @SerializedName("errorCode")
    private int errorCode;
    @SerializedName("errorMsg")
    private String errorMsg;
    @SerializedName("data")
    private T data;

    public PlayAndroidResultBean() {
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
        return "PlayAndroidResultBean{" +
                "errorCode=" + errorCode +
                ", errorMsg='" + errorMsg + '\'' +
                ", data=" + data +
                '}';
    }
}
