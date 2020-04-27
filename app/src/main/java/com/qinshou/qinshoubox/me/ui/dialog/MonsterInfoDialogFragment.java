package com.qinshou.qinshoubox.me.ui.dialog;



import android.app.Dialog;
import android.view.Window;
import android.view.WindowManager;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.qinshou.commonmodule.base.AbsDialogFragment;
import com.qinshou.commonmodule.rcvdecoration.DividerDecoration;
import com.qinshou.qinshoubox.R;
import com.qinshou.qinshoubox.me.bean.monster.AbsMonster;
import com.qinshou.qinshoubox.me.ui.adapter.RcvMonsterAdapter;
import com.qinshou.qinshoubox.util.MagicGameManager;

import java.util.List;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/10/10 19:02
 * Description:点击圣光徽,显示怪物信息列表的对话框
 */
public class MonsterInfoDialogFragment extends AbsDialogFragment {
    private RcvMonsterAdapter mRcvMonsterAdapter;

    @Override
    public int initLayoutId() {
        return R.layout.dialog_monster_info;
    }

    @Override
    public void initView() {
        RecyclerView rcvMonsterInfo = findViewByID(R.id.rcv_monster_info);
        rcvMonsterInfo.setLayoutManager(new LinearLayoutManager(getContext()));
        rcvMonsterInfo.addItemDecoration(new DividerDecoration(new DividerDecoration.Builder().setColor(0xFF696969)));
        mRcvMonsterAdapter = new RcvMonsterAdapter(getContext());
        rcvMonsterInfo.setAdapter(mRcvMonsterAdapter);
    }

    @Override
    public void setListener() {

    }

    @Override
    public void initData() {
        List<AbsMonster> currentFloorMonsterList = MagicGameManager.SINGLETON.getCurrentFloorMonsterList();
        mRcvMonsterAdapter.setDataList(currentFloorMonsterList);
    }

    @Override
    public Dialog customDialog(Dialog dialog) {
        Window window = dialog.getWindow();
        if (window != null) {
            window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT);
        }
        return dialog;
    }
}
