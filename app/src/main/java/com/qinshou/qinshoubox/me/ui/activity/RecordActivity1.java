package com.qinshou.qinshoubox.me.ui.activity;

import android.annotation.SuppressLint;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.qinshou.qinshoubox.R;
import com.qinshou.qinshoubox.base.QSActivity;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.ExecutorService;

/**
 * Create By:禽兽先生
 * Create On:2019-03-19 21:05
 * Description:
 */
public class RecordActivity1 extends QSActivity {
    private Button mBtnPressToSpeech;
    private Button mBtnPlay;

    private ExecutorService mExecutorService;   //录音 JNI 函数不具备线程安全性,所以要用单线程
    private MediaRecorder mMediaRecorder;   //录音类
    private Handler mHandler;
    private long mStartRecordTime;
    private MediaPlayer mMediaPlayer;

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //停止录音任务,避免内存泄漏
        mExecutorService.shutdownNow();
        releaseRecorder();
        //停止播放
        stopPlay();
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_record_1;
    }


    @Override
    public void initView() {
//        mBtnPressToSpeech = findViewByID(R.id.btn_press_to_speech);
//        mBtnPlay = findViewByID(R.id.btn_play);
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public void setListener() {
        mBtnPressToSpeech.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        startRecord();
                        break;
                    case MotionEvent.ACTION_UP:
                    case MotionEvent.ACTION_CANCEL:
                        stopRecord();
                        break;
                }
                return true;
            }
        });
        mBtnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startPlay();
            }
        });
    }

    @Override
    public void initData() {
//        PermissionUtil.requestPermission(this, new String[]{Manifest.permission.RECORD_AUDIO, Manifest.permission.WRITE_EXTERNAL_STORAGE}, new IOnRequestPermissionResultCallBack() {
//            @Override
//            public void onSuccess() {
//
//            }
//
//            @Override
//            public void onError(List<String> deniedPermissionList) {
//                Toast.makeText(getContext(), "没有录音相关权限", Toast.LENGTH_LONG).show();
//            }
//        });
//        mExecutorService = Executors.newSingleThreadExecutor();
//        mHandler = new Handler(Looper.getMainLooper());
    }

    /**
     * Create By:禽兽先生
     * Description: 开始录音
     */
    private void startRecord() {
        //修改 UI 状态
        mBtnPressToSpeech.setText("松开结束");
        //开始录音任务
        mExecutorService.submit(new Runnable() {
            @Override
            public void run() {
                //释放之前的 Recorder
                releaseRecorder();

                if (!doStart()) {
                    recordFailure();
                }
            }
        });
    }

    /**
     * Create By:禽兽先生
     * Description: 停止录音
     */
    private void stopRecord() {
        //修改 UI 状态
        mBtnPressToSpeech.setText("按住说话");
        //结束录音任务
        mExecutorService.submit(new Runnable() {
            @Override
            public void run() {
                if (!doStop()) {
                    recordFailure();
                }
                //释放之前的 Recorder
                releaseRecorder();
            }
        });
    }

    /**
     * Create By:禽兽先生
     * Description: 开始录音的具体逻辑
     */
    private boolean doStart() {
        try {
            //创建录音文件
            File file = new File(getCacheDir() + "/Audio/speech.m4a");
            if (!file.exists()) {
                file.getParentFile().mkdirs();
                file.createNewFile();
            }
            //创建 MediaRecorder
            mMediaRecorder = new MediaRecorder();

            //配置 MediaRecorder
            //设置音频来源
            mMediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
            //设置音频格式
            mMediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.MPEG_4);
            //设置音频采样率
            mMediaRecorder.setAudioSamplingRate(44100);
            //设置音频编码格式
            mMediaRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AAC);
            //设置音频编码频率
            mMediaRecorder.setAudioEncodingBitRate(96000);
            //设置音频输出文件
            mMediaRecorder.setOutputFile(file.getAbsolutePath());

            //开始录音
            mMediaRecorder.prepare();
            mMediaRecorder.start();

            //记录开始录音的时间
            mStartRecordTime = System.currentTimeMillis();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        } catch (IllegalStateException e) {
            e.printStackTrace();
            return false;
        }
        //录音成功
        return true;
    }

    /**
     * Create By:禽兽先生
     * Description: 停止录音的具体逻辑
     */
    private boolean doStop() {
        try {
            //停止录音
            mMediaRecorder.stop();
        } catch (IllegalStateException e) {
            e.printStackTrace();
            return false;
        }

        //记录停止时间,计算录音时间
        long stopRecordTime = System.currentTimeMillis();
        long recordTime = stopRecordTime - mStartRecordTime;
        //小于 2s 不算有效录音
        if (recordTime < 2000) {
            return false;
        }
        return true;
    }

    /**
     * Create By:禽兽先生
     * Description: 释放资源
     */
    private void releaseRecorder() {
        if (mMediaRecorder != null) {
            mMediaRecorder.release();
            mMediaRecorder = null;
        }
    }

    /**
     * Create By:禽兽先生
     * Description: 录音失败
     */
    private void recordFailure() {
        mHandler.post(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(getContext(), "录音失败", Toast.LENGTH_LONG).show();
            }
        });
    }

    /**
     * Create By:禽兽先生
     * Description: 播放录音文件
     */
    private void startPlay() {
        //对 mMediaPlayer 进行是否为空的判断,如果为空说明正在播放,直接 return
        if (mMediaPlayer != null) {
            return;
        }
        mExecutorService.submit(new Runnable() {
            @Override
            public void run() {
                doPlay();
            }
        });
    }

    /**
     * Create By:禽兽先生
     * Description: 停止播放
     */
    private void stopPlay() {
        if (mMediaPlayer != null) {
            if (mMediaPlayer.isPlaying()) {
                mMediaPlayer.stop();
            }
            mMediaPlayer.setOnPreparedListener(null);
            mMediaPlayer.setOnCompletionListener(null);
            mMediaPlayer.setOnErrorListener(null);
            mMediaPlayer.release();
            mMediaPlayer = null;
        }
    }

    /**
     * Create By:禽兽先生
     * Description: 具体的播放逻辑
     */
    private void doPlay() {
        stopPlay();
        File file = new File(getCacheDir() + "/Audio/speech.m4a");
        //配置 MediaPlayer
        mMediaPlayer = new MediaPlayer();
        try {
            mMediaPlayer.setDataSource(file.getAbsolutePath());
            mMediaPlayer.prepareAsync();
            mMediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mediaPlayer) {
                    mMediaPlayer.start();
                }
            });
            mMediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    stopPlay();
                }
            });
            mMediaPlayer.setOnErrorListener(new MediaPlayer.OnErrorListener() {
                @Override
                public boolean onError(MediaPlayer mediaPlayer, int i, int i1) {
                    playFailure();
                    stopPlay();
                    //错误已经处理后返回 true
                    return true;
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
            playFailure();
            stopPlay();
        }
    }

    /**
     * Create By:禽兽先生
     * Description: 录音失败
     */
    private void playFailure() {
        mHandler.post(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(getContext(), "播放失败", Toast.LENGTH_LONG).show();
            }
        });
    }
}
