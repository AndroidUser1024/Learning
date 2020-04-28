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
 * Description:第 2 层的商人
 */
public class BusinessManFloor2 implements INpc {
    @Override
    public int getResourceId() {
        return R.drawable.magic_tower_npc_business_man;
    }

    @Override
    public void handleEvent(FragmentManager fragmentManager, int floor, Position position, IHandleEventCallback handleEventCallback) {
        ArrayList<String> contentList1 = new ArrayList<>();
        contentList1.add("您已经得救了！");
        contentList1.add("快走吧，现在您已经自由了！");
        TalkerBean talker1 = new TalkerBean("勇士", R.drawable.magic_tower_warrior_down, contentList1);

        ArrayList<String> contentList2 = new ArrayList<>();
        contentList2.add("哦，是吗！真是太感谢你了！我是个商人，不知道为什么被抓到这里来了！");
        contentList2.add("哦，对对对，我已经自由了。那这个东西就送给你吧，本来我是准备卖钱的。相信它对你一定很有帮助！");
        TalkerBean talker2 = new TalkerBean("商人", R.drawable.magic_tower_npc_business_man, contentList2);

        TalkDialogFragment talkDialogFragment = TalkDialogFragment.newInstance(talker1, talker2);
        talkDialogFragment.show(fragmentManager, "TalkDialogFragment");
        talkDialogFragment.setOnDismissListener(new AbsDialogFragment.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {
                WarriorBean warriorBean = MagicGameManager.SINGLETON.getWarriorBean();
                warriorBean.setDefenseValue(warriorBean.getDefenseValue() + 30);
                warriorBean.update();

                MagicGameManager.SINGLETON.setCase(position, new Road());

                Toast.makeText(App.getInstance(), "获得钢盾,防御+30", Toast.LENGTH_SHORT).show();

                handleEventCallback.onSuccess(false);
            }
        });
    }
}
