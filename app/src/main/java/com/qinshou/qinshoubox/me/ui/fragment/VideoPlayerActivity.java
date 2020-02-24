package com.qinshou.qinshoubox.me.ui.fragment;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.graphics.Color;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.RelativeLayout;

import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.ConcatenatingMediaSource;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.ProgressiveMediaSource;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.util.Util;
import com.qinshou.commonmodule.util.ShowLogUtil;
import com.qinshou.commonmodule.util.StatusBarUtil;
import com.qinshou.commonmodule.util.SystemUtil;
import com.qinshou.qinshoubox.R;
import com.qinshou.qinshoubox.base.QSActivity;
import com.qinshou.qinshoubox.homepage.bean.EventBean;
import com.qinshou.qinshoubox.me.contract.IVideoPlayerContract;
import com.qinshou.qinshoubox.me.presenter.VideoPlayerPresenter;

import java.io.File;


/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 20-2-3 上午9:38
 * Description:视频播放界面
 */
public class VideoPlayerActivity extends QSActivity<VideoPlayerPresenter> implements IVideoPlayerContract.IView {

    private ImageButton mIbPlayAndPause;
    private ImageButton mIbFullscreen;
    private RelativeLayout mRelativeLayout;
    private PlayerView mPlayerView;
    private ExoPlayer mExoPlayer;
    private Player.EventListener mEventListener = new Player.EventListener() {
        @Override
        public void onTimelineChanged(Timeline timeline, int reason) {

        }

        @Override
        public void onTracksChanged(TrackGroupArray trackGroups, TrackSelectionArray trackSelections) {

        }

        @Override
        public void onLoadingChanged(boolean isLoading) {

        }

        @Override
        public void onPlayerStateChanged(boolean playWhenReady, int playbackState) {
            ShowLogUtil.logi("onPlayerStateChanged: " + "playWhenReady--->" + playWhenReady + ",playbackState--->" + playbackState);
        }

        @Override
        public void onPlaybackSuppressionReasonChanged(int playbackSuppressionReason) {

        }

        @Override
        public void onIsPlayingChanged(boolean isPlaying) {
            ShowLogUtil.logi("onIsPlayingChanged: " + "isPlaying--->" + isPlaying);
            if (isPlaying) {
                mIbPlayAndPause.setImageResource(R.drawable.music_play_ib_play_or_pause_src_pause);
            } else {
                mIbPlayAndPause.setImageResource(R.drawable.music_play_ib_play_or_pause_src_play);
            }
        }

        @Override
        public void onRepeatModeChanged(int repeatMode) {

        }

        @Override
        public void onShuffleModeEnabledChanged(boolean shuffleModeEnabled) {

        }

        @Override
        public void onPlayerError(ExoPlaybackException error) {
            ShowLogUtil.logi("onPlayerError: " + "error--->" + error);
        }

        @Override
        public void onPositionDiscontinuity(int reason) {

        }

        @Override
        public void onPlaybackParametersChanged(PlaybackParameters playbackParameters) {

        }

        @Override
        public void onSeekProcessed() {

        }
    };

