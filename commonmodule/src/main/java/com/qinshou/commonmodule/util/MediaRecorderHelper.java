package com.qinshou.commonmodule.util;

import android.app.Activity;
import android.hardware.Camera;
import android.media.MediaRecorder;
import android.os.Handler;
import android.view.Surface;
import android.view.SurfaceHolder;

import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Description:MediaRecorder 录音工具类
 * Author: QinHao
 * Date: 2019/4/11 10:35
 */
public enum MediaRecorderHelper {
    SINGLETON;

    private static final String TAG = "MediaRecorderHelper";
    /**
     * 振幅范围的最大值,监听振幅时可以根据该值来计算音量等级
     */
    public static final int MAX_AMPLITUDE = 32767;
    private ExecutorService mExecutorService;   //录音 JNI 函数不具备线程安全性,所以要用单线程
    private MediaRecorder mMediaRecorder;   //录音类
    private long mStartRecordTime;  //开始录音的时间
    private IOnMediaRecorderListener mOnMediaRecorderListener;
    private File mFile;
    /**
     * 子线程中执行任务的 Handler
     */
    private Handler mHandler;
    private AutoFocusRunnable mAutoFocusRunnable;
    private GetCurrentVolumeRunnable mGetCurrentVolumeRunnable;

    MediaRecorderHelper() {
        mExecutorService = Executors.newSingleThreadExecutor();
        mHandler = new Handler();
    }

    /**
     * Create By:禽兽先生
     * Description: 释放资源
     */
    private void releaseMediaRecorder() {
        if (mMediaRecorder != null) {
            mMediaRecorder.release();
            mMediaRecorder = null;
        }
        if (mAutoFocusRunnable != null) {
            mHandler.removeCallbacks(mAutoFocusRunnable);
            mAutoFocusRunnable = null;
        }
        if (mGetCurrentVolumeRunnable != null) {
            mHandler.removeCallbacks(mGetCurrentVolumeRunnable);
            mGetCurrentVolumeRunnable = null;
        }
        mOnMediaRecorderListener = null;
    }

    /**
     * description:计算相机预览应该旋转的角度
     * author:QinHao
     * date:2019/4/16 18:02
     */
    private int calculateCameraPreviewRotation(Activity activity, int cameraId) {
        Camera.CameraInfo info = new Camera.CameraInfo();
        Camera.getCameraInfo(cameraId, info);
        int rotation = activity.getWindowManager().getDefaultDisplay().getRotation();
        int degrees = 0;
        switch (rotation) {
            case Surface.ROTATION_0:
                degrees = 0;
                break;
            case Surface.ROTATION_90:
                degrees = 90;
                break;
            case Surface.ROTATION_180:
                degrees = 180;
                break;
            case Surface.ROTATION_270:
                degrees = 270;
                break;
        }

        int result;
        if (info.facing == Camera.CameraInfo.CAMERA_FACING_FRONT) {
            result = (info.orientation + degrees) % 360;
            result = (360 - result) % 360;
        } else {
            result = (info.orientation - degrees + 360) % 360;
        }
        return result;
    }

    /**
     * description:自动对焦的 Runnable
     * author:QinHao
     * date:2019/4/17 19:38
     */
    private class AutoFocusRunnable implements Runnable {
        private Camera mCamera;

        public AutoFocusRunnable(Camera camera) {
            mCamera = camera;
        }

        @Override
        public void run() {
            if (mCamera == null) {
                return;
            }
            mCamera.autoFocus(mAutoFocusCallback);
        }
    }

    /**
     * description:自动对焦的回调
     * author:QinHao
     * date:2019/4/16 16:40
     */
    private Camera.AutoFocusCallback mAutoFocusCallback = new Camera.AutoFocusCallback() {
        @Override
        public void onAutoFocus(boolean success, Camera camera) {
            // 每隔 0.5s 自动对焦一次
            if (mAutoFocusRunnable != null) {
                mHandler.postDelayed(mAutoFocusRunnable, 500);
            }
        }
    };

    /**
     * Author: QinHao
     * Email:qinhao@jeejio.com
     * Date:2019/6/5 16:05
     * Description:获取当前录音来源的音量,不知道是否是只有录音来源为麦克风时才有效
     * 音量范围 0-32767
     */
    private class GetCurrentVolumeRunnable implements Runnable {

        @Override
        public void run() {
            if (mMediaRecorder == null || mOnMediaRecorderListener == null) {
                return;
            }
            int maxAmplitude = mMediaRecorder.getMaxAmplitude();
            mOnMediaRecorderListener.onVolumeChange(maxAmplitude);
            // 每隔 100ms 获取一次
            mHandler.postDelayed(this, 100);
        }
    }

