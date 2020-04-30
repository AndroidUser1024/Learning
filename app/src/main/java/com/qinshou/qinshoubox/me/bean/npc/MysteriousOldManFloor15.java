package com.qinshou.qinshoubox.me.bean.npc;


import android.content.DialogInterface;
import android.widget.Toast;

import com.qinshou.commonmodule.base.AbsDialogFragment;
import com.qinshou.qinshoubox.App;
import com.qinshou.qinshoubox.R;
import com.qinshou.qinshoubox.me.bean.IHandleEventCallback;
import com.qinshou.qinshoubox.me.bean.Position;
import com.qinshou.qinshoubox.me.bean.TalkerBean;
import com.qinshou.qinshoubox.me.bean.building.Road;
import com.qinshou.qinshoubox.me.bean.warrior.WarriorBean;
import com.qinshou.qinshoubox.me.ui.dialog.TalkDialogFragment;
import com.qinshou.qinshoubox.util.MagicGameManager;

import androidx.fragment.app.FragmentManager;

import java.util.ArrayList;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2020/4/23 22:26
 * Description:第 15 层的神秘老人
 */
public class MysteriousOldManFloor15 implements INpc {
    @Override
    public int getResourceId() {
        return R.drawable.magic_tower_npc_mysterious_old_man;
    }

    @Override
    public void handleEvent(FragmentManager fragmentManager, int floor, Position position, IHandleEventCallback handleEventCallback) {
        WarriorBean warriorBean = MagicGameManager.SINGLETON.getWarriorBean();
        ArrayList<String> contentList1 = new ArrayList<>();
        contentList1.add("你好，勇敢的孩子，你终于来到这里了。我将给你一个非常好的宝物，它可以使你的攻击力提升120点，但这必须得用你的500点经验来进行交换，考虑一下子吧！");
        if (warriorBean.getExperience() >= 500) {
            contentList1.add("那好吧，这把剑就给你了！");
        } else {
            contentList1.add("对不起，你的经验不够哦，等你攒够了再来吧！");
        }
        ArrayList<String> contentList2 = new ArrayList<>();
        contentList2.add("好吧，那就将那把剑给我吧！");
        TalkerBean talker1 = new TalkerBean("神秘老人", R.drawable.magic_tower_npc_mysterious_old_man, contentList1);
        TalkerBean talker2 = new TalkerBean("勇士", R.drawable.magic_tower_warrior_down, contentList2);
        TalkDialogFragment talkDialogFragment = TalkDialogFragment.newInstance(talker1, talker2);
        talkDialogFragment.show(fragmentManager);
        talkDialogFragment.setOnDismissListener(new AbsDialogFragment.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {
                if (warriorBean.getExperience() >= 500) {
                    warriorBean.setExperience(warriorBean.getExperience() - 500);
                    warriorBean.setAttackValue(warriorBean.getAttackValue() + 120);
                    warriorBean.update();

                    MagicGameManager.SINGLETON.setCase(position, new Road());

                    Toast.makeText(App.getInstance(), "获得圣光剑,攻击+120", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
