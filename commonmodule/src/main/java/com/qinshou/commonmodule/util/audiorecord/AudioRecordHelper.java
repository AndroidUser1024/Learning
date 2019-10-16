package com.qinshou.commonmodule.util.audiorecord;

import android.media.AudioFormat;
import android.media.AudioRecord;
import android.media.MediaRecorder;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Description:AudioRecord 的帮助类
 * Author: QinHao
 * Date: 2019/4/24 15:14
 */
public enum AudioRecordHelper {
    SINGLETON;

    private static final String TAG = "AudioRecordHelper";
    private ExecutorService mExecutorService;   //录音 JNI 函数不具备线程安全性,所以要用单线程
    private Handler mHandler;
    private volatile boolean mRecording;
    private Future mFuture;
    private boolean mCancelRecordAudio = false;

    AudioRecordHelper() {
        mExecutorService = Executors.newSingleThreadExecutor();
        mHandler = new Handler(Looper.getMainLooper());
    }

    private void throwException(final IOnAudioRecordListener onAudioRecordListener, final String message) {
        Log.i(TAG, "message--->" + message);
        if (onAudioRecordListener != null) {
            mHandler.post(new Runnable() {
                @Override
                public void run() {
                    onAudioRecordListener.onError(message);
                }
            });
        }
    }

    /**
     * Create By:禽兽先生
     * Description: 开始录音
     */
    public void startRecord(final File file, final IOnAudioRecordListener onAudioRecordListener) {
        //配置 AudioRecord
        //录音来源
        int audioSource = MediaRecorder.AudioSource.MIC;
        //录音频率
        int sampleRate = 44100;
        //声道为单声道
        int channelConfig = AudioFormat.CHANNEL_IN_MONO;
        //音频格式
        int audioFormat = AudioFormat.ENCODING_PCM_16BIT;
        this.startRecord(file, audioSource, sampleRate, channelConfig, audioFormat, onAudioRecordListener);
    }

    /**
     * Create By:禽兽先生
     * Description: 开始录音
     */
    public void startRecord(final File file, final int audioSource, final int sampleRate, final int channelConfig, final int audioFormat, final IOnAudioRecordListener onAudioRecordListener) {
        stopRecordAudio();
        if (mFuture != null) {
            mFuture.cancel(true);
            throwException(onAudioRecordListener, "录音线程已开启");
            return;
        }
        //开始录音任务
        mFuture = mExecutorService.submit(new Runnable() {
            @Override
            public void run() {
                FileOutputStream fileOutputStream = null;
                AudioRecord audioRecord = null;
                try {
                    mRecording = true;
                    mCancelRecordAudio = false;
                    // 创建录音文件
                    if (!file.exists()) {
                        file.getParentFile().mkdirs();
                    }
                    file.createNewFile();
                    // 创建输出流
                    fileOutputStream = new FileOutputStream(file);

                    // 计算 AudioRecord 缓冲区的 Buffer 的最小大小
                    int minBufferSize = AudioRecord.getMinBufferSize(sampleRate, channelConfig, audioFormat);
                    // 自己定义的每次读取缓冲区的最小 SIZE
                    byte[] buffer = new byte[1024 * 2];

                    // 创建 AudioRecord
                    audioRecord = new AudioRecord(audioSource
                            , sampleRate
                            , channelConfig
                            , audioFormat
                            , Math.max(minBufferSize, buffer.length));
                    // 开始录音
                    audioRecord.startRecording();
                    // 记录开始录音时间
                    final long startRecordTime = System.currentTimeMillis();
                    if (onAudioRecordListener != null) {
                        mHandler.post(new Runnable() {
                            @Override
                            public void run() {
                                onAudioRecordListener.onStart();
                            }
                        });
                    }
                    // 循环读取数据,写入到输出流中
                    while (mRecording) {
                        int length = audioRecord.read(buffer, 0, buffer.length);
                        if (length > 0) {
                            fileOutputStream.write(buffer, 0, length);
                        } else {
                            //读取失败
                            audioRecord.stop();
                            audioRecord.release();
                            throwException(onAudioRecordListener, "采集音频数据失败");
                            return;
                        }
                    }

                    // 停止录音
                    audioRecord.stop();
                    audioRecord.release();
//                    // 记录结束时间,计算录音时间
//                    long stopRecordTime = System.currentTimeMillis();
//                    long recordTime = stopRecordTime - startRecordTime;
                    // 小于 1s 不算有效录音
                    if (System.currentTimeMillis() - startRecordTime < 1000) {
                        throwException(onAudioRecordListener, "record time less than 1 seconds");
                    } else {
                        if (onAudioRecordListener != null) {
                            mHandler.post(new Runnable() {
                                @Override
                                public void run() {
                                    if (mCancelRecordAudio) {
                                        onAudioRecordListener.onCancel(file, System.currentTimeMillis() - startRecordTime);
                                    } else {
                                        onAudioRecordListener.onStop(file, System.currentTimeMillis() - startRecordTime);
                                    }
                                }
                            });
                        }
                    }
                    mFuture = null;
                } catch (final IOException ignoreException) {
                    throwException(onAudioRecordListener, ignoreException.getMessage());
                } catch (final IllegalStateException ignoreException) {
                    throwException(onAudioRecordListener, ignoreException.getMessage());
                } finally {
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException ignoreException) {
                            throwException(onAudioRecordListener, "record time less than 1 seconds");
                        }
                    }
                    if (audioRecord != null) {
                        audioRecord.stop();
                        audioRecord.release();
                    }
                }
            }
        });
    }

    public void stopRecordAudio() {
        mRecording = false;
    }

    public void cancelRecordAudio() {
        mRecording = false;
        mCancelRecordAudio = true;
    }

    public interface IOnAudioRecordListener {
        void onStart();

        void onError(String errorInfo);

        void onStop(File file, long recordTime);

        void onCancel(File file, long recordTime);
    }
}
