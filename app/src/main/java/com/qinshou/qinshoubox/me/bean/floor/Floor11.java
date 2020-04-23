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
//        List<CaseBean> row0 = new ArrayList<>();
//        row0.add(new SmallBloodBottle());
//        row0.add(new Wall());
//        row0.add(new YellowKey());
//        row0.add(new Wall());
//        row0.add(new BlueKey());
//        row0.add(new Wall());
//        row0.add(new RedKey());
//        row0.add(new Wall());
//        row0.add(new BigBloodBottle());
//        row0.add(new CaseBean(IProp.HUANG_JIN_DUN, R.drawable.magic_tower_prop_huang_jin_dun));
//        row0.add(new BigBloodBottle());
//        floor11.add(row0);
//
//        List<CaseBean> row1 = new ArrayList<>();
//        row1.add(new SmallBloodBottle());
//        row1.add(new Wall());
//        row1.add(new YellowKey());
//        row1.add(new Wall());
//        row1.add(new BlueKey());
//        row1.add(new Wall());
//        row1.add(new RedKey());
//        row1.add(new Wall());
//        row1.add(new CaseBean(IMonster.MING_WEI_BING, R.drawable.magic_tower_monster_ming_wei_bing));
//        row1.add(new CaseBean(IMonster.GAO_JI_WEI_BING, R.drawable.magic_tower_monster_gao_ji_wei_bing));
//        row1.add(new CaseBean(IMonster.MING_WEI_BING, R.drawable.magic_tower_monster_ming_wei_bing));
//        floor11.add(row1);
//
//        List<CaseBean> row2 = new ArrayList<>();
//        row2.add(new SmallBloodBottle());
//        row2.add(new Wall());
//        row2.add(new YellowKey());
//        row2.add(new Wall());
//        row2.add(new BlueKey());
//        row2.add(new Wall());
//        row2.add(new RedKey());
//        row2.add(new Wall());
//        row2.add(new Road());
//        row2.add(new CaseBean(IMonster.MING_WEI_BING, R.drawable.magic_tower_monster_ming_wei_bing));
//        row2.add(new Road());
//        floor11.add(row2);
//
//        List<CaseBean> row3 = new ArrayList<>();
//        row3.add(new YellowGate());
//        row3.add(new Wall());
//        row3.add(new YellowGate());
//        row3.add(new Wall());
//        row3.add(new YellowGate());
//        row3.add(new Wall());
//        row3.add(new YellowGate());
//        row3.add(new Wall());
//        row3.add(new Wall());
//        row3.add(new BlueGate());
//        row3.add(new Wall());
//        floor11.add(row3);
//
//        List<CaseBean> row4 = new ArrayList<>();
//        row4.add(new Road());
//        row4.add(new Road());
//        row4.add(new Road());
//        row4.add(new Road());
//        row4.add(new Road());
//        row4.add(new Wall());
//        row4.add(new Road());
//        row4.add(new Road());
//        row4.add(new Road());
//        row4.add(new Road());
//        row4.add(new Road());
//        floor11.add(row4);
//
//        List<CaseBean> row5 = new ArrayList<>();
//        row5.add(new YellowGate());
//        row5.add(new Wall());
//        row5.add(new Wall());
//        row5.add(new BlueGate());
//        row5.add(new Wall());
//        row5.add(new Wall());
//        row5.add(new Wall());
//        row5.add(new BlueGate());
//        row5.add(new Wall());
//        row5.add(new Wall());
//        row5.add(new YellowGate());
//        floor11.add(row5);
//
//        List<CaseBean> row6 = new ArrayList<>();
//        row6.add(new BlueGem());
//        row6.add(new Wall());
//        row6.add(new Road());
//        row6.add(new CaseBean(IMonster.MING_WEI_BING, R.drawable.magic_tower_monster_ming_wei_bing));
//        row6.add(new BigBloodBottle());
//        row6.add(new CaseBean(IMonster.SHUANG_SHOU_JIAN_SHI, R.drawable.magic_tower_monster_shuang_shou_jian_shi));
//        row6.add(new BigBloodBottle());
//        row6.add(new CaseBean(IMonster.MING_WEI_BING, R.drawable.magic_tower_monster_ming_wei_bing));
//        row6.add(new Road());
//        row6.add(new Wall());
//        row6.add(new RedGem());
//        floor11.add(row6);
//
//        List<CaseBean> row7 = new ArrayList<>();
//        row7.add(new BlueGem());
//        row7.add(new Wall());
//        row7.add(new CaseBean(IMonster.SHOU_MIAN_WU_SHI, R.drawable.magic_tower_monster_shou_mian_wu_shi));
//        row7.add(new Wall());
//        row7.add(new Wall());
//        row7.add(new Wall());
//        row7.add(new Wall());
//        row7.add(new Wall());
//        row7.add(new CaseBean(IMonster.SHOU_MIAN_WU_SHI, R.drawable.magic_tower_monster_shou_mian_wu_shi));
//        row7.add(new Wall());
//        row7.add(new RedGem());
//        floor11.add(row7);
//
//        List<CaseBean> row8 = new ArrayList<>();
//        row8.add(new BlueGem());
//        row8.add(new Wall());
//        row8.add(new CaseBean(IMonster.SHOU_MIAN_WU_SHI, R.drawable.magic_tower_monster_shou_mian_wu_shi));
//        row8.add(new Wall());
//        row8.add(new CaseBean(Npc.SHANG_DIAN_LAO_BAN_BIG_1, R.drawable.magic_tower_npc_shang_dian_lao_ban_1));
//        row8.add(new CaseBean(Npc.SHANG_DIAN_LAO_BAN_BIG_2, R.drawable.magic_tower_npc_shang_dian_lao_ban_2));
//        row8.add(new CaseBean(Npc.SHANG_DIAN_LAO_BAN_BIG_3, R.drawable.magic_tower_npc_shang_dian_lao_ban_3));
//        row8.add(new Wall());
//        row8.add(new CaseBean(IMonster.SHOU_MIAN_WU_SHI, R.drawable.magic_tower_monster_shou_mian_wu_shi));
//        row8.add(new Wall());
//        row8.add(new RedGem());
//        floor11.add(row8);
//
//        List<CaseBean> row9 = new ArrayList<>();
//        row9.add(new Wall());
//        row9.add(new Wall());
//        row9.add(new CaseBean(Npc.GATE_RED, R.drawable.magic_tower_npc_gate_red_1));
//        row9.add(new Wall());
//        row9.add(new SmallBloodBottle());
//        row9.add(new Road());
//        row9.add(new SmallBloodBottle());
//        row9.add(new Wall());
//        row9.add(new CaseBean(Npc.GATE_RED, R.drawable.magic_tower_npc_gate_red_1));
//        row9.add(new Wall());
//        row9.add(new Wall());
//        floor11.add(row9);
//
//        List<CaseBean> row10 = new ArrayList<>();
//        row10.add(new GoDownstairs());
//        row10.add(new Road());
//        row10.add(new Road());
//        row10.add(new Road());
//        row10.add(new Road());
//        row10.add(new Road());
//        row10.add(new Road());
//        row10.add(new Road());
//        row10.add(new Road());
//        row10.add(new Road());
//        row10.add(new GoUpstairs());
//        floor11.add(row10);

        return floor11;
    }

    @Override
    public void fromUpstairsToThisFloor() {
        resetWarriorPosition(new Position(10, 9));
    }

    @Override
    public void fromDownstairsToThisFloor() {
        resetWarriorPosition(new Position(10, 1));
    }
}
