package com.qinshou.mediamodule;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import android.view.SurfaceHolder;

import androidx.appcompat.view.menu.ShowableListMenu;

import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.ProgressiveMediaSource;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.util.Util;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2020/4/29 14:24
 * Description:类描述
 */
public class QsExoPlayer extends BasePlayer {
    private SimpleExoPlayer mSimpleExoPlayer;
    private MediaSource mMediaSource;
    private boolean mPlaying = false;

    public QsExoPlayer(Context context) {
        super(context);
        mSimpleExoPlayer = new SimpleExoPlayer.Builder(context).build();
        mSimpleExoPlayer.addListener(new Player.EventListener() {
            @Override
            public void onIsPlayingChanged(boolean isPlaying) {
                mPlaying = isPlaying;
            }

            @Override
            public void onPlayerStateChanged(boolean playWhenReady, int playbackState) {
                // 播放与暂停播放会回调该方法
                // 播放器状态变更也会回调该方法
                Log.i("daolema", "onPlayerStateChanged" + " : "
                        + "playWhenReady--->" + playWhenReady
                        + ",playbackState--->" + playbackState
                        + ",mPlaying--->" + mPlaying);
                if (!playWhenReady && playbackState == Player.STATE_READY && !mPlaying) {
//                    if (mMediaPlayerListener != null) {
//                        mMediaPlayerListener.onPrepared();
//                    }
                    mSimpleExoPlayer.setPlayWhenReady(true);
                    if (mMediaPlayerListener != null) {
                        mMediaPlayerListener.onStart();
                    }
                }
                if (playWhenReady && playbackState == Player.STATE_ENDED) {
                    if (mMediaPlayerListener != null) {
                        mMediaPlayerListener.onComplete();
                    }
                }
            }

            @Override
            public void onPlayerError(ExoPlaybackException error) {
                if (mMediaPlayerListener != null) {
                    mMediaPlayerListener.onError(error);
                }
            }
        });
    }

    @Override
    public void setDisplay(SurfaceHolder surfaceHolder) {
        mSimpleExoPlayer.setVideoSurfaceHolder(surfaceHolder);
    }

    @Override
    public void setDataSource(Uri uri) {
        String userAgent = Util.getUserAgent(mContext, "QinshouBox");
        DataSource.Factory dataSourceFactory = new DefaultDataSourceFactory(mContext, userAgent);
        mMediaSource = new ProgressiveMediaSource.Factory(dataSourceFactory)
                .createMediaSource(uri);
    }

    @Override
    public void prepare() {
        mSimpleExoPlayer.prepare(mMediaSource);
    }

    @Override
    public void start() {
        if (mSimpleExoPlayer.getPlaybackState() == Player.STATE_ENDED) {
            mSimpleExoPlayer.seekToDefaultPosition();
        }
        mSimpleExoPlayer.setPlayWhenReady(true);
        if (mMediaPlayerListener != null) {
            mMediaPlayerListener.onStart();
        }
    }

    @Override
    public void play(Uri uri) {
        mSimpleExoPlayer.stop(true);
        String userAgent = Util.getUserAgent(mContext, "QinshouBox");
        DataSource.Factory dataSourceFactory = new DefaultDataSourceFactory(mContext, userAgent);
        mMediaSource = new ProgressiveMediaSource.Factory(dataSourceFactory)
                .createMediaSource(uri);
        mSimpleExoPlayer.prepare(mMediaSource);
    }

    @Override
    public void pause() {
        mSimpleExoPlayer.setPlayWhenReady(false);
        if (mMediaPlayerListener != null) {
            mMediaPlayerListener.onPause();
        }
    }

    @Override
    public void stop() {
        mSimpleExoPlayer.stop(true);
        if (mMediaPlayerListener != null) {
            mMediaPlayerListener.onStop();
        }
    }

    @Override
    public void release() {
        mSimpleExoPlayer.release();
    }

    @Override
    public void seekTo(long position) {
        mSimpleExoPlayer.seekTo(position);
    }

    @Override
    public boolean isPlaying() {
        return mSimpleExoPlayer.isPlaying();
    }

    @Override
    public long getCurrentPosition() {
        return mSimpleExoPlayer.getCurrentPosition();
    }

    @Override
    public long getDuration() {
        return mSimpleExoPlayer.getDuration();
    }
}
