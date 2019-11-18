package com.qinshou.imagemodule.callback;

import android.net.Uri;

import java.util.List;

/**
 * Description:
 * Created by 禽兽先生
 * Created on 2018/4/20
 */

public interface IOnImageChooseResultCallback {
    void onSuccess(List<Uri> uriList);
}
