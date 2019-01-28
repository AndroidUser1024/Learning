package com.qinshou.qinshoubox.me.ui.activity;

import android.graphics.Color;

import com.qinshou.commonmodule.widget.chartview.ColumnChartView;
import com.qinshou.commonmodule.widget.chartview.LineChartView;
import com.qinshou.commonmodule.widget.chartview.component.DataColumn;
import com.qinshou.commonmodule.widget.chartview.component.DataLine;
import com.qinshou.commonmodule.widget.chartview.component.DataPoint;
import com.qinshou.commonmodule.widget.chartview.component.HighlightDataPoint;
import com.qinshou.qinshoubox.R;
import com.qinshou.qinshoubox.base.MyBaseActivity;

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
        LineChartView lineChartView = findViewById(R.id.line_chart_view);
        ColumnChartView columnChartView = findViewById(R.id.column_chart_view);

        DataLine dataLine1 = new DataLine();
        dataLine1.setColor(Color.parseColor("#FF4A93FA"));
        dataLine1.setWidth(5f);

        DataLine dataLine2 = new DataLine();
        dataLine2.setColor(Color.parseColor("#FFE60012"));
        dataLine2.setWidth(5f);

        DataLine dataLine3 = new DataLine();
        dataLine3.setColor(Color.parseColor("#FFFFFF00"));
        dataLine3.setWidth(5f);
        for (int i = 0; i < 5; i++) {
            dataLine1.addDataPoint(new DataPoint(i, new Random().nextInt(10) + 5));
            dataLine2.addDataPoint(new DataPoint(i, new Random().nextInt(10) + 5));
            dataLine3.addDataPoint(new DataPoint(i, new Random().nextInt(10) + 5));
        }
        lineChartView.setYMax(20);
        lineChartView.addDataLine(dataLine1);
        lineChartView.addDataLine(dataLine2);
        lineChartView.addDataLine(dataLine3);

        HighlightDataPoint highlightDataPoint1 = new HighlightDataPoint(dataLine1, dataLine1.getSize() - 1);
        highlightDataPoint1.setRadius(5f);
        highlightDataPoint1.setColor(Color.BLACK);
        lineChartView.addHighlightDataPoint(highlightDataPoint1);

        HighlightDataPoint highlightDataPoint2 = new HighlightDataPoint(dataLine2, dataLine2.getSize() - 1);
        highlightDataPoint2.setRadius(5f);
        highlightDataPoint2.setColor(Color.BLACK);
        lineChartView.addHighlightDataPoint(highlightDataPoint2);

        lineChartView.setAnimateDraw(true);
        lineChartView.draw();

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
}
