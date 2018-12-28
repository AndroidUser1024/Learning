package com.qinshou.commonmodule.chartview.component;

/**
 * Description:轴文字格式化的接口，通过回调 position 来实现可以自定义对应位置的文字
 * Created by 禽兽先生
 * Created on 2018/3/14
 */

public interface IAxisTextlFormatter {
    String getFormattedLabel(int position);
}
