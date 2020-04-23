package com.qinshou.qinshoubox.me.bean.prop;

import com.qinshou.qinshoubox.R;
import com.qinshou.qinshoubox.me.bean.IHandleEventCallback;
import com.qinshou.qinshoubox.me.bean.Position;

import androidx.fragment.app.FragmentManager;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2020/4/23 22:37
 * Description:光芒神盾
 */
public class LightGodShield implements IProp {
    @Override
    public int getResourceId() {
        return R.drawable.magic_tower_prop_light_god_shield;
    }

    @Override
    public void handleEvent(FragmentManager fragmentManager, int floor, Position position, IHandleEventCallback handleEventCallback) {

    }
}
