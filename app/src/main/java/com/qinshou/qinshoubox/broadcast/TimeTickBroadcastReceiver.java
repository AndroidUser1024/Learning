package com.qinshou.qinshoubox.broadcast;

import android.annotation.SuppressLint;
import android.app.WallpaperManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;

import com.qinshou.commonmodule.util.ShowLogUtil;
import com.qinshou.qinshoubox.R;

import java.io.IOException;
import java.util.Calendar;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2020/5/18 15:05
 * Description:类描述
 */
public class TimeTickBroadcastReceiver extends BroadcastReceiver {
    @SuppressLint("ResourceType")
    @Override
    public void onReceive(Context context, Intent intent) {
        if (!TextUtils.equals(Intent.ACTION_TIME_TICK, intent.getAction())) {
            return;
        }
        Calendar calendar = Calendar.getInstance();
        int hourOfDay = calendar.get(Calendar.HOUR_OF_DAY);
        ShowLogUtil.logi("hourOfDay--->" + hourOfDay);
        WallpaperManager wallpaperManager = WallpaperManager.getInstance(context);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            try {
                wallpaperManager.setResource(R.drawable.splash_iv_advertisement_src, WallpaperManager.FLAG_LOCK);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
