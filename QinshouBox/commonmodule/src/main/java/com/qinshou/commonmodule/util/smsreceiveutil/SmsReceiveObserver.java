package com.qinshou.commonmodule.util.smsreceiveutil;

import android.app.AlertDialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.widget.TextView;

/**
 * Description:接收短信的观察者
 * Created by 禽兽先生
 * Created on 2018/8/4
 */
public class SmsReceiveObserver extends ContentObserver {
    private Context mContext;
    private OnSmsReceiveListener mSmsReceiveListener;
    private DialogType mDialogType;
    private int mCheckCodeStartIndex;
    private int mCheckCodeLength;
    private TextView mTvAutoComplete;
    private AlertDialog mAlertDialog;

    public enum DialogType {
        COPY_DIALOG, AUTO_COMPLETE_DIALOG
    }

    public SmsReceiveObserver(Handler handler, Context context, OnSmsReceiveListener smsReceiveListener) {
        super(handler);
        mContext = context;
        mSmsReceiveListener = smsReceiveListener;
    }

    public SmsReceiveObserver(Handler handler, Context context, DialogType dialogType, int checkCodeStartIndex, int checkCodeLength) {
        this(handler, context, dialogType, checkCodeStartIndex, checkCodeLength, null);
    }

    public SmsReceiveObserver(Handler handler, Context context, DialogType dialogType, int checkCodeStartIndex, int checkCodeLength, TextView tvAutoComplete) {
        super(handler);
        mContext = context;
        mDialogType = dialogType;
        mCheckCodeStartIndex = checkCodeStartIndex;
        mCheckCodeLength = checkCodeLength;
        mTvAutoComplete = tvAutoComplete;
        mAlertDialog = new AlertDialog.Builder(context).create();
    }


    @Override
    public void onChange(boolean selfChange, Uri uri) {
        super.onChange(selfChange, uri);
        if (uri.toString().equals("content://sms/raw")) {
            return;
        }
        Cursor cursor = mContext.getContentResolver().query(Uri.parse("content://sms/inbox"), new String[]{"_id", "address", "read", "body"}, "read=?", new String[]{"0"}, "_id desc");
        if (cursor != null) {
            if (cursor.moveToNext()) {
                String address = cursor.getString(cursor.getColumnIndex("address"));
                final String body = cursor.getString(cursor.getColumnIndex("body"));
                if (mSmsReceiveListener != null) {
                    mSmsReceiveListener.onSuccess(body);
                }
                if (mAlertDialog != null) {
                    mAlertDialog.setTitle(address);
                    mAlertDialog.setMessage(body);
                    if (mDialogType == DialogType.COPY_DIALOG) {
                        mAlertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "复制验证码", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                String checkCode = body.substring(mCheckCodeStartIndex, mCheckCodeStartIndex + mCheckCodeLength);
                                ClipboardManager clipboardManager = (ClipboardManager) mContext.getSystemService(Context.CLIPBOARD_SERVICE);
                                if (clipboardManager != null) {
                                    clipboardManager.setPrimaryClip(ClipData.newPlainText("checkCode", checkCode));
                                }
                                dialog.dismiss();
                            }
                        });
                    } else if (mDialogType == DialogType.AUTO_COMPLETE_DIALOG) {
                        mAlertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "自动填入验证码", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                String checkCode = body.substring(mCheckCodeStartIndex, mCheckCodeStartIndex + mCheckCodeLength);
                                mTvAutoComplete.setText(checkCode);
                                dialog.dismiss();
                            }
                        });
                    }
                    mAlertDialog.show();
                }
            }
            cursor.close();
        }
    }
}
