package com.qinshou.qinshoubox.listener;


import com.qinshou.okhttphelper.callback.Callback;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date:2019/7/25 18:19
 * Description:调用某个方法失败后在主线程中的回调
 */
public class FailureRunnable<T> implements Runnable {
    private Callback<T> mCallback;
    private Exception mException;

    public FailureRunnable(Callback<T> callback, Exception exception) {
        mCallback = callback;
        mException = exception;
    }

    @Override
    public void run() {
        if (mCallback == null) {
            return;
        }
        mCallback.onFailure(mException);
    }
}