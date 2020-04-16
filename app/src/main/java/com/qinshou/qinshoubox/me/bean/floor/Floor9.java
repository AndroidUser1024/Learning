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

public class Floor9 extends AFloor {

    @Override
    public int getFloor() {
        return 9;
    }

    @Override
    public List<List<CaseBean>> setData() {
        List<List<CaseBean>> floor9 = new ArrayList<>();
        List<CaseBean> row0 = new ArrayList<>();
        row0.add(new CaseBean(9, 0, 0, Prop.FENG_ZHI_LUO_PAN, R.drawable.magic_tower_prop_feng_zhi_luo_pan));
        row0.add(new CaseBean(9, 0, 1, Prop.KEY_YELLOW, R.drawable.magic_tower_prop_key_yellow));
        row0.add(new CaseBean(9, 0, 2, Building.ROAD, R.drawable.magic_tower_building_road));
        row0.add(new CaseBean(9, 0, 3, Building.WALL, R.drawable.magic_tower_building_wall));
        row0.add(new CaseBean(9, 0, 4, Building.WALL, R.drawable.magic_tower_building_wall));
        row0.add(new CaseBean(9, 0, 5, Building.WALL, R.drawable.magic_tower_building_wall));
        row0.add(new CaseBean(9, 0, 6, Building.ROAD, R.drawable.magic_tower_building_road));
        row0.add(new CaseBean(9, 0, 7, Building.ROAD, R.drawable.magic_tower_building_road));
        row0.add(new CaseBean(9, 0, 8, Building.ROAD, R.drawable.magic_tower_building_road));
        row0.add(new CaseBean(9, 0, 9, Building.WALL, R.drawable.magic_tower_building_wall));
        row0.add(new CaseBean(9, 0, 10, Building.ROAD, R.drawable.magic_tower_building_road));
        floor9.add(row0);

        List<CaseBean> row1 = new ArrayList<>();
        row1.add(new CaseBean(9, 1, 0, Prop.KEY_YELLOW, R.drawable.magic_tower_prop_key_yellow));
        row1.add(new CaseBean(9, 1, 1, Building.ROAD, R.drawable.magic_tower_building_road));
        row1.add(new CaseBean(9, 1, 2, Monster.SHOU_MIAN_WU_SHI, R.drawable.magic_tower_monster_shou_mian_wu_shi));
        row1.add(new CaseBean(9, 1, 3, Npc.GATE_YELLOW, R.drawable.magic_tower_npc_gate_yellow_1));
        row1.add(new CaseBean(9, 1, 4, Building.ROAD, R.drawable.magic_tower_building_road));
        row1.add(new CaseBean(9, 1, 5, Building.ROAD, R.drawable.magic_tower_building_road));
        row1.add(new CaseBean(9, 1, 6, Building.ROAD, R.drawable.magic_tower_building_road));
        row1.add(new CaseBean(9, 1, 7, Building.WALL, R.drawable.magic_tower_building_wall));
        row1.add(new CaseBean(9, 1, 8, Building.ROAD, R.drawable.magic_tower_building_road));
        row1.add(new CaseBean(9, 1, 9, Npc.GATE_YELLOW, R.drawable.magic_tower_npc_gate_yellow_1));
        row1.add(new CaseBean(9, 1, 10, Monster.KU_LOU_DUI_ZHANG, R.drawable.magic_tower_monster_ku_lou_dui_zhang));
        floor9.add(row1);

        List<CaseBean> row2 = new ArrayList<>();
        row2.add(new CaseBean(9, 2, 0, Building.WALL, R.drawable.magic_tower_building_wall));
        row2.add(new CaseBean(9, 2, 1, Npc.GATE_YELLOW, R.drawable.magic_tower_npc_gate_yellow_1));
        row2.add(new CaseBean(9, 2, 2, Building.WALL, R.drawable.magic_tower_building_wall));
        row2.add(new CaseBean(9, 2, 3, Building.WALL, R.drawable.magic_tower_building_wall));
        row2.add(new CaseBean(9, 2, 4, Building.ROAD, R.drawable.magic_tower_building_road));
        row2.add(new CaseBean(9, 2, 5, Building.WALL, R.drawable.magic_tower_building_wall));
        row2.add(new CaseBean(9, 2, 6, Building.WALL, R.drawable.magic_tower_building_wall));
        row2.add(new CaseBean(9, 2, 7, Building.WALL, R.drawable.magic_tower_building_wall));
        row2.add(new CaseBean(9, 2, 8, Building.ROAD, R.drawable.magic_tower_building_road));
        row2.add(new CaseBean(9, 2, 9, Building.WALL, R.drawable.magic_tower_building_wall));
        row2.add(new CaseBean(9, 2, 10, Prop.KEY_YELLOW, R.drawable.magic_tower_prop_key_yellow));
        floor9.add(row2);

        List<CaseBean> row3 = new ArrayList<>();
        row3.add(new CaseBean(9, 3, 0, Building.ROAD, R.drawable.magic_tower_building_road));
        row3.add(new CaseBean(9, 3, 1, Building.ROAD, R.drawable.magic_tower_building_road));
        row3.add(new CaseBean(9, 3, 2, Building.ROAD, R.drawable.magic_tower_building_road));
        row3.add(new CaseBean(9, 3, 3, Building.WALL, R.drawable.magic_tower_building_wall));
        row3.add(new CaseBean(9, 3, 4, Building.ROAD, R.drawable.magic_tower_building_road));
        row3.add(new CaseBean(9, 3, 5, Building.WALL, R.drawable.magic_tower_building_wall));
        row3.add(new CaseBean(9, 3, 6, Building.ROAD, R.drawable.magic_tower_building_road));
        row3.add(new CaseBean(9, 3, 7, Building.ROAD, R.drawable.magic_tower_building_road));
        row3.add(new CaseBean(9, 3, 8, Building.ROAD, R.drawable.magic_tower_building_road));
        row3.add(new CaseBean(9, 3, 9, Building.WALL, R.drawable.magic_tower_building_wall));
        row3.add(new CaseBean(9, 3, 10, Prop.KEY_YELLOW, R.drawable.magic_tower_prop_key_yellow));
        floor9.add(row3);

        List<CaseBean> row4 = new ArrayList<>();
        row4.add(new CaseBean(9, 4, 0, Building.ROAD, R.drawable.magic_tower_building_road));
        row4.add(new CaseBean(9, 4, 1, Building.ROAD, R.drawable.magic_tower_building_road));
        row4.add(new CaseBean(9, 4, 2, Building.ROAD, R.drawable.magic_tower_building_road));
        row4.add(new CaseBean(9, 4, 3, Npc.GATE_RED, R.drawable.magic_tower_npc_gate_red_1));
        row4.add(new CaseBean(9, 4, 4, Building.ROAD, R.drawable.magic_tower_building_road));
        row4.add(new CaseBean(9, 4, 5, Building.WALL, R.drawable.magic_tower_building_wall));
        row4.add(new CaseBean(9, 4, 6, Npc.GO_DOWNSTAIRS, R.drawable.magic_tower_npc_go_downstairs));
        row4.add(new CaseBean(9, 4, 7, Building.WALL, R.drawable.magic_tower_building_wall));
        row4.add(new CaseBean(9, 4, 8, Building.ROAD, R.drawable.magic_tower_building_road));
        row4.add(new CaseBean(9, 4, 9, Building.WALL, R.drawable.magic_tower_building_wall));
        row4.add(new CaseBean(9, 4, 10, Prop.XIE_PING_SMALL, R.drawable.magic_tower_prop_xie_ping_small));
        floor9.add(row4);

        List<CaseBean> row5 = new ArrayList<>();
        row5.add(new CaseBean(9, 5, 0, Building.WALL, R.drawable.magic_tower_building_wall));
        row5.add(new CaseBean(9, 5, 1, Npc.GATE_BLUE, R.drawable.magic_tower_npc_gate_blue_1));
        row5.add(new CaseBean(9, 5, 2, Building.WALL, R.drawable.magic_tower_building_wall));
        row5.add(new CaseBean(9, 5, 3, Building.WALL, R.drawable.magic_tower_building_wall));
        row5.add(new CaseBean(9, 5, 4, Building.ROAD, R.drawable.magic_tower_building_road));
        row5.add(new CaseBean(9, 5, 5, Building.WALL, R.drawable.magic_tower_building_wall));
        row5.add(new CaseBean(9, 5, 6, Building.WALL, R.drawable.magic_tower_building_wall));
        row5.add(new CaseBean(9, 5, 7, Building.WALL, R.drawable.magic_tower_building_wall));
        row5.add(new CaseBean(9, 5, 8, Building.ROAD, R.drawable.magic_tower_building_road));
        row5.add(new CaseBean(9, 5, 9, Building.WALL, R.drawable.magic_tower_building_wall));
        row5.add(new CaseBean(9, 5, 10, Building.WALL, R.drawable.magic_tower_building_wall));
        floor9.add(row5);

        List<CaseBean> row6 = new ArrayList<>();
        row6.add(new CaseBean(9, 6, 0, Prop.BAO_SHI_BLUE, R.drawable.magic_tower_prop_bao_shi_blue));
        row6.add(new CaseBean(9, 6, 1, Monster.HONG_YI_FA_SHI, R.drawable.magic_tower_monster_hong_yi_fa_shi));
        row6.add(new CaseBean(9, 6, 2, Prop.BAO_SHI_RED, R.drawable.magic_tower_prop_bao_shi_red));
        row6.add(new CaseBean(9, 6, 3, Building.WALL, R.drawable.magic_tower_building_wall));
        row6.add(new CaseBean(9, 6, 4, Monster.MA_YI_FA_SHI, R.drawable.magic_tower_monster_ma_yi_fa_shi));
        row6.add(new CaseBean(9, 6, 5, Building.WALL, R.drawable.magic_tower_building_wall));
        row6.add(new CaseBean(9, 6, 6, Npc.GO_UPSTAIRS, R.drawable.magic_tower_npc_go_upstairs));
        row6.add(new CaseBean(9, 6, 7, Building.WALL, R.drawable.magic_tower_building_wall));
        row6.add(new CaseBean(9, 6, 8, Building.ROAD, R.drawable.magic_tower_building_road));
        row6.add(new CaseBean(9, 6, 9, Building.WALL, R.drawable.magic_tower_building_wall));
        row6.add(new CaseBean(9, 6, 10, Prop.XIE_PING_SMALL, R.drawable.magic_tower_prop_xie_ping_small));
        floor9.add(row6);

        List<CaseBean> row7 = new ArrayList<>();
        row7.add(new CaseBean(9, 7, 0, Building.WALL, R.drawable.magic_tower_building_wall));
        row7.add(new CaseBean(9, 7, 1, Npc.GATE_YELLOW, R.drawable.magic_tower_npc_gate_yellow_1));
        row7.add(new CaseBean(9, 7, 2, Building.WALL, R.drawable.magic_tower_building_wall));
        row7.add(new CaseBean(9, 7, 3, Building.WALL, R.drawable.magic_tower_building_wall));
        row7.add(new CaseBean(9, 7, 4, Building.ROAD, R.drawable.magic_tower_building_road));
        row7.add(new CaseBean(9, 7, 5, Building.ROAD, R.drawable.magic_tower_building_road));
        row7.add(new CaseBean(9, 7, 6, Building.ROAD, R.drawable.magic_tower_building_road));
        row7.add(new CaseBean(9, 7, 7, Npc.GATE_YELLOW, R.drawable.magic_tower_npc_gate_yellow_1));
        row7.add(new CaseBean(9, 7, 8, Building.ROAD, R.drawable.magic_tower_building_road));
        row7.add(new CaseBean(9, 7, 9, Building.WALL, R.drawable.magic_tower_building_wall));
        row7.add(new CaseBean(9, 7, 10, Prop.KEY_YELLOW, R.drawable.magic_tower_prop_key_yellow));
        floor9.add(row7);

        List<CaseBean> row8 = new ArrayList<>();
        row8.add(new CaseBean(9, 8, 0, Monster.KU_LOU_DUI_ZHANG, R.drawable.magic_tower_monster_ku_lou_dui_zhang));
        row8.add(new CaseBean(9, 8, 1, Prop.XIE_PING_SMALL, R.drawable.magic_tower_prop_xie_ping_small));
        row8.add(new CaseBean(9, 8, 2, Monster.KU_LOU_DUI_ZHANG, R.drawable.magic_tower_monster_ku_lou_dui_zhang));
        row8.add(new CaseBean(9, 8, 3, Building.WALL, R.drawable.magic_tower_building_wall));
        row8.add(new CaseBean(9, 8, 4, Building.WALL, R.drawable.magic_tower_building_wall));
        row8.add(new CaseBean(9, 8, 5, Npc.GATE_BLUE, R.drawable.magic_tower_npc_gate_blue_1));
        row8.add(new CaseBean(9, 8, 6, Building.WALL, R.drawable.magic_tower_building_wall));
        row8.add(new CaseBean(9, 8, 7, Building.WALL, R.drawable.magic_tower_building_wall));
        row8.add(new CaseBean(9, 8, 8, Building.ROAD, R.drawable.magic_tower_building_road));
        row8.add(new CaseBean(9, 8, 9, Building.WALL, R.drawable.magic_tower_building_wall));
        row8.add(new CaseBean(9, 8, 10, Prop.KEY_YELLOW, R.drawable.magic_tower_prop_key_yellow));
        floor9.add(row8);

        List<CaseBean> row9 = new ArrayList<>();
        row9.add(new CaseBean(9, 9, 0, Prop.KEY_BLUE, R.drawable.magic_tower_prop_key_blue));
        row9.add(new CaseBean(9, 9, 1, Monster.KU_LOU_DUI_ZHANG, R.drawable.magic_tower_monster_ku_lou_dui_zhang));
        row9.add(new CaseBean(9, 9, 2, Prop.XIE_PING_SMALL, R.drawable.magic_tower_prop_xie_ping_small));
        row9.add(new CaseBean(9, 9, 3, Building.WALL, R.drawable.magic_tower_building_wall));
        row9.add(new CaseBean(9, 9, 4, Monster.SHI_TOU_GUAI_REN, R.drawable.magic_tower_monster_shi_tou_guai_ren));
        row9.add(new CaseBean(9, 9, 5, Monster.MA_YI_FA_SHI, R.drawable.magic_tower_monster_ma_yi_fa_shi));
        row9.add(new CaseBean(9, 9, 6, Monster.SHI_TOU_GUAI_REN, R.drawable.magic_tower_monster_shi_tou_guai_ren));
        row9.add(new CaseBean(9, 9, 7, Building.WALL, R.drawable.magic_tower_building_wall));
        row9.add(new CaseBean(9, 9, 8, Building.ROAD, R.drawable.magic_tower_building_road));
        row9.add(new CaseBean(9, 9, 9, Npc.GATE_YELLOW, R.drawable.magic_tower_npc_gate_yellow_1));
        row9.add(new CaseBean(9, 9, 10, Monster.KU_LOU_DUI_ZHANG, R.drawable.magic_tower_monster_ku_lou_dui_zhang));
        floor9.add(row9);

        List<CaseBean> row10 = new ArrayList<>();
        row10.add(new CaseBean(9, 10, 0, Prop.QING_FENG_JIAN, R.drawable.magic_tower_prop_qing_feng_jian));
        row10.add(new CaseBean(9, 10, 1, Prop.KEY_BLUE, R.drawable.magic_tower_prop_key_blue));
        row10.add(new CaseBean(9, 10, 2, Monster.KU_LOU_DUI_ZHANG, R.drawable.magic_tower_monster_ku_lou_dui_zhang));
        row10.add(new CaseBean(9, 10, 3, Npc.GATE_YELLOW, R.drawable.magic_tower_npc_gate_yellow_1));
        row10.add(new CaseBean(9, 10, 4, Prop.XIE_PING_BIG, R.drawable.magic_tower_prop_xie_ping_big));
        row10.add(new CaseBean(9, 10, 5, Monster.SHI_TOU_GUAI_REN, R.drawable.magic_tower_monster_shi_tou_guai_ren));
        row10.add(new CaseBean(9, 10, 6, Prop.XIE_PING_BIG, R.drawable.magic_tower_prop_xie_ping_big));
        row10.add(new CaseBean(9, 10, 7, Building.WALL, R.drawable.magic_tower_building_wall));
        row10.add(new CaseBean(9, 10, 8, Building.ROAD, R.drawable.magic_tower_building_road));
        row10.add(new CaseBean(9, 10, 9, Building.WALL, R.drawable.magic_tower_building_wall));
        row10.add(new CaseBean(9, 10, 10, Building.ROAD, R.drawable.magic_tower_building_road));
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
