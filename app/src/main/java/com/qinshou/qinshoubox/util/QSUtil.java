package com.qinshou.qinshoubox.util;

import android.content.Context;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Environment;
import android.os.Vibrator;

import com.qinshou.immodule.bean.MessageBean;

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
     * Description:播放提示音
     *
     * @param context 上下文
     */
    public static void playRingtone(Context context) {
        Uri uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        Ringtone ringtone = RingtoneManager.getRingtone(context, uri);
        ringtone.play();
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

    /**
     * Author: QinHao
     * Email:qinhao@jeejio.com
     * Date:2019/9/9 13:58
     * Description:显示通知
     *
     * @param context     上下文
     * @param messageBean 消息实体类
     */
    public static void showNotification(Context context, final MessageBean messageBean) {
        String content = messageBean.getContent();
        NotificationUtil.showNotification(context
                , messageBean.getPid()
                , messageBean.getFromUserId()
                , "先随便传一个"
                , content);
    }
}
