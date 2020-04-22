package com.qinshou.qinshoubox.me.bean.floor;


import com.qinshou.qinshoubox.me.bean.CaseBean;
import com.qinshou.qinshoubox.me.bean.Position;
import com.qinshou.qinshoubox.me.bean.building.FireSea;
import com.qinshou.qinshoubox.me.bean.building.Road;
import com.qinshou.qinshoubox.me.bean.building.StarrySky;
import com.qinshou.qinshoubox.me.bean.building.Wall;
import com.qinshou.qinshoubox.me.bean.npc.Fairy;
import com.qinshou.qinshoubox.me.bean.npc.YellowGate;
import com.qinshou.qinshoubox.me.bean.npc.GoUpstairs;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:第 0 层
 * Created by 禽兽先生
 * Created on 207/6/5
 */

public class Floor0 extends AbsFloor {

    @Override
    public int getFloor() {
        return 0;
    }

    @Override
    public List<List<CaseBean>> setData() {
        List<List<CaseBean>> floor0 = new ArrayList<>();
        List<CaseBean> row0 = new ArrayList<>();
        row0.add(new Wall());
        row0.add(new StarrySky());
        row0.add(new StarrySky());
        row0.add(new StarrySky());
        row0.add(new StarrySky());
        row0.add(new GoUpstairs());
        row0.add(new StarrySky());
        row0.add(new StarrySky());
        row0.add(new StarrySky());
        row0.add(new StarrySky());
        row0.add(new Wall());
        floor0.add(row0);

        List<CaseBean> row1 = new ArrayList<>();
        row1.add(new Wall());
        row1.add(new StarrySky());
        row1.add(new StarrySky());
        row1.add(new StarrySky());
        row1.add(new StarrySky());
        row1.add(new Road());
        row1.add(new StarrySky());
        row1.add(new StarrySky());
        row1.add(new StarrySky());
        row1.add(new StarrySky());
        row1.add(new Wall());
        floor0.add(row1);

        List<CaseBean> row2 = new ArrayList<>();
        row2.add(new Wall());
        row2.add(new StarrySky());
        row2.add(new StarrySky());
        row2.add(new StarrySky());
        row2.add(new StarrySky());
        row2.add(new Road());
        row2.add(new StarrySky());
        row2.add(new StarrySky());
        row2.add(new StarrySky());
        row2.add(new StarrySky());
        row2.add(new Wall());
        floor0.add(row2);

        List<CaseBean> row3 = new ArrayList<>();
        row3.add(new Wall());
        row3.add(new StarrySky());
        row3.add(new StarrySky());
        row3.add(new StarrySky());
        row3.add(new StarrySky());
        row3.add(new Road());
        row3.add(new StarrySky());
        row3.add(new StarrySky());
        row3.add(new StarrySky());
        row3.add(new StarrySky());
        row3.add(new Wall());
        floor0.add(row3);

        List<CaseBean> row4 = new ArrayList<>();
        row4.add(new Wall());
        row4.add(new StarrySky());
        row4.add(new StarrySky());
        row4.add(new StarrySky());
        row4.add(new StarrySky());
        row4.add(new Road());
        row4.add(new StarrySky());
        row4.add(new StarrySky());
        row4.add(new StarrySky());
        row4.add(new StarrySky());
        row4.add(new Wall());
        floor0.add(row4);

        List<CaseBean> row5 = new ArrayList<>();
        row5.add(new Wall());
        row5.add(new StarrySky());
        row5.add(new StarrySky());
        row5.add(new StarrySky());
        row5.add(new StarrySky());
        row5.add(new Road());
        row5.add(new StarrySky());
        row5.add(new StarrySky());
        row5.add(new StarrySky());
        row5.add(new StarrySky());
        row5.add(new Wall());
        floor0.add(row5);

        List<CaseBean> row6 = new ArrayList<>();
        row6.add(new Wall());
        row6.add(new Wall());
        row6.add(new StarrySky());
        row6.add(new StarrySky());
        row6.add(new StarrySky());
        row6.add(new Road());
        row6.add(new StarrySky());
        row6.add(new StarrySky());
        row6.add(new StarrySky());
        row6.add(new Wall());
        row6.add(new Wall());
        floor0.add(row6);

        List<CaseBean> row7 = new ArrayList<>();
        row7.add(new Wall());
        row7.add(new Wall());
        row7.add(new Wall());
        row7.add(new Wall());
        row7.add(new Wall());
        row7.add(new YellowGate());
        row7.add(new Wall());
        row7.add(new Wall());
        row7.add(new Wall());
        row7.add(new Wall());
        row7.add(new Wall());
        floor0.add(row7);

        List<CaseBean> row8 = new ArrayList<>();
        row8.add(new FireSea());
        row8.add(new Wall());
        row8.add(new FireSea());
        row8.add(new Wall());
        row8.add(new Road());
        row8.add(new Fairy());
        row8.add(new Road());
        row8.add(new Wall());
        row8.add(new FireSea());
        row8.add(new Wall());
        row8.add(new FireSea());
        floor0.add(row8);

        List<CaseBean> row9 = new ArrayList<>();
        row9.add(new FireSea());
        row9.add(new FireSea());
        row9.add(new FireSea());
        row9.add(new FireSea());
        row9.add(new FireSea());
        row9.add(new Road());
        row9.add(new FireSea());
        row9.add(new FireSea());
        row9.add(new FireSea());
        row9.add(new FireSea());
        row9.add(new FireSea());
        floor0.add(row9);

        List<CaseBean> row10 = new ArrayList<>();
        row10.add(new FireSea());
        row10.add(new FireSea());
        row10.add(new FireSea());
        row10.add(new FireSea());
        row10.add(new FireSea());
        row10.add(new Road());
        row10.add(new FireSea());
        row10.add(new FireSea());
        row10.add(new FireSea());
        row10.add(new FireSea());
        row10.add(new FireSea());
        floor0.add(row10);

        return floor0;
    }

    @Override
    public void fromUpstairsToThisFloor() {
        resetWarriorPosition(new Position(1, 5));
    }

    @Override
    public void fromDownstairsToThisFloor() {
        resetWarriorPosition(new Position(9, 5));
    }
}
