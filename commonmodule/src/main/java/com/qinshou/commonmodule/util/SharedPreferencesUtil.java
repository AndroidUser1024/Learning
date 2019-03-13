package com.qinshou.commonmodule.util;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Description:存储 SharedPreferences 的工具类
 * Created by 禽兽先生
 * Created on 2018/1/9
 */

public class SharedPreferencesUtil {
    public static void putInt(Context context, String key, int value) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(context.getApplicationInfo().processName, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(key, value);
        editor.apply();
    }

    public static int getInt(Context context, String key) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(context.getApplicationInfo().processName, Context.MODE_PRIVATE);
        return sharedPreferences.getInt(key, -1);
    }

    public static void putString(Context context, String key, String value) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(context.getApplicationInfo().processName, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, value);
        editor.apply();
    }

    public static String getString(Context context, String key) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(context.getApplicationInfo().processName, Context.MODE_PRIVATE);
        return sharedPreferences.getString(key, null);
    }

    public static void remove(Context context, String key) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(context.getApplicationInfo().processName, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.remove(key);
        editor.apply();
    }
}