package com.qinshou.qinshoubox.me.bean;

import android.support.v4.app.FragmentActivity;

import com.qinshou.commonmodule.util.ShowLogUtil;
import com.qinshou.networkmodule.rxbus.RxBus;
import com.qinshou.qinshoubox.R;
import com.qinshou.qinshoubox.me.ui.dialog.ShangDianLaoBanBigDialogFragment;
import com.qinshou.qinshoubox.me.ui.dialog.ShangDianLaoBanSmallDialogFragment;
import com.qinshou.qinshoubox.me.ui.dialog.ShangRenFloor12DialogFragment;
import com.qinshou.qinshoubox.me.ui.dialog.ShangRenFloor5DialogFragment;
import com.qinshou.qinshoubox.me.ui.dialog.ShenMiLaoRenFloor13DialogFragment;
import com.qinshou.qinshoubox.me.ui.dialog.ShenMiLaoRenFloor5DialogFragment;
import com.qinshou.qinshoubox.me.ui.dialog.TalkDialogFragment;
import com.qinshou.qinshoubox.me.util.MapManager;

/**
 * Description:Npc 实体类
 * Created by 禽兽先生
 * Created on 2017/6/15
 */

public class NpcBean extends ABaseBean {

    public NpcBean(String name, int type, int resourceID) {
        super(name, type, resourceID);
    }

