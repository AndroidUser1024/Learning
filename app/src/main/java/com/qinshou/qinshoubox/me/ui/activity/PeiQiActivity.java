package com.qinshou.qinshoubox.me.ui.activity;

import android.view.View;

import com.qinshou.commonmodule.base.AbsPresenter;
import com.qinshou.qinshoubox.R;
import com.qinshou.qinshoubox.base.QSActivity;
import com.qinshou.qinshoubox.homepage.bean.EventBean;
import com.qinshou.qinshoubox.me.ui.widget.PeiQiView;

/**
 * Create By:禽兽先生
 * Create On:2019-03-05 22:56
 * Description:
 */
public class PeiQiActivity extends QSActivity<AbsPresenter> {

    @Override
    public int getLayoutId() {
        return R.layout.activity_pei_qi;
    }

    @Override
    public void initView() {

    }

    @Override
    public void setListener() {
        findViewById(R.id.btn_next).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((PeiQiView) findViewById(R.id.pei_qi_view)).drawPeiQi();
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
