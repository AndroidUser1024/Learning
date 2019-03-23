package com.qinshou.qinshoubox.me.bean;

import com.google.gson.annotations.SerializedName;

/**
 * Description:易源 Api 返回的统一格式的结果
 * Author: QinHao
 * Date: 2019/3/23 9:43
 */
public class YiYuanApiResultBean<T> {
    @SerializedName("showapi_res_code")
    private int showapiResCode; //易源 API 调用结果码
    @SerializedName("showapi_res_error")
    private String showapiResError; //错误信息
    @SerializedName("showapi_res_body")
    private T t;    //真实数据

    public YiYuanApiResultBean() {
    }

    public int getShowapiResCode() {
        return showapiResCode;
    }

    public void setShowapiResCode(int showapiResCode) {
        this.showapiResCode = showapiResCode;
    }

    public String getShowapiResError() {
        return showapiResError;
    }

    public void setShowapiResError(String showapiResError) {
        this.showapiResError = showapiResError;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    @Override
    public String toString() {
        return "YiYuanApiResultBean{" +
                "showapiResCode=" + showapiResCode +
                ", showapiResError='" + showapiResError + '\'' +
                ", t=" + t +
                '}';
    }
}
