package com.qinshou.qinshoubox.me.bean.prop;

import androidx.fragment.app.FragmentManager;

import com.qinshou.qinshoubox.R;
import com.qinshou.qinshoubox.me.bean.IHandleEventCallback;
import com.qinshou.qinshoubox.me.bean.Position;

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

    }
}
