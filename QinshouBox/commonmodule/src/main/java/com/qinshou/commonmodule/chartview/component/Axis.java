package com.qinshou.commonmodule.chartview.component;


import com.qinshou.commonmodule.widget.chartview.component.ILabelFormatter;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:图表的轴
 * Created by 禽兽先生
 * Created on 2018/3/15
 */

public class Axis {
    private List<String> textList;  //标签集合
    private int count;  //要显示的标签总数,从 0 开始数
    private int offset; //偏移量,跳过从左开始几个便签
    private int space;  //间隔,每个标签之间跳过几个标签
    private TextPosition mTextPosition;  //标签显示的位置
    private boolean showScale;  //是否在标签的对应位置显示刻度

    public enum TextPosition {
        INSIDE, //标签在轴内部显示
        OUTSIDE,    //标签在轴外部显示
    }

    public Axis() {
        textList = new ArrayList<>();
        count = textList.size();
        offset = 0;
        space = 0;
        mTextPosition = TextPosition.OUTSIDE;
        showScale = false;
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

    public TextPosition getTextPosition() {
        return mTextPosition;
    }

    public void setAxisPosition(TextPosition textPosition) {
        this.mTextPosition = textPosition;
    }

    public boolean isShowScale() {
        return showScale;
    }

    public void setShowScale(boolean showScale) {
        this.showScale = showScale;
    }

    public void setI(IAxisTextlFormatter axisTextlFormatter) {
        for (int i = 0; i < textList.size(); i++) {
//            int value = Integer.parseInt(labelList.get(i).getLabel());
//            labelList.get(i).setLabel(labelFormatter.getFormattedLabel(value));
        }
    }
}
