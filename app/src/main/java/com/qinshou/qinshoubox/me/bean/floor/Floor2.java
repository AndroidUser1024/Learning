package com.qinshou.qinshoubox.me.bean.floor;


import com.qinshou.qinshoubox.me.bean.CaseBean;
import com.qinshou.qinshoubox.me.bean.Position;
import com.qinshou.qinshoubox.me.bean.building.Road;
import com.qinshou.qinshoubox.me.bean.building.Wall;
import com.qinshou.qinshoubox.me.bean.monster.JinDuiZhang;
import com.qinshou.qinshoubox.me.bean.monster.JinWeiShi;
import com.qinshou.qinshoubox.me.bean.npc.BlueGate;
import com.qinshou.qinshoubox.me.bean.npc.GoDownstairs;
import com.qinshou.qinshoubox.me.bean.npc.GoUpstairs;
import com.qinshou.qinshoubox.me.bean.npc.GreenGate;
import com.qinshou.qinshoubox.me.bean.npc.IronGateCanOpen;
import com.qinshou.qinshoubox.me.bean.npc.BusinessManFloor2;
import com.qinshou.qinshoubox.me.bean.npc.MysteriousOldManFloor2;
import com.qinshou.qinshoubox.me.bean.npc.YellowGate;
import com.qinshou.qinshoubox.me.bean.prop.BigBloodBottle;
import com.qinshou.qinshoubox.me.bean.prop.BlueGem;
import com.qinshou.qinshoubox.me.bean.prop.BlueKey;
import com.qinshou.qinshoubox.me.bean.prop.RedGem;
import com.qinshou.qinshoubox.me.bean.prop.RedKey;
import com.qinshou.qinshoubox.me.bean.prop.SmallBloodBottle;
import com.qinshou.qinshoubox.me.bean.prop.YellowKey;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:第 2 层
 * Created by 禽兽先生
 * Created on 2017/4/26
 */

public class Floor2 extends AbsFloor {

    @Override
    public int getFloor() {
        return 2;
    }

    @Override
    public List<List<CaseBean>> setData() {
        List<List<CaseBean>> floor2 = new ArrayList<>();
        List<CaseBean> row0 = new ArrayList<>();
        row0.add(new GoDownstairs());
        row0.add(new Wall());
        row0.add(new Road());
        row0.add(new JinDuiZhang());
        row0.add(new Road());
        row0.add(new Wall());
        row0.add(new RedGem());
        row0.add(new BlueGem());
        row0.add(new YellowKey());
        row0.add(new RedKey());
        row0.add(new Wall());
        floor2.add(row0);

        List<CaseBean> row1 = new ArrayList<>();
        row1.add(new Road());
        row1.add(new Wall());
        row1.add(new BlueGem());
        row1.add(new Wall());
        row1.add(new BigBloodBottle());
        row1.add(new Wall());
        row1.add(new RedGem());
        row1.add(new BlueGem());
        row1.add(new YellowKey());
        row1.add(new BlueKey());
        row1.add(new Wall());
        floor2.add(row1);

        List<CaseBean> row2 = new ArrayList<>();
        row2.add(new Road());
        row2.add(new Wall());
        row2.add(new YellowKey());
        row2.add(new Wall());
        row2.add(new YellowKey());
        row2.add(new Wall());
        row2.add(new RedGem());
        row2.add(new BlueGem());
        row2.add(new YellowKey());
        row2.add(new JinWeiShi());
        row2.add(new Wall());
        floor2.add(row2);

        List<CaseBean> row3 = new ArrayList<>();
        row3.add(new Road());
        row3.add(new Wall());
        row3.add(new YellowKey());
        row3.add(new Wall());
        row3.add(new YellowKey());
        row3.add(new Wall());
        row3.add(new Wall());
        row3.add(new Wall());
        row3.add(new Wall());
        row3.add(new YellowGate());
        row3.add(new Wall());
        floor2.add(row3);

        List<CaseBean> row4 = new ArrayList<>();
        row4.add(new Road());
        row4.add(new Wall());
        row4.add(new Road());
        row4.add(new Wall());
        row4.add(new Road());
        row4.add(new Road());
        row4.add(new Road());
        row4.add(new YellowGate());
        row4.add(new Road());
        row4.add(new Road());
        row4.add(new Wall());
        floor2.add(row4);

        List<CaseBean> row5 = new ArrayList<>();
        row5.add(new Road());
        row5.add(new Wall());
        row5.add(new YellowGate());
        row5.add(new Wall());
        row5.add(new Wall());
        row5.add(new YellowGate());
        row5.add(new Wall());
        row5.add(new Wall());
        row5.add(new YellowGate());
        row5.add(new Wall());
        row5.add(new Wall());
        floor2.add(row5);

        List<CaseBean> row6 = new ArrayList<>();
        row6.add(new Road());
        row6.add(new GreenGate());
        row6.add(new Road());
        row6.add(new Road());
        row6.add(new Road());
        row6.add(new Road());
        row6.add(new Wall());
        row6.add(new Road());
        row6.add(new JinWeiShi());
        row6.add(new Road());
        row6.add(new Wall());
        floor2.add(row6);

        List<CaseBean> row7 = new ArrayList<>();
        row7.add(new Road());
        row7.add(new Wall());
        row7.add(new YellowGate());
        row7.add(new Wall());
        row7.add(new Wall());
        row7.add(new BlueGate());
        row7.add(new Wall());
        row7.add(new IronGateCanOpen());
        row7.add(new Wall());
        row7.add(new IronGateCanOpen());
        row7.add(new Wall());
        floor2.add(row7);

        List<CaseBean> row8 = new ArrayList<>();
        row8.add(new Road());
        row8.add(new Wall());
        row8.add(new YellowKey());
        row8.add(new Wall());
        row8.add(new BigBloodBottle());
        row8.add(new SmallBloodBottle());
        row8.add(new Wall());
        row8.add(new Road());
        row8.add(new Wall());
        row8.add(new Road());
        row8.add(new Wall());
        floor2.add(row8);

        List<CaseBean> row9 = new ArrayList<>();
        row9.add(new Road());
        row9.add(new Wall());
        row9.add(new YellowKey());
        row9.add(new Wall());
        row9.add(new BigBloodBottle());
        row9.add(new SmallBloodBottle());
        row9.add(new Wall());
        row9.add(new Road());
        row9.add(new Wall());
        row9.add(new Road());
        row9.add(new Wall());
        floor2.add(row9);

        List<CaseBean> row10 = new ArrayList<>();
        row10.add(new GoUpstairs());
        row10.add(new Wall());
        row10.add(new RedGem());
        row10.add(new Wall());
        row10.add(new BigBloodBottle());
        row10.add(new BigBloodBottle());
        row10.add(new Wall());
        row10.add(new MysteriousOldManFloor2());
        row10.add(new Wall());
        row10.add(new BusinessManFloor2());
        row10.add(new Wall());
        floor2.add(row10);

        return floor2;
    }

    @Override
    public void fromUpstairsToThisFloor() {
        resetWarriorPosition(new Position(9, 0));
    }

    @Override
    public void fromDownstairsToThisFloor() {
        resetWarriorPosition(new Position(1, 0));
    }
}
