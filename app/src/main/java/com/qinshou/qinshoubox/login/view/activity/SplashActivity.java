package com.qinshou.qinshoubox.login.view.activity;

import android.content.Intent;
import android.view.View;

import com.qinshou.commonmodule.base.AbsMVPActivity;
import com.qinshou.commonmodule.widget.CountDownView;
import com.qinshou.qinshoubox.MainActivity;
import com.qinshou.qinshoubox.R;
import com.qinshou.qinshoubox.login.presenter.SplashPresenter;
import com.qinshou.qinshoubox.login.contract.ISplashContract;

/**
 * Description:闪屏界面
 * Author: QinHao
 * Date: 2019/4/4 19:24
 */
public class SplashActivity extends AbsMVPActivity<SplashPresenter> implements ISplashContract.ISplashView {
    private CountDownView mCountDownView;

    @Override
    public int getLayoutId() {
        return R.layout.activity_splash;
    }

    @Override
    public void initView() {
        mCountDownView = findViewByID(R.id.count_down_view);
    }

    @Override
    public void setListener() {
        mCountDownView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jumpToMainActivity();
            }
        });
        mCountDownView.setOnCountDownListener(new CountDownView.onCountDownListener() {
            @Override
            public void onTick(int tick) {

            }

            @Override
            public void onFinish() {
                jumpToMainActivity();
            }
        });
    }

    @Override
    public void initData() {
    }

    private void jumpToMainActivity() {
        if (isFinishing()) {
            return;
        }
        startActivity(new Intent(getContext(), MainActivity.class));
//        startActivity(ContainerActivity.getJumpIntent(getContext(), LoginOrRegisterFragment.class));
        finish();
    }
}
