package com.qinshou.qinshoubox.friend.contract;


import com.qinshou.commonmodule.base.IBaseModel;
import com.qinshou.commonmodule.base.IBaseView;
import com.qinshou.okhttphelper.callback.Callback;
import com.qinshou.qinshoubox.friend.view.fragment.AddFriendFragment;
import com.qinshou.qinshoubox.login.bean.UserBean;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/08/21 14:25
 * Description:{@link AddFriendFragment} 的契约类
 */
public interface IAddFriendContract {
    interface IModel extends IBaseModel {
        /**
         * Author: QinHao
         * Email:qinhao@jeejio.com
         * Date:2019/9/6 9:34
         * Description:获取用户信息
         *
         * @param userId   用户 id
         * @param keyword  系统账号/手机号/邮箱
         * @param callback 回调接口
         */
        void getUserDetail(String userId, String keyword, Callback<UserBean> callback);
    }

    interface IView extends IBaseView {
        /**
         * Author: QinHao
         * Email:qinhao@jeejio.com
         * Date:2019/9/6 9:34
         * Description:获取用户信息成功
         *
         * @param userBean 用户信息实体类
         */
        void getUserDetailSuccess(UserBean userBean);

        /**
         * Author: QinHao
         * Email:qinhao@jeejio.com
         * Date:2019/9/6 9:35
         * Description:获取用户信息失败
         *
         * @param e 错误信息
         */
        void getUserDetailFailure(Exception e);
    }

    interface IPresenter {
        /**
         * Author: QinHao
         * Email:qinhao@jeejio.com
         * Date:2019/9/6 9:34
         * Description:获取用户信息
         *
         * @param userId  用户 id
         * @param keyword 系统账号/手机号/邮箱
         */
        void getUserDetail(String userId, String keyword);
    }
}