package com.qinshou.qinshoubox.listener;


import com.qinshou.okhttphelper.callback.Callback;
import com.qinshou.qinshoubox.im.listener.QSCallback;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date:2019/7/25 18:19
 * Description:调用某个方法失败后在主线程中的回调
 */
public class FailureRunnable<T> implements Runnable {
    private QSCallback<T> mQSCallback;
    private Exception mException;

    public FailureRunnable(QSCallback<T> qsCallback, Exception exception) {
        mQSCallback = qsCallback;
        mException = exception;
    }

    @Override
    public void run() {
        if (mQSCallback == null) {
            return;
        }
        mQSCallback.onFailure(mException);
    }
}