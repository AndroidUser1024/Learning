package com.qinshou.mediamodule;

import android.content.Context;
import android.net.Uri;
import android.view.SurfaceHolder;

import java.io.IOException;

import tv.danmaku.ijk.media.player.IMediaPlayer;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2020/4/29 14:24
 * Description:类描述
 */
public class QsIjkPlayer extends BasePlayer {
    private final IjkMediaPlayer mIjkMediaPlayer;

    public QsIjkPlayer(Context context) {
        super(context);
        mContext = context;
        mIjkMediaPlayer = new IjkMediaPlayer();
        mIjkMediaPlayer.setOption(IjkMediaPlayer.OPT_CATEGORY_PLAYER, "opensles", 1);

        mIjkMediaPlayer.setOption(IjkMediaPlayer.OPT_CATEGORY_PLAYER, "overlay-format", IjkMediaPlayer.SDL_FCC_RV32);
        mIjkMediaPlayer.setOption(IjkMediaPlayer.OPT_CATEGORY_PLAYER, "framedrop", 1);
        mIjkMediaPlayer.setOption(IjkMediaPlayer.OPT_CATEGORY_PLAYER, "start-on-prepared", 0);

        mIjkMediaPlayer.setOption(IjkMediaPlayer.OPT_CATEGORY_PLAYER, "http-detect-range-support", 1);

        mIjkMediaPlayer.setOption(IjkMediaPlayer.OPT_CATEGORY_CODEC, "skip_loop_filter", 48);
        mIjkMediaPlayer.setOption(IjkMediaPlayer.OPT_CATEGORY_CODEC, "min-frames", 100);
        mIjkMediaPlayer.setOption(IjkMediaPlayer.OPT_CATEGORY_PLAYER, "enable-accurate-seek", 1);

        mIjkMediaPlayer.setVolume(1.0f, 1.0f);
        mIjkMediaPlayer.setOnPreparedListener(new tv.danmaku.ijk.media.player.IMediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(tv.danmaku.ijk.media.player.IMediaPlayer iMediaPlayer) {
                if (mOnPreparedListener != null) {
                    mOnPreparedListener.onPrepared();
                }
            }
        });
        mIjkMediaPlayer.setOnErrorListener(new tv.danmaku.ijk.media.player.IMediaPlayer.OnErrorListener() {
            @Override
            public boolean onError(tv.danmaku.ijk.media.player.IMediaPlayer iMediaPlayer, int i, int i1) {
                if (mOnErrorListener != null) {
                    mOnErrorListener.onError(new Exception("播放失败"));
                }
                return true;
            }
        });
        mIjkMediaPlayer.setOnCompletionListener(new IMediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(IMediaPlayer iMediaPlayer) {
                if (mOnCompleteListener != null) {
                    mOnCompleteListener.onComplete();
                }
            }
        });
    }

    @Override
    public void setDisplay(SurfaceHolder surfaceHolder) {
        mIjkMediaPlayer.setDisplay(surfaceHolder);
    }

    @Override
    public void setDataSource(Uri uri) {
        try {
            mIjkMediaPlayer.setDataSource(mContext, uri);
        } catch (IOException e) {
            return;
        }
    }

    @Override
    public void prepare() {
        mIjkMediaPlayer.prepareAsync();
    }

    @Override
    public void start() {
        mIjkMediaPlayer.start();
    }

    @Override
    public void pause() {
        mIjkMediaPlayer.pause();
    }

    @Override
    public void stop() {
        mIjkMediaPlayer.stop();
    }

    @Override
    public void release() {
        mIjkMediaPlayer.release();
    }

    @Override
    public void seekTo(long position) {
        mIjkMediaPlayer.seekTo(position);
    }

    @Override
    public boolean isPlaying() {
        return mIjkMediaPlayer.isPlaying();
    }

    @Override
    public long getCurrentPosition() {
        return mIjkMediaPlayer.getCurrentPosition();
    }

    @Override
    public long getDuration() {
        return mIjkMediaPlayer.getDuration();
    }
}
