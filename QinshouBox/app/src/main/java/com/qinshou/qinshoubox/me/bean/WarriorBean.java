package com.qinshou.qinshoubox.me.bean;


import android.support.v4.app.FragmentActivity;

import com.qinshou.networkmodule.rxbus.RxBus;
import com.qinshou.qinshoubox.R;
import com.qinshou.qinshoubox.me.util.MapManager;

/**
 * Description:勇士实体类
 * Created by 禽兽先生
 * Created on 2017/6/15
 */

public class WarriorBean extends ABaseBean {
    private Position mPosition;
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


    private WarriorBean() {
        super("勇士", CaseBean.WARRIOR_UP, R.drawable.warrior_up);
        mPosition = new Position(9, 5);
        level = 1;
        lifeValue = 1000;
        attackValue = 10;
        defenseValue = 10;
        money = 0;
        experience = 0;
        yellowKeyCount = 100;
        blueKeyCount = 100;
        redKeyCount = 100;
        hasShengGuangHui = false;
        hasFengZhiLuoPan = false;
        hasXingGuangShenLang = false;
    }


    public static WarriorBean getInstance() {
        return SingleHolder.singleton;
    }

    private static class SingleHolder {
        private static final WarriorBean singleton = new WarriorBean();
    }

    public static class Position {

        private int mRow;
        private int mColumn;

        public Position() {
        }

        public Position(int row, int column) {
            mRow = row;
            mColumn = column;
        }

        public int getRow() {
            return mRow;
        }

        public void setRow(int row) {
            mRow = row;
        }

        public int getColumn() {
            return mColumn;
        }

        public void setColumn(int column) {
            mColumn = column;
        }

        @Override
        public String toString() {
            return "勇士当前坐标{" +
                    "第" + mRow + "行" +
                    ", 第" + mColumn + "列" +
                    '}';
        }
    }

    public Position getPosition() {
        return mPosition;
    }

