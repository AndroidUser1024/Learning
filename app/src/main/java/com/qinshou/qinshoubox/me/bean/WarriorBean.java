package com.qinshou.qinshoubox.me.bean;


import androidx.annotation.DrawableRes;

import com.qinshou.qinshoubox.R;
import com.qinshou.qinshoubox.me.enums.Type;
import com.qinshou.qinshoubox.me.enums.Warrior;

import java.util.Observable;


/**
 * Description:勇士实体类
 * Created by 禽兽先生
 * Created on 2017/6/15
 */

public class WarriorBean extends Observable {
    private String name;
    private Type type;
    @DrawableRes
    private int resourceId;
    private int level;
    private int lifeValue;
    private int attackValue;
    private int defenseValue;
    private int money;
    private int experience;
    private int yellowKeyCount;
    private int blueKeyCount;
    private int redKeyCount;
    private boolean hasShengGuangHui;
    private boolean hasFengZhiLuoPan;
    private boolean hasXingGuangShenLang;
    private boolean hasLuckyCross;
    private Position position;


    private WarriorBean() {
        name = "勇士";
        type = Warrior.UP;
        resourceId = R.drawable.magic_tower_warrior_up;
        level = 1;
        lifeValue = 1000;
        attackValue = 10;
        defenseValue = 10;
        money = 0;
        experience = 0;
        yellowKeyCount = 0;
        blueKeyCount = 0;
        redKeyCount = 0;
        hasShengGuangHui = false;
        hasFengZhiLuoPan = false;
        hasXingGuangShenLang = false;
        position = new Position(9, 5);
    }

    public static class Position {

        private int row;
        private int column;

        public Position() {
        }

