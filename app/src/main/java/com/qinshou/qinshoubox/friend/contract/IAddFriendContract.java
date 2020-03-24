package com.qinshou.qinshoubox.friend.contract;


import com.qinshou.commonmodule.base.IBaseModel;
import com.qinshou.commonmodule.base.IBaseView;
import com.qinshou.okhttphelper.callback.Callback;
import com.qinshou.qinshoubox.im.bean.UserDetailBean;
import com.qinshou.qinshoubox.friend.view.fragment.AddFriendFragment;
import com.qinshou.qinshoubox.im.listener.QSCallback;

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
         * @param keyword    系统账号/手机号/邮箱
         * @param qsCallback 回调接口
         */
        void getUserDetail(String keyword, QSCallback<UserDetailBean> qsCallback);
    }

    interface IView extends IBaseView {
        /**
         * Author: QinHao
         * Email:qinhao@jeejio.com
         * Date:2019/9/6 9:34
         * Description:获取用户信息成功
         *
         * @param userDetailBean 用户信息实体类
         */
        void getUserDetailSuccess(UserDetailBean userDetailBean);

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
         * @param keyword 系统账号/手机号/邮箱
         */
        void getUserDetail(String keyword);
    }
}