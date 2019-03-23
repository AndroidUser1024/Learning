package com.qinshou.qinshoubox.me.ui.activity;

import android.graphics.Color;
import android.support.annotation.ColorRes;
import android.util.Log;

import com.qinshou.commonmodule.widget.chartview.ColumnChartView;
import com.qinshou.commonmodule.widget.chartview.LineChartView;
import com.qinshou.commonmodule.widget.chartview.component.AxisText;
import com.qinshou.commonmodule.widget.chartview.component.DataColumn;
import com.qinshou.commonmodule.widget.chartview.component.DataLine;
import com.qinshou.commonmodule.widget.chartview.component.DataPoint;
import com.qinshou.commonmodule.widget.chartview.component.HighlightDataPoint;
import com.qinshou.commonmodule.widget.chartview.component.HorizontalLine;
import com.qinshou.commonmodule.widget.chartview.component.IAxisTextFormatter;
import com.qinshou.networkmodule.okhttp.OkHttpUtil;
import com.qinshou.networkmodule.okhttp.Parameter;
import com.qinshou.networkmodule.okhttp.callback.ARequestCallback;
import com.qinshou.qinshoubox.R;
import com.qinshou.qinshoubox.base.MyBaseActivity;
import com.qinshou.qinshoubox.me.bean.RealTimeTimeSharingBean;
import com.qinshou.qinshoubox.me.bean.YiYuanApiResultBean;
import com.qinshou.qinshoubox.network.IUrlConstants;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class ChartActivity extends MyBaseActivity {
    private LineChartView mLineChartView;

    @Override
    public int getLayoutId() {
        return R.layout.activity_chart;
    }

    @Override
    public void setPresenter() {

    }

    @Override
    public void initView() {
    }

    @Override
    public void setListener() {

    }

    @Override
    public void initData() {
        OkHttpUtil.getInstance().request(OkHttpUtil.Method.GET, IUrlConstants.GET_REAL_TIME_TIME_SHARING_DATA, new ARequestCallback<YiYuanApiResultBean<RealTimeTimeSharingBean>>() {
            @Override
            public void onSuccess(YiYuanApiResultBean<RealTimeTimeSharingBean> data) {
                Log.i("daolema", "data--->" + data);
                if (data.getT() == null || data.getT().getDataBeanList() == null || data.getT().getDataBeanList().size() == 0) {
                    return;
                }
                drawRealTimeTimeSharingChart(data.getT().getDataBeanList().get(0));
            }

            @Override
            public void onFailure(Exception e) {
                Log.i("daolema", "e--->" + e.getMessage());
            }
        }, new Parameter("showapi_appid", "60420"), new Parameter("showapi_sign", "b9db6f8d15a849619c72bfc7e0744c41"), new Parameter("code", "300355"));

        ColumnChartView columnChartView = findViewById(R.id.column_chart_view);

        DataColumn dataColumn1 = new DataColumn();
        dataColumn1.setColor(Color.parseColor("#FF4A93FA"));
        dataColumn1.setMarginLeft(30);
        dataColumn1.setMarginRight(-10);

        DataColumn dataColumn2 = new DataColumn();
        dataColumn2.setColor(Color.parseColor("#FFE60012"));
        dataColumn2.setMarginLeft(10);
        dataColumn2.setMarginRight(10);

        DataColumn dataColumn3 = new DataColumn();
        dataColumn3.setColor(Color.parseColor("#FFFFFF00"));
        dataColumn3.setMarginLeft(-10);
        dataColumn3.setMarginRight(30);
        for (int i = 0; i < 5; i++) {
            dataColumn1.addDataPoint(new DataPoint(i, new Random().nextInt(10) + 5));
            dataColumn2.addDataPoint(new DataPoint(i, new Random().nextInt(10) + 5));
            dataColumn3.addDataPoint(new DataPoint(i, new Random().nextInt(10) + 5));
        }
        columnChartView.setYMax(20);
        columnChartView.addDataColumn(dataColumn1);
        columnChartView.addDataColumn(dataColumn2);
        columnChartView.addDataColumn(dataColumn3);

        HighlightDataPoint highlightDataPoint3 = new HighlightDataPoint(dataColumn3, dataColumn3.getSize() - 1);
        highlightDataPoint3.setRadius(5f);
        highlightDataPoint3.setColor(Color.BLACK);
        columnChartView.addHighlightDataPoint(highlightDataPoint3);

        HighlightDataPoint highlightDataPoint4 = new HighlightDataPoint(dataColumn2, dataColumn3.getSize() - 1);
        highlightDataPoint4.setRadius(5f);
        highlightDataPoint4.setColor(Color.BLACK);
        columnChartView.addHighlightDataPoint(highlightDataPoint4);

        columnChartView.setAnimateDraw(true);
        columnChartView.draw();
    }

    private void drawRealTimeTimeSharingChart(RealTimeTimeSharingBean.DataBean dataBean) {
        if (dataBean == null || dataBean.getMinuteBeanList() == null || dataBean.getMinuteBeanList().size() == 0) {
            return;
        }
        LineChartView lineChartView = findViewById(R.id.line_chart_view);
        lineChartView.setBgColor(Color.parseColor("#FF000000"));
        lineChartView.setTouchLineColor(Color.parseColor("#FFFFFFFF"));
        lineChartView.setTouchLineTextColor(Color.parseColor("#FFFFFFFF"));

        DataLine dataLine1 = new DataLine();
        dataLine1.setColor(Color.parseColor("#FFFFFFFF"));
        dataLine1.setWidth(3f);

        List<Float> nowPriceList = new ArrayList<>();
        for (int i = 0; i < dataBean.getMinuteBeanList().size(); i++) {
            dataLine1.addDataPoint(new DataPoint(i, dataBean.getMinuteBeanList().get(i).getNowPrice()));
            nowPriceList.add(dataBean.getMinuteBeanList().get(i).getNowPrice());
        }
        lineChartView.addDataLine(dataLine1);
        float yMin = Collections.min(nowPriceList);
        lineChartView.setYMin(yMin);
        lineChartView.setYMax(dataBean.getYesterdayClose() + (dataBean.getYesterdayClose() - yMin));

        lineChartView.getAxisX().setAxisTextFormatter(new IAxisTextFormatter() {
            @Override
            public AxisText formatAxisText(int position, AxisText axisText) {
                return null;
            }
        });

        HighlightDataPoint highlightDataPoint1 = new HighlightDataPoint(dataLine1, dataLine1.getSize() - 1);
        highlightDataPoint1.setRadius(5f);
        highlightDataPoint1.setColor(Color.parseColor("#FFFF0000"));
        lineChartView.addHighlightDataPoint(highlightDataPoint1);

        HorizontalLine horizontalLine = new HorizontalLine();
        horizontalLine.setColor(Color.parseColor("#FFFFFF00"));
        horizontalLine.setDashEffect(new HorizontalLine.DashEffect(10f, 10f, 0));
        horizontalLine.setY(dataBean.getYesterdayClose());
        horizontalLine.setShowText(true);
        horizontalLine.setTextColor(Color.parseColor("#FFFFFFFF"));
        lineChartView.addHorizontalLine(horizontalLine);

        lineChartView.setAnimateDraw(true);
        lineChartView.draw();
    }
}
