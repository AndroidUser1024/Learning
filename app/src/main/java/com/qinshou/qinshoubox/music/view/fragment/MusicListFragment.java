package com.qinshou.qinshoubox.music.view.fragment;

import android.Manifest;
import android.graphics.Color;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.qinshou.commonmodule.base.AbsMVPFragment;
import com.qinshou.commonmodule.rcvdecoration.DividerDecoration;
import com.qinshou.commonmodule.util.DisplayUtil;
import com.qinshou.commonmodule.util.permissionutil.IOnRequestPermissionResultCallBack;
import com.qinshou.commonmodule.util.permissionutil.PermissionUtil;
import com.qinshou.qinshoubox.R;
import com.qinshou.qinshoubox.base.QSFragment;
import com.qinshou.qinshoubox.homepage.bean.EventBean;
import com.qinshou.qinshoubox.music.bean.MusicBean;
import com.qinshou.qinshoubox.music.contract.IMusicListContract;
import com.qinshou.qinshoubox.music.presenter.MusicListPresenter;
import com.qinshou.qinshoubox.music.view.adapter.RcvMusicAdapter;
import com.scwang.smartrefresh.layout.util.DensityUtil;

import java.util.List;

/**
 * Description:音乐列表界面
 * Author: QinHao
 * Date: 2019/3/26 19:43
 */
public class MusicListFragment extends QSFragment<MusicListPresenter> implements IMusicListContract.IMusicListView {
    private RcvMusicAdapter mRcvMusicAdapter;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_music_list;
    }

    @Override
    public void initView() {
        RecyclerView rcvMusic = findViewByID(R.id.rcv_music);
        //设置 RecyclerView 布局管理器
        rcvMusic.setLayoutManager(new LinearLayoutManager(getContext()));
        //设置 RecyclerView 适配器
        mRcvMusicAdapter = new RcvMusicAdapter(getContext());
        rcvMusic.setAdapter(mRcvMusicAdapter);
        //设置 RecyclerView ItemDecoration
        DividerDecoration dividerDecoration = new DividerDecoration(DividerDecoration.Orientation.VERTICAL, 1, Color.parseColor("#FF999999"));
        dividerDecoration.setMargin(DisplayUtil.dp2px(getContext(), 50), 0, 0, 0);
        rcvMusic.addItemDecoration(dividerDecoration);
    }

    @Override
    public void setListener() {

    }

    @Override
    public void initData() {
        PermissionUtil.requestPermission(getChildFragmentManager(), new IOnRequestPermissionResultCallBack() {
            @Override
            public void onSuccess() {
                getPresenter().getMusicList(getContext());
            }

            @Override
            public void onFailure(List<String> deniedPermissionList) {

            }
        }, Manifest.permission.READ_EXTERNAL_STORAGE);
    }

    @Override
    public void handleEvent(EventBean<Object> eventBean) {
    }

    @Override
    public void setMusicList(List<MusicBean> musicList) {
        mRcvMusicAdapter.setDataList(musicList);
    }

    @Override
    public void queryMusicListFailure(String failureInfo) {

    }
}
