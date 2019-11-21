package com.qinshou.qinshoubox.util;

import android.content.Context;
import android.os.Environment;
import android.os.Vibrator;

import java.io.File;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/11/18 10:58
 * Description:本项目的工具类
 */
public class QSUtil {
    public static String getPicturePath() {
        return Environment.getExternalStorageDirectory()
                + File.separator
                + "QinshouBox"
                + File.separator
                + "Picture"
                + File.separator;
    }

    /**
     * Author: QinHao
     * Email:qinhao@jeejio.com
     * Date:2019/11/5 14:59
     * Description:播放震动
     *
     * @param context 上下文
     */
    public static void playVibration(Context context) {
        if (context == null) {
            return;
        }
        Vibrator vibrator = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
        if (vibrator == null) {
            return;
        }
        vibrator.vibrate(new long[]{0, 300}, -1);
    }
}
