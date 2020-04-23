package com.qinshou.qinshoubox.me.bean.floor;


import com.qinshou.qinshoubox.me.bean.CaseBean;
import com.qinshou.qinshoubox.me.bean.Position;
import com.qinshou.qinshoubox.me.bean.building.Road;
import com.qinshou.qinshoubox.me.bean.building.Wall;
import com.qinshou.qinshoubox.me.bean.monster.GaoJiWeiBing;
import com.qinshou.qinshoubox.me.bean.monster.JinDuiZhang;
import com.qinshou.qinshoubox.me.bean.monster.JinWeiShi;
import com.qinshou.qinshoubox.me.bean.monster.MingDuiZhang;
import com.qinshou.qinshoubox.me.bean.monster.MingWeiBing;
import com.qinshou.qinshoubox.me.bean.monster.MingZhanShi;
import com.qinshou.qinshoubox.me.bean.npc.BlueGate;
import com.qinshou.qinshoubox.me.bean.npc.GoDownstairs;
import com.qinshou.qinshoubox.me.bean.npc.GoUpstairs;
import com.qinshou.qinshoubox.me.bean.npc.IronGateCanNotOpen;
import com.qinshou.qinshoubox.me.bean.npc.IronGateCanOpen;
import com.qinshou.qinshoubox.me.bean.npc.MysteriousOldManFloor13;
import com.qinshou.qinshoubox.me.bean.npc.RedGate;
import com.qinshou.qinshoubox.me.bean.npc.YellowGate;
import com.qinshou.qinshoubox.me.bean.prop.BigBloodBottle;
import com.qinshou.qinshoubox.me.bean.prop.BigFlightFeather;
import com.qinshou.qinshoubox.me.bean.prop.BlueGem;
import com.qinshou.qinshoubox.me.bean.prop.RedGem;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:第 13 层
 * Created by 禽兽先生
 * Created on 2017/4/27
 */

public class Floor13 extends AbsFloor {

    @Override
    public int getFloor() {
        return 13;
    }

    @Override
    public List<List<CaseBean>> setData() {
        List<List<CaseBean>> floor13 = new ArrayList<>();
        List<CaseBean> row0 = new ArrayList<>();
        row0.add(new Road());
        row0.add(new GaoJiWeiBing());
        row0.add(new Road());
        row0.add(new Road());
        row0.add(new Road());
        row0.add(new Road());
        row0.add(new Road());
        row0.add(new Wall());
        row0.add(new Road());
        row0.add(new MingZhanShi());
        row0.add(new Road());
        floor13.add(row0);

        List<CaseBean> row1 = new ArrayList<>();
        row1.add(new Road());
        row1.add(new Wall());
        row1.add(new Wall());
        row1.add(new Wall());
        row1.add(new Wall());
        row1.add(new Wall());
        row1.add(new YellowGate());
        row1.add(new Wall());
        row1.add(new Road());
        row1.add(new Wall());
        row1.add(new Road());
        floor13.add(row1);

        List<CaseBean> row2 = new ArrayList<>();
        row2.add(new Road());
        row2.add(new Wall());
        row2.add(new Road());
        row2.add(new Road());
        row2.add(new MingWeiBing());
        row2.add(new Road());
        row2.add(new Road());
        row2.add(new Wall());
        row2.add(new Road());
        row2.add(new Wall());
        row2.add(new Road());
        floor13.add(row2);

        List<CaseBean> row3 = new ArrayList<>();
        row3.add(new BigBloodBottle());
        row3.add(new Wall());
        row3.add(new RedGate());
        row3.add(new Wall());
        row3.add(new Wall());
        row3.add(new Wall());
        row3.add(new Road());
        row3.add(new Wall());
        row3.add(new Road());
        row3.add(new Wall());
        row3.add(new Road());
        floor13.add(row3);

        List<CaseBean> row4 = new ArrayList<>();
        row4.add(new JinWeiShi());
        row4.add(new Wall());
        row4.add(new Road());
        row4.add(new Road());
        row4.add(new MingZhanShi());
        row4.add(new Wall());
        row4.add(new MingWeiBing());
        row4.add(new Wall());
        row4.add(new RedGem());
        row4.add(new Wall());
        row4.add(new Road());
        floor13.add(row4);

        List<CaseBean> row5 = new ArrayList<>();
        row5.add(new JinDuiZhang());
        row5.add(new Wall());
        row5.add(new Road());
        row5.add(new MingDuiZhang());
        row5.add(new IronGateCanNotOpen());
        row5.add(new Wall());
        row5.add(new GaoJiWeiBing());
        row5.add(new Wall());
        row5.add(new RedGem());
        row5.add(new Wall());
        row5.add(new Road());
        floor13.add(row5);

        List<CaseBean> row6 = new ArrayList<>();
        row6.add(new JinWeiShi());
        row6.add(new Wall());
        row6.add(new MingZhanShi());
        row6.add(new IronGateCanOpen());
        row6.add(new MysteriousOldManFloor13());
        row6.add(new Wall());
        row6.add(new MingWeiBing());
        row6.add(new Wall());
        row6.add(new RedGem());
        row6.add(new Wall());
        row6.add(new BlueGem());
        floor13.add(row6);

        List<CaseBean> row7 = new ArrayList<>();
        row7.add(new Road());
        row7.add(new Wall());
        row7.add(new Wall());
        row7.add(new Wall());
        row7.add(new Wall());
        row7.add(new Wall());
        row7.add(new Road());
        row7.add(new Wall());
        row7.add(new Road());
        row7.add(new Wall());
        row7.add(new BlueGem());
        floor13.add(row7);

        List<CaseBean> row8 = new ArrayList<>();
        row8.add(new Road());
        row8.add(new JinWeiShi());
        row8.add(new Road());
        row8.add(new Wall());
        row8.add(new Road());
        row8.add(new Road());
        row8.add(new Road());
        row8.add(new MingZhanShi());
        row8.add(new Road());
        row8.add(new Wall());
        row8.add(new BlueGem());
        floor13.add(row8);

        List<CaseBean> row9 = new ArrayList<>();
        row9.add(new Wall());
        row9.add(new Wall());
        row9.add(new Road());
        row9.add(new Wall());
        row9.add(new BigBloodBottle());
        row9.add(new Wall());
        row9.add(new Wall());
        row9.add(new Wall());
        row9.add(new Wall());
        row9.add(new Wall());
        row9.add(new Road());
        floor13.add(row9);

        List<CaseBean> row10 = new ArrayList<>();
        row10.add(new GoDownstairs());
        row10.add(new Road());
        row10.add(new Road());
        row10.add(new BlueGate());
        row10.add(new Road());
        row10.add(new GoUpstairs());
        row10.add(new Wall());
        row10.add(new BigFlightFeather());
        row10.add(new MingDuiZhang());
        row10.add(new YellowGate());
        row10.add(new Road());
        floor13.add(row10);

        return floor13;
    }

    @Override
    public void fromUpstairsToThisFloor() {
        resetWarriorPosition(new Position(10, 4));
    }

    @Override
    public void fromDownstairsToThisFloor() {
        resetWarriorPosition(new Position(10, 1));
    }
}
