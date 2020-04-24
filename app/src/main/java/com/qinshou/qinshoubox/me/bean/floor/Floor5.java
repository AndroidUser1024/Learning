package com.qinshou.qinshoubox.me.bean.floor;


import com.qinshou.qinshoubox.R;
import com.qinshou.qinshoubox.me.bean.CaseBean;
import com.qinshou.qinshoubox.me.bean.Position;
import com.qinshou.qinshoubox.me.bean.building.Road;
import com.qinshou.qinshoubox.me.bean.building.Wall;
import com.qinshou.qinshoubox.me.bean.monster.ChuJiFaShi;
import com.qinshou.qinshoubox.me.bean.monster.ChuJiWeiBing;
import com.qinshou.qinshoubox.me.bean.monster.DaBianFu;
import com.qinshou.qinshoubox.me.bean.monster.IMonster;
import com.qinshou.qinshoubox.me.bean.monster.KuLouRen;
import com.qinshou.qinshoubox.me.bean.monster.KuLouShiBing;
import com.qinshou.qinshoubox.me.bean.monster.QingTouGuai;
import com.qinshou.qinshoubox.me.bean.monster.ShouMianRen;
import com.qinshou.qinshoubox.me.bean.monster.XiaoBianFu;
import com.qinshou.qinshoubox.me.bean.npc.BlueGate;
import com.qinshou.qinshoubox.me.bean.npc.BusinessManFloor5;
import com.qinshou.qinshoubox.me.bean.npc.GoDownstairs;
import com.qinshou.qinshoubox.me.bean.npc.GoUpstairs;
import com.qinshou.qinshoubox.me.bean.npc.MysteriousOldManFloor5;
import com.qinshou.qinshoubox.me.bean.npc.YellowGate;
import com.qinshou.qinshoubox.me.bean.prop.BigBloodBottle;
import com.qinshou.qinshoubox.me.bean.prop.BlueGem;
import com.qinshou.qinshoubox.me.bean.prop.BlueKey;
import com.qinshou.qinshoubox.me.bean.prop.IProp;
import com.qinshou.qinshoubox.me.bean.prop.IronShield;
import com.qinshou.qinshoubox.me.bean.prop.KeyBox;
import com.qinshou.qinshoubox.me.bean.prop.RedGem;
import com.qinshou.qinshoubox.me.bean.prop.SmallBloodBottle;
import com.qinshou.qinshoubox.me.bean.prop.YellowKey;
import com.qinshou.qinshoubox.me.enums.Npc;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:第 5 层
 * Created by 禽兽先生
 * Created on 2017/4/26
 */

public class Floor5 extends AbsFloor {

    @Override
    public int getFloor() {
        return 5;
    }

