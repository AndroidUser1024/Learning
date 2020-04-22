package com.qinshou.qinshoubox.me.bean.building;

import androidx.fragment.app.FragmentManager;

import com.qinshou.qinshoubox.R;
import com.qinshou.qinshoubox.me.bean.CaseBean;
import com.qinshou.qinshoubox.me.bean.IHandleEventCallback;
import com.qinshou.qinshoubox.me.enums.Building;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 20-4-21 下午11:22
 * Description:
 */
public abstract class BuildingBean extends CaseBean {
    public BuildingBean(int floor, int row, int column) {
        super(floor, row, column, Building.ROAD, R.drawable.magic_tower_building_road);
    }

    @Override
    public void handleEvent(FragmentManager fragmentManager, IHandleEventCallback handleEventCallback) {
        handleEventCallback.onSuccess(true);
    }
}
