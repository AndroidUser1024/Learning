package com.qinshou.qinshoubox.me.presenter;

import com.qinshou.commonmodule.base.AbsPresenter;
import com.qinshou.qinshoubox.me.contract.IVideoPlayerContract;
import com.qinshou.qinshoubox.me.model.VideoPlayerModel;
import com.qinshou.qinshoubox.me.ui.fragment.VideoPlayerActivity;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 20-2-3 上午9:41
 * Description:{@link VideoPlayerActivity} 的 P 层
 */
public class VideoPlayerPresenter extends AbsPresenter<IVideoPlayerContract.IView, IVideoPlayerContract.IModel> implements IVideoPlayerContract.IPresenter {
    @Override
    public IVideoPlayerContract.IModel initModel() {
        return new VideoPlayerModel();
    }
}