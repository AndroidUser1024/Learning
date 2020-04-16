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
 * Description:第 2 层
 * Created by 禽兽先生
 * Created on 2017/4/26
 */

public class Floor2 extends AFloor {

    @Override
    public int getFloor() {
        return 2;
    }

    @Override
    public List<List<CaseBean>> setData() {
        List<List<CaseBean>> floor2 = new ArrayList<>();
        List<CaseBean> row0 = new ArrayList<>();
        row0.add(new CaseBean(2, 0, 0, Npc.GO_DOWNSTAIRS, R.drawable.magic_tower_npc_go_downstairs));
        row0.add(new CaseBean(2, 0, 1, Building.WALL, R.drawable.magic_tower_building_wall));
        row0.add(new CaseBean(2, 0, 2, Building.ROAD, R.drawable.magic_tower_building_road));
        row0.add(new CaseBean(2, 0, 3, Monster.JIN_DUI_ZHANG, R.drawable.magic_tower_monster_jin_dui_zhang));
        row0.add(new CaseBean(2, 0, 4, Building.ROAD, R.drawable.magic_tower_building_road));
        row0.add(new CaseBean(2, 0, 5, Building.WALL, R.drawable.magic_tower_building_wall));
        row0.add(new CaseBean(2, 0, 6, Prop.BAO_SHI_RED, R.drawable.magic_tower_prop_bao_shi_red));
        row0.add(new CaseBean(2, 0, 7, Prop.BAO_SHI_BLUE, R.drawable.magic_tower_prop_bao_shi_blue));
        row0.add(new CaseBean(2, 0, 8, Prop.KEY_YELLOW, R.drawable.magic_tower_prop_key_yellow));
        row0.add(new CaseBean(2, 0, 9, Prop.KEY_RED, R.drawable.magic_tower_prop_key_red));
        row0.add(new CaseBean(2, 0, 10, Building.WALL, R.drawable.magic_tower_building_wall));
        floor2.add(row0);

        List<CaseBean> row1 = new ArrayList<>();
        row1.add(new CaseBean(2, 1, 0, Building.ROAD, R.drawable.magic_tower_building_road));
        row1.add(new CaseBean(2, 1, 1, Building.WALL, R.drawable.magic_tower_building_wall));
        row1.add(new CaseBean(2, 1, 2, Prop.BAO_SHI_BLUE, R.drawable.magic_tower_prop_bao_shi_blue));
        row1.add(new CaseBean(2, 1, 3, Building.WALL, R.drawable.magic_tower_building_wall));
        row1.add(new CaseBean(2, 1, 4, Prop.XIE_PING_BIG, R.drawable.magic_tower_prop_xie_ping_big));
        row1.add(new CaseBean(2, 1, 5, Building.WALL, R.drawable.magic_tower_building_wall));
        row1.add(new CaseBean(2, 1, 6, Prop.BAO_SHI_RED, R.drawable.magic_tower_prop_bao_shi_red));
        row1.add(new CaseBean(2, 1, 7, Prop.BAO_SHI_BLUE, R.drawable.magic_tower_prop_bao_shi_blue));
        row1.add(new CaseBean(2, 1, 8, Prop.KEY_YELLOW, R.drawable.magic_tower_prop_key_yellow));
        row1.add(new CaseBean(2, 1, 9, Prop.KEY_BLUE, R.drawable.magic_tower_prop_key_blue));
        row1.add(new CaseBean(2, 1, 10, Building.WALL, R.drawable.magic_tower_building_wall));
        floor2.add(row1);

        List<CaseBean> row2 = new ArrayList<>();
        row2.add(new CaseBean(2, 2, 0, Building.ROAD, R.drawable.magic_tower_building_road));
        row2.add(new CaseBean(2, 2, 1, Building.WALL, R.drawable.magic_tower_building_wall));
        row2.add(new CaseBean(2, 2, 2, Prop.KEY_YELLOW, R.drawable.magic_tower_prop_key_yellow));
        row2.add(new CaseBean(2, 2, 3, Building.WALL, R.drawable.magic_tower_building_wall));
        row2.add(new CaseBean(2, 2, 4, Prop.KEY_YELLOW, R.drawable.magic_tower_prop_key_yellow));
        row2.add(new CaseBean(2, 2, 5, Building.WALL, R.drawable.magic_tower_building_wall));
        row2.add(new CaseBean(2, 2, 6, Prop.BAO_SHI_RED, R.drawable.magic_tower_prop_bao_shi_red));
        row2.add(new CaseBean(2, 2, 7, Prop.BAO_SHI_BLUE, R.drawable.magic_tower_prop_bao_shi_blue));
        row2.add(new CaseBean(2, 2, 8, Prop.KEY_YELLOW, R.drawable.magic_tower_prop_key_yellow));
        row2.add(new CaseBean(2, 2, 9, Monster.JIN_WEI_SHI, R.drawable.magic_tower_monster_jin_wei_shi));
        row2.add(new CaseBean(2, 2, 10, Building.WALL, R.drawable.magic_tower_building_wall));
        floor2.add(row2);

        List<CaseBean> row3 = new ArrayList<>();
        row3.add(new CaseBean(2, 3, 0, Building.ROAD, R.drawable.magic_tower_building_road));
        row3.add(new CaseBean(2, 3, 1, Building.WALL, R.drawable.magic_tower_building_wall));
        row3.add(new CaseBean(2, 3, 2, Prop.KEY_YELLOW, R.drawable.magic_tower_prop_key_yellow));
        row3.add(new CaseBean(2, 3, 3, Building.WALL, R.drawable.magic_tower_building_wall));
        row3.add(new CaseBean(2, 3, 4, Prop.KEY_YELLOW, R.drawable.magic_tower_prop_key_yellow));
        row3.add(new CaseBean(2, 3, 5, Building.WALL, R.drawable.magic_tower_building_wall));
        row3.add(new CaseBean(2, 3, 6, Building.WALL, R.drawable.magic_tower_building_wall));
        row3.add(new CaseBean(2, 3, 7, Building.WALL, R.drawable.magic_tower_building_wall));
        row3.add(new CaseBean(2, 3, 8, Building.WALL, R.drawable.magic_tower_building_wall));
        row3.add(new CaseBean(2, 3, 9, Npc.GATE_YELLOW, R.drawable.magic_tower_npc_gate_yellow_1));
        row3.add(new CaseBean(2, 3, 10, Building.WALL, R.drawable.magic_tower_building_wall));
        floor2.add(row3);

        List<CaseBean> row4 = new ArrayList<>();
        row4.add(new CaseBean(2, 4, 0, Building.ROAD, R.drawable.magic_tower_building_road));
        row4.add(new CaseBean(2, 4, 1, Building.WALL, R.drawable.magic_tower_building_wall));
        row4.add(new CaseBean(2, 4, 2, Building.ROAD, R.drawable.magic_tower_building_road));
        row4.add(new CaseBean(2, 4, 3, Building.WALL, R.drawable.magic_tower_building_wall));
        row4.add(new CaseBean(2, 4, 4, Building.ROAD, R.drawable.magic_tower_building_road));
        row4.add(new CaseBean(2, 4, 5, Building.ROAD, R.drawable.magic_tower_building_road));
        row4.add(new CaseBean(2, 4, 6, Building.ROAD, R.drawable.magic_tower_building_road));
        row4.add(new CaseBean(2, 4, 7, Npc.GATE_YELLOW, R.drawable.magic_tower_npc_gate_yellow_1));
        row4.add(new CaseBean(2, 4, 8, Building.ROAD, R.drawable.magic_tower_building_road));
        row4.add(new CaseBean(2, 4, 9, Building.ROAD, R.drawable.magic_tower_building_road));
        row4.add(new CaseBean(2, 4, 10, Building.WALL, R.drawable.magic_tower_building_wall));
        floor2.add(row4);

        List<CaseBean> row5 = new ArrayList<>();
        row5.add(new CaseBean(2, 5, 0, Building.ROAD, R.drawable.magic_tower_building_road));
        row5.add(new CaseBean(2, 5, 1, Building.WALL, R.drawable.magic_tower_building_wall));
        row5.add(new CaseBean(2, 5, 2, Npc.GATE_YELLOW, R.drawable.magic_tower_npc_gate_yellow_1));
        row5.add(new CaseBean(2, 5, 3, Building.WALL, R.drawable.magic_tower_building_wall));
        row5.add(new CaseBean(2, 5, 4, Building.WALL, R.drawable.magic_tower_building_wall));
        row5.add(new CaseBean(2, 5, 5, Npc.GATE_YELLOW, R.drawable.magic_tower_npc_gate_yellow_1));
        row5.add(new CaseBean(2, 5, 6, Building.WALL, R.drawable.magic_tower_building_wall));
        row5.add(new CaseBean(2, 5, 7, Building.WALL, R.drawable.magic_tower_building_wall));
        row5.add(new CaseBean(2, 5, 8, Npc.GATE_YELLOW, R.drawable.magic_tower_npc_gate_yellow_1));
        row5.add(new CaseBean(2, 5, 9, Building.WALL, R.drawable.magic_tower_building_wall));
        row5.add(new CaseBean(2, 5, 10, Building.WALL, R.drawable.magic_tower_building_wall));
        floor2.add(row5);

        List<CaseBean> row6 = new ArrayList<>();
        row6.add(new CaseBean(2, 6, 0, Building.ROAD, R.drawable.magic_tower_building_road));
        row6.add(new CaseBean(2, 6, 1, Npc.GATE_GREEN, R.drawable.magic_tower_npc_gate_green_1));
        row6.add(new CaseBean(2, 6, 2, Building.ROAD, R.drawable.magic_tower_building_road));
        row6.add(new CaseBean(2, 6, 3, Building.ROAD, R.drawable.magic_tower_building_road));
        row6.add(new CaseBean(2, 6, 4, Building.ROAD, R.drawable.magic_tower_building_road));
        row6.add(new CaseBean(2, 6, 5, Building.ROAD, R.drawable.magic_tower_building_road));
        row6.add(new CaseBean(2, 6, 6, Building.WALL, R.drawable.magic_tower_building_wall));
        row6.add(new CaseBean(2, 6, 7, Building.ROAD, R.drawable.magic_tower_building_road));
        row6.add(new CaseBean(2, 6, 8, Monster.JIN_WEI_SHI, R.drawable.magic_tower_monster_jin_wei_shi));
        row6.add(new CaseBean(2, 6, 9, Building.ROAD, R.drawable.magic_tower_building_road));
        row6.add(new CaseBean(2, 6, 10, Building.WALL, R.drawable.magic_tower_building_wall));
        floor2.add(row6);

        List<CaseBean> row7 = new ArrayList<>();
        row7.add(new CaseBean(2, 7, 0, Building.ROAD, R.drawable.magic_tower_building_road));
        row7.add(new CaseBean(2, 7, 1, Building.WALL, R.drawable.magic_tower_building_wall));
        row7.add(new CaseBean(2, 7, 2, Npc.GATE_YELLOW, R.drawable.magic_tower_npc_gate_yellow_1));
        row7.add(new CaseBean(2, 7, 3, Building.WALL, R.drawable.magic_tower_building_wall));
        row7.add(new CaseBean(2, 7, 4, Building.WALL, R.drawable.magic_tower_building_wall));
        row7.add(new CaseBean(2, 7, 5, Npc.GATE_BLUE, R.drawable.magic_tower_npc_gate_blue_1));
        row7.add(new CaseBean(2, 7, 6, Building.WALL, R.drawable.magic_tower_building_wall));
        row7.add(new CaseBean(2, 7, 7, Npc.GATE_IRON_OPEN, R.drawable.magic_tower_npc_gate_iron_1));
        row7.add(new CaseBean(2, 7, 8, Building.WALL, R.drawable.magic_tower_building_wall));
        row7.add(new CaseBean(2, 7, 9, Npc.GATE_IRON_OPEN, R.drawable.magic_tower_npc_gate_iron_1));
        row7.add(new CaseBean(2, 7, 10, Building.WALL, R.drawable.magic_tower_building_wall));
        floor2.add(row7);

        List<CaseBean> row8 = new ArrayList<>();
        row8.add(new CaseBean(2, 8, 0, Building.ROAD, R.drawable.magic_tower_building_road));
        row8.add(new CaseBean(2, 8, 1, Building.WALL, R.drawable.magic_tower_building_wall));
        row8.add(new CaseBean(2, 8, 2, Prop.KEY_YELLOW, R.drawable.magic_tower_prop_key_yellow));
        row8.add(new CaseBean(2, 8, 3, Building.WALL, R.drawable.magic_tower_building_wall));
        row8.add(new CaseBean(2, 8, 4, Prop.XIE_PING_BIG, R.drawable.magic_tower_prop_xie_ping_big));
        row8.add(new CaseBean(2, 8, 5, Prop.XIE_PING_SMALL, R.drawable.magic_tower_prop_xie_ping_small));
        row8.add(new CaseBean(2, 8, 6, Building.WALL, R.drawable.magic_tower_building_wall));
        row8.add(new CaseBean(2, 8, 7, Building.ROAD, R.drawable.magic_tower_building_road));
        row8.add(new CaseBean(2, 8, 8, Building.WALL, R.drawable.magic_tower_building_wall));
        row8.add(new CaseBean(2, 8, 9, Building.ROAD, R.drawable.magic_tower_building_road));
        row8.add(new CaseBean(2, 8, 10, Building.WALL, R.drawable.magic_tower_building_wall));
        floor2.add(row8);

        List<CaseBean> row9 = new ArrayList<>();
        row9.add(new CaseBean(2, 9, 0, Building.ROAD, R.drawable.magic_tower_building_road));
        row9.add(new CaseBean(2, 9, 1, Building.WALL, R.drawable.magic_tower_building_wall));
        row9.add(new CaseBean(2, 9, 2, Prop.KEY_YELLOW, R.drawable.magic_tower_prop_key_yellow));
        row9.add(new CaseBean(2, 9, 3, Building.WALL, R.drawable.magic_tower_building_wall));
        row9.add(new CaseBean(2, 9, 4, Prop.XIE_PING_BIG, R.drawable.magic_tower_prop_xie_ping_big));
        row9.add(new CaseBean(2, 9, 5, Prop.XIE_PING_SMALL, R.drawable.magic_tower_prop_xie_ping_small));
        row9.add(new CaseBean(2, 9, 6, Building.WALL, R.drawable.magic_tower_building_wall));
        row9.add(new CaseBean(2, 9, 7, Building.ROAD, R.drawable.magic_tower_building_road));
        row9.add(new CaseBean(2, 9, 8, Building.WALL, R.drawable.magic_tower_building_wall));
        row9.add(new CaseBean(2, 9, 9, Building.ROAD, R.drawable.magic_tower_building_road));
        row9.add(new CaseBean(2, 9, 10, Building.WALL, R.drawable.magic_tower_building_wall));
        floor2.add(row9);

        List<CaseBean> row10 = new ArrayList<>();
        row10.add(new CaseBean(2, 10, 0, Npc.GO_UPSTAIRS,R.drawable.magic_tower_npc_go_upstairs));
        row10.add(new CaseBean(2, 10, 1, Building.WALL, R.drawable.magic_tower_building_wall));
        row10.add(new CaseBean(2, 10, 2, Prop.BAO_SHI_RED, R.drawable.magic_tower_prop_bao_shi_red));
        row10.add(new CaseBean(2, 10, 3, Building.WALL, R.drawable.magic_tower_building_wall));
        row10.add(new CaseBean(2, 10, 4, Prop.XIE_PING_BIG, R.drawable.magic_tower_prop_xie_ping_big));
        row10.add(new CaseBean(2, 10, 5, Prop.XIE_PING_BIG, R.drawable.magic_tower_prop_xie_ping_big));
        row10.add(new CaseBean(2, 10, 6, Building.WALL, R.drawable.magic_tower_building_wall));
        row10.add(new CaseBean(2, 10, 7, Npc.SHEN_MI_LAO_REN_FLOOR_2,R.drawable.magic_tower_npc_shen_mi_lao_ren));
        row10.add(new CaseBean(2, 10, 8, Building.WALL, R.drawable.magic_tower_building_wall));
        row10.add(new CaseBean(2, 10, 9, Npc.SHANG_REN_FLOOR_2,R.drawable.magic_tower_npc_shang_ren));
        row10.add(new CaseBean(2, 10, 10, Building.WALL, R.drawable.magic_tower_building_wall));
        floor2.add(row10);

        return floor2;
    }

    @Override
    public void fromUpstairsToThisFloor() {
        resetWarriorPosition(9, 0);
    }

    @Override
    public void fromDownstairsToThisFloor() {
        resetWarriorPosition(1, 0);
    }
}
