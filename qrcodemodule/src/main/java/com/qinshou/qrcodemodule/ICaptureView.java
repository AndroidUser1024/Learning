package com.qinshou.qrcodemodule;

import com.google.zxing.Result;
import com.qinshou.qrcodemodule.camera.CameraManager;
import com.qinshou.qrcodemodule.handler.CaptureHandler;
import com.qinshou.qrcodemodule.manager.ConfigManager;
import com.qinshou.qrcodemodule.widget.ViewfinderView;

/**
 * Description:类描述
 * Author: QinHao
 * Date: 2019/2/26 14:42
 */
public interface ICaptureView {
    //初始化 ConfigManager 对象
    ConfigManager getConfigManager();

    //初始化 CameraManager 对象
    CameraManager getCameraManager();

    //初始化 CaptureHandler 对象
    CaptureHandler getCaptureHandler();

    //初始化 ViewfinderView 对象
    ViewfinderView getViewfinderView();

    //处理二维码扫描结果
    void handleDecode(Result rawResult);
}
