package com.qinshou.qinshoubox.me.bean.npc;


import android.content.DialogInterface;

import com.qinshou.commonmodule.base.AbsDialogFragment;
import com.qinshou.qinshoubox.R;
import com.qinshou.qinshoubox.me.bean.IHandleEventCallback;
import com.qinshou.qinshoubox.me.bean.Position;
import com.qinshou.qinshoubox.me.bean.TalkerBean;
import com.qinshou.qinshoubox.me.bean.building.Road;
import com.qinshou.qinshoubox.me.ui.dialog.TalkDialogFragment;
import com.qinshou.qinshoubox.util.MagicGameManager;

import java.util.ArrayList;

import androidx.fragment.app.FragmentManager;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2020/4/23 22:26
 * Description:公主
 */
public class Princess implements INpc {
    @Override
    public int getResourceId() {
        return R.drawable.magic_tower_npc_princess;
    }

    @Override
    public void handleEvent(FragmentManager fragmentManager, int floor, Position position, IHandleEventCallback handleEventCallback) {
        ArrayList<String> contentList1 = new ArrayList<>();
        contentList1.add("公主！你得救了！");
        contentList1.add("是的，我是奉国王的命令来救你的，请你快随我出去吧！");
        contentList1.add("为什么？这里面到处都是恶魔。");
        contentList1.add("大恶魔？我已经杀死了一个魔王！");
        contentList1.add("好，那你等着，等我杀了那个恶魔再来这里找你！");
        TalkerBean talker1 = new TalkerBean("勇士", R.drawable.magic_tower_warrior_down, contentList1);

        ArrayList<String> contentList2 = new ArrayList<>();
        contentList2.add("啊，你是来救我的吗?");
        contentList2.add("不，我还不想走。");
        contentList2.add("正是因为这里面到处都是恶魔，所以才不可以就这样出去，我要看着那个恶魔被杀死！英雄的勇士，如果你能够将那个大恶魔杀死，我就和你一起出去！");
        contentList2.add("大恶魔在这座塔的最顶层，你杀死的可能是一个小队长之类的恶魔。");
        contentList2.add("大恶魔比你刚才杀死的那个厉害多了，而且他还会变身，变身后的魔王的攻击力和防御力都会提升至少一半以上，你要小心！请一定要杀死大魔王！");
        TalkerBean talker2 = new TalkerBean("公主", R.drawable.magic_tower_npc_princess, contentList2);

        TalkDialogFragment talkDialogFragment = TalkDialogFragment.newInstance(talker1, talker2);
        talkDialogFragment.show(fragmentManager, "TalkDialogFragment");
        talkDialogFragment.setOnDismissListener(new AbsDialogFragment.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {
                MagicGameManager.SINGLETON.setCase(position, new Road());
                MagicGameManager.SINGLETON.setCase(new Position(10, 10), new GoUpstairs());

                handleEventCallback.onSuccess(false);
            }
        });
    }
}
