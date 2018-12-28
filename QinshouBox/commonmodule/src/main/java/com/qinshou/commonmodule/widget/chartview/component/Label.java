package com.qinshou.commonmodule.widget.chartview.component;

import android.graphics.Color;

/**
 * Description:轴标签
 * Created by 禽兽先生
 * Created on 2018/3/14
 */

public class Label {
    private String label;
    private int color;
    private int marginLeft; //仅对 Y 轴并且轴标签位置 TextPosition 为 INSIDE 时有效
    private int marginTop;  //仅对 X 轴并且轴标签位置 TextPosition 为 OUTSIDE 时有效
    private int marginRight;    //仅对 Y 轴并且轴标签位置 TextPosition 为 OUTSIDE 时有效
    private int marginBottom;   //仅对 X 轴并且轴标签位置 TextPosition 为 INSIDE 时有效

    public Label() {
        this("");
    }

    public Label(String label) {
        this(label, Color.argb(255, 0, 0, 0));
    }

    public Label(String label, int color) {
        this.label = label;
        this.color = color;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
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

    public int getMarginTop() {
        return marginTop;
    }

    public void setMarginTop(int marginTop) {
        this.marginTop = marginTop;
    }

    public int getMarginRight() {
        return marginRight;
    }

    public void setMarginRight(int marginRight) {
        this.marginRight = marginRight;
    }

    public int getMarginBottom() {
        return marginBottom;
    }

    public void setMarginBottom(int marginBottom) {
        this.marginBottom = marginBottom;
    }

    @Override
    public String toString() {
        return "Label{" +
                "label='" + label + '\'' +
                ", color=" + color +
                ", marginLeft=" + marginLeft +
                ", marginTop=" + marginTop +
                ", marginRight=" + marginRight +
                ", marginBottom=" + marginBottom +
                '}';
    }
}
