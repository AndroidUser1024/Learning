package com.qinshou.qinshoubox.friend.view.dialog;

import android.app.Dialog;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.qinshou.commonmodule.base.AbsDialogFragment;
import com.qinshou.qinshoubox.R;


/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/11/13 10:22
 * Description:清空聊天记录对话框
 */
public class DeleteFriendDialog extends AbsDialogFragment {
    private View.OnClickListener mOnClickListener;

    @Override
    public int initLayoutId() {
        return R.layout.dialog_delete_friend;
    }

    @Override
    public void initView() {
    }

    @Override
    public void setListener() {
        findViewByID(R.id.tv_delete).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mOnClickListener != null) {
                    mOnClickListener.onClick(v);
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

    public void setTvDeleteOnClickListener(View.OnClickListener onClickListener) {
        mOnClickListener = onClickListener;
    }
}
