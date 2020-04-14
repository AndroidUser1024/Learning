package com.qinshou.qinshoubox.music.contract;

import android.content.Context;

import com.jeejio.networkmodule.callback.Callback;
import com.qinshou.commonmodule.base.IBaseContract;
import com.qinshou.commonmodule.base.IBaseModel;
import com.qinshou.commonmodule.base.IBaseView;
import com.qinshou.qinshoubox.music.bean.MusicBean;
import com.qinshou.qinshoubox.music.view.fragment.MusicListFragment;

import java.util.List;

/**
 * Description:{@link MusicListFragment} 的契约类
 * Author: QinHao
 * Date: 2019/4/4 17:39
 */
public interface IMusicListContract extends IBaseContract {
    interface IMusicListModel extends IBaseModel {
        void getMusicList(Context context, Callback<List<MusicBean>> callback);

        void getMusicList(Context context, int page, int pageSize, Callback<List<MusicBean>> callback);
    }

    interface IMusicListView extends IBaseView {
        void setMusicList(List<MusicBean> musicList);

        void queryMusicListFailure(String failureInfo);
    }

    interface IMusicListPresenter {
        void getMusicList(Context context);
    }
}
