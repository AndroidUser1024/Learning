package com.qinshou.qinshoubox.friend.view.fragment;

import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.qinshou.commonmodule.widget.TitleBar;
import com.qinshou.qinshoubox.R;
import com.qinshou.qinshoubox.base.QSFragment;
import com.qinshou.qinshoubox.friend.contract.IAddFriendContract;
import com.qinshou.qinshoubox.friend.presenter.AddFriendPresenter;
import com.qinshou.qinshoubox.listener.ClearErrorInfoTextWatcher;
import com.qinshou.qinshoubox.me.bean.UserBean;
import com.qinshou.qinshoubox.util.userstatusmanager.UserStatusManager;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/08/21 14:25
 * Description:新的朋友界面
 */
public class AddFriendFragment extends QSFragment<AddFriendPresenter> implements IAddFriendContract.IView {
    private TitleBar mTitleBar;
    /**
     * 帐号/手机号/邮箱输入框
     */
    private EditText mEtKeyword;
    /**
     * 输入框提示
     */
    private LinearLayout mLlHint;
    /**
     * 清空输入框的按钮
     */
    private ImageView mIvClear;
    /**
     * 搜索按钮
     */
    private Button mBtnSearch;
    /**
     * 搜索结果为空  视图
     */
    private LinearLayout mLlEmptyView;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_add_friend;
    }

    @Override
    public void initView() {
        mTitleBar = findViewByID(R.id.title_bar);
        mLlHint = findViewByID(R.id.ll_hint);
        mEtKeyword = findViewByID(R.id.et_keyword);
        mIvClear = findViewByID(R.id.iv_clear);
        mBtnSearch = findViewByID(R.id.btn_search);
        mLlEmptyView = findViewByID(R.id.ll_empty_view);
    }

    @Override
    public void setListener() {
        mTitleBar.setLeftTextOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        mBtnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String keyword = mEtKeyword.getText().toString().trim();
                if (TextUtils.isEmpty(keyword)) {
                    return;
                }
                getPresenter().getUserDetail(UserStatusManager.SINGLETON.getUserBean().getId(), keyword);
            }
        });
        mEtKeyword.addTextChangedListener(new ClearErrorInfoTextWatcher(null) {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                super.onTextChanged(s, start, before, count);
                mLlEmptyView.setVisibility(View.GONE);
                boolean empty = TextUtils.isEmpty(mEtKeyword.getText());
                mBtnSearch.setEnabled(!empty);
                mLlHint.setVisibility(empty ? View.VISIBLE : View.GONE);
                mIvClear.setVisibility(empty ? View.GONE : View.VISIBLE);
            }
        });
        mIvClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEtKeyword.setText("");
            }
        });
    }

    @Override
    public void initData() {

    }

    @Override
    public void getUserDetailSuccess(UserBean userBean) {
        UserDetailFragment.start(getContext(), mEtKeyword.getText().toString().trim());
    }

    @Override
    public void getUserDetailFailure(Exception e) {
        mLlEmptyView.setVisibility(View.VISIBLE);
    }
}