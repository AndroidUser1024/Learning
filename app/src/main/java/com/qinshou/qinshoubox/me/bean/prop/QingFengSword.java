package com.qinshou.qinshoubox.me.bean.prop;

import android.widget.Toast;

import androidx.fragment.app.FragmentManager;

import com.qinshou.qinshoubox.App;
import com.qinshou.qinshoubox.R;
import com.qinshou.qinshoubox.me.bean.IHandleEventCallback;
import com.qinshou.qinshoubox.me.bean.Position;
import com.qinshou.qinshoubox.me.bean.building.Road;
import com.qinshou.qinshoubox.me.bean.warrior.WarriorBean;
import com.qinshou.qinshoubox.me.enums.Warrior;
import com.qinshou.qinshoubox.util.MagicGameManager;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2020/4/23 19:24
 * Description:青锋剑
 */
public class QingFengSword implements IProp {

    @Override
    public int getResourceId() {
        return R.drawable.magic_tower_prop_qing_feng_sword;
    }

    @Override
    public void handleEvent(FragmentManager fragmentManager, int floor, Position position, IHandleEventCallback handleEventCallback) {
        WarriorBean warriorBean = MagicGameManager.SINGLETON.getWarriorBean();
        warriorBean.setAttackValue(warriorBean.getAttackValue() + 85);
        warriorBean.update();

        MagicGameManager.SINGLETON.setCase(position, new Road());

        handleEventCallback.onSuccess(false);
        Toast.makeText(App.getInstance(), "获得青锋剑,攻击+85", Toast.LENGTH_SHORT).show();
    }
}
