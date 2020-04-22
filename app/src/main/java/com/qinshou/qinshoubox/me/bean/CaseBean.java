package com.qinshou.qinshoubox.me.bean;


import androidx.annotation.DrawableRes;
import androidx.fragment.app.FragmentManager;

import com.qinshou.qinshoubox.me.enums.Type;

/**
 * Description:地图中每一格的实体类
 * Created by 禽兽先生
 * Created on 2018/4/10
 */

public interface CaseBean {

    int getResourceId();

    void handleEvent(FragmentManager fragmentManager, int floor, Position position, IHandleEventCallback handleEventCallback);
}
