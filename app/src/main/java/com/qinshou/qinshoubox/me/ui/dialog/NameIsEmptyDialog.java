package com.qinshou.qinshoubox.me.ui.dialog;

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
 * Date: 2019/11/13 15:17
 * Description:设置名字时,输入名字为空的提示对话框
 */
public class NameIsEmptyDialog extends AbsDialogFragment {
    @Override
    public int initLayoutId() {
        return R.layout.dialog_name_is_empty;
    }

    @Override
    public void initView() {

    }

    @Override
    public void setListener() {
        findViewByID(R.id.tv_i_know).setOnClickListener(new View.OnClickListener() {
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
}
