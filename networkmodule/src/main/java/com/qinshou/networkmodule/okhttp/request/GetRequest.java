package com.qinshou.networkmodule.okhttp.request;


import com.qinshou.networkmodule.okhttp.Parameter;

import java.util.Map;

import okhttp3.HttpUrl;
import okhttp3.Request;

/**
 * Description:Get 请求
 * Author: QinHao
 * Date: 2019/3/7 16:47
 */
public class GetRequest extends ARequest {

    @Override
    public Request createRequest(String url, Parameter... parameters) {
        Request request = null;
        HttpUrl httpUrl = HttpUrl.parse(url);
        if (httpUrl == null) {
            return null;
        }
        HttpUrl.Builder builder = httpUrl.newBuilder();

        Map<String, String> parameterMap = getParameterMap(parameters);
        for (String key : parameterMap.keySet()) {
            String value = parameterMap.get(key);
            if (value != null) {
                builder.addQueryParameter(key, value);
            }
        }
        request = new Request.Builder().url(builder.build()).get().build();
        return request;
    }
}
