package com.qinshou.qinshoubox.me.bean;

import android.support.annotation.IdRes;

import com.qinshou.qinshoubox.me.handler.IEventHandler;


/**
 * Description:魔塔地图中实体类的基类
 * Created by 禽兽先生
 * Created on 2017/6/15
 */

public abstract class ABaseBean implements IEventHandler {
    private String mName;
    private int mType;
    @IdRes
    private int mResourceId;

    public ABaseBean() {
    }

    public ABaseBean(String name, int type, int resourceId) {
        this.mName = name;
        this.mType = type;
        this.mResourceId = resourceId;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public int getType() {
        return mType;
    }

    public void setType(int type) {
        mType = type;
    }

    public int getResourceId() {
        return mResourceId;
    }

    public void setResourceId(int resourceId) {
        mResourceId = resourceId;
    }
}
