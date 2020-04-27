package com.qinshou.qinshoubox.me.bean.floor;


import com.qinshou.qinshoubox.me.bean.CaseBean;
import com.qinshou.qinshoubox.me.bean.Position;
import com.qinshou.qinshoubox.me.bean.building.Road;
import com.qinshou.qinshoubox.me.bean.building.Wall;
import com.qinshou.qinshoubox.me.bean.monster.HongTouGuai;
import com.qinshou.qinshoubox.me.bean.monster.KuLouRen;
import com.qinshou.qinshoubox.me.bean.monster.LvTouGuai;
import com.qinshou.qinshoubox.me.bean.monster.XiaoBianFu;
import com.qinshou.qinshoubox.me.bean.npc.GoDownstairs;
import com.qinshou.qinshoubox.me.bean.npc.GoUpstairs;
import com.qinshou.qinshoubox.me.bean.npc.SmallStore1;
import com.qinshou.qinshoubox.me.bean.npc.SmallStore2;
import com.qinshou.qinshoubox.me.bean.npc.SmallStore3;
import com.qinshou.qinshoubox.me.bean.npc.YellowGate;
import com.qinshou.qinshoubox.me.bean.prop.BigBloodBottle;
import com.qinshou.qinshoubox.me.bean.prop.BlueGem;
import com.qinshou.qinshoubox.me.bean.prop.IronSword;
import com.qinshou.qinshoubox.me.bean.prop.RedGem;
import com.qinshou.qinshoubox.me.bean.prop.YellowKey;
import com.qinshou.qinshoubox.me.bean.warrior.WarriorBean;
import com.qinshou.qinshoubox.util.MagicGameManager;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:第 3 层
 * Created by 禽兽先生
 * Created on 2017/4/26
 */

public class Floor3 extends AbsFloor {

    @Override
    public int getFloor() {
        return 3;
    }

    @Override
    public List<List<CaseBean>> setData() {
        List<List<CaseBean>> floor3 = new ArrayList<>();
        List<CaseBean> row0 = new ArrayList<>();
        row0.add(new IronSword());
        row0.add(new HongTouGuai());
        row0.add(new YellowKey());
        row0.add(new Wall());
        row0.add(new SmallStore1());
        row0.add(new SmallStore2());
        row0.add(new SmallStore3());
        row0.add(new Wall());
        row0.add(new Wall());
        row0.add(new Wall());
        row0.add(new Wall());
        floor3.add(row0);

        List<CaseBean> row1 = new ArrayList<>();
        row1.add(new HongTouGuai());
        row1.add(new YellowKey());
        row1.add(new Road());
        row1.add(new Wall());
        row1.add(new Road());
        row1.add(new Road());
        row1.add(new Road());
        row1.add(new Wall());
        row1.add(new Road());
        row1.add(new XiaoBianFu());
        row1.add(new Road());
        floor3.add(row1);

        List<CaseBean> row2 = new ArrayList<>();
        row2.add(new YellowKey());
        row2.add(new KuLouRen());
        row2.add(new Road());
        row2.add(new Wall());
        row2.add(new Wall());
        row2.add(new YellowGate());
        row2.add(new Wall());
        row2.add(new Wall());
        row2.add(new Road());
        row2.add(new Wall());
        row2.add(new Road());
        floor3.add(row2);

        List<CaseBean> row3 = new ArrayList<>();
        row3.add(new Wall());
        row3.add(new YellowGate());
        row3.add(new Wall());
        row3.add(new Wall());
        row3.add(new Road());
        row3.add(new KuLouRen());
        row3.add(new Road());
        row3.add(new Wall());
        row3.add(new YellowKey());
        row3.add(new Wall());
        row3.add(new HongTouGuai());
        floor3.add(row3);

        List<CaseBean> row4 = new ArrayList<>();
        row4.add(new Road());
        row4.add(new Road());
        row4.add(new Road());
        row4.add(new Wall());
        row4.add(new Wall());
        row4.add(new Wall());
        row4.add(new Road());
        row4.add(new Wall());
        row4.add(new YellowKey());
        row4.add(new Wall());
        row4.add(new XiaoBianFu());
        floor3.add(row4);

        List<CaseBean> row5 = new ArrayList<>();
        row5.add(new LvTouGuai());
        row5.add(new Wall());
        row5.add(new Road());
        row5.add(new XiaoBianFu());
        row5.add(new HongTouGuai());
        row5.add(new XiaoBianFu());
        row5.add(new Road());
        row5.add(new Wall());
        row5.add(new YellowKey());
        row5.add(new Wall());
        row5.add(new HongTouGuai());
        floor3.add(row5);

        List<CaseBean> row6 = new ArrayList<>();
        row6.add(new LvTouGuai());
        row6.add(new Wall());
        row6.add(new Wall());
        row6.add(new Wall());
        row6.add(new Wall());
        row6.add(new Wall());
        row6.add(new Road());
        row6.add(new Road());
        row6.add(new Road());
        row6.add(new Wall());
        row6.add(new Road());
        floor3.add(row6);

        List<CaseBean> row7 = new ArrayList<>();
        row7.add(new Road());
        row7.add(new Road());
        row7.add(new Road());
        row7.add(new Road());
        row7.add(new Road());
        row7.add(new Wall());
        row7.add(new Wall());
        row7.add(new YellowGate());
        row7.add(new Wall());
        row7.add(new Wall());
        row7.add(new Road());
        floor3.add(row7);

        List<CaseBean> row8 = new ArrayList<>();
        row8.add(new Wall());
        row8.add(new Wall());
        row8.add(new Wall());
        row8.add(new Wall());
        row8.add(new XiaoBianFu());
        row8.add(new Wall());
        row8.add(new HongTouGuai());
        row8.add(new Road());
        row8.add(new HongTouGuai());
        row8.add(new Wall());
        row8.add(new Road());
        floor3.add(row8);

        List<CaseBean> row9 = new ArrayList<>();
        row9.add(new Wall());
        row9.add(new Road());
        row9.add(new Road());
        row9.add(new Road());
        row9.add(new Road());
        row9.add(new Wall());
        row9.add(new BlueGem());
        row9.add(new XiaoBianFu());
        row9.add(new YellowKey());
        row9.add(new Wall());
        row9.add(new Road());
        floor3.add(row9);

        List<CaseBean> row10 = new ArrayList<>();
        row10.add(new GoDownstairs());
        row10.add(new Road());
        row10.add(new Wall());
        row10.add(new Wall());
        row10.add(new Wall());
        row10.add(new Wall());
        row10.add(new RedGem());
        row10.add(new BigBloodBottle());
        row10.add(new YellowKey());
        row10.add(new Wall());
        row10.add(new GoUpstairs());
        floor3.add(row10);

        return floor3;
    }

    @Override
    public void fromUpstairsToThisFloor() {
        WarriorBean warriorBean = MagicGameManager.SINGLETON.getWarriorBean();
        warriorBean.setPosition(new Position(9, 10));
        MagicGameManager.SINGLETON.setCase(warriorBean.getPosition(), warriorBean);
    }

    @Override
    public void fromDownstairsToThisFloor() {
        WarriorBean warriorBean = MagicGameManager.SINGLETON.getWarriorBean();
        warriorBean.setPosition(new Position(10, 1));
        MagicGameManager.SINGLETON.setCase(warriorBean.getPosition(), warriorBean);
    }
}
