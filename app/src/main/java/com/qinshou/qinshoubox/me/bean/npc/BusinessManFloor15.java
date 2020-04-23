package com.qinshou.qinshoubox.me.bean.npc;


import com.qinshou.qinshoubox.R;
import com.qinshou.qinshoubox.me.bean.IHandleEventCallback;
import com.qinshou.qinshoubox.me.bean.Position;

import androidx.fragment.app.FragmentManager;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2020/4/23 22:26
 * Description:第 15 层的商人
 */
public class BusinessManFloor15 implements INpc {
    @Override
    public int getResourceId() {
        return R.drawable.magic_tower_npc_shang_ren;
    }

    @Override
    public void handleEvent(FragmentManager fragmentManager, int floor, Position position, IHandleEventCallback handleEventCallback) {

    }
}