    /**
     * Create By:禽兽先生
     * Description: 开始录音
     */
    public void startRecordAudio(File file, final IOnMediaRecorderListener onMediaRecorderListener) {
        mFile = file;
        // 开始录音任务
        mExecutorService.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    // 释放之前的 Recorder
                    releaseMediaRecorder();
                    mOnMediaRecorderListener = onMediaRecorderListener;
                    // 创建录音文件
                    if (!mFile.exists()) {
                        mFile.getParentFile().mkdirs();
                    }
                    mFile.createNewFile();
                    // 创建 MediaRecorder
                    mMediaRecorder = new MediaRecorder();

                    // 配置 MediaRecorder
                    // 设置音频来源
                    mMediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
                    // 设置音频格式
                    mMediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.MPEG_4);
                    // 设置音频采样率
                    mMediaRecorder.setAudioSamplingRate(44100);
                    // 设置音频编码格式
                    mMediaRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AAC);
                    // 设置音频编码频率
                    mMediaRecorder.setAudioEncodingBitRate(96000);
                    // 设置音频输出文件
                    mMediaRecorder.setOutputFile(mFile.getAbsolutePath());

                    // 开始录音
                    mMediaRecorder.prepare();
                    mMediaRecorder.start();
                    // 记录开始录音的时间
                    mStartRecordTime = System.currentTimeMillis();
                    if (mOnMediaRecorderListener != null) {
                        mOnMediaRecorderListener.onStart();
                    }
                    if (mGetCurrentVolumeRunnable == null) {
                        mGetCurrentVolumeRunnable = new GetCurrentVolumeRunnable();
                        mHandler.post(mGetCurrentVolumeRunnable);
                    }
                } catch (final Exception e) {
                    e.printStackTrace();
                    if (mOnMediaRecorderListener != null) {
                        mOnMediaRecorderListener.onError(e.getMessage());
                    }
                    releaseMediaRecorder();
                }
            }
        });
    }

    public void startRecordVideo(final Activity activity, final int cameraId, final SurfaceHolder surfaceHolder, File file, final IOnMediaRecorderListener onMediaRecorderListener) {
        if (surfaceHolder == null) {
            return;
        }
        mFile = file;
        // 开始录音任务
        mExecutorService.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    // 释放之前的 Recorder
                    releaseMediaRecorder();
                    mOnMediaRecorderListener = onMediaRecorderListener;
                    // 创建录音文件
                    if (!mFile.exists()) {
                        mFile.getParentFile().mkdirs();
                        mFile.createNewFile();
                    }
                    // 创建 MediaRecorder
                    mMediaRecorder = new MediaRecorder();

                    Camera camera = Camera.open(cameraId);
                    // 摄像头进行旋转 90 度
                    camera.setDisplayOrientation(calculateCameraPreviewRotation(activity, 0));
                    camera.unlock();

                    // 配置 MediaRecorder
                    mMediaRecorder.setCamera(camera);
                    // 设置视频来源
                    mMediaRecorder.setVideoSource(MediaRecorder.VideoSource.CAMERA);
                    // 设置视频格式
                    mMediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.MPEG_4);
                    // 设置编码比特率,不设置会使视频图像模糊
                    mMediaRecorder.setVideoEncodingBitRate(1920 * 1080 * 2);
                    // 设置视频编码格式
                    mMediaRecorder.setVideoEncoder(MediaRecorder.VideoEncoder.H264);
                    // 设置视频录制分辨率
                    mMediaRecorder.setVideoSize(1920, 1080);
                    // 设置视频录制帧率
                    mMediaRecorder.setVideoFrameRate(20);
                    // 设置视频录制预览的 SurfaceHolder
                    mMediaRecorder.setPreviewDisplay(surfaceHolder.getSurface());
                    // 设置视频旋转90度，这里是录制的视频文件旋转 90 度
                    mMediaRecorder.setOrientationHint(calculateCameraPreviewRotation(activity, 0));
                    // 设置视频输出文件
                    mMediaRecorder.setOutputFile(mFile.getAbsolutePath());

                    // 开始录制
                    mMediaRecorder.prepare();
                    mMediaRecorder.start();
                    // 记录开始录制的时间
                    mStartRecordTime = System.currentTimeMillis();
                    if (mOnMediaRecorderListener != null) {
                        mOnMediaRecorderListener.onStart();
                    }
                    if (mAutoFocusRunnable == null) {
                        mAutoFocusRunnable = new AutoFocusRunnable(camera);
                        mHandler.post(mAutoFocusRunnable);
                    }
                } catch (final Exception e) {
                    e.printStackTrace();
                    if (mOnMediaRecorderListener != null) {
                        mOnMediaRecorderListener.onError(e.getMessage());
                    }
                    releaseMediaRecorder();
                }
            }
        });
    }

    /**
     * Create By:禽兽先生
     * Description: 停止录音
     */
    public void stopRecord() {
        mExecutorService.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    // 停止录音
                    if (mMediaRecorder == null) {
                        return;
                    }
                    mMediaRecorder.stop();
                    mMediaRecorder.reset();
                    if (mOnMediaRecorderListener != null) {
                        if (System.currentTimeMillis() - mStartRecordTime < 1000) {
                            mOnMediaRecorderListener.onError("record time less than 1 seconds");
                        } else {
                            mOnMediaRecorderListener.onStop(mFile, System.currentTimeMillis() - mStartRecordTime);
                        }
                    }
                } catch (final Exception e) {
                    e.printStackTrace();
                    if (mOnMediaRecorderListener != null) {
                        mOnMediaRecorderListener.onError(e.getMessage());
                    }
                } finally {
                    releaseMediaRecorder();
                }
            }
        });
    }

    public interface IOnMediaRecorderListener {
        void onStart();

        void onError(String errorInfo);

        void onStop(File file, long recordTime);

        void onVolumeChange(int currentVolume);
    }
}
