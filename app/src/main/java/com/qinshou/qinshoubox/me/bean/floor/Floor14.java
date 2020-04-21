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
 * Description:第 14 层
 * Created by 禽兽先生
 * Created on 2017/4/27
 */

public class Floor14 extends AbsFloor {

    @Override
    public int getFloor() {
        return 14;
    }

    @Override
    public List<List<CaseBean>> setData() {
        List<List<CaseBean>> floor14 = new ArrayList<>();
        List<CaseBean> row0 = new ArrayList<>();
        row0.add(new CaseBean(14, 0, 0, Building.WALL, R.drawable.magic_tower_building_wall));
        row0.add(new CaseBean(14, 0, 1, Building.ROAD, R.drawable.magic_tower_building_road));
        row0.add(new CaseBean(14, 0, 2, Monster.LING_WU_SHI_1, R.drawable.magic_tower_monster_ling_wu_shi));
        row0.add(new CaseBean(14, 0, 3, Prop.YAO_SHI_HE, R.drawable.magic_tower_prop_yao_shi_he));
        row0.add(new CaseBean(14, 0, 4, Npc.GO_UPSTAIRS, R.drawable.magic_tower_npc_go_upstairs));
        row0.add(new CaseBean(14, 0, 5, Building.ROAD, R.drawable.magic_tower_building_road));
        row0.add(new CaseBean(14, 0, 6, Building.ROAD, R.drawable.magic_tower_building_road));
        row0.add(new CaseBean(14, 0, 7, Building.ROAD, R.drawable.magic_tower_building_road));
        row0.add(new CaseBean(14, 0, 8, Building.ROAD, R.drawable.magic_tower_building_road));
        row0.add(new CaseBean(14, 0, 9, Building.ROAD, R.drawable.magic_tower_building_road));
        row0.add(new CaseBean(14, 0, 10, Building.WALL, R.drawable.magic_tower_building_wall));
        floor14.add(row0);

        List<CaseBean> row1 = new ArrayList<>();
        row1.add(new CaseBean(14, 1, 0, Building.WALL, R.drawable.magic_tower_building_wall));
        row1.add(new CaseBean(14, 1, 1, Building.ROAD, R.drawable.magic_tower_building_road));
        row1.add(new CaseBean(14, 1, 2, Prop.XIE_PING_BIG, R.drawable.magic_tower_prop_xie_ping_big));
        row1.add(new CaseBean(14, 1, 3, Building.WALL, R.drawable.magic_tower_building_wall));
        row1.add(new CaseBean(14, 1, 4, Building.WALL, R.drawable.magic_tower_building_wall));
        row1.add(new CaseBean(14, 1, 5, Building.WALL, R.drawable.magic_tower_building_wall));
        row1.add(new CaseBean(14, 1, 6, Building.WALL, R.drawable.magic_tower_building_wall));
        row1.add(new CaseBean(14, 1, 7, Building.WALL, R.drawable.magic_tower_building_wall));
        row1.add(new CaseBean(14, 1, 8, Prop.XIE_PING_BIG, R.drawable.magic_tower_prop_xie_ping_big));
        row1.add(new CaseBean(14, 1, 9, Building.ROAD, R.drawable.magic_tower_building_road));
        row1.add(new CaseBean(14, 1, 10, Building.WALL, R.drawable.magic_tower_building_wall));
        floor14.add(row1);

        List<CaseBean> row2 = new ArrayList<>();
        row2.add(new CaseBean(14, 2, 0, Building.WALL, R.drawable.magic_tower_building_wall));
        row2.add(new CaseBean(14, 2, 1, Building.ROAD, R.drawable.magic_tower_building_road));
        row2.add(new CaseBean(14, 2, 2, Building.WALL, R.drawable.magic_tower_building_wall));
        row2.add(new CaseBean(14, 2, 3, Building.WALL, R.drawable.magic_tower_building_wall));
        row2.add(new CaseBean(14, 2, 4, Building.WALL, R.drawable.magic_tower_building_wall));
        row2.add(new CaseBean(14, 2, 5, Building.WALL, R.drawable.magic_tower_building_wall));
        row2.add(new CaseBean(14, 2, 6, Building.WALL, R.drawable.magic_tower_building_wall));
        row2.add(new CaseBean(14, 2, 7, Building.WALL, R.drawable.magic_tower_building_wall));
        row2.add(new CaseBean(14, 2, 8, Building.WALL, R.drawable.magic_tower_building_wall));
        row2.add(new CaseBean(14, 2, 9, Building.ROAD, R.drawable.magic_tower_building_road));
        row2.add(new CaseBean(14, 2, 10, Building.WALL, R.drawable.magic_tower_building_wall));
        floor14.add(row2);

        List<CaseBean> row3 = new ArrayList<>();
        row3.add(new CaseBean(14, 3, 0, Building.WALL, R.drawable.magic_tower_building_wall));
        row3.add(new CaseBean(14, 3, 1, Building.ROAD, R.drawable.magic_tower_building_road));
        row3.add(new CaseBean(14, 3, 2, Building.WALL, R.drawable.magic_tower_building_wall));
        row3.add(new CaseBean(14, 3, 3, Building.WALL, R.drawable.magic_tower_building_wall));
        row3.add(new CaseBean(14, 3, 4, Building.WALL, R.drawable.magic_tower_building_wall));
        row3.add(new CaseBean(14, 3, 5, Prop.SHENG_SHUI, R.drawable.magic_tower_prop_sheng_shui));
        row3.add(new CaseBean(14, 3, 6, Building.WALL, R.drawable.magic_tower_building_wall));
        row3.add(new CaseBean(14, 3, 7, Building.WALL, R.drawable.magic_tower_building_wall));
        row3.add(new CaseBean(14, 3, 8, Building.WALL, R.drawable.magic_tower_building_wall));
        row3.add(new CaseBean(14, 3, 9, Building.ROAD, R.drawable.magic_tower_building_road));
        row3.add(new CaseBean(14, 3, 10, Building.WALL, R.drawable.magic_tower_building_wall));
        floor14.add(row3);

        List<CaseBean> row4 = new ArrayList<>();
        row4.add(new CaseBean(14, 4, 0, Building.WALL, R.drawable.magic_tower_building_wall));
        row4.add(new CaseBean(14, 4, 1, Building.ROAD, R.drawable.magic_tower_building_road));
        row4.add(new CaseBean(14, 4, 2, Building.WALL, R.drawable.magic_tower_building_wall));
        row4.add(new CaseBean(14, 4, 3, Building.WALL, R.drawable.magic_tower_building_wall));
        row4.add(new CaseBean(14, 4, 4, Building.WALL, R.drawable.magic_tower_building_wall));
        row4.add(new CaseBean(14, 4, 5, Npc.GATE_IRON_OPEN, R.drawable.magic_tower_npc_gate_iron_1));
        row4.add(new CaseBean(14, 4, 6, Building.WALL, R.drawable.magic_tower_building_wall));
        row4.add(new CaseBean(14, 4, 7, Building.WALL, R.drawable.magic_tower_building_wall));
        row4.add(new CaseBean(14, 4, 8, Building.WALL, R.drawable.magic_tower_building_wall));
        row4.add(new CaseBean(14, 4, 9, Building.ROAD, R.drawable.magic_tower_building_road));
        row4.add(new CaseBean(14, 4, 10, Building.WALL, R.drawable.magic_tower_building_wall));
        floor14.add(row4);

        List<CaseBean> row5 = new ArrayList<>();
        row5.add(new CaseBean(14, 5, 0, Building.WALL, R.drawable.magic_tower_building_wall));
        row5.add(new CaseBean(14, 5, 1, Building.ROAD, R.drawable.magic_tower_building_road));
        row5.add(new CaseBean(14, 5, 2, Prop.XIE_PING_SMALL, R.drawable.magic_tower_prop_xie_ping_small));
        row5.add(new CaseBean(14, 5, 3, Building.WALL, R.drawable.magic_tower_building_wall));
        row5.add(new CaseBean(14, 5, 4, Building.WALL, R.drawable.magic_tower_building_wall));
        row5.add(new CaseBean(14, 5, 5, Monster.MING_ZHAN_SHI, R.drawable.magic_tower_monster_ming_zhan_shi));
        row5.add(new CaseBean(14, 5, 6, Building.WALL, R.drawable.magic_tower_building_wall));
        row5.add(new CaseBean(14, 5, 7, Building.WALL, R.drawable.magic_tower_building_wall));
        row5.add(new CaseBean(14, 5, 8, Prop.XIE_PING_SMALL, R.drawable.magic_tower_prop_xie_ping_small));
        row5.add(new CaseBean(14, 5, 9, Building.ROAD, R.drawable.magic_tower_building_road));
        row5.add(new CaseBean(14, 5, 10, Building.WALL, R.drawable.magic_tower_building_wall));
        floor14.add(row5);

        List<CaseBean> row6 = new ArrayList<>();
        row6.add(new CaseBean(14, 6, 0, Building.WALL, R.drawable.magic_tower_building_wall));
        row6.add(new CaseBean(14, 6, 1, Building.ROAD, R.drawable.magic_tower_building_road));
        row6.add(new CaseBean(14, 6, 2, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row6.add(new CaseBean(14, 6, 3, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row6.add(new CaseBean(14, 6, 4, Building.WALL, R.drawable.magic_tower_building_wall));
        row6.add(new CaseBean(14, 6, 5, Monster.MING_DUI_ZHANG_1, R.drawable.magic_tower_monster_ming_dui_zhang));
        row6.add(new CaseBean(14, 6, 6, Building.WALL, R.drawable.magic_tower_building_wall));
        row6.add(new CaseBean(14, 6, 7, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row6.add(new CaseBean(14, 6, 8, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row6.add(new CaseBean(14, 6, 9, Building.ROAD, R.drawable.magic_tower_building_road));
        row6.add(new CaseBean(14, 6, 10, Building.WALL, R.drawable.magic_tower_building_wall));
        floor14.add(row6);

        List<CaseBean> row7 = new ArrayList<>();
        row7.add(new CaseBean(14, 7, 0, Building.WALL, R.drawable.magic_tower_building_wall));
        row7.add(new CaseBean(14, 7, 1, Building.ROAD, R.drawable.magic_tower_building_road));
        row7.add(new CaseBean(14, 7, 2, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row7.add(new CaseBean(14, 7, 3, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row7.add(new CaseBean(14, 7, 4, Building.WALL, R.drawable.magic_tower_building_wall));
        row7.add(new CaseBean(14, 7, 5, Monster.MING_ZHAN_SHI, R.drawable.magic_tower_monster_ming_zhan_shi));
        row7.add(new CaseBean(14, 7, 6, Building.WALL, R.drawable.magic_tower_building_wall));
        row7.add(new CaseBean(14, 7, 7, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row7.add(new CaseBean(14, 7, 8, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row7.add(new CaseBean(14, 7, 9, Building.ROAD, R.drawable.magic_tower_building_road));
        row7.add(new CaseBean(14, 7, 10, Building.WALL, R.drawable.magic_tower_building_wall));
        floor14.add(row7);

        List<CaseBean> row8 = new ArrayList<>();
        row8.add(new CaseBean(14, 8, 0, Building.WALL, R.drawable.magic_tower_building_wall));
        row8.add(new CaseBean(14, 8, 1, Building.ROAD, R.drawable.magic_tower_building_road));
        row8.add(new CaseBean(14, 8, 2, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row8.add(new CaseBean(14, 8, 3, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row8.add(new CaseBean(14, 8, 4, Building.WALL, R.drawable.magic_tower_building_wall));
        row8.add(new CaseBean(14, 8, 5, Npc.GATE_BLUE, R.drawable.magic_tower_npc_gate_blue_1));
        row8.add(new CaseBean(14, 8, 6, Building.WALL, R.drawable.magic_tower_building_wall));
        row8.add(new CaseBean(14, 8, 7, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row8.add(new CaseBean(14, 8, 8, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row8.add(new CaseBean(14, 8, 9, Building.ROAD, R.drawable.magic_tower_building_road));
        row8.add(new CaseBean(14, 8, 10, Building.WALL, R.drawable.magic_tower_building_wall));
        floor14.add(row8);

        List<CaseBean> row9 = new ArrayList<>();
        row9.add(new CaseBean(14, 9, 0, Building.WALL, R.drawable.magic_tower_building_wall));
        row9.add(new CaseBean(14, 9, 1, Monster.MING_WEI_BING, R.drawable.magic_tower_monster_ming_wei_bing));
        row9.add(new CaseBean(14, 9, 2, Monster.GAO_JI_WEI_BING, R.drawable.magic_tower_monster_gao_ji_wei_bing));
        row9.add(new CaseBean(14, 9, 3, Monster.MING_WEI_BING, R.drawable.magic_tower_monster_ming_wei_bing));
        row9.add(new CaseBean(14, 9, 4, Npc.GATE_BLUE, R.drawable.magic_tower_npc_gate_blue_1));
        row9.add(new CaseBean(14, 9, 5, Building.ROAD, R.drawable.magic_tower_building_road));
        row9.add(new CaseBean(14, 9, 6, Npc.GATE_BLUE, R.drawable.magic_tower_npc_gate_blue_1));
        row9.add(new CaseBean(14, 9, 7, Monster.MING_WEI_BING, R.drawable.magic_tower_monster_ming_wei_bing));
        row9.add(new CaseBean(14, 9, 8, Monster.GAO_JI_WEI_BING, R.drawable.magic_tower_monster_gao_ji_wei_bing));
        row9.add(new CaseBean(14, 9, 9, Monster.MING_WEI_BING, R.drawable.magic_tower_monster_ming_wei_bing));
        row9.add(new CaseBean(14, 9, 10, Building.WALL, R.drawable.magic_tower_building_wall));
        floor14.add(row9);

        List<CaseBean> row10 = new ArrayList<>();
        row10.add(new CaseBean(14, 10, 0, Building.WALL, R.drawable.magic_tower_building_wall));
        row10.add(new CaseBean(14, 10, 1, Building.WALL, R.drawable.magic_tower_building_wall));
        row10.add(new CaseBean(14, 10, 2, Building.WALL, R.drawable.magic_tower_building_wall));
        row10.add(new CaseBean(14, 10, 3, Building.WALL, R.drawable.magic_tower_building_wall));
        row10.add(new CaseBean(14, 10, 4, Building.WALL, R.drawable.magic_tower_building_wall));
        row10.add(new CaseBean(14, 10, 5, Npc.GO_DOWNSTAIRS, R.drawable.magic_tower_npc_go_downstairs));
        row10.add(new CaseBean(14, 10, 6, Building.WALL, R.drawable.magic_tower_building_wall));
        row10.add(new CaseBean(14, 10, 7, Building.WALL, R.drawable.magic_tower_building_wall));
        row10.add(new CaseBean(14, 10, 8, Building.WALL, R.drawable.magic_tower_building_wall));
        row10.add(new CaseBean(14, 10, 9, Building.WALL, R.drawable.magic_tower_building_wall));
        row10.add(new CaseBean(14, 10, 10, Building.WALL, R.drawable.magic_tower_building_wall));
        floor14.add(row10);

        return floor14;
    }

    @Override
    public void fromUpstairsToThisFloor() {
        resetWarriorPosition(0, 5);
    }

    @Override
    public void fromDownstairsToThisFloor() {
        resetWarriorPosition(9, 5);
    }
}
