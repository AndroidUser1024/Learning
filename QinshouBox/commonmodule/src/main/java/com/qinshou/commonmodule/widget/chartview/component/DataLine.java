package com.qinshou.commonmodule.widget.chartview.component;

import android.graphics.Color;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Description:数据线
 * Created by 禽兽先生
 * Created on 2018/3/13
 */

public class DataLine {
    private List<DataPoint> mDataPointList;
    private int color;
    private float width;
    private Type mType;
    private boolean fill;
    private int[] fillColors;

    public enum Type {
        LINEAR,    //普通折线图,默认
        BEZIER, //平滑曲线图
    }

    public DataLine() {
        this.mDataPointList = new ArrayList<>();
        this.color = Color.parseColor("#FF000000");
        this.width = 1f;
        this.mType = Type.LINEAR;
        this.fill = false;
        this.fillColors = new int[]{Color.parseColor("#FF000000"), Color.parseColor("#FF000000")};
    }

    public List<DataPoint> getDataPointList() {
        return mDataPointList;
    }

    public void setDataPointList(List<DataPoint> dataPointList) {
        this.mDataPointList = dataPointList;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public Type getType() {
        return mType;
    }

    public void setType(Type type) {
        this.mType = type;
    }

    public boolean isFill() {
        return fill;
    }

    public void setFill(boolean fill) {
        this.fill = fill;
    }

    public int[] getFillColors() {
        return fillColors;
    }

    public void setFillColors(int[] fillColors) {
        if (fillColors == null) {
            throw new NullPointerException("fillColors must not be null");
        }
        if (fillColors.length < 2) {
            throw new IllegalArgumentException("needs >= 2 number of colors");
        }
        this.fillColors = fillColors;
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

    @Override
    public String toString() {
        return "DataLine{" +
                "mDataPointList=" + mDataPointList +
                ", color=" + color +
                ", mType=" + mType +
                ", width=" + width +
                '}';
    }
}
