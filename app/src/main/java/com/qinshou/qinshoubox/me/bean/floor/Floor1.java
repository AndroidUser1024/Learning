package com.qinshou.qinshoubox.me.bean.floor;


import com.qinshou.qinshoubox.me.bean.CaseBean;
import com.qinshou.qinshoubox.me.bean.Position;
import com.qinshou.qinshoubox.me.bean.building.Road;
import com.qinshou.qinshoubox.me.bean.building.Wall;
import com.qinshou.qinshoubox.me.bean.monster.ChuJiFaShi;
import com.qinshou.qinshoubox.me.bean.monster.HongTouGuai;
import com.qinshou.qinshoubox.me.bean.monster.KuLouRen;
import com.qinshou.qinshoubox.me.bean.monster.KuLouShiBing;
import com.qinshou.qinshoubox.me.bean.monster.LvTouGuai;
import com.qinshou.qinshoubox.me.bean.monster.QingTouGuai;
import com.qinshou.qinshoubox.me.bean.monster.ShouMianRen;
import com.qinshou.qinshoubox.me.bean.monster.XiaoBianFu;
import com.qinshou.qinshoubox.me.bean.npc.RedGate;
import com.qinshou.qinshoubox.me.bean.npc.YellowGate;
import com.qinshou.qinshoubox.me.bean.npc.GoDownstairs;
import com.qinshou.qinshoubox.me.bean.npc.GoUpstairs;
import com.qinshou.qinshoubox.me.bean.prop.BigBloodBottle;
import com.qinshou.qinshoubox.me.bean.prop.SmallBloodBottle;
import com.qinshou.qinshoubox.me.bean.prop.BlueGem;
import com.qinshou.qinshoubox.me.bean.prop.RedGem;
import com.qinshou.qinshoubox.me.bean.prop.BlueKey;
import com.qinshou.qinshoubox.me.bean.prop.RedKey;
import com.qinshou.qinshoubox.me.bean.prop.YellowKey;
import com.qinshou.qinshoubox.me.bean.prop.HolyLightBadge;
import com.qinshou.qinshoubox.me.bean.warrior.WarriorBean;
import com.qinshou.qinshoubox.util.MagicGameManager;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:第 1 层
 * Created by 禽兽先生
 * Created on 2017/4/26
 */

public class Floor1 extends AbsFloor {

    @Override
    public int getFloor() {
        return 1;
    }

    @Override
    public List<List<CaseBean>> setData() {
        List<List<CaseBean>> floor1 = new ArrayList<>();
        List<CaseBean> row0 = new ArrayList<>();
        row0.add(new GoUpstairs());
        row0.add(new Road());
        row0.add(new YellowKey());
        row0.add(new LvTouGuai());
        row0.add(new HongTouGuai());
        row0.add(new LvTouGuai());
        row0.add(new Road());
        row0.add(new Road());
        row0.add(new Road());
        row0.add(new Road());
        row0.add(new Road());
        floor1.add(row0);

        List<CaseBean> row1 = new ArrayList<>();
        row1.add(new Wall());
        row1.add(new Wall());
        row1.add(new Wall());
        row1.add(new Wall());
        row1.add(new Wall());
        row1.add(new Wall());
        row1.add(new Wall());
        row1.add(new Wall());
        row1.add(new Wall());
        row1.add(new Wall());
        row1.add(new Road());
        floor1.add(row1);

        List<CaseBean> row2 = new ArrayList<>();
        row2.add(new SmallBloodBottle());
        row2.add(new Road());
        row2.add(new KuLouRen());
        row2.add(new YellowGate());
        row2.add(new Road());
        row2.add(new Wall());
        row2.add(new SmallBloodBottle());
        row2.add(new YellowKey());
        row2.add(new SmallBloodBottle());
        row2.add(new Wall());
        row2.add(new Road());
        floor1.add(row2);

        List<CaseBean> row3 = new ArrayList<>();
        row3.add(new YellowKey());
        row3.add(new KuLouRen());
        row3.add(new RedGem());
        row3.add(new Wall());
        row3.add(new Road());
        row3.add(new Wall());
        row3.add(new SmallBloodBottle());
        row3.add(new YellowKey());
        row3.add(new SmallBloodBottle());
        row3.add(new Wall());
        row3.add(new Road());
        floor1.add(row3);

        List<CaseBean> row4 = new ArrayList<>();
        row4.add(new Wall());
        row4.add(new YellowGate());
        row4.add(new Wall());
        row4.add(new Wall());
        row4.add(new Road());
        row4.add(new Wall());
        row4.add(new Wall());
        row4.add(new Wall());
        row4.add(new QingTouGuai());
        row4.add(new Wall());
        row4.add(new Road());
        floor1.add(row4);

        List<CaseBean> row5 = new ArrayList<>();
        row5.add(new YellowKey());
        row5.add(new KuLouShiBing());
        row5.add(new Road());
        row5.add(new Wall());
        row5.add(new Road());
        row5.add(new YellowGate());
        row5.add(new ChuJiFaShi());
        row5.add(new LvTouGuai());
        row5.add(new XiaoBianFu());
        row5.add(new Wall());
        row5.add(new Road());
        floor1.add(row5);

        List<CaseBean> row6 = new ArrayList<>();
        row6.add(new BlueGem());
        row6.add(new Road());
        row6.add(new BlueKey());
        row6.add(new Wall());
        row6.add(new Road());
        row6.add(new Wall());
        row6.add(new Wall());
        row6.add(new Wall());
        row6.add(new Wall());
        row6.add(new Wall());
        row6.add(new Road());
        floor1.add(row6);

        List<CaseBean> row7 = new ArrayList<>();
        row7.add(new Wall());
        row7.add(new YellowGate());
        row7.add(new Wall());
        row7.add(new Wall());
        row7.add(new Road());
        row7.add(new Road());
        row7.add(new Road());
        row7.add(new Road());
        row7.add(new Road());
        row7.add(new Road());
        row7.add(new Road());
        floor1.add(row7);

        List<CaseBean> row8 = new ArrayList<>();
        row8.add(new Road());
        row8.add(new KuLouShiBing());
        row8.add(new Road());
        row8.add(new Wall());
        row8.add(new Wall());
        row8.add(new RedGate());
        row8.add(new Wall());
        row8.add(new Wall());
        row8.add(new Wall());
        row8.add(new YellowGate());
        row8.add(new Wall());
        floor1.add(row8);

        List<CaseBean> row9 = new ArrayList<>();
        row9.add(new SmallBloodBottle());
        row9.add(new BigBloodBottle());
        row9.add(new YellowKey());
        row9.add(new Wall());
        row9.add(new RedKey());
        row9.add(new Road());
        row9.add(new Road());
        row9.add(new Wall());
        row9.add(new YellowKey());
        row9.add(new ShouMianRen());
        row9.add(new BlueKey());
        floor1.add(row9);

        List<CaseBean> row10 = new ArrayList<>();
        row10.add(new SmallBloodBottle());
        row10.add(new HolyLightBadge());
        row10.add(new YellowKey());
        row10.add(new Wall());
        row10.add(new Road());
        row10.add(new GoDownstairs());
        row10.add(new Road());
        row10.add(new Wall());
        row10.add(new YellowKey());
        row10.add(new YellowKey());
        row10.add(new YellowKey());
        floor1.add(row10);

        return floor1;
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
        warriorBean.setPosition(new Position(9, 5));
        MagicGameManager.SINGLETON.setCase(warriorBean.getPosition(), warriorBean);
    }
}
