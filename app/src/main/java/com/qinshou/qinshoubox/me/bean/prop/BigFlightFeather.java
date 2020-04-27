package com.qinshou.qinshoubox.me.bean.prop;

import android.widget.Toast;

import com.qinshou.qinshoubox.App;
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
 * Date: 2020/4/23 22:22
 * Description:大飞羽
 */
public class BigFlightFeather implements IProp {
    @Override
    public int getResourceId() {
        return R.drawable.magic_tower_prop_big_flight_feather;
    }

    @Override
    public void handleEvent(FragmentManager fragmentManager, int floor, Position position, IHandleEventCallback handleEventCallback) {
        WarriorBean warriorBean = MagicGameManager.SINGLETON.getWarriorBean();
        warriorBean.setLevel(warriorBean.getLevel() + 1 * 3);
        warriorBean.setLifeValue(warriorBean.getLifeValue() + 1000 * 3);
        warriorBean.setAttackValue(warriorBean.getAttackValue() + 7 * 3);
        warriorBean.setDefenseValue(warriorBean.getDefenseValue() + 7 * 3);
        warriorBean.update();

        MagicGameManager.SINGLETON.setCase(position, new Road());

        handleEventCallback.onSuccess(false);

        Toast.makeText(App.getInstance(), "获得大飞羽,等级+3", Toast.LENGTH_SHORT).show();
    }
}
