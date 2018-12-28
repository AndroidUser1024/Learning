package com.qinshou.commonmodule.util.permissionutil;

import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;

import java.util.LinkedList;
import java.util.List;

/**
 * Description:申请回调的无界面的代理 Fragment
 * Created by 禽兽先生
 * Created on 2018/4/18
 */
public class RequestPermissionFragment extends Fragment {
    private static final int REQUEST_CODE = 200;
    private OnRequestPermissionResultCallBack mCallBack;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    public void requestPermission(String[] permissionArray, OnRequestPermissionResultCallBack onRequestPermissionResultCallBack) {
        this.mCallBack = onRequestPermissionResultCallBack;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(permissionArray, REQUEST_CODE);
        } else {
            boolean allPermissionGranted = true;
            List<String> deniedPermissionList = new LinkedList<>();
            for (int i = 0; i < permissionArray.length; i++) {
                int grantResult = ContextCompat.checkSelfPermission(getContext(), permissionArray[i]);
                if (grantResult == PackageManager.PERMISSION_DENIED) {
                    allPermissionGranted = false;
                    deniedPermissionList.add(permissionArray[i]);
                }
            }
            if (mCallBack != null) {
                if (allPermissionGranted) {
                    mCallBack.onSuccess();
                } else {
                    mCallBack.onError(deniedPermissionList);
                }
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_CODE && mCallBack != null) {
            boolean allPermissionGranted = true;
            List<String> deniedPermissionList = new LinkedList<>();
            for (int i = 0; i < grantResults.length; i++) {
                if (grantResults[i] == PackageManager.PERMISSION_DENIED) {
                    allPermissionGranted = false;
                    deniedPermissionList.add(permissions[i]);
                }
            }
            if (allPermissionGranted) {
                mCallBack.onSuccess();
            } else {
                mCallBack.onError(deniedPermissionList);
            }
        }
    }
}
