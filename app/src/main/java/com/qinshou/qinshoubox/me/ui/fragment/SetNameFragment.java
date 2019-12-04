package com.qinshou.qinshoubox.me.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.qinshou.commonmodule.ContainerActivity;
import com.qinshou.qinshoubox.R;
import com.qinshou.qinshoubox.base.QSFragment;
import com.qinshou.qinshoubox.homepage.bean.EventBean;
import com.qinshou.qinshoubox.listener.ClearErrorInfoTextWatcher;
import com.qinshou.qinshoubox.login.bean.UserBean;
import com.qinshou.qinshoubox.me.contract.ISetNameContract;
import com.qinshou.qinshoubox.me.presenter.SetNamePresenter;
import com.qinshou.qinshoubox.me.ui.dialog.NameIsEmptyDialog;
import com.qinshou.qinshoubox.util.userstatusmanager.UserStatusManager;

import org.greenrobot.eventbus.EventBus;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/11/13 14:36
 * Description:设置名字界面
 */
public class SetNameFragment extends QSFragment<SetNamePresenter> implements ISetNameContract.IView {
    private static final String NICKNAME = "Nickname";
    /**
     * 完成按钮
     */
    private TextView mTvFinish;
    /**
     * 昵称输入框
     */
    private EditText mEtNickname;
    /**
     * 输入框清空按钮
     */
    private ImageView mIvClear;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_set_name;
    }

    @Override
    public void initView() {
        mTvFinish = findViewByID(R.id.tv_finish);
        mEtNickname = findViewByID(R.id.et_nickname);
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
                String nickname = mEtNickname.getText().toString().trim();
                if (TextUtils.isEmpty(nickname)) {
                    NameIsEmptyDialog nameIsEmptyDialog = new NameIsEmptyDialog();
                    nameIsEmptyDialog.show(getChildFragmentManager(), "NameIsEmptyDialog");
                    return;
                }
                getPresenter().setUserInfo(UserStatusManager.SINGLETON.getUserBean().getId(), nickname);
            }
        });
        mEtNickname.addTextChangedListener(new ClearErrorInfoTextWatcher(null) {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                super.onTextChanged(s, start, before, count);
                mIvClear.setVisibility(TextUtils.isEmpty(mEtNickname.getText()) ? View.GONE : View.VISIBLE);
                mTvFinish.setEnabled(!TextUtils.isEmpty(mEtNickname.getText()));
            }
        });
        mIvClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEtNickname.setText("");
            }
        });
    }

    @Override
    public void initData() {
        Bundle bundle = getArguments();
        if (bundle == null) {
            return;
        }
        String nickname = bundle.getString(NICKNAME);
        mEtNickname.setText(nickname);
    }

    @Override
    public void setUserInfoSuccess(UserBean userBean) {
        UserStatusManager.SINGLETON.getUserBean().setNickname(userBean.getNickname());
        EventBus.getDefault().post(new EventBean<Object>(EventBean.Type.REFRESH_USER_BEAN, null));
        finish();
    }

    @Override
    public void setUserInfoFailure(Exception e) {
        toastShort(e.getMessage());
    }

    /**
     * Author: QinHao
     * Email:qinhao@jeejio.com
     * Date:2019/11/13 14:56
     * Description:跳转到该界面
     *
     * @param context  上下文
     * @param nickname 旧昵称
     */
    public static void start(Context context, String nickname) {
        Bundle bundle = new Bundle();
        bundle.putString(NICKNAME, nickname);
        context.startActivity(ContainerActivity.getJumpIntent(context, SetNameFragment.class, bundle));
    }
}