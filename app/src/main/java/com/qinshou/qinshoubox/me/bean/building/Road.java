package com.qinshou.qinshoubox.me.bean.building;

import com.qinshou.qinshoubox.R;
import com.qinshou.qinshoubox.me.bean.IHandleEventCallback;
import com.qinshou.qinshoubox.me.bean.Position;
import com.qinshou.qinshoubox.me.enums.Building;
import com.qinshou.qinshoubox.me.enums.Type;

import androidx.fragment.app.FragmentManager;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2020/4/22 13:18
 * Description:类描述
 */
public class Road implements BuildingBean {

    @Override
    public int getResourceId() {
        return R.drawable.magic_tower_building_road;
    }

    @Override
    public void handleEvent(FragmentManager fragmentManager, int floor, Position position, IHandleEventCallback handleEventCallback) {
        handleEventCallback.onSuccess(true);
    }
}
