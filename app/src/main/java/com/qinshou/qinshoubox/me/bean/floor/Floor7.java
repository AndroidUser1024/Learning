package com.qinshou.qinshoubox.me.bean.floor;


import com.qinshou.qinshoubox.me.bean.CaseBean;
import com.qinshou.qinshoubox.me.bean.Position;
import com.qinshou.qinshoubox.me.bean.building.Road;
import com.qinshou.qinshoubox.me.bean.building.Wall;
import com.qinshou.qinshoubox.me.bean.monster.BaiYiWuShi;
import com.qinshou.qinshoubox.me.bean.monster.GuaiWang;
import com.qinshou.qinshoubox.me.bean.monster.HongBianFu;
import com.qinshou.qinshoubox.me.bean.monster.KuLouDuiZhang;
import com.qinshou.qinshoubox.me.bean.npc.BlueGate;
import com.qinshou.qinshoubox.me.bean.npc.GoDownstairs;
import com.qinshou.qinshoubox.me.bean.npc.GoUpstairs;
import com.qinshou.qinshoubox.me.bean.npc.IronGateCanNotOpen;
import com.qinshou.qinshoubox.me.bean.npc.IronGateCanOpen;
import com.qinshou.qinshoubox.me.bean.npc.RedGate;
import com.qinshou.qinshoubox.me.bean.npc.YellowGate;
import com.qinshou.qinshoubox.me.bean.prop.BigBloodBottle;
import com.qinshou.qinshoubox.me.bean.prop.BlueGem;
import com.qinshou.qinshoubox.me.bean.prop.BlueKey;
import com.qinshou.qinshoubox.me.bean.prop.RedGem;
import com.qinshou.qinshoubox.me.bean.prop.SmallBloodBottle;
import com.qinshou.qinshoubox.me.bean.prop.StarCross;
import com.qinshou.qinshoubox.me.bean.prop.YellowKey;
import com.qinshou.qinshoubox.me.bean.warrior.WarriorBean;
import com.qinshou.qinshoubox.util.MagicGameManager;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:第 7 层
 * Created by 禽兽先生
 * Created on 2017/4/26
 */

public class Floor7 extends AbsFloor {

    @Override
    public int getFloor() {
        return 7;
    }

