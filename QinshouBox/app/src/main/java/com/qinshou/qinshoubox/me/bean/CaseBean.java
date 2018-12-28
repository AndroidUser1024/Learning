package com.qinshou.qinshoubox.me.bean;

import com.qinshou.commonmodule.database.DatabaseField;
import com.qinshou.qinshoubox.me.util.SpecificEntityFactory;

/**
 * Description:地图中每一格的实体类
 * Created by 禽兽先生
 * Created on 2018/4/10
 */

public class CaseBean {
    //建筑类
    public static final int BUILDING_ROAD = 100;
    public static final int BUILDING_WALL = 101;
    public static final int BUILDING_STARRY_SKY = 102;
    public static final int BUILDING_FIRE_SEA = 103;

    //怪物类
    public static final int MONSTER_LV_TOU_GUAI = 200;  //绿头怪
    public static final int MONSTER_HONG_TOU_GUAI = 201;    //红头怪
    public static final int MONSTER_KU_LOU_REN = 202;   //骷髅人
    public static final int MONSTER_KU_LOU_SHI_BING = 203;  //骷髅士兵
    public static final int MONSTER_CHU_JI_FA_SHI = 204;    //初级法师
    public static final int MONSTER_XIAO_BIAN_FU = 205; //小蝙蝠
    public static final int MONSTER_QING_TOU_GUAI = 206;    //青头怪
    public static final int MONSTER_SHOU_MIAN_REN = 207;    //兽面人
    public static final int MONSTER_JIN_WEI_SHI = 208;  //金卫士
    public static final int MONSTER_JIN_DUI_ZHANG = 209;    //金队长
    public static final int MONSTER_DA_BIAN_FU = 210;   //大蝙蝠
    public static final int MONSTER_HONG_BIAN_FU = 211; //红蝙蝠
    public static final int MONSTER_CHU_JI_WEI_BING = 212;  //初级卫兵
    public static final int MONSTER_KU_LOU_DUI_ZHANG = 213; //骷髅队长
    public static final int MONSTER_GUAI_WANG = 214;    //怪王
    public static final int MONSTER_SHI_TOU_GUAI_REN = 215; //石头怪人
    public static final int MONSTER_HONG_YI_FA_SHI = 216;   //红衣法师
    public static final int MONSTER_GAO_JI_FA_SHI = 217;    //高级法师
    public static final int MONSTER_BAI_YI_WU_SHI = 218;    //白衣武士
    public static final int MONSTER_MA_YI_FA_SHI = 219; //麻衣法师
    public static final int MONSTER_SHOU_MIAN_WU_SHI = 220; //兽面武士
    public static final int MONSTER_MING_WEI_BING = 221;    //冥卫兵
    public static final int MONSTER_GAO_JI_WEI_BING = 222;  //高级卫兵
    public static final int MONSTER_SHUANG_SHOU_JIAN_SHI = 223; //双手剑士
    public static final int MONSTER_LING_WU_SHI_1 = 224;    //弱版灵武士
    public static final int MONSTER_LING_WU_SHI_2 = 225;    //强化版灵武士,击败第十六层红衣魔王后会变强,生命值,攻击力,防御力增强
    public static final int MONSTER_MING_ZHAN_SHI = 226;    //冥战士
    public static final int MONSTER_LING_FA_SHI_1 = 227;    //弱版灵法师
    public static final int MONSTER_LING_FA_SHI_2 = 228;    //强化版灵法师,击败第十六层红衣魔王后会变强,生命值,攻击力,防御力增强
    public static final int MONSTER_MING_DUI_ZHANG_1 = 229; //弱版冥队长
    public static final int MONSTER_MING_DUI_ZHANG_2 = 230; //强化版冥队长,击败第十六层红衣魔王后会变强,生命值,攻击力,防御力增强
    public static final int MONSTER_HONG_YI_MO_WANG_1 = 231;    //弱版红衣魔王,位于第十六层
    public static final int MONSTER_HONG_YI_MO_WANG_2 = 232;    //强化版红衣魔王,位于第十八层
    public static final int MONSTER_YING_ZI_ZHAN_SHI = 233; //影子战士
    public static final int MONSTER_MING_LING_MO_WANG_1 = 234;  //弱版冥灵魔王,位于第十八层
    public static final int MONSTER_MING_LING_MO_WANG_2 = 235;  //强化版冥灵魔王,位于第21层