    private BroadcastReceiver mScreenBroadcastReceiver = new BroadcastReceiver() {

        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (Intent.ACTION_SCREEN_ON.equals(action)) {
//                ShowLogUtil.logi("解锁");
//                new Handler().postDelayed(new Runnable() {
//                    @Override
//                    public void run() {
//                mExoPlayer.setPlayWhenReady(true);
//                    }
//                }, 500);
            } else if (Intent.ACTION_SCREEN_OFF.equals(action)) {
                ShowLogUtil.logi("锁屏");
//                mExoPlayer.setPlayWhenReady(false);
            }
        }
    };

    @Override
    protected void onResume() {
        super.onResume();
        mExoPlayer.setPlayWhenReady(true);

    }

    @Override
    protected void onPause() {
        super.onPause();
        mExoPlayer.setPlayWhenReady(false);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(mScreenBroadcastReceiver);
        if (mExoPlayer != null) {
            mExoPlayer.removeListener(mEventListener);
            mExoPlayer.release();
        }
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_video_player;
    }

    @Override
    public void initView() {
        mRelativeLayout = findViewByID(R.id.relative_layout);
//        mVideoView = findViewByID(R.id.video_view);
        //    private VideoView mVideoView;
        mPlayerView = findViewByID(R.id.player_view);
        mIbPlayAndPause = findViewByID(R.id.ib_play_and_pause);
        mIbFullscreen = findViewByID(R.id.ib_fullscreen);
        mPlayerView.setUseController(false);
        mPlayerView.setOnTouchListener(new View.OnTouchListener() {
            private boolean mAdjustBrightness;
            private boolean mAdjustVolume;

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (getResources().getConfiguration().orientation != Configuration.ORIENTATION_LANDSCAPE) {
                    return false;
                }
                float screenWidth = getResources().getDisplayMetrics().widthPixels;
                float screenHeight = getResources().getDisplayMetrics().heightPixels;
                float x = event.getX();
                float y = event.getY();
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        if (x < screenWidth / 2) {
                            ShowLogUtil.logi("调节亮度");
                            mAdjustBrightness = true;
                        } else {
                            mAdjustVolume = true;
                            ShowLogUtil.logi("调节音量");
                        }
                        break;
                    case MotionEvent.ACTION_MOVE:
                        if (mAdjustBrightness) {
                            ShowLogUtil.logi("调节亮度");
                            float brightness = 1 - (y / screenHeight);
                            if (brightness > 1) {
                                brightness = 1;
                            } else if (brightness < 0) {
                                brightness = 0;
                            }
                            Window window = getWindow();
                            WindowManager.LayoutParams layoutParams = window.getAttributes();
                            // 调节当前屏幕的亮度,非系统屏幕亮度,取值在 0-1f 之间
                            layoutParams.screenBrightness = brightness;
                            window.setAttributes(layoutParams);
                        } else if (mAdjustVolume) {
                            ShowLogUtil.logi("调节音量");
                            AudioManager audioManager = (AudioManager) getSystemService(AUDIO_SERVICE);
                            // 获取音量最大值
                            int maxVolume = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
                            // 通过手指触摸位置与屏幕高度的比例，来计算需要设置的音量
                            int volume = (int) ((1 - y / screenHeight) * maxVolume);
                            audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, volume, 0);
                        }
                        break;
                    case MotionEvent.ACTION_UP:
                        mAdjustBrightness = false;
                        mAdjustVolume = false;
                        break;
                }
                return true;
            }
        });
    }


    @Override
    public void initData() {
//        mVideoView.setVideoPath(path);
//
//        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
//        mediaMetadataRetriever.setDataSource(path);
//        Bitmap frameAtTime = mediaMetadataRetriever.getFrameAtTime();
//        mVideoView.setBackground(new BitmapDrawable(getResources(), frameAtTime));
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(Intent.ACTION_SCREEN_ON);
        intentFilter.addAction(Intent.ACTION_SCREEN_OFF);
        registerReceiver(mScreenBroadcastReceiver, intentFilter);

//        String path = getContext().getCacheDir()
//                + File.separator
//                + "Video"
//                + File.separator
//                + "190319222227698228.mp4";
        String path = "http://vfx.mtime.cn/Video/2019/03/12/mp4/190312083533415853.mp4";
        String path2 = "http://vfx.mtime.cn/Video/2019/03/09/mp4/190309153658147087.mp4";
        mExoPlayer = new SimpleExoPlayer.Builder(getContext()).build();
        DataSource.Factory dataSourceFactory = new DefaultDataSourceFactory(getContext(),
                Util.getUserAgent(getContext(), "QinshouBox"));
        // This is the MediaSource representing the media to be played.
        // 设置播放源
        MediaSource mediaSource = new ProgressiveMediaSource.Factory(dataSourceFactory)
                .createMediaSource(Uri.parse(path));
        mExoPlayer.prepare(mediaSource);
//        MediaSource mediaSource2 = new ProgressiveMediaSource.Factory(dataSourceFactory)
//                .createMediaSource(Uri.parse(path2));
        // Prepare the player with the source.
        // ConcatenatingMediaSource 可以设置多个播放源
//        ConcatenatingMediaSource concatenatingMediaSource = new ConcatenatingMediaSource(mediaSource, mediaSource2);
//        mExoPlayer.prepare(concatenatingMediaSource);
        mExoPlayer.addListener(mEventListener);
        mExoPlayer.setRepeatMode(Player.REPEAT_MODE_ALL);
        mPlayerView.setPlayer(mExoPlayer);
    }

    @Override
    public void setListener() {
        super.setListener();
        mIbPlayAndPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mExoPlayer == null) {
                    return;
                }
                if (mExoPlayer.isPlaying()) {
                    mIbPlayAndPause.setImageResource(R.drawable.music_play_ib_play_or_pause_src_play);
                    mExoPlayer.setPlayWhenReady(false);
                } else {
                    mExoPlayer.setPlayWhenReady(true);
                    mIbPlayAndPause.setImageResource(R.drawable.music_play_ib_play_or_pause_src_pause);
                }
