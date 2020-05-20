package com.qinshou.qinshoubox.me.bean.klotski;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.qinshou.qinshoubox.R;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2020/5/20 17:21
 * Description:类描述
 */
public class ZhangFei1 extends KlotskiBean {

    public ZhangFei1(Context context) {
        super("张飞", 1, 2, Type.CAO_CAO);
        Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.klotski_zhang_fei);
        super.bitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight() / 2);
    }
}
