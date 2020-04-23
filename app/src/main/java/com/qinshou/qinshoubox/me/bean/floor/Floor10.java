package com.qinshou.qinshoubox.me.bean.floor;


import com.qinshou.qinshoubox.me.bean.CaseBean;
import com.qinshou.qinshoubox.me.bean.Position;
import com.qinshou.qinshoubox.me.bean.building.Road;
import com.qinshou.qinshoubox.me.bean.building.Wall;
import com.qinshou.qinshoubox.me.bean.monster.DaBianFu;
import com.qinshou.qinshoubox.me.bean.monster.GuaiWang;
import com.qinshou.qinshoubox.me.bean.monster.HongBianFu;
import com.qinshou.qinshoubox.me.bean.monster.HongYiFaShi;
import com.qinshou.qinshoubox.me.bean.monster.MaYiFaShi;
import com.qinshou.qinshoubox.me.bean.monster.ShouMianWuShi;
import com.qinshou.qinshoubox.me.bean.npc.GoDownstairs;
import com.qinshou.qinshoubox.me.bean.npc.GoUpstairs;
import com.qinshou.qinshoubox.me.bean.npc.IronGateCanOpen;
import com.qinshou.qinshoubox.me.bean.npc.RedGate;
import com.qinshou.qinshoubox.me.bean.npc.YellowGate;
import com.qinshou.qinshoubox.me.bean.prop.BigBloodBottle;
import com.qinshou.qinshoubox.me.bean.prop.BlueGem;
import com.qinshou.qinshoubox.me.bean.prop.BlueKey;
import com.qinshou.qinshoubox.me.bean.prop.RedGem;
import com.qinshou.qinshoubox.me.bean.prop.SmallBloodBottle;
import com.qinshou.qinshoubox.me.bean.prop.YellowKey;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:第 10 层
 * Created by 禽兽先生
 * Created on 2017/4/26
 */

public class Floor10 extends AbsFloor {

    @Override
    public int getFloor() {
        return 10;
    }

    @Override
    public List<List<CaseBean>> setData() {
        List<List<CaseBean>> floor10 = new ArrayList<>();
        List<CaseBean> row0 = new ArrayList<>();
        row0.add(new Road());
        row0.add(new Wall());
        row0.add(new Wall());
        row0.add(new BlueGem());
        row0.add(new ShouMianWuShi());
        row0.add(new Wall());
        row0.add(new ShouMianWuShi());
        row0.add(new RedGem());
        row0.add(new Wall());
        row0.add(new Wall());
        row0.add(new Road());
        floor10.add(row0);

        List<CaseBean> row1 = new ArrayList<>();
        row1.add(new Road());
        row1.add(new Road());
        row1.add(new Wall());
        row1.add(new Wall());
        row1.add(new YellowGate());
        row1.add(new Wall());
        row1.add(new YellowGate());
        row1.add(new Wall());
        row1.add(new Wall());
        row1.add(new Road());
        row1.add(new HongYiFaShi());
        floor10.add(row1);

        List<CaseBean> row2 = new ArrayList<>();
        row2.add(new Road());
        row2.add(new Road());
        row2.add(new Road());
        row2.add(new Road());
        row2.add(new Road());
        row2.add(new Wall());
        row2.add(new Road());
        row2.add(new Road());
        row2.add(new Road());
        row2.add(new HongYiFaShi());
        row2.add(new BigBloodBottle());
        floor10.add(row2);

        List<CaseBean> row3 = new ArrayList<>();
        row3.add(new Road());
        row3.add(new Wall());
        row3.add(new Road());
        row3.add(new Wall());
        row3.add(new Wall());
        row3.add(new Wall());
        row3.add(new Wall());
        row3.add(new Wall());
        row3.add(new Road());
        row3.add(new Wall());
        row3.add(new Wall());
        floor10.add(row3);

        List<CaseBean> row4 = new ArrayList<>();
        row4.add(new DaBianFu());
        row4.add(new Wall());
        row4.add(new Road());
        row4.add(new Road());
        row4.add(new YellowKey());
        row4.add(new YellowKey());
        row4.add(new YellowKey());
        row4.add(new Road());
        row4.add(new Road());
        row4.add(new Wall());
        row4.add(new YellowKey());
        floor10.add(row4);

        List<CaseBean> row5 = new ArrayList<>();
        row5.add(new HongBianFu());
        row5.add(new Wall());
        row5.add(new Road());
        row5.add(new Wall());
        row5.add(new Wall());
        row5.add(new Wall());
        row5.add(new Wall());
        row5.add(new YellowGate());
        row5.add(new Wall());
        row5.add(new Wall());
        row5.add(new YellowKey());
        floor10.add(row5);

        List<CaseBean> row6 = new ArrayList<>();
        row6.add(new DaBianFu());
        row6.add(new Wall());
        row6.add(new Road());
        row6.add(new IronGateCanOpen());
        row6.add(new Road());
        row6.add(new GoDownstairs());
        row6.add(new Wall());
        row6.add(new Road());
        row6.add(new YellowGate());
        row6.add(new HongBianFu());
        row6.add(new Road());
        floor10.add(row6);

        List<CaseBean> row7 = new ArrayList<>();
        row7.add(new Road());
        row7.add(new Wall());
        row7.add(new Wall());
        row7.add(new Wall());
        row7.add(new Wall());
        row7.add(new Wall());
        row7.add(new Wall());
        row7.add(new YellowGate());
        row7.add(new Wall());
        row7.add(new Wall());
        row7.add(new Road());
        floor10.add(row7);

        List<CaseBean> row8 = new ArrayList<>();
        row8.add(new Road());
        row8.add(new Wall());
        row8.add(new SmallBloodBottle());
        row8.add(new BlueGem());
        row8.add(new RedGem());
        row8.add(new Wall());
        row8.add(new Road());
        row8.add(new HongBianFu());
        row8.add(new Road());
        row8.add(new Wall());
        row8.add(new YellowKey());
        floor10.add(row8);

        List<CaseBean> row9 = new ArrayList<>();
        row9.add(new Road());
        row9.add(new Wall());
        row9.add(new SmallBloodBottle());
        row9.add(new BlueGem());
        row9.add(new RedGem());
        row9.add(new RedGate());
        row9.add(new MaYiFaShi());
        row9.add(new Wall());
        row9.add(new MaYiFaShi());
        row9.add(new Wall());
        row9.add(new YellowKey());
        floor10.add(row9);

        List<CaseBean> row10 = new ArrayList<>();
        row10.add(new GoUpstairs());
        row10.add(new Wall());
        row10.add(new SmallBloodBottle());
        row10.add(new BlueGem());
        row10.add(new RedGem());
        row10.add(new Wall());
        row10.add(new BlueKey());
        row10.add(new Wall());
        row10.add(new BlueKey());
        row10.add(new Wall());
        row10.add(new SmallBloodBottle());
        floor10.add(row10);

        return floor10;
    }

    @Override
    public void fromUpstairsToThisFloor() {
        resetWarriorPosition(new Position(9, 0));
    }

    @Override
    public void fromDownstairsToThisFloor() {
        resetWarriorPosition(new Position(6, 4));
    }
}
