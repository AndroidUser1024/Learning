package com.qinshou.qinshoubox.music.view.activity;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.qinshou.commonmodule.adapter.VpSingleViewAdapter;
import com.qinshou.commonmodule.util.DisplayUtil;
import com.qinshou.commonmodule.widget.TitleBar;
import com.qinshou.mediamodule.IMediaPlayerListener;
import com.qinshou.mediamodule.MediaPlayerHelper;
import com.qinshou.qinshoubox.R;
import com.qinshou.qinshoubox.base.QSActivity;
import com.qinshou.qinshoubox.homepage.bean.EventBean;
import com.qinshou.qinshoubox.music.bean.MusicBean;
import com.qinshou.qinshoubox.music.contract.IMusicPlayContract;
import com.qinshou.qinshoubox.music.presenter.MusicPlayPresenter;

import java.util.ArrayList;
import java.util.List;

import androidx.viewpager.widget.ViewPager;

/**
 * Description:音乐播放界面
 * Author: QinHao
 * Date: 2019/4/4 18:32
 */
public class MusicPlayActivity extends QSActivity<MusicPlayPresenter> implements IMusicPlayContract.IMusicPlayView {

    private static final String MUSIC_LIST = "MusicList";
    private static final String INDEX = "Index";
    private TitleBar mTitleBar;
    private ViewPager mViewPager;   //音乐播放界面中间的 ViewPager,目前准备放唱片 View 和歌词 View
    private ImageView mIvDiskRod;   //唱片杆
    private ImageView mIvDisk;  //唱片
    private TextView mTvCurrentTime;    //当前播放时长
    private SeekBar mSbPlayProgress;    //播放进度条
    private TextView mTvTotalTime;  //歌曲总时长
    private ImageButton mIbPrevious;    //上一曲按钮
    private ImageButton mIbPlayAndPause;    //播放暂停按钮
    private ImageButton mIbNext;    //下一曲按钮

    private List<MusicBean> mMusicBeanList; //音乐列表
    private int mIndex; //当前播放的音乐在列表中的下标

