package com.qinshou.qinshoubox.music.presenter;

import android.content.Context;

import com.qinshou.networkmodule.callback.Callback;
import com.qinshou.commonmodule.base.AbsPresenter;
import com.qinshou.qinshoubox.music.bean.MusicBean;
import com.qinshou.qinshoubox.music.contract.IMusicListContract;
import com.qinshou.qinshoubox.music.model.MusicListModel;
import com.qinshou.qinshoubox.music.view.fragment.MusicListFragment;

import java.util.List;


/**
 * Description:{@link MusicListFragment} 的 Presenter
 * Author: QinHao
 * Date: 2019/4/4 17:42
 */
public class MusicListPresenter extends AbsPresenter<IMusicListContract.IMusicListView, IMusicListContract.IMusicListModel> implements IMusicListContract.IMusicListPresenter {
    @Override
    public IMusicListContract.IMusicListModel initModel() {
        return new MusicListModel();
    }

    @Override
    public void getMusicList(Context context) {
        getModel().getMusicList(context, new Callback<List<MusicBean>>() {
            @Override
            public void onSuccess(List<MusicBean> data) {
                if (!isViewAttached()) {
                    return;
                }
                getView().setMusicList(data);
            }

            @Override
            public void onFailure(Exception e) {
                if (!isViewAttached()) {
                    return;
                }
                getView().queryMusicListFailure(e.getMessage());
            }
        });
    }
}
