package com.qinshou.commonmodule.widget.chartview.component;

import android.graphics.Color;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Description:
 * Created by 禽兽先生
 * Created on 2019/1/16
 */
public class DataColumn implements Cloneable {
    private ArrayList<DataPoint> mDataPointList;
    private int color;
    private int marginLeft;
    private int marginRight;

    public DataColumn() {
        this.mDataPointList = new ArrayList<>();
        this.color = Color.parseColor("#FF000000");
    }

    public void setDataPointList(ArrayList<DataPoint> dataPointList) {
        mDataPointList = dataPointList;
    }

    public List<DataPoint> getDataPointList() {
        return mDataPointList;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public int getMarginLeft() {
        return marginLeft;
    }

    public void setMarginLeft(int marginLeft) {
        this.marginLeft = marginLeft;
    }

    public int getMarginRight() {
        return marginRight;
    }

    public void setMarginRight(int marginRight) {
        this.marginRight = marginRight;
    }

    @Override
    protected DataColumn clone() {
        try {
            DataColumn dataColumn = (DataColumn) super.clone();
            dataColumn.mDataPointList = (ArrayList<DataPoint>) this.mDataPointList.clone();
            dataColumn.color = this.color;
            dataColumn.marginLeft = this.marginLeft;
            dataColumn.marginRight = this.marginRight;
            return dataColumn;
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void addDataPoint(DataPoint dataPoint) {
        mDataPointList.add(dataPoint);
    }

    public DataPoint removeDataPoint(int index) {
        return mDataPointList.remove(index);
    }

    public boolean removeDataPoint(DataPoint dataPoint) {
        return mDataPointList.remove(dataPoint);
    }

    public void clearDataPointList() {
        mDataPointList.clear();
    }

    /**
     * Description:返回数据个数
     * Date:2018/3/13
     */
    public int getSize() {
        return mDataPointList.size();
    }

    /**
     * Description:返回所有数据中的最大 y 值和最小 y 值的差值
     * Date:2018/3/13
     */
    public float getDiff() {
        List<Float> yList = new ArrayList<>();
        for (int i = 0; i < mDataPointList.size(); i++) {
            yList.add(mDataPointList.get(i).getY());
        }
        return Collections.max(yList) - Collections.min(yList);
    }

    /**
     * Description:返回所有数据中的最大 y 值
     * Date:2018/3/13
     */
    public float getMax() {
        if (mDataPointList == null || mDataPointList.isEmpty()) {
            return 0;
        }
        List<Float> yList = new ArrayList<>();
        for (int i = 0; i < mDataPointList.size(); i++) {
            yList.add(mDataPointList.get(i).getY());
        }
        return Collections.max(yList);
    }

    /**
     * Description:返回所有数据中的最小 y 值
     * Date:2018/3/13
     */
    public float getMin() {
        if (mDataPointList == null || mDataPointList.isEmpty()) {
            return 0;
        }
        List<Float> yList = new ArrayList<>();
        for (int i = 0; i < mDataPointList.size(); i++) {
            yList.add(mDataPointList.get(i).getY());
        }
        return Collections.min(yList);
    }
}
