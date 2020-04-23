package com.qinshou.qinshoubox.me.bean.npc;

import android.content.DialogInterface;

import androidx.fragment.app.FragmentManager;

import com.qinshou.commonmodule.base.AbsDialogFragment;
import com.qinshou.qinshoubox.R;
import com.qinshou.qinshoubox.me.bean.IHandleEventCallback;
import com.qinshou.qinshoubox.me.bean.Position;
import com.qinshou.qinshoubox.me.ui.dialog.StoreSmallDialogFragment;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2020/4/23 17:04
 * Description:小商店老板1
 */
public class SmallStore2 implements INpc {
    @Override
    public int getResourceId() {
        return R.drawable.magic_tower_npc_store_2;
    }

    @Override
    public void handleEvent(FragmentManager fragmentManager, int floor, Position position, IHandleEventCallback handleEventCallback) {
        StoreSmallDialogFragment storeSmallDialogFragment = new StoreSmallDialogFragment();
        storeSmallDialogFragment.show(fragmentManager, "StoreSmallDialogFragment");
        storeSmallDialogFragment.setOnDismissListener(new AbsDialogFragment.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {
                handleEventCallback.onSuccess(false);
            }
        });
    }
}
