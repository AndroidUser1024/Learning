package com.qinshou.qinshoubox.me.bean;

import android.support.v4.app.FragmentActivity;

import com.qinshou.qinshoubox.me.util.MapManager;

/**
 * Description:道具实体类
 * Created by 禽兽先生
 * Created on 2017/6/15
 */

public class PropBean extends ABaseBean {

    public PropBean(String name, int type, int resourceID) {
        super(name, type, resourceID);
    }

    @Override
    public boolean handleEvent(FragmentActivity activity, CaseBean fromCase, CaseBean toCase) {
        switch (getType()) {
            case CaseBean.PROP_KEY_YELLOW:
                MapManager.getInstance().setToCase2Road(toCase);
                WarriorBean.getInstance().obtainYellowKey();
                break;
            case CaseBean.PROP_KEY_BLUE:
                MapManager.getInstance().setToCase2Road(toCase);
                WarriorBean.getInstance().obtainBlueKey();
                break;
            case CaseBean.PROP_KEY_RED:
                MapManager.getInstance().setToCase2Road(toCase);
                WarriorBean.getInstance().obtainRedKey();
                break;
            case CaseBean.PROP_XIE_PING_SMALL:
                MapManager.getInstance().setToCase2Road(toCase);
                WarriorBean.getInstance().obtainSmallBloodBottle();
                break;
            case CaseBean.PROP_XIE_PING_BIG:
                MapManager.getInstance().setToCase2Road(toCase);
                WarriorBean.getInstance().obtainBigBloodBottle();
                break;
            case CaseBean.PROP_BAO_SHI_RED:
                MapManager.getInstance().setToCase2Road(toCase);
                WarriorBean.getInstance().obtainRedGem();
                break;
            case CaseBean.PROP_BAO_SHI_BLUE:
                MapManager.getInstance().setToCase2Road(toCase);
                WarriorBean.getInstance().obtainBlueGem();
                break;
            case CaseBean.PROP_SHENG_GUANG_HUI:
                MapManager.getInstance().setToCase2Road(toCase);
                WarriorBean.getInstance().obtainShengGuangHui();
                break;
            case CaseBean.PROP_TIE_JIAN:
                MapManager.getInstance().setToCase2Road(toCase);
                WarriorBean.getInstance().obtainIronSword();
                break;
            case CaseBean.PROP_TIE_DUN:
                MapManager.getInstance().setToCase2Road(toCase);
                WarriorBean.getInstance().obtainIronShield();
                break;
            case CaseBean.PROP_YAO_SHI_HE:
                MapManager.getInstance().setToCase2Road(toCase);
                WarriorBean.getInstance().obtainKeyBox();
                break;
            case CaseBean.PROP_XIAO_FEI_YU:
                MapManager.getInstance().setToCase2Road(toCase);
                WarriorBean.getInstance().obtainSmallFlightFeather();
                break;
            case CaseBean.PROP_JIN_KUAI:
                MapManager.getInstance().setToCase2Road(toCase);
                WarriorBean.getInstance().obtainGoldBullion();
                break;
            case CaseBean.PROP_XING_YUN_SHI_ZI_JIA:
                MapManager.getInstance().setToCase2Road(toCase);
                WarriorBean.getInstance().obtainLuckyCross();
                break;
            case CaseBean.PROP_FENG_ZHI_LUO_PAN:
                MapManager.getInstance().setToCase2Road(toCase);
                WarriorBean.getInstance().obtainFengZhiLuoPan();
                break;
            case CaseBean.PROP_QING_FENG_JIAN:
                MapManager.getInstance().setToCase2Road(toCase);
                WarriorBean.getInstance().obtainQingFengSword();
                break;
            case CaseBean.PROP_HUANG_JIN_DUN:
                MapManager.getInstance().setToCase2Road(toCase);
                WarriorBean.getInstance().obtainGoldShield();
                break;
            case CaseBean.PROP_XING_GUANG_SHEN_LANG:
                MapManager.getInstance().setToCase2Road(toCase);
                WarriorBean.getInstance().obtainXingGuangShenLang();
                break;
            case CaseBean.PROP_DA_FEI_YU:
                MapManager.getInstance().setToCase2Road(toCase);
                WarriorBean.getInstance().obtainBigFlightFeather();
                break;
            case CaseBean.PROP_SHENG_SHUI:
                MapManager.getInstance().setToCase2Road(toCase);
                WarriorBean.getInstance().obtainHolyWater();
                break;
            case CaseBean.PROP_XING_GUANG_SHEN_JIAN:
                MapManager.getInstance().setToCase2Road(toCase);
                WarriorBean.getInstance().obtainStarSword();
                break;
            case CaseBean.PROP_GUANG_MANG_SHEN_DUN:
                MapManager.getInstance().setToCase2Road(toCase);
                WarriorBean.getInstance().obtainLightShield();
                break;
        }
        return false;
    }
}