    //NPC 类
    public static final int NPC_FAIRY_1 = 300;    //序章(第 0 层)中的仙子
    public static final int NPC_FAIRY_2 = 301;    //序章(第 0 层)中的仙子
    public static final int NPC_GO_UPSTAIRS = 302;  //上楼
    public static final int NPC_GO_DOWNSTAIRS = 303;    //下楼
    public static final int NPC_GATE_YELLOW = 304;  //黄色门
    public static final int NPC_GATE_BLUE = 305;    //蓝色门
    public static final int NPC_GATE_RED = 306; //红色门
    public static final int NPC_GATE_GREEN = 307;   //绿色门(第 2 层)
    public static final int NPC_GATE_IRON_OPEN = 308;   //可以打开的铁门,一碰即开
    public static final int NPC_GATE_IRON_CLOSE = 309;  //不可以打开的铁门或需要满足某个条件才能打开的铁门
    public static final int NPC_SHEN_MI_LAO_REN_FLOOR_2 = 310;  //第 2 层的神秘老人,对话获得钢剑,攻击+30
    public static final int NPC_SHANG_REN_FLOOR_2 = 311;    //第 2 层的商人,对话获得钢盾,防御+30
    public static final int NPC_SHANG_DIAN_LAO_BAN_SMALL1 = 312;
    public static final int NPC_SHANG_DIAN_LAO_BAN_SMALL2 = 313;    //第 3 层的商店老板,可以花费25金币购买800生命或4攻击或4防御
    public static final int NPC_SHANG_DIAN_LAO_BAN_SMALL3 = 314;
    public static final int NPC_THIEF = 315;    //第 4 层的小偷,对话可打开第 2 层的绿色门,后续获得第 12 层的嵌了红宝石的铁榔头后可打通第 18 层的路
    public static final int NPC_SHEN_MI_LAO_REN_FLOOR_5 = 316;  //第 5 层的神秘老人,可以花费100经验升1级或30经验+5攻击或30经验+5防御
    public static final int NPC_SHANG_REN_FLOOR_5 = 317;    ///第 5 层的商人,可以花费10金币购买1把黄钥匙或50金币购买1把蓝钥匙或100金币购买1把红钥匙
    public static final int NPC_SHANG_DIAN_LAO_BAN_BIG1 = 318;
    public static final int NPC_SHANG_DIAN_LAO_BAN_BIG2 = 319;  //第 11 层的商店老板,可以花费100金币购买4000生命或20攻击或20防御
    public static final int NPC_SHANG_DIAN_LAO_BAN_BIG3 = 320;
    public static final int NPC_SHANG_REN_FLOOR_12 = 321;    //第 12 层的商人,可以卖出1把黄钥匙获取7金币或卖出1把蓝钥匙获得35金币或卖出一把红钥匙获得70金币
    public static final int NPC_SHEN_MI_LAO_REN_FLOOR_13 = 322;    //第 13 层的神秘老人,可以花费270经验升3级或95经验+17攻击或95经验+17防御
    public static final int NPC_SHANG_REN_FLOOR_15 = 323;    //第 15 层的神秘老人,花费500经验换取圣光剑
    public static final int NPC_SHEN_MI_LAO_REN_FLOOR_15 = 324;    //第 15 层的商人,花费500金币换取星光盾
    public static final int NPC_PRINCESS = 325;    //第 18 层的公主

