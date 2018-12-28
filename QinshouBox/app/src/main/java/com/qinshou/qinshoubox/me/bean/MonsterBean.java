package com.qinshou.qinshoubox.me.bean;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.app.FragmentActivity;

import com.qinshou.networkmodule.rxbus.RxBus;
import com.qinshou.qinshoubox.me.ui.dialog.BattleDialogFragment;
import com.qinshou.qinshoubox.me.util.MapManager;

/**
 * Description:怪物实体类
 * Created by 禽兽先生
 * Created on 2017/6/17
 */

public class MonsterBean extends ABaseBean implements Parcelable, Cloneable {
    private int mLifeValue;
    private int mAttackValue;
    private int mDefenseValue;
    private int mMoney;
    private int mExperience;

    public MonsterBean() {
    }

    protected MonsterBean(Parcel in) {
        super(in.readString(), in.readInt(), in.readInt());
        mLifeValue = in.readInt();
        mAttackValue = in.readInt();
        mDefenseValue = in.readInt();
        mMoney = in.readInt();
        mExperience = in.readInt();
    }

    public MonsterBean(String name, int type, int resourceID, int lifeValue, int attackValue, int defenseValue, int money, int experience) {
        super(name, type, resourceID);
        this.mLifeValue = lifeValue;
        this.mAttackValue = attackValue;
        this.mDefenseValue = defenseValue;
        this.mMoney = money;
        this.mExperience = experience;
    }

    public int getLifeValue() {
        return mLifeValue;
    }

    public void setLifeValue(int lifeValue) {
        this.mLifeValue = lifeValue;
    }

    public int getAttackValue() {
        return mAttackValue;
    }

    public void setAttackValue(int attackValue) {
        this.mAttackValue = attackValue;
    }

    public int getDefenseValue() {
        return mDefenseValue;
    }

    public void setDefenseValue(int defenseValue) {
        this.mDefenseValue = defenseValue;
    }

    public int getMoney() {
        return mMoney;
    }

    public void setMoney(int money) {
        this.mMoney = money;
    }

    public int getExperience() {
        return mExperience;
    }

    public void setExperience(int experience) {
        this.mExperience = experience;
    }

    @Override
    public String toString() {
        return "MonsterBean:" +
                "名字:" + getName() +
                ", 生命:" + mLifeValue +
                ", 攻击:" + mAttackValue +
                ", 防御:" + mDefenseValue +
                ", 金钱:" + mMoney +
                ", 经验:" + mExperience;
    }

    @Override
    public boolean handleEvent(FragmentActivity activity, CaseBean fromCase, CaseBean toCase) {
        WarriorBean warriorEntity = WarriorBean.getInstance();
        int monsterEachBoutLossLifeValue = warriorEntity.getAttackValue() - mDefenseValue > 0
                ? warriorEntity.getAttackValue() - mDefenseValue
                : 0;
        if (monsterEachBoutLossLifeValue == 0) {
            RxBus.getInstance().post("打不过啊,兄dei,人家一点血不掉");
            return false;
        }
        int warriorEachBoutLossLifeValue = mAttackValue - warriorEntity.getDefenseValue() > 0
                ? mAttackValue - warriorEntity.getDefenseValue()
                : 0;
        //向上取整
        int bout = (int) Math.ceil((double) mLifeValue / (double) monsterEachBoutLossLifeValue);
        int warriorTotalLossLifeValue = warriorEachBoutLossLifeValue * bout;
        if (warriorEntity.getLifeValue() <= warriorTotalLossLifeValue) {
            RxBus.getInstance().post("打是打得动,但是打着打着你就死了啊,兄dei");
            return false;
        }
        BattleDialogFragment.newInstance(this).show(activity.getSupportFragmentManager(), "battleDialogFragment");
        toCase.setType(CaseBean.BUILDING_ROAD);
        MapManager.getInstance().setCase(toCase.getRow(), toCase.getColumn(), toCase);
        MapManager.getInstance().updateUI(toCase);
        warriorEntity.setLifeValue(warriorEntity.getLifeValue() - warriorTotalLossLifeValue);
        warriorEntity.setExperience(warriorEntity.getExperience() + mExperience);
        warriorEntity.setMoney(warriorEntity.getMoney() + mMoney);
        return false;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(getName());
        dest.writeInt(getType());
        dest.writeInt(getResourceId());
        dest.writeInt(mLifeValue);
        dest.writeInt(mAttackValue);
        dest.writeInt(mDefenseValue);
        dest.writeInt(mMoney);
        dest.writeInt(mExperience);
    }

    public static final Creator<MonsterBean> CREATOR = new Creator<MonsterBean>() {
        @Override
        public MonsterBean createFromParcel(Parcel in) {
            return new MonsterBean(in);
        }

        @Override
        public MonsterBean[] newArray(int size) {
            return new MonsterBean[size];
        }
    };

    @Override
    public MonsterBean clone() {
        try {
            MonsterBean monster = (MonsterBean) super.clone();
            monster.mLifeValue = this.mLifeValue;
            monster.mAttackValue = this.mAttackValue;
            monster.mDefenseValue = this.mDefenseValue;
            monster.mMoney = this.mMoney;
            monster.mExperience = this.mExperience;
            return monster;
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }
}
