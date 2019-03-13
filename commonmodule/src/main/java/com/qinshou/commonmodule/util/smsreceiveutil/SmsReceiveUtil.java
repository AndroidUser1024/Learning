package com.qinshou.commonmodule.util.smsreceiveutil;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.widget.TextView;

/**
 * Description:验证码接收工具类
 * Created by 禽兽先生
 * Created on 2018/8/4
 */
public class SmsReceiveUtil {
    public static void getCheckCode(Context context, Handler handler, OnSmsReceiveListener smsReceiveListener) {
        context.getContentResolver().registerContentObserver(Uri.parse("content://sms/")
                , true
                , new SmsReceiveObserver(handler, context, smsReceiveListener));
    }

    public static void copyCheckCode(Context context, Handler handler,int checkCodeStartIndex,int checkCodeLength) {
        context.getContentResolver().registerContentObserver(Uri.parse("content://sms/")
                , true
                , new SmsReceiveObserver(handler, context, SmsReceiveObserver.DialogType.COPY_DIALOG,checkCodeStartIndex,checkCodeLength));
    }
    public static void autoCompleteCheckCode(Context context, Handler handler, int checkCodeStartIndex, int checkCodeLength, TextView tvAutoComplete) {
        context.getContentResolver().registerContentObserver(Uri.parse("content://sms/")
                , true
                , new SmsReceiveObserver(handler, context, SmsReceiveObserver.DialogType.AUTO_COMPLETE_DIALOG,checkCodeStartIndex,checkCodeLength,tvAutoComplete));
    }
}
