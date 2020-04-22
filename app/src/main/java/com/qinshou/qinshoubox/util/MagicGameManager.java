package com.qinshou.qinshoubox.util;

import android.content.DialogInterface;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;

import com.google.gson.Gson;
import com.qinshou.commonmodule.base.AbsDialogFragment;
import com.qinshou.commonmodule.util.SharedPreferencesHelper;
import com.qinshou.commonmodule.util.ShowLogUtil;
import com.qinshou.qinshoubox.R;
import com.qinshou.qinshoubox.constant.IConstant;
import com.qinshou.qinshoubox.me.bean.CaseBean;
import com.qinshou.qinshoubox.me.bean.IHandleEventCallback;
import com.qinshou.qinshoubox.me.bean.MonsterBean;
import com.qinshou.qinshoubox.me.bean.WarriorBean;
import com.qinshou.qinshoubox.me.bean.floor.AbsFloor;
import com.qinshou.qinshoubox.me.bean.floor.Floor0;
import com.qinshou.qinshoubox.me.bean.floor.Floor1;
import com.qinshou.qinshoubox.me.bean.floor.Floor10;
import com.qinshou.qinshoubox.me.bean.floor.Floor11;
import com.qinshou.qinshoubox.me.bean.floor.Floor12;
import com.qinshou.qinshoubox.me.bean.floor.Floor13;
import com.qinshou.qinshoubox.me.bean.floor.Floor14;
import com.qinshou.qinshoubox.me.bean.floor.Floor15;
import com.qinshou.qinshoubox.me.bean.floor.Floor16;
import com.qinshou.qinshoubox.me.bean.floor.Floor17;
import com.qinshou.qinshoubox.me.bean.floor.Floor18;
import com.qinshou.qinshoubox.me.bean.floor.Floor19;
import com.qinshou.qinshoubox.me.bean.floor.Floor2;
import com.qinshou.qinshoubox.me.bean.floor.Floor20;
import com.qinshou.qinshoubox.me.bean.floor.Floor21;
import com.qinshou.qinshoubox.me.bean.floor.Floor3;
import com.qinshou.qinshoubox.me.bean.floor.Floor4;
import com.qinshou.qinshoubox.me.bean.floor.Floor5;
import com.qinshou.qinshoubox.me.bean.floor.Floor6;
import com.qinshou.qinshoubox.me.bean.floor.Floor7;
import com.qinshou.qinshoubox.me.bean.floor.Floor8;
import com.qinshou.qinshoubox.me.bean.floor.Floor9;
import com.qinshou.qinshoubox.me.enums.Building;
import com.qinshou.qinshoubox.me.enums.Monster;
import com.qinshou.qinshoubox.me.enums.Npc;
import com.qinshou.qinshoubox.me.enums.Prop;
import com.qinshou.qinshoubox.me.enums.Warrior;
import com.qinshou.qinshoubox.me.ui.dialog.BattleDialogFragment;

import java.util.ArrayList;
import java.util.List;

import androidx.fragment.app.FragmentManager;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 20-4-21 下午10:14
 * Description:
 */
public enum MagicGameManager {
    SINGLETON;

    private static final int MAX_ROW = 11;
    private static final int MAX_COLUMN = 11;
    private WarriorBean mWarriorBean;
    private List<AbsFloor> mFloorList = new ArrayList<>();
    private FragmentManager mFragmentManager;
    private TableLayout mTableLayout;
    private int mFloor;

    MagicGameManager() {
        mWarriorBean = new WarriorBean("勇士"
                , Warrior.UP
                , R.drawable.magic_tower_warrior_up
                , 1
                , 1000
                , 10
                , 10
                , 0
                , 0
                , 0
                , 0
                , 0
                , false
                , false
                , false
                , false
                , new WarriorBean.Position(9, 5));
        mFloorList.add(new Floor0());
        mFloorList.add(new Floor1());
        mFloorList.add(new Floor2());
        mFloorList.add(new Floor3());
        mFloorList.add(new Floor4());
        mFloorList.add(new Floor5());
        mFloorList.add(new Floor6());
        mFloorList.add(new Floor7());
        mFloorList.add(new Floor8());
        mFloorList.add(new Floor9());
        mFloorList.add(new Floor10());
        mFloorList.add(new Floor11());
        mFloorList.add(new Floor12());
        mFloorList.add(new Floor13());
        mFloorList.add(new Floor14());
        mFloorList.add(new Floor15());
        mFloorList.add(new Floor16());
        mFloorList.add(new Floor17());
        mFloorList.add(new Floor18());
        mFloorList.add(new Floor19());
        mFloorList.add(new Floor20());
        mFloorList.add(new Floor21());
        mFloor = 0;
    }

    /**
     * Author: QinHao
     * Email:cqflqinhao@126.com
     * Date:2019//9 11:27
     * Description:获取某一格
     *
     * @param row    第几行
     * @param column 第几列
     */
    private CaseBean getCase(int row, int column) {
        return mFloorList.get(mFloor).getCase(row, column);
    }

