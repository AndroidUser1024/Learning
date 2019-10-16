package com.qinshou.commonmodule.base;

import android.app.Activity;
import android.app.Application;
import android.content.Context;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:Application 的基类
 * Created by 禽兽先生
 * Created on 2018/6/1
 */

public class BaseApplication extends Application {
    private static BaseApplication instance;
    private List<Activity> mActivityList = new ArrayList<>();

    public static synchronized BaseApplication getInstance() {
        return instance;
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    public List<Activity> getActivityList() {
        return mActivityList;
    }

    public void addActivity(Activity activity) {
        if (!mActivityList.contains(activity)) {
            mActivityList.add(activity);
        }
    }

    public void removeActivity(Activity activity) {
        if (mActivityList.contains(activity)) {
            mActivityList.remove(activity);
        }
    }

    public void exit() {
        for (Activity activity : mActivityList) {
            if (activity != null) {
                activity.finish();
            }
        }
    }
}