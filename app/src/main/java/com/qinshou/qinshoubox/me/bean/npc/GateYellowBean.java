package com.qinshou.qinshoubox.me.bean.npc;

import com.qinshou.qinshoubox.R;
import com.qinshou.qinshoubox.me.bean.IHandleEventCallback;
import com.qinshou.qinshoubox.me.bean.Position;
import com.qinshou.qinshoubox.me.bean.building.RoadBean;
import com.qinshou.qinshoubox.me.enums.Npc;
import com.qinshou.qinshoubox.util.MagicGameManager;

import androidx.fragment.app.FragmentManager;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2020/4/22 19:06
 * Description:类描述
 */
public class GateYellowBean extends NpcBean {
    public GateYellowBean() {
        super(Npc.GATE_YELLOW, R.drawable.magic_tower_npc_gate_yellow_1);
    }

    @Override
    public void handleEvent(FragmentManager fragmentManager, int floor, Position position, IHandleEventCallback handleEventCallback) {
        if (MagicGameManager.SINGLETON.getWarriorBean().getYellowKeyCount() == 0) {
            handleEventCallback.onFailure(new Exception("没有黄钥匙啦,可以找五楼的商人买一把去."));
            return;
        }
        MagicGameManager.SINGLETON.getWarriorBean().loseYellowKey();
        MagicGameManager.SINGLETON.getWarriorBean().update();

        MagicGameManager.SINGLETON.setCase(position,new RoadBean());
    }
}