        public Position(int row, int column) {
            this.row = row;
            this.column = column;
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

        @Override
        public String toString() {
            return "勇士当前坐标{" +
                    "第" + row + "行" +
                    ", 第" + column + "列" +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "勇士信息{" +
                "当前坐标:" + position +
                ", 等级:" + level +
                ", 生命值:" + lifeValue +
                ", 攻击:" + attackValue +
                ", 防御:" + defenseValue +
                ", 金钱:" + money +
                ", 经验:" + experience +
                ", 黄钥匙数量:" + yellowKeyCount +
                ", 蓝钥匙数量:" + blueKeyCount +
                ", 红钥匙数量:" + redKeyCount +
                ", 是否拥有圣光徽:" + hasShengGuangHui +
                ", 是否拥有风之罗盘:" + hasFengZhiLuoPan +
                ", 是否拥有星光神榔:" + hasXingGuangShenLang +
                ", 是否拥有幸运十字架:" + hasLuckyCross +
                '}';
    }

    public static WarriorBean getInstance() {
        return SingleHolder.singleton;
    }

    private static class SingleHolder {
        private static final WarriorBean singleton = new WarriorBean();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public int getResourceId() {
        return resourceId;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int mLevel) {
        this.level = mLevel;
    }

    public int getLifeValue() {
        return lifeValue;
    }

    public void setLifeValue(int mLifeValue) {
        this.lifeValue = mLifeValue;
    }

    public int getAttackValue() {
        return attackValue;
    }

    public void setAttackValue(int mAttackValue) {
        this.attackValue = mAttackValue;
    }

    public int getDefenseValue() {
        return defenseValue;
    }

    public void setDefenseValue(int mDefenseValue) {
        this.defenseValue = mDefenseValue;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int mMoney) {
        this.money = mMoney;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int mExperience) {
        this.experience = mExperience;
    }

    public int getYellowKeyCount() {
        return yellowKeyCount;
    }

    public void setYellowKeyCount(int mYellowKeyCount) {
        this.yellowKeyCount = mYellowKeyCount;
    }

    public int getBlueKeyCount() {
        return blueKeyCount;
    }

    public void setBlueKeyCount(int mBlueKeyCount) {
        this.blueKeyCount = mBlueKeyCount;
    }

    public int getRedKeyCount() {
        return redKeyCount;
    }

    public void setRedKeyCount(int mRedKeyCount) {
        this.redKeyCount = mRedKeyCount;
    }

    public boolean isHasShengGuangHui() {
        return hasShengGuangHui;
    }

    public void setHasShengGuangHui(boolean hasShengGuangHui) {
        this.hasShengGuangHui = hasShengGuangHui;
    }

    public boolean isHasFengZhiLuoPan() {
        return hasFengZhiLuoPan;
    }

    public void setHasFengZhiLuoPan(boolean hasFengZhiLuoPan) {
        this.hasFengZhiLuoPan = hasFengZhiLuoPan;
    }

    public boolean isHasXingGuangShenLang() {
        return hasXingGuangShenLang;
    }

    public void setHasXingGuangShenLang(boolean hasXingGuangShenLang) {
        this.hasXingGuangShenLang = hasXingGuangShenLang;
    }

    public boolean isHasLuckyCross() {
        return hasLuckyCross;
    }

    public void setHasLuckyCross(boolean hasLuckyCross) {
        this.hasLuckyCross = hasLuckyCross;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    /**
     * Author: QinHao
     * Email:cqflqinhao@126.com
     * Date:2019/10/9 18:09
     * Description:像观察者们发送更新通知
     */
    public void update() {
        // 标识状态或内容发生改变
        setChanged();
        // 通知所有观察者
        notifyObservers();
    }

    /**
     * author：MrQinshou
     * Description:获得一把黄钥匙
     * date:2018/11/29 20:43
     * param
     * return
     */
    public void obtainYellowKey() {
        yellowKeyCount++;
        update();
    }

    /**
     * author：MrQinshou
     * Description:获得一把蓝钥匙
     * date:2018/11/29 20:43
     * param
     * return
     */
    public void obtainBlueKey() {
        blueKeyCount++;
        update();
    }

    /**
     * author：MrQinshou
     * Description:获得一把红钥匙
     * date:2018/11/29 20:43
     * param
     * return
     */
    public void obtainRedKey() {
        redKeyCount++;
        update();
    }

    /**
     * Author: QinHao
     * Email:cqflqinhao@126.com
     * Date:2019/10/9 19:20
     * Description:失去一把黄钥匙
     */
    public void loseYellowKey() {
        yellowKeyCount--;
        update();
    }

    /**
     * Author: QinHao
     * Email:cqflqinhao@126.com
     * Date:2019/10/9 19:21
     * Description:失去一把蓝钥匙
     */
    public void loseBlueKey() {
        blueKeyCount--;
        update();
    }

    /**
     * Author: QinHao
     * Email:cqflqinhao@126.com
     * Date:2019/10/9 19:21
     * Description:失去一把红钥匙
     */
    public void loseRedKey() {
        redKeyCount--;
        update();
    }

    public void beatMonster(int loseLifeValue, int experience, int money) {
        lifeValue -= loseLifeValue;
        this.experience += experience;
        this.money += money;
        update();
    }

    /**
     * Author: QinHao
     * Email:cqflqinhao@126.com
     * Date:2019/10/10 9:30
     * Description:获得小血瓶
     */
    public void obtainSmallBloodBottle() {
        lifeValue += 200;
        update();
    }

    /**
     * Author: QinHao
     * Email:cqflqinhao@126.com
     * Date:2019/10/10 9:30
     * Description:获得大血瓶
     */
    public void obtainBigBloodBottle() {
        lifeValue += 500;
        update();
    }

    /**
     * Author: QinHao
     * Email:cqflqinhao@126.com
     * Date:2019/10/10 9:31
     * Description:获得红宝石
     */
    public void obtainRedGem() {
        attackValue += 3;
        update();
    }

    /**
     * Author: QinHao
     * Email:cqflqinhao@126.com
     * Date:2019/10/10 9:31
     * Description:获得蓝宝石
     */
    public void obtainBlueGem() {
        defenseValue += 3;
        update();
    }

    /**
     * Author: QinHao
     * Email:cqflqinhao@126.com
     * Date:2019/10/10 9:32
     * <p>
     * <p>
     * Description:获得蓝宝石
     */
    public void obtainShengGuangHui() {
        hasShengGuangHui = true;
        update();
    }

    /**
     * Author: QinHao
     * Email:cqflqinhao@126.com
     * Date:2019/10/10 9:45
     * Description:获得铁剑
     */
    public void obtainIronSword() {
        attackValue += 10;
        update();
    }

    /**
     * Author: QinHao
     * Email:cqflqinhao@126.com
     * Date:2019/10/10 9:45
     * Description:获得铁盾
     */
    public void obtainIronShield() {
        defenseValue += 10;
        update();
    }

    /**
     * Author: QinHao
     * Email:cqflqinhao@126.com
     * Date:2019/10/10 11:35
     * Description:获得钢剑
     */
    public void obtainSteelSword() {
        attackValue += 30;
        update();
    }

    /**
     * Author: QinHao
     * Email:cqflqinhao@126.com
     * Date:2019/10/10 11:35
     * Description:获得钢盾
     */
    public void obtainSteelShield() {
        defenseValue += 30;
        update();
    }

    /**
     * Author: QinHao
     * Email:cqflqinhao@126.com
     * Date:2019/10/10 11:46
     * Description:用 25 金币购买 800 生命值
     */
    public void buy800LifeValueWith25Money() {
        if (money < 25) {
            return;
        }
        lifeValue += 800;
        money -= 25;
        update();
    }

    /**
     * Author: QinHao
     * Email:cqflqinhao@126.com
     * Date:2019/10/10 11:48
     * Description:用 25 金币购买 4 攻击
     */
    public void buy4AttackValueWith25Money() {
        if (money < 25) {
            return;
        }
        attackValue += 4;
        money -= 25;
        update();
    }

    /**
     * Author: QinHao
     * Email:cqflqinhao@126.com
     * Date:2019/10/10 11:48
     * Description:用 25 金币购买 4 防御
     */
    public void buy4DefenseValueWith25Money() {
        if (money < 25) {
            return;
        }
        defenseValue += 4;
        money -= 25;
        update();
    }

    /**
     * Author: QinHao
     * Email:cqflqinhao@126.com
     * Date:2019/10/10 16:38
     * Description:获得钥匙盒
     */
    public void obtainKeyBox() {
        yellowKeyCount++;
        blueKeyCount++;
        redKeyCount++;
        update();
    }


    /**
     * Author: QinHao
     * Email:cqflqinhao@126.com
     * Date:2019/10/10 16:46
     * Description:升 1 级
     */
    public void levelUp() {
        if (experience < 100) {
            return;
        }
        level++;
        lifeValue += 1000;
        attackValue += 7;
        defenseValue += 7;
        experience -= 100;
        update();
    }

    /**
     * Author: QinHao
     * Email:cqflqinhao@126.com
     * Date:2019/10/10 16:46
     * Description:用 30 经验值来提升 5 攻击力
     */
    public void buy5AttackValueWith30Experience() {
        if (experience < 30) {
            return;
        }
        attackValue += 5;
        experience -= 30;
        update();
    }

    /**
     * Author: QinHao
     * Email:cqflqinhao@126.com
     * Date:2019/10/10 16:45
     * Description:用 30 经验值来提升 5 防御力
     */
    public void buy5DefenseValueWith30Experience() {
        if (experience < 30) {
            return;
        }
        defenseValue += 5;
        experience -= 30;
        update();
    }

    /**
     * Author: QinHao
     * Email:cqflqinhao@126.com
     * Date:2019/10/10 16:48
     * Description:使用 10 金币购买 1 把黄钥匙
     */
    public boolean buyYellowKeyWith10Money() {
        if (money < 10) {
            return false;
        }
        yellowKeyCount++;
        money -= 10;
        update();
        return true;
    }

    /**
     * Author: QinHao
     * Email:cqflqinhao@126.com
     * Date:2019/10/10 16:48
     * Description:使用 50 金币购买1 把蓝钥匙
     */
    public boolean buyBlueKeyWith50Money() {
        if (money < 50) {
            return false;
        }
        blueKeyCount++;
        money -= 50;
        update();
        return true;
    }

    /**
     * Author: QinHao
     * Email:cqflqinhao@126.com
     * Date:2019/10/10 16:48
     * Description:使用 100 金币购买 1 把红钥匙
     */
    public boolean buyKeyRedWith100Money() {
        if (money < 100) {
            return false;
        }
        redKeyCount++;
        money -= 100;
        update();
        return true;
    }

    /**
     * Author: QinHao
     * Email:cqflqinhao@126.com
     * Date:2019/10/10 16:54
     * Description:获得小飞羽
     */
    public void obtainSmallFlightFeather() {
        level++;
        lifeValue += 1000;
        attackValue += 7;
        defenseValue += 7;
        update();
    }

    /**
     * Author: QinHao
     * Email:cqflqinhao@126.com
     * Date:2019/10/10 16:59
     * Description:获得金块
     */
    public void obtainGoldBullion() {
        money += 300;
        update();
    }

    /**
     * Author: QinHao
     * Email:cqflqinhao@126.com
     * Date:2019/10/10 17:34
     * Description:获得幸运十字架
     */
    public void obtainLuckyCross() {
        hasLuckyCross = true;
        update();
    }

    /**
     * Author: QinHao
     * Email:cqflqinhao@126.com
     * Date:2019/10/12 17:25
     * Description:获得风之罗盘
     */
    public void obtainWindCompass() {
        hasFengZhiLuoPan = true;
        update();
    }

    /**
     * Author: QinHao
     * Email:cqflqinhao@126.com
     * Date:2019/10/12 17:25
     * Description:获得青锋剑
     */
    public void obtainQingFengSword() {
        defenseValue += 85;
        update();
    }

    /**
     * Author: QinHao
     * Email:cqflqinhao@126.com
     * Date:2019/10/12 19:30
     * Description:获得黄金盾
     */
    public void obtainGoldShield() {
        attackValue += 70;
        update();
    }

    /**
     * Author: QinHao
     * Email:cqflqinhao@126.com
     * Date:2019/10/12 19:08
     * Description:用 100 金币购买 800 生命值
     */
    public boolean buy4000LifeValueWith100Money() {
        if (money < 100) {
            return false;
        }
        lifeValue += 4000;
        money -= 100;
        update();
        return true;
    }

    /**
     * Author: QinHao
     * Email:cqflqinhao@126.com
     * Date:2019/10/12 19:08
     * Description:用 100 金币购买 4 攻击
     */
    public boolean buy20AttackValueWith100Money() {
        if (money < 100) {
            return false;
        }
        attackValue += 20;
        money -= 100;
        update();
        return true;
    }

    /**
     * Author: QinHao
     * Email:cqflqinhao@126.com
     * Date:2019/10/12 19:08
     * Description:用 100 金币购买 20 防御
     */
    public boolean buy20DefenseValueWith100Money() {
        if (money < 100) {
            return false;
        }
        defenseValue += 20;
        money -= 100;
        update();
        return true;
    }

    /**
     * Author: QinHao
     * Email:cqflqinhao@126.com
     * Date:2019/10/12 19:24
     * Description:卖出 1 把黄钥匙得到 7 金币
     */
    public boolean sellYellowKeyFor7Money() {
        if (yellowKeyCount == 0) {
            return false;
        }
        yellowKeyCount--;
        money += 7;
        update();
        return true;
    }

    /**
     * Author: QinHao
     * Email:cqflqinhao@126.com
     * Date:2019/10/12 19:24
     * Description:卖出 1 把蓝钥匙得到 35 金币
     */
    public boolean sellBlueKeyFor35Money() {
        if (blueKeyCount == 0) {
            return false;
        }
        blueKeyCount--;
        money += 35;
        update();
        return true;
    }

    /**
     * Author: QinHao
     * Email:cqflqinhao@126.com
     * Date:2019/10/12 19:24
     * Description:卖出 1 把红钥匙得到 70 金币
     */
    public boolean sellRedKeyFor70Money() {
        if (redKeyCount == 0) {
            return false;
        }
        redKeyCount--;
        money += 70;
        update();
        return true;
    }

    /**
     * Author: QinHao
     * Email:cqflqinhao@126.com
     * Date:2019/10/12 19:30
     * Description:获得星光神榔
     */
    public void obtainStarlightGodHammer() {
        hasXingGuangShenLang = true;
        update();
    }

    /**
     * Author: QinHao
     * Email:cqflqinhao@126.com
     * Date:2019/10/13 10:22
     * Description:升 3 级
     */
    public boolean levelUp3() {
        if (experience < 270) {
            return false;
        }
        level += 3;
        lifeValue += 3000;
        attackValue += 21;
        defenseValue += 21;
        experience -= 270;
        update();
        return true;
    }

    /**
     * Author: QinHao
     * Email:cqflqinhao@126.com
     * Date:2019/10/13 10:22
     * Description:用 395 经验 +17 攻击
     */
    public boolean buy17AttackValueWith95Experience() {
        if (experience < 95) {
            return false;
        }
        attackValue += 17;
        experience -= 95;
        update();
        return true;
    }

    /**
     * Author: QinHao
     * Email:cqflqinhao@126.com
     * Date:2019/10/13 10:22
     * Description:用 95 经验 +17 防御
     */
    public boolean buy17DefenseValueWith95Experience() {
        if (experience < 95) {
            return false;
        }
        defenseValue += 17;
        experience -= 95;
        update();
        return true;
    }

    /**
     * Author: QinHao
     * Email:cqflqinhao@126.com
     * Date:2019/10/13 10:23
     * Description:获得小飞羽
     */
    public void obtainBigFlightFeather() {
        level += 3;
        lifeValue += 3000;
        attackValue += 21;
        defenseValue += 21;
        update();
    }

    /**
     * Author: QinHao
     * Email:cqflqinhao@126.com
     * Date:2019/10/13 10:35
     * Description:获得圣水
     */
    public void obtainHolyWater() {
        lifeValue *= 2;
        update();
    }

    /**
     * Author: QinHao
     * Email:cqflqinhao@126.com
     * Date:2019/10/13 13:35
     * Description:获得圣光剑
     */
    public boolean obtainHolyLightSword() {
        if (experience < 500) {
            return false;
        }
        experience -= 500;
        attackValue += 100;
        update();
        return true;
    }

    /**
     * Author: QinHao
     * Email:cqflqinhao@126.com
     * Date:2019/10/13 13:35
     * Description:获得星光盾
     */
    public boolean obtainStarLightShield() {
        if (money < 500) {
            return false;
        }
        money -= 500;
        attackValue += 100;
        update();
        return true;
    }

    /**
     * Author: QinHao
     * Email:cqflqinhao@126.com
     * Date:2019/10/13 13:43
     * Description:获得星光神剑
     */
    public void obtainStarLightGodSword() {
        attackValue += 150;
        update();
    }

    /**
     * Author: QinHao
     * Email:cqflqinhao@126.com
     * Date:2019/10/13 13:44
     * Description:获得光芒神盾
     */
    public void obtainLightGodShield() {
        defenseValue += 150;
        update();
    }

    /**
     * Author: QinHao
     * Email:cqflqinhao@126.com
     * Date:2019/10/15 19:33
     * Description:把幸运十字架给仙子
     */
    public boolean giveLuckyCross2Fairy() {
        if (!hasLuckyCross) {
            return false;
        }
        lifeValue *= 4 / 3;
        attackValue *= 4 / 3;
        defenseValue *= 4 / 3;
        hasLuckyCross = false;
        return true;

    }
//
//    /**
//     * author：MrQinshou
//     * Description:获得黄金盾
//     * date:2018/11/29 22:20
//     * param
//     * return
//     */
//    public void obtainGoldShield() {
//        setDefenseValue(getDefenseValue() + 85);
//        RxBus.getInstance().post(this);
//        RxBus.getInstance().post("获得黄金盾，防御 +85。");
//    }
//
//    /**
//     * author：MrQinshou
//     * Description:获得星光神榔
//     * date:2018/11/29 22:20
//     * param
//     * return
//     */
//    public void obtainXingGuangShenLang() {
//        setHasXingGuangShenLang(true);
//        RxBus.getInstance().post(this);
//        RxBus.getInstance().post("获得星光神榔，把它交给第 4 层的小偷，就可以打开第 18 层的隐藏地面啦。");
//    }
//
//    /**
//     * author：MrQinshou
//     * Description:获得大飞羽
//     * date:2018/11/29 22:20
//     * param
//     * return
//     */
//    public void obtainBigFlightFeather() {
////        setLevel(getLevel() + 3);
////        setLifeValue(getLifeValue() + 1000);
////        setAttackValue(getAttackValue() + 7);
////        setDefenseValue(getDefenseValue() + 7);
////        RxBus.getInstance().post(this);
////        RxBus.getInstance().post("获得大飞羽，等级 +3。");
//    }
//
//    /**
//     * author：MrQinshou
//     * Description:获得圣水
//     * date:2018/11/29 22:20
//     * param
//     * return
//     */
//    public void obtainHolyWater() {
//        setLifeValue(getLifeValue() * 2);
//        RxBus.getInstance().post(this);
//        RxBus.getInstance().post("获得圣水，生命值翻倍。");
//    }
//
//    /**
//     * author：MrQinshou
//     * Description:获得星光神剑
//     * date:2018/11/29 22:20
//     * param
//     * return
//     */
//    public void obtainStarSword() {
//        setAttackValue(getAttackValue() + 150);
//        RxBus.getInstance().post(this);
//        RxBus.getInstance().post("获得星光神剑，攻击 +150。");
//    }
//
//    /**
//     * author：MrQinshou
//     * Description:获得光芒神盾
//     * date:2018/11/29 22:20
//     * param
//     * return
//     */
//    public void obtainLightShield() {
//        setDefenseValue(getDefenseValue() + 150);
//        RxBus.getInstance().post(this);
//        RxBus.getInstance().post("获得光芒神盾，防御 +150。");
//    }
//
//
//
//    public void improvemLifeValueWith100mMoney() {
//        if (getMoney() >= 100) {
//            setLifeValue(getLifeValue() + 4000);
//            setMoney(getMoney() - 100);
//        }
//    }
//
//    public void improvemAttackValueWith100mMoney() {
//        if (getMoney() >= 100) {
//            setAttackValue(getAttackValue() + 20);
//            setMoney(getMoney() - 100);
//        }
//    }
//
//    public void improvemDefenseValueWith100mMoney() {
//        if (getMoney() >= 100) {
//            setDefenseValue(getDefenseValue() + 20);
//            setMoney(getMoney() - 100);
//        }
//    }
//
//    @Override
//    public boolean handleEvent(FragmentActivity activity, CaseBean fromCase, CaseBean toCase) {
//        return false;
//    }
//
//    public void moveUp(FragmentActivity activity) {
//        if (position.row == 0) {
//            return;
//        }
//        setType(CaseBean.WARRIOR_UP);
//        setResourceId(R.drawable.warrior_up);
//        CaseBean fromCase = MapManager.getInstance().getCase(position.row, position.column);
//        CaseBean toCase = MapManager.getInstance().getCase(position.row - 1, position.column);
//        AbsBean AbsBean = toCase.getSpecificEntity(toCase.getType());
//        if (AbsBean.handleEvent(activity, fromCase, toCase)) {
//            position.row--;
//        }
//        RxBus.getInstance().post(this);
//    }
//
//    public void moveDown(FragmentActivity activity) {
//        if (position.row == 10) {
//            return;
//        }
//        setType(CaseBean.WARRIOR_DOWN);
//        setResourceId(R.drawable.warrior_down);
//        CaseBean fromCase = MapManager.getInstance().getCase(position.row, position.column);
//        CaseBean toCase = MapManager.getInstance().getCase(position.row + 1, position.column);
//        AbsBean AbsBean = toCase.getSpecificEntity(toCase.getType());
//        if (AbsBean.handleEvent(activity, fromCase, toCase)) {
//            position.row++;
//        }
//        RxBus.getInstance().post(this);
//    }
//
//    public void moveLeft(FragmentActivity activity) {
//        if (position.column == 0) {
//            return;
//        }
//        setType(CaseBean.WARRIOR_LEFT);
//        setResourceId(R.drawable.warrior_left);
//        CaseBean fromCase = MapManager.getInstance().getCase(position.row, position.column);
//        CaseBean toCase = MapManager.getInstance().getCase(position.row, position.column - 1);
//        AbsBean AbsBean = toCase.getSpecificEntity(toCase.getType());
//        if (AbsBean.handleEvent(activity, fromCase, toCase)) {
//            position.column--;
//        }
//        RxBus.getInstance().post(this);
//    }
//
//    public void moveRight(FragmentActivity activity) {
//        if (position.column == 10) {
//            return;
//        }
//        setType(CaseBean.WARRIOR_RIGHT);
//        setResourceId(R.drawable.warrior_right);
//        CaseBean fromCase = MapManager.getInstance().getCase(position.row, position.column);
//        CaseBean toCase = MapManager.getInstance().getCase(position.row, position.column + 1);
//        AbsBean AbsBean = toCase.getSpecificEntity(toCase.getType());
//        if (AbsBean.handleEvent(activity, fromCase, toCase)) {
//            position.column++;
//        }
//        RxBus.getInstance().post(this);
//    }

}
