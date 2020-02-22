package com.qinshou.imagemodule.util;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;

import com.qinshou.imagemodule.callback.IOnImageCropResultCallback;
import com.qinshou.imagemodule.fragment.ImageCropResultFragment;

import java.util.ArrayList;

/**
 * Description:图片裁剪工具，使用 'com.yanzhenjie:durban:1.0.1' 第三方库，支持选择、缩放手势，多图裁剪。
 * 裁剪库的参数设置在 ImageCropResultFragment 中的 startActivityForResult() 方法中，可根据需求修改。
 * Created by 禽兽先生
 * Created on 2018/6/12
 */

public class ImageCropUtil {
    public static void cropImage(FragmentActivity activity, ArrayList<String> imagePathList, IOnImageCropResultCallback OnImageCropResultCallback) {
        FragmentManager fragmentManager = activity.getSupportFragmentManager();
        ImageCropResultFragment imageCropResultFragment = (ImageCropResultFragment) fragmentManager.findFragmentByTag(ImageCropResultFragment.class.getSimpleName());
        if (imageCropResultFragment == null) {
            imageCropResultFragment = new ImageCropResultFragment();
            fragmentManager.beginTransaction()
                    .add(imageCropResultFragment, ImageCropResultFragment.class.getSimpleName())
                    .commitAllowingStateLoss();
            fragmentManager.executePendingTransactions();
        }
        imageCropResultFragment.startActivityForResult(imagePathList, OnImageCropResultCallback);
    }
}
