package com.qinshou.networkmodule.okhttp;

/**
 * Description:类描述
 * Author: QinHao
 * Date: 2019/3/22 13:30
 */
public class Parameter {
    private String key;
    private Object value;

    public Parameter(String key, Object value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
