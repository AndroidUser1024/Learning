package com.qinshou.imagemodule.callback;

import android.graphics.drawable.Drawable;

/**
 * Description:异步加载图片的回调接口
 * Created by 禽兽先生
 * Created on 2018/3/5
 */

public interface IOnGetImgCallback {
    void onSuccess(Drawable drawable);

    void onFailure(String error, Drawable errorDrawable);
}
