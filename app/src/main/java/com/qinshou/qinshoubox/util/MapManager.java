package com.qinshou.qinshoubox.util;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Looper;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;

import androidx.fragment.app.FragmentManager;

import com.qinshou.commonmodule.base.AbsDialogFragment;
import com.qinshou.commonmodule.util.ShowLogUtil;
import com.qinshou.qinshoubox.R;
import com.qinshou.qinshoubox.me.bean.CaseBean;
import com.qinshou.qinshoubox.me.bean.MonsterBean;
import com.qinshou.qinshoubox.me.bean.TalkerBean;
import com.qinshou.qinshoubox.me.bean.WarriorBean;
import com.qinshou.qinshoubox.me.bean.floor.AFloor;
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
import com.qinshou.qinshoubox.me.ui.dialog.BusinessManFloor12DialogFragment;
import com.qinshou.qinshoubox.me.ui.dialog.BusinessManFloor5DialogFragment;
import com.qinshou.qinshoubox.me.ui.dialog.MysteriousOldManFloor13DialogFragment;
import com.qinshou.qinshoubox.me.ui.dialog.MysteriousOldManFloor5DialogFragment;
import com.qinshou.qinshoubox.me.ui.dialog.StoreBigDialogFragment;
import com.qinshou.qinshoubox.me.ui.dialog.StoreSmallDialogFragment;
import com.qinshou.qinshoubox.me.ui.dialog.TalkDialogFragment;

import java.util.ArrayList;
import java.util.List;


/**
 * Description:地图管理类
 * Created by 禽兽先生
 * Created on 2018/4/11
 */

public enum MapManager {
    SINGLETON;

    private static final int MAX_ROW = 11;
    private static final int MAX_COLUMN = 11;
    private int mFloor = 0;
    private List<AFloor> floorList;
    private TableLayout mTableLayout;
    private Handler mHandler = new Handler(Looper.getMainLooper());

    MapManager() {
        floorList = new ArrayList<>();
        floorList.add(new Floor0());
        floorList.add(new Floor1());
        floorList.add(new Floor2());
        floorList.add(new Floor3());
        floorList.add(new Floor4());
        floorList.add(new Floor5());
        floorList.add(new Floor6());
        floorList.add(new Floor7());
        floorList.add(new Floor8());
        floorList.add(new Floor9());
        floorList.add(new Floor10());
        floorList.add(new Floor11());
        floorList.add(new Floor12());
        floorList.add(new Floor13());
        floorList.add(new Floor14());
        floorList.add(new Floor15());
        floorList.add(new Floor16());
        floorList.add(new Floor17());
        floorList.add(new Floor18());
        floorList.add(new Floor19());
        floorList.add(new Floor20());
        floorList.add(new Floor21());
    }

