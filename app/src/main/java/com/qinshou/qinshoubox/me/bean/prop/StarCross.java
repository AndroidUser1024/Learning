package com.qinshou.qinshoubox.me.bean.prop;

import android.widget.Toast;

import androidx.fragment.app.FragmentManager;

import com.qinshou.qinshoubox.App;
import com.qinshou.qinshoubox.R;
import com.qinshou.qinshoubox.me.bean.IHandleEventCallback;
import com.qinshou.qinshoubox.me.bean.Position;
import com.qinshou.qinshoubox.me.bean.building.Road;
import com.qinshou.qinshoubox.util.MagicGameManager;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2020/4/23 19:22
 * Description:星光十字架
 */
public class StarCross implements IProp {
    @Override
    public int getResourceId() {
        return R.drawable.magic_tower_prop_star_cross;
    }

    @Override
    public void handleEvent(FragmentManager fragmentManager, int floor, Position position, IHandleEventCallback handleEventCallback) {
        MagicGameManager.SINGLETON.getWarriorBean().setHasLuckyCross(true);
        MagicGameManager.SINGLETON.setCase(position, new Road());

        handleEventCallback.onSuccess(false);

        Toast.makeText(App.getInstance(), "恭喜你获得幸运十字架,将它交给序章中的仙子,可以提升一定属性", Toast.LENGTH_SHORT).show();
    }
}
