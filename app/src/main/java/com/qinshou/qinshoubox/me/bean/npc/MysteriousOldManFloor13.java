package com.qinshou.qinshoubox.me.bean.npc;


import android.content.DialogInterface;

import com.qinshou.commonmodule.base.AbsDialogFragment;
import com.qinshou.qinshoubox.R;
import com.qinshou.qinshoubox.me.bean.IHandleEventCallback;
import com.qinshou.qinshoubox.me.bean.Position;
import com.qinshou.qinshoubox.me.ui.dialog.MysteriousOldManFloor13Dialog;
import com.qinshou.qinshoubox.me.ui.dialog.MysteriousOldManFloor5Dialog;

import androidx.fragment.app.FragmentManager;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2020/4/23 22:23
 * Description:第 13 层的神秘老人
 */
public class MysteriousOldManFloor13 implements INpc {
    @Override
    public int getResourceId() {
        return R.drawable.magic_tower_npc_mysterious_old_man;
    }

    @Override
    public void handleEvent(FragmentManager fragmentManager, int floor, Position position, IHandleEventCallback handleEventCallback) {
        MysteriousOldManFloor13Dialog mysteriousOldManFloor13Dialog = new MysteriousOldManFloor13Dialog();
        mysteriousOldManFloor13Dialog.show(fragmentManager);
        mysteriousOldManFloor13Dialog.setOnDismissListener(new AbsDialogFragment.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {
                handleEventCallback.onSuccess(false);
            }
        });
    }
}
