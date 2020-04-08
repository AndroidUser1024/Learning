package com.qinshou.qinshoubox.me.ui.fragment;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.source.hls.HlsMediaSource;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultHttpDataSourceFactory;
import com.google.android.exoplayer2.util.Util;
import com.qinshou.commonmodule.util.ShowLogUtil;
import com.qinshou.commonmodule.util.StatusBarUtil;
import com.qinshou.commonmodule.util.SystemUtil;
import com.qinshou.qinshoubox.R;
import com.qinshou.qinshoubox.base.QSActivity;
import com.qinshou.qinshoubox.homepage.bean.EventBean;
import com.qinshou.qinshoubox.me.contract.IVideoPlayerContract;
import com.qinshou.qinshoubox.me.presenter.VideoPlayerPresenter;


/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 20-2-3 上午9:38
 * Description:视频播放界面
 */
public class VideoPlayerActivity extends QSActivity<VideoPlayerPresenter> implements IVideoPlayerContract.IView {
    /**
     * 显示和隐藏控制器组件的动画时长
     */
    private final int ANIMATOR_DURATION = 1000;
    /**
     * 延时隐藏控制器组件的时长
     */
    private final int HIDE_CONTROL_DELAY = 1000;
    /**
     * 单击有效期
     */
    private final int CLICK_TIME = 500;
    private RelativeLayout mRelativeLayout;
    private PlayerView mPlayerView;
    private ExoPlayer mExoPlayer;
    private LinearLayout mLlControl;
    /**
     * 播放按钮
     */
    private ImageView mIvPlay;
    /**
     * 当前时间
     */
    private TextView mTvCurrentTime;
    /**
     * 进度
     */
    private SeekBar mSeekBar;
    /**
     * 总时间
     */
    private TextView mTvTotalTime;
    /**
     * 倍速
     */
    private TextView mTvSpeed;
    /**
     * 全屏按钮
     */
    private ImageView mIvFullscreen;
    private LinearLayout mLlBrightness;
    private ImageView mIvBrightness;
    private LinearLayout mLlBrightnessValue;
    private Handler mHandler = new Handler();
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
            if (playbackState == Player.STATE_READY) {
                mHandler.removeCallbacks(mUpdateProgressRunnable);
                mHandler.post(mUpdateProgressRunnable);
            }
        }

        @Override
        public void onPlaybackSuppressionReasonChanged(int playbackSuppressionReason) {

        }

        @Override
        public void onIsPlayingChanged(boolean isPlaying) {
            ShowLogUtil.logi("onIsPlayingChanged: " + "isPlaying--->" + isPlaying);
            if (isPlaying) {
                mIvPlay.setImageResource(R.drawable.video_player_iv_play_src_2);
                mHandler.removeCallbacks(mUpdateProgressRunnable);
                mHandler.post(mUpdateProgressRunnable);

                //  开始播放后 1s 后隐藏控制器
                mHandler.removeCallbacks(mHideControlRunnable);
                mHandler.postDelayed(mHideControlRunnable, HIDE_CONTROL_DELAY);
            } else {
                mIvPlay.setImageResource(R.drawable.video_player_iv_play_src);
                mHandler.removeCallbacks(mUpdateProgressRunnable);
                mHandler.post(mUpdateProgressRunnable);

                // 暂停立即显示控制器
                showControl();
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
    /**
     * 更新进度条的任务
     */
    private Runnable mUpdateProgressRunnable = new Runnable() {
        @Override
        public void run() {
            if (mExoPlayer == null) {
                return;
            }
            long currentPosition = mExoPlayer.getCurrentPosition();
            long duration = mExoPlayer.getDuration();
            mSeekBar.setMax((int) duration);
            mSeekBar.setProgress((int) currentPosition);

            final long currentTimeHour = currentPosition / 1000 / 60 / 60;
            final long currentTimeMinute = currentPosition / 1000 / 60;
            final long currentTimeSecond = currentPosition / 1000 % 60;
            final long totalTimeHour = duration / 1000 / 60 / 60;
            final long totalTimeMinute = duration / 1000 / 60;
            final long totalTimeSecond = duration / 1000 % 60;

            StringBuilder currentTime = new StringBuilder();
            if (currentTimeHour > 0) {
                if (currentTimeHour < 10) {
                    currentTime.append(0);
                }
                currentTime.append(currentTimeHour)
                        .append(":");
            }
            if (currentTimeMinute < 10) {
                currentTime.append(0);
            }
            currentTime.append(currentTimeMinute)
                    .append(":");
            if (currentTimeSecond < 10) {
                currentTime.append(0);
            }
            currentTime.append(currentTimeSecond);
            mTvCurrentTime.setText(currentTime);

            StringBuilder totalTime = new StringBuilder();
            if (totalTimeHour > 0) {
                if (currentTimeHour < 10) {
                    totalTime.append(0);
                }
                totalTime.append(totalTimeHour)
                        .append(":");
            }
            if (totalTimeMinute < 10) {
                totalTime.append(0);
            }
            totalTime.append(totalTimeMinute)
                    .append(":");
            if (totalTimeSecond < 10) {
                totalTime.append(0);
            }
            totalTime.append(totalTimeSecond);
            mTvTotalTime.setText(totalTime);

            if (mExoPlayer.isPlaying()) {
                float speed = mExoPlayer.getPlaybackParameters().speed;
                long delayMillis = (long) (1000 / speed);
                mHandler.postDelayed(mUpdateProgressRunnable, delayMillis);
            }
        }
    };
    /**
     * 隐藏控制器组件的任务
     */
    private Runnable mHideControlRunnable = new Runnable() {
        @Override
        public void run() {
            hideControl();
        }
    };
    private boolean mContinuePlay = false;

    @Override
    protected void onRestart() {
        super.onRestart();
        if (mContinuePlay && mExoPlayer != null) {
            mExoPlayer.setPlayWhenReady(true);
            mContinuePlay = false;
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        mHandler.removeCallbacks(mUpdateProgressRunnable);
        mHandler.removeCallbacks(mHideControlRunnable);
        if (mExoPlayer != null && mExoPlayer.isPlaying()) {
            mExoPlayer.setPlayWhenReady(false);
            mContinuePlay = true;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mHandler.removeCallbacks(mUpdateProgressRunnable);
        mHandler.removeCallbacks(mHideControlRunnable);
        if (mExoPlayer != null) {
            mExoPlayer.removeListener(mEventListener);
            mExoPlayer.release();
        }
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            mIvFullscreen.setImageResource(R.drawable.video_player_iv_fullscreen_src_2);
            ViewGroup.LayoutParams layoutParams = mRelativeLayout.getLayoutParams();
            layoutParams.width = SystemUtil.getScreenWidth(getContext());
            layoutParams.height = SystemUtil.getScreenHeight(getContext());
            mRelativeLayout.requestLayout();
            //使内容延伸到状态栏下
            StatusBarUtil.setStatusBarTranslucent(getActivity().getWindow(), true);
            //使状态栏透明
            StatusBarUtil.setStatusBarColor(getActivity().getWindow(), Color.TRANSPARENT, true);
        } else {
            mIvFullscreen.setImageResource(R.drawable.video_player_iv_fullscreen_src);
            ViewGroup.LayoutParams layoutParams = mRelativeLayout.getLayoutParams();
            layoutParams.width = SystemUtil.getScreenWidth(getContext());
            layoutParams.height = getResources().getDimensionPixelOffset(R.dimen.px500);
            mRelativeLayout.requestLayout();
            StatusBarUtil.setStatusBarTranslucent(getActivity().getWindow(), false);
            StatusBarUtil.setStatusBarColor(getActivity().getWindow(), initStatusBarColor(), false);
        }
        mRelativeLayout.addOnLayoutChangeListener(new View.OnLayoutChangeListener() {
            @Override
            public void onLayoutChange(View v, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
                showControl();
            }
        });
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
        mPlayerView.setUseController(false);
        mLlControl = findViewByID(R.id.ll_control);
        mIvPlay = findViewByID(R.id.iv_play);
        mTvCurrentTime = findViewByID(R.id.tv_current_time);
        mSeekBar = findViewByID(R.id.seek_bar);
        mTvTotalTime = findViewByID(R.id.tv_total_time);
        mTvSpeed = findViewByID(R.id.tv_speed);
        mIvFullscreen = findViewByID(R.id.iv_fullscreen);
        mLlBrightness = findViewByID(R.id.ll_brightness);
        mIvBrightness = findViewByID(R.id.iv_brightness);
        mLlBrightnessValue = findViewByID(R.id.ll_brightness_value);
    }


    @Override
    public void initData() {
//        String path = getContext().getCacheDir()
//                + File.separator
//                + "Video"
//                + File.separator
//                + "190309153658147087.mp4";
        String path = "http://vfx.mtime.cn/Video/2019/03/12/mp4/190312083533415853.mp4";
//        String path2 = "http://vfx.mtime.cn/Video/2019/03/09/mp4/190309153658147087.mp4";
        mExoPlayer = new SimpleExoPlayer.Builder(getContext()).build();
        mExoPlayer.addListener(mEventListener);
        mExoPlayer.setRepeatMode(Player.REPEAT_MODE_ALL);
//        mExoPlayer.setPlayWhenReady(true);

        String userAgent = Util.getUserAgent(getContext(), "QinshouBox");
//        // 播放单个视频
//        DataSource.Factory dataSourceFactory = new DefaultDataSourceFactory(getContext(), userAgent);
//        // 设置播放源
//        MediaSource mediaSource = new ProgressiveMediaSource.Factory(dataSourceFactory)
//                .createMediaSource(Uri.parse(path));
//        mExoPlayer.prepare(mediaSource);
//        MediaSource mediaSource2 = new ProgressiveMediaSource.Factory(dataSourceFactory)
//                .createMediaSource(Uri.parse(path2));
        // Prepare the player with the source.
        // ConcatenatingMediaSource 可以设置多个播放源
//        ConcatenatingMediaSource concatenatingMediaSource = new ConcatenatingMediaSource(mediaSource, mediaSource2);

        // 播放 HLS 流
        DataSource.Factory dataSourceFactory = new DefaultHttpDataSourceFactory(userAgent);
        Uri uri = Uri.parse("http://ivi.bupt.edu.cn/hls/cctv1hd.m3u8");
        MediaSource mediaSource = new HlsMediaSource.Factory(dataSourceFactory).createMediaSource(uri);
        mExoPlayer.prepare(mediaSource);

        mPlayerView.setPlayer(mExoPlayer);
    }

    @Override
    public void setListener() {
        mIvPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mExoPlayer == null) {
                    return;
                }
                if (mExoPlayer.isPlaying()) {
                    mExoPlayer.setPlayWhenReady(false);
                    mIvPlay.setImageResource(R.drawable.video_player_iv_play_src);
                } else {
                    mExoPlayer.setPlayWhenReady(true);
                    mIvPlay.setImageResource(R.drawable.video_player_iv_play_src_2);
                }
            }
        });
        mTvSpeed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mExoPlayer == null) {
                    return;
                }
                CharSequence text = mTvSpeed.getText();
                PlaybackParameters playbackParameters = null;
                if (TextUtils.equals(text, getString(R.string.video_player_tv_speed_text))) {
                    mTvSpeed.setText(getString(R.string.video_player_tv_speed_text_2));
                    playbackParameters = new PlaybackParameters(1.5f);
                } else if (TextUtils.equals(text, getString(R.string.video_player_tv_speed_text_2))) {
                    mTvSpeed.setText(getString(R.string.video_player_tv_speed_text_3));
                    playbackParameters = new PlaybackParameters(2.0f);
                } else if (TextUtils.equals(text, getString(R.string.video_player_tv_speed_text_3))) {
                    mTvSpeed.setText(getString(R.string.video_player_tv_speed_text));
                    playbackParameters = new PlaybackParameters(1.0f);
                }
                mExoPlayer.setPlaybackParameters(playbackParameters);
