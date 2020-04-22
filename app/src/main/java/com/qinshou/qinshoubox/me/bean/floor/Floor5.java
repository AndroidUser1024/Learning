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
 * Description:第 5 层
 * Created by 禽兽先生
 * Created on 2017/4/26
 */

public class Floor5 extends AbsFloor {

    @Override
    public int getFloor() {
        return 5;
    }

    @Override
    public List<List<CaseBean>> setData() {
        List<List<CaseBean>> floor5 = new ArrayList<>();
        List<CaseBean> row0 = new ArrayList<>();
        row0.add(new CaseBean(Prop.YAO_SHI_HE, R.drawable.magic_tower_prop_yao_shi_he));
        row0.add(new CaseBean(Building.WALL, R.drawable.magic_tower_building_wall));
        row0.add(new CaseBean(Prop.XIE_PING_SMALL, R.drawable.magic_tower_prop_xie_ping_small));
        row0.add(new CaseBean(Building.WALL, R.drawable.magic_tower_building_wall));
        row0.add(new CaseBean(Prop.XIE_PING_BIG, R.drawable.magic_tower_prop_xie_ping_big));
        row0.add(new CaseBean(Monster.CHU_JI_FA_SHI, R.drawable.magic_tower_monster_chu_ji_fa_shi));
        row0.add(new CaseBean(Building.ROAD, R.drawable.magic_tower_building_road));
        row0.add(new CaseBean(Building.ROAD, R.drawable.magic_tower_building_road));
        row0.add(new CaseBean(Monster.CHU_JI_FA_SHI, R.drawable.magic_tower_monster_chu_ji_fa_shi));
        row0.add(new CaseBean(Prop.KEY_YELLOW, R.drawable.magic_tower_prop_key_yellow));
        row0.add(new CaseBean(Prop.KEY_BLUE, R.drawable.magic_tower_prop_key_blue));
        floor5.add(row0);

        List<CaseBean> row1 = new ArrayList<>();
        row1.add(new CaseBean(Building.ROAD, R.drawable.magic_tower_building_road));
        row1.add(new CaseBean(Building.WALL, R.drawable.magic_tower_building_wall));
        row1.add(new CaseBean(Prop.BAO_SHI_RED, R.drawable.magic_tower_prop_bao_shi_red));
        row1.add(new CaseBean(Building.WALL, R.drawable.magic_tower_building_wall));
        row1.add(new CaseBean(Monster.CHU_JI_FA_SHI, R.drawable.magic_tower_monster_chu_ji_fa_shi));
        row1.add(new CaseBean(Building.ROAD, R.drawable.magic_tower_building_road));
        row1.add(new CaseBean(Building.ROAD, R.drawable.magic_tower_building_road));
        row1.add(new CaseBean(Building.ROAD, R.drawable.magic_tower_building_road));
        row1.add(new CaseBean(Building.ROAD, R.drawable.magic_tower_building_road));
        row1.add(new CaseBean(Monster.CHU_JI_FA_SHI, R.drawable.magic_tower_monster_chu_ji_fa_shi));
        row1.add(new CaseBean(Prop.KEY_YELLOW, R.drawable.magic_tower_prop_key_yellow));
        floor5.add(row1);

        List<CaseBean> row2 = new ArrayList<>();
        row2.add(new CaseBean(Monster.DA_BIAN_FU, R.drawable.magic_tower_monster_da_bian_fu));
        row2.add(new CaseBean(Building.WALL, R.drawable.magic_tower_building_wall));
        row2.add(new CaseBean(Building.ROAD, R.drawable.magic_tower_building_road));
        row2.add(new CaseBean(Building.WALL, R.drawable.magic_tower_building_wall));
        row2.add(new CaseBean(Monster.KU_LOU_SHI_BING, R.drawable.magic_tower_monster_ku_lou_shi_bing));
        row2.add(new CaseBean(Building.ROAD, R.drawable.magic_tower_building_road));
        row2.add(new CaseBean(Building.WALL, R.drawable.magic_tower_building_wall));
        row2.add(new CaseBean(Building.WALL, R.drawable.magic_tower_building_wall));
        row2.add(new CaseBean(Npc.GATE_YELLOW, R.drawable.magic_tower_npc_gate_yellow_1));
        row2.add(new CaseBean(Building.WALL, R.drawable.magic_tower_building_wall));
        row2.add(new CaseBean(Building.WALL, R.drawable.magic_tower_building_wall));
        floor5.add(row2);

        List<CaseBean> row3 = new ArrayList<>();
        row3.add(new CaseBean(Building.ROAD, R.drawable.magic_tower_building_road));
        row3.add(new CaseBean(Npc.GATE_YELLOW, R.drawable.magic_tower_npc_gate_yellow_1));
        row3.add(new CaseBean(Monster.CHU_JI_FA_SHI, R.drawable.magic_tower_monster_chu_ji_fa_shi));
        row3.add(new CaseBean(Building.WALL, R.drawable.magic_tower_building_wall));
        row3.add(new CaseBean(Prop.TIE_DUN, R.drawable.magic_tower_prop_tie_dun));
        row3.add(new CaseBean(Monster.KU_LOU_SHI_BING, R.drawable.magic_tower_monster_ku_lou_shi_bing));
        row3.add(new CaseBean(Building.WALL, R.drawable.magic_tower_building_wall));
        row3.add(new CaseBean(Building.ROAD, R.drawable.magic_tower_building_road));
        row3.add(new CaseBean(Monster.SHOU_MIAN_REN, R.drawable.magic_tower_monster_shou_mian_ren));
        row3.add(new CaseBean(Monster.KU_LOU_SHI_BING, R.drawable.magic_tower_monster_ku_lou_shi_bing));
        row3.add(new CaseBean(Npc.SHANG_REN_FLOOR_5, R.drawable.magic_tower_npc_shang_ren));
        floor5.add(row3);

        List<CaseBean> row4 = new ArrayList<>();
        row4.add(new CaseBean(Monster.DA_BIAN_FU, R.drawable.magic_tower_monster_da_bian_fu));
        row4.add(new CaseBean(Building.WALL, R.drawable.magic_tower_building_wall));
        row4.add(new CaseBean(Building.ROAD, R.drawable.magic_tower_building_road));
        row4.add(new CaseBean(Building.WALL, R.drawable.magic_tower_building_wall));
        row4.add(new CaseBean(Building.WALL, R.drawable.magic_tower_building_wall));
        row4.add(new CaseBean(Building.WALL, R.drawable.magic_tower_building_wall));
        row4.add(new CaseBean(Building.WALL, R.drawable.magic_tower_building_wall));
        row4.add(new CaseBean(Building.ROAD, R.drawable.magic_tower_building_road));
        row4.add(new CaseBean(Building.ROAD, R.drawable.magic_tower_building_road));
        row4.add(new CaseBean(Building.ROAD, R.drawable.magic_tower_building_road));
        row4.add(new CaseBean(Monster.KU_LOU_SHI_BING, R.drawable.magic_tower_monster_ku_lou_shi_bing));
        floor5.add(row4);

        List<CaseBean> row5 = new ArrayList<>();
        row5.add(new CaseBean(Prop.BAO_SHI_RED, R.drawable.magic_tower_prop_bao_shi_red));
        row5.add(new CaseBean(Building.WALL, R.drawable.magic_tower_building_wall));
        row5.add(new CaseBean(Building.ROAD, R.drawable.magic_tower_building_road));
        row5.add(new CaseBean(Building.ROAD, R.drawable.magic_tower_building_road));
        row5.add(new CaseBean(Building.ROAD, R.drawable.magic_tower_building_road));
        row5.add(new CaseBean(Monster.XIAO_BIAN_FU, R.drawable.magic_tower_monster_xiao_bian_fu));
        row5.add(new CaseBean(Monster.KU_LOU_REN, R.drawable.magic_tower_monster_ku_lou_ren));
        row5.add(new CaseBean(Building.ROAD, R.drawable.magic_tower_building_road));
        row5.add(new CaseBean(Building.ROAD, R.drawable.magic_tower_building_road));
        row5.add(new CaseBean(Building.ROAD, R.drawable.magic_tower_building_road));
        row5.add(new CaseBean(Building.ROAD, R.drawable.magic_tower_building_road));
        floor5.add(row5);

        List<CaseBean> row6 = new ArrayList<>();
        row6.add(new CaseBean(Prop.BAO_SHI_BLUE, R.drawable.magic_tower_prop_bao_shi_blue));
        row6.add(new CaseBean(Building.WALL, R.drawable.magic_tower_building_wall));
        row6.add(new CaseBean(Building.WALL, R.drawable.magic_tower_building_wall));
        row6.add(new CaseBean(Monster.QING_TOU_GUAI, R.drawable.magic_tower_monster_qing_tou_guai));
        row6.add(new CaseBean(Building.WALL, R.drawable.magic_tower_building_wall));
        row6.add(new CaseBean(Building.WALL, R.drawable.magic_tower_building_wall));
        row6.add(new CaseBean(Building.WALL, R.drawable.magic_tower_building_wall));
        row6.add(new CaseBean(Building.WALL, R.drawable.magic_tower_building_wall));
        row6.add(new CaseBean(Building.ROAD, R.drawable.magic_tower_building_road));
        row6.add(new CaseBean(Building.ROAD, R.drawable.magic_tower_building_road));
        row6.add(new CaseBean(Building.ROAD, R.drawable.magic_tower_building_road));
        floor5.add(row6);

        List<CaseBean> row7 = new ArrayList<>();
        row7.add(new CaseBean(Building.ROAD, R.drawable.magic_tower_building_road));
        row7.add(new CaseBean(Npc.SHEN_MI_LAO_REN_FLOOR_5, R.drawable.magic_tower_npc_shen_mi_lao_ren));
        row7.add(new CaseBean(Building.WALL, R.drawable.magic_tower_building_wall));
        row7.add(new CaseBean(Monster.QING_TOU_GUAI, R.drawable.magic_tower_monster_qing_tou_guai));
        row7.add(new CaseBean(Building.WALL, R.drawable.magic_tower_building_wall));
        row7.add(new CaseBean(Building.ROAD, R.drawable.magic_tower_building_road));
        row7.add(new CaseBean(Building.ROAD, R.drawable.magic_tower_building_road));
        row7.add(new CaseBean(Building.ROAD, R.drawable.magic_tower_building_road));
        row7.add(new CaseBean(Monster.SHOU_MIAN_REN, R.drawable.magic_tower_monster_shou_mian_ren));
        row7.add(new CaseBean(Monster.CHU_JI_WEI_BING, R.drawable.magic_tower_monster_chu_ji_wei_bing));
        row7.add(new CaseBean(Building.ROAD, R.drawable.magic_tower_building_road));
        floor5.add(row7);

        List<CaseBean> row8 = new ArrayList<>();
        row8.add(new CaseBean(Building.WALL, R.drawable.magic_tower_building_wall));
        row8.add(new CaseBean(Building.WALL, R.drawable.magic_tower_building_wall));
        row8.add(new CaseBean(Building.WALL, R.drawable.magic_tower_building_wall));
        row8.add(new CaseBean(Monster.XIAO_BIAN_FU, R.drawable.magic_tower_monster_xiao_bian_fu));
        row8.add(new CaseBean(Building.WALL, R.drawable.magic_tower_building_wall));
        row8.add(new CaseBean(Npc.GATE_YELLOW, R.drawable.magic_tower_npc_gate_yellow_1));
        row8.add(new CaseBean(Building.WALL, R.drawable.magic_tower_building_wall));
        row8.add(new CaseBean(Npc.GATE_BLUE, R.drawable.magic_tower_npc_gate_blue_1));
        row8.add(new CaseBean(Building.WALL, R.drawable.magic_tower_building_wall));
        row8.add(new CaseBean(Npc.GATE_YELLOW, R.drawable.magic_tower_npc_gate_yellow_1));
        row8.add(new CaseBean(Building.WALL, R.drawable.magic_tower_building_wall));
        floor5.add(row8);

        List<CaseBean> row9 = new ArrayList<>();
        row9.add(new CaseBean(Building.ROAD, R.drawable.magic_tower_building_road));
        row9.add(new CaseBean(Building.ROAD, R.drawable.magic_tower_building_road));
        row9.add(new CaseBean(Building.WALL, R.drawable.magic_tower_building_wall));
        row9.add(new CaseBean(Building.ROAD, R.drawable.magic_tower_building_road));
        row9.add(new CaseBean(Building.WALL, R.drawable.magic_tower_building_wall));
        row9.add(new CaseBean(Monster.XIAO_BIAN_FU, R.drawable.magic_tower_monster_xiao_bian_fu));
        row9.add(new CaseBean(Building.WALL, R.drawable.magic_tower_building_wall));
        row9.add(new CaseBean(Prop.BAO_SHI_BLUE, R.drawable.magic_tower_prop_bao_shi_blue));
        row9.add(new CaseBean(Npc.GATE_YELLOW, R.drawable.magic_tower_npc_gate_yellow_1));
        row9.add(new CaseBean(Building.ROAD, R.drawable.magic_tower_building_road));
        row9.add(new CaseBean(Building.WALL, R.drawable.magic_tower_building_wall));
        floor5.add(row9);

        List<CaseBean> row10 = new ArrayList<>();
        row10.add(new CaseBean(Npc.GO_DOWNSTAIRS, R.drawable.magic_tower_npc_go_downstairs));
        row10.add(new CaseBean(Building.ROAD, R.drawable.magic_tower_building_road));
        row10.add(new CaseBean(Monster.XIAO_BIAN_FU, R.drawable.magic_tower_monster_xiao_bian_fu));
        row10.add(new CaseBean(Building.ROAD, R.drawable.magic_tower_building_road));
        row10.add(new CaseBean(Building.ROAD, R.drawable.magic_tower_building_road));
        row10.add(new CaseBean(Building.ROAD, R.drawable.magic_tower_building_road));
        row10.add(new CaseBean(Building.WALL, R.drawable.magic_tower_building_wall));
        row10.add(new CaseBean(Prop.KEY_YELLOW, R.drawable.magic_tower_prop_key_yellow));
        row10.add(new CaseBean(Building.WALL, R.drawable.magic_tower_building_wall));
        row10.add(new CaseBean(Npc.GO_UPSTAIRS, R.drawable.magic_tower_npc_go_upstairs));
        row10.add(new CaseBean(Building.WALL, R.drawable.magic_tower_building_wall));
        floor5.add(row10);

        return floor5;
    }

    @Override
    public void fromUpstairsToThisFloor() {
        resetWarriorPosition(9, 9);
    }

    @Override
    public void fromDownstairsToThisFloor() {
        resetWarriorPosition(9, 0);
    }
}
