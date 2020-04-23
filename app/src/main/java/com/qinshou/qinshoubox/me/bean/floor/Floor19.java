package com.qinshou.qinshoubox.me.bean.floor;


import com.qinshou.qinshoubox.R;
import com.qinshou.qinshoubox.me.bean.CaseBean;
import com.qinshou.qinshoubox.me.bean.Position;
import com.qinshou.qinshoubox.me.bean.building.Road;
import com.qinshou.qinshoubox.me.bean.building.StarrySky;
import com.qinshou.qinshoubox.me.bean.monster.HongYiMoWang2;
import com.qinshou.qinshoubox.me.bean.monster.MingLingMoWang;
import com.qinshou.qinshoubox.me.bean.npc.GoDownstairs;
import com.qinshou.qinshoubox.me.bean.npc.GoUpstairs;
import com.qinshou.qinshoubox.me.bean.npc.IronGateCanOpen;
import com.qinshou.qinshoubox.me.bean.prop.LightGodShield;
import com.qinshou.qinshoubox.me.bean.prop.StarLightGodSword;
import com.qinshou.qinshoubox.me.enums.Building;
import com.qinshou.qinshoubox.me.enums.Monster;
import com.qinshou.qinshoubox.me.enums.Npc;
import com.qinshou.qinshoubox.me.enums.Prop;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:第 19 层
 * Created by 禽兽先生
 * Created on 2018/4/27
 */

public class Floor19 extends AbsFloor {

    @Override
    public int getFloor() {
        return 19;
    }

    @Override
    public List<List<CaseBean>> setData() {
        List<List<CaseBean>> floor19 = new ArrayList<>();
        List<CaseBean> row0 = new ArrayList<>();
        row0.add(new Road());
        row0.add(new Road());
        row0.add(new Road());
        row0.add(new Road());
        row0.add(new Road());
        row0.add(new Road());
        row0.add(new Road());
        row0.add(new Road());
        row0.add(new Road());
        row0.add(new Road());
        row0.add(new Road());
        floor19.add(row0);

        List<CaseBean> row1 = new ArrayList<>();
        row1.add(new Road());
        row1.add(new StarrySky());
        row1.add(new Road());
        row1.add(new StarrySky());
        row1.add(new StarrySky());
        row1.add(new StarrySky());
        row1.add(new StarrySky());
        row1.add(new StarrySky());
        row1.add(new Road());
        row1.add(new StarrySky());
        row1.add(new Road());
        floor19.add(row1);

        List<CaseBean> row2 = new ArrayList<>();
        row2.add(new Road());
        row2.add(new StarrySky());
        row2.add(new Road());
        row2.add(new StarrySky());
        row2.add(new StarrySky());
        row2.add(new StarrySky());
        row2.add(new StarrySky());
        row2.add(new StarrySky());
        row2.add(new Road());
        row2.add(new StarrySky());
        row2.add(new Road());
        floor19.add(row2);

        List<CaseBean> row3 = new ArrayList<>();
        row3.add(new Road());
        row3.add(new StarrySky());
        row3.add(new Road());
        row3.add(new StarrySky());
        row3.add(new StarrySky());
        row3.add(new GoUpstairs());
        row3.add(new StarrySky());
        row3.add(new StarrySky());
        row3.add(new Road());
        row3.add(new StarrySky());
        row3.add(new Road());
        floor19.add(row3);

        List<CaseBean> row4 = new ArrayList<>();
        row4.add(new Road());
        row4.add(new StarrySky());
        row4.add(new Road());
        row4.add(new StarrySky());
        row4.add(new StarrySky());
        row4.add(new Road());
        row4.add(new StarrySky());
        row4.add(new StarrySky());
        row4.add(new Road());
        row4.add(new StarrySky());
        row4.add(new Road());
        floor19.add(row4);

        List<CaseBean> row5 = new ArrayList<>();
        row5.add(new Road());
        row5.add(new StarrySky());
        row5.add(new HongYiMoWang2());
        row5.add(new StarrySky());
        row5.add(new StarrySky());
        row5.add(new Road());
        row5.add(new StarrySky());
        row5.add(new StarrySky());
        row5.add(new HongYiMoWang2());
        row5.add(new StarrySky());
        row5.add(new Road());
        floor19.add(row5);

        List<CaseBean> row6 = new ArrayList<>();
        row6.add(new Road());
        row6.add(new StarrySky());
        row6.add(new IronGateCanOpen());
        row6.add(new StarrySky());
        row6.add(new StarrySky());
        row6.add(new MingLingMoWang());
        row6.add(new StarrySky());
        row6.add(new StarrySky());
        row6.add(new IronGateCanOpen());
        row6.add(new StarrySky());
        row6.add(new Road());
        floor19.add(row6);

        List<CaseBean> row7 = new ArrayList<>();
        row7.add(new Road());
        row7.add(new StarrySky());
        row7.add(new StarLightGodSword());
        row7.add(new StarrySky());
        row7.add(new StarrySky());
        row7.add(new Road());
        row7.add(new StarrySky());
        row7.add(new StarrySky());
        row7.add(new LightGodShield());
        row7.add(new StarrySky());
        row7.add(new Road());
        floor19.add(row7);

        List<CaseBean> row8 = new ArrayList<>();
        row8.add(new Road());
        row8.add(new StarrySky());
        row8.add(new StarrySky());
        row8.add(new StarrySky());
        row8.add(new StarrySky());
        row8.add(new Road());
        row8.add(new StarrySky());
        row8.add(new StarrySky());
        row8.add(new StarrySky());
        row8.add(new StarrySky());
        row8.add(new Road());
        floor19.add(row8);

        List<CaseBean> row9 = new ArrayList<>();
        row9.add(new Road());
        row9.add(new StarrySky());
        row9.add(new StarrySky());
        row9.add(new StarrySky());
        row9.add(new StarrySky());
        row9.add(new Road());
        row9.add(new StarrySky());
        row9.add(new StarrySky());
        row9.add(new StarrySky());
        row9.add(new StarrySky());
        row9.add(new Road());
        floor19.add(row9);

        List<CaseBean> row10 = new ArrayList<>();
        row10.add(new Road());
        row10.add(new Road());
        row10.add(new Road());
        row10.add(new Road());
        row10.add(new Road());
        row10.add(new Road());
        row10.add(new Road());
        row10.add(new Road());
        row10.add(new Road());
        row10.add(new Road());
        row10.add(new GoDownstairs());
        floor19.add(row10);

        return floor19;
    }

    @Override
    public void fromUpstairsToThisFloor() {
        resetWarriorPosition(new Position(4, 5));
    }

    @Override
    public void fromDownstairsToThisFloor() {
        resetWarriorPosition(new Position(10, 9));
    }
}
