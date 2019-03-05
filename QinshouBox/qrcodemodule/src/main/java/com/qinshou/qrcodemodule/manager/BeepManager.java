/*
 * Copyright (C) 2010 ZXing authors
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

package com.qinshou.qrcodemodule.manager;

import android.app.Activity;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.os.Vibrator;
import android.util.Log;

import com.qinshou.qrcodemodule.R;

import java.io.IOException;

/**
 * Description:扫描二维码成功后声音和震动的管理者类
 * Author: QinHao
 * Date: 2019/2/26 13:49
 */
public final class BeepManager {
    private static final String TAG = "BeepManager";

    private static final float BEEP_VOLUME = 0.10f;
    private static final long VIBRATE_DURATION = 200L;

    private Activity mActivity;
    private boolean mPlayBeep;
    private boolean mVibrate;

    public BeepManager(Activity activity) {
        this.mActivity = activity;
    }

    public void setPlayBeep(boolean playBeep) {
        this.mPlayBeep = playBeep;
    }

    public void setVibrate(boolean vibrate) {
        this.mVibrate = vibrate;
    }

    /**
     * description:播放声音和开启震动
     * author:QinHao
     * date:2019/2/26 16:19
     */
    public void playBeepSoundAndVibrate() {
        if (mPlayBeep) {
            MediaPlayer mediaPlayer = new MediaPlayer();
            AssetFileDescriptor assetFileDescriptor = mActivity.getResources().openRawResourceFd(R.raw.beep);
            try {
                mediaPlayer.setDataSource(assetFileDescriptor.getFileDescriptor(), assetFileDescriptor.getStartOffset(), assetFileDescriptor.getLength());
                mediaPlayer.setVolume(BEEP_VOLUME, BEEP_VOLUME);
                mediaPlayer.prepareAsync();
                assetFileDescriptor.close();
                mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                    @Override
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        mediaPlayer.start();
                    }
                });
            } catch (IOException e) {
                e.printStackTrace();
                mediaPlayer.release();
            }
            // 监听是否播放完成
            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    mediaPlayer.release();
                }
            });
            mediaPlayer.setOnErrorListener(new MediaPlayer.OnErrorListener() {
                @Override
                public boolean onError(MediaPlayer mediaPlayer, int what, int extra) {
                    Log.e(TAG, "播放声音错误");
                    mediaPlayer.release();
                    return true;
                }
            });
        }
        if (mVibrate) {
            Vibrator vibrator = (Vibrator) mActivity.getSystemService(Context.VIBRATOR_SERVICE);
            if (vibrator != null) {
                vibrator.vibrate(VIBRATE_DURATION);
            }
        }
    }
}
