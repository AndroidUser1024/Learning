package com.qinshou.qinshoubox.me.bean.floor;


import com.qinshou.qinshoubox.R;
import com.qinshou.qinshoubox.me.bean.CaseBean;
import com.qinshou.qinshoubox.me.bean.Position;
import com.qinshou.qinshoubox.me.bean.building.Road;
import com.qinshou.qinshoubox.me.bean.building.Wall;
import com.qinshou.qinshoubox.me.bean.monster.BaiYiWuShi;
import com.qinshou.qinshoubox.me.bean.monster.ChuJiFaShi;
import com.qinshou.qinshoubox.me.bean.monster.DaBianFu;
import com.qinshou.qinshoubox.me.bean.monster.GuaiWang;
import com.qinshou.qinshoubox.me.bean.monster.HongBianFu;
import com.qinshou.qinshoubox.me.bean.monster.IMonster;
import com.qinshou.qinshoubox.me.bean.monster.KuLouDuiZhang;
import com.qinshou.qinshoubox.me.bean.monster.MaYiFaShi;
import com.qinshou.qinshoubox.me.bean.monster.QingTouGuai;
import com.qinshou.qinshoubox.me.bean.npc.BlueGate;
import com.qinshou.qinshoubox.me.bean.npc.GoDownstairs;
import com.qinshou.qinshoubox.me.bean.npc.GoUpstairs;
import com.qinshou.qinshoubox.me.bean.npc.YellowGate;
import com.qinshou.qinshoubox.me.bean.prop.BlueGem;
import com.qinshou.qinshoubox.me.bean.prop.IProp;
import com.qinshou.qinshoubox.me.bean.prop.RedGem;
import com.qinshou.qinshoubox.me.bean.prop.SmallBloodBottle;
import com.qinshou.qinshoubox.me.bean.prop.YellowKey;
import com.qinshou.qinshoubox.me.bean.warrior.WarriorBean;
import com.qinshou.qinshoubox.me.enums.Building;
import com.qinshou.qinshoubox.me.enums.Monster;
import com.qinshou.qinshoubox.me.enums.Npc;
import com.qinshou.qinshoubox.me.enums.Prop;
import com.qinshou.qinshoubox.util.MagicGameManager;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:第 8 层
 * Created by 禽兽先生
 * Created on 2017/4/26
 */

public class Floor8 extends AbsFloor {

    @Override
    public int getFloor() {
        return 8;
    }

