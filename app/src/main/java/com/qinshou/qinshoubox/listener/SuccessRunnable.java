package com.qinshou.qinshoubox.listener;


import com.qinshou.okhttphelper.callback.Callback;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date:2019/7/25 18:19
 * Description:调用某个方法成功后在主线程中的回调
 */
public class SuccessRunnable<T> implements Runnable {
    private Callback<T> mCallback;
    private T mData;

    public SuccessRunnable(Callback<T> callback, T data) {
        mCallback = callback;
        mData = data;
    }

    @Override
    public void run() {
        if (mCallback == null) {
            return;
        }
        mCallback.onSuccess(mData);
    }
}
