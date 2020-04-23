package com.qinshou.qinshoubox.me.bean.prop;

import com.qinshou.qinshoubox.R;
import com.qinshou.qinshoubox.me.bean.IHandleEventCallback;
import com.qinshou.qinshoubox.me.bean.Position;

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

    }
}
