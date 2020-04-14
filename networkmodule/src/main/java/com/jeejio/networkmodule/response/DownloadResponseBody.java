package com.jeejio.networkmodule.response;


import com.jeejio.networkmodule.callback.IDownloadCallback;

import java.io.File;
import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;
import okio.ForwardingSource;
import okio.Okio;
import okio.Source;

public class DownloadResponseBody extends ResponseBody {
    private ResponseBody responseBody;
    private IDownloadCallback mDownloadCallback;
    // BufferedSource 是 okio 库中的输入流，这里就当作 inputStream 来使用。
    private BufferedSource bufferedSource;
    private File mFile;
    private long totalBytesRead = 0L;
    private long totalBytes = 0L;

    public DownloadResponseBody(ResponseBody responseBody, IDownloadCallback downloadCallback, File file, long start) {
        this.responseBody = responseBody;
        this.mDownloadCallback = downloadCallback;
        mDownloadCallback.onStart(responseBody.contentLength());
        mFile = file;
        totalBytesRead = start;
        totalBytes = responseBody.contentLength() + start;
    }

    @Override
    public MediaType contentType() {
        return responseBody.contentType();
    }

    @Override
    public long contentLength() {
        return responseBody.contentLength();
    }

    @Override
    public BufferedSource source() {
        if (bufferedSource == null) {
            bufferedSource = Okio.buffer(source(responseBody.source()));
        }
        return bufferedSource;
    }

    private Source source(Source source) {
        return new ForwardingSource(source) {

            @Override
            public long read(Buffer sink, long byteCount) throws IOException {
                long bytesRead = super.read(sink, byteCount);
                if (bytesRead == -1) {
                    return bytesRead;
                }
                totalBytesRead += bytesRead;
                int progress = (int) (totalBytesRead * 100 / totalBytes);
                System.out.println("progress--->" + progress);
                if (mDownloadCallback != null) {
                    mDownloadCallback.onProgress(progress);
                    if (totalBytesRead == responseBody.contentLength()) {
                        mDownloadCallback.onSuccess(mFile);
                    }
                }
                return bytesRead;
            }
        };
    }
}