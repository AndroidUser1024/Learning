package com.qinshou.mediamodule;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import android.view.SurfaceHolder;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2020/4/29 14:20
 * Description:类描述
 */
public class MediaPlayerHelper {
    private IMediaPlayer mMediaPlayer;

    public MediaPlayerHelper(Context context) {
//        mMediaPlayer = new QsMediaPlayer(context);
        mMediaPlayer = new QsExoPlayer(context);
//        mMediaPlayer = new QsIjkPlayer(context);
    }

    public IMediaPlayer getMediaPlayer() {
        return mMediaPlayer;
    }

    public void setMediaPlayer(IMediaPlayer mediaPlayer) {
        mMediaPlayer = mediaPlayer;
    }

    public void setDisplay(SurfaceHolder surfaceHolder) {
        mMediaPlayer.setDisplay(surfaceHolder);
    }

    public void play(Uri uri) {

    }
    public void setDataSource(Uri uri) {
//        mMediaPlayer.setDataSource(uri);
    }

    public void prepare() {
//        mMediaPlayer.prepare();
    }

    public void start() {
//        mMediaPlayer.start();
    }

    public void pause() {
        mMediaPlayer.pause();
    }

    public void stop() {
        mMediaPlayer.stop();
    }

    public void release() {
        mMediaPlayer.release();
    }

    public void seekTo(long position) {
        mMediaPlayer.seekTo(position);
    }

    public boolean isPlaying() {
        return mMediaPlayer != null && mMediaPlayer.isPlaying();
    }

    public long getCurrentPosition() {
        return mMediaPlayer.getCurrentPosition();
    }

    public long getDuration() {
        return mMediaPlayer.getDuration();
    }

    public void setMediaPlayerListener(IMediaPlayerListener mediaPlayerListener) {
        mMediaPlayer.setMediaPlayerListener(mediaPlayerListener);
    }
}
