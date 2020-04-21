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
        List<CaseBean> row0 = new ArrayList<>();
        row0.add(new CaseBean(8, 0, 0, Npc.GO_DOWNSTAIRS, R.drawable.magic_tower_npc_go_downstairs));
        row0.add(new CaseBean(8, 0, 1, Building.WALL, R.drawable.magic_tower_building_wall));
        row0.add(new CaseBean(8, 0, 2, Building.ROAD, R.drawable.magic_tower_building_road));
        row0.add(new CaseBean(8, 0, 3, Building.ROAD, R.drawable.magic_tower_building_road));
        row0.add(new CaseBean(8, 0, 4, Building.ROAD, R.drawable.magic_tower_building_road));
        row0.add(new CaseBean(8, 0, 5, Building.ROAD, R.drawable.magic_tower_building_road));
        row0.add(new CaseBean(8, 0, 6, Building.WALL, R.drawable.magic_tower_building_wall));
        row0.add(new CaseBean(8, 0, 7, Building.ROAD, R.drawable.magic_tower_building_road));
        row0.add(new CaseBean(8, 0, 8, Prop.KEY_YELLOW, R.drawable.magic_tower_prop_key_yellow));
        row0.add(new CaseBean(8, 0, 9, Monster.KU_LOU_DUI_ZHANG, R.drawable.magic_tower_monster_ku_lou_dui_zhang));
        row0.add(new CaseBean(8, 0, 10, Building.ROAD, R.drawable.magic_tower_building_road));
        floor8.add(row0);

        List<CaseBean> row1 = new ArrayList<>();
        row1.add(new CaseBean(8, 1, 0, Building.ROAD, R.drawable.magic_tower_building_road));
        row1.add(new CaseBean(8, 1, 1, Building.WALL, R.drawable.magic_tower_building_wall));
        row1.add(new CaseBean(8, 1, 2, Building.ROAD, R.drawable.magic_tower_building_road));
        row1.add(new CaseBean(8, 1, 3, Building.WALL, R.drawable.magic_tower_building_wall));
        row1.add(new CaseBean(8, 1, 4, Building.WALL, R.drawable.magic_tower_building_wall));
        row1.add(new CaseBean(8, 1, 5, Npc.GATE_YELLOW, R.drawable.magic_tower_npc_gate_yellow_1));
        row1.add(new CaseBean(8, 1, 6, Building.WALL, R.drawable.magic_tower_building_wall));
        row1.add(new CaseBean(8, 1, 7, Npc.GATE_YELLOW, R.drawable.magic_tower_npc_gate_yellow_1));
        row1.add(new CaseBean(8, 1, 8, Building.WALL, R.drawable.magic_tower_building_wall));
        row1.add(new CaseBean(8, 1, 9, Building.WALL, R.drawable.magic_tower_building_wall));
        row1.add(new CaseBean(8, 1, 10, Building.ROAD, R.drawable.magic_tower_building_road));
        floor8.add(row1);

        List<CaseBean> row2 = new ArrayList<>();
        row2.add(new CaseBean(8, 2, 0, Building.ROAD, R.drawable.magic_tower_building_road));
        row2.add(new CaseBean(8, 2, 1, Building.WALL, R.drawable.magic_tower_building_wall));
        row2.add(new CaseBean(8, 2, 2, Building.ROAD, R.drawable.magic_tower_building_road));
        row2.add(new CaseBean(8, 2, 3, Building.WALL, R.drawable.magic_tower_building_wall));
        row2.add(new CaseBean(8, 2, 4, Building.ROAD, R.drawable.magic_tower_building_road));
        row2.add(new CaseBean(8, 2, 5, Building.ROAD, R.drawable.magic_tower_building_road));
        row2.add(new CaseBean(8, 2, 6, Npc.GATE_BLUE, R.drawable.magic_tower_npc_gate_blue_1));
        row2.add(new CaseBean(8, 2, 7, Building.ROAD, R.drawable.magic_tower_building_road));
        row2.add(new CaseBean(8, 2, 8, Building.ROAD, R.drawable.magic_tower_building_road));
        row2.add(new CaseBean(8, 2, 9, Building.WALL, R.drawable.magic_tower_building_wall));
        row2.add(new CaseBean(8, 2, 10, Prop.BAO_SHI_RED, R.drawable.magic_tower_prop_bao_shi_red));
        floor8.add(row2);

        List<CaseBean> row3 = new ArrayList<>();
        row3.add(new CaseBean(8, 3, 0, Building.ROAD, R.drawable.magic_tower_building_road));
        row3.add(new CaseBean(8, 3, 1, Building.WALL, R.drawable.magic_tower_building_wall));
        row3.add(new CaseBean(8, 3, 2, Building.ROAD, R.drawable.magic_tower_building_road));
        row3.add(new CaseBean(8, 3, 3, Building.WALL, R.drawable.magic_tower_building_wall));
        row3.add(new CaseBean(8, 3, 4, Monster.MA_YI_FA_SHI, R.drawable.magic_tower_monster_ma_yi_fa_shi));
        row3.add(new CaseBean(8, 3, 5, Building.WALL, R.drawable.magic_tower_building_wall));
        row3.add(new CaseBean(8, 3, 6, Building.WALL, R.drawable.magic_tower_building_wall));
        row3.add(new CaseBean(8, 3, 7, Building.WALL, R.drawable.magic_tower_building_wall));
        row3.add(new CaseBean(8, 3, 8, Monster.DA_BIAN_FU, R.drawable.magic_tower_monster_da_bian_fu));
        row3.add(new CaseBean(8, 3, 9, Building.WALL, R.drawable.magic_tower_building_wall));
        row3.add(new CaseBean(8, 3, 10, Monster.QING_TOU_GUAI, R.drawable.magic_tower_monster_qing_tou_guai));
        floor8.add(row3);

        List<CaseBean> row4 = new ArrayList<>();
        row4.add(new CaseBean(8, 4, 0, Monster.DA_BIAN_FU, R.drawable.magic_tower_monster_da_bian_fu));
        row4.add(new CaseBean(8, 4, 1, Building.WALL, R.drawable.magic_tower_building_wall));
        row4.add(new CaseBean(8, 4, 2, Building.ROAD, R.drawable.magic_tower_building_road));
        row4.add(new CaseBean(8, 4, 3, Building.WALL, R.drawable.magic_tower_building_wall));
        row4.add(new CaseBean(8, 4, 4, Prop.XIE_PING_SMALL, R.drawable.magic_tower_prop_xie_ping_small));
        row4.add(new CaseBean(8, 4, 5, Building.WALL, R.drawable.magic_tower_building_wall));
        row4.add(new CaseBean(8, 4, 6, Npc.GO_UPSTAIRS, R.drawable.magic_tower_npc_go_upstairs));
        row4.add(new CaseBean(8, 4, 7, Building.ROAD, R.drawable.magic_tower_building_road));
        row4.add(new CaseBean(8, 4, 8, Building.ROAD, R.drawable.magic_tower_building_road));
        row4.add(new CaseBean(8, 4, 9, Building.WALL, R.drawable.magic_tower_building_wall));
        row4.add(new CaseBean(8, 4, 10, Monster.QING_TOU_GUAI, R.drawable.magic_tower_monster_qing_tou_guai));
        floor8.add(row4);

        List<CaseBean> row5 = new ArrayList<>();
        row5.add(new CaseBean(8, 5, 0, Monster.HONG_BIAN_FU, R.drawable.magic_tower_monster_hong_bian_fu));
        row5.add(new CaseBean(8, 5, 1, Building.WALL, R.drawable.magic_tower_building_wall));
        row5.add(new CaseBean(8, 5, 2, Prop.BAO_SHI_BLUE, R.drawable.magic_tower_prop_bao_shi_blue));
        row5.add(new CaseBean(8, 5, 3, Building.WALL, R.drawable.magic_tower_building_wall));
        row5.add(new CaseBean(8, 5, 4, Prop.XIE_PING_SMALL, R.drawable.magic_tower_prop_xie_ping_small));
        row5.add(new CaseBean(8, 5, 5, Building.WALL, R.drawable.magic_tower_building_wall));
        row5.add(new CaseBean(8, 5, 6, Building.WALL, R.drawable.magic_tower_building_wall));
        row5.add(new CaseBean(8, 5, 7, Building.WALL, R.drawable.magic_tower_building_wall));
        row5.add(new CaseBean(8, 5, 8, Building.WALL, R.drawable.magic_tower_building_wall));
        row5.add(new CaseBean(8, 5, 9, Building.WALL, R.drawable.magic_tower_building_wall));
        row5.add(new CaseBean(8, 5, 10, Building.ROAD, R.drawable.magic_tower_building_road));
        floor8.add(row5);

        List<CaseBean> row6 = new ArrayList<>();
        row6.add(new CaseBean(8, 6, 0, Monster.DA_BIAN_FU, R.drawable.magic_tower_monster_da_bian_fu));
        row6.add(new CaseBean(8, 6, 1, Building.WALL, R.drawable.magic_tower_building_wall));
        row6.add(new CaseBean(8, 6, 2, Monster.QING_TOU_GUAI, R.drawable.magic_tower_monster_qing_tou_guai));
        row6.add(new CaseBean(8, 6, 3, Building.WALL, R.drawable.magic_tower_building_wall));
        row6.add(new CaseBean(8, 6, 4, Building.ROAD, R.drawable.magic_tower_building_road));
        row6.add(new CaseBean(8, 6, 5, Building.ROAD, R.drawable.magic_tower_building_road));
        row6.add(new CaseBean(8, 6, 6, Building.ROAD, R.drawable.magic_tower_building_road));
        row6.add(new CaseBean(8, 6, 7, Building.WALL, R.drawable.magic_tower_building_wall));
        row6.add(new CaseBean(8, 6, 8, Building.ROAD, R.drawable.magic_tower_building_road));
        row6.add(new CaseBean(8, 6, 9, Monster.HONG_BIAN_FU, R.drawable.magic_tower_monster_hong_bian_fu));
        row6.add(new CaseBean(8, 6, 10, Building.ROAD, R.drawable.magic_tower_building_road));
        floor8.add(row6);

        List<CaseBean> row7 = new ArrayList<>();
        row7.add(new CaseBean(8, 7, 0, Building.ROAD, R.drawable.magic_tower_building_road));
        row7.add(new CaseBean(8, 7, 1, Building.WALL, R.drawable.magic_tower_building_wall));
        row7.add(new CaseBean(8, 7, 2, Monster.QING_TOU_GUAI, R.drawable.magic_tower_monster_qing_tou_guai));
        row7.add(new CaseBean(8, 7, 3, Building.WALL, R.drawable.magic_tower_building_wall));
        row7.add(new CaseBean(8, 7, 4, Building.WALL, R.drawable.magic_tower_building_wall));
        row7.add(new CaseBean(8, 7, 5, Building.WALL, R.drawable.magic_tower_building_wall));
        row7.add(new CaseBean(8, 7, 6, Monster.CHU_JI_WEI_BING, R.drawable.magic_tower_monster_chu_ji_wei_bing));
        row7.add(new CaseBean(8, 7, 7, Building.WALL, R.drawable.magic_tower_building_wall));
        row7.add(new CaseBean(8, 7, 8, Npc.GATE_YELLOW, R.drawable.magic_tower_npc_gate_yellow_1));
        row7.add(new CaseBean(8, 7, 9, Building.WALL, R.drawable.magic_tower_building_wall));
        row7.add(new CaseBean(8, 7, 10, Building.WALL, R.drawable.magic_tower_building_wall));
        floor8.add(row7);

        List<CaseBean> row8 = new ArrayList<>();
        row8.add(new CaseBean(8, 8, 0, Building.ROAD, R.drawable.magic_tower_building_road));
        row8.add(new CaseBean(8, 8, 1, Building.WALL, R.drawable.magic_tower_building_wall));
        row8.add(new CaseBean(8, 8, 2, Building.ROAD, R.drawable.magic_tower_building_road));
        row8.add(new CaseBean(8, 8, 3, Monster.KU_LOU_DUI_ZHANG, R.drawable.magic_tower_monster_ku_lou_dui_zhang));
        row8.add(new CaseBean(8, 8, 4, Building.ROAD, R.drawable.magic_tower_building_road));
        row8.add(new CaseBean(8, 8, 5, Building.WALL, R.drawable.magic_tower_building_wall));
        row8.add(new CaseBean(8, 8, 6, Monster.KU_LOU_DUI_ZHANG, R.drawable.magic_tower_monster_ku_lou_dui_zhang));
        row8.add(new CaseBean(8, 8, 7, Building.WALL, R.drawable.magic_tower_building_wall));
        row8.add(new CaseBean(8, 8, 8, Building.ROAD, R.drawable.magic_tower_building_road));
        row8.add(new CaseBean(8, 8, 9, Building.ROAD, R.drawable.magic_tower_building_road));
        row8.add(new CaseBean(8, 8, 10, Building.ROAD, R.drawable.magic_tower_building_road));
        floor8.add(row8);

        List<CaseBean> row9 = new ArrayList<>();
        row9.add(new CaseBean(8, 9, 0, Building.ROAD, R.drawable.magic_tower_building_road));
        row9.add(new CaseBean(8, 9, 1, Building.WALL, R.drawable.magic_tower_building_wall));
        row9.add(new CaseBean(8, 9, 2, Building.WALL, R.drawable.magic_tower_building_wall));
        row9.add(new CaseBean(8, 9, 3, Building.WALL, R.drawable.magic_tower_building_wall));
        row9.add(new CaseBean(8, 9, 4, Npc.GATE_YELLOW, R.drawable.magic_tower_npc_gate_yellow_1));
        row9.add(new CaseBean(8, 9, 5, Building.WALL, R.drawable.magic_tower_building_wall));
        row9.add(new CaseBean(8, 9, 6, Building.ROAD, R.drawable.magic_tower_building_road));
        row9.add(new CaseBean(8, 9, 7, Building.WALL, R.drawable.magic_tower_building_wall));
        row9.add(new CaseBean(8, 9, 8, Building.WALL, R.drawable.magic_tower_building_wall));
        row9.add(new CaseBean(8, 9, 9, Building.WALL, R.drawable.magic_tower_building_wall));
        row9.add(new CaseBean(8, 9, 10, Building.ROAD, R.drawable.magic_tower_building_road));
        floor8.add(row9);

        List<CaseBean> row10 = new ArrayList<>();
        row10.add(new CaseBean(8, 10, 0, Building.ROAD, R.drawable.magic_tower_building_road));
        row10.add(new CaseBean(8, 10, 1, Building.ROAD, R.drawable.magic_tower_building_road));
        row10.add(new CaseBean(8, 10, 2, Monster.MA_YI_FA_SHI, R.drawable.magic_tower_monster_ma_yi_fa_shi));
        row10.add(new CaseBean(8, 10, 3, Building.ROAD, R.drawable.magic_tower_building_road));
        row10.add(new CaseBean(8, 10, 4, Building.ROAD, R.drawable.magic_tower_building_road));
        row10.add(new CaseBean(8, 10, 5, Building.WALL, R.drawable.magic_tower_building_wall));
        row10.add(new CaseBean(8, 10, 6, Building.ROAD, R.drawable.magic_tower_building_road));
        row10.add(new CaseBean(8, 10, 7, Monster.GUAI_WANG, R.drawable.magic_tower_monster_guai_wang));
        row10.add(new CaseBean(8, 10, 8, Monster.BAI_YI_WU_SHI, R.drawable.magic_tower_monster_bai_yi_wu_shi));
        row10.add(new CaseBean(8, 10, 9, Monster.GUAI_WANG, R.drawable.magic_tower_monster_guai_wang));
        row10.add(new CaseBean(8, 10, 10, Building.ROAD, R.drawable.magic_tower_building_road));
        floor8.add(row10);

        return floor8;
    }

    @Override
    public void fromUpstairsToThisFloor() {
        resetWarriorPosition(4, 7);
    }

    @Override
    public void fromDownstairsToThisFloor() {
        resetWarriorPosition(1, 0);
    }
}
