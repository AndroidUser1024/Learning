package com.qinshou.qinshoubox.me.ui.fragment;

import com.qinshou.commonmodule.base.AbsMVPFragment;
import com.qinshou.commonmodule.util.ShowLogUtil;
import com.qinshou.qinshoubox.R;
import com.qinshou.qinshoubox.me.ui.adapter.RcvTestAdapter;
import com.qinshou.qinshoubox.me.contract.ITestContract;
import com.qinshou.qinshoubox.me.presenter.TestPresenter;
import com.qinshou.qinshoubox.me.ui.widget.SwitchButton;
import com.qinshou.qinshoubox.me.ui.widget.WaveSideBar;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/11/14 13:57
 * Description:测试界面
 */
public class TestFragment extends AbsMVPFragment<TestPresenter> implements ITestContract.IView {

    private RcvTestAdapter mRcvTestAdapter;
    private SwitchButton mSbWaveSideBarPosition;
    private SwitchButton mSbWaveSideBarWave;
    private SwitchButton mSbWaveSideBarItemSelectedPopupWindow;
    private WaveSideBar mWaveSideBar;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_test;
    }

    @Override
    public void initView() {
//        final RecyclerView rcvTest = findViewByID(R.id.rcv_test);
//        rcvTest.setLayoutManager(new GridLayoutManager(getContext(), 4));
//        mRcvTestAdapter = new RcvTestAdapter(getContext());
//        rcvTest.setAdapter(mRcvTestAdapter);
//
//        final ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new ItemTouchHelper.QSCallback() {
//            @Override
//            public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
//                int dragFlags = 0;
//                if (recyclerView.getLayoutManager() instanceof GridLayoutManager) {
//                    dragFlags = ItemTouchHelper.UP | ItemTouchHelper.DOWN |
//                            ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT;
//                } else {
//                    dragFlags = ItemTouchHelper.UP | ItemTouchHelper.DOWN;
//                }
//                // 支持左右滑动(删除)操作, swipeFlags = ItemTouchHelper.START | ItemTouchHelper.END
//                final int swipeFlags = 0;
//                return makeMovementFlags(dragFlags, swipeFlags);
//            }
//
//            @Override
//            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
//                // 按下时的 position
//                int fromPosition = viewHolder.getAdapterPosition();
//                // 当前拖拽到的 item 的 position
//                int toPosition = target.getAdapterPosition();
//                ShowLogUtil.logi("fromPosition--->" + fromPosition);
//                ShowLogUtil.logi("toPosition--->" + toPosition);
//                mRcvTestAdapter.onItemMove(fromPosition, toPosition);
//                return true;
//            }
//
//            @Override
//            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
//
//            }
//
//            @Override
//            public void onSelectedChanged(RecyclerView.ViewHolder viewHolder, int actionState) {
//                super.onSelectedChanged(viewHolder, actionState);
//                ShowLogUtil.logi("onSelectedChanged : viewHolder--->" + viewHolder + ",actionState--->" + actionState);
//            }
//
//            @Override
//            public void clearView(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
//                super.clearView(recyclerView, viewHolder);
//                ShowLogUtil.logi("clearView : viewHolder--->" + viewHolder.getAdapterPosition());
//            }
//        });
//        itemTouchHelper.attachToRecyclerView(rcvTest);
        mSbWaveSideBarPosition = findViewByID(R.id.sb_wave_side_bar_position);
        mSbWaveSideBarWave = findViewByID(R.id.sb_wave_side_bar_wave);
        mSbWaveSideBarItemSelectedPopupWindow = findViewByID(R.id.sb_wave_side_bar_show_item_selected_popup_window);
        mWaveSideBar = findViewByID(R.id.wave_side_bar);
    }

    @Override
    public void setListener() {
        mSbWaveSideBarPosition.setOnCheckedChangeListener(new SwitchButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(boolean checked, boolean fromUser) {
                if (checked) {
                    mWaveSideBar.setPosition(WaveSideBar.Position.RIGHT);
                } else {
                    mWaveSideBar.setPosition(WaveSideBar.Position.LEFT);
                }
            }
        });
        mSbWaveSideBarWave.setOnCheckedChangeListener(new SwitchButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(boolean checked, boolean fromUser) {
                if (checked) {
                    mWaveSideBar.setWave(true);
                } else {
                    mWaveSideBar.setWave(false);
                }
            }
        });
        mSbWaveSideBarItemSelectedPopupWindow.setOnCheckedChangeListener(new SwitchButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(boolean checked, boolean fromUser) {
                if (checked) {
                    mWaveSideBar.setShowItemSelectedPopupWindow(true);
                } else {
                    mWaveSideBar.setShowItemSelectedPopupWindow(false);
                }
            }
        });
        mWaveSideBar.setOnItemSelectedListener(new WaveSideBar.IOnItemSelectedListener() {
            @Override
            public void onItemSelected(int position, String item) {
                ShowLogUtil.logi("onItemSelected:position--->" + position + ",item--->" + item);
            }

            @Override
            public void onCancel() {
                ShowLogUtil.logi("onCancel");
            }
        });
    }

    @Override
    public void initData() {
//        List<String> list = new ArrayList<>();
//        for (int i = 0; i < 100; i++) {
//            list.add("测试文字" + i);
//        }
//        mRcvTestAdapter.setDataList(list);
    }
}
