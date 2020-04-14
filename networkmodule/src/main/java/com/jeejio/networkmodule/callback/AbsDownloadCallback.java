package com.jeejio.networkmodule.callback;

import java.io.File;

public interface AbsDownloadCallback {
    void onStart(long length);

    void onProgress(int progress);

    void onSuccess(File file);

    void onFailure(Exception e);
}