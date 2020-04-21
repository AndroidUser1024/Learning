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
 * Description:第 11 层
 * Created by 禽兽先生
 * Created on 2017/4/27
 */

public class Floor11 extends AbsFloor {

    @Override
    public int getFloor() {
        return 11;
    }

    @Override
    public List<List<CaseBean>> setData() {
        List<List<CaseBean>> floor11 = new ArrayList<>();
        List<CaseBean> row0 = new ArrayList<>();
        row0.add(new CaseBean(11, 0, 0, Prop.XIE_PING_SMALL, R.drawable.magic_tower_prop_xie_ping_small));
        row0.add(new CaseBean(11, 0, 1, Building.WALL, R.drawable.magic_tower_building_wall));
        row0.add(new CaseBean(11, 0, 2, Prop.KEY_YELLOW, R.drawable.magic_tower_prop_key_yellow));
        row0.add(new CaseBean(11, 0, 3, Building.WALL, R.drawable.magic_tower_building_wall));
        row0.add(new CaseBean(11, 0, 4, Prop.KEY_BLUE, R.drawable.magic_tower_prop_key_blue));
        row0.add(new CaseBean(11, 0, 5, Building.WALL, R.drawable.magic_tower_building_wall));
        row0.add(new CaseBean(11, 0, 6, Prop.KEY_RED, R.drawable.magic_tower_prop_key_red));
        row0.add(new CaseBean(11, 0, 7, Building.WALL, R.drawable.magic_tower_building_wall));
        row0.add(new CaseBean(11, 0, 8, Prop.XIE_PING_BIG, R.drawable.magic_tower_prop_xie_ping_big));
        row0.add(new CaseBean(11, 0, 9, Prop.HUANG_JIN_DUN, R.drawable.magic_tower_prop_huang_jin_dun));
        row0.add(new CaseBean(11, 0, 10, Prop.XIE_PING_BIG, R.drawable.magic_tower_prop_xie_ping_big));
        floor11.add(row0);

        List<CaseBean> row1 = new ArrayList<>();
        row1.add(new CaseBean(11, 1, 0, Prop.XIE_PING_SMALL, R.drawable.magic_tower_prop_xie_ping_small));
        row1.add(new CaseBean(11, 1, 1, Building.WALL, R.drawable.magic_tower_building_wall));
        row1.add(new CaseBean(11, 1, 2, Prop.KEY_YELLOW, R.drawable.magic_tower_prop_key_yellow));
        row1.add(new CaseBean(11, 1, 3, Building.WALL, R.drawable.magic_tower_building_wall));
        row1.add(new CaseBean(11, 1, 4, Prop.KEY_BLUE, R.drawable.magic_tower_prop_key_blue));
        row1.add(new CaseBean(11, 1, 5, Building.WALL, R.drawable.magic_tower_building_wall));
        row1.add(new CaseBean(11, 1, 6, Prop.KEY_RED, R.drawable.magic_tower_prop_key_red));
        row1.add(new CaseBean(11, 1, 7, Building.WALL, R.drawable.magic_tower_building_wall));
        row1.add(new CaseBean(11, 1, 8, Monster.MING_WEI_BING, R.drawable.magic_tower_monster_ming_wei_bing));
        row1.add(new CaseBean(11, 1, 9, Monster.GAO_JI_WEI_BING, R.drawable.magic_tower_monster_gao_ji_wei_bing));
        row1.add(new CaseBean(11, 1, 10, Monster.MING_WEI_BING, R.drawable.magic_tower_monster_ming_wei_bing));
        floor11.add(row1);

        List<CaseBean> row2 = new ArrayList<>();
        row2.add(new CaseBean(11, 2, 0, Prop.XIE_PING_SMALL, R.drawable.magic_tower_prop_xie_ping_small));
        row2.add(new CaseBean(11, 2, 1, Building.WALL, R.drawable.magic_tower_building_wall));
        row2.add(new CaseBean(11, 2, 2, Prop.KEY_YELLOW, R.drawable.magic_tower_prop_key_yellow));
        row2.add(new CaseBean(11, 2, 3, Building.WALL, R.drawable.magic_tower_building_wall));
        row2.add(new CaseBean(11, 2, 4, Prop.KEY_BLUE, R.drawable.magic_tower_prop_key_blue));
        row2.add(new CaseBean(11, 2, 5, Building.WALL, R.drawable.magic_tower_building_wall));
        row2.add(new CaseBean(11, 2, 6, Prop.KEY_RED, R.drawable.magic_tower_prop_key_red));
        row2.add(new CaseBean(11, 2, 7, Building.WALL, R.drawable.magic_tower_building_wall));
        row2.add(new CaseBean(11, 2, 8, Building.ROAD, R.drawable.magic_tower_building_road));
        row2.add(new CaseBean(11, 2, 9, Monster.MING_WEI_BING, R.drawable.magic_tower_monster_ming_wei_bing));
        row2.add(new CaseBean(11, 2, 10, Building.ROAD, R.drawable.magic_tower_building_road));
        floor11.add(row2);

        List<CaseBean> row3 = new ArrayList<>();
        row3.add(new CaseBean(11, 3, 0, Npc.GATE_YELLOW, R.drawable.magic_tower_npc_gate_yellow_1));
        row3.add(new CaseBean(11, 3, 1, Building.WALL, R.drawable.magic_tower_building_wall));
        row3.add(new CaseBean(11, 3, 2, Npc.GATE_YELLOW, R.drawable.magic_tower_npc_gate_yellow_1));
        row3.add(new CaseBean(11, 3, 3, Building.WALL, R.drawable.magic_tower_building_wall));
        row3.add(new CaseBean(11, 3, 4, Npc.GATE_YELLOW, R.drawable.magic_tower_npc_gate_yellow_1));
        row3.add(new CaseBean(11, 3, 5, Building.WALL, R.drawable.magic_tower_building_wall));
        row3.add(new CaseBean(11, 3, 6, Npc.GATE_YELLOW, R.drawable.magic_tower_npc_gate_yellow_1));
        row3.add(new CaseBean(11, 3, 7, Building.WALL, R.drawable.magic_tower_building_wall));
        row3.add(new CaseBean(11, 3, 8, Building.WALL, R.drawable.magic_tower_building_wall));
        row3.add(new CaseBean(11, 3, 9, Npc.GATE_BLUE, R.drawable.magic_tower_npc_gate_blue_1));
        row3.add(new CaseBean(11, 3, 10, Building.WALL, R.drawable.magic_tower_building_wall));
        floor11.add(row3);

        List<CaseBean> row4 = new ArrayList<>();
        row4.add(new CaseBean(11, 4, 0, Building.ROAD, R.drawable.magic_tower_building_road));
        row4.add(new CaseBean(11, 4, 1, Building.ROAD, R.drawable.magic_tower_building_road));
        row4.add(new CaseBean(11, 4, 2, Building.ROAD, R.drawable.magic_tower_building_road));
        row4.add(new CaseBean(11, 4, 3, Building.ROAD, R.drawable.magic_tower_building_road));
        row4.add(new CaseBean(11, 4, 4, Building.ROAD, R.drawable.magic_tower_building_road));
        row4.add(new CaseBean(11, 4, 5, Building.WALL, R.drawable.magic_tower_building_wall));
        row4.add(new CaseBean(11, 4, 6, Building.ROAD, R.drawable.magic_tower_building_road));
        row4.add(new CaseBean(11, 4, 7, Building.ROAD, R.drawable.magic_tower_building_road));
        row4.add(new CaseBean(11, 4, 8, Building.ROAD, R.drawable.magic_tower_building_road));
        row4.add(new CaseBean(11, 4, 9, Building.ROAD, R.drawable.magic_tower_building_road));
        row4.add(new CaseBean(11, 4, 10, Building.ROAD, R.drawable.magic_tower_building_road));
        floor11.add(row4);

        List<CaseBean> row5 = new ArrayList<>();
        row5.add(new CaseBean(11, 5, 0, Npc.GATE_YELLOW, R.drawable.magic_tower_npc_gate_yellow_1));
        row5.add(new CaseBean(11, 5, 1, Building.WALL, R.drawable.magic_tower_building_wall));
        row5.add(new CaseBean(11, 5, 2, Building.WALL, R.drawable.magic_tower_building_wall));
        row5.add(new CaseBean(11, 5, 3, Npc.GATE_BLUE, R.drawable.magic_tower_npc_gate_blue_1));
        row5.add(new CaseBean(11, 5, 4, Building.WALL, R.drawable.magic_tower_building_wall));
        row5.add(new CaseBean(11, 5, 5, Building.WALL, R.drawable.magic_tower_building_wall));
        row5.add(new CaseBean(11, 5, 6, Building.WALL, R.drawable.magic_tower_building_wall));
        row5.add(new CaseBean(11, 5, 7, Npc.GATE_BLUE, R.drawable.magic_tower_npc_gate_blue_1));
        row5.add(new CaseBean(11, 5, 8, Building.WALL, R.drawable.magic_tower_building_wall));
        row5.add(new CaseBean(11, 5, 9, Building.WALL, R.drawable.magic_tower_building_wall));
        row5.add(new CaseBean(11, 5, 10, Npc.GATE_YELLOW, R.drawable.magic_tower_npc_gate_yellow_1));
        floor11.add(row5);

        List<CaseBean> row6 = new ArrayList<>();
        row6.add(new CaseBean(11, 6, 0, Prop.BAO_SHI_BLUE, R.drawable.magic_tower_prop_bao_shi_blue));
        row6.add(new CaseBean(11, 6, 1, Building.WALL, R.drawable.magic_tower_building_wall));
        row6.add(new CaseBean(11, 6, 2, Building.ROAD, R.drawable.magic_tower_building_road));
        row6.add(new CaseBean(11, 6, 3, Monster.MING_WEI_BING, R.drawable.magic_tower_monster_ming_wei_bing));
        row6.add(new CaseBean(11, 6, 4, Prop.XIE_PING_BIG, R.drawable.magic_tower_prop_xie_ping_big));
        row6.add(new CaseBean(11, 6, 5, Monster.SHUANG_SHOU_JIAN_SHI, R.drawable.magic_tower_monster_shuang_shou_jian_shi));
        row6.add(new CaseBean(11, 6, 6, Prop.XIE_PING_BIG, R.drawable.magic_tower_prop_xie_ping_big));
        row6.add(new CaseBean(11, 6, 7, Monster.MING_WEI_BING, R.drawable.magic_tower_monster_ming_wei_bing));
        row6.add(new CaseBean(11, 6, 8, Building.ROAD, R.drawable.magic_tower_building_road));
        row6.add(new CaseBean(11, 6, 9, Building.WALL, R.drawable.magic_tower_building_wall));
        row6.add(new CaseBean(11, 6, 10, Prop.BAO_SHI_RED, R.drawable.magic_tower_prop_bao_shi_red));
        floor11.add(row6);

        List<CaseBean> row7 = new ArrayList<>();
        row7.add(new CaseBean(11, 7, 0, Prop.BAO_SHI_BLUE, R.drawable.magic_tower_prop_bao_shi_blue));
        row7.add(new CaseBean(11, 7, 1, Building.WALL, R.drawable.magic_tower_building_wall));
        row7.add(new CaseBean(11, 7, 2, Monster.SHOU_MIAN_WU_SHI, R.drawable.magic_tower_monster_shou_mian_wu_shi));
        row7.add(new CaseBean(11, 7, 3, Building.WALL, R.drawable.magic_tower_building_wall));
        row7.add(new CaseBean(11, 7, 4, Building.WALL, R.drawable.magic_tower_building_wall));
        row7.add(new CaseBean(11, 7, 5, Building.WALL, R.drawable.magic_tower_building_wall));
        row7.add(new CaseBean(11, 7, 6, Building.WALL, R.drawable.magic_tower_building_wall));
        row7.add(new CaseBean(11, 7, 7, Building.WALL, R.drawable.magic_tower_building_wall));
        row7.add(new CaseBean(11, 7, 8, Monster.SHOU_MIAN_WU_SHI, R.drawable.magic_tower_monster_shou_mian_wu_shi));
        row7.add(new CaseBean(11, 7, 9, Building.WALL, R.drawable.magic_tower_building_wall));
        row7.add(new CaseBean(11, 7, 10, Prop.BAO_SHI_RED, R.drawable.magic_tower_prop_bao_shi_red));
        floor11.add(row7);

        List<CaseBean> row8 = new ArrayList<>();
        row8.add(new CaseBean(11, 8, 0, Prop.BAO_SHI_BLUE, R.drawable.magic_tower_prop_bao_shi_blue));
        row8.add(new CaseBean(11, 8, 1, Building.WALL, R.drawable.magic_tower_building_wall));
        row8.add(new CaseBean(11, 8, 2, Monster.SHOU_MIAN_WU_SHI, R.drawable.magic_tower_monster_shou_mian_wu_shi));
        row8.add(new CaseBean(11, 8, 3, Building.WALL, R.drawable.magic_tower_building_wall));
        row8.add(new CaseBean(11, 8, 4, Npc.SHANG_DIAN_LAO_BAN_BIG_1, R.drawable.magic_tower_npc_shang_dian_lao_ban_1));
        row8.add(new CaseBean(11, 8, 5, Npc.SHANG_DIAN_LAO_BAN_BIG_2, R.drawable.magic_tower_npc_shang_dian_lao_ban_2));
        row8.add(new CaseBean(11, 8, 6, Npc.SHANG_DIAN_LAO_BAN_BIG_3, R.drawable.magic_tower_npc_shang_dian_lao_ban_3));
        row8.add(new CaseBean(11, 8, 7, Building.WALL, R.drawable.magic_tower_building_wall));
        row8.add(new CaseBean(11, 8, 8, Monster.SHOU_MIAN_WU_SHI, R.drawable.magic_tower_monster_shou_mian_wu_shi));
        row8.add(new CaseBean(11, 8, 9, Building.WALL, R.drawable.magic_tower_building_wall));
        row8.add(new CaseBean(11, 8, 10, Prop.BAO_SHI_RED, R.drawable.magic_tower_prop_bao_shi_red));
        floor11.add(row8);

        List<CaseBean> row9 = new ArrayList<>();
        row9.add(new CaseBean(11, 9, 0, Building.WALL, R.drawable.magic_tower_building_wall));
        row9.add(new CaseBean(11, 9, 1, Building.WALL, R.drawable.magic_tower_building_wall));
        row9.add(new CaseBean(11, 9, 2, Npc.GATE_RED, R.drawable.magic_tower_npc_gate_red_1));
        row9.add(new CaseBean(11, 9, 3, Building.WALL, R.drawable.magic_tower_building_wall));
        row9.add(new CaseBean(11, 9, 4, Prop.XIE_PING_SMALL, R.drawable.magic_tower_prop_xie_ping_small));
        row9.add(new CaseBean(11, 9, 5, Building.ROAD, R.drawable.magic_tower_building_road));
        row9.add(new CaseBean(11, 9, 6, Prop.XIE_PING_SMALL, R.drawable.magic_tower_prop_xie_ping_small));
        row9.add(new CaseBean(11, 9, 7, Building.WALL, R.drawable.magic_tower_building_wall));
        row9.add(new CaseBean(11, 9, 8, Npc.GATE_RED, R.drawable.magic_tower_npc_gate_red_1));
        row9.add(new CaseBean(11, 9, 9, Building.WALL, R.drawable.magic_tower_building_wall));
        row9.add(new CaseBean(11, 9, 10, Building.WALL, R.drawable.magic_tower_building_wall));
        floor11.add(row9);

        List<CaseBean> row10 = new ArrayList<>();
        row10.add(new CaseBean(11, 10, 0, Npc.GO_DOWNSTAIRS, R.drawable.magic_tower_npc_go_downstairs));
        row10.add(new CaseBean(11, 10, 1, Building.ROAD, R.drawable.magic_tower_building_road));
        row10.add(new CaseBean(11, 10, 2, Building.ROAD, R.drawable.magic_tower_building_road));
        row10.add(new CaseBean(11, 10, 3, Building.ROAD, R.drawable.magic_tower_building_road));
        row10.add(new CaseBean(11, 10, 4, Building.ROAD, R.drawable.magic_tower_building_road));
        row10.add(new CaseBean(11, 10, 5, Building.ROAD, R.drawable.magic_tower_building_road));
        row10.add(new CaseBean(11, 10, 6, Building.ROAD, R.drawable.magic_tower_building_road));
        row10.add(new CaseBean(11, 10, 7, Building.ROAD, R.drawable.magic_tower_building_road));
        row10.add(new CaseBean(11, 10, 8, Building.ROAD, R.drawable.magic_tower_building_road));
        row10.add(new CaseBean(11, 10, 9, Building.ROAD, R.drawable.magic_tower_building_road));
        row10.add(new CaseBean(11, 10, 10, Npc.GO_UPSTAIRS, R.drawable.magic_tower_npc_go_upstairs));
        floor11.add(row10);

        return floor11;
    }

    @Override
    public void fromUpstairsToThisFloor() {
        resetWarriorPosition(10, 9);
    }

    @Override
    public void fromDownstairsToThisFloor() {
        resetWarriorPosition(10, 1);
    }
}
