package com.qinshou.commonmodule.util;

import android.content.Intent;
import android.net.Uri;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Description:Activity 隐式跳转的工具类
 * Created by 禽兽先生
 * Created on 2018/11/19
 */
public class SchemeUtil {
    public String getScheme(Intent intent) {
        if (intent == null) {
            return "";
        }
        Uri uri = intent.getData();
        if (uri == null) {
            return "";
        }
        return uri.getScheme();
    }

    public String getHost(Intent intent) {
        if (intent == null) {
            return "";
        }
        Uri uri = intent.getData();
        if (uri == null) {
            return "";
        }
        return uri.getHost();
    }

    public String getPath(Intent intent) {
        if (intent == null) {
            return "";
        }
        Uri uri = intent.getData();
        if (uri == null) {
            return "";
        }
        return uri.getPath();
    }

    public int getPort(Intent intent) {
        if (intent == null) {
            return -1;
        }
        Uri uri = intent.getData();
        if (uri == null) {
            return -1;
        }
        return uri.getPort();
    }

    public Map<String, String> getParameterMap(Intent intent) {
        Map<String, String> map = new HashMap<>();
        Uri uri = intent.getData();
        if (uri == null) {
            return map;
        }
        Set<String> queryParameterNames = uri.getQueryParameterNames();
        for (String key : queryParameterNames) {
            map.put(key, uri.getQueryParameter(key));
        }
        return map;
    }
}
