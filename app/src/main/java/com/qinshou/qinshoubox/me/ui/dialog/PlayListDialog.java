package com.qinshou.qinshoubox.me.ui.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.qinshou.commonmodule.base.AbsDialogFragment;
import com.qinshou.qinshoubox.R;
import com.qinshou.qinshoubox.me.bean.MediaSourceBean;
import com.qinshou.qinshoubox.me.ui.adapter.RcvPlayListAdapter;

import java.util.ArrayList;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2020/4/9 16:26
 * Description:播放列表对话框
 */
public class PlayListDialog extends AbsDialogFragment {
    private static final String MEDIA_SOURCE_BEAN_LIST = "MediaSourceBeanList";
    private RcvPlayListAdapter mRcvPlayListAdapter;

    @Override
    public boolean isImmersive() {
        return true;
    }

    @Override
    public int initLayoutId() {
        return R.layout.dialog_play_list;
    }

    @Override
    public void initView() {
        RecyclerView rcvPlayList = findViewByID(R.id.rcv_play_list);
        rcvPlayList.setLayoutManager(new LinearLayoutManager(getContext()));
        rcvPlayList.setAdapter(mRcvPlayListAdapter = new RcvPlayListAdapter(getContext()));
    }

    @Override
    public void setListener() {

    }

    @Override
    public void initData() {
        Bundle bundle = getArguments();
        if (bundle == null) {
            return;
        }
        ArrayList<MediaSourceBean> mediaSourceBeanList = bundle.getParcelableArrayList(MEDIA_SOURCE_BEAN_LIST);
        mRcvPlayListAdapter.setDataList(mediaSourceBeanList);
    }

    @Override
    public Dialog customDialog(Dialog dialog) {
        Window window = dialog.getWindow();
        if (window != null) {
            //底部对话框
            window.setGravity(Gravity.RIGHT);
            window.setLayout(getResources().getDisplayMetrics().widthPixels / 3, WindowManager.LayoutParams.MATCH_PARENT);
            window.setWindowAnimations(R.style.PlayListDialogAnimation);
        }
        return dialog;
    }

    public static PlayListDialog newInstance(ArrayList<MediaSourceBean> mediaSourceBeanList) {

        Bundle args = new Bundle();
        args.putParcelableArrayList(MEDIA_SOURCE_BEAN_LIST, mediaSourceBeanList);

        PlayListDialog fragment = new PlayListDialog();
        fragment.setArguments(args);
        return fragment;
    }
//
//    /**
//     * Description:使 Activity 根布局变暗
//     * Date:2018/6/21
//     */
//    public static void setActivityAlpha(Activity activity, float alpha) {
//        WindowManager.LayoutParams lp = activity.getWindow().getAttributes();
//        lp.alpha = alpha;
//        if (alpha == 1) {
//            activity.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
//        } else {
//            activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
//        }
//        activity.getWindow().setAttributes(lp);
//    }
}
