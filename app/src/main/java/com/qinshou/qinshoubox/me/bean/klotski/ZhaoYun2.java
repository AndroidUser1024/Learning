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
public class ZhaoYun2 extends KlotskiBean {

    public ZhaoYun2(Context context) {
        super("赵云", 1, 2, Type.ZHAO_YUN);
        Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.klotski_zhao_yun);
        super.bitmap = Bitmap.createBitmap(bitmap, 0, bitmap.getHeight() / 2, bitmap.getWidth(), bitmap.getHeight() / 2);
    }
}
