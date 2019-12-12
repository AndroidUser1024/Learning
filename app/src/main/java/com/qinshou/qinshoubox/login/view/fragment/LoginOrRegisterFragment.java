package com.qinshou.qinshoubox.login.view.fragment;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.qinshou.commonmodule.util.SharedPreferencesHelper;
import com.qinshou.commonmodule.util.ShowLogUtil;
import com.qinshou.commonmodule.util.SoftKeyboardUtil;
import com.qinshou.qinshoubox.R;
import com.qinshou.qinshoubox.base.QSFragment;
import com.qinshou.qinshoubox.constant.IConstant;
import com.qinshou.qinshoubox.homepage.bean.EventBean;
import com.qinshou.qinshoubox.login.bean.UserBean;
import com.qinshou.qinshoubox.login.contract.ILoginOrRegisterContract;
import com.qinshou.qinshoubox.login.presenter.LoginOrRegisterPresenter;
import com.qinshou.qinshoubox.util.userstatusmanager.UserStatusManager;

/**
 * Description:登录注册界面
 * Author: QinHao
 * Date: 2019/5/5 17:16
 */
public class LoginOrRegisterFragment extends QSFragment<LoginOrRegisterPresenter> implements ILoginOrRegisterContract.IView {
    /**
     * 登录文本框
     */
    private TextView mTvLogin;
    /**
     * 注册文本框
     */
    private TextView mTvRegister;
    /**
     * 用户名输入框
     */
    private EditText mEtUsername;
    /**
     * 密码输入框
     */
    private EditText mEtPassword;
    /**
     * 登录注册按钮
     */
    private Button mBtnLoginOrRegister;
    /**
     * 输入框部分的布局
     */
    private LinearLayout mLlInput;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_login;
    }

    @Override
    public void initView() {
        mTvLogin = findViewByID(R.id.tv_click_2_login);
        mTvRegister = findViewByID(R.id.tv_register);
        mLlInput = findViewByID(R.id.ll_input);
        mBtnLoginOrRegister = findViewByID(R.id.btn_login_or_register);
        mEtUsername = findViewByID(R.id.et_username);
        mEtUsername.setText(SharedPreferencesHelper.SINGLETON.getString(IConstant.SP_KEY_LAST_LOGIN_USERNAME));
        mEtPassword = findViewByID(R.id.et_password);
    }

    @Override
    public void setListener() {
        // 点击外部区域关闭软键盘
        findViewByID(R.id.cl_root).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SoftKeyboardUtil.hideSoftKeyboard(getActivity());
            }
        });
        mTvRegister.setOnClickListener(mTvRegisterOnClickListener);
        mBtnLoginOrRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.equals(mBtnLoginOrRegister.getText(), getString(R.string.login_btn_login_or_register_text))) {
                    login();
                } else if (TextUtils.equals(mBtnLoginOrRegister.getText(), getString(R.string.login_btn_login_or_register_text2))) {
                    register();
                }
            }
        });
    }

    @Override
    public void initData() {

    }

    @Override
    public void handleEvent(EventBean<Object> eventBean) {
    }

    @Override
    public void loginSuccess(final UserBean userBean) {
        ShowLogUtil.logi("loginSuccess" + " : " + "userBean--->" + userBean);
        UserStatusManager.SINGLETON.login(getContext(), userBean);
    }

    @Override
    public void loginFailure(Exception e) {
        ShowLogUtil.logi("loginFailure" + " : " + "e--->" + e.getMessage());
        toastShort(e.getMessage());
    }

    @Override
    public void registerSuccess(UserBean userBean) {
        ShowLogUtil.logi("registerSuccess" + " : " + "userBean--->" + userBean);
        String username = mEtUsername.getText().toString().trim();
        String password = mEtPassword.getText().toString().trim();
        getPresenter().login(username, password);
    }

    @Override
    public void registerFailure(Exception e) {
        ShowLogUtil.logi("registerFailure" + " : " + "e--->" + e.getMessage());
        toastShort(e.getMessage());
    }

    /**
     * 登录按钮的点击事件监听器,当前显示注册状态的 UI 时才设置
     */
    private View.OnClickListener mTvLoginOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            float x1 = mTvRegister.getX();
            float y1 = mTvRegister.getY();
            float x2 = mTvLogin.getX();
            float y2 = mTvLogin.getY();
            // 注册文本框从原本位置移动到登录文本框的位置
            ObjectAnimator objectAnimator1 = ObjectAnimator.ofFloat(mTvRegister, "x", x1, x2 + mTvLogin.getMeasuredWidth() - mTvRegister.getMeasuredWidth());
            ObjectAnimator objectAnimator2 = ObjectAnimator.ofFloat(mTvRegister, "y", y1, y2);
            // 登录文本框从原本位置移动到注册文本框的位置
            ObjectAnimator objectAnimator3 = ObjectAnimator.ofFloat(mTvLogin, "x", x2, x1);
            ObjectAnimator objectAnimator4 = ObjectAnimator.ofFloat(mTvLogin, "y", y2, y1);
            // 注册文本框变半透明
            ObjectAnimator objectAnimator5 = ObjectAnimator.ofFloat(mTvRegister, "alpha", 1f, 0.5f);
            // 登录文本框变不透明
            ObjectAnimator objectAnimator6 = ObjectAnimator.ofFloat(mTvLogin, "alpha", 0.5f, 1f);
            // 输入框部分的动画
            ObjectAnimator objectAnimator7 = ObjectAnimator.ofFloat(mLlInput, "y", mLlInput.getY(), mLlInput.getY() + 200, mLlInput.getY());
            ObjectAnimator objectAnimator8 = ObjectAnimator.ofFloat(mLlInput, "alpha", 1f, 0.1f, 1f);
            objectAnimator8.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    float animatedValue = (float) animation.getAnimatedValue();
                    if (animatedValue < 0.2f) {
                        mBtnLoginOrRegister.setText(getString(R.string.login_btn_login_or_register_text));
                        mEtUsername.setText("");
                        mEtPassword.setText("");
                    }
                }
            });
            objectAnimator8.addListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationStart(Animator animation) {
                    super.onAnimationStart(animation);
                    mTvRegister.setOnClickListener(null);
                    mTvLogin.setOnClickListener(null);
                }

                @Override
                public void onAnimationEnd(Animator animation) {
                    super.onAnimationEnd(animation);
                    mTvRegister.setOnClickListener(mTvRegisterOnClickListener);
                    mTvLogin.setOnClickListener(null);
                }
            });
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setInterpolator(new LinearInterpolator());
            animatorSet.play(objectAnimator1)
                    .with(objectAnimator2)
                    .with(objectAnimator3)
                    .with(objectAnimator4)
                    .with(objectAnimator5)
                    .with(objectAnimator6)
                    .with(objectAnimator7)
                    .with(objectAnimator8);
            animatorSet.setDuration(800);
            animatorSet.start();
        }
    };

    /**
     * 注册按钮的点击事件监听器,当前显示登录状态的 UI 时才设置
     */
    private View.OnClickListener mTvRegisterOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            float x1 = mTvLogin.getX();
            float y1 = mTvLogin.getY();
            float x2 = mTvRegister.getX();
            float y2 = mTvRegister.getY();
            // 登录文本框从原本位置移动到注册文本框的位置
            ObjectAnimator objectAnimator1 = ObjectAnimator.ofFloat(mTvLogin, "x", x1, x2 + mTvRegister.getMeasuredWidth() - mTvLogin.getMeasuredWidth());
            ObjectAnimator objectAnimator2 = ObjectAnimator.ofFloat(mTvLogin, "y", y1, y2);
            // 注册文本框从原本位置移动到登录文本框的位置
            ObjectAnimator objectAnimator3 = ObjectAnimator.ofFloat(mTvRegister, "x", x2, x1);
            ObjectAnimator objectAnimator4 = ObjectAnimator.ofFloat(mTvRegister, "y", y2, y1);
            // 登录文本框变半透明
            ObjectAnimator objectAnimator5 = ObjectAnimator.ofFloat(mTvLogin, "alpha", 1f, 0.5f);
            // 注册文本框变不透明
            ObjectAnimator objectAnimator6 = ObjectAnimator.ofFloat(mTvRegister, "alpha", 0.5f, 1f);
            // 输入框部分的动画
            ObjectAnimator objectAnimator7 = ObjectAnimator.ofFloat(mLlInput, "y", mLlInput.getY(), mLlInput.getY() + 200, mLlInput.getY());
            ObjectAnimator objectAnimator8 = ObjectAnimator.ofFloat(mLlInput, "alpha", 1f, 0.1f, 1f);
            objectAnimator8.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    float animatedValue = (float) animation.getAnimatedValue();
                    if (animatedValue < 0.2f) {
                        mBtnLoginOrRegister.setText(getString(R.string.login_btn_login_or_register_text2));
                        mEtUsername.setText("");
                        mEtPassword.setText("");
                    }
                }
            });
            objectAnimator8.addListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationStart(Animator animation) {
                    super.onAnimationStart(animation);
                    mTvRegister.setOnClickListener(null);
                    mTvLogin.setOnClickListener(null);
                }

                @Override
                public void onAnimationEnd(Animator animation) {
                    super.onAnimationEnd(animation);
                    mTvLogin.setOnClickListener(mTvLoginOnClickListener);
                    mTvRegister.setOnClickListener(null);
                }
            });
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setInterpolator(new LinearInterpolator());
            animatorSet.play(objectAnimator1)
                    .with(objectAnimator2)
                    .with(objectAnimator3)
                    .with(objectAnimator4)
                    .with(objectAnimator5)
                    .with(objectAnimator6)
                    .with(objectAnimator7)
                    .with(objectAnimator8);
            animatorSet.setDuration(800);
            animatorSet.start();
        }
    };

    /**
     * Author: QinHao
     * Email:cqflqinhao@126.com
     * Date:2019/9/19 14:53
     * Description:登录
     */
    private void login() {
        SoftKeyboardUtil.hideSoftKeyboard(getActivity());
        String username = mEtUsername.getText().toString().trim();
        String password = mEtPassword.getText().toString().trim();
        if (TextUtils.isEmpty(username)) {
            toastShort(mEtPassword.getHint().toString());
            return;
        }
        if (TextUtils.isEmpty(username)) {
            toastShort(mEtPassword.getHint().toString());
            return;
        }
        getPresenter().login(username, password);
    }

    /**
     * Author: QinHao
     * Email:cqflqinhao@126.com
     * Date:2019/9/19 14:53
     * Description:注册
     */
    private void register() {
        SoftKeyboardUtil.hideSoftKeyboard(getActivity());
        String username = mEtUsername.getText().toString().trim();
        String password = mEtPassword.getText().toString().trim();
        if (TextUtils.isEmpty(username)) {
            toastShort(mEtPassword.getHint().toString());
            return;
        }
        if (TextUtils.isEmpty(username)) {
            toastShort(mEtPassword.getHint().toString());
            return;
        }
        getPresenter().register(username, password);
    }
}
