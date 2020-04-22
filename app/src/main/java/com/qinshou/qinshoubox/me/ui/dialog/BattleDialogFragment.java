package com.qinshou.qinshoubox.me.ui.dialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.qinshou.commonmodule.base.AbsDialogFragment;
import com.qinshou.qinshoubox.R;
import com.qinshou.qinshoubox.me.bean.MonsterBean;
import com.qinshou.qinshoubox.me.bean.WarriorBean;

/**
 * Description:战斗对话框
 * Created by 禽兽先生
 * Created on 2018/4/27
 */

public class BattleDialogFragment extends AbsDialogFragment {
    private static final String MONSTER = "Monster";
    private ImageView mIvMonster;
    private TextView mTvMonsterName;
    private TextView mTvMonsterLifeValue;
    private TextView mTvMonsterAttackValue;
    private TextView mTvMonsterDefenseValue;
    private ImageView mIvWarrior;
    private TextView mTvWarriorName;
    private TextView mTvWarriorLifeValue;
    private TextView mTvWarriorAttackValue;
    private TextView mTvWarriorDefenseValue;

    private Handler mHandler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            if (msg.what == 200) {
                dismiss();
                return false;
            }
            int monsterLifeValue = msg.arg1;
            if (monsterLifeValue > 0 || msg.what != 0) {
                mTvMonsterLifeValue.setText("生命:" + monsterLifeValue);
            }
            int warriorLifeValue = msg.arg2;
            if (warriorLifeValue > 0) {
                mTvWarriorLifeValue.setText("生命:" + warriorLifeValue);
            }
            return false;
        }
    });


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
        mIvWarrior = findViewByID(R.id.iv_warrior);
        mTvWarriorName = findViewByID(R.id.tv_warrior_name);
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
        final MonsterBean monster = bundle.getParcelable(MONSTER);
//        WarriorBean warriorBean = WarriorBean.getInstance();
//        if (monster == null) {
//            return;
//        }

//        // 设置怪物信息
//        mIvMonster.setImageResource(monster.getResourceId());
//        mTvMonsterName.setText(monster.getName());
//        mTvMonsterLifeValue.setText("生命:" + monster.getLifeValue());
//        mTvMonsterAttackValue.setText("攻击:" + monster.getAttackValue());
//        mTvMonsterDefenseValue.setText("防御:" + monster.getDefenseValue());
//
//        // 设置勇士信息
//        mTvWarriorLifeValue.setText("生命:" + warriorBean.getLifeValue());
//        mTvWarriorAttackValue.setText("攻击:" + warriorBean.getAttackValue());
//        mTvWarriorDefenseValue.setText("防御:" + warriorBean.getDefenseValue());
//
//        new BattleThread(monster, warriorBean).start();
    }

    @Override
    public Dialog customDialog(Dialog dialog) {
        // 设置点击外部不可消失
        dialog.setCanceledOnTouchOutside(false);
        return super.customDialog(dialog);
    }

    private class BattleThread extends Thread {
        private MonsterBean mMonster;
        private WarriorBean mWarrior;

        public BattleThread(MonsterBean monster, WarriorBean warrior) {
            mMonster = monster;
            mWarrior = warrior;
        }

        @Override
        public void run() {
            super.run();
            if (mMonster == null) {
                return;
            }
            int monsterEachBoutLossLifeValue = mWarrior.getAttackValue() - mMonster.getDefenseValue() > 0
                    ? mWarrior.getAttackValue() - mMonster.getDefenseValue()
                    : 0;
            int warriorEachBoutLossLifeValue = mMonster.getAttackValue() - mWarrior.getDefenseValue() > 0
                    ? mMonster.getAttackValue() - mWarrior.getDefenseValue()
                    : 0;
            // 向上取整
            int bout = (int) Math.ceil((double) mMonster.getLifeValue() / (double) monsterEachBoutLossLifeValue);
            int warriorTotalLossLifeValue = warriorEachBoutLossLifeValue * bout;
            // 先发送一次怪物和勇士信息,更新 UI
            Message message = Message.obtain();
            message.arg1 = mMonster.getLifeValue();
            mHandler.sendMessage(message);

            message = Message.obtain();
            message.arg2 = mWarrior.getLifeValue();
            mHandler.sendMessage(message);
            for (int i = 0; i <= bout; i++) {
                message = Message.obtain();
                message.arg1 = mMonster.getLifeValue() - i * monsterEachBoutLossLifeValue >= 0
                        ? mMonster.getLifeValue() - i * monsterEachBoutLossLifeValue
                        : 0;
                if (message.arg1 == 0) {
                    message.what = 1;
                }
                mHandler.sendMessage(message);
                SystemClock.sleep(200);
                message = Message.obtain();
                // 这是一个新开的线程,其实在弹出这个对话框的时候,勇士的生命值已经是减掉该次战斗损失的生命值后的生命值了
                // 这个对话框只是一个过程,所以在显示的时候把损失的生命值加上
                message.arg2 = mWarrior.getLifeValue() - i * warriorEachBoutLossLifeValue;
                mHandler.sendMessage(message);
                SystemClock.sleep(200);
            }
            Message.obtain(mHandler, 200).sendToTarget();
        }
    }

    public static BattleDialogFragment newInstance(MonsterBean monster) {
        // 谷歌推荐使用这种方式保存传进来的数据
        BattleDialogFragment battleDialogFragment = new BattleDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable(MONSTER, monster);
        battleDialogFragment.setArguments(bundle);
        return battleDialogFragment;
    }
}
