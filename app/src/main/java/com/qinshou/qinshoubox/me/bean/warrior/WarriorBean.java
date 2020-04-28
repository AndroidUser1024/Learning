package com.qinshou.qinshoubox.me.bean.warrior;


import com.qinshou.qinshoubox.R;
import com.qinshou.qinshoubox.homepage.bean.EventBean;
import com.qinshou.qinshoubox.me.bean.CaseBean;
import com.qinshou.qinshoubox.me.bean.IHandleEventCallback;
import com.qinshou.qinshoubox.me.bean.Position;

import androidx.fragment.app.FragmentManager;

import org.greenrobot.eventbus.EventBus;


/**
 * Description:勇士实体类
 * Created by 禽兽先生
 * Created on 2017/6/15
 */

public class WarriorBean implements CaseBean {
    private String name;
    private Type type;
    private int level;
    private int lifeValue;
    private int attackValue;
    private int defenseValue;
    private int money;
    private int experience;
    private int yellowKeyCount;
    private int blueKeyCount;
    private int redKeyCount;
    private boolean hasHolyLightBadge;
    private boolean hasWindCompass;
    private boolean hasStarLightGodHammer;
    private boolean hasLuckyCross;
    private Position position;

    public WarriorBean() {
    }

    public WarriorBean(String name, Type type, int level, int lifeValue, int attackValue, int defenseValue, int money, int experience, int yellowKeyCount, int blueKeyCount, int redKeyCount, boolean hasHolyLightBadge, boolean hasWindCompass, boolean hasStarLightGodHammer, boolean hasLuckyCross, Position position) {
        this.name = name;
        this.type = type;
        this.level = level;
        this.lifeValue = lifeValue;
        this.attackValue = attackValue;
        this.defenseValue = defenseValue;
        this.money = money;
        this.experience = experience;
        this.yellowKeyCount = yellowKeyCount;
        this.blueKeyCount = blueKeyCount;
        this.redKeyCount = redKeyCount;
        this.hasHolyLightBadge = hasHolyLightBadge;
        this.hasWindCompass = hasWindCompass;
        this.hasStarLightGodHammer = hasStarLightGodHammer;
        this.hasLuckyCross = hasLuckyCross;
        this.position = position;
    }

    @Override
    public String toString() {
        return "勇士信息{" +
                "当前坐标:" + position +
                ", 等级:" + level +
                ", 生命值:" + lifeValue +
                ", 攻击:" + attackValue +
                ", 防御:" + defenseValue +
                ", 金钱:" + money +
                ", 经验:" + experience +
                ", 黄钥匙数量:" + yellowKeyCount +
                ", 蓝钥匙数量:" + blueKeyCount +
                ", 红钥匙数量:" + redKeyCount +
                ", 是否拥有圣光徽:" + hasHolyLightBadge +
                ", 是否拥有风之罗盘:" + hasWindCompass +
                ", 是否拥有星光神榔:" + hasStarLightGodHammer +
                ", 是否拥有幸运十字架:" + hasLuckyCross +
                '}';
    }

    @Override
    public int getResourceId() {
        switch (type) {
            case LEFT:
                return R.drawable.magic_tower_warrior_left;
            case UP:
                return R.drawable.magic_tower_warrior_up;
            case RIGHT:
                return R.drawable.magic_tower_warrior_right;
            case DOWN:
            default:
                return R.drawable.magic_tower_warrior_down;
        }
    }

    @Override
    public void handleEvent(FragmentManager fragmentManager, int floor, Position position, IHandleEventCallback handleEventCallback) {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int mLevel) {
        this.level = mLevel;
    }

    public int getLifeValue() {
        return lifeValue;
    }

    public void setLifeValue(int mLifeValue) {
        this.lifeValue = mLifeValue;
    }

    public int getAttackValue() {
        return attackValue;
    }

    public void setAttackValue(int mAttackValue) {
        this.attackValue = mAttackValue;
    }

    public int getDefenseValue() {
        return defenseValue;
    }

    public void setDefenseValue(int mDefenseValue) {
        this.defenseValue = mDefenseValue;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int mMoney) {
        this.money = mMoney;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int mExperience) {
        this.experience = mExperience;
    }

