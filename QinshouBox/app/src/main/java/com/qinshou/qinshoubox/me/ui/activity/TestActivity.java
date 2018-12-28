package com.qinshou.qinshoubox.me.ui.activity;

import android.graphics.Color;

import com.qinshou.commonmodule.chartview.ChartView;
import com.qinshou.commonmodule.chartview.component.DataLine;
import com.qinshou.commonmodule.chartview.component.DataPoint;
import com.qinshou.commonmodule.chartview.component.HorizontalLine;
import com.qinshou.qinshoubox.R;
import com.qinshou.qinshoubox.base.MyBaseActivity;

import java.util.Random;

public class TestActivity extends MyBaseActivity {
    private ChartView mChartView;

    @Override
    public int getLayoutId() {
        return R.layout.activity_test;
    }

    @Override
    public void setPresenter() {

    }

    @Override
    public void initView() {
        mChartView = findViewByID(R.id.chart_view);
    }

    @Override
    public void setListener() {

    }

    @Override
    public void initData() {
    }
}
