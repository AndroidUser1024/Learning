package com.qinshou.qinshoubox.me.bean.npc;


import androidx.fragment.app.FragmentManager;

import com.qinshou.qinshoubox.R;
import com.qinshou.qinshoubox.me.bean.IHandleEventCallback;
import com.qinshou.qinshoubox.me.bean.Position;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2020/4/23 13:44
 * Description:第 2 层的神秘老人
 */
public class MysteriousOldManFloor2 implements INpc {
    @Override
    public int getResourceId() {
        return R.drawable.magic_tower_npc_shen_mi_lao_ren;
    }

    @Override
    public void handleEvent(FragmentManager fragmentManager, int floor, Position position, IHandleEventCallback handleEventCallback) {

    }
}
