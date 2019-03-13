package com.qinshou.commonmodule.util.activityresultutil;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;

/**
 * Description:启动需要返回结果的 Activity 的无界面的代理 Fragment
 * Created by 禽兽先生
 * Created on 2018/4/18
 */

public class ActivityResultFragment extends Fragment {
    private static final int REQUEST_CODE = 200;
    private OnActivityResultCallBack mCallBack;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    public void startActivityForResult(Intent intent, OnActivityResultCallBack onActivityResultCallBack) {
        this.mCallBack = onActivityResultCallBack;
        startActivityForResult(intent, REQUEST_CODE);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE && mCallBack != null) {
            mCallBack.onActivityResult(data);
        }
    }

}
