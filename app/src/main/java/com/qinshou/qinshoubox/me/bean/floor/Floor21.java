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
 * Description:第 21 层
 * Created by 禽兽先生
 * Created on 2018/4/27
 */

public class Floor21 extends AbsFloor {

    @Override
    public int getFloor() {
        return 21;
    }

    @Override
    public List<List<CaseBean>> setData() {
        List<List<CaseBean>> floor21 = new ArrayList<>();
//        List<CaseBean> row0 = new ArrayList<>();
//        row0.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        row0.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        row0.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        row0.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        row0.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        row0.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        row0.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        row0.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        row0.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        row0.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        row0.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        floor21.add(row0);
//
//        List<CaseBean> row1 = new ArrayList<>();
//        row1.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        row1.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        row1.add(new Road());
//        row1.add(new Road());
//        row1.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        row1.add(new CaseBean(IMonster.MING_LING_MO_WANG_2, R.drawable.magic_tower_monster_ming_ling_mo_wang));
//        row1.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        row1.add(new Road());
//        row1.add(new Road());
//        row1.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        row1.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        floor21.add(row1);
//
//        List<CaseBean> row2 = new ArrayList<>();
//        row2.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        row2.add(new Road());
//        row2.add(new Road());
//        row2.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        row2.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        row2.add(new CaseBean(IMonster.LING_FA_SHI_2, R.drawable.magic_tower_monster_ling_fa_shi));
//        row2.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        row2.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        row2.add(new Road());
//        row2.add(new Road());
//        row2.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        floor21.add(row2);
//
//        List<CaseBean> row3 = new ArrayList<>();
//        row3.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        row3.add(new Road());
//        row3.add(new Road());
//        row3.add(new Road());
//        row3.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        row3.add(new CaseBean(IMonster.LING_FA_SHI_2, R.drawable.magic_tower_monster_ling_fa_shi));
//        row3.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        row3.add(new Road());
//        row3.add(new Road());
//        row3.add(new Road());
//        row3.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        floor21.add(row3);
//
//        List<CaseBean> row4 = new ArrayList<>();
//        row4.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        row4.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        row4.add(new Road());
//        row4.add(new Road());
//        row4.add(new Road());
//        row4.add(new Road());
//        row4.add(new Road());
//        row4.add(new Road());
//        row4.add(new Road());
//        row4.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        row4.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        floor21.add(row4);
//
//        List<CaseBean> row5 = new ArrayList<>();
//        row5.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        row5.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        row5.add(new Road());
//        row5.add(new Road());
//        row5.add(new Road());
//        row5.add(new Road());
//        row5.add(new Road());
//        row5.add(new Road());
//        row5.add(new Road());
//        row5.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        row5.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        floor21.add(row5);
//
//        List<CaseBean> row6 = new ArrayList<>();
//        row6.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        row6.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        row6.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        row6.add(new Road());
//        row6.add(new Road());
//        row6.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        row6.add(new Road());
//        row6.add(new Road());
//        row6.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        row6.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        row6.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        floor21.add(row6);
//
//        List<CaseBean> row7 = new ArrayList<>();
//        row7.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        row7.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        row7.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        row7.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        row7.add(new CaseBean(Npc.GATE_IRON_CLOSE, R.drawable.magic_tower_npc_gate_iron_1));
//        row7.add(new GoDownstairs());
//        row7.add(new CaseBean(Npc.GATE_IRON_CLOSE, R.drawable.magic_tower_npc_gate_iron_1));
//        row7.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        row7.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        row7.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        row7.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        floor21.add(row7);
//
//        List<CaseBean> row8 = new ArrayList<>();
//        row8.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        row8.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        row8.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        row8.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        row8.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        row8.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        row8.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        row8.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        row8.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        row8.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        row8.add(new CaseBean(Building.STARRY_SKY, R.drawable.magic_tower_building_starry_sky));
//        floor21.add(row8);
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
//        floor21.add(row9);
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
//        floor21.add(row10);

        return floor21;
    }

    @Override
    public void fromUpstairsToThisFloor() {
//        resetWarriorPosition( 0);
    }

    @Override
    public void fromDownstairsToThisFloor() {
        resetWarriorPosition(new Position(5, 5));
    }
}
