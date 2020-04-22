package com.qinshou.qinshoubox.me.bean.floor;


import com.qinshou.qinshoubox.R;
import com.qinshou.qinshoubox.me.bean.CaseBean;
import com.qinshou.qinshoubox.me.bean.Position;
import com.qinshou.qinshoubox.me.enums.Building;
import com.qinshou.qinshoubox.me.enums.Monster;
import com.qinshou.qinshoubox.me.enums.Npc;
import com.qinshou.qinshoubox.me.enums.Prop;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:第 8 层
 * Created by 禽兽先生
 * Created on 2017/4/26
 */

public class Floor8 extends AbsFloor {

    @Override
    public int getFloor() {
        return 8;
    }

    @Override
    public List<List<CaseBean>> setData() {
        List<List<CaseBean>> floor8 = new ArrayList<>();
//        List<CaseBean> row0 = new ArrayList<>();
//        row0.add(new CaseBean(   Npc.GO_DOWNSTAIRS, R.drawable.magic_tower_npc_go_downstairs));
//        row0.add(new CaseBean(   Building.WALL, R.drawable.magic_tower_building_wall));
//        row0.add(new CaseBean(   Building.ROAD, R.drawable.magic_tower_building_road));
//        row0.add(new CaseBean(   Building.ROAD, R.drawable.magic_tower_building_road));
//        row0.add(new CaseBean(   Building.ROAD, R.drawable.magic_tower_building_road));
//        row0.add(new CaseBean(   Building.ROAD, R.drawable.magic_tower_building_road));
//        row0.add(new CaseBean(   Building.WALL, R.drawable.magic_tower_building_wall));
//        row0.add(new CaseBean(   Building.ROAD, R.drawable.magic_tower_building_road));
//        row0.add(new CaseBean(   Prop.KEY_YELLOW, R.drawable.magic_tower_prop_key_yellow));
//        row0.add(new CaseBean(   Monster.KU_LOU_DUI_ZHANG, R.drawable.magic_tower_monster_ku_lou_dui_zhang));
//        row0.add(new CaseBean(   Building.ROAD, R.drawable.magic_tower_building_road));
//        floor8.add(row0);
//
//        List<CaseBean> row1 = new ArrayList<>();
//        row1.add(new CaseBean(   Building.ROAD, R.drawable.magic_tower_building_road));
//        row1.add(new CaseBean(   Building.WALL, R.drawable.magic_tower_building_wall));
//        row1.add(new CaseBean(   Building.ROAD, R.drawable.magic_tower_building_road));
//        row1.add(new CaseBean(   Building.WALL, R.drawable.magic_tower_building_wall));
//        row1.add(new CaseBean(   Building.WALL, R.drawable.magic_tower_building_wall));
//        row1.add(new CaseBean(   Npc.GATE_YELLOW, R.drawable.magic_tower_npc_gate_yellow_1));
//        row1.add(new CaseBean(   Building.WALL, R.drawable.magic_tower_building_wall));
//        row1.add(new CaseBean(   Npc.GATE_YELLOW, R.drawable.magic_tower_npc_gate_yellow_1));
//        row1.add(new CaseBean(   Building.WALL, R.drawable.magic_tower_building_wall));
//        row1.add(new CaseBean(   Building.WALL, R.drawable.magic_tower_building_wall));
//        row1.add(new CaseBean(   Building.ROAD, R.drawable.magic_tower_building_road));
//        floor8.add(row1);
//
//        List<CaseBean> row2 = new ArrayList<>();
//        row2.add(new CaseBean(   Building.ROAD, R.drawable.magic_tower_building_road));
//        row2.add(new CaseBean(   Building.WALL, R.drawable.magic_tower_building_wall));
//        row2.add(new CaseBean(   Building.ROAD, R.drawable.magic_tower_building_road));
//        row2.add(new CaseBean(   Building.WALL, R.drawable.magic_tower_building_wall));
//        row2.add(new CaseBean(   Building.ROAD, R.drawable.magic_tower_building_road));
//        row2.add(new CaseBean(   Building.ROAD, R.drawable.magic_tower_building_road));
//        row2.add(new CaseBean(   Npc.GATE_BLUE, R.drawable.magic_tower_npc_gate_blue_1));
//        row2.add(new CaseBean(   Building.ROAD, R.drawable.magic_tower_building_road));
//        row2.add(new CaseBean(   Building.ROAD, R.drawable.magic_tower_building_road));
//        row2.add(new CaseBean(   Building.WALL, R.drawable.magic_tower_building_wall));
//        row2.add(new CaseBean(   Prop.BAO_SHI_RED, R.drawable.magic_tower_prop_gem_red));
//        floor8.add(row2);
//
//        List<CaseBean> row3 = new ArrayList<>();
//        row3.add(new CaseBean(   Building.ROAD, R.drawable.magic_tower_building_road));
//        row3.add(new CaseBean(   Building.WALL, R.drawable.magic_tower_building_wall));
//        row3.add(new CaseBean(   Building.ROAD, R.drawable.magic_tower_building_road));
//        row3.add(new CaseBean(   Building.WALL, R.drawable.magic_tower_building_wall));
//        row3.add(new CaseBean(   Monster.MA_YI_FA_SHI, R.drawable.magic_tower_monster_ma_yi_fa_shi));
//        row3.add(new CaseBean(   Building.WALL, R.drawable.magic_tower_building_wall));
//        row3.add(new CaseBean(   Building.WALL, R.drawable.magic_tower_building_wall));
//        row3.add(new CaseBean(   Building.WALL, R.drawable.magic_tower_building_wall));
//        row3.add(new CaseBean(   Monster.DA_BIAN_FU, R.drawable.magic_tower_monster_da_bian_fu));
//        row3.add(new CaseBean(   Building.WALL, R.drawable.magic_tower_building_wall));
//        row3.add(new CaseBean(   Monster.QING_TOU_GUAI, R.drawable.magic_tower_monster_qing_tou_guai));
//        floor8.add(row3);
//
//        List<CaseBean> row4 = new ArrayList<>();
//        row4.add(new CaseBean(   Monster.DA_BIAN_FU, R.drawable.magic_tower_monster_da_bian_fu));
//        row4.add(new CaseBean(   Building.WALL, R.drawable.magic_tower_building_wall));
//        row4.add(new CaseBean(   Building.ROAD, R.drawable.magic_tower_building_road));
//        row4.add(new CaseBean(   Building.WALL, R.drawable.magic_tower_building_wall));
//        row4.add(new CaseBean(   Prop.XIE_PING_SMALL, R.drawable.magic_tower_prop_blood_bottle_small));
//        row4.add(new CaseBean(   Building.WALL, R.drawable.magic_tower_building_wall));
//        row4.add(new CaseBean(   Npc.GO_UPSTAIRS, R.drawable.magic_tower_npc_go_upstairs));
//        row4.add(new CaseBean(   Building.ROAD, R.drawable.magic_tower_building_road));
//        row4.add(new CaseBean(   Building.ROAD, R.drawable.magic_tower_building_road));
//        row4.add(new CaseBean(   Building.WALL, R.drawable.magic_tower_building_wall));
//        row4.add(new CaseBean(   Monster.QING_TOU_GUAI, R.drawable.magic_tower_monster_qing_tou_guai));
//        floor8.add(row4);
//
//        List<CaseBean> row5 = new ArrayList<>();
//        row5.add(new CaseBean(   Monster.HONG_BIAN_FU, R.drawable.magic_tower_monster_hong_bian_fu));
//        row5.add(new CaseBean(   Building.WALL, R.drawable.magic_tower_building_wall));
//        row5.add(new CaseBean(   Prop.BAO_SHI_BLUE, R.drawable.magic_tower_prop_gem_blue));
//        row5.add(new CaseBean(   Building.WALL, R.drawable.magic_tower_building_wall));
//        row5.add(new CaseBean(   Prop.XIE_PING_SMALL, R.drawable.magic_tower_prop_blood_bottle_small));
//        row5.add(new CaseBean(   Building.WALL, R.drawable.magic_tower_building_wall));
//        row5.add(new CaseBean(   Building.WALL, R.drawable.magic_tower_building_wall));
//        row5.add(new CaseBean(   Building.WALL, R.drawable.magic_tower_building_wall));
//        row5.add(new CaseBean(   Building.WALL, R.drawable.magic_tower_building_wall));
//        row5.add(new CaseBean(   Building.WALL, R.drawable.magic_tower_building_wall));
//        row5.add(new CaseBean(   Building.ROAD, R.drawable.magic_tower_building_road));
//        floor8.add(row5);
//
//        List<CaseBean> row6 = new ArrayList<>();
//        row6.add(new CaseBean(   Monster.DA_BIAN_FU, R.drawable.magic_tower_monster_da_bian_fu));
//        row6.add(new CaseBean(   Building.WALL, R.drawable.magic_tower_building_wall));
//        row6.add(new CaseBean(   Monster.QING_TOU_GUAI, R.drawable.magic_tower_monster_qing_tou_guai));
//        row6.add(new CaseBean(   Building.WALL, R.drawable.magic_tower_building_wall));
//        row6.add(new CaseBean(   Building.ROAD, R.drawable.magic_tower_building_road));
//        row6.add(new CaseBean(   Building.ROAD, R.drawable.magic_tower_building_road));
//        row6.add(new CaseBean(   Building.ROAD, R.drawable.magic_tower_building_road));
//        row6.add(new CaseBean(   Building.WALL, R.drawable.magic_tower_building_wall));
//        row6.add(new CaseBean(   Building.ROAD, R.drawable.magic_tower_building_road));
//        row6.add(new CaseBean(   Monster.HONG_BIAN_FU, R.drawable.magic_tower_monster_hong_bian_fu));
//        row6.add(new CaseBean(   Building.ROAD, R.drawable.magic_tower_building_road));
//        floor8.add(row6);
//
//        List<CaseBean> row7 = new ArrayList<>();
//        row7.add(new CaseBean(   Building.ROAD, R.drawable.magic_tower_building_road));
//        row7.add(new CaseBean(   Building.WALL, R.drawable.magic_tower_building_wall));
//        row7.add(new CaseBean(   Monster.QING_TOU_GUAI, R.drawable.magic_tower_monster_qing_tou_guai));
//        row7.add(new CaseBean(   Building.WALL, R.drawable.magic_tower_building_wall));
//        row7.add(new CaseBean(   Building.WALL, R.drawable.magic_tower_building_wall));
//        row7.add(new CaseBean(   Building.WALL, R.drawable.magic_tower_building_wall));
//        row7.add(new CaseBean(   Monster.CHU_JI_WEI_BING, R.drawable.magic_tower_monster_chu_ji_wei_bing));
//        row7.add(new CaseBean(   Building.WALL, R.drawable.magic_tower_building_wall));
//        row7.add(new CaseBean(   Npc.GATE_YELLOW, R.drawable.magic_tower_npc_gate_yellow_1));
//        row7.add(new CaseBean(   Building.WALL, R.drawable.magic_tower_building_wall));
//        row7.add(new CaseBean(   Building.WALL, R.drawable.magic_tower_building_wall));
//        floor8.add(row7);
//
//        List<CaseBean> row8 = new ArrayList<>();
//        row8.add(new CaseBean(   Building.ROAD, R.drawable.magic_tower_building_road));
//        row8.add(new CaseBean(   Building.WALL, R.drawable.magic_tower_building_wall));
//        row8.add(new CaseBean(   Building.ROAD, R.drawable.magic_tower_building_road));
//        row8.add(new CaseBean(   Monster.KU_LOU_DUI_ZHANG, R.drawable.magic_tower_monster_ku_lou_dui_zhang));
//        row8.add(new CaseBean(   Building.ROAD, R.drawable.magic_tower_building_road));
//        row8.add(new CaseBean(   Building.WALL, R.drawable.magic_tower_building_wall));
//        row8.add(new CaseBean(   Monster.KU_LOU_DUI_ZHANG, R.drawable.magic_tower_monster_ku_lou_dui_zhang));
//        row8.add(new CaseBean(   Building.WALL, R.drawable.magic_tower_building_wall));
//        row8.add(new CaseBean(   Building.ROAD, R.drawable.magic_tower_building_road));
//        row8.add(new CaseBean(   Building.ROAD, R.drawable.magic_tower_building_road));
//        row8.add(new CaseBean(   Building.ROAD, R.drawable.magic_tower_building_road));
//        floor8.add(row8);
//
//        List<CaseBean> row9 = new ArrayList<>();
//        row9.add(new CaseBean(   Building.ROAD, R.drawable.magic_tower_building_road));
//        row9.add(new CaseBean(   Building.WALL, R.drawable.magic_tower_building_wall));
//        row9.add(new CaseBean(   Building.WALL, R.drawable.magic_tower_building_wall));
//        row9.add(new CaseBean(   Building.WALL, R.drawable.magic_tower_building_wall));
//        row9.add(new CaseBean(   Npc.GATE_YELLOW, R.drawable.magic_tower_npc_gate_yellow_1));
//        row9.add(new CaseBean(   Building.WALL, R.drawable.magic_tower_building_wall));
//        row9.add(new CaseBean(   Building.ROAD, R.drawable.magic_tower_building_road));
//        row9.add(new CaseBean(   Building.WALL, R.drawable.magic_tower_building_wall));
//        row9.add(new CaseBean(   Building.WALL, R.drawable.magic_tower_building_wall));
//        row9.add(new CaseBean(   Building.WALL, R.drawable.magic_tower_building_wall));
//        row9.add(new CaseBean(   Building.ROAD, R.drawable.magic_tower_building_road));
//        floor8.add(row9);
//
//        List<CaseBean> row10 = new ArrayList<>();
//        row10.add(new CaseBean(   Building.ROAD, R.drawable.magic_tower_building_road));
//        row10.add(new CaseBean(   Building.ROAD, R.drawable.magic_tower_building_road));
//        row10.add(new CaseBean(   Monster.MA_YI_FA_SHI, R.drawable.magic_tower_monster_ma_yi_fa_shi));
//        row10.add(new CaseBean(   Building.ROAD, R.drawable.magic_tower_building_road));
//        row10.add(new CaseBean(   Building.ROAD, R.drawable.magic_tower_building_road));
//        row10.add(new CaseBean(   Building.WALL, R.drawable.magic_tower_building_wall));
//        row10.add(new CaseBean(   Building.ROAD, R.drawable.magic_tower_building_road));
//        row10.add(new CaseBean(   Monster.GUAI_WANG, R.drawable.magic_tower_monster_guai_wang));
//        row10.add(new CaseBean(   Monster.BAI_YI_WU_SHI, R.drawable.magic_tower_monster_bai_yi_wu_shi));
//        row10.add(new CaseBean(   Monster.GUAI_WANG, R.drawable.magic_tower_monster_guai_wang));
//        row10.add(new CaseBean(   Building.ROAD, R.drawable.magic_tower_building_road));
//        floor8.add(row10);

        return floor8;
    }

    @Override
    public void fromUpstairsToThisFloor() {
        resetWarriorPosition( new Position(4, 7));
    }

    @Override
    public void fromDownstairsToThisFloor() {
        resetWarriorPosition(new Position(1, 0));
    }
}
