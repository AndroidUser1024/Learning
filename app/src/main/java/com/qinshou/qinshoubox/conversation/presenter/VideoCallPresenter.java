package com.qinshou.qinshoubox.conversation.presenter;

import com.qinshou.commonmodule.base.AbsPresenter;
import com.qinshou.qinshoubox.conversation.contract.IVideoCallContract;
import com.qinshou.qinshoubox.conversation.model.VideoCallModel;
import com.qinshou.qinshoubox.conversation.view.activity.VideoCallFragment;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2020/5/9 16:13
 * Description:{@link VideoCallFragment} 的 P 层
 */
public class VideoCallPresenter extends AbsPresenter<IVideoCallContract.IView, IVideoCallContract.IModel> implements IVideoCallContract.IPresenter {

    @Override
    public IVideoCallContract.IModel initModel() {
        return new VideoCallModel();
    }
}