    /**
     * Author: QinHao
     * Email:cqflqinhao@126.com
     * Date:2019/10/9 16:36
     * Description:处理勇士将要去的位置的事件
     *
     * @param toCase 勇士将要去的位置
     * @return 勇士是否可以移动到要去的位置
     */
    private boolean handleToCase(CaseBean toCase) {
        if (toCase.getType() instanceof Building) {
            return handleBuildingToCase(toCase);
        } else if (toCase.getType() instanceof Npc) {
            return handleNpcToCase(toCase);
        } else if (toCase.getType() instanceof Prop) {
            return handlePropToCase(toCase);
        } else if (toCase.getType() instanceof Monster) {
            return handleMonsterToCase(toCase);
        }
        return true;
    }

    /**
     * Author: QinHao
     * Email:cqflqinhao@126.com
     * Date:2019/10/9 16:36
     * Description:勇士将要去的位置为建筑类的处理
     *
     * @param toCase 勇士将要去的位置
     */
    private boolean handleBuildingToCase(CaseBean toCase) {
        if (toCase.getType() == Building.ROAD) {
            return true;
        } else if (toCase.getType() == Building.WALL) {
            ShowLogUtil.logi("再走就要撞墙了!");
        } else if (toCase.getType() == Building.STARRY_SKY) {
            ShowLogUtil.logi("你要上天吗?");
        } else if (toCase.getType() == Building.FIRE_SEA) {
            ShowLogUtil.logi("碳烤人肉串?");
        }
        return false;
    }