    public static final int PROP_KEY_YELLOW = 400;   //黄钥匙
    public static final int PROP_KEY_BLUE = 401; //蓝钥匙
    public static final int PROP_KEY_RED = 402;  //红钥匙
    public static final int PROP_XIE_PING_SMALL = 403;   //小血瓶,+200生命
    public static final int PROP_XIE_PING_BIG = 404; //大血瓶,+500生命
    public static final int PROP_BAO_SHI_RED = 405;  //红宝石,+3攻击
    public static final int PROP_BAO_SHI_BLUE = 406; //蓝宝石,+3防御
    public static final int PROP_SHENG_GUANG_HUI = 407;  //圣光徽,第 1 层,可查看怪物信息
    public static final int PROP_TIE_JIAN = 408; //铁剑,第 3 层,+10攻击
    public static final int PROP_TIE_DUN = 409;  //铁盾,第 5 层,+10防御
    public static final int PROP_YAO_SHI_HE = 410;   //钥匙盒,第 5 层,三色钥匙数量各+1
    public static final int PROP_XIAO_FEI_YU = 411;  //小飞羽,第 6 层,升 1 级
    public static final int PROP_JIN_KUAI = 412; //金块,第 6 层,金币+300
    public static final int PROP_XING_YUN_SHI_ZI_JIA = 413;   //幸运十字架,第 7 层,可交给序章中的仙子,增加一定属性
    public static final int PROP_FENG_ZHI_LUO_PAN = 414; //风之罗盘,第 9 层,可直接移动到任意去过的楼层
    public static final int PROP_QING_FENG_JIAN = 415;   //青锋剑,第 9 层,攻击+70
    public static final int PROP_HUANG_JIN_DUN = 416;    //黄金盾,第 11 层,防御+85
    public static final int PROP_XING_GUANG_SHEN_LANG = 417;    //星光神榔,第 12 层,交给第 4 层的小偷,可以打开第 18 层的隐藏地面,就可以救出公主了
    public static final int PROP_DA_FEI_YU = 418;    //大飞羽,第 13 层,升 3 级
    public static final int PROP_SHENG_SHUI = 419;    //圣水,第 14 层,生命值翻倍
    public static final int PROP_XING_GUANG_SHEN_JIAN = 420;    //星光神剑,第 19 层,攻击+150
    public static final int PROP_GUANG_MANG_SHEN_DUN = 421;    //光芒神盾,第 19 层,防御+150

    //勇士类
    public static final int WARRIOR_UP = 500;
    public static final int WARRIOR_DOWN = 501;
    public static final int WARRIOR_LEFT = 502;
    public static final int WARRIOR_RIGHT = 503;
    @DatabaseField(columnName = "floor", type = DatabaseField.TYPE.INTEGER)
    private int floor;
    @DatabaseField(columnName = "row", type = DatabaseField.TYPE.INTEGER)
    private int row;
    @DatabaseField(columnName = "column", type = DatabaseField.TYPE.INTEGER)
    private int column;
    @DatabaseField(columnName = "type", type = DatabaseField.TYPE.INTEGER)
    private int type;    //11*11 的格子内每一格的类型,1 开头为建筑类,2 开头为怪物类,3 开头为 NPC 类,4 开头为道具类,5 开头为勇士

    public CaseBean() {
    }

    public CaseBean(int floor, int row, int column, int type) {
        this.floor = floor;
        this.row = row;
        this.column = column;
        this.type = type;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "CaseBean{" +
                "floor=" + floor +
                ", row=" + row +
                ", column=" + column +
                ", type=" + type +
                '}';
    }

    public ABaseBean getSpecificEntity(int type) {
        return SpecificEntityFactory.getSpecificEntity(type);
    }

//    @Override
//    public void handleEvent(WarriorBean warrior) {
//        if (type == BUILDING_ROAD) {
//            type = warrior.getType();
//            resourceId = warrior.getResourceId();
//            MapManager.getInstance().setCase(new CaseBean(floor, warrior.getPosition().getRow(), warrior.getPosition().getColumn(), BUILDING_ROAD, R.drawable.building_road));
//        }
//    }
}
