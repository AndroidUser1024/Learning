package com.qinshou.networkmodule.okhttp.request;


import com.qinshou.networkmodule.okhttp.Parameter;

import java.util.HashMap;
import java.util.Map;

import okhttp3.Request;

/**
 * Description:请求的基类
 * Author: QinHao
 * Date: 2019/3/7 18:21
 */
public abstract class ARequest {

    public abstract Request createRequest(String url, Parameter... parameters);

    public Map<String, String> getParameterMap(Parameter... parameters) {
        if (parameters == null || parameters.length == 0) {
            return new HashMap<>();
        }
        Map<String, String> parameterMap = new HashMap<>();
        for (Parameter parameter : parameters) {
            parameterMap.put(parameter.getKey(), String.valueOf(parameter.getValue()));
        }
        return parameterMap;
    }
}
