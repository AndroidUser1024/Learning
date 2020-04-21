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
 * Description:第 12 层
 * Created by 禽兽先生
 * Created on 2017/4/27
 */

public class Floor12 extends AbsFloor {

    @Override
    public int getFloor() {
        return 12;
    }

    @Override
    public List<List<CaseBean>> setData() {
        List<List<CaseBean>> floor12 = new ArrayList<>();
        List<CaseBean> row0 = new ArrayList<>();
        row0.add(new CaseBean(12, 0, 0, Npc.SHANG_REN_FLOOR_12, R.drawable.magic_tower_npc_shang_ren));
        row0.add(new CaseBean(12, 0, 1, Prop.BAO_SHI_BLUE, R.drawable.magic_tower_prop_bao_shi_blue));
        row0.add(new CaseBean(12, 0, 2, Building.WALL, R.drawable.magic_tower_building_wall));
        row0.add(new CaseBean(12, 0, 3, Building.ROAD, R.drawable.magic_tower_building_road));
        row0.add(new CaseBean(12, 0, 4, Monster.JIN_WEI_SHI, R.drawable.magic_tower_monster_jin_wei_shi));
        row0.add(new CaseBean(12, 0, 5, Monster.JIN_DUI_ZHANG, R.drawable.magic_tower_monster_jin_dui_zhang));
        row0.add(new CaseBean(12, 0, 6, Monster.JIN_WEI_SHI, R.drawable.magic_tower_monster_jin_wei_shi));
        row0.add(new CaseBean(12, 0, 7, Building.ROAD, R.drawable.magic_tower_building_road));
        row0.add(new CaseBean(12, 0, 8, Building.WALL, R.drawable.magic_tower_building_wall));
        row0.add(new CaseBean(12, 0, 9, Prop.XIE_PING_BIG, R.drawable.magic_tower_prop_xie_ping_big));
        row0.add(new CaseBean(12, 0, 10, Prop.XING_GUANG_SHEN_LANG, R.drawable.magic_tower_prop_xing_guang_shen_lang));
        floor12.add(row0);

        List<CaseBean> row1 = new ArrayList<>();
        row1.add(new CaseBean(12, 1, 0, Prop.BAO_SHI_RED, R.drawable.magic_tower_prop_bao_shi_red));
        row1.add(new CaseBean(12, 1, 1, Building.ROAD, R.drawable.magic_tower_building_road));
        row1.add(new CaseBean(12, 1, 2, Building.WALL, R.drawable.magic_tower_building_wall));
        row1.add(new CaseBean(12, 1, 3, Building.ROAD, R.drawable.magic_tower_building_road));
        row1.add(new CaseBean(12, 1, 4, Building.WALL, R.drawable.magic_tower_building_wall));
        row1.add(new CaseBean(12, 1, 5, Npc.GATE_YELLOW, R.drawable.magic_tower_npc_gate_yellow_1));
        row1.add(new CaseBean(12, 1, 6, Building.WALL, R.drawable.magic_tower_building_wall));
        row1.add(new CaseBean(12, 1, 7, Building.ROAD, R.drawable.magic_tower_building_road));
        row1.add(new CaseBean(12, 1, 8, Building.WALL, R.drawable.magic_tower_building_wall));
        row1.add(new CaseBean(12, 1, 9, Building.ROAD, R.drawable.magic_tower_building_road));
        row1.add(new CaseBean(12, 1, 10, Prop.XIE_PING_BIG, R.drawable.magic_tower_prop_xie_ping_big));
        floor12.add(row1);

        List<CaseBean> row2 = new ArrayList<>();
        row2.add(new CaseBean(12, 2, 0, Building.ROAD, R.drawable.magic_tower_building_road));
        row2.add(new CaseBean(12, 2, 1, Building.ROAD, R.drawable.magic_tower_building_road));
        row2.add(new CaseBean(12, 2, 2, Building.WALL, R.drawable.magic_tower_building_wall));
        row2.add(new CaseBean(12, 2, 3, Building.ROAD, R.drawable.magic_tower_building_road));
        row2.add(new CaseBean(12, 2, 4, Building.WALL, R.drawable.magic_tower_building_wall));
        row2.add(new CaseBean(12, 2, 5, Monster.JIN_DUI_ZHANG, R.drawable.magic_tower_monster_jin_dui_zhang));
        row2.add(new CaseBean(12, 2, 6, Building.WALL, R.drawable.magic_tower_building_wall));
        row2.add(new CaseBean(12, 2, 7, Building.ROAD, R.drawable.magic_tower_building_road));
        row2.add(new CaseBean(12, 2, 8, Building.WALL, R.drawable.magic_tower_building_wall));
        row2.add(new CaseBean(12, 2, 9, Building.ROAD, R.drawable.magic_tower_building_road));
        row2.add(new CaseBean(12, 2, 10, Building.ROAD, R.drawable.magic_tower_building_road));
        floor12.add(row2);

        List<CaseBean> row3 = new ArrayList<>();
        row3.add(new CaseBean(12, 3, 0, Building.ROAD, R.drawable.magic_tower_building_road));
        row3.add(new CaseBean(12, 3, 1, Monster.SHUANG_SHOU_JIAN_SHI, R.drawable.magic_tower_monster_shuang_shou_jian_shi));
        row3.add(new CaseBean(12, 3, 2, Building.WALL, R.drawable.magic_tower_building_wall));
        row3.add(new CaseBean(12, 3, 3, Building.ROAD, R.drawable.magic_tower_building_road));
        row3.add(new CaseBean(12, 3, 4, Building.WALL, R.drawable.magic_tower_building_wall));
        row3.add(new CaseBean(12, 3, 5, Prop.KEY_YELLOW, R.drawable.magic_tower_prop_key_yellow));
        row3.add(new CaseBean(12, 3, 6, Building.WALL, R.drawable.magic_tower_building_wall));
        row3.add(new CaseBean(12, 3, 7, Building.ROAD, R.drawable.magic_tower_building_road));
        row3.add(new CaseBean(12, 3, 8, Building.WALL, R.drawable.magic_tower_building_wall));
        row3.add(new CaseBean(12, 3, 9, Monster.LING_WU_SHI_1, R.drawable.magic_tower_monster_ling_wu_shi));
        row3.add(new CaseBean(12, 3, 10, Building.ROAD, R.drawable.magic_tower_building_road));
        floor12.add(row3);

        List<CaseBean> row4 = new ArrayList<>();
        row4.add(new CaseBean(12, 4, 0, Monster.SHUANG_SHOU_JIAN_SHI, R.drawable.magic_tower_monster_shuang_shou_jian_shi));
        row4.add(new CaseBean(12, 4, 1, Monster.MING_ZHAN_SHI, R.drawable.magic_tower_monster_ming_zhan_shi));
        row4.add(new CaseBean(12, 4, 2, Building.WALL, R.drawable.magic_tower_building_wall));
        row4.add(new CaseBean(12, 4, 3, Building.ROAD, R.drawable.magic_tower_building_road));
        row4.add(new CaseBean(12, 4, 4, Building.WALL, R.drawable.magic_tower_building_wall));
        row4.add(new CaseBean(12, 4, 5, Prop.KEY_YELLOW, R.drawable.magic_tower_prop_key_yellow));
        row4.add(new CaseBean(12, 4, 6, Building.WALL, R.drawable.magic_tower_building_wall));
        row4.add(new CaseBean(12, 4, 7, Building.ROAD, R.drawable.magic_tower_building_road));
        row4.add(new CaseBean(12, 4, 8, Building.WALL, R.drawable.magic_tower_building_wall));
        row4.add(new CaseBean(12, 4, 9, Monster.LING_FA_SHI_1, R.drawable.magic_tower_monster_ling_fa_shi));
        row4.add(new CaseBean(12, 4, 10, Monster.LING_WU_SHI_1, R.drawable.magic_tower_monster_ling_wu_shi));
        floor12.add(row4);

        List<CaseBean> row5 = new ArrayList<>();
        row5.add(new CaseBean(12, 5, 0, Building.WALL, R.drawable.magic_tower_building_wall));
        row5.add(new CaseBean(12, 5, 1, Npc.GATE_BLUE, R.drawable.magic_tower_npc_gate_blue_1));
        row5.add(new CaseBean(12, 5, 2, Building.WALL, R.drawable.magic_tower_building_wall));
        row5.add(new CaseBean(12, 5, 3, Building.ROAD, R.drawable.magic_tower_building_road));
        row5.add(new CaseBean(12, 5, 4, Building.WALL, R.drawable.magic_tower_building_wall));
        row5.add(new CaseBean(12, 5, 5, Prop.XIE_PING_SMALL, R.drawable.magic_tower_prop_xie_ping_small));
        row5.add(new CaseBean(12, 5, 6, Building.WALL, R.drawable.magic_tower_building_wall));
        row5.add(new CaseBean(12, 5, 7, Building.ROAD, R.drawable.magic_tower_building_road));
        row5.add(new CaseBean(12, 5, 8, Building.WALL, R.drawable.magic_tower_building_wall));
        row5.add(new CaseBean(12, 5, 9, Npc.GATE_BLUE, R.drawable.magic_tower_npc_gate_blue_1));
        row5.add(new CaseBean(12, 5, 10, Building.WALL, R.drawable.magic_tower_building_wall));
        floor12.add(row5);

        List<CaseBean> row6 = new ArrayList<>();
        row6.add(new CaseBean(12, 6, 0, Building.ROAD, R.drawable.magic_tower_building_road));
        row6.add(new CaseBean(12, 6, 1, Building.ROAD, R.drawable.magic_tower_building_road));
        row6.add(new CaseBean(12, 6, 2, Building.ROAD, R.drawable.magic_tower_building_road));
        row6.add(new CaseBean(12, 6, 3, Building.ROAD, R.drawable.magic_tower_building_road));
        row6.add(new CaseBean(12, 6, 4, Building.WALL, R.drawable.magic_tower_building_wall));
        row6.add(new CaseBean(12, 6, 5, Prop.XIE_PING_SMALL, R.drawable.magic_tower_prop_xie_ping_small));
        row6.add(new CaseBean(12, 6, 6, Building.WALL, R.drawable.magic_tower_building_wall));
        row6.add(new CaseBean(12, 6, 7, Building.ROAD, R.drawable.magic_tower_building_road));
        row6.add(new CaseBean(12, 6, 8, Building.ROAD, R.drawable.magic_tower_building_road));
        row6.add(new CaseBean(12, 6, 9, Building.ROAD, R.drawable.magic_tower_building_road));
        row6.add(new CaseBean(12, 6, 10, Building.ROAD, R.drawable.magic_tower_building_road));
        floor12.add(row6);

        List<CaseBean> row7 = new ArrayList<>();
        row7.add(new CaseBean(12, 7, 0, Building.WALL, R.drawable.magic_tower_building_wall));
        row7.add(new CaseBean(12, 7, 1, Building.WALL, R.drawable.magic_tower_building_wall));
        row7.add(new CaseBean(12, 7, 2, Building.WALL, R.drawable.magic_tower_building_wall));
        row7.add(new CaseBean(12, 7, 3, Building.ROAD, R.drawable.magic_tower_building_road));
        row7.add(new CaseBean(12, 7, 4, Building.WALL, R.drawable.magic_tower_building_wall));
        row7.add(new CaseBean(12, 7, 5, Building.WALL, R.drawable.magic_tower_building_wall));
        row7.add(new CaseBean(12, 7, 6, Building.WALL, R.drawable.magic_tower_building_wall));
        row7.add(new CaseBean(12, 7, 7, Building.ROAD, R.drawable.magic_tower_building_road));
        row7.add(new CaseBean(12, 7, 8, Building.WALL, R.drawable.magic_tower_building_wall));
        row7.add(new CaseBean(12, 7, 9, Building.WALL, R.drawable.magic_tower_building_wall));
        row7.add(new CaseBean(12, 7, 10, Building.WALL, R.drawable.magic_tower_building_wall));
        floor12.add(row7);

        List<CaseBean> row8 = new ArrayList<>();
        row8.add(new CaseBean(12, 8, 0, Prop.BAO_SHI_BLUE, R.drawable.magic_tower_prop_bao_shi_blue));
        row8.add(new CaseBean(12, 8, 1, Monster.SHUANG_SHOU_JIAN_SHI, R.drawable.magic_tower_monster_shuang_shou_jian_shi));
        row8.add(new CaseBean(12, 8, 2, Npc.GATE_YELLOW, R.drawable.magic_tower_npc_gate_yellow_1));
        row8.add(new CaseBean(12, 8, 3, Monster.MING_WEI_BING, R.drawable.magic_tower_monster_ming_wei_bing));
        row8.add(new CaseBean(12, 8, 4, Monster.MING_WEI_BING, R.drawable.magic_tower_monster_ming_wei_bing));
        row8.add(new CaseBean(12, 8, 5, Monster.GAO_JI_WEI_BING, R.drawable.magic_tower_monster_gao_ji_wei_bing));
        row8.add(new CaseBean(12, 8, 6, Monster.MING_WEI_BING, R.drawable.magic_tower_monster_ming_wei_bing));
        row8.add(new CaseBean(12, 8, 7, Monster.MING_WEI_BING, R.drawable.magic_tower_monster_ming_wei_bing));
        row8.add(new CaseBean(12, 8, 8, Npc.GATE_YELLOW, R.drawable.magic_tower_npc_gate_yellow_1));
        row8.add(new CaseBean(12, 8, 9, Monster.SHUANG_SHOU_JIAN_SHI, R.drawable.magic_tower_monster_shuang_shou_jian_shi));
        row8.add(new CaseBean(12, 8, 10, Prop.BAO_SHI_RED, R.drawable.magic_tower_prop_bao_shi_red));
        floor12.add(row8);

        List<CaseBean> row9 = new ArrayList<>();
        row9.add(new CaseBean(12, 9, 0, Building.WALL, R.drawable.magic_tower_building_wall));
        row9.add(new CaseBean(12, 9, 1, Building.WALL, R.drawable.magic_tower_building_wall));
        row9.add(new CaseBean(12, 9, 2, Building.WALL, R.drawable.magic_tower_building_wall));
        row9.add(new CaseBean(12, 9, 3, Building.WALL, R.drawable.magic_tower_building_wall));
        row9.add(new CaseBean(12, 9, 4, Building.WALL, R.drawable.magic_tower_building_wall));
        row9.add(new CaseBean(12, 9, 5, Npc.GATE_BLUE, R.drawable.magic_tower_npc_gate_blue_1));
        row9.add(new CaseBean(12, 9, 6, Building.WALL, R.drawable.magic_tower_building_wall));
        row9.add(new CaseBean(12, 9, 7, Building.WALL, R.drawable.magic_tower_building_wall));
        row9.add(new CaseBean(12, 9, 8, Building.WALL, R.drawable.magic_tower_building_wall));
        row9.add(new CaseBean(12, 9, 9, Building.WALL, R.drawable.magic_tower_building_wall));
        row9.add(new CaseBean(12, 9, 10, Building.WALL, R.drawable.magic_tower_building_wall));
        floor12.add(row9);

        List<CaseBean> row10 = new ArrayList<>();
        row10.add(new CaseBean(12, 10, 0, Npc.GO_UPSTAIRS, R.drawable.magic_tower_npc_go_upstairs));
        row10.add(new CaseBean(12, 10, 1, Building.ROAD, R.drawable.magic_tower_building_road));
        row10.add(new CaseBean(12, 10, 2, Building.ROAD, R.drawable.magic_tower_building_road));
        row10.add(new CaseBean(12, 10, 3, Building.ROAD, R.drawable.magic_tower_building_road));
        row10.add(new CaseBean(12, 10, 4, Building.ROAD, R.drawable.magic_tower_building_road));
        row10.add(new CaseBean(12, 10, 5, Building.ROAD, R.drawable.magic_tower_building_road));
        row10.add(new CaseBean(12, 10, 6, Building.ROAD, R.drawable.magic_tower_building_road));
        row10.add(new CaseBean(12, 10, 7, Building.ROAD, R.drawable.magic_tower_building_road));
        row10.add(new CaseBean(12, 10, 8, Building.ROAD, R.drawable.magic_tower_building_road));
        row10.add(new CaseBean(12, 10, 9, Building.ROAD, R.drawable.magic_tower_building_road));
        row10.add(new CaseBean(12, 10, 10, Npc.GO_DOWNSTAIRS, R.drawable.magic_tower_npc_go_downstairs));
        floor12.add(row10);

        return floor12;
    }

    @Override
    public void fromUpstairsToThisFloor() {
        resetWarriorPosition(10, 1);
    }

    @Override
    public void fromDownstairsToThisFloor() {
        resetWarriorPosition(10, 9);
    }
}
