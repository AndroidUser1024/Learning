package com.qinshou.qinshoubox.me.bean.building;

import androidx.fragment.app.FragmentManager;

import com.qinshou.qinshoubox.R;
import com.qinshou.qinshoubox.me.bean.IHandleEventCallback;
import com.qinshou.qinshoubox.me.bean.Position;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2020/4/22 18:03
 * Description:类描述
 */
public class Wall implements IBuilding {

    @Override
    public int getResourceId() {
        return R.drawable.magic_tower_building_wall;
    }

    @Override
    public void handleEvent(FragmentManager fragmentManager, int floor, Position position, IHandleEventCallback handleEventCallback) {
        handleEventCallback.onFailure(new Exception("再走就要撞墙了!"));
    }
}
