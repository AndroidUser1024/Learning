package com.qinshou.qinshoubox.util;

import com.qinshou.qinshoubox.R;
import com.qinshou.qinshoubox.me.bean.MonsterBean;
import com.qinshou.qinshoubox.me.enums.Monster;

import java.util.HashMap;
import java.util.Map;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/10/9 19:32
 * Description:怪物工厂
 */
public class MonsterFactory {
    private static Map<Monster, MonsterBean> map = new HashMap<Monster, MonsterBean>();
    static {
        //怪物类
        map.put(Monster.LV_TOU_GUAI, new MonsterBean("绿头怪", Monster.LV_TOU_GUAI
                , R.drawable.magic_tower_monster_lv_tou_guai
                , 50
                , 20
                , 1
                , 1
                , 1));
        map.put(Monster.HONG_TOU_GUAI, new MonsterBean("红头怪", Monster.HONG_TOU_GUAI
                , R.drawable.magic_tower_monster_hong_tou_guai
                , 70
                , 15
                , 2
                , 2
                , 2));
        map.put(Monster.KU_LOU_REN, new MonsterBean("骷髅人", Monster.KU_LOU_REN
                , R.drawable.magic_tower_monster_ku_lou_ren
                , 110
                , 25
                , 5
                , 5
                , 4));
        map.put(Monster.KU_LOU_SHI_BING, new MonsterBean("骷髅士兵", Monster.KU_LOU_SHI_BING
                , R.drawable.magic_tower_monster_ku_lou_shi_bing
                , 150
                , 40
                , 20
                , 8
                , 6));
        map.put(Monster.CHU_JI_FA_SHI, new MonsterBean("初级法师", Monster.CHU_JI_FA_SHI
                , R.drawable.magic_tower_monster_chu_ji_fa_shi
                , 125
                , 50
                , 25
                , 10
                , 7));
        map.put(Monster.XIAO_BIAN_FU, new MonsterBean("小蝙蝠", Monster.XIAO_BIAN_FU
                , R.drawable.magic_tower_monster_xiao_bian_fu
                , 100
                , 20
                , 5
                , 3
                , 3));
        map.put(Monster.QING_TOU_GUAI, new MonsterBean("青头怪", Monster.QING_TOU_GUAI
                , R.drawable.magic_tower_monster_qing_tou_guai
                , 200
                , 35
                , 10
                , 5
                , 5));
        map.put(Monster.SHOU_MIAN_REN, new MonsterBean("兽面人", Monster.SHOU_MIAN_REN
                , R.drawable.magic_tower_monster_shou_mian_ren
                , 300
                , 75
                , 45
                , 13
                , 10));
        map.put(Monster.JIN_WEI_SHI, new MonsterBean("金卫士", Monster.JIN_WEI_SHI
                , R.drawable.magic_tower_monster_jin_wei_shi
                , 850
                , 350
                , 200
                , 45
                , 40));
        map.put(Monster.JIN_DUI_ZHANG, new MonsterBean("金队长", Monster.JIN_DUI_ZHANG
                , R.drawable.magic_tower_monster_jin_dui_zhang
                , 900
                , 750
                , 650
                , 77
                , 70));
        map.put(Monster.DA_BIAN_FU, new MonsterBean("大蝙蝠", Monster.DA_BIAN_FU
                , R.drawable.magic_tower_monster_da_bian_fu
                , 150
                , 65
                , 30
                , 10
                , 8));
        map.put(Monster.HONG_BIAN_FU, new MonsterBean("红蝙蝠", Monster.HONG_BIAN_FU
                , R.drawable.magic_tower_monster_hong_bian_fu
                , 550
                , 160
                , 90
                , 25
                , 20));
        map.put(Monster.CHU_JI_WEI_BING, new MonsterBean("初级卫兵", Monster.CHU_JI_WEI_BING
                , R.drawable.magic_tower_monster_chu_ji_wei_bing
                , 450
                , 150
                , 90
                , 22
                , 19));
        map.put(Monster.KU_LOU_DUI_ZHANG, new MonsterBean("骷髅队长", Monster.KU_LOU_DUI_ZHANG
                , R.drawable.magic_tower_monster_ku_lou_dui_zhang
                , 400
                , 90
                , 50
                , 15
                , 12));
        map.put(Monster.GUAI_WANG, new MonsterBean("怪王", Monster.GUAI_WANG
                , R.drawable.magic_tower_monster_guai_wang
                , 700
                , 250
                , 125
                , 32
                , 30));
        map.put(Monster.SHI_TOU_GUAI_REN, new MonsterBean("石头怪人", Monster.SHI_TOU_GUAI_REN
                , R.drawable.magic_tower_monster_shi_tou_guai_ren
                , 500
                , 115
                , 65
                , 15
                , 15));
        map.put(Monster.HONG_YI_FA_SHI, new MonsterBean("红衣法师", Monster.HONG_YI_FA_SHI
                , R.drawable.magic_tower_monster_hong_yi_fa_shi
                , 500
                , 400
                , 260
                , 47
                , 45));
        map.put(Monster.GAO_JI_FA_SHI, new MonsterBean("高级法师", Monster.GAO_JI_FA_SHI
                , R.drawable.magic_tower_monster_gao_ji_fa_shi
                , 100
                , 200
                , 110
                , 30
                , 25));
        map.put(Monster.BAI_YI_WU_SHI, new MonsterBean("白衣武士", Monster.BAI_YI_WU_SHI
                , R.drawable.magic_tower_monster_bai_yi_wu_shi
                , 1300
                , 300
                , 150
                , 40
                , 35));
        map.put(Monster.MA_YI_FA_SHI, new MonsterBean("麻衣法师", Monster.MA_YI_FA_SHI
                , R.drawable.magic_tower_monster_ma_yi_fa_shi
                , 250
                , 120
                , 70
                , 20
                , 17));
        map.put(Monster.SHOU_MIAN_WU_SHI, new MonsterBean("兽面武士", Monster.SHOU_MIAN_WU_SHI
                , R.drawable.magic_tower_monster_shou_mian_wu_shi
                , 900
                , 450
                , 330
                , 50
                , 50));
        map.put(Monster.MING_WEI_BING, new MonsterBean("冥卫兵", Monster.MING_WEI_BING
                , R.drawable.magic_tower_monster_ming_wei_bing
                , 1250
                , 500
                , 400
                , 55
                , 55));
        map.put(Monster.GAO_JI_WEI_BING, new MonsterBean("高级卫兵", Monster.GAO_JI_WEI_BING
                , R.drawable.magic_tower_monster_gao_ji_wei_bing
                , 1500
                , 560
                , 460
                , 60
                , 60));
        map.put(Monster.SHUANG_SHOU_JIAN_SHI, new MonsterBean("双手剑士", Monster.SHUANG_SHOU_JIAN_SHI
                , R.drawable.magic_tower_monster_shuang_shou_jian_shi
                , 1200
                , 620
                , 520
                , 65
                , 75));
        map.put(Monster.LING_WU_SHI_1, new MonsterBean("灵武士", Monster.LING_WU_SHI_1
                , R.drawable.magic_tower_monster_ling_wu_shi
                , 1200
                , 980
                , 900
                , 88
                , 75));
        map.put(Monster.LING_WU_SHI_2, new MonsterBean("灵武士", Monster.LING_WU_SHI_2
                , R.drawable.magic_tower_monster_ling_wu_shi
                , 1600
                , 1306
                , 1200
                , 117
                , 100));
        map.put(Monster.MING_ZHAN_SHI, new MonsterBean("冥战士", Monster.MING_ZHAN_SHI
                , R.drawable.magic_tower_monster_ming_zhan_shi
                , 2000
                , 680
                , 590
                , 70
                , 65));
        map.put(Monster.LING_FA_SHI_1, new MonsterBean("灵法师", Monster.LING_FA_SHI_1
                , R.drawable.magic_tower_monster_ling_fa_shi
                , 1500
                , 830
                , 730
                , 80
                , 70));
        map.put(Monster.LING_FA_SHI_2, new MonsterBean("灵法师", Monster.LING_FA_SHI_2
                , R.drawable.magic_tower_monster_ling_fa_shi
                , 2000
                , 1106
                , 973
                , 106
                , 93));
        map.put(Monster.MING_DUI_ZHANG_1, new MonsterBean("冥队长", Monster.MING_DUI_ZHANG_1
                , R.drawable.magic_tower_monster_ming_dui_zhang
                , 2500
                , 900
                , 850
                , 84
                , 75));
        map.put(Monster.MING_DUI_ZHANG_2, new MonsterBean("冥队长", Monster.MING_DUI_ZHANG_2
                , R.drawable.magic_tower_monster_ming_dui_zhang
                , 3333
                , 1200
                , 1133
                , 112
                , 100));
        map.put(Monster.HONG_YI_MO_WANG_1, new MonsterBean("红衣魔王", Monster.HONG_YI_MO_WANG_1
                , R.drawable.magic_tower_monster_hong_yi_mo_wang
                , 15000
                , 1000
                , 1000
                , 100
                , 100));
        map.put(Monster.HONG_YI_MO_WANG_2, new MonsterBean("红衣魔王", Monster.HONG_YI_MO_WANG_2
                , R.drawable.magic_tower_monster_hong_yi_mo_wang
                , 20000
                , 1333
                , 1333
                , 133
                , 133));
        map.put(Monster.YING_ZI_ZHAN_SHI, new MonsterBean("影子战士", Monster.YING_ZI_ZHAN_SHI
                , R.drawable.magic_tower_monster_ying_zi_zhan_shi
                , 3100
                , 1150
                , 1050
                , 92
                , 80));
        map.put(Monster.MING_LING_MO_WANG_1, new MonsterBean("冥灵魔王", Monster.MING_LING_MO_WANG_1
                , R.drawable.magic_tower_monster_ming_ling_mo_wang
                , 30000
                , 1700
                , 1500
                , 250
                , 220));
        map.put(Monster.MING_LING_MO_WANG_2, new MonsterBean("冥灵魔王", Monster.MING_LING_MO_WANG_2
                , R.drawable.magic_tower_monster_ming_ling_mo_wang
                , 45000
                , 2550
                , 2250
                , 312
                , 275));
    }

    public static MonsterBean getMonster(Monster monster) {
        return map.get(monster);
    }
}
