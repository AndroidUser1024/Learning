package com.qinshou.mediamodule;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2020/4/30 15:36
 * Description:类描述
 */
public interface IMediaPlayerListener {
    void onPrepared();

    void onStart();

    void onPause();

    void onStop();

    void onComplete();

    void onError(Exception e);
}
