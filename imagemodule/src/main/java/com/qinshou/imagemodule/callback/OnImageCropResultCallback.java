package com.qinshou.imagemodule.callback;

import android.graphics.Bitmap;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 * Created by 禽兽先生
 * Created on 2018/4/20
 */

public interface OnImageCropResultCallback {
    void onSuccess(ArrayList<String> resultsPathList);

    void onSuccess(List<Bitmap> results);
}
