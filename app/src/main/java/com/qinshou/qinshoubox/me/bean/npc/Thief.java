package com.qinshou.qinshoubox.me.bean.npc;

import android.content.DialogInterface;

import androidx.fragment.app.FragmentManager;

import com.qinshou.commonmodule.base.AbsDialogFragment;
import com.qinshou.commonmodule.util.ShowLogUtil;
import com.qinshou.qinshoubox.R;
import com.qinshou.qinshoubox.me.bean.IHandleEventCallback;
import com.qinshou.qinshoubox.me.bean.Position;
import com.qinshou.qinshoubox.me.bean.TalkerBean;
import com.qinshou.qinshoubox.me.bean.building.Road;
import com.qinshou.qinshoubox.me.ui.dialog.TalkDialogFragment;
import com.qinshou.qinshoubox.util.MagicGameManager;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2020/4/23 18:54
 * Description:小偷1
 */
public class Thief implements INpc {
    @Override
    public int getResourceId() {
        return R.drawable.magic_tower_npc_thief;
    }

    @Override
    public void handleEvent(FragmentManager fragmentManager, int floor, Position position, IHandleEventCallback handleEventCallback) {
    }
}
