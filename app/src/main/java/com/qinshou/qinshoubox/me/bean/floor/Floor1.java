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
 * Description:第 1 层
 * Created by 禽兽先生
 * Created on 2017/4/26
 */

public class Floor1 extends AFloor {

    @Override
    public int getFloor() {
        return 1;
    }

    @Override
    public List<List<CaseBean>> setData() {
        List<List<CaseBean>> floor1 = new ArrayList<>();
        List<CaseBean> row0 = new ArrayList<>();
        row0.add(new CaseBean(1, 0, 0, Npc.GO_UPSTAIRS, R.drawable.magic_tower_npc_go_upstairs));
        row0.add(new CaseBean(1, 0, 1, Building.ROAD, R.drawable.magic_tower_building_road));
        row0.add(new CaseBean(1, 0, 2, Prop.KEY_YELLOW, R.drawable.magic_tower_prop_key_yellow));
        row0.add(new CaseBean(1, 0, 3, Monster.LV_TOU_GUAI, R.drawable.magic_tower_monster_lv_tou_guai));
        row0.add(new CaseBean(1, 0, 4, Monster.HONG_TOU_GUAI, R.drawable.magic_tower_monster_hong_tou_guai));
        row0.add(new CaseBean(1, 0, 5, Monster.LV_TOU_GUAI, R.drawable.magic_tower_monster_lv_tou_guai));
        row0.add(new CaseBean(1, 0, 6, Building.ROAD, R.drawable.magic_tower_building_road));
        row0.add(new CaseBean(1, 0, 7, Building.ROAD, R.drawable.magic_tower_building_road));
        row0.add(new CaseBean(1, 0, 8, Building.ROAD, R.drawable.magic_tower_building_road));
        row0.add(new CaseBean(1, 0, 9, Building.ROAD, R.drawable.magic_tower_building_road));
        row0.add(new CaseBean(1, 0, 10, Building.ROAD, R.drawable.magic_tower_building_road));
        floor1.add(row0);

        List<CaseBean> row1 = new ArrayList<>();
        row1.add(new CaseBean(1, 1, 0, Building.WALL, R.drawable.magic_tower_building_wall));
        row1.add(new CaseBean(1, 1, 1, Building.WALL, R.drawable.magic_tower_building_wall));
        row1.add(new CaseBean(1, 1, 2, Building.WALL, R.drawable.magic_tower_building_wall));
        row1.add(new CaseBean(1, 1, 3, Building.WALL, R.drawable.magic_tower_building_wall));
        row1.add(new CaseBean(1, 1, 4, Building.WALL, R.drawable.magic_tower_building_wall));
        row1.add(new CaseBean(1, 1, 5, Building.WALL, R.drawable.magic_tower_building_wall));
        row1.add(new CaseBean(1, 1, 6, Building.WALL, R.drawable.magic_tower_building_wall));
        row1.add(new CaseBean(1, 1, 7, Building.WALL, R.drawable.magic_tower_building_wall));
        row1.add(new CaseBean(1, 1, 8, Building.WALL, R.drawable.magic_tower_building_wall));
        row1.add(new CaseBean(1, 1, 9, Building.WALL, R.drawable.magic_tower_building_wall));
        row1.add(new CaseBean(1, 1, 10, Building.ROAD, R.drawable.magic_tower_building_road));
        floor1.add(row1);

        List<CaseBean> row2 = new ArrayList<>();
        row2.add(new CaseBean(1, 2, 0, Prop.XIE_PING_SMALL, R.drawable.magic_tower_prop_xie_ping_small));
        row2.add(new CaseBean(1, 2, 1, Building.ROAD, R.drawable.magic_tower_building_road));
        row2.add(new CaseBean(1, 2, 2, Monster.KU_LOU_REN, R.drawable.magic_tower_monster_ku_lou_ren));
        row2.add(new CaseBean(1, 2, 3, Npc.GATE_YELLOW, R.drawable.magic_tower_npc_gate_yellow_1));
        row2.add(new CaseBean(1, 2, 4, Building.ROAD, R.drawable.magic_tower_building_road));
        row2.add(new CaseBean(1, 2, 5, Building.WALL, R.drawable.magic_tower_building_wall));
        row2.add(new CaseBean(1, 2, 6, Prop.XIE_PING_SMALL, R.drawable.magic_tower_prop_xie_ping_small));
        row2.add(new CaseBean(1, 2, 7, Prop.KEY_YELLOW, R.drawable.magic_tower_prop_key_yellow));
        row2.add(new CaseBean(1, 2, 8, Prop.XIE_PING_SMALL, R.drawable.magic_tower_prop_xie_ping_small));
        row2.add(new CaseBean(1, 2, 9, Building.WALL, R.drawable.magic_tower_building_wall));
        row2.add(new CaseBean(1, 2, 10, Building.ROAD, R.drawable.magic_tower_building_road));
        floor1.add(row2);

        List<CaseBean> row3 = new ArrayList<>();
        row3.add(new CaseBean(1, 3, 0, Prop.KEY_YELLOW, R.drawable.magic_tower_prop_key_yellow));
        row3.add(new CaseBean(1, 3, 1, Monster.KU_LOU_REN, R.drawable.magic_tower_monster_ku_lou_ren));
        row3.add(new CaseBean(1, 3, 2, Prop.BAO_SHI_RED, R.drawable.magic_tower_prop_bao_shi_red));
        row3.add(new CaseBean(1, 3, 3, Building.WALL, R.drawable.magic_tower_building_wall));
        row3.add(new CaseBean(1, 3, 4, Building.ROAD, R.drawable.magic_tower_building_road));
        row3.add(new CaseBean(1, 3, 5, Building.WALL, R.drawable.magic_tower_building_wall));
        row3.add(new CaseBean(1, 3, 6, Prop.XIE_PING_SMALL, R.drawable.magic_tower_prop_xie_ping_small));
        row3.add(new CaseBean(1, 3, 7, Prop.KEY_YELLOW, R.drawable.magic_tower_prop_key_yellow));
        row3.add(new CaseBean(1, 3, 8, Prop.XIE_PING_SMALL, R.drawable.magic_tower_prop_xie_ping_small));
        row3.add(new CaseBean(1, 3, 9, Building.WALL, R.drawable.magic_tower_building_wall));
        row3.add(new CaseBean(1, 3, 10, Building.ROAD, R.drawable.magic_tower_building_road));
        floor1.add(row3);

        List<CaseBean> row4 = new ArrayList<>();
        row4.add(new CaseBean(1, 4, 0, Building.WALL, R.drawable.magic_tower_building_wall));
        row4.add(new CaseBean(1, 4, 1, Npc.GATE_YELLOW, R.drawable.magic_tower_npc_gate_yellow_1));
        row4.add(new CaseBean(1, 4, 2, Building.WALL, R.drawable.magic_tower_building_wall));
        row4.add(new CaseBean(1, 4, 3, Building.WALL, R.drawable.magic_tower_building_wall));
        row4.add(new CaseBean(1, 4, 4, Building.ROAD, R.drawable.magic_tower_building_road));
        row4.add(new CaseBean(1, 4, 5, Building.WALL, R.drawable.magic_tower_building_wall));
        row4.add(new CaseBean(1, 4, 6, Building.WALL, R.drawable.magic_tower_building_wall));
        row4.add(new CaseBean(1, 4, 7, Building.WALL, R.drawable.magic_tower_building_wall));
        row4.add(new CaseBean(1, 4, 8, Monster.QING_TOU_GUAI, R.drawable.magic_tower_monster_qing_tou_guai));
        row4.add(new CaseBean(1, 4, 9, Building.WALL, R.drawable.magic_tower_building_wall));
        row4.add(new CaseBean(1, 4, 10, Building.ROAD, R.drawable.magic_tower_building_road));
        floor1.add(row4);

        List<CaseBean> row5 = new ArrayList<>();
        row5.add(new CaseBean(1, 5, 0, Prop.KEY_YELLOW, R.drawable.magic_tower_prop_key_yellow));
        row5.add(new CaseBean(1, 5, 1, Monster.KU_LOU_SHI_BING, R.drawable.magic_tower_monster_ku_lou_shi_bing));
        row5.add(new CaseBean(1, 5, 2, Building.ROAD, R.drawable.magic_tower_building_road));
        row5.add(new CaseBean(1, 5, 3, Building.WALL, R.drawable.magic_tower_building_wall));
        row5.add(new CaseBean(1, 5, 4, Building.ROAD, R.drawable.magic_tower_building_road));
        row5.add(new CaseBean(1, 5, 5, Npc.GATE_YELLOW, R.drawable.magic_tower_npc_gate_yellow_1));
        row5.add(new CaseBean(1, 5, 6, Monster.CHU_JI_FA_SHI, R.drawable.magic_tower_monster_chu_ji_fa_shi));
        row5.add(new CaseBean(1, 5, 7, Monster.LV_TOU_GUAI, R.drawable.magic_tower_monster_lv_tou_guai));
        row5.add(new CaseBean(1, 5, 8, Monster.XIAO_BIAN_FU, R.drawable.magic_tower_monster_xiao_bian_fu));
        row5.add(new CaseBean(1, 5, 9, Building.WALL, R.drawable.magic_tower_building_wall));
        row5.add(new CaseBean(1, 5, 10, Building.ROAD, R.drawable.magic_tower_building_road));
        floor1.add(row5);

        List<CaseBean> row6 = new ArrayList<>();
        row6.add(new CaseBean(1, 6, 0, Prop.BAO_SHI_BLUE, R.drawable.magic_tower_prop_bao_shi_blue));
        row6.add(new CaseBean(1, 6, 1, Building.ROAD, R.drawable.magic_tower_building_road));
        row6.add(new CaseBean(1, 6, 2, Prop.KEY_BLUE, R.drawable.magic_tower_prop_key_blue));
        row6.add(new CaseBean(1, 6, 3, Building.WALL, R.drawable.magic_tower_building_wall));
        row6.add(new CaseBean(1, 6, 4, Building.ROAD, R.drawable.magic_tower_building_road));
        row6.add(new CaseBean(1, 6, 5, Building.WALL, R.drawable.magic_tower_building_wall));
        row6.add(new CaseBean(1, 6, 6, Building.WALL, R.drawable.magic_tower_building_wall));
        row6.add(new CaseBean(1, 6, 7, Building.WALL, R.drawable.magic_tower_building_wall));
        row6.add(new CaseBean(1, 6, 8, Building.WALL, R.drawable.magic_tower_building_wall));
        row6.add(new CaseBean(1, 6, 9, Building.WALL, R.drawable.magic_tower_building_wall));
        row6.add(new CaseBean(1, 6, 10, Building.ROAD, R.drawable.magic_tower_building_road));
        floor1.add(row6);

        List<CaseBean> row7 = new ArrayList<>();
        row7.add(new CaseBean(1, 7, 0, Building.WALL, R.drawable.magic_tower_building_wall));
        row7.add(new CaseBean(1, 7, 1, Npc.GATE_YELLOW, R.drawable.magic_tower_npc_gate_yellow_1));
        row7.add(new CaseBean(1, 7, 2, Building.WALL, R.drawable.magic_tower_building_wall));
        row7.add(new CaseBean(1, 7, 3, Building.WALL, R.drawable.magic_tower_building_wall));
        row7.add(new CaseBean(1, 7, 4, Building.ROAD, R.drawable.magic_tower_building_road));
        row7.add(new CaseBean(1, 7, 5, Building.ROAD, R.drawable.magic_tower_building_road));
        row7.add(new CaseBean(1, 7, 6, Building.ROAD, R.drawable.magic_tower_building_road));
        row7.add(new CaseBean(1, 7, 7, Building.ROAD, R.drawable.magic_tower_building_road));
        row7.add(new CaseBean(1, 7, 8, Building.ROAD, R.drawable.magic_tower_building_road));
        row7.add(new CaseBean(1, 7, 9, Building.ROAD, R.drawable.magic_tower_building_road));
        row7.add(new CaseBean(1, 7, 10, Building.ROAD, R.drawable.magic_tower_building_road));
        floor1.add(row7);

        List<CaseBean> row8 = new ArrayList<>();
        row8.add(new CaseBean(1, 8, 0, Building.ROAD, R.drawable.magic_tower_building_road));
        row8.add(new CaseBean(1, 8, 1, Monster.KU_LOU_SHI_BING, R.drawable.magic_tower_monster_ku_lou_shi_bing));
        row8.add(new CaseBean(1, 8, 2, Building.ROAD, R.drawable.magic_tower_building_road));
        row8.add(new CaseBean(1, 8, 3, Building.WALL, R.drawable.magic_tower_building_wall));
        row8.add(new CaseBean(1, 8, 4, Building.WALL, R.drawable.magic_tower_building_wall));
        row8.add(new CaseBean(1, 8, 5, Npc.GATE_RED, R.drawable.magic_tower_npc_gate_red_1));
        row8.add(new CaseBean(1, 8, 6, Building.WALL, R.drawable.magic_tower_building_wall));
        row8.add(new CaseBean(1, 8, 7, Building.WALL, R.drawable.magic_tower_building_wall));
        row8.add(new CaseBean(1, 8, 8, Building.WALL, R.drawable.magic_tower_building_wall));
        row8.add(new CaseBean(1, 8, 9, Npc.GATE_YELLOW, R.drawable.magic_tower_npc_gate_yellow_1));
        row8.add(new CaseBean(1, 8, 10, Building.WALL, R.drawable.magic_tower_building_wall));
        floor1.add(row8);

        List<CaseBean> row9 = new ArrayList<>();
        row9.add(new CaseBean(1, 9, 0, Prop.XIE_PING_SMALL, R.drawable.magic_tower_prop_xie_ping_small));
        row9.add(new CaseBean(1, 9, 1, Prop.XIE_PING_BIG, R.drawable.magic_tower_prop_xie_ping_big));
        row9.add(new CaseBean(1, 9, 2, Prop.KEY_YELLOW, R.drawable.magic_tower_prop_key_yellow));
        row9.add(new CaseBean(1, 9, 3, Building.WALL, R.drawable.magic_tower_building_wall));
        row9.add(new CaseBean(1, 9, 4, Prop.KEY_RED, R.drawable.magic_tower_prop_key_red));
        row9.add(new CaseBean(1, 9, 5, Building.ROAD, R.drawable.magic_tower_building_road));
        row9.add(new CaseBean(1, 9, 6, Building.ROAD, R.drawable.magic_tower_building_road));
        row9.add(new CaseBean(1, 9, 7, Building.WALL, R.drawable.magic_tower_building_wall));
        row9.add(new CaseBean(1, 9, 8, Prop.KEY_YELLOW, R.drawable.magic_tower_prop_key_yellow));
        row9.add(new CaseBean(1, 9, 9, Monster.SHOU_MIAN_REN, R.drawable.magic_tower_monster_shou_mian_ren));
        row9.add(new CaseBean(1, 9, 10, Prop.KEY_BLUE, R.drawable.magic_tower_prop_key_blue));
        floor1.add(row9);

        List<CaseBean> row10 = new ArrayList<>();
        row10.add(new CaseBean(1, 10, 0, Prop.XIE_PING_SMALL, R.drawable.magic_tower_prop_xie_ping_small));
        row10.add(new CaseBean(1, 10, 1, Prop.SHENG_GUANG_HUI, R.drawable.magic_tower_prop_sheng_guang_hui));
        row10.add(new CaseBean(1, 10, 2, Prop.KEY_YELLOW, R.drawable.magic_tower_prop_key_yellow));
        row10.add(new CaseBean(1, 10, 3, Building.WALL, R.drawable.magic_tower_building_wall));
        row10.add(new CaseBean(1, 10, 4, Building.ROAD, R.drawable.magic_tower_building_road));
        row10.add(new CaseBean(1, 10, 5, Npc.GO_DOWNSTAIRS, R.drawable.magic_tower_npc_go_downstairs));
        row10.add(new CaseBean(1, 10, 6, Building.ROAD, R.drawable.magic_tower_building_road));
        row10.add(new CaseBean(1, 10, 7, Building.WALL, R.drawable.magic_tower_building_wall));
        row10.add(new CaseBean(1, 10, 8, Prop.KEY_YELLOW, R.drawable.magic_tower_prop_key_yellow));
        row10.add(new CaseBean(1, 10, 9, Prop.KEY_YELLOW, R.drawable.magic_tower_prop_key_yellow));
        row10.add(new CaseBean(1, 10, 10, Prop.KEY_YELLOW, R.drawable.magic_tower_prop_key_yellow));
        floor1.add(row10);

        return floor1;
    }

    @Override
    public void fromUpstairsToThisFloor() {
        resetWarriorPosition(0, 1);
    }

    @Override
    public void fromDownstairsToThisFloor() {
        resetWarriorPosition(9, 5);
    }
}