    public void initMap(TableLayout tableLayout) {
        mTableLayout = tableLayout;
        if (tableLayout.getChildCount() != MAX_ROW) {
            return;
        }
        floorList.get(mFloor).initFloor(tableLayout);
        floorList.get(mFloor).fromDownstairsToThisFloor();
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
    public CaseBean getCase(int row, int column) {
        return floorList.get(mFloor).getCase(row, column);
    }

    /**
     * Author: QinHao
     * Email:cqflqinhao@126.com
     * Date:2019//9 11:32
     * Description:重设某一格
     *
     * @param row      第几行
     * @param column   第几列
     * @param caseBean 格子对象
     */
    public void setCase(int row, int column, CaseBean caseBean) {
        floorList.get(mFloor).setCase(row, column, caseBean);
    }

    /**
     * Author: QinHao
     * Email:cqflqinhao@126.com
     * Date:2019/10/9 21:32
     * Description:更新整个地图的 UI
     */
    public void updateUI() {
        for (int i = 0; i < mTableLayout.getChildCount(); i++) {
            TableRow tableRow = (TableRow) mTableLayout.getChildAt(i);
            for (int j = 0; j < tableRow.getChildCount(); j++) {
                ImageView imageView = (ImageView) tableRow.getChildAt(j);
                CaseBean caseBean = floorList.get(mFloor).getCase(i, j);
                imageView.setImageResource(caseBean.getResourceId());
            }
        }
    }


    /**
     * Author: QinHao
     * Email:cqflqinhao@126.com
     * Date:2019//8 18:52
     * Description:更新单个地图格的 UI
     *
     * @param caseBean 地图格子对象
     */
    public void updateUI(CaseBean caseBean) {
//        ((ImageView) ((TableRow) mTableLayout.getChildAt(caseBean.getRow())).getChildAt(caseBean.getColumn())).setImageResource(caseBean.getSpecificEntity(caseBean.getType()).getResourceId());
        TableRow tableRow = (TableRow) mTableLayout.getChildAt(caseBean.getRow());
        ImageView imageView = (ImageView) tableRow.getChildAt(caseBean.getColumn());
        imageView.setImageResource(caseBean.getResourceId());
    }

    /**
     * Author: QinHao
     * Email:cqflqinhao@126.com
     * Date:2019/10/9 16:18
     * Description:勇士向左移动
     */
    public void warriorMoveLeft(FragmentManager fragmentManager) {
        WarriorBean warriorBean = WarriorBean.getInstance();
        WarriorBean.Position position = warriorBean.getPosition();
        if (position.getColumn() == 0) {
            return;
        }
        // 勇士需要移动到的位置
        CaseBean toCase = getCase(position.getRow(), position.getColumn() - 1);
        if (!handleToCase(toCase, fragmentManager)) {
            return;
        }
        toCase.setType(Warrior.LEFT);
        toCase.setResourceId(R.drawable.magic_tower_warrior_left);
        setCase(toCase.getRow(), toCase.getColumn(), toCase);
        updateUI(toCase);

        // 勇士原来的位置
        CaseBean fromCase = getCase(position.getRow(), position.getColumn());
        fromCase.setResourceId(R.drawable.magic_tower_building_road);
        fromCase.setType(Building.ROAD);
        setCase(fromCase.getRow(), fromCase.getColumn(), fromCase);
        updateUI(fromCase);

        // 修改勇士属性
        warriorBean.setType(Warrior.LEFT);
        warriorBean.setResourceId(R.drawable.magic_tower_warrior_left);
        warriorBean.getPosition().setColumn(warriorBean.getPosition().getColumn() - 1);
    }

    /**
     * Author: QinHao
     * Email:cqflqinhao@126.com
     * Date:2019/10/9 16:18
     * Description:勇士向上移动
     */
    public void warriorMoveUp(FragmentManager fragmentManager) {
        WarriorBean warriorBean = WarriorBean.getInstance();
        WarriorBean.Position position = warriorBean.getPosition();
        if (position.getRow() == 0) {
            return;
        }
        // 需要移动到的位置
        CaseBean toCase = getCase(position.getRow() - 1, position.getColumn());
        if (!handleToCase(toCase, fragmentManager)) {
            return;
        }
        toCase.setType(Warrior.UP);
        toCase.setResourceId(R.drawable.magic_tower_warrior_up);
        setCase(toCase.getRow(), toCase.getColumn(), toCase);
        updateUI(toCase);

        // 勇士原来的位置
        CaseBean fromCase = getCase(position.getRow(), position.getColumn());
        fromCase.setResourceId(R.drawable.magic_tower_building_road);
        fromCase.setType(Building.ROAD);
        setCase(fromCase.getRow(), fromCase.getColumn(), fromCase);
        updateUI(fromCase);

        // 修改勇士属性
        warriorBean.setType(Warrior.UP);
        warriorBean.setResourceId(R.drawable.magic_tower_warrior_up);
        warriorBean.getPosition().setRow(warriorBean.getPosition().getRow() - 1);
    }

    /**
     * Author: QinHao
     * Email:cqflqinhao@126.com
     * Date:2019/10/9 16:19
     * Description:勇士向右移动
     */
    public void warriorMoveRight(FragmentManager fragmentManager) {
        WarriorBean warriorBean = WarriorBean.getInstance();
        WarriorBean.Position position = warriorBean.getPosition();
        if (position.getColumn() == MAX_COLUMN - 1) {
            return;
        }
        // 勇士需要移动到的位置
        CaseBean toCase = getCase(position.getRow(), position.getColumn() + 1);
        if (!handleToCase(toCase, fragmentManager)) {
            return;
        }
        toCase.setType(Warrior.RIGHT);
        toCase.setResourceId(R.drawable.magic_tower_warrior_right);
        setCase(toCase.getRow(), toCase.getColumn(), toCase);
        updateUI(toCase);

        // 勇士原来的位置
        CaseBean fromCase = getCase(position.getRow(), position.getColumn());
        fromCase.setResourceId(R.drawable.magic_tower_building_road);
        fromCase.setType(Building.ROAD);
        setCase(fromCase.getRow(), fromCase.getColumn(), fromCase);
        updateUI(fromCase);

        // 修改勇士属性
        warriorBean.setType(Warrior.RIGHT);
        warriorBean.setResourceId(R.drawable.magic_tower_warrior_right);
        warriorBean.getPosition().setColumn(warriorBean.getPosition().getColumn() + 1);
    }

    /**
     * Author: QinHao
     * Email:cqflqinhao@126.com
     * Date:2019/10/9 16:19
     * Description:勇士向下移动
     */
    public void warriorMoveDown(FragmentManager fragmentManager) {
        WarriorBean warriorBean = WarriorBean.getInstance();
        WarriorBean.Position position = warriorBean.getPosition();
        if (position.getRow() == MAX_ROW - 1) {
            return;
        }
        // 勇士需要移动到的位置
        CaseBean toCase = getCase(position.getRow() + 1, position.getColumn());
        if (!handleToCase(toCase, fragmentManager)) {
            return;
        }
        toCase.setType(Warrior.DOWN);
        toCase.setResourceId(R.drawable.magic_tower_warrior_down);
        setCase(toCase.getRow(), toCase.getColumn(), toCase);
        updateUI(toCase);

        // 勇士原来的位置
        CaseBean fromCase = getCase(position.getRow(), position.getColumn());
        fromCase.setResourceId(R.drawable.magic_tower_building_road);
        fromCase.setType(Building.ROAD);
        setCase(fromCase.getRow(), fromCase.getColumn(), fromCase);
        updateUI(fromCase);

        // 修改勇士属性
        warriorBean.setType(Warrior.DOWN);
        warriorBean.setResourceId(R.drawable.magic_tower_warrior_down);
        warriorBean.getPosition().setRow(warriorBean.getPosition().getRow() + 1);
    }

    /**
     * Author: QinHao
     * Email:cqflqinhao@126.com
     * Date:2019/10/9 16:36
     * Description:勇士将要去的位置的预处理
     *
     * @param toCase 勇士将要去的位置
     */
    private boolean handleToCase(CaseBean toCase, FragmentManager fragmentManager) {
        if (toCase.getType() instanceof Building) {
            return handleBuildingToCase(toCase, fragmentManager);
        } else if (toCase.getType() instanceof Npc) {
            return handleNpcToCase(toCase, fragmentManager);
        } else if (toCase.getType() instanceof Prop) {
            return handlePropToCase(toCase, fragmentManager);
        } else if (toCase.getType() instanceof Monster) {
            return handleMonsterToCase(toCase, fragmentManager);
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
    private boolean handleBuildingToCase(CaseBean toCase, FragmentManager fragmentManager) {
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
    private boolean handleNpcToCase(CaseBean toCase, FragmentManager fragmentManager) {
        if (toCase.getType() == Npc.FAIRY_1) {
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
                    setToCase2Road(toCase);

                    CaseBean caseBean = new CaseBean(toCase.getFloor(), toCase.getRow(), toCase.getColumn() - 1, Npc.FAIRY_2, R.drawable.magic_tower_npc_fairy);
                    setCase(caseBean.getRow(), caseBean.getColumn(), caseBean);
                    updateUI(caseBean);

                    WarriorBean.getInstance().obtainYellowKey();
                    WarriorBean.getInstance().obtainBlueKey();
                    WarriorBean.getInstance().obtainRedKey();
                }
            });
        }
        if (toCase.getType() == Npc.FAIRY_2) {
            String[] content1 = new String[]{"……"
                    , "我找到了幸运十字架"
            };
            TalkerBean talker1 = new TalkerBean("勇士", R.drawable.magic_tower_warrior_down, content1);

            String[] content2 = new String[]{"你醒了！"
                    , "把你的生命,攻击,防御提高1/3"
            };
            TalkerBean talker2 = new TalkerBean("仙子", R.drawable.magic_tower_npc_fairy, content2);

            TalkDialogFragment talkDialogFragment = TalkDialogFragment.newInstance(talker1, talker2);
            talkDialogFragment.show(fragmentManager, "TalkDialogFragment");
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
            goUpstairs();
        } else if (toCase.getType() == Npc.GO_DOWNSTAIRS) {
            goDownstairs();
        } else if (toCase.getType() == Npc.GATE_YELLOW) {
            if (WarriorBean.getInstance().getYellowKeyCount() == 0) {
                ShowLogUtil.logi("没有黄钥匙啦,可以找五楼的商人买一把去.");
                return false;
            }
            setToCase2Road(toCase);

            WarriorBean.getInstance().loseYellowKey();
            WarriorBean.getInstance().update();
        } else if (toCase.getType() == Npc.GATE_BLUE) {
            if (WarriorBean.getInstance().getBlueKeyCount() == 0) {
                ShowLogUtil.logi("没有蓝钥匙啦,可以找五楼的商人买一把去.");
                return false;
            }
            setToCase2Road(toCase);

            WarriorBean.getInstance().loseBlueKey();
            WarriorBean.getInstance().update();
        } else if (toCase.getType() == Npc.GATE_RED) {
            if (WarriorBean.getInstance().getRedKeyCount() == 0) {
                ShowLogUtil.logi("没有红钥匙啦,可以找五楼的商人买一把去.");
                return false;
            }
            setToCase2Road(toCase);

            WarriorBean.getInstance().loseRedKey();
            WarriorBean.getInstance().update();
        } else if (toCase.getType() == Npc.GATE_GREEN) {
            setToCase2Road(toCase);
        } else if (toCase.getType() == Npc.GATE_IRON_OPEN) {
            setToCase2Road(toCase);
        } else if (toCase.getType() == Npc.GATE_IRON_CLOSE) {

        } else if (toCase.getType() == Npc.SHEN_MI_LAO_REN_FLOOR_2) {
            String[] content1 = new String[]{"您已经得救了!"
                    , "快走吧,我还得去救被关在这里的公主."
            };
            TalkerBean talker1 = new TalkerBean("勇士", R.drawable.magic_tower_warrior_down, content1);

            String[] content2 = new String[]{"哦,我的孩子,真是太感谢你了!这个地方又脏又坏,我真的是快呆不下去了."
                    , "哦,你是来救公主的,为了表示对你的感谢,这个东西就送给你吧,这还是我年轻的时候用过的.拿着它去解救公主吧!"
            };
            TalkerBean talker2 = new TalkerBean("神秘老人", R.drawable.magic_tower_npc_shen_mi_lao_ren, content2);

            TalkDialogFragment talkDialogFragment = TalkDialogFragment.newInstance(talker1, talker2);
            talkDialogFragment.show(fragmentManager, "TalkDialogFragment");
//            talkDialogFragment.setOnDismissListener(new OnDismissListener() {
//                @Override
//                public void onDismiss(DialogInterface dialog) {
//                    setToCase2Road(toCase);
//
//                    WarriorBean.getInstance().obtainSteelSword();
//                }
//            });
        } else if (toCase.getType() == Npc.SHANG_REN_FLOOR_2) {
            String[] content1 = new String[]{"您已经得救了!"
                    , "快走吧,现在您已经自由了.."
            };
            TalkerBean talker1 = new TalkerBean("勇士", R.drawable.magic_tower_warrior_down, content1);

            String[] content2 = new String[]{"哦,是吗!真是太感谢你了!我是个商人,不知道为什么被抓到这里来了."
                    , "哦,对对对,我已经自由了.那这个东西就送给你吧,本来我是准备卖钱的.相信它对你一定很有帮助!"
            };
            TalkerBean talker2 = new TalkerBean("神秘老人", R.drawable.magic_tower_npc_shen_mi_lao_ren, content2);

            TalkDialogFragment talkDialogFragment = TalkDialogFragment.newInstance(talker1, talker2);
            talkDialogFragment.show(fragmentManager, "TalkDialogFragment");
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
            new StoreSmallDialogFragment().show(fragmentManager, "StoreSmallDialogFragment");
        } else if (toCase.getType() == Npc.SHANG_DIAN_LAO_BAN_SMALL_3) {

        } else if (toCase.getType() == Npc.THIEF_1) {
            String[] content1 = new String[]{"你已经得救了"
                    , "快走吧,外面还有很多怪物,我可能顾不上你."
                    , "……你会开门吗?"
                    , "那就请你帮我打开第二层的门吧!"
                    , "嵌了红宝石的铁榔头?好吧,我帮你找找."
            };
            TalkerBean talker1 = new TalkerBean("勇士", R.drawable.magic_tower_warrior_down, content1);

            String[] content2 = new String[]{"啊,那真是太好了,我又可以在这里面寻宝了!哦,还没有自我介绍,我叫杰克,是这附近有名的小偷,什么金银财宝我样样都偷过.不过这次运气可不是太好,刚进来就被抓了.现在你帮我打开了门,那我就帮你做一件事吧."
                    , "不,不,不会有事的.快说吧,叫我做什么?"
                    , "那当然."
                    , "那个简单,不过,如果你能帮我找到一把嵌了红宝石的铁榔头的话,我还帮你打通第十八层的路."
                    , "非常的感谢,一会儿我便会将第二层的门打开.如果你找到那个铁榔头的话,还是来这里找我!"
            };
            TalkerBean talker2 = new TalkerBean("小偷", R.drawable.magic_tower_npc_thief, content2);

            TalkDialogFragment talkDialogFragment = TalkDialogFragment.newInstance(talker1, talker2);
            talkDialogFragment.show(fragmentManager, "TalkDialogFragment");
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
            new MysteriousOldManFloor5DialogFragment().show(fragmentManager, "MysteriousOldManFloor5DialogFragment");
        } else if (toCase.getType() == Npc.SHANG_REN_FLOOR_5) {
            new BusinessManFloor5DialogFragment().show(fragmentManager, "BusinessManFloor5DialogFragment");
        } else if (toCase.getType() == Npc.SHANG_DIAN_LAO_BAN_BIG_2) {
            new StoreBigDialogFragment().show(fragmentManager, "StoreBigDialogFragment");
        } else if (toCase.getType() == Npc.SHANG_REN_FLOOR_12) {
            new BusinessManFloor12DialogFragment().show(fragmentManager, "BusinessManFloor12DialogFragment");
        } else if (toCase.getType() == Npc.SHEN_MI_LAO_REN_FLOOR_13) {
            new MysteriousOldManFloor13DialogFragment().show(fragmentManager, "MysteriousOldManFloor13DialogFragment");
        } else if (toCase.getType() == Npc.SHEN_MI_LAO_REN_FLOOR_15) {
            String[] content1;
            String[] content2;
            boolean obtainHolyLightSword = WarriorBean.getInstance().obtainHolyLightSword();
            if (obtainHolyLightSword) {
                content1 = new String[]{"你好,勇敢的孩子,你终于来到这里了.我将给你一个非常好的宝物,它可以使你的攻击力提升120点,但这必须得用你的500点经验来进行交换,考虑一下子吧!"
                        , "那好吧,这把剑就给你了!"
                };

                content2 = new String[]{"好吧,那就将那把剑给我吧!"
                };
            } else {
                content1 = new String[]{"你好,勇敢的孩子,你终于来到这里了.我将给你一个非常好的宝物,它可以使你的攻击力提升120点,但这必须得用你的500点经验来进行交换,考虑一下子吧!"
                        , "对不起,你的经验不够哦,等你攒够了再来吧!"
                };
                content2 = new String[]{"好吧,那就将那把剑给我吧!"
                };
            }
            TalkerBean talker1 = new TalkerBean("神秘老人", R.drawable.magic_tower_npc_shen_mi_lao_ren, content1);
            TalkerBean talker2 = new TalkerBean("勇士", R.drawable.magic_tower_warrior_down, content2);

            TalkDialogFragment talkDialogFragment = TalkDialogFragment.newInstance(talker1, talker2);
            talkDialogFragment.show(fragmentManager, "TalkDialogFragment");
//            talkDialogFragment.setOnDismissListener(new OnDismissListener() {
//                @Override
//                public void onDismiss(DialogInterface dialog) {
//                    if (obtainHolyLightSword) {
//                        setToCase2Road(toCase);
//                    }
//                }
//            });
        } else if (toCase.getType() == Npc.SHANG_REN_FLOOR_15) {
            String[] content1;
            String[] content2;
            boolean obtainStarLightShield = WarriorBean.getInstance().obtainStarLightShield();
            if (obtainStarLightShield) {
                content1 = new String[]{"啊哈,欢迎你的到来!我这里有一件对你来说非常好的宝物,只要你出得起钱,我就卖给你."
                        , "是这个游戏最好的盾牌,防御值可以增加120点,而你只要出500个金币就可以买下.怎么样?你有500个金币吗?"
                        , "好,成交!"
                };

                content2 = new String[]{"什么宝物?要多少钱?"
                        , "我有500个金币."
                };
            } else {
                content1 = new String[]{"啊哈,欢迎你的到来!我这里有一件对你来说非常好的宝物,只要你出得起钱,我就卖给你."
                        , "是这个游戏最好的盾牌,防御值可以增加120点,而你只要出500个金币就可以买下.怎么样?你有500个金币吗?"
                        , "那等你凑够了再来吧!"
                };
                content2 = new String[]{"什么宝物?要多少钱?"
                        , "我没有500个金币."
                };
            }
            TalkerBean talker1 = new TalkerBean("商人", R.drawable.magic_tower_npc_shang_ren, content1);
            TalkerBean talker2 = new TalkerBean("勇士", R.drawable.magic_tower_warrior_down, content2);

            TalkDialogFragment talkDialogFragment = TalkDialogFragment.newInstance(talker1, talker2);
            talkDialogFragment.show(fragmentManager, "TalkDialogFragment");
//            talkDialogFragment.setOnDismissListener(new OnDismissListener() {
//                @Override
//                public void onDismiss(DialogInterface dialog) {
//                    if (obtainStarLightShield) {
//                        setToCase2Road(toCase);
//                    }
//                }
//            });
        } else if (toCase.getType() == Npc.PRINCESS) {
            String[] content1 = new String[]{"公主!你得救了!"
                    , "是的,我是奉国王的命令来救你的.请你快随我出去吧!"
                    , "为什么?这里面到处都是恶魔."
                    , "大恶魔?我已经杀死了一个魔王!"
                    , "好,那你等着,等我杀了那个恶魔再来这里找你!"
            };
            TalkerBean talker1 = new TalkerBean("勇士", R.drawable.magic_tower_warrior_down, content1);

            String[] content2 = new String[]{"啊,你是来救我的吗?"
                    , "不,我还不想走."
                    , "正是因为这里面到处都是恶魔,所以才不可以就这样出去,我要看着那个恶魔被杀死!英雄的勇士,如果你能够将那个大恶魔杀死,我就和你一起出去!"
                    , "大恶魔在这座塔的最顶层,你杀死的可能是一个小队长之类的恶魔."
                    , "大恶魔比你刚才杀死的那个厉害多了.而且他还会变身,变身后的魔王的攻击力和防御力都会提升至少一半以上,你要小心!请一定要杀死大魔王!"
            };
            TalkerBean talker2 = new TalkerBean("公主", R.drawable.magic_tower_npc_princess, content2);

            TalkDialogFragment talkDialogFragment = TalkDialogFragment.newInstance(talker1, talker2);
            talkDialogFragment.show(fragmentManager, "TalkDialogFragment");
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
     * Date:2019/10/15 19:36
     * Description:将目标小方块变为 Road
     *
     * @param toCase 目标小方块
     */
    private void setToCase2Road(CaseBean toCase) {
        toCase.setType(Building.ROAD);
        toCase.setResourceId(R.drawable.magic_tower_building_road);
        setCase(toCase.getRow(), toCase.getColumn(), toCase);
        updateUI(toCase);
    }

    /**
     * Author: QinHao
     * Email:cqflqinhao@126.com
     * Date:2019/10/11 14:43
     * Description:上楼
     */
    public void goUpstairs() {
        if (mFloor == floorList.size() - 1) {
            return;
        }
        floorList.get(mFloor).clearWarriorPosition();
        mFloor++;
        floorList.get(mFloor).initFloor(mTableLayout);
        floorList.get(mFloor).fromDownstairsToThisFloor();
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
        floorList.get(mFloor).clearWarriorPosition();
        mFloor--;
        floorList.get(mFloor).initFloor(mTableLayout);
        floorList.get(mFloor).fromUpstairsToThisFloor();
    }

    /**
     * Author: QinHao
     * Email:cqflqinhao@126.com
     * Date:2019/10/9 19:16
     * Description:勇士将要去的位置为道具类的处理
     *
     * @param toCase 勇士将要去的位置
     */
    private boolean handlePropToCase(CaseBean toCase, FragmentManager fragmentManager) {
        if (toCase.getType() == Prop.KEY_YELLOW) {
            WarriorBean.getInstance().obtainYellowKey();
        } else if (toCase.getType() == Prop.KEY_BLUE) {
            WarriorBean.getInstance().obtainBlueKey();
        } else if (toCase.getType() == Prop.KEY_RED) {
            WarriorBean.getInstance().obtainRedKey();
        } else if (toCase.getType() == Prop.XIE_PING_SMALL) {
            WarriorBean.getInstance().obtainSmallBloodBottle();
        } else if (toCase.getType() == Prop.XIE_PING_BIG) {
            WarriorBean.getInstance().obtainBigBloodBottle();
        } else if (toCase.getType() == Prop.BAO_SHI_RED) {
            WarriorBean.getInstance().obtainRedGem();
        } else if (toCase.getType() == Prop.BAO_SHI_BLUE) {
            WarriorBean.getInstance().obtainBlueGem();
        } else if (toCase.getType() == Prop.SHENG_GUANG_HUI) {
            WarriorBean.getInstance().obtainShengGuangHui();
        } else if (toCase.getType() == Prop.TIE_JIAN) {
            WarriorBean.getInstance().obtainIronSword();
        } else if (toCase.getType() == Prop.TIE_DUN) {
            WarriorBean.getInstance().obtainIronShield();
        } else if (toCase.getType() == Prop.YAO_SHI_HE) {
            WarriorBean.getInstance().obtainKeyBox();
        } else if (toCase.getType() == Prop.XIAO_FEI_YU) {
            WarriorBean.getInstance().obtainSmallFlightFeather();
        } else if (toCase.getType() == Prop.JIN_KUAI) {
            WarriorBean.getInstance().obtainGoldBullion();
        } else if (toCase.getType() == Prop.XING_YUN_SHI_ZI_JIA) {
            WarriorBean.getInstance().obtainLuckyCross();
        } else if (toCase.getType() == Prop.FENG_ZHI_LUO_PAN) {
            WarriorBean.getInstance().obtainWindCompass();
        } else if (toCase.getType() == Prop.QING_FENG_JIAN) {
            WarriorBean.getInstance().obtainQingFengSword();
        } else if (toCase.getType() == Prop.HUANG_JIN_DUN) {
            WarriorBean.getInstance().obtainGoldShield();
        } else if (toCase.getType() == Prop.XING_GUANG_SHEN_LANG) {
            WarriorBean.getInstance().obtainStarlightGodHammer();
        } else if (toCase.getType() == Prop.DA_FEI_YU) {
            WarriorBean.getInstance().obtainBigFlightFeather();
        } else if (toCase.getType() == Prop.SHENG_SHUI) {
            WarriorBean.getInstance().obtainHolyWater();
        } else if (toCase.getType() == Prop.XING_GUANG_SHEN_JIAN) {
            WarriorBean.getInstance().obtainStarLightGodSword();
        } else if (toCase.getType() == Prop.GUANG_MANG_SHEN_DUN) {
            WarriorBean.getInstance().obtainLightGodShield();
        }
        setToCase2Road(toCase);
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
    private boolean handleMonsterToCase(CaseBean toCase, FragmentManager fragmentManager) {
        WarriorBean warriorBean = WarriorBean.getInstance();
        MonsterBean monsterBean = MonsterFactory.getMonster((Monster) toCase.getType());
        int monsterEachBoutLossLifeValue = warriorBean.getAttackValue() - monsterBean.getDefenseValue();
        if (monsterEachBoutLossLifeValue <= 0) {
            ShowLogUtil.logi("打不过啊,兄dei,人家一点血不掉");
            return false;
        }
        // 每一回合失去的生命值
        int warriorEachBoutLossLifeValue = monsterBean.getAttackValue() - warriorBean.getDefenseValue() > 0
                ? monsterBean.getAttackValue() - warriorBean.getDefenseValue()
                : 0;
        // 向上取整
        int bout = (int) Math.ceil((double) monsterBean.getLifeValue() / (double) monsterEachBoutLossLifeValue);
        // 失去的总生命值
        int warriorTotalLossLifeValue = warriorEachBoutLossLifeValue * bout;
//        if (toCase.getType() == Monster.BAI_YI_WU_SHI) {
//            warriorTotalLossLifeValue += warriorBean.getLifeValue() / 4;
//        }
        if (warriorBean.getLifeValue() <= warriorTotalLossLifeValue) {
            ShowLogUtil.logi("打是打得动,但是打着打着你就死了啊,兄dei");
            return false;
        }
        BattleDialogFragment battleDialogFragment = BattleDialogFragment.newInstance(monsterBean);
        // 失去的总生命值
        int finalWarriorTotalLossLifeValue = warriorTotalLossLifeValue;
        battleDialogFragment.setOnDismissListener(new AbsDialogFragment.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {
                setToCase2Road(toCase);
                WarriorBean.getInstance().beatMonster(finalWarriorTotalLossLifeValue, monsterBean.getExperience(), monsterBean.getMoney());
            }
        });
        battleDialogFragment.show(fragmentManager, "BattleDialogFragment");
        return false;
    }

    /**
     * Author: QinHao
     * Email:cqflqinhao@126.com
     * Date:2019/10/9 20:19
     * Description:保存地图所有楼层当前状态
     */
    public void save(Context context) {
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                // 遍历所有层
//                for (int i = 0; i < floorList.size(); i++) {
//                    List<List<CaseBean>> floor = floorList.get(i).getData();
//                    // 遍历所有行
//                    for (int j = 0; j < floor.size(); j++) {
//                        List<CaseBean> row = floor.get(j);
//                        // 遍历每一行
//                        for (int k = 0; k < row.size(); k++) {
//                            CaseBean caseBean = DatabaseManager.SINGLETON.select(CaseBean.class, new Where.Builder()
//                                    .equal("floor", i)
//                                    .operator(Where.Operator.AND)
//                                    .equal("row", j)
//                                    .operator(Where.Operator.AND)
//                                    .equal("column", k)
//                                    .build());
//                            if (caseBean == null) {
//                                // 插入
//                                DatabaseManager.SINGLETON.insert(row.get(k));
//                            } else {
//                                // 更新
//                                DatabaseManager.SINGLETON.update(row.get(k), new Where.Builder()
//                                        .equal("floor", i)
//                                        .operator(Where.Operator.AND)
//                                        .equal("row", j)
//                                        .operator(Where.Operator.AND)
//                                        .equal("column", k)
//                                        .build());
//                            }
//                        }
//                    }
//                }
//                // 保存当前楼层
//                SharedPreferencesHelper.SINGLETON.putInt(Constant.SP_KEY_FLOOR, mFloor);
//                // 保存勇士属性
//                WarriorBean warriorBean = WarriorBean.getInstance();
//                SharedPreferencesHelper.SINGLETON.putString(Constant.SP_KEY_WARRIOR_NAME, warriorBean.getName());
//                SharedPreferencesHelper.SINGLETON.putString(Constant.SP_KEY_WARRIOR_TYPE, warriorBean.getType().toString());
//                SharedPreferencesHelper.SINGLETON.putInt(Constant.SP_KEY_WARRIOR_RESOURCE_ID, warriorBean.getResourceId());
//                SharedPreferencesHelper.SINGLETON.putInt(Constant.SP_KEY_WARRIOR_LEVEL, warriorBean.getLevel());
//                SharedPreferencesHelper.SINGLETON.putInt(Constant.SP_KEY_WARRIOR_LIFE_VALUE, warriorBean.getLifeValue());
//                SharedPreferencesHelper.SINGLETON.putInt(Constant.SP_KEY_WARRIOR_ATTACK_VALUE, warriorBean.getAttackValue());
//                SharedPreferencesHelper.SINGLETON.putInt(Constant.SP_KEY_WARRIOR_DEFENSE_VALUE, warriorBean.getDefenseValue());
//                SharedPreferencesHelper.SINGLETON.putInt(Constant.SP_KEY_WARRIOR_MONEY, warriorBean.getMoney());
//                SharedPreferencesHelper.SINGLETON.putInt(Constant.SP_KEY_WARRIOR_EXPERIENCE, warriorBean.getExperience());
//                SharedPreferencesHelper.SINGLETON.putInt(Constant.SP_KEY_WARRIOR_YELLOW_KEY_COUNT, warriorBean.getYellowKeyCount());
//                SharedPreferencesHelper.SINGLETON.putInt(Constant.SP_KEY_WARRIOR_BLUE_KEY_COUNT, warriorBean.getBlueKeyCount());
//                SharedPreferencesHelper.SINGLETON.putInt(Constant.SP_KEY_WARRIOR_RED_KEY_COUNT, warriorBean.getRedKeyCount());
//                SharedPreferencesHelper.SINGLETON.putBoolean(Constant.SP_KEY_WARRIOR_HAS_SHENG_GUANG_HUI, warriorBean.isHasShengGuangHui());
//                SharedPreferencesHelper.SINGLETON.putBoolean(Constant.SP_KEY_WARRIOR_HAS_FENG_ZHI_LUO_PAN, warriorBean.isHasFengZhiLuoPan());
//                SharedPreferencesHelper.SINGLETON.putBoolean(Constant.SP_KEY_WARRIOR_HAS_XING_GUANG_SHEN_LANG, warriorBean.isHasXingGuangShenLang());
//                SharedPreferencesHelper.SINGLETON.putBoolean(Constant.SP_KEY_WARRIOR_HAS_LUCKY_CROSS, warriorBean.isHasLuckyCross());
//                SharedPreferencesHelper.SINGLETON.putInt(Constant.SP_KEY_WARRIOR_POSITION_ROW, warriorBean.getPosition().getRow());
//                SharedPreferencesHelper.SINGLETON.putInt(Constant.SP_KEY_WARRIOR_POSITION_COLUMN, warriorBean.getPosition().getColumn());
//            }
//        }).start();
    }

    /**
     * Author: QinHao
     * Email:cqflqinhao@126.com
     * Date:2019/10/9 20:41
     * Description:读取之前存储的地图状态
     */
    public void read(Context context) {
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                // 读取保存的数据
//                List<CaseBean> caseBeanList = DatabaseManager.SINGLETON.selectList(CaseBean.class);
//                if (caseBeanList.size() == 0) {
//                    return;
//                }
//                // 设置地图状态
//                for (CaseBean caseBean : caseBeanList) {
//                    setCaseBeanType(caseBean);
//                    floorList.get(caseBean.getFloor()).setCase(caseBean.getRow(), caseBean.getColumn(), caseBean);
//                }
//                // 设置当前楼层
//                mFloor = SharedPreferencesHelper.SINGLETON.getInt(Constant.SP_KEY_FLOOR);
//                // 读取勇士属性
//                WarriorBean warriorBean = WarriorBean.getInstance();
//                warriorBean.setName(SharedPreferencesHelper.SINGLETON.getString(Constant.SP_KEY_WARRIOR_NAME));
//                String type = SharedPreferencesHelper.SINGLETON.getString(Constant.SP_KEY_WARRIOR_TYPE);
//                if (TextUtils.equals(type, Warrior.LEFT.toString())) {
//                    warriorBean.setType(Warrior.LEFT);
//                } else if (TextUtils.equals(type, Warrior.UP.toString())) {
//                    warriorBean.setType(Warrior.UP);
//                } else if (TextUtils.equals(type, Warrior.RIGHT.toString())) {
//                    warriorBean.setType(Warrior.RIGHT);
//                } else if (TextUtils.equals(type, Warrior.DOWN.toString())) {
//                    warriorBean.setType(Warrior.DOWN);
//                }
//                warriorBean.setResourceId(SharedPreferencesHelper.SINGLETON.getInt(Constant.SP_KEY_WARRIOR_LEVEL));
//                warriorBean.setLifeValue(SharedPreferencesHelper.SINGLETON.getInt(Constant.SP_KEY_WARRIOR_LIFE_VALUE));
//                warriorBean.setAttackValue(SharedPreferencesHelper.SINGLETON.getInt(Constant.SP_KEY_WARRIOR_ATTACK_VALUE));
//                warriorBean.setDefenseValue(SharedPreferencesHelper.SINGLETON.getInt(Constant.SP_KEY_WARRIOR_DEFENSE_VALUE));
//                warriorBean.setMoney(SharedPreferencesHelper.SINGLETON.getInt(Constant.SP_KEY_WARRIOR_MONEY));
//                warriorBean.setExperience(SharedPreferencesHelper.SINGLETON.getInt(Constant.SP_KEY_WARRIOR_EXPERIENCE));
//                warriorBean.setYellowKeyCount(SharedPreferencesHelper.SINGLETON.getInt(Constant.SP_KEY_WARRIOR_YELLOW_KEY_COUNT));
//                warriorBean.setBlueKeyCount(SharedPreferencesHelper.SINGLETON.getInt(Constant.SP_KEY_WARRIOR_BLUE_KEY_COUNT));
//                warriorBean.setResourceId(SharedPreferencesHelper.SINGLETON.getInt(Constant.SP_KEY_WARRIOR_RED_KEY_COUNT));
//                warriorBean.setHasShengGuangHui(SharedPreferencesHelper.SINGLETON.getBoolean(Constant.SP_KEY_WARRIOR_HAS_SHENG_GUANG_HUI));
//                warriorBean.setHasFengZhiLuoPan(SharedPreferencesHelper.SINGLETON.getBoolean(Constant.SP_KEY_WARRIOR_HAS_FENG_ZHI_LUO_PAN));
//                warriorBean.setHasXingGuangShenLang(SharedPreferencesHelper.SINGLETON.getBoolean(Constant.SP_KEY_WARRIOR_HAS_XING_GUANG_SHEN_LANG));
//                warriorBean.setHasLuckyCross(SharedPreferencesHelper.SINGLETON.getBoolean(Constant.SP_KEY_WARRIOR_HAS_LUCKY_CROSS));
//                warriorBean.getPosition().setRow(SharedPreferencesHelper.SINGLETON.getInt(Constant.SP_KEY_WARRIOR_POSITION_ROW));
//                warriorBean.getPosition().setColumn(SharedPreferencesHelper.SINGLETON.getInt(Constant.SP_KEY_WARRIOR_POSITION_COLUMN));
//                mHandler.post(new Runnable() {
//                    @Override
//                    public void run() {
//                        updateUI();
//                        warriorBean.update();
//                    }
//                });
//            }
//
//            private void setCaseBeanType(CaseBean caseBean) {
//                if (TextUtils.equals(caseBean.getTypeValue(), Building.ROAD.toString())) {
//                    caseBean.setType(Building.ROAD);
//                } else if (TextUtils.equals(caseBean.getTypeValue(), Building.WALL.toString())) {
//                    caseBean.setType(Building.WALL);
//                } else if (TextUtils.equals(caseBean.getTypeValue(), Building.STARRY_SKY.toString())) {
//                    caseBean.setType(Building.STARRY_SKY);
//                } else if (TextUtils.equals(caseBean.getTypeValue(), Building.FIRE_SEA.toString())) {
//                    caseBean.setType(Building.FIRE_SEA);
//                } else if (TextUtils.equals(caseBean.getTypeValue(), Monster.LV_TOU_GUAI.toString())) {
//                    caseBean.setType(Monster.LV_TOU_GUAI);
//                } else if (TextUtils.equals(caseBean.getTypeValue(), Monster.HONG_TOU_GUAI.toString())) {
//                    caseBean.setType(Monster.HONG_TOU_GUAI);
//                } else if (TextUtils.equals(caseBean.getTypeValue(), Monster.KU_LOU_REN.toString())) {
//                    caseBean.setType(Monster.KU_LOU_REN);
//                } else if (TextUtils.equals(caseBean.getTypeValue(), Monster.KU_LOU_SHI_BING.toString())) {
//                    caseBean.setType(Monster.KU_LOU_SHI_BING);
//                } else if (TextUtils.equals(caseBean.getTypeValue(), Monster.CHU_JI_FA_SHI.toString())) {
//                    caseBean.setType(Monster.CHU_JI_FA_SHI);
//                } else if (TextUtils.equals(caseBean.getTypeValue(), Monster.XIAO_BIAN_FU.toString())) {
//                    caseBean.setType(Monster.XIAO_BIAN_FU);
//                } else if (TextUtils.equals(caseBean.getTypeValue(), Monster.QING_TOU_GUAI.toString())) {
//                    caseBean.setType(Monster.QING_TOU_GUAI);
//                } else if (TextUtils.equals(caseBean.getTypeValue(), Monster.SHOU_MIAN_REN.toString())) {
//                    caseBean.setType(Monster.SHOU_MIAN_REN);
//                } else if (TextUtils.equals(caseBean.getTypeValue(), Monster.JIN_WEI_SHI.toString())) {
//                    caseBean.setType(Monster.JIN_WEI_SHI);
//                } else if (TextUtils.equals(caseBean.getTypeValue(), Monster.JIN_DUI_ZHANG.toString())) {
//                    caseBean.setType(Monster.JIN_DUI_ZHANG);
//                } else if (TextUtils.equals(caseBean.getTypeValue(), Monster.DA_BIAN_FU.toString())) {
//                    caseBean.setType(Monster.DA_BIAN_FU);
//                } else if (TextUtils.equals(caseBean.getTypeValue(), Monster.HONG_BIAN_FU.toString())) {
//                    caseBean.setType(Monster.HONG_BIAN_FU);
//                } else if (TextUtils.equals(caseBean.getTypeValue(), Monster.CHU_JI_WEI_BING.toString())) {
//                    caseBean.setType(Monster.CHU_JI_WEI_BING);
//                } else if (TextUtils.equals(caseBean.getTypeValue(), Monster.KU_LOU_DUI_ZHANG.toString())) {
//                    caseBean.setType(Monster.KU_LOU_DUI_ZHANG);
//                } else if (TextUtils.equals(caseBean.getTypeValue(), Monster.GUAI_WANG.toString())) {
//                    caseBean.setType(Monster.GUAI_WANG);
//                } else if (TextUtils.equals(caseBean.getTypeValue(), Monster.SHI_TOU_GUAI_REN.toString())) {
//                    caseBean.setType(Monster.SHI_TOU_GUAI_REN);
//                } else if (TextUtils.equals(caseBean.getTypeValue(), Monster.HONG_YI_FA_SHI.toString())) {
//                    caseBean.setType(Monster.HONG_YI_FA_SHI);
//                } else if (TextUtils.equals(caseBean.getTypeValue(), Monster.GAO_JI_FA_SHI.toString())) {
//                    caseBean.setType(Monster.GAO_JI_FA_SHI);
//                } else if (TextUtils.equals(caseBean.getTypeValue(), Monster.BAI_YI_WU_SHI.toString())) {
//                    caseBean.setType(Monster.BAI_YI_WU_SHI);
//                } else if (TextUtils.equals(caseBean.getTypeValue(), Monster.MA_YI_FA_SHI.toString())) {
//                    caseBean.setType(Monster.MA_YI_FA_SHI);
//                } else if (TextUtils.equals(caseBean.getTypeValue(), Monster.SHOU_MIAN_WU_SHI.toString())) {
//                    caseBean.setType(Monster.SHOU_MIAN_WU_SHI);
//                } else if (TextUtils.equals(caseBean.getTypeValue(), Monster.MING_WEI_BING.toString())) {
//                    caseBean.setType(Monster.MING_WEI_BING);
//                } else if (TextUtils.equals(caseBean.getTypeValue(), Monster.GAO_JI_WEI_BING.toString())) {
//                    caseBean.setType(Monster.GAO_JI_WEI_BING);
//                } else if (TextUtils.equals(caseBean.getTypeValue(), Monster.SHUANG_SHOU_JIAN_SHI.toString())) {
//                    caseBean.setType(Monster.SHUANG_SHOU_JIAN_SHI);
//                } else if (TextUtils.equals(caseBean.getTypeValue(), Monster.LING_WU_SHI_1.toString())) {
//                    caseBean.setType(Monster.LING_WU_SHI_1);
//                } else if (TextUtils.equals(caseBean.getTypeValue(), Monster.LING_WU_SHI_2.toString())) {
//                    caseBean.setType(Monster.LING_WU_SHI_2);
//                } else if (TextUtils.equals(caseBean.getTypeValue(), Monster.MING_ZHAN_SHI.toString())) {
//                    caseBean.setType(Monster.MING_ZHAN_SHI);
//                } else if (TextUtils.equals(caseBean.getTypeValue(), Monster.LING_FA_SHI_1.toString())) {
//                    caseBean.setType(Monster.LING_FA_SHI_1);
//                } else if (TextUtils.equals(caseBean.getTypeValue(), Monster.LING_FA_SHI_2.toString())) {
//                    caseBean.setType(Monster.LING_FA_SHI_2);
//                } else if (TextUtils.equals(caseBean.getTypeValue(), Monster.MING_DUI_ZHANG_1.toString())) {
//                    caseBean.setType(Monster.MING_DUI_ZHANG_1);
//                } else if (TextUtils.equals(caseBean.getTypeValue(), Monster.MING_DUI_ZHANG_2.toString())) {
//                    caseBean.setType(Monster.MING_DUI_ZHANG_2);
//                } else if (TextUtils.equals(caseBean.getTypeValue(), Monster.HONG_YI_MO_WANG_1.toString())) {
//                    caseBean.setType(Monster.HONG_YI_MO_WANG_1);
//                } else if (TextUtils.equals(caseBean.getTypeValue(), Monster.HONG_YI_MO_WANG_2.toString())) {
//                    caseBean.setType(Monster.HONG_YI_MO_WANG_2);
//                } else if (TextUtils.equals(caseBean.getTypeValue(), Monster.YING_ZI_ZHAN_SHI.toString())) {
//                    caseBean.setType(Monster.YING_ZI_ZHAN_SHI);
//                } else if (TextUtils.equals(caseBean.getTypeValue(), Monster.MING_LING_MO_WANG_1.toString())) {
//                    caseBean.setType(Monster.MING_LING_MO_WANG_1);
//                } else if (TextUtils.equals(caseBean.getTypeValue(), Monster.MING_LING_MO_WANG_2.toString())) {
//                    caseBean.setType(Monster.MING_LING_MO_WANG_2);
//                } else if (TextUtils.equals(caseBean.getTypeValue(), Npc.FAIRY_1.toString())) {
//                    caseBean.setType(Npc.FAIRY_1);
//                } else if (TextUtils.equals(caseBean.getTypeValue(), Npc.FAIRY_2.toString())) {
//                    caseBean.setType(Npc.FAIRY_2);
//                } else if (TextUtils.equals(caseBean.getTypeValue(), Npc.GO_UPSTAIRS.toString())) {
//                    caseBean.setType(Npc.GO_UPSTAIRS);
//                } else if (TextUtils.equals(caseBean.getTypeValue(), Npc.GO_DOWNSTAIRS.toString())) {
//                    caseBean.setType(Npc.GO_DOWNSTAIRS);
//                } else if (TextUtils.equals(caseBean.getTypeValue(), Npc.GATE_YELLOW.toString())) {
//                    caseBean.setType(Npc.GATE_YELLOW);
//                } else if (TextUtils.equals(caseBean.getTypeValue(), Npc.GATE_BLUE.toString())) {
//                    caseBean.setType(Npc.GATE_BLUE);
//                } else if (TextUtils.equals(caseBean.getTypeValue(), Npc.GATE_RED.toString())) {
//                    caseBean.setType(Npc.GATE_RED);
//                } else if (TextUtils.equals(caseBean.getTypeValue(), Npc.GATE_GREEN.toString())) {
//                    caseBean.setType(Npc.GATE_GREEN);
//                } else if (TextUtils.equals(caseBean.getTypeValue(), Npc.GATE_IRON_OPEN.toString())) {
//                    caseBean.setType(Npc.GATE_IRON_OPEN);
//                } else if (TextUtils.equals(caseBean.getTypeValue(), Npc.GATE_IRON_CLOSE.toString())) {
//                    caseBean.setType(Npc.GATE_IRON_CLOSE);
//                } else if (TextUtils.equals(caseBean.getTypeValue(), Npc.SHEN_MI_LAO_REN_FLOOR_2.toString())) {
//                    caseBean.setType(Npc.SHEN_MI_LAO_REN_FLOOR_2);
//                } else if (TextUtils.equals(caseBean.getTypeValue(), Npc.SHANG_REN_FLOOR_2.toString())) {
//                    caseBean.setType(Npc.SHANG_REN_FLOOR_2);
//                } else if (TextUtils.equals(caseBean.getTypeValue(), Npc.SHANG_DIAN_LAO_BAN_SMALL_1.toString())) {
//                    caseBean.setType(Npc.SHANG_DIAN_LAO_BAN_SMALL_1);
//                } else if (TextUtils.equals(caseBean.getTypeValue(), Npc.SHANG_DIAN_LAO_BAN_SMALL_2.toString())) {
//                    caseBean.setType(Npc.SHANG_DIAN_LAO_BAN_SMALL_2);
//                } else if (TextUtils.equals(caseBean.getTypeValue(), Npc.SHANG_DIAN_LAO_BAN_SMALL_3.toString())) {
//                    caseBean.setType(Npc.SHANG_DIAN_LAO_BAN_SMALL_3);
//                } else if (TextUtils.equals(caseBean.getTypeValue(), Npc.THIEF_1.toString())) {
//                    caseBean.setType(Npc.THIEF_1);
//                } else if (TextUtils.equals(caseBean.getTypeValue(), Npc.THIEF_2.toString())) {
//                    caseBean.setType(Npc.THIEF_2);
//                } else if (TextUtils.equals(caseBean.getTypeValue(), Npc.SHEN_MI_LAO_REN_FLOOR_5.toString())) {
//                    caseBean.setType(Npc.SHEN_MI_LAO_REN_FLOOR_5);
//                } else if (TextUtils.equals(caseBean.getTypeValue(), Npc.SHANG_REN_FLOOR_5.toString())) {
//                    caseBean.setType(Npc.SHANG_REN_FLOOR_5);
//                } else if (TextUtils.equals(caseBean.getTypeValue(), Npc.SHANG_DIAN_LAO_BAN_BIG_1.toString())) {
//                    caseBean.setType(Npc.SHANG_DIAN_LAO_BAN_BIG_1);
//                } else if (TextUtils.equals(caseBean.getTypeValue(), Npc.SHANG_DIAN_LAO_BAN_BIG_2.toString())) {
//                    caseBean.setType(Npc.SHANG_DIAN_LAO_BAN_BIG_2);
//                } else if (TextUtils.equals(caseBean.getTypeValue(), Npc.SHANG_DIAN_LAO_BAN_BIG_3.toString())) {
//                    caseBean.setType(Npc.SHANG_DIAN_LAO_BAN_BIG_3);
//                } else if (TextUtils.equals(caseBean.getTypeValue(), Npc.SHANG_REN_FLOOR_12.toString())) {
//                    caseBean.setType(Npc.SHANG_REN_FLOOR_12);
//                } else if (TextUtils.equals(caseBean.getTypeValue(), Npc.SHEN_MI_LAO_REN_FLOOR_13.toString())) {
//                    caseBean.setType(Npc.SHEN_MI_LAO_REN_FLOOR_13);
//                } else if (TextUtils.equals(caseBean.getTypeValue(), Npc.SHANG_REN_FLOOR_15.toString())) {
//                    caseBean.setType(Npc.SHANG_REN_FLOOR_15);
//                } else if (TextUtils.equals(caseBean.getTypeValue(), Npc.SHEN_MI_LAO_REN_FLOOR_15.toString())) {
//                    caseBean.setType(Npc.SHEN_MI_LAO_REN_FLOOR_15);
//                } else if (TextUtils.equals(caseBean.getTypeValue(), Npc.PRINCESS.toString())) {
//                    caseBean.setType(Npc.PRINCESS);
//                } else if (TextUtils.equals(caseBean.getTypeValue(), Prop.KEY_YELLOW.toString())) {
//                    caseBean.setType(Prop.KEY_YELLOW);
//                } else if (TextUtils.equals(caseBean.getTypeValue(), Prop.KEY_BLUE.toString())) {
//                    caseBean.setType(Prop.KEY_BLUE);
//                } else if (TextUtils.equals(caseBean.getTypeValue(), Prop.KEY_RED.toString())) {
//                    caseBean.setType(Prop.KEY_RED);
//                } else if (TextUtils.equals(caseBean.getTypeValue(), Prop.XIE_PING_SMALL.toString())) {
//                    caseBean.setType(Prop.XIE_PING_SMALL);
//                } else if (TextUtils.equals(caseBean.getTypeValue(), Prop.XIE_PING_BIG.toString())) {
//                    caseBean.setType(Prop.XIE_PING_BIG);
//                } else if (TextUtils.equals(caseBean.getTypeValue(), Prop.BAO_SHI_RED.toString())) {
//                    caseBean.setType(Prop.BAO_SHI_RED);
//                } else if (TextUtils.equals(caseBean.getTypeValue(), Prop.BAO_SHI_BLUE.toString())) {
//                    caseBean.setType(Prop.BAO_SHI_BLUE);
//                } else if (TextUtils.equals(caseBean.getTypeValue(), Prop.SHENG_GUANG_HUI.toString())) {
//                    caseBean.setType(Prop.SHENG_GUANG_HUI);
//                } else if (TextUtils.equals(caseBean.getTypeValue(), Prop.TIE_JIAN.toString())) {
//                    caseBean.setType(Prop.TIE_JIAN);
//                } else if (TextUtils.equals(caseBean.getTypeValue(), Prop.TIE_DUN.toString())) {
//                    caseBean.setType(Prop.TIE_DUN);
//                } else if (TextUtils.equals(caseBean.getTypeValue(), Prop.YAO_SHI_HE.toString())) {
//                    caseBean.setType(Prop.YAO_SHI_HE);
//                } else if (TextUtils.equals(caseBean.getTypeValue(), Prop.XIAO_FEI_YU.toString())) {
//                    caseBean.setType(Prop.XIAO_FEI_YU);
//                } else if (TextUtils.equals(caseBean.getTypeValue(), Prop.JIN_KUAI.toString())) {
//                    caseBean.setType(Prop.JIN_KUAI);
//                } else if (TextUtils.equals(caseBean.getTypeValue(), Prop.XING_YUN_SHI_ZI_JIA.toString())) {
//                    caseBean.setType(Prop.XING_YUN_SHI_ZI_JIA);
//                } else if (TextUtils.equals(caseBean.getTypeValue(), Prop.FENG_ZHI_LUO_PAN.toString())) {
//                    caseBean.setType(Prop.FENG_ZHI_LUO_PAN);
//                } else if (TextUtils.equals(caseBean.getTypeValue(), Prop.QING_FENG_JIAN.toString())) {
//                    caseBean.setType(Prop.QING_FENG_JIAN);
//                } else if (TextUtils.equals(caseBean.getTypeValue(), Prop.HUANG_JIN_DUN.toString())) {
//                    caseBean.setType(Prop.HUANG_JIN_DUN);
//                } else if (TextUtils.equals(caseBean.getTypeValue(), Prop.XING_GUANG_SHEN_LANG.toString())) {
//                    caseBean.setType(Prop.XING_GUANG_SHEN_LANG);
//                } else if (TextUtils.equals(caseBean.getTypeValue(), Prop.DA_FEI_YU.toString())) {
//                    caseBean.setType(Prop.DA_FEI_YU);
//                } else if (TextUtils.equals(caseBean.getTypeValue(), Prop.SHENG_SHUI.toString())) {
//                    caseBean.setType(Prop.SHENG_SHUI);
//                } else if (TextUtils.equals(caseBean.getTypeValue(), Prop.XING_GUANG_SHEN_JIAN.toString())) {
//                    caseBean.setType(Prop.XING_GUANG_SHEN_JIAN);
//                } else if (TextUtils.equals(caseBean.getTypeValue(), Prop.GUANG_MANG_SHEN_DUN.toString())) {
//                    caseBean.setType(Prop.GUANG_MANG_SHEN_DUN);
//                } else if (TextUtils.equals(caseBean.getTypeValue(), Warrior.LEFT.toString())) {
//                    caseBean.setType(Warrior.LEFT);
//                } else if (TextUtils.equals(caseBean.getTypeValue(), Warrior.UP.toString())) {
//                    caseBean.setType(Warrior.UP);
//                } else if (TextUtils.equals(caseBean.getTypeValue(), Warrior.RIGHT.toString())) {
//                    caseBean.setType(Warrior.RIGHT);
//                } else if (TextUtils.equals(caseBean.getTypeValue(), Warrior.DOWN.toString())) {
//                    caseBean.setType(Warrior.DOWN);
//                }
//            }
//        }).start();
    }

    /**
     * Author: QinHao
     * Email:cqflqinhao@126.com
     * Date:2019/10/10 18:33
     * Description:获取当前楼层的所有地图格子
     */
    public List<List<CaseBean>> getCurrentFloor() {
        return floorList.get(mFloor).getData();
    }
//    public void setToCase2Road(CaseBean toCase) {
//        toCase.setType(CaseBean.BUILDING_ROAD);
//        setCase(toCase.getRow(), toCase.getColumn(), toCase);
//        updateUI(toCase);
//    }
}
