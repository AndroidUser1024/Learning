package com.qinshou.commonmodule.util.activityresultutil;

import android.content.Intent;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;

/**
 * Description:启动需要接收返回结果的 Activity 的工具类
 * Created by 禽兽先生
 * Created on 2018/4/18
 */

public class ActivityResultUtil {
    private static final int REQUEST_CODE = 200;

    public static void startActivityForResult(FragmentActivity activity, Class<?> targetClass, OnActivityResultCallBack onActivityResultCallBack) {
        startActivityForResult(activity, targetClass, REQUEST_CODE, onActivityResultCallBack);
    }

    public static void startActivityForResult(FragmentActivity activity, Class<?> targetClass, int requestCode, OnActivityResultCallBack onActivityResultCallBack) {
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
        activityResultFragment.startActivityForResult(intent, requestCode, onActivityResultCallBack);
    }

    public static void startActivityForResult(FragmentActivity activity, Intent intent, OnActivityResultCallBack onActivityResultCallBack) {
        startActivityForResult(activity, intent, REQUEST_CODE, onActivityResultCallBack);
    }

    public static void startActivityForResult(FragmentActivity activity, Intent intent, int requestCode, OnActivityResultCallBack onActivityResultCallBack) {
        FragmentManager fragmentManager = activity.getSupportFragmentManager();
        ActivityResultFragment activityResultFragment = (ActivityResultFragment) fragmentManager.findFragmentByTag(ActivityResultFragment.class.getSimpleName());
        if (activityResultFragment == null) {
            activityResultFragment = new ActivityResultFragment();
            fragmentManager.beginTransaction()
                    .add(activityResultFragment, ActivityResultFragment.class.getSimpleName())
                    .commitAllowingStateLoss();
            fragmentManager.executePendingTransactions();
        }
        activityResultFragment.startActivityForResult(intent, requestCode, onActivityResultCallBack);
    }
}