    @Override
    public List<List<CaseBean>> setData() {
        List<List<CaseBean>> floor5 = new ArrayList<>();
        List<CaseBean> row0 = new ArrayList<>();
        row0.add(new KeyBox());
        row0.add(new Wall());
        row0.add(new SmallBloodBottle());
        row0.add(new Wall());
        row0.add(new BigBloodBottle());
        row0.add(new ChuJiFaShi());
        row0.add(new Road());
        row0.add(new Road());
        row0.add(new ChuJiFaShi());
        row0.add(new YellowKey());
        row0.add(new BlueKey());
        floor5.add(row0);

        List<CaseBean> row1 = new ArrayList<>();
        row1.add(new Road());
        row1.add(new Wall());
        row1.add(new RedGem());
        row1.add(new Wall());
        row1.add(new ChuJiFaShi());
        row1.add(new Road());
        row1.add(new Road());
        row1.add(new Road());
        row1.add(new Road());
        row1.add(new ChuJiFaShi());
        row1.add(new YellowKey());
        floor5.add(row1);

        List<CaseBean> row2 = new ArrayList<>();
        row2.add(new DaBianFu());
        row2.add(new Wall());
        row2.add(new Road());
        row2.add(new Wall());
        row2.add(new KuLouShiBing());
        row2.add(new Road());
        row2.add(new Wall());
        row2.add(new Wall());
        row2.add(new YellowGate());
        row2.add(new Wall());
        row2.add(new Wall());
        floor5.add(row2);

        List<CaseBean> row3 = new ArrayList<>();
        row3.add(new Road());
        row3.add(new YellowGate());
        row3.add(new ChuJiFaShi());
        row3.add(new Wall());
        row3.add(new IronShield());
        row3.add(new KuLouShiBing());
        row3.add(new Wall());
        row3.add(new Road());
        row3.add(new ShouMianRen());
        row3.add(new KuLouShiBing());
        row3.add(new BusinessManFloor5());
        floor5.add(row3);

        List<CaseBean> row4 = new ArrayList<>();
        row4.add(new DaBianFu());
        row4.add(new Wall());
        row4.add(new Road());
        row4.add(new Wall());
        row4.add(new Wall());
        row4.add(new Wall());
        row4.add(new Wall());
        row4.add(new Road());
        row4.add(new Road());
        row4.add(new Road());
        row4.add(new KuLouShiBing());
        floor5.add(row4);

        List<CaseBean> row5 = new ArrayList<>();
        row5.add(new RedGem());
        row5.add(new Wall());
        row5.add(new Road());
        row5.add(new Road());
        row5.add(new Road());
        row5.add(new XiaoBianFu());
        row5.add(new KuLouRen());
        row5.add(new Road());
        row5.add(new Road());
        row5.add(new Road());
        row5.add(new Road());
        floor5.add(row5);

        List<CaseBean> row6 = new ArrayList<>();
        row6.add(new BlueGem());
        row6.add(new Wall());
        row6.add(new Wall());
        row6.add(new QingTouGuai());
        row6.add(new Wall());
        row6.add(new Wall());
        row6.add(new Wall());
        row6.add(new Wall());
        row6.add(new Road());
        row6.add(new Road());
        row6.add(new Road());
        floor5.add(row6);

        List<CaseBean> row7 = new ArrayList<>();
        row7.add(new Road());
        row7.add(new MysteriousOldManFloor5());
        row7.add(new Wall());
        row7.add(new QingTouGuai());
        row7.add(new Wall());
        row7.add(new Road());
        row7.add(new Road());
        row7.add(new Road());
        row7.add(new ShouMianRen());
        row7.add(new ChuJiWeiBing());
        row7.add(new Road());
        floor5.add(row7);

        List<CaseBean> row8 = new ArrayList<>();
        row8.add(new Wall());
        row8.add(new Wall());
        row8.add(new Wall());
        row8.add(new XiaoBianFu());
        row8.add(new Wall());
        row8.add(new YellowGate());
        row8.add(new Wall());
        row8.add(new BlueGate());
        row8.add(new Wall());
        row8.add(new YellowGate());
        row8.add(new Wall());
        floor5.add(row8);

        List<CaseBean> row9 = new ArrayList<>();
        row9.add(new Road());
        row9.add(new Road());
        row9.add(new Wall());
        row9.add(new Road());
        row9.add(new Wall());
        row9.add(new XiaoBianFu());
        row9.add(new Wall());
        row9.add(new BlueGem());
        row9.add(new YellowGate());
        row9.add(new Road());
        row9.add(new Wall());
        floor5.add(row9);

        List<CaseBean> row10 = new ArrayList<>();
        row10.add(new GoDownstairs());
        row10.add(new Road());
        row10.add(new XiaoBianFu());
        row10.add(new Road());
        row10.add(new Road());
        row10.add(new Road());
        row10.add(new Wall());
        row10.add(new YellowKey());
        row10.add(new Wall());
        row10.add(new GoUpstairs());
        row10.add(new Wall());
        floor5.add(row10);

        return floor5;
    }

    @Override
    public void fromUpstairsToThisFloor() {
        resetWarriorPosition(new Position(9, 9));
    }

    @Override
    public void fromDownstairsToThisFloor() {
        resetWarriorPosition(new Position(9, 0));
    }
}
