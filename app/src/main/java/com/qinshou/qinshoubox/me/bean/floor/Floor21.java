package com.qinshou.qinshoubox.me.bean.floor;



import com.qinshou.qinshoubox.R;
import com.qinshou.qinshoubox.me.bean.CaseBean;
import com.qinshou.qinshoubox.me.enums.Building;
import com.qinshou.qinshoubox.me.enums.Monster;
import com.qinshou.qinshoubox.me.enums.Npc;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:第 21 层
 * Created by 禽兽先生
 * Created on 2018/4/27
 */

public class Floor21 extends AFloor {

    @Override
    public int getFloor() {
        return 21;
    }

    @Override
    public List<List<CaseBean>> setData() {
        List<List<CaseBean>> floor21 = new ArrayList<>();
        List<CaseBean> row0 = new ArrayList<>();
        row0.add(new CaseBean(21, 0, 0, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row0.add(new CaseBean(21, 0, 1, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row0.add(new CaseBean(21, 0, 2, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row0.add(new CaseBean(21, 0, 3, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row0.add(new CaseBean(21, 0, 4, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row0.add(new CaseBean(21, 0, 5, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row0.add(new CaseBean(21, 0, 6, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row0.add(new CaseBean(21, 0, 7, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row0.add(new CaseBean(21, 0, 8, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row0.add(new CaseBean(21, 0, 9, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row0.add(new CaseBean(21, 0, 10, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        floor21.add(row0);

        List<CaseBean> row1 = new ArrayList<>();
        row1.add(new CaseBean(21, 1, 0, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row1.add(new CaseBean(21, 1, 1, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row1.add(new CaseBean(21, 1, 2, Building.ROAD, R.drawable.magic_tower_building_road));
        row1.add(new CaseBean(21, 1, 3, Building.ROAD, R.drawable.magic_tower_building_road));
        row1.add(new CaseBean(21, 1, 4, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row1.add(new CaseBean(21, 1, 5, Monster.MING_LING_MO_WANG_2, R.drawable.magic_tower_monster_ming_ling_mo_wang));
        row1.add(new CaseBean(21, 1, 6, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row1.add(new CaseBean(21, 1, 7, Building.ROAD, R.drawable.magic_tower_building_road));
        row1.add(new CaseBean(21, 1, 8, Building.ROAD, R.drawable.magic_tower_building_road));
        row1.add(new CaseBean(21, 1, 9, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row1.add(new CaseBean(21, 1, 10, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        floor21.add(row1);

        List<CaseBean> row2 = new ArrayList<>();
        row2.add(new CaseBean(21, 2, 0, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row2.add(new CaseBean(21, 2, 1, Building.ROAD, R.drawable.magic_tower_building_road));
        row2.add(new CaseBean(21, 2, 2, Building.ROAD, R.drawable.magic_tower_building_road));
        row2.add(new CaseBean(21, 2, 3, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row2.add(new CaseBean(21, 2, 4, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row2.add(new CaseBean(21, 2, 5, Monster.LING_FA_SHI_2, R.drawable.magic_tower_monster_ling_fa_shi));
        row2.add(new CaseBean(21, 2, 6, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row2.add(new CaseBean(21, 2, 7, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row2.add(new CaseBean(21, 2, 8, Building.ROAD, R.drawable.magic_tower_building_road));
        row2.add(new CaseBean(21, 2, 9, Building.ROAD, R.drawable.magic_tower_building_road));
        row2.add(new CaseBean(21, 2, 10, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        floor21.add(row2);

        List<CaseBean> row3 = new ArrayList<>();
        row3.add(new CaseBean(21, 3, 0, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row3.add(new CaseBean(21, 3, 1, Building.ROAD, R.drawable.magic_tower_building_road));
        row3.add(new CaseBean(21, 3, 2, Building.ROAD, R.drawable.magic_tower_building_road));
        row3.add(new CaseBean(21, 3, 3, Building.ROAD, R.drawable.magic_tower_building_road));
        row3.add(new CaseBean(21, 3, 4, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row3.add(new CaseBean(21, 3, 5, Monster.LING_FA_SHI_2, R.drawable.magic_tower_monster_ling_fa_shi));
        row3.add(new CaseBean(21, 3, 6, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row3.add(new CaseBean(21, 3, 7, Building.ROAD, R.drawable.magic_tower_building_road));
        row3.add(new CaseBean(21, 3, 8, Building.ROAD, R.drawable.magic_tower_building_road));
        row3.add(new CaseBean(21, 3, 9, Building.ROAD, R.drawable.magic_tower_building_road));
        row3.add(new CaseBean(21, 3, 10, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        floor21.add(row3);

        List<CaseBean> row4 = new ArrayList<>();
        row4.add(new CaseBean(21, 4, 0, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row4.add(new CaseBean(21, 4, 1, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row4.add(new CaseBean(21, 4, 2, Building.ROAD, R.drawable.magic_tower_building_road));
        row4.add(new CaseBean(21, 4, 3, Building.ROAD, R.drawable.magic_tower_building_road));
        row4.add(new CaseBean(21, 4, 4, Building.ROAD, R.drawable.magic_tower_building_road));
        row4.add(new CaseBean(21, 4, 5, Building.ROAD, R.drawable.magic_tower_building_road));
        row4.add(new CaseBean(21, 4, 6, Building.ROAD, R.drawable.magic_tower_building_road));
        row4.add(new CaseBean(21, 4, 7, Building.ROAD, R.drawable.magic_tower_building_road));
        row4.add(new CaseBean(21, 4, 8, Building.ROAD, R.drawable.magic_tower_building_road));
        row4.add(new CaseBean(21, 4, 9, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row4.add(new CaseBean(21, 4, 10, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        floor21.add(row4);

        List<CaseBean> row5 = new ArrayList<>();
        row5.add(new CaseBean(21, 5, 0, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row5.add(new CaseBean(21, 5, 1, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row5.add(new CaseBean(21, 5, 2, Building.ROAD, R.drawable.magic_tower_building_road));
        row5.add(new CaseBean(21, 5, 3, Building.ROAD, R.drawable.magic_tower_building_road));
        row5.add(new CaseBean(21, 5, 4, Building.ROAD, R.drawable.magic_tower_building_road));
        row5.add(new CaseBean(21, 5, 5, Building.ROAD, R.drawable.magic_tower_building_road));
        row5.add(new CaseBean(21, 5, 6, Building.ROAD, R.drawable.magic_tower_building_road));
        row5.add(new CaseBean(21, 5, 7, Building.ROAD, R.drawable.magic_tower_building_road));
        row5.add(new CaseBean(21, 5, 8, Building.ROAD, R.drawable.magic_tower_building_road));
        row5.add(new CaseBean(21, 5, 9, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row5.add(new CaseBean(21, 5, 10, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        floor21.add(row5);

        List<CaseBean> row6 = new ArrayList<>();
        row6.add(new CaseBean(21, 6, 0, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row6.add(new CaseBean(21, 6, 1, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row6.add(new CaseBean(21, 6, 2, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row6.add(new CaseBean(21, 6, 3, Building.ROAD, R.drawable.magic_tower_building_road));
        row6.add(new CaseBean(21, 6, 4, Building.ROAD, R.drawable.magic_tower_building_road));
        row6.add(new CaseBean(21, 6, 5, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row6.add(new CaseBean(21, 6, 6, Building.ROAD, R.drawable.magic_tower_building_road));
        row6.add(new CaseBean(21, 6, 7, Building.ROAD, R.drawable.magic_tower_building_road));
        row6.add(new CaseBean(21, 6, 8, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row6.add(new CaseBean(21, 6, 9, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row6.add(new CaseBean(21, 6, 10, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        floor21.add(row6);

        List<CaseBean> row7 = new ArrayList<>();
        row7.add(new CaseBean(21, 7, 0, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row7.add(new CaseBean(21, 7, 1, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row7.add(new CaseBean(21, 7, 2, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row7.add(new CaseBean(21, 7, 3, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row7.add(new CaseBean(21, 7, 4, Npc.GATE_IRON_CLOSE, R.drawable.magic_tower_npc_gate_iron_1));
        row7.add(new CaseBean(21, 7, 5, Npc.GO_DOWNSTAIRS, R.drawable.magic_tower_npc_go_downstairs));
        row7.add(new CaseBean(21, 7, 6, Npc.GATE_IRON_CLOSE, R.drawable.magic_tower_npc_gate_iron_1));
        row7.add(new CaseBean(21, 7, 7, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row7.add(new CaseBean(21, 7, 8, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row7.add(new CaseBean(21, 7, 9, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row7.add(new CaseBean(21, 7, 10, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        floor21.add(row7);

        List<CaseBean> row8 = new ArrayList<>();
        row8.add(new CaseBean(21, 8, 0, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row8.add(new CaseBean(21, 8, 1, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row8.add(new CaseBean(21, 8, 2, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row8.add(new CaseBean(21, 8, 3, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row8.add(new CaseBean(21, 8, 4, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row8.add(new CaseBean(21, 8, 5, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row8.add(new CaseBean(21, 8, 6, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row8.add(new CaseBean(21, 8, 7, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row8.add(new CaseBean(21, 8, 8, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row8.add(new CaseBean(21, 8, 9, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row8.add(new CaseBean(21, 8, 10, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        floor21.add(row8);

        List<CaseBean> row9 = new ArrayList<>();
        row9.add(new CaseBean(21, 9, 0, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row9.add(new CaseBean(21, 9, 1, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row9.add(new CaseBean(21, 9, 2, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row9.add(new CaseBean(21, 9, 3, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row9.add(new CaseBean(21, 9, 4, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row9.add(new CaseBean(21, 9, 5, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row9.add(new CaseBean(21, 9, 6, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row9.add(new CaseBean(21, 9, 7, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row9.add(new CaseBean(21, 9, 8, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row9.add(new CaseBean(21, 9, 9, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row9.add(new CaseBean(21, 9, 10, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        floor21.add(row9);

        List<CaseBean> row10 = new ArrayList<>();
        row10.add(new CaseBean(21, 10, 0, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row10.add(new CaseBean(21, 10, 1, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row10.add(new CaseBean(21, 10, 2, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row10.add(new CaseBean(21, 10, 3, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row10.add(new CaseBean(21, 10, 4, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row10.add(new CaseBean(21, 10, 5, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row10.add(new CaseBean(21, 10, 6, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row10.add(new CaseBean(21, 10, 7, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row10.add(new CaseBean(21, 10, 8, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row10.add(new CaseBean(21, 10, 9, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row10.add(new CaseBean(21, 10, 10, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        floor21.add(row10);

        return floor21;
    }

    @Override
    public void fromUpstairsToThisFloor() {
//        resetWarriorPosition(0, 0);
    }

    @Override
    public void fromDownstairsToThisFloor() {
        resetWarriorPosition(5, 5);
    }
}
