package com.qinshou.qinshoubox.me.contract;

import com.jeejio.networkmodule.callback.Callback;
import com.qinshou.commonmodule.base.IBaseModel;
import com.qinshou.commonmodule.base.IBaseView;
import com.qinshou.qinshoubox.login.bean.UserBean;
import com.qinshou.qinshoubox.me.ui.fragment.SetNameFragment;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/11/13 14:36
 * Description:{@link SetNameFragment} 的契约类
 */
public interface ISetNameContract {
    interface IModel extends IBaseModel {
        /**
         * Author: QinHao
         * Email:qinhao@jeejio.com
         * Date:2019/11/13 15:36
         * Description:设置昵称
         *
         * @param userId   用户 id
         * @param nickname 新昵称
         * @param callback 回调接口
         */
        void setUserInfo(String userId, String nickname, Callback<UserBean> callback);
    }

    interface IView extends IBaseView {
        /**
         * Author: QinHao
         * Email:qinhao@jeejio.com
         * Date:2019/11/13 15:38
         * Description:设置昵称成功
         *
         * @param userBean 新的用户信息
         */
        void setUserInfoSuccess(UserBean userBean);

        /**
         * Author: QinHao
         * Email:qinhao@jeejio.com
         * Date:2019/11/13 15:38
         * Description:设置昵称失败
         *
         * @param e 错误信息
         */
        void setUserInfoFailure(Exception e);
    }

    interface IPresenter {
        /**
         * Author: QinHao
         * Email:qinhao@jeejio.com
         * Date:2019/11/13 15:37
         * Description:设置昵称
         *
         * @param userId   用户 id
         * @param nickname 新昵称
         */
        void setUserInfo(String userId, String nickname);
    }
}