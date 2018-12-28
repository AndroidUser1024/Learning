package com.qinshou.commonmodule.util;

import android.util.Log;

import com.qinshou.commonmodule.BuildConfig;


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

    public static void logi(String log) {
        if (BuildConfig.DEBUG) {
            Log.i(TAG, log);
        }
    }

    public static void logi(Object log) {
        logi(log.toString());
    }

    private static void logd(String log) {
        if (BuildConfig.DEBUG) {
            Log.d(TAG, log);
        }
    }

    public static void logd(Object log) {
        logd(String.valueOf(log));
    }

    private static void loge(String log) {
        if (BuildConfig.DEBUG) {
            Log.e(TAG, log);
        }
    }

    public static void loge(Object log) {
        loge(String.valueOf(log));
    }

}
