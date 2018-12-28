package com.qinshou.commonmodule.util.permissionutil;

import android.content.pm.PackageManager;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

/**
 * Description:Android Api 23 以上的系统申请权限的工具类
 * Created by 禽兽先生
 * Created on 2018/4/18
 */
public class PermissionUtil {
    public static final int REQUEST_PERMISSION_SUCCESS = PackageManager.PERMISSION_GRANTED;
    public static final int REQUEST_PERMISSION_FAIL = PackageManager.PERMISSION_DENIED;

    public static void requestPermission(FragmentActivity activity, String permission, OnRequestPermissionResultCallBack onRequestPermissionResultCallBack) {
        requestPermission(activity, new String[]{permission}, onRequestPermissionResultCallBack);
    }

    public static void requestPermission(FragmentActivity activity, String[] permissionArray, OnRequestPermissionResultCallBack onRequestPermissionResultCallBack) {
        FragmentManager fragmentManager = activity.getSupportFragmentManager();
        RequestPermissionFragment requestPermissionFragment = (RequestPermissionFragment) fragmentManager.findFragmentByTag(RequestPermissionFragment.class.getSimpleName());
        if (requestPermissionFragment == null) {
            requestPermissionFragment = new RequestPermissionFragment();
            fragmentManager.beginTransaction()
                    .add(requestPermissionFragment, RequestPermissionFragment.class.getSimpleName())
                    .commitAllowingStateLoss();
            fragmentManager.executePendingTransactions();
        }
        requestPermissionFragment.requestPermission(permissionArray, onRequestPermissionResultCallBack);
    }
}