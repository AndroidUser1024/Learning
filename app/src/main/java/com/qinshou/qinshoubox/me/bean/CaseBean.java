package com.qinshou.qinshoubox.me.bean;


import androidx.annotation.DrawableRes;
import androidx.fragment.app.FragmentManager;

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

    public CaseBean() {
    }

    public CaseBean(int floor, int row, int column, Type type, @DrawableRes int resourceId) {
        this.floor = floor;
        this.row = row;
        this.column = column;
        this.type = type;
        this.resourceId = resourceId;
    }

    @Override
    public String toString() {
        return "CaseBean{" +
                "floor=" + floor +
                ", 行=" + row +
                ", 列=" + column +
                ", 图片资源 Id=" + resourceId +
                ", 类型=" + type +
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
    }

    public boolean handleEvent(FragmentManager fragmentManager) {
        return true;
    }
}