    @Override
    public List<List<CaseBean>> setData() {
        List<List<CaseBean>> floor8 = new ArrayList<>();
        List<CaseBean> row0 = new ArrayList<>();
        row0.add(new GoDownstairs());
        row0.add(new Wall());
        row0.add(new Road());
        row0.add(new Road());
        row0.add(new Road());
        row0.add(new Road());
        row0.add(new Wall());
        row0.add(new Road());
        row0.add(new YellowKey());
        row0.add(new KuLouDuiZhang());
        row0.add(new Road());
        floor8.add(row0);

        List<CaseBean> row1 = new ArrayList<>();
        row1.add(new Road());
        row1.add(new Wall());
        row1.add(new Road());
        row1.add(new Wall());
        row1.add(new Wall());
        row1.add(new YellowGate());
        row1.add(new Wall());
        row1.add(new YellowGate());
        row1.add(new Wall());
        row1.add(new Wall());
        row1.add(new Road());
        floor8.add(row1);

        List<CaseBean> row2 = new ArrayList<>();
        row2.add(new Road());
        row2.add(new Wall());
        row2.add(new Road());
        row2.add(new Wall());
        row2.add(new Road());
        row2.add(new Road());
        row2.add(new BlueGate());
        row2.add(new Road());
        row2.add(new Road());
        row2.add(new Wall());
        row2.add(new RedGem());
        floor8.add(row2);

        List<CaseBean> row3 = new ArrayList<>();
        row3.add(new Road());
        row3.add(new Wall());
        row3.add(new Road());
        row3.add(new Wall());
        row3.add(new MaYiFaShi());
        row3.add(new Wall());
        row3.add(new Wall());
        row3.add(new Wall());
        row3.add(new DaBianFu());
        row3.add(new Wall());
        row3.add(new QingTouGuai());
        floor8.add(row3);

        List<CaseBean> row4 = new ArrayList<>();
        row4.add(new DaBianFu());
        row4.add(new Wall());
        row4.add(new Road());
        row4.add(new Wall());
        row4.add(new SmallBloodBottle());
        row4.add(new Wall());
        row4.add(new GoUpstairs());
        row4.add(new Road());
        row4.add(new Road());
        row4.add(new Wall());
        row4.add(new QingTouGuai());
        floor8.add(row4);

        List<CaseBean> row5 = new ArrayList<>();
        row5.add(new HongBianFu());
        row5.add(new Wall());
        row5.add(new BlueGem());
        row5.add(new Wall());
        row5.add(new SmallBloodBottle());
        row5.add(new Wall());
        row5.add(new Wall());
        row5.add(new Wall());
        row5.add(new Wall());
        row5.add(new Wall());
        row5.add(new Road());
        floor8.add(row5);

        List<CaseBean> row6 = new ArrayList<>();
        row6.add(new DaBianFu());
        row6.add(new Wall());
        row6.add(new QingTouGuai());
        row6.add(new Wall());
        row6.add(new Road());
        row6.add(new Road());
        row6.add(new Road());
        row6.add(new Wall());
        row6.add(new Road());
        row6.add(new HongBianFu());
        row6.add(new Road());
        floor8.add(row6);

        List<CaseBean> row7 = new ArrayList<>();
        row7.add(new Road());
        row7.add(new Wall());
        row7.add(new QingTouGuai());
        row7.add(new Wall());
        row7.add(new Wall());
        row7.add(new Wall());
        row7.add(new ChuJiFaShi());
        row7.add(new Wall());
        row7.add(new YellowGate());
        row7.add(new Wall());
        row7.add(new Wall());
        floor8.add(row7);

        List<CaseBean> row8 = new ArrayList<>();
        row8.add(new Road());
        row8.add(new Wall());
        row8.add(new Road());
        row8.add(new KuLouDuiZhang());
        row8.add(new Road());
        row8.add(new Wall());
        row8.add(new KuLouDuiZhang());
        row8.add(new Wall());
        row8.add(new Road());
        row8.add(new Road());
        row8.add(new Road());
        floor8.add(row8);

        List<CaseBean> row9 = new ArrayList<>();
        row9.add(new Road());
        row9.add(new Wall());
        row9.add(new Wall());
        row9.add(new Wall());
        row9.add(new YellowGate());
        row9.add(new Wall());
        row9.add(new Road());
        row9.add(new Wall());
        row9.add(new Wall());
        row9.add(new Wall());
        row9.add(new Road());
        floor8.add(row9);

        List<CaseBean> row10 = new ArrayList<>();
        row10.add(new Road());
        row10.add(new Road());
        row10.add(new MaYiFaShi());
        row10.add(new Road());
        row10.add(new Road());
        row10.add(new Wall());
        row10.add(new Road());
        row10.add(new GuaiWang());
        row10.add(new BaiYiWuShi());
        row10.add(new GuaiWang());
        row10.add(new Road());
        floor8.add(row10);

        return floor8;
    }

    @Override
    public void fromUpstairsToThisFloor() {
        WarriorBean warriorBean = MagicGameManager.SINGLETON.getWarriorBean();
        warriorBean.setPosition(new Position(4, 7));
        MagicGameManager.SINGLETON.setCase(warriorBean.getPosition(), warriorBean);
    }

    @Override
    public void fromDownstairsToThisFloor() {
        WarriorBean warriorBean = MagicGameManager.SINGLETON.getWarriorBean();
        warriorBean.setPosition(new Position(1, 0));
        MagicGameManager.SINGLETON.setCase(warriorBean.getPosition(), warriorBean);
    }
}
