package com.qinshou.qinshoubox.me.bean;


import java.util.ArrayList;
import java.util.List;

/**
 * Description:第 2 层
 * Created by 禽兽先生
 * Created on 2017/4/26
 */

public class Floor2 extends AFloor {

    @Override
    public int getFloor() {
        return 2;
    }

    @Override
    public List<List<CaseBean>> setData() {
        List<List<CaseBean>> floor2 = new ArrayList<>();
        List<CaseBean> row0 = new ArrayList<>();
        row0.add(new CaseBean(2, 0, 0, CaseBean.NPC_GO_DOWNSTAIRS));
        row0.add(new CaseBean(2, 0, 1, CaseBean.BUILDING_WALL));
        row0.add(new CaseBean(2, 0, 2, CaseBean.BUILDING_ROAD));
        row0.add(new CaseBean(2, 0, 3, CaseBean.MONSTER_JIN_DUI_ZHANG));
        row0.add(new CaseBean(2, 0, 4, CaseBean.BUILDING_ROAD));
        row0.add(new CaseBean(2, 0, 5, CaseBean.BUILDING_WALL));
        row0.add(new CaseBean(2, 0, 6, CaseBean.PROP_BAO_SHI_RED));
        row0.add(new CaseBean(2, 0, 7, CaseBean.PROP_BAO_SHI_BLUE));
        row0.add(new CaseBean(2, 0, 8, CaseBean.PROP_KEY_YELLOW));
        row0.add(new CaseBean(2, 0, 9, CaseBean.PROP_KEY_RED));
        row0.add(new CaseBean(2, 0, 10, CaseBean.BUILDING_WALL));
        floor2.add(row0);

        List<CaseBean> row1 = new ArrayList<>();
        row1.add(new CaseBean(2, 1, 0, CaseBean.BUILDING_ROAD));
        row1.add(new CaseBean(2, 1, 1, CaseBean.BUILDING_WALL));
        row1.add(new CaseBean(2, 1, 2, CaseBean.PROP_BAO_SHI_BLUE));
        row1.add(new CaseBean(2, 1, 3, CaseBean.BUILDING_WALL));
        row1.add(new CaseBean(2, 1, 4, CaseBean.PROP_XIE_PING_BIG));
        row1.add(new CaseBean(2, 1, 5, CaseBean.BUILDING_WALL));
        row1.add(new CaseBean(2, 1, 6, CaseBean.PROP_BAO_SHI_RED));
        row1.add(new CaseBean(2, 1, 7, CaseBean.PROP_BAO_SHI_BLUE));
        row1.add(new CaseBean(2, 1, 8, CaseBean.PROP_KEY_YELLOW));
        row1.add(new CaseBean(2, 1, 9, CaseBean.PROP_KEY_BLUE));
        row1.add(new CaseBean(2, 1, 10, CaseBean.BUILDING_WALL));
        floor2.add(row1);

        List<CaseBean> row2 = new ArrayList<>();
        row2.add(new CaseBean(2, 2, 0, CaseBean.BUILDING_ROAD));
        row2.add(new CaseBean(2, 2, 1, CaseBean.BUILDING_WALL));
        row2.add(new CaseBean(2, 2, 2, CaseBean.PROP_KEY_YELLOW));
        row2.add(new CaseBean(2, 2, 3, CaseBean.BUILDING_WALL));
        row2.add(new CaseBean(2, 2, 4, CaseBean.PROP_KEY_YELLOW));
        row2.add(new CaseBean(2, 2, 5, CaseBean.BUILDING_WALL));
        row2.add(new CaseBean(2, 2, 6, CaseBean.PROP_BAO_SHI_RED));
        row2.add(new CaseBean(2, 2, 7, CaseBean.PROP_BAO_SHI_BLUE));
        row2.add(new CaseBean(2, 2, 8, CaseBean.PROP_KEY_YELLOW));
        row2.add(new CaseBean(2, 2, 9, CaseBean.MONSTER_JIN_WEI_SHI));
        row2.add(new CaseBean(2, 2, 10, CaseBean.BUILDING_WALL));
        floor2.add(row2);

        List<CaseBean> row3 = new ArrayList<>();
        row3.add(new CaseBean(2, 3, 0, CaseBean.BUILDING_ROAD));
        row3.add(new CaseBean(2, 3, 1, CaseBean.BUILDING_WALL));
        row3.add(new CaseBean(2, 3, 2, CaseBean.PROP_KEY_YELLOW));
        row3.add(new CaseBean(2, 3, 3, CaseBean.BUILDING_WALL));
        row3.add(new CaseBean(2, 3, 4, CaseBean.PROP_KEY_YELLOW));
        row3.add(new CaseBean(2, 3, 5, CaseBean.BUILDING_WALL));
        row3.add(new CaseBean(2, 3, 6, CaseBean.BUILDING_WALL));
        row3.add(new CaseBean(2, 3, 7, CaseBean.BUILDING_WALL));
        row3.add(new CaseBean(2, 3, 8, CaseBean.BUILDING_WALL));
        row3.add(new CaseBean(2, 3, 9, CaseBean.NPC_GATE_YELLOW));
        row3.add(new CaseBean(2, 3, 10, CaseBean.BUILDING_WALL));
        floor2.add(row3);

        List<CaseBean> row4 = new ArrayList<>();
        row4.add(new CaseBean(2, 4, 0, CaseBean.BUILDING_ROAD));
        row4.add(new CaseBean(2, 4, 1, CaseBean.BUILDING_WALL));
        row4.add(new CaseBean(2, 4, 2, CaseBean.BUILDING_ROAD));
        row4.add(new CaseBean(2, 4, 3, CaseBean.BUILDING_WALL));
        row4.add(new CaseBean(2, 4, 4, CaseBean.BUILDING_ROAD));
        row4.add(new CaseBean(2, 4, 5, CaseBean.BUILDING_ROAD));
        row4.add(new CaseBean(2, 4, 6, CaseBean.BUILDING_ROAD));
        row4.add(new CaseBean(2, 4, 7, CaseBean.NPC_GATE_YELLOW));
        row4.add(new CaseBean(2, 4, 8, CaseBean.BUILDING_ROAD));
        row4.add(new CaseBean(2, 4, 9, CaseBean.BUILDING_ROAD));
        row4.add(new CaseBean(2, 4, 10, CaseBean.BUILDING_WALL));
        floor2.add(row4);

        List<CaseBean> row5 = new ArrayList<>();
        row5.add(new CaseBean(2, 5, 0, CaseBean.BUILDING_ROAD));
        row5.add(new CaseBean(2, 5, 1, CaseBean.BUILDING_WALL));
        row5.add(new CaseBean(2, 5, 2, CaseBean.NPC_GATE_YELLOW));
        row5.add(new CaseBean(2, 5, 3, CaseBean.BUILDING_WALL));
        row5.add(new CaseBean(2, 5, 4, CaseBean.BUILDING_WALL));
        row5.add(new CaseBean(2, 5, 5, CaseBean.NPC_GATE_YELLOW));
        row5.add(new CaseBean(2, 5, 6, CaseBean.BUILDING_WALL));
        row5.add(new CaseBean(2, 5, 7, CaseBean.BUILDING_WALL));
        row5.add(new CaseBean(2, 5, 8, CaseBean.NPC_GATE_YELLOW));
        row5.add(new CaseBean(2, 5, 9, CaseBean.BUILDING_WALL));
        row5.add(new CaseBean(2, 5, 10, CaseBean.BUILDING_WALL));
        floor2.add(row5);

        List<CaseBean> row6 = new ArrayList<>();
        row6.add(new CaseBean(2, 6, 0, CaseBean.BUILDING_ROAD));
        row6.add(new CaseBean(2, 6, 1, CaseBean.NPC_GATE_GREEN));
        row6.add(new CaseBean(2, 6, 2, CaseBean.BUILDING_ROAD));
        row6.add(new CaseBean(2, 6, 3, CaseBean.BUILDING_ROAD));
        row6.add(new CaseBean(2, 6, 4, CaseBean.BUILDING_ROAD));
        row6.add(new CaseBean(2, 6, 5, CaseBean.BUILDING_ROAD));
        row6.add(new CaseBean(2, 6, 6, CaseBean.BUILDING_WALL));
        row6.add(new CaseBean(2, 6, 7, CaseBean.BUILDING_ROAD));
        row6.add(new CaseBean(2, 6, 8, CaseBean.MONSTER_JIN_WEI_SHI));
        row6.add(new CaseBean(2, 6, 9, CaseBean.BUILDING_ROAD));
        row6.add(new CaseBean(2, 6, 10, CaseBean.BUILDING_WALL));
        floor2.add(row6);

        List<CaseBean> row7 = new ArrayList<>();
        row7.add(new CaseBean(2, 7, 0, CaseBean.BUILDING_ROAD));
        row7.add(new CaseBean(2, 7, 1, CaseBean.BUILDING_WALL));
        row7.add(new CaseBean(2, 7, 2, CaseBean.NPC_GATE_YELLOW));
        row7.add(new CaseBean(2, 7, 3, CaseBean.BUILDING_WALL));
        row7.add(new CaseBean(2, 7, 4, CaseBean.BUILDING_WALL));
        row7.add(new CaseBean(2, 7, 5, CaseBean.NPC_GATE_BLUE));
        row7.add(new CaseBean(2, 7, 6, CaseBean.BUILDING_WALL));
        row7.add(new CaseBean(2, 7, 7, CaseBean.NPC_GATE_IRON_OPEN));
        row7.add(new CaseBean(2, 7, 8, CaseBean.BUILDING_WALL));
        row7.add(new CaseBean(2, 7, 9, CaseBean.NPC_GATE_IRON_OPEN));
        row7.add(new CaseBean(2, 7, 10, CaseBean.BUILDING_WALL));
        floor2.add(row7);

        List<CaseBean> row8 = new ArrayList<>();
        row8.add(new CaseBean(2, 8, 0, CaseBean.BUILDING_ROAD));
        row8.add(new CaseBean(2, 8, 1, CaseBean.BUILDING_WALL));
        row8.add(new CaseBean(2, 8, 2, CaseBean.PROP_KEY_YELLOW));
        row8.add(new CaseBean(2, 8, 3, CaseBean.BUILDING_WALL));
        row8.add(new CaseBean(2, 8, 4, CaseBean.PROP_XIE_PING_BIG));
        row8.add(new CaseBean(2, 8, 5, CaseBean.PROP_XIE_PING_SMALL));
        row8.add(new CaseBean(2, 8, 6, CaseBean.BUILDING_WALL));
        row8.add(new CaseBean(2, 8, 7, CaseBean.BUILDING_ROAD));
        row8.add(new CaseBean(2, 8, 8, CaseBean.BUILDING_WALL));
        row8.add(new CaseBean(2, 8, 9, CaseBean.BUILDING_ROAD));
        row8.add(new CaseBean(2, 8, 10, CaseBean.BUILDING_WALL));
        floor2.add(row8);

        List<CaseBean> row9 = new ArrayList<>();
        row9.add(new CaseBean(2, 9, 0, CaseBean.BUILDING_ROAD));
        row9.add(new CaseBean(2, 9, 1, CaseBean.BUILDING_WALL));
        row9.add(new CaseBean(2, 9, 2, CaseBean.PROP_KEY_YELLOW));
        row9.add(new CaseBean(2, 9, 3, CaseBean.BUILDING_WALL));
        row9.add(new CaseBean(2, 9, 4, CaseBean.PROP_XIE_PING_BIG));
        row9.add(new CaseBean(2, 9, 5, CaseBean.PROP_XIE_PING_SMALL));
        row9.add(new CaseBean(2, 9, 6, CaseBean.BUILDING_WALL));
        row9.add(new CaseBean(2, 9, 7, CaseBean.BUILDING_ROAD));
        row9.add(new CaseBean(2, 9, 8, CaseBean.BUILDING_WALL));
        row9.add(new CaseBean(2, 9, 9, CaseBean.BUILDING_ROAD));
        row9.add(new CaseBean(2, 9, 10, CaseBean.BUILDING_WALL));
        floor2.add(row9);

        List<CaseBean> row10 = new ArrayList<>();
        row10.add(new CaseBean(2, 10, 0, CaseBean.NPC_GO_UPSTAIRS));
        row10.add(new CaseBean(2, 10, 1, CaseBean.BUILDING_WALL));
        row10.add(new CaseBean(2, 10, 2, CaseBean.PROP_BAO_SHI_RED));
        row10.add(new CaseBean(2, 10, 3, CaseBean.BUILDING_WALL));
        row10.add(new CaseBean(2, 10, 4, CaseBean.PROP_XIE_PING_BIG));
        row10.add(new CaseBean(2, 10, 5, CaseBean.PROP_XIE_PING_BIG));
        row10.add(new CaseBean(2, 10, 6, CaseBean.BUILDING_WALL));
        row10.add(new CaseBean(2, 10, 7, CaseBean.NPC_SHEN_MI_LAO_REN_FLOOR_2));
        row10.add(new CaseBean(2, 10, 8, CaseBean.BUILDING_WALL));
        row10.add(new CaseBean(2, 10, 9, CaseBean.NPC_SHANG_REN_FLOOR_2));
        row10.add(new CaseBean(2, 10, 10, CaseBean.BUILDING_WALL));
        floor2.add(row10);

        return floor2;
    }

    @Override
    public void fromUpstairsToThisFloor() {
        resetWarriorPosition(9, 0);
    }

    @Override
    public void fromDownstairsToThisFloor() {
        resetWarriorPosition(1, 0);
    }
}
