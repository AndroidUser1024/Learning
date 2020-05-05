package com.qinshou.mediamodule;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.view.SurfaceHolder;

import java.io.IOException;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2020/4/29 14:24
 * Description:类描述
 */
public class QsMediaPlayer extends BasePlayer {
    private MediaPlayer mMediaPlayer;

    public QsMediaPlayer(Context context) {
        super(context);
        mMediaPlayer = new MediaPlayer();
        mMediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer iMediaPlayer) {
//                if (mMediaPlayerListener != null) {
//                    mMediaPlayerListener.onPrepared();
//                }
                mMediaPlayer.start();
                if (mMediaPlayerListener != null) {
                    mMediaPlayerListener.onStart();
                }
            }
        });
        mMediaPlayer.setOnErrorListener(new MediaPlayer.OnErrorListener() {
            @Override
            public boolean onError(MediaPlayer iMediaPlayer, int i, int i1) {
                if (mMediaPlayerListener != null) {
                    mMediaPlayerListener.onError(new Exception("播放失败"));
                }
                return true;
            }
        });
        mMediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                if (mMediaPlayerListener != null) {
                    mMediaPlayerListener.onComplete();
                }
                mMediaPlayer.reset();
            }
        });
    }

    @Override
    public void setDisplay(SurfaceHolder surfaceHolder) {
        mMediaPlayer.setDisplay(surfaceHolder);
    }

    @Override
    public void setDataSource(Uri uri) {
        try {
            mMediaPlayer.setDataSource(mContext, uri);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void prepare() {
        mMediaPlayer.prepareAsync();
    }

    @Override
    public void start() {
        mMediaPlayer.start();
        if (mMediaPlayerListener != null) {
            mMediaPlayerListener.onStart();
        }
    }

    @Override
    public void play(Uri uri) {
        mMediaPlayer.reset();
        try {
            mMediaPlayer.setDataSource(mContext, uri);
        } catch (IOException e) {
            return;
        }
        mMediaPlayer.prepareAsync();
    }

    @Override
    public void pause() {
        mMediaPlayer.pause();
        if (mMediaPlayerListener != null) {
            mMediaPlayerListener.onPause();
        }
    }

    @Override
    public void stop() {
        mMediaPlayer.stop();
        if (mMediaPlayerListener != null) {
            mMediaPlayerListener.onStop();
        }
    }

    @Override
    public void release() {
        mMediaPlayer.release();
    }

    @Override
    public void seekTo(long position) {
        mMediaPlayer.seekTo((int) position);
    }

    @Override
    public boolean isPlaying() {
        return mMediaPlayer.isPlaying();
    }

    @Override
    public long getCurrentPosition() {
        return mMediaPlayer.getCurrentPosition();
    }

    @Override
    public long getDuration() {
        return mMediaPlayer.getDuration();
    }
}