    public int getYellowKeyCount() {
        return yellowKeyCount;
    }

    public void setYellowKeyCount(int mYellowKeyCount) {
        this.yellowKeyCount = mYellowKeyCount;
    }

    public int getBlueKeyCount() {
        return blueKeyCount;
    }

    public void setBlueKeyCount(int mBlueKeyCount) {
        this.blueKeyCount = mBlueKeyCount;
    }

    public int getRedKeyCount() {
        return redKeyCount;
    }

    public void setRedKeyCount(int mRedKeyCount) {
        this.redKeyCount = mRedKeyCount;
    }

    public boolean isHasHolyLightBadge() {
        return hasHolyLightBadge;
    }

    public void setHasHolyLightBadge(boolean hasHolyLightBadge) {
        this.hasHolyLightBadge = hasHolyLightBadge;
    }

    public boolean isHasWindCompass() {
        return hasWindCompass;
    }

    public void setHasWindCompass(boolean hasWindCompass) {
        this.hasWindCompass = hasWindCompass;
    }

    public boolean isHasStarLightGodHammer() {
        return hasStarLightGodHammer;
    }

    public void setHasStarLightGodHammer(boolean hasStarLightGodHammer) {
        this.hasStarLightGodHammer = hasStarLightGodHammer;
    }

    public boolean isHasLuckyCross() {
        return hasLuckyCross;
    }

