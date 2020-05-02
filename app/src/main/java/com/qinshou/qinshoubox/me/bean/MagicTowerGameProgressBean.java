package com.qinshou.qinshoubox.me.bean;

import com.qinshou.qinshoubox.me.bean.warrior.WarriorBean;

import java.util.List;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2020/05/02 15:40
 * Description:魔塔游戏进度
 */
public class MagicTowerGameProgressBean {
    private WarriorBean warriorBean;
    private List<List<List<String>>> floorList;
    private int currentFloor;
    private int maxFloorHaveBeTo;

    public MagicTowerGameProgressBean() {
    }

    public MagicTowerGameProgressBean(WarriorBean warriorBean, List<List<List<String>>> floorList, int currentFloor, int maxFloorHaveBeTo) {
        this.warriorBean = warriorBean;
        this.floorList = floorList;
        this.currentFloor = currentFloor;
        this.maxFloorHaveBeTo = maxFloorHaveBeTo;
    }

    @Override
    public String toString() {
        return "MagicTowerGameProgressBean{" +
                "warriorBean=" + warriorBean +
                ", floorList=" + floorList +
                ", currentFloor=" + currentFloor +
                ", maxFloorHaveBeTo=" + maxFloorHaveBeTo +
                '}';
    }

    public WarriorBean getWarriorBean() {
        return warriorBean;
    }

    public void setWarriorBean(WarriorBean warriorBean) {
        this.warriorBean = warriorBean;
    }

    public List<List<List<String>>> getFloorList() {
        return floorList;
    }

    public void setFloorList(List<List<List<String>>> floorList) {
        this.floorList = floorList;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }

    public int getMaxFloorHaveBeTo() {
        return maxFloorHaveBeTo;
    }

    public void setMaxFloorHaveBeTo(int maxFloorHaveBeTo) {
        this.maxFloorHaveBeTo = maxFloorHaveBeTo;
    }
}
