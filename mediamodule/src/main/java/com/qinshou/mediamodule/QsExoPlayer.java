package com.qinshou.mediamodule;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import android.view.SurfaceHolder;

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
    private boolean mIsPlaying = false;

    public QsExoPlayer(Context context) {
        super(context);
        mSimpleExoPlayer = new SimpleExoPlayer.Builder(context).build();
        mSimpleExoPlayer.setVideoScalingMode(C.VIDEO_SCALING_MODE_SCALE_TO_FIT);
        mSimpleExoPlayer.addListener(new Player.EventListener() {
            @Override
            public void onIsPlayingChanged(boolean isPlaying) {
                mIsPlaying = isPlaying;
            }

            @Override
            public void onPlayerStateChanged(boolean playWhenReady, int playbackState) {
                // 播放与暂停播放会回调该方法
                // 播放器状态变更也会回调该方法
                Log.i("daolema", "onPlayerStateChanged" + " : "
                        + "playWhenReady--->" + playWhenReady
                        + ",playbackState--->" + playbackState
                        + ",mIsPlaying--->" + mIsPlaying);
                if (!playWhenReady && playbackState == Player.STATE_READY && !mIsPlaying) {
                    if (mOnPreparedListener != null) {
                        mOnPreparedListener.onPrepared();
                    }
                }
                if (playWhenReady && playbackState == Player.STATE_ENDED) {
                    if (mOnCompleteListener != null) {
                        mOnCompleteListener.onComplete();
                    }
                }
            }

            @Override
            public void onPlayerError(ExoPlaybackException error) {
                if (mOnErrorListener != null) {
                    mOnErrorListener.onError(error);
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
        // TODO getCurrentPosition()>getDuration() 时是不是就可以算是重新播
        Log.i("daolema", "getCurrentPosition()--->" + getCurrentPosition());
        Log.i("daolema", "getDuration()--->" + getDuration());
        mSimpleExoPlayer.setPlayWhenReady(true);
    }

    @Override
    public void pause() {
        mSimpleExoPlayer.setPlayWhenReady(false);
    }

    @Override
    public void stop() {
        mSimpleExoPlayer.setPlayWhenReady(false);
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
