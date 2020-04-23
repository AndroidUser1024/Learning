package com.qinshou.qinshoubox.me.bean.floor;


import com.qinshou.qinshoubox.R;
import com.qinshou.qinshoubox.me.bean.CaseBean;
import com.qinshou.qinshoubox.me.bean.Position;
import com.qinshou.qinshoubox.me.enums.Building;
import com.qinshou.qinshoubox.me.enums.Monster;
import com.qinshou.qinshoubox.me.enums.Npc;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:第 16 层
 * Created by 禽兽先生
 * Created on 2017/4/27
 */

public class Floor16 extends AbsFloor {

    @Override
    public int getFloor() {
        return 16;
    }

    @Override
    public List<List<CaseBean>> setData() {
        List<List<CaseBean>> floor16 = new ArrayList<>();
        List<CaseBean> row0 = new ArrayList<>();
//        row0.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        row0.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        row0.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        row0.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        row0.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        row0.add(new Road());
//        row0.add(new GoDownstairs());
//        row0.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        row0.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        row0.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        row0.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        floor16.add(row0);
//
//        List<CaseBean> row1 = new ArrayList<>();
//        row1.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        row1.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        row1.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        row1.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        row1.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        row1.add(new Road());
//        row1.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        row1.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        row1.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        row1.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        row1.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        floor16.add(row1);
//
//        List<CaseBean> row2 = new ArrayList<>();
//        row2.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        row2.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        row2.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        row2.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        row2.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        row2.add(new Road());
//        row2.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        row2.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        row2.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        row2.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        row2.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        floor16.add(row2);
//
//        List<CaseBean> row3 = new ArrayList<>();
//        row3.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        row3.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        row3.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        row3.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        row3.add(new Wall());
//        row3.add(new Road());
//        row3.add(new Wall());
//        row3.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        row3.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        row3.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        row3.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        floor16.add(row3);
//
//        List<CaseBean> row4 = new ArrayList<>();
//        row4.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        row4.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        row4.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        row4.add(new Wall());
//        row4.add(new Wall());
//        row4.add(new Road());
//        row4.add(new Wall());
//        row4.add(new Wall());
//        row4.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        row4.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        row4.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        floor16.add(row4);
//
//        List<CaseBean> row5 = new ArrayList<>();
//        row5.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        row5.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        row5.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        row5.add(new Wall());
//        row5.add(new Wall());
//        row5.add(new CaseBean(IMonster.HONG_YI_MO_WANG_1, R.drawable.magic_tower_monster_hong_yi_mo_wang));
//        row5.add(new Wall());
//        row5.add(new Wall());
//        row5.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        row5.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        row5.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        floor16.add(row5);
//
//        List<CaseBean> row6 = new ArrayList<>();
//        row6.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        row6.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        row6.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        row6.add(new Wall());
//        row6.add(new Wall());
//        row6.add(new Road());
//        row6.add(new Wall());
//        row6.add(new Wall());
//        row6.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        row6.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        row6.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        floor16.add(row6);
//
//        List<CaseBean> row7 = new ArrayList<>();
//        row7.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        row7.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        row7.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        row7.add(new Wall());
//        row7.add(new Wall());
//        row7.add(new GoUpstairs());
//        row7.add(new Wall());
//        row7.add(new Wall());
//        row7.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        row7.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        row7.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        floor16.add(row7);
//
//        List<CaseBean> row8 = new ArrayList<>();
//        row8.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        row8.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        row8.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        row8.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        row8.add(new Wall());
//        row8.add(new Wall());
//        row8.add(new Wall());
//        row8.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        row8.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        row8.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        row8.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        floor16.add(row8);
//
//        List<CaseBean> row9 = new ArrayList<>();
//        row9.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        row9.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        row9.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        row9.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        row9.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        row9.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        row9.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        row9.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        row9.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        row9.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        row9.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        floor16.add(row9);
//
//        List<CaseBean> row10 = new ArrayList<>();
//        row10.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        row10.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        row10.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        row10.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        row10.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        row10.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        row10.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        row10.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        row10.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        row10.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        row10.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        floor16.add(row10);

        return floor16;
    }

    @Override
    public void fromUpstairsToThisFloor() {
        resetWarriorPosition(new Position(6, 5));
    }

    @Override
    public void fromDownstairsToThisFloor() {
        resetWarriorPosition(new Position(0, 5));
    }
}
