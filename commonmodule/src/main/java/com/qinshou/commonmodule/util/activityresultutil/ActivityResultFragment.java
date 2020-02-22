package com.qinshou.commonmodule.util.activityresultutil;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;

/**
 * Description:启动需要返回结果的 Activity 的无界面的代理 Fragment
 * Created by 禽兽先生
 * Created on 2018/4/18
 */

public class ActivityResultFragment extends Fragment {
    private int mRequestCode;
    private OnActivityResultCallBack mCallBack;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    public void startActivityForResult(Intent intent, int requestCode, OnActivityResultCallBack onActivityResultCallBack) {
        this.mCallBack = onActivityResultCallBack;
        this.mRequestCode = requestCode;
        startActivityForResult(intent, requestCode);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == mRequestCode && mCallBack != null) {
            mCallBack.onActivityResult(requestCode, resultCode, data);
        }
    }
}
