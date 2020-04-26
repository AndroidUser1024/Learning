package com.qinshou.qinshoubox.me.bean.npc;


import android.content.DialogInterface;

import androidx.fragment.app.FragmentManager;

import com.qinshou.commonmodule.base.AbsDialogFragment;
import com.qinshou.qinshoubox.R;
import com.qinshou.qinshoubox.me.bean.IHandleEventCallback;
import com.qinshou.qinshoubox.me.bean.Position;
import com.qinshou.qinshoubox.me.ui.dialog.BusinessManFloor5Dialog;
import com.qinshou.qinshoubox.me.ui.dialog.MysteriousOldManFloor5Dialog;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2020/4/23 19:03
 * Description:第 5 层的神秘老人
 */
public class MysteriousOldManFloor5 implements INpc {
    @Override
    public int getResourceId() {
        return R.drawable.magic_tower_npc_shen_mi_lao_ren;
    }

    @Override
    public void handleEvent(FragmentManager fragmentManager, int floor, Position position, IHandleEventCallback handleEventCallback) {
        MysteriousOldManFloor5Dialog mysteriousOldManFloor5Dialog = new MysteriousOldManFloor5Dialog();
        mysteriousOldManFloor5Dialog.show(fragmentManager);
        mysteriousOldManFloor5Dialog.setOnDismissListener(new AbsDialogFragment.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {
                handleEventCallback.onSuccess(false);
            }
        });
    }
}
