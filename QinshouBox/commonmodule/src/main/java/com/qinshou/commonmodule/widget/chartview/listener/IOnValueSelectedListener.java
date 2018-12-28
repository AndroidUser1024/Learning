package com.qinshou.commonmodule.widget.chartview.listener;

/**
 * Description:折线图控件触摸时的回调监听器
 * Created by 禽兽先生
 * Created on 2018/3/14
 */

public interface IOnValueSelectedListener {
    /**
     * Description:数据点被选择时的回调
     * Date:2018/3/22
     *
     * @param x        触摸点相对于屏幕的 x 坐标
     * @param y        触摸点相对于屏幕的 y 坐标
     * @param position 距离触摸点最近的数据的位置
     */
    void onValueSelected(float x, float y, int position);

    /**
     * Description:没有数据点被选择时回调,通常在手指抬起时回调
     * Date:2018/3/29
     */
    void onValueCancelSelected();
}
