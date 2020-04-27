package com.qinshou.qinshoubox.me.bean.npc;

import android.content.DialogInterface;

import com.qinshou.commonmodule.base.AbsDialogFragment;
import com.qinshou.qinshoubox.R;
import com.qinshou.qinshoubox.me.bean.IHandleEventCallback;
import com.qinshou.qinshoubox.me.bean.Position;
import com.qinshou.qinshoubox.me.ui.dialog.StoreBigDialog;
import com.qinshou.qinshoubox.me.ui.dialog.StoreSmallDialog;

import androidx.fragment.app.FragmentManager;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2020/4/23 22:06
 * Description:大商店老板2
 */
public class BigStore2 implements INpc {
    @Override
    public int getResourceId() {
        return R.drawable.magic_tower_npc_store_2;
    }

    @Override
    public void handleEvent(FragmentManager fragmentManager, int floor, Position position, IHandleEventCallback handleEventCallback) {
        StoreBigDialog storeBigDialog = new StoreBigDialog();
        storeBigDialog.show(fragmentManager);
        storeBigDialog.setOnDismissListener(new AbsDialogFragment.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {
                handleEventCallback.onSuccess(false);
            }
        });
    }
}