    /**
     * Author: QinHao
     * Email:cqflqinhao@126.com
     * Date:2019/10/9 16:36
     * Description:勇士将要去的位置为 Npc 类的处理
     *
     * @param toCase 勇士将要去的位置
     */
    private boolean handleNpcToCase(CaseBean toCase) {
        if (toCase.getType() == Npc.FAIRY_1) {
//            String[] content1 = new String[]{"……"
//                    , "……你是谁？我在哪里？"
//                    , "……剑，剑，我的剑呢？"
//                    , "那，公主呢？我是来救公主的。"
//                    , "那我怎么办，我答应了国王一定要将公主救出来的，那我现在应该怎么办呢？"
//                    , "找东西？找什么东西？"
//                    , "那个东西有什么用吗？"
//                    , "……好吧，我试试看。"
//                    , "可是，我怎么进去呢？"
//            };
//            TalkerBean talker1 = new TalkerBean("勇士", R.drawable.magic_tower_warrior_down, content1);
//
//            String[] content2 = new String[]{"你醒了！"
//                    , "我是这里的仙子，刚才你被这里的小怪打昏了。"
//                    , "你的剑被他们抢走了，我只来得及将你救出来。"
//                    , "公主还在里面，你这样进去是打不过里面的小怪的。"
//                    , "放心吧，我把我的力量借给你，你就可以打赢那些小怪了。不过，你得先帮我去找一样东西，找到了再来这里找我。"
//                    , "是一个十字架，中间有一颗红色的宝石。"
//                    , "我本是这座塔的守护者，可不久前，从北方来了一批恶魔，他们占领了这座塔，并将我的魔力封在了这个十字架里面，如果你能将它带出塔来，那我的魔力便会慢慢回复，到那时我便可以把力量借给你去救出公主了。要记住：只有用我的魔力才可以打开二十一层的门。"
//                    , "刚才我去看过了，你的剑被放在三楼，你的盾在五楼，而那个十字架被放在七楼，要到七楼，你得先取回你的剑和盾。另外，在塔里的其他楼层上，还有一些存放了好几百年的宝剑和宝物，如果得到它们，对于你对付这里面的怪物将有很大的帮助。"
//                    , "我这里有三把钥匙，你先拿去，在塔里面还有很多这样的钥匙，你一定要珍惜使用。勇敢的去吧，勇士！"
//            };
//            TalkerBean talker2 = new TalkerBean("仙子", R.drawable.magic_tower_npc_fairy, content2);
//
//            TalkDialogFragment talkDialogFragment = TalkDialogFragment.newInstance(talker1, talker2);
//            talkDialogFragment.show(fragmentManager, "TalkDialogFragment");
//            talkDialogFragment.setOnDismissListener(new AbsDialogFragment.OnDismissListener() {
//                @Override
//                public void onDismiss(DialogInterface dialog) {
//                    setToCase2Road(toCase);
//
//                    CaseBean caseBean = new CaseBean(toCase.getFloor(), toCase.getRow(), toCase.getColumn() - 1, Npc.FAIRY_2, R.drawable.magic_tower_npc_fairy);
//                    setCase(caseBean.getRow(), caseBean.getColumn(), caseBean);
//                    updateUI(caseBean);
//
//                    WarriorBean.getInstance().obtainYellowKey();
//                    WarriorBean.getInstance().obtainBlueKey();
//                    WarriorBean.getInstance().obtainRedKey();
//                }
//            });
        }
        if (toCase.getType() == Npc.FAIRY_2) {
//            String[] content1 = new String[]{"……"
//                    , "我找到了幸运十字架"
//            };
//            TalkerBean talker1 = new TalkerBean("勇士", R.drawable.magic_tower_warrior_down, content1);
//
//            String[] content2 = new String[]{"你醒了！"
//                    , "把你的生命,攻击,防御提高1/3"
//            };
//            TalkerBean talker2 = new TalkerBean("仙子", R.drawable.magic_tower_npc_fairy, content2);
//
//            TalkDialogFragment talkDialogFragment = TalkDialogFragment.newInstance(talker1, talker2);
//            talkDialogFragment.show(fragmentManager, "TalkDialogFragment");
//            talkDialogFragment.setOnDismissListener(new OnDismissListener() {
//                @Override
//                public void onDismiss(DialogInterface dialog) {
//                    if (!WarriorBean.getInstance().giveLuckyCross2Fairy()) {
//                        return;
//                    }
//                    setToCase2Road(toCase);
//                }
//            });
        } else if (toCase.getType() == Npc.GO_UPSTAIRS) {
//            goUpstairs();
        } else if (toCase.getType() == Npc.GO_DOWNSTAIRS) {
//            goDownstairs();
        } else if (toCase.getType() == Npc.GATE_YELLOW) {
//            if (WarriorBean.getInstance().getYellowKeyCount() == 0) {
//                ShowLogUtil.logi("没有黄钥匙啦,可以找五楼的商人买一把去.");
//                return false;
//            }
//            setToCase2Road(toCase);
//
//            WarriorBean.getInstance().loseYellowKey();
//            WarriorBean.getInstance().update();
        } else if (toCase.getType() == Npc.GATE_BLUE) {
//            if (WarriorBean.getInstance().getBlueKeyCount() == 0) {
//                ShowLogUtil.logi("没有蓝钥匙啦,可以找五楼的商人买一把去.");
//                return false;
//            }
//            setToCase2Road(toCase);
//
//            WarriorBean.getInstance().loseBlueKey();
//            WarriorBean.getInstance().update();
        } else if (toCase.getType() == Npc.GATE_RED) {
//            if (WarriorBean.getInstance().getRedKeyCount() == 0) {
//                ShowLogUtil.logi("没有红钥匙啦,可以找五楼的商人买一把去.");
//                return false;
//            }
//            setToCase2Road(toCase);
//
//            WarriorBean.getInstance().loseRedKey();
//            WarriorBean.getInstance().update();
        } else if (toCase.getType() == Npc.GATE_GREEN) {
//            setToCase2Road(toCase);
        } else if (toCase.getType() == Npc.GATE_IRON_OPEN) {
//            setToCase2Road(toCase);
        } else if (toCase.getType() == Npc.GATE_IRON_CLOSE) {

        } else if (toCase.getType() == Npc.SHEN_MI_LAO_REN_FLOOR_2) {
//            String[] content1 = new String[]{"您已经得救了!"
//                    , "快走吧,我还得去救被关在这里的公主."
//            };
//            TalkerBean talker1 = new TalkerBean("勇士", R.drawable.magic_tower_warrior_down, content1);
//
//            String[] content2 = new String[]{"哦,我的孩子,真是太感谢你了!这个地方又脏又坏,我真的是快呆不下去了."
//                    , "哦,你是来救公主的,为了表示对你的感谢,这个东西就送给你吧,这还是我年轻的时候用过的.拿着它去解救公主吧!"
//            };
//            TalkerBean talker2 = new TalkerBean("神秘老人", R.drawable.magic_tower_npc_shen_mi_lao_ren, content2);
//
//            TalkDialogFragment talkDialogFragment = TalkDialogFragment.newInstance(talker1, talker2);
//            talkDialogFragment.show(fragmentManager, "TalkDialogFragment");
//            talkDialogFragment.setOnDismissListener(new OnDismissListener() {
//                @Override
//                public void onDismiss(DialogInterface dialog) {
//                    setToCase2Road(toCase);
//
//                    WarriorBean.getInstance().obtainSteelSword();
//                }
//            });
        } else if (toCase.getType() == Npc.SHANG_REN_FLOOR_2) {
//            String[] content1 = new String[]{"您已经得救了!"
//                    , "快走吧,现在您已经自由了.."
//            };
//            TalkerBean talker1 = new TalkerBean("勇士", R.drawable.magic_tower_warrior_down, content1);
//
//            String[] content2 = new String[]{"哦,是吗!真是太感谢你了!我是个商人,不知道为什么被抓到这里来了."
//                    , "哦,对对对,我已经自由了.那这个东西就送给你吧,本来我是准备卖钱的.相信它对你一定很有帮助!"
//            };
//            TalkerBean talker2 = new TalkerBean("神秘老人", R.drawable.magic_tower_npc_shen_mi_lao_ren, content2);
//
//            TalkDialogFragment talkDialogFragment = TalkDialogFragment.newInstance(talker1, talker2);
//            talkDialogFragment.show(fragmentManager, "TalkDialogFragment");
//            talkDialogFragment.setOnDismissListener(new OnDismissListener() {
//                @Override
//                public void onDismiss(DialogInterface dialog) {
//                    setToCase2Road(toCase);
//
//                    WarriorBean.getInstance().obtainSteelShield();
//                }
//            });
        } else if (toCase.getType() == Npc.SHANG_DIAN_LAO_BAN_SMALL_1) {

        } else if (toCase.getType() == Npc.SHANG_DIAN_LAO_BAN_SMALL_2) {
//            new StoreSmallDialogFragment().show(fragmentManager, "StoreSmallDialogFragment");
        } else if (toCase.getType() == Npc.SHANG_DIAN_LAO_BAN_SMALL_3) {

        } else if (toCase.getType() == Npc.THIEF_1) {
//            String[] content1 = new String[]{"你已经得救了"
//                    , "快走吧,外面还有很多怪物,我可能顾不上你."
//                    , "……你会开门吗?"
//                    , "那就请你帮我打开第二层的门吧!"
//                    , "嵌了红宝石的铁榔头?好吧,我帮你找找."
//            };
//            TalkerBean talker1 = new TalkerBean("勇士", R.drawable.magic_tower_warrior_down, content1);
//
//            String[] content2 = new String[]{"啊,那真是太好了,我又可以在这里面寻宝了!哦,还没有自我介绍,我叫杰克,是这附近有名的小偷,什么金银财宝我样样都偷过.不过这次运气可不是太好,刚进来就被抓了.现在你帮我打开了门,那我就帮你做一件事吧."
//                    , "不,不,不会有事的.快说吧,叫我做什么?"
//                    , "那当然."
//                    , "那个简单,不过,如果你能帮我找到一把嵌了红宝石的铁榔头的话,我还帮你打通第十八层的路."
//                    , "非常的感谢,一会儿我便会将第二层的门打开.如果你找到那个铁榔头的话,还是来这里找我!"
//            };
//            TalkerBean talker2 = new TalkerBean("小偷", R.drawable.magic_tower_npc_thief, content2);
//
//            TalkDialogFragment talkDialogFragment = TalkDialogFragment.newInstance(talker1, talker2);
//            talkDialogFragment.show(fragmentManager, "TalkDialogFragment");
//            talkDialogFragment.setOnDismissListener(new OnDismissListener() {
//                @Override
//                public void onDismiss(DialogInterface dialog) {
//                    List<List<CaseBean>> data = floorList.get(2).getData();
//                    for (List<CaseBean> caseBeanList : data) {
//                        for (CaseBean caseBean : caseBeanList) {
//                            if (caseBean.getType() == Npc.GATE_GREEN) {
//                                caseBean.setType(Building.ROAD);
//                                caseBean.setResourceId(R.drawable.magic_tower_building_road);
//                                setCase(caseBean.getRow(), caseBean.getColumn(), caseBean);
//                                break;
//                            }
//                        }
//                    }
//                }
//            });
        } else if (toCase.getType() == Npc.THIEF_2) {

        } else if (toCase.getType() == Npc.SHEN_MI_LAO_REN_FLOOR_5) {
//            new MysteriousOldManFloor5DialogFragment().show(fragmentManager, "MysteriousOldManFloor5DialogFragment");
        } else if (toCase.getType() == Npc.SHANG_REN_FLOOR_5) {
//            new BusinessManFloor5DialogFragment().show(fragmentManager, "BusinessManFloor5DialogFragment");
        } else if (toCase.getType() == Npc.SHANG_DIAN_LAO_BAN_BIG_2) {
//            new StoreBigDialogFragment().show(fragmentManager, "StoreBigDialogFragment");
        } else if (toCase.getType() == Npc.SHANG_REN_FLOOR_12) {
//            new BusinessManFloor12DialogFragment().show(fragmentManager, "BusinessManFloor12DialogFragment");
        } else if (toCase.getType() == Npc.SHEN_MI_LAO_REN_FLOOR_13) {
//            new MysteriousOldManFloor13DialogFragment().show(fragmentManager, "MysteriousOldManFloor13DialogFragment");
        } else if (toCase.getType() == Npc.SHEN_MI_LAO_REN_FLOOR_15) {
//            String[] content1;
//            String[] content2;
//            boolean obtainHolyLightSword = WarriorBean.getInstance().obtainHolyLightSword();
//            if (obtainHolyLightSword) {
//                content1 = new String[]{"你好,勇敢的孩子,你终于来到这里了.我将给你一个非常好的宝物,它可以使你的攻击力提升120点,但这必须得用你的500点经验来进行交换,考虑一下子吧!"
//                        , "那好吧,这把剑就给你了!"
//                };
//
//                content2 = new String[]{"好吧,那就将那把剑给我吧!"
//                };
//            } else {
//                content1 = new String[]{"你好,勇敢的孩子,你终于来到这里了.我将给你一个非常好的宝物,它可以使你的攻击力提升120点,但这必须得用你的500点经验来进行交换,考虑一下子吧!"
//                        , "对不起,你的经验不够哦,等你攒够了再来吧!"
//                };
//                content2 = new String[]{"好吧,那就将那把剑给我吧!"
//                };
//            }
//            TalkerBean talker1 = new TalkerBean("神秘老人", R.drawable.magic_tower_npc_shen_mi_lao_ren, content1);
//            TalkerBean talker2 = new TalkerBean("勇士", R.drawable.magic_tower_warrior_down, content2);
//
//            TalkDialogFragment talkDialogFragment = TalkDialogFragment.newInstance(talker1, talker2);
//            talkDialogFragment.show(fragmentManager, "TalkDialogFragment");
//            talkDialogFragment.setOnDismissListener(new OnDismissListener() {
//                @Override
//                public void onDismiss(DialogInterface dialog) {
//                    if (obtainHolyLightSword) {
//                        setToCase2Road(toCase);
//                    }
//                }
//            });
        } else if (toCase.getType() == Npc.SHANG_REN_FLOOR_15) {
//            String[] content1;
//            String[] content2;
//            boolean obtainStarLightShield = WarriorBean.getInstance().obtainStarLightShield();
//            if (obtainStarLightShield) {
//                content1 = new String[]{"啊哈,欢迎你的到来!我这里有一件对你来说非常好的宝物,只要你出得起钱,我就卖给你."
//                        , "是这个游戏最好的盾牌,防御值可以增加120点,而你只要出500个金币就可以买下.怎么样?你有500个金币吗?"
//                        , "好,成交!"
//                };
//
//                content2 = new String[]{"什么宝物?要多少钱?"
//                        , "我有500个金币."
//                };
//            } else {
//                content1 = new String[]{"啊哈,欢迎你的到来!我这里有一件对你来说非常好的宝物,只要你出得起钱,我就卖给你."
//                        , "是这个游戏最好的盾牌,防御值可以增加120点,而你只要出500个金币就可以买下.怎么样?你有500个金币吗?"
//                        , "那等你凑够了再来吧!"
//                };
//                content2 = new String[]{"什么宝物?要多少钱?"
//                        , "我没有500个金币."
//                };
//            }
//            TalkerBean talker1 = new TalkerBean("商人", R.drawable.magic_tower_npc_shang_ren, content1);
//            TalkerBean talker2 = new TalkerBean("勇士", R.drawable.magic_tower_warrior_down, content2);
//
//            TalkDialogFragment talkDialogFragment = TalkDialogFragment.newInstance(talker1, talker2);
//            talkDialogFragment.show(fragmentManager, "TalkDialogFragment");
//            talkDialogFragment.setOnDismissListener(new OnDismissListener() {
//                @Override
//                public void onDismiss(DialogInterface dialog) {
//                    if (obtainStarLightShield) {
//                        setToCase2Road(toCase);
//                    }
//                }
//            });
        } else if (toCase.getType() == Npc.PRINCESS) {
//            String[] content1 = new String[]{"公主!你得救了!"
//                    , "是的,我是奉国王的命令来救你的.请你快随我出去吧!"
//                    , "为什么?这里面到处都是恶魔."
//                    , "大恶魔?我已经杀死了一个魔王!"
//                    , "好,那你等着,等我杀了那个恶魔再来这里找你!"
//            };
//            TalkerBean talker1 = new TalkerBean("勇士", R.drawable.magic_tower_warrior_down, content1);
//
//            String[] content2 = new String[]{"啊,你是来救我的吗?"
//                    , "不,我还不想走."
//                    , "正是因为这里面到处都是恶魔,所以才不可以就这样出去,我要看着那个恶魔被杀死!英雄的勇士,如果你能够将那个大恶魔杀死,我就和你一起出去!"
//                    , "大恶魔在这座塔的最顶层,你杀死的可能是一个小队长之类的恶魔."
//                    , "大恶魔比你刚才杀死的那个厉害多了.而且他还会变身,变身后的魔王的攻击力和防御力都会提升至少一半以上,你要小心!请一定要杀死大魔王!"
//            };
//            TalkerBean talker2 = new TalkerBean("公主", R.drawable.magic_tower_npc_princess, content2);
//
//            TalkDialogFragment talkDialogFragment = TalkDialogFragment.newInstance(talker1, talker2);
//            talkDialogFragment.show(fragmentManager, "TalkDialogFragment");
//            talkDialogFragment.setOnDismissListener(new OnDismissListener() {
//                @Override
//                public void onDismiss(DialogInterface dialog) {
//                    setToCase2Road(toCase);
//                }
//            });
        }

        return false;
    }

