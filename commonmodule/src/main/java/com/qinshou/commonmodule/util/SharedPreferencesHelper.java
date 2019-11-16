package com.qinshou.commonmodule.util;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Description:存储 SharedPreferences 的工具类
 * Created by 禽兽先生
 * Created on 2018/1/9
 */

public enum SharedPreferencesHelper {
    SINGLETON;
    /**
     * 上下文
     */
    private Context mContext;

    SharedPreferencesHelper() {

    }

    public void init(Context context) {
        mContext = context;
    }

    public void putInt(String key, int value) {
        if (mContext == null) {
            throw new NullPointerException("please call init first");
        }
        SharedPreferences sharedPreferences = mContext.getSharedPreferences(mContext.getApplicationInfo().processName, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(key, value);
        editor.apply();
    }

    public int getInt(String key) {
        if (mContext == null) {
            throw new NullPointerException("please call init first");
        }
        SharedPreferences sharedPreferences = mContext.getSharedPreferences(mContext.getApplicationInfo().processName, Context.MODE_PRIVATE);
        return sharedPreferences.getInt(key, -1);
    }

    public void putString(String key, String value) {
        if (mContext == null) {
            throw new NullPointerException("please call init first");
        }
        SharedPreferences sharedPreferences = mContext.getSharedPreferences(mContext.getApplicationInfo().processName, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, value);
        editor.apply();
    }

    public String getString(String key) {
        if (mContext == null) {
            throw new NullPointerException("please call init first");
        }
        SharedPreferences sharedPreferences = mContext.getSharedPreferences(mContext.getApplicationInfo().processName, Context.MODE_PRIVATE);
        return sharedPreferences.getString(key, null);
    }

    public void putBoolean(String key, boolean value) {
        if (mContext == null) {
            throw new NullPointerException("please call init first");
        }
        SharedPreferences sharedPreferences = mContext.getSharedPreferences(mContext.getApplicationInfo().processName, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(key, value);
        editor.apply();
    }

    public boolean getBoolean(String key) {
        if (mContext == null) {
            throw new NullPointerException("please call init first");
        }
        SharedPreferences sharedPreferences = mContext.getSharedPreferences(mContext.getApplicationInfo().processName, Context.MODE_PRIVATE);
        return sharedPreferences.getBoolean(key, false);
    }

    /**
     * Author: QinHao
     * Email:qinhao@jeejio.com
     * Date:2019/11/5 16:45
     * Description:是否有存储某个 key
     */
    public boolean contains(String key) {
        if (mContext == null) {
            throw new NullPointerException("please call init first");
        }
        SharedPreferences sharedPreferences = mContext.getSharedPreferences(mContext.getApplicationInfo().processName, Context.MODE_PRIVATE);
        return sharedPreferences.contains(key);
    }

    public void remove(String key) {
        if (mContext == null) {
            throw new NullPointerException("please call init first");
        }
        SharedPreferences sharedPreferences = mContext.getSharedPreferences(mContext.getApplicationInfo().processName, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.remove(key);
        editor.apply();
    }
}