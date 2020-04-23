package com.qinshou.qinshoubox.me.bean.monster;

import java.io.Serializable;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2020/4/23 10:59
 * Description:怪兽抽象类
 */
public abstract class AbsMonster implements Serializable {
    private String name;
    private int resId;
    private int lifeValue;
    private int attackValue;
    private int defenseValue;
    private int money;
    private int experience;

    public AbsMonster(String name, int resId, int lifeValue, int attackValue, int defenseValue, int money, int experience) {
        this.name = name;
        this.resId = resId;
        this.lifeValue = lifeValue;
        this.attackValue = attackValue;
        this.defenseValue = defenseValue;
        this.money = money;
        this.experience = experience;
    }

    @Override
    public String toString() {
        return "AbsMonster{" +
                "名字='" + name + '\'' +
                ", 图片=" + resId +
                ", 生命值=" + lifeValue +
                ", 攻击力=" + attackValue +
                ", 防御力=" + defenseValue +
                ", 金钱=" + money +
                ", 经验=" + experience +
                '}';
    }

    public String getName() {
        return name;
    }

    public int getResId() {
        return resId;
    }

    public int getLifeValue() {
        return lifeValue;
    }

    public int getAttackValue() {
        return attackValue;
    }

    public int getDefenseValue() {
        return defenseValue;
    }

    public int getMoney() {
        return money;
    }

    public int getExperience() {
        return experience;
    }
}
