package com.qinshou.commonmodule.util;

import android.content.Context;
import android.content.SharedPreferences;


/**
 * Description:存储 SharedPreferences 的工具类
 * Created by 禽兽先生
 * Created on 2018/1/9
 */

public enum SharedPreferencesHelper2 {
    SINGLETON;

    private SharedPreferences mSharedPreferences;

    SharedPreferencesHelper2() {

    }

    public void init(Context context,String name) {
        mSharedPreferences = context.getSharedPreferences(name, Context.MODE_PRIVATE);
    }

    public void putInt(String key, int value) {
        if (mSharedPreferences == null) {
            throw new NullPointerException("please call init first");
        }
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putInt(key, value);
        editor.apply();
    }

    public int getInt(String key) {
        if (mSharedPreferences == null) {
            throw new NullPointerException("please call init first");
        }
        return mSharedPreferences.getInt(key, -1);
    }

    public int getInt(String key, int defaultValue) {
        if (mSharedPreferences == null) {
            throw new NullPointerException("please call init first");
        }
        return mSharedPreferences.getInt(key, defaultValue);
    }

    public void putString(String key, String value) {
        if (mSharedPreferences == null) {
            throw new NullPointerException("please call init first");
        }
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putString(key, value);
        editor.apply();
    }

    public String getString(String key) {
        if (mSharedPreferences == null) {
            throw new NullPointerException("please call init first");
        }
        return mSharedPreferences.getString(key, null);
    }

    public String getString(String key, String defaultVaule) {
        if (mSharedPreferences == null) {
            throw new NullPointerException("please call init first");
        }
        return mSharedPreferences.getString(key, defaultVaule);
    }

    public void putLong(String key, long value) {
        if (mSharedPreferences == null) {
            throw new NullPointerException("please call init first");
        }
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putLong(key, value);
        editor.apply();
    }

    public long getLong(String key) {
        if (mSharedPreferences == null) {
            throw new NullPointerException("please call init first");
        }
        return mSharedPreferences.getLong(key, -1);
    }

    public void putBoolean(String key, boolean value) {
        if (mSharedPreferences == null) {
            throw new NullPointerException("please call init first");
        }
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putBoolean(key, value);
        editor.apply();
    }

    public boolean getBoolean(String key) {
        if (mSharedPreferences == null) {
            throw new NullPointerException("please call init first");
        }
        return mSharedPreferences.getBoolean(key, false);
    }

    /**
     * Author: QinHao
     * Email:qinhao@jeejio.com
     * Date:2019/11/5 16:45
     * Description:是否有存储某个 key
     */
    public boolean contains(String key) {
        if (mSharedPreferences == null) {
            throw new NullPointerException("please call init first");
        }
        return mSharedPreferences.contains(key);
    }

    public void remove(String key) {
        if (mSharedPreferences == null) {
            throw new NullPointerException("please call init first");
        }
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.remove(key);
        editor.apply();
    }

    public void clearAll() {
        if (mSharedPreferences == null) {
            throw new NullPointerException("please call init first");
        }
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.clear();
        editor.apply();
    }
}