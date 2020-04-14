package com.qinshou.qinshoubox.me.contract;

import com.jeejio.networkmodule.callback.Callback;
import com.qinshou.commonmodule.base.IBaseContract;
import com.qinshou.commonmodule.base.IBaseModel;
import com.qinshou.commonmodule.base.IBaseView;
import com.qinshou.qinshoubox.me.bean.MediaSourceBean;
import com.qinshou.qinshoubox.me.ui.fragment.VideoPlayerActivity;

import java.util.List;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 20-2-3 上午9:38
 * Description:{@link VideoPlayerActivity} 的契约类
 */
public interface IVideoPlayerContract extends IBaseContract {
    interface IModel extends IBaseModel {
        /**
         * Author: QinHao
         * Email:cqflqinhao@126.com
         * Date:2020/4/9 18:21
         * Description:获取 Hls 播放列表
         */
        void getHlsPlayList(Callback<List<MediaSourceBean>> callback);
    }

    interface IView extends IBaseView {
        /**
         * Author: QinHao
         * Email:cqflqinhao@126.com
         * Date:2020/4/9 18:21
         * Description:获取 Hls 播放列表成功
         */
        void getHlsPlayListSuccess(List<MediaSourceBean> mediaSourceBeanList);

        /**
         * Author: QinHao
         * Email:cqflqinhao@126.com
         * Date:2020/4/9 18:21
         * Description:获取 Hls 播放列表失败
         */
        void getHlsPlayListFailure(Exception e);
    }

    interface IPresenter {
        /**
         * Author: QinHao
         * Email:cqflqinhao@126.com
         * Date:2020/4/9 18:21
         * Description:获取 Hls 播放列表
         */
        void getHlsPlayList();
    }
}
