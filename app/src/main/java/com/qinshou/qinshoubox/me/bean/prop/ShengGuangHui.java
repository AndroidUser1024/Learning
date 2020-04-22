package com.qinshou.qinshoubox.me.bean.prop;

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
public class ShengGuangHui implements Prop {
    @Override
    public int getResourceId() {
        return R.drawable.magic_tower_prop_sheng_guang_hui;
    }

    @Override
    public void handleEvent(FragmentManager fragmentManager, int floor, Position position, IHandleEventCallback handleEventCallback) {
        MagicGameManager.SINGLETON.getWarriorBean().obtainShengGuangHui();
        MagicGameManager.SINGLETON.setCase(position, new Road());
        handleEventCallback.onSuccess(false);
    }
}
