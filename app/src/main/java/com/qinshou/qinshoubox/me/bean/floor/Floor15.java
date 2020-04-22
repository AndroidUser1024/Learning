package com.qinshou.qinshoubox.me.bean.floor;


import com.qinshou.qinshoubox.R;
import com.qinshou.qinshoubox.me.bean.CaseBean;
import com.qinshou.qinshoubox.me.enums.Building;
import com.qinshou.qinshoubox.me.enums.Npc;
import com.qinshou.qinshoubox.me.enums.Prop;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:第 15 层
 * Created by 禽兽先生
 * Created on 2017/4/27
 */

public class Floor15 extends AbsFloor {

    @Override
    public int getFloor() {
        return 15;
    }

    @Override
    public List<List<CaseBean>> setData() {
        List<List<CaseBean>> floor15 = new ArrayList<>();
        List<CaseBean> row0 = new ArrayList<>();
        row0.add(new CaseBean(Building.ROAD, R.drawable.magic_tower_building_road));
        row0.add(new CaseBean(Building.ROAD, R.drawable.magic_tower_building_road));
        row0.add(new CaseBean(Building.ROAD, R.drawable.magic_tower_building_road));
        row0.add(new CaseBean(Building.ROAD, R.drawable.magic_tower_building_road));
        row0.add(new CaseBean(Npc.GO_DOWNSTAIRS, R.drawable.magic_tower_npc_go_downstairs));
        row0.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row0.add(new CaseBean(Npc.GO_UPSTAIRS, R.drawable.magic_tower_npc_go_upstairs));
        row0.add(new CaseBean(Building.ROAD, R.drawable.magic_tower_building_road));
        row0.add(new CaseBean(Building.ROAD, R.drawable.magic_tower_building_road));
        row0.add(new CaseBean(Building.ROAD, R.drawable.magic_tower_building_road));
        row0.add(new CaseBean(Building.ROAD, R.drawable.magic_tower_building_road));
        floor15.add(row0);

        List<CaseBean> row1 = new ArrayList<>();
        row1.add(new CaseBean(Building.ROAD, R.drawable.magic_tower_building_road));
        row1.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row1.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row1.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row1.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row1.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row1.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row1.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row1.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row1.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row1.add(new CaseBean(Building.ROAD, R.drawable.magic_tower_building_road));
        floor15.add(row1);

        List<CaseBean> row2 = new ArrayList<>();
        row2.add(new CaseBean(Building.ROAD, R.drawable.magic_tower_building_road));
        row2.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row2.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row2.add(new CaseBean(Building.WALL, R.drawable.magic_tower_building_wall));
        row2.add(new CaseBean(Building.WALL, R.drawable.magic_tower_building_wall));
        row2.add(new CaseBean(Building.WALL, R.drawable.magic_tower_building_wall));
        row2.add(new CaseBean(Building.WALL, R.drawable.magic_tower_building_wall));
        row2.add(new CaseBean(Building.WALL, R.drawable.magic_tower_building_wall));
        row2.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row2.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row2.add(new CaseBean(Building.ROAD, R.drawable.magic_tower_building_road));
        floor15.add(row2);

        List<CaseBean> row3 = new ArrayList<>();
        row3.add(new CaseBean(Building.ROAD, R.drawable.magic_tower_building_road));
        row3.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row3.add(new CaseBean(Building.WALL, R.drawable.magic_tower_building_wall));
        row3.add(new CaseBean(Building.WALL, R.drawable.magic_tower_building_wall));
        row3.add(new CaseBean(Npc.SHEN_MI_LAO_REN_FLOOR_15, R.drawable.magic_tower_npc_shen_mi_lao_ren));
        row3.add(new CaseBean(Building.WALL, R.drawable.magic_tower_building_wall));
        row3.add(new CaseBean(Npc.SHANG_REN_FLOOR_15, R.drawable.magic_tower_npc_shang_ren));
        row3.add(new CaseBean(Building.WALL, R.drawable.magic_tower_building_wall));
        row3.add(new CaseBean(Building.WALL, R.drawable.magic_tower_building_wall));
        row3.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row3.add(new CaseBean(Building.ROAD, R.drawable.magic_tower_building_road));
        floor15.add(row3);

        List<CaseBean> row4 = new ArrayList<>();
        row4.add(new CaseBean(Building.ROAD, R.drawable.magic_tower_building_road));
        row4.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row4.add(new CaseBean(Building.WALL, R.drawable.magic_tower_building_wall));
        row4.add(new CaseBean(Building.WALL, R.drawable.magic_tower_building_wall));
        row4.add(new CaseBean(Prop.BAO_SHI_BLUE, R.drawable.magic_tower_prop_bao_shi_blue));
        row4.add(new CaseBean(Building.WALL, R.drawable.magic_tower_building_wall));
        row4.add(new CaseBean(Prop.BAO_SHI_BLUE, R.drawable.magic_tower_prop_bao_shi_blue));
        row4.add(new CaseBean(Building.WALL, R.drawable.magic_tower_building_wall));
        row4.add(new CaseBean(Building.WALL, R.drawable.magic_tower_building_wall));
        row4.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row4.add(new CaseBean(Building.ROAD, R.drawable.magic_tower_building_road));
        floor15.add(row4);

        List<CaseBean> row5 = new ArrayList<>();
        row5.add(new CaseBean(Building.ROAD, R.drawable.magic_tower_building_road));
        row5.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row5.add(new CaseBean(Building.WALL, R.drawable.magic_tower_building_wall));
        row5.add(new CaseBean(Building.WALL, R.drawable.magic_tower_building_wall));
        row5.add(new CaseBean(Prop.BAO_SHI_RED, R.drawable.magic_tower_prop_bao_shi_red));
        row5.add(new CaseBean(Building.WALL, R.drawable.magic_tower_building_wall));
        row5.add(new CaseBean(Prop.BAO_SHI_RED, R.drawable.magic_tower_prop_bao_shi_red));
        row5.add(new CaseBean(Building.WALL, R.drawable.magic_tower_building_wall));
        row5.add(new CaseBean(Building.WALL, R.drawable.magic_tower_building_wall));
        row5.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row5.add(new CaseBean(Building.ROAD, R.drawable.magic_tower_building_road));
        floor15.add(row5);

        List<CaseBean> row6 = new ArrayList<>();
        row6.add(new CaseBean(Building.ROAD, R.drawable.magic_tower_building_road));
        row6.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row6.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row6.add(new CaseBean(Building.WALL, R.drawable.magic_tower_building_wall));
        row6.add(new CaseBean(Building.ROAD, R.drawable.magic_tower_building_road));
        row6.add(new CaseBean(Building.WALL, R.drawable.magic_tower_building_wall));
        row6.add(new CaseBean(Building.ROAD, R.drawable.magic_tower_building_road));
        row6.add(new CaseBean(Building.WALL, R.drawable.magic_tower_building_wall));
        row6.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row6.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row6.add(new CaseBean(Building.ROAD, R.drawable.magic_tower_building_road));
        floor15.add(row6);

        List<CaseBean> row7 = new ArrayList<>();
        row7.add(new CaseBean(Building.ROAD, R.drawable.magic_tower_building_road));
        row7.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row7.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row7.add(new CaseBean(Building.WALL, R.drawable.magic_tower_building_wall));
        row7.add(new CaseBean(Npc.GATE_YELLOW, R.drawable.magic_tower_npc_gate_yellow_1));
        row7.add(new CaseBean(Building.WALL, R.drawable.magic_tower_building_wall));
        row7.add(new CaseBean(Npc.GATE_YELLOW, R.drawable.magic_tower_npc_gate_yellow_1));
        row7.add(new CaseBean(Building.WALL, R.drawable.magic_tower_building_wall));
        row7.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row7.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row7.add(new CaseBean(Building.ROAD, R.drawable.magic_tower_building_road));
        floor15.add(row7);

        List<CaseBean> row8 = new ArrayList<>();
        row8.add(new CaseBean(Building.ROAD, R.drawable.magic_tower_building_road));
        row8.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row8.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row8.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row8.add(new CaseBean(Building.ROAD, R.drawable.magic_tower_building_road));
        row8.add(new CaseBean(Building.ROAD, R.drawable.magic_tower_building_road));
        row8.add(new CaseBean(Building.ROAD, R.drawable.magic_tower_building_road));
        row8.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row8.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row8.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row8.add(new CaseBean(Building.ROAD, R.drawable.magic_tower_building_road));
        floor15.add(row8);

        List<CaseBean> row9 = new ArrayList<>();
        row9.add(new CaseBean(Building.ROAD, R.drawable.magic_tower_building_road));
        row9.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row9.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row9.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row9.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row9.add(new CaseBean(Building.ROAD, R.drawable.magic_tower_building_road));
        row9.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row9.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row9.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row9.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row9.add(new CaseBean(Building.ROAD, R.drawable.magic_tower_building_road));
        floor15.add(row9);

        List<CaseBean> row10 = new ArrayList<>();
        row10.add(new CaseBean(Building.ROAD, R.drawable.magic_tower_building_road));
        row10.add(new CaseBean(Building.ROAD, R.drawable.magic_tower_building_road));
        row10.add(new CaseBean(Building.ROAD, R.drawable.magic_tower_building_road));
        row10.add(new CaseBean(Building.ROAD, R.drawable.magic_tower_building_road));
        row10.add(new CaseBean(Building.ROAD, R.drawable.magic_tower_building_road));
        row10.add(new CaseBean(Building.ROAD, R.drawable.magic_tower_building_road));
        row10.add(new CaseBean(Building.ROAD, R.drawable.magic_tower_building_road));
        row10.add(new CaseBean(Building.ROAD, R.drawable.magic_tower_building_road));
        row10.add(new CaseBean(Building.ROAD, R.drawable.magic_tower_building_road));
        row10.add(new CaseBean(Building.ROAD, R.drawable.magic_tower_building_road));
        row10.add(new CaseBean(Building.ROAD, R.drawable.magic_tower_building_road));
        floor15.add(row10);

        return floor15;
    }

    @Override
    public void fromUpstairsToThisFloor() {
        resetWarriorPosition(0, 7);
    }

    @Override
    public void fromDownstairsToThisFloor() {
        resetWarriorPosition(0, 3);
    }
}
