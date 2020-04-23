package com.qinshou.qinshoubox.me.bean.floor;


import com.qinshou.qinshoubox.me.bean.CaseBean;
import com.qinshou.qinshoubox.me.bean.Position;
import com.qinshou.qinshoubox.me.bean.building.Road;
import com.qinshou.qinshoubox.me.bean.building.StarrySky;
import com.qinshou.qinshoubox.me.bean.building.Wall;
import com.qinshou.qinshoubox.me.bean.monster.GaoJiWeiBing;
import com.qinshou.qinshoubox.me.bean.monster.LingWuShi;
import com.qinshou.qinshoubox.me.bean.monster.MingDuiZhang;
import com.qinshou.qinshoubox.me.bean.monster.MingWeiBing;
import com.qinshou.qinshoubox.me.bean.monster.MingZhanShi;
import com.qinshou.qinshoubox.me.bean.npc.BlueGate;
import com.qinshou.qinshoubox.me.bean.npc.GoDownstairs;
import com.qinshou.qinshoubox.me.bean.npc.GoUpstairs;
import com.qinshou.qinshoubox.me.bean.npc.IronGateCanOpen;
import com.qinshou.qinshoubox.me.bean.prop.BigBloodBottle;
import com.qinshou.qinshoubox.me.bean.prop.HolyWater;
import com.qinshou.qinshoubox.me.bean.prop.KeyBox;
import com.qinshou.qinshoubox.me.bean.prop.SmallBloodBottle;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:第 14 层
 * Created by 禽兽先生
 * Created on 2017/4/27
 */

public class Floor14 extends AbsFloor {

    @Override
    public int getFloor() {
        return 14;
    }

    @Override
    public List<List<CaseBean>> setData() {
        List<List<CaseBean>> floor14 = new ArrayList<>();
        List<CaseBean> row0 = new ArrayList<>();
        row0.add(new Wall());
        row0.add(new Road());
        row0.add(new LingWuShi());
        row0.add(new KeyBox());
        row0.add(new GoUpstairs());
        row0.add(new Road());
        row0.add(new Road());
        row0.add(new Road());
        row0.add(new Road());
        row0.add(new Road());
        row0.add(new Wall());
        floor14.add(row0);

        List<CaseBean> row1 = new ArrayList<>();
        row1.add(new Wall());
        row1.add(new Road());
        row1.add(new BigBloodBottle());
        row1.add(new Wall());
        row1.add(new Wall());
        row1.add(new Wall());
        row1.add(new Wall());
        row1.add(new Wall());
        row1.add(new BigBloodBottle());
        row1.add(new Road());
        row1.add(new Wall());
        floor14.add(row1);

        List<CaseBean> row2 = new ArrayList<>();
        row2.add(new Wall());
        row2.add(new Road());
        row2.add(new Wall());
        row2.add(new Wall());
        row2.add(new Wall());
        row2.add(new Wall());
        row2.add(new Wall());
        row2.add(new Wall());
        row2.add(new Wall());
        row2.add(new Road());
        row2.add(new Wall());
        floor14.add(row2);

        List<CaseBean> row3 = new ArrayList<>();
        row3.add(new Wall());
        row3.add(new Road());
        row3.add(new Wall());
        row3.add(new Wall());
        row3.add(new Wall());
        row3.add(new HolyWater());
        row3.add(new Wall());
        row3.add(new Wall());
        row3.add(new Wall());
        row3.add(new Road());
        row3.add(new Wall());
        floor14.add(row3);

        List<CaseBean> row4 = new ArrayList<>();
        row4.add(new Wall());
        row4.add(new Road());
        row4.add(new Wall());
        row4.add(new Wall());
        row4.add(new Wall());
        row4.add(new IronGateCanOpen());
        row4.add(new Wall());
        row4.add(new Wall());
        row4.add(new Wall());
        row4.add(new Road());
        row4.add(new Wall());
        floor14.add(row4);

        List<CaseBean> row5 = new ArrayList<>();
        row5.add(new Wall());
        row5.add(new Road());
        row5.add(new SmallBloodBottle());
        row5.add(new Wall());
        row5.add(new Wall());
        row5.add(new MingZhanShi());
        row5.add(new Wall());
        row5.add(new Wall());
        row5.add(new SmallBloodBottle());
        row5.add(new Road());
        row5.add(new Wall());
        floor14.add(row5);

        List<CaseBean> row6 = new ArrayList<>();
        row6.add(new Wall());
        row6.add(new Road());
        row6.add(new StarrySky());
        row6.add(new StarrySky());
        row6.add(new Wall());
        row6.add(new MingDuiZhang());
        row6.add(new Wall());
        row6.add(new StarrySky());
        row6.add(new StarrySky());
        row6.add(new Road());
        row6.add(new Wall());
        floor14.add(row6);

        List<CaseBean> row7 = new ArrayList<>();
        row7.add(new Wall());
        row7.add(new Road());
        row7.add(new StarrySky());
        row7.add(new StarrySky());
        row7.add(new Wall());
        row7.add(new MingZhanShi());
        row7.add(new Wall());
        row7.add(new StarrySky());
        row7.add(new StarrySky());
        row7.add(new Road());
        row7.add(new Wall());
        floor14.add(row7);

        List<CaseBean> row8 = new ArrayList<>();
        row8.add(new Wall());
        row8.add(new Road());
        row8.add(new StarrySky());
        row8.add(new StarrySky());
        row8.add(new Wall());
        row8.add(new BlueGate());
        row8.add(new Wall());
        row8.add(new StarrySky());
        row8.add(new StarrySky());
        row8.add(new Road());
        row8.add(new Wall());
        floor14.add(row8);

        List<CaseBean> row9 = new ArrayList<>();
        row9.add(new Wall());
        row9.add(new MingWeiBing());
        row9.add(new GaoJiWeiBing());
        row9.add(new MingWeiBing());
        row9.add(new BlueGate());
        row9.add(new Road());
        row9.add(new BlueGate());
        row9.add(new MingWeiBing());
        row9.add(new GaoJiWeiBing());
        row9.add(new MingWeiBing());
        row9.add(new Wall());
        floor14.add(row9);

        List<CaseBean> row10 = new ArrayList<>();
        row10.add(new Wall());
        row10.add(new Wall());
        row10.add(new Wall());
        row10.add(new Wall());
        row10.add(new Wall());
        row10.add(new GoDownstairs());
        row10.add(new Wall());
        row10.add(new Wall());
        row10.add(new Wall());
        row10.add(new Wall());
        row10.add(new Wall());
        floor14.add(row10);

        return floor14;
    }

    @Override
    public void fromUpstairsToThisFloor() {
        resetWarriorPosition(new Position(0, 5));
    }

    @Override
    public void fromDownstairsToThisFloor() {
        resetWarriorPosition(new Position(9, 5));
    }
}
