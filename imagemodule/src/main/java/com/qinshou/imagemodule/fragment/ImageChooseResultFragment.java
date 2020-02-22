package com.qinshou.imagemodule.fragment;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import com.qinshou.imagemodule.R;
import com.qinshou.imagemodule.callback.IOnImageChooseResultCallback;
import com.qinshou.imagemodule.imageengine.Glide4Engine;
import com.zhihu.matisse.Matisse;
import com.zhihu.matisse.MimeType;
import com.zhihu.matisse.internal.entity.CaptureStrategy;

import java.util.List;

import static android.app.Activity.RESULT_OK;

/**
 * Description:选择图片的结果的无界面的代理 Fragment
 * Created by 禽兽先生
 * Created on 2018/4/18
 */

public class ImageChooseResultFragment extends Fragment {
    public static final int REQUEST_CODE = 200;
    //    public static final int RESULT_CODE = 201;
    private IOnImageChooseResultCallback mCallBack;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    public void startActivityForResult(int maxSize, boolean capture, IOnImageChooseResultCallback onImageChooseResultCallback) {
        this.mCallBack = onImageChooseResultCallback;
        Matisse.from(this)
                // 设置可选择图片类型
                .choose(MimeType.ofImage())
                .theme(R.style.Matisse_Dracula) //主题有两个 蓝色 R.style.Matisse_Zhihu |黑暗 R.style.Matisse_Dracula
                .countable(true)
                //最大选中张数
                .maxSelectable(maxSize)
                //图片引擎，知乎内部集成的 Glide3，所以如果图片加载库使用 Glide4 的话需自定义引擎
                .imageEngine(new Glide4Engine())
                .thumbnailScale(0.85f)
                //设置允许拍照
                .capture(capture)
                //设置拍照策略，如果允许拍照则必须进行该设置
                .captureStrategy(new CaptureStrategy(true, getContext().getApplicationInfo().processName + ".fileProvider"))
                .restrictOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED)
                .forResult(REQUEST_CODE);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE
                && resultCode == RESULT_OK
                && mCallBack != null) {
            List<Uri> uriList = Matisse.obtainResult(data);
            mCallBack.onSuccess(uriList);
        }
    }
}
