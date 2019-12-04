package com.qinshou.immodule.listener;

public interface QSCallback<T> {

    void onSuccess(T data);

    void onFailure(Exception e);
}