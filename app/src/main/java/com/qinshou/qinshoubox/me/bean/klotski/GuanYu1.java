package com.qinshou.qinshoubox.me.bean.klotski;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.qinshou.qinshoubox.R;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2020/5/20 17:21
 * Description:关羽1
 */
public class GuanYu1 extends KlotskiBean {

    public GuanYu1(Context context) {
        super("关羽", 2, 1, Type.GUAN_YU);
        Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.klotski_guan_yu);
        super.bitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth() / 2, bitmap.getHeight());
    }
}
