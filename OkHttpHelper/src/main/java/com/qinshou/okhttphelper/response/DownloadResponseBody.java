package com.qinshou.okhttphelper.response;


import com.qinshou.okhttphelper.callback.AbsDownloadCallback;

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
    private AbsDownloadCallback mDownloadCallback;
    // BufferedSource 是okio库中的输入流，这里就当作inputStream来使用。
    private BufferedSource bufferedSource;

    public DownloadResponseBody(ResponseBody responseBody, AbsDownloadCallback downloadCallback) {
        this.responseBody = responseBody;
        this.mDownloadCallback = downloadCallback;
        mDownloadCallback.onStart(responseBody.contentLength());
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
            long totalBytesRead = 0L;

            @Override
            public long read(Buffer sink, long byteCount) throws IOException {
                long bytesRead = super.read(sink, byteCount);
                if (bytesRead == -1) {
                    return bytesRead;
                }
                totalBytesRead += bytesRead;
                int progress = (int) (totalBytesRead * 100 / responseBody.contentLength());
                System.out.println("progress: " + progress);
                if (mDownloadCallback != null) {
                    mDownloadCallback.onProgress(progress);
                    if (totalBytesRead == responseBody.contentLength()) {
                        mDownloadCallback.onSuccess();
                    }
                }
                return bytesRead;
            }
        };
    }
}