    /**
     * Author: QinHao
     * Email:cqflqinhao@126.com
     * Date:2019/10/9 19:16
     * Description:勇士将要去的位置为道具类的处理
     *
     * @param toCase 勇士将要去的位置
     */
    private boolean handlePropToCase(CaseBean toCase) {
//        if (toCase.getType() == Prop.KEY_YELLOW) {
//            WarriorBean.getInstance().obtainYellowKey();
//        } else if (toCase.getType() == Prop.KEY_BLUE) {
//            WarriorBean.getInstance().obtainBlueKey();
//        } else if (toCase.getType() == Prop.KEY_RED) {
//            WarriorBean.getInstance().obtainRedKey();
//        } else if (toCase.getType() == Prop.XIE_PING_SMALL) {
//            WarriorBean.getInstance().obtainSmallBloodBottle();
//        } else if (toCase.getType() == Prop.XIE_PING_BIG) {
//            WarriorBean.getInstance().obtainBigBloodBottle();
//        } else if (toCase.getType() == Prop.BAO_SHI_RED) {
//            WarriorBean.getInstance().obtainRedGem();
//        } else if (toCase.getType() == Prop.BAO_SHI_BLUE) {
//            WarriorBean.getInstance().obtainBlueGem();
//        } else if (toCase.getType() == Prop.SHENG_GUANG_HUI) {
//            WarriorBean.getInstance().obtainShengGuangHui();
//        } else if (toCase.getType() == Prop.TIE_JIAN) {
//            WarriorBean.getInstance().obtainIronSword();
//        } else if (toCase.getType() == Prop.TIE_DUN) {
//            WarriorBean.getInstance().obtainIronShield();
//        } else if (toCase.getType() == Prop.YAO_SHI_HE) {
//            WarriorBean.getInstance().obtainKeyBox();
//        } else if (toCase.getType() == Prop.XIAO_FEI_YU) {
//            WarriorBean.getInstance().obtainSmallFlightFeather();
//        } else if (toCase.getType() == Prop.JIN_KUAI) {
//            WarriorBean.getInstance().obtainGoldBullion();
//        } else if (toCase.getType() == Prop.XING_YUN_SHI_ZI_JIA) {
//            WarriorBean.getInstance().obtainLuckyCross();
//        } else if (toCase.getType() == Prop.FENG_ZHI_LUO_PAN) {
//            WarriorBean.getInstance().obtainWindCompass();
//        } else if (toCase.getType() == Prop.QING_FENG_JIAN) {
//            WarriorBean.getInstance().obtainQingFengSword();
//        } else if (toCase.getType() == Prop.HUANG_JIN_DUN) {
//            WarriorBean.getInstance().obtainGoldShield();
//        } else if (toCase.getType() == Prop.XING_GUANG_SHEN_LANG) {
//            WarriorBean.getInstance().obtainStarlightGodHammer();
//        } else if (toCase.getType() == Prop.DA_FEI_YU) {
//            WarriorBean.getInstance().obtainBigFlightFeather();
//        } else if (toCase.getType() == Prop.SHENG_SHUI) {
//            WarriorBean.getInstance().obtainHolyWater();
//        } else if (toCase.getType() == Prop.XING_GUANG_SHEN_JIAN) {
//            WarriorBean.getInstance().obtainStarLightGodSword();
//        } else if (toCase.getType() == Prop.GUANG_MANG_SHEN_DUN) {
//            WarriorBean.getInstance().obtainLightGodShield();
//        }
//        setToCase2Road(toCase);
        return false;
    }

