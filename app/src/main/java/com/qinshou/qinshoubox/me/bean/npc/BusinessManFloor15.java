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
 * Description:第 15 层的商人
 */
public class BusinessManFloor15 implements INpc {
    @Override
    public int getResourceId() {
        return R.drawable.magic_tower_npc_business_man;
    }

    @Override
    public void handleEvent(FragmentManager fragmentManager, int floor, Position position, IHandleEventCallback handleEventCallback) {
        WarriorBean warriorBean = MagicGameManager.SINGLETON.getWarriorBean();
        ArrayList<String> contentList1 = new ArrayList<>();
        contentList1.add("啊哈，欢迎你的到来！我这里有一件对你来说非常好的宝物，只要你出得起钱，我就卖给你。");
        contentList1.add("是这个游戏最好的盾牌，防御值可以增加120点，而你只要出500个金币就可以买下。怎么样？你有500个金币吗？");
        if (warriorBean.getMoney() >= 500) {
            contentList1.add("好，成交！");
        } else {
            contentList1.add("那等你凑够了再来吧！");
        }
        ArrayList<String> contentList2 = new ArrayList<>();
        contentList2.add("什么宝物？要多少钱？");
        if (warriorBean.getMoney() >= 500) {
            contentList2.add("我有500个金币。");
        } else {
            contentList2.add("我沒有500个金币。");
        }
        TalkerBean talker1 = new TalkerBean("商人", R.drawable.magic_tower_npc_business_man, contentList1);
        TalkerBean talker2 = new TalkerBean("勇士", R.drawable.magic_tower_warrior_down, contentList2);
        TalkDialogFragment talkDialogFragment = TalkDialogFragment.newInstance(talker1, talker2);
        talkDialogFragment.show(fragmentManager);
        talkDialogFragment.setOnDismissListener(new AbsDialogFragment.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {
                if (warriorBean.getMoney() >= 500) {
                    warriorBean.setMoney(warriorBean.getMoney() - 500);
                    warriorBean.setDefenseValue(warriorBean.getDefenseValue() + 120);
                    warriorBean.update();

                    MagicGameManager.SINGLETON.setCase(position, new Road());

                    Toast.makeText(App.getInstance(), "获得星光盾,防御+120", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
