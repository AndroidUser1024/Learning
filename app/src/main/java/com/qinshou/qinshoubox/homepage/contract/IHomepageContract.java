package com.qinshou.qinshoubox.homepage.contract;

import com.qinshou.commonmodule.base.IBaseContract;
import com.qinshou.commonmodule.base.IBaseModel;
import com.qinshou.commonmodule.base.IBaseView;
import com.qinshou.okhttphelper.callback.Callback;
import com.qinshou.qinshoubox.homepage.bean.WallpaperBean;
import com.qinshou.qinshoubox.homepage.ui.fragment.HomepageFragment;

import java.util.List;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/10/16 17:17
 * Description:{@link HomepageFragment} 的契约类
 */
public interface IHomepageContract extends IBaseContract {
    interface IModel extends IBaseModel {
        /**
         * Author: QinHao
         * Email:cqflqinhao@126.com
         * Date:2019/10/16 17:24
         * Description:获取壁纸列表
         *
         * @param callback 回调接口
         */
        void getWallpaperList(Callback<List<WallpaperBean>> callback);
    }

    interface IView extends IBaseView {

        /**
         * Author: QinHao
         * Email:cqflqinhao@126.com
         * Date:2019/10/16 17:24
         * Description:获取壁纸列表成功
         *
         * @param wallpaperBeanList 壁纸列表
         */
        void getWallpaperListSuccess(List<WallpaperBean> wallpaperBeanList);

        /**
         * Author: QinHao
         * Email:cqflqinhao@126.com
         * Date:2019/10/16 17:24
         * Description:获取壁纸列表失败
         *
         * @param e 错误信息
         */
        void getWallpaperListFailure(Exception e);
    }

    interface IPresenter {
        /**
         * Author: QinHao
         * Email:cqflqinhao@126.com
         * Date:2019/10/16 17:25
         * Description:获取壁纸列表
         */
        void getWallpaperList();
    }
}