    /**
     * Author: QinHao
     * Email:cqflqinhao@126.com
     * Date:2019/10/9 19:16
     * Description:勇士将要去的位置为道具类的处理
     *
     * @param toCase 勇士将要去的位置
     */
    private boolean handleMonsterToCase(CaseBean toCase) {
//        WarriorBean warriorBean = WarriorBean.getInstance();
//        MonsterBean monsterBean = MonsterFactory.getMonster((Monster) toCase.getType());
//        int monsterEachBoutLossLifeValue = warriorBean.getAttackValue() - monsterBean.getDefenseValue();
//        if (monsterEachBoutLossLifeValue <= 0) {
//            ShowLogUtil.logi("打不过啊,兄dei,人家一点血不掉");
//            return false;
//        }
//        // 每一回合失去的生命值
//        int warriorEachBoutLossLifeValue = monsterBean.getAttackValue() - warriorBean.getDefenseValue() > 0
//                ? monsterBean.getAttackValue() - warriorBean.getDefenseValue()
//                : 0;
//        // 向上取整
//        int bout = (int) Math.ceil((double) monsterBean.getLifeValue() / (double) monsterEachBoutLossLifeValue);
//        // 失去的总生命值
//        int warriorTotalLossLifeValue = warriorEachBoutLossLifeValue * bout;
////        if (toCase.getType() == Monster.BAI_YI_WU_SHI) {
////            warriorTotalLossLifeValue += warriorBean.getLifeValue() / 4;
////        }
//        if (warriorBean.getLifeValue() <= warriorTotalLossLifeValue) {
//            ShowLogUtil.logi("打是打得动,但是打着打着你就死了啊,兄dei");
//            return false;
//        }
//        BattleDialogFragment battleDialogFragment = BattleDialogFragment.newInstance(monsterBean);
//        // 失去的总生命值
//        int finalWarriorTotalLossLifeValue = warriorTotalLossLifeValue;
//        battleDialogFragment.setOnDismissListener(new AbsDialogFragment.OnDismissListener() {
//            @Override
//            public void onDismiss(DialogInterface dialog) {
////                setToCase2Road(toCase);
//                WarriorBean.getInstance().beatMonster(finalWarriorTotalLossLifeValue, monsterBean.getExperience(), monsterBean.getMoney());
//            }
//        });
//        battleDialogFragment.show(mFragmentManager, "BattleDialogFragment");
        return false;
    }