    private float mIvDiskRodRotation = -25f;    //唱片杆旋转动画的角度
    private ObjectAnimator mIvDiskRodAnimator; //唱片杆的旋转动画
    private ObjectAnimator mIvDiskAnimator; //唱片旋转动画
    private MediaPlayerHelper mMediaPlayerHelper;
    private Handler mHandler = new Handler();
    /**
     * 更新进度条的任务
     */
    private Runnable mUpdateProgressRunnable = new Runnable() {
        @Override
        public void run() {
            if (mMediaPlayerHelper == null) {
                return;
            }
            long currentPosition = mMediaPlayerHelper.getCurrentPosition();
            long duration = mMediaPlayerHelper.getDuration();
            mSbPlayProgress.setMax((int) duration);
            mSbPlayProgress.setProgress((int) currentPosition);

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
                if (totalTimeHour < 10) {
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

//                float speed = mMediaPlayerHelper.getPlaybackParameters().speed;
            float speed = 1;
            long delayMillis = (long) (1000 / speed);
            mHandler.postDelayed(this, delayMillis);
        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mHandler.removeCallbacks(mUpdateProgressRunnable);
    }

    @Override
    public boolean initStatusBarDark() {
        return false;
    }

    @Override
    public boolean isImmersive() {
        return true;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_music_play;
    }

    @Override
    public void initView() {
        mTitleBar = findViewByID(R.id.title_bar);
        mViewPager = findViewByID(R.id.view_pager);
        List<View> viewList = new ArrayList<>();
        List<String> titleList = new ArrayList<>();
        viewList.add(LayoutInflater.from(getContext()).inflate(R.layout.layout_disk_view, null));
        titleList.add("");
        VpSingleViewAdapter vpSingleViewAdapter = new VpSingleViewAdapter(viewList, titleList);
        mViewPager.setAdapter(vpSingleViewAdapter);
        mViewPager.setOffscreenPageLimit(vpSingleViewAdapter.getCount());

        mIvDiskRod = viewList.get(0).findViewById(R.id.iv_disk_rod);
        mIvDiskRod.setPivotX(0);
        mIvDiskRod.setPivotY(0);
        mIvDiskRod.setRotation(mIvDiskRodRotation);
        mIvDisk = viewList.get(0).findViewById(R.id.iv_disk);

        mTvCurrentTime = findViewByID(R.id.tv_current_time);
        mSbPlayProgress = findViewByID(R.id.sb_play_progress);
        mTvTotalTime = findViewByID(R.id.tv_total_time);
        mIbPrevious = findViewByID(R.id.ib_previous);
        mIbPlayAndPause = findViewByID(R.id.ib_play_and_pause);
        mIbNext = findViewByID(R.id.ib_next);

        //设置唱片杆的旋转动画的中心
        mIvDiskRod.setPivotX(DisplayUtil.dp2px(getContext(), 10f));
        mIvDiskRod.setPivotY(DisplayUtil.dp2px(getContext(), 10f));
        //设置唱片杆的旋转动画
        mIvDiskRodAnimator = new ObjectAnimator();
        mIvDiskRodAnimator.setTarget(mIvDiskRod);
        mIvDiskRodAnimator.setPropertyName("rotation");
        mIvDiskRodAnimator.setInterpolator(new LinearInterpolator());
        //设置唱片旋转动画
        mIvDiskAnimator = new ObjectAnimator();
        mIvDiskAnimator.setTarget(mIvDisk);
        mIvDiskAnimator.setPropertyName("rotation");
        mIvDiskAnimator.setDuration(15 * 1000);
        mIvDiskAnimator.setRepeatCount(ValueAnimator.INFINITE);
        mIvDiskAnimator.setRepeatMode(ValueAnimator.RESTART);
        mIvDiskAnimator.setInterpolator(new LinearInterpolator());

        mMediaPlayerHelper = new MediaPlayerHelper(getContext());
    }

    @Override
    public void setListener() {
        mTitleBar.setLeftImageOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        mTitleBar.setRightImageOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        mIbPrevious.setOnClickListener(mOnClickListener);
        mIbPlayAndPause.setOnClickListener(mOnClickListener);
        mIbNext.setOnClickListener(mOnClickListener);
        mSbPlayProgress.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (!fromUser || !mMediaPlayerHelper.isPlaying()) {
                    return;
                }
                mMediaPlayerHelper.seekTo(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        mMediaPlayerHelper.setMediaPlayerListener(new IMediaPlayerListener() {
            @Override
            public void onStart() {
//                mHandler.post(new Runnable() {
//                    @Override
//                    public void run() {
                        long duration = mMediaPlayerHelper.getDuration();
                        //设置进度条 max
                        mSbPlayProgress.setMax((int) duration);
                        //设置播放暂停按钮的图片资源
                        mIbPlayAndPause.setImageResource(R.drawable.music_play_ib_play_or_pause_src_pause);
                        //开始唱片旋转动画
                        mIvDiskAnimator.setFloatValues(0, 360);
                        mIvDiskAnimator.start();

                        //如果唱片杆动画正在运行,先取消之前的动画
                        if (mIvDiskRodAnimator.isRunning()) {
                            mIvDiskRodAnimator.cancel();
                        }
                        //如果唱片杆已经移动了,则先恢复原位再移动
                        if (mIvDiskRod.getRotation() == 0) {
                            mIvDiskRodAnimator.setFloatValues(0, mIvDiskRodRotation, 0);
                        } else {
                            mIvDiskRodAnimator.setFloatValues(mIvDiskRodRotation, 0);
                        }
                        mIvDiskRodAnimator.setDuration(1000);
                        mIvDiskRodAnimator.start();

//                    }
//                });

                mHandler.removeCallbacks(mUpdateProgressRunnable);
                mHandler.post(mUpdateProgressRunnable);
            }

            @Override
            public void onPause() {

            }

            @Override
            public void onStop() {

            }

            @Override
            public void onComplete() {
                mIbPlayAndPause.setImageResource(R.drawable.music_play_ib_play_or_pause_src_play);
                mIbNext.performClick();
            }

            @Override
            public void onError(Exception e) {
                mIbPlayAndPause.setImageResource(R.drawable.music_play_ib_play_or_pause_src_play);
            }
        });
    }

    @Override
    public void initData() {
        mMusicBeanList = getIntent().getParcelableArrayListExtra(MUSIC_LIST);
        mIndex = getIntent().getIntExtra(INDEX, 0);
        if (mMusicBeanList == null) {
            return;
        }
        playMusic();
    }

    @Override
    public void handleEvent(EventBean<Object> eventBean) {

    }

    private View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.ib_previous:
                    previous();
                    break;
                case R.id.ib_play_and_pause:
                    playOrPause();
                    break;
                case R.id.ib_next:
                    next();
                    break;
            }

        }
    };

