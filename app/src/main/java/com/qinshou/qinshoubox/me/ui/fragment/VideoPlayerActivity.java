package com.qinshou.qinshoubox.me.ui.fragment;

import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.VideoView;

import com.google.android.exoplayer2.DefaultLoadControl;
import com.google.android.exoplayer2.DefaultRenderersFactory;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.ProgressiveMediaSource;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
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

    //    private VideoView mVideoView;
    private PlayerView mPlayerView;
    private ImageButton mIbPlayAndPause;
    private ImageButton mIbFullscreen;
    private RelativeLayout mRelativeLayout;

    @Override
    public int getLayoutId() {
        return R.layout.activity_video_player;
    }

    @Override
    public void initView() {
        mRelativeLayout = findViewByID(R.id.relative_layout);
//        mVideoView = findViewByID(R.id.video_view);
        mPlayerView = findViewByID(R.id.player_view);
        mIbPlayAndPause = findViewByID(R.id.ib_play_and_pause);
        mIbFullscreen = findViewByID(R.id.ib_fullscreen);

//        BarChart barChart = findViewByID(R.id.bar_chart);
//        // 数据描述
//        barChart.setDescription(null);
//
//        XAxis xAxis = barChart.getXAxis();
//        xAxis.setDrawGridLines(false);
//        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
//        xAxis.setLabelCount(7,false);
//        xAxis.setValueFormatter(new ValueFormatter() {
//            @Override
//            public String getFormattedValue(float value) {
//                if (value == 0) {
//                    return "日期";
//                }
//                return "2/" + (int) value;
//            }
//        });
//
//        YAxis leftYAxis = barChart.getAxisLeft();
//        // 不绘制网格线
//        leftYAxis.setDrawGridLines(false);
//        // 不绘制标签
//        leftYAxis.setDrawLabels(false);
//
//        YAxis rightYAxis = barChart.getAxisRight();
//        // 不绘制网格线
//        rightYAxis.setDrawGridLines(false);
//        // 不绘制标签
//        rightYAxis.setDrawLabels(false);
//
//        List<BarEntry> barEntryList = new ArrayList<>();
//        barEntryList.add(new BarEntry(0f, 0f));
//        for (int i = 1; i < 15; i++) {
//            BarEntry barEntry = new BarEntry(i, new Random().nextFloat());
//            barEntryList.add(barEntry);
//        }
//        BarDataSet barDataSet = new BarDataSet(barEntryList, null);
//        // 设置柱颜色
//        barDataSet.setGradientColor(0xFF313B7E, 0xFF6374C6);
//        barChart.setData(new BarData(barDataSet));
    }


    @Override
    public void initData() {
//        String path = getContext().getCacheDir()
//                + File.separator
//                + "Video"
//                + File.separator
//                + "190319222227698228.mp4";
//        mVideoView.setVideoPath(path);
//
//        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
//        mediaMetadataRetriever.setDataSource(path);
//        Bitmap frameAtTime = mediaMetadataRetriever.getFrameAtTime();
//        mVideoView.setBackground(new BitmapDrawable(getResources(), frameAtTime));
//        ExoPlayer exoPlayer = ExoPlayerFactory.newSimpleInstance(
//                new DefaultRenderersFactory(getContext()),
//                new DefaultTrackSelector(), new DefaultLoadControl());
//        ExoPlayer exoPlayer = new ExoPlayer.Builder(getContext()).build();
        SimpleExoPlayer exoPlayer = new SimpleExoPlayer.Builder(getContext()).build();
        exoPlayer.setPlayWhenReady(true);
        mPlayerView.setPlayer(exoPlayer);

        // Produces DataSource instances through which media data is loaded.
        DataSource.Factory dataSourceFactory = new DefaultDataSourceFactory(getContext()
                , Util.getUserAgent(getContext(), SystemUtil.getAppName(getContext())));
// This is the MediaSource representing the media to be played.
        String url = "http://clips.vorwaerts-gmbh.de/big_buck_bunny.mp4";
        MediaSource videoSource = new ProgressiveMediaSource.Factory(dataSourceFactory)
                .createMediaSource(Uri.parse(url));
// Prepare the player with the source.
        exoPlayer.prepare(videoSource);
    }

    @Override
    public void setListener() {
        super.setListener();
//        mIbPlayAndPause.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                ShowLogUtil.logi("点击");
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
//            }
//        });
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
}
