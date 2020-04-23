package com.qinshou.qinshoubox.me.bean;


import androidx.fragment.app.FragmentManager;

/**
 * Description:地图中每一格的实体类
 * Created by 禽兽先生
 * Created on 2018/4/10
 */

public interface CaseBean {

    int getResourceId();

    void handleEvent(FragmentManager fragmentManager, int floor, Position position, IHandleEventCallback handleEventCallback);
}
