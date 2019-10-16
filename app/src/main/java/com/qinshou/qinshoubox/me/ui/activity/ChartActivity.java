package com.qinshou.qinshoubox.me.ui.activity;

import android.graphics.Color;

import com.qinshou.commonmodule.widget.chartview.ColumnChartView;
import com.qinshou.commonmodule.widget.chartview.LineChartView;
import com.qinshou.commonmodule.widget.chartview.component.AxisText;
import com.qinshou.commonmodule.widget.chartview.component.DataColumn;
import com.qinshou.commonmodule.widget.chartview.component.DataLine;
import com.qinshou.commonmodule.widget.chartview.component.DataPoint;
import com.qinshou.commonmodule.widget.chartview.component.HighlightDataPoint;
import com.qinshou.commonmodule.widget.chartview.component.HorizontalLine;
import com.qinshou.commonmodule.widget.chartview.component.IAxisTextFormatter;
import com.qinshou.qinshoubox.R;
import com.qinshou.qinshoubox.base.MyBaseActivity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class ChartActivity extends MyBaseActivity {
    private static final int MSG_DRAW = 1;
    private LineChartView mLineChartView;
    private ColumnChartView mColumnChartView;

    @Override
    public int getLayoutId() {
        return R.layout.activity_chart;
    }

    @Override
    public void initView() {
        mColumnChartView = findViewById(R.id.column_chart_view);
        mLineChartView = findViewById(R.id.line_chart_view);
    }

    @Override
    public void setListener() {

    }

    @Override
    public void initData() {
        drawColumnChartView();
        drawLineChartView();
    }

    private void drawLineChartView() {
        mLineChartView.setBgColor(Color.parseColor("#FF000000"));
        mLineChartView.setTouchLineColor(Color.parseColor("#FFFFFFFF"));
        mLineChartView.setTouchLineTextColor(Color.parseColor("#FFFFFFFF"));

        DataLine dataLine1 = new DataLine();
        dataLine1.setColor(Color.parseColor("#FFFFFFFF"));
        dataLine1.setWidth(3f);

        List<Float> nowPriceList = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            DataPoint dataPoint = new DataPoint(i, new Random().nextInt(20));
            dataLine1.addDataPoint(dataPoint);
            nowPriceList.add(dataPoint.getY());
        }
        mLineChartView.addDataLine(dataLine1);
        float yMin = Collections.min(nowPriceList);
        mLineChartView.setYMin(yMin);
//        mLineChartView.setYMax(dataBean.getYesterdayClose() + (dataBean.getYesterdayClose() - yMin));

        mLineChartView.getAxisX().setAxisTextFormatter(new IAxisTextFormatter() {
            @Override
            public AxisText formatAxisText(int position, AxisText axisText) {
                return null;
            }
        });

        HighlightDataPoint highlightDataPoint1 = new HighlightDataPoint(dataLine1, dataLine1.getSize() - 1);
        highlightDataPoint1.setRadius(5f);
        highlightDataPoint1.setColor(Color.parseColor("#FFFF0000"));
        mLineChartView.addHighlightDataPoint(highlightDataPoint1);

        HorizontalLine horizontalLine = new HorizontalLine();
        horizontalLine.setColor(Color.parseColor("#FFFFFF00"));
        horizontalLine.setDashEffect(new HorizontalLine.DashEffect(10f, 10f, 0));
        horizontalLine.setShowText(true);
        horizontalLine.setTextColor(Color.parseColor("#FFFFFFFF"));
        mLineChartView.addHorizontalLine(horizontalLine);

        mLineChartView.setAnimateDraw(true);
        mLineChartView.draw();
    }

    private void drawColumnChartView() {
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
        mColumnChartView.setYMax(20);
        mColumnChartView.addDataColumn(dataColumn1);
        mColumnChartView.addDataColumn(dataColumn2);
        mColumnChartView.addDataColumn(dataColumn3);

        HighlightDataPoint highlightDataPoint3 = new HighlightDataPoint(dataColumn3, dataColumn3.getSize() - 1);
        highlightDataPoint3.setRadius(5f);
        highlightDataPoint3.setColor(Color.BLACK);
        mColumnChartView.addHighlightDataPoint(highlightDataPoint3);

        HighlightDataPoint highlightDataPoint4 = new HighlightDataPoint(dataColumn2, dataColumn3.getSize() - 1);
        highlightDataPoint4.setRadius(5f);
        highlightDataPoint4.setColor(Color.BLACK);
        mColumnChartView.addHighlightDataPoint(highlightDataPoint4);

        mColumnChartView.setAnimateDraw(true);
        mColumnChartView.draw();
    }
}
