package com.qinshou.qinshoubox.me.bean.floor;


import com.qinshou.qinshoubox.R;
import com.qinshou.qinshoubox.me.bean.CaseBean;
import com.qinshou.qinshoubox.me.bean.Position;
import com.qinshou.qinshoubox.me.bean.building.Road;
import com.qinshou.qinshoubox.me.bean.building.StarrySky;
import com.qinshou.qinshoubox.me.bean.monster.BaiYiWuShi;
import com.qinshou.qinshoubox.me.bean.monster.LingWuShi;
import com.qinshou.qinshoubox.me.bean.monster.LingWuShi2;
import com.qinshou.qinshoubox.me.bean.monster.MingDuiZhang2;
import com.qinshou.qinshoubox.me.bean.monster.YingZiZhanShi;
import com.qinshou.qinshoubox.me.bean.npc.GoDownstairs;
import com.qinshou.qinshoubox.me.bean.npc.GoUpstairs;
import com.qinshou.qinshoubox.me.bean.prop.BigBloodBottle;
import com.qinshou.qinshoubox.me.bean.prop.BlueGem;
import com.qinshou.qinshoubox.me.bean.prop.BlueKey;
import com.qinshou.qinshoubox.me.bean.prop.RedGem;
import com.qinshou.qinshoubox.me.bean.prop.RedKey;
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
 * Description:第 20 层
 * Created by 禽兽先生
 * Created on 2018/4/27
 */

public class Floor20 extends AbsFloor {

    @Override
    public int getFloor() {
        return 20;
    }

    @Override
    public List<List<CaseBean>> setData() {
        List<List<CaseBean>> floor20 = new ArrayList<>();
        List<CaseBean> row0 = new ArrayList<>();
        row0.add(new YingZiZhanShi());
        row0.add(new RedGem());
        row0.add(new BaiYiWuShi());
        row0.add(new SmallBloodBottle());
        row0.add(new MingDuiZhang2());
        row0.add(new RedKey());
        row0.add(new MingDuiZhang2());
        row0.add(new SmallBloodBottle());
        row0.add(new BaiYiWuShi());
        row0.add(new RedGem());
        row0.add(new YingZiZhanShi());
        floor20.add(row0);

        List<CaseBean> row1 = new ArrayList<>();
        row1.add(new BigBloodBottle());
        row1.add(new StarrySky());
        row1.add(new YellowKey());
        row1.add(new StarrySky());
        row1.add(new BlueKey());
        row1.add(new StarrySky());
        row1.add(new BlueKey());
        row1.add(new StarrySky());
        row1.add(new YellowKey());
        row1.add(new StarrySky());
        row1.add(new BigBloodBottle());
        floor20.add(row1);

        List<CaseBean> row2 = new ArrayList<>();
        row2.add(new StarrySky());
        row2.add(new BlueGem());
        row2.add(new BaiYiWuShi());
        row2.add(new Road());
        row2.add(new LingWuShi2());
        row2.add(new Road());
        row2.add(new LingWuShi2());
        row2.add(new Road());
        row2.add(new BaiYiWuShi());
        row2.add(new BlueGem());
        row2.add(new StarrySky());
        floor20.add(row2);

        List<CaseBean> row3 = new ArrayList<>();
        row3.add(new SmallBloodBottle());
        row3.add(new StarrySky());
        row3.add(new YellowKey());
        row3.add(new StarrySky());
        row3.add(new Road());
        row3.add(new GoDownstairs());
        row3.add(new Road());
        row3.add(new StarrySky());
        row3.add(new YellowKey());
        row3.add(new StarrySky());
        row3.add(new SmallBloodBottle());
        floor20.add(row3);

        List<CaseBean> row4 = new ArrayList<>();
        row4.add(new MingDuiZhang2());
        row4.add(new BlueKey());
        row4.add(new LingWuShi2());
        row4.add(new Road());
        row4.add(new Road());
        row4.add(new Road());
        row4.add(new Road());
        row4.add(new Road());
        row4.add(new LingWuShi2());
        row4.add(new BlueKey());
        row4.add(new MingDuiZhang2());
        floor20.add(row4);

        List<CaseBean> row5 = new ArrayList<>();
        row5.add(new RedKey());
        row5.add(new StarrySky());
        row5.add(new Road());
        row5.add(new StarrySky());
        row5.add(new Road());
        row5.add(new StarrySky());
        row5.add(new Road());
        row5.add(new StarrySky());
        row5.add(new Road());
        row5.add(new StarrySky());
        row5.add(new RedKey());
        floor20.add(row5);

        List<CaseBean> row6 = new ArrayList<>();
        row6.add(new MingDuiZhang2());
        row6.add(new BlueKey());
        row6.add(new LingWuShi2());
        row6.add(new Road());
        row6.add(new Road());
        row6.add(new Road());
        row6.add(new Road());
        row6.add(new Road());
        row6.add(new LingWuShi2());
        row6.add(new BlueKey());
        row6.add(new MingDuiZhang2());
        floor20.add(row6);

        List<CaseBean> row7 = new ArrayList<>();
        row7.add(new SmallBloodBottle());
        row7.add(new StarrySky());
        row7.add(new YellowKey());
        row7.add(new StarrySky());
        row7.add(new Road());
        row7.add(new GoUpstairs());
        row7.add(new Road());
        row7.add(new StarrySky());
        row7.add(new YellowKey());
        row7.add(new StarrySky());
        row7.add(new SmallBloodBottle());
        floor20.add(row7);

        List<CaseBean> row8 = new ArrayList<>();
        row8.add(new StarrySky());
        row8.add(new BlueGem());
        row8.add(new BaiYiWuShi());
        row8.add(new Road());
        row8.add(new LingWuShi2());
        row8.add(new Road());
        row8.add(new LingWuShi2());
        row8.add(new Road());
        row8.add(new BaiYiWuShi());
        row8.add(new BlueGem());
        row8.add(new StarrySky());
        floor20.add(row8);

        List<CaseBean> row9 = new ArrayList<>();
        row9.add(new BigBloodBottle());
        row9.add(new StarrySky());
        row9.add(new YellowKey());
        row9.add(new StarrySky());
        row9.add(new BlueKey());
        row9.add(new StarrySky());
        row9.add(new BlueKey());
        row9.add(new StarrySky());
        row9.add(new YellowKey());
        row9.add(new StarrySky());
        row9.add(new BigBloodBottle());
        floor20.add(row9);

        List<CaseBean> row10 = new ArrayList<>();
        row10.add(new YingZiZhanShi());
        row10.add(new RedGem());
        row10.add(new BaiYiWuShi());
        row10.add(new SmallBloodBottle());
        row10.add(new MingDuiZhang2());
        row10.add(new RedKey());
        row10.add(new MingDuiZhang2());
        row10.add(new SmallBloodBottle());
        row10.add(new BaiYiWuShi());
        row10.add(new RedGem());
        row10.add(new YingZiZhanShi());
        floor20.add(row10);

        return floor20;
    }

    @Override
    public void fromUpstairsToThisFloor() {
//        resetWarriorPosition( 0);
    }

    @Override
    public void fromDownstairsToThisFloor() {
        WarriorBean warriorBean = MagicGameManager.SINGLETON.getWarriorBean();
        warriorBean.setPosition(new Position(4, 5));
        MagicGameManager.SINGLETON.setCase(warriorBean.getPosition(), warriorBean);
    }
}
