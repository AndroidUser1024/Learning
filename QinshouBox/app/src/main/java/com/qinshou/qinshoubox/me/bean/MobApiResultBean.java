package com.qinshou.qinshoubox.me.bean;

import com.google.gson.annotations.SerializedName;

/**
 * Description:MobApi 的数据统一格式
 * Created by 禽兽先生
 * Created on 2018/4/4
 */

public class MobApiResultBean<T> {
    @SerializedName("msg")
    private String msg;
    @SerializedName("retCode")
    private int retCode;
    @SerializedName("result")
    private T result;

    public MobApiResultBean() {
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getRetCode() {
        return retCode;
    }

    public void setRetCode(int retCode) {
        this.retCode = retCode;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "MobApiResultBean{" +
                "msg='" + msg + '\'' +
                ", retCode=" + retCode +
                ", result=" + result +
                '}';
    }
}
