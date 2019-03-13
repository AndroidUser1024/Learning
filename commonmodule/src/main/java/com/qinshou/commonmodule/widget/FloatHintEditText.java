package com.qinshou.commonmodule.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.qinshou.commonmodule.R;

/**
 * Description:当有输入时,提示文字会悬浮在上方的 EditText
 * Created by 禽兽先生
 * Created on 2018/4/20
 */

public class FloatHintEditText extends LinearLayout {

    private String mHint;
    private float mHintTextSize;
    private int mHintTextColor;

    public FloatHintEditText(Context context) {
        this(context, null);
    }

    public FloatHintEditText(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public FloatHintEditText(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initAttribute(context, attrs);
        initView(context);
    }

    /**
     * Description:初始化自定义属性
     * Date:2017/9/18
     */
    private void initAttribute(Context context, AttributeSet attrs) {
        TypedArray mTypedArray = context.obtainStyledAttributes(attrs, R.styleable.FloatHintEditText);
        mHint = mTypedArray.getString(R.styleable.FloatHintEditText_edit_text_hint);
        mHintTextSize = mTypedArray.getDimension(R.styleable.FloatHintEditText_hint_text_size, 10) / getResources().getDisplayMetrics().density;
        mHintTextColor = mTypedArray.getColor(R.styleable.FloatHintEditText_hint_text_color, Color.GRAY);
        mTypedArray.recycle();
    }

    private void initView(Context context) {
        setOrientation(LinearLayout.VERTICAL);
        final TextView textView = new TextView(context);
        final EditText editText = new EditText(context);
        textView.setPadding(0,0,0,0);
        textView.setTextSize(mHintTextSize);
        textView.setTextColor(mHintTextColor);

        editText.setHint(mHint);
        editText.setBackgroundResource(0);
        editText.setPadding(0,0,0,0);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (TextUtils.isEmpty(editText.getText().toString())) {
                    textView.setText("");
                } else {
                    textView.setText(mHint);
                }
            }
        });

        addView(textView);
        addView(editText);
    }
}
