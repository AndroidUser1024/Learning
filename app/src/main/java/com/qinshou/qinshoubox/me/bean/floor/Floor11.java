package com.qinshou.qinshoubox.me.bean.floor;


import com.qinshou.qinshoubox.me.bean.CaseBean;
import com.qinshou.qinshoubox.me.bean.Position;
import com.qinshou.qinshoubox.me.bean.building.Road;
import com.qinshou.qinshoubox.me.bean.building.Wall;
import com.qinshou.qinshoubox.me.bean.monster.GaoJiWeiBing;
import com.qinshou.qinshoubox.me.bean.monster.MingWeiBing;
import com.qinshou.qinshoubox.me.bean.monster.ShouMianWuShi;
import com.qinshou.qinshoubox.me.bean.npc.BigStore1;
import com.qinshou.qinshoubox.me.bean.npc.BigStore2;
import com.qinshou.qinshoubox.me.bean.npc.BigStore3;
import com.qinshou.qinshoubox.me.bean.npc.BlueGate;
import com.qinshou.qinshoubox.me.bean.npc.GoDownstairs;
import com.qinshou.qinshoubox.me.bean.npc.GoUpstairs;
import com.qinshou.qinshoubox.me.bean.npc.RedGate;
import com.qinshou.qinshoubox.me.bean.npc.YellowGate;
import com.qinshou.qinshoubox.me.bean.prop.BigBloodBottle;
import com.qinshou.qinshoubox.me.bean.prop.BlueGem;
import com.qinshou.qinshoubox.me.bean.prop.BlueKey;
import com.qinshou.qinshoubox.me.bean.prop.GoldShield;
import com.qinshou.qinshoubox.me.bean.prop.RedGem;
import com.qinshou.qinshoubox.me.bean.prop.RedKey;
import com.qinshou.qinshoubox.me.bean.prop.SmallBloodBottle;
import com.qinshou.qinshoubox.me.bean.prop.YellowKey;
import com.qinshou.qinshoubox.me.bean.warrior.WarriorBean;
import com.qinshou.qinshoubox.util.MagicGameManager;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:第 11 层
 * Created by 禽兽先生
 * Created on 2017/4/27
 */

public class Floor11 extends AbsFloor {

    @Override
    public int getFloor() {
        return 11;
    }

