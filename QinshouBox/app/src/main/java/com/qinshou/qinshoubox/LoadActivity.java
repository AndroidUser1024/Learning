package com.qinshou.qinshoubox;

import android.content.Intent;
import android.view.View;

import com.qinshou.commonmodule.widget.CountDownView;
import com.qinshou.qinshoubox.base.MyBaseActivity;

public class LoadActivity extends MyBaseActivity {

    private CountDownView countDownView;

    @Override
    public boolean getIsImmersive() {
        return true;
    }

    @Override
    public boolean getStatusBarIsDark() {
        return true;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_load;
    }

    @Override
    public void setPresenter() {

    }

    @Override
    public void initView() {
        countDownView = findViewByID(R.id.count_down_view);
    }

    @Override
    public void setListener() {
        countDownView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jumpToMainActivity();
            }
        });
        countDownView.setOnCountDownListener(new CountDownView.onCountDownListener() {
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
        startActivity(new Intent(LoadActivity.this, MainActivity.class));
        finish();
    }
}
