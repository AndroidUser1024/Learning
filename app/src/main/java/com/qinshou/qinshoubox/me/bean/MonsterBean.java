package com.qinshou.qinshoubox.me.bean;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.DrawableRes;

import com.qinshou.qinshoubox.me.enums.Type;


/**
 * Description:怪物实体类
 * Created by 禽兽先生
 * Created on 2017/6/17
 */

public class MonsterBean implements Parcelable {
    private String name;
    private Type type;
    @DrawableRes
    private int resourceId;
    private int lifeValue;
    private int attackValue;
    private int defenseValue;
    private int money;
    private int experience;

    public MonsterBean() {
    }

    public MonsterBean(String name, Type type, int resourceId, int lifeValue, int attackValue, int defenseValue, int money, int experience) {
        this.name = name;
        this.type = type;
        this.resourceId = resourceId;
        this.lifeValue = lifeValue;
        this.attackValue = attackValue;
        this.defenseValue = defenseValue;
        this.money = money;
        this.experience = experience;
    }

    protected MonsterBean(Parcel in) {
        name = in.readString();
        resourceId = in.readInt();
        lifeValue = in.readInt();
        attackValue = in.readInt();
        defenseValue = in.readInt();
        money = in.readInt();
        experience = in.readInt();
    }

    @Override
    public String toString() {
        return "MonsterBean:" +
                "名字:" + name +
                ", 生命:" + lifeValue +
                ", 攻击:" + attackValue +
                ", 防御:" + defenseValue +
                ", 金钱:" + money +
                ", 经验:" + experience;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeString(name);
        dest.writeInt(resourceId);
        dest.writeInt(lifeValue);
        dest.writeInt(attackValue);
        dest.writeInt(defenseValue);
        dest.writeInt(money);
        dest.writeInt(experience);
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
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof MonsterBean)) return false;

        MonsterBean that = (MonsterBean) object;

        if (resourceId != that.resourceId) return false;
        if (lifeValue != that.lifeValue) return false;
        if (attackValue != that.attackValue) return false;
        if (defenseValue != that.defenseValue) return false;
        if (money != that.money) return false;
        if (experience != that.experience) return false;
        if (!name.equals(that.name)) return false;
        return type.equals(that.type);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + type.hashCode();
        result = 31 * result + resourceId;
        result = 31 * result + lifeValue;
        result = 31 * result + attackValue;
        result = 31 * result + defenseValue;
        result = 31 * result + money;
        result = 31 * result + experience;
        return result;
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

    public int getLifeValue() {
        return lifeValue;
    }

    public void setLifeValue(int lifeValue) {
        this.lifeValue = lifeValue;
    }

    public int getAttackValue() {
        return attackValue;
    }

    public void setAttackValue(int attackValue) {
        this.attackValue = attackValue;
    }

    public int getDefenseValue() {
        return defenseValue;
    }

    public void setDefenseValue(int defenseValue) {
        this.defenseValue = defenseValue;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }


}
