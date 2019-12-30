package com.qinshou.okhttphelper.callback;

public interface AbsDownloadCallback {
    void onStart(long length);

    void onProgress(int progress);

    void onSuccess();

    void onFailure(Exception e);
}