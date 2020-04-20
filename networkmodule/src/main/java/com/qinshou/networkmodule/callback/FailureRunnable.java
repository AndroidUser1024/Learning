package com.qinshou.networkmodule.callback;

public class FailureRunnable<T> implements Runnable {
    private Callback<T> mRequestCallback;
    private Exception mException;

    public FailureRunnable(Callback<T> requestCallback, Exception exception) {
        mRequestCallback = requestCallback;
        mException = exception;
    }

    @Override
    public void run() {
        if (mRequestCallback == null) {
            return;
        }
        mRequestCallback.onFailure(mException);
    }
}