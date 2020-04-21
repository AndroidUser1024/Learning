package com.qinshou.qinshoubox.me.bean.floor;



import com.qinshou.qinshoubox.R;
import com.qinshou.qinshoubox.me.bean.CaseBean;
import com.qinshou.qinshoubox.me.enums.Building;
import com.qinshou.qinshoubox.me.enums.Monster;
import com.qinshou.qinshoubox.me.enums.Npc;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:第 16 层
 * Created by 禽兽先生
 * Created on 2017/4/27
 */

public class Floor16 extends AbsFloor {

    @Override
    public int getFloor() {
        return 16;
    }

    @Override
    public List<List<CaseBean>> setData() {
        List<List<CaseBean>> floor16 = new ArrayList<>();
        List<CaseBean> row0 = new ArrayList<>();
        row0.add(new CaseBean(16, 0, 0, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row0.add(new CaseBean(16, 0, 1, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row0.add(new CaseBean(16, 0, 2, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row0.add(new CaseBean(16, 0, 3, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row0.add(new CaseBean(16, 0, 4, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row0.add(new CaseBean(16, 0, 5, Building.ROAD, R.drawable.magic_tower_building_road));
        row0.add(new CaseBean(16, 0, 6, Npc.GO_DOWNSTAIRS, R.drawable.magic_tower_npc_go_downstairs));
        row0.add(new CaseBean(16, 0, 7, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row0.add(new CaseBean(16, 0, 8, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row0.add(new CaseBean(16, 0, 9, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row0.add(new CaseBean(16, 0, 10, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        floor16.add(row0);

        List<CaseBean> row1 = new ArrayList<>();
        row1.add(new CaseBean(16, 1, 0, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row1.add(new CaseBean(16, 1, 1, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row1.add(new CaseBean(16, 1, 2, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row1.add(new CaseBean(16, 1, 3, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row1.add(new CaseBean(16, 1, 4, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row1.add(new CaseBean(16, 1, 5, Building.ROAD, R.drawable.magic_tower_building_road));
        row1.add(new CaseBean(16, 1, 6, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row1.add(new CaseBean(16, 1, 7, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row1.add(new CaseBean(16, 1, 8, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row1.add(new CaseBean(16, 1, 9, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row1.add(new CaseBean(16, 1, 10, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        floor16.add(row1);

        List<CaseBean> row2 = new ArrayList<>();
        row2.add(new CaseBean(16, 2, 0, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row2.add(new CaseBean(16, 2, 1, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row2.add(new CaseBean(16, 2, 2, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row2.add(new CaseBean(16, 2, 3, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row2.add(new CaseBean(16, 2, 4, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row2.add(new CaseBean(16, 2, 5, Building.ROAD, R.drawable.magic_tower_building_road));
        row2.add(new CaseBean(16, 2, 6, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row2.add(new CaseBean(16, 2, 7, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row2.add(new CaseBean(16, 2, 8, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row2.add(new CaseBean(16, 2, 9, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row2.add(new CaseBean(16, 2, 10, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        floor16.add(row2);

        List<CaseBean> row3 = new ArrayList<>();
        row3.add(new CaseBean(16, 3, 0, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row3.add(new CaseBean(16, 3, 1, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row3.add(new CaseBean(16, 3, 2, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row3.add(new CaseBean(16, 3, 3, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row3.add(new CaseBean(16, 3, 4, Building.WALL, R.drawable.magic_tower_building_wall));
        row3.add(new CaseBean(16, 3, 5, Building.ROAD, R.drawable.magic_tower_building_road));
        row3.add(new CaseBean(16, 3, 6, Building.WALL, R.drawable.magic_tower_building_wall));
        row3.add(new CaseBean(16, 3, 7, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row3.add(new CaseBean(16, 3, 8, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row3.add(new CaseBean(16, 3, 9, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row3.add(new CaseBean(16, 3, 10, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        floor16.add(row3);

        List<CaseBean> row4 = new ArrayList<>();
        row4.add(new CaseBean(16, 4, 0, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row4.add(new CaseBean(16, 4, 1, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row4.add(new CaseBean(16, 4, 2, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row4.add(new CaseBean(16, 4, 3, Building.WALL, R.drawable.magic_tower_building_wall));
        row4.add(new CaseBean(16, 4, 4, Building.WALL, R.drawable.magic_tower_building_wall));
        row4.add(new CaseBean(16, 4, 5, Building.ROAD, R.drawable.magic_tower_building_road));
        row4.add(new CaseBean(16, 4, 6, Building.WALL, R.drawable.magic_tower_building_wall));
        row4.add(new CaseBean(16, 4, 7, Building.WALL, R.drawable.magic_tower_building_wall));
        row4.add(new CaseBean(16, 4, 8, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row4.add(new CaseBean(16, 4, 9, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row4.add(new CaseBean(16, 4, 10, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        floor16.add(row4);

        List<CaseBean> row5 = new ArrayList<>();
        row5.add(new CaseBean(16, 5, 0, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row5.add(new CaseBean(16, 5, 1, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row5.add(new CaseBean(16, 5, 2, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row5.add(new CaseBean(16, 5, 3, Building.WALL, R.drawable.magic_tower_building_wall));
        row5.add(new CaseBean(16, 5, 4, Building.WALL, R.drawable.magic_tower_building_wall));
        row5.add(new CaseBean(16, 5, 5, Monster.HONG_YI_MO_WANG_1, R.drawable.magic_tower_monster_hong_yi_mo_wang));
        row5.add(new CaseBean(16, 5, 6, Building.WALL, R.drawable.magic_tower_building_wall));
        row5.add(new CaseBean(16, 5, 7, Building.WALL, R.drawable.magic_tower_building_wall));
        row5.add(new CaseBean(16, 5, 8, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row5.add(new CaseBean(16, 5, 9, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row5.add(new CaseBean(16, 5, 10, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        floor16.add(row5);

        List<CaseBean> row6 = new ArrayList<>();
        row6.add(new CaseBean(16, 6, 0, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row6.add(new CaseBean(16, 6, 1, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row6.add(new CaseBean(16, 6, 2, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row6.add(new CaseBean(16, 6, 3, Building.WALL, R.drawable.magic_tower_building_wall));
        row6.add(new CaseBean(16, 6, 4, Building.WALL, R.drawable.magic_tower_building_wall));
        row6.add(new CaseBean(16, 6, 5, Building.ROAD, R.drawable.magic_tower_building_road));
        row6.add(new CaseBean(16, 6, 6, Building.WALL, R.drawable.magic_tower_building_wall));
        row6.add(new CaseBean(16, 6, 7, Building.WALL, R.drawable.magic_tower_building_wall));
        row6.add(new CaseBean(16, 6, 8, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row6.add(new CaseBean(16, 6, 9, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row6.add(new CaseBean(16, 6, 10, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        floor16.add(row6);

        List<CaseBean> row7 = new ArrayList<>();
        row7.add(new CaseBean(16, 7, 0, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row7.add(new CaseBean(16, 7, 1, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row7.add(new CaseBean(16, 7, 2, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row7.add(new CaseBean(16, 7, 3, Building.WALL, R.drawable.magic_tower_building_wall));
        row7.add(new CaseBean(16, 7, 4, Building.WALL, R.drawable.magic_tower_building_wall));
        row7.add(new CaseBean(16, 7, 5, Npc.GO_UPSTAIRS, R.drawable.magic_tower_npc_go_upstairs));
        row7.add(new CaseBean(16, 7, 6, Building.WALL, R.drawable.magic_tower_building_wall));
        row7.add(new CaseBean(16, 7, 7, Building.WALL, R.drawable.magic_tower_building_wall));
        row7.add(new CaseBean(16, 7, 8, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row7.add(new CaseBean(16, 7, 9, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row7.add(new CaseBean(16, 7, 10, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        floor16.add(row7);

        List<CaseBean> row8 = new ArrayList<>();
        row8.add(new CaseBean(16, 8, 0, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row8.add(new CaseBean(16, 8, 1, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row8.add(new CaseBean(16, 8, 2, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row8.add(new CaseBean(16, 8, 3, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row8.add(new CaseBean(16, 8, 4, Building.WALL, R.drawable.magic_tower_building_wall));
        row8.add(new CaseBean(16, 8, 5, Building.WALL, R.drawable.magic_tower_building_wall));
        row8.add(new CaseBean(16, 8, 6, Building.WALL, R.drawable.magic_tower_building_wall));
        row8.add(new CaseBean(16, 8, 7, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row8.add(new CaseBean(16, 8, 8, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row8.add(new CaseBean(16, 8, 9, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row8.add(new CaseBean(16, 8, 10, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        floor16.add(row8);

        List<CaseBean> row9 = new ArrayList<>();
        row9.add(new CaseBean(16, 9, 0, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row9.add(new CaseBean(16, 9, 1, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row9.add(new CaseBean(16, 9, 2, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row9.add(new CaseBean(16, 9, 3, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row9.add(new CaseBean(16, 9, 4, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row9.add(new CaseBean(16, 9, 5, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row9.add(new CaseBean(16, 9, 6, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row9.add(new CaseBean(16, 9, 7, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row9.add(new CaseBean(16, 9, 8, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row9.add(new CaseBean(16, 9, 9, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row9.add(new CaseBean(16, 9, 10, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        floor16.add(row9);

        List<CaseBean> row10 = new ArrayList<>();
        row10.add(new CaseBean(16, 10, 0, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row10.add(new CaseBean(16, 10, 1, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row10.add(new CaseBean(16, 10, 2, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row10.add(new CaseBean(16, 10, 3, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row10.add(new CaseBean(16, 10, 4, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row10.add(new CaseBean(16, 10, 5, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row10.add(new CaseBean(16, 10, 6, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row10.add(new CaseBean(16, 10, 7, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row10.add(new CaseBean(16, 10, 8, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row10.add(new CaseBean(16, 10, 9, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row10.add(new CaseBean(16, 10, 10, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        floor16.add(row10);

        return floor16;
    }

    @Override
    public void fromUpstairsToThisFloor() {
        resetWarriorPosition(6, 5);
    }

    @Override
    public void fromDownstairsToThisFloor() {
        resetWarriorPosition(0, 5);
    }
}
