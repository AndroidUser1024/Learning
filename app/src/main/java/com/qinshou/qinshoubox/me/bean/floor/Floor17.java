package com.qinshou.qinshoubox.me.bean.floor;


import com.qinshou.qinshoubox.R;
import com.qinshou.qinshoubox.me.bean.CaseBean;
import com.qinshou.qinshoubox.me.bean.Position;
import com.qinshou.qinshoubox.me.enums.Building;
import com.qinshou.qinshoubox.me.enums.Monster;
import com.qinshou.qinshoubox.me.enums.Npc;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:第 17 层
 * Created by 禽兽先生
 * Created on 2017/4/27
 */

public class Floor17 extends AbsFloor {

    @Override
    public int getFloor() {
        return 17;
    }

    @Override
    public List<List<CaseBean>> setData() {
        List<List<CaseBean>> floor17 = new ArrayList<>();
//        List<CaseBean> row0 = new ArrayList<>();
//        row0.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        row0.add(new CaseBean(Monster.LING_WU_SHI_2, R.drawable.magic_tower_monster_ling_wu_shi));
//        row0.add(new CaseBean(Monster.MING_DUI_ZHANG_2, R.drawable.magic_tower_monster_ming_dui_zhang));
//        row0.add(new CaseBean(Building.ROAD, R.drawable.magic_tower_building_road));
//        row0.add(new CaseBean(Building.ROAD, R.drawable.magic_tower_building_road));
//        row0.add(new CaseBean(Building.ROAD, R.drawable.magic_tower_building_road));
//        row0.add(new CaseBean(Building.ROAD, R.drawable.magic_tower_building_road));
//        row0.add(new CaseBean(Building.ROAD, R.drawable.magic_tower_building_road));
//        row0.add(new CaseBean(Building.ROAD, R.drawable.magic_tower_building_road));
//        row0.add(new CaseBean(Building.ROAD, R.drawable.magic_tower_building_road));
//        row0.add(new CaseBean(Monster.LING_WU_SHI_2, R.drawable.magic_tower_monster_ling_wu_shi));
//        floor17.add(row0);
//
//        List<CaseBean> row1 = new ArrayList<>();
//        row1.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        row1.add(new CaseBean(Monster.MING_DUI_ZHANG_2, R.drawable.magic_tower_monster_ming_dui_zhang));
//        row1.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        row1.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        row1.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        row1.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        row1.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        row1.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        row1.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        row1.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        row1.add(new CaseBean(Building.ROAD, R.drawable.magic_tower_building_road));
//        floor17.add(row1);
//
//        List<CaseBean> row2 = new ArrayList<>();
//        row2.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        row2.add(new CaseBean(Building.ROAD, R.drawable.magic_tower_building_road));
//        row2.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        row2.add(new CaseBean(Monster.LING_WU_SHI_2, R.drawable.magic_tower_monster_ling_wu_shi));
//        row2.add(new CaseBean(Building.ROAD, R.drawable.magic_tower_building_road));
//        row2.add(new CaseBean(Building.ROAD, R.drawable.magic_tower_building_road));
//        row2.add(new CaseBean(Building.ROAD, R.drawable.magic_tower_building_road));
//        row2.add(new CaseBean(Building.ROAD, R.drawable.magic_tower_building_road));
//        row2.add(new CaseBean(Building.ROAD, R.drawable.magic_tower_building_road));
//        row2.add(new CaseBean(Building.ROAD, R.drawable.magic_tower_building_road));
//        row2.add(new CaseBean(Monster.LING_WU_SHI_2, R.drawable.magic_tower_monster_ling_wu_shi));
//        floor17.add(row2);
//
//        List<CaseBean> row3 = new ArrayList<>();
//        row3.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        row3.add(new CaseBean(Building.ROAD, R.drawable.magic_tower_building_road));
//        row3.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        row3.add(new CaseBean(Building.ROAD, R.drawable.magic_tower_building_road));
//        row3.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        row3.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        row3.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        row3.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        row3.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        row3.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        row3.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        floor17.add(row3);
//
//        List<CaseBean> row4 = new ArrayList<>();
//        row4.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        row4.add(new CaseBean(Building.ROAD, R.drawable.magic_tower_building_road));
//        row4.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        row4.add(new CaseBean(Building.ROAD, R.drawable.magic_tower_building_road));
//        row4.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        row4.add(new CaseBean(Monster.LING_WU_SHI_2, R.drawable.magic_tower_monster_ling_wu_shi));
//        row4.add(new CaseBean(Building.ROAD, R.drawable.magic_tower_building_road));
//        row4.add(new CaseBean(Building.ROAD, R.drawable.magic_tower_building_road));
//        row4.add(new CaseBean(Building.ROAD, R.drawable.magic_tower_building_road));
//        row4.add(new CaseBean(Monster.LING_WU_SHI_2, R.drawable.magic_tower_monster_ling_wu_shi));
//        row4.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        floor17.add(row4);
//
//        List<CaseBean> row5 = new ArrayList<>();
//        row5.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        row5.add(new CaseBean(Building.ROAD, R.drawable.magic_tower_building_road));
//        row5.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        row5.add(new CaseBean(Monster.LING_WU_SHI_2, R.drawable.magic_tower_monster_ling_wu_shi));
//        row5.add(new CaseBean(Building.ROAD, R.drawable.magic_tower_building_road));
//        row5.add(new CaseBean(Building.ROAD, R.drawable.magic_tower_building_road));
//        row5.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        row5.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        row5.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        row5.add(new CaseBean(Building.ROAD, R.drawable.magic_tower_building_road));
//        row5.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        floor17.add(row5);
//
//        List<CaseBean> row6 = new ArrayList<>();
//        row6.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        row6.add(new CaseBean(Building.ROAD, R.drawable.magic_tower_building_road));
//        row6.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        row6.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        row6.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        row6.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        row6.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        row6.add(new CaseBean(Monster.LING_WU_SHI_2, R.drawable.magic_tower_monster_ling_wu_shi));
//        row6.add(new CaseBean(Building.ROAD, R.drawable.magic_tower_building_road));
//        row6.add(new CaseBean(Monster.LING_WU_SHI_2, R.drawable.magic_tower_monster_ling_wu_shi));
//        row6.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        floor17.add(row6);
//
//        List<CaseBean> row7 = new ArrayList<>();
//        row7.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        row7.add(new CaseBean(Monster.MING_DUI_ZHANG_2, R.drawable.magic_tower_monster_ming_dui_zhang));
//        row7.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        row7.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        row7.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        row7.add(new CaseBean(Npc.GO_DOWNSTAIRS, R.drawable.magic_tower_npc_go_downstairs));
//        row7.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        row7.add(new CaseBean(Building.ROAD, R.drawable.magic_tower_building_road));
//        row7.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        row7.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        row7.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        floor17.add(row7);
//
//        List<CaseBean> row8 = new ArrayList<>();
//        row8.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        row8.add(new CaseBean(Monster.LING_WU_SHI_2, R.drawable.magic_tower_monster_ling_wu_shi));
//        row8.add(new CaseBean(Monster.MING_DUI_ZHANG_2, R.drawable.magic_tower_monster_ming_dui_zhang));
//        row8.add(new CaseBean(Building.ROAD, R.drawable.magic_tower_building_road));
//        row8.add(new CaseBean(Monster.YING_ZI_ZHAN_SHI, R.drawable.magic_tower_monster_ying_zi_zhan_shi));
//        row8.add(new CaseBean(Building.ROAD, R.drawable.magic_tower_building_road));
//        row8.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        row8.add(new CaseBean(Monster.LING_WU_SHI_2, R.drawable.magic_tower_monster_ling_wu_shi));
//        row8.add(new CaseBean(Building.ROAD, R.drawable.magic_tower_building_road));
//        row8.add(new CaseBean(Building.ROAD, R.drawable.magic_tower_building_road));
//        row8.add(new CaseBean(Monster.LING_WU_SHI_2, R.drawable.magic_tower_monster_ling_wu_shi));
//        floor17.add(row8);
//
//        List<CaseBean> row9 = new ArrayList<>();
//        row9.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        row9.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        row9.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        row9.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        row9.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        row9.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        row9.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        row9.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        row9.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        row9.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        row9.add(new CaseBean(Building.ROAD, R.drawable.magic_tower_building_road));
//        floor17.add(row9);
//
//        List<CaseBean> row10 = new ArrayList<>();
//        row10.add(new CaseBean(Npc.GO_UPSTAIRS, R.drawable.magic_tower_npc_go_upstairs));
//        row10.add(new CaseBean(Building.ROAD, R.drawable.magic_tower_building_road));
//        row10.add(new CaseBean(Monster.YING_ZI_ZHAN_SHI, R.drawable.magic_tower_monster_ying_zi_zhan_shi));
//        row10.add(new CaseBean(Building.ROAD, R.drawable.magic_tower_building_road));
//        row10.add(new CaseBean(Building.ROAD, R.drawable.magic_tower_building_road));
//        row10.add(new CaseBean(Building.ROAD, R.drawable.magic_tower_building_road));
//        row10.add(new CaseBean(Building.ROAD, R.drawable.magic_tower_building_road));
//        row10.add(new CaseBean(Building.ROAD, R.drawable.magic_tower_building_road));
//        row10.add(new CaseBean(Building.ROAD, R.drawable.magic_tower_building_road));
//        row10.add(new CaseBean(Building.ROAD, R.drawable.magic_tower_building_road));
//        row10.add(new CaseBean(Monster.LING_WU_SHI_2, R.drawable.magic_tower_monster_ling_wu_shi));
//        floor17.add(row10);

        return floor17;
    }

    @Override
    public void fromUpstairsToThisFloor() {
        resetWarriorPosition(new Position(10, 1));
    }

    @Override
    public void fromDownstairsToThisFloor() {
        resetWarriorPosition(new Position(8, 5));
    }
}
