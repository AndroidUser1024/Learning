package com.qinshou.qinshoubox.me.bean.npc;

import android.widget.Toast;

import com.qinshou.qinshoubox.App;
import com.qinshou.qinshoubox.R;
import com.qinshou.qinshoubox.me.bean.IHandleEventCallback;
import com.qinshou.qinshoubox.me.bean.Position;
import com.qinshou.qinshoubox.me.bean.building.Road;
import com.qinshou.qinshoubox.util.MagicGameManager;

import androidx.fragment.app.FragmentManager;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2020/4/22 19:06
 * Description:黄色门
 */
public class YellowGate implements INpc {

    @Override
    public int getResourceId() {
        return R.drawable.magic_tower_npc_gate_yellow_1;
    }

    @Override
    public void handleEvent(FragmentManager fragmentManager, int floor, Position position, IHandleEventCallback handleEventCallback) {
        if (MagicGameManager.SINGLETON.getWarriorBean().getYellowKeyCount() == 0) {
            handleEventCallback.onFailure(new Exception("没有黄钥匙啦,可以找五楼的商人买一把去."));
            return;
        }
        MagicGameManager.SINGLETON.getWarriorBean().loseYellowKey();
        MagicGameManager.SINGLETON.getWarriorBean().update();

        MagicGameManager.SINGLETON.setCase(position, new Road());

        Toast.makeText(App.getInstance(),"打开黄色门,黄钥匙-1",Toast.LENGTH_SHORT).show();
    }
}
