package com.qinshou.commonmodule.util;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import androidx.appcompat.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

/**
 * Description:
 * Created by 禽兽先生
 * Created on 2018/11/16
 */
public class DialogUtil {
    private Builder mBuilder;

    private DialogUtil(Builder builder) {
        mBuilder = builder;
    }

    /**
     * Description:普通对话框
     * Date:2018/11/16
     */
    public void showNormalDialog() {
        new AlertDialog.Builder(mBuilder.mContext)
                .setIcon(mBuilder.icon)
                .setTitle(mBuilder.title)
                .setMessage(mBuilder.message)
                .setPositiveButton(mBuilder.positiveButtonText, mBuilder.positiveButtonOnClickListener)
                .setNegativeButton(mBuilder.negativeButtonText, mBuilder.negativeButtonOnClickListener)
                .setNeutralButton(mBuilder.neutralButtonText, mBuilder.neutralButtonOnClickListener)
                .show();
    }

    /**
     * Description:列表对话框
     * 设置 items 后
     * 再设置 message 则不显示列表
     * 再设置 icon 则不显示 icon
     * Date:2018/11/16
     */
    public void showListDialog() {
        new AlertDialog.Builder(mBuilder.mContext)
                .setIcon(mBuilder.icon)
                .setTitle(mBuilder.title)
                .setMessage(mBuilder.message)
                .setItems(mBuilder.items, mBuilder.itemOnClickListener)
                .setPositiveButton(mBuilder.positiveButtonText, mBuilder.positiveButtonOnClickListener)
                .setNegativeButton(mBuilder.negativeButtonText, mBuilder.negativeButtonOnClickListener)
                .setNeutralButton(mBuilder.neutralButtonText, mBuilder.neutralButtonOnClickListener)
                .show();
    }

    /**
     * Description:单选对话框
     * Date:2018/11/16
     */
    public void showSingleChoiceDialog() {
        new AlertDialog.Builder(mBuilder.mContext)
                .setIcon(mBuilder.icon)
                .setTitle(mBuilder.title)
                .setMessage(mBuilder.message)
                .setSingleChoiceItems(mBuilder.items, mBuilder.checkedItem, mBuilder.itemOnClickListener)
                .setPositiveButton(mBuilder.positiveButtonText, mBuilder.positiveButtonOnClickListener)
                .setNegativeButton(mBuilder.negativeButtonText, mBuilder.negativeButtonOnClickListener)
                .setNeutralButton(mBuilder.neutralButtonText, mBuilder.neutralButtonOnClickListener)
                .show();
    }

    /**
     * Description:多选对话框
     * Date:2018/11/16
     */
    public void showMultiChoiceDialog() {
        new AlertDialog.Builder(mBuilder.mContext)
                .setIcon(mBuilder.icon)
                .setTitle(mBuilder.title)
                .setMessage(mBuilder.message)
                .setMultiChoiceItems(mBuilder.items, mBuilder.checkedItems, mBuilder.onMultiChoiceClickListener)
                .setPositiveButton(mBuilder.positiveButtonText, mBuilder.positiveButtonOnClickListener)
                .setNegativeButton(mBuilder.negativeButtonText, mBuilder.negativeButtonOnClickListener)
                .setNeutralButton(mBuilder.neutralButtonText, mBuilder.neutralButtonOnClickListener)
                .show();
    }

    /**
     * Description:显示等待对话框
     * 屏蔽其他控件的交互能力，setCancelable() 为使屏幕不可点击，设置为不可取消(false)
     * 事件完成后，主动调用函数关闭该Dialog
     * <p>
     * Date:2018/11/16
     */
    public ProgressDialog showWaitingDialog() {
        ProgressDialog waitingDialog = new ProgressDialog(mBuilder.mContext);
        waitingDialog.setTitle(mBuilder.title);
        waitingDialog.setMessage(mBuilder.message);
        waitingDialog.setIndeterminate(true);
        waitingDialog.setCancelable(false);
        waitingDialog.show();
        return waitingDialog;
    }

    /**
     * Description:显示进度对话框
     * Date:2018/11/16
     */
    public ProgressDialog showProgressDialog() {
        ProgressDialog progressDialog = new ProgressDialog(mBuilder.mContext);
        progressDialog.setProgress(mBuilder.progress);
        progressDialog.setTitle(mBuilder.title);
        progressDialog.setProgressStyle(mBuilder.progressStyle);
        progressDialog.setMax(mBuilder.progressMax);
        progressDialog.show();
        return progressDialog;
    }