    /**
     * description:播放音乐
     * author:QinHao
     * date:2019/4/4 19:04
     */
    private void playMusic() {
        MusicBean musicBean = mMusicBeanList.get(mIndex);
        mTitleBar.setTitleText(musicBean.getName());
        mIvDisk.setImageResource(R.drawable.music_play_iv_disk_src_default);
        mMediaPlayerHelper.play(Uri.parse(musicBean.getPath()));
    }

    /**
     * description:播放或者暂停
     * author:QinHao
     * date:2019/4/4 19:04
     */
    private void playOrPause() {
        if (mMediaPlayerHelper.isPlaying()) {
            //暂停播放
            mMediaPlayerHelper.pause();
            //修改播放暂停按钮的图片资源
            mIbPlayAndPause.setImageResource(R.drawable.music_play_ib_play_or_pause_src_play);
            //暂停唱片旋转动画
            mIvDiskAnimator.cancel();

            //如果唱片杆动画正在运行,先取消之前的动画
            if (mIvDiskRodAnimator.isRunning()) {
                mIvDiskRodAnimator.cancel();
            }
            //唱片杆恢复原位
            mIvDiskRodAnimator.setFloatValues(0, mIvDiskRodRotation);
            mIvDiskRodAnimator.setDuration(500);
            mIvDiskRodAnimator.start();
        } else {
            //开始播放
            mMediaPlayerHelper.start();
            //修改播放暂停按钮的图片资源
            mIbPlayAndPause.setImageResource(R.drawable.music_play_ib_play_or_pause_src_pause);
            //开始唱片旋转动画
            mIvDiskAnimator.setFloatValues(mIvDisk.getRotation(), mIvDisk.getRotation() + 360);
            mIvDiskAnimator.start();
            //如果唱片杆动画正在运行,先取消之前的动画
            if (mIvDiskRodAnimator.isRunning()) {
                mIvDiskRodAnimator.cancel();
            }
            //唱片杆移动
            mIvDiskRodAnimator.setFloatValues(mIvDiskRodRotation, 0);
            mIvDiskRodAnimator.setDuration(1000);
            mIvDiskRodAnimator.start();
        }
    }

    /**
     * description:上一曲
     * author:QinHao
     * date:2019/4/4 19:04
     */
    private void previous() {
        if (mIndex == 0) {
            mIndex = mMusicBeanList.size() - 1;
        } else {
            mIndex--;
        }
        playMusic();

    }

    /**
     * description:下一曲
     * author:QinHao
     * date:2019/4/4 19:04
     */
    private void next() {
        if (mIndex == mMusicBeanList.size() - 1) {
            mIndex = 0;
        } else {
            mIndex++;
        }
        playMusic();
    }

    public static void start(Context context, ArrayList<MusicBean> musicBeanList, int index) {
        Intent intent = new Intent(context, MusicPlayActivity.class);
        intent.putParcelableArrayListExtra(MUSIC_LIST, musicBeanList);
        intent.putExtra(INDEX, index);
        context.startActivity(intent);
    }
}
