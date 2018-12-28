package com.qinshou.networkmodule.listener;

public interface OnDownloadListener {
    void onStart(long length);

    void onProgress(int progress);

    void onSuccess();

    void onError(String error);
}