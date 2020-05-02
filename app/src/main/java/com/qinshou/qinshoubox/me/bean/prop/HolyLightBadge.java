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
 * Date: 2020/4/22 23:19
 * Description:圣光徽
 */
public class HolyLightBadge implements IProp {
    @Override
    public int getResourceId() {
        return R.drawable.magic_tower_prop_holy_light_badge;
    }

    @Override
    public void handleEvent(FragmentManager fragmentManager, int floor, Position position, IHandleEventCallback handleEventCallback) {
        MagicGameManager.SINGLETON.getWarriorBean().setHasHolyLightBadge(true);
        MagicGameManager.SINGLETON.setCase(position, new Road());
        MagicGameManager.SINGLETON.getWarriorBean().update();

        handleEventCallback.onSuccess(false);

        Toast.makeText(App.getInstance(), "恭喜你获得圣光徽,点击可查看怪物信息", Toast.LENGTH_SHORT).show();
    }
}
