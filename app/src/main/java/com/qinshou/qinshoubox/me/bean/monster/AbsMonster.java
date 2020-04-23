package com.qinshou.qinshoubox.me.bean.monster;

import android.content.DialogInterface;

import androidx.fragment.app.FragmentManager;

import com.qinshou.commonmodule.base.AbsDialogFragment;
import com.qinshou.qinshoubox.me.bean.IHandleEventCallback;
import com.qinshou.qinshoubox.me.bean.Position;
import com.qinshou.qinshoubox.me.bean.building.Road;
import com.qinshou.qinshoubox.me.bean.warrior.WarriorBean;
import com.qinshou.qinshoubox.me.ui.dialog.BattleDialogFragment;
import com.qinshou.qinshoubox.util.MagicGameManager;

import java.io.Serializable;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2020/4/23 10:59
 * Description:怪兽抽象类
 */
public abstract class AbsMonster implements IMonster, Serializable {
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

    @Override
    public int getResourceId() {
        return resId;
    }

    @Override
    public void handleEvent(FragmentManager fragmentManager, int floor, Position position, IHandleEventCallback handleEventCallback) {
        WarriorBean warriorBean = MagicGameManager.SINGLETON.getWarriorBean();
        // 怪物每一回合失去的生命值
        int monsterEachBoutLossLifeValue = warriorBean.getAttackValue() - getDefenseValue();
        if (monsterEachBoutLossLifeValue <= 0) {
            handleEventCallback.onFailure(new Exception("打不过啊,兄dei,人家一点血不掉"));
            return;
        }
        // 勇士每一回合失去的生命值
        int warriorEachBoutLossLifeValue = getAttackValue() - warriorBean.getDefenseValue() > 0
                ? getAttackValue() - warriorBean.getDefenseValue()
                : 0;
        // 勇士先攻击
        // 如果怪物生命值为 10,每回合损失血量为 15,则勇士不会损失生命值
        // 如果怪物生命值为 10,每回合损失血量为 5,勇士遭受攻击次数为 10/2=2,则勇士损失生命值为(每回合损失血量*2)
        // 如果怪物生命值为 10,每回合损失血量为 3,勇士遭受攻击次数为 10/3=3.3333,由于勇士先攻击,所以勇士只会受到 3 次攻击则勇士损失生命值为(每回合损失血量*3)
        // 所以回合数只需要取整数部分即可
        int bout = getLifeValue() / monsterEachBoutLossLifeValue;
        // 勇士失去的总生命值
        int warriorTotalLossLifeValue = warriorEachBoutLossLifeValue * bout;
//        if (toCase.getType() == IMonster.BAI_YI_WU_SHI) {
//            warriorTotalLossLifeValue += warriorBean.getLifeValue() / 4;
//        }
        if (warriorBean.getLifeValue() <= warriorTotalLossLifeValue) {
            handleEventCallback.onFailure(new Exception("打是打得动,但是打着打着你就死了啊,兄dei"));
            return;
        }
        BattleDialogFragment battleDialogFragment = BattleDialogFragment.newInstance(this);
        // 失去的总生命值
        battleDialogFragment.setOnDismissListener(new AbsDialogFragment.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {
                MagicGameManager.SINGLETON.setCase(position, new Road());
                MagicGameManager.SINGLETON.getWarriorBean().beatMonster(warriorTotalLossLifeValue, getExperience(), getMoney());
                handleEventCallback.onSuccess(false);
            }
        });
        battleDialogFragment.show(fragmentManager, "BattleDialogFragment");
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
