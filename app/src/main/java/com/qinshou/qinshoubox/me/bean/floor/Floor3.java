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
 * Description:第 3 层
 * Created by 禽兽先生
 * Created on 2017/4/26
 */

public class Floor3 extends AbsFloor {

    @Override
    public int getFloor() {
        return 3;
    }

    @Override
    public List<List<CaseBean>> setData() {
        List<List<CaseBean>> floor3 = new ArrayList<>();
        List<CaseBean> row0 = new ArrayList<>();
        row0.add(new CaseBean(3, 0, 0, Prop.TIE_JIAN, R.drawable.magic_tower_prop_tie_jian));
        row0.add(new CaseBean(3, 0, 1, Monster.HONG_TOU_GUAI, R.drawable.magic_tower_monster_hong_tou_guai));
        row0.add(new CaseBean(3, 0, 2, Prop.KEY_YELLOW, R.drawable.magic_tower_prop_key_yellow));
        row0.add(new CaseBean(3, 0, 3, Building.WALL, R.drawable.magic_tower_building_wall));
        row0.add(new CaseBean(3, 0, 4, Npc.SHANG_DIAN_LAO_BAN_SMALL_1, R.drawable.magic_tower_npc_shang_dian_lao_ban_1));
        row0.add(new CaseBean(3, 0, 5, Npc.SHANG_DIAN_LAO_BAN_SMALL_2, R.drawable.magic_tower_npc_shang_dian_lao_ban_2));
        row0.add(new CaseBean(3, 0, 6, Npc.SHANG_DIAN_LAO_BAN_SMALL_3, R.drawable.magic_tower_npc_shang_dian_lao_ban_3));
        row0.add(new CaseBean(3, 0, 7, Building.WALL, R.drawable.magic_tower_building_wall));
        row0.add(new CaseBean(3, 0, 8, Building.WALL, R.drawable.magic_tower_building_wall));
        row0.add(new CaseBean(3, 0, 9, Building.WALL, R.drawable.magic_tower_building_wall));
        row0.add(new CaseBean(3, 0, 10, Building.WALL, R.drawable.magic_tower_building_wall));
        floor3.add(row0);

        List<CaseBean> row1 = new ArrayList<>();
        row1.add(new CaseBean(3, 1, 0, Monster.HONG_TOU_GUAI, R.drawable.magic_tower_monster_hong_tou_guai));
        row1.add(new CaseBean(3, 1, 1, Prop.KEY_YELLOW, R.drawable.magic_tower_prop_key_yellow));
        row1.add(new CaseBean(3, 1, 2, Building.ROAD, R.drawable.magic_tower_building_road));
        row1.add(new CaseBean(3, 1, 3, Building.WALL, R.drawable.magic_tower_building_wall));
        row1.add(new CaseBean(3, 1, 4, Building.ROAD, R.drawable.magic_tower_building_road));
        row1.add(new CaseBean(3, 1, 5, Building.ROAD, R.drawable.magic_tower_building_road));
        row1.add(new CaseBean(3, 1, 6, Building.ROAD, R.drawable.magic_tower_building_road));
        row1.add(new CaseBean(3, 1, 7, Building.WALL, R.drawable.magic_tower_building_wall));
        row1.add(new CaseBean(3, 1, 8, Building.ROAD, R.drawable.magic_tower_building_road));
        row1.add(new CaseBean(3, 1, 9, Monster.XIAO_BIAN_FU, R.drawable.magic_tower_monster_xiao_bian_fu));
        row1.add(new CaseBean(3, 1, 10, Building.ROAD, R.drawable.magic_tower_building_road));
        floor3.add(row1);

        List<CaseBean> row2 = new ArrayList<>();
        row2.add(new CaseBean(3, 2, 0, Prop.KEY_YELLOW, R.drawable.magic_tower_prop_key_yellow));
        row2.add(new CaseBean(3, 2, 1, Monster.KU_LOU_REN, R.drawable.magic_tower_monster_ku_lou_ren));
        row2.add(new CaseBean(3, 2, 2, Building.ROAD, R.drawable.magic_tower_building_road));
        row2.add(new CaseBean(3, 2, 3, Building.WALL, R.drawable.magic_tower_building_wall));
        row2.add(new CaseBean(3, 2, 4, Building.WALL, R.drawable.magic_tower_building_wall));
        row2.add(new CaseBean(3, 2, 5, Npc.GATE_YELLOW, R.drawable.magic_tower_npc_gate_yellow_1));
        row2.add(new CaseBean(3, 2, 6, Building.WALL, R.drawable.magic_tower_building_wall));
        row2.add(new CaseBean(3, 2, 7, Building.WALL, R.drawable.magic_tower_building_wall));
        row2.add(new CaseBean(3, 2, 8, Building.ROAD, R.drawable.magic_tower_building_road));
        row2.add(new CaseBean(3, 2, 9, Building.WALL, R.drawable.magic_tower_building_wall));
        row2.add(new CaseBean(3, 2, 10, Building.ROAD, R.drawable.magic_tower_building_road));
        floor3.add(row2);

        List<CaseBean> row3 = new ArrayList<>();
        row3.add(new CaseBean(3, 3, 0, Building.WALL, R.drawable.magic_tower_building_wall));
        row3.add(new CaseBean(3, 3, 1, Npc.GATE_YELLOW, R.drawable.magic_tower_npc_gate_yellow_1));
        row3.add(new CaseBean(3, 3, 2, Building.WALL, R.drawable.magic_tower_building_wall));
        row3.add(new CaseBean(3, 3, 3, Building.WALL, R.drawable.magic_tower_building_wall));
        row3.add(new CaseBean(3, 3, 4, Building.ROAD, R.drawable.magic_tower_building_road));
        row3.add(new CaseBean(3, 3, 5, Monster.KU_LOU_REN, R.drawable.magic_tower_monster_ku_lou_ren));
        row3.add(new CaseBean(3, 3, 6, Building.ROAD, R.drawable.magic_tower_building_road));
        row3.add(new CaseBean(3, 3, 7, Building.WALL, R.drawable.magic_tower_building_wall));
        row3.add(new CaseBean(3, 3, 8, Prop.KEY_YELLOW, R.drawable.magic_tower_prop_key_yellow));
        row3.add(new CaseBean(3, 3, 9, Building.WALL, R.drawable.magic_tower_building_wall));
        row3.add(new CaseBean(3, 3, 10, Monster.HONG_TOU_GUAI, R.drawable.magic_tower_monster_hong_tou_guai));
        floor3.add(row3);

        List<CaseBean> row4 = new ArrayList<>();
        row4.add(new CaseBean(3, 4, 0, Building.ROAD, R.drawable.magic_tower_building_road));
        row4.add(new CaseBean(3, 4, 1, Building.ROAD, R.drawable.magic_tower_building_road));
        row4.add(new CaseBean(3, 4, 2, Building.ROAD, R.drawable.magic_tower_building_road));
        row4.add(new CaseBean(3, 4, 3, Building.WALL, R.drawable.magic_tower_building_wall));
        row4.add(new CaseBean(3, 4, 4, Building.WALL, R.drawable.magic_tower_building_wall));
        row4.add(new CaseBean(3, 4, 5, Building.WALL, R.drawable.magic_tower_building_wall));
        row4.add(new CaseBean(3, 4, 6, Building.ROAD, R.drawable.magic_tower_building_road));
        row4.add(new CaseBean(3, 4, 7, Building.WALL, R.drawable.magic_tower_building_wall));
        row4.add(new CaseBean(3, 4, 8, Prop.KEY_YELLOW, R.drawable.magic_tower_prop_key_yellow));
        row4.add(new CaseBean(3, 4, 9, Building.WALL, R.drawable.magic_tower_building_wall));
        row4.add(new CaseBean(3, 4, 10, Monster.XIAO_BIAN_FU, R.drawable.magic_tower_monster_xiao_bian_fu));
        floor3.add(row4);

        List<CaseBean> row5 = new ArrayList<>();
        row5.add(new CaseBean(3, 5, 0, Monster.LV_TOU_GUAI, R.drawable.magic_tower_monster_lv_tou_guai));
        row5.add(new CaseBean(3, 5, 1, Building.WALL, R.drawable.magic_tower_building_wall));
        row5.add(new CaseBean(3, 5, 2, Building.ROAD, R.drawable.magic_tower_building_road));
        row5.add(new CaseBean(3, 5, 3, Monster.XIAO_BIAN_FU, R.drawable.magic_tower_monster_xiao_bian_fu));
        row5.add(new CaseBean(3, 5, 4, Monster.HONG_TOU_GUAI, R.drawable.magic_tower_monster_hong_tou_guai));
        row5.add(new CaseBean(3, 5, 5, Monster.XIAO_BIAN_FU, R.drawable.magic_tower_monster_xiao_bian_fu));
        row5.add(new CaseBean(3, 5, 6, Building.ROAD, R.drawable.magic_tower_building_road));
        row5.add(new CaseBean(3, 5, 7, Building.WALL, R.drawable.magic_tower_building_wall));
        row5.add(new CaseBean(3, 5, 8, Prop.KEY_YELLOW, R.drawable.magic_tower_prop_key_yellow));
        row5.add(new CaseBean(3, 5, 9, Building.WALL, R.drawable.magic_tower_building_wall));
        row5.add(new CaseBean(3, 5, 10, Monster.HONG_TOU_GUAI, R.drawable.magic_tower_monster_hong_tou_guai));
        floor3.add(row5);

        List<CaseBean> row6 = new ArrayList<>();
        row6.add(new CaseBean(3, 6, 0, Monster.LV_TOU_GUAI, R.drawable.magic_tower_monster_lv_tou_guai));
        row6.add(new CaseBean(3, 6, 1, Building.WALL, R.drawable.magic_tower_building_wall));
        row6.add(new CaseBean(3, 6, 2, Building.WALL, R.drawable.magic_tower_building_wall));
        row6.add(new CaseBean(3, 6, 3, Building.WALL, R.drawable.magic_tower_building_wall));
        row6.add(new CaseBean(3, 6, 4, Building.WALL, R.drawable.magic_tower_building_wall));
        row6.add(new CaseBean(3, 6, 5, Building.WALL, R.drawable.magic_tower_building_wall));
        row6.add(new CaseBean(3, 6, 6, Building.ROAD, R.drawable.magic_tower_building_road));
        row6.add(new CaseBean(3, 6, 7, Building.ROAD, R.drawable.magic_tower_building_road));
        row6.add(new CaseBean(3, 6, 8, Building.ROAD, R.drawable.magic_tower_building_road));
        row6.add(new CaseBean(3, 6, 9, Building.WALL, R.drawable.magic_tower_building_wall));
        row6.add(new CaseBean(3, 6, 10, Building.ROAD, R.drawable.magic_tower_building_road));
        floor3.add(row6);

        List<CaseBean> row7 = new ArrayList<>();
        row7.add(new CaseBean(3, 7, 0, Building.ROAD, R.drawable.magic_tower_building_road));
        row7.add(new CaseBean(3, 7, 1, Building.ROAD, R.drawable.magic_tower_building_road));
        row7.add(new CaseBean(3, 7, 2, Building.ROAD, R.drawable.magic_tower_building_road));
        row7.add(new CaseBean(3, 7, 3, Building.ROAD, R.drawable.magic_tower_building_road));
        row7.add(new CaseBean(3, 7, 4, Building.ROAD, R.drawable.magic_tower_building_road));
        row7.add(new CaseBean(3, 7, 5, Building.WALL, R.drawable.magic_tower_building_wall));
        row7.add(new CaseBean(3, 7, 6, Building.WALL, R.drawable.magic_tower_building_wall));
        row7.add(new CaseBean(3, 7, 7, Npc.GATE_YELLOW, R.drawable.magic_tower_npc_gate_yellow_1));
        row7.add(new CaseBean(3, 7, 8, Building.WALL, R.drawable.magic_tower_building_wall));
        row7.add(new CaseBean(3, 7, 9, Building.WALL, R.drawable.magic_tower_building_wall));
        row7.add(new CaseBean(3, 7, 10, Building.ROAD, R.drawable.magic_tower_building_road));
        floor3.add(row7);

        List<CaseBean> row8 = new ArrayList<>();
        row8.add(new CaseBean(3, 8, 0, Building.WALL, R.drawable.magic_tower_building_wall));
        row8.add(new CaseBean(3, 8, 1, Building.WALL, R.drawable.magic_tower_building_wall));
        row8.add(new CaseBean(3, 8, 2, Building.WALL, R.drawable.magic_tower_building_wall));
        row8.add(new CaseBean(3, 8, 3, Building.WALL, R.drawable.magic_tower_building_wall));
        row8.add(new CaseBean(3, 8, 4, Monster.XIAO_BIAN_FU, R.drawable.magic_tower_monster_xiao_bian_fu));
        row8.add(new CaseBean(3, 8, 5, Building.WALL, R.drawable.magic_tower_building_wall));
        row8.add(new CaseBean(3, 8, 6, Monster.HONG_TOU_GUAI, R.drawable.magic_tower_monster_hong_tou_guai));
        row8.add(new CaseBean(3, 8, 7, Building.ROAD, R.drawable.magic_tower_building_road));
        row8.add(new CaseBean(3, 8, 8, Monster.HONG_TOU_GUAI, R.drawable.magic_tower_monster_hong_tou_guai));
        row8.add(new CaseBean(3, 8, 9, Building.WALL, R.drawable.magic_tower_building_wall));
        row8.add(new CaseBean(3, 8, 10, Building.ROAD, R.drawable.magic_tower_building_road));
        floor3.add(row8);

        List<CaseBean> row9 = new ArrayList<>();
        row9.add(new CaseBean(3, 9, 0, Building.WALL, R.drawable.magic_tower_building_wall));
        row9.add(new CaseBean(3, 9, 1, Building.ROAD, R.drawable.magic_tower_building_road));
        row9.add(new CaseBean(3, 9, 2, Building.ROAD, R.drawable.magic_tower_building_road));
        row9.add(new CaseBean(3, 9, 3, Building.ROAD, R.drawable.magic_tower_building_road));
        row9.add(new CaseBean(3, 9, 4, Building.ROAD, R.drawable.magic_tower_building_road));
        row9.add(new CaseBean(3, 9, 5, Building.WALL, R.drawable.magic_tower_building_wall));
        row9.add(new CaseBean(3, 9, 6, Prop.BAO_SHI_BLUE, R.drawable.magic_tower_prop_bao_shi_blue));
        row9.add(new CaseBean(3, 9, 7, Monster.XIAO_BIAN_FU, R.drawable.magic_tower_monster_xiao_bian_fu));
        row9.add(new CaseBean(3, 9, 8, Prop.KEY_YELLOW, R.drawable.magic_tower_prop_key_yellow));
        row9.add(new CaseBean(3, 9, 9, Building.WALL, R.drawable.magic_tower_building_wall));
        row9.add(new CaseBean(3, 9, 10, Building.ROAD, R.drawable.magic_tower_building_road));
        floor3.add(row9);

        List<CaseBean> row10 = new ArrayList<>();
        row10.add(new CaseBean(3, 10, 0, Npc.GO_DOWNSTAIRS, R.drawable.magic_tower_npc_go_downstairs));
        row10.add(new CaseBean(3, 10, 1, Building.ROAD, R.drawable.magic_tower_building_road));
        row10.add(new CaseBean(3, 10, 2, Building.WALL, R.drawable.magic_tower_building_wall));
        row10.add(new CaseBean(3, 10, 3, Building.WALL, R.drawable.magic_tower_building_wall));
        row10.add(new CaseBean(3, 10, 4, Building.WALL, R.drawable.magic_tower_building_wall));
        row10.add(new CaseBean(3, 10, 5, Building.WALL, R.drawable.magic_tower_building_wall));
        row10.add(new CaseBean(3, 10, 6, Prop.BAO_SHI_RED, R.drawable.magic_tower_prop_bao_shi_red));
        row10.add(new CaseBean(3, 10, 7, Prop.XIE_PING_BIG, R.drawable.magic_tower_prop_xie_ping_big));
        row10.add(new CaseBean(3, 10, 8, Prop.KEY_YELLOW, R.drawable.magic_tower_prop_key_yellow));
        row10.add(new CaseBean(3, 10, 9, Building.WALL, R.drawable.magic_tower_building_wall));
        row10.add(new CaseBean(3, 10, 10, Npc.GO_UPSTAIRS, R.drawable.magic_tower_npc_go_upstairs));
        floor3.add(row10);

        return floor3;
    }

    @Override
    public void fromUpstairsToThisFloor() {
        resetWarriorPosition(9, 10);
    }

    @Override
    public void fromDownstairsToThisFloor() {
        resetWarriorPosition(10, 1);
    }
}
