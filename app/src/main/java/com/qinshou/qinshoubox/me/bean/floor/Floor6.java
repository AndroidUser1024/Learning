package com.qinshou.qinshoubox.me.bean.floor;


import com.qinshou.qinshoubox.R;
import com.qinshou.qinshoubox.me.bean.CaseBean;
import com.qinshou.qinshoubox.me.bean.Position;
import com.qinshou.qinshoubox.me.bean.building.Road;
import com.qinshou.qinshoubox.me.bean.building.Wall;
import com.qinshou.qinshoubox.me.bean.monster.ChuJiWeiBing;
import com.qinshou.qinshoubox.me.bean.monster.DaBianFu;
import com.qinshou.qinshoubox.me.bean.monster.GaoJiFaShi;
import com.qinshou.qinshoubox.me.bean.monster.GuaiWang;
import com.qinshou.qinshoubox.me.bean.monster.HongBianFu;
import com.qinshou.qinshoubox.me.bean.monster.HongYiFaShi;
import com.qinshou.qinshoubox.me.bean.monster.IMonster;
import com.qinshou.qinshoubox.me.bean.monster.KuLouDuiZhang;
import com.qinshou.qinshoubox.me.bean.monster.ShiTouGuaiRen;
import com.qinshou.qinshoubox.me.bean.npc.BlueGate;
import com.qinshou.qinshoubox.me.bean.npc.GoDownstairs;
import com.qinshou.qinshoubox.me.bean.npc.GoUpstairs;
import com.qinshou.qinshoubox.me.bean.npc.RedGate;
import com.qinshou.qinshoubox.me.bean.npc.YellowGate;
import com.qinshou.qinshoubox.me.bean.prop.BigBloodBottle;
import com.qinshou.qinshoubox.me.bean.prop.BlueGem;
import com.qinshou.qinshoubox.me.bean.prop.GoldBullion;
import com.qinshou.qinshoubox.me.bean.prop.IProp;
import com.qinshou.qinshoubox.me.bean.prop.RedGem;
import com.qinshou.qinshoubox.me.bean.prop.SmallFlightFeather;
import com.qinshou.qinshoubox.me.bean.prop.YellowKey;
import com.qinshou.qinshoubox.me.enums.Npc;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:第 6 层
 * Created by 禽兽先生
 * Created on 2017/4/26
 */

public class Floor6 extends AbsFloor {

    @Override
    public int getFloor() {
        return 6;
    }

    @Override
    public List<List<CaseBean>> setData() {
        List<List<CaseBean>> floor6 = new ArrayList<>();
        List<CaseBean> row0 = new ArrayList<>();
        row0.add(new SmallFlightFeather());
        row0.add(new KuLouDuiZhang());
        row0.add(new Wall());
        row0.add(new BlueGem());
        row0.add(new Wall());
        row0.add(new YellowKey());
        row0.add(new GuaiWang());
        row0.add(new GoldBullion());
        row0.add(new Wall());
        row0.add(new BigBloodBottle());
        row0.add(new BigBloodBottle());
        floor6.add(row0);

        List<CaseBean> row1 = new ArrayList<>();
        row1.add(new KuLouDuiZhang());
        row1.add(new YellowKey());
        row1.add(new Wall());
        row1.add(new RedGem());
        row1.add(new Wall());
        row1.add(new Road());
        row1.add(new YellowKey());
        row1.add(new GuaiWang());
        row1.add(new Wall());
        row1.add(new ShiTouGuaiRen());
        row1.add(new BigBloodBottle());
        floor6.add(row1);

        List<CaseBean> row2 = new ArrayList<>();
        row2.add(new YellowKey());
        row2.add(new HongBianFu());
        row2.add(new BlueGate());
        row2.add(new Road());
        row2.add(new BlueGate());
        row2.add(new HongBianFu());
        row2.add(new Road());
        row2.add(new YellowKey());
        row2.add(new Wall());
        row2.add(new Road());
        row2.add(new ShiTouGuaiRen());
        floor6.add(row2);

        List<CaseBean> row3 = new ArrayList<>();
        row3.add(new Road());
        row3.add(new Road());
        row3.add(new Wall());
        row3.add(new ChuJiWeiBing());
        row3.add(new Wall());
        row3.add(new Road());
        row3.add(new Road());
        row3.add(new Road());
        row3.add(new Wall());
        row3.add(new HongYiFaShi());
        row3.add(new Road());
        floor6.add(row3);

        List<CaseBean> row4 = new ArrayList<>();
        row4.add(new Wall());
        row4.add(new Wall());
        row4.add(new Wall());
        row4.add(new RedGate());
        row4.add(new Wall());
        row4.add(new Wall());
        row4.add(new Wall());
        row4.add(new Wall());
        row4.add(new Wall());
        row4.add(new YellowGate());
        row4.add(new Wall());
        floor6.add(row4);

        List<CaseBean> row5 = new ArrayList<>();
        row5.add(new Road());
        row5.add(new Road());
        row5.add(new GaoJiFaShi());
        row5.add(new Road());
        row5.add(new YellowKey());
        row5.add(new YellowKey());
        row5.add(new YellowKey());
        row5.add(new Road());
        row5.add(new GaoJiFaShi());
        row5.add(new Road());
        row5.add(new Road());
        floor6.add(row5);

        List<CaseBean> row6 = new ArrayList<>();
        row6.add(new Road());
        row6.add(new Wall());
        row6.add(new Wall());
        row6.add(new Wall());
        row6.add(new Wall());
        row6.add(new Wall());
        row6.add(new Wall());
        row6.add(new Wall());
        row6.add(new Wall());
        row6.add(new Wall());
        row6.add(new Wall());
        floor6.add(row6);

        List<CaseBean> row7 = new ArrayList<>();
        row7.add(new Road());
        row7.add(new Wall());
        row7.add(new DaBianFu());
        row7.add(new YellowGate());
        row7.add(new DaBianFu());
        row7.add(new Road());
        row7.add(new Road());
        row7.add(new Road());
        row7.add(new Road());
        row7.add(new Road());
        row7.add(new Wall());
        floor6.add(row7);

        List<CaseBean> row8 = new ArrayList<>();
        row8.add(new Road());
        row8.add(new Wall());
        row8.add(new YellowGate());
        row8.add(new Wall());
        row8.add(new YellowGate());
        row8.add(new Wall());
        row8.add(new Wall());
        row8.add(new Wall());
        row8.add(new Wall());
        row8.add(new BlueGate());
        row8.add(new Wall());
        floor6.add(row8);

        List<CaseBean> row9 = new ArrayList<>();
        row9.add(new Road());
        row9.add(new Wall());
        row9.add(new DaBianFu());
        row9.add(new Wall());
        row9.add(new Road());
        row9.add(new Road());
        row9.add(new Wall());
        row9.add(new Wall());
        row9.add(new Road());
        row9.add(new Road());
        row9.add(new Wall());
        floor6.add(row9);

        List<CaseBean> row10 = new ArrayList<>();
        row10.add(new Road());
        row10.add(new Road());
        row10.add(new Road());
        row10.add(new Wall());
        row10.add(new GoUpstairs());
        row10.add(new Road());
        row10.add(new YellowGate());
        row10.add(new YellowGate());
        row10.add(new Road());
        row10.add(new GoDownstairs());
        row10.add(new Wall());
        floor6.add(row10);

        return floor6;
    }

    @Override
    public void fromUpstairsToThisFloor() {
        resetWarriorPosition(new Position(10, 5));
    }

    @Override
    public void fromDownstairsToThisFloor() {
        resetWarriorPosition(new Position(9, 9));
    }
}
