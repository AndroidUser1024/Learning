package com.qinshou.qinshoubox.me.bean.prop;

import android.widget.Toast;

import androidx.fragment.app.FragmentManager;

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
 * Date: 2020/4/23 19:04
 * Description:小飞羽
 */
public class SmallFlightFeather implements IProp {
    @Override
    public int getResourceId() {
        return R.drawable.magic_tower_prop_small_flight_feather;
    }

    @Override
    public void handleEvent(FragmentManager fragmentManager, int floor, Position position, IHandleEventCallback handleEventCallback) {
        WarriorBean warriorBean = MagicGameManager.SINGLETON.getWarriorBean();
        warriorBean.setLevel(warriorBean.getLevel() + 1);
        warriorBean.setLifeValue(warriorBean.getLifeValue() + 1000);
        warriorBean.setAttackValue(warriorBean.getAttackValue() + 7);
        warriorBean.setDefenseValue(warriorBean.getDefenseValue() + 7);
        warriorBean.update();

        MagicGameManager.SINGLETON.setCase(position, new Road());

        handleEventCallback.onSuccess(false);

        Toast.makeText(App.getInstance(), "获得小飞羽,等级+13", Toast.LENGTH_SHORT).show();
    }
}
