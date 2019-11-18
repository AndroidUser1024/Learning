package com.qinshou.qinshoubox.listener;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;

/**
 * Description:监听到输入框有输入后就清除错误提示信息的监听器
 * Created by 禽兽先生
 * Created on 2018/12/4
 */
public class ClearErrorInfoTextWatcher implements TextWatcher {
    //错误信息提示文本框
    private TextView mTvErrorInfo;

    public ClearErrorInfoTextWatcher(TextView tvErrorInfo) {
        this.mTvErrorInfo = tvErrorInfo;
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        //输入发生改变时清空错误信息提示文本框
        if (mTvErrorInfo == null) {
            return;
        }
        mTvErrorInfo.setText("");
    }

    @Override
    public void afterTextChanged(Editable s) {

    }
}
