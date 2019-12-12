package com.qinshou.qinshoubox.login.view.activity;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import com.qinshou.commonmodule.base.AbsMVPActivity;
import com.qinshou.commonmodule.widget.CountDownView;
import com.qinshou.qinshoubox.MainActivity;
import com.qinshou.qinshoubox.R;
import com.qinshou.qinshoubox.base.QSActivity;
import com.qinshou.qinshoubox.homepage.bean.EventBean;
import com.qinshou.qinshoubox.login.bean.PoemBean;
import com.qinshou.qinshoubox.login.presenter.SplashPresenter;
import com.qinshou.qinshoubox.login.contract.ISplashContract;

/**
 * Description:闪屏界面
 * Author: QinHao
 * Date: 2019/4/4 19:24
 */
public class SplashActivity extends QSActivity<SplashPresenter> implements ISplashContract.ISplashView {
    private CountDownView mCountDownView;
    private TextView mTvContent;
    private TextView mTvTitle;
    private TextView mTvAuthor;

    @Override
    public int getLayoutId() {
        return R.layout.activity_splash;
    }

    @Override
    public void initView() {
        mCountDownView = findViewByID(R.id.count_down_view);
        mTvContent = findViewByID(R.id.tv_content);
        mTvTitle = findViewByID(R.id.tv_title);
        mTvAuthor = findViewByID(R.id.tv_author);
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
        getPresenter().getRandomPoem();
    }

    @Override
    public void handleEvent(EventBean<Object> eventBean) {
    }

    private void jumpToMainActivity() {
        if (isFinishing()) {
            return;
        }
        startActivity(new Intent(getContext(), MainActivity.class));
//        startActivity(ContainerActivity.getJumpIntent(getContext(), LoginOrRegisterFragment.class));
        finish();
    }

    @Override
    public void getRandomSuccess(PoemBean poemBean) {
        String content = poemBean.getContent();
        content = content.replace("，", "\n")
                .replace("。", "\n");
        String[] split = content.split("\n");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < split.length; i++) {
            stringBuilder.append(split[i]);
            if (i == 2) {
                break;
            } else {
                stringBuilder.append("\n");
            }
        }
        mTvContent.setText(stringBuilder);
        mTvTitle.setText("--" + poemBean.getTitle());
        mTvAuthor.setText("--" + poemBean.getAuthor());
    }

    @Override
    public void getRandomFailure(Exception e) {

    }
}
