package com.qinshou.qinshoubox.me.bean.npc;

import android.content.DialogInterface;

import androidx.fragment.app.FragmentManager;

import com.qinshou.commonmodule.base.AbsDialogFragment;
import com.qinshou.qinshoubox.R;
import com.qinshou.qinshoubox.me.bean.IHandleEventCallback;
import com.qinshou.qinshoubox.me.bean.Position;
import com.qinshou.qinshoubox.me.bean.TalkerBean;
import com.qinshou.qinshoubox.me.bean.building.Road;
import com.qinshou.qinshoubox.me.ui.dialog.TalkDialogFragment;
import com.qinshou.qinshoubox.util.MagicGameManager;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2020/4/23 18:54
 * Description:小偷1
 */
public class Thief implements INpc {
    @Override
    public int getResourceId() {
        return R.drawable.magic_tower_npc_thief;
    }

    @Override
    public void handleEvent(FragmentManager fragmentManager, int floor, Position position, IHandleEventCallback handleEventCallback) {
        ArrayList<String> contentList1 = new ArrayList<>();
        contentList1.add("你已经得救了");
        contentList1.add("快走吧，外面还有很多怪物，我可能顾不上你。");
        contentList1.add("……你会开门吗？");
        contentList1.add("那就请你帮我打开第二层的门吧！");
        contentList1.add("嵌了红宝石的铁榔头？好吧，我帮你找找。");
        TalkerBean talker1 = new TalkerBean("勇士", R.drawable.magic_tower_warrior_down, contentList1);

        ArrayList<String> contentList2 = new ArrayList<>();
        contentList2.add("啊，那真是太好了，我又可以在这里面寻宝了！哦，还没有自我介绍，我叫杰克，是这附近有名的小偷，什么金银财宝我样样都偷过。不过这次运气可不是太好，刚进来就被抓了。现在你帮我打开了门，那我就帮你做一件事吧。");
        contentList2.add("不，不，不会有事的。快说吧，叫我做什么？");
        contentList2.add("那当然。");
        contentList2.add("那个简单，不过，如果你能帮我找到一把嵌了红宝石的铁榔头的话，我还帮你打通第十八层的。");
        contentList2.add("非常的感谢，一会儿我便会将第二层的门打开。如果你找到那个铁榔头的话，还是来这里找我。");
        TalkerBean talker2 = new TalkerBean("小偷", R.drawable.magic_tower_npc_thief, contentList2);

        TalkDialogFragment talkDialogFragment = TalkDialogFragment.newInstance(talker1, talker2);
        talkDialogFragment.show(fragmentManager);
        talkDialogFragment.setOnDismissListener(new AbsDialogFragment.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {
                MagicGameManager.SINGLETON.setCase(2, new Position(6, 1), new Road());
                MagicGameManager.SINGLETON.setCase(position, new Thief2());

                handleEventCallback.onSuccess(false);
            }
        });
    }
}
