package com.qinshou.commonmodule.util;

import android.content.pm.ApplicationInfo;
import android.util.Log;

import com.qinshou.commonmodule.base.BaseApplication;


/**
 * Description:打印日志的工具类
 * 以前日志的开关是 commonmodule.gradle 中配置,如下:
 * buildTypes {
 * debug {
 * buildConfigField 'boolean', 'LOG_SWITCH', 'true'
 * }
 * release {
 * buildConfigField 'boolean', 'LOG_SWITCH', 'false'
 * }
 * }
 * <p>
 * 现在日志开关改为 commonmodule.BuildConfig.DEBUG 常量了,所以上面代码不用配置
 * <p>
 * commonmodule.gradle 的 android{} 层级中需增加 publishNonDefault true
 * <p>
 * 然后依赖 commonmodule 的工程也需要修改
 * 将 compile project(':commonmodule')
 * 改为
 * debugCompile project(path: ':commonmodule', configuration: 'debug')
 * releaseCompile project(path: ':commonmodule', configuration: 'release')
 * <p>
 * Created by 禽兽先生
 * Created on 2017/9/20
 */

public class ShowLogUtil {
    private static String TAG = "daolema";
    private static final int LENGTH = 1024;

    public static void logi(Object log) {
        logi(log.toString());
    }

    public static void logi(String log) {
        logi(TAG, log);
    }

    public static void logi(String tag, String log) {
        if (isDebug()) {
            int a = log.length() / LENGTH;
            int b = log.length() % LENGTH;
            for (int i = 0; i < a; i++) {
                Log.i(tag, log.substring(i * LENGTH, (i + 1) * LENGTH));
            }
            Log.i(tag, log.substring(a * LENGTH, a * LENGTH + b));
        }
    }

    public static void logd(Object log) {
        logd(log.toString());
    }

    public static void logd(String log) {
        logd(TAG, log);
    }

    public static void logd(String tag, String log) {
        if (isDebug()) {
            int a = log.length() / LENGTH;
            int b = log.length() % LENGTH;
            for (int i = 0; i < a; i++) {
                Log.d(tag, log.substring(i * LENGTH, (i + 1) * LENGTH));
            }
            Log.d(tag, log.substring(a * LENGTH, a * LENGTH + b));
        }
    }

    public static void loge(Object log) {
        loge(log.toString());
    }

    public static void loge(String log) {
        loge(TAG, log);
    }

    public static void loge(String tag, String log) {
        if (isDebug()) {
            int a = log.length() / LENGTH;
            int b = log.length() % LENGTH;
            for (int i = 0; i < a; i++) {
                Log.e(tag, log.substring(i * LENGTH, (i + 1) * LENGTH));
            }
            Log.e(tag, log.substring(a * LENGTH, a * LENGTH + b));
        }
    }

    private static boolean isDebug() {
        try {
            ApplicationInfo info = BaseApplication.getInstance().getApplicationInfo();
            return (info.flags & ApplicationInfo.FLAG_DEBUGGABLE) != 0;
        } catch (Exception e) {
            return false;
        }
    }
}
