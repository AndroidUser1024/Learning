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
import java.util.List;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2020/4/22 22:43
 * Description:
 */
public class Fairy2 implements INpc {

    @Override
    public int getResourceId() {
        return R.drawable.magic_tower_npc_fairy;
    }

    @Override
    public void handleEvent(FragmentManager fragmentManager, int floor, Position position, IHandleEventCallback handleEventCallback) {
        WarriorBean warriorBean = MagicGameManager.SINGLETON.getWarriorBean();
        if (!warriorBean.isHasLuckyCross()) {
            handleEventCallback.onFailure(new Exception("你没有幸运十字架哦！"));
            return;
        }
        ArrayList<String> contentList1 = new ArrayList<>();
        contentList1.add("我找到了幸运十字架！");
        TalkerBean talker1 = new TalkerBean("勇士", R.drawable.magic_tower_warrior_down, contentList1);
        ArrayList<String> contentList2 = new ArrayList<>();
        contentList2.add("好的勇士！我把你的生命，攻击，防御提高了 1/3，快去和魔王决斗吧！");

        TalkerBean talker2 = new TalkerBean("仙子", R.drawable.magic_tower_npc_fairy, contentList2);

        TalkDialogFragment talkDialogFragment = TalkDialogFragment.newInstance(talker1, talker2);
        talkDialogFragment.show(fragmentManager);
        talkDialogFragment.setOnDismissListener(new AbsDialogFragment.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {
                warriorBean.setLifeValue(warriorBean.getLifeValue() + warriorBean.getLifeValue() / 3);
                warriorBean.setAttackValue(warriorBean.getAttackValue() + warriorBean.getAttackValue() / 3);
                warriorBean.setDefenseValue(warriorBean.getDefenseValue() + warriorBean.getDefenseValue() / 3);
                warriorBean.setHasLuckyCross(false);
                warriorBean.update();

                MagicGameManager.SINGLETON.setCase(position, new Road());

                handleEventCallback.onSuccess(false);
            }
        });
    }
}
