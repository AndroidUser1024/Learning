package com.qinshou.commonmodule.widget.chartview.component;

/**
 * Description:数据点
 * Created by 禽兽先生
 * Created on 2018/3/13
 */

public class Point {
    private float x;
    private float y;

    public Point(float x, float y) {
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
    public String toString() {
        return "DataPoint{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
