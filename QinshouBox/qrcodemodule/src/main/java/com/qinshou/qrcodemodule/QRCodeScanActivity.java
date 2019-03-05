package com.qinshou.qrcodemodule;


import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.Toast;

import com.google.zxing.Result;
import com.qinshou.qrcodemodule.camera.CameraManager;
import com.qinshou.qrcodemodule.constant.Constant;
import com.qinshou.qrcodemodule.decode.DecodeImgCallback;
import com.qinshou.qrcodemodule.decode.DecodeImgThread;
import com.qinshou.qrcodemodule.decode.ImageUtil;
import com.qinshou.qrcodemodule.handler.CaptureHandler;
import com.qinshou.qrcodemodule.manager.BeepManager;
import com.qinshou.qrcodemodule.manager.ConfigManager;
import com.qinshou.qrcodemodule.widget.ViewfinderView;

import java.io.IOException;

/**
 * Create By:禽兽先生
 * Create On:2019-03-05 22:26
 * Description:
 */

public class QRCodeScanActivity extends AppCompatActivity implements ICaptureView {
    private static final String TAG = "QRCodeScanActivity";

    private ViewfinderView mViewfinderView; //二维码扫描控件
    private SurfaceHolder mSurfaceHolder;
    private ConfigManager mConfigManager;   //二维码配置管理者
    private CameraManager mCameraManager;   //相机管理者
    private CaptureHandler mCaptureHandler; //二维码扫描结果的处理者

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qr_code_scan);
        //二维码扫描时摄像头捕捉画面的显示控件
        SurfaceView surfaceView = (SurfaceView) findViewById(R.id.surface_view);
        mSurfaceHolder = surfaceView.getHolder();
        mViewfinderView = (ViewfinderView) findViewById(R.id.viewfinder_view);

        mSurfaceHolder.addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(SurfaceHolder surfaceHolder) {
                mConfigManager = new ConfigManager();
                //设置二维码扫描边框的颜色
                mConfigManager.setReactColor(Color.parseColor("#FF327AF3"));
                //设置二维码扫描线图片
                mConfigManager.setScanLineColor(Color.parseColor("#FF327AF3"));
                mViewfinderView.setConfigManager(mConfigManager);
                mCameraManager = new CameraManager(QRCodeScanActivity.this, mConfigManager);
                mViewfinderView.setCameraManager(mCameraManager);
                mCaptureHandler = null;
                initCamera(surfaceHolder);
            }

            @Override
            public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2) {

            }

            @Override
            public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
                if (mCaptureHandler != null) {
                    mCaptureHandler.quitSynchronously();
                    mCaptureHandler = null;
                }
                if (mCameraManager != null) {
                    mCameraManager.closeDriver();
                    mCameraManager = null;
                }
            }
        });

    }

    @Override
    public ConfigManager getConfigManager() {
        if (mConfigManager == null) {
            //可以对二维码扫描做一些配置
            mConfigManager = new ConfigManager();
        }
        return mConfigManager;
    }

    @Override
    public CameraManager getCameraManager() {
        return mCameraManager;
    }

    @Override
    public CaptureHandler getCaptureHandler() {
        return mCaptureHandler;
    }

    @Override
    public ViewfinderView getViewfinderView() {
        return mViewfinderView;
    }


    @Override
    public void handleDecode(Result rawResult) {
        BeepManager beepManager = new BeepManager(this);
        if (mConfigManager != null) {
            beepManager.setPlayBeep(mConfigManager.isPlayBeep());
            beepManager.setVibrate(mConfigManager.isVibrate());
        }
        beepManager.playBeepSoundAndVibrate();
        Toast.makeText(this, rawResult.getText(), Toast.LENGTH_LONG).show();
        onBackPressed();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == Constant.REQUEST_IMAGE && resultCode == RESULT_OK) {
            String path = ImageUtil.getImageAbsolutePath(this, data.getData());
            new DecodeImgThread(path, new DecodeImgCallback() {
                @Override
                public void onImageDecodeSuccess(Result result) {
                    handleDecode(result);
                }

                @Override
                public void onImageDecodeFailed() {
                    Toast.makeText(QRCodeScanActivity.this, "抱歉,解析失败,换个图片试试.", Toast.LENGTH_SHORT).show();
                }
            }).run();
        }
    }

    /**
     * description:初始化摄像头
     * author:QinHao
     * date:2019/2/26 17:45
     */
    private void initCamera(SurfaceHolder surfaceHolder) {
        if (surfaceHolder == null) {
            throw new IllegalStateException("No SurfaceHolder provided");
        }
        if (mCameraManager.isOpen()) {
            return;
        }
        try {
            // 打开Camera硬件设备
            mCameraManager.openDriver(surfaceHolder);
            // 创建一个handler来打开预览，并抛出一个运行时异常
            if (mCaptureHandler == null) {
                mCaptureHandler = new CaptureHandler(this, mCameraManager);
            }
        } catch (IOException e) {
            Log.e(TAG, e.getMessage());
            showExitDialog();
        } catch (RuntimeException e) {
            Log.e(TAG, e.getMessage());
            showExitDialog();
        }
    }

    /**
     * description:显示退出对话框
     * author:QinHao
     * date:2019/2/26 17:45
     */
    private void showExitDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("扫描二维码出错");
        builder.setPositiveButton("退出", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                onBackPressed();
            }
        });
        builder.setOnCancelListener(new DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialogInterface) {
                onBackPressed();
            }
        });
        builder.show();
    }

}
