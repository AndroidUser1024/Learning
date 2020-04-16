package com.qinshou.qinshoubox.me.bean.floor;


import com.qinshou.qinshoubox.R;
import com.qinshou.qinshoubox.me.bean.CaseBean;
import com.qinshou.qinshoubox.me.enums.Building;
import com.qinshou.qinshoubox.me.enums.Npc;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:第 0 层
 * Created by 禽兽先生
 * Created on 2017/6/15
 */

public class Floor0 extends AFloor {

    @Override
    public int getFloor() {
        return 0;
    }

    @Override
    public List<List<CaseBean>> setData() {
        List<List<CaseBean>> floor0 = new ArrayList<>();
        List<CaseBean> row0 = new ArrayList<>();
        row0.add(new CaseBean(0, 0, 0, Building.WALL, R.drawable.magic_tower_building_wall));
        row0.add(new CaseBean(0, 0, 1, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row0.add(new CaseBean(0, 0, 2, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row0.add(new CaseBean(0, 0, 3, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row0.add(new CaseBean(0, 0, 4, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row0.add(new CaseBean(0, 0, 5, Npc.GO_UPSTAIRS, R.drawable.magic_tower_npc_go_upstairs));
        row0.add(new CaseBean(0, 0, 6, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row0.add(new CaseBean(0, 0, 7, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row0.add(new CaseBean(0, 0, 8, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row0.add(new CaseBean(0, 0, 9, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row0.add(new CaseBean(0, 0, 10, Building.WALL, R.drawable.magic_tower_building_wall));
        floor0.add(row0);

        List<CaseBean> row1 = new ArrayList<>();
        row1.add(new CaseBean(0, 1, 0, Building.WALL, R.drawable.magic_tower_building_wall));
        row1.add(new CaseBean(0, 1, 1, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row1.add(new CaseBean(0, 1, 2, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row1.add(new CaseBean(0, 1, 3, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row1.add(new CaseBean(0, 1, 4, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row1.add(new CaseBean(0, 1, 5, Building.ROAD, R.drawable.magic_tower_building_road));
        row1.add(new CaseBean(0, 1, 6, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row1.add(new CaseBean(0, 1, 7, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row1.add(new CaseBean(0, 1, 8, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row1.add(new CaseBean(0, 1, 9, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row1.add(new CaseBean(0, 1, 10, Building.WALL, R.drawable.magic_tower_building_wall));
        floor0.add(row1);

        List<CaseBean> row2 = new ArrayList<>();
        row2.add(new CaseBean(0, 2, 0, Building.WALL, R.drawable.magic_tower_building_wall));
        row2.add(new CaseBean(0, 2, 1, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row2.add(new CaseBean(0, 2, 2, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row2.add(new CaseBean(0, 2, 3, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row2.add(new CaseBean(0, 2, 4, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row2.add(new CaseBean(0, 2, 5, Building.ROAD, R.drawable.magic_tower_building_road));
        row2.add(new CaseBean(0, 2, 6, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row2.add(new CaseBean(0, 2, 7, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row2.add(new CaseBean(0, 2, 8, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row2.add(new CaseBean(0, 2, 9, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row2.add(new CaseBean(0, 2, 10, Building.WALL, R.drawable.magic_tower_building_wall));
        floor0.add(row2);

        List<CaseBean> row3 = new ArrayList<>();
        row3.add(new CaseBean(0, 3, 0, Building.WALL, R.drawable.magic_tower_building_wall));
        row3.add(new CaseBean(0, 3, 1, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row3.add(new CaseBean(0, 3, 2, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row3.add(new CaseBean(0, 3, 3, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row3.add(new CaseBean(0, 3, 4, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row3.add(new CaseBean(0, 3, 5, Building.ROAD, R.drawable.magic_tower_building_road));
        row3.add(new CaseBean(0, 3, 6, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row3.add(new CaseBean(0, 3, 7, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row3.add(new CaseBean(0, 3, 8, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row3.add(new CaseBean(0, 3, 9, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row3.add(new CaseBean(0, 3, 10, Building.WALL, R.drawable.magic_tower_building_wall));
        floor0.add(row3);

        List<CaseBean> row4 = new ArrayList<>();
        row4.add(new CaseBean(0, 4, 0, Building.WALL, R.drawable.magic_tower_building_wall));
        row4.add(new CaseBean(0, 4, 1, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row4.add(new CaseBean(0, 4, 2, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row4.add(new CaseBean(0, 4, 3, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row4.add(new CaseBean(0, 4, 4, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row4.add(new CaseBean(0, 4, 5, Building.ROAD, R.drawable.magic_tower_building_road));
        row4.add(new CaseBean(0, 4, 6, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row4.add(new CaseBean(0, 4, 7, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row4.add(new CaseBean(0, 4, 8, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row4.add(new CaseBean(0, 4, 9, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row4.add(new CaseBean(0, 4, 10, Building.WALL, R.drawable.magic_tower_building_wall));
        floor0.add(row4);

        List<CaseBean> row5 = new ArrayList<>();
        row5.add(new CaseBean(0, 5, 0, Building.WALL, R.drawable.magic_tower_building_wall));
        row5.add(new CaseBean(0, 5, 1, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row5.add(new CaseBean(0, 5, 2, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row5.add(new CaseBean(0, 5, 3, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row5.add(new CaseBean(0, 5, 4, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row5.add(new CaseBean(0, 5, 5, Building.ROAD, R.drawable.magic_tower_building_road));
        row5.add(new CaseBean(0, 5, 6, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row5.add(new CaseBean(0, 5, 7, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row5.add(new CaseBean(0, 5, 8, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row5.add(new CaseBean(0, 5, 9, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row5.add(new CaseBean(0, 5, 10, Building.WALL, R.drawable.magic_tower_building_wall));
        floor0.add(row5);

        List<CaseBean> row6 = new ArrayList<>();
        row6.add(new CaseBean(0, 6, 0, Building.WALL, R.drawable.magic_tower_building_wall));
        row6.add(new CaseBean(0, 6, 1, Building.WALL, R.drawable.magic_tower_building_wall));
        row6.add(new CaseBean(0, 6, 2, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row6.add(new CaseBean(0, 6, 3, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row6.add(new CaseBean(0, 6, 4, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row6.add(new CaseBean(0, 6, 5, Building.ROAD, R.drawable.magic_tower_building_road));
        row6.add(new CaseBean(0, 6, 6, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row6.add(new CaseBean(0, 6, 7, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row6.add(new CaseBean(0, 6, 8, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row6.add(new CaseBean(0, 6, 9, Building.WALL, R.drawable.magic_tower_building_wall));
        row6.add(new CaseBean(0, 6, 10, Building.WALL, R.drawable.magic_tower_building_wall));
        floor0.add(row6);

        List<CaseBean> row7 = new ArrayList<>();
        row7.add(new CaseBean(0, 7, 0, Building.WALL, R.drawable.magic_tower_building_wall));
        row7.add(new CaseBean(0, 7, 1, Building.WALL, R.drawable.magic_tower_building_wall));
        row7.add(new CaseBean(0, 7, 2, Building.WALL, R.drawable.magic_tower_building_wall));
        row7.add(new CaseBean(0, 7, 3, Building.WALL, R.drawable.magic_tower_building_wall));
        row7.add(new CaseBean(0, 7, 4, Building.WALL, R.drawable.magic_tower_building_wall));
        row7.add(new CaseBean(0, 7, 5, Npc.GATE_YELLOW, R.drawable.magic_tower_npc_gate_yellow_1));
        row7.add(new CaseBean(0, 7, 6, Building.WALL, R.drawable.magic_tower_building_wall));
        row7.add(new CaseBean(0, 7, 7, Building.WALL, R.drawable.magic_tower_building_wall));
        row7.add(new CaseBean(0, 7, 8, Building.WALL, R.drawable.magic_tower_building_wall));
        row7.add(new CaseBean(0, 7, 9, Building.WALL, R.drawable.magic_tower_building_wall));
        row7.add(new CaseBean(0, 7, 10, Building.WALL, R.drawable.magic_tower_building_wall));
        floor0.add(row7);

        List<CaseBean> row8 = new ArrayList<>();
        row8.add(new CaseBean(0, 8, 0, Building.FIRE_SEA, R.drawable.magic_tower_building_fire_sea));
        row8.add(new CaseBean(0, 8, 1, Building.WALL, R.drawable.magic_tower_building_wall));
        row8.add(new CaseBean(0, 8, 2, Building.FIRE_SEA, R.drawable.magic_tower_building_fire_sea));
        row8.add(new CaseBean(0, 8, 3, Building.WALL, R.drawable.magic_tower_building_wall));
        row8.add(new CaseBean(0, 8, 4, Building.ROAD, R.drawable.magic_tower_building_road));
        row8.add(new CaseBean(0, 8, 5, Npc.FAIRY_1, R.drawable.magic_tower_npc_fairy));
        row8.add(new CaseBean(0, 8, 6, Building.ROAD, R.drawable.magic_tower_building_road));
        row8.add(new CaseBean(0, 8, 7, Building.WALL, R.drawable.magic_tower_building_wall));
        row8.add(new CaseBean(0, 8, 8, Building.FIRE_SEA, R.drawable.magic_tower_building_fire_sea));
        row8.add(new CaseBean(0, 8, 9, Building.WALL, R.drawable.magic_tower_building_wall));
        row8.add(new CaseBean(0, 8, 10, Building.FIRE_SEA, R.drawable.magic_tower_building_fire_sea));
        floor0.add(row8);

        List<CaseBean> row9 = new ArrayList<>();
        row9.add(new CaseBean(0, 9, 0, Building.FIRE_SEA, R.drawable.magic_tower_building_fire_sea));
        row9.add(new CaseBean(0, 9, 1, Building.FIRE_SEA, R.drawable.magic_tower_building_fire_sea));
        row9.add(new CaseBean(0, 9, 2, Building.FIRE_SEA, R.drawable.magic_tower_building_fire_sea));
        row9.add(new CaseBean(0, 9, 3, Building.FIRE_SEA, R.drawable.magic_tower_building_fire_sea));
        row9.add(new CaseBean(0, 9, 4, Building.FIRE_SEA, R.drawable.magic_tower_building_fire_sea));
        row9.add(new CaseBean(0, 9, 5, Building.ROAD, R.drawable.magic_tower_building_road));
        row9.add(new CaseBean(0, 9, 6, Building.FIRE_SEA, R.drawable.magic_tower_building_fire_sea));
        row9.add(new CaseBean(0, 9, 7, Building.FIRE_SEA, R.drawable.magic_tower_building_fire_sea));
        row9.add(new CaseBean(0, 9, 8, Building.FIRE_SEA, R.drawable.magic_tower_building_fire_sea));
        row9.add(new CaseBean(0, 9, 9, Building.FIRE_SEA, R.drawable.magic_tower_building_fire_sea));
        row9.add(new CaseBean(0, 9, 10, Building.FIRE_SEA, R.drawable.magic_tower_building_fire_sea));
        floor0.add(row9);

        List<CaseBean> row10 = new ArrayList<>();
        row10.add(new CaseBean(0, 10, 0, Building.FIRE_SEA, R.drawable.magic_tower_building_fire_sea));
        row10.add(new CaseBean(0, 10, 1, Building.FIRE_SEA, R.drawable.magic_tower_building_fire_sea));
        row10.add(new CaseBean(0, 10, 2, Building.FIRE_SEA, R.drawable.magic_tower_building_fire_sea));
        row10.add(new CaseBean(0, 10, 3, Building.FIRE_SEA, R.drawable.magic_tower_building_fire_sea));
        row10.add(new CaseBean(0, 10, 4, Building.FIRE_SEA, R.drawable.magic_tower_building_fire_sea));
        row10.add(new CaseBean(0, 10, 5, Building.ROAD, R.drawable.magic_tower_building_road));
        row10.add(new CaseBean(0, 10, 6, Building.FIRE_SEA, R.drawable.magic_tower_building_fire_sea));
        row10.add(new CaseBean(0, 10, 7, Building.FIRE_SEA, R.drawable.magic_tower_building_fire_sea));
        row10.add(new CaseBean(0, 10, 8, Building.FIRE_SEA, R.drawable.magic_tower_building_fire_sea));
        row10.add(new CaseBean(0, 10, 9, Building.FIRE_SEA, R.drawable.magic_tower_building_fire_sea));
        row10.add(new CaseBean(0, 10, 10, Building.FIRE_SEA, R.drawable.magic_tower_building_fire_sea));
        floor0.add(row10);

        return floor0;
    }

    @Override
    public void fromUpstairsToThisFloor() {
        resetWarriorPosition(1, 5);
    }

    @Override
    public void fromDownstairsToThisFloor() {
        resetWarriorPosition(9, 5);
    }
}
