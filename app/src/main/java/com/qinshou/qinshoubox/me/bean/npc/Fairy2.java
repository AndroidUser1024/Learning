package com.qinshou.qinshoubox.me.bean.npc;

import com.qinshou.qinshoubox.R;
import com.qinshou.qinshoubox.me.bean.IHandleEventCallback;
import com.qinshou.qinshoubox.me.bean.Position;

import androidx.fragment.app.FragmentManager;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2020/4/22 22:43
 * Description:
 */
public class Fairy2 implements INpc {

    @Override
    public int getResourceId() {
        return R.drawable.magic_tower_npc_fairy;
    }

    @Override
    public void handleEvent(FragmentManager fragmentManager, int floor, Position position, IHandleEventCallback handleEventCallback) {
    }
}
