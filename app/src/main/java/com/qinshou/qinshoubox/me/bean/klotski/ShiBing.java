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
public class ShiBing extends KlotskiBean {

    public ShiBing(Context context) {
        super("士兵", 1, 1, Type.SHI_BING);
        Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.klotski_shi_bing);
        super.bitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth() , bitmap.getHeight());
    }
}