    public void setHasLuckyCross(boolean hasLuckyCross) {
        this.hasLuckyCross = hasLuckyCross;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    /**
     * Author: QinHao
     * Email:cqflqinhao@126.com
     * Date:2019/10/9 18:09
     * Description:像观察者们发送更新通知
     */
    public void update() {
        EventBus.getDefault().post(new EventBean<WarriorBean>(EventBean.Type.REFRESH_WARRIOR_INFO, this));
        // 标识状态或内容发生改变
//        setChanged();
        // 通知所有观察者
//        notifyObservers();
    }

    /**
     * Author: QinHao
     * Email:cqflqinhao@126.com
     * Date:2019/10/12 19:24
     * Description:卖出 1 把黄钥匙得到 7 金币
     */
    public boolean sellYellowKeyFor7Money() {
        if (yellowKeyCount == 0) {
            return false;
        }
        yellowKeyCount--;
        money += 7;
        update();
        return true;
    }

    /**
     * Author: QinHao
     * Email:cqflqinhao@126.com
     * Date:2019/10/12 19:24
     * Description:卖出 1 把蓝钥匙得到 35 金币
     */
    public boolean sellBlueKeyFor35Money() {
        if (blueKeyCount == 0) {
            return false;
        }
        blueKeyCount--;
        money += 35;
        update();
        return true;
    }

    /**
     * Author: QinHao
     * Email:cqflqinhao@126.com
     * Date:2019/10/12 19:24
     * Description:卖出 1 把红钥匙得到 70 金币
     */
    public boolean sellRedKeyFor70Money() {
        if (redKeyCount == 0) {
            return false;
        }
        redKeyCount--;
        money += 70;
        update();
        return true;
    }

    /**
     * Author: QinHao
     * Email:cqflqinhao@126.com
     * Date:2019/10/12 19:30
     * Description:获得星光神榔
     */
    public void obtainStarlightGodHammer() {
        hasStarLightGodHammer = true;
        update();
    }

    /**
     * Author: QinHao
     * Email:cqflqinhao@126.com
     * Date:2019/10/13 10:22
     * Description:升 3 级
     */
    public boolean levelUp3() {
        if (experience < 270) {
            return false;
        }
        level += 3;
        lifeValue += 3000;
        attackValue += 21;
        defenseValue += 21;
        experience -= 270;
        update();
        return true;
    }

    /**
     * Author: QinHao
     * Email:cqflqinhao@126.com
     * Date:2019/10/13 10:22
     * Description:用 395 经验 +17 攻击
     */
    public boolean buy17AttackValueWith95Experience() {
        if (experience < 95) {
            return false;
        }
        attackValue += 17;
        experience -= 95;
        update();
        return true;
    }

    /**
     * Author: QinHao
     * Email:cqflqinhao@126.com
     * Date:2019/10/13 10:22
     * Description:用 95 经验 +17 防御
     */
    public boolean buy17DefenseValueWith95Experience() {
        if (experience < 95) {
            return false;
        }
        defenseValue += 17;
        experience -= 95;
        update();
        return true;
    }

    /**
     * Author: QinHao
     * Email:cqflqinhao@126.com
     * Date:2019/10/13 10:23
     * Description:获得小飞羽
     */
    public void obtainBigFlightFeather() {
        level += 3;
        lifeValue += 3000;
        attackValue += 21;
        defenseValue += 21;
        update();
    }

    /**
     * Author: QinHao
     * Email:cqflqinhao@126.com
     * Date:2019/10/13 10:35
     * Description:获得圣水
     */
    public void obtainHolyWater() {
        lifeValue *= 2;
        update();
    }

    /**
     * Author: QinHao
     * Email:cqflqinhao@126.com
     * Date:2019/10/13 13:35
     * Description:获得圣光剑
     */
    public boolean obtainHolyLightSword() {
        if (experience < 500) {
            return false;
        }
        experience -= 500;
        attackValue += 100;
        update();
        return true;
    }

    /**
     * Author: QinHao
     * Email:cqflqinhao@126.com
     * Date:2019/10/13 13:35
     * Description:获得星光盾
     */
    public boolean obtainStarLightShield() {
        if (money < 500) {
            return false;
        }
        money -= 500;
        attackValue += 100;
        update();
        return true;
    }

    /**
     * Author: QinHao
     * Email:cqflqinhao@126.com
     * Date:2019/10/13 13:43
     * Description:获得星光神剑
     */
    public void obtainStarLightGodSword() {
        attackValue += 150;
        update();
    }

    /**
     * Author: QinHao
     * Email:cqflqinhao@126.com
     * Date:2019/10/13 13:44
     * Description:获得光芒神盾
     */
    public void obtainLightGodShield() {
        defenseValue += 150;
        update();
    }

    /**
     * Author: QinHao
     * Email:cqflqinhao@126.com
     * Date:2019/10/15 19:33
     * Description:把幸运十字架给仙子
     */
    public boolean giveLuckyCross2Fairy() {
        if (!hasLuckyCross) {
            return false;
        }
        lifeValue *= 4 / 3;
        attackValue *= 4 / 3;
        defenseValue *= 4 / 3;
        hasLuckyCross = false;
        return true;

    }

    //
//    /**
//     * author：MrQinshou
//     * Description:获得黄金盾
//     * date:2018/11/29 22:20
//     * param
//     * return
//     */
//    public void obtainGoldShield() {
//        setDefenseValue(getDefenseValue() + 85);
//        RxBus.getInstance().post(this);
//        RxBus.getInstance().post("获得黄金盾，防御 +85。");
//    }
//
//    /**
//     * author：MrQinshou
//     * Description:获得星光神榔
//     * date:2018/11/29 22:20
//     * param
//     * return
//     */
//    public void obtainXingGuangShenLang() {
//        setHasStarLightGodHammer(true);
//        RxBus.getInstance().post(this);
//        RxBus.getInstance().post("获得星光神榔，把它交给第 4 层的小偷，就可以打开第 18 层的隐藏地面啦。");
//    }
//
//    /**
//     * author：MrQinshou
//     * Description:获得大飞羽
//     * date:2018/11/29 22:20
//     * param
//     * return
//     */
//    public void obtainBigFlightFeather() {
////        setLevel(getLevel() + 3);
////        setLifeValue(getLifeValue() + 1000);
////        setAttackValue(getAttackValue() + 7);
////        setDefenseValue(getDefenseValue() + 7);
////        RxBus.getInstance().post(this);
////        RxBus.getInstance().post("获得大飞羽，等级 +3。");
//    }
//
//    /**
//     * author：MrQinshou
//     * Description:获得圣水
//     * date:2018/11/29 22:20
//     * param
//     * return
//     */
//    public void obtainHolyWater() {
//        setLifeValue(getLifeValue() * 2);
//        RxBus.getInstance().post(this);
//        RxBus.getInstance().post("获得圣水，生命值翻倍。");
//    }
//
//    /**
//     * author：MrQinshou
//     * Description:获得星光神剑
//     * date:2018/11/29 22:20
//     * param
//     * return
//     */
//    public void obtainStarSword() {
//        setAttackValue(getAttackValue() + 150);
//        RxBus.getInstance().post(this);
//        RxBus.getInstance().post("获得星光神剑，攻击 +150。");
//    }
//
//    /**
//     * author：MrQinshou
//     * Description:获得光芒神盾
//     * date:2018/11/29 22:20
//     * param
//     * return
//     */
//    public void obtainLightShield() {
//        setDefenseValue(getDefenseValue() + 150);
//        RxBus.getInstance().post(this);
//        RxBus.getInstance().post("获得光芒神盾，防御 +150。");
//    }
//
//
//
//    public void improvemLifeValueWith100mMoney() {
//        if (getMoney() >= 100) {
//            setLifeValue(getLifeValue() + 4000);
//            setMoney(getMoney() - 100);
//        }
//    }
//
//    public void improvemAttackValueWith100mMoney() {
//        if (getMoney() >= 100) {
//            setAttackValue(getAttackValue() + 20);
//            setMoney(getMoney() - 100);
//        }
//    }
//
//    public void improvemDefenseValueWith100mMoney() {
//        if (getMoney() >= 100) {
//            setDefenseValue(getDefenseValue() + 20);
//            setMoney(getMoney() - 100);
//        }
//    }
//
//    @Override
//    public boolean handleEvent(FragmentActivity activity, CaseBean fromCase, CaseBean toCase) {
//        return false;
//    }
//
//    public void moveUp(FragmentActivity activity) {
//        if (position.row == 0) {
//            return;
//        }
//        setType(CaseBean.WARRIOR_UP);
//        setResId(R.drawable.warrior_up);
//        CaseBean fromCase = MapManager.getInstance().getCase(position.row, position.column);
//        CaseBean toCase = MapManager.getInstance().getCase(position.row - 1, position.column);
//        AbsBean AbsBean = toCase.getSpecificEntity(toCase.getType());
//        if (AbsBean.handleEvent(activity, fromCase, toCase)) {
//            position.row--;
//        }
//        RxBus.getInstance().post(this);
//    }
//
//    public void moveDown(FragmentActivity activity) {
//        if (position.row == 10) {
//            return;
//        }
//        setType(CaseBean.WARRIOR_DOWN);
//        setResId(R.drawable.warrior_down);
//        CaseBean fromCase = MapManager.getInstance().getCase(position.row, position.column);
//        CaseBean toCase = MapManager.getInstance().getCase(position.row + 1, position.column);
//        AbsBean AbsBean = toCase.getSpecificEntity(toCase.getType());
//        if (AbsBean.handleEvent(activity, fromCase, toCase)) {
//            position.row++;
//        }
//        RxBus.getInstance().post(this);
//    }
//
//    public void moveLeft(FragmentActivity activity) {
//        if (position.column == 0) {
//            return;
//        }
//        setType(CaseBean.WARRIOR_LEFT);
//        setResId(R.drawable.warrior_left);
//        CaseBean fromCase = MapManager.getInstance().getCase(position.row, position.column);
//        CaseBean toCase = MapManager.getInstance().getCase(position.row, position.column - 1);
//        AbsBean AbsBean = toCase.getSpecificEntity(toCase.getType());
//        if (AbsBean.handleEvent(activity, fromCase, toCase)) {
//            position.column--;
//        }
//        RxBus.getInstance().post(this);
//    }
//
//    public void moveRight(FragmentActivity activity) {
//        if (position.column == 10) {
//            return;
//        }
//        setType(CaseBean.WARRIOR_RIGHT);
//        setResId(R.drawable.warrior_right);
//        CaseBean fromCase = MapManager.getInstance().getCase(position.row, position.column);
//        CaseBean toCase = MapManager.getInstance().getCase(position.row, position.column + 1);
//        AbsBean AbsBean = toCase.getSpecificEntity(toCase.getType());
//        if (AbsBean.handleEvent(activity, fromCase, toCase)) {
//            position.column++;
//        }
//        RxBus.getInstance().post(this);
//    }
    public enum Type {
        LEFT,
        UP,
        RIGHT,
        DOWN;
    }
}
