package com.qinshou.qinshoubox.me.bean.prop;

import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;
import com.qinshou.qinshoubox.App;
import com.qinshou.qinshoubox.R;
import com.qinshou.qinshoubox.me.bean.IHandleEventCallback;
import com.qinshou.qinshoubox.me.bean.Position;
import com.qinshou.qinshoubox.me.bean.building.Road;
import com.qinshou.qinshoubox.me.bean.warrior.WarriorBean;
import com.qinshou.qinshoubox.util.MagicGameManager;

import androidx.fragment.app.FragmentManager;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2020/4/22 23:19
 * Description:黄钥匙
 */
public class YellowKey implements IProp {
    @Override
    public int getResourceId() {
        return R.drawable.magic_tower_prop_key_yellow;
    }

    @Override
    public void handleEvent(FragmentManager fragmentManager, int floor, Position position, IHandleEventCallback handleEventCallback) {
        WarriorBean warriorBean = MagicGameManager.SINGLETON.getWarriorBean();
        warriorBean.setYellowKeyCount(warriorBean.getYellowKeyCount() + 1);
        warriorBean.update();

        MagicGameManager.SINGLETON.setCase(position, new Road());

        handleEventCallback.onSuccess(false);

        Toast.makeText(App.getInstance(), "获得1把黄钥匙", Toast.LENGTH_SHORT).show();
//        Snackbar.make(MagicGameManager.SINGLETON.getTableLayout()
//                , "获得一把黄钥匙"
//                , Snackbar.LENGTH_SHORT
//        ).show();
    }
}
