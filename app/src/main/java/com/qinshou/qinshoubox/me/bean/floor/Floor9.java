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
//        List<CaseBean> row0 = new ArrayList<>();
//        row0.add(new CaseBean(IProp.FENG_ZHI_LUO_PAN, R.drawable.magic_tower_prop_feng_zhi_luo_pan));
//        row0.add(new YellowKey());
//        row0.add(new Road());
//        row0.add(new Wall());
//        row0.add(new Wall());
//        row0.add(new Wall());
//        row0.add(new Road());
//        row0.add(new Road());
//        row0.add(new Road());
//        row0.add(new Wall());
//        row0.add(new Road());
//        floor9.add(row0);
//
//        List<CaseBean> row1 = new ArrayList<>();
//        row1.add(new YellowKey());
//        row1.add(new Road());
//        row1.add(new CaseBean(IMonster.SHOU_MIAN_WU_SHI, R.drawable.magic_tower_monster_shou_mian_wu_shi));
//        row1.add(new YellowGate());
//        row1.add(new Road());
//        row1.add(new Road());
//        row1.add(new Road());
//        row1.add(new Wall());
//        row1.add(new Road());
//        row1.add(new YellowGate());
//        row1.add(new CaseBean(IMonster.KU_LOU_DUI_ZHANG, R.drawable.magic_tower_monster_ku_lou_dui_zhang));
//        floor9.add(row1);
//
//        List<CaseBean> row2 = new ArrayList<>();
//        row2.add(new Wall());
//        row2.add(new YellowGate());
//        row2.add(new Wall());
//        row2.add(new Wall());
//        row2.add(new Road());
//        row2.add(new Wall());
//        row2.add(new Wall());
//        row2.add(new Wall());
//        row2.add(new Road());
//        row2.add(new Wall());
//        row2.add(new YellowKey());
//        floor9.add(row2);
//
//        List<CaseBean> row3 = new ArrayList<>();
//        row3.add(new Road());
//        row3.add(new Road());
//        row3.add(new Road());
//        row3.add(new Wall());
//        row3.add(new Road());
//        row3.add(new Wall());
//        row3.add(new Road());
//        row3.add(new Road());
//        row3.add(new Road());
//        row3.add(new Wall());
//        row3.add(new YellowKey());
//        floor9.add(row3);
//
//        List<CaseBean> row4 = new ArrayList<>();
//        row4.add(new Road());
//        row4.add(new Road());
//        row4.add(new Road());
//        row4.add(new CaseBean(Npc.GATE_RED, R.drawable.magic_tower_npc_gate_red_1));
//        row4.add(new Road());
//        row4.add(new Wall());
//        row4.add(new GoDownstairs());
//        row4.add(new Wall());
//        row4.add(new Road());
//        row4.add(new Wall());
//        row4.add(new SmallBloodBottle());
//        floor9.add(row4);
//
//        List<CaseBean> row5 = new ArrayList<>();
//        row5.add(new Wall());
//        row5.add(new BlueGate());
//        row5.add(new Wall());
//        row5.add(new Wall());
//        row5.add(new Road());
//        row5.add(new Wall());
//        row5.add(new Wall());
//        row5.add(new Wall());
//        row5.add(new Road());
//        row5.add(new Wall());
//        row5.add(new Wall());
//        floor9.add(row5);
//
//        List<CaseBean> row6 = new ArrayList<>();
//        row6.add(new BlueGem());
//        row6.add(new CaseBean(IMonster.HONG_YI_FA_SHI, R.drawable.magic_tower_monster_hong_yi_fa_shi));
//        row6.add(new RedGem());
//        row6.add(new Wall());
//        row6.add(new CaseBean(IMonster.MA_YI_FA_SHI, R.drawable.magic_tower_monster_ma_yi_fa_shi));
//        row6.add(new Wall());
//        row6.add(new GoUpstairs());
//        row6.add(new Wall());
//        row6.add(new Road());
//        row6.add(new Wall());
//        row6.add(new SmallBloodBottle());
//        floor9.add(row6);
//
//        List<CaseBean> row7 = new ArrayList<>();
//        row7.add(new Wall());
//        row7.add(new YellowGate());
//        row7.add(new Wall());
//        row7.add(new Wall());
//        row7.add(new Road());
//        row7.add(new Road());
//        row7.add(new Road());
//        row7.add(new YellowGate());
//        row7.add(new Road());
//        row7.add(new Wall());
//        row7.add(new YellowKey());
//        floor9.add(row7);
//
//        List<CaseBean> row8 = new ArrayList<>();
//        row8.add(new CaseBean(IMonster.KU_LOU_DUI_ZHANG, R.drawable.magic_tower_monster_ku_lou_dui_zhang));
//        row8.add(new SmallBloodBottle());
//        row8.add(new CaseBean(IMonster.KU_LOU_DUI_ZHANG, R.drawable.magic_tower_monster_ku_lou_dui_zhang));
//        row8.add(new Wall());
//        row8.add(new Wall());
//        row8.add(new BlueGate());
//        row8.add(new Wall());
//        row8.add(new Wall());
//        row8.add(new Road());
//        row8.add(new Wall());
//        row8.add(new YellowKey());
//        floor9.add(row8);
//
//        List<CaseBean> row9 = new ArrayList<>();
//        row9.add(new BlueKey());
//        row9.add(new CaseBean(IMonster.KU_LOU_DUI_ZHANG, R.drawable.magic_tower_monster_ku_lou_dui_zhang));
//        row9.add(new SmallBloodBottle());
//        row9.add(new Wall());
//        row9.add(new CaseBean(IMonster.SHI_TOU_GUAI_REN, R.drawable.magic_tower_monster_shi_tou_guai_ren));
//        row9.add(new CaseBean(IMonster.MA_YI_FA_SHI, R.drawable.magic_tower_monster_ma_yi_fa_shi));
//        row9.add(new CaseBean(IMonster.SHI_TOU_GUAI_REN, R.drawable.magic_tower_monster_shi_tou_guai_ren));
//        row9.add(new Wall());
//        row9.add(new Road());
//        row9.add(new YellowGate());
//        row9.add(new CaseBean(IMonster.KU_LOU_DUI_ZHANG, R.drawable.magic_tower_monster_ku_lou_dui_zhang));
//        floor9.add(row9);
//
//        List<CaseBean> row10 = new ArrayList<>();
//        row10.add(new CaseBean(IProp.QING_FENG_JIAN, R.drawable.magic_tower_prop_qing_feng_jian));
//        row10.add(new BlueKey());
//        row10.add(new CaseBean(IMonster.KU_LOU_DUI_ZHANG, R.drawable.magic_tower_monster_ku_lou_dui_zhang));
//        row10.add(new YellowGate());
//        row10.add(new BigBloodBottle());
//        row10.add(new CaseBean(IMonster.SHI_TOU_GUAI_REN, R.drawable.magic_tower_monster_shi_tou_guai_ren));
//        row10.add(new BigBloodBottle());
//        row10.add(new Wall());
//        row10.add(new Road());
//        row10.add(new Wall());
//        row10.add(new Road());
//        floor9.add(row10);

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
