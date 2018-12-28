package com.qinshou.imagemodule.callback;

import android.graphics.Bitmap;

/**
 * Description:异步加载图片的回调接口
 * Created by 禽兽先生
 * Created on 2018/3/5
 */

public interface OnGetImageCallback {
    void onSuccess(Bitmap bitmap);

    void onFailure(String error, Bitmap errorBitmap);
}
