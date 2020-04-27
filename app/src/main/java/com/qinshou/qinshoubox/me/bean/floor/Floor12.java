package com.qinshou.qinshoubox.me.bean.floor;


import com.qinshou.qinshoubox.me.bean.CaseBean;
import com.qinshou.qinshoubox.me.bean.Position;
import com.qinshou.qinshoubox.me.bean.building.Road;
import com.qinshou.qinshoubox.me.bean.building.Wall;
import com.qinshou.qinshoubox.me.bean.monster.GaoJiWeiBing;
import com.qinshou.qinshoubox.me.bean.monster.JinDuiZhang;
import com.qinshou.qinshoubox.me.bean.monster.JinWeiShi;
import com.qinshou.qinshoubox.me.bean.monster.LingFaShi;
import com.qinshou.qinshoubox.me.bean.monster.LingWuShi;
import com.qinshou.qinshoubox.me.bean.monster.MingWeiBing;
import com.qinshou.qinshoubox.me.bean.monster.MingZhanShi;
import com.qinshou.qinshoubox.me.bean.npc.BlueGate;
import com.qinshou.qinshoubox.me.bean.npc.BusinessManFloor12;
import com.qinshou.qinshoubox.me.bean.npc.GoDownstairs;
import com.qinshou.qinshoubox.me.bean.npc.GoUpstairs;
import com.qinshou.qinshoubox.me.bean.npc.YellowGate;
import com.qinshou.qinshoubox.me.bean.prop.BigBloodBottle;
import com.qinshou.qinshoubox.me.bean.prop.BlueGem;
import com.qinshou.qinshoubox.me.bean.prop.RedGem;
import com.qinshou.qinshoubox.me.bean.prop.SmallBloodBottle;
import com.qinshou.qinshoubox.me.bean.prop.StarLightGodHammer;
import com.qinshou.qinshoubox.me.bean.prop.YellowKey;
import com.qinshou.qinshoubox.me.bean.warrior.WarriorBean;
import com.qinshou.qinshoubox.util.MagicGameManager;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:第 12 层
 * Created by 禽兽先生
 * Created on 2017/4/27
 */

public class Floor12 extends AbsFloor {

    @Override
    public int getFloor() {
        return 12;
    }

