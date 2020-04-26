package com.qinshou.qinshoubox.me.bean.prop;

import android.widget.Toast;

import androidx.fragment.app.FragmentManager;

import com.qinshou.qinshoubox.App;
import com.qinshou.qinshoubox.R;
import com.qinshou.qinshoubox.me.bean.IHandleEventCallback;
import com.qinshou.qinshoubox.me.bean.Position;
import com.qinshou.qinshoubox.me.bean.building.Road;
import com.qinshou.qinshoubox.me.bean.warrior.WarriorBean;
import com.qinshou.qinshoubox.util.MagicGameManager;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2020/4/23 18:57
 * Description:钥匙盒
 */
public class KeyBox implements IProp {
    @Override
    public int getResourceId() {
        return R.drawable.magic_tower_prop_key_box;
    }

    @Override
    public void handleEvent(FragmentManager fragmentManager, int floor, Position position, IHandleEventCallback handleEventCallback) {
        WarriorBean warriorBean = MagicGameManager.SINGLETON.getWarriorBean();
        warriorBean.setYellowKeyCount(warriorBean.getYellowKeyCount() + 1);
        warriorBean.setBlueKeyCount(warriorBean.getBlueKeyCount() + 1);
        warriorBean.setRedKeyCount(warriorBean.getRedKeyCount() + 1);
        warriorBean.update();

        MagicGameManager.SINGLETON.setCase(position, new Road());

        handleEventCallback.onSuccess(false);

        Toast.makeText(App.getInstance(), "获得钥匙盒,各钥匙+1", Toast.LENGTH_SHORT).show();

    }
}
