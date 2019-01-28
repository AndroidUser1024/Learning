package com.qinshou.commonmodule.widget.chartview.component;

/**
 * Description:高亮显示的数据点
 * Created by 禽兽先生
 * Created on 2018/4/3
 */

public class HighlightDataPoint {
    private DataLine mDataLine; //需要显示高亮数据点的数据线
    private DataColumn mDataColumn; //需要显示高亮数据点的数据柱
    private int index;  //需要高亮显示的数据点在数据集合中的下标
    private float radius;
    private int color;

    public HighlightDataPoint(DataLine dataLine, int index) {
        this.mDataLine = dataLine;
        this.index = index;
    }

    public HighlightDataPoint(DataColumn dataColumn, int index) {
        this.mDataColumn = dataColumn;
        this.index = index;
    }

    public DataLine getDataLine() {
        return mDataLine;
    }

    public void setDataLine(DataLine dataLine) {
        mDataLine = dataLine;
    }

    public DataColumn getDataColumn() {
        return mDataColumn;
    }

    public void setDataColumn(DataColumn dataColumn) {
        mDataColumn = dataColumn;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public float getRadius() {
        return radius;
    }

    public void setRadius(float radius) {
        this.radius = radius;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "HighlightDataPoint{" +
                "mDataLine=" + mDataLine +
                ", mDataColumn=" + mDataColumn +
                ", index=" + index +
                ", radius=" + radius +
                ", color=" + color +
                '}';
    }
}
