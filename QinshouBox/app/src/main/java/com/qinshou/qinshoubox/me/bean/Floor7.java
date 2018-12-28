package com.qinshou.qinshoubox.me.bean;


import java.util.ArrayList;
import java.util.List;

/**
 * Description:第 7 层
 * Created by 禽兽先生
 * Created on 2017/4/26
 */

public class Floor7 extends AFloor {

    @Override
    public int getFloor() {
        return 7;
    }

    @Override
    public List<List<CaseBean>> setData() {
        List<List<CaseBean>> floor7 = new ArrayList<>();
        List<CaseBean> row0 = new ArrayList<>();
        row0.add(new CaseBean(7, 0, 0, CaseBean.NPC_GO_UPSTAIRS));
        row0.add(new CaseBean(7, 0, 1, CaseBean.BUILDING_ROAD));
        row0.add(new CaseBean(7, 0, 2, CaseBean.BUILDING_ROAD));
        row0.add(new CaseBean(7, 0, 3, CaseBean.BUILDING_ROAD));
        row0.add(new CaseBean(7, 0, 4, CaseBean.BUILDING_ROAD));
        row0.add(new CaseBean(7, 0, 5, CaseBean.BUILDING_ROAD));
        row0.add(new CaseBean(7, 0, 6, CaseBean.BUILDING_ROAD));
        row0.add(new CaseBean(7, 0, 7, CaseBean.BUILDING_ROAD));
        row0.add(new CaseBean(7, 0, 8, CaseBean.BUILDING_WALL));
        row0.add(new CaseBean(7, 0, 9, CaseBean.BUILDING_WALL));
        row0.add(new CaseBean(7, 0, 10, CaseBean.BUILDING_WALL));
        floor7.add(row0);

        List<CaseBean> row1 = new ArrayList<>();
        row1.add(new CaseBean(7, 1, 0, CaseBean.BUILDING_WALL));
        row1.add(new CaseBean(7, 1, 1, CaseBean.BUILDING_WALL));
        row1.add(new CaseBean(7, 1, 2, CaseBean.BUILDING_ROAD));
        row1.add(new CaseBean(7, 1, 3, CaseBean.MONSTER_HONG_BIAN_FU));
        row1.add(new CaseBean(7, 1, 4, CaseBean.BUILDING_WALL));
        row1.add(new CaseBean(7, 1, 5, CaseBean.NPC_GATE_BLUE));
        row1.add(new CaseBean(7, 1, 6, CaseBean.BUILDING_WALL));
        row1.add(new CaseBean(7, 1, 7, CaseBean.MONSTER_KU_LOU_DUI_ZHANG));
        row1.add(new CaseBean(7, 1, 8, CaseBean.BUILDING_ROAD));
        row1.add(new CaseBean(7, 1, 9, CaseBean.BUILDING_WALL));
        row1.add(new CaseBean(7, 1, 10, CaseBean.BUILDING_WALL));
        floor7.add(row1);

        List<CaseBean> row2 = new ArrayList<>();
        row2.add(new CaseBean(7, 2, 0, CaseBean.BUILDING_WALL));
        row2.add(new CaseBean(7, 2, 1, CaseBean.BUILDING_ROAD));
        row2.add(new CaseBean(7, 2, 2, CaseBean.MONSTER_HONG_BIAN_FU));
        row2.add(new CaseBean(7, 2, 3, CaseBean.PROP_BAO_SHI_BLUE));
        row2.add(new CaseBean(7, 2, 4, CaseBean.BUILDING_WALL));
        row2.add(new CaseBean(7, 2, 5, CaseBean.MONSTER_BAI_YI_WU_SHI));
        row2.add(new CaseBean(7, 2, 6, CaseBean.BUILDING_WALL));
        row2.add(new CaseBean(7, 2, 7, CaseBean.PROP_BAO_SHI_RED));
        row2.add(new CaseBean(7, 2, 8, CaseBean.MONSTER_KU_LOU_DUI_ZHANG));
        row2.add(new CaseBean(7, 2, 9, CaseBean.BUILDING_ROAD));
        row2.add(new CaseBean(7, 2, 10, CaseBean.BUILDING_WALL));
        floor7.add(row2);

        List<CaseBean> row3 = new ArrayList<>();
        row3.add(new CaseBean(7, 3, 0, CaseBean.BUILDING_ROAD));
        row3.add(new CaseBean(7, 3, 1, CaseBean.BUILDING_ROAD));
        row3.add(new CaseBean(7, 3, 2, CaseBean.BUILDING_WALL));
        row3.add(new CaseBean(7, 3, 3, CaseBean.BUILDING_WALL));
        row3.add(new CaseBean(7, 3, 4, CaseBean.BUILDING_WALL));
        row3.add(new CaseBean(7, 3, 5, CaseBean.NPC_GATE_IRON_CLOSE));
        row3.add(new CaseBean(7, 3, 6, CaseBean.BUILDING_WALL));
        row3.add(new CaseBean(7, 3, 7, CaseBean.BUILDING_WALL));
        row3.add(new CaseBean(7, 3, 8, CaseBean.BUILDING_WALL));
        row3.add(new CaseBean(7, 3, 9, CaseBean.BUILDING_ROAD));
        row3.add(new CaseBean(7, 3, 10, CaseBean.BUILDING_ROAD));
        floor7.add(row3);

        List<CaseBean> row4 = new ArrayList<>();
        row4.add(new CaseBean(7, 4, 0, CaseBean.BUILDING_ROAD));
        row4.add(new CaseBean(7, 4, 1, CaseBean.BUILDING_ROAD));
        row4.add(new CaseBean(7, 4, 2, CaseBean.NPC_GATE_BLUE));
        row4.add(new CaseBean(7, 4, 3, CaseBean.MONSTER_BAI_YI_WU_SHI));
        row4.add(new CaseBean(7, 4, 4, CaseBean.NPC_GATE_IRON_OPEN));
        row4.add(new CaseBean(7, 4, 5, CaseBean.PROP_XING_YUN_SHI_ZI_JIA));
        row4.add(new CaseBean(7, 4, 6, CaseBean.NPC_GATE_IRON_CLOSE));
        row4.add(new CaseBean(7, 4, 7, CaseBean.MONSTER_BAI_YI_WU_SHI));
        row4.add(new CaseBean(7, 4, 8, CaseBean.NPC_GATE_BLUE));
        row4.add(new CaseBean(7, 4, 9, CaseBean.BUILDING_ROAD));
        row4.add(new CaseBean(7, 4, 10, CaseBean.BUILDING_ROAD));
        floor7.add(row4);

        List<CaseBean> row5 = new ArrayList<>();
        row5.add(new CaseBean(7, 5, 0, CaseBean.BUILDING_ROAD));
        row5.add(new CaseBean(7, 5, 1, CaseBean.BUILDING_WALL));
        row5.add(new CaseBean(7, 5, 2, CaseBean.BUILDING_WALL));
        row5.add(new CaseBean(7, 5, 3, CaseBean.BUILDING_WALL));
        row5.add(new CaseBean(7, 5, 4, CaseBean.BUILDING_WALL));
        row5.add(new CaseBean(7, 5, 5, CaseBean.NPC_GATE_IRON_CLOSE));
        row5.add(new CaseBean(7, 5, 6, CaseBean.BUILDING_WALL));
        row5.add(new CaseBean(7, 5, 7, CaseBean.BUILDING_WALL));
        row5.add(new CaseBean(7, 5, 8, CaseBean.BUILDING_WALL));
        row5.add(new CaseBean(7, 5, 9, CaseBean.BUILDING_WALL));
        row5.add(new CaseBean(7, 5, 10, CaseBean.BUILDING_ROAD));
        floor7.add(row5);

        List<CaseBean> row6 = new ArrayList<>();
        row6.add(new CaseBean(7, 6, 0, CaseBean.BUILDING_ROAD));
        row6.add(new CaseBean(7, 6, 1, CaseBean.BUILDING_WALL));
        row6.add(new CaseBean(7, 6, 2, CaseBean.PROP_XIE_PING_SMALL));
        row6.add(new CaseBean(7, 6, 3, CaseBean.PROP_BAO_SHI_RED));
        row6.add(new CaseBean(7, 6, 4, CaseBean.BUILDING_WALL));
        row6.add(new CaseBean(7, 6, 5, CaseBean.MONSTER_BAI_YI_WU_SHI));
        row6.add(new CaseBean(7, 6, 6, CaseBean.BUILDING_WALL));
        row6.add(new CaseBean(7, 6, 7, CaseBean.PROP_BAO_SHI_BLUE));
        row6.add(new CaseBean(7, 6, 8, CaseBean.PROP_XIE_PING_SMALL));
        row6.add(new CaseBean(7, 6, 9, CaseBean.BUILDING_WALL));
        row6.add(new CaseBean(7, 6, 10, CaseBean.BUILDING_ROAD));
        floor7.add(row6);

        List<CaseBean> row7 = new ArrayList<>();
        row7.add(new CaseBean(7, 7, 0, CaseBean.BUILDING_ROAD));
        row7.add(new CaseBean(7, 7, 1, CaseBean.BUILDING_WALL));
        row7.add(new CaseBean(7, 7, 2, CaseBean.PROP_KEY_YELLOW));
        row7.add(new CaseBean(7, 7, 3, CaseBean.PROP_XIE_PING_SMALL));
        row7.add(new CaseBean(7, 7, 4, CaseBean.BUILDING_WALL));
        row7.add(new CaseBean(7, 7, 5, CaseBean.NPC_GATE_BLUE));
        row7.add(new CaseBean(7, 7, 6, CaseBean.BUILDING_WALL));
        row7.add(new CaseBean(7, 7, 7, CaseBean.PROP_XIE_PING_SMALL));
        row7.add(new CaseBean(7, 7, 8, CaseBean.PROP_KEY_YELLOW));
        row7.add(new CaseBean(7, 7, 9, CaseBean.BUILDING_WALL));
        row7.add(new CaseBean(7, 7, 10, CaseBean.BUILDING_ROAD));
        floor7.add(row7);

        List<CaseBean> row8 = new ArrayList<>();
        row8.add(new CaseBean(7, 8, 0, CaseBean.BUILDING_ROAD));
        row8.add(new CaseBean(7, 8, 1, CaseBean.BUILDING_WALL));
        row8.add(new CaseBean(7, 8, 2, CaseBean.BUILDING_WALL));
        row8.add(new CaseBean(7, 8, 3, CaseBean.PROP_KEY_BLUE));
        row8.add(new CaseBean(7, 8, 4, CaseBean.PROP_KEY_BLUE));
        row8.add(new CaseBean(7, 8, 5, CaseBean.PROP_XIE_PING_BIG));
        row8.add(new CaseBean(7, 8, 6, CaseBean.PROP_KEY_BLUE));
        row8.add(new CaseBean(7, 8, 7, CaseBean.PROP_KEY_BLUE));
        row8.add(new CaseBean(7, 8, 8, CaseBean.BUILDING_WALL));
        row8.add(new CaseBean(7, 8, 9, CaseBean.BUILDING_WALL));
        row8.add(new CaseBean(7, 8, 10, CaseBean.BUILDING_ROAD));
        floor7.add(row8);

        List<CaseBean> row9 = new ArrayList<>();
        row9.add(new CaseBean(7, 9, 0, CaseBean.BUILDING_ROAD));
        row9.add(new CaseBean(7, 9, 1, CaseBean.BUILDING_ROAD));
        row9.add(new CaseBean(7, 9, 2, CaseBean.BUILDING_WALL));
        row9.add(new CaseBean(7, 9, 3, CaseBean.BUILDING_WALL));
        row9.add(new CaseBean(7, 9, 4, CaseBean.BUILDING_WALL));
        row9.add(new CaseBean(7, 9, 5, CaseBean.NPC_GATE_RED));
        row9.add(new CaseBean(7, 9, 6, CaseBean.BUILDING_WALL));
        row9.add(new CaseBean(7, 9, 7, CaseBean.BUILDING_WALL));
        row9.add(new CaseBean(7, 9, 8, CaseBean.BUILDING_WALL));
        row9.add(new CaseBean(7, 9, 9, CaseBean.BUILDING_ROAD));
        row9.add(new CaseBean(7, 9, 10, CaseBean.BUILDING_ROAD));
        floor7.add(row9);

        List<CaseBean> row10 = new ArrayList<>();
        row10.add(new CaseBean(7, 10, 0, CaseBean.BUILDING_WALL));
        row10.add(new CaseBean(7, 10, 1, CaseBean.BUILDING_ROAD));
        row10.add(new CaseBean(7, 10, 2, CaseBean.BUILDING_ROAD));
        row10.add(new CaseBean(7, 10, 3, CaseBean.NPC_GATE_YELLOW));
        row10.add(new CaseBean(7, 10, 4, CaseBean.NPC_GO_DOWNSTAIRS));
        row10.add(new CaseBean(7, 10, 5, CaseBean.BUILDING_ROAD));
        row10.add(new CaseBean(7, 10, 6, CaseBean.BUILDING_ROAD));
        row10.add(new CaseBean(7, 10, 7, CaseBean.NPC_GATE_YELLOW));
        row10.add(new CaseBean(7, 10, 8, CaseBean.BUILDING_ROAD));
        row10.add(new CaseBean(7, 10, 9, CaseBean.BUILDING_ROAD));
        row10.add(new CaseBean(7, 10, 10, CaseBean.BUILDING_WALL));
        floor7.add(row10);

        return floor7;
    }

    @Override
    public void fromUpstairsToThisFloor() {
        resetWarriorPosition(0, 1);
    }

    @Override
    public void fromDownstairsToThisFloor() {
        resetWarriorPosition(10, 5);
    }
}
