package com.qinshou.qinshoubox.me.bean;


import java.util.ArrayList;
import java.util.List;

/**
 * Description:第 1 层
 * Created by 禽兽先生
 * Created on 2017/4/26
 */

public class Floor1 extends AFloor {

    @Override
    public int getFloor() {
        return 1;
    }

    @Override
    public List<List<CaseBean>> setData() {
        List<List<CaseBean>> floor1 = new ArrayList<>();
        List<CaseBean> row0 = new ArrayList<>();
        row0.add(new CaseBean(1, 0, 0, CaseBean.NPC_GO_UPSTAIRS));
        row0.add(new CaseBean(1, 0, 1, CaseBean.BUILDING_ROAD));
        row0.add(new CaseBean(1, 0, 2, CaseBean.PROP_KEY_YELLOW));
        row0.add(new CaseBean(1, 0, 3, CaseBean.MONSTER_LV_TOU_GUAI));
        row0.add(new CaseBean(1, 0, 4, CaseBean.MONSTER_HONG_TOU_GUAI));
        row0.add(new CaseBean(1, 0, 5, CaseBean.MONSTER_LV_TOU_GUAI));
        row0.add(new CaseBean(1, 0, 6, CaseBean.BUILDING_ROAD));
        row0.add(new CaseBean(1, 0, 7, CaseBean.BUILDING_ROAD));
        row0.add(new CaseBean(1, 0, 8, CaseBean.BUILDING_ROAD));
        row0.add(new CaseBean(1, 0, 9, CaseBean.BUILDING_ROAD));
        row0.add(new CaseBean(1, 0, 10, CaseBean.BUILDING_ROAD));
        floor1.add(row0);

        List<CaseBean> row1 = new ArrayList<>();
        row1.add(new CaseBean(1, 1, 0, CaseBean.BUILDING_WALL));
        row1.add(new CaseBean(1, 1, 1, CaseBean.BUILDING_WALL));
        row1.add(new CaseBean(1, 1, 2, CaseBean.BUILDING_WALL));
        row1.add(new CaseBean(1, 1, 3, CaseBean.BUILDING_WALL));
        row1.add(new CaseBean(1, 1, 4, CaseBean.BUILDING_WALL));
        row1.add(new CaseBean(1, 1, 5, CaseBean.BUILDING_WALL));
        row1.add(new CaseBean(1, 1, 6, CaseBean.BUILDING_WALL));
        row1.add(new CaseBean(1, 1, 7, CaseBean.BUILDING_WALL));
        row1.add(new CaseBean(1, 1, 8, CaseBean.BUILDING_WALL));
        row1.add(new CaseBean(1, 1, 9, CaseBean.BUILDING_WALL));
        row1.add(new CaseBean(1, 1, 10, CaseBean.BUILDING_ROAD));
        floor1.add(row1);

        List<CaseBean> row2 = new ArrayList<>();
        row2.add(new CaseBean(1, 2, 0, CaseBean.PROP_XIE_PING_SMALL));
        row2.add(new CaseBean(1, 2, 1, CaseBean.BUILDING_ROAD));
        row2.add(new CaseBean(1, 2, 2, CaseBean.MONSTER_KU_LOU_REN));
        row2.add(new CaseBean(1, 2, 3, CaseBean.NPC_GATE_YELLOW));
        row2.add(new CaseBean(1, 2, 4, CaseBean.BUILDING_ROAD));
        row2.add(new CaseBean(1, 2, 5, CaseBean.BUILDING_WALL));
        row2.add(new CaseBean(1, 2, 6, CaseBean.PROP_XIE_PING_SMALL));
        row2.add(new CaseBean(1, 2, 7, CaseBean.PROP_KEY_YELLOW));
        row2.add(new CaseBean(1, 2, 8, CaseBean.PROP_XIE_PING_SMALL));
        row2.add(new CaseBean(1, 2, 9, CaseBean.BUILDING_WALL));
        row2.add(new CaseBean(1, 2, 10, CaseBean.BUILDING_ROAD));
        floor1.add(row2);

        List<CaseBean> row3 = new ArrayList<>();
        row3.add(new CaseBean(1, 3, 0, CaseBean.PROP_KEY_YELLOW));
        row3.add(new CaseBean(1, 3, 1, CaseBean.MONSTER_KU_LOU_REN));
        row3.add(new CaseBean(1, 3, 2, CaseBean.PROP_BAO_SHI_RED));
        row3.add(new CaseBean(1, 3, 3, CaseBean.BUILDING_WALL));
        row3.add(new CaseBean(1, 3, 4, CaseBean.BUILDING_ROAD));
        row3.add(new CaseBean(1, 3, 5, CaseBean.BUILDING_WALL));
        row3.add(new CaseBean(1, 3, 6, CaseBean.PROP_XIE_PING_SMALL));
        row3.add(new CaseBean(1, 3, 7, CaseBean.PROP_KEY_YELLOW));
        row3.add(new CaseBean(1, 3, 8, CaseBean.PROP_XIE_PING_SMALL));
        row3.add(new CaseBean(1, 3, 9, CaseBean.BUILDING_WALL));
        row3.add(new CaseBean(1, 3, 10, CaseBean.BUILDING_ROAD));
        floor1.add(row3);

        List<CaseBean> row4 = new ArrayList<>();
        row4.add(new CaseBean(1, 4, 0, CaseBean.BUILDING_WALL));
        row4.add(new CaseBean(1, 4, 1, CaseBean.NPC_GATE_YELLOW));
        row4.add(new CaseBean(1, 4, 2, CaseBean.BUILDING_WALL));
        row4.add(new CaseBean(1, 4, 3, CaseBean.BUILDING_WALL));
        row4.add(new CaseBean(1, 4, 4, CaseBean.BUILDING_ROAD));
        row4.add(new CaseBean(1, 4, 5, CaseBean.BUILDING_WALL));
        row4.add(new CaseBean(1, 4, 6, CaseBean.BUILDING_WALL));
        row4.add(new CaseBean(1, 4, 7, CaseBean.BUILDING_WALL));
        row4.add(new CaseBean(1, 4, 8, CaseBean.MONSTER_QING_TOU_GUAI));
        row4.add(new CaseBean(1, 4, 9, CaseBean.BUILDING_WALL));
        row4.add(new CaseBean(1, 4, 10, CaseBean.BUILDING_ROAD));
        floor1.add(row4);

        List<CaseBean> row5 = new ArrayList<>();
        row5.add(new CaseBean(1, 5, 0, CaseBean.PROP_KEY_YELLOW));
        row5.add(new CaseBean(1, 5, 1, CaseBean.MONSTER_KU_LOU_SHI_BING));
        row5.add(new CaseBean(1, 5, 2, CaseBean.BUILDING_ROAD));
        row5.add(new CaseBean(1, 5, 3, CaseBean.BUILDING_WALL));
        row5.add(new CaseBean(1, 5, 4, CaseBean.BUILDING_ROAD));
        row5.add(new CaseBean(1, 5, 5, CaseBean.NPC_GATE_YELLOW));
        row5.add(new CaseBean(1, 5, 6, CaseBean.MONSTER_CHU_JI_FA_SHI));
        row5.add(new CaseBean(1, 5, 7, CaseBean.MONSTER_LV_TOU_GUAI));
        row5.add(new CaseBean(1, 5, 8, CaseBean.MONSTER_XIAO_BIAN_FU));
        row5.add(new CaseBean(1, 5, 9, CaseBean.BUILDING_WALL));
        row5.add(new CaseBean(1, 5, 10, CaseBean.BUILDING_ROAD));
        floor1.add(row5);

        List<CaseBean> row6 = new ArrayList<>();
        row6.add(new CaseBean(1, 6, 0, CaseBean.PROP_BAO_SHI_BLUE));
        row6.add(new CaseBean(1, 6, 1, CaseBean.BUILDING_ROAD));
        row6.add(new CaseBean(1, 6, 2, CaseBean.PROP_KEY_BLUE));
        row6.add(new CaseBean(1, 6, 3, CaseBean.BUILDING_WALL));
        row6.add(new CaseBean(1, 6, 4, CaseBean.BUILDING_ROAD));
        row6.add(new CaseBean(1, 6, 5, CaseBean.BUILDING_WALL));
        row6.add(new CaseBean(1, 6, 6, CaseBean.BUILDING_WALL));
        row6.add(new CaseBean(1, 6, 7, CaseBean.BUILDING_WALL));
        row6.add(new CaseBean(1, 6, 8, CaseBean.BUILDING_WALL));
        row6.add(new CaseBean(1, 6, 9, CaseBean.BUILDING_WALL));
        row6.add(new CaseBean(1, 6, 10, CaseBean.BUILDING_ROAD));
        floor1.add(row6);

        List<CaseBean> row7 = new ArrayList<>();
        row7.add(new CaseBean(1, 7, 0, CaseBean.BUILDING_WALL));
        row7.add(new CaseBean(1, 7, 1, CaseBean.NPC_GATE_YELLOW));
        row7.add(new CaseBean(1, 7, 2, CaseBean.BUILDING_WALL));
        row7.add(new CaseBean(1, 7, 3, CaseBean.BUILDING_WALL));
        row7.add(new CaseBean(1, 7, 4, CaseBean.BUILDING_ROAD));
        row7.add(new CaseBean(1, 7, 5, CaseBean.BUILDING_ROAD));
        row7.add(new CaseBean(1, 7, 6, CaseBean.BUILDING_ROAD));
        row7.add(new CaseBean(1, 7, 7, CaseBean.BUILDING_ROAD));
        row7.add(new CaseBean(1, 7, 8, CaseBean.BUILDING_ROAD));
        row7.add(new CaseBean(1, 7, 9, CaseBean.BUILDING_ROAD));
        row7.add(new CaseBean(1, 7, 10, CaseBean.BUILDING_ROAD));
        floor1.add(row7);

        List<CaseBean> row8 = new ArrayList<>();
        row8.add(new CaseBean(1, 8, 0, CaseBean.BUILDING_ROAD));
        row8.add(new CaseBean(1, 8, 1, CaseBean.MONSTER_KU_LOU_SHI_BING));
        row8.add(new CaseBean(1, 8, 2, CaseBean.BUILDING_ROAD));
        row8.add(new CaseBean(1, 8, 3, CaseBean.BUILDING_WALL));
        row8.add(new CaseBean(1, 8, 4, CaseBean.BUILDING_WALL));
        row8.add(new CaseBean(1, 8, 5, CaseBean.NPC_GATE_RED));
        row8.add(new CaseBean(1, 8, 6, CaseBean.BUILDING_WALL));
        row8.add(new CaseBean(1, 8, 7, CaseBean.BUILDING_WALL));
        row8.add(new CaseBean(1, 8, 8, CaseBean.BUILDING_WALL));
        row8.add(new CaseBean(1, 8, 9, CaseBean.NPC_GATE_YELLOW));
        row8.add(new CaseBean(1, 8, 10, CaseBean.BUILDING_WALL));
        floor1.add(row8);

        List<CaseBean> row9 = new ArrayList<>();
        row9.add(new CaseBean(1, 9, 0, CaseBean.PROP_XIE_PING_SMALL));
        row9.add(new CaseBean(1, 9, 1, CaseBean.PROP_XIE_PING_BIG));
        row9.add(new CaseBean(1, 9, 2, CaseBean.PROP_KEY_YELLOW));
        row9.add(new CaseBean(1, 9, 3, CaseBean.BUILDING_WALL));
        row9.add(new CaseBean(1, 9, 4, CaseBean.PROP_KEY_RED));
        row9.add(new CaseBean(1, 9, 5, CaseBean.BUILDING_ROAD));
        row9.add(new CaseBean(1, 9, 6, CaseBean.BUILDING_ROAD));
        row9.add(new CaseBean(1, 9, 7, CaseBean.BUILDING_WALL));
        row9.add(new CaseBean(1, 9, 8, CaseBean.PROP_KEY_YELLOW));
        row9.add(new CaseBean(1, 9, 9, CaseBean.MONSTER_SHOU_MIAN_REN));
        row9.add(new CaseBean(1, 9, 10, CaseBean.PROP_KEY_BLUE));
        floor1.add(row9);

        List<CaseBean> row10 = new ArrayList<>();
        row10.add(new CaseBean(1, 10, 0, CaseBean.PROP_XIE_PING_SMALL));
        row10.add(new CaseBean(1, 10, 1, CaseBean.PROP_SHENG_GUANG_HUI));
        row10.add(new CaseBean(1, 10, 2, CaseBean.PROP_KEY_YELLOW));
        row10.add(new CaseBean(1, 10, 3, CaseBean.BUILDING_WALL));
        row10.add(new CaseBean(1, 10, 4, CaseBean.BUILDING_ROAD));
        row10.add(new CaseBean(1, 10, 5, CaseBean.NPC_GO_DOWNSTAIRS));
        row10.add(new CaseBean(1, 10, 6, CaseBean.BUILDING_ROAD));
        row10.add(new CaseBean(1, 10, 7, CaseBean.BUILDING_WALL));
        row10.add(new CaseBean(1, 10, 8, CaseBean.PROP_KEY_YELLOW));
        row10.add(new CaseBean(1, 10, 9, CaseBean.PROP_KEY_YELLOW));
        row10.add(new CaseBean(1, 10, 10, CaseBean.PROP_KEY_YELLOW));
        floor1.add(row10);

        return floor1;
    }

    @Override
    public void fromUpstairsToThisFloor() {
        resetWarriorPosition(0, 1);
    }

    @Override
    public void fromDownstairsToThisFloor() {
        resetWarriorPosition(9, 5);
    }
}
