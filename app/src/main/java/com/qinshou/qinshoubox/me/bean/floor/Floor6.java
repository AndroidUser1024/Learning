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
 * Description:第 6 层
 * Created by 禽兽先生
 * Created on 2017/4/26
 */

public class Floor6 extends AbsFloor {

    @Override
    public int getFloor() {
        return 6;
    }

    @Override
    public List<List<CaseBean>> setData() {
        List<List<CaseBean>> floor6 = new ArrayList<>();
//        List<CaseBean> row0 = new ArrayList<>();
//        row0.add(new CaseBean(IProp.XIAO_FEI_YU, R.drawable.magic_tower_prop_xiao_fei_yu));
//        row0.add(new CaseBean(IMonster.KU_LOU_DUI_ZHANG, R.drawable.magic_tower_monster_ku_lou_dui_zhang));
//        row0.add(new Wall());
//        row0.add(new CaseBean(IProp.BAO_SHI_BLUE, R.drawable.magic_tower_prop_gem_blue));
//        row0.add(new Wall());
//        row0.add(new YellowKey());
//        row0.add(new CaseBean(IMonster.GUAI_WANG, R.drawable.magic_tower_monster_guai_wang));
//        row0.add(new CaseBean(IProp.JIN_KUAI, R.drawable.magic_tower_prop_jin_kuai));
//        row0.add(new Wall());
//        row0.add(new BigBloodBottle());
//        row0.add(new BigBloodBottle());
//        floor6.add(row0);
//
//        List<CaseBean> row1 = new ArrayList<>();
//        row1.add(new CaseBean(IMonster.KU_LOU_DUI_ZHANG, R.drawable.magic_tower_monster_ku_lou_dui_zhang));
//        row1.add(new YellowKey());
//        row1.add(new Wall());
//        row1.add(new RedGem());
//        row1.add(new Wall());
//        row1.add(new Road());
//        row1.add(new YellowKey());
//        row1.add(new CaseBean(IMonster.GUAI_WANG, R.drawable.magic_tower_monster_guai_wang));
//        row1.add(new Wall());
//        row1.add(new CaseBean(IMonster.SHI_TOU_GUAI_REN, R.drawable.magic_tower_monster_shi_tou_guai_ren));
//        row1.add(new BigBloodBottle());
//        floor6.add(row1);
//
//        List<CaseBean> row2 = new ArrayList<>();
//        row2.add(new YellowKey());
//        row2.add(new CaseBean(IMonster.HONG_BIAN_FU, R.drawable.magic_tower_monster_hong_bian_fu));
//        row2.add(new BlueGate());
//        row2.add(new Road());
//        row2.add(new BlueGate());
//        row2.add(new CaseBean(IMonster.HONG_BIAN_FU, R.drawable.magic_tower_monster_hong_bian_fu));
//        row2.add(new Road());
//        row2.add(new YellowKey());
//        row2.add(new Wall());
//        row2.add(new Road());
//        row2.add(new CaseBean(IMonster.SHI_TOU_GUAI_REN, R.drawable.magic_tower_monster_shi_tou_guai_ren));
//        floor6.add(row2);
//
//        List<CaseBean> row3 = new ArrayList<>();
//        row3.add(new Road());
//        row3.add(new Road());
//        row3.add(new Wall());
//        row3.add(new CaseBean(IMonster.CHU_JI_WEI_BING, R.drawable.magic_tower_monster_chu_ji_wei_bing));
//        row3.add(new Wall());
//        row3.add(new Road());
//        row3.add(new Road());
//        row3.add(new Road());
//        row3.add(new Wall());
//        row3.add(new CaseBean(IMonster.HONG_YI_FA_SHI, R.drawable.magic_tower_monster_hong_yi_fa_shi));
//        row3.add(new Road());
//        floor6.add(row3);
//
//        List<CaseBean> row4 = new ArrayList<>();
//        row4.add(new Wall());
//        row4.add(new Wall());
//        row4.add(new Wall());
//        row4.add(new CaseBean(Npc.GATE_RED, R.drawable.magic_tower_npc_gate_red_1));
//        row4.add(new Wall());
//        row4.add(new Wall());
//        row4.add(new Wall());
//        row4.add(new Wall());
//        row4.add(new Wall());
//        row4.add(new YellowGate());
//        row4.add(new Wall());
//        floor6.add(row4);
//
//        List<CaseBean> row5 = new ArrayList<>();
//        row5.add(new Road());
//        row5.add(new Road());
//        row5.add(new CaseBean(IMonster.GAO_JI_FA_SHI, R.drawable.magic_tower_monster_gao_ji_fa_shi));
//        row5.add(new Road());
//        row5.add(new YellowKey());
//        row5.add(new YellowKey());
//        row5.add(new YellowKey());
//        row5.add(new Road());
//        row5.add(new CaseBean(IMonster.GAO_JI_FA_SHI, R.drawable.magic_tower_monster_gao_ji_fa_shi));
//        row5.add(new Road());
//        row5.add(new Road());
//        floor6.add(row5);
//
//        List<CaseBean> row6 = new ArrayList<>();
//        row6.add(new Road());
//        row6.add(new Wall());
//        row6.add(new Wall());
//        row6.add(new Wall());
//        row6.add(new Wall());
//        row6.add(new Wall());
//        row6.add(new Wall());
//        row6.add(new Wall());
//        row6.add(new Wall());
//        row6.add(new Wall());
//        row6.add(new Wall());
//        floor6.add(row6);
//
//        List<CaseBean> row7 = new ArrayList<>();
//        row7.add(new Road());
//        row7.add(new Wall());
//        row7.add(new CaseBean(IMonster.DA_BIAN_FU, R.drawable.magic_tower_monster_da_bian_fu));
//        row7.add(new YellowGate());
//        row7.add(new CaseBean(IMonster.DA_BIAN_FU, R.drawable.magic_tower_monster_da_bian_fu));
//        row7.add(new Road());
//        row7.add(new Road());
//        row7.add(new Road());
//        row7.add(new Road());
//        row7.add(new Road());
//        row7.add(new Wall());
//        floor6.add(row7);
//
//        List<CaseBean> row8 = new ArrayList<>();
//        row8.add(new Road());
//        row8.add(new Wall());
//        row8.add(new YellowGate());
//        row8.add(new Wall());
//        row8.add(new YellowGate());
//        row8.add(new Wall());
//        row8.add(new Wall());
//        row8.add(new Wall());
//        row8.add(new Wall());
//        row8.add(new BlueGate());
//        row8.add(new Wall());
//        floor6.add(row8);
//
//        List<CaseBean> row9 = new ArrayList<>();
//        row9.add(new Road());
//        row9.add(new Wall());
//        row9.add(new CaseBean(IMonster.DA_BIAN_FU, R.drawable.magic_tower_monster_da_bian_fu));
//        row9.add(new Wall());
//        row9.add(new Road());
//        row9.add(new Road());
//        row9.add(new Wall());
//        row9.add(new Wall());
//        row9.add(new Road());
//        row9.add(new Road());
//        row9.add(new Wall());
//        floor6.add(row9);
//
//        List<CaseBean> row10 = new ArrayList<>();
//        row10.add(new Road());
//        row10.add(new Road());
//        row10.add(new Road());
//        row10.add(new Wall());
//        row10.add(new GoUpstairs());
//        row10.add(new Road());
//        row10.add(new YellowGate());
//        row10.add(new YellowGate());
//        row10.add(new Road());
//        row10.add(new GoDownstairs());
//        row10.add(new Wall());
//        floor6.add(row10);

        return floor6;
    }

    @Override
    public void fromUpstairsToThisFloor() {
        resetWarriorPosition(new Position(10, 5));
    }

    @Override
    public void fromDownstairsToThisFloor() {
        resetWarriorPosition(new Position(9, 9));
    }
}
