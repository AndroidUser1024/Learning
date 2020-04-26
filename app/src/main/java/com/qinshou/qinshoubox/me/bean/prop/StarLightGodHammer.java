package com.qinshou.qinshoubox.me.bean.prop;

import android.widget.Toast;

import com.qinshou.qinshoubox.App;
import com.qinshou.qinshoubox.R;
import com.qinshou.qinshoubox.me.bean.IHandleEventCallback;
import com.qinshou.qinshoubox.me.bean.Position;
import com.qinshou.qinshoubox.me.bean.building.Road;
import com.qinshou.qinshoubox.util.MagicGameManager;

import androidx.fragment.app.FragmentManager;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2020/4/23 22:12
 * Description:星光神榔
 */
public class StarLightGodHammer implements IProp {
    @Override
    public int getResourceId() {
        return R.drawable.magic_tower_prop_light_god_shield;
    }

    @Override
    public void handleEvent(FragmentManager fragmentManager, int floor, Position position, IHandleEventCallback handleEventCallback) {
        MagicGameManager.SINGLETON.getWarriorBean().setHasStarLightGodHammer(true);
        MagicGameManager.SINGLETON.setCase(position, new Road());

        handleEventCallback.onSuccess(false);

        Toast.makeText(App.getInstance(), "恭喜你获得星光神榔,将它交给第4层的小偷,可以帮你修好18层的路", Toast.LENGTH_SHORT).show();
    }
}
