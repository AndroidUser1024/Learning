package com.qinshou.qinshoubox.me.util;

import com.qinshou.qinshoubox.R;
import com.qinshou.qinshoubox.me.bean.ABaseBean;
import com.qinshou.qinshoubox.me.bean.BuildingBean;
import com.qinshou.qinshoubox.me.bean.CaseBean;
import com.qinshou.qinshoubox.me.bean.MonsterBean;
import com.qinshou.qinshoubox.me.bean.NpcBean;
import com.qinshou.qinshoubox.me.bean.PropBean;
import com.qinshou.qinshoubox.me.bean.WarriorBean;

import java.util.HashMap;
import java.util.Map;

/**
 * Description:具体实体类的工厂,内部采用享元模式
 * Created by 禽兽先生
 * Created on 2018/4/11
 */

public class SpecificEntityFactory {
    private static Map<Integer, ABaseBean> map = new HashMap<Integer, ABaseBean>();

    static {
        //建筑类
        map.put(CaseBean.BUILDING_ROAD, new BuildingBean("路", CaseBean.BUILDING_ROAD, R.drawable.building_road));
        map.put(CaseBean.BUILDING_WALL, new BuildingBean("墙", CaseBean.BUILDING_WALL, R.drawable.building_wall));
        map.put(CaseBean.BUILDING_STARRY_SKY, new BuildingBean("星空", CaseBean.BUILDING_STARRY_SKY, R.drawable.building_starry_sky));
        map.put(CaseBean.BUILDING_FIRE_SEA, new BuildingBean("火海", CaseBean.BUILDING_FIRE_SEA, R.drawable.building_fire_sea));

        //怪物类
        map.put(CaseBean.MONSTER_LV_TOU_GUAI, new MonsterBean("绿头怪", CaseBean.MONSTER_LV_TOU_GUAI
                , R.drawable.monster_lv_tou_guai
                , 50
                , 20
                , 1
                , 1
                , 1));
        map.put(CaseBean.MONSTER_HONG_TOU_GUAI, new MonsterBean("红头怪", CaseBean.MONSTER_HONG_TOU_GUAI
                , R.drawable.monster_hong_tou_guai
                , 70
                , 15
                , 2
                , 2
                , 2));
        map.put(CaseBean.MONSTER_KU_LOU_REN, new MonsterBean("骷髅人", CaseBean.MONSTER_KU_LOU_REN
                , R.drawable.monster_ku_lou_ren
                , 110
                , 25
                , 5
                , 5
                , 4));
        map.put(CaseBean.MONSTER_KU_LOU_SHI_BING, new MonsterBean("骷髅士兵", CaseBean.MONSTER_KU_LOU_SHI_BING
                , R.drawable.monster_ku_lou_shi_bing
                , 150
                , 40
                , 20
                , 8
                , 6));
        map.put(CaseBean.MONSTER_CHU_JI_FA_SHI, new MonsterBean("初级法师", CaseBean.MONSTER_CHU_JI_FA_SHI
                , R.drawable.monster_chu_ji_fa_shi
                , 125
                , 50
                , 25
                , 10
                , 7));
        map.put(CaseBean.MONSTER_XIAO_BIAN_FU, new MonsterBean("小蝙蝠", CaseBean.MONSTER_XIAO_BIAN_FU
                , R.drawable.monster_xiao_bian_fu
                , 100
                , 20
                , 5
                , 3
                , 3));
        map.put(CaseBean.MONSTER_QING_TOU_GUAI, new MonsterBean("青头怪", CaseBean.MONSTER_QING_TOU_GUAI
                , R.drawable.monster_qing_tou_guai
                , 200
                , 35
                , 10
                , 5
                , 5));
        map.put(CaseBean.MONSTER_SHOU_MIAN_REN, new MonsterBean("兽面人", CaseBean.MONSTER_SHOU_MIAN_REN
                , R.drawable.monster_shou_mian_ren
                , 300
                , 75
                , 45
                , 13
                , 10));
        map.put(CaseBean.MONSTER_JIN_WEI_SHI, new MonsterBean("金卫士", CaseBean.MONSTER_JIN_WEI_SHI
                , R.drawable.monster_jin_wei_shi
                , 850
                , 350
                , 200
                , 45
                , 40));
        map.put(CaseBean.MONSTER_JIN_DUI_ZHANG, new MonsterBean("金队长", CaseBean.MONSTER_JIN_DUI_ZHANG
                , R.drawable.monster_jin_dui_zhang
                , 900
                , 750
                , 650
                , 77
                , 70));
        map.put(CaseBean.MONSTER_DA_BIAN_FU, new MonsterBean("大蝙蝠", CaseBean.MONSTER_DA_BIAN_FU
                , R.drawable.monster_da_bian_fu
                , 150
                , 65
                , 30
                , 10
                , 8));
        map.put(CaseBean.MONSTER_HONG_BIAN_FU, new MonsterBean("红蝙蝠", CaseBean.MONSTER_HONG_BIAN_FU
                , R.drawable.monster_hong_bian_fu
                , 550
                , 160
                , 90
                , 25
                , 20));
        map.put(CaseBean.MONSTER_CHU_JI_WEI_BING, new MonsterBean("初级卫兵", CaseBean.MONSTER_CHU_JI_WEI_BING
                , R.drawable.monster_chu_ji_wei_bing
                , 450
                , 150
                , 90
                , 22
                , 19));
        map.put(CaseBean.MONSTER_KU_LOU_DUI_ZHANG, new MonsterBean("骷髅队长", CaseBean.MONSTER_KU_LOU_DUI_ZHANG
                , R.drawable.monster_ku_lou_dui_zhang
                , 400
                , 90
                , 50
                , 15
                , 12));
        map.put(CaseBean.MONSTER_GUAI_WANG, new MonsterBean("怪王", CaseBean.MONSTER_GUAI_WANG
                , R.drawable.monster_guai_wang
                , 700
                , 250
                , 125
                , 32
                , 30));
        map.put(CaseBean.MONSTER_SHI_TOU_GUAI_REN, new MonsterBean("石头怪人", CaseBean.MONSTER_SHI_TOU_GUAI_REN
                , R.drawable.monster_shi_tou_guai_ren
                , 500
                , 115
                , 65
                , 15
                , 15));
        map.put(CaseBean.MONSTER_HONG_YI_FA_SHI, new MonsterBean("红衣法师", CaseBean.MONSTER_HONG_YI_FA_SHI
                , R.drawable.monster_hong_yi_fa_shi
                , 500
                , 400
                , 260
                , 47
                , 45));
        map.put(CaseBean.MONSTER_GAO_JI_FA_SHI, new MonsterBean("高级法师", CaseBean.MONSTER_GAO_JI_FA_SHI
                , R.drawable.monster_gao_ji_fa_shi
                , 100
                , 200
                , 110
                , 30
                , 25));
        map.put(CaseBean.MONSTER_BAI_YI_WU_SHI, new MonsterBean("白衣武士", CaseBean.MONSTER_BAI_YI_WU_SHI
                , R.drawable.monster_bai_yi_wu_shi
                , 1300
                , 300
                , 150
                , 40
                , 35));
        map.put(CaseBean.MONSTER_MA_YI_FA_SHI, new MonsterBean("麻衣法师", CaseBean.MONSTER_MA_YI_FA_SHI
                , R.drawable.monster_ma_yi_fa_shi
                , 250
                , 120
                , 70
                , 20
                , 17));
        map.put(CaseBean.MONSTER_SHOU_MIAN_WU_SHI, new MonsterBean("兽面武士", CaseBean.MONSTER_SHOU_MIAN_WU_SHI
                , R.drawable.monster_shou_mian_wu_shi
                , 900
                , 450
                , 330
                , 50
                , 50));
        map.put(CaseBean.MONSTER_MING_WEI_BING, new MonsterBean("冥卫兵", CaseBean.MONSTER_MING_WEI_BING
                , R.drawable.monster_ming_wei_bing
                , 1250
                , 500
                , 400
                , 55
                , 55));
        map.put(CaseBean.MONSTER_GAO_JI_WEI_BING, new MonsterBean("高级卫兵", CaseBean.MONSTER_GAO_JI_WEI_BING
                , R.drawable.monster_gao_ji_wei_bing
                , 1500
                , 560
                , 460
                , 60
                , 60));
        map.put(CaseBean.MONSTER_SHUANG_SHOU_JIAN_SHI, new MonsterBean("双手剑士", CaseBean.MONSTER_SHUANG_SHOU_JIAN_SHI
                , R.drawable.monster_shuang_shou_jian_shi
                , 1200
                , 620
                , 520
                , 65
                , 75));
        map.put(CaseBean.MONSTER_LING_WU_SHI_1, new MonsterBean("灵武士", CaseBean.MONSTER_LING_WU_SHI_1
                , R.drawable.monster_ling_wu_shi
                , 1200
                , 980
                , 900
                , 88
                , 75));
        map.put(CaseBean.MONSTER_LING_WU_SHI_2, new MonsterBean("灵武士", CaseBean.MONSTER_LING_WU_SHI_2
                , R.drawable.monster_ling_wu_shi
                , 1600
                , 1306
                , 1200
                , 117
                , 100));
        map.put(CaseBean.MONSTER_MING_ZHAN_SHI, new MonsterBean("冥战士", CaseBean.MONSTER_MING_ZHAN_SHI
                , R.drawable.monster_ming_zhan_shi
                , 2000
                , 680
                , 590
                , 70
                , 65));
        map.put(CaseBean.MONSTER_LING_FA_SHI_1, new MonsterBean("灵法师", CaseBean.MONSTER_LING_FA_SHI_1
                , R.drawable.monster_ling_fa_shi
                , 1500
                , 830
                , 730
                , 80
                , 70));
        map.put(CaseBean.MONSTER_LING_FA_SHI_2, new MonsterBean("灵法师", CaseBean.MONSTER_LING_FA_SHI_2
                , R.drawable.monster_ling_fa_shi
                , 2000
                , 1106
                , 973
                , 106
                , 93));
        map.put(CaseBean.MONSTER_MING_DUI_ZHANG_1, new MonsterBean("冥队长", CaseBean.MONSTER_MING_DUI_ZHANG_1
                , R.drawable.monster_ming_dui_zhang
                , 2500
                , 900
                , 850
                , 84
                , 75));
        map.put(CaseBean.MONSTER_MING_DUI_ZHANG_2, new MonsterBean("冥队长", CaseBean.MONSTER_MING_DUI_ZHANG_2
                , R.drawable.monster_ming_dui_zhang
                , 3333
                , 1200
                , 1133
                , 112
                , 100));
        map.put(CaseBean.MONSTER_HONG_YI_MO_WANG_1, new MonsterBean("红衣魔王", CaseBean.MONSTER_HONG_YI_MO_WANG_1
                , R.drawable.monster_hong_yi_mo_wang
                , 15000
                , 1000
                , 1000
                , 100
                , 100));
        map.put(CaseBean.MONSTER_HONG_YI_MO_WANG_2, new MonsterBean("红衣魔王", CaseBean.MONSTER_HONG_YI_MO_WANG_2
                , R.drawable.monster_hong_yi_mo_wang
                , 20000
                , 1333
                , 1333
                , 133
                , 133));
        map.put(CaseBean.MONSTER_YING_ZI_ZHAN_SHI, new MonsterBean("影子战士", CaseBean.MONSTER_YING_ZI_ZHAN_SHI
                , R.drawable.monster_ying_zi_zhan_shi
                , 3100
                , 1150
                , 1050
                , 92
                , 80));
        map.put(CaseBean.MONSTER_MING_LING_MO_WANG_1, new MonsterBean("冥灵魔王", CaseBean.MONSTER_MING_LING_MO_WANG_1
                , R.drawable.monster_ming_ling_mo_wang
                , 30000
                , 1700
                , 1500
                , 250
                , 220));
        map.put(CaseBean.MONSTER_MING_LING_MO_WANG_2, new MonsterBean("冥灵魔王", CaseBean.MONSTER_MING_LING_MO_WANG_2
                , R.drawable.monster_ming_ling_mo_wang
                , 45000
                , 2550
                , 2250
                , 312
                , 275));

        //NPC 类
        map.put(CaseBean.NPC_FAIRY_1, new NpcBean("仙子", CaseBean.NPC_FAIRY_1, R.drawable.npc_fairy));
        map.put(CaseBean.NPC_FAIRY_2, new NpcBean("仙子", CaseBean.NPC_FAIRY_2, R.drawable.npc_fairy));
        map.put(CaseBean.NPC_GO_UPSTAIRS, new NpcBean("上楼", CaseBean.NPC_GO_UPSTAIRS, R.drawable.npc_go_upstairs));
        map.put(CaseBean.NPC_GO_DOWNSTAIRS, new NpcBean("下楼", CaseBean.NPC_GO_DOWNSTAIRS, R.drawable.npc_go_downstairs));
        map.put(CaseBean.NPC_GATE_YELLOW, new NpcBean("黄色门", CaseBean.NPC_GATE_YELLOW, R.drawable.npc_gate_yellow1));
        map.put(CaseBean.NPC_GATE_BLUE, new NpcBean("蓝色门", CaseBean.NPC_GATE_BLUE, R.drawable.npc_gate_blue1));
        map.put(CaseBean.NPC_GATE_RED, new NpcBean("红色门", CaseBean.NPC_GATE_RED, R.drawable.npc_gate_red1));
        map.put(CaseBean.NPC_GATE_GREEN, new NpcBean("绿色门", CaseBean.NPC_GATE_GREEN, R.drawable.npc_gate_green1));
        map.put(CaseBean.NPC_GATE_IRON_OPEN, new NpcBean("一碰就开的铁门", CaseBean.NPC_GATE_IRON_OPEN, R.drawable.npc_gate_iron1));
        map.put(CaseBean.NPC_GATE_IRON_CLOSE, new NpcBean("满足特定条件后自动打开的铁门", CaseBean.NPC_GATE_IRON_CLOSE, R.drawable.npc_gate_iron1));
        map.put(CaseBean.NPC_SHEN_MI_LAO_REN_FLOOR_2, new NpcBean("神秘老人", CaseBean.NPC_SHEN_MI_LAO_REN_FLOOR_2, R.drawable.npc_shen_mi_lao_ren));
        map.put(CaseBean.NPC_SHANG_REN_FLOOR_2, new NpcBean("商人", CaseBean.NPC_SHANG_REN_FLOOR_2, R.drawable.npc_shang_ren));
        map.put(CaseBean.NPC_SHANG_DIAN_LAO_BAN_SMALL1, new NpcBean("小商店", CaseBean.NPC_SHANG_DIAN_LAO_BAN_SMALL1, R.drawable.npc_shang_dian_lao_ban_1));
        map.put(CaseBean.NPC_SHANG_DIAN_LAO_BAN_SMALL2, new NpcBean("小商店", CaseBean.NPC_SHANG_DIAN_LAO_BAN_SMALL2, R.drawable.npc_shang_dian_lao_ban_2));
        map.put(CaseBean.NPC_SHANG_DIAN_LAO_BAN_SMALL3, new NpcBean("小商店", CaseBean.NPC_SHANG_DIAN_LAO_BAN_SMALL3, R.drawable.npc_shang_dian_lao_ban_3));
        map.put(CaseBean.NPC_THIEF, new NpcBean("小偷", CaseBean.NPC_THIEF, R.drawable.npc_thief));
        map.put(CaseBean.NPC_SHEN_MI_LAO_REN_FLOOR_5, new NpcBean("神秘老人", CaseBean.NPC_SHEN_MI_LAO_REN_FLOOR_5, R.drawable.npc_shen_mi_lao_ren));
        map.put(CaseBean.NPC_SHANG_REN_FLOOR_5, new NpcBean("商人", CaseBean.NPC_SHANG_REN_FLOOR_5, R.drawable.npc_shang_ren));
        map.put(CaseBean.NPC_SHANG_DIAN_LAO_BAN_BIG1, new NpcBean("大商店", CaseBean.NPC_SHANG_DIAN_LAO_BAN_BIG1, R.drawable.npc_shang_dian_lao_ban_1));
        map.put(CaseBean.NPC_SHANG_DIAN_LAO_BAN_BIG2, new NpcBean("大商店", CaseBean.NPC_SHANG_DIAN_LAO_BAN_BIG2, R.drawable.npc_shang_dian_lao_ban_2));
        map.put(CaseBean.NPC_SHANG_DIAN_LAO_BAN_BIG3, new NpcBean("大商店", CaseBean.NPC_SHANG_DIAN_LAO_BAN_BIG3, R.drawable.npc_shang_dian_lao_ban_3));
        map.put(CaseBean.NPC_SHANG_REN_FLOOR_12, new NpcBean("商人", CaseBean.NPC_SHANG_REN_FLOOR_12, R.drawable.npc_shang_ren));
        map.put(CaseBean.NPC_SHEN_MI_LAO_REN_FLOOR_13, new NpcBean("神秘老人", CaseBean.NPC_SHEN_MI_LAO_REN_FLOOR_13, R.drawable.npc_shen_mi_lao_ren));
        map.put(CaseBean.NPC_SHANG_REN_FLOOR_15, new NpcBean("商人", CaseBean.NPC_SHANG_REN_FLOOR_15, R.drawable.npc_shang_ren));
        map.put(CaseBean.NPC_SHEN_MI_LAO_REN_FLOOR_15, new NpcBean("神秘老人", CaseBean.NPC_SHEN_MI_LAO_REN_FLOOR_15, R.drawable.npc_shen_mi_lao_ren));
        map.put(CaseBean.NPC_PRINCESS, new NpcBean("公主", CaseBean.NPC_PRINCESS, R.drawable.npc_princess));

        //道具类
        map.put(CaseBean.PROP_KEY_YELLOW, new PropBean("黄钥匙", CaseBean.PROP_KEY_YELLOW, R.drawable.prop_yellow_key));
        map.put(CaseBean.PROP_KEY_BLUE, new PropBean("蓝钥匙", CaseBean.PROP_KEY_BLUE, R.drawable.prop_blue_key));
        map.put(CaseBean.PROP_KEY_RED, new PropBean("红钥匙", CaseBean.PROP_KEY_RED, R.drawable.prop_red_key));
        map.put(CaseBean.PROP_XIE_PING_SMALL, new PropBean("小血瓶", CaseBean.PROP_XIE_PING_SMALL, R.drawable.prop_xie_ping_small));
        map.put(CaseBean.PROP_XIE_PING_BIG, new PropBean("大血瓶", CaseBean.PROP_XIE_PING_BIG, R.drawable.prop_xie_ping_big));
        map.put(CaseBean.PROP_BAO_SHI_RED, new PropBean("红宝石", CaseBean.PROP_BAO_SHI_RED, R.drawable.prop_bao_shi_red));
        map.put(CaseBean.PROP_BAO_SHI_BLUE, new PropBean("蓝宝石", CaseBean.PROP_BAO_SHI_BLUE, R.drawable.prop_bao_shi_blue));
        map.put(CaseBean.PROP_SHENG_GUANG_HUI, new PropBean("圣光徽", CaseBean.PROP_SHENG_GUANG_HUI, R.drawable.prop_sheng_guang_hui));
        map.put(CaseBean.PROP_TIE_JIAN, new PropBean("铁剑", CaseBean.PROP_TIE_JIAN, R.drawable.prop_tie_jian));
        map.put(CaseBean.PROP_TIE_DUN, new PropBean("铁盾", CaseBean.PROP_TIE_DUN, R.drawable.prop_tie_dun));
        map.put(CaseBean.PROP_YAO_SHI_HE, new PropBean("钥匙盒", CaseBean.PROP_YAO_SHI_HE, R.drawable.prop_yao_shi_he));
        map.put(CaseBean.PROP_XIAO_FEI_YU, new PropBean("小飞羽", CaseBean.PROP_XIAO_FEI_YU, R.drawable.prop_xiao_fei_yu));
        map.put(CaseBean.PROP_JIN_KUAI, new PropBean("金块", CaseBean.PROP_JIN_KUAI, R.drawable.prop_jin_kuai));
        map.put(CaseBean.PROP_XING_YUN_SHI_ZI_JIA, new PropBean("幸运十字架", CaseBean.PROP_XING_YUN_SHI_ZI_JIA, R.drawable.prop_xing_yun_shi_zi_jia));
        map.put(CaseBean.PROP_FENG_ZHI_LUO_PAN, new PropBean("风之罗盘", CaseBean.PROP_FENG_ZHI_LUO_PAN, R.drawable.prop_feng_zhi_luo_pan));
        map.put(CaseBean.PROP_QING_FENG_JIAN, new PropBean("青锋剑", CaseBean.PROP_QING_FENG_JIAN, R.drawable.prop_qing_feng_jian));
        map.put(CaseBean.PROP_HUANG_JIN_DUN, new PropBean("黄金盾", CaseBean.PROP_HUANG_JIN_DUN, R.drawable.prop_huang_jin_dun));
        map.put(CaseBean.PROP_XING_GUANG_SHEN_LANG, new PropBean("星光神榔", CaseBean.PROP_XING_GUANG_SHEN_LANG, R.drawable.prop_xing_guang_shen_lang));
        map.put(CaseBean.PROP_DA_FEI_YU, new PropBean("大飞羽", CaseBean.PROP_DA_FEI_YU, R.drawable.prop_da_fei_yu));
        map.put(CaseBean.PROP_SHENG_SHUI, new PropBean("圣水", CaseBean.PROP_SHENG_SHUI, R.drawable.prop_sheng_shui));
        map.put(CaseBean.PROP_XING_GUANG_SHEN_JIAN, new PropBean("星光神剑", CaseBean.PROP_XING_GUANG_SHEN_JIAN, R.drawable.prop_xing_guang_shen_jian));
        map.put(CaseBean.PROP_GUANG_MANG_SHEN_DUN, new PropBean("光芒神盾", CaseBean.PROP_GUANG_MANG_SHEN_DUN, R.drawable.prop_guang_mang_shen_dun));

        //勇士类
        map.put(CaseBean.WARRIOR_UP, WarriorBean.getInstance());
        map.put(CaseBean.WARRIOR_DOWN, WarriorBean.getInstance());
        map.put(CaseBean.WARRIOR_LEFT, WarriorBean.getInstance());
        map.put(CaseBean.WARRIOR_RIGHT, WarriorBean.getInstance());
    }

    public static ABaseBean getSpecificEntity(int type) {
        return map.get(type);
    }
}
