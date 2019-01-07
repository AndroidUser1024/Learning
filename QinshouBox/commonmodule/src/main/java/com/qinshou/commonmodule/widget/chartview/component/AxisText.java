package com.qinshou.commonmodule.widget.chartview.component;

import android.graphics.Color;

/**
 * Description:轴标签文本
 * Created by 禽兽先生
 * Created on 2018/3/14
 */

public class AxisText {
    private float x;
    private float y;
        private String text;
    private int textColor;
    private int textSize;
    private Position mPosition;  //标签显示的位置
    private boolean showScale;  //是否在标签的对应位置显示刻度
    private int marginLeft; //仅对 Y 轴并且轴标签位置 LabelPosition 为 INSIDE 时有效
    private int marginTop;  //仅对 X 轴并且轴标签位置 LabelPosition 为 OUTSIDE 时有效
    private int marginRight;    //仅对 Y 轴并且轴标签位置 LabelPosition 为 OUTSIDE 时有效
    private int marginBottom;   //仅对 X 轴并且轴标签位置 LabelPosition 为 INSIDE 时有效

    public enum Position {
        INSIDE, //标签在轴内部显示
        OUTSIDE,    //标签在轴外部显示
    }

    public AxisText(float x, float y) {
        this.x = x;
        this.y = y;
        this.text = "";
        this.textColor = Color.parseColor("#FF000000");
        this.mPosition = Position.OUTSIDE;
        this.showScale = false;
        this.textSize = 20;
        this.marginLeft = 0;
        this.marginTop = 0;
        this.marginRight = 0;
        this.marginBottom = 0;
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

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getTextColor() {
        return textColor;
    }

    public void setTextColor(int textColor) {
        this.textColor = textColor;
    }

    public int getTextSize() {
        return textSize;
    }

    public void setTextSize(int textSize) {
        this.textSize = textSize;
    }

    public Position getPosition() {
        return mPosition;
    }

    public void setPosition(Position position) {
        mPosition = position;
    }

    public boolean isShowScale() {
        return showScale;
    }

    public void setShowScale(boolean showScale) {
        this.showScale = showScale;
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
        return "AxisText{" +
                "x=" + x +
                ", y=" + y +
                ", text='" + text + '\'' +
                ", textColor=" + textColor +
                ", textSize=" + textSize +
                ", mPosition=" + mPosition +
                ", showScale=" + showScale +
                ", marginLeft=" + marginLeft +
                ", marginTop=" + marginTop +
                ", marginRight=" + marginRight +
                ", marginBottom=" + marginBottom +
                '}';
    }
}
