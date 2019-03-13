package com.qinshou.qinshoubox.me.bean;

import android.support.v4.app.FragmentActivity;
import android.util.Log;

import com.qinshou.qinshoubox.me.util.MapManager;

/**
 * Description:建筑实体类
 * Created by 禽兽先生
 * Created on 2017/6/15
 */

public class BuildingBean extends ABaseBean {
    public BuildingBean() {
    }

    public BuildingBean(String name, int type, int resourceId) {
        super(name, type, resourceId);
    }

    @Override
    public boolean handleEvent(FragmentActivity activity, CaseBean fromCase, CaseBean toCase) {
        switch (getType()) {
            case CaseBean.BUILDING_ROAD:
                fromCase.setType(CaseBean.BUILDING_ROAD);
                MapManager.getInstance().setCase(fromCase.getRow(), fromCase.getColumn(), fromCase);
                MapManager.getInstance().updateUI(fromCase);
                toCase.setType(CaseBean.WARRIOR_UP);
                MapManager.getInstance().setCase(toCase.getRow(), toCase.getColumn(), toCase);
                MapManager.getInstance().updateUI(toCase);
                return true;
            case CaseBean.BUILDING_WALL:
                Log.i("BuildingBean", "再走就要撞墙了!");
                break;
            case CaseBean.BUILDING_STARRY_SKY:
                Log.i("BuildingBean", "你要上天吗?");
                break;
            case CaseBean.BUILDING_FIRE_SEA:
                Log.i("BuildingBean", "碳烤人肉串?");
                break;
        }
        return false;
    }
}
