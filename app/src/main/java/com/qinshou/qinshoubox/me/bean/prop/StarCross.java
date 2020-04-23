package com.qinshou.qinshoubox.me.bean.prop;

import androidx.fragment.app.FragmentManager;

import com.qinshou.qinshoubox.R;
import com.qinshou.qinshoubox.me.bean.IHandleEventCallback;
import com.qinshou.qinshoubox.me.bean.Position;

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

    }
}
