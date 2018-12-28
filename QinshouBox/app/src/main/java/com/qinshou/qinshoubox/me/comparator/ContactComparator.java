package com.qinshou.qinshoubox.me.comparator;


import com.qinshou.qinshoubox.me.bean.ContactBean;

import java.util.Comparator;

/**
 * Description:联系人排序工具类
 * Created by 禽兽先生
 * Created on 2017/4/3
 */

public class ContactComparator implements Comparator<ContactBean> {

    @Override
    public int compare(ContactBean contactBean1, ContactBean contactBean2) {
        //这里主要是用来对ListView里面的数据根据 ABCDEFG... 来排序,@ 开头排在最开头，# 开头排在最后
        if (contactBean1.getSortLetter().equals("@") || contactBean2.getSortLetter().equals("#")) {
            return -1;
        } else if (contactBean1.getSortLetter().equals("#") || contactBean2.getSortLetter().equals("@")) {
            return 1;
        } else {
            return contactBean1.getSortLetter().compareTo(contactBean2.getSortLetter());
        }
    }
}
