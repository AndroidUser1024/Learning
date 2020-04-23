package com.qinshou.qinshoubox.me.bean.floor;


import com.qinshou.qinshoubox.R;
import com.qinshou.qinshoubox.me.bean.CaseBean;
import com.qinshou.qinshoubox.me.bean.Position;
import com.qinshou.qinshoubox.me.bean.building.Road;
import com.qinshou.qinshoubox.me.bean.building.Wall;
import com.qinshou.qinshoubox.me.bean.monster.GuaiWang;
import com.qinshou.qinshoubox.me.bean.monster.HongYiFaShi;
import com.qinshou.qinshoubox.me.bean.monster.IMonster;
import com.qinshou.qinshoubox.me.bean.monster.KuLouDuiZhang;
import com.qinshou.qinshoubox.me.bean.monster.MaYiFaShi;
import com.qinshou.qinshoubox.me.bean.monster.ShiTouGuaiRen;
import com.qinshou.qinshoubox.me.bean.monster.ShouMianWuShi;
import com.qinshou.qinshoubox.me.bean.npc.BlueGate;
import com.qinshou.qinshoubox.me.bean.npc.GoDownstairs;
import com.qinshou.qinshoubox.me.bean.npc.GoUpstairs;
import com.qinshou.qinshoubox.me.bean.npc.RedGate;
import com.qinshou.qinshoubox.me.bean.npc.YellowGate;
import com.qinshou.qinshoubox.me.bean.prop.BigBloodBottle;
import com.qinshou.qinshoubox.me.bean.prop.BlueGem;
import com.qinshou.qinshoubox.me.bean.prop.BlueKey;
import com.qinshou.qinshoubox.me.bean.prop.IProp;
import com.qinshou.qinshoubox.me.bean.prop.QingFengSword;
import com.qinshou.qinshoubox.me.bean.prop.RedGem;
import com.qinshou.qinshoubox.me.bean.prop.SmallBloodBottle;
import com.qinshou.qinshoubox.me.bean.prop.WindCompass;
import com.qinshou.qinshoubox.me.bean.prop.YellowKey;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:第 9 层
 * Created by 禽兽先生
 * Created on 2017/4/26
 */

public class Floor9 extends AbsFloor {

    @Override
    public int getFloor() {
        return 9;
    }

    @Override
    public List<List<CaseBean>> setData() {
        List<List<CaseBean>> floor9 = new ArrayList<>();
        List<CaseBean> row0 = new ArrayList<>();
        row0.add(new WindCompass());
        row0.add(new YellowKey());
        row0.add(new Road());
        row0.add(new Wall());
        row0.add(new Wall());
        row0.add(new Wall());
        row0.add(new Road());
        row0.add(new Road());
        row0.add(new Road());
        row0.add(new Wall());
        row0.add(new Road());
        floor9.add(row0);

        List<CaseBean> row1 = new ArrayList<>();
        row1.add(new YellowKey());
        row1.add(new Road());
        row1.add(new ShouMianWuShi());
        row1.add(new YellowGate());
        row1.add(new Road());
        row1.add(new Road());
        row1.add(new Road());
        row1.add(new Wall());
        row1.add(new Road());
        row1.add(new YellowGate());
        row1.add(new KuLouDuiZhang());
        floor9.add(row1);

        List<CaseBean> row2 = new ArrayList<>();
        row2.add(new Wall());
        row2.add(new YellowGate());
        row2.add(new Wall());
        row2.add(new Wall());
        row2.add(new Road());
        row2.add(new Wall());
        row2.add(new Wall());
        row2.add(new Wall());
        row2.add(new Road());
        row2.add(new Wall());
        row2.add(new YellowKey());
        floor9.add(row2);

        List<CaseBean> row3 = new ArrayList<>();
        row3.add(new Road());
        row3.add(new Road());
        row3.add(new Road());
        row3.add(new Wall());
        row3.add(new Road());
        row3.add(new Wall());
        row3.add(new Road());
        row3.add(new Road());
        row3.add(new Road());
        row3.add(new Wall());
        row3.add(new YellowKey());
        floor9.add(row3);

        List<CaseBean> row4 = new ArrayList<>();
        row4.add(new Road());
        row4.add(new Road());
        row4.add(new Road());
        row4.add(new RedGate());
        row4.add(new Road());
        row4.add(new Wall());
        row4.add(new GoDownstairs());
        row4.add(new Wall());
        row4.add(new Road());
        row4.add(new Wall());
        row4.add(new SmallBloodBottle());
        floor9.add(row4);

        List<CaseBean> row5 = new ArrayList<>();
        row5.add(new Wall());
        row5.add(new BlueGate());
        row5.add(new Wall());
        row5.add(new Wall());
        row5.add(new Road());
        row5.add(new Wall());
        row5.add(new Wall());
        row5.add(new Wall());
        row5.add(new Road());
        row5.add(new Wall());
        row5.add(new Wall());
        floor9.add(row5);

        List<CaseBean> row6 = new ArrayList<>();
        row6.add(new BlueGem());
        row6.add(new HongYiFaShi());
        row6.add(new RedGem());
        row6.add(new Wall());
        row6.add(new MaYiFaShi());
        row6.add(new Wall());
        row6.add(new GoUpstairs());
        row6.add(new Wall());
        row6.add(new Road());
        row6.add(new Wall());
        row6.add(new SmallBloodBottle());
        floor9.add(row6);

        List<CaseBean> row7 = new ArrayList<>();
        row7.add(new Wall());
        row7.add(new YellowGate());
        row7.add(new Wall());
        row7.add(new Wall());
        row7.add(new Road());
        row7.add(new Road());
        row7.add(new Road());
        row7.add(new YellowGate());
        row7.add(new Road());
        row7.add(new Wall());
        row7.add(new YellowKey());
        floor9.add(row7);

        List<CaseBean> row8 = new ArrayList<>();
        row8.add(new KuLouDuiZhang());
        row8.add(new SmallBloodBottle());
        row8.add(new KuLouDuiZhang());
        row8.add(new Wall());
        row8.add(new Wall());
        row8.add(new BlueGate());
        row8.add(new Wall());
        row8.add(new Wall());
        row8.add(new Road());
        row8.add(new Wall());
        row8.add(new YellowKey());
        floor9.add(row8);

        List<CaseBean> row9 = new ArrayList<>();
        row9.add(new BlueKey());
        row9.add(new KuLouDuiZhang());
        row9.add(new SmallBloodBottle());
        row9.add(new Wall());
        row9.add(new ShiTouGuaiRen());
        row9.add(new MaYiFaShi());
        row9.add(new ShiTouGuaiRen());
        row9.add(new Wall());
        row9.add(new Road());
        row9.add(new YellowGate());
        row9.add(new KuLouDuiZhang());
        floor9.add(row9);

        List<CaseBean> row10 = new ArrayList<>();
        row10.add(new QingFengSword());
        row10.add(new BlueKey());
        row10.add(new KuLouDuiZhang());
        row10.add(new YellowGate());
        row10.add(new BigBloodBottle());
        row10.add(new ShiTouGuaiRen());
        row10.add(new BigBloodBottle());
        row10.add(new Wall());
        row10.add(new Road());
        row10.add(new Wall());
        row10.add(new Road());
        floor9.add(row10);

        return floor9;
    }

    @Override
    public void fromUpstairsToThisFloor() {
        resetWarriorPosition(new Position(7, 6));
    }

    @Override
    public void fromDownstairsToThisFloor() {
        resetWarriorPosition(new Position(3, 6));
    }
}
