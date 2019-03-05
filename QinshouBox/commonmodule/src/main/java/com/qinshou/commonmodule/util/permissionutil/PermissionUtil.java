package com.qinshou.commonmodule.util.permissionutil;

import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

/**
 * Description:Android Api 23 以上的系统申请权限的工具类
 * Created by 禽兽先生
 * Created on 2018/4/18
 */
public class PermissionUtil {
    public static void requestPermission(FragmentActivity activity, String permission, IOnRequestPermissionResultCallBack IOnRequestPermissionResultCallBack) {
        requestPermission(activity, new String[]{permission}, IOnRequestPermissionResultCallBack);
    }

    public static void requestPermission(FragmentActivity activity, String[] permissionArray, IOnRequestPermissionResultCallBack IOnRequestPermissionResultCallBack) {
        FragmentManager fragmentManager = activity.getSupportFragmentManager();
        RequestPermissionFragment requestPermissionFragment = (RequestPermissionFragment) fragmentManager.findFragmentByTag(RequestPermissionFragment.class.getSimpleName());
        if (requestPermissionFragment == null) {
            requestPermissionFragment = new RequestPermissionFragment();
            fragmentManager.beginTransaction()
                    .add(requestPermissionFragment, RequestPermissionFragment.class.getSimpleName())
                    .commitAllowingStateLoss();
            fragmentManager.executePendingTransactions();
        }
        requestPermissionFragment.requestPermission(permissionArray, IOnRequestPermissionResultCallBack);
    }
}