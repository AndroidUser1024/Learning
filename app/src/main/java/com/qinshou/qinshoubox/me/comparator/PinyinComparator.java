package com.qinshou.qinshoubox.me.comparator;

import java.util.Comparator;

/**
 * Description:字符串排序工具类
 * Created by 禽兽先生
 * Created on 2017/4/3
 */

public class PinyinComparator implements Comparator<String> {

    @Override
    public int compare(String string1, String string2) {
        //这里主要是用来对ListView里面的数据根据ABCDEFG...来排序
        if (string1.equals("@") || string2.equals("#")) {
            return -1;
        } else if (string1.equals("#") || string2.equals("@")) {
            return 1;
        } else {
            return string1.compareTo(string2);
        }
    }
}
