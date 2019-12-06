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
import com.qinshou.qinshoubox.friend.contract.ISetAdditionalMsgContract;
import com.qinshou.qinshoubox.friend.presenter.SetAdditionalMsgPresenter;
import com.qinshou.qinshoubox.util.userstatusmanager.UserStatusManager;


/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/09/12 10:01
 * Description:输入朋友验证消息界面
 */
public class SetAdditionalMsgFragment extends QSFragment<SetAdditionalMsgPresenter> implements ISetAdditionalMsgContract.IView {
    private static final String TO_USER_ID = "ToUserId";
    private static final String REMARK = "Remark";
    private static final String SOURCE = "Source";
    /**
     * 待添加的人的用户 id
     */
    private String mToUserId;
    /**
     * 待添加的人的备注
     */
    private String mRemark;
    /**
     * 朋友验证消息输入框
     */
    private EditText mEtAdditionalMsg;
    /**
     * 清空输入框的按钮
     */
    private ImageButton mIbClearInput;
    private int mSource;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_set_additional_msg;
    }

    @Override
    public void initView() {
        mEtAdditionalMsg = findViewByID(R.id.et_additional_msg);
        mEtAdditionalMsg.setText(getString(R.string.set_additional_msg_default_additional_msg, UserStatusManager.SINGLETON.getUserBean().getNickname()));
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
                if (TextUtils.isEmpty(mToUserId)) {
                    return;
                }
                getPresenter().addFriend(mToUserId
                        , mRemark
                        , mEtAdditionalMsg.getText().toString().trim()
                        , mSource);
            }
        });
        mEtAdditionalMsg.addTextChangedListener(new TextWatcher() {
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
                mEtAdditionalMsg.setText("");
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
    public static void start(Context context, String toUserId, String remark, int source) {
        Bundle bundle = new Bundle();
        bundle.putString(TO_USER_ID, toUserId);
        bundle.putString(REMARK, remark);
        bundle.putInt(SOURCE, source);
        context.startActivity(ContainerActivity.getJumpIntent(context
                , SetAdditionalMsgFragment.class
                , bundle));
    }
}