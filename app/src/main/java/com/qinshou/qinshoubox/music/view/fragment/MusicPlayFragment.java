package com.qinshou.qinshoubox.music.view.fragment;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.qinshou.commonmodule.adapter.VpSingleViewAdapter;
import com.qinshou.commonmodule.base.AbsMVPFragment;
import com.qinshou.commonmodule.util.DisplayUtil;
import com.qinshou.commonmodule.util.MediaPlayerHelper;
import com.qinshou.qinshoubox.R;
import com.qinshou.qinshoubox.base.QSFragment;
import com.qinshou.qinshoubox.homepage.bean.EventBean;
import com.qinshou.qinshoubox.music.bean.MusicBean;
import com.qinshou.qinshoubox.music.contract.IMusicPlayContract;
import com.qinshou.qinshoubox.music.presenter.MusicPlayPresenter;
import com.scwang.smartrefresh.layout.util.DensityUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:音乐播放界面
 * Author: QinHao
 * Date: 2019/4/4 18:32
 */
public class MusicPlayFragment extends QSFragment<MusicPlayPresenter> implements IMusicPlayContract.IMusicPlayView {

    private TextView mTvTitle;  //音乐标题
    private ImageButton mIbShare;   //分享按钮
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

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        MediaPlayerHelper.SINGLETON.stop();
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_music_play;
    }

    @Override
    public void initView() {
        mTvTitle = findViewByID(R.id.tv_title);
        mIbShare = findViewByID(R.id.ib_share);
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
    }

    @Override
    public void setListener() {
        super.setListener();
        mIbShare.setOnClickListener(mOnClickListener);
        mIbPrevious.setOnClickListener(mOnClickListener);
        mIbPlayAndPause.setOnClickListener(mOnClickListener);
        mIbNext.setOnClickListener(mOnClickListener);
        mSbPlayProgress.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (!fromUser || !MediaPlayerHelper.SINGLETON.isPlaying()) {
                    return;
                }
                MediaPlayerHelper.SINGLETON.seekTo(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    @Override
    public void initData() {
        Bundle bundle = getArguments();
        if (bundle == null) {
            return;
        }
        mMusicBeanList = bundle.getParcelableArrayList("MusicList");
        mIndex = bundle.getInt("index");
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
        mTvTitle.setText(musicBean.getName());
        mIvDisk.setImageResource(R.drawable.music_play_iv_disk_src_default);
        MediaPlayerHelper.SINGLETON.playMusic(musicBean.getPath(), new MediaPlayerHelper.IOnMediaPlayerListener() {
            @Override
            public void onStart(int totalProgress) {
                //设置进度条 max
                mSbPlayProgress.setMax(totalProgress);
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
            }

            @Override
            public void onError() {
                mIbPlayAndPause.setImageResource(R.drawable.music_play_ib_play_or_pause_src_play);
            }

            @Override
            public void onComplete() {
                mIbPlayAndPause.setImageResource(R.drawable.music_play_ib_play_or_pause_src_play);
                mIbNext.performClick();
            }

            @Override
            public void onProgress(final int progress, int totalProgress, final int currentTimeMinute, final int currentTimeSecond, final int totalTimeMinute, final int totalTimeSecond) {
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mSbPlayProgress.setProgress(progress);
                        StringBuilder stringBuilder = new StringBuilder();
                        if (currentTimeMinute < 10) {
                            stringBuilder.append(0);
                        }
                        stringBuilder.append(currentTimeMinute)
                                .append(":");
                        if (currentTimeSecond < 10) {
                            stringBuilder.append(0);
                        }
                        stringBuilder.append(currentTimeSecond);
                        mTvCurrentTime.setText(stringBuilder);

                        stringBuilder = new StringBuilder();
                        if (totalTimeMinute < 10) {
                            stringBuilder.append(0);
                        }
                        stringBuilder.append(totalTimeMinute)
                                .append(":");
                        if (totalTimeSecond < 10) {
                            stringBuilder.append(0);
                        }
                        stringBuilder.append(totalTimeSecond);
                        mTvTotalTime.setText(stringBuilder);
                    }
                });

            }

            @Override
            public void onBufferingUpdate(int percent) {

            }
        });
    }

    /**
     * description:播放或者暂停
     * author:QinHao
     * date:2019/4/4 19:04
     */
    private void playOrPause() {
        if (MediaPlayerHelper.SINGLETON.isPlaying()) {
            //暂停播放
            MediaPlayerHelper.SINGLETON.pause();
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
            MediaPlayerHelper.SINGLETON.start();
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
}