    public void setPosition(Position position) {
        mPosition = position;
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

    /**
     * author：MrQinshou
     * Description:获得一把黄钥匙
     * date:2018/11/29 20:43
     * param
     * return
     */
    public void obtainYellowKey() {
        setYellowKeyCount(getYellowKeyCount() + 1);
        RxBus.getInstance().post(this);
        RxBus.getInstance().post("获得 1 把黄钥匙。");
    }

    /**
     * author：MrQinshou
     * Description:获得一把蓝钥匙
     * date:2018/11/29 20:43
     * param
     * return
     */
    public void obtainBlueKey() {
        setBlueKeyCount(getBlueKeyCount() + 1);
        RxBus.getInstance().post(this);
        RxBus.getInstance().post("获得 1 把蓝钥匙。");
    }

    /**
     * author：MrQinshou
     * Description:获得一把红钥匙
     * date:2018/11/29 20:43
     * param
     * return
     */
    public void obtainRedKey() {
        setRedKeyCount(getRedKeyCount() + 1);
        RxBus.getInstance().post(this);
        RxBus.getInstance().post("获得 1 把红钥匙。");
    }

    /**
     * author：MrQinshou
     * Description:获得小血瓶
     * date:2018/11/29 21:02
     * param
     * return
     */
    public void obtainSmallBloodBottle() {
        setLifeValue(getLifeValue() + 200);
        RxBus.getInstance().post(this);
        RxBus.getInstance().post("获得小血瓶，生命 +200。");
    }

    /**
     * author：MrQinshou
     * Description:获得大血瓶
     * date:2018/11/29 21:02
     * param
     * return
     */
    public void obtainBigBloodBottle() {
        setLifeValue(getLifeValue() + 500);
        RxBus.getInstance().post(this);
        RxBus.getInstance().post("获得大血瓶，生命 +500。");
    }

    /**
     * author：MrQinshou
     * Description:获得红宝石
     * date:2018/11/29 22:16
     * param
     * return
     */
    public void obtainRedGem() {
        setAttackValue(getAttackValue() + 3);
        RxBus.getInstance().post(this);
        RxBus.getInstance().post("获得红宝石，攻击 +3。");
    }

    /**
     * author：MrQinshou
     * Description:获得蓝宝石
     * date:2018/11/29 22:16
     * param
     * return
     */
    public void obtainBlueGem() {
        setDefenseValue(getDefenseValue() + 3);
        RxBus.getInstance().post(this);
        RxBus.getInstance().post("获得蓝宝石，攻击 +3。");
    }

    /**
     * author：MrQinshou
     * Description:获得圣光徽
     * date:2018/11/29 22:20
     * param
     * return
     */
    public void obtainShengGuangHui() {
        setHasShengGuangHui(true);
        RxBus.getInstance().post(this);
        RxBus.getInstance().post("获得圣光徽，现在你可以查看当前所在楼层怪物信息。");
    }

    /**
     * author：MrQinshou
     * Description:获得铁剑
     * date:2018/11/29 22:20
     * param
     * return
     */
    public void obtainIronSword() {
        setAttackValue(getAttackValue() + 10);
        RxBus.getInstance().post(this);
        RxBus.getInstance().post("获得铁剑，攻击 +10。");
    }

    /**
     * author：MrQinshou
     * Description:获得铁盾
     * date:2018/11/29 22:20
     * param
     * return
     */
    public void obtainIronShield() {
        setDefenseValue(getDefenseValue() + 10);
        RxBus.getInstance().post(this);
        RxBus.getInstance().post("获得铁盾，防御 +10。");
    }

    /**
     * author：MrQinshou
     * Description:获得钥匙盒
     * date:2018/11/29 22:20
     * param
     * return
     */
    public void obtainKeyBox() {
        setYellowKeyCount(getYellowKeyCount() + 1);
        setBlueKeyCount(getBlueKeyCount() + 1);
        setRedKeyCount(getRedKeyCount() + 1);
        RxBus.getInstance().post(this);
        RxBus.getInstance().post("获得钥匙盒，所有钥匙数 +1。");
    }

    /**
     * author：MrQinshou
     * Description:获得小飞羽
     * date:2018/11/29 22:20
     * param
     * return
     */
    public void obtainSmallFlightFeather() {
        setLevel(getLevel() + 1);
        setLifeValue(getLifeValue() + 1000);
        setAttackValue(getAttackValue() + 7);
        setDefenseValue(getDefenseValue() + 7);
        RxBus.getInstance().post(this);
        RxBus.getInstance().post("获得小飞羽，等级 +1。");
    }

    /**
     * author：MrQinshou
     * Description:获得金块
     * date:2018/11/29 22:20
     * param
     * return
     */
    public void obtainGoldBullion() {
        setMoney(getMoney() + 300);
        RxBus.getInstance().post(this);
        RxBus.getInstance().post("获得金块，金币 +300。");
    }

    /**
     * author：MrQinshou
     * Description:获得幸运十字架
     * date:2018/11/29 22:20
     * param
     * return
     */
    public void obtainLuckyCross() {
        setHasLuckyCross(true);
        RxBus.getInstance().post(this);
        RxBus.getInstance().post("获得幸运十字架，把它交给序章中的仙子，可以增加一定属性哦。");
    }

    /**
     * author：MrQinshou
     * Description:获得风之罗盘
     * date:2018/11/29 22:20
     * param
     * return
     */
    public void obtainFengZhiLuoPan() {
        setHasFengZhiLuoPan(true);
        RxBus.getInstance().post(this);
        RxBus.getInstance().post("获得风之罗盘，现在你可以直接移动到任意去过的楼层。");
    }

    /**
     * author：MrQinshou
     * Description:获得青锋剑
     * date:2018/11/29 22:20
     * param
     * return
     */
    public void obtainQingFengSword() {
        setAttackValue(getAttackValue() + 70);
        RxBus.getInstance().post(this);
        RxBus.getInstance().post("获得青锋剑，攻击 +70。");
    }

    /**
     * author：MrQinshou
     * Description:获得黄金盾
     * date:2018/11/29 22:20
     * param
     * return
     */
    public void obtainGoldShield() {
        setDefenseValue(getDefenseValue() + 85);
        RxBus.getInstance().post(this);
        RxBus.getInstance().post("获得黄金盾，防御 +85。");
    }

    /**
     * author：MrQinshou
     * Description:获得星光神榔
     * date:2018/11/29 22:20
     * param
     * return
     */
    public void obtainXingGuangShenLang() {
        setHasXingGuangShenLang(true);
        RxBus.getInstance().post(this);
        RxBus.getInstance().post("获得星光神榔，把它交给第 4 层的小偷，就可以打开第 18 层的隐藏地面啦。");
    }

    /**
     * author：MrQinshou
     * Description:获得大飞羽
     * date:2018/11/29 22:20
     * param
     * return
     */
    public void obtainBigFlightFeather() {
//        setLevel(getLevel() + 3);
//        setLifeValue(getLifeValue() + 1000);
//        setAttackValue(getAttackValue() + 7);
//        setDefenseValue(getDefenseValue() + 7);
//        RxBus.getInstance().post(this);
//        RxBus.getInstance().post("获得大飞羽，等级 +3。");
    }

    /**
     * author：MrQinshou
     * Description:获得圣水
     * date:2018/11/29 22:20
     * param
     * return
     */
    public void obtainHolyWater() {
        setLifeValue(getLifeValue() * 2);
        RxBus.getInstance().post(this);
        RxBus.getInstance().post("获得圣水，生命值翻倍。");
    }

    /**
     * author：MrQinshou
     * Description:获得星光神剑
     * date:2018/11/29 22:20
     * param
     * return
     */
    public void obtainStarSword() {
        setAttackValue(getAttackValue() + 150);
        RxBus.getInstance().post(this);
        RxBus.getInstance().post("获得星光神剑，攻击 +150。");
    }

    /**
     * author：MrQinshou
     * Description:获得光芒神盾
     * date:2018/11/29 22:20
     * param
     * return
     */
    public void obtainLightShield() {
        setDefenseValue(getDefenseValue() + 150);
        RxBus.getInstance().post(this);
        RxBus.getInstance().post("获得光芒神盾，防御 +150。");
    }


    /**
     * author：MrQinshou
     * Description:升 1 级
     * date:2018/11/29 20:40
     * param
     * return
     */
    public void levelUp() {
        if (getExperience() >= 100) {
            setLevel(getLevel() + 1);
            setLifeValue(getLifeValue() + 1000);
            setAttackValue(getAttackValue() + 7);
            setDefenseValue(getDefenseValue() + 7);
            setExperience(getExperience() - 100);
            RxBus.getInstance().post(this);
        } else {
            RxBus.getInstance().post("经验不足");
        }
    }

    /**
     * author：MrQinshou
     * Description:用 30 经验值来提升 5 攻击力
     * date:2018/11/29 20:40
     * param
     * return
     */
    public void improveAttackValueWith30Experience() {
        if (getExperience() >= 30) {
            setAttackValue(getAttackValue() + 5);
            setExperience(getExperience() - 30);
            RxBus.getInstance().post(this);
        } else {
            RxBus.getInstance().post("经验不足");
        }
    }

    /**
     * author：MrQinshou
     * Description:用 30 经验值来提升 5 防御力
     * date:2018/11/29 20:40
     * param
     * return
     */
    public void improveDefenseValueWith30Experience() {
        if (getExperience() >= 30) {
            setDefenseValue(getDefenseValue() + 5);
            setExperience(getExperience() - 30);
            RxBus.getInstance().post(this);
        } else {
            RxBus.getInstance().post("经验不足");
        }
    }

    public void buyYellowKeyWithMoney() {
        if (getMoney() >= 10) {
            setYellowKeyCount(getYellowKeyCount() + 1);
            setMoney(getMoney() - 10);
        }
    }

    public void buyBlueKeyWithMoney() {
        if (getMoney() >= 50) {
            setBlueKeyCount(getBlueKeyCount() + 1);
            setMoney(getMoney() - 50);
        }
    }

    public void obtainKeyRedWithmMoney() {
        if (getMoney() >= 10) {
            setRedKeyCount(getRedKeyCount() + 1);
            setMoney(getMoney() - 100);
        }
    }

    public void improvemLifeValueWith100mMoney() {
        if (getMoney() >= 100) {
            setLifeValue(getLifeValue() + 4000);
            setMoney(getMoney() - 100);
        }
    }

    public void improvemAttackValueWith100mMoney() {
        if (getMoney() >= 100) {
            setAttackValue(getAttackValue() + 20);
            setMoney(getMoney() - 100);
        }
    }

    public void improvemDefenseValueWith100mMoney() {
        if (getMoney() >= 100) {
            setDefenseValue(getDefenseValue() + 20);
            setMoney(getMoney() - 100);
        }
    }

    @Override
    public boolean handleEvent(FragmentActivity activity, CaseBean fromCase, CaseBean toCase) {
        return false;
    }

    public void moveUp(FragmentActivity activity) {
        if (mPosition.mRow == 0) {
            return;
        }
        setType(CaseBean.WARRIOR_UP);
        setResourceId(R.drawable.warrior_up);
        CaseBean fromCase = MapManager.getInstance().getCase(mPosition.mRow, mPosition.mColumn);
        CaseBean toCase = MapManager.getInstance().getCase(mPosition.mRow - 1, mPosition.mColumn);
        ABaseBean ABaseBean = toCase.getSpecificEntity(toCase.getType());
        if (ABaseBean.handleEvent(activity, fromCase, toCase)) {
            mPosition.mRow--;
        }
        RxBus.getInstance().post(this);
    }

    public void moveDown(FragmentActivity activity) {
        if (mPosition.mRow == 10) {
            return;
        }
        setType(CaseBean.WARRIOR_DOWN);
        setResourceId(R.drawable.warrior_down);
        CaseBean fromCase = MapManager.getInstance().getCase(mPosition.mRow, mPosition.mColumn);
        CaseBean toCase = MapManager.getInstance().getCase(mPosition.mRow + 1, mPosition.mColumn);
        ABaseBean ABaseBean = toCase.getSpecificEntity(toCase.getType());
        if (ABaseBean.handleEvent(activity, fromCase, toCase)) {
            mPosition.mRow++;
        }
        RxBus.getInstance().post(this);
    }

    public void moveLeft(FragmentActivity activity) {
        if (mPosition.mColumn == 0) {
            return;
        }
        setType(CaseBean.WARRIOR_LEFT);
        setResourceId(R.drawable.warrior_left);
        CaseBean fromCase = MapManager.getInstance().getCase(mPosition.mRow, mPosition.mColumn);
        CaseBean toCase = MapManager.getInstance().getCase(mPosition.mRow, mPosition.mColumn - 1);
        ABaseBean ABaseBean = toCase.getSpecificEntity(toCase.getType());
        if (ABaseBean.handleEvent(activity, fromCase, toCase)) {
            mPosition.mColumn--;
        }
        RxBus.getInstance().post(this);
    }

    public void moveRight(FragmentActivity activity) {
        if (mPosition.mColumn == 10) {
            return;
        }
        setType(CaseBean.WARRIOR_RIGHT);
        setResourceId(R.drawable.warrior_right);
        CaseBean fromCase = MapManager.getInstance().getCase(mPosition.mRow, mPosition.mColumn);
        CaseBean toCase = MapManager.getInstance().getCase(mPosition.mRow, mPosition.mColumn + 1);
        ABaseBean ABaseBean = toCase.getSpecificEntity(toCase.getType());
        if (ABaseBean.handleEvent(activity, fromCase, toCase)) {
            mPosition.mColumn++;
        }
        RxBus.getInstance().post(this);
    }

    @Override
    public String toString() {
        return "勇士信息{" +
                "当前坐标:" + mPosition +
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
}
