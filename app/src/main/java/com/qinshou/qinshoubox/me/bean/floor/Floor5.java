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
//        List<CaseBean> row0 = new ArrayList<>();
//        row0.add(new CaseBean(IProp.YAO_SHI_HE, R.drawable.magic_tower_prop_yao_shi_he));
//        row0.add(new Wall());
//        row0.add(new SmallBloodBottle());
//        row0.add(new Wall());
//        row0.add(new BigBloodBottle());
//        row0.add(new CaseBean(IMonster.CHU_JI_FA_SHI, R.drawable.magic_tower_monster_chu_ji_fa_shi));
//        row0.add(new Road());
//        row0.add(new Road());
//        row0.add(new CaseBean(IMonster.CHU_JI_FA_SHI, R.drawable.magic_tower_monster_chu_ji_fa_shi));
//        row0.add(new YellowKey());
//        row0.add(new BlueKey());
//        floor5.add(row0);
//
//        List<CaseBean> row1 = new ArrayList<>();
//        row1.add(new Road());
//        row1.add(new Wall());
//        row1.add(new RedGem());
//        row1.add(new Wall());
//        row1.add(new CaseBean(IMonster.CHU_JI_FA_SHI, R.drawable.magic_tower_monster_chu_ji_fa_shi));
//        row1.add(new Road());
//        row1.add(new Road());
//        row1.add(new Road());
//        row1.add(new Road());
//        row1.add(new CaseBean(IMonster.CHU_JI_FA_SHI, R.drawable.magic_tower_monster_chu_ji_fa_shi));
//        row1.add(new YellowKey());
//        floor5.add(row1);
//
//        List<CaseBean> row2 = new ArrayList<>();
//        row2.add(new CaseBean(IMonster.DA_BIAN_FU, R.drawable.magic_tower_monster_da_bian_fu));
//        row2.add(new Wall());
//        row2.add(new Road());
//        row2.add(new Wall());
//        row2.add(new CaseBean(IMonster.KU_LOU_SHI_BING, R.drawable.magic_tower_monster_ku_lou_shi_bing));
//        row2.add(new Road());
//        row2.add(new Wall());
//        row2.add(new Wall());
//        row2.add(new YellowGate());
//        row2.add(new Wall());
//        row2.add(new Wall());
//        floor5.add(row2);
//
//        List<CaseBean> row3 = new ArrayList<>();
//        row3.add(new Road());
//        row3.add(new YellowGate());
//        row3.add(new CaseBean(IMonster.CHU_JI_FA_SHI, R.drawable.magic_tower_monster_chu_ji_fa_shi));
//        row3.add(new Wall());
//        row3.add(new CaseBean(IProp.TIE_DUN, R.drawable.magic_tower_prop_tie_dun));
//        row3.add(new CaseBean(IMonster.KU_LOU_SHI_BING, R.drawable.magic_tower_monster_ku_lou_shi_bing));
//        row3.add(new Wall());
//        row3.add(new Road());
//        row3.add(new CaseBean(IMonster.SHOU_MIAN_REN, R.drawable.magic_tower_monster_shou_mian_ren));
//        row3.add(new CaseBean(IMonster.KU_LOU_SHI_BING, R.drawable.magic_tower_monster_ku_lou_shi_bing));
//        row3.add(new CaseBean(Npc.SHANG_REN_FLOOR_5, R.drawable.magic_tower_npc_shang_ren));
//        floor5.add(row3);
//
//        List<CaseBean> row4 = new ArrayList<>();
//        row4.add(new CaseBean(IMonster.DA_BIAN_FU, R.drawable.magic_tower_monster_da_bian_fu));
//        row4.add(new Wall());
//        row4.add(new Road());
//        row4.add(new Wall());
//        row4.add(new Wall());
//        row4.add(new Wall());
//        row4.add(new Wall());
//        row4.add(new Road());
//        row4.add(new Road());
//        row4.add(new Road());
//        row4.add(new CaseBean(IMonster.KU_LOU_SHI_BING, R.drawable.magic_tower_monster_ku_lou_shi_bing));
//        floor5.add(row4);
//
//        List<CaseBean> row5 = new ArrayList<>();
//        row5.add(new RedGem());
//        row5.add(new Wall());
//        row5.add(new Road());
//        row5.add(new Road());
//        row5.add(new Road());
//        row5.add(new CaseBean(IMonster.XIAO_BIAN_FU, R.drawable.magic_tower_monster_xiao_bian_fu));
//        row5.add(new CaseBean(IMonster.KU_LOU_REN, R.drawable.magic_tower_monster_ku_lou_ren));
//        row5.add(new Road());
//        row5.add(new Road());
//        row5.add(new Road());
//        row5.add(new Road());
//        floor5.add(row5);
//
//        List<CaseBean> row6 = new ArrayList<>();
//        row6.add(new BlueGem());
//        row6.add(new Wall());
//        row6.add(new Wall());
//        row6.add(new CaseBean(IMonster.QING_TOU_GUAI, R.drawable.magic_tower_monster_qing_tou_guai));
//        row6.add(new Wall());
//        row6.add(new Wall());
//        row6.add(new Wall());
//        row6.add(new Wall());
//        row6.add(new Road());
//        row6.add(new Road());
//        row6.add(new Road());
//        floor5.add(row6);
//
//        List<CaseBean> row7 = new ArrayList<>();
//        row7.add(new Road());
//        row7.add(new CaseBean(Npc.SHEN_MI_LAO_REN_FLOOR_5, R.drawable.magic_tower_npc_shen_mi_lao_ren));
//        row7.add(new Wall());
//        row7.add(new CaseBean(IMonster.QING_TOU_GUAI, R.drawable.magic_tower_monster_qing_tou_guai));
//        row7.add(new Wall());
//        row7.add(new Road());
//        row7.add(new Road());
//        row7.add(new Road());
//        row7.add(new CaseBean(IMonster.SHOU_MIAN_REN, R.drawable.magic_tower_monster_shou_mian_ren));
//        row7.add(new CaseBean(IMonster.CHU_JI_WEI_BING, R.drawable.magic_tower_monster_chu_ji_wei_bing));
//        row7.add(new Road());
//        floor5.add(row7);
//
//        List<CaseBean> row8 = new ArrayList<>();
//        row8.add(new Wall());
//        row8.add(new Wall());
//        row8.add(new Wall());
//        row8.add(new CaseBean(IMonster.XIAO_BIAN_FU, R.drawable.magic_tower_monster_xiao_bian_fu));
//        row8.add(new Wall());
//        row8.add(new YellowGate());
//        row8.add(new Wall());
//        row8.add(new BlueGate());
//        row8.add(new Wall());
//        row8.add(new YellowGate());
//        row8.add(new Wall());
//        floor5.add(row8);
//
//        List<CaseBean> row9 = new ArrayList<>();
//        row9.add(new Road());
//        row9.add(new Road());
//        row9.add(new Wall());
//        row9.add(new Road());
//        row9.add(new Wall());
//        row9.add(new CaseBean(IMonster.XIAO_BIAN_FU, R.drawable.magic_tower_monster_xiao_bian_fu));
//        row9.add(new Wall());
//        row9.add(new BlueGem());
//        row9.add(new YellowGate());
//        row9.add(new Road());
//        row9.add(new Wall());
//        floor5.add(row9);
//
//        List<CaseBean> row10 = new ArrayList<>();
//        row10.add(new GoDownstairs());
//        row10.add(new Road());
//        row10.add(new CaseBean(IMonster.XIAO_BIAN_FU, R.drawable.magic_tower_monster_xiao_bian_fu));
//        row10.add(new Road());
//        row10.add(new Road());
//        row10.add(new Road());
//        row10.add(new Wall());
//        row10.add(new YellowKey());
//        row10.add(new Wall());
//        row10.add(new GoUpstairs());
//        row10.add(new Wall());
//        floor5.add(row10);

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
