package com.qinshou.qinshoubox.me.bean.prop;

import com.qinshou.qinshoubox.me.bean.CaseBean;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2020/4/23 16:59
 * Description:道具
 */
public abstract class AbsProp implements CaseBean {
    private String name;
    private int resId;

    public AbsProp(String name, int resId) {
        this.name = name;
        this.resId = resId;
    }

    @Override
    public int getResourceId() {
        return resId;
    }
}
