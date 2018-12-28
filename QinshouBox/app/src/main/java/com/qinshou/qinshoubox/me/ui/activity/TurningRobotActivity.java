package com.qinshou.qinshoubox.me.ui.activity;

import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.qinshou.commonmodule.util.SnackbarUtil;
import com.qinshou.qinshoubox.R;
import com.qinshou.qinshoubox.base.MyBaseActivity;

/**
 * Description:图灵机器人游戏界面
 * Created by 禽兽先生
 * Created on 2018/8/29
 */

public class TurningRobotActivity extends MyBaseActivity {
    private EditText etMessage;
    private Button btnSend;

    @Override
    public int getLayoutId() {
        return R.layout.activity_turning_robot;
    }

    @Override
    public void setPresenter() {

    }

    @Override
    public void initView() {
        etMessage = findViewByID(R.id.et_message);
        btnSend = findViewByID(R.id.btn_send);
    }

    @Override
    public void setListener() {
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = etMessage.getText().toString().trim();
                if (TextUtils.isEmpty(message)) {
                    SnackbarUtil.showSnackbar(getActivity(), "不允许发送空白消息");
                    return;
                }
            }
        });
    }

    @Override
    public void initData() {

    }

}
