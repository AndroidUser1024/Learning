package com.qinshou.commonmodule.widget.chartview.component;


import java.util.ArrayList;
import java.util.List;

/**
 * Description:图表的轴
 * Created by 禽兽先生
 * Created on 2018/3/15
 */

public class Axis {
    private Type mType; //横轴还是纵轴
    private List<AxisText> mAxisTextList;  //文本标签集合
    private int count;  //要显示的标签总数,从 0 开始数
    private int offset; //偏移量,跳过从左开始几个便签
    private int space;  //间隔,每个标签之间跳过几个标签
    private IAxisTextFormatter mAxisTextFormatter;

    public enum Type {
        X, Y,
    }


    public Axis(Type type) {
        this.mType = type;
        this.mAxisTextList = new ArrayList<>();
        this.count = 0;
        this.offset = 0;
        this.space = 0;
    }

    public Type getType() {
        return mType;
    }

    public void setType(Type type) {
        mType = type;
    }

    public int getCount() {
        return count;
    }

    /**
     * Description:该方法一定要在 setLabelList() 之后调用,因为 setLabelList() 会自动设置 count 为 labelList 的长度
     * Date:2018/3/15
     */
    public void setCount(int count) {
        this.count = count;
    }

    public int getOffset() {
        return offset;
    }

    /**
     * Description:该方法一定要在 setLabelList() 之后调用,因为 setLabelList() 会自动重置 offset
     * Date:2018/3/15
     */
    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getSpace() {
        return space;
    }

    /**
     * Description:该方法一定要在 setLabelList() 之后调用,因为 setLabelList() 会自动重置 space
     * Date:2018/3/15
     */
    public void setSpace(int space) {
        this.space = space;
    }

    public List<AxisText> getAxisTextList() {
        return mAxisTextList;
    }

    public void addText(AxisText axisText) {
        mAxisTextList.add(axisText);
        setCount(mAxisTextList.size());
    }

    public void clearAxisTextList() {
        mAxisTextList.clear();
        setCount(mAxisTextList.size());
    }

    public IAxisTextFormatter getAxisTextFormatter() {
        return mAxisTextFormatter;
    }

    public void setAxisTextFormatter(IAxisTextFormatter axisTextFormatter) {
        mAxisTextFormatter = axisTextFormatter;
    }
}
