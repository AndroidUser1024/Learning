package com.qinshou.qinshoubox.me.bean.klotski;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.qinshou.qinshoubox.R;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2020/5/20 17:21
 * Description:张飞2
 */
public class ZhangFei2 extends KlotskiBean {

    public ZhangFei2(Context context) {
        super("张飞", 1, 2, Type.ZHANG_FEI);
        Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.klotski_zhang_fei);
        super.bitmap = Bitmap.createBitmap(bitmap, 0, bitmap.getHeight() / 2, bitmap.getWidth(), bitmap.getHeight() / 2);
    }
}
