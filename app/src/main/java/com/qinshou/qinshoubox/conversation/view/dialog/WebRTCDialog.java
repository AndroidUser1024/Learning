package com.qinshou.qinshoubox.conversation.view.dialog;

import android.app.Dialog;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.qinshou.commonmodule.base.AbsDialogFragment;
import com.qinshou.commonmodule.util.ShowLogUtil;
import com.qinshou.qinshoubox.R;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2020/5/6 18:38
 * Description:音视频实时通话选择框
 */
public class WebRTCDialog extends AbsDialogFragment {
    private static final String TO_USER_ID = "toUserId";
    private String mToUserId;

    @Override
    public int initLayoutId() {
        return R.layout.dialog_web_rtc;
    }

    @Override
    public void initView() {
        ShowLogUtil.logi("");
    }

    @Override
    public void setListener() {
        findViewByID(R.id.tv_video_call).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dismiss();
            }
        });
        findViewByID(R.id.tv_audio_call).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

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
        Bundle bundle = getArguments();
        if (bundle == null) {
            return;
        }
        mToUserId = bundle.getString(TO_USER_ID);
    }

    @Override
    public Dialog customDialog(Dialog dialog) {
        Window window = dialog.getWindow();
        if (window != null) {
            // 底部对话框
            window.setGravity(Gravity.CENTER);
            window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
            window.setWindowAnimations(R.style.Scale);
        }
        return dialog;
    }

    public static WebRTCDialog newInstance(String toUserId) {

        Bundle args = new Bundle();
        args.putString(TO_USER_ID, toUserId);

        WebRTCDialog fragment = new WebRTCDialog();
        fragment.setArguments(args);
        return fragment;
    }
}
