package com.qinshou.qinshoubox.me.bean.npc;


import android.content.DialogInterface;
import android.widget.Toast;

import androidx.fragment.app.FragmentManager;

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

import java.util.ArrayList;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2020/4/23 13:44
 * Description:第 2 层的神秘老人
 */
public class MysteriousOldManFloor2 implements INpc {
    @Override
    public int getResourceId() {
        return R.drawable.magic_tower_npc_mysterious_old_man;
    }

    @Override
    public void handleEvent(FragmentManager fragmentManager, int floor, Position position, IHandleEventCallback handleEventCallback) {
        ArrayList<String> contentList1 = new ArrayList<>();
        contentList1.add("您已经得救了！");
        contentList1.add("快走吧，我还得去救被关在这里的公主。");
        TalkerBean talker1 = new TalkerBean("勇士", R.drawable.magic_tower_warrior_down, contentList1);

        ArrayList<String> contentList2 = new ArrayList<>();
        contentList2.add("哦，我的孩子，真是太感谢你了！这个地方又脏又坏，我真的是快呆不下去了。");
        contentList2.add("哦，你是来救公主的，为了表示对你的感谢，这个东西就送给你吧，这还是我年轻的时候用过的。拿着它去解救公主吧！");
        TalkerBean talker2 = new TalkerBean("神秘老人", R.drawable.magic_tower_npc_mysterious_old_man, contentList2);

        TalkDialogFragment talkDialogFragment = TalkDialogFragment.newInstance(talker1, talker2);
        talkDialogFragment.show(fragmentManager);
        talkDialogFragment.setOnDismissListener(new AbsDialogFragment.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {
                WarriorBean warriorBean = MagicGameManager.SINGLETON.getWarriorBean();
                warriorBean.setAttackValue(warriorBean.getAttackValue() + 30);
                warriorBean.update();

                MagicGameManager.SINGLETON.setCase(position, new Road());

                Toast.makeText(App.getInstance(), "获得钢剑,攻击+30", Toast.LENGTH_SHORT).show();

                handleEventCallback.onSuccess(false);
            }
        });
    }
}
