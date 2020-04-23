package com.qinshou.qinshoubox.me.bean.floor;


import com.qinshou.qinshoubox.R;
import com.qinshou.qinshoubox.me.bean.CaseBean;
import com.qinshou.qinshoubox.me.bean.Position;
import com.qinshou.qinshoubox.me.bean.monster.IMonster;
import com.qinshou.qinshoubox.me.bean.prop.IProp;
import com.qinshou.qinshoubox.me.enums.Building;
import com.qinshou.qinshoubox.me.enums.Monster;
import com.qinshou.qinshoubox.me.enums.Npc;
import com.qinshou.qinshoubox.me.enums.Prop;

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
//        List<CaseBean> row0 = new ArrayList<>();
//        row0.add(new GoDownstairs());
//        row0.add(new Wall());
//        row0.add(new Road());
//        row0.add(new Road());
//        row0.add(new Road());
//        row0.add(new Road());
//        row0.add(new Wall());
//        row0.add(new Road());
//        row0.add(new YellowKey());
//        row0.add(new CaseBean(IMonster.KU_LOU_DUI_ZHANG, R.drawable.magic_tower_monster_ku_lou_dui_zhang));
//        row0.add(new Road());
//        floor8.add(row0);
//
//        List<CaseBean> row1 = new ArrayList<>();
//        row1.add(new Road());
//        row1.add(new Wall());
//        row1.add(new Road());
//        row1.add(new Wall());
//        row1.add(new Wall());
//        row1.add(new YellowGate());
//        row1.add(new Wall());
//        row1.add(new YellowGate());
//        row1.add(new Wall());
//        row1.add(new Wall());
//        row1.add(new Road());
//        floor8.add(row1);
//
//        List<CaseBean> row2 = new ArrayList<>();
//        row2.add(new Road());
//        row2.add(new Wall());
//        row2.add(new Road());
//        row2.add(new Wall());
//        row2.add(new Road());
//        row2.add(new Road());
//        row2.add(new BlueGate());
//        row2.add(new Road());
//        row2.add(new Road());
//        row2.add(new Wall());
//        row2.add(new RedGem());
//        floor8.add(row2);
//
//        List<CaseBean> row3 = new ArrayList<>();
//        row3.add(new Road());
//        row3.add(new Wall());
//        row3.add(new Road());
//        row3.add(new Wall());
//        row3.add(new CaseBean(IMonster.MA_YI_FA_SHI, R.drawable.magic_tower_monster_ma_yi_fa_shi));
//        row3.add(new Wall());
//        row3.add(new Wall());
//        row3.add(new Wall());
//        row3.add(new CaseBean(IMonster.DA_BIAN_FU, R.drawable.magic_tower_monster_da_bian_fu));
//        row3.add(new Wall());
//        row3.add(new CaseBean(IMonster.QING_TOU_GUAI, R.drawable.magic_tower_monster_qing_tou_guai));
//        floor8.add(row3);
//
//        List<CaseBean> row4 = new ArrayList<>();
//        row4.add(new CaseBean(IMonster.DA_BIAN_FU, R.drawable.magic_tower_monster_da_bian_fu));
//        row4.add(new Wall());
//        row4.add(new Road());
//        row4.add(new Wall());
//        row4.add(new SmallBloodBottle());
//        row4.add(new Wall());
//        row4.add(new GoUpstairs());
//        row4.add(new Road());
//        row4.add(new Road());
//        row4.add(new Wall());
//        row4.add(new CaseBean(IMonster.QING_TOU_GUAI, R.drawable.magic_tower_monster_qing_tou_guai));
//        floor8.add(row4);
//
//        List<CaseBean> row5 = new ArrayList<>();
//        row5.add(new CaseBean(IMonster.HONG_BIAN_FU, R.drawable.magic_tower_monster_hong_bian_fu));
//        row5.add(new Wall());
//        row5.add(new BlueGem());
//        row5.add(new Wall());
//        row5.add(new SmallBloodBottle());
//        row5.add(new Wall());
//        row5.add(new Wall());
//        row5.add(new Wall());
//        row5.add(new Wall());
//        row5.add(new Wall());
//        row5.add(new Road());
//        floor8.add(row5);
//
//        List<CaseBean> row6 = new ArrayList<>();
//        row6.add(new CaseBean(IMonster.DA_BIAN_FU, R.drawable.magic_tower_monster_da_bian_fu));
//        row6.add(new Wall());
//        row6.add(new CaseBean(IMonster.QING_TOU_GUAI, R.drawable.magic_tower_monster_qing_tou_guai));
//        row6.add(new Wall());
//        row6.add(new Road());
//        row6.add(new Road());
//        row6.add(new Road());
//        row6.add(new Wall());
//        row6.add(new Road());
//        row6.add(new CaseBean(IMonster.HONG_BIAN_FU, R.drawable.magic_tower_monster_hong_bian_fu));
//        row6.add(new Road());
//        floor8.add(row6);
//
//        List<CaseBean> row7 = new ArrayList<>();
//        row7.add(new Road());
//        row7.add(new Wall());
//        row7.add(new CaseBean(IMonster.QING_TOU_GUAI, R.drawable.magic_tower_monster_qing_tou_guai));
//        row7.add(new Wall());
//        row7.add(new Wall());
//        row7.add(new Wall());
//        row7.add(new CaseBean(IMonster.CHU_JI_WEI_BING, R.drawable.magic_tower_monster_chu_ji_wei_bing));
//        row7.add(new Wall());
//        row7.add(new YellowGate());
//        row7.add(new Wall());
//        row7.add(new Wall());
//        floor8.add(row7);
//
//        List<CaseBean> row8 = new ArrayList<>();
//        row8.add(new Road());
//        row8.add(new Wall());
//        row8.add(new Road());
//        row8.add(new CaseBean(IMonster.KU_LOU_DUI_ZHANG, R.drawable.magic_tower_monster_ku_lou_dui_zhang));
//        row8.add(new Road());
//        row8.add(new Wall());
//        row8.add(new CaseBean(IMonster.KU_LOU_DUI_ZHANG, R.drawable.magic_tower_monster_ku_lou_dui_zhang));
//        row8.add(new Wall());
//        row8.add(new Road());
//        row8.add(new Road());
//        row8.add(new Road());
//        floor8.add(row8);
//
//        List<CaseBean> row9 = new ArrayList<>();
//        row9.add(new Road());
//        row9.add(new Wall());
//        row9.add(new Wall());
//        row9.add(new Wall());
//        row9.add(new YellowGate());
//        row9.add(new Wall());
//        row9.add(new Road());
//        row9.add(new Wall());
//        row9.add(new Wall());
//        row9.add(new Wall());
//        row9.add(new Road());
//        floor8.add(row9);
//
//        List<CaseBean> row10 = new ArrayList<>();
//        row10.add(new Road());
//        row10.add(new Road());
//        row10.add(new CaseBean(IMonster.MA_YI_FA_SHI, R.drawable.magic_tower_monster_ma_yi_fa_shi));
//        row10.add(new Road());
//        row10.add(new Road());
//        row10.add(new Wall());
//        row10.add(new Road());
//        row10.add(new CaseBean(IMonster.GUAI_WANG, R.drawable.magic_tower_monster_guai_wang));
//        row10.add(new CaseBean(IMonster.BAI_YI_WU_SHI, R.drawable.magic_tower_monster_bai_yi_wu_shi));
//        row10.add(new CaseBean(IMonster.GUAI_WANG, R.drawable.magic_tower_monster_guai_wang));
//        row10.add(new Road());
//        floor8.add(row10);

        return floor8;
    }

    @Override
    public void fromUpstairsToThisFloor() {
        resetWarriorPosition( new Position(4, 7));
    }

    @Override
    public void fromDownstairsToThisFloor() {
        resetWarriorPosition(new Position(1, 0));
    }
}