    @Override
    public List<List<CaseBean>> setData() {
        List<List<CaseBean>> floor12 = new ArrayList<>();
        List<CaseBean> row0 = new ArrayList<>();
        row0.add(new BusinessManFloor12());
        row0.add(new BlueGem());
        row0.add(new Wall());
        row0.add(new Road());
        row0.add(new JinWeiShi());
        row0.add(new JinDuiZhang());
        row0.add(new JinWeiShi());
        row0.add(new Road());
        row0.add(new Wall());
        row0.add(new BigBloodBottle());
        row0.add(new StarLightGodHammer());
        floor12.add(row0);

        List<CaseBean> row1 = new ArrayList<>();
        row1.add(new RedGem());
        row1.add(new Road());
        row1.add(new Wall());
        row1.add(new Road());
        row1.add(new Wall());
        row1.add(new YellowGate());
        row1.add(new Wall());
        row1.add(new Road());
        row1.add(new Wall());
        row1.add(new Road());
        row1.add(new BigBloodBottle());
        floor12.add(row1);

        List<CaseBean> row2 = new ArrayList<>();
        row2.add(new Road());
        row2.add(new Road());
        row2.add(new Wall());
        row2.add(new Road());
        row2.add(new Wall());
        row2.add(new JinDuiZhang());
        row2.add(new Wall());
        row2.add(new Road());
        row2.add(new Wall());
        row2.add(new Road());
        row2.add(new Road());
        floor12.add(row2);

        List<CaseBean> row3 = new ArrayList<>();
        row3.add(new Road());
        row3.add(new GaoJiWeiBing());
        row3.add(new Wall());
        row3.add(new Road());
        row3.add(new Wall());
        row3.add(new YellowKey());
        row3.add(new Wall());
        row3.add(new Road());
        row3.add(new Wall());
        row3.add(new LingWuShi());
        row3.add(new Road());
        floor12.add(row3);

        List<CaseBean> row4 = new ArrayList<>();
        row4.add(new GaoJiWeiBing());
        row4.add(new MingZhanShi());
        row4.add(new Wall());
        row4.add(new Road());
        row4.add(new Wall());
        row4.add(new YellowKey());
        row4.add(new Wall());
        row4.add(new Road());
        row4.add(new Wall());
        row4.add(new LingFaShi());
        row4.add(new LingWuShi());
        floor12.add(row4);

        List<CaseBean> row5 = new ArrayList<>();
        row5.add(new Wall());
        row5.add(new BlueGate());
        row5.add(new Wall());
        row5.add(new Road());
        row5.add(new Wall());
        row5.add(new SmallBloodBottle());
        row5.add(new Wall());
        row5.add(new Road());
        row5.add(new Wall());
        row5.add(new BlueGate());
        row5.add(new Wall());
        floor12.add(row5);

        List<CaseBean> row6 = new ArrayList<>();
        row6.add(new Road());
        row6.add(new Road());
        row6.add(new Road());
        row6.add(new Road());
        row6.add(new Wall());
        row6.add(new SmallBloodBottle());
        row6.add(new Wall());
        row6.add(new Road());
        row6.add(new Road());
        row6.add(new Road());
        row6.add(new Road());
        floor12.add(row6);

        List<CaseBean> row7 = new ArrayList<>();
        row7.add(new Wall());
        row7.add(new Wall());
        row7.add(new Wall());
        row7.add(new Road());
        row7.add(new Wall());
        row7.add(new Wall());
        row7.add(new Wall());
        row7.add(new Road());
        row7.add(new Wall());
        row7.add(new Wall());
        row7.add(new Wall());
        floor12.add(row7);

        List<CaseBean> row8 = new ArrayList<>();
        row8.add(new BlueGem());
        row8.add(new GaoJiWeiBing());
        row8.add(new YellowGate());
        row8.add(new MingWeiBing());
        row8.add(new MingWeiBing());
        row8.add(new GaoJiWeiBing());
        row8.add(new MingWeiBing());
        row8.add(new MingWeiBing());
        row8.add(new YellowGate());
        row8.add(new GaoJiWeiBing());
        row8.add(new RedGem());
        floor12.add(row8);

        List<CaseBean> row9 = new ArrayList<>();
        row9.add(new Wall());
        row9.add(new Wall());
        row9.add(new Wall());
        row9.add(new Wall());
        row9.add(new Wall());
        row9.add(new BlueGate());
        row9.add(new Wall());
        row9.add(new Wall());
        row9.add(new Wall());
        row9.add(new Wall());
        row9.add(new Wall());
        floor12.add(row9);

        List<CaseBean> row10 = new ArrayList<>();
        row10.add(new GoUpstairs());
        row10.add(new Road());
        row10.add(new Road());
        row10.add(new Road());
        row10.add(new Road());
        row10.add(new Road());
        row10.add(new Road());
        row10.add(new Road());
        row10.add(new Road());
        row10.add(new Road());
        row10.add(new GoDownstairs());
        floor12.add(row10);

        return floor12;
    }

    @Override
    public void fromUpstairsToThisFloor() {
        WarriorBean warriorBean = MagicGameManager.SINGLETON.getWarriorBean();
        warriorBean.setPosition(new Position(10, 1));
        MagicGameManager.SINGLETON.setCase(warriorBean.getPosition(), warriorBean);
    }

    @Override
    public void fromDownstairsToThisFloor() {
        WarriorBean warriorBean = MagicGameManager.SINGLETON.getWarriorBean();
        warriorBean.setPosition(new Position(10, 9));
        MagicGameManager.SINGLETON.setCase(warriorBean.getPosition(), warriorBean);
    }
}
