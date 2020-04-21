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
 * Description:第 7 层
 * Created by 禽兽先生
 * Created on 2017/4/26
 */

public class Floor7 extends AbsFloor {

    @Override
    public int getFloor() {
        return 7;
    }

    @Override
    public List<List<CaseBean>> setData() {
        List<List<CaseBean>> floor7 = new ArrayList<>();
        List<CaseBean> row0 = new ArrayList<>();
        row0.add(new CaseBean(7, 0, 0, Npc.GO_UPSTAIRS, R.drawable.magic_tower_npc_go_upstairs));
        row0.add(new CaseBean(7, 0, 1, Building.ROAD, R.drawable.magic_tower_building_road));
        row0.add(new CaseBean(7, 0, 2, Building.ROAD, R.drawable.magic_tower_building_road));
        row0.add(new CaseBean(7, 0, 3, Building.ROAD, R.drawable.magic_tower_building_road));
        row0.add(new CaseBean(7, 0, 4, Building.ROAD, R.drawable.magic_tower_building_road));
        row0.add(new CaseBean(7, 0, 5, Building.ROAD, R.drawable.magic_tower_building_road));
        row0.add(new CaseBean(7, 0, 6, Building.ROAD, R.drawable.magic_tower_building_road));
        row0.add(new CaseBean(7, 0, 7, Building.ROAD, R.drawable.magic_tower_building_road));
        row0.add(new CaseBean(7, 0, 8, Building.WALL, R.drawable.magic_tower_building_wall));
        row0.add(new CaseBean(7, 0, 9, Building.WALL, R.drawable.magic_tower_building_wall));
        row0.add(new CaseBean(7, 0, 10, Building.WALL, R.drawable.magic_tower_building_wall));
        floor7.add(row0);

        List<CaseBean> row1 = new ArrayList<>();
        row1.add(new CaseBean(7, 1, 0, Building.WALL, R.drawable.magic_tower_building_wall));
        row1.add(new CaseBean(7, 1, 1, Building.WALL, R.drawable.magic_tower_building_wall));
        row1.add(new CaseBean(7, 1, 2, Building.ROAD, R.drawable.magic_tower_building_road));
        row1.add(new CaseBean(7, 1, 3, Monster.HONG_BIAN_FU, R.drawable.magic_tower_monster_hong_bian_fu));
        row1.add(new CaseBean(7, 1, 4, Building.WALL, R.drawable.magic_tower_building_wall));
        row1.add(new CaseBean(7, 1, 5, Npc.GATE_BLUE, R.drawable.magic_tower_npc_gate_blue_1));
        row1.add(new CaseBean(7, 1, 6, Building.WALL, R.drawable.magic_tower_building_wall));
        row1.add(new CaseBean(7, 1, 7, Monster.KU_LOU_DUI_ZHANG, R.drawable.magic_tower_monster_ku_lou_dui_zhang));
        row1.add(new CaseBean(7, 1, 8, Building.ROAD, R.drawable.magic_tower_building_road));
        row1.add(new CaseBean(7, 1, 9, Building.WALL, R.drawable.magic_tower_building_wall));
        row1.add(new CaseBean(7, 1, 10, Building.WALL, R.drawable.magic_tower_building_wall));
        floor7.add(row1);

        List<CaseBean> row2 = new ArrayList<>();
        row2.add(new CaseBean(7, 2, 0, Building.WALL, R.drawable.magic_tower_building_wall));
        row2.add(new CaseBean(7, 2, 1, Building.ROAD, R.drawable.magic_tower_building_road));
        row2.add(new CaseBean(7, 2, 2, Monster.HONG_BIAN_FU, R.drawable.magic_tower_monster_hong_bian_fu));
        row2.add(new CaseBean(7, 2, 3, Prop.BAO_SHI_BLUE, R.drawable.magic_tower_prop_bao_shi_blue));
        row2.add(new CaseBean(7, 2, 4, Building.WALL, R.drawable.magic_tower_building_wall));
        row2.add(new CaseBean(7, 2, 5, Monster.BAI_YI_WU_SHI, R.drawable.magic_tower_monster_bai_yi_wu_shi));
        row2.add(new CaseBean(7, 2, 6, Building.WALL, R.drawable.magic_tower_building_wall));
        row2.add(new CaseBean(7, 2, 7, Prop.BAO_SHI_RED, R.drawable.magic_tower_prop_bao_shi_red));
        row2.add(new CaseBean(7, 2, 8, Monster.KU_LOU_DUI_ZHANG, R.drawable.magic_tower_monster_ku_lou_dui_zhang));
        row2.add(new CaseBean(7, 2, 9, Building.ROAD, R.drawable.magic_tower_building_road));
        row2.add(new CaseBean(7, 2, 10, Building.WALL, R.drawable.magic_tower_building_wall));
        floor7.add(row2);

        List<CaseBean> row3 = new ArrayList<>();
        row3.add(new CaseBean(7, 3, 0, Building.ROAD, R.drawable.magic_tower_building_road));
        row3.add(new CaseBean(7, 3, 1, Building.ROAD, R.drawable.magic_tower_building_road));
        row3.add(new CaseBean(7, 3, 2, Building.WALL, R.drawable.magic_tower_building_wall));
        row3.add(new CaseBean(7, 3, 3, Building.WALL, R.drawable.magic_tower_building_wall));
        row3.add(new CaseBean(7, 3, 4, Building.WALL, R.drawable.magic_tower_building_wall));
        row3.add(new CaseBean(7, 3, 5, Npc.GATE_IRON_CLOSE, R.drawable.magic_tower_npc_gate_iron_1));
        row3.add(new CaseBean(7, 3, 6, Building.WALL, R.drawable.magic_tower_building_wall));
        row3.add(new CaseBean(7, 3, 7, Building.WALL, R.drawable.magic_tower_building_wall));
        row3.add(new CaseBean(7, 3, 8, Building.WALL, R.drawable.magic_tower_building_wall));
        row3.add(new CaseBean(7, 3, 9, Building.ROAD, R.drawable.magic_tower_building_road));
        row3.add(new CaseBean(7, 3, 10, Building.ROAD, R.drawable.magic_tower_building_road));
        floor7.add(row3);

        List<CaseBean> row4 = new ArrayList<>();
        row4.add(new CaseBean(7, 4, 0, Building.ROAD, R.drawable.magic_tower_building_road));
        row4.add(new CaseBean(7, 4, 1, Building.ROAD, R.drawable.magic_tower_building_road));
        row4.add(new CaseBean(7, 4, 2, Npc.GATE_BLUE, R.drawable.magic_tower_npc_gate_blue_1));
        row4.add(new CaseBean(7, 4, 3, Monster.BAI_YI_WU_SHI, R.drawable.magic_tower_monster_bai_yi_wu_shi));
        row4.add(new CaseBean(7, 4, 4, Npc.GATE_IRON_OPEN, R.drawable.magic_tower_npc_gate_iron_1));
        row4.add(new CaseBean(7, 4, 5, Prop.XING_YUN_SHI_ZI_JIA, R.drawable.magic_tower_prop_xing_yun_shi_zi_jia));
        row4.add(new CaseBean(7, 4, 6, Npc.GATE_IRON_CLOSE, R.drawable.magic_tower_npc_gate_iron_1));
        row4.add(new CaseBean(7, 4, 7, Monster.BAI_YI_WU_SHI, R.drawable.magic_tower_monster_bai_yi_wu_shi));
        row4.add(new CaseBean(7, 4, 8, Npc.GATE_BLUE, R.drawable.magic_tower_npc_gate_blue_1));
        row4.add(new CaseBean(7, 4, 9, Building.ROAD, R.drawable.magic_tower_building_road));
        row4.add(new CaseBean(7, 4, 10, Building.ROAD, R.drawable.magic_tower_building_road));
        floor7.add(row4);

        List<CaseBean> row5 = new ArrayList<>();
        row5.add(new CaseBean(7, 5, 0, Building.ROAD, R.drawable.magic_tower_building_road));
        row5.add(new CaseBean(7, 5, 1, Building.WALL, R.drawable.magic_tower_building_wall));
        row5.add(new CaseBean(7, 5, 2, Building.WALL, R.drawable.magic_tower_building_wall));
        row5.add(new CaseBean(7, 5, 3, Building.WALL, R.drawable.magic_tower_building_wall));
        row5.add(new CaseBean(7, 5, 4, Building.WALL, R.drawable.magic_tower_building_wall));
        row5.add(new CaseBean(7, 5, 5, Npc.GATE_IRON_CLOSE, R.drawable.magic_tower_npc_gate_iron_1));
        row5.add(new CaseBean(7, 5, 6, Building.WALL, R.drawable.magic_tower_building_wall));
        row5.add(new CaseBean(7, 5, 7, Building.WALL, R.drawable.magic_tower_building_wall));
        row5.add(new CaseBean(7, 5, 8, Building.WALL, R.drawable.magic_tower_building_wall));
        row5.add(new CaseBean(7, 5, 9, Building.WALL, R.drawable.magic_tower_building_wall));
        row5.add(new CaseBean(7, 5, 10, Building.ROAD, R.drawable.magic_tower_building_road));
        floor7.add(row5);

        List<CaseBean> row6 = new ArrayList<>();
        row6.add(new CaseBean(7, 6, 0, Building.ROAD, R.drawable.magic_tower_building_road));
        row6.add(new CaseBean(7, 6, 1, Building.WALL, R.drawable.magic_tower_building_wall));
        row6.add(new CaseBean(7, 6, 2, Prop.XIE_PING_SMALL, R.drawable.magic_tower_prop_xie_ping_small));
        row6.add(new CaseBean(7, 6, 3, Prop.BAO_SHI_RED, R.drawable.magic_tower_prop_bao_shi_red));
        row6.add(new CaseBean(7, 6, 4, Building.WALL, R.drawable.magic_tower_building_wall));
        row6.add(new CaseBean(7, 6, 5, Monster.BAI_YI_WU_SHI, R.drawable.magic_tower_monster_bai_yi_wu_shi));
        row6.add(new CaseBean(7, 6, 6, Building.WALL, R.drawable.magic_tower_building_wall));
        row6.add(new CaseBean(7, 6, 7, Prop.BAO_SHI_BLUE, R.drawable.magic_tower_prop_bao_shi_blue));
        row6.add(new CaseBean(7, 6, 8, Prop.XIE_PING_SMALL, R.drawable.magic_tower_prop_xie_ping_small));
        row6.add(new CaseBean(7, 6, 9, Building.WALL, R.drawable.magic_tower_building_wall));
        row6.add(new CaseBean(7, 6, 10, Building.ROAD, R.drawable.magic_tower_building_road));
        floor7.add(row6);

        List<CaseBean> row7 = new ArrayList<>();
        row7.add(new CaseBean(7, 7, 0, Building.ROAD, R.drawable.magic_tower_building_road));
        row7.add(new CaseBean(7, 7, 1, Building.WALL, R.drawable.magic_tower_building_wall));
        row7.add(new CaseBean(7, 7, 2, Prop.KEY_YELLOW, R.drawable.magic_tower_prop_key_yellow));
        row7.add(new CaseBean(7, 7, 3, Prop.XIE_PING_SMALL, R.drawable.magic_tower_prop_xie_ping_small));
        row7.add(new CaseBean(7, 7, 4, Building.WALL, R.drawable.magic_tower_building_wall));
        row7.add(new CaseBean(7, 7, 5, Npc.GATE_BLUE, R.drawable.magic_tower_npc_gate_blue_1));
        row7.add(new CaseBean(7, 7, 6, Building.WALL, R.drawable.magic_tower_building_wall));
        row7.add(new CaseBean(7, 7, 7, Prop.XIE_PING_SMALL, R.drawable.magic_tower_prop_xie_ping_small));
        row7.add(new CaseBean(7, 7, 8, Prop.KEY_YELLOW, R.drawable.magic_tower_prop_key_yellow));
        row7.add(new CaseBean(7, 7, 9, Building.WALL, R.drawable.magic_tower_building_wall));
        row7.add(new CaseBean(7, 7, 10, Building.ROAD, R.drawable.magic_tower_building_road));
        floor7.add(row7);

        List<CaseBean> row8 = new ArrayList<>();
        row8.add(new CaseBean(7, 8, 0, Building.ROAD, R.drawable.magic_tower_building_road));
        row8.add(new CaseBean(7, 8, 1, Building.WALL, R.drawable.magic_tower_building_wall));
        row8.add(new CaseBean(7, 8, 2, Building.WALL, R.drawable.magic_tower_building_wall));
        row8.add(new CaseBean(7, 8, 3, Prop.KEY_BLUE, R.drawable.magic_tower_prop_key_blue));
        row8.add(new CaseBean(7, 8, 4, Prop.KEY_BLUE, R.drawable.magic_tower_prop_key_blue));
        row8.add(new CaseBean(7, 8, 5, Prop.XIE_PING_BIG, R.drawable.magic_tower_prop_xie_ping_big));
        row8.add(new CaseBean(7, 8, 6, Prop.KEY_BLUE, R.drawable.magic_tower_prop_key_blue));
        row8.add(new CaseBean(7, 8, 7, Prop.KEY_BLUE, R.drawable.magic_tower_prop_key_blue));
        row8.add(new CaseBean(7, 8, 8, Building.WALL, R.drawable.magic_tower_building_wall));
        row8.add(new CaseBean(7, 8, 9, Building.WALL, R.drawable.magic_tower_building_wall));
        row8.add(new CaseBean(7, 8, 10, Building.ROAD, R.drawable.magic_tower_building_road));
        floor7.add(row8);

        List<CaseBean> row9 = new ArrayList<>();
        row9.add(new CaseBean(7, 9, 0, Building.ROAD, R.drawable.magic_tower_building_road));
        row9.add(new CaseBean(7, 9, 1, Building.ROAD, R.drawable.magic_tower_building_road));
        row9.add(new CaseBean(7, 9, 2, Building.WALL, R.drawable.magic_tower_building_wall));
        row9.add(new CaseBean(7, 9, 3, Building.WALL, R.drawable.magic_tower_building_wall));
        row9.add(new CaseBean(7, 9, 4, Building.WALL, R.drawable.magic_tower_building_wall));
        row9.add(new CaseBean(7, 9, 5, Npc.GATE_RED, R.drawable.magic_tower_npc_gate_red_1));
        row9.add(new CaseBean(7, 9, 6, Building.WALL, R.drawable.magic_tower_building_wall));
        row9.add(new CaseBean(7, 9, 7, Building.WALL, R.drawable.magic_tower_building_wall));
        row9.add(new CaseBean(7, 9, 8, Building.WALL, R.drawable.magic_tower_building_wall));
        row9.add(new CaseBean(7, 9, 9, Building.ROAD, R.drawable.magic_tower_building_road));
        row9.add(new CaseBean(7, 9, 10, Building.ROAD, R.drawable.magic_tower_building_road));
        floor7.add(row9);

        List<CaseBean> row10 = new ArrayList<>();
        row10.add(new CaseBean(7, 10, 0, Building.WALL, R.drawable.magic_tower_building_wall));
        row10.add(new CaseBean(7, 10, 1, Building.ROAD, R.drawable.magic_tower_building_road));
        row10.add(new CaseBean(7, 10, 2, Building.ROAD, R.drawable.magic_tower_building_road));
        row10.add(new CaseBean(7, 10, 3, Npc.GATE_YELLOW, R.drawable.magic_tower_npc_gate_yellow_1));
        row10.add(new CaseBean(7, 10, 4, Npc.GO_DOWNSTAIRS, R.drawable.magic_tower_npc_go_downstairs));
        row10.add(new CaseBean(7, 10, 5, Building.ROAD, R.drawable.magic_tower_building_road));
        row10.add(new CaseBean(7, 10, 6, Building.ROAD, R.drawable.magic_tower_building_road));
        row10.add(new CaseBean(7, 10, 7, Npc.GATE_YELLOW, R.drawable.magic_tower_npc_gate_yellow_1));
        row10.add(new CaseBean(7, 10, 8, Building.ROAD, R.drawable.magic_tower_building_road));
        row10.add(new CaseBean(7, 10, 9, Building.ROAD, R.drawable.magic_tower_building_road));
        row10.add(new CaseBean(7, 10, 10, Building.WALL, R.drawable.magic_tower_building_wall));
        floor7.add(row10);

        return floor7;
    }

    @Override
    public void fromUpstairsToThisFloor() {
        resetWarriorPosition(0, 1);
    }

    @Override
    public void fromDownstairsToThisFloor() {
        resetWarriorPosition(10, 5);
    }
}
