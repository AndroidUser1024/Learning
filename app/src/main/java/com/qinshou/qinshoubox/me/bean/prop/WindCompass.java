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
 * Description:风之罗盘
 */
public class WindCompass implements IProp {
    @Override
    public int getResourceId() {
        return R.drawable.magic_tower_prop_wind_compass;
    }

    @Override
    public void handleEvent(FragmentManager fragmentManager, int floor, Position position, IHandleEventCallback handleEventCallback) {
        MagicGameManager.SINGLETON.getWarriorBean().setHasWindCompass(true);
        MagicGameManager.SINGLETON.setCase(position, new Road());
        MagicGameManager.SINGLETON.getWarriorBean().update();

        handleEventCallback.onSuccess(false);

        Toast.makeText(App.getInstance(), "恭喜你获得风之罗盘,现在你可以随意去你去过的楼层", Toast.LENGTH_SHORT).show();
    }
}
