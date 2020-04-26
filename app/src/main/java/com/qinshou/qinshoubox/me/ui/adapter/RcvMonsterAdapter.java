package com.qinshou.qinshoubox.me.ui.adapter;

import android.content.Context;

import com.qinshou.commonmodule.rcvbaseadapter.RcvSingleBaseAdapter;
import com.qinshou.commonmodule.rcvbaseadapter.baseholder.BaseViewHolder;
import com.qinshou.imagemodule.util.ImageLoadUtil;
import com.qinshou.qinshoubox.R;
import com.qinshou.qinshoubox.me.bean.monster.AbsMonster;
import com.qinshou.qinshoubox.me.bean.warrior.WarriorBean;
import com.qinshou.qinshoubox.util.MagicGameManager;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/10/10 18:59
 * Description:点击圣光徽,显示怪物信息的列表的适配器
 */
public class RcvMonsterAdapter extends RcvSingleBaseAdapter<AbsMonster> {

    public RcvMonsterAdapter(Context context) {
        super(context, R.layout.item_rcv_monster);
    }

    @Override
    public void bindViewHolder(BaseViewHolder holder, AbsMonster itemData, int position) {
        ImageLoadUtil.SINGLETON.loadImage(getContext(), itemData.getResourceId(), holder.getImageView(R.id.iv_monster));
        holder.setTvText(R.id.tv_name, itemData.getName());
        holder.setTvText(R.id.tv_attack_value, itemData.getAttackValue() + "");
        holder.setTvText(R.id.tv_defense_value, itemData.getDefenseValue() + "");
        holder.setTvText(R.id.tv_money, itemData.getMoney() + "");
        holder.setTvText(R.id.tv_experience, itemData.getExperience() + "");
        holder.setTvText(R.id.tv_total_loss_life_value, getTotalLossLifeValue(itemData));
    }

    public String getTotalLossLifeValue(AbsMonster monster) {
        WarriorBean warriorBean = MagicGameManager.SINGLETON.getWarriorBean();
        // 勇士每一回合失去的生命值
        int warriorEachBoutLossLifeValue = monster.getAttackValue() - warriorBean.getDefenseValue() > 0
                ? monster.getAttackValue() - warriorBean.getDefenseValue()
                : 0;
        // 怪物每一回合失去的生命值
        int monsterEachBoutLossLifeValue = warriorBean.getAttackValue() - monster.getDefenseValue();
        if (monsterEachBoutLossLifeValue <= 0) {
            return "???";
        }
        // 勇士先攻击
        // 如果怪物生命值为 10,每回合损失血量为 15,则勇士不会损失生命值
        // 如果怪物生命值为 10,每回合损失血量为 5,勇士遭受攻击次数为 10/2=2,则勇士损失生命值为(每回合损失血量*2)
        // 如果怪物生命值为 10,每回合损失血量为 3,勇士遭受攻击次数为 10/3=3.3333,由于勇士先攻击,所以勇士只会受到 3 次攻击则勇士损失生命值为(每回合损失血量*3)
        // 所以回合数只需要取整数部分即可
        int bout =monster. getLifeValue() / monsterEachBoutLossLifeValue;
        // 勇士失去的总生命值
        int warriorTotalLossLifeValue = warriorEachBoutLossLifeValue * bout;
        return "" + warriorTotalLossLifeValue;
    }
}
