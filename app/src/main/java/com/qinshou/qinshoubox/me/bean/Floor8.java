package com.qinshou.qinshoubox.me.bean;


import java.util.ArrayList;
import java.util.List;

/**
 * Description:第 8 层
 * Created by 禽兽先生
 * Created on 2017/4/26
 */

public class Floor8 extends AFloor {

    @Override
    public int getFloor() {
        return 8;
    }

    @Override
    public List<List<CaseBean>> setData() {
        List<List<CaseBean>> floor8 = new ArrayList<>();
        List<CaseBean> row0 = new ArrayList<>();
        row0.add(new CaseBean(8, 0, 0, CaseBean.NPC_GO_DOWNSTAIRS));
        row0.add(new CaseBean(8, 0, 1, CaseBean.BUILDING_WALL));
        row0.add(new CaseBean(8, 0, 2, CaseBean.BUILDING_ROAD));
        row0.add(new CaseBean(8, 0, 3, CaseBean.BUILDING_ROAD));
        row0.add(new CaseBean(8, 0, 4, CaseBean.BUILDING_ROAD));
        row0.add(new CaseBean(8, 0, 5, CaseBean.BUILDING_ROAD));
        row0.add(new CaseBean(8, 0, 6, CaseBean.BUILDING_WALL));
        row0.add(new CaseBean(8, 0, 7, CaseBean.BUILDING_ROAD));
        row0.add(new CaseBean(8, 0, 8, CaseBean.PROP_KEY_YELLOW));
        row0.add(new CaseBean(8, 0, 9, CaseBean.MONSTER_KU_LOU_DUI_ZHANG));
        row0.add(new CaseBean(8, 0, 10, CaseBean.BUILDING_ROAD));
        floor8.add(row0);

        List<CaseBean> row1 = new ArrayList<>();
        row1.add(new CaseBean(8, 1, 0, CaseBean.BUILDING_ROAD));
        row1.add(new CaseBean(8, 1, 1, CaseBean.BUILDING_WALL));
        row1.add(new CaseBean(8, 1, 2, CaseBean.BUILDING_ROAD));
        row1.add(new CaseBean(8, 1, 3, CaseBean.BUILDING_WALL));
        row1.add(new CaseBean(8, 1, 4, CaseBean.BUILDING_WALL));
        row1.add(new CaseBean(8, 1, 5, CaseBean.NPC_GATE_YELLOW));
        row1.add(new CaseBean(8, 1, 6, CaseBean.BUILDING_WALL));
        row1.add(new CaseBean(8, 1, 7, CaseBean.NPC_GATE_YELLOW));
        row1.add(new CaseBean(8, 1, 8, CaseBean.BUILDING_WALL));
        row1.add(new CaseBean(8, 1, 9, CaseBean.BUILDING_WALL));
        row1.add(new CaseBean(8, 1, 10, CaseBean.BUILDING_ROAD));
        floor8.add(row1);

        List<CaseBean> row2 = new ArrayList<>();
        row2.add(new CaseBean(8, 2, 0, CaseBean.BUILDING_ROAD));
        row2.add(new CaseBean(8, 2, 1, CaseBean.BUILDING_WALL));
        row2.add(new CaseBean(8, 2, 2, CaseBean.BUILDING_ROAD));
        row2.add(new CaseBean(8, 2, 3, CaseBean.BUILDING_WALL));
        row2.add(new CaseBean(8, 2, 4, CaseBean.BUILDING_ROAD));
        row2.add(new CaseBean(8, 2, 5, CaseBean.BUILDING_ROAD));
        row2.add(new CaseBean(8, 2, 6, CaseBean.NPC_GATE_BLUE));
        row2.add(new CaseBean(8, 2, 7, CaseBean.BUILDING_ROAD));
        row2.add(new CaseBean(8, 2, 8, CaseBean.BUILDING_ROAD));
        row2.add(new CaseBean(8, 2, 9, CaseBean.BUILDING_WALL));
        row2.add(new CaseBean(8, 2, 10, CaseBean.PROP_BAO_SHI_RED));
        floor8.add(row2);

        List<CaseBean> row3 = new ArrayList<>();
        row3.add(new CaseBean(8, 3, 0, CaseBean.BUILDING_ROAD));
        row3.add(new CaseBean(8, 3, 1, CaseBean.BUILDING_WALL));
        row3.add(new CaseBean(8, 3, 2, CaseBean.BUILDING_ROAD));
        row3.add(new CaseBean(8, 3, 3, CaseBean.BUILDING_WALL));
        row3.add(new CaseBean(8, 3, 4, CaseBean.MONSTER_MA_YI_FA_SHI));
        row3.add(new CaseBean(8, 3, 5, CaseBean.BUILDING_WALL));
        row3.add(new CaseBean(8, 3, 6, CaseBean.BUILDING_WALL));
        row3.add(new CaseBean(8, 3, 7, CaseBean.BUILDING_WALL));
        row3.add(new CaseBean(8, 3, 8, CaseBean.MONSTER_DA_BIAN_FU));
        row3.add(new CaseBean(8, 3, 9, CaseBean.BUILDING_WALL));
        row3.add(new CaseBean(8, 3, 10, CaseBean.MONSTER_QING_TOU_GUAI));
        floor8.add(row3);

        List<CaseBean> row4 = new ArrayList<>();
        row4.add(new CaseBean(8, 4, 0, CaseBean.MONSTER_DA_BIAN_FU));
        row4.add(new CaseBean(8, 4, 1, CaseBean.BUILDING_WALL));
        row4.add(new CaseBean(8, 4, 2, CaseBean.BUILDING_ROAD));
        row4.add(new CaseBean(8, 4, 3, CaseBean.BUILDING_WALL));
        row4.add(new CaseBean(8, 4, 4, CaseBean.PROP_XIE_PING_SMALL));
        row4.add(new CaseBean(8, 4, 5, CaseBean.BUILDING_WALL));
        row4.add(new CaseBean(8, 4, 6, CaseBean.NPC_GO_UPSTAIRS));
        row4.add(new CaseBean(8, 4, 7, CaseBean.BUILDING_ROAD));
        row4.add(new CaseBean(8, 4, 8, CaseBean.BUILDING_ROAD));
        row4.add(new CaseBean(8, 4, 9, CaseBean.BUILDING_WALL));
        row4.add(new CaseBean(8, 4, 10, CaseBean.MONSTER_QING_TOU_GUAI));
        floor8.add(row4);

        List<CaseBean> row5 = new ArrayList<>();
        row5.add(new CaseBean(8, 5, 0, CaseBean.MONSTER_HONG_BIAN_FU));
        row5.add(new CaseBean(8, 5, 1, CaseBean.BUILDING_WALL));
        row5.add(new CaseBean(8, 5, 2, CaseBean.PROP_BAO_SHI_BLUE));
        row5.add(new CaseBean(8, 5, 3, CaseBean.BUILDING_WALL));
        row5.add(new CaseBean(8, 5, 4, CaseBean.PROP_XIE_PING_SMALL));
        row5.add(new CaseBean(8, 5, 5, CaseBean.BUILDING_WALL));
        row5.add(new CaseBean(8, 5, 6, CaseBean.BUILDING_WALL));
        row5.add(new CaseBean(8, 5, 7, CaseBean.BUILDING_WALL));
        row5.add(new CaseBean(8, 5, 8, CaseBean.BUILDING_WALL));
        row5.add(new CaseBean(8, 5, 9, CaseBean.BUILDING_WALL));
        row5.add(new CaseBean(8, 5, 10, CaseBean.BUILDING_ROAD));
        floor8.add(row5);

        List<CaseBean> row6 = new ArrayList<>();
        row6.add(new CaseBean(8, 6, 0, CaseBean.MONSTER_DA_BIAN_FU));
        row6.add(new CaseBean(8, 6, 1, CaseBean.BUILDING_WALL));
        row6.add(new CaseBean(8, 6, 2, CaseBean.MONSTER_QING_TOU_GUAI));
        row6.add(new CaseBean(8, 6, 3, CaseBean.BUILDING_WALL));
        row6.add(new CaseBean(8, 6, 4, CaseBean.BUILDING_ROAD));
        row6.add(new CaseBean(8, 6, 5, CaseBean.BUILDING_ROAD));
        row6.add(new CaseBean(8, 6, 6, CaseBean.BUILDING_ROAD));
        row6.add(new CaseBean(8, 6, 7, CaseBean.BUILDING_WALL));
        row6.add(new CaseBean(8, 6, 8, CaseBean.BUILDING_ROAD));
        row6.add(new CaseBean(8, 6, 9, CaseBean.MONSTER_HONG_BIAN_FU));
        row6.add(new CaseBean(8, 6, 10, CaseBean.BUILDING_ROAD));
        floor8.add(row6);

        List<CaseBean> row7 = new ArrayList<>();
        row7.add(new CaseBean(8, 7, 0, CaseBean.BUILDING_ROAD));
        row7.add(new CaseBean(8, 7, 1, CaseBean.BUILDING_WALL));
        row7.add(new CaseBean(8, 7, 2, CaseBean.MONSTER_QING_TOU_GUAI));
        row7.add(new CaseBean(8, 7, 3, CaseBean.BUILDING_WALL));
        row7.add(new CaseBean(8, 7, 4, CaseBean.BUILDING_WALL));
        row7.add(new CaseBean(8, 7, 5, CaseBean.BUILDING_WALL));
        row7.add(new CaseBean(8, 7, 6, CaseBean.MONSTER_CHU_JI_WEI_BING));
        row7.add(new CaseBean(8, 7, 7, CaseBean.BUILDING_WALL));
        row7.add(new CaseBean(8, 7, 8, CaseBean.NPC_GATE_YELLOW));
        row7.add(new CaseBean(8, 7, 9, CaseBean.BUILDING_WALL));
        row7.add(new CaseBean(8, 7, 10, CaseBean.BUILDING_WALL));
        floor8.add(row7);

        List<CaseBean> row8 = new ArrayList<>();
        row8.add(new CaseBean(8, 8, 0, CaseBean.BUILDING_ROAD));
        row8.add(new CaseBean(8, 8, 1, CaseBean.BUILDING_WALL));
        row8.add(new CaseBean(8, 8, 2, CaseBean.BUILDING_ROAD));
        row8.add(new CaseBean(8, 8, 3, CaseBean.MONSTER_KU_LOU_DUI_ZHANG));
        row8.add(new CaseBean(8, 8, 4, CaseBean.BUILDING_ROAD));
        row8.add(new CaseBean(8, 8, 5, CaseBean.BUILDING_WALL));
        row8.add(new CaseBean(8, 8, 6, CaseBean.MONSTER_KU_LOU_DUI_ZHANG));
        row8.add(new CaseBean(8, 8, 7, CaseBean.BUILDING_WALL));
        row8.add(new CaseBean(8, 8, 8, CaseBean.BUILDING_ROAD));
        row8.add(new CaseBean(8, 8, 9, CaseBean.BUILDING_ROAD));
        row8.add(new CaseBean(8, 8, 10, CaseBean.BUILDING_ROAD));
        floor8.add(row8);

        List<CaseBean> row9 = new ArrayList<>();
        row9.add(new CaseBean(8, 9, 0, CaseBean.BUILDING_ROAD));
        row9.add(new CaseBean(8, 9, 1, CaseBean.BUILDING_WALL));
        row9.add(new CaseBean(8, 9, 2, CaseBean.BUILDING_WALL));
        row9.add(new CaseBean(8, 9, 3, CaseBean.BUILDING_WALL));
        row9.add(new CaseBean(8, 9, 4, CaseBean.NPC_GATE_YELLOW));
        row9.add(new CaseBean(8, 9, 5, CaseBean.BUILDING_WALL));
        row9.add(new CaseBean(8, 9, 6, CaseBean.BUILDING_ROAD));
        row9.add(new CaseBean(8, 9, 7, CaseBean.BUILDING_WALL));
        row9.add(new CaseBean(8, 9, 8, CaseBean.BUILDING_WALL));
        row9.add(new CaseBean(8, 9, 9, CaseBean.BUILDING_WALL));
        row9.add(new CaseBean(8, 9, 10, CaseBean.BUILDING_ROAD));
        floor8.add(row9);

        List<CaseBean> row10 = new ArrayList<>();
        row10.add(new CaseBean(8, 10, 0, CaseBean.BUILDING_ROAD));
        row10.add(new CaseBean(8, 10, 1, CaseBean.BUILDING_ROAD));
        row10.add(new CaseBean(8, 10, 2, CaseBean.MONSTER_MA_YI_FA_SHI));
        row10.add(new CaseBean(8, 10, 3, CaseBean.BUILDING_ROAD));
        row10.add(new CaseBean(8, 10, 4, CaseBean.BUILDING_ROAD));
        row10.add(new CaseBean(8, 10, 5, CaseBean.BUILDING_WALL));
        row10.add(new CaseBean(8, 10, 6, CaseBean.BUILDING_ROAD));
        row10.add(new CaseBean(8, 10, 7, CaseBean.MONSTER_GUAI_WANG));
        row10.add(new CaseBean(8, 10, 8, CaseBean.MONSTER_BAI_YI_WU_SHI));
        row10.add(new CaseBean(8, 10, 9, CaseBean.MONSTER_GUAI_WANG));
        row10.add(new CaseBean(8, 10, 10, CaseBean.BUILDING_ROAD));
        floor8.add(row10);

        return floor8;
    }

    @Override
    public void fromUpstairsToThisFloor() {
        resetWarriorPosition(4, 7);
    }

    @Override
    public void fromDownstairsToThisFloor() {
        resetWarriorPosition(1, 0);
    }
}
