package com.jeejio.networkmodule.callback;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/7/4 9:24
 * Description:请求回调接口
 */
public interface Callback<T> {

    void onSuccess(T data);

    void onFailure(Exception e);
}
