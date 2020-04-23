package com.qinshou.qinshoubox.me.bean.npc;

import androidx.fragment.app.FragmentManager;

import com.qinshou.qinshoubox.R;
import com.qinshou.qinshoubox.me.bean.IHandleEventCallback;
import com.qinshou.qinshoubox.me.bean.Position;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2020/4/23 17:04
 * Description:小商店老板1
 */
public class SmallStore1 implements INpc {
    @Override
    public int getResourceId() {
        return R.drawable.magic_tower_npc_store_1;
    }

    @Override
    public void handleEvent(FragmentManager fragmentManager, int floor, Position position, IHandleEventCallback handleEventCallback) {
        handleEventCallback.onFailure(new Exception("大门在右边"));
    }
}
