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
 * Description:第 13 层
 * Created by 禽兽先生
 * Created on 2017/4/27
 */

public class Floor13 extends AbsFloor {

    @Override
    public int getFloor() {
        return 13;
    }

    @Override
    public List<List<CaseBean>> setData() {
        List<List<CaseBean>> floor13 = new ArrayList<>();
        List<CaseBean> row0 = new ArrayList<>();
        row0.add(new CaseBean(13, 0, 0, Building.ROAD, R.drawable.magic_tower_building_road));
        row0.add(new CaseBean(13, 0, 1, Monster.SHUANG_SHOU_JIAN_SHI, R.drawable.magic_tower_monster_shuang_shou_jian_shi));
        row0.add(new CaseBean(13, 0, 2, Building.ROAD, R.drawable.magic_tower_building_road));
        row0.add(new CaseBean(13, 0, 3, Building.ROAD, R.drawable.magic_tower_building_road));
        row0.add(new CaseBean(13, 0, 4, Building.ROAD, R.drawable.magic_tower_building_road));
        row0.add(new CaseBean(13, 0, 5, Building.ROAD, R.drawable.magic_tower_building_road));
        row0.add(new CaseBean(13, 0, 6, Building.ROAD, R.drawable.magic_tower_building_road));
        row0.add(new CaseBean(13, 0, 7, Building.WALL, R.drawable.magic_tower_building_wall));
        row0.add(new CaseBean(13, 0, 8, Building.ROAD, R.drawable.magic_tower_building_road));
        row0.add(new CaseBean(13, 0, 9, Monster.MING_ZHAN_SHI, R.drawable.magic_tower_monster_ming_zhan_shi));
        row0.add(new CaseBean(13, 0, 10, Building.ROAD, R.drawable.magic_tower_building_road));
        floor13.add(row0);

        List<CaseBean> row1 = new ArrayList<>();
        row1.add(new CaseBean(13, 1, 0, Building.ROAD, R.drawable.magic_tower_building_road));
        row1.add(new CaseBean(13, 1, 1, Building.WALL, R.drawable.magic_tower_building_wall));
        row1.add(new CaseBean(13, 1, 2, Building.WALL, R.drawable.magic_tower_building_wall));
        row1.add(new CaseBean(13, 1, 3, Building.WALL, R.drawable.magic_tower_building_wall));
        row1.add(new CaseBean(13, 1, 4, Building.WALL, R.drawable.magic_tower_building_wall));
        row1.add(new CaseBean(13, 1, 5, Building.WALL, R.drawable.magic_tower_building_wall));
        row1.add(new CaseBean(13, 1, 6, Npc.GATE_YELLOW, R.drawable.magic_tower_npc_gate_yellow_1));
        row1.add(new CaseBean(13, 1, 7, Building.WALL, R.drawable.magic_tower_building_wall));
        row1.add(new CaseBean(13, 1, 8, Building.ROAD, R.drawable.magic_tower_building_road));
        row1.add(new CaseBean(13, 1, 9, Building.WALL, R.drawable.magic_tower_building_wall));
        row1.add(new CaseBean(13, 1, 10, Building.ROAD, R.drawable.magic_tower_building_road));
        floor13.add(row1);

        List<CaseBean> row2 = new ArrayList<>();
        row2.add(new CaseBean(13, 2, 0, Building.ROAD, R.drawable.magic_tower_building_road));
        row2.add(new CaseBean(13, 2, 1, Building.WALL, R.drawable.magic_tower_building_wall));
        row2.add(new CaseBean(13, 2, 2, Building.ROAD, R.drawable.magic_tower_building_road));
        row2.add(new CaseBean(13, 2, 3, Building.ROAD, R.drawable.magic_tower_building_road));
        row2.add(new CaseBean(13, 2, 4, Monster.MING_WEI_BING, R.drawable.magic_tower_monster_ming_wei_bing));
        row2.add(new CaseBean(13, 2, 5, Building.ROAD, R.drawable.magic_tower_building_road));
        row2.add(new CaseBean(13, 2, 6, Building.ROAD, R.drawable.magic_tower_building_road));
        row2.add(new CaseBean(13, 2, 7, Building.WALL, R.drawable.magic_tower_building_wall));
        row2.add(new CaseBean(13, 2, 8, Building.ROAD, R.drawable.magic_tower_building_road));
        row2.add(new CaseBean(13, 2, 9, Building.WALL, R.drawable.magic_tower_building_wall));
        row2.add(new CaseBean(13, 2, 10, Building.ROAD, R.drawable.magic_tower_building_road));
        floor13.add(row2);

        List<CaseBean> row3 = new ArrayList<>();
        row3.add(new CaseBean(13, 3, 0, Prop.XIE_PING_BIG, R.drawable.magic_tower_prop_xie_ping_big));
        row3.add(new CaseBean(13, 3, 1, Building.WALL, R.drawable.magic_tower_building_wall));
        row3.add(new CaseBean(13, 3, 2, Npc.GATE_RED, R.drawable.magic_tower_npc_gate_red_1));
        row3.add(new CaseBean(13, 3, 3, Building.WALL, R.drawable.magic_tower_building_wall));
        row3.add(new CaseBean(13, 3, 4, Building.WALL, R.drawable.magic_tower_building_wall));
        row3.add(new CaseBean(13, 3, 5, Building.WALL, R.drawable.magic_tower_building_wall));
        row3.add(new CaseBean(13, 3, 6, Building.ROAD, R.drawable.magic_tower_building_road));
        row3.add(new CaseBean(13, 3, 7, Building.WALL, R.drawable.magic_tower_building_wall));
        row3.add(new CaseBean(13, 3, 8, Building.ROAD, R.drawable.magic_tower_building_road));
        row3.add(new CaseBean(13, 3, 9, Building.WALL, R.drawable.magic_tower_building_wall));
        row3.add(new CaseBean(13, 3, 10, Building.ROAD, R.drawable.magic_tower_building_road));
        floor13.add(row3);

        List<CaseBean> row4 = new ArrayList<>();
        row4.add(new CaseBean(13, 4, 0, Monster.JIN_WEI_SHI, R.drawable.magic_tower_monster_jin_wei_shi));
        row4.add(new CaseBean(13, 4, 1, Building.WALL, R.drawable.magic_tower_building_wall));
        row4.add(new CaseBean(13, 4, 2, Building.ROAD, R.drawable.magic_tower_building_road));
        row4.add(new CaseBean(13, 4, 3, Building.ROAD, R.drawable.magic_tower_building_road));
        row4.add(new CaseBean(13, 4, 4, Monster.MING_ZHAN_SHI, R.drawable.magic_tower_monster_ming_zhan_shi));
        row4.add(new CaseBean(13, 4, 5, Building.WALL, R.drawable.magic_tower_building_wall));
        row4.add(new CaseBean(13, 4, 6, Monster.MING_WEI_BING, R.drawable.magic_tower_monster_ming_wei_bing));
        row4.add(new CaseBean(13, 4, 7, Building.WALL, R.drawable.magic_tower_building_wall));
        row4.add(new CaseBean(13, 4, 8, Prop.BAO_SHI_RED, R.drawable.magic_tower_prop_bao_shi_red));
        row4.add(new CaseBean(13, 4, 9, Building.WALL, R.drawable.magic_tower_building_wall));
        row4.add(new CaseBean(13, 4, 10, Building.ROAD, R.drawable.magic_tower_building_road));
        floor13.add(row4);

        List<CaseBean> row5 = new ArrayList<>();
        row5.add(new CaseBean(13, 5, 0, Monster.JIN_DUI_ZHANG, R.drawable.magic_tower_monster_jin_dui_zhang));
        row5.add(new CaseBean(13, 5, 1, Building.WALL, R.drawable.magic_tower_building_wall));
        row5.add(new CaseBean(13, 5, 2, Building.ROAD, R.drawable.magic_tower_building_road));
        row5.add(new CaseBean(13, 5, 3, Monster.MING_DUI_ZHANG_1, R.drawable.magic_tower_monster_ming_dui_zhang));
        row5.add(new CaseBean(13, 5, 4, Npc.GATE_IRON_CLOSE, R.drawable.magic_tower_npc_gate_iron_1));
        row5.add(new CaseBean(13, 5, 5, Building.WALL, R.drawable.magic_tower_building_wall));
        row5.add(new CaseBean(13, 5, 6, Monster.GAO_JI_WEI_BING, R.drawable.magic_tower_monster_gao_ji_wei_bing));
        row5.add(new CaseBean(13, 5, 7, Building.WALL, R.drawable.magic_tower_building_wall));
        row5.add(new CaseBean(13, 5, 8, Prop.BAO_SHI_RED, R.drawable.magic_tower_prop_bao_shi_red));
        row5.add(new CaseBean(13, 5, 9, Building.WALL, R.drawable.magic_tower_building_wall));
        row5.add(new CaseBean(13, 5, 10, Building.ROAD, R.drawable.magic_tower_building_road));
        floor13.add(row5);

        List<CaseBean> row6 = new ArrayList<>();
        row6.add(new CaseBean(13, 6, 0, Monster.JIN_WEI_SHI, R.drawable.magic_tower_monster_jin_wei_shi));
        row6.add(new CaseBean(13, 6, 1, Building.WALL, R.drawable.magic_tower_building_wall));
        row6.add(new CaseBean(13, 6, 2, Monster.MING_ZHAN_SHI, R.drawable.magic_tower_monster_ming_zhan_shi));
        row6.add(new CaseBean(13, 6, 3, Npc.GATE_IRON_OPEN, R.drawable.magic_tower_npc_gate_iron_1));
        row6.add(new CaseBean(13, 6, 4, Npc.SHEN_MI_LAO_REN_FLOOR_13, R.drawable.magic_tower_npc_shen_mi_lao_ren));
        row6.add(new CaseBean(13, 6, 5, Building.WALL, R.drawable.magic_tower_building_wall));
        row6.add(new CaseBean(13, 6, 6, Monster.MING_WEI_BING, R.drawable.magic_tower_monster_ming_wei_bing));
        row6.add(new CaseBean(13, 6, 7, Building.WALL, R.drawable.magic_tower_building_wall));
        row6.add(new CaseBean(13, 6, 8, Prop.BAO_SHI_RED, R.drawable.magic_tower_prop_bao_shi_red));
        row6.add(new CaseBean(13, 6, 9, Building.WALL, R.drawable.magic_tower_building_wall));
        row6.add(new CaseBean(13, 6, 10, Prop.BAO_SHI_BLUE, R.drawable.magic_tower_prop_bao_shi_blue));
        floor13.add(row6);

        List<CaseBean> row7 = new ArrayList<>();
        row7.add(new CaseBean(13, 7, 0, Building.ROAD, R.drawable.magic_tower_building_road));
        row7.add(new CaseBean(13, 7, 1, Building.WALL, R.drawable.magic_tower_building_wall));
        row7.add(new CaseBean(13, 7, 2, Building.WALL, R.drawable.magic_tower_building_wall));
        row7.add(new CaseBean(13, 7, 3, Building.WALL, R.drawable.magic_tower_building_wall));
        row7.add(new CaseBean(13, 7, 4, Building.WALL, R.drawable.magic_tower_building_wall));
        row7.add(new CaseBean(13, 7, 5, Building.WALL, R.drawable.magic_tower_building_wall));
        row7.add(new CaseBean(13, 7, 6, Building.ROAD, R.drawable.magic_tower_building_road));
        row7.add(new CaseBean(13, 7, 7, Building.WALL, R.drawable.magic_tower_building_wall));
        row7.add(new CaseBean(13, 7, 8, Building.ROAD, R.drawable.magic_tower_building_road));
        row7.add(new CaseBean(13, 7, 9, Building.WALL, R.drawable.magic_tower_building_wall));
        row7.add(new CaseBean(13, 7, 10, Prop.BAO_SHI_BLUE, R.drawable.magic_tower_prop_bao_shi_blue));
        floor13.add(row7);

        List<CaseBean> row8 = new ArrayList<>();
        row8.add(new CaseBean(13, 8, 0, Building.ROAD, R.drawable.magic_tower_building_road));
        row8.add(new CaseBean(13, 8, 1, Monster.JIN_WEI_SHI, R.drawable.magic_tower_monster_jin_wei_shi));
        row8.add(new CaseBean(13, 8, 2, Building.ROAD, R.drawable.magic_tower_building_road));
        row8.add(new CaseBean(13, 8, 3, Building.WALL, R.drawable.magic_tower_building_wall));
        row8.add(new CaseBean(13, 8, 4, Building.ROAD, R.drawable.magic_tower_building_road));
        row8.add(new CaseBean(13, 8, 5, Building.ROAD, R.drawable.magic_tower_building_road));
        row8.add(new CaseBean(13, 8, 6, Building.ROAD, R.drawable.magic_tower_building_road));
        row8.add(new CaseBean(13, 8, 7, Monster.MING_ZHAN_SHI, R.drawable.magic_tower_monster_ming_zhan_shi));
        row8.add(new CaseBean(13, 8, 8, Building.ROAD, R.drawable.magic_tower_building_road));
        row8.add(new CaseBean(13, 8, 9, Building.WALL, R.drawable.magic_tower_building_wall));
        row8.add(new CaseBean(13, 8, 10, Prop.BAO_SHI_BLUE, R.drawable.magic_tower_prop_bao_shi_blue));
        floor13.add(row8);

        List<CaseBean> row9 = new ArrayList<>();
        row9.add(new CaseBean(13, 9, 0, Building.WALL, R.drawable.magic_tower_building_wall));
        row9.add(new CaseBean(13, 9, 1, Building.WALL, R.drawable.magic_tower_building_wall));
        row9.add(new CaseBean(13, 9, 2, Building.ROAD, R.drawable.magic_tower_building_road));
        row9.add(new CaseBean(13, 9, 3, Building.WALL, R.drawable.magic_tower_building_wall));
        row9.add(new CaseBean(13, 9, 4, Prop.XIE_PING_BIG, R.drawable.magic_tower_prop_xie_ping_big));
        row9.add(new CaseBean(13, 9, 5, Building.WALL, R.drawable.magic_tower_building_wall));
        row9.add(new CaseBean(13, 9, 6, Building.WALL, R.drawable.magic_tower_building_wall));
        row9.add(new CaseBean(13, 9, 7, Building.WALL, R.drawable.magic_tower_building_wall));
        row9.add(new CaseBean(13, 9, 8, Building.WALL, R.drawable.magic_tower_building_wall));
        row9.add(new CaseBean(13, 9, 9, Building.WALL, R.drawable.magic_tower_building_wall));
        row9.add(new CaseBean(13, 9, 10, Building.ROAD, R.drawable.magic_tower_building_road));
        floor13.add(row9);

        List<CaseBean> row10 = new ArrayList<>();
        row10.add(new CaseBean(13, 10, 0, Npc.GO_DOWNSTAIRS, R.drawable.magic_tower_npc_go_downstairs));
        row10.add(new CaseBean(13, 10, 1, Building.ROAD, R.drawable.magic_tower_building_road));
        row10.add(new CaseBean(13, 10, 2, Building.ROAD, R.drawable.magic_tower_building_road));
        row10.add(new CaseBean(13, 10, 3, Npc.GATE_BLUE, R.drawable.magic_tower_npc_gate_blue_1));
        row10.add(new CaseBean(13, 10, 4, Building.ROAD, R.drawable.magic_tower_building_road));
        row10.add(new CaseBean(13, 10, 5, Npc.GO_UPSTAIRS, R.drawable.magic_tower_npc_go_upstairs));
        row10.add(new CaseBean(13, 10, 6, Building.WALL, R.drawable.magic_tower_building_wall));
        row10.add(new CaseBean(13, 10, 7, Prop.DA_FEI_YU, R.drawable.magic_tower_prop_da_fei_yu));
        row10.add(new CaseBean(13, 10, 8, Monster.MING_DUI_ZHANG_1, R.drawable.magic_tower_monster_ming_dui_zhang));
        row10.add(new CaseBean(13, 10, 9, Npc.GATE_YELLOW, R.drawable.magic_tower_npc_gate_yellow_1));
        row10.add(new CaseBean(13, 10, 10, Building.ROAD, R.drawable.magic_tower_building_road));
        floor13.add(row10);

        return floor13;
    }

    @Override
    public void fromUpstairsToThisFloor() {
        resetWarriorPosition(10, 4);
    }

    @Override
    public void fromDownstairsToThisFloor() {
        resetWarriorPosition(10, 1);
    }
}
