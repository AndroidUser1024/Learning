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
 * Description:第 9 层
 * Created by 禽兽先生
 * Created on 2017/4/26
 */

public class Floor9 extends AbsFloor {

    @Override
    public int getFloor() {
        return 9;
    }

    @Override
    public List<List<CaseBean>> setData() {
        List<List<CaseBean>> floor9 = new ArrayList<>();
        List<CaseBean> row0 = new ArrayList<>();
        row0.add(new CaseBean(Prop.FENG_ZHI_LUO_PAN, R.drawable.magic_tower_prop_feng_zhi_luo_pan));
        row0.add(new CaseBean(Prop.KEY_YELLOW, R.drawable.magic_tower_prop_key_yellow));
        row0.add(new CaseBean(Building.ROAD, R.drawable.magic_tower_building_road));
        row0.add(new CaseBean(Building.WALL, R.drawable.magic_tower_building_wall));
        row0.add(new CaseBean(Building.WALL, R.drawable.magic_tower_building_wall));
        row0.add(new CaseBean(Building.WALL, R.drawable.magic_tower_building_wall));
        row0.add(new CaseBean(Building.ROAD, R.drawable.magic_tower_building_road));
        row0.add(new CaseBean(Building.ROAD, R.drawable.magic_tower_building_road));
        row0.add(new CaseBean(Building.ROAD, R.drawable.magic_tower_building_road));
        row0.add(new CaseBean(Building.WALL, R.drawable.magic_tower_building_wall));
        row0.add(new CaseBean(Building.ROAD, R.drawable.magic_tower_building_road));
        floor9.add(row0);

        List<CaseBean> row1 = new ArrayList<>();
        row1.add(new CaseBean(Prop.KEY_YELLOW, R.drawable.magic_tower_prop_key_yellow));
        row1.add(new CaseBean(Building.ROAD, R.drawable.magic_tower_building_road));
        row1.add(new CaseBean(Monster.SHOU_MIAN_WU_SHI, R.drawable.magic_tower_monster_shou_mian_wu_shi));
        row1.add(new CaseBean(Npc.GATE_YELLOW, R.drawable.magic_tower_npc_gate_yellow_1));
        row1.add(new CaseBean(Building.ROAD, R.drawable.magic_tower_building_road));
        row1.add(new CaseBean(Building.ROAD, R.drawable.magic_tower_building_road));
        row1.add(new CaseBean(Building.ROAD, R.drawable.magic_tower_building_road));
        row1.add(new CaseBean(Building.WALL, R.drawable.magic_tower_building_wall));
        row1.add(new CaseBean(Building.ROAD, R.drawable.magic_tower_building_road));
        row1.add(new CaseBean(Npc.GATE_YELLOW, R.drawable.magic_tower_npc_gate_yellow_1));
        row1.add(new CaseBean(Monster.KU_LOU_DUI_ZHANG, R.drawable.magic_tower_monster_ku_lou_dui_zhang));
        floor9.add(row1);

        List<CaseBean> row2 = new ArrayList<>();
        row2.add(new CaseBean(Building.WALL, R.drawable.magic_tower_building_wall));
        row2.add(new CaseBean(Npc.GATE_YELLOW, R.drawable.magic_tower_npc_gate_yellow_1));
        row2.add(new CaseBean(Building.WALL, R.drawable.magic_tower_building_wall));
        row2.add(new CaseBean(Building.WALL, R.drawable.magic_tower_building_wall));
        row2.add(new CaseBean(Building.ROAD, R.drawable.magic_tower_building_road));
        row2.add(new CaseBean(Building.WALL, R.drawable.magic_tower_building_wall));
        row2.add(new CaseBean(Building.WALL, R.drawable.magic_tower_building_wall));
        row2.add(new CaseBean(Building.WALL, R.drawable.magic_tower_building_wall));
        row2.add(new CaseBean(Building.ROAD, R.drawable.magic_tower_building_road));
        row2.add(new CaseBean(Building.WALL, R.drawable.magic_tower_building_wall));
        row2.add(new CaseBean(Prop.KEY_YELLOW, R.drawable.magic_tower_prop_key_yellow));
        floor9.add(row2);

        List<CaseBean> row3 = new ArrayList<>();
        row3.add(new CaseBean(Building.ROAD, R.drawable.magic_tower_building_road));
        row3.add(new CaseBean(Building.ROAD, R.drawable.magic_tower_building_road));
        row3.add(new CaseBean(Building.ROAD, R.drawable.magic_tower_building_road));
        row3.add(new CaseBean(Building.WALL, R.drawable.magic_tower_building_wall));
        row3.add(new CaseBean(Building.ROAD, R.drawable.magic_tower_building_road));
        row3.add(new CaseBean(Building.WALL, R.drawable.magic_tower_building_wall));
        row3.add(new CaseBean(Building.ROAD, R.drawable.magic_tower_building_road));
        row3.add(new CaseBean(Building.ROAD, R.drawable.magic_tower_building_road));
        row3.add(new CaseBean(Building.ROAD, R.drawable.magic_tower_building_road));
        row3.add(new CaseBean(Building.WALL, R.drawable.magic_tower_building_wall));
        row3.add(new CaseBean(Prop.KEY_YELLOW, R.drawable.magic_tower_prop_key_yellow));
        floor9.add(row3);

        List<CaseBean> row4 = new ArrayList<>();
        row4.add(new CaseBean(Building.ROAD, R.drawable.magic_tower_building_road));
        row4.add(new CaseBean(Building.ROAD, R.drawable.magic_tower_building_road));
        row4.add(new CaseBean(Building.ROAD, R.drawable.magic_tower_building_road));
        row4.add(new CaseBean(Npc.GATE_RED, R.drawable.magic_tower_npc_gate_red_1));
        row4.add(new CaseBean(Building.ROAD, R.drawable.magic_tower_building_road));
        row4.add(new CaseBean(Building.WALL, R.drawable.magic_tower_building_wall));
        row4.add(new CaseBean(Npc.GO_DOWNSTAIRS, R.drawable.magic_tower_npc_go_downstairs));
        row4.add(new CaseBean(Building.WALL, R.drawable.magic_tower_building_wall));
        row4.add(new CaseBean(Building.ROAD, R.drawable.magic_tower_building_road));
        row4.add(new CaseBean(Building.WALL, R.drawable.magic_tower_building_wall));
        row4.add(new CaseBean(Prop.XIE_PING_SMALL, R.drawable.magic_tower_prop_xie_ping_small));
        floor9.add(row4);

        List<CaseBean> row5 = new ArrayList<>();
        row5.add(new CaseBean(Building.WALL, R.drawable.magic_tower_building_wall));
        row5.add(new CaseBean(Npc.GATE_BLUE, R.drawable.magic_tower_npc_gate_blue_1));
        row5.add(new CaseBean(Building.WALL, R.drawable.magic_tower_building_wall));
        row5.add(new CaseBean(Building.WALL, R.drawable.magic_tower_building_wall));
        row5.add(new CaseBean(Building.ROAD, R.drawable.magic_tower_building_road));
        row5.add(new CaseBean(Building.WALL, R.drawable.magic_tower_building_wall));
        row5.add(new CaseBean(Building.WALL, R.drawable.magic_tower_building_wall));
        row5.add(new CaseBean(Building.WALL, R.drawable.magic_tower_building_wall));
        row5.add(new CaseBean(Building.ROAD, R.drawable.magic_tower_building_road));
        row5.add(new CaseBean(Building.WALL, R.drawable.magic_tower_building_wall));
        row5.add(new CaseBean(Building.WALL, R.drawable.magic_tower_building_wall));
        floor9.add(row5);

        List<CaseBean> row6 = new ArrayList<>();
        row6.add(new CaseBean(Prop.BAO_SHI_BLUE, R.drawable.magic_tower_prop_bao_shi_blue));
        row6.add(new CaseBean(Monster.HONG_YI_FA_SHI, R.drawable.magic_tower_monster_hong_yi_fa_shi));
        row6.add(new CaseBean(Prop.BAO_SHI_RED, R.drawable.magic_tower_prop_bao_shi_red));
        row6.add(new CaseBean(Building.WALL, R.drawable.magic_tower_building_wall));
        row6.add(new CaseBean(Monster.MA_YI_FA_SHI, R.drawable.magic_tower_monster_ma_yi_fa_shi));
        row6.add(new CaseBean(Building.WALL, R.drawable.magic_tower_building_wall));
        row6.add(new CaseBean(Npc.GO_UPSTAIRS, R.drawable.magic_tower_npc_go_upstairs));
        row6.add(new CaseBean(Building.WALL, R.drawable.magic_tower_building_wall));
        row6.add(new CaseBean(Building.ROAD, R.drawable.magic_tower_building_road));
        row6.add(new CaseBean(Building.WALL, R.drawable.magic_tower_building_wall));
        row6.add(new CaseBean(Prop.XIE_PING_SMALL, R.drawable.magic_tower_prop_xie_ping_small));
        floor9.add(row6);

        List<CaseBean> row7 = new ArrayList<>();
        row7.add(new CaseBean(Building.WALL, R.drawable.magic_tower_building_wall));
        row7.add(new CaseBean(Npc.GATE_YELLOW, R.drawable.magic_tower_npc_gate_yellow_1));
        row7.add(new CaseBean(Building.WALL, R.drawable.magic_tower_building_wall));
        row7.add(new CaseBean(Building.WALL, R.drawable.magic_tower_building_wall));
        row7.add(new CaseBean(Building.ROAD, R.drawable.magic_tower_building_road));
        row7.add(new CaseBean(Building.ROAD, R.drawable.magic_tower_building_road));
        row7.add(new CaseBean(Building.ROAD, R.drawable.magic_tower_building_road));
        row7.add(new CaseBean(Npc.GATE_YELLOW, R.drawable.magic_tower_npc_gate_yellow_1));
        row7.add(new CaseBean(Building.ROAD, R.drawable.magic_tower_building_road));
        row7.add(new CaseBean(Building.WALL, R.drawable.magic_tower_building_wall));
        row7.add(new CaseBean(Prop.KEY_YELLOW, R.drawable.magic_tower_prop_key_yellow));
        floor9.add(row7);

        List<CaseBean> row8 = new ArrayList<>();
        row8.add(new CaseBean(Monster.KU_LOU_DUI_ZHANG, R.drawable.magic_tower_monster_ku_lou_dui_zhang));
        row8.add(new CaseBean(Prop.XIE_PING_SMALL, R.drawable.magic_tower_prop_xie_ping_small));
        row8.add(new CaseBean(Monster.KU_LOU_DUI_ZHANG, R.drawable.magic_tower_monster_ku_lou_dui_zhang));
        row8.add(new CaseBean(Building.WALL, R.drawable.magic_tower_building_wall));
        row8.add(new CaseBean(Building.WALL, R.drawable.magic_tower_building_wall));
        row8.add(new CaseBean(Npc.GATE_BLUE, R.drawable.magic_tower_npc_gate_blue_1));
        row8.add(new CaseBean(Building.WALL, R.drawable.magic_tower_building_wall));
        row8.add(new CaseBean(Building.WALL, R.drawable.magic_tower_building_wall));
        row8.add(new CaseBean(Building.ROAD, R.drawable.magic_tower_building_road));
        row8.add(new CaseBean(Building.WALL, R.drawable.magic_tower_building_wall));
        row8.add(new CaseBean(Prop.KEY_YELLOW, R.drawable.magic_tower_prop_key_yellow));
        floor9.add(row8);

        List<CaseBean> row9 = new ArrayList<>();
        row9.add(new CaseBean(Prop.KEY_BLUE, R.drawable.magic_tower_prop_key_blue));
        row9.add(new CaseBean(Monster.KU_LOU_DUI_ZHANG, R.drawable.magic_tower_monster_ku_lou_dui_zhang));
        row9.add(new CaseBean(Prop.XIE_PING_SMALL, R.drawable.magic_tower_prop_xie_ping_small));
        row9.add(new CaseBean(Building.WALL, R.drawable.magic_tower_building_wall));
        row9.add(new CaseBean(Monster.SHI_TOU_GUAI_REN, R.drawable.magic_tower_monster_shi_tou_guai_ren));
        row9.add(new CaseBean(Monster.MA_YI_FA_SHI, R.drawable.magic_tower_monster_ma_yi_fa_shi));
        row9.add(new CaseBean(Monster.SHI_TOU_GUAI_REN, R.drawable.magic_tower_monster_shi_tou_guai_ren));
        row9.add(new CaseBean(Building.WALL, R.drawable.magic_tower_building_wall));
        row9.add(new CaseBean(Building.ROAD, R.drawable.magic_tower_building_road));
        row9.add(new CaseBean(Npc.GATE_YELLOW, R.drawable.magic_tower_npc_gate_yellow_1));
        row9.add(new CaseBean(Monster.KU_LOU_DUI_ZHANG, R.drawable.magic_tower_monster_ku_lou_dui_zhang));
        floor9.add(row9);

        List<CaseBean> row10 = new ArrayList<>();
        row10.add(new CaseBean(Prop.QING_FENG_JIAN, R.drawable.magic_tower_prop_qing_feng_jian));
        row10.add(new CaseBean(Prop.KEY_BLUE, R.drawable.magic_tower_prop_key_blue));
        row10.add(new CaseBean(Monster.KU_LOU_DUI_ZHANG, R.drawable.magic_tower_monster_ku_lou_dui_zhang));
        row10.add(new CaseBean(Npc.GATE_YELLOW, R.drawable.magic_tower_npc_gate_yellow_1));
        row10.add(new CaseBean(Prop.XIE_PING_BIG, R.drawable.magic_tower_prop_xie_ping_big));
        row10.add(new CaseBean(Monster.SHI_TOU_GUAI_REN, R.drawable.magic_tower_monster_shi_tou_guai_ren));
        row10.add(new CaseBean(Prop.XIE_PING_BIG, R.drawable.magic_tower_prop_xie_ping_big));
        row10.add(new CaseBean(Building.WALL, R.drawable.magic_tower_building_wall));
        row10.add(new CaseBean(Building.ROAD, R.drawable.magic_tower_building_road));
        row10.add(new CaseBean(Building.WALL, R.drawable.magic_tower_building_wall));
        row10.add(new CaseBean(Building.ROAD, R.drawable.magic_tower_building_road));
        floor9.add(row10);

        return floor9;
    }

    @Override
    public void fromUpstairsToThisFloor() {
        resetWarriorPosition(7, 6);
    }

    @Override
    public void fromDownstairsToThisFloor() {
        resetWarriorPosition(3, 6);
    }
}
