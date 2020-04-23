package com.qinshou.qinshoubox.me.ui.dialog;

import android.app.Dialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.widget.ImageView;
import android.widget.TextView;

import com.qinshou.commonmodule.base.AbsDialogFragment;
import com.qinshou.qinshoubox.R;
import com.qinshou.qinshoubox.me.bean.MonsterBean;
import com.qinshou.qinshoubox.me.bean.monster.AbsMonster;
import com.qinshou.qinshoubox.me.bean.warrior.WarriorBean;
import com.qinshou.qinshoubox.util.MagicGameManager;

/**
 * Description:战斗对话框
 * Created by 禽兽先生
 * Created on 2018/4/27
 */

public class BattleDialogFragment extends AbsDialogFragment {
    private static final String MONSTER = "IMonster";
    private ImageView mIvMonster;
    private TextView mTvMonsterName;
    private TextView mTvMonsterLifeValue;
    private TextView mTvMonsterAttackValue;
    private TextView mTvMonsterDefenseValue;
    private TextView mTvWarriorLifeValue;
    private TextView mTvWarriorAttackValue;
    private TextView mTvWarriorDefenseValue;
    /**
     * 是否是勇士的回合，默认是,勇士先攻击
     */
    private boolean mWarriorBout = true;
    private int mMonsterLifeValue;
    private int mWarriorBeanLifeValue;


    @Override
    public int initLayoutId() {
        return R.layout.dialog_battle;
    }

    @Override
    public void initView() {
        mIvMonster = findViewByID(R.id.iv_monster);
        mTvMonsterName = findViewByID(R.id.tv_monster_name);
        mTvMonsterLifeValue = findViewByID(R.id.tv_monster_life_value);
        mTvMonsterAttackValue = findViewByID(R.id.tv_monster_attack_value);
        mTvMonsterDefenseValue = findViewByID(R.id.tv_monster_defense_value);

        mTvWarriorLifeValue = findViewByID(R.id.tv_warrior_life_value);
        mTvWarriorAttackValue = findViewByID(R.id.tv_warrior_attack_value);
        mTvWarriorDefenseValue = findViewByID(R.id.tv_warrior_defense_value);
    }

    @Override
    public void setListener() {

    }

    @Override
    public void initData() {
        Bundle bundle = getArguments();
        if (bundle == null) {
            return;
        }
        final AbsMonster monster = (AbsMonster) bundle.getSerializable(MONSTER);
        if (monster == null) {
            return;
        }

        // 设置怪物信息
        mIvMonster.setImageResource(monster.getResId());
        mTvMonsterName.setText(monster.getName());
        mMonsterLifeValue = monster.getLifeValue();
        mTvMonsterLifeValue.setText("生命:" + mMonsterLifeValue);
        mTvMonsterAttackValue.setText("攻击:" + monster.getAttackValue());
        mTvMonsterDefenseValue.setText("防御:" + monster.getDefenseValue());

        WarriorBean warriorBean = MagicGameManager.SINGLETON.getWarriorBean();
        // 设置勇士信息
        mWarriorBeanLifeValue = warriorBean.getLifeValue();
        mTvWarriorLifeValue.setText("生命:" + mWarriorBeanLifeValue);
        mTvWarriorAttackValue.setText("攻击:" + warriorBean.getAttackValue());
        mTvWarriorDefenseValue.setText("防御:" + warriorBean.getDefenseValue());

        // 怪物每一回合失去的生命值
        int monsterEachBoutLossLifeValue = warriorBean.getAttackValue() - monster.getDefenseValue();
        // 勇士每一回合失去的生命值
        int warriorEachBoutLossLifeValue = monster.getAttackValue() - warriorBean.getDefenseValue() > 0
                ? monster.getAttackValue() - warriorBean.getDefenseValue()
                : 0;

        mIvMonster.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (mWarriorBout) {
                    mMonsterLifeValue -= monsterEachBoutLossLifeValue;
                    mTvMonsterLifeValue.setText("生命:" + mMonsterLifeValue);
                } else {
                    mWarriorBeanLifeValue -= warriorEachBoutLossLifeValue;
                    mTvWarriorLifeValue.setText("生命:" + mWarriorBeanLifeValue);
                }
                mWarriorBout = !mWarriorBout;
                if (mMonsterLifeValue <= 0) {
                    dismiss();
                } else {
                    mIvMonster.postDelayed(this, 300);
                }
            }
        }, 300);
    }

    @Override
    public Dialog customDialog(Dialog dialog) {
        // 设置点击外部不可消失
        dialog.setCanceledOnTouchOutside(false);
        return dialog;
    }

    public static BattleDialogFragment newInstance(AbsMonster monster) {
        // 谷歌推荐使用这种方式保存传进来的数据
        BattleDialogFragment battleDialogFragment = new BattleDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable(MONSTER, monster);
        battleDialogFragment.setArguments(bundle);
        return battleDialogFragment;
    }
}
