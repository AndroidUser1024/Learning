package com.qinshou.commonmodule.widget.chartview.component;


import java.util.ArrayList;
import java.util.List;

/**
 * Description:图表的轴
 * Created by 禽兽先生
 * Created on 2018/3/15
 */

public class Axis {
    private List<Label> labelList;  //标签集合
    private int count;  //要显示的标签总数,从 0 开始数
    private int offset; //偏移量,跳过从左开始几个便签
    private int space;  //间隔,每个标签之间跳过几个标签
    private LabelPosition labelPosition;  //标签显示的位置
    private boolean showScale;  //是否在标签的对应位置显示刻度

    public enum LabelPosition {
        INSIDE, //标签在轴内部显示
        OUTSIDE,    //标签在轴外部显示
    }

    public Axis() {
        labelList = new ArrayList<>();
        count = labelList.size();
        offset = 0;
        space = 0;
        labelPosition = LabelPosition.OUTSIDE;
        showScale = false;
    }

    public List<Label> getLabelList() {
        return labelList;
    }

    public void setLabelList(List<Label> labelList) {
        this.labelList = labelList;
        count = labelList.size();
        offset = 0;
        space = 0;
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

    public LabelPosition getLabelPosition() {
        return labelPosition;
    }

    public void setAxisPosition(LabelPosition labelPosition) {
        this.labelPosition = labelPosition;
    }

    public boolean isShowScale() {
        return showScale;
    }

    public void setShowScale(boolean showScale) {
        this.showScale = showScale;
    }

    public void setLabelFormatter(ILabelFormatter labelFormatter) {
        for (int i = 0; i < labelList.size(); i++) {
            int value = Integer.parseInt(labelList.get(i).getLabel());
            labelList.get(i).setLabel(labelFormatter.getFormattedLabel(value));
        }
    }
}
