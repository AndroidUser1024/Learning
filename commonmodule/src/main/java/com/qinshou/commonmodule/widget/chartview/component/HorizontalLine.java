package com.qinshou.commonmodule.widget.chartview.component;

import android.graphics.Color;
import android.text.TextUtils;

/**
 * Description:水平辅助线
 * Created by 禽兽先生
 * Created on 2018/3/20
 */

public class HorizontalLine {
    private float y;    //辅助线 y 坐标
    private int color;  //辅助线颜色
    private float width;    //辅助线宽度
    private DashEffect dashEffect;  //虚线效果
    private Level level; //水平辅助线的显示层级
    private boolean showText;  //辅助线是否显示文字
    private String text;  //辅助线文字
    private TextPosition mTextPosition;    //y 坐标值的文字显示位置
    private int textSize;  //y 坐标值的文字大小
    private int textColor; //y 坐标值线的文字颜色

    public enum TextPosition {
        LEFT,   //水平辅助线的值显示在图表左侧
        RIGHT,  //显示在右侧
    }

    public enum Level {
        BELOW_DATA_LINE,   //水平辅助线显示在数据线的下层
        ABOVE_DATA_LINE,  //显示在上层
    }

    public HorizontalLine() {
        this.y = 0f;
        this.color = Color.parseColor("#FF000000");
        this.width = 1f;
        this.level = Level.BELOW_DATA_LINE;
        this.mTextPosition = TextPosition.RIGHT;
        this.textSize = 20;
        this.textColor = Color.parseColor("#FF000000");
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
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

    public DashEffect getDashEffect() {
        return dashEffect;
    }

    public void setDashEffect(DashEffect dashEffect) {
        this.dashEffect = dashEffect;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public boolean isShowText() {
        return showText;
    }

    public void setShowText(boolean showText) {
        this.showText = showText;
    }

    public String getText() {
        return TextUtils.isEmpty(text) ? String.valueOf(y) : text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public TextPosition getTextPosition() {
        return mTextPosition;
    }

    public void setTextPosition(TextPosition textPosition) {
        mTextPosition = textPosition;
    }

    public int getTextSize() {
        return textSize;
    }

    public void setTextSize(int textSize) {
        this.textSize = textSize;
    }

    public int getTextColor() {
        return textColor;
    }

    public void setTextColor(int textColor) {
        this.textColor = textColor;
    }

    @Override
    public String toString() {
        return "HorizontalLine{" +
                "y=" + y +
                ", showText=" + showText +
                ", color=" + color +
                ", dashEffect=" + dashEffect +
                ", mTextPosition=" + mTextPosition +
                ", textSize=" + textSize +
                ", textColor=" + textColor +
                ", level=" + level +
                '}';
    }

    public static class DashEffect {
        private float lineLength;
        private float spaceLength;
        private float phase;

        public DashEffect() {
            this.lineLength = 20f;
            this.spaceLength = 4f;
            this.phase = 0f;
        }

        public DashEffect(float lineLength, float spaceLength, float phase) {
            this.lineLength = lineLength;
            this.spaceLength = spaceLength;
            this.phase = phase;
        }

        public float getLineLength() {
            return lineLength;
        }

        public void setLineLength(float lineLength) {
            this.lineLength = lineLength;
        }

        public float getSpaceLength() {
            return spaceLength;
        }

        public void setSpaceLength(float spaceLength) {
            this.spaceLength = spaceLength;
        }

        public float getPhase() {
            return phase;
        }

        public void setPhase(float phase) {
            this.phase = phase;
        }

        @Override
        public String toString() {
            return "DashEffect{" +
                    "lineLength=" + lineLength +
                    ", spaceLength=" + spaceLength +
                    ", phase=" + phase +
                    '}';
        }
    }
}