//                showControl();
            }
        });
        mIvFullscreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
                    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
                } else {
                    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
                }
//                showControl();
            }
        });
        mPlayerView.setOnTouchListener(new View.OnTouchListener() {
            private boolean mAdjustBrightness;
            private boolean mAdjustVolume;
            private long mActionDownTimestamp;

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                float screenWidth = getResources().getDisplayMetrics().widthPixels;
                float x = event.getX();
                float y = event.getY();
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        mActionDownTimestamp = System.currentTimeMillis();
                        if (x < screenWidth / 2) {
                            mAdjustBrightness = true;
                        } else {
                            mAdjustVolume = true;
                        }
                        break;
                    case MotionEvent.ACTION_MOVE:
                        // 小于单击有效时间,暂不调整亮度和音量
                        if (System.currentTimeMillis() - mActionDownTimestamp < CLICK_TIME) {
                            break;
                        }
                        if (mAdjustBrightness) {
                            adjustBrightness(y);
                        } else if (mAdjustVolume) {
                            adjustVolume(y);
                        }
                        break;
                    case MotionEvent.ACTION_CANCEL:
                    case MotionEvent.ACTION_UP:
                        // 从上一次按下到抬起,小于 CLICK_TIME,则认为是单击事件
                        if (System.currentTimeMillis() - mActionDownTimestamp < CLICK_TIME) {
//                            showControl();
                            mExoPlayer.setPlayWhenReady(false);
                        }
                        mAdjustBrightness = false;
                        mAdjustVolume = false;
                        mLlBrightness.setVisibility(View.GONE);
                        break;
                }
                return true;
            }
        });
    }

    @Override
    public void handleEvent(EventBean<Object> eventBean) {

    }

    /**
     * Author: QinHao
     * Email:cqflqinhao@126.com
     * Date:2020/2/25 12:26
     * Description:调节亮度
     *
     * @param y 触摸点的 y 坐标
     */
    private void adjustBrightness(float y) {
        if (getResources().getConfiguration().orientation != Configuration.ORIENTATION_LANDSCAPE) {
            return;
        }
        float screenHeight = getResources().getDisplayMetrics().heightPixels;
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

        mIvBrightness.setImageResource(R.drawable.video_player_iv_brightness_src);
        int childCount = mLlBrightnessValue.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View view = mLlBrightnessValue.getChildAt(i);
            if (!(view instanceof ImageView)) {
                continue;
            }
            if (i < (1 - (y / screenHeight)) * childCount) {
                ((ImageView) view).setImageDrawable(new ColorDrawable(0xFFFFFFFF));
            } else {
                ((ImageView) view).setImageBitmap(null);
            }
        }
        mLlBrightness.setVisibility(View.VISIBLE);
    }

    /**
     * Author: QinHao
     * Email:cqflqinhao@126.com
     * Date:2020/2/25 12:26
     * Description:调节音量
     *
     * @param y 触摸点的 y 坐标
     */
    private void adjustVolume(float y) {
        if (getResources().getConfiguration().orientation != Configuration.ORIENTATION_LANDSCAPE) {
            return;
        }
        float screenHeight = getResources().getDisplayMetrics().heightPixels;
        AudioManager audioManager = (AudioManager) getSystemService(AUDIO_SERVICE);
        // 获取音量最大值
        int maxVolume = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        // 通过手指触摸位置与屏幕高度的比例，来计算需要设置的音量
        int volume = (int) ((1 - y / screenHeight) * maxVolume);
        audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, volume, 0);

        mIvBrightness.setImageResource(R.drawable.video_player_iv_brightness_src_2);
        int childCount = mLlBrightnessValue.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View view = mLlBrightnessValue.getChildAt(i);
            if (!(view instanceof ImageView)) {
                continue;
            }
            if (i < (1 - (y / screenHeight)) * childCount) {
                ((ImageView) view).setImageDrawable(new ColorDrawable(0xFFFFFFFF));
            } else {
                ((ImageView) view).setImageBitmap(null);
            }
        }
        mLlBrightness.setVisibility(View.VISIBLE);
    }

    /**
     * Author: QinHao
     * Email:cqflqinhao@126.com
     * Date:2020/2/25 12:32
     * Description:显示控制器控件
     */
    private void showControl() {
        ShowLogUtil.logi("mRelativeLayout.getBottom()--->" + mRelativeLayout.getBottom());
        ObjectAnimator showControlAnimator = ObjectAnimator.ofFloat(mLlControl, "y", mRelativeLayout.getBottom(), mRelativeLayout.getBottom() - mLlControl.getMeasuredHeight());
        showControlAnimator.setDuration(ANIMATOR_DURATION);
        showControlAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                ShowLogUtil.logi("value--->" + animation.getAnimatedValue());
            }
        });
        showControlAnimator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                if (mExoPlayer != null && mExoPlayer.isPlaying()) {
                    // 一秒后自动隐藏
                    mHandler.postDelayed(mHideControlRunnable, HIDE_CONTROL_DELAY);
                }
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
        if (mLlControl.getY() == mRelativeLayout.getBottom() - mLlControl.getMeasuredHeight()) {
            return;
        }
        showControlAnimator.start();
    }


    /**
     * Author: QinHao
     * Email:cqflqinhao@126.com
     * Date:2020/2/25 12:32
     * Description:隐藏控制器控件
     */
    private void hideControl() {
        ObjectAnimator hideControlAnimator = ObjectAnimator.ofFloat(mLlControl, "y", mRelativeLayout.getBottom() - mLlControl.getMeasuredHeight(), mRelativeLayout.getBottom());
        hideControlAnimator.setDuration(ANIMATOR_DURATION);
        hideControlAnimator.start();
    }
}
