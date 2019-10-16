package com.qinshou.okhttphelper.callback;

public class FailureRunnable<T> implements Runnable {
        private Callback<T> mRequestCallback;
        private Exception mException;

        public FailureRunnable(Callback<T> requestCallback, Exception exception) {
            mRequestCallback = requestCallback;
            mException = exception;
        }

        @Override
        public void run() {
            mRequestCallback.onFailure(mException);
        }
    }