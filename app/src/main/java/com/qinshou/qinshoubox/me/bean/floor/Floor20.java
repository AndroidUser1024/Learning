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
//        List<CaseBean> row0 = new ArrayList<>();
//        row0.add(new CaseBean(IMonster.YING_ZI_ZHAN_SHI, R.drawable.magic_tower_monster_ying_zi_zhan_shi));
//        row0.add(new RedGem());
//        row0.add(new CaseBean(IMonster.BAI_YI_WU_SHI, R.drawable.magic_tower_monster_bai_yi_wu_shi));
//        row0.add(new SmallBloodBottle());
//        row0.add(new CaseBean(IMonster.MING_DUI_ZHANG_2, R.drawable.magic_tower_monster_ming_dui_zhang));
//        row0.add(new RedKey());
//        row0.add(new CaseBean(IMonster.MING_DUI_ZHANG_2, R.drawable.magic_tower_monster_ming_dui_zhang));
//        row0.add(new SmallBloodBottle());
//        row0.add(new CaseBean(IMonster.BAI_YI_WU_SHI, R.drawable.magic_tower_monster_bai_yi_wu_shi));
//        row0.add(new RedGem());
//        row0.add(new CaseBean(IMonster.YING_ZI_ZHAN_SHI, R.drawable.magic_tower_monster_ying_zi_zhan_shi));
//        floor20.add(row0);
//
//        List<CaseBean> row1 = new ArrayList<>();
//        row1.add(new BigBloodBottle());
//        row1.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        row1.add(new YellowKey());
//        row1.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        row1.add(new BlueKey());
//        row1.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        row1.add(new BlueKey());
//        row1.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        row1.add(new YellowKey());
//        row1.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        row1.add(new BigBloodBottle());
//        floor20.add(row1);
//
//        List<CaseBean> row2 = new ArrayList<>();
//        row2.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        row2.add(new BlueGem());
//        row2.add(new CaseBean(IMonster.BAI_YI_WU_SHI, R.drawable.magic_tower_monster_bai_yi_wu_shi));
//        row2.add(new Road());
//        row2.add(new CaseBean(IMonster.LING_WU_SHI_2, R.drawable.magic_tower_monster_ling_wu_shi));
//        row2.add(new Road());
//        row2.add(new CaseBean(IMonster.LING_WU_SHI_2, R.drawable.magic_tower_monster_ling_wu_shi));
//        row2.add(new Road());
//        row2.add(new CaseBean(IMonster.BAI_YI_WU_SHI, R.drawable.magic_tower_monster_bai_yi_wu_shi));
//        row2.add(new BlueGem());
//        row2.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        floor20.add(row2);
//
//        List<CaseBean> row3 = new ArrayList<>();
//        row3.add(new SmallBloodBottle());
//        row3.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        row3.add(new YellowKey());
//        row3.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        row3.add(new Road());
//        row3.add(new GoDownstairs());
//        row3.add(new Road());
//        row3.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        row3.add(new YellowKey());
//        row3.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        row3.add(new SmallBloodBottle());
//        floor20.add(row3);
//
//        List<CaseBean> row4 = new ArrayList<>();
//        row4.add(new CaseBean(IMonster.MING_DUI_ZHANG_2, R.drawable.magic_tower_monster_ming_dui_zhang));
//        row4.add(new BlueKey());
//        row4.add(new CaseBean(IMonster.LING_WU_SHI_2, R.drawable.magic_tower_monster_ling_wu_shi));
//        row4.add(new Road());
//        row4.add(new Road());
//        row4.add(new Road());
//        row4.add(new Road());
//        row4.add(new Road());
//        row4.add(new CaseBean(IMonster.LING_WU_SHI_2, R.drawable.magic_tower_monster_ling_wu_shi));
//        row4.add(new BlueKey());
//        row4.add(new CaseBean(IMonster.MING_DUI_ZHANG_2, R.drawable.magic_tower_monster_ming_dui_zhang));
//        floor20.add(row4);
//
//        List<CaseBean> row5 = new ArrayList<>();
//        row5.add(new RedKey());
//        row5.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        row5.add(new Road());
//        row5.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        row5.add(new Road());
//        row5.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        row5.add(new Road());
//        row5.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        row5.add(new Road());
//        row5.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        row5.add(new RedKey());
//        floor20.add(row5);
//
//        List<CaseBean> row6 = new ArrayList<>();
//        row6.add(new CaseBean(IMonster.MING_DUI_ZHANG_2, R.drawable.magic_tower_monster_ming_dui_zhang));
//        row6.add(new BlueKey());
//        row6.add(new CaseBean(IMonster.LING_WU_SHI_2, R.drawable.magic_tower_monster_ling_wu_shi));
//        row6.add(new Road());
//        row6.add(new Road());
//        row6.add(new Road());
//        row6.add(new Road());
//        row6.add(new Road());
//        row6.add(new CaseBean(IMonster.LING_WU_SHI_2, R.drawable.magic_tower_monster_ling_wu_shi));
//        row6.add(new BlueKey());
//        row6.add(new CaseBean(IMonster.MING_DUI_ZHANG_2, R.drawable.magic_tower_monster_ming_dui_zhang));
//        floor20.add(row6);
//
//        List<CaseBean> row7 = new ArrayList<>();
//        row7.add(new SmallBloodBottle());
//        row7.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        row7.add(new YellowKey());
//        row7.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        row7.add(new Road());
//        row7.add(new Road());
//        row7.add(new Road());
//        row7.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        row7.add(new YellowKey());
//        row7.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        row7.add(new SmallBloodBottle());
//        floor20.add(row7);
//
//        List<CaseBean> row8 = new ArrayList<>();
//        row8.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        row8.add(new BlueGem());
//        row8.add(new CaseBean(IMonster.BAI_YI_WU_SHI, R.drawable.magic_tower_monster_bai_yi_wu_shi));
//        row8.add(new Road());
//        row8.add(new CaseBean(IMonster.LING_WU_SHI_2, R.drawable.magic_tower_monster_ling_wu_shi));
//        row8.add(new Road());
//        row8.add(new CaseBean(IMonster.LING_WU_SHI_2, R.drawable.magic_tower_monster_ling_wu_shi));
//        row8.add(new Road());
//        row8.add(new CaseBean(IMonster.BAI_YI_WU_SHI, R.drawable.magic_tower_monster_bai_yi_wu_shi));
//        row8.add(new BlueGem());
//        row8.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        floor20.add(row8);
//
//        List<CaseBean> row9 = new ArrayList<>();
//        row9.add(new BigBloodBottle());
//        row9.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        row9.add(new YellowKey());
//        row9.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        row9.add(new BlueKey());
//        row9.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        row9.add(new BlueKey());
//        row9.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        row9.add(new YellowKey());
//        row9.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        row9.add(new BigBloodBottle());
//        floor20.add(row9);
//
//        List<CaseBean> row10 = new ArrayList<>();
//        row10.add(new CaseBean(IMonster.YING_ZI_ZHAN_SHI, R.drawable.magic_tower_monster_ying_zi_zhan_shi));
//        row10.add(new RedGem());
//        row10.add(new CaseBean(IMonster.BAI_YI_WU_SHI, R.drawable.magic_tower_monster_bai_yi_wu_shi));
//        row10.add(new SmallBloodBottle());
//        row10.add(new CaseBean(IMonster.MING_DUI_ZHANG_2, R.drawable.magic_tower_monster_ming_dui_zhang));
//        row10.add(new RedKey());
//        row10.add(new CaseBean(IMonster.MING_DUI_ZHANG_2, R.drawable.magic_tower_monster_ming_dui_zhang));
//        row10.add(new SmallBloodBottle());
//        row10.add(new CaseBean(IMonster.BAI_YI_WU_SHI, R.drawable.magic_tower_monster_bai_yi_wu_shi));
//        row10.add(new RedGem());
//        row10.add(new CaseBean(IMonster.YING_ZI_ZHAN_SHI, R.drawable.magic_tower_monster_ying_zi_zhan_shi));
//        floor20.add(row10);

        return floor20;
    }

    @Override
    public void fromUpstairsToThisFloor() {
//        resetWarriorPosition( 0);
    }

    @Override
    public void fromDownstairsToThisFloor() {
        resetWarriorPosition(new Position(4, 5));
    }
}
