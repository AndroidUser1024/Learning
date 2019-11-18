package com.qinshou.qinshoubox.me.ui.dialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.qinshou.commonmodule.base.AbsDialogFragment;
import com.qinshou.qinshoubox.R;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/11/13 19:18
 * Description:个人头像更多功能对话框
 */
public class PersonalHeadImgDialog extends AbsDialogFragment {
    private IOnDismissListener mOnDismissListener;

    @Override
    public int initLayoutId() {
        return R.layout.dialog_personal_head_img_more;
    }

    @Override
    public void initView() {

    }

    @Override
    public void setListener() {
        findViewByID(R.id.tv_take_photo).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mOnDismissListener != null) {
                    mOnDismissListener.onDismiss(getDialog(), Type.TAKE_PHOTO);
                }
                dismiss();
            }
        });
        findViewByID(R.id.tv_pick_photo).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mOnDismissListener != null) {
                    mOnDismissListener.onDismiss(getDialog(), Type.PICK_PHOTO);
                }
                dismiss();
            }
        });
        findViewByID(R.id.tv_save_image).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mOnDismissListener != null) {
                    mOnDismissListener.onDismiss(getDialog(), Type.SAVE_IMAGE);
                }
                dismiss();
            }
        });
        findViewByID(R.id.tv_cancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
    }

    @Override
    public void initData() {

    }

    @Override
    public Dialog customDialog(Dialog dialog) {
        Window window = dialog.getWindow();
        if (window != null) {
            //底部对话框
            window.setGravity(Gravity.BOTTOM);
            window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        }
        return dialog;
    }

    public void setOnDismissListener(IOnDismissListener onDismissListener) {
        mOnDismissListener = onDismissListener;
    }

    public interface IOnDismissListener {
        void onDismiss(DialogInterface dialogInterface, Type type);
    }

    public enum Type {
        /**
         * 拍照
         */
        TAKE_PHOTO,
        /**
         * 从手机相册选择
         */
        PICK_PHOTO,
        /**
         * 保存图片
         */
        SAVE_IMAGE,
    }
}
