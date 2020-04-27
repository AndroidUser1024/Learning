package com.qinshou.qinshoubox.me.bean.floor;


import com.qinshou.qinshoubox.R;
import com.qinshou.qinshoubox.me.bean.CaseBean;
import com.qinshou.qinshoubox.me.bean.Position;
import com.qinshou.qinshoubox.me.bean.building.Road;
import com.qinshou.qinshoubox.me.bean.building.StarrySky;
import com.qinshou.qinshoubox.me.bean.monster.LingWuShi2;
import com.qinshou.qinshoubox.me.bean.monster.MingDuiZhang2;
import com.qinshou.qinshoubox.me.bean.monster.YingZiZhanShi;
import com.qinshou.qinshoubox.me.bean.npc.GoDownstairs;
import com.qinshou.qinshoubox.me.bean.npc.GoUpstairs;
import com.qinshou.qinshoubox.me.bean.warrior.WarriorBean;
import com.qinshou.qinshoubox.me.enums.Building;
import com.qinshou.qinshoubox.me.enums.Monster;
import com.qinshou.qinshoubox.me.enums.Npc;
import com.qinshou.qinshoubox.util.MagicGameManager;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:第 17 层
 * Created by 禽兽先生
 * Created on 2017/4/27
 */

public class Floor17 extends AbsFloor {

    @Override
    public int getFloor() {
        return 17;
    }

    @Override
    public List<List<CaseBean>> setData() {
        List<List<CaseBean>> floor17 = new ArrayList<>();
        List<CaseBean> row0 = new ArrayList<>();
        row0.add(new StarrySky());
        row0.add(new LingWuShi2());
        row0.add(new MingDuiZhang2());
        row0.add(new Road());
        row0.add(new Road());
        row0.add(new Road());
        row0.add(new Road());
        row0.add(new Road());
        row0.add(new Road());
        row0.add(new Road());
        row0.add(new LingWuShi2());
        floor17.add(row0);

        List<CaseBean> row1 = new ArrayList<>();
        row1.add(new StarrySky());
        row1.add(new MingDuiZhang2());
        row1.add(new StarrySky());
        row1.add(new StarrySky());
        row1.add(new StarrySky());
        row1.add(new StarrySky());
        row1.add(new StarrySky());
        row1.add(new StarrySky());
        row1.add(new StarrySky());
        row1.add(new StarrySky());
        row1.add(new Road());
        floor17.add(row1);

        List<CaseBean> row2 = new ArrayList<>();
        row2.add(new StarrySky());
        row2.add(new Road());
        row2.add(new StarrySky());
        row2.add(new LingWuShi2());
        row2.add(new Road());
        row2.add(new Road());
        row2.add(new Road());
        row2.add(new Road());
        row2.add(new Road());
        row2.add(new Road());
        row2.add(new LingWuShi2());
        floor17.add(row2);

        List<CaseBean> row3 = new ArrayList<>();
        row3.add(new StarrySky());
        row3.add(new Road());
        row3.add(new StarrySky());
        row3.add(new Road());
        row3.add(new StarrySky());
        row3.add(new StarrySky());
        row3.add(new StarrySky());
        row3.add(new StarrySky());
        row3.add(new StarrySky());
        row3.add(new StarrySky());
        row3.add(new StarrySky());
        floor17.add(row3);

        List<CaseBean> row4 = new ArrayList<>();
        row4.add(new StarrySky());
        row4.add(new Road());
        row4.add(new StarrySky());
        row4.add(new Road());
        row4.add(new StarrySky());
        row4.add(new LingWuShi2());
        row4.add(new Road());
        row4.add(new Road());
        row4.add(new Road());
        row4.add(new LingWuShi2());
        row4.add(new StarrySky());
        floor17.add(row4);

        List<CaseBean> row5 = new ArrayList<>();
        row5.add(new StarrySky());
        row5.add(new Road());
        row5.add(new StarrySky());
        row5.add(new LingWuShi2());
        row5.add(new Road());
        row5.add(new Road());
        row5.add(new StarrySky());
        row5.add(new StarrySky());
        row5.add(new StarrySky());
        row5.add(new Road());
        row5.add(new StarrySky());
        floor17.add(row5);

        List<CaseBean> row6 = new ArrayList<>();
        row6.add(new StarrySky());
        row6.add(new Road());
        row6.add(new StarrySky());
        row6.add(new StarrySky());
        row6.add(new StarrySky());
        row6.add(new StarrySky());
        row6.add(new StarrySky());
        row6.add(new LingWuShi2());
        row6.add(new Road());
        row6.add(new LingWuShi2());
        row6.add(new StarrySky());
        floor17.add(row6);

        List<CaseBean> row7 = new ArrayList<>();
        row7.add(new StarrySky());
        row7.add(new MingDuiZhang2());
        row7.add(new StarrySky());
        row7.add(new StarrySky());
        row7.add(new StarrySky());
        row7.add(new GoDownstairs());
        row7.add(new StarrySky());
        row7.add(new Road());
        row7.add(new StarrySky());
        row7.add(new StarrySky());
        row7.add(new StarrySky());
        floor17.add(row7);

        List<CaseBean> row8 = new ArrayList<>();
        row8.add(new StarrySky());
        row8.add(new LingWuShi2());
        row8.add(new MingDuiZhang2());
        row8.add(new Road());
        row8.add(new YingZiZhanShi());
        row8.add(new Road());
        row8.add(new StarrySky());
        row8.add(new LingWuShi2());
        row8.add(new Road());
        row8.add(new Road());
        row8.add(new LingWuShi2());
        floor17.add(row8);

        List<CaseBean> row9 = new ArrayList<>();
        row9.add(new StarrySky());
        row9.add(new StarrySky());
        row9.add(new StarrySky());
        row9.add(new StarrySky());
        row9.add(new StarrySky());
        row9.add(new StarrySky());
        row9.add(new StarrySky());
        row9.add(new StarrySky());
        row9.add(new StarrySky());
        row9.add(new StarrySky());
        row9.add(new Road());
        floor17.add(row9);

        List<CaseBean> row10 = new ArrayList<>();
        row10.add(new GoUpstairs());
        row10.add(new Road());
        row10.add(new YingZiZhanShi());
        row10.add(new Road());
        row10.add(new Road());
        row10.add(new Road());
        row10.add(new Road());
        row10.add(new Road());
        row10.add(new Road());
        row10.add(new Road());
        row10.add(new LingWuShi2());
        floor17.add(row10);

        return floor17;
    }

    @Override
    public void fromUpstairsToThisFloor() {
        WarriorBean warriorBean = MagicGameManager.SINGLETON.getWarriorBean();
        warriorBean.setPosition(new Position(10, 1));
        MagicGameManager.SINGLETON.setCase(warriorBean.getPosition(), warriorBean);
    }

    @Override
    public void fromDownstairsToThisFloor() {
        WarriorBean warriorBean = MagicGameManager.SINGLETON.getWarriorBean();
        warriorBean.setPosition(new Position(8, 5));
        MagicGameManager.SINGLETON.setCase(warriorBean.getPosition(), warriorBean);
    }
}