    @Override
    public List<List<CaseBean>> setData() {
        List<List<CaseBean>> floor11 = new ArrayList<>();
        List<CaseBean> row0 = new ArrayList<>();
        row0.add(new SmallBloodBottle());
        row0.add(new Wall());
        row0.add(new YellowKey());
        row0.add(new Wall());
        row0.add(new BlueKey());
        row0.add(new Wall());
        row0.add(new RedKey());
        row0.add(new Wall());
        row0.add(new BigBloodBottle());
        row0.add(new GoldShield());
        row0.add(new BigBloodBottle());
        floor11.add(row0);

        List<CaseBean> row1 = new ArrayList<>();
        row1.add(new SmallBloodBottle());
        row1.add(new Wall());
        row1.add(new YellowKey());
        row1.add(new Wall());
        row1.add(new BlueKey());
        row1.add(new Wall());
        row1.add(new RedKey());
        row1.add(new Wall());
        row1.add(new MingWeiBing());
        row1.add(new GaoJiWeiBing());
        row1.add(new MingWeiBing());
        floor11.add(row1);

        List<CaseBean> row2 = new ArrayList<>();
        row2.add(new SmallBloodBottle());
        row2.add(new Wall());
        row2.add(new YellowKey());
        row2.add(new Wall());
        row2.add(new BlueKey());
        row2.add(new Wall());
        row2.add(new RedKey());
        row2.add(new Wall());
        row2.add(new Road());
        row2.add(new MingWeiBing());
        row2.add(new Road());
        floor11.add(row2);

        List<CaseBean> row3 = new ArrayList<>();
        row3.add(new YellowGate());
        row3.add(new Wall());
        row3.add(new YellowGate());
        row3.add(new Wall());
        row3.add(new YellowGate());
        row3.add(new Wall());
        row3.add(new YellowGate());
        row3.add(new Wall());
        row3.add(new Wall());
        row3.add(new BlueGate());
        row3.add(new Wall());
        floor11.add(row3);

        List<CaseBean> row4 = new ArrayList<>();
        row4.add(new Road());
        row4.add(new Road());
        row4.add(new Road());
        row4.add(new Road());
        row4.add(new Road());
        row4.add(new Wall());
        row4.add(new Road());
        row4.add(new Road());
        row4.add(new Road());
        row4.add(new Road());
        row4.add(new Road());
        floor11.add(row4);

        List<CaseBean> row5 = new ArrayList<>();
        row5.add(new YellowGate());
        row5.add(new Wall());
        row5.add(new Wall());
        row5.add(new BlueGate());
        row5.add(new Wall());
        row5.add(new Wall());
        row5.add(new Wall());
        row5.add(new BlueGate());
        row5.add(new Wall());
        row5.add(new Wall());
        row5.add(new YellowGate());
        floor11.add(row5);

        List<CaseBean> row6 = new ArrayList<>();
        row6.add(new BlueGem());
        row6.add(new Wall());
        row6.add(new Road());
        row6.add(new MingWeiBing());
        row6.add(new BigBloodBottle());
        row6.add(new GaoJiWeiBing());
        row6.add(new BigBloodBottle());
        row6.add(new MingWeiBing());
        row6.add(new Road());
        row6.add(new Wall());
        row6.add(new RedGem());
        floor11.add(row6);

        List<CaseBean> row7 = new ArrayList<>();
        row7.add(new BlueGem());
        row7.add(new Wall());
        row7.add(new ShouMianWuShi());
        row7.add(new Wall());
        row7.add(new Wall());
        row7.add(new Wall());
        row7.add(new Wall());
        row7.add(new Wall());
        row7.add(new ShouMianWuShi());
        row7.add(new Wall());
        row7.add(new RedGem());
        floor11.add(row7);

        List<CaseBean> row8 = new ArrayList<>();
        row8.add(new BlueGem());
        row8.add(new Wall());
        row8.add(new ShouMianWuShi());
        row8.add(new Wall());
        row8.add(new BigStore1());
        row8.add(new BigStore2());
        row8.add(new BigStore3());
        row8.add(new Wall());
        row8.add(new ShouMianWuShi());
        row8.add(new Wall());
        row8.add(new RedGem());
        floor11.add(row8);

        List<CaseBean> row9 = new ArrayList<>();
        row9.add(new Wall());
        row9.add(new Wall());
        row9.add(new RedGate());
        row9.add(new Wall());
        row9.add(new SmallBloodBottle());
        row9.add(new Road());
        row9.add(new SmallBloodBottle());
        row9.add(new Wall());
        row9.add(new RedGate());
        row9.add(new Wall());
        row9.add(new Wall());
        floor11.add(row9);

        List<CaseBean> row10 = new ArrayList<>();
        row10.add(new GoDownstairs());
        row10.add(new Road());
        row10.add(new Road());
        row10.add(new Road());
        row10.add(new Road());
        row10.add(new Road());
        row10.add(new Road());
        row10.add(new Road());
        row10.add(new Road());
        row10.add(new Road());
        row10.add(new GoUpstairs());
        floor11.add(row10);

        return floor11;
    }

    @Override
    public void fromUpstairsToThisFloor() {
        WarriorBean warriorBean = MagicGameManager.SINGLETON.getWarriorBean();
        warriorBean.setPosition(new Position(10, 9));
        MagicGameManager.SINGLETON.setCase(warriorBean.getPosition(), warriorBean);
    }

    @Override
    public void fromDownstairsToThisFloor() {
        WarriorBean warriorBean = MagicGameManager.SINGLETON.getWarriorBean();
        warriorBean.setPosition(new Position(10, 1));
        MagicGameManager.SINGLETON.setCase(warriorBean.getPosition(), warriorBean);
    }
}
