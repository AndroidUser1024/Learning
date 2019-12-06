package com.qinshou.qinshoubox.util;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;

import com.qinshou.qinshoubox.R;
import com.qinshou.qinshoubox.conversation.view.activity.ChatActivity;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/9/9 13:49
 * Description:通知工具类
 */
public class NotificationUtil {
    /**
     * Author: QinHao
     * Email:qinhao@jeejio.com
     * Date:2019/9/9 14:14
     * Description:显示通知
     *
     * @param context  上下文
     * @param id       通知 id,用于区分各个通知,通常需要唯一性,通常传递 MessageBean 的 id
     * @param toUserId 对方的用户,用于设置点击通知跳转事件,如果为 0 则没有跳转事件
     * @param title    通知标题,通常传递对方昵称
     * @param content  通知内容,通常传递消息内容
     */
    public static void showNotification(Context context, int id, String toUserId, String title, String content) {
        // 创建NotificationManager对象，并发布和管理所要创建的Notification
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
//        PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0, null, PendingIntent.FLAG_UPDATE_CURRENT);
        long[] vibrate = {0, 500};
        // 大图标
        Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), R.mipmap.ic_launcher);
        // 点击跳转意图
        PendingIntent pendingIntent = null;
        if (!TextUtils.isEmpty(toUserId)) {
            Intent intent = new Intent(context, ChatActivity.class);
            intent.putExtra("ToUserId", toUserId);
            pendingIntent = PendingIntent.getActivity(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        }
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, id + "")
                // 触摸之后，通知立即消失
                .setAutoCancel(true)
                // 显示的时间
                .setWhen(System.currentTimeMillis())
                // 设置通知的小图标
                .setSmallIcon(R.mipmap.ic_launcher)
                // 设置状态栏显示的文本
                .setTicker(content)
                // 设置通知的标题
                .setContentTitle(title)
                // 设置通知的内容
                .setContentText(content)
                // 设置声音（系统默认的）
                // .setDefaults(Notification.DEFAULT_SOUND)
                // 设置声音（自定义）
                // 设置跳转的activity
                .setContentIntent(pendingIntent)
                // 设置震动
                .setVibrate(vibrate)
                //使用系统提供的铃音
                .setDefaults(Notification.DEFAULT_SOUND)
                .setLargeIcon(bitmap);
        // 部分手机需要设置 Style 才能显示通知
        NotificationCompat.BigTextStyle style = new NotificationCompat.BigTextStyle();
        style.bigText(content);
        style.setBigContentTitle(title);
        builder.setStyle(style);
        // Android 8.0 以上需要设置 Channel
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            String channelId = "1";
            NotificationChannel notificationChannel = notificationManager.getNotificationChannel(channelId);
            if (notificationChannel == null) {
                notificationManager.createNotificationChannel(new NotificationChannel(channelId, "JeejioMessage", NotificationManager.IMPORTANCE_HIGH));
            }
            builder.setChannelId(channelId);
        }
        notificationManager.notify(id, builder.build());
    }
}
