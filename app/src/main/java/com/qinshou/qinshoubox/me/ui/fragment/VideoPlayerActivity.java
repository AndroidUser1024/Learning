package com.qinshou.qinshoubox.me.ui.fragment;

import android.animation.Animator;
import android.animation.ObjectAnimator;
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

import androidx.fragment.app.FragmentTransaction;

import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.Timeline;
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
import java.util.ArrayList;


/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 20-2-3 上午9:38
 * Description:视频播放界面
 */
public class VideoPlayerActivity extends QSActivity<VideoPlayerPresenter> implements IVideoPlayerContract.IView {

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
//        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
//            mIvFullscreen.setImageResource(R.drawable.video_player_iv_fullscreen_src_2);
//            ViewGroup.LayoutParams layoutParams = mRelativeLayout.getLayoutParams();
//            layoutParams.width = SystemUtil.getScreenWidth(getContext());
//            layoutParams.height = SystemUtil.getScreenHeight(getContext());
//            mRelativeLayout.requestLayout();
//            //使内容延伸到状态栏下
//            StatusBarUtil.setStatusBarTranslucent(getActivity().getWindow(), true);
//            //使状态栏透明
//            StatusBarUtil.setStatusBarColor(getActivity().getWindow(), Color.TRANSPARENT, true);
//        } else {
//            mIvFullscreen.setImageResource(R.drawable.video_player_iv_fullscreen_src);
//            ViewGroup.LayoutParams layoutParams = mRelativeLayout.getLayoutParams();
//            layoutParams.width = SystemUtil.getScreenWidth(getContext());
//            layoutParams.height = getResources().getDimensionPixelOffset(R.dimen.px500);
//            mRelativeLayout.requestLayout();
//            StatusBarUtil.setStatusBarTranslucent(getActivity().getWindow(), false);
//            StatusBarUtil.setStatusBarColor(getActivity().getWindow(), initStatusBarColor(), false);
//        }
//        // 重新设置控制器组件的位置
//        mHandler.post(new Runnable() {
//            @Override
//            public void run() {
//                showControl();
//            }
//        });
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_video_player;
    }

    @Override
    public void initView() {
    }


    @Override
    public void initData() {
        String path = getContext().getCacheDir()
                + File.separator
                + "Video"
                + File.separator
                + "190309153658147087.mp4";
//        String path = "http://vfx.mtime.cn/Video/2019/03/12/mp4/190312083533415853.mp4";
//        String path2 = "http://vfx.mtime.cn/Video/2019/03/09/mp4/190309153658147087.mp4";
        ArrayList<String> pathList = new ArrayList<>();
        pathList.add("http://vfx.mtime.cn/Video/2019/03/12/mp4/190312083533415853.mp4");
        pathList.add("http://vfx.mtime.cn/Video/2019/03/09/mp4/190309153658147087.mp4");
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.fl_fragment_container, VideoPlayerFragment.newInstance(pathList));
        fragmentTransaction.commitAllowingStateLoss();
    }

    @Override
    public void setListener() {

    }

    @Override
    public void handleEvent(EventBean<Object> eventBean) {

    }
}