    @Override
    public List<List<CaseBean>> setData() {
        List<List<CaseBean>> floor7 = new ArrayList<>();
        List<CaseBean> row0 = new ArrayList<>();
        row0.add(new GoUpstairs());
        row0.add(new Road());
        row0.add(new Road());
        row0.add(new Road());
        row0.add(new Road());
        row0.add(new Road());
        row0.add(new Road());
        row0.add(new Road());
        row0.add(new Wall());
        row0.add(new Wall());
        row0.add(new Wall());
        floor7.add(row0);

        List<CaseBean> row1 = new ArrayList<>();
        row1.add(new Wall());
        row1.add(new Wall());
        row1.add(new Road());
        row1.add(new HongBianFu());
        row1.add(new Wall());
        row1.add(new BlueGate());
        row1.add(new Wall());
        row1.add(new KuLouDuiZhang());
        row1.add(new Road());
        row1.add(new Wall());
        row1.add(new Wall());
        floor7.add(row1);

        List<CaseBean> row2 = new ArrayList<>();
        row2.add(new Wall());
        row2.add(new Road());
        row2.add(new HongBianFu());
        row2.add(new BlueGem());
        row2.add(new Wall());
        row2.add(new BaiYiWuShi());
        row2.add(new Wall());
        row2.add(new RedGem());
        row2.add(new KuLouDuiZhang());
        row2.add(new Road());
        row2.add(new Wall());
        floor7.add(row2);

        List<CaseBean> row3 = new ArrayList<>();
        row3.add(new Road());
        row3.add(new Road());
        row3.add(new Wall());
        row3.add(new Wall());
        row3.add(new Wall());
        row3.add(new IronGateCanNotOpen());
        row3.add(new Wall());
        row3.add(new Wall());
        row3.add(new Wall());
        row3.add(new Road());
        row3.add(new Road());
        floor7.add(row3);

        List<CaseBean> row4 = new ArrayList<>();
        row4.add(new Road());
        row4.add(new Road());
        row4.add(new BlueGate());
        row4.add(new BaiYiWuShi());
        row4.add(new IronGateCanOpen());
        row4.add(new StarCross());
        row4.add(new IronGateCanNotOpen());
        row4.add(new BaiYiWuShi());
        row4.add(new BlueGate());
        row4.add(new Road());
        row4.add(new Road());
        floor7.add(row4);

        List<CaseBean> row5 = new ArrayList<>();
        row5.add(new Road());
        row5.add(new Wall());
        row5.add(new Wall());
        row5.add(new Wall());
        row5.add(new Wall());
        row5.add(new IronGateCanNotOpen());
        row5.add(new Wall());
        row5.add(new Wall());
        row5.add(new Wall());
        row5.add(new Wall());
        row5.add(new Road());
        floor7.add(row5);

        List<CaseBean> row6 = new ArrayList<>();
        row6.add(new Road());
        row6.add(new Wall());
        row6.add(new SmallBloodBottle());
        row6.add(new RedGem());
        row6.add(new Wall());
        row6.add(new BaiYiWuShi());
        row6.add(new Wall());
        row6.add(new BlueGem());
        row6.add(new SmallBloodBottle());
        row6.add(new Wall());
        row6.add(new Road());
        floor7.add(row6);

        List<CaseBean> row7 = new ArrayList<>();
        row7.add(new Road());
        row7.add(new Wall());
        row7.add(new YellowKey());
        row7.add(new SmallBloodBottle());
        row7.add(new Wall());
        row7.add(new BlueGate());
        row7.add(new Wall());
        row7.add(new SmallBloodBottle());
        row7.add(new YellowKey());
        row7.add(new Wall());
        row7.add(new Road());
        floor7.add(row7);

        List<CaseBean> row8 = new ArrayList<>();
        row8.add(new Road());
        row8.add(new Wall());
        row8.add(new Wall());
        row8.add(new BlueKey());
        row8.add(new BlueKey());
        row8.add(new BigBloodBottle());
        row8.add(new BlueKey());
        row8.add(new BlueKey());
        row8.add(new Wall());
        row8.add(new Wall());
        row8.add(new Road());
        floor7.add(row8);

        List<CaseBean> row9 = new ArrayList<>();
        row9.add(new Road());
        row9.add(new Road());
        row9.add(new Wall());
        row9.add(new Wall());
        row9.add(new Wall());
        row9.add(new RedGate());
        row9.add(new Wall());
        row9.add(new Wall());
        row9.add(new Wall());
        row9.add(new Road());
        row9.add(new Road());
        floor7.add(row9);

        List<CaseBean> row10 = new ArrayList<>();
        row10.add(new Wall());
        row10.add(new Road());
        row10.add(new Road());
        row10.add(new YellowGate());
        row10.add(new GoDownstairs());
        row10.add(new Road());
        row10.add(new Road());
        row10.add(new YellowGate());
        row10.add(new Road());
        row10.add(new Road());
        row10.add(new Wall());
        floor7.add(row10);

        return floor7;
    }

    @Override
    public void fromUpstairsToThisFloor() {
        WarriorBean warriorBean = MagicGameManager.SINGLETON.getWarriorBean();
        warriorBean.setPosition(new Position(0, 1));
        MagicGameManager.SINGLETON.setCase(warriorBean.getPosition(), warriorBean);
    }

    @Override
    public void fromDownstairsToThisFloor() {
        WarriorBean warriorBean = MagicGameManager.SINGLETON.getWarriorBean();
        warriorBean.setPosition(new Position(10, 5));
        MagicGameManager.SINGLETON.setCase(warriorBean.getPosition(), warriorBean);
    }
}
