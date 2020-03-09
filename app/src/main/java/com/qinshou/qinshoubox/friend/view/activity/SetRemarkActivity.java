package com.qinshou.qinshoubox.friend.view.activity;

import android.content.Context;
import android.content.Intent;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.qinshou.commonmodule.widget.TitleBar;
import com.qinshou.qinshoubox.R;
import com.qinshou.qinshoubox.base.QSActivity;
import com.qinshou.qinshoubox.friend.contract.ISetRemarkContract;
import com.qinshou.qinshoubox.friend.presenter.SetRemarkPresenter;
import com.qinshou.qinshoubox.homepage.bean.EventBean;
import com.qinshou.qinshoubox.listener.ClearErrorInfoTextWatcher;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/09/05 19:53
 * Description:设置备注界面
 */
public class SetRemarkActivity extends QSActivity<SetRemarkPresenter> implements ISetRemarkContract.IView {
    public static final int REQUEST_CODE = 1001;
    public static final int RESULT_CODE = 1002;
    private static final String OLD_REMARK = "OldRemark";
    public static final String NEW_REMARK = "NewRemark";
    /**
     * 备注输入框
     */
    private EditText mEtRemark;
    /**
     * 完成按钮
     */
    private TextView mTvFinish;
    /**
     * 输入框清空按钮
     */
    private ImageView mIvClear;


    @Override
    public int getLayoutId() {
        return R.layout.activity_set_remark;
    }

    @Override
    public void initView() {
        mTvFinish = findViewByID(R.id.tv_finish);
        mEtRemark = findViewByID(R.id.et_remark);
        mIvClear = findViewByID(R.id.iv_clear);
    }

    @Override
    public void setListener() {
        findViewByID(R.id.tv_cancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        mTvFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String remark = mEtRemark.getText().toString().trim();
                Intent intent = new Intent();
                intent.putExtra(NEW_REMARK, remark);
                setResult(RESULT_CODE, intent);
                finish();
            }
        });
        mEtRemark.addTextChangedListener(new ClearErrorInfoTextWatcher(null) {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mIvClear.setVisibility(TextUtils.isEmpty(mEtRemark.getText()) ? View.GONE : View.VISIBLE);
            }
        });
        mIvClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEtRemark.setText("");
            }
        });
    }

    @Override
    public void initData() {
        String oldRemark = getIntent().getStringExtra(OLD_REMARK);
        mEtRemark.setText(oldRemark);
    }

    @Override
    public void handleEvent(EventBean<Object> eventBean) {
    }

    /**
     * Author: QinHao
     * Email:qinhao@jeejio.com
     * Date:2019/10/21 19:38
     * Description:跳转到该界面
     *
     * @param context   description
     * @param oldRemark 旧的备注
     */
    public static Intent getJumpIntent(Context context, String oldRemark) {
        Intent intent = new Intent(context, SetRemarkActivity.class);
        intent.putExtra(OLD_REMARK, oldRemark);
        return intent;
    }
}