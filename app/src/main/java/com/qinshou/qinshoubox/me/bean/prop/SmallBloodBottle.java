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
 * Description:小血瓶
 */
public class SmallBloodBottle implements IProp {
    @Override
    public int getResourceId() {
        return R.drawable.magic_tower_prop_blood_bottle_small;
    }

    @Override
    public void handleEvent(FragmentManager fragmentManager, int floor, Position position, IHandleEventCallback handleEventCallback) {
        WarriorBean warriorBean = MagicGameManager.SINGLETON.getWarriorBean();
        warriorBean.setLifeValue(warriorBean.getLifeValue() + 200);
        warriorBean.update();

        MagicGameManager.SINGLETON.setCase(position, new Road());

        handleEventCallback.onSuccess(false);

        Toast.makeText(App.getInstance(), "获得小血瓶,生命值+200", Toast.LENGTH_SHORT).show();
//        Snackbar.make(MagicGameManager.SINGLETON.getTableLayout()
//                , "获得小血瓶,生命值+200"
//                , Snackbar.LENGTH_SHORT
//        ).show();
    }
}
