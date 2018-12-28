package com.qinshou.commonmodule.widget.chartview.component;

/**
 * Description:高亮显示的数据点
 * Created by 禽兽先生
 * Created on 2018/4/3
 */

public class HighlightPoint {
    private float x;
    private float y;
    private float radius;
    private int color;

    public HighlightPoint() {

    }

    public HighlightPoint(float x, float y) {
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
        return "HighlightPoint{" +
                "x=" + x +
                ", y=" + y +
                ", radius=" + radius +
                ", color=" + color +
                '}';
    }
}
