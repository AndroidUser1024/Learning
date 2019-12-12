package com.qinshou.qinshoubox.me.ui.activity;

import android.content.Intent;
import android.view.View;

import com.qinshou.commonmodule.base.AbsPresenter;
import com.qinshou.qinshoubox.R;
import com.qinshou.qinshoubox.base.QSActivity;
import com.qinshou.qinshoubox.homepage.bean.EventBean;

/**
 * Description:图灵机器人游戏界面
 * Created by 禽兽先生
 * Created on 2018/8/29
 */

public class TurningRobotActivity extends QSActivity<AbsPresenter> {

    @Override
    public int getLayoutId() {
        return R.layout.activity_turning_robot;
    }

    @Override
    public void initView() {
    }

    @Override
    public void setListener() {
        findViewByID(R.id.btn_record_1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), RecordActivity1.class));
            }
        });
        findViewByID(R.id.btn_record_2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), RecordActivity2.class));
            }
        });
    }

    @Override
    public void initData() {
    }

    @Override
    public void handleEvent(EventBean<Object> eventBean) {
    }
}
