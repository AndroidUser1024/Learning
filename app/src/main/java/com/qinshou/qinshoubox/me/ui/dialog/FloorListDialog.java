package com.qinshou.qinshoubox.me.ui.dialog;

import com.qinshou.commonmodule.base.AbsDialogFragment;
import com.qinshou.commonmodule.rcvbaseadapter.baseholder.BaseViewHolder;
import com.qinshou.commonmodule.rcvbaseadapter.listener.IOnItemClickListener;
import com.qinshou.qinshoubox.R;
import com.qinshou.qinshoubox.me.ui.adapter.RcvFloorAdapter;
import com.qinshou.qinshoubox.util.MagicGameManager;

import java.util.ArrayList;
import java.util.List;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2020/04/28 22:17
 * Description:点击风之罗盘,显示楼层列表的对话框
 */
public class FloorListDialog extends AbsDialogFragment {
    private RcvFloorAdapter mRcvFloorAdapter;

    @Override
    public int initLayoutId() {
        return R.layout.dialog_floor_list;
    }

    @Override
    public void initView() {
        RecyclerView rcvFloor = findViewByID(R.id.rcv_floor);
        rcvFloor.setAdapter(mRcvFloorAdapter = new RcvFloorAdapter(getContext()));
        rcvFloor.setLayoutManager(new GridLayoutManager(getContext(), 3));
    }

    @Override
    public void setListener() {
        mRcvFloorAdapter.setOnItemClickListener(new IOnItemClickListener<String>() {
            @Override
            public void onItemClick(BaseViewHolder holder, String itemData, int position) {
                MagicGameManager.SINGLETON.goToFloor(position);
                dismiss();
            }
        });
    }

    @Override
    public void initData() {
        List<String> dataList = new ArrayList<>();
        for (int i = 0; i < MagicGameManager.SINGLETON.getFloorListSize(); i++) {
            dataList.add("第" + i + "层");
        }
        mRcvFloorAdapter.setDataList(dataList);
    }
}
