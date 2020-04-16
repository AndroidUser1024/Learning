package com.qinshou.qinshoubox.me.bean;


import androidx.annotation.DrawableRes;

import com.qinshou.qinshoubox.me.enums.Type;

/**
 * Description:地图中每一格的实体类
 * Created by 禽兽先生
 * Created on 2018/4/10
 */

public class CaseBean {
    private int floor;
    private int row;
    private int column;
    private int resourceId;
    /**
     * 格子类型
     */
    private Type type;
    /**
     * 格子类型对应的字符串
     */
    private String typeValue;

    public CaseBean() {
    }

    public CaseBean(int floor, int row, int column, Type type, @DrawableRes int resourceId) {
        this.floor = floor;
        this.row = row;
        this.column = column;
        this.type = type;
        this.resourceId = resourceId;
        this.typeValue = type.toString();
    }

    @Override
    public String toString() {
        return "CaseBean{" +
                "floor=" + floor +
                ", 行=" + row +
                ", 列=" + column +
                ", 图片资源 Id=" + resourceId +
                ", 类型=" + type +
                ", 类型对应字符串='" + typeValue + '\'' +
                '}';
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int getResourceId() {
        return resourceId;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
        // 同步更新类型对应的字符串
        this.typeValue = type.toString();
    }

    public String getTypeValue() {
        return typeValue;
    }
}
