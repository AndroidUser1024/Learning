package com.qinshou.qinshoubox.me.bean.prop;

import com.google.android.material.snackbar.Snackbar;
import com.qinshou.qinshoubox.R;
import com.qinshou.qinshoubox.me.bean.IHandleEventCallback;
import com.qinshou.qinshoubox.me.bean.Position;
import com.qinshou.qinshoubox.me.bean.building.Road;
import com.qinshou.qinshoubox.me.bean.warrior.WarriorBean;
import com.qinshou.qinshoubox.util.MagicGameManager;

import androidx.fragment.app.FragmentManager;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2020/4/22 23:19
 * Description:蓝宝石
 */
public class BlueGem implements IProp {
    @Override
    public int getResourceId() {
        return R.drawable.magic_tower_prop_gem_blue;
    }

    @Override
    public void handleEvent(FragmentManager fragmentManager, int floor, Position position, IHandleEventCallback handleEventCallback) {
        WarriorBean warriorBean = MagicGameManager.SINGLETON.getWarriorBean();
        warriorBean.setDefenseValue(warriorBean.getDefenseValue() + 3);
        warriorBean.update();

        MagicGameManager.SINGLETON.setCase(position, new Road());
        handleEventCallback.onSuccess(false);
//        Snackbar.make(MagicGameManager.SINGLETON.getTableLayout()
//                , "获得蓝宝石,防御力+3"
//                , Snackbar.LENGTH_SHORT
//        ).show();
    }
}
