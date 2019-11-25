package com.qinshou.qinshoubox.music.presenter;

import com.qinshou.commonmodule.base.AbsPresenter;
import com.qinshou.qinshoubox.music.contract.IMusicPlayContract;
import com.qinshou.qinshoubox.music.model.MusicPlayModel;
import com.qinshou.qinshoubox.music.view.fragment.MusicPlayFragment;

/**
 * Description:{@link MusicPlayFragment} 的 Presenter
 * Author: QinHao
 * Date: 2019/4/4 17:42
 */
public class MusicPlayPresenter extends AbsPresenter<IMusicPlayContract.IMusicPlayView, IMusicPlayContract.IMusicPlayModel> implements IMusicPlayContract.IMusicPlayPresenter {
    @Override
    public IMusicPlayContract.IMusicPlayModel initModel() {
        return new MusicPlayModel();
    }

}
