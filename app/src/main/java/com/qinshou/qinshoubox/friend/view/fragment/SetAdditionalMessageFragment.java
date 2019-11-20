package com.qinshou.qinshoubox.friend.view.fragment;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import com.qinshou.commonmodule.ContainerActivity;
import com.qinshou.commonmodule.util.ShowLogUtil;
import com.qinshou.commonmodule.widget.TitleBar;
import com.qinshou.qinshoubox.R;
import com.qinshou.qinshoubox.base.QSFragment;
import com.qinshou.qinshoubox.friend.contract.ISetAdditionalMessageContract;
import com.qinshou.qinshoubox.friend.presenter.SetAdditionalMessagePresenter;
import com.qinshou.qinshoubox.util.userstatusmanager.UserStatusManager;


/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/09/12 10:01
 * Description:输入朋友验证消息界面
 */
public class SetAdditionalMessageFragment extends QSFragment<SetAdditionalMessagePresenter> implements ISetAdditionalMessageContract.IView {
    private static final String TO_USER_ID = "ToUserId";
    private static final String REMARK = "Remark";
    private static final String SOURCE = "Source";
    /**
     * 待添加的人的用户 id
     */
    private int mToUserId;
    /**
     * 待添加的人的备注
     */
    private String mRemark;
    /**
     * 朋友验证消息输入框
     */
    private EditText mEtAdditionalMessage;
    /**
     * 清空输入框的按钮
     */
    private ImageButton mIbClearInput;
    private int mSource;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_set_additional_message;
    }

    @Override
    public void initView() {
        mEtAdditionalMessage = findViewByID(R.id.et_additional_message);
        mEtAdditionalMessage.setText(getString(R.string.set_additional_message_default_additional_message, UserStatusManager.SINGLETON.getUserBean().getNickname()));
        mIbClearInput = findViewByID(R.id.ib_clear_input);
    }

    @Override
    public void setListener() {
        ((TitleBar) findViewByID(R.id.title_bar)).setLeftTextOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();

            }
        });
        ((TitleBar) findViewByID(R.id.title_bar)).setRightTextOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mToUserId == 0) {
                    return;
                }
                getPresenter().addFriend(UserStatusManager.SINGLETON.getUserBean().getId()
                        , mToUserId
                        , mRemark
                        , mEtAdditionalMessage.getText().toString().trim()
                        , mSource);
            }
        });
        mEtAdditionalMessage.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.length() > 0) {
                    mIbClearInput.setVisibility(View.VISIBLE);
                } else {
                    mIbClearInput.setVisibility(View.INVISIBLE);
                }
            }
        });
        mIbClearInput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEtAdditionalMessage.setText("");
            }
        });
    }

    @Override
    public void initData() {
        Bundle bundle = getArguments();
        if (bundle == null) {
            return;
        }
        mToUserId = bundle.getInt(TO_USER_ID, 0);
        mRemark = bundle.getString(REMARK);
        mSource = bundle.getInt(SOURCE, 0);
    }

    @Override
    public void addFriendSuccess() {
        finish();
        toastShort("发送添加好友请求成功");
    }

    @Override
    public void addFriendFailure(Exception e) {
        toastShort("发送添加好友请求失败");
        ShowLogUtil.logi("发送添加好友请求失败: e--->" + e.getMessage());
    }

    /**
     * Author: QinHao
     * Email:qinhao@jeejio.com
     * Date:2019/9/12 10:17
     * Description:跳转到该界面
     *
     * @param context  上下文
     * @param toUserId 待添加的人的用户 id
     * @param remark   待添加的人的备注
     * @param source   添加来源
     */
    public static void start(Context context, int toUserId, String remark, int source) {
        Bundle bundle = new Bundle();
        bundle.putInt(TO_USER_ID, toUserId);
        bundle.putString(REMARK, remark);
        bundle.putInt(SOURCE, source);
        context.startActivity(ContainerActivity.getJumpIntent(context
                , SetAdditionalMessageFragment.class
                , bundle));
    }
}