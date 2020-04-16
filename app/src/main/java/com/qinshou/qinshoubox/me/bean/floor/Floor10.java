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
 * Description:第 10 层
 * Created by 禽兽先生
 * Created on 2017/4/26
 */

public class Floor10 extends AFloor {

    @Override
    public int getFloor() {
        return 10;
    }

    @Override
    public List<List<CaseBean>> setData() {
        List<List<CaseBean>> floor10 = new ArrayList<>();
        List<CaseBean> row0 = new ArrayList<>();
        row0.add(new CaseBean(10, 0, 0, Building.ROAD, R.drawable.magic_tower_building_road));
        row0.add(new CaseBean(10, 0, 1, Building.WALL, R.drawable.magic_tower_building_wall));
        row0.add(new CaseBean(10, 0, 2, Building.WALL, R.drawable.magic_tower_building_wall));
        row0.add(new CaseBean(10, 0, 3, Prop.BAO_SHI_BLUE, R.drawable.magic_tower_prop_bao_shi_blue));
        row0.add(new CaseBean(10, 0, 4, Monster.SHOU_MIAN_WU_SHI, R.drawable.magic_tower_monster_shou_mian_wu_shi));
        row0.add(new CaseBean(10, 0, 5, Building.WALL, R.drawable.magic_tower_building_wall));
        row0.add(new CaseBean(10, 0, 6, Monster.SHOU_MIAN_WU_SHI, R.drawable.magic_tower_monster_shou_mian_wu_shi));
        row0.add(new CaseBean(10, 0, 7, Prop.BAO_SHI_RED, R.drawable.magic_tower_prop_bao_shi_red));
        row0.add(new CaseBean(10, 0, 8, Building.WALL, R.drawable.magic_tower_building_wall));
        row0.add(new CaseBean(10, 0, 9, Building.WALL, R.drawable.magic_tower_building_wall));
        row0.add(new CaseBean(10, 0, 10, Building.ROAD, R.drawable.magic_tower_building_road));
        floor10.add(row0);

        List<CaseBean> row1 = new ArrayList<>();
        row1.add(new CaseBean(10, 1, 0, Building.ROAD, R.drawable.magic_tower_building_road));
        row1.add(new CaseBean(10, 1, 1, Building.ROAD, R.drawable.magic_tower_building_road));
        row1.add(new CaseBean(10, 1, 2, Building.WALL, R.drawable.magic_tower_building_wall));
        row1.add(new CaseBean(10, 1, 3, Building.WALL, R.drawable.magic_tower_building_wall));
        row1.add(new CaseBean(10, 1, 4, Npc.GATE_YELLOW, R.drawable.magic_tower_npc_gate_yellow_1));
        row1.add(new CaseBean(10, 1, 5, Building.WALL, R.drawable.magic_tower_building_wall));
        row1.add(new CaseBean(10, 1, 6, Npc.GATE_YELLOW, R.drawable.magic_tower_npc_gate_yellow_1));
        row1.add(new CaseBean(10, 1, 7, Building.WALL, R.drawable.magic_tower_building_wall));
        row1.add(new CaseBean(10, 1, 8, Building.WALL, R.drawable.magic_tower_building_wall));
        row1.add(new CaseBean(10, 1, 9, Building.ROAD, R.drawable.magic_tower_building_road));
        row1.add(new CaseBean(10, 1, 10, Monster.HONG_YI_FA_SHI, R.drawable.magic_tower_monster_hong_yi_fa_shi));
        floor10.add(row1);

        List<CaseBean> row2 = new ArrayList<>();
        row2.add(new CaseBean(10, 2, 0, Building.ROAD, R.drawable.magic_tower_building_road));
        row2.add(new CaseBean(10, 2, 1, Building.ROAD, R.drawable.magic_tower_building_road));
        row2.add(new CaseBean(10, 2, 2, Building.ROAD, R.drawable.magic_tower_building_road));
        row2.add(new CaseBean(10, 2, 3, Building.ROAD, R.drawable.magic_tower_building_road));
        row2.add(new CaseBean(10, 2, 4, Building.ROAD, R.drawable.magic_tower_building_road));
        row2.add(new CaseBean(10, 2, 5, Building.WALL, R.drawable.magic_tower_building_wall));
        row2.add(new CaseBean(10, 2, 6, Building.ROAD, R.drawable.magic_tower_building_road));
        row2.add(new CaseBean(10, 2, 7, Building.ROAD, R.drawable.magic_tower_building_road));
        row2.add(new CaseBean(10, 2, 8, Building.ROAD, R.drawable.magic_tower_building_road));
        row2.add(new CaseBean(10, 2, 9, Monster.HONG_YI_FA_SHI, R.drawable.magic_tower_monster_hong_yi_fa_shi));
        row2.add(new CaseBean(10, 2, 10, Prop.XIE_PING_BIG, R.drawable.magic_tower_prop_xie_ping_big));
        floor10.add(row2);

        List<CaseBean> row3 = new ArrayList<>();
        row3.add(new CaseBean(10, 3, 0, Building.ROAD, R.drawable.magic_tower_building_road));
        row3.add(new CaseBean(10, 3, 1, Building.WALL, R.drawable.magic_tower_building_wall));
        row3.add(new CaseBean(10, 3, 2, Building.ROAD, R.drawable.magic_tower_building_road));
        row3.add(new CaseBean(10, 3, 3, Building.WALL, R.drawable.magic_tower_building_wall));
        row3.add(new CaseBean(10, 3, 4, Building.WALL, R.drawable.magic_tower_building_wall));
        row3.add(new CaseBean(10, 3, 5, Building.WALL, R.drawable.magic_tower_building_wall));
        row3.add(new CaseBean(10, 3, 6, Building.WALL, R.drawable.magic_tower_building_wall));
        row3.add(new CaseBean(10, 3, 7, Building.WALL, R.drawable.magic_tower_building_wall));
        row3.add(new CaseBean(10, 3, 8, Building.ROAD, R.drawable.magic_tower_building_road));
        row3.add(new CaseBean(10, 3, 9, Building.WALL, R.drawable.magic_tower_building_wall));
        row3.add(new CaseBean(10, 3, 10, Building.WALL, R.drawable.magic_tower_building_wall));
        floor10.add(row3);

        List<CaseBean> row4 = new ArrayList<>();
        row4.add(new CaseBean(10, 4, 0, Monster.DA_BIAN_FU, R.drawable.magic_tower_monster_da_bian_fu));
        row4.add(new CaseBean(10, 4, 1, Building.WALL, R.drawable.magic_tower_building_wall));
        row4.add(new CaseBean(10, 4, 2, Building.ROAD, R.drawable.magic_tower_building_road));
        row4.add(new CaseBean(10, 4, 3, Building.ROAD, R.drawable.magic_tower_building_road));
        row4.add(new CaseBean(10, 4, 4, Prop.KEY_YELLOW, R.drawable.magic_tower_prop_key_yellow));
        row4.add(new CaseBean(10, 4, 5, Prop.KEY_YELLOW, R.drawable.magic_tower_prop_key_yellow));
        row4.add(new CaseBean(10, 4, 6, Prop.KEY_YELLOW, R.drawable.magic_tower_prop_key_yellow));
        row4.add(new CaseBean(10, 4, 7, Building.ROAD, R.drawable.magic_tower_building_road));
        row4.add(new CaseBean(10, 4, 8, Building.ROAD, R.drawable.magic_tower_building_road));
        row4.add(new CaseBean(10, 4, 9, Building.WALL, R.drawable.magic_tower_building_wall));
        row4.add(new CaseBean(10, 4, 10, Prop.KEY_YELLOW, R.drawable.magic_tower_prop_key_yellow));
        floor10.add(row4);

        List<CaseBean> row5 = new ArrayList<>();
        row5.add(new CaseBean(10, 5, 0, Monster.HONG_BIAN_FU, R.drawable.magic_tower_monster_hong_bian_fu));
        row5.add(new CaseBean(10, 5, 1, Building.WALL, R.drawable.magic_tower_building_wall));
        row5.add(new CaseBean(10, 5, 2, Building.ROAD, R.drawable.magic_tower_building_road));
        row5.add(new CaseBean(10, 5, 3, Building.WALL, R.drawable.magic_tower_building_wall));
        row5.add(new CaseBean(10, 5, 4, Building.WALL, R.drawable.magic_tower_building_wall));
        row5.add(new CaseBean(10, 5, 5, Building.WALL, R.drawable.magic_tower_building_wall));
        row5.add(new CaseBean(10, 5, 6, Building.WALL, R.drawable.magic_tower_building_wall));
        row5.add(new CaseBean(10, 5, 7, Npc.GATE_YELLOW, R.drawable.magic_tower_npc_gate_yellow_1));
        row5.add(new CaseBean(10, 5, 8, Building.WALL, R.drawable.magic_tower_building_wall));
        row5.add(new CaseBean(10, 5, 9, Building.WALL, R.drawable.magic_tower_building_wall));
        row5.add(new CaseBean(10, 5, 10, Prop.KEY_YELLOW, R.drawable.magic_tower_prop_key_yellow));
        floor10.add(row5);

        List<CaseBean> row6 = new ArrayList<>();
        row6.add(new CaseBean(10, 6, 0, Monster.DA_BIAN_FU, R.drawable.magic_tower_monster_da_bian_fu));
        row6.add(new CaseBean(10, 6, 1, Building.WALL, R.drawable.magic_tower_building_wall));
        row6.add(new CaseBean(10, 6, 2, Building.ROAD, R.drawable.magic_tower_building_road));
        row6.add(new CaseBean(10, 6, 3, Npc.GATE_IRON_OPEN, R.drawable.magic_tower_npc_gate_iron_1));
        row6.add(new CaseBean(10, 6, 4, Building.ROAD, R.drawable.magic_tower_building_road));
        row6.add(new CaseBean(10, 6, 5, Npc.GO_DOWNSTAIRS, R.drawable.magic_tower_npc_go_downstairs));
        row6.add(new CaseBean(10, 6, 6, Building.WALL, R.drawable.magic_tower_building_wall));
        row6.add(new CaseBean(10, 6, 7, Building.ROAD, R.drawable.magic_tower_building_road));
        row6.add(new CaseBean(10, 6, 8, Npc.GATE_YELLOW, R.drawable.magic_tower_npc_gate_yellow_1));
        row6.add(new CaseBean(10, 6, 9, Monster.HONG_BIAN_FU, R.drawable.magic_tower_monster_hong_bian_fu));
        row6.add(new CaseBean(10, 6, 10, Building.ROAD, R.drawable.magic_tower_building_road));
        floor10.add(row6);

        List<CaseBean> row7 = new ArrayList<>();
        row7.add(new CaseBean(10, 7, 0, Building.ROAD, R.drawable.magic_tower_building_road));
        row7.add(new CaseBean(10, 7, 1, Building.WALL, R.drawable.magic_tower_building_wall));
        row7.add(new CaseBean(10, 7, 2, Building.WALL, R.drawable.magic_tower_building_wall));
        row7.add(new CaseBean(10, 7, 3, Building.WALL, R.drawable.magic_tower_building_wall));
        row7.add(new CaseBean(10, 7, 4, Building.WALL, R.drawable.magic_tower_building_wall));
        row7.add(new CaseBean(10, 7, 5, Building.WALL, R.drawable.magic_tower_building_wall));
        row7.add(new CaseBean(10, 7, 6, Building.WALL, R.drawable.magic_tower_building_wall));
        row7.add(new CaseBean(10, 7, 7, Npc.GATE_YELLOW, R.drawable.magic_tower_npc_gate_yellow_1));
        row7.add(new CaseBean(10, 7, 8, Building.WALL, R.drawable.magic_tower_building_wall));
        row7.add(new CaseBean(10, 7, 9, Building.WALL, R.drawable.magic_tower_building_wall));
        row7.add(new CaseBean(10, 7, 10, Building.ROAD, R.drawable.magic_tower_building_road));
        floor10.add(row7);

        List<CaseBean> row8 = new ArrayList<>();
        row8.add(new CaseBean(10, 8, 0, Building.ROAD, R.drawable.magic_tower_building_road));
        row8.add(new CaseBean(10, 8, 1, Building.WALL, R.drawable.magic_tower_building_wall));
        row8.add(new CaseBean(10, 8, 2, Prop.XIE_PING_SMALL, R.drawable.magic_tower_prop_xie_ping_small));
        row8.add(new CaseBean(10, 8, 3, Prop.BAO_SHI_BLUE, R.drawable.magic_tower_prop_bao_shi_blue));
        row8.add(new CaseBean(10, 8, 4, Prop.BAO_SHI_RED, R.drawable.magic_tower_prop_bao_shi_red));
        row8.add(new CaseBean(10, 8, 5, Building.WALL, R.drawable.magic_tower_building_wall));
        row8.add(new CaseBean(10, 8, 6, Building.ROAD, R.drawable.magic_tower_building_road));
        row8.add(new CaseBean(10, 8, 7, Monster.HONG_BIAN_FU, R.drawable.magic_tower_monster_hong_bian_fu));
        row8.add(new CaseBean(10, 8, 8, Building.ROAD, R.drawable.magic_tower_building_road));
        row8.add(new CaseBean(10, 8, 9, Building.WALL, R.drawable.magic_tower_building_wall));
        row8.add(new CaseBean(10, 8, 10, Prop.KEY_YELLOW, R.drawable.magic_tower_prop_key_yellow));
        floor10.add(row8);

        List<CaseBean> row9 = new ArrayList<>();
        row9.add(new CaseBean(10, 9, 0, Building.ROAD, R.drawable.magic_tower_building_road));
        row9.add(new CaseBean(10, 9, 1, Building.WALL, R.drawable.magic_tower_building_wall));
        row9.add(new CaseBean(10, 9, 2, Prop.XIE_PING_SMALL, R.drawable.magic_tower_prop_xie_ping_small));
        row9.add(new CaseBean(10, 9, 3, Prop.BAO_SHI_BLUE, R.drawable.magic_tower_prop_bao_shi_blue));
        row9.add(new CaseBean(10, 9, 4, Prop.BAO_SHI_RED, R.drawable.magic_tower_prop_bao_shi_red));
        row9.add(new CaseBean(10, 9, 5, Npc.GATE_RED, R.drawable.magic_tower_npc_gate_red_1));
        row9.add(new CaseBean(10, 9, 6, Monster.MA_YI_FA_SHI, R.drawable.magic_tower_monster_ma_yi_fa_shi));
        row9.add(new CaseBean(10, 9, 7, Building.WALL, R.drawable.magic_tower_building_wall));
        row9.add(new CaseBean(10, 9, 8, Monster.MA_YI_FA_SHI, R.drawable.magic_tower_monster_ma_yi_fa_shi));
        row9.add(new CaseBean(10, 9, 9, Building.WALL, R.drawable.magic_tower_building_wall));
        row9.add(new CaseBean(10, 9, 10, Prop.KEY_YELLOW, R.drawable.magic_tower_prop_key_yellow));
        floor10.add(row9);

        List<CaseBean> row10 = new ArrayList<>();
        row10.add(new CaseBean(10, 10, 0, Npc.GO_UPSTAIRS, R.drawable.magic_tower_npc_go_upstairs));
        row10.add(new CaseBean(10, 10, 1, Building.WALL, R.drawable.magic_tower_building_wall));
        row10.add(new CaseBean(10, 10, 2, Prop.XIE_PING_SMALL, R.drawable.magic_tower_prop_xie_ping_small));
        row10.add(new CaseBean(10, 10, 3, Prop.BAO_SHI_BLUE, R.drawable.magic_tower_prop_bao_shi_blue));
        row10.add(new CaseBean(10, 10, 4, Prop.BAO_SHI_RED, R.drawable.magic_tower_prop_bao_shi_red));
        row10.add(new CaseBean(10, 10, 5, Building.WALL, R.drawable.magic_tower_building_wall));
        row10.add(new CaseBean(10, 10, 6, Prop.KEY_BLUE, R.drawable.magic_tower_prop_key_blue));
        row10.add(new CaseBean(10, 10, 7, Building.WALL, R.drawable.magic_tower_building_wall));
        row10.add(new CaseBean(10, 10, 8, Prop.KEY_BLUE, R.drawable.magic_tower_prop_key_blue));
        row10.add(new CaseBean(10, 10, 9, Building.WALL, R.drawable.magic_tower_building_wall));
        row10.add(new CaseBean(10, 10, 10, Prop.XIE_PING_SMALL, R.drawable.magic_tower_prop_xie_ping_small));
        floor10.add(row10);

        return floor10;
    }

    @Override
    public void fromUpstairsToThisFloor() {
        resetWarriorPosition(9, 0);
    }

    @Override
    public void fromDownstairsToThisFloor() {
        resetWarriorPosition(6, 4);
    }
}
