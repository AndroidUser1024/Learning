package com.qinshou.commonmodule.util.activityresultutil;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

/**
 * Description:启动需要接收返回结果的 Activity 的工具类
 * Created by 禽兽先生
 * Created on 2018/4/18
 */

public class ActivityResultUtil {
    public static void startActivityForResult(AppCompatActivity activity,Class<?> targetClass,OnActivityResultCallBack onActivityResultCallBack) {
        FragmentManager fragmentManager = activity.getSupportFragmentManager();
        ActivityResultFragment activityResultFragment = (ActivityResultFragment) fragmentManager.findFragmentByTag(ActivityResultFragment.class.getSimpleName());
        if (activityResultFragment == null) {
            activityResultFragment = new ActivityResultFragment();
            fragmentManager.beginTransaction()
                    .add(activityResultFragment, ActivityResultFragment.class.getSimpleName())
                    .commitAllowingStateLoss();
            fragmentManager.executePendingTransactions();
        }
        Intent intent = new Intent(activity, targetClass);
        activityResultFragment.startActivityForResult(intent, onActivityResultCallBack);
    }
}
