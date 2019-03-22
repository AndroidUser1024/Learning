package com.qinshou.qinshoubox.me.ui.activity;

import android.Manifest;
import android.annotation.SuppressLint;
import android.media.AudioAttributes;
import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.AudioRecord;
import android.media.AudioTrack;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.qinshou.commonmodule.util.permissionutil.IOnRequestPermissionResultCallBack;
import com.qinshou.commonmodule.util.permissionutil.PermissionUtil;
import com.qinshou.qinshoubox.R;
import com.qinshou.qinshoubox.base.MyBaseActivity;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Create By:禽兽先生
 * Create On:2019-03-19 21:05
 * Description:
 */
public class RecordActivity2 extends MyBaseActivity {
    private Button mBtnPressToSpeech;

    private ExecutorService mExecutorService;   //录音 JNI 函数不具备线程安全性,所以要用单线程
    private Handler mHandler;
    private volatile boolean mRecording;
    private AudioTrack mAudioTrack;
    private Button mBtnPlay;

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //停止录音任务,避免内存泄漏
        mExecutorService.shutdownNow();
        stopPlay();
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_record_2;
    }

    @Override
    public void setPresenter() {

    }

    @Override
    public void initView() {
        mBtnPressToSpeech = findViewByID(R.id.btn_press_to_speech);
        mBtnPlay = findViewByID(R.id.btn_play);
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
        PermissionUtil.requestPermission(this, new String[]{Manifest.permission.RECORD_AUDIO, Manifest.permission.WRITE_EXTERNAL_STORAGE}, new IOnRequestPermissionResultCallBack() {
            @Override
            public void onSuccess() {

            }

            @Override
            public void onError(List<String> deniedPermissionList) {
                Toast.makeText(getContext(), "没有录音相关权限", Toast.LENGTH_LONG).show();
            }
        });
        mExecutorService = Executors.newSingleThreadExecutor();
        mHandler = new Handler(Looper.getMainLooper());
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
                if (!doStart()) {
                    recordFailure();
                }
            }
        });
    }

    /**
     * Create By:禽兽先生
     * Description: 真正的录音逻辑
     */
    private boolean doStart() {
        FileOutputStream fileOutputStream = null;
        AudioRecord audioRecord = null;
        try {
            mRecording = true;
            //创建录音文件
            File file = new File(getCacheDir() + "/Audio/speech.pcm");
            if (!file.exists()) {
                file.getParentFile().mkdirs();
                file.createNewFile();
            }
            //创建输出流
            fileOutputStream = new FileOutputStream(file);

            //配置 AudioRecord
            //录音来源
            int audioSource = MediaRecorder.AudioSource.MIC;
            //录音频率
            int sampleRate = 44100;
            //声道为单声道
            int channelConfig = AudioFormat.CHANNEL_IN_MONO;
            //音频格式
            int audioFormat = AudioFormat.ENCODING_PCM_16BIT;
            //计算 AudioRecord 缓冲区的 Buffer 的最小大小
            int minBufferSize = AudioRecord.getMinBufferSize(sampleRate, channelConfig, audioFormat);
            //自己定义的每次读取缓冲区的最小 SIZE
            byte[] buffer = new byte[1024 * 2];

            //创建 AudioRecord
            audioRecord = new AudioRecord(audioSource
                    , sampleRate
                    , channelConfig
                    , audioFormat
                    , Math.max(minBufferSize, buffer.length));

            //开始录音
            audioRecord.startRecording();
            //记录开始录音时间
            long startRecordTime = System.currentTimeMillis();
            //循环读取数据,写入到输出流中
            while (mRecording) {
                int length = audioRecord.read(buffer, 0, buffer.length);
                if (length > 0) {
                    fileOutputStream.write(buffer, 0, length);
                } else {
                    //读取失败
                    return false;
                }
            }

            //停止录音
            audioRecord.stop();
            //记录结束时间,计算录音时间
            long stopRecordTime = System.currentTimeMillis();
            long recordTime = stopRecordTime - startRecordTime;
            //小于 2s 不算有效录音
            if (recordTime < 2000) {
                return false;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        } catch (IllegalStateException e) {
            e.printStackTrace();
            return false;
        } finally {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (audioRecord != null) {
                audioRecord.release();
            }
        }
        return true;
    }

    /**
     * Create By:禽兽先生
     * Description: 停止录音
     */
    private void stopRecord() {
        //修改 UI 状态
        mBtnPressToSpeech.setText("按住说话");
        mRecording = false;
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
        //对 mAudioTrack 进行是否为空的判断,如果为空说明正在播放,直接 return
        if (mAudioTrack != null) {
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
        if (mAudioTrack != null) {
            try {
                mAudioTrack.stop();
                mAudioTrack.release();
                mAudioTrack = null;
            } catch (IllegalStateException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Create By:禽兽先生
     * Description: 具体的播放逻辑
     */
    private void doPlay() {
        stopPlay();
        File file = new File(getCacheDir() + "/Audio/speech.pcm");
        //配置 AudioTrack
        //音乐类型,扬声器播放
        int streamType = AudioManager.STREAM_MUSIC;
        //采样率
        int sampleRate = 44100;
        //单声道
        int channelConfig = AudioFormat.CHANNEL_OUT_MONO;
        //音频格式
        int audioFormat = AudioFormat.ENCODING_PCM_16BIT;
        //流模式
        int mode = AudioTrack.MODE_STREAM;

        int minBufferSize = AudioTrack.getMinBufferSize(sampleRate, channelConfig, audioFormat);

        //自己定义的每次读取缓冲区的最小 SIZE
        byte[] buffer = new byte[1024 * 2];
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            mAudioTrack = new AudioTrack.Builder()
                    .setAudioAttributes(new AudioAttributes.Builder()
                            .setUsage(AudioAttributes.USAGE_ALARM)
                            .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                            .build())
                    .setAudioFormat(new AudioFormat.Builder()
                            .setSampleRate(sampleRate)
                            .setChannelMask(channelConfig)
                            .setEncoding(audioFormat)
                            .build())
                    .setBufferSizeInBytes(Math.max(minBufferSize, buffer.length))
                    .build();
        } else {
            mAudioTrack = new AudioTrack(streamType
                    , sampleRate
                    , channelConfig
                    , audioFormat
                    , Math.max(minBufferSize, buffer.length)
                    , mode);
        }
        mAudioTrack.play();
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(file);
            int length;
            //循环读取音频文件
            while ((length = fileInputStream.read(buffer)) > 0) {
                int result = mAudioTrack.write(buffer, 0, length);
                //检查返回值
                switch (result) {
                    case AudioTrack.ERROR_INVALID_OPERATION:
                    case AudioTrack.ERROR_BAD_VALUE:
                    case AudioTrack.ERROR_DEAD_OBJECT:
                        playFailure();
                        return;
                    default:
                        break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            stopPlay();
            playFailure();
        } finally {
            //释放资源
            stopPlay();
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
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