//                if (mVideoView.isPlaying()) {
//                    // 暂停播放
//                    mVideoView.pause();
//                    mIbPlayAndPause.setImageResource(R.drawable.music_play_ib_play_or_pause_src_play);
//                    mVideoView.setBackground(null);
//                } else {
//                    // 开始播放
//                    mVideoView.start();
//                    mIbPlayAndPause.setImageResource(R.drawable.music_play_ib_play_or_pause_src_pause);
//                    mVideoView.setBackground(null);
//                }
            }
        });
        mIbFullscreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
                    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
                } else {
                    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
                }
            }
        });
    }

    @Override
    public void handleEvent(EventBean<Object> eventBean) {

    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            ViewGroup.LayoutParams layoutParams = mRelativeLayout.getLayoutParams();
            layoutParams.width = SystemUtil.getScreenWidth(getContext());
            layoutParams.height = SystemUtil.getScreenHeight(getContext());
            mRelativeLayout.requestLayout();
            //使内容延伸到状态栏下
            StatusBarUtil.setStatusBarTranslucent(getActivity().getWindow(), true);
            //使状态栏透明
            StatusBarUtil.setStatusBarColor(getActivity().getWindow(), Color.TRANSPARENT, true);
        } else {
            ViewGroup.LayoutParams layoutParams = mRelativeLayout.getLayoutParams();
            layoutParams.width = SystemUtil.getScreenWidth(getContext());
            layoutParams.height = getResources().getDimensionPixelOffset(R.dimen.px500);
            mRelativeLayout.requestLayout();
            StatusBarUtil.setStatusBarTranslucent(getActivity().getWindow(), false);
            StatusBarUtil.setStatusBarColor(getActivity().getWindow(), initStatusBarColor(), false);
        }
    }

//    private void initPlayer() {
//        String path = getContext().getCacheDir()
//                + File.separator
//                + "Video"
//                + File.separator
//                + "190319222227698228.mp4";
//        mExoPlayer = new SimpleExoPlayer.Builder(getContext()).build();
//        DataSource.Factory dataSourceFactory = new DefaultDataSourceFactory(getContext(),
//                Util.getUserAgent(getContext(), "QinshouBox"));
//        // This is the MediaSource representing the media to be played.
//        MediaSource videoSource = new ProgressiveMediaSource.Factory(dataSourceFactory)
//                .createMediaSource(Uri.parse(path));
//        // Prepare the player with the source.
//        mExoPlayer.prepare(videoSource);
//        mExoPlayer.addListener(mEventListener);
//        mPlayerView.setPlayer(mExoPlayer);
//
//        mIbPlayAndPause.setImageResource(R.drawable.music_play_ib_play_or_pause_src_play);
//    }
//
//    private void releasePlayer() {
//        if (mExoPlayer != null) {
//            mExoPlayer.removeListener(mEventListener);
//            mExoPlayer.release();
//        }
//    }
}
