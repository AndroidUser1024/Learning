/*
 * Copyright (C) 2008 ZXing authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.qinshou.qrcodemodule.handler;

import android.os.Handler;
import android.os.Message;

import com.google.zxing.Result;
import com.qinshou.qrcodemodule.ICaptureView;
import com.qinshou.qrcodemodule.camera.CameraManager;
import com.qinshou.qrcodemodule.constant.Constant;
import com.qinshou.qrcodemodule.decode.DecodeThread;
import com.qinshou.qrcodemodule.widget.ViewfinderResultPointCallback;


/**
 * This class handles all the messaging which comprises the state machine for
 * capture. 该类用于处理有关拍摄状态的所有信息
 *
 * @author dswitkin@google.com (Daniel Switkin)
 */
public final class CaptureHandler extends Handler {
    private static final String TAG = CaptureHandler.class.getSimpleName();

    private final ICaptureView mCaptureView;
    private final DecodeThread mDecodeThread;
    private State mState;
    private final CameraManager cameraManager;

    private enum State {
        PREVIEW, SUCCESS, DONE
    }

    public CaptureHandler(ICaptureView captureView, CameraManager cameraManager) {
        this.mCaptureView = captureView;
        mDecodeThread = new DecodeThread(captureView, new ViewfinderResultPointCallback(captureView.getViewfinderView()));
        mDecodeThread.start();
        mState = State.SUCCESS;

        // Start ourselves capturing previews and decoding.
        // 开始拍摄预览和解码
        this.cameraManager = cameraManager;
        cameraManager.startPreview();
        restartPreviewAndDecode();
    }

    @Override
    public void handleMessage(Message message) {
        switch (message.what) {
            case Constant.RESTART_PREVIEW:
                // 重新预览
                restartPreviewAndDecode();
                break;
            case Constant.DECODE_SUCCEEDED:
                // 解码成功
                mState = State.SUCCESS;
                mCaptureView.handleDecode((Result) message.obj);
                break;
            case Constant.DECODE_FAILED:
                // 尽可能快的解码，以便可以在解码失败时，开始另一次解码
                mState = State.PREVIEW;
                cameraManager.requestPreviewFrame(mDecodeThread.getHandler(), Constant.DECODE);
                break;
        }
    }

    /**
     * description:完全退出
     * author:QinHao
     * date:2019/2/26 16:47
     */
    public void quitSynchronously() {
        mState = State.DONE;
        cameraManager.stopPreview();
        Message quit = Message.obtain(mDecodeThread.getHandler(), Constant.QUIT);
        quit.sendToTarget();
        try {
            // Wait at most half a second; should be enough time, and onPause()
            // will timeout quickly
            mDecodeThread.join(500L);
        } catch (InterruptedException e) {
            // continue
        }
        // Be absolutely sure we don't send any queued up messages
        //确保不会发送任何队列消息
        removeMessages(Constant.DECODE_SUCCEEDED);
        removeMessages(Constant.DECODE_FAILED);
    }

    /**
     * description:重新开始预览和解码
     * author:QinHao
     * date:2019/2/26 17:42
     */
    public void restartPreviewAndDecode() {
        if (mState == State.SUCCESS) {
            mState = State.PREVIEW;
            cameraManager.requestPreviewFrame(mDecodeThread.getHandler(), Constant.DECODE);
            mCaptureView.getViewfinderView().drawViewfinder();
        }
    }
}
