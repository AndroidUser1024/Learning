package com.qinshou.networkmodule.callback;

public class SuccessRunnable<T> implements Runnable {
    private Callback<T> mRequestCallback;
    private T mData;

    public SuccessRunnable(Callback<T> requestCallback, T data) {
        mRequestCallback = requestCallback;
        mData = data;
    }

    @Override
    public void run() {
        if (mRequestCallback == null) {
            return;
        }
        mRequestCallback.onSuccess(mData);
    }
}