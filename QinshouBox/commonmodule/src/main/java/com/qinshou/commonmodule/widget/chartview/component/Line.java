package com.qinshou.commonmodule.widget.chartview.component;

import android.graphics.Color;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Description:
 * Created by 禽兽先生
 * Created on 2018/3/13
 */

public class Line {
    private List<Point> pointList;
    private int color;
    private int fillColor;
    private Mode mode;
    private float width;

    public enum Mode {
        LINEAR,    //普通折线图,默认
        BEZIER, //平滑曲线图
        LINEAR_AND_FILL, //普通折线图并填充
        BEZIER_AND_FILL, //平滑曲线图并填充,目前动态绘制还不是很完美
    }

    public Line() {
        this.pointList = new ArrayList<>();
        this.color = Color.argb(255, 0, 0, 0);
        this.fillColor = Color.argb(127, 0, 0, 0);
        this.mode = Mode.LINEAR;
    }

    public List<Point> getPointList() {
        return pointList;
    }

    public void setPointList(List<Point> pointList) {
        this.pointList = pointList;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public int getFillColor() {
        return fillColor;
    }

    public void setFillColor(int fillColor) {
        this.fillColor = fillColor;
    }

    public Mode getMode() {
        return mode;
    }

    public void setMode(Mode mode) {
        this.mode = mode;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public void addPoint(Point point) {
        pointList.add(point);
    }

    public Point removePoint(int index) {
        return pointList.remove(index);
    }

    public boolean removePoint(Point point) {
        return pointList.remove(point);
    }

    public void clearPointList() {
        pointList.clear();
    }

    /**
     * Description:返回数据个数
     * Date:2018/3/13
     */
    public int getSize() {
        return pointList.size();
    }

    /**
     * Description:返回所有数据中的最大 y 值和最小 y 值的差值
     * Date:2018/3/13
     */
    public float getDiff() {
        List<Float> yList = new ArrayList<>();
        for (int i = 0; i < pointList.size(); i++) {
            yList.add(pointList.get(i).getY());
        }
        return Collections.max(yList) - Collections.min(yList);
    }

    /**
     * Description:返回所有数据中的最大 y 值
     * Date:2018/3/13
     */
    public float getMax() {
        List<Float> yList = new ArrayList<>();
        for (int i = 0; i < pointList.size(); i++) {
            yList.add(pointList.get(i).getY());
        }
        return Collections.max(yList);
    }

    /**
     * Description:返回所有数据中的最小 y 值
     * Date:2018/3/13
     */
    public float getMin() {
        List<Float> yList = new ArrayList<>();
        for (int i = 0; i < pointList.size(); i++) {
            yList.add(pointList.get(i).getY());
        }
        return Collections.min(yList);
    }

    @Override
    public String toString() {
        return "DataLine{" +
                "pointList=" + pointList +
                ", color=" + color +
                ", fillColor=" + fillColor +
                ", mode=" + mode +
                ", width=" + width +
                '}';
    }
}
