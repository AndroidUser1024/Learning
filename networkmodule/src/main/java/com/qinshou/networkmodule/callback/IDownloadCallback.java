package com.qinshou.networkmodule.callback;

import java.io.File;

public interface IDownloadCallback {
    void onStart(long length);

    void onProgress(int progress);

    void onSuccess(File file);

    void onFailure(Exception e);
}