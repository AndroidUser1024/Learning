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
//        List<CaseBean> row0 = new ArrayList<>();
//        row0.add(new CaseBean(Npc.SHANG_REN_FLOOR_12, R.drawable.magic_tower_npc_shang_ren));
//        row0.add(new BlueGem());
//        row0.add(new Wall());
//        row0.add(new Road());
//        row0.add(new JinWeiShi());
//        row0.add(new JinDuiZhang());
//        row0.add(new JinWeiShi());
//        row0.add(new Road());
//        row0.add(new Wall());
//        row0.add(new BigBloodBottle());
//        row0.add(new CaseBean(IProp.XING_GUANG_SHEN_LANG, R.drawable.magic_tower_prop_xing_guang_shen_lang));
//        floor12.add(row0);
//
//        List<CaseBean> row1 = new ArrayList<>();
//        row1.add(new RedGem());
//        row1.add(new Road());
//        row1.add(new Wall());
//        row1.add(new Road());
//        row1.add(new Wall());
//        row1.add(new YellowGate());
//        row1.add(new Wall());
//        row1.add(new Road());
//        row1.add(new Wall());
//        row1.add(new Road());
//        row1.add(new BigBloodBottle());
//        floor12.add(row1);
//
//        List<CaseBean> row2 = new ArrayList<>();
//        row2.add(new Road());
//        row2.add(new Road());
//        row2.add(new Wall());
//        row2.add(new Road());
//        row2.add(new Wall());
//        row2.add(new JinDuiZhang());
//        row2.add(new Wall());
//        row2.add(new Road());
//        row2.add(new Wall());
//        row2.add(new Road());
//        row2.add(new Road());
//        floor12.add(row2);
//
//        List<CaseBean> row3 = new ArrayList<>();
//        row3.add(new Road());
//        row3.add(new CaseBean(IMonster.SHUANG_SHOU_JIAN_SHI, R.drawable.magic_tower_monster_shuang_shou_jian_shi));
//        row3.add(new Wall());
//        row3.add(new Road());
//        row3.add(new Wall());
//        row3.add(new YellowKey());
//        row3.add(new Wall());
//        row3.add(new Road());
//        row3.add(new Wall());
//        row3.add(new CaseBean(IMonster.LING_WU_SHI_1, R.drawable.magic_tower_monster_ling_wu_shi));
//        row3.add(new Road());
//        floor12.add(row3);
//
//        List<CaseBean> row4 = new ArrayList<>();
//        row4.add(new CaseBean(IMonster.SHUANG_SHOU_JIAN_SHI, R.drawable.magic_tower_monster_shuang_shou_jian_shi));
//        row4.add(new CaseBean(IMonster.MING_ZHAN_SHI, R.drawable.magic_tower_monster_ming_zhan_shi));
//        row4.add(new Wall());
//        row4.add(new Road());
//        row4.add(new Wall());
//        row4.add(new YellowKey());
//        row4.add(new Wall());
//        row4.add(new Road());
//        row4.add(new Wall());
//        row4.add(new CaseBean(IMonster.LING_FA_SHI_1, R.drawable.magic_tower_monster_ling_fa_shi));
//        row4.add(new CaseBean(IMonster.LING_WU_SHI_1, R.drawable.magic_tower_monster_ling_wu_shi));
//        floor12.add(row4);
//
//        List<CaseBean> row5 = new ArrayList<>();
//        row5.add(new Wall());
//        row5.add(new BlueGate());
//        row5.add(new Wall());
//        row5.add(new Road());
//        row5.add(new Wall());
//        row5.add(new SmallBloodBottle());
//        row5.add(new Wall());
//        row5.add(new Road());
//        row5.add(new Wall());
//        row5.add(new BlueGate());
//        row5.add(new Wall());
//        floor12.add(row5);
//
//        List<CaseBean> row6 = new ArrayList<>();
//        row6.add(new Road());
//        row6.add(new Road());
//        row6.add(new Road());
//        row6.add(new Road());
//        row6.add(new Wall());
//        row6.add(new SmallBloodBottle());
//        row6.add(new Wall());
//        row6.add(new Road());
//        row6.add(new Road());
//        row6.add(new Road());
//        row6.add(new Road());
//        floor12.add(row6);
//
//        List<CaseBean> row7 = new ArrayList<>();
//        row7.add(new Wall());
//        row7.add(new Wall());
//        row7.add(new Wall());
//        row7.add(new Road());
//        row7.add(new Wall());
//        row7.add(new Wall());
//        row7.add(new Wall());
//        row7.add(new Road());
//        row7.add(new Wall());
//        row7.add(new Wall());
//        row7.add(new Wall());
//        floor12.add(row7);
//
//        List<CaseBean> row8 = new ArrayList<>();
//        row8.add(new BlueGem());
//        row8.add(new CaseBean(IMonster.SHUANG_SHOU_JIAN_SHI, R.drawable.magic_tower_monster_shuang_shou_jian_shi));
//        row8.add(new YellowGate());
//        row8.add(new CaseBean(IMonster.MING_WEI_BING, R.drawable.magic_tower_monster_ming_wei_bing));
//        row8.add(new CaseBean(IMonster.MING_WEI_BING, R.drawable.magic_tower_monster_ming_wei_bing));
//        row8.add(new CaseBean(IMonster.GAO_JI_WEI_BING, R.drawable.magic_tower_monster_gao_ji_wei_bing));
//        row8.add(new CaseBean(IMonster.MING_WEI_BING, R.drawable.magic_tower_monster_ming_wei_bing));
//        row8.add(new CaseBean(IMonster.MING_WEI_BING, R.drawable.magic_tower_monster_ming_wei_bing));
//        row8.add(new YellowGate());
//        row8.add(new CaseBean(IMonster.SHUANG_SHOU_JIAN_SHI, R.drawable.magic_tower_monster_shuang_shou_jian_shi));
//        row8.add(new RedGem());
//        floor12.add(row8);
//
//        List<CaseBean> row9 = new ArrayList<>();
//        row9.add(new Wall());
//        row9.add(new Wall());
//        row9.add(new Wall());
//        row9.add(new Wall());
//        row9.add(new Wall());
//        row9.add(new BlueGate());
//        row9.add(new Wall());
//        row9.add(new Wall());
//        row9.add(new Wall());
//        row9.add(new Wall());
//        row9.add(new Wall());
//        floor12.add(row9);
//
//        List<CaseBean> row10 = new ArrayList<>();
//        row10.add(new GoUpstairs());
//        row10.add(new Road());
//        row10.add(new Road());
//        row10.add(new Road());
//        row10.add(new Road());
//        row10.add(new Road());
//        row10.add(new Road());
//        row10.add(new Road());
//        row10.add(new Road());
//        row10.add(new Road());
//        row10.add(new GoDownstairs());
//        floor12.add(row10);

        return floor12;
    }

    @Override
    public void fromUpstairsToThisFloor() {
        resetWarriorPosition(new Position(10, 1));
    }

    @Override
    public void fromDownstairsToThisFloor() {
        resetWarriorPosition(new Position(10, 9));
    }
}
