package com.qinshou.qinshoubox.me.bean.floor;



import com.qinshou.qinshoubox.R;
import com.qinshou.qinshoubox.me.bean.CaseBean;
import com.qinshou.qinshoubox.me.enums.Building;
import com.qinshou.qinshoubox.me.enums.Monster;
import com.qinshou.qinshoubox.me.enums.Npc;
import com.qinshou.qinshoubox.me.enums.Prop;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:第 19 层
 * Created by 禽兽先生
 * Created on 2018/4/27
 */

public class Floor19 extends AbsFloor {

    @Override
    public int getFloor() {
        return 19;
    }

    @Override
    public List<List<CaseBean>> setData() {
        List<List<CaseBean>> floor19 = new ArrayList<>();
        List<CaseBean> row0 = new ArrayList<>();
        row0.add(new CaseBean(19, 0, 0, Building.ROAD, R.drawable.magic_tower_building_road));
        row0.add(new CaseBean(19, 0, 1, Building.ROAD, R.drawable.magic_tower_building_road));
        row0.add(new CaseBean(19, 0, 2, Building.ROAD, R.drawable.magic_tower_building_road));
        row0.add(new CaseBean(19, 0, 3, Building.ROAD, R.drawable.magic_tower_building_road));
        row0.add(new CaseBean(19, 0, 4, Building.ROAD, R.drawable.magic_tower_building_road));
        row0.add(new CaseBean(19, 0, 5, Building.ROAD, R.drawable.magic_tower_building_road));
        row0.add(new CaseBean(19, 0, 6, Building.ROAD, R.drawable.magic_tower_building_road));
        row0.add(new CaseBean(19, 0, 7, Building.ROAD, R.drawable.magic_tower_building_road));
        row0.add(new CaseBean(19, 0, 8, Building.ROAD, R.drawable.magic_tower_building_road));
        row0.add(new CaseBean(19, 0, 9, Building.ROAD, R.drawable.magic_tower_building_road));
        row0.add(new CaseBean(19, 0, 10, Building.ROAD, R.drawable.magic_tower_building_road));
        floor19.add(row0);

        List<CaseBean> row1 = new ArrayList<>();
        row1.add(new CaseBean(19, 1, 0, Building.ROAD, R.drawable.magic_tower_building_road));
        row1.add(new CaseBean(19, 1, 1, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row1.add(new CaseBean(19, 1, 2, Building.ROAD, R.drawable.magic_tower_building_road));
        row1.add(new CaseBean(19, 1, 3, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row1.add(new CaseBean(19, 1, 4, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row1.add(new CaseBean(19, 1, 5, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row1.add(new CaseBean(19, 1, 6, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row1.add(new CaseBean(19, 1, 7, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row1.add(new CaseBean(19, 1, 8, Building.ROAD, R.drawable.magic_tower_building_road));
        row1.add(new CaseBean(19, 1, 9, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row1.add(new CaseBean(19, 1, 10, Building.ROAD, R.drawable.magic_tower_building_road));
        floor19.add(row1);

        List<CaseBean> row2 = new ArrayList<>();
        row2.add(new CaseBean(19, 2, 0, Building.ROAD, R.drawable.magic_tower_building_road));
        row2.add(new CaseBean(19, 2, 1, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row2.add(new CaseBean(19, 2, 2, Building.ROAD, R.drawable.magic_tower_building_road));
        row2.add(new CaseBean(19, 2, 3, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row2.add(new CaseBean(19, 2, 4, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row2.add(new CaseBean(19, 2, 5, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row2.add(new CaseBean(19, 2, 6, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row2.add(new CaseBean(19, 2, 7, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row2.add(new CaseBean(19, 2, 8, Building.ROAD, R.drawable.magic_tower_building_road));
        row2.add(new CaseBean(19, 2, 9, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row2.add(new CaseBean(19, 2, 10, Building.ROAD, R.drawable.magic_tower_building_road));
        floor19.add(row2);

        List<CaseBean> row3 = new ArrayList<>();
        row3.add(new CaseBean(19, 3, 0, Building.ROAD, R.drawable.magic_tower_building_road));
        row3.add(new CaseBean(19, 3, 1, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row3.add(new CaseBean(19, 3, 2, Building.ROAD, R.drawable.magic_tower_building_road));
        row3.add(new CaseBean(19, 3, 3, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row3.add(new CaseBean(19, 3, 4, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row3.add(new CaseBean(19, 3, 5, Npc.GO_UPSTAIRS, R.drawable.magic_tower_npc_go_upstairs));
        row3.add(new CaseBean(19, 3, 6, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row3.add(new CaseBean(19, 3, 7, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row3.add(new CaseBean(19, 3, 8, Building.ROAD, R.drawable.magic_tower_building_road));
        row3.add(new CaseBean(19, 3, 9, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row3.add(new CaseBean(19, 3, 10, Building.ROAD, R.drawable.magic_tower_building_road));
        floor19.add(row3);

        List<CaseBean> row4 = new ArrayList<>();
        row4.add(new CaseBean(19, 4, 0, Building.ROAD, R.drawable.magic_tower_building_road));
        row4.add(new CaseBean(19, 4, 1, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row4.add(new CaseBean(19, 4, 2, Building.ROAD, R.drawable.magic_tower_building_road));
        row4.add(new CaseBean(19, 4, 3, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row4.add(new CaseBean(19, 4, 4, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row4.add(new CaseBean(19, 4, 5, Building.ROAD, R.drawable.magic_tower_building_road));
        row4.add(new CaseBean(19, 4, 6, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row4.add(new CaseBean(19, 4, 7, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row4.add(new CaseBean(19, 4, 8, Building.ROAD, R.drawable.magic_tower_building_road));
        row4.add(new CaseBean(19, 4, 9, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row4.add(new CaseBean(19, 4, 10, Building.ROAD, R.drawable.magic_tower_building_road));
        floor19.add(row4);

        List<CaseBean> row5 = new ArrayList<>();
        row5.add(new CaseBean(19, 5, 0, Building.ROAD, R.drawable.magic_tower_building_road));
        row5.add(new CaseBean(19, 5, 1, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row5.add(new CaseBean(19, 5, 2, Monster.HONG_YI_MO_WANG_2, R.drawable.magic_tower_monster_hong_yi_mo_wang));
        row5.add(new CaseBean(19, 5, 3, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row5.add(new CaseBean(19, 5, 4, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row5.add(new CaseBean(19, 5, 5, Building.ROAD, R.drawable.magic_tower_building_road));
        row5.add(new CaseBean(19, 5, 6, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row5.add(new CaseBean(19, 5, 7, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row5.add(new CaseBean(19, 5, 8, Monster.HONG_YI_MO_WANG_2, R.drawable.magic_tower_monster_hong_yi_mo_wang));
        row5.add(new CaseBean(19, 5, 9, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row5.add(new CaseBean(19, 5, 10, Building.ROAD, R.drawable.magic_tower_building_road));
        floor19.add(row5);

        List<CaseBean> row6 = new ArrayList<>();
        row6.add(new CaseBean(19, 6, 0, Building.ROAD, R.drawable.magic_tower_building_road));
        row6.add(new CaseBean(19, 6, 1, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row6.add(new CaseBean(19, 6, 2, Npc.GATE_IRON_OPEN, R.drawable.magic_tower_npc_gate_iron_1));
        row6.add(new CaseBean(19, 6, 3, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row6.add(new CaseBean(19, 6, 4, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row6.add(new CaseBean(19, 6, 5, Monster.MING_LING_MO_WANG_1, R.drawable.magic_tower_monster_ming_ling_mo_wang));
        row6.add(new CaseBean(19, 6, 6, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row6.add(new CaseBean(19, 6, 7, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row6.add(new CaseBean(19, 6, 8, Npc.GATE_IRON_OPEN, R.drawable.magic_tower_npc_gate_iron_1));
        row6.add(new CaseBean(19, 6, 9, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row6.add(new CaseBean(19, 6, 10, Building.ROAD, R.drawable.magic_tower_building_road));
        floor19.add(row6);

        List<CaseBean> row7 = new ArrayList<>();
        row7.add(new CaseBean(19, 7, 0, Building.ROAD, R.drawable.magic_tower_building_road));
        row7.add(new CaseBean(19, 7, 1, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row7.add(new CaseBean(19, 7, 2, Prop.XING_GUANG_SHEN_JIAN, R.drawable.magic_tower_prop_xing_guang_shen_jian));
        row7.add(new CaseBean(19, 7, 3, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row7.add(new CaseBean(19, 7, 4, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row7.add(new CaseBean(19, 7, 5, Building.ROAD, R.drawable.magic_tower_building_road));
        row7.add(new CaseBean(19, 7, 6, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row7.add(new CaseBean(19, 7, 7, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row7.add(new CaseBean(19, 7, 8, Prop.GUANG_MANG_SHEN_DUN, R.drawable.magic_tower_prop_guang_mang_shen_dun));
        row7.add(new CaseBean(19, 7, 9, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row7.add(new CaseBean(19, 7, 10, Building.ROAD, R.drawable.magic_tower_building_road));
        floor19.add(row7);

        List<CaseBean> row8 = new ArrayList<>();
        row8.add(new CaseBean(19, 8, 0, Building.ROAD, R.drawable.magic_tower_building_road));
        row8.add(new CaseBean(19, 8, 1, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row8.add(new CaseBean(19, 8, 2, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row8.add(new CaseBean(19, 8, 3, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row8.add(new CaseBean(19, 8, 4, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row8.add(new CaseBean(19, 8, 5, Building.ROAD, R.drawable.magic_tower_building_road));
        row8.add(new CaseBean(19, 8, 6, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row8.add(new CaseBean(19, 8, 7, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row8.add(new CaseBean(19, 8, 8, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row8.add(new CaseBean(19, 8, 9, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row8.add(new CaseBean(19, 8, 10, Building.ROAD, R.drawable.magic_tower_building_road));
        floor19.add(row8);

        List<CaseBean> row9 = new ArrayList<>();
        row9.add(new CaseBean(19, 9, 0, Building.ROAD, R.drawable.magic_tower_building_road));
        row9.add(new CaseBean(19, 9, 1, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row9.add(new CaseBean(19, 9, 2, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row9.add(new CaseBean(19, 9, 3, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row9.add(new CaseBean(19, 9, 4, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row9.add(new CaseBean(19, 9, 5, Building.ROAD, R.drawable.magic_tower_building_road));
        row9.add(new CaseBean(19, 9, 6, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row9.add(new CaseBean(19, 9, 7, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row9.add(new CaseBean(19, 9, 8, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row9.add(new CaseBean(19, 9, 9, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row9.add(new CaseBean(19, 9, 10, Building.ROAD, R.drawable.magic_tower_building_road));
        floor19.add(row9);

        List<CaseBean> row10 = new ArrayList<>();
        row10.add(new CaseBean(19, 10, 0, Building.ROAD, R.drawable.magic_tower_building_road));
        row10.add(new CaseBean(19, 10, 1, Building.ROAD, R.drawable.magic_tower_building_road));
        row10.add(new CaseBean(19, 10, 2, Building.ROAD, R.drawable.magic_tower_building_road));
        row10.add(new CaseBean(19, 10, 3, Building.ROAD, R.drawable.magic_tower_building_road));
        row10.add(new CaseBean(19, 10, 4, Building.ROAD, R.drawable.magic_tower_building_road));
        row10.add(new CaseBean(19, 10, 5, Building.ROAD, R.drawable.magic_tower_building_road));
        row10.add(new CaseBean(19, 10, 6, Building.ROAD, R.drawable.magic_tower_building_road));
        row10.add(new CaseBean(19, 10, 7, Building.ROAD, R.drawable.magic_tower_building_road));
        row10.add(new CaseBean(19, 10, 8, Building.ROAD, R.drawable.magic_tower_building_road));
        row10.add(new CaseBean(19, 10, 9, Building.ROAD, R.drawable.magic_tower_building_road));
        row10.add(new CaseBean(19, 10, 10, Npc.GO_DOWNSTAIRS,R.drawable.magic_tower_npc_go_downstairs));
        floor19.add(row10);

        return floor19;
    }

    @Override
    public void fromUpstairsToThisFloor() {
        resetWarriorPosition(4, 5);
    }

    @Override
    public void fromDownstairsToThisFloor() {
        resetWarriorPosition(10, 9);
    }
}
