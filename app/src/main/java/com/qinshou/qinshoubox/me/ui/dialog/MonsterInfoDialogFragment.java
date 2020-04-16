package com.qinshou.qinshoubox.me.ui.dialog;


import android.os.Bundle;

import com.qinshou.commonmodule.base.AbsDialogFragment;
import com.qinshou.qinshoubox.me.bean.MonsterBean;

import java.util.ArrayList;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/10/10 19:02
 * Description:点击圣光徽,显示怪物信息列表的对话框
 */
public class MonsterInfoDialogFragment extends AbsDialogFragment {
    private static final String MONSTER_LIST = "MonsterList";
//    private RcvMonsterInfoAdapter mRcvMonsterInfoAdapter;

//    @Override
//    public int initLayoutId() {
//        return R.layout.dialog_monster_info;
//    }
//
//    @Override
//    public void initView() {
//        RecyclerView rcvMonsterInfo = findViewByID(R.id.rcv_monster_info);
//        rcvMonsterInfo.setLayoutManager(new LinearLayoutManager(getContext()));
//        rcvMonsterInfo.addItemDecoration(new DividerDecoration(DividerDecoration.Orientation.VERTICAL, 1, 0xFF696969));
//        mRcvMonsterInfoAdapter = new RcvMonsterInfoAdapter(getContext());
//        rcvMonsterInfo.setAdapter(mRcvMonsterInfoAdapter);
//
//    }
//
//    @Override
//    public void setListener() {
//
//    }
//
//    @Override
//    public void initData() {
//        Bundle bundle = getArguments();
//        if (bundle == null) {
//            return;
//        }
//        List<MonsterBean> monsterBeanList = bundle.getParcelableArrayList(MONSTER_LIST);
//        mRcvMonsterInfoAdapter.setDataList(monsterBeanList);
//    }
//
//    @Override
//    public Dialog customDialog(Dialog dialog) {
//        Window window = dialog.getWindow();
//        if (window != null) {
//            //底部对话框
//            window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT);
//        }
//        return dialog;
//    }

    public static MonsterInfoDialogFragment newInstance(ArrayList<MonsterBean> monsterBeanList) {
        Bundle args = new Bundle();
        MonsterInfoDialogFragment fragment = new MonsterInfoDialogFragment();
        args.putParcelableArrayList(MONSTER_LIST, monsterBeanList);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int initLayoutId() {
        return 0;
    }

    @Override
    public void initView() {

    }

    @Override
    public void setListener() {

    }

    @Override
    public void initData() {

    }
}