    private void setCase(int row, int column, CaseBean toCase) {
        this.setCase(mFloor, row, column, toCase);
    }

    /**
     * Author: QinHao
     * Email:cqflqinhao@126.com
     * Date:2019//9 11:32
     * Description:重设某一格
     *
     * @param caseBean 格子对象
     */
    public void setCase(int floor, int row, int column, CaseBean caseBean) {
        mFloorList.get(floor).setCase(row, column, caseBean);
        if (floor == mFloor) {
            updateUI(row, column, caseBean);
        }
    }

    public WarriorBean getWarriorBean() {
        return mWarriorBean;
    }

    public void startGame(FragmentManager fragmentManager, TableLayout tableLayout) {
        mFragmentManager = fragmentManager;
        mTableLayout = tableLayout;
        if (tableLayout.getChildCount() != MAX_ROW) {
            return;
        }
        mFloorList.get(mFloor).initFloor(tableLayout);
        mFloorList.get(mFloor).fromDownstairsToThisFloor();
    }

    /**
     * Author: QinHao
     * Email:cqflqinhao@126.com
     * Date:2019/10/9 16:18
     * Description:勇士向左移动
     */
    public void warriorMoveLeft() {
        // 勇士原来的位置的纵坐标
        int originColumn = mWarriorBean.getPosition().getRow();
        if (originColumn == 0) {
            return;
        }
        // 勇士需要移动到的位置
        CaseBean caseBean = mFloorList.get(mFloor).getCase(mWarriorBean.getPosition().getRow(), originColumn - 1);
        caseBean.handleEvent(mFragmentManager, new IHandleEventCallback() {
            @Override
            public void onSuccess(boolean canMove) {
                if (!canMove) {
                    return;
                }
                // 可以移动过去,则修改勇士属性
                mWarriorBean.setType(Warrior.LEFT);
                mWarriorBean.setResourceId(R.drawable.magic_tower_warrior_left);
                mWarriorBean.getPosition().setColumn(originColumn - 1);

                // 更新勇士现在的位置的 UI
                CaseBean toCase = getCase(mWarriorBean.getPosition().getRow(), mWarriorBean.getPosition().getColumn());
                toCase.setType(Warrior.LEFT);
                toCase.setResourceId(R.drawable.magic_tower_warrior_left);
                setCase(mWarriorBean.getPosition().getRow(), mWarriorBean.getPosition().getColumn(), toCase);

                // 勇士原来的位置变成 Building.ROAD
                CaseBean fromCase = getCase(mWarriorBean.getPosition().getRow(), originColumn);
                fromCase.setType(Building.ROAD);
                fromCase.setResourceId(R.drawable.magic_tower_building_road);
                setCase(mWarriorBean.getPosition().getRow(), originColumn, fromCase);
            }

            @Override
            public void onFailure() {

            }
        });
    }

