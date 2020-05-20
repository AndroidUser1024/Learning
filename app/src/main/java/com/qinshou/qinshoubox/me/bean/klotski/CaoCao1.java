package com.qinshou.qinshoubox.me.bean.klotski;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.qinshou.qinshoubox.R;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2020/5/20 17:21
 * Description:曹操1
 */
public class CaoCao1 extends KlotskiBean {

    public CaoCao1(Context context) {
        super("曹操", 2, 2, Type.CAO_CAO);
        Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.klitski_cao_cao);
        super.bitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth() / 2, bitmap.getHeight() / 2);
    }
}
