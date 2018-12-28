package com.qinshou.commonmodule.widget.chartview.component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Description:数据线的集合
 * Created by 禽兽先生
 * Created on 2018/3/13
 */

public class LineList {
    private List<Line> lineList;

    public LineList() {
        this.lineList = new ArrayList<>();
    }

    public LineList(List<Line> lineList) {
        this.lineList = lineList;
    }

    public List<Line> getLineList() {
        return lineList;
    }

    public void setLineList(List<Line> lineList) {
        this.lineList = lineList;
    }

    public void addLine(Line line) {
        this.lineList.add(line);
    }

    /**
     * Description:比较每一个 DataLine 的 Size,返回最大值
     * Date:2018/3/13
     */
    public int getMaxSize() {
        List<Integer> sizeList = new ArrayList<>();
        for (Line line : lineList) {
            sizeList.add(line.getSize());
        }
        return Collections.max(sizeList);
    }

    /**
     * Description:比较每一个 DataLine 的 Size,返回最小值
     * Date:2018/3/13
     */
    public int minSize() {
        List<Integer> sizeList = new ArrayList<>();
        for (Line line : lineList) {
            sizeList.add(line.getSize());
        }
        return Collections.min(sizeList);
    }

    /**
     * Description:比较每一个 DataLine 的每一个值,返回最大值
     * Date:2018/3/13
     */
    public float getMax() {
        List<Float> maxList = new ArrayList<>();
        for (Line line : lineList) {
            maxList.add(line.getMax());
        }
        return Collections.max(maxList);
    }

    /**
     * Description:比较每一个 DataLine 的每一个值,返回最小值
     * Date:2018/3/13
     */
    public float getMin() {
        List<Float> minList = new ArrayList<>();
        for (Line line : lineList) {
            minList.add(line.getMin());
        }
        return Collections.min(minList);
    }
}