    /**
     * Author: QinHao
     * Email:cqflqinhao@126.com
     * Date:2019/10/9 16:18
     * Description:勇士向上移动
     */
    public void warriorMoveUp() {
        // 勇士原来的位置的横坐标
        int originRow = mWarriorBean.getPosition().getRow();
        if (originRow == 0) {
            return;
        }
        // 勇士需要移动到的位置
        CaseBean caseBean = mFloorList.get(mFloor).getCase(originRow - 1, mWarriorBean.getPosition().getColumn());
        caseBean.handleEvent(mFragmentManager, new IHandleEventCallback() {
            @Override
            public void onSuccess(boolean canMove) {
                if (!canMove) {
                    return;
                }
                // 可以移动过去,则修改勇士属性
                mWarriorBean.setType(Warrior.UP);
                mWarriorBean.setResourceId(R.drawable.magic_tower_warrior_up);
                mWarriorBean.getPosition().setRow(originRow - 1);

                // 更新勇士现在的位置的 UI
                CaseBean toCase = getCase(mWarriorBean.getPosition().getRow(), mWarriorBean.getPosition().getColumn());
                toCase.setType(Warrior.UP);
                toCase.setResourceId(R.drawable.magic_tower_warrior_up);
                setCase(mWarriorBean.getPosition().getRow(), mWarriorBean.getPosition().getColumn(), toCase);

                // 勇士原来的位置变成 Building.ROAD
                CaseBean fromCase = getCase(originRow, mWarriorBean.getPosition().getColumn());
                fromCase.setType(Building.ROAD);
                fromCase.setResourceId(R.drawable.magic_tower_building_road);
                setCase(originRow, mWarriorBean.getPosition().getColumn(), toCase);
            }

            @Override
            public void onFailure() {

            }
        });
    }

    /**
     * Author: QinHao
     * Email:cqflqinhao@126.com
     * Date:2019/10/9 16:19
     * Description:勇士向右移动
     */
    public void warriorMoveRight() {

        // 勇士原来的位置的纵坐标
        int originColumn = mWarriorBean.getPosition().getRow();
        if (originColumn == MAX_COLUMN - 1) {
            return;
        }
        // 勇士需要移动到的位置
        CaseBean caseBean = mFloorList.get(mFloor).getCase(mWarriorBean.getPosition().getRow(), originColumn + 1);
        caseBean.handleEvent(mFragmentManager, new IHandleEventCallback() {
            @Override
            public void onSuccess(boolean canMove) {
                if (!canMove) {
                    return;
                }
                // 可以移动过去,则修改勇士属性
                mWarriorBean.setType(Warrior.RIGHT);
                mWarriorBean.setResourceId(R.drawable.magic_tower_warrior_right);
                mWarriorBean.getPosition().setColumn(originColumn + 1);

                // 更新勇士现在的位置的 UI
                CaseBean toCase = getCase(mWarriorBean.getPosition().getRow(), mWarriorBean.getPosition().getColumn());
                toCase.setType(Warrior.RIGHT);
                toCase.setResourceId(R.drawable.magic_tower_warrior_right);
                setCase(mWarriorBean.getPosition().getRow(), mWarriorBean.getPosition().getColumn(), toCase);

                // 勇士原来的位置变成 Building.ROAD
                CaseBean fromCase = getCase(mWarriorBean.getPosition().getRow(), originColumn);
                fromCase.setType(Building.ROAD);
                fromCase.setResourceId(R.drawable.magic_tower_building_road);
                setCase(mWarriorBean.getPosition().getRow(), originColumn, toCase);
            }

            @Override
            public void onFailure() {

            }
        });
    }

