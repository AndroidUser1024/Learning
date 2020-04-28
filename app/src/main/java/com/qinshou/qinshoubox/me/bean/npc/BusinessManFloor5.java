package com.qinshou.qinshoubox.me.bean.npc;


import android.content.DialogInterface;

import androidx.fragment.app.FragmentManager;

import com.qinshou.commonmodule.base.AbsDialogFragment;
import com.qinshou.qinshoubox.R;
import com.qinshou.qinshoubox.me.bean.IHandleEventCallback;
import com.qinshou.qinshoubox.me.bean.Position;
import com.qinshou.qinshoubox.me.ui.dialog.BusinessManFloor5Dialog;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2020/4/23 19:03
 * Description:第 5 层的商人
 */
public class BusinessManFloor5 implements INpc {
    @Override
    public int getResourceId() {
        return R.drawable.magic_tower_npc_business_man;
    }

    @Override
    public void handleEvent(FragmentManager fragmentManager, int floor, Position position, IHandleEventCallback handleEventCallback) {
        BusinessManFloor5Dialog businessManFloor5Dialog = new BusinessManFloor5Dialog();
        businessManFloor5Dialog.show(fragmentManager);
        businessManFloor5Dialog.setOnDismissListener(new AbsDialogFragment.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {
                handleEventCallback.onSuccess(false);
            }
        });
    }
}
