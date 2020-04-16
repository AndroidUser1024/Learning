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
 * Description:第 20 层
 * Created by 禽兽先生
 * Created on 2018/4/27
 */

public class Floor20 extends AFloor {

    @Override
    public int getFloor() {
        return 20;
    }

    @Override
    public List<List<CaseBean>> setData() {
        List<List<CaseBean>> floor20 = new ArrayList<>();
        List<CaseBean> row0 = new ArrayList<>();
        row0.add(new CaseBean(20, 0, 0, Monster.YING_ZI_ZHAN_SHI, R.drawable.magic_tower_monster_ying_zi_zhan_shi));
        row0.add(new CaseBean(20, 0, 1, Prop.BAO_SHI_RED, R.drawable.magic_tower_prop_bao_shi_red));
        row0.add(new CaseBean(20, 0, 2, Monster.BAI_YI_WU_SHI, R.drawable.magic_tower_monster_bai_yi_wu_shi));
        row0.add(new CaseBean(20, 0, 3, Prop.XIE_PING_SMALL, R.drawable.magic_tower_prop_xie_ping_small));
        row0.add(new CaseBean(20, 0, 4, Monster.MING_DUI_ZHANG_2, R.drawable.magic_tower_monster_ming_dui_zhang));
        row0.add(new CaseBean(20, 0, 5, Prop.KEY_RED, R.drawable.magic_tower_prop_key_red));
        row0.add(new CaseBean(20, 0, 6, Monster.MING_DUI_ZHANG_2, R.drawable.magic_tower_monster_ming_dui_zhang));
        row0.add(new CaseBean(20, 0, 7, Prop.XIE_PING_SMALL, R.drawable.magic_tower_prop_xie_ping_small));
        row0.add(new CaseBean(20, 0, 8, Monster.BAI_YI_WU_SHI, R.drawable.magic_tower_monster_bai_yi_wu_shi));
        row0.add(new CaseBean(20, 0, 9, Prop.BAO_SHI_RED, R.drawable.magic_tower_prop_bao_shi_red));
        row0.add(new CaseBean(20, 0, 10, Monster.YING_ZI_ZHAN_SHI, R.drawable.magic_tower_monster_ying_zi_zhan_shi));
        floor20.add(row0);

        List<CaseBean> row1 = new ArrayList<>();
        row1.add(new CaseBean(20, 1, 0, Prop.XIE_PING_BIG, R.drawable.magic_tower_prop_xie_ping_big));
        row1.add(new CaseBean(20, 1, 1, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row1.add(new CaseBean(20, 1, 2, Prop.KEY_YELLOW, R.drawable.magic_tower_prop_key_yellow));
        row1.add(new CaseBean(20, 1, 3, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row1.add(new CaseBean(20, 1, 4, Prop.KEY_BLUE, R.drawable.magic_tower_prop_key_blue));
        row1.add(new CaseBean(20, 1, 5, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row1.add(new CaseBean(20, 1, 6, Prop.KEY_BLUE, R.drawable.magic_tower_prop_key_blue));
        row1.add(new CaseBean(20, 1, 7, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row1.add(new CaseBean(20, 1, 8, Prop.KEY_YELLOW, R.drawable.magic_tower_prop_key_yellow));
        row1.add(new CaseBean(20, 1, 9, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row1.add(new CaseBean(20, 1, 10, Prop.XIE_PING_BIG, R.drawable.magic_tower_prop_xie_ping_big));
        floor20.add(row1);

        List<CaseBean> row2 = new ArrayList<>();
        row2.add(new CaseBean(20, 2, 0, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row2.add(new CaseBean(20, 2, 1, Prop.BAO_SHI_BLUE, R.drawable.magic_tower_prop_bao_shi_blue));
        row2.add(new CaseBean(20, 2, 2, Monster.BAI_YI_WU_SHI, R.drawable.magic_tower_monster_bai_yi_wu_shi));
        row2.add(new CaseBean(20, 2, 3, Building.ROAD, R.drawable.magic_tower_building_road));
        row2.add(new CaseBean(20, 2, 4, Monster.LING_WU_SHI_2, R.drawable.magic_tower_monster_ling_wu_shi));
        row2.add(new CaseBean(20, 2, 5, Building.ROAD, R.drawable.magic_tower_building_road));
        row2.add(new CaseBean(20, 2, 6, Monster.LING_WU_SHI_2, R.drawable.magic_tower_monster_ling_wu_shi));
        row2.add(new CaseBean(20, 2, 7, Building.ROAD, R.drawable.magic_tower_building_road));
        row2.add(new CaseBean(20, 2, 8, Monster.BAI_YI_WU_SHI, R.drawable.magic_tower_monster_bai_yi_wu_shi));
        row2.add(new CaseBean(20, 2, 9, Prop.BAO_SHI_BLUE, R.drawable.magic_tower_prop_bao_shi_blue));
        row2.add(new CaseBean(20, 2, 10, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        floor20.add(row2);

        List<CaseBean> row3 = new ArrayList<>();
        row3.add(new CaseBean(20, 3, 0, Prop.XIE_PING_SMALL, R.drawable.magic_tower_prop_xie_ping_small));
        row3.add(new CaseBean(20, 3, 1, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row3.add(new CaseBean(20, 3, 2, Prop.KEY_YELLOW, R.drawable.magic_tower_prop_key_yellow));
        row3.add(new CaseBean(20, 3, 3, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row3.add(new CaseBean(20, 3, 4, Building.ROAD, R.drawable.magic_tower_building_road));
        row3.add(new CaseBean(20, 3, 5, Npc.GO_DOWNSTAIRS, R.drawable.magic_tower_npc_go_downstairs));
        row3.add(new CaseBean(20, 3, 6, Building.ROAD, R.drawable.magic_tower_building_road));
        row3.add(new CaseBean(20, 3, 7, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row3.add(new CaseBean(20, 3, 8, Prop.KEY_YELLOW, R.drawable.magic_tower_prop_key_yellow));
        row3.add(new CaseBean(20, 3, 9, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row3.add(new CaseBean(20, 3, 10, Prop.XIE_PING_SMALL, R.drawable.magic_tower_prop_xie_ping_small));
        floor20.add(row3);

        List<CaseBean> row4 = new ArrayList<>();
        row4.add(new CaseBean(20, 4, 0, Monster.MING_DUI_ZHANG_2, R.drawable.magic_tower_monster_ming_dui_zhang));
        row4.add(new CaseBean(20, 4, 1, Prop.KEY_BLUE, R.drawable.magic_tower_prop_key_blue));
        row4.add(new CaseBean(20, 4, 2, Monster.LING_WU_SHI_2, R.drawable.magic_tower_monster_ling_wu_shi));
        row4.add(new CaseBean(20, 4, 3, Building.ROAD, R.drawable.magic_tower_building_road));
        row4.add(new CaseBean(20, 4, 4, Building.ROAD, R.drawable.magic_tower_building_road));
        row4.add(new CaseBean(20, 4, 5, Building.ROAD, R.drawable.magic_tower_building_road));
        row4.add(new CaseBean(20, 4, 6, Building.ROAD, R.drawable.magic_tower_building_road));
        row4.add(new CaseBean(20, 4, 7, Building.ROAD, R.drawable.magic_tower_building_road));
        row4.add(new CaseBean(20, 4, 8, Monster.LING_WU_SHI_2, R.drawable.magic_tower_monster_ling_wu_shi));
        row4.add(new CaseBean(20, 4, 9, Prop.KEY_BLUE, R.drawable.magic_tower_prop_key_blue));
        row4.add(new CaseBean(20, 4, 10, Monster.MING_DUI_ZHANG_2, R.drawable.magic_tower_monster_ming_dui_zhang));
        floor20.add(row4);

        List<CaseBean> row5 = new ArrayList<>();
        row5.add(new CaseBean(20, 5, 0, Prop.KEY_RED, R.drawable.magic_tower_prop_key_red));
        row5.add(new CaseBean(20, 5, 1, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row5.add(new CaseBean(20, 5, 2, Building.ROAD, R.drawable.magic_tower_building_road));
        row5.add(new CaseBean(20, 5, 3, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row5.add(new CaseBean(20, 5, 4, Building.ROAD, R.drawable.magic_tower_building_road));
        row5.add(new CaseBean(20, 5, 5, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row5.add(new CaseBean(20, 5, 6, Building.ROAD, R.drawable.magic_tower_building_road));
        row5.add(new CaseBean(20, 5, 7, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row5.add(new CaseBean(20, 5, 8, Building.ROAD, R.drawable.magic_tower_building_road));
        row5.add(new CaseBean(20, 5, 9, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row5.add(new CaseBean(20, 5, 10, Prop.KEY_RED, R.drawable.magic_tower_prop_key_red));
        floor20.add(row5);

        List<CaseBean> row6 = new ArrayList<>();
        row6.add(new CaseBean(20, 6, 0, Monster.MING_DUI_ZHANG_2, R.drawable.magic_tower_monster_ming_dui_zhang));
        row6.add(new CaseBean(20, 6, 1, Prop.KEY_BLUE, R.drawable.magic_tower_prop_key_blue));
        row6.add(new CaseBean(20, 6, 2, Monster.LING_WU_SHI_2, R.drawable.magic_tower_monster_ling_wu_shi));
        row6.add(new CaseBean(20, 6, 3, Building.ROAD, R.drawable.magic_tower_building_road));
        row6.add(new CaseBean(20, 6, 4, Building.ROAD, R.drawable.magic_tower_building_road));
        row6.add(new CaseBean(20, 6, 5, Building.ROAD, R.drawable.magic_tower_building_road));
        row6.add(new CaseBean(20, 6, 6, Building.ROAD, R.drawable.magic_tower_building_road));
        row6.add(new CaseBean(20, 6, 7, Building.ROAD, R.drawable.magic_tower_building_road));
        row6.add(new CaseBean(20, 6, 8, Monster.LING_WU_SHI_2, R.drawable.magic_tower_monster_ling_wu_shi));
        row6.add(new CaseBean(20, 6, 9, Prop.KEY_BLUE, R.drawable.magic_tower_prop_key_blue));
        row6.add(new CaseBean(20, 6, 10, Monster.MING_DUI_ZHANG_2, R.drawable.magic_tower_monster_ming_dui_zhang));
        floor20.add(row6);

        List<CaseBean> row7 = new ArrayList<>();
        row7.add(new CaseBean(20, 7, 0, Prop.XIE_PING_SMALL, R.drawable.magic_tower_prop_xie_ping_small));
        row7.add(new CaseBean(20, 7, 1, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row7.add(new CaseBean(20, 7, 2, Prop.KEY_YELLOW, R.drawable.magic_tower_prop_key_yellow));
        row7.add(new CaseBean(20, 7, 3, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row7.add(new CaseBean(20, 7, 4, Building.ROAD, R.drawable.magic_tower_building_road));
        row7.add(new CaseBean(20, 7, 5, Building.ROAD, R.drawable.magic_tower_building_road));
        row7.add(new CaseBean(20, 7, 6, Building.ROAD, R.drawable.magic_tower_building_road));
        row7.add(new CaseBean(20, 7, 7, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row7.add(new CaseBean(20, 7, 8, Prop.KEY_YELLOW, R.drawable.magic_tower_prop_key_yellow));
        row7.add(new CaseBean(20, 7, 9, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row7.add(new CaseBean(20, 7, 10, Prop.XIE_PING_SMALL, R.drawable.magic_tower_prop_xie_ping_small));
        floor20.add(row7);

        List<CaseBean> row8 = new ArrayList<>();
        row8.add(new CaseBean(20, 8, 0, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row8.add(new CaseBean(20, 8, 1, Prop.BAO_SHI_BLUE, R.drawable.magic_tower_prop_bao_shi_blue));
        row8.add(new CaseBean(20, 8, 2, Monster.BAI_YI_WU_SHI, R.drawable.magic_tower_monster_bai_yi_wu_shi));
        row8.add(new CaseBean(20, 8, 3, Building.ROAD, R.drawable.magic_tower_building_road));
        row8.add(new CaseBean(20, 8, 4, Monster.LING_WU_SHI_2, R.drawable.magic_tower_monster_ling_wu_shi));
        row8.add(new CaseBean(20, 8, 5, Building.ROAD, R.drawable.magic_tower_building_road));
        row8.add(new CaseBean(20, 8, 6, Monster.LING_WU_SHI_2, R.drawable.magic_tower_monster_ling_wu_shi));
        row8.add(new CaseBean(20, 8, 7, Building.ROAD, R.drawable.magic_tower_building_road));
        row8.add(new CaseBean(20, 8, 8, Monster.BAI_YI_WU_SHI, R.drawable.magic_tower_monster_bai_yi_wu_shi));
        row8.add(new CaseBean(20, 8, 9, Prop.BAO_SHI_BLUE, R.drawable.magic_tower_prop_bao_shi_blue));
        row8.add(new CaseBean(20, 8, 10, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        floor20.add(row8);

        List<CaseBean> row9 = new ArrayList<>();
        row9.add(new CaseBean(20, 9, 0, Prop.XIE_PING_BIG, R.drawable.magic_tower_prop_xie_ping_big));
        row9.add(new CaseBean(20, 9, 1, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row9.add(new CaseBean(20, 9, 2, Prop.KEY_YELLOW, R.drawable.magic_tower_prop_key_yellow));
        row9.add(new CaseBean(20, 9, 3, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row9.add(new CaseBean(20, 9, 4, Prop.KEY_BLUE, R.drawable.magic_tower_prop_key_blue));
        row9.add(new CaseBean(20, 9, 5, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row9.add(new CaseBean(20, 9, 6, Prop.KEY_BLUE, R.drawable.magic_tower_prop_key_blue));
        row9.add(new CaseBean(20, 9, 7, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row9.add(new CaseBean(20, 9, 8, Prop.KEY_YELLOW, R.drawable.magic_tower_prop_key_yellow));
        row9.add(new CaseBean(20, 9, 9, Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row9.add(new CaseBean(20, 9, 10, Prop.XIE_PING_BIG, R.drawable.magic_tower_prop_xie_ping_big));
        floor20.add(row9);

        List<CaseBean> row10 = new ArrayList<>();
        row10.add(new CaseBean(20, 10, 0, Monster.YING_ZI_ZHAN_SHI, R.drawable.magic_tower_monster_ying_zi_zhan_shi));
        row10.add(new CaseBean(20, 10, 1, Prop.BAO_SHI_RED, R.drawable.magic_tower_prop_bao_shi_red));
        row10.add(new CaseBean(20, 10, 2, Monster.BAI_YI_WU_SHI, R.drawable.magic_tower_monster_bai_yi_wu_shi));
        row10.add(new CaseBean(20, 10, 3, Prop.XIE_PING_SMALL, R.drawable.magic_tower_prop_xie_ping_small));
        row10.add(new CaseBean(20, 10, 4, Monster.MING_DUI_ZHANG_2, R.drawable.magic_tower_monster_ming_dui_zhang));
        row10.add(new CaseBean(20, 10, 5, Prop.KEY_RED, R.drawable.magic_tower_prop_key_red));
        row10.add(new CaseBean(20, 10, 6, Monster.MING_DUI_ZHANG_2, R.drawable.magic_tower_monster_ming_dui_zhang));
        row10.add(new CaseBean(20, 10, 7, Prop.XIE_PING_SMALL, R.drawable.magic_tower_prop_xie_ping_small));
        row10.add(new CaseBean(20, 10, 8, Monster.BAI_YI_WU_SHI, R.drawable.magic_tower_monster_bai_yi_wu_shi));
        row10.add(new CaseBean(20, 10, 9, Prop.BAO_SHI_RED, R.drawable.magic_tower_prop_bao_shi_red));
        row10.add(new CaseBean(20, 10, 10, Monster.YING_ZI_ZHAN_SHI, R.drawable.magic_tower_monster_ying_zi_zhan_shi));
        floor20.add(row10);

        return floor20;
    }

    @Override
    public void fromUpstairsToThisFloor() {
//        resetWarriorPosition(0, 0);
    }

    @Override
    public void fromDownstairsToThisFloor() {
        resetWarriorPosition(4, 5);
    }
}
