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
 * Description:第 4 层
 * Created by 禽兽先生
 * Created on 2017/4/26
 */

public class Floor4 extends AFloor {

    @Override
    public int getFloor() {
        return 4;
    }

    @Override
    public List<List<CaseBean>> setData() {
        List<List<CaseBean>> floor4 = new ArrayList<>();
        List<CaseBean> row0 = new ArrayList<>();
        row0.add(new CaseBean(4, 0, 0, Building.ROAD, R.drawable.magic_tower_building_road));
        row0.add(new CaseBean(4, 0, 1, Monster.QING_TOU_GUAI, R.drawable.magic_tower_monster_qing_tou_guai));
        row0.add(new CaseBean(4, 0, 2, Building.ROAD, R.drawable.magic_tower_building_road));
        row0.add(new CaseBean(4, 0, 3, Building.WALL, R.drawable.magic_tower_building_wall));
        row0.add(new CaseBean(4, 0, 4, Building.ROAD, R.drawable.magic_tower_building_road));
        row0.add(new CaseBean(4, 0, 5, Npc.THIEF_1, R.drawable.magic_tower_npc_thief));
        row0.add(new CaseBean(4, 0, 6, Building.ROAD, R.drawable.magic_tower_building_road));
        row0.add(new CaseBean(4, 0, 7, Building.WALL, R.drawable.magic_tower_building_wall));
        row0.add(new CaseBean(4, 0, 8, Building.ROAD, R.drawable.magic_tower_building_road));
        row0.add(new CaseBean(4, 0, 9, Monster.QING_TOU_GUAI, R.drawable.magic_tower_monster_qing_tou_guai));
        row0.add(new CaseBean(4, 0, 10, Building.ROAD, R.drawable.magic_tower_building_road));
        floor4.add(row0);

        List<CaseBean> row1 = new ArrayList<>();
        row1.add(new CaseBean(4, 1, 0, Npc.GATE_YELLOW, R.drawable.magic_tower_npc_gate_yellow_1));
        row1.add(new CaseBean(4, 1, 1, Building.WALL, R.drawable.magic_tower_building_wall));
        row1.add(new CaseBean(4, 1, 2, Npc.GATE_YELLOW, R.drawable.magic_tower_npc_gate_yellow_1));
        row1.add(new CaseBean(4, 1, 3, Building.WALL, R.drawable.magic_tower_building_wall));
        row1.add(new CaseBean(4, 1, 4, Building.ROAD, R.drawable.magic_tower_building_road));
        row1.add(new CaseBean(4, 1, 5, Building.ROAD, R.drawable.magic_tower_building_road));
        row1.add(new CaseBean(4, 1, 6, Building.ROAD, R.drawable.magic_tower_building_road));
        row1.add(new CaseBean(4, 1, 7, Building.WALL, R.drawable.magic_tower_building_wall));
        row1.add(new CaseBean(4, 1, 8, Npc.GATE_YELLOW, R.drawable.magic_tower_npc_gate_yellow_1));
        row1.add(new CaseBean(4, 1, 9, Building.WALL, R.drawable.magic_tower_building_wall));
        row1.add(new CaseBean(4, 1, 10, Npc.GATE_YELLOW, R.drawable.magic_tower_npc_gate_yellow_1));
        floor4.add(row1);

        List<CaseBean> row2 = new ArrayList<>();
        row2.add(new CaseBean(4, 2, 0, Building.ROAD, R.drawable.magic_tower_building_road));
        row2.add(new CaseBean(4, 2, 1, Building.WALL, R.drawable.magic_tower_building_wall));
        row2.add(new CaseBean(4, 2, 2, Building.ROAD, R.drawable.magic_tower_building_road));
        row2.add(new CaseBean(4, 2, 3, Building.WALL, R.drawable.magic_tower_building_wall));
        row2.add(new CaseBean(4, 2, 4, Building.WALL, R.drawable.magic_tower_building_wall));
        row2.add(new CaseBean(4, 2, 5, Npc.GATE_IRON_OPEN, R.drawable.magic_tower_npc_gate_iron_1));
        row2.add(new CaseBean(4, 2, 6, Building.WALL, R.drawable.magic_tower_building_wall));
        row2.add(new CaseBean(4, 2, 7, Building.WALL, R.drawable.magic_tower_building_wall));
        row2.add(new CaseBean(4, 2, 8, Building.ROAD, R.drawable.magic_tower_building_road));
        row2.add(new CaseBean(4, 2, 9, Building.WALL, R.drawable.magic_tower_building_wall));
        row2.add(new CaseBean(4, 2, 10, Building.ROAD, R.drawable.magic_tower_building_road));
        floor4.add(row2);

        List<CaseBean> row3 = new ArrayList<>();
        row3.add(new CaseBean(4, 3, 0, Building.ROAD, R.drawable.magic_tower_building_road));
        row3.add(new CaseBean(4, 3, 1, Building.WALL, R.drawable.magic_tower_building_wall));
        row3.add(new CaseBean(4, 3, 2, Monster.KU_LOU_REN, R.drawable.magic_tower_monster_ku_lou_ren));
        row3.add(new CaseBean(4, 3, 3, Building.WALL, R.drawable.magic_tower_building_wall));
        row3.add(new CaseBean(4, 3, 4, Monster.DA_BIAN_FU, R.drawable.magic_tower_monster_da_bian_fu));
        row3.add(new CaseBean(4, 3, 5, Monster.HONG_BIAN_FU, R.drawable.magic_tower_monster_hong_bian_fu));
        row3.add(new CaseBean(4, 3, 6, Monster.DA_BIAN_FU, R.drawable.magic_tower_monster_da_bian_fu));
        row3.add(new CaseBean(4, 3, 7, Building.WALL, R.drawable.magic_tower_building_wall));
        row3.add(new CaseBean(4, 3, 8, Monster.KU_LOU_REN, R.drawable.magic_tower_monster_ku_lou_ren));
        row3.add(new CaseBean(4, 3, 9, Building.WALL, R.drawable.magic_tower_building_wall));
        row3.add(new CaseBean(4, 3, 10, Building.ROAD, R.drawable.magic_tower_building_road));
        floor4.add(row3);

        List<CaseBean> row4 = new ArrayList<>();
        row4.add(new CaseBean(4, 4, 0, Monster.XIAO_BIAN_FU, R.drawable.magic_tower_monster_xiao_bian_fu));
        row4.add(new CaseBean(4, 4, 1, Building.WALL, R.drawable.magic_tower_building_wall));
        row4.add(new CaseBean(4, 4, 2, Prop.XIE_PING_SMALL, R.drawable.magic_tower_prop_xie_ping_small));
        row4.add(new CaseBean(4, 4, 3, Building.WALL, R.drawable.magic_tower_building_wall));
        row4.add(new CaseBean(4, 4, 4, Prop.BAO_SHI_BLUE, R.drawable.magic_tower_prop_bao_shi_blue));
        row4.add(new CaseBean(4, 4, 5, Monster.DA_BIAN_FU, R.drawable.magic_tower_monster_da_bian_fu));
        row4.add(new CaseBean(4, 4, 6, Prop.BAO_SHI_BLUE, R.drawable.magic_tower_prop_bao_shi_blue));
        row4.add(new CaseBean(4, 4, 7, Building.WALL, R.drawable.magic_tower_building_wall));
        row4.add(new CaseBean(4, 4, 8, Prop.XIE_PING_SMALL, R.drawable.magic_tower_prop_xie_ping_small));
        row4.add(new CaseBean(4, 4, 9, Building.WALL, R.drawable.magic_tower_building_wall));
        row4.add(new CaseBean(4, 4, 10, Monster.XIAO_BIAN_FU, R.drawable.magic_tower_monster_xiao_bian_fu));
        floor4.add(row4);

        List<CaseBean> row5 = new ArrayList<>();
        row5.add(new CaseBean(4, 5, 0, Monster.XIAO_BIAN_FU, R.drawable.magic_tower_monster_xiao_bian_fu));
        row5.add(new CaseBean(4, 5, 1, Building.WALL, R.drawable.magic_tower_building_wall));
        row5.add(new CaseBean(4, 5, 2, Prop.XIE_PING_SMALL, R.drawable.magic_tower_prop_xie_ping_small));
        row5.add(new CaseBean(4, 5, 3, Building.WALL, R.drawable.magic_tower_building_wall));
        row5.add(new CaseBean(4, 5, 4, Building.WALL, R.drawable.magic_tower_building_wall));
        row5.add(new CaseBean(4, 5, 5, Npc.GATE_RED, R.drawable.magic_tower_npc_gate_red_1));
        row5.add(new CaseBean(4, 5, 6, Building.WALL, R.drawable.magic_tower_building_wall));
        row5.add(new CaseBean(4, 5, 7, Building.WALL, R.drawable.magic_tower_building_wall));
        row5.add(new CaseBean(4, 5, 8, Prop.XIE_PING_SMALL, R.drawable.magic_tower_prop_xie_ping_small));
        row5.add(new CaseBean(4, 5, 9, Building.WALL, R.drawable.magic_tower_building_wall));
        row5.add(new CaseBean(4, 5, 10, Monster.XIAO_BIAN_FU, R.drawable.magic_tower_monster_xiao_bian_fu));
        floor4.add(row5);

        List<CaseBean> row6 = new ArrayList<>();
        row6.add(new CaseBean(4, 6, 0, Monster.HONG_TOU_GUAI, R.drawable.magic_tower_monster_hong_tou_guai));
        row6.add(new CaseBean(4, 6, 1, Building.WALL, R.drawable.magic_tower_building_wall));
        row6.add(new CaseBean(4, 6, 2, Building.ROAD, R.drawable.magic_tower_building_road));
        row6.add(new CaseBean(4, 6, 3, Building.WALL, R.drawable.magic_tower_building_wall));
        row6.add(new CaseBean(4, 6, 4, Monster.SHOU_MIAN_REN, R.drawable.magic_tower_monster_shou_mian_ren));
        row6.add(new CaseBean(4, 6, 5, Monster.CHU_JI_WEI_BING, R.drawable.magic_tower_monster_chu_ji_wei_bing));
        row6.add(new CaseBean(4, 6, 6, Monster.SHOU_MIAN_REN, R.drawable.magic_tower_monster_shou_mian_ren));
        row6.add(new CaseBean(4, 6, 7, Building.WALL, R.drawable.magic_tower_building_wall));
        row6.add(new CaseBean(4, 6, 8, Building.ROAD, R.drawable.magic_tower_building_road));
        row6.add(new CaseBean(4, 6, 9, Building.WALL, R.drawable.magic_tower_building_wall));
        row6.add(new CaseBean(4, 6, 10, Monster.HONG_TOU_GUAI, R.drawable.magic_tower_monster_hong_tou_guai));
        floor4.add(row6);

        List<CaseBean> row7 = new ArrayList<>();
        row7.add(new CaseBean(4, 7, 0, Building.ROAD, R.drawable.magic_tower_building_road));
        row7.add(new CaseBean(4, 7, 1, Building.WALL, R.drawable.magic_tower_building_wall));
        row7.add(new CaseBean(4, 7, 2, Building.ROAD, R.drawable.magic_tower_building_road));
        row7.add(new CaseBean(4, 7, 3, Building.WALL, R.drawable.magic_tower_building_wall));
        row7.add(new CaseBean(4, 7, 4, Prop.BAO_SHI_RED, R.drawable.magic_tower_prop_bao_shi_red));
        row7.add(new CaseBean(4, 7, 5, Monster.SHOU_MIAN_REN, R.drawable.magic_tower_monster_shou_mian_ren));
        row7.add(new CaseBean(4, 7, 6, Prop.BAO_SHI_RED, R.drawable.magic_tower_prop_bao_shi_red));
        row7.add(new CaseBean(4, 7, 7, Building.WALL, R.drawable.magic_tower_building_wall));
        row7.add(new CaseBean(4, 7, 8, Building.ROAD, R.drawable.magic_tower_building_road));
        row7.add(new CaseBean(4, 7, 9, Building.WALL, R.drawable.magic_tower_building_wall));
        row7.add(new CaseBean(4, 7, 10, Building.ROAD, R.drawable.magic_tower_building_road));
        floor4.add(row7);

        List<CaseBean> row8 = new ArrayList<>();
        row8.add(new CaseBean(4, 8, 0, Building.ROAD, R.drawable.magic_tower_building_road));
        row8.add(new CaseBean(4, 8, 1, Building.WALL, R.drawable.magic_tower_building_wall));
        row8.add(new CaseBean(4, 8, 2, Building.ROAD, R.drawable.magic_tower_building_road));
        row8.add(new CaseBean(4, 8, 3, Building.WALL, R.drawable.magic_tower_building_wall));
        row8.add(new CaseBean(4, 8, 4, Building.WALL, R.drawable.magic_tower_building_wall));
        row8.add(new CaseBean(4, 8, 5, Npc.GATE_BLUE, R.drawable.magic_tower_npc_gate_blue_1));
        row8.add(new CaseBean(4, 8, 6, Building.WALL, R.drawable.magic_tower_building_wall));
        row8.add(new CaseBean(4, 8, 7, Building.WALL, R.drawable.magic_tower_building_wall));
        row8.add(new CaseBean(4, 8, 8, Building.ROAD, R.drawable.magic_tower_building_road));
        row8.add(new CaseBean(4, 8, 9, Building.WALL, R.drawable.magic_tower_building_wall));
        row8.add(new CaseBean(4, 8, 10, Building.ROAD, R.drawable.magic_tower_building_road));
        floor4.add(row8);

        List<CaseBean> row9 = new ArrayList<>();
        row9.add(new CaseBean(4, 9, 0, Building.ROAD, R.drawable.magic_tower_building_road));
        row9.add(new CaseBean(4, 9, 1, Building.WALL, R.drawable.magic_tower_building_wall));
        row9.add(new CaseBean(4, 9, 2, Building.ROAD, R.drawable.magic_tower_building_road));
        row9.add(new CaseBean(4, 9, 3, Building.WALL, R.drawable.magic_tower_building_wall));
        row9.add(new CaseBean(4, 9, 4, Prop.KEY_YELLOW, R.drawable.magic_tower_prop_key_yellow));
        row9.add(new CaseBean(4, 9, 5, Building.ROAD, R.drawable.magic_tower_building_road));
        row9.add(new CaseBean(4, 9, 6, Prop.KEY_YELLOW, R.drawable.magic_tower_prop_key_yellow));
        row9.add(new CaseBean(4, 9, 7, Building.WALL, R.drawable.magic_tower_building_wall));
        row9.add(new CaseBean(4, 9, 8, Building.ROAD, R.drawable.magic_tower_building_road));
        row9.add(new CaseBean(4, 9, 9, Building.WALL, R.drawable.magic_tower_building_wall));
        row9.add(new CaseBean(4, 9, 10, Building.ROAD, R.drawable.magic_tower_building_road));
        floor4.add(row9);

        List<CaseBean> row10 = new ArrayList<>();
        row10.add(new CaseBean(4, 10, 0, Npc.GO_UPSTAIRS, R.drawable.magic_tower_npc_go_upstairs));
        row10.add(new CaseBean(4, 10, 1, Building.WALL, R.drawable.magic_tower_building_wall));
        row10.add(new CaseBean(4, 10, 2, Building.ROAD, R.drawable.magic_tower_building_road));
        row10.add(new CaseBean(4, 10, 3, Monster.QING_TOU_GUAI, R.drawable.magic_tower_monster_qing_tou_guai));
        row10.add(new CaseBean(4, 10, 4, Building.ROAD, R.drawable.magic_tower_building_road));
        row10.add(new CaseBean(4, 10, 5, Building.ROAD, R.drawable.magic_tower_building_road));
        row10.add(new CaseBean(4, 10, 6, Building.ROAD, R.drawable.magic_tower_building_road));
        row10.add(new CaseBean(4, 10, 7, Monster.QING_TOU_GUAI, R.drawable.magic_tower_monster_qing_tou_guai));
        row10.add(new CaseBean(4, 10, 8, Building.ROAD, R.drawable.magic_tower_building_road));
        row10.add(new CaseBean(4, 10, 9, Building.WALL, R.drawable.magic_tower_building_wall));
        row10.add(new CaseBean(4, 10, 10, Npc.GO_DOWNSTAIRS, R.drawable.magic_tower_npc_go_downstairs));
        floor4.add(row10);

        return floor4;
    }

    @Override
    public void fromUpstairsToThisFloor() {
        resetWarriorPosition(9, 0);
    }

    @Override
    public void fromDownstairsToThisFloor() {
        resetWarriorPosition(9, 10);
    }
}
