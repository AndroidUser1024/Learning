package com.qinshou.commonmodule.util;

import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.view.SurfaceHolder;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Create By:禽兽先生
 * Create On:2019-03-24 16:27
 * Description:MediaPlayer 工具类
 */
public enum MediaPlayerHelper {
    SINGLETON;

    private static final String TAG = "MediaPlayerHelper";
    private MediaPlayer mMediaPlayer;
    private ExecutorService mExecutorService;
    private ExecutorService mProgressRunnableExecutorService;
    private boolean calculateProgress = false;  //开始计算播放进度的标志位,用于开始计算播放进度的线程

    MediaPlayerHelper() {
        mExecutorService = Executors.newSingleThreadExecutor();
        mProgressRunnableExecutorService = Executors.newSingleThreadExecutor();
        mMediaPlayer = new MediaPlayer();
    }

    /**
     * description:播放,不需要监听播放器
     * author:QinHao
     * date:2019/4/4 19:09
     *
     * @param path 文件地址
     */
    public void playMusic(final String path) {
        this.playMusic(path, null);
    }

    /**
     * description:播放,需要监听播放器
     * author:QinHao
     * date:2019/4/4 19:09
     *
     * @param path 文件地址
     */
    public void playMusic(final String path, final IOnMediaPlayerListener onMediaPlayerListener) {
        mExecutorService.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    if (calculateProgress) {
                        //如果上一个计算播放进度的线程还在跑,则把标志位置为 false,停止上一个线程
                        calculateProgress = false;
                    }
                    stop();
                    if (TextUtils.isEmpty(path)) {
                        if (onMediaPlayerListener != null) {
                            onMediaPlayerListener.onError();
                        }
                        return;
                    }
                    mMediaPlayer = new MediaPlayer();
                    //设置播放源
                    mMediaPlayer.setDataSource(path);
                    //设置音量
                    mMediaPlayer.setVolume(1f, 1f);
                    //异步准备播放器
                    mMediaPlayer.prepareAsync();
                    mMediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                        @Override
                        public void onPrepared(MediaPlayer mediaPlayer) {
                            //开始播放
                            start();
                            if (onMediaPlayerListener != null) {
                                onMediaPlayerListener.onStart(mediaPlayer.getDuration());
                            }
                            mProgressRunnableExecutorService.submit(new ProgressRunnable(onMediaPlayerListener));
                        }
                    });
                    mMediaPlayer.setOnErrorListener(new MediaPlayer.OnErrorListener() {
                        @Override
                        public boolean onError(MediaPlayer mp, int what, int extra) {
                            //播放失败,停止播放,释放播放器
                            Log.i(TAG, "onError:what--->" + what + ",extra--->" + extra);
                            stop();
                            if (onMediaPlayerListener != null) {
                                onMediaPlayerListener.onError();
                            }
                            return true;
                        }
                    });
                    mMediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            //播放完成,停止播放,释放播放器
                            stop();
                            if (onMediaPlayerListener != null) {
                                onMediaPlayerListener.onComplete();
                            }
                        }
                    });
                    mMediaPlayer.setOnBufferingUpdateListener(new MediaPlayer.OnBufferingUpdateListener() {
                        @Override
                        public void onBufferingUpdate(MediaPlayer mp, int percent) {

                        }
                    });
                } catch (IOException e) {
                    e.printStackTrace();
                    //停止播放, 释放播放器
                    stop();
                } catch (IllegalStateException e) {
                    e.printStackTrace();
                    //停止播放, 释放播放器
                    stop();
                }
            }
        });
    }

    /**
     * description:播放,不需要监听播放器
     * author:QinHao
     * date:2019/4/4 19:09
     *
     * @param assetFileDescriptor 文件地址
     */
    public void playMusic(final AssetFileDescriptor assetFileDescriptor) {
        this.playMusic(assetFileDescriptor, null);
    }

    /**
     * description:播放,需要监听播放器
     * author:QinHao
     * date:2019/4/4 19:09
     *
     * @param assetFileDescriptor 文件地址
     */
    public void playMusic(final AssetFileDescriptor assetFileDescriptor, final IOnMediaPlayerListener onMediaPlayerListener) {
        mExecutorService.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    if (calculateProgress) {
                        //如果上一个计算播放进度的线程还在跑,则把标志位置为 false,停止上一个线程
                        calculateProgress = false;
                    }
                    stop();
                    if (assetFileDescriptor == null) {
                        if (onMediaPlayerListener != null) {
                            onMediaPlayerListener.onError();
                        }
                        return;
                    }
                    mMediaPlayer = new MediaPlayer();
                    //设置播放源
                    mMediaPlayer.setDataSource(assetFileDescriptor.getFileDescriptor(), assetFileDescriptor.getStartOffset(), assetFileDescriptor.getLength());
                    //设置音量
                    mMediaPlayer.setVolume(1f, 1f);
                    //异步准备播放器
                    mMediaPlayer.prepareAsync();
                    mMediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                        @Override
                        public void onPrepared(MediaPlayer mediaPlayer) {
                            //开始播放
                            start();
                            if (onMediaPlayerListener != null) {
                                onMediaPlayerListener.onStart(mediaPlayer.getDuration());
                            }
                            mProgressRunnableExecutorService.submit(new ProgressRunnable(onMediaPlayerListener));
                        }
                    });
                    mMediaPlayer.setOnErrorListener(new MediaPlayer.OnErrorListener() {
                        @Override
                        public boolean onError(MediaPlayer mp, int what, int extra) {
                            //播放失败,停止播放,释放播放器
                            Log.i(TAG, "onError:what--->" + what + ",extra--->" + extra);
                            stop();
                            if (onMediaPlayerListener != null) {
                                onMediaPlayerListener.onError();
                            }
                            return true;
                        }
                    });
                    mMediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            //播放完成,停止播放,释放播放器
                            stop();
                            if (onMediaPlayerListener != null) {
                                onMediaPlayerListener.onComplete();
                            }
                        }
                    });
                } catch (IOException e) {
                    e.printStackTrace();
                    //停止播放, 释放播放器
                    stop();
                } catch (IllegalStateException e) {
                    e.printStackTrace();
                    //停止播放, 释放播放器
                    stop();
                }
            }
        });
    }

    /**
     * description:播放,需要监听播放器
     * author:QinHao
     * date:2019/4/4 19:09
     *
     * @param surfaceHolder 播放视频的 surfaceView 的 holder
     * @param path          文件地址
     */
    public void playVideo(final SurfaceHolder surfaceHolder, final String path, final IOnMediaPlayerListener onMediaPlayerListener) {
        mExecutorService.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    if (calculateProgress) {
                        //如果上一个计算播放进度的线程还在跑,则把标志位置为 false,停止上一个线程
                        calculateProgress = false;
                    }
                    stop();
                    if (TextUtils.isEmpty(path)) {
                        if (onMediaPlayerListener != null) {
                            onMediaPlayerListener.onError();
                        }
                        return;
                    }
                    mMediaPlayer = new MediaPlayer();
                    mMediaPlayer.setDisplay(surfaceHolder);
                    //设置播放源
                    mMediaPlayer.setDataSource(path);
                    //设置音量
                    mMediaPlayer.setVolume(1f, 1f);
                    //异步准备播放器
                    mMediaPlayer.prepareAsync();
                    mMediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                        @Override
                        public void onPrepared(MediaPlayer mediaPlayer) {
                            //开始播放
                            start();
                            if (onMediaPlayerListener != null) {
                                onMediaPlayerListener.onStart(mediaPlayer.getDuration());
                            }
                            mProgressRunnableExecutorService.submit(new ProgressRunnable(onMediaPlayerListener));
                        }
                    });
                    mMediaPlayer.setOnErrorListener(new MediaPlayer.OnErrorListener() {
                        @Override
                        public boolean onError(MediaPlayer mp, int what, int extra) {
                            //播放失败,停止播放,释放播放器
                            Log.i(TAG, "onError:what--->" + what + ",extra--->" + extra);
                            stop();
                            if (onMediaPlayerListener != null) {
                                onMediaPlayerListener.onError();
                            }
                            return true;
                        }
                    });
                    mMediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            //播放完成,停止播放,释放播放器
                            stop();
                            if (onMediaPlayerListener != null) {
                                onMediaPlayerListener.onComplete();
                            }
                        }
                    });
                    mMediaPlayer.setOnBufferingUpdateListener(new MediaPlayer.OnBufferingUpdateListener() {
                        @Override
                        public void onBufferingUpdate(MediaPlayer mp, int percent) {
                            if (onMediaPlayerListener != null) {
                                onMediaPlayerListener.onBufferingUpdate(percent);
                            }
                        }
                    });
                } catch (IOException e) {
                    e.printStackTrace();
                    //停止播放, 释放播放器
                    stop();
                } catch (IllegalStateException e) {
                    e.printStackTrace();
                    //停止播放, 释放播放器
                    stop();
                }
            }
        });
    }

    /**
     * description:停止播放
     * author:QinHao
     * date:2019/4/4 19:09
     */
    public void stop() {
        if (mMediaPlayer != null) {
            //停止播放
            mMediaPlayer.stop();
            //释放播放器
            mMediaPlayer.release();
            // 置空对象
            mMediaPlayer = null;
        }
    }

    /**
     * description:暂停播放
     * author:QinHao
     * date:2019/4/4 19:09
     */
    public void pause() {
        if (mMediaPlayer == null) {
            return;
        }
        if (!mMediaPlayer.isPlaying()) {
            return;
        }
        mMediaPlayer.pause();
    }

    /**
     * description:开始播放,区别于直接播放,这是暂停后重新继续播放
     * author:QinHao
     * date:2019/4/4 19:09
     */
    public void start() {
        if (mMediaPlayer == null) {
            return;
        }
        try {
            mMediaPlayer.start();
        } catch (IllegalStateException e) {
            e.printStackTrace();
            //停止播放, 释放播放器
            stop();
        }
    }

    /**
     * description:是否正在播放
     * author:QinHao
     * date:2019/4/4 19:09
     */
    public boolean isPlaying() {
        return mMediaPlayer != null && mMediaPlayer.isPlaying();
    }

    /**
     * description:设置跳转到指定位置
     * author:QinHao
     * date:2019/4/4 19:14
     */
    public void seekTo(int progress) {
        if (mMediaPlayer == null || !mMediaPlayer.isPlaying()) {
            return;
        }
        mMediaPlayer.seekTo(progress);
    }

    /**
     * description:计算播放进度的线程
     * author:QinHao
     * date:2019/4/4 19:09
     */
    private class ProgressRunnable implements Runnable {

        private IOnMediaPlayerListener mOnMediaPlayerListener;

        public ProgressRunnable(IOnMediaPlayerListener onMediaPlayerListener) {
            mOnMediaPlayerListener = onMediaPlayerListener;
        }

        @Override
        public void run() {
            calculateProgress = true;
            while (calculateProgress) {
                if (mOnMediaPlayerListener == null || mMediaPlayer == null) {
                    return;
                }
                if (isPlaying()) {
                    final int progress = mMediaPlayer.getCurrentPosition();
                    final int totalProgress = mMediaPlayer.getDuration();
                    final int currentTimeMinute = mMediaPlayer.getCurrentPosition() / 60 / 1000;
                    final int currentTimeSecond = (mMediaPlayer.getCurrentPosition() - currentTimeMinute * 60 * 1000) / 1000;
                    final int totalTimeMinute = mMediaPlayer.getDuration() / 60 / 1000;
                    final int totalTimeSecond = (mMediaPlayer.getDuration() - totalTimeMinute * 60 * 1000) / 1000;

                    mOnMediaPlayerListener.onProgress(progress, totalProgress, currentTimeMinute, currentTimeSecond, totalTimeMinute, totalTimeSecond);
                }
            }
        }
    }

    /**
     * description:播放器状态监听器
     * author:QinHao
     * date:2019/4/4 19:09
     */
    public interface IOnMediaPlayerListener {
        void onStart(int totalProgress);

        void onError();

        void onComplete();

        void onProgress(int progress, int totalProgress, int currentTimeMinute, int currentTimeSecond, int totalTimeMinute, int totalTimeSecond);

        void onBufferingUpdate(int percent);
    }

}
