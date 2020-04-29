package com.qinshou.mediamodule;

import android.net.Uri;
import android.view.SurfaceHolder;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2020/4/29 14:24
 * Description:类描述
 */
public interface IMediaPlayer {
    void setDisplay(SurfaceHolder surfaceHolder);

    void setDataSource(Uri uri);

    void prepare();

    void start();

    void pause();

    void stop();

    void release();

    void seekTo(long position);

    boolean isPlaying();

    long getCurrentPosition();

    long getDuration();

    void setOnPreparedListener(IOnPreparedListener preparedListener);

    void setOnErrorListener(IOnErrorListener onErrorListener);

    void setOnCompleteListener(IOnCompleteListener onCompleteListener);
}
