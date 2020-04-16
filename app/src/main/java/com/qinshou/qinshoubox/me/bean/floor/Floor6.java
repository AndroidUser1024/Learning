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
 * Description:第 6 层
 * Created by 禽兽先生
 * Created on 2017/4/26
 */

public class Floor6 extends AFloor {

    @Override
    public int getFloor() {
        return 6;
    }

    @Override
    public List<List<CaseBean>> setData() {
        List<List<CaseBean>> floor6 = new ArrayList<>();
        List<CaseBean> row0 = new ArrayList<>();
        row0.add(new CaseBean(6, 0, 0, Prop.XIAO_FEI_YU, R.drawable.magic_tower_prop_xiao_fei_yu));
        row0.add(new CaseBean(6, 0, 1, Monster.KU_LOU_DUI_ZHANG, R.drawable.magic_tower_monster_ku_lou_dui_zhang));
        row0.add(new CaseBean(6, 0, 2, Building.WALL, R.drawable.magic_tower_building_wall));
        row0.add(new CaseBean(6, 0, 3, Prop.BAO_SHI_BLUE, R.drawable.magic_tower_prop_bao_shi_blue));
        row0.add(new CaseBean(6, 0, 4, Building.WALL, R.drawable.magic_tower_building_wall));
        row0.add(new CaseBean(6, 0, 5, Prop.KEY_YELLOW, R.drawable.magic_tower_prop_key_yellow));
        row0.add(new CaseBean(6, 0, 6, Monster.GUAI_WANG, R.drawable.magic_tower_monster_guai_wang));
        row0.add(new CaseBean(6, 0, 7, Prop.JIN_KUAI, R.drawable.magic_tower_prop_jin_kuai));
        row0.add(new CaseBean(6, 0, 8, Building.WALL, R.drawable.magic_tower_building_wall));
        row0.add(new CaseBean(6, 0, 9, Prop.XIE_PING_BIG, R.drawable.magic_tower_prop_xie_ping_big));
        row0.add(new CaseBean(6, 0, 10, Prop.XIE_PING_BIG, R.drawable.magic_tower_prop_xie_ping_big));
        floor6.add(row0);

        List<CaseBean> row1 = new ArrayList<>();
        row1.add(new CaseBean(6, 1, 0, Monster.KU_LOU_DUI_ZHANG, R.drawable.magic_tower_monster_ku_lou_dui_zhang));
        row1.add(new CaseBean(6, 1, 1, Prop.KEY_YELLOW, R.drawable.magic_tower_prop_key_yellow));
        row1.add(new CaseBean(6, 1, 2, Building.WALL, R.drawable.magic_tower_building_wall));
        row1.add(new CaseBean(6, 1, 3, Prop.BAO_SHI_RED, R.drawable.magic_tower_prop_bao_shi_red));
        row1.add(new CaseBean(6, 1, 4, Building.WALL, R.drawable.magic_tower_building_wall));
        row1.add(new CaseBean(6, 1, 5, Building.ROAD, R.drawable.magic_tower_building_road));
        row1.add(new CaseBean(6, 1, 6, Prop.KEY_YELLOW, R.drawable.magic_tower_prop_key_yellow));
        row1.add(new CaseBean(6, 1, 7, Monster.GUAI_WANG, R.drawable.magic_tower_monster_guai_wang));
        row1.add(new CaseBean(6, 1, 8, Building.WALL, R.drawable.magic_tower_building_wall));
        row1.add(new CaseBean(6, 1, 9, Monster.SHI_TOU_GUAI_REN, R.drawable.magic_tower_monster_shi_tou_guai_ren));
        row1.add(new CaseBean(6, 1, 10, Prop.XIE_PING_BIG, R.drawable.magic_tower_prop_xie_ping_big));
        floor6.add(row1);

        List<CaseBean> row2 = new ArrayList<>();
        row2.add(new CaseBean(6, 2, 0, Prop.KEY_YELLOW, R.drawable.magic_tower_prop_key_yellow));
        row2.add(new CaseBean(6, 2, 1, Monster.HONG_BIAN_FU, R.drawable.magic_tower_monster_hong_bian_fu));
        row2.add(new CaseBean(6, 2, 2, Npc.GATE_BLUE, R.drawable.magic_tower_npc_gate_blue_1));
        row2.add(new CaseBean(6, 2, 3, Building.ROAD, R.drawable.magic_tower_building_road));
        row2.add(new CaseBean(6, 2, 4, Npc.GATE_BLUE, R.drawable.magic_tower_npc_gate_blue_1));
        row2.add(new CaseBean(6, 2, 5, Monster.HONG_BIAN_FU, R.drawable.magic_tower_monster_hong_bian_fu));
        row2.add(new CaseBean(6, 2, 6, Building.ROAD, R.drawable.magic_tower_building_road));
        row2.add(new CaseBean(6, 2, 7, Prop.KEY_YELLOW, R.drawable.magic_tower_prop_key_yellow));
        row2.add(new CaseBean(6, 2, 8, Building.WALL, R.drawable.magic_tower_building_wall));
        row2.add(new CaseBean(6, 2, 9, Building.ROAD, R.drawable.magic_tower_building_road));
        row2.add(new CaseBean(6, 2, 10, Monster.SHI_TOU_GUAI_REN, R.drawable.magic_tower_monster_shi_tou_guai_ren));
        floor6.add(row2);

        List<CaseBean> row3 = new ArrayList<>();
        row3.add(new CaseBean(6, 3, 0, Building.ROAD, R.drawable.magic_tower_building_road));
        row3.add(new CaseBean(6, 3, 1, Building.ROAD, R.drawable.magic_tower_building_road));
        row3.add(new CaseBean(6, 3, 2, Building.WALL, R.drawable.magic_tower_building_wall));
        row3.add(new CaseBean(6, 3, 3, Monster.CHU_JI_WEI_BING, R.drawable.magic_tower_monster_chu_ji_wei_bing));
        row3.add(new CaseBean(6, 3, 4, Building.WALL, R.drawable.magic_tower_building_wall));
        row3.add(new CaseBean(6, 3, 5, Building.ROAD, R.drawable.magic_tower_building_road));
        row3.add(new CaseBean(6, 3, 6, Building.ROAD, R.drawable.magic_tower_building_road));
        row3.add(new CaseBean(6, 3, 7, Building.ROAD, R.drawable.magic_tower_building_road));
        row3.add(new CaseBean(6, 3, 8, Building.WALL, R.drawable.magic_tower_building_wall));
        row3.add(new CaseBean(6, 3, 9, Monster.HONG_YI_FA_SHI, R.drawable.magic_tower_monster_hong_yi_fa_shi));
        row3.add(new CaseBean(6, 3, 10, Building.ROAD, R.drawable.magic_tower_building_road));
        floor6.add(row3);

        List<CaseBean> row4 = new ArrayList<>();
        row4.add(new CaseBean(6, 4, 0, Building.WALL, R.drawable.magic_tower_building_wall));
        row4.add(new CaseBean(6, 4, 1, Building.WALL, R.drawable.magic_tower_building_wall));
        row4.add(new CaseBean(6, 4, 2, Building.WALL, R.drawable.magic_tower_building_wall));
        row4.add(new CaseBean(6, 4, 3, Npc.GATE_RED, R.drawable.magic_tower_npc_gate_red_1));
        row4.add(new CaseBean(6, 4, 4, Building.WALL, R.drawable.magic_tower_building_wall));
        row4.add(new CaseBean(6, 4, 5, Building.WALL, R.drawable.magic_tower_building_wall));
        row4.add(new CaseBean(6, 4, 6, Building.WALL, R.drawable.magic_tower_building_wall));
        row4.add(new CaseBean(6, 4, 7, Building.WALL, R.drawable.magic_tower_building_wall));
        row4.add(new CaseBean(6, 4, 8, Building.WALL, R.drawable.magic_tower_building_wall));
        row4.add(new CaseBean(6, 4, 9, Npc.GATE_YELLOW, R.drawable.magic_tower_npc_gate_yellow_1));
        row4.add(new CaseBean(6, 4, 10, Building.WALL, R.drawable.magic_tower_building_wall));
        floor6.add(row4);

        List<CaseBean> row5 = new ArrayList<>();
        row5.add(new CaseBean(6, 5, 0, Building.ROAD, R.drawable.magic_tower_building_road));
        row5.add(new CaseBean(6, 5, 1, Building.ROAD, R.drawable.magic_tower_building_road));
        row5.add(new CaseBean(6, 5, 2, Monster.GAO_JI_FA_SHI, R.drawable.magic_tower_monster_gao_ji_fa_shi));
        row5.add(new CaseBean(6, 5, 3, Building.ROAD, R.drawable.magic_tower_building_road));
        row5.add(new CaseBean(6, 5, 4, Prop.KEY_YELLOW, R.drawable.magic_tower_prop_key_yellow));
        row5.add(new CaseBean(6, 5, 5, Prop.KEY_YELLOW, R.drawable.magic_tower_prop_key_yellow));
        row5.add(new CaseBean(6, 5, 6, Prop.KEY_YELLOW, R.drawable.magic_tower_prop_key_yellow));
        row5.add(new CaseBean(6, 5, 7, Building.ROAD, R.drawable.magic_tower_building_road));
        row5.add(new CaseBean(6, 5, 8, Monster.GAO_JI_FA_SHI, R.drawable.magic_tower_monster_gao_ji_fa_shi));
        row5.add(new CaseBean(6, 5, 9, Building.ROAD, R.drawable.magic_tower_building_road));
        row5.add(new CaseBean(6, 5, 10, Building.ROAD, R.drawable.magic_tower_building_road));
        floor6.add(row5);

        List<CaseBean> row6 = new ArrayList<>();
        row6.add(new CaseBean(6, 6, 0, Building.ROAD, R.drawable.magic_tower_building_road));
        row6.add(new CaseBean(6, 6, 1, Building.WALL, R.drawable.magic_tower_building_wall));
        row6.add(new CaseBean(6, 6, 2, Building.WALL, R.drawable.magic_tower_building_wall));
        row6.add(new CaseBean(6, 6, 3, Building.WALL, R.drawable.magic_tower_building_wall));
        row6.add(new CaseBean(6, 6, 4, Building.WALL, R.drawable.magic_tower_building_wall));
        row6.add(new CaseBean(6, 6, 5, Building.WALL, R.drawable.magic_tower_building_wall));
        row6.add(new CaseBean(6, 6, 6, Building.WALL, R.drawable.magic_tower_building_wall));
        row6.add(new CaseBean(6, 6, 7, Building.WALL, R.drawable.magic_tower_building_wall));
        row6.add(new CaseBean(6, 6, 8, Building.WALL, R.drawable.magic_tower_building_wall));
        row6.add(new CaseBean(6, 6, 9, Building.WALL, R.drawable.magic_tower_building_wall));
        row6.add(new CaseBean(6, 6, 10, Building.WALL, R.drawable.magic_tower_building_wall));
        floor6.add(row6);

        List<CaseBean> row7 = new ArrayList<>();
        row7.add(new CaseBean(6, 7, 0, Building.ROAD, R.drawable.magic_tower_building_road));
        row7.add(new CaseBean(6, 7, 1, Building.WALL, R.drawable.magic_tower_building_wall));
        row7.add(new CaseBean(6, 7, 2, Monster.DA_BIAN_FU, R.drawable.magic_tower_monster_da_bian_fu));
        row7.add(new CaseBean(6, 7, 3, Npc.GATE_YELLOW, R.drawable.magic_tower_npc_gate_yellow_1));
        row7.add(new CaseBean(6, 7, 4, Monster.DA_BIAN_FU, R.drawable.magic_tower_monster_da_bian_fu));
        row7.add(new CaseBean(6, 7, 5, Building.ROAD, R.drawable.magic_tower_building_road));
        row7.add(new CaseBean(6, 7, 6, Building.ROAD, R.drawable.magic_tower_building_road));
        row7.add(new CaseBean(6, 7, 7, Building.ROAD, R.drawable.magic_tower_building_road));
        row7.add(new CaseBean(6, 7, 8, Building.ROAD, R.drawable.magic_tower_building_road));
        row7.add(new CaseBean(6, 7, 9, Building.ROAD, R.drawable.magic_tower_building_road));
        row7.add(new CaseBean(6, 7, 10, Building.WALL, R.drawable.magic_tower_building_wall));
        floor6.add(row7);

        List<CaseBean> row8 = new ArrayList<>();
        row8.add(new CaseBean(6, 8, 0, Building.ROAD, R.drawable.magic_tower_building_road));
        row8.add(new CaseBean(6, 8, 1, Building.WALL, R.drawable.magic_tower_building_wall));
        row8.add(new CaseBean(6, 8, 2, Npc.GATE_YELLOW, R.drawable.magic_tower_npc_gate_yellow_1));
        row8.add(new CaseBean(6, 8, 3, Building.WALL, R.drawable.magic_tower_building_wall));
        row8.add(new CaseBean(6, 8, 4, Npc.GATE_YELLOW, R.drawable.magic_tower_npc_gate_yellow_1));
        row8.add(new CaseBean(6, 8, 5, Building.WALL, R.drawable.magic_tower_building_wall));
        row8.add(new CaseBean(6, 8, 6, Building.WALL, R.drawable.magic_tower_building_wall));
        row8.add(new CaseBean(6, 8, 7, Building.WALL, R.drawable.magic_tower_building_wall));
        row8.add(new CaseBean(6, 8, 8, Building.WALL, R.drawable.magic_tower_building_wall));
        row8.add(new CaseBean(6, 8, 9, Npc.GATE_BLUE, R.drawable.magic_tower_npc_gate_blue_1));
        row8.add(new CaseBean(6, 8, 10, Building.WALL, R.drawable.magic_tower_building_wall));
        floor6.add(row8);

        List<CaseBean> row9 = new ArrayList<>();
        row9.add(new CaseBean(6, 9, 0, Building.ROAD, R.drawable.magic_tower_building_road));
        row9.add(new CaseBean(6, 9, 1, Building.WALL, R.drawable.magic_tower_building_wall));
        row9.add(new CaseBean(6, 9, 2, Monster.DA_BIAN_FU, R.drawable.magic_tower_monster_da_bian_fu));
        row9.add(new CaseBean(6, 9, 3, Building.WALL, R.drawable.magic_tower_building_wall));
        row9.add(new CaseBean(6, 9, 4, Building.ROAD, R.drawable.magic_tower_building_road));
        row9.add(new CaseBean(6, 9, 5, Building.ROAD, R.drawable.magic_tower_building_road));
        row9.add(new CaseBean(6, 9, 6, Building.WALL, R.drawable.magic_tower_building_wall));
        row9.add(new CaseBean(6, 9, 7, Building.WALL, R.drawable.magic_tower_building_wall));
        row9.add(new CaseBean(6, 9, 8, Building.ROAD, R.drawable.magic_tower_building_road));
        row9.add(new CaseBean(6, 9, 9, Building.ROAD, R.drawable.magic_tower_building_road));
        row9.add(new CaseBean(6, 9, 10, Building.WALL, R.drawable.magic_tower_building_wall));
        floor6.add(row9);

        List<CaseBean> row10 = new ArrayList<>();
        row10.add(new CaseBean(6, 10, 0, Building.ROAD, R.drawable.magic_tower_building_road));
        row10.add(new CaseBean(6, 10, 1, Building.ROAD, R.drawable.magic_tower_building_road));
        row10.add(new CaseBean(6, 10, 2, Building.ROAD, R.drawable.magic_tower_building_road));
        row10.add(new CaseBean(6, 10, 3, Building.WALL, R.drawable.magic_tower_building_wall));
        row10.add(new CaseBean(6, 10, 4, Npc.GO_UPSTAIRS, R.drawable.magic_tower_npc_go_upstairs));
        row10.add(new CaseBean(6, 10, 5, Building.ROAD, R.drawable.magic_tower_building_road));
        row10.add(new CaseBean(6, 10, 6, Npc.GATE_YELLOW, R.drawable.magic_tower_npc_gate_yellow_1));
        row10.add(new CaseBean(6, 10, 7, Npc.GATE_YELLOW, R.drawable.magic_tower_npc_gate_yellow_1));
        row10.add(new CaseBean(6, 10, 8, Building.ROAD, R.drawable.magic_tower_building_road));
        row10.add(new CaseBean(6, 10, 9, Npc.GO_DOWNSTAIRS, R.drawable.magic_tower_npc_go_downstairs));
        row10.add(new CaseBean(6, 10, 10, Building.WALL, R.drawable.magic_tower_building_wall));
        floor6.add(row10);

        return floor6;
    }

    @Override
    public void fromUpstairsToThisFloor() {
        resetWarriorPosition(10, 5);
    }

    @Override
    public void fromDownstairsToThisFloor() {
        resetWarriorPosition(9, 9);
    }
}