    /**
     * Description:显示输入对话框
     * 调用 setView() 方法自定义对话框，放入一个 EditText
     * Date:2018/11/16
     */
    public void showInputDialog() {
        final EditText editText = new EditText(mBuilder.mContext);
        new AlertDialog.Builder(mBuilder.mContext)
                .setTitle(mBuilder.title)
                .setView(editText)
                .setPositiveButton(mBuilder.positiveButtonText, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (mBuilder.mOnClickListenerWithView != null) {
                            mBuilder.mOnClickListenerWithView.onClick(dialog, which, editText);
                        }
                    }
                })
                .show();
    }

    public View showCustomDialog() {
        new AlertDialog.Builder(mBuilder.mContext)
                .setView(mBuilder.mView)
                .show();
        return mBuilder.mView;
    }

    public static class Builder {
        private Context mContext;
        private String title;
        private String message;
        private int icon;
        private String positiveButtonText;
        private DialogInterface.OnClickListener positiveButtonOnClickListener;
        private String negativeButtonText;
        private DialogInterface.OnClickListener negativeButtonOnClickListener;
        private String neutralButtonText;
        private DialogInterface.OnClickListener neutralButtonOnClickListener;
        private String[] items;
        private int checkedItem;
        private DialogInterface.OnClickListener itemOnClickListener;
        private boolean[] checkedItems;
        private DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener;
        private int progress = 0;
        private int progressStyle = 1;
        private int progressMax = 100;
        private OnClickListenerWithView mOnClickListenerWithView;
        private View mView;

        public Builder(Context context) {
            this.mContext = context;
        }

        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder setMessage(String message) {
            this.message = message;
            return this;
        }

        public Builder setIcon(int icon) {
            this.icon = icon;
            return this;
        }

        public Builder setPositiveButton(String positiveButtonText, DialogInterface.OnClickListener positiveButtonOnClickListener) {
            this.positiveButtonText = positiveButtonText;
            this.positiveButtonOnClickListener = positiveButtonOnClickListener;
            return this;
        }

        public Builder setNegativeButton(String negativeButtonText, DialogInterface.OnClickListener negativeButtonOnClickListener) {
            this.negativeButtonText = negativeButtonText;
            this.negativeButtonOnClickListener = negativeButtonOnClickListener;
            return this;
        }

        public Builder setNeutralButton(String neutralButtonText, DialogInterface.OnClickListener neutralButtonOnClickListener) {
            this.neutralButtonText = neutralButtonText;
            this.neutralButtonOnClickListener = neutralButtonOnClickListener;
            return this;
        }

        public Builder setItems(String[] items, DialogInterface.OnClickListener itemOnClickListener) {
            return setItems(items, 0, itemOnClickListener);
        }

        public Builder setItems(String[] items, int checkedItem, DialogInterface.OnClickListener itemOnClickListener) {
            this.items = items;
            this.checkedItem = checkedItem;
            this.itemOnClickListener = itemOnClickListener;
            return this;
        }

        public Builder setItems(String[] items, DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener) {
            return setItems(items, new boolean[items.length], onMultiChoiceClickListener);
        }

        public Builder setItems(String[] items, boolean[] checkedItems, DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener) {
            this.items = items;
            this.checkedItems = checkedItems;
            this.onMultiChoiceClickListener = onMultiChoiceClickListener;
            return this;
        }

        public Builder setProgress(int progress) {
            this.progress = progress;
            return this;
        }

        public Builder setProgressStyle(int progressStyle) {
            this.progressStyle = progressStyle;
            return this;
        }

        public Builder setProgressMax(int progressMax) {
            this.progressMax = progressMax;
            return this;
        }

        public Builder setPositiveButton(String positiveButtonText, OnClickListenerWithView onClickListenerWithView) {
            this.positiveButtonText = positiveButtonText;
            this.mOnClickListenerWithView = onClickListenerWithView;
            return this;
        }

        public Builder setView(int resId) {
            return setView(LayoutInflater.from(mContext).inflate(resId, null));
        }

        public Builder setView(View view) {
            this.mView = view;
            return this;
        }

        public DialogUtil create() {
            return new DialogUtil(this);
        }
    }

    public interface OnClickListenerWithView<T extends View> {
        void onClick(DialogInterface dialog, int which, T t);
    }
}
