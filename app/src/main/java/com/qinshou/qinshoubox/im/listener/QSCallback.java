package com.qinshou.qinshoubox.im.listener;

public interface QSCallback<T> {

    void onSuccess(T data);

    void onFailure(Exception e);
}