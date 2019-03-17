package com.qinshou.qinshoubox.me.ui.activity;

import android.Manifest;
import android.annotation.SuppressLint;
import android.media.MediaRecorder;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.qinshou.commonmodule.util.SystemUtil;
import com.qinshou.commonmodule.util.permissionutil.IOnRequestPermissionResultCallBack;
import com.qinshou.commonmodule.util.permissionutil.PermissionUtil;
import com.qinshou.qinshoubox.MainActivity;
import com.qinshou.qinshoubox.R;
import com.qinshou.qinshoubox.base.MyBaseActivity;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Description:图灵机器人游戏界面
 * Created by 禽兽先生
 * Created on 2018/8/29
 */

public class TurningRobotActivity extends MyBaseActivity {

    private Button mBtnPressToSpeech;

    private ExecutorService mExecutorService;   //录音 JNI 函数不具备线程安全性,所以要用单线程
    private MediaRecorder mMediaRecorder;   //录音类
    private Handler mHandler;
    private long mStartRecordTime;

    @Override
    public int getLayoutId() {
        return R.layout.activity_turning_robot;
    }

    @Override
    public void setPresenter() {

    }

    @Override
    public void initView() {
        mBtnPressToSpeech = findViewByID(R.id.btn_press_to_speech);
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
    }

    @Override
    public void initData() {
        PermissionUtil.requestPermission(this, new String[]{Manifest.permission.RECORD_AUDIO, Manifest.permission.WRITE_EXTERNAL_STORAGE}, new IOnRequestPermissionResultCallBack() {
            @Override
            public void onSuccess() {

            }

            @Override
            public void onError(List<String> deniedPermissionList) {
                Toast.makeText(TurningRobotActivity.this, "没有录音相关权限", Toast.LENGTH_LONG).show();
            }
        });
        mExecutorService = Executors.newSingleThreadExecutor();
        mHandler = new Handler(Looper.getMainLooper());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //停止录音任务,避免内存泄漏
        mExecutorService.shutdownNow();
        releaseRecorder();
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
        mBtnPressToSpeech.setText("按住录音");
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
            Log.i("daolema", "startRecordTime--->" + mStartRecordTime);
        } catch (IOException e) {
            Log.i("daolema", "IOException--->" + e.getMessage());
            e.printStackTrace();
            return false;
        } catch (IllegalStateException e) {
            Log.i("daolema", "IllegalStateException--->" + e.getMessage());
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
        //停止录音
        try {
            mMediaRecorder.stop();
        } catch (IllegalStateException e) {
            e.printStackTrace();
            return false;
        }

        //记录停止时间,计算录音时间
        long stopRecordTime = System.currentTimeMillis();
        long recordTime = stopRecordTime - mStartRecordTime;
        Log.i("daolema", "recordTime--->" + recordTime);
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
                Toast.makeText(TurningRobotActivity.this, "录音失败", Toast.LENGTH_LONG).show();
            }
        });
    }

}
