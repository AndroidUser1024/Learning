package com.qinshou.qinshoubox.me.bean.npc;

import com.qinshou.qinshoubox.R;
import com.qinshou.qinshoubox.me.bean.IHandleEventCallback;
import com.qinshou.qinshoubox.me.bean.Position;
import com.qinshou.qinshoubox.util.MagicGameManager;

import androidx.fragment.app.FragmentManager;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2020/4/22 22:55
 * Description:处理上楼事件
 */
public class GoUpstairs implements INpc {

    @Override
    public int getResourceId() {
        return R.drawable.magic_tower_npc_go_upstairs;
    }

    @Override
    public void handleEvent(FragmentManager fragmentManager, int floor, Position position, IHandleEventCallback handleEventCallback) {
        MagicGameManager.SINGLETON.goUpstairs();
    }
}
