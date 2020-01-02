package com.qinshou.imagemodule.util;

import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

import com.qinshou.imagemodule.callback.IOnImageChooseResultCallback;
import com.qinshou.imagemodule.fragment.ImageChooseResultFragment;


/**
 * Description:图片选择的工具类,使用知乎开源的图片选择库,仿微信朋友圈选择手机内图片,可增加拍照功能
 * 知乎图片选择库的参数设置在 ImageChooseResultFragment 中的 startActivityForResult() 方法中，可根据需求修改
 * Created by 禽兽先生
 * Created on 2018/4/18
 */

public class ImageChooseUtil {
    public static void chooseImage(FragmentActivity activity, IOnImageChooseResultCallback OnImageChooseResultCallback) {
        chooseImage(activity, 1, false, OnImageChooseResultCallback);
    }

    public static void chooseImage(FragmentActivity activity, int maxSize, IOnImageChooseResultCallback OnImageChooseResultCallback) {
        chooseImage(activity, maxSize, false, OnImageChooseResultCallback);
    }

    public static void chooseImage(FragmentActivity activity, boolean capture, IOnImageChooseResultCallback OnImageChooseResultCallback) {
        chooseImage(activity, 1, capture, OnImageChooseResultCallback);
    }

    public static void chooseImage(FragmentActivity activity, int maxSize, boolean capture, IOnImageChooseResultCallback OnImageChooseResultCallback) {
        FragmentManager fragmentManager = activity.getSupportFragmentManager();
        ImageChooseResultFragment imageChooseResultFragment = (ImageChooseResultFragment) fragmentManager.findFragmentByTag(ImageChooseResultFragment.class.getSimpleName());
        if (imageChooseResultFragment == null) {
            imageChooseResultFragment = new ImageChooseResultFragment();
            fragmentManager.beginTransaction()
                    .add(imageChooseResultFragment, ImageChooseResultFragment.class.getSimpleName())
                    .commitAllowingStateLoss();
            fragmentManager.executePendingTransactions();
        }
        imageChooseResultFragment.startActivityForResult(maxSize, capture, OnImageChooseResultCallback);
    }
}
