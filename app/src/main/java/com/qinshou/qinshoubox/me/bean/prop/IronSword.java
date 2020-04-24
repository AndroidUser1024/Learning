package com.qinshou.qinshoubox.me.bean.prop;

import androidx.fragment.app.FragmentManager;

import com.google.android.material.snackbar.Snackbar;
import com.qinshou.commonmodule.util.SnackbarUtil;
import com.qinshou.qinshoubox.App;
import com.qinshou.qinshoubox.R;
import com.qinshou.qinshoubox.me.bean.IHandleEventCallback;
import com.qinshou.qinshoubox.me.bean.Position;
import com.qinshou.qinshoubox.me.bean.building.Road;
import com.qinshou.qinshoubox.me.bean.warrior.WarriorBean;
import com.qinshou.qinshoubox.util.MagicGameManager;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2020/4/23 16:59
 * Description:铁剑
 */
public class IronSword implements IProp {


    @Override
    public int getResourceId() {
        return R.drawable.magic_tower_prop_iron_sword;
    }

    @Override
    public void handleEvent(FragmentManager fragmentManager, int floor, Position position, IHandleEventCallback handleEventCallback) {
        WarriorBean warriorBean = MagicGameManager.SINGLETON.getWarriorBean();
        warriorBean.setAttackValue(warriorBean.getAttackValue() + 10);
        warriorBean.update();

        MagicGameManager.SINGLETON.setCase(position, new Road());
        handleEventCallback.onSuccess(false);
//        Snackbar.make(MagicGameManager.SINGLETON.getTableLayout()
//                , "获得铁剑,攻击+10"
//                , Snackbar.LENGTH_SHORT
//        ).show();
    }
}
