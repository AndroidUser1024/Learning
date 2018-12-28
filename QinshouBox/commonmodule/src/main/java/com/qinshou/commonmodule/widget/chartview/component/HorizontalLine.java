package com.qinshou.commonmodule.widget.chartview.component;

import android.graphics.Color;

/**
 * Description:水平辅助线
 * Created by 禽兽先生
 * Created on 2018/3/20
 */

public class HorizontalLine {
    private float y;    //辅助线 y 坐标
    private boolean showValue;  //辅助线是否显示 y 坐标值
    private int color;  //辅助线颜色
    private DashEffect dashEffect;  //虚线效果
    private ValuePosition valuePosition;    //y 坐标值的文字显示位置
    private int valueTextSize;  //y 坐标值的文字大小
    private int valueTextColor; //y 坐标值线的文字颜色
    private Level level; //水平辅助线的显示层级

    public enum ValuePosition {
        LEFT,   //水平辅助线的值显示在图表左侧
        RIGHT,  //显示在右侧
    }

    public enum Level {
        BELOW,   //水平辅助线显示在数据线的下层
        ABOVE,  //显示在上层
    }

    public HorizontalLine() {
        this(0f);
    }

    public HorizontalLine(float y) {
        this(y, false);
    }

    public HorizontalLine(float y, boolean showValue) {
        this.y = y;
        this.showValue = showValue;
        this.color = Color.argb(255, 0, 0, 0);
        this.dashEffect = null;
        this.valuePosition = ValuePosition.LEFT;
        this.valueTextSize = 20;
        this.valueTextColor = Color.argb(255, 0, 0, 0);
        this.level = Level.BELOW;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public boolean isShowValue() {
        return showValue;
    }

    public void setShowValue(boolean showValue) {
        this.showValue = showValue;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public DashEffect getDashEffect() {
        return dashEffect;
    }

    public void setDashEffect(DashEffect dashEffect) {
        this.dashEffect = dashEffect;
    }

    public ValuePosition getValuePosition() {
        return valuePosition;
    }

    public void setValuePosition(ValuePosition valuePosition) {
        this.valuePosition = valuePosition;
    }

    public int getValueTextSize() {
        return valueTextSize;
    }

    public void setValueTextSize(int valueTextSize) {
        this.valueTextSize = valueTextSize;
    }

    public int getValueTextColor() {
        return valueTextColor;
    }

    public void setValueTextColor(int valueTextColor) {
        this.valueTextColor = valueTextColor;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public static class DashEffect {
        private float lineLength;
        private float spaceLength;
        private float phase;

        public DashEffect() {
            this(20f, 4f, 0f);
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
