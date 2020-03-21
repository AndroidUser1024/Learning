package com.qinshou.qinshoubox.listener;


import com.qinshou.qinshoubox.im.listener.QSCallback;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date:2019/7/25 18:19
 * Description:调用某个方法成功后在主线程中的回调
 */
public class SuccessRunnable<T> implements Runnable {
    private QSCallback<T> mQSCallback;
    private T mData;

    public SuccessRunnable(QSCallback<T> qsCallback, T data) {
        mQSCallback = qsCallback;
        mData = data;
    }

    @Override
    public void run() {
        if (mQSCallback == null) {
            return;
        }
        mQSCallback.onSuccess(mData);
    }
}
