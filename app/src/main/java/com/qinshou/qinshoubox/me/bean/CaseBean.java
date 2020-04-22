package com.qinshou.qinshoubox.me.bean;


import androidx.annotation.DrawableRes;
import androidx.fragment.app.FragmentManager;

import com.qinshou.qinshoubox.me.enums.Type;

/**
 * Description:地图中每一格的实体类
 * Created by 禽兽先生
 * Created on 2018/4/10
 */

public class CaseBean {
    private int resourceId;
    /**
     * 格子类型
     */
    private Type type;

    public CaseBean() {
    }

    public CaseBean(Type type, @DrawableRes int resourceId) {
        this.type = type;
        this.resourceId = resourceId;
    }

    @Override
    public String toString() {
        return "CaseBean{" +
                ", 图片资源 Id=" + resourceId +
                ", 类型=" + type +
                '}';
    }

    public int getResourceId() {
        return resourceId;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public void handleEvent(FragmentManager fragmentManager, IHandleEventCallback handleEventCallback) {
    }
}
