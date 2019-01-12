package com.qinshou.qinshoubox.me.ui.activity;

import android.graphics.Color;

import com.qinshou.commonmodule.widget.chartview.LineChartView;
import com.qinshou.qinshoubox.R;
import com.qinshou.qinshoubox.base.MyBaseActivity;

import java.util.Random;

public class TestActivity extends MyBaseActivity {
    private LineChartView mLineChartView;

    @Override
    public int getLayoutId() {
        return R.layout.activity_test;
    }

    @Override
    public void setPresenter() {

    }

    @Override
    public void initView() {
        mLineChartView = findViewByID(R.id.chart_view);
    }

    @Override
    public void setListener() {

    }

    @Override
    public void initData() {
    }
}
