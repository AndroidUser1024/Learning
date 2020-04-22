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

public class Floor20 extends AbsFloor {

    @Override
    public int getFloor() {
        return 20;
    }

    @Override
    public List<List<CaseBean>> setData() {
        List<List<CaseBean>> floor20 = new ArrayList<>();
        List<CaseBean> row0 = new ArrayList<>();
        row0.add(new CaseBean(Monster.YING_ZI_ZHAN_SHI, R.drawable.magic_tower_monster_ying_zi_zhan_shi));
        row0.add(new CaseBean(Prop.BAO_SHI_RED, R.drawable.magic_tower_prop_bao_shi_red));
        row0.add(new CaseBean(Monster.BAI_YI_WU_SHI, R.drawable.magic_tower_monster_bai_yi_wu_shi));
        row0.add(new CaseBean(Prop.XIE_PING_SMALL, R.drawable.magic_tower_prop_xie_ping_small));
        row0.add(new CaseBean(Monster.MING_DUI_ZHANG_2, R.drawable.magic_tower_monster_ming_dui_zhang));
        row0.add(new CaseBean(Prop.KEY_RED, R.drawable.magic_tower_prop_key_red));
        row0.add(new CaseBean(Monster.MING_DUI_ZHANG_2, R.drawable.magic_tower_monster_ming_dui_zhang));
        row0.add(new CaseBean(Prop.XIE_PING_SMALL, R.drawable.magic_tower_prop_xie_ping_small));
        row0.add(new CaseBean(Monster.BAI_YI_WU_SHI, R.drawable.magic_tower_monster_bai_yi_wu_shi));
        row0.add(new CaseBean(Prop.BAO_SHI_RED, R.drawable.magic_tower_prop_bao_shi_red));
        row0.add(new CaseBean(Monster.YING_ZI_ZHAN_SHI, R.drawable.magic_tower_monster_ying_zi_zhan_shi));
        floor20.add(row0);

        List<CaseBean> row1 = new ArrayList<>();
        row1.add(new CaseBean(Prop.XIE_PING_BIG, R.drawable.magic_tower_prop_xie_ping_big));
        row1.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row1.add(new CaseBean(Prop.KEY_YELLOW, R.drawable.magic_tower_prop_key_yellow));
        row1.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row1.add(new CaseBean(Prop.KEY_BLUE, R.drawable.magic_tower_prop_key_blue));
        row1.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row1.add(new CaseBean(Prop.KEY_BLUE, R.drawable.magic_tower_prop_key_blue));
        row1.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row1.add(new CaseBean(Prop.KEY_YELLOW, R.drawable.magic_tower_prop_key_yellow));
        row1.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row1.add(new CaseBean(Prop.XIE_PING_BIG, R.drawable.magic_tower_prop_xie_ping_big));
        floor20.add(row1);

        List<CaseBean> row2 = new ArrayList<>();
        row2.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row2.add(new CaseBean(Prop.BAO_SHI_BLUE, R.drawable.magic_tower_prop_bao_shi_blue));
        row2.add(new CaseBean(Monster.BAI_YI_WU_SHI, R.drawable.magic_tower_monster_bai_yi_wu_shi));
        row2.add(new CaseBean(Building.ROAD, R.drawable.magic_tower_building_road));
        row2.add(new CaseBean(Monster.LING_WU_SHI_2, R.drawable.magic_tower_monster_ling_wu_shi));
        row2.add(new CaseBean(Building.ROAD, R.drawable.magic_tower_building_road));
        row2.add(new CaseBean(Monster.LING_WU_SHI_2, R.drawable.magic_tower_monster_ling_wu_shi));
        row2.add(new CaseBean(Building.ROAD, R.drawable.magic_tower_building_road));
        row2.add(new CaseBean(Monster.BAI_YI_WU_SHI, R.drawable.magic_tower_monster_bai_yi_wu_shi));
        row2.add(new CaseBean(Prop.BAO_SHI_BLUE, R.drawable.magic_tower_prop_bao_shi_blue));
        row2.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        floor20.add(row2);

        List<CaseBean> row3 = new ArrayList<>();
        row3.add(new CaseBean(Prop.XIE_PING_SMALL, R.drawable.magic_tower_prop_xie_ping_small));
        row3.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row3.add(new CaseBean(Prop.KEY_YELLOW, R.drawable.magic_tower_prop_key_yellow));
        row3.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row3.add(new CaseBean(Building.ROAD, R.drawable.magic_tower_building_road));
        row3.add(new CaseBean(Npc.GO_DOWNSTAIRS, R.drawable.magic_tower_npc_go_downstairs));
        row3.add(new CaseBean(Building.ROAD, R.drawable.magic_tower_building_road));
        row3.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row3.add(new CaseBean(Prop.KEY_YELLOW, R.drawable.magic_tower_prop_key_yellow));
        row3.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row3.add(new CaseBean(Prop.XIE_PING_SMALL, R.drawable.magic_tower_prop_xie_ping_small));
        floor20.add(row3);

        List<CaseBean> row4 = new ArrayList<>();
        row4.add(new CaseBean(Monster.MING_DUI_ZHANG_2, R.drawable.magic_tower_monster_ming_dui_zhang));
        row4.add(new CaseBean(Prop.KEY_BLUE, R.drawable.magic_tower_prop_key_blue));
        row4.add(new CaseBean(Monster.LING_WU_SHI_2, R.drawable.magic_tower_monster_ling_wu_shi));
        row4.add(new CaseBean(Building.ROAD, R.drawable.magic_tower_building_road));
        row4.add(new CaseBean(Building.ROAD, R.drawable.magic_tower_building_road));
        row4.add(new CaseBean(Building.ROAD, R.drawable.magic_tower_building_road));
        row4.add(new CaseBean(Building.ROAD, R.drawable.magic_tower_building_road));
        row4.add(new CaseBean(Building.ROAD, R.drawable.magic_tower_building_road));
        row4.add(new CaseBean(Monster.LING_WU_SHI_2, R.drawable.magic_tower_monster_ling_wu_shi));
        row4.add(new CaseBean(Prop.KEY_BLUE, R.drawable.magic_tower_prop_key_blue));
        row4.add(new CaseBean(Monster.MING_DUI_ZHANG_2, R.drawable.magic_tower_monster_ming_dui_zhang));
        floor20.add(row4);

        List<CaseBean> row5 = new ArrayList<>();
        row5.add(new CaseBean(Prop.KEY_RED, R.drawable.magic_tower_prop_key_red));
        row5.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row5.add(new CaseBean(Building.ROAD, R.drawable.magic_tower_building_road));
        row5.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row5.add(new CaseBean(Building.ROAD, R.drawable.magic_tower_building_road));
        row5.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row5.add(new CaseBean(Building.ROAD, R.drawable.magic_tower_building_road));
        row5.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row5.add(new CaseBean(Building.ROAD, R.drawable.magic_tower_building_road));
        row5.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row5.add(new CaseBean(Prop.KEY_RED, R.drawable.magic_tower_prop_key_red));
        floor20.add(row5);

        List<CaseBean> row6 = new ArrayList<>();
        row6.add(new CaseBean(Monster.MING_DUI_ZHANG_2, R.drawable.magic_tower_monster_ming_dui_zhang));
        row6.add(new CaseBean(Prop.KEY_BLUE, R.drawable.magic_tower_prop_key_blue));
        row6.add(new CaseBean(Monster.LING_WU_SHI_2, R.drawable.magic_tower_monster_ling_wu_shi));
        row6.add(new CaseBean(Building.ROAD, R.drawable.magic_tower_building_road));
        row6.add(new CaseBean(Building.ROAD, R.drawable.magic_tower_building_road));
        row6.add(new CaseBean(Building.ROAD, R.drawable.magic_tower_building_road));
        row6.add(new CaseBean(Building.ROAD, R.drawable.magic_tower_building_road));
        row6.add(new CaseBean(Building.ROAD, R.drawable.magic_tower_building_road));
        row6.add(new CaseBean(Monster.LING_WU_SHI_2, R.drawable.magic_tower_monster_ling_wu_shi));
        row6.add(new CaseBean(Prop.KEY_BLUE, R.drawable.magic_tower_prop_key_blue));
        row6.add(new CaseBean(Monster.MING_DUI_ZHANG_2, R.drawable.magic_tower_monster_ming_dui_zhang));
        floor20.add(row6);

        List<CaseBean> row7 = new ArrayList<>();
        row7.add(new CaseBean(Prop.XIE_PING_SMALL, R.drawable.magic_tower_prop_xie_ping_small));
        row7.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row7.add(new CaseBean(Prop.KEY_YELLOW, R.drawable.magic_tower_prop_key_yellow));
        row7.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row7.add(new CaseBean(Building.ROAD, R.drawable.magic_tower_building_road));
        row7.add(new CaseBean(Building.ROAD, R.drawable.magic_tower_building_road));
        row7.add(new CaseBean(Building.ROAD, R.drawable.magic_tower_building_road));
        row7.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row7.add(new CaseBean(Prop.KEY_YELLOW, R.drawable.magic_tower_prop_key_yellow));
        row7.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row7.add(new CaseBean(Prop.XIE_PING_SMALL, R.drawable.magic_tower_prop_xie_ping_small));
        floor20.add(row7);

        List<CaseBean> row8 = new ArrayList<>();
        row8.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row8.add(new CaseBean(Prop.BAO_SHI_BLUE, R.drawable.magic_tower_prop_bao_shi_blue));
        row8.add(new CaseBean(Monster.BAI_YI_WU_SHI, R.drawable.magic_tower_monster_bai_yi_wu_shi));
        row8.add(new CaseBean(Building.ROAD, R.drawable.magic_tower_building_road));
        row8.add(new CaseBean(Monster.LING_WU_SHI_2, R.drawable.magic_tower_monster_ling_wu_shi));
        row8.add(new CaseBean(Building.ROAD, R.drawable.magic_tower_building_road));
        row8.add(new CaseBean(Monster.LING_WU_SHI_2, R.drawable.magic_tower_monster_ling_wu_shi));
        row8.add(new CaseBean(Building.ROAD, R.drawable.magic_tower_building_road));
        row8.add(new CaseBean(Monster.BAI_YI_WU_SHI, R.drawable.magic_tower_monster_bai_yi_wu_shi));
        row8.add(new CaseBean(Prop.BAO_SHI_BLUE, R.drawable.magic_tower_prop_bao_shi_blue));
        row8.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        floor20.add(row8);

        List<CaseBean> row9 = new ArrayList<>();
        row9.add(new CaseBean(Prop.XIE_PING_BIG, R.drawable.magic_tower_prop_xie_ping_big));
        row9.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row9.add(new CaseBean(Prop.KEY_YELLOW, R.drawable.magic_tower_prop_key_yellow));
        row9.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row9.add(new CaseBean(Prop.KEY_BLUE, R.drawable.magic_tower_prop_key_blue));
        row9.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row9.add(new CaseBean(Prop.KEY_BLUE, R.drawable.magic_tower_prop_key_blue));
        row9.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row9.add(new CaseBean(Prop.KEY_YELLOW, R.drawable.magic_tower_prop_key_yellow));
        row9.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
        row9.add(new CaseBean(Prop.XIE_PING_BIG, R.drawable.magic_tower_prop_xie_ping_big));
        floor20.add(row9);

        List<CaseBean> row10 = new ArrayList<>();
        row10.add(new CaseBean(Monster.YING_ZI_ZHAN_SHI, R.drawable.magic_tower_monster_ying_zi_zhan_shi));
        row10.add(new CaseBean(Prop.BAO_SHI_RED, R.drawable.magic_tower_prop_bao_shi_red));
        row10.add(new CaseBean(Monster.BAI_YI_WU_SHI, R.drawable.magic_tower_monster_bai_yi_wu_shi));
        row10.add(new CaseBean(Prop.XIE_PING_SMALL, R.drawable.magic_tower_prop_xie_ping_small));
        row10.add(new CaseBean(Monster.MING_DUI_ZHANG_2, R.drawable.magic_tower_monster_ming_dui_zhang));
        row10.add(new CaseBean(Prop.KEY_RED, R.drawable.magic_tower_prop_key_red));
        row10.add(new CaseBean(Monster.MING_DUI_ZHANG_2, R.drawable.magic_tower_monster_ming_dui_zhang));
        row10.add(new CaseBean(Prop.XIE_PING_SMALL, R.drawable.magic_tower_prop_xie_ping_small));
        row10.add(new CaseBean(Monster.BAI_YI_WU_SHI, R.drawable.magic_tower_monster_bai_yi_wu_shi));
        row10.add(new CaseBean(Prop.BAO_SHI_RED, R.drawable.magic_tower_prop_bao_shi_red));
        row10.add(new CaseBean(Monster.YING_ZI_ZHAN_SHI, R.drawable.magic_tower_monster_ying_zi_zhan_shi));
        floor20.add(row10);

        return floor20;
    }

    @Override
    public void fromUpstairsToThisFloor() {
//        resetWarriorPosition( 0);
    }

    @Override
    public void fromDownstairsToThisFloor() {
        resetWarriorPosition(4, 5);
    }
}
