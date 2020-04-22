package com.qinshou.qinshoubox.me.bean;

/**
 * Author: QinHao
 * Email:cqflqinhao@126.com
 * Date: 2020/04/22 22:15
 * Description:坐标
 */
public class Position {
    private int row;
    private int column;

    public Position(int row, int column) {
        this.row = row;
        this.column = column;
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

    @Override
    public String toString() {
        return "当前坐标{" +
                "第" + row + "行" +
                ", 第" + column + "列" +
                '}';
    }
}