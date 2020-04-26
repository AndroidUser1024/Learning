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
 * Date: 2020/4/23 22:02
 * Description:圣水
 */
public class HolyWater implements IProp {
    @Override
    public int getResourceId() {
        return R.drawable.magic_tower_prop_holy_water;
    }

    @Override
    public void handleEvent(FragmentManager fragmentManager, int floor, Position position, IHandleEventCallback handleEventCallback) {
        WarriorBean warriorBean = MagicGameManager.SINGLETON.getWarriorBean();
        warriorBean.setLifeValue(warriorBean.getLifeValue() * 2);

        MagicGameManager.SINGLETON.setCase(position, new Road());

        handleEventCallback.onSuccess(false);

        Toast.makeText(App.getInstance(), "获得圣水,生命值翻倍", Toast.LENGTH_SHORT).show();
    }
}
