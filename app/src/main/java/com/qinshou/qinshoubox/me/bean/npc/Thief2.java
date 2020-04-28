package com.qinshou.qinshoubox.me.bean.npc;

import androidx.fragment.app.FragmentManager;

import com.qinshou.qinshoubox.R;
import com.qinshou.qinshoubox.me.bean.IHandleEventCallback;
import com.qinshou.qinshoubox.me.bean.Position;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2020/4/23 18:54
 * Description:小偷2
 */
public class Thief2 implements INpc {
    @Override
    public int getResourceId() {
        return R.drawable.magic_tower_npc_thief;
    }

    @Override
    public void handleEvent(FragmentManager fragmentManager, int floor, Position position, IHandleEventCallback handleEventCallback) {
    }
}
