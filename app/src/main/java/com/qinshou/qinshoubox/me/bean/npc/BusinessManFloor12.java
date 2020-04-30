package com.qinshou.qinshoubox.me.bean.npc;


import android.content.DialogInterface;

import com.qinshou.commonmodule.base.AbsDialogFragment;
import com.qinshou.qinshoubox.R;
import com.qinshou.qinshoubox.me.bean.IHandleEventCallback;
import com.qinshou.qinshoubox.me.bean.Position;
import com.qinshou.qinshoubox.me.ui.dialog.BusinessManFloor12Dialog;
import com.qinshou.qinshoubox.me.ui.dialog.BusinessManFloor5Dialog;

import androidx.fragment.app.FragmentManager;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2020/4/23 22:09
 * Description:第 12 层的商人
 */
public class BusinessManFloor12 implements INpc {
    @Override
    public int getResourceId() {
        return R.drawable.magic_tower_npc_business_man;
    }

    @Override
    public void handleEvent(FragmentManager fragmentManager, int floor, Position position, IHandleEventCallback handleEventCallback) {
        BusinessManFloor12Dialog businessManFloor12Dialog = new BusinessManFloor12Dialog();
        businessManFloor12Dialog.show(fragmentManager);
        businessManFloor12Dialog.setOnDismissListener(new AbsDialogFragment.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {
                handleEventCallback.onSuccess(false);
            }
        });
    }
}