    @Override
    public boolean handleEvent(FragmentActivity activity, CaseBean fromCase, CaseBean toCase) {
        switch (getType()) {
            case CaseBean.NPC_FAIRY_1:
                TalkerEntity talker1 = new TalkerEntity();
                talker1.setName("勇士");
                talker1.setResourceId(R.drawable.warrior_down);
                String[] content1 = new String[]{"……", "……你是谁？我在哪里？", "……剑，剑，我的剑呢？", "那，公主呢？我是来救公主的。", "那我怎么办，我答应了国王一定要将公主救出来的，那我现在应该怎么办呢？", "找东西？找什么东西？", "那个东西有什么用吗？", "……好吧，我试试看。", "可是，我怎么进去呢？"};
                talker1.setContent(content1);

                TalkerEntity talker2 = new TalkerEntity();
                talker2.setName("仙子");
                talker2.setResourceId(R.drawable.npc_fairy);
                String[] content2 = new String[]{"你醒了！", "我是这里的仙子，刚才你被这里的小怪打昏了。", "你的剑被他们抢走了，我只来得及将你救出来。", "公主还在里面，你这样进去是打不过里面的小怪的。", "放心吧，我把我的力量借给你，你就可以打赢那些小怪了。不过，你得先帮我去找一样东西，找到了再来这里找我。", "是一个十字架，中间有一颗红色的宝石。", "我本是这座塔的守护者，可不久前，从北方来了一批恶魔，他们占领了这座塔，并将我的魔力封在了这个十字架里面，如果你能将它带出塔来，那我的魔力便会慢慢回复，到那时我便可以把力量借给你去救出公主了。要记住：只有用我的魔力才可以打开二十一层的门。", "刚才我去看过了，你的剑被放在三楼，你的盾在五楼，而那个十字架被放在七楼，要到七楼，你得先取回你的剑和盾。另外，在塔里的其他楼层上，还有一些存放了好几百年的宝剑和宝物，如果得到它们，对于你对付这里面的怪物将有很大的帮助。", "我这里有三把钥匙，你先拿去，在塔里面还有很多这样的钥匙，你一定要珍惜使用。勇敢的去吧，勇士！"};
                talker2.setContent(content2);

                TalkDialogFragment.newInstance(talker1, talker2).show(activity.getSupportFragmentManager(), "talkDialogFragment");
                toCase.setType(CaseBean.BUILDING_ROAD);
                MapManager.getInstance().setCase(toCase.getRow(), toCase.getColumn(), toCase);
                MapManager.getInstance().updateUI(toCase);
                CaseBean caseBean = new CaseBean(toCase.getFloor(), toCase.getRow(), toCase.getColumn() - 1, CaseBean.NPC_FAIRY_2);
                MapManager.getInstance().setCase(caseBean.getRow(), caseBean.getColumn(), caseBean);
                MapManager.getInstance().updateUI(caseBean);
                WarriorBean.getInstance().setYellowKeyCount(WarriorBean.getInstance().getYellowKeyCount() + 1);
                WarriorBean.getInstance().setBlueKeyCount(WarriorBean.getInstance().getBlueKeyCount() + 1);
                WarriorBean.getInstance().setRedKeyCount(WarriorBean.getInstance().getRedKeyCount() + 1);
                break;
            case CaseBean.NPC_FAIRY_2:
                ShowLogUtil.logi("仙子2");
                break;
            case CaseBean.NPC_GO_UPSTAIRS:
                MapManager.getInstance().goUpstairs();
                break;
            case CaseBean.NPC_GO_DOWNSTAIRS:
                MapManager.getInstance().goDownstairs();
                break;
            case CaseBean.NPC_GATE_YELLOW:
                if (WarriorBean.getInstance().getYellowKeyCount() == 0) {
                    RxBus.getInstance().post("没有黄钥匙啦，可以找五楼的商人买一把去。");
                    break;
                }
                toCase.setType(CaseBean.BUILDING_ROAD);
                MapManager.getInstance().setCase(toCase.getRow(), toCase.getColumn(), toCase);
                MapManager.getInstance().updateUI(toCase);
                WarriorBean.getInstance().setYellowKeyCount(WarriorBean.getInstance().getYellowKeyCount() - 1);
                break;
            case CaseBean.NPC_GATE_BLUE:
                if (WarriorBean.getInstance().getBlueKeyCount() == 0) {
                    RxBus.getInstance().post("没有蓝钥匙啦，可以找五楼的商人买一把去。");
                    break;
                }
                toCase.setType(CaseBean.BUILDING_ROAD);
                MapManager.getInstance().setCase(toCase.getRow(), toCase.getColumn(), toCase);
                MapManager.getInstance().updateUI(toCase);
                WarriorBean.getInstance().setBlueKeyCount(WarriorBean.getInstance().getBlueKeyCount() - 1);
                break;
            case CaseBean.NPC_GATE_RED:
                if (WarriorBean.getInstance().getRedKeyCount() == 0) {
                    RxBus.getInstance().post("没有红钥匙啦，可以找五楼的商人买一把去。");
                    break;
                }
                toCase.setType(CaseBean.BUILDING_ROAD);
                MapManager.getInstance().setCase(toCase.getRow(), toCase.getColumn(), toCase);
                MapManager.getInstance().updateUI(toCase);
                WarriorBean.getInstance().setRedKeyCount(WarriorBean.getInstance().getRedKeyCount() - 1);
                break;
            case CaseBean.NPC_GATE_GREEN:
                RxBus.getInstance().post("我不是一扇随便的门，所以不能随便打开(给你个提示，找三楼的小偷试试)。");
                break;
            case CaseBean.NPC_GATE_IRON_OPEN:
                toCase.setType(CaseBean.BUILDING_ROAD);
                MapManager.getInstance().setCase(toCase.getRow(), toCase.getColumn(), toCase);
                MapManager.getInstance().updateUI(toCase);
                break;
            case CaseBean.NPC_GATE_IRON_CLOSE:
                RxBus.getInstance().post("我是盼盼防盗门，怎么撞也打不开");
                break;
            case CaseBean.NPC_SHEN_MI_LAO_REN_FLOOR_2:
                toCase.setType(CaseBean.BUILDING_ROAD);
                MapManager.getInstance().setCase(toCase.getRow(), toCase.getColumn(), toCase);
                MapManager.getInstance().updateUI(toCase);
                RxBus.getInstance().post("获得钢剑，攻击 +30");
                WarriorBean.getInstance().setAttackValue(WarriorBean.getInstance().getAttackValue() + 30);
                break;
            case CaseBean.NPC_SHANG_REN_FLOOR_2:
                toCase.setType(CaseBean.BUILDING_ROAD);
                MapManager.getInstance().setCase(toCase.getRow(), toCase.getColumn(), toCase);
                MapManager.getInstance().updateUI(toCase);
                RxBus.getInstance().post("获得钢盾，防御 +30");
                WarriorBean.getInstance().setDefenseValue(WarriorBean.getInstance().getDefenseValue() + 30);
                break;
            case CaseBean.NPC_SHANG_DIAN_LAO_BAN_SMALL1:
                RxBus.getInstance().post("出门右拐");
                break;
            case CaseBean.NPC_SHANG_DIAN_LAO_BAN_SMALL2:
                new ShangDianLaoBanSmallDialogFragment().show(activity.getSupportFragmentManager(), "dialog");
                break;
            case CaseBean.NPC_SHANG_DIAN_LAO_BAN_SMALL3:
                RxBus.getInstance().post("出门左拐");
                break;
            case CaseBean.NPC_THIEF:
                break;
            case CaseBean.NPC_SHEN_MI_LAO_REN_FLOOR_5:
                new ShenMiLaoRenFloor5DialogFragment().show(activity.getSupportFragmentManager(), "shenMiLaoRenFloor5DialogFragment");
                break;
            case CaseBean.NPC_SHANG_REN_FLOOR_5:
                new ShangRenFloor5DialogFragment().show(activity.getSupportFragmentManager(), "shangRenFloor5DialogFragment");
                break;
            case CaseBean.NPC_SHANG_DIAN_LAO_BAN_BIG1:
                RxBus.getInstance().post("出门右拐");
                break;
            case CaseBean.NPC_SHANG_DIAN_LAO_BAN_BIG2:
                new ShangDianLaoBanBigDialogFragment().show(activity.getSupportFragmentManager(), "shangDianLaoBanBigDialogFragment");
                break;
            case CaseBean.NPC_SHANG_DIAN_LAO_BAN_BIG3:
                RxBus.getInstance().post("出门左拐");
                break;
            case CaseBean.NPC_SHANG_REN_FLOOR_12:
                new ShangRenFloor12DialogFragment().show(activity.getSupportFragmentManager(), "shangRenFloor12DialogFragment");
                break;
            case CaseBean.NPC_SHEN_MI_LAO_REN_FLOOR_13:
                new ShenMiLaoRenFloor13DialogFragment().show(activity.getSupportFragmentManager(), "shenMiLaoRenFloor13DialogFragment");
                break;
            case CaseBean.NPC_SHANG_REN_FLOOR_15:
                talker1 = new TalkerEntity();
                talker1.setName("商人");
                talker1.setResourceId(R.drawable.npc_shang_ren);
                content1 = new String[]{"啊哈，欢迎你的到来！我这里有一件对你来说非常好的宝物，只要你出得起钱，我就卖给你！", "是这个游戏最好的盾牌，防御值可以增加 120 点，而你只要出 500 个金币就可以买下。怎么样？你有 500 个金币吗？", "好，成交！"};
                talker1.setContent(content1);

                talker2 = new TalkerEntity();
                talker2.setName("勇士");
                talker2.setResourceId(R.drawable.warrior_down);
                if (WarriorBean.getInstance().getMoney() >= 500) {
                    content2 = new String[]{"什么宝物？要多少钱？", "我有 500 个金币。"};
                } else {
                    content2 = new String[]{"什么宝物？要多少钱？", "暂时没有，一会儿再来。"};
                }
                talker2.setContent(content2);
                TalkDialogFragment.newInstance(talker1, talker2).show(activity.getSupportFragmentManager(), "talkDialogFragment");
                if (WarriorBean.getInstance().getMoney() >= 500) {
                    toCase.setType(CaseBean.BUILDING_ROAD);
                    MapManager.getInstance().setCase(toCase.getRow(), toCase.getColumn(), toCase);
                    MapManager.getInstance().updateUI(toCase);
                    WarriorBean.getInstance().setMoney(WarriorBean.getInstance().getMoney() - 500);
                    WarriorBean.getInstance().setDefenseValue(WarriorBean.getInstance().getDefenseValue() + 120);
                }
                break;
            case CaseBean.NPC_SHEN_MI_LAO_REN_FLOOR_15:
                talker1 = new TalkerEntity();
                talker1.setName("神秘老人");
                talker1.setResourceId(R.drawable.npc_shen_mi_lao_ren);
                content1 = new String[]{"你好，勇敢的孩子，你终于来到这里了。我将给你一个非常好的宝物，它可以使你的攻击力提升 120 点，但这必须得用你的 500 点经验来进行交换，考虑一下子吧！"};
                talker1.setContent(content1);

                talker2 = new TalkerEntity();
                talker2.setName("勇士");
                talker2.setResourceId(R.drawable.warrior_down);
                if (WarriorBean.getInstance().getExperience() >= 500) {
                    content2 = new String[]{"好吧，那就将那把剑给我吧！"};
                } else {
                    content2 = new String[]{"现在没钱，有钱再来！"};
                }
                talker2.setContent(content2);
                TalkDialogFragment.newInstance(talker1, talker2).show(activity.getSupportFragmentManager(), "talkDialogFragment");
                if (WarriorBean.getInstance().getExperience() >= 500) {
                    toCase.setType(CaseBean.BUILDING_ROAD);
                    MapManager.getInstance().setCase(toCase.getRow(), toCase.getColumn(), toCase);
                    MapManager.getInstance().updateUI(toCase);
                    WarriorBean.getInstance().setExperience(WarriorBean.getInstance().getExperience() - 500);
                    WarriorBean.getInstance().setAttackValue(WarriorBean.getInstance().getAttackValue() + 120);
                }
                break;
            case CaseBean.NPC_PRINCESS:
                talker1 = new TalkerEntity();
                talker1.setName("勇士");
                talker1.setResourceId(R.drawable.warrior_down);
                content1 = new String[]{"公主！你得救了！","是的，我是奉国王的命令来救你的。请你快随我出去吧！","为什么？这里面到处都是恶魔。","大恶魔？我已经杀死了一个魔王！","好，那你等着，等我杀了那个恶魔再来这里找你！"};
                talker1.setContent(content1);

                talker2 = new TalkerEntity();
                talker2.setName("公主");
                talker2.setResourceId(R.drawable.npc_princess);
                content2 = new String[]{"啊，你是来救我的吗？","不，我还不想走","正是因为这里面到处都是恶魔，所以才不可以就这样出去，我要看着那个恶魔被杀死！英雄的勇士，如果你能够将那个大恶魔杀死，我就和你一起出去！","大恶魔在这座塔的最顶层，你杀死的可能是一个小队长之类的恶魔。","大恶魔比你刚才杀死的那个厉害多了。而且他还会变身，变身后的魔王的攻击力和防御力都会提升至少一半以上，你要小心！请一定要杀死大魔王！"};
                talker2.setContent(content2);
                TalkDialogFragment.newInstance(talker1, talker2).show(activity.getSupportFragmentManager(), "talkDialogFragment");
                break;
        }
        return false;
    }
}
