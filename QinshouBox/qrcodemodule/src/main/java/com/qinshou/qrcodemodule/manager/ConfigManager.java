package com.qinshou.qrcodemodule.manager;

import android.graphics.Bitmap;
import android.graphics.Color;

/**
 * Description:二维码扫描一些配置参数的管理者类
 * Author: QinHao
 * Date: 2019/2/26 13:49
 */
public class ConfigManager {
    private boolean mPlayBeep = true;  //扫码成功后是否播放声音
    private boolean mVibrate = true; //扫码成功后是否震动
    private boolean mShowFlashLightSwitch = true;  //是否显示闪光灯按钮
    private boolean mShowAlbumButton = true; //是否显示相册按钮
    private boolean mDecodeBarCode = true; //是否解析条形码
    private boolean mFullScreenScan = true;

    private int mReactColor = Color.parseColor("#FFFFFFFF"); //四个角的颜色
    private int mFrameLineColor = Color.parseColor("#00FFFFFF"); //扫描框的颜色
    private int mScanLineColor = Color.parseColor("#FFFFFFFF");  //扫描线
    private Bitmap mScanLineBitmap = null;  //扫描线

    public boolean isPlayBeep() {
        return mPlayBeep;
    }

    public void setPlayBeep(boolean playBeep) {
        mPlayBeep = playBeep;
    }

    public boolean isVibrate() {
        return mVibrate;
    }

    public void setVibrate(boolean vibrate) {
        mVibrate = vibrate;
    }

    public boolean isShowFlashLightSwitch() {
        return mShowFlashLightSwitch;
    }

    public void setShowFlashLightSwitch(boolean showFlashLightSwitch) {
        mShowFlashLightSwitch = showFlashLightSwitch;
    }

    public boolean isShowAlbumButton() {
        return mShowAlbumButton;
    }

    public void setShowAlbumButton(boolean showAlbumButton) {
        mShowAlbumButton = showAlbumButton;
    }

    public boolean isDecodeBarCode() {
        return mDecodeBarCode;
    }

    public void setDecodeBarCode(boolean decodeBarCode) {
        mDecodeBarCode = decodeBarCode;
    }

    public boolean isFullScreenScan() {
        return mFullScreenScan;
    }

    public void setFullScreenScan(boolean fullScreenScan) {
        mFullScreenScan = fullScreenScan;
    }

    public int getReactColor() {
        return mReactColor;
    }

    public void setReactColor(int reactColor) {
        mReactColor = reactColor;
    }

    public int getFrameLineColor() {
        return mFrameLineColor;
    }

    public void setFrameLineColor(int frameLineColor) {
        mFrameLineColor = frameLineColor;
    }

    public int getScanLineColor() {
        return mScanLineColor;
    }

    public void setScanLineColor(int scanLineColor) {
        mScanLineColor = scanLineColor;
    }

    public Bitmap getScanLineBitmap() {
        return mScanLineBitmap;
    }

    public void setScanLineBitmap(Bitmap scanLineBitmap) {
        mScanLineBitmap = scanLineBitmap;
    }
}
