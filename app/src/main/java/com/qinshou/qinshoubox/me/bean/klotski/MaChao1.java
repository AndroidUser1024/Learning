package com.qinshou.qinshoubox.me.bean.klotski;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.qinshou.qinshoubox.R;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2020/5/20 17:21
 * Description:马超1
 */
public class MaChao1 extends KlotskiBean {

    public MaChao1(Context context) {
        super("马超", 1, 2, Type.MA_CHAO);
        Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.klotski_ma_chao);
        super.bitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight() / 2);
    }
}
