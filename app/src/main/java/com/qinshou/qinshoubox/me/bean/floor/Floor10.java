package com.qinshou.qinshoubox.me.bean.floor;


import com.qinshou.qinshoubox.R;
import com.qinshou.qinshoubox.me.bean.CaseBean;
import com.qinshou.qinshoubox.me.bean.Position;
import com.qinshou.qinshoubox.me.enums.Building;
import com.qinshou.qinshoubox.me.enums.Monster;
import com.qinshou.qinshoubox.me.enums.Npc;
import com.qinshou.qinshoubox.me.enums.Prop;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:第 10 层
 * Created by 禽兽先生
 * Created on 2017/4/26
 */

public class Floor10 extends AbsFloor {

    @Override
    public int getFloor() {
        return 10;
    }

    @Override
    public List<List<CaseBean>> setData() {
        List<List<CaseBean>> floor10 = new ArrayList<>();
//        List<CaseBean> row0 = new ArrayList<>();
//        row0.add(new Road());
//        row0.add(new Wall());
//        row0.add(new Wall());
//        row0.add(new BlueGem());
//        row0.add(new CaseBean(IMonster.SHOU_MIAN_WU_SHI, R.drawable.magic_tower_monster_shou_mian_wu_shi));
//        row0.add(new Wall());
//        row0.add(new CaseBean(IMonster.SHOU_MIAN_WU_SHI, R.drawable.magic_tower_monster_shou_mian_wu_shi));
//        row0.add(new RedGem());
//        row0.add(new Wall());
//        row0.add(new Wall());
//        row0.add(new Road());
//        floor10.add(row0);
//
//        List<CaseBean> row1 = new ArrayList<>();
//        row1.add(new Road());
//        row1.add(new Road());
//        row1.add(new Wall());
//        row1.add(new Wall());
//        row1.add(new YellowGate());
//        row1.add(new Wall());
//        row1.add(new YellowGate());
//        row1.add(new Wall());
//        row1.add(new Wall());
//        row1.add(new Road());
//        row1.add(new CaseBean(IMonster.HONG_YI_FA_SHI, R.drawable.magic_tower_monster_hong_yi_fa_shi));
//        floor10.add(row1);
//
//        List<CaseBean> row2 = new ArrayList<>();
//        row2.add(new Road());
//        row2.add(new Road());
//        row2.add(new Road());
//        row2.add(new Road());
//        row2.add(new Road());
//        row2.add(new Wall());
//        row2.add(new Road());
//        row2.add(new Road());
//        row2.add(new Road());
//        row2.add(new CaseBean(IMonster.HONG_YI_FA_SHI, R.drawable.magic_tower_monster_hong_yi_fa_shi));
//        row2.add(new BigBloodBottle());
//        floor10.add(row2);
//
//        List<CaseBean> row3 = new ArrayList<>();
//        row3.add(new Road());
//        row3.add(new Wall());
//        row3.add(new Road());
//        row3.add(new Wall());
//        row3.add(new Wall());
//        row3.add(new Wall());
//        row3.add(new Wall());
//        row3.add(new Wall());
//        row3.add(new Road());
//        row3.add(new Wall());
//        row3.add(new Wall());
//        floor10.add(row3);
//
//        List<CaseBean> row4 = new ArrayList<>();
//        row4.add(new CaseBean(IMonster.DA_BIAN_FU, R.drawable.magic_tower_monster_da_bian_fu));
//        row4.add(new Wall());
//        row4.add(new Road());
//        row4.add(new Road());
//        row4.add(new YellowKey());
//        row4.add(new YellowKey());
//        row4.add(new YellowKey());
//        row4.add(new Road());
//        row4.add(new Road());
//        row4.add(new Wall());
//        row4.add(new YellowKey());
//        floor10.add(row4);
//
//        List<CaseBean> row5 = new ArrayList<>();
//        row5.add(new CaseBean(IMonster.HONG_BIAN_FU, R.drawable.magic_tower_monster_hong_bian_fu));
//        row5.add(new Wall());
//        row5.add(new Road());
//        row5.add(new Wall());
//        row5.add(new Wall());
//        row5.add(new Wall());
//        row5.add(new Wall());
//        row5.add(new YellowGate());
//        row5.add(new Wall());
//        row5.add(new Wall());
//        row5.add(new YellowKey());
//        floor10.add(row5);
//
//        List<CaseBean> row6 = new ArrayList<>();
//        row6.add(new CaseBean(IMonster.DA_BIAN_FU, R.drawable.magic_tower_monster_da_bian_fu));
//        row6.add(new Wall());
//        row6.add(new Road());
//        row6.add(new CaseBean(Npc.GATE_IRON_OPEN, R.drawable.magic_tower_npc_gate_iron_1));
//        row6.add(new Road());
//        row6.add(new GoDownstairs());
//        row6.add(new Wall());
//        row6.add(new Road());
//        row6.add(new YellowGate());
//        row6.add(new CaseBean(IMonster.HONG_BIAN_FU, R.drawable.magic_tower_monster_hong_bian_fu));
//        row6.add(new Road());
//        floor10.add(row6);
//
//        List<CaseBean> row7 = new ArrayList<>();
//        row7.add(new Road());
//        row7.add(new Wall());
//        row7.add(new Wall());
//        row7.add(new Wall());
//        row7.add(new Wall());
//        row7.add(new Wall());
//        row7.add(new Wall());
//        row7.add(new YellowGate());
//        row7.add(new Wall());
//        row7.add(new Wall());
//        row7.add(new Road());
//        floor10.add(row7);
//
//        List<CaseBean> row8 = new ArrayList<>();
//        row8.add(new Road());
//        row8.add(new Wall());
//        row8.add(new SmallBloodBottle());
//        row8.add(new BlueGem());
//        row8.add(new RedGem());
//        row8.add(new Wall());
//        row8.add(new Road());
//        row8.add(new CaseBean(IMonster.HONG_BIAN_FU, R.drawable.magic_tower_monster_hong_bian_fu));
//        row8.add(new Road());
//        row8.add(new Wall());
//        row8.add(new YellowKey());
//        floor10.add(row8);
//
//        List<CaseBean> row9 = new ArrayList<>();
//        row9.add(new Road());
//        row9.add(new Wall());
//        row9.add(new SmallBloodBottle());
//        row9.add(new BlueGem());
//        row9.add(new RedGem());
//        row9.add(new CaseBean(Npc.GATE_RED, R.drawable.magic_tower_npc_gate_red_1));
//        row9.add(new CaseBean(IMonster.MA_YI_FA_SHI, R.drawable.magic_tower_monster_ma_yi_fa_shi));
//        row9.add(new Wall());
//        row9.add(new CaseBean(IMonster.MA_YI_FA_SHI, R.drawable.magic_tower_monster_ma_yi_fa_shi));
//        row9.add(new Wall());
//        row9.add(new YellowKey());
//        floor10.add(row9);
//
//        List<CaseBean> row10 = new ArrayList<>();
//        row10.add(new GoUpstairs());
//        row10.add(new Wall());
//        row10.add(new SmallBloodBottle());
//        row10.add(new BlueGem());
//        row10.add(new RedGem());
//        row10.add(new Wall());
//        row10.add(new BlueKey());
//        row10.add(new Wall());
//        row10.add(new BlueKey());
//        row10.add(new Wall());
//        row10.add(new SmallBloodBottle());
//        floor10.add(row10);

        return floor10;
    }

    @Override
    public void fromUpstairsToThisFloor() {
        resetWarriorPosition(new Position(9, 0));
    }

    @Override
    public void fromDownstairsToThisFloor() {
        resetWarriorPosition(new Position(6, 4));
    }
}
