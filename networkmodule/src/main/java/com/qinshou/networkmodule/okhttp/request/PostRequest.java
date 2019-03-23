package com.qinshou.networkmodule.okhttp.request;

import com.google.gson.Gson;
import com.qinshou.networkmodule.okhttp.Parameter;

import java.util.Map;

import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;

/**
 * Description:Post 请求
 * Author: QinHao
 * Date: 2019/3/15 9:21
 */
public class PostRequest extends ARequest {

    @Override
    public Request createRequest(String url, Parameter... parameters) {
        Map<String, String> parameterMap = getParameterMap(parameters);
        FormBody.Builder builder = new FormBody.Builder();
        for (String key : parameterMap.keySet()) {
            String value = parameterMap.get(key);
            if (value != null) {
                builder.add(key, value);
            }
        }
        return new Request.Builder()
                .url(url)
                .post(builder.build())
                .build();
    }

/**
 * description:参数以 Json 格式传递的 Post 请求
 * author:QinHao
 * date:2019/3/23 9:32
 */
    public Request createJsonRequest(String url, Parameter... parameters) {
        Map<String, String> parameterMap = getParameterMap(parameters);
        return new Request.Builder()
                .url(url)
                .post(RequestBody.create(MediaType.parse("application/json;charset=utf-8"), new Gson().toJson(parameterMap)))
                .addHeader("Accept-Language", "zh_CN")
                .build();
    }
}
