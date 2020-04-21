package com.qinshou.qinshoubox.me.bean.npc;

import android.content.DialogInterface;

import com.qinshou.commonmodule.base.AbsDialogFragment;
import com.qinshou.commonmodule.util.ShowLogUtil;
import com.qinshou.qinshoubox.R;
import com.qinshou.qinshoubox.me.bean.TalkerBean;
import com.qinshou.qinshoubox.me.enums.Npc;
import com.qinshou.qinshoubox.me.ui.dialog.TalkDialogFragment;

import androidx.fragment.app.FragmentManager;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 20-4-21 下午11:22
 * Description:
 */
public class FairyBean extends NpcBean {
    public FairyBean() {
        super(0, 8, 5, Npc.FAIRY_1, R.drawable.magic_tower_npc_fairy);
    }

    @Override
    public boolean handleEvent(FragmentManager fragmentManager) {
        ShowLogUtil.logi("我要处理事件");
        String[] content1 = new String[]{"……"
                , "……你是谁？我在哪里？"
                , "……剑，剑，我的剑呢？"
                , "那，公主呢？我是来救公主的。"
                , "那我怎么办，我答应了国王一定要将公主救出来的，那我现在应该怎么办呢？"
                , "找东西？找什么东西？"
                , "那个东西有什么用吗？"
                , "……好吧，我试试看。"
                , "可是，我怎么进去呢？"
        };
        TalkerBean talker1 = new TalkerBean("勇士", R.drawable.magic_tower_warrior_down, content1);

        String[] content2 = new String[]{"你醒了！"
                , "我是这里的仙子，刚才你被这里的小怪打昏了。"
                , "你的剑被他们抢走了，我只来得及将你救出来。"
                , "公主还在里面，你这样进去是打不过里面的小怪的。"
                , "放心吧，我把我的力量借给你，你就可以打赢那些小怪了。不过，你得先帮我去找一样东西，找到了再来这里找我。"
                , "是一个十字架，中间有一颗红色的宝石。"
                , "我本是这座塔的守护者，可不久前，从北方来了一批恶魔，他们占领了这座塔，并将我的魔力封在了这个十字架里面，如果你能将它带出塔来，那我的魔力便会慢慢回复，到那时我便可以把力量借给你去救出公主了。要记住：只有用我的魔力才可以打开二十一层的门。"
                , "刚才我去看过了，你的剑被放在三楼，你的盾在五楼，而那个十字架被放在七楼，要到七楼，你得先取回你的剑和盾。另外，在塔里的其他楼层上，还有一些存放了好几百年的宝剑和宝物，如果得到它们，对于你对付这里面的怪物将有很大的帮助。"
                , "我这里有三把钥匙，你先拿去，在塔里面还有很多这样的钥匙，你一定要珍惜使用。勇敢的去吧，勇士！"
        };
        TalkerBean talker2 = new TalkerBean("仙子", R.drawable.magic_tower_npc_fairy, content2);

        TalkDialogFragment talkDialogFragment = TalkDialogFragment.newInstance(talker1, talker2);
        talkDialogFragment.show(fragmentManager, "TalkDialogFragment");
        talkDialogFragment.setOnDismissListener(new AbsDialogFragment.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {
//                setToCase2Road(toCase);
//
//                CaseBean caseBean = new CaseBean(toCase.getFloor(), toCase.getRow(), toCase.getColumn() - 1, Npc.FAIRY_2, R.drawable.magic_tower_npc_fairy);
//                setCase(caseBean.getRow(), caseBean.getColumn(), caseBean);
//                updateUI(caseBean);
//
//                WarriorBean.getInstance().obtainYellowKey();
//                WarriorBean.getInstance().obtainBlueKey();
//                WarriorBean.getInstance().obtainRedKey();
            }
        });
        return false;
    }
}