    /**
     * Author: QinHao
     * Email:cqflqinhao@126.com
     * Date:2019/10/9 16:19
     * Description:勇士向下移动
     */
    public void warriorMoveDown() {
        // 勇士原来的位置的横坐标
        int originRow = mWarriorBean.getPosition().getRow();
        if (originRow == MAX_ROW - 1) {
            return;
        }

        // 勇士需要移动到的位置
        CaseBean caseBean = mFloorList.get(mFloor).getCase(originRow + 1, mWarriorBean.getPosition().getColumn());
        caseBean.handleEvent(mFragmentManager, new IHandleEventCallback() {
            @Override
            public void onSuccess(boolean canMove) {
                if (!canMove) {
                    return;
                }
                // 可以移动过去,则修改勇士属性
                mWarriorBean.setType(Warrior.DOWN);
                mWarriorBean.setResourceId(R.drawable.magic_tower_warrior_down);
                mWarriorBean.getPosition().setRow(originRow + 1);

                // 更新勇士现在的位置的 UI
                CaseBean toCase = getCase(mWarriorBean.getPosition().getRow(), mWarriorBean.getPosition().getColumn());
                toCase.setType(Warrior.DOWN);
                toCase.setResourceId(R.drawable.magic_tower_warrior_down);
                setCase(mWarriorBean.getPosition().getRow(), mWarriorBean.getPosition().getColumn(), toCase);

                // 勇士原来的位置变成 Building.ROAD
                CaseBean fromCase = getCase(originRow, mWarriorBean.getPosition().getColumn());
                fromCase.setType(Building.ROAD);
                fromCase.setResourceId(R.drawable.magic_tower_building_road);
                setCase(originRow, mWarriorBean.getPosition().getColumn(), fromCase);
            }

            @Override
            public void onFailure() {

            }
        });
    }

    /**
     * Author: QinHao
     * Email:cqflqinhao@126.com
     * Date:2019//8 18:52
     * Description:更新单个地图格的 UI
     *
     * @param caseBean 地图格子对象
     */
    public void updateUI(int row, int column, CaseBean caseBean) {
//        ((ImageView) ((TableRow) mTableLayout.getChildAt(caseBean.getRow())).getChildAt(caseBean.getColumn())).setImageResource(caseBean.getSpecificEntity(caseBean.getType()).getResourceId());
        TableRow tableRow = (TableRow) mTableLayout.getChildAt(row);
        ImageView imageView = (ImageView) tableRow.getChildAt(column);
        imageView.setImageResource(caseBean.getResourceId());
    }

    /**
     * Author: QinHao
     * Email:cqflqinhao@126.com
     * Date:2019/10/9 20:19
     * Description:保存地图所有楼层当前状态
     */
    public void save() {
        new Thread(new Runnable() {
            @Override
            public void run() {
//                String json = new Gson().toJson(mFloorList);
//                SharedPreferencesHelper.SINGLETON.putString(IConstant.MAP_JSON, json);
//                // 保存当前楼层
//                SharedPreferencesHelper.SINGLETON.putInt(IConstant.FLOOR, mFloor);
                // 保存勇士属性
//                SharedPreferencesHelper.SINGLETON.putString(IConstant.WARRIOR_BEAN_JSON, new Gson().toJson(WarriorBean.getInstance()));
            }
        }).start();
    }

    /**
     * Author: QinHao
     * Email:cqflqinhao@126.com
     * Date:2019/10/9 20:41
     * Description:读取之前存储的地图状态
     */
    public void read() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                String warriorBeanJson = SharedPreferencesHelper.SINGLETON.getString(IConstant.WARRIOR_BEAN_JSON);
                if (!TextUtils.isEmpty(warriorBeanJson)) {
                    mWarriorBean = new Gson().fromJson(warriorBeanJson, WarriorBean.class);
                }
//                mFloorList = new Gson().fromJson(SharedPreferencesHelper.SINGLETON.getString(IConstant.MAP_JSON), new TypeToken<List<List<AbsFloor>>>() {
//                getType());
//                // 读取保存的数据
//                mFloor = SharedPreferencesHelper.SINGLETON.getInt(IConstant.FLOOR);
//                // 读取勇士属性
//                mHandler.post(new Runnable() {
//                    @Override
//                    public void run() {
//                        updateUI();
//                        WarriorBean.getInstance().update();
//                    }
//                });
            }
        }).start();
    }

    /**
     * Author: QinHao
     * Email:cqflqinhao@126.com
     * Date:2019/10/10 18:33
     * Description:获取当前楼层的所有地图格子
     */
    public List<List<CaseBean>> getCurrentFloor() {
        return mFloorList.get(mFloor).getData();
    }

    /**
     * Author: QinHao
     * Email:cqflqinhao@126.com
     * Date:2019/10/11 14:43
     * Description:上楼
     */
    public void goUpstairs() {
        if (mFloor == mFloorList.size() - 1) {
            return;
        }
        mFloorList.get(mFloor).clearWarriorPosition();
        mFloor++;
        mFloorList.get(mFloor).initFloor(mTableLayout);
        mFloorList.get(mFloor).fromDownstairsToThisFloor();
    }

    /**
     * Author: QinHao
     * Email:cqflqinhao@126.com
     * Date:2019/10/11 14:44
     * Description:下楼
     */
    public void goDownstairs() {
        if (mFloor == 0) {
            return;
        }
        mFloorList.get(mFloor).clearWarriorPosition();
        mFloor--;
        mFloorList.get(mFloor).initFloor(mTableLayout);
        mFloorList.get(mFloor).fromUpstairsToThisFloor();
    }
}
