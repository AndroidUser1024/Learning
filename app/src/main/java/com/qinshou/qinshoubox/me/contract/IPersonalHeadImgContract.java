package com.qinshou.qinshoubox.me.contract;


import com.qinshou.commonmodule.base.IBaseModel;
import com.qinshou.commonmodule.base.IBaseView;
import com.qinshou.okhttphelper.callback.Callback;
import com.qinshou.immodule.bean.UserBean;
import com.qinshou.qinshoubox.me.ui.fragment.PersonalHeadImgFragment;

import java.io.File;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/11/13 16:40
 * Description:{@link PersonalHeadImgFragment} 的契约类
 */
public interface IPersonalHeadImgContract {
    interface IModel extends IBaseModel {
        /**
         * Author: QinHao
         * Email:qinhao@jeejio.com
         * Date:2019/11/18 16:05
         * Description:设置头像
         *
         * @param userId       用户 id
         * @param file     头像文件
         * @param callback 回调接口
         */
        void setHeadImg(int userId, File file, Callback<UserBean> callback);
    }

    interface IView extends IBaseView {
        /**
         * Author: QinHao
         * Email:qinhao@jeejio.com
         * Date:2019/11/18 16:05
         * Description:设置头像成功
         *
         * @param userBean 用户信息
         */
        void setHeadImgSuccess(UserBean userBean);

        /**
         * Author: QinHao
         * Email:qinhao@jeejio.com
         * Date:2019/11/18 16:05
         * Description:设置头像失败
         *
         * @param e 错误信息
         */
        void setHeadImgFailure(Exception e);
    }

    interface IPresenter {
        /**
         * Author: QinHao
         * Email:qinhao@jeejio.com
         * Date:2019/11/18 16:06
         * Description:设置头像
         *
         * @param userId   用户 id
         * @param file 头像文件
         */
        void setHeadImg(int userId, File file);
    }
}