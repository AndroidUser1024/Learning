package com.qinshou.qinshoubox.conversation.view.fragment;

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
import com.qinshou.qinshoubox.conversation.contract.ISetNicknameInGroupChatContract;
import com.qinshou.qinshoubox.conversation.presenter.SetNicknameInGroupChatPresenter;
import com.qinshou.qinshoubox.homepage.bean.EventBean;
import com.qinshou.qinshoubox.listener.ClearErrorInfoTextWatcher;
import com.qinshou.qinshoubox.me.ui.dialog.NameIsEmptyDialog;

import org.greenrobot.eventbus.EventBus;

/**
 * Author: QinHao
 * Email:cqflqinhao@126.com
 * Date: 2019/12/09 14:01
 * Description:群聊-设置我在本群中的昵称界面
 */
public class SetNicknameInGroupChatFragment extends QSFragment<SetNicknameInGroupChatPresenter> implements ISetNicknameInGroupChatContract.IView {
    public static final String GROUP_CHAT_ID = "GroupChatId";
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
    /**
     * 群 Id
     */
    private String mGroupChatId;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_set_nickname_in_group_chat;
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
                getPresenter().setNicknameInGroupChat(mGroupChatId, nickname);
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
        mGroupChatId = bundle.getString(GROUP_CHAT_ID);
        String nickname = bundle.getString(NICKNAME);
        mEtNickname.setText(nickname);
    }

    @Override
    public void setNicknameInGroupChatSuccess() {
        EventBus.getDefault().post(new EventBean<Object>(EventBean.Type.REFRESH_GROUP_CHAT_DETAIL, null));
        finish();
    }

    @Override
    public void setNicknameInGroupChatFailure(Exception e) {

    }

    /**
     * Author: QinHao
     * Email:cqflqinhao@126.com
     * Date:2019/12/09 14:06
     * Description:跳转到该界面
     *
     * @param context     上下文
     * @param groupChatId 群 Id
     * @param nickname    旧昵称
     */
    public static void start(Context context, String groupChatId, String nickname) {
        Bundle bundle = new Bundle();
        bundle.putString(GROUP_CHAT_ID, groupChatId);
        bundle.putString(NICKNAME, nickname);
        context.startActivity(ContainerActivity.getJumpIntent(context, SetNicknameInGroupChatFragment.class, bundle));
    }

}