package com.qinshou.commonmodule.widget.chartview.component;

/**
 * Description:数据点
 * Created by 禽兽先生
 * Created on 2018/3/13
 */

public class DataPoint implements Cloneable {
    private float x;
    private float y;

    public DataPoint(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    @Override
    protected DataPoint clone() {
        try {
            DataPoint dataPoint = (DataPoint) super.clone();
            dataPoint.x = this.x;
            dataPoint.y = this.y;
            return dataPoint;
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String toString() {
        return "DataPoint{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
