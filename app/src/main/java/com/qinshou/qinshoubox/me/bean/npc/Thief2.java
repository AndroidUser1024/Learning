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
 * Date: 2020/4/23 18:54
 * Description:小偷2
 */
public class Thief2 implements INpc {
    @Override
    public int getResourceId() {
        return R.drawable.magic_tower_npc_thief;
    }

    @Override
    public void handleEvent(FragmentManager fragmentManager, int floor, Position position, IHandleEventCallback handleEventCallback) {
        if (!MagicGameManager.SINGLETON.getWarriorBean().isHasStarLightGodHammer()) {
            Toast.makeText(App.getInstance(), "对不起,你没有星光神榔哦", Toast.LENGTH_SHORT).show();
            return;
        }
        ArrayList<String> contentList1 = new ArrayList<>();
        contentList1.add("哈，快看！我找到了什么！");
        TalkerBean talker1 = new TalkerBean("勇士", R.drawable.magic_tower_warrior_down, contentList1);

        ArrayList<String> contentList2 = new ArrayList<>();
        contentList2.add("太好了，这东西果然在这里！好吧，我这就去帮你修好第18层的路面。");
        TalkerBean talker2 = new TalkerBean("小偷", R.drawable.magic_tower_npc_thief, contentList2);

        TalkDialogFragment talkDialogFragment = TalkDialogFragment.newInstance(talker1, talker2);
        talkDialogFragment.show(fragmentManager);
        talkDialogFragment.setOnDismissListener(new AbsDialogFragment.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {
                MagicGameManager.SINGLETON.setCase(18, new Position(9, 5), new Road());
                MagicGameManager.SINGLETON.setCase(position, new Road());

                MagicGameManager.SINGLETON.getWarriorBean().setHasStarLightGodHammer(false);

                handleEventCallback.onSuccess(false);
            }
        });
    }
}